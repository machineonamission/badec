package com.blueair.viewcore.extensions;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"dismissKeyboard", "", "Landroid/app/Activity;", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class ActivityExtensionsKt {
   public static final void dismissKeyboard(Activity var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Object var1 = var0.getSystemService("input_method");
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      InputMethodManager var4 = (InputMethodManager)var1;
      if (var4.isAcceptingText()) {
         View var2 = var0.getCurrentFocus();
         IBinder var3;
         if (var2 != null) {
            var3 = var2.getWindowToken();
         } else {
            var3 = null;
         }

         var4.hideSoftInputFromWindow(var3, 0);
      }

   }
}
