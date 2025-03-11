# SarSymbol Library

![SarSymbol Image](sar2.png)

`SarSymbol` is a custom `TextView` for Android that replaces currency symbols like "SAR" or "ر.س" with an image (`Drawable`). The image scales automatically to match the text size, and custom currency symbols can be set easily.

## ✨ Features

- Replaces currency symbols (e.g., "SAR", "ر.س") with an image (`Drawable`).
- Supports customizable left and right currency symbols.
- Automatically scales the drawable to match the text size.
- Easy integration into Android projects.

## 📦 Installation

### 1️⃣ Add the JitPack Repository

First, add the JitPack repository to your project's `settings.gradle` file:

```groovy
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // Add this line
    }
}
```

### 2️⃣ Add the Dependency

Add the dependency to your project-level `build.gradle` file:

```gradle
dependencies {
    implementation 'com.github.MohammedAl-sultani:SarSymbol:1.0.0' // Replace with the latest version
}
```

### 3️⃣ Sync the Project

Sync your project with Gradle to download the library.

## 🚀 Usage

### 1️⃣ Add `SarSymbol` to Your Layout (XML)

To use `SarSymbol`, add it to your XML layout:

```xml
<com.sultani.sar.SarTextView
    android:id="@+id/sarSymbolText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="100 SAR"
    android:textSize="16sp"
    android:textColor="@android:color/black" />
```

### 2️⃣ Customize Currency Symbols

By default, `SarSymbol` uses "ر.س" for the left symbol and "SAR" for the right symbol. You can customize these values easily:

#### Kotlin Example:
```kotlin
val sarSymbolText = findViewById<SarTextView>(R.id.sarSymbolText)
sarSymbolText.text = "100 USD"  // The default SAR symbol will be used
```

To customize the symbols:
```kotlin
val sarSymbolText = SarTextView(context).apply {
    currency = "USD"  // Set the currency
    leftCurrency = "$"  // Custom left symbol
    rightCurrency = "USD"  // Custom right symbol
}
sarSymbolText.text = "100 USD"
```

#### Java Example:
```java
SarTextView sarSymbolText = findViewById(R.id.sarSymbolText);
sarSymbolText.setText("100 USD");  // The default SAR symbol will be used
```

To customize the symbols:
```java
SarTextView sarSymbolText = new SarTextView(context);
sarSymbolText.setCurrency("USD");  // Set the currency
sarSymbolText.setLeftCurrency("$");  // Custom left symbol
sarSymbolText.setRightCurrency("USD");  // Custom right symbol
sarSymbolText.setText("100 USD");
```

## ⚙️ How It Works

- The `SarTextView` widget automatically detects currency symbols within the provided text.
- It replaces these symbols with a predefined drawable image (`sar drawable resource`).
- The drawable scales automatically to match the text size, ensuring a clean and visually appealing result.

## 🔧 Customization Options

| Parameter       | Description                                          | Default |
|---------------|--------------------------------------------------|---------|
| `currency`    | The currency symbol to display (e.g., "USD", "SAR"). | "SAR"   |
| `leftCurrency` | The symbol displayed on the left (e.g., "$", "ر.س"). | "ر.س"   |
| `rightCurrency`| The symbol displayed on the right (e.g., "USD", "SAR"). | "SAR"   |

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

---

# مكتبة SarSymbol

![SarSymbol Image](sar2.png)

`SarSymbol` هو مكون مخصص (`TextView`) لنظام أندرويد يقوم باستبدال رموز العملات مثل "SAR" أو "ر.س" بصورة (`Drawable`). يتم ضبط حجم الصورة تلقائيًا لتتناسب مع حجم النص، كما يمكن تخصيص رموز العملات المستخدمة بسهولة.

## ✨ المميزات

- استبدال رموز العملات (مثل "SAR"، "ر.س") بصورة (`Drawable`).
- دعم رموز عملات مخصصة لكل من الجهة اليسرى واليمنى.
- ضبط تلقائي لحجم الصورة لتتناسب مع حجم النص.
- تكامل سهل في مشاريع الأندرويد.

## 📦 التثبيت

### 1️⃣ إضافة مستودع JitPack

أضف مستودع JitPack إلى ملف `settings.gradle` الخاص بالمشروع:

```groovy
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // أضف هذا السطر
    }
}
```

### 2️⃣ إضافة التبعية

أضف التبعية إلى ملف `build.gradle` الخاص بالمشروع:

```gradle
dependencies {
    implementation 'com.github.MohammedAl-sultani:SarSymbol:1.0.0' // Replace with the latest version
}
```

### 3️⃣ مزامنة المشروع

قم بمزامنة المشروع مع Gradle لتحميل المكتبة.

## 🚀 طريقة الاستخدام

### 1️⃣ إضافة `SarSymbol` إلى التخطيط (XML)

لاستخدام `SarSymbol`، قم بإضافته إلى ملف تخطيط XML:

```xml
<com.sultani.sar.SarTextView
    android:id="@+id/sarSymbolText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="100 SAR"
    android:textSize="16sp"
    android:textColor="@android:color/black" />
```

## 📜 الرخصة

هذه المكتبة مفتوحة المصدر. لا تتردد في المساهمة وتحسينها!

