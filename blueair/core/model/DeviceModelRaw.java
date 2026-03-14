package com.blueair.core.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"},
   d2 = {"Lcom/blueair/core/model/DeviceModelRaw;", "", "type", "", "model_name", "Lcom/blueair/core/model/I18nConfig;", "family_name", "user_manual", "<init>", "(Ljava/lang/String;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getModel_name", "()Lcom/blueair/core/model/I18nConfig;", "getFamily_name", "getUser_manual", "toDeviceModel", "Lcom/blueair/core/model/DeviceModel;", "manualMap", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModelRaw {
   private final I18nConfig family_name;
   private final I18nConfig model_name;
   private final String type;
   private final String user_manual;

   public DeviceModelRaw(String var1, I18nConfig var2, I18nConfig var3, String var4) {
      this.type = var1;
      this.model_name = var2;
      this.family_name = var3;
      this.user_manual = var4;
   }

   // $FF: synthetic method
   public static DeviceModelRaw copy$default(DeviceModelRaw var0, String var1, I18nConfig var2, I18nConfig var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.model_name;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.family_name;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.user_manual;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.type;
   }

   public final I18nConfig component2() {
      return this.model_name;
   }

   public final I18nConfig component3() {
      return this.family_name;
   }

   public final String component4() {
      return this.user_manual;
   }

   public final DeviceModelRaw copy(String var1, I18nConfig var2, I18nConfig var3, String var4) {
      return new DeviceModelRaw(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceModelRaw)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.model_name, var1.model_name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.family_name, var1.family_name)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.user_manual, var1.user_manual);
         }
      }
   }

   public final I18nConfig getFamily_name() {
      return this.family_name;
   }

   public final I18nConfig getModel_name() {
      return this.model_name;
   }

   public final String getType() {
      return this.type;
   }

   public final String getUser_manual() {
      return this.user_manual;
   }

   public int hashCode() {
      String var5 = this.type;
      int var4 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      I18nConfig var6 = this.model_name;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      var6 = this.family_name;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      String var8 = this.user_manual;
      if (var8 != null) {
         var4 = var8.hashCode();
      }

      return ((var1 * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public final DeviceModel toDeviceModel(Map var1) {
      Intrinsics.checkNotNullParameter(var1, "manualMap");
      String var2 = this.type;
      DeviceType var4;
      if (var2 != null) {
         var4 = DeviceType.Companion.fromName(var2);
      } else {
         var4 = null;
      }

      SkuConfigurationKt.access$logNotFoundError("device_model.type", this.type, var4);
      I18nConfig var3 = (I18nConfig)var1.get(this.user_manual);
      SkuConfigurationKt.access$logNotFoundError("device_model.user_manual", this.user_manual, var3);
      return new DeviceModel(var4, this.model_name, this.family_name, var3);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceModelRaw(type=");
      var1.append(this.type);
      var1.append(", model_name=");
      var1.append(this.model_name);
      var1.append(", family_name=");
      var1.append(this.family_name);
      var1.append(", user_manual=");
      var1.append(this.user_manual);
      var1.append(')');
      return var1.toString();
   }
}
