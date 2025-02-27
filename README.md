# SarSymbol Library

![SarSymbol Logo](https://via.placeholder.com/150) <!-- Replace this link with your logo if available -->

SarSymbol is an Android library designed to display currency symbols (such as the Saudi Riyal "ر.س" or "SAR") as graphical symbols (Drawable) within text. The library supports customizing left and right currency symbols and automatically applies colors based on the text color.

## Features

- Display currency symbols as graphical symbols within text.
- Customize left and right currency symbols.
- Automatically apply symbol colors based on the text color.
- Easy integration with existing Android projects.

## Installation

### Via Gradle

Add the following dependency to your project's `build.gradle` file:


### Installation
1. Add the dependency
Add the following to your build.gradle file (Module level):
```
dependencies {
    implementation 'com.sultani:sar:1.0.0'  // Use the latest version
}
```
2. Sync your project
After adding the dependency, sync your project with Gradle to download the library.

### Usage
1. Add SarSymbol to your layout
You can add SarSymbol directly to your XML layout:

````
<com.sultani.sar.SarSymbol
    android:id="@+id/sarSymbolText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="100 SAR"
    android:textSize="16sp"
    android:textColor="@android:color/black" />
````

android:text: The text to display, which can include the currency symbol (e.g., "100 SAR" or "100 ر.س").
android:textSize: The size of the text.
android:textColor: The color of the text.
2. Customize currency symbols programmatically
The default symbols are "ر.س" for the left and "SAR" for the right. You can customize these symbols by setting them programmatically:

```
val sarSymbolText = findViewById<SarSymbol>(R.id.sarSymbolText)
sarSymbolText.setText("100 USD")  // Default symbols will be used (SAR)
```
To specify custom symbols for both sides:

```
val sarSymbolText = SarSymbol(
    context,
    currentCurrency = "USD",
    leftSymbol = "$",
    rightSymbol = "USD"
)
sarSymbolText.setText("100 USD")
```
#### 3. How it works
SarSymbol detects the currency symbol (left or right) in the provided text.
It replaces the symbol with a drawable image (sar drawable resource).
The image scales to match the text size automatically.
Customization
You can customize the SarSymbol widget using the following parameters:

currentCurrency: The currency to display (e.g., "USD", "SAR", etc.). Default is "SAR".
leftSymbol: The symbol to display on the left of the amount (e.g., "$", "ر.س"). Default is "ر.س".
rightSymbol: The symbol to display on the right of the amount (e.g., "USD", "SAR"). Default is "SAR".
