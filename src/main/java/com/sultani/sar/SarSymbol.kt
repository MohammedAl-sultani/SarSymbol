package com.sultani.sar

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat

class SarSymbol @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    private val currentCurrency: String = "SAR", // Default currency
    private val leftSymbol: String = "ر.س", // Default left symbol
    private val rightSymbol: String = "SAR" // Default right symbol
) : AppCompatTextView(context, attrs, defStyleAttr) {

    // الرسم (Drawable) الذي سيتم استخدامه كرمز للعملة
    private val sarDrawable: Drawable? by lazy {
        ResourcesCompat.getDrawable(context.resources, R.drawable.sar, null)?.apply {
            val textSize = textSize
            val scale = textSize / intrinsicHeight
            val width = (intrinsicWidth * scale).toInt()
            val height = (intrinsicHeight * scale).toInt()
            setBounds(0, 0, width, height)

            // تطبيق tint على الـ Drawable بلون النص الحالي
            DrawableCompat.setTint(this, currentTextColor)
            DrawableCompat.setTintMode(this, PorterDuff.Mode.SRC_IN)
        }
    }

    init {
        // تحديث النص تلقائيًا عند التهيئة
        if (!isInEditMode) {
            updateText()
        }
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        // تنسيق النص وعرضه مع الرسم
        val formattedText = if (!text.isNullOrEmpty()) {
            if (currentCurrency.equals("sar", ignoreCase = true)) {
                replaceCurrencySymbolsWithDrawable(text.toString())
            } else {
                SpannableString(text)
            }
        } else {
            SpannableString("")
        }
        super.setText(formattedText, type)
    }

    private fun replaceCurrencySymbolsWithDrawable(text: String): SpannableString {
        val spannableStringBuilder = SpannableStringBuilder(text)
        val symbols = listOf(leftSymbol, rightSymbol) // Use the provided left and right symbols

        symbols.forEach { symbol ->
            var startIndex = text.indexOf(symbol, ignoreCase = true)
            while (startIndex != -1) {
                // استبدال النص بالرسم
                spannableStringBuilder.replace(startIndex, startIndex + symbol.length, " ") // استبدال النص بمسافة
                sarDrawable?.let { drawable ->
                    val imageSpan = ImageSpan(drawable, ImageSpan.ALIGN_BASELINE)
                    spannableStringBuilder.setSpan(
                        imageSpan,
                        startIndex,
                        startIndex + 1, // لأننا استبدلنا النص بمسافة واحدة
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
                startIndex = text.indexOf(symbol, startIndex + symbol.length, ignoreCase = true)
            }
        }

        return SpannableString(spannableStringBuilder)
    }

    // دالة لتحديث النص تلقائيًا
    private fun updateText() {
        val currentText = text?.toString() ?: ""
        text = currentText
    }
}