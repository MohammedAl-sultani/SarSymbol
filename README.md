# SarSymbol Library


`SarSymbol` is a custom `TextView` in Android that allows you to replace currency symbols like "SAR" or "ر.س" with an image (`Drawable`). This library scales the image based on the text size and supports customizable currency symbols for your convenience.

## Features

- Replaces currency symbols (e.g., "SAR", "ر.س") with an image (`Drawable`).
- Customizable left and right currency symbols.
- Automatically scales the drawable to match the text size.
- Simple to integrate into your Android project.

## Installation

### 1. Add the Dependency

In your project-level `build.gradle` file, add the following dependency:

```gradle
dependencies {
    implementation 'com.sultani:sar:1.0.0'  // Replace with the latest version
}
```
2. Sync the Project
Sync your project with Gradle to download the library.

#### Usage
1. Add SarSymbol to Your Layout
To use SarSymbol, simply add it to your layout XML file:

````
<com.sultani.sar.SarSymbol
    android:id="@+id/sarSymbolText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="100 SAR"
    android:textSize="16sp"
    android:textColor="@android:color/black" />
````
android:text: Text to display, including currency symbols (e.g., "100 SAR" or "100 ر.س").
android:textSize: Size of the text.
android:textColor: Color of the text.

2. Customize Currency Symbols
By default, SarSymbol uses "ر.س" for the left symbol and "SAR" for the right symbol. You can customize these symbols when needed:

````
val sarSymbolText = findViewById<SarSymbol>(R.id.sarSymbolText)
sarSymbolText.setText("100 USD")  // The default SAR symbol will be used
````
For custom left and right symbols:
````
val sarSymbolText = SarSymbol(
    context,
    currentCurrency = "USD",  // Set the currency
    leftSymbol = "$",  // Custom left symbol
    rightSymbol = "USD"  // Custom right symbol
)
sarSymbolText.setText("100 USD")
````
#### How It Works
The SarSymbol widget automatically detects currency symbols within the provided text.
It replaces these symbols with a drawable image (sar drawable resource).
The drawable scales to match the text size, providing a clean and visually appealing result.
Customization
You can customize the behavior of SarSymbol by passing the following parameters:

currentCurrency: The currency symbol to display (e.g., "USD", "SAR", etc.). Default is "SAR".
leftSymbol: The symbol to display on the left (e.g., "$", "ر.س"). Default is "ر.س".
rightSymbol: The symbol to display on the right (e.g., "USD", "SAR"). Default is "SAR".
Example
Before Replacement:
Plain text with a currency symbol:


100 SAR
After Replacement:
The text will be replaced with an image:


The "SAR" symbol will now be an image, scaled based on the text size.

