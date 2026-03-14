package com.blueair.android.fragment.integration;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"},
   d2 = {"Lcom/blueair/android/fragment/integration/IotDeviceConfig;", "", "link", "", "nameRes", "", "imageRes", "<init>", "(Ljava/lang/String;II)V", "getLink", "()Ljava/lang/String;", "getNameRes", "()I", "getImageRes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IotDeviceConfig {
   public static final int $stable = 0;
   private final int imageRes;
   private final String link;
   private final int nameRes;

   public IotDeviceConfig(String var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "link");
      super();
      this.link = var1;
      this.nameRes = var2;
      this.imageRes = var3;
   }

   // $FF: synthetic method
   public static IotDeviceConfig copy$default(IotDeviceConfig var0, String var1, int var2, int var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.link;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.nameRes;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.imageRes;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.link;
   }

   public final int component2() {
      return this.nameRes;
   }

   public final int component3() {
      return this.imageRes;
   }

   public final IotDeviceConfig copy(String var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "link");
      return new IotDeviceConfig(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof IotDeviceConfig)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.link, var1.link)) {
            return false;
         } else if (this.nameRes != var1.nameRes) {
            return false;
         } else {
            return this.imageRes == var1.imageRes;
         }
      }
   }

   public final int getImageRes() {
      return this.imageRes;
   }

   public final String getLink() {
      return this.link;
   }

   public final int getNameRes() {
      return this.nameRes;
   }

   public int hashCode() {
      return (this.link.hashCode() * 31 + this.nameRes) * 31 + this.imageRes;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("IotDeviceConfig(link=");
      var1.append(this.link);
      var1.append(", nameRes=");
      var1.append(this.nameRes);
      var1.append(", imageRes=");
      var1.append(this.imageRes);
      var1.append(')');
      return var1.toString();
   }
}
