package com.blueair.core.util;

import android.content.Context;
import android.os.LocaleList;
import android.os.Build.VERSION;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000b¨\u0006\r"},
   d2 = {"Lcom/blueair/core/util/LocaleUtils;", "", "<init>", "()V", "getLocale", "Ljava/util/Locale;", "context", "Landroid/content/Context;", "isUsLocale", "", "getCountryLocale", "", "getLanguageCode", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocaleUtils {
   public static final LocaleUtils INSTANCE = new LocaleUtils();

   private LocaleUtils() {
   }

   public final String getCountryLocale(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return StringUtils.INSTANCE.nullSafeToLowerCase(this.getLocale(var1).getCountry());
   }

   public final String getLanguageCode() {
      String var2 = Locale.getDefault().getLanguage();
      String var1 = var2;
      if (Intrinsics.areEqual(var2, "zh")) {
         var1 = Locale.getDefault().toLanguageTag();
         if (var1.length() >= 7) {
            Intrinsics.checkNotNull(var1);
            var1 = var1.substring(0, 7);
            Intrinsics.checkNotNullExpressionValue(var1, "substring(...)");
         } else {
            var1 = "zh-Hans";
         }
      }

      Intrinsics.checkNotNullExpressionValue(var1, "let(...)");
      return var1;
   }

   public final Locale getLocale(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Locale var2 = var1.getResources().getConfiguration().locale;
      if (VERSION.SDK_INT >= 24) {
         LocaleList var3 = BlueairApp$$ExternalSyntheticApiModelOutline0.m(var1.getResources().getConfiguration());
         Intrinsics.checkNotNullExpressionValue(var3, "getLocales(...)");
         Locale var4 = var2;
         if (BlueairApp$$ExternalSyntheticApiModelOutline0.m(var3) > 0) {
            var4 = BlueairApp$$ExternalSyntheticApiModelOutline0.m((LocaleList)var3, 0);
         }

         Intrinsics.checkNotNull(var4);
         return var4;
      } else {
         Intrinsics.checkNotNull(var2);
         return var2;
      }
   }

   public final boolean isUsLocale(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return Intrinsics.areEqual(this.getLocale(var1), Locale.US);
   }
}
