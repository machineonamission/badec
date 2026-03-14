package com.blueair.viewcore.extensions;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"underlineText", "", "Landroid/widget/TextView;", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class TextViewExtensionsKt {
   public static final void underlineText(TextView var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      CharSequence var1 = var0.getText();
      SpannableString var2 = new SpannableString(var1);
      var2.setSpan(new UnderlineSpan(), 0, var1.length(), 0);
      var0.setText((CharSequence)var2);
   }
}
