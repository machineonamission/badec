package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"},
   d2 = {"Lcom/blueair/core/model/SimpleResourceBundle;", "", "iconRes", "", "titleRes", "contentRes", "linkStr", "", "linkToken", "<init>", "(IIILjava/lang/String;Ljava/lang/String;)V", "getIconRes", "()I", "getTitleRes", "getContentRes", "getLinkStr", "()Ljava/lang/String;", "getLinkToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleResourceBundle {
   private final int contentRes;
   private final int iconRes;
   private final String linkStr;
   private final String linkToken;
   private final int titleRes;

   public SimpleResourceBundle(int var1, int var2, int var3, String var4, String var5) {
      this.iconRes = var1;
      this.titleRes = var2;
      this.contentRes = var3;
      this.linkStr = var4;
      this.linkToken = var5;
   }

   // $FF: synthetic method
   public SimpleResourceBundle(int var1, int var2, int var3, String var4, String var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = null;
      }

      if ((var6 & 16) != 0) {
         var5 = null;
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static SimpleResourceBundle copy$default(SimpleResourceBundle var0, int var1, int var2, int var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.iconRes;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.titleRes;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.contentRes;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.linkStr;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.linkToken;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final int component1() {
      return this.iconRes;
   }

   public final int component2() {
      return this.titleRes;
   }

   public final int component3() {
      return this.contentRes;
   }

   public final String component4() {
      return this.linkStr;
   }

   public final String component5() {
      return this.linkToken;
   }

   public final SimpleResourceBundle copy(int var1, int var2, int var3, String var4, String var5) {
      return new SimpleResourceBundle(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SimpleResourceBundle)) {
         return false;
      } else {
         var1 = var1;
         if (this.iconRes != var1.iconRes) {
            return false;
         } else if (this.titleRes != var1.titleRes) {
            return false;
         } else if (this.contentRes != var1.contentRes) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkStr, var1.linkStr)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.linkToken, var1.linkToken);
         }
      }
   }

   public final int getContentRes() {
      return this.contentRes;
   }

   public final int getIconRes() {
      return this.iconRes;
   }

   public final String getLinkStr() {
      return this.linkStr;
   }

   public final String getLinkToken() {
      return this.linkToken;
   }

   public final int getTitleRes() {
      return this.titleRes;
   }

   public int hashCode() {
      int var5 = this.iconRes;
      int var3 = this.titleRes;
      int var4 = this.contentRes;
      String var6 = this.linkStr;
      int var2 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.linkToken;
      if (var6 != null) {
         var2 = var6.hashCode();
      }

      return (((var5 * 31 + var3) * 31 + var4) * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SimpleResourceBundle(iconRes=");
      var1.append(this.iconRes);
      var1.append(", titleRes=");
      var1.append(this.titleRes);
      var1.append(", contentRes=");
      var1.append(this.contentRes);
      var1.append(", linkStr=");
      var1.append(this.linkStr);
      var1.append(", linkToken=");
      var1.append(this.linkToken);
      var1.append(')');
      return var1.toString();
   }
}
