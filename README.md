# SarSymbol Library
![SarSymbol Image](sar2.png)

`SarSymbol` is a custom `TextView` for Android that replaces currency symbols like "SAR" or "ر.س" with an image (`Drawable`). The library scales the image based on the text size and allows customizable currency symbols.

## ✨ Features

- Replaces currency symbols (e.g., "SAR", "ر.س") with an image (`Drawable`).
- Customizable left and right currency symbols.
- Automatically scales the drawable to match the text size.
- Simple integration into your Android project.

## 📦 Installation

### 1️⃣ Add the Dependency

Add the dependency to your project-level `build.gradle` file:

```gradle
dependencies {
    implementation 'com.sultani:sar:1.0.0'  // Replace with the latest version
}
```

### 2️⃣ Sync the Project

Sync your project with Gradle to download the library.

## 🚀 Usage

### 1️⃣ Add `SarSymbol` to Your Layout

To use `SarSymbol`, add it to your XML layout:

```xml
<com.sultani.sar.SarSymbol
    android:id="@+id/sarSymbolText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="100 SAR"
    android:textSize="16sp"
    android:textColor="@android:color/black" />
```

### 2️⃣ Customize Currency Symbols

By default, `SarSymbol` uses "ر.س" for the left symbol and "SAR" for the right symbol. You can customize these symbols:

#### Kotlin Example:
```kotlin
val sarSymbolText = findViewById<SarSymbol>(R.id.sarSymbolText)
sarSymbolText.setText("100 USD")  // The default SAR symbol will be used
```

For custom left and right symbols:

```kotlin
val sarSymbolText = SarSymbol(
    context,
    currentCurrency = "USD",  // Set the currency
    leftSymbol = "$",  // Custom left symbol
    rightSymbol = "USD"  // Custom right symbol
)
sarSymbolText.setText("100 USD")
```

#### Java Example:
```java
SarSymbol sarSymbolText = findViewById(R.id.sarSymbolText);
sarSymbolText.setText("100 USD");  // The default SAR symbol will be used
```

For custom left and right symbols:

```java
SarSymbol sarSymbolText = new SarSymbol(
    context,
    "USD",  // Set the currency
    "$",  // Custom left symbol
    "USD"  // Custom right symbol
);
sarSymbolText.setText("100 USD");
```

## ⚙️ How It Works

- The `SarSymbol` widget automatically detects currency symbols within the provided text.
- It replaces these symbols with a drawable image (`sar drawable resource`).
- The drawable scales to match the text size, ensuring a clean and visually appealing result.

## 🔧 Customization Options

| Parameter       | Description                                          | Default |
|---------------|--------------------------------------------------|---------|
| `currentCurrency` | The currency symbol to display (e.g., "USD", "SAR"). | "SAR"   |
| `leftSymbol`    | The symbol to display on the left (e.g., "$", "ر.س"). | "ر.س"   |
| `rightSymbol`   | The symbol to display on the right (e.g., "USD", "SAR"). | "SAR"   |

## 📌 Example Output

**Before Replacement:**
```
100 SAR
```

**After Replacement:**
```
The "SAR" symbol is replaced with an image, scaled based on text size.
```

## 📜 License

This library is open-source. Feel free to contribute and improve it!

