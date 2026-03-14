package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"},
   d2 = {"Lcom/blueair/core/model/MigrationOtaResponse;", "", "compatibility", "", "model", "isUpgrading", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCompatibility", "()Ljava/lang/String;", "getModel", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MigrationOtaResponse {
   private final String compatibility;
   private final boolean isUpgrading;
   private final String model;

   public MigrationOtaResponse(String var1, String var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "compatibility");
      Intrinsics.checkNotNullParameter(var2, "model");
      super();
      this.compatibility = var1;
      this.model = var2;
      this.isUpgrading = var3;
   }

   // $FF: synthetic method
   public static MigrationOtaResponse copy$default(MigrationOtaResponse var0, String var1, String var2, boolean var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.compatibility;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.model;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.isUpgrading;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.compatibility;
   }

   public final String component2() {
      return this.model;
   }

   public final boolean component3() {
      return this.isUpgrading;
   }

   public final MigrationOtaResponse copy(String var1, String var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "compatibility");
      Intrinsics.checkNotNullParameter(var2, "model");
      return new MigrationOtaResponse(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof MigrationOtaResponse)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.compatibility, var1.compatibility)) {
            return false;
         } else if (!Intrinsics.areEqual(this.model, var1.model)) {
            return false;
         } else {
            return this.isUpgrading == var1.isUpgrading;
         }
      }
   }

   public final String getCompatibility() {
      return this.compatibility;
   }

   public final String getModel() {
      return this.model;
   }

   public int hashCode() {
      return (this.compatibility.hashCode() * 31 + this.model.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.isUpgrading);
   }

   public final boolean isUpgrading() {
      return this.isUpgrading;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("MigrationOtaResponse(compatibility=");
      var1.append(this.compatibility);
      var1.append(", model=");
      var1.append(this.model);
      var1.append(", isUpgrading=");
      var1.append(this.isUpgrading);
      var1.append(')');
      return var1.toString();
   }
}
