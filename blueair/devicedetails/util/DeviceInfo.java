package com.blueair.devicedetails.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceInfo;", "", "type", "Lcom/blueair/devicedetails/util/DeviceInfoType;", "name", "", "value", "", "<init>", "(Lcom/blueair/devicedetails/util/DeviceInfoType;ILjava/lang/String;)V", "getType", "()Lcom/blueair/devicedetails/util/DeviceInfoType;", "getName", "()I", "getValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceInfo {
   private final int name;
   private final DeviceInfoType type;
   private final String value;

   public DeviceInfo(DeviceInfoType var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var3, "value");
      super();
      this.type = var1;
      this.name = var2;
      this.value = var3;
   }

   // $FF: synthetic method
   public static DeviceInfo copy$default(DeviceInfo var0, DeviceInfoType var1, int var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.value;
      }

      return var0.copy(var1, var2, var3);
   }

   public final DeviceInfoType component1() {
      return this.type;
   }

   public final int component2() {
      return this.name;
   }

   public final String component3() {
      return this.value;
   }

   public final DeviceInfo copy(DeviceInfoType var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var3, "value");
      return new DeviceInfo(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceInfo)) {
         return false;
      } else {
         var1 = var1;
         if (this.type != var1.type) {
            return false;
         } else if (this.name != var1.name) {
            return false;
         } else {
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }
   }

   public final int getName() {
      return this.name;
   }

   public final DeviceInfoType getType() {
      return this.type;
   }

   public final String getValue() {
      return this.value;
   }

   public int hashCode() {
      return (this.type.hashCode() * 31 + this.name) * 31 + this.value.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceInfo(type=");
      var1.append(this.type);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", value=");
      var1.append(this.value);
      var1.append(')');
      return var1.toString();
   }
}
