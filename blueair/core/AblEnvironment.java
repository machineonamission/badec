package com.blueair.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0013"},
   d2 = {"Lcom/blueair/core/AblEnvironment;", "", "<init>", "()V", "PROD", "", "UAT", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "apiKey", "getApiKey", "isUAT", "", "()Z", "getHost", "url", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AblEnvironment {
   public static final AblEnvironment INSTANCE = new AblEnvironment();
   public static final String PROD = "https://api.blueair.io/";
   public static final String UAT = "https://api-uat.blueair.io/";
   private static String baseUrl;

   static {
      BuildVariant var1 = BuildEnvironment.INSTANCE.getVariant();
      int var0 = AblEnvironment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      String var2;
      if (var0 != 1 && var0 != 2) {
         if (var0 != 3) {
            throw new NoWhenBranchMatchedException();
         }

         var2 = "https://api-uat.blueair.io/";
      } else {
         var2 = "https://api.blueair.io/";
      }

      baseUrl = var2;
   }

   private AblEnvironment() {
   }

   public final String getApiKey() {
      String var1 = baseUrl;
      if (Intrinsics.areEqual(var1, "https://api.blueair.io/")) {
         return "eyJhbGciOiJIUzI1NiJ9.eyJncmFudGVlIjoiYmx1ZWFpciIsImlhdCI6MTQ1MzEyNTYzMiwidmFsaWRpdHkiOi0xLCJqdGkiOiJkNmY3OGE0Yi1iMWNkLTRkZDgtOTA2Yi1kN2JkNzM0MTQ2NzQiLCJwZXJtaXNzaW9ucyI6WyJhbGwiXSwicXVvdGEiOi0xLCJyYXRlTGltaXQiOi0xfQ.CJsfWVzFKKDDA6rWdh-hjVVVE9S3d6Hu9BzXG9htWFw";
      } else {
         return Intrinsics.areEqual(var1, "https://api-uat.blueair.io/") ? "eyJhbGciOiJIUzI1NiJ9.eyJncmFudGVlIjoiYmx1ZWFpciIsImlhdCI6MTQ0NzIzOTQyNSwidmFsaWRpdHkiOi0xLCJqdGkiOiIyIiwicGVybWlzc2lvbnMiOlsiYWxsIl0sInF1b3RhIjotMSwicmF0ZUxpbWl0IjotMX0.aqN5MuOHKeEwqOkAJAP0caBcj3Z3nkde0U83OYO9g_A" : "";
      }
   }

   public final String getBaseUrl() {
      return baseUrl;
   }

   public final String getHost(String var1) {
      Intrinsics.checkNotNullParameter(var1, "url");
      return StringsKt.removeSuffix(StringsKt.removePrefix(var1, (CharSequence)"https://"), (CharSequence)"/");
   }

   public final boolean isUAT() {
      return Intrinsics.areEqual(baseUrl, "https://api-uat.blueair.io/");
   }

   public final void setBaseUrl(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      baseUrl = var1;
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[BuildVariant.values().length];

         try {
            var0[BuildVariant.DEBUG.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[BuildVariant.RELEASE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[BuildVariant.BETA.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
