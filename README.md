# SarSymbol Library

![SarSymbol Logo](https://via.placeholder.com/150) <!-- استبدل هذا الرابط برابط صورة الشعار إذا كان لديك -->

SarSymbol هي مكتبة أندرويد مخصصة لعرض رموز العملات (مثل الريال السعودي "ر.س" أو "SAR") كرموز رسومية (Drawable) داخل النصوص. المكتبة تدعم تخصيص الرموز اليسرى واليمنى للعملة وتطبيق الألوان تلقائيًا بناءً على لون النص.

## المميزات

- عرض رموز العملات كرموز رسومية داخل النصوص.
- دعم تخصيص الرموز اليسرى واليمنى للعملة.
- تطبيق لون الرمز تلقائيًا بناءً على لون النص.
- سهلة التكامل مع مشاريع الأندرويد الحالية.

## التثبيت

### عبر Gradle

أضف التبعية التالية إلى ملف `build.gradle` لمشروعك:

```groovy
dependencies {
    implementation 'com.github.yourusername:yourrepository:version'
}
ملاحظة: استبدل yourusername و yourrepository و version بقيمك الخاصة.

الاستخدام
تهيئة SarSymbol
يمكنك استخدام SarSymbol في ملفات XML أو عبر الكود.

في XML
xml
<com.sultani.sar.SarSymbol
    android:id="@+id/sarSymbol"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="100.50"
    app:currentCurrency="SAR"
    app:leftSymbol="ر.س"
    app:rightSymbol="SAR" />
في الكود
kotlin
val sarSymbol = SarSymbol(context).apply {
    text = "100.50"
    currentCurrency = "SAR"
    leftSymbol = "ر.س"
    rightSymbol = "SAR"
}
تخصيص الرموز
يمكنك تخصيص الرموز اليسرى واليمنى للعملة:

kotlin
val sarSymbol = SarSymbol(context).apply {
    text = "100.50"
    currentCurrency = "USD"
    leftSymbol = "$"
    rightSymbol = "USD"
}
تغيير لون الرمز
لون الرمز يتغير تلقائيًا بناءً على لون النص. يمكنك تغيير لون النص كالتالي:

kotlin
sarSymbol.setTextColor(Color.RED)


المساهمة
نرحب بالمساهمات! إذا كنت ترغب في المساهمة في هذا المشروع، يرجى اتباع الخطوات التالية:

قم بعمل Fork للمشروع.

قم بإنشاء فرع جديد (git checkout -b feature/YourFeatureName).

قم بإجراء التغييرات المطلوبة.

قم بعمل Commit للتغييرات (git commit -m 'Add some feature').

قم بعمل Push إلى الفرع (git push origin feature/YourFeatureName).

افتح طلب Pull.

الرخصة
هذا المشروع مرخص تحت MIT License.


### ملاحظات:
1. **الصور التوضيحية**: استبدل الروابط المؤقتة (`https://via.placeholder.com/...`) بروابط صور حقيقية توضح كيفية عمل المكتبة.
2. **الترخيص**: إذا كنت تستخدم ترخيصًا مختلفًا، استبدل `[MIT License](LICENSE)` بالترخيص المناسب.
3. **التبديلات**: استبدل `yourusername` و `yourrepository` و `version` بمعلومات مستودعك الفعلية.

بعد الانتهاء من كتابة الملف، احفظه باسم `README.md` في الجذر (root) لمستودع GitHub الخاص بك.
