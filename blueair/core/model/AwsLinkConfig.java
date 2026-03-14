package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0019"},
   d2 = {"Lcom/blueair/core/model/AwsLinkConfig;", "", "cn", "Lcom/blueair/core/model/I18nConfig;", "eu", "us", "<init>", "(Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;)V", "getCn", "()Lcom/blueair/core/model/I18nConfig;", "getEu", "getUs", "getValue", "", "region", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AwsLinkConfig {
   private final I18nConfig cn;
   private final I18nConfig eu;
   private final I18nConfig us;

   public AwsLinkConfig(I18nConfig var1, I18nConfig var2, I18nConfig var3) {
      this.cn = var1;
      this.eu = var2;
      this.us = var3;
   }

   // $FF: synthetic method
   public static AwsLinkConfig copy$default(AwsLinkConfig var0, I18nConfig var1, I18nConfig var2, I18nConfig var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.cn;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.eu;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.us;
      }

      return var0.copy(var1, var2, var3);
   }

   public final I18nConfig component1() {
      return this.cn;
   }

   public final I18nConfig component2() {
      return this.eu;
   }

   public final I18nConfig component3() {
      return this.us;
   }

   public final AwsLinkConfig copy(I18nConfig var1, I18nConfig var2, I18nConfig var3) {
      return new AwsLinkConfig(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AwsLinkConfig)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.cn, var1.cn)) {
            return false;
         } else if (!Intrinsics.areEqual(this.eu, var1.eu)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.us, var1.us);
         }
      }
   }

   public final I18nConfig getCn() {
      return this.cn;
   }

   public final I18nConfig getEu() {
      return this.eu;
   }

   public final I18nConfig getUs() {
      return this.us;
   }

   public final String getValue(String var1) {
      I18nConfig var4;
      if (var1 != null) {
         int var2 = var1.hashCode();
         if (var2 != 3179) {
            if (var2 != 3248) {
               if (var2 == 3742 && var1.equals("us")) {
                  I18nConfig var3 = this.us;
                  var4 = var3;
                  if (var3 == null) {
                     var4 = this.eu;
                  }

                  return var4 != null ? var4.getValue() : null;
               }
            } else if (var1.equals("eu")) {
               var4 = this.eu;
               return var4 != null ? var4.getValue() : null;
            }
         } else if (var1.equals("cn")) {
            var4 = this.cn;
            return var4 != null ? var4.getValue() : null;
         }
      }

      var4 = this.eu;
      return var4 != null ? var4.getValue() : null;
   }

   public int hashCode() {
      I18nConfig var4 = this.cn;
      int var3 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      var4 = this.eu;
      int var2;
      if (var4 == null) {
         var2 = 0;
      } else {
         var2 = var4.hashCode();
      }

      var4 = this.us;
      if (var4 != null) {
         var3 = var4.hashCode();
      }

      return (var1 * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AwsLinkConfig(cn=");
      var1.append(this.cn);
      var1.append(", eu=");
      var1.append(this.eu);
      var1.append(", us=");
      var1.append(this.us);
      var1.append(')');
      return var1.toString();
   }
}
