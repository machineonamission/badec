package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"},
   d2 = {"Lcom/blueair/core/model/DeviceModel;", "", "type", "Lcom/blueair/core/model/DeviceType;", "modelName", "Lcom/blueair/core/model/I18nConfig;", "familyName", "userManual", "<init>", "(Lcom/blueair/core/model/DeviceType;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;)V", "getType", "()Lcom/blueair/core/model/DeviceType;", "getModelName", "()Lcom/blueair/core/model/I18nConfig;", "getFamilyName", "getUserManual", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModel {
   private final I18nConfig familyName;
   private final I18nConfig modelName;
   private final DeviceType type;
   private final I18nConfig userManual;

   public DeviceModel(DeviceType var1, I18nConfig var2, I18nConfig var3, I18nConfig var4) {
      this.type = var1;
      this.modelName = var2;
      this.familyName = var3;
      this.userManual = var4;
   }

   // $FF: synthetic method
   public static DeviceModel copy$default(DeviceModel var0, DeviceType var1, I18nConfig var2, I18nConfig var3, I18nConfig var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.modelName;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.familyName;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.userManual;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final DeviceType component1() {
      return this.type;
   }

   public final I18nConfig component2() {
      return this.modelName;
   }

   public final I18nConfig component3() {
      return this.familyName;
   }

   public final I18nConfig component4() {
      return this.userManual;
   }

   public final DeviceModel copy(DeviceType var1, I18nConfig var2, I18nConfig var3, I18nConfig var4) {
      return new DeviceModel(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceModel)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.familyName, var1.familyName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.userManual, var1.userManual);
         }
      }
   }

   public final I18nConfig getFamilyName() {
      return this.familyName;
   }

   public final I18nConfig getModelName() {
      return this.modelName;
   }

   public final DeviceType getType() {
      return this.type;
   }

   public final I18nConfig getUserManual() {
      return this.userManual;
   }

   public int hashCode() {
      DeviceType var5 = this.type;
      int var4 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      I18nConfig var6 = this.modelName;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      var6 = this.familyName;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      var6 = this.userManual;
      if (var6 != null) {
         var4 = var6.hashCode();
      }

      return ((var1 * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceModel(type=");
      var1.append(this.type);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", familyName=");
      var1.append(this.familyName);
      var1.append(", userManual=");
      var1.append(this.userManual);
      var1.append(')');
      return var1.toString();
   }
}
