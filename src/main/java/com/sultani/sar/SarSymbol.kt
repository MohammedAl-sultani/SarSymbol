package com.sultani.sar

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.sultani.sar.R
import com.sultani.sar.utils.AppSharedPreference

class SarTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    // Drawable for the currency symbol
    private var sarDrawable: Drawable? = null

    // Cache for the last processed text to avoid redundant operations
    private var lastProcessedText: CharSequence? = null

    init {
        if (!isInEditMode) {
            initializeDrawable()
        }
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        if (text == lastProcessedText) return // Skip if text hasn't changed

        val processedText = processText(text)
        lastProcessedText = processedText
        super.setText(processedText, type)
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
        updateDrawableTint()
        updateText()
    }

    override fun setTextSize(unit: Int, size: Float) {
        super.setTextSize(unit, size)
        initializeDrawable()
        updateText()
    }

    /**
     * Processes the input text to replace currency symbols with a drawable.
     */
    private fun processText(text: CharSequence?): CharSequence {
        return try {
            if (text.isNullOrEmpty()) {
                return SpannableString("")
            }

            val currency = AppSharedPreference.getCurrencyCode(context, "")
            if (currency.isNullOrEmpty() || currency.equals("sar", ignoreCase = true)) {
                replaceCurrencySymbolsWithDrawable(text.toString())
            } else {
                SpannableString(text)
            }
        } catch (e: Exception) {
            Log.e("SarTextView", "Error processing text: ${e.message}")
            SpannableString(text ?: "") // Fallback to original text
        }
    }

    /**
     * Replaces currency symbols in the text with a drawable.
     */
    private fun replaceCurrencySymbolsWithDrawable(text: String): SpannableString {
        return try {
            val spannableStringBuilder = SpannableStringBuilder(text)
            val symbols = listOfNotNull(
                AppSharedPreference.getCurrencyRightSymbol(context),
                AppSharedPreference.getCurrencyLeftSymbol(context)
            )

            symbols.forEach { symbol ->
                var startIndex = text.indexOf(symbol, ignoreCase = true)
                var loopCounter = 0 // Safeguard against infinite loops

                while (startIndex != -1 && loopCounter < 100) {
                    try {
                        // Replace the symbol with a zero-width space and an ImageSpan
                        spannableStringBuilder.replace(startIndex, startIndex + symbol.length, " \u200B \u200B ")
                        sarDrawable?.let { drawable ->
                            val imageSpan = ImageSpan(drawable, ImageSpan.ALIGN_BASELINE)
                            spannableStringBuilder.setSpan(
                                imageSpan,
                                startIndex + 1,
                                startIndex + 2,
                                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                        }
                    } catch (e: Exception) {
                        Log.e("SarTextView", "Error replacing symbol: ${e.message}")
                    }
                    startIndex = text.indexOf(symbol, startIndex + symbol.length, ignoreCase = true)
                    loopCounter++
                }
            }

            SpannableString(spannableStringBuilder)
        } catch (e: Exception) {
            Log.e("SarTextView", "Error in replaceCurrencySymbolsWithDrawable: ${e.message}")
            SpannableString(text) // Fallback to original text
        }
    }

    /**
     * Initializes the drawable used for the currency symbol.
     */
    private fun initializeDrawable() {
        try {
            sarDrawable = ResourcesCompat.getDrawable(context.resources, R.drawable.sar, null)?.apply {
                val textSize = textSize
                val scale = textSize / intrinsicHeight
                val width = (intrinsicWidth * scale).toInt()
                val height = (intrinsicHeight * scale).toInt()
                setBounds(0, 0, width, height)
                updateDrawableTint()
            }
        } catch (e: Exception) {
            Log.e("SarTextView", "Error initializing drawable: ${e.message}")
            sarDrawable = null // Fallback to no drawable
        }
    }

    /**
     * Updates the tint of the drawable to match the text color.
     */
    private fun updateDrawableTint() {
        sarDrawable?.let { drawable ->
            DrawableCompat.setTint(drawable, currentTextColor)
            DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
        }
    }

    /**
     * Updates the text with the current drawable.
     */
    private fun updateText() {
        val currentText = text?.toString() ?: ""
        text = currentText
    }
}
