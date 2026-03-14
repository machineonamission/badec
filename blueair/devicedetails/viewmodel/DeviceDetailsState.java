package com.blueair.devicedetails.viewmodel;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.TrackedLocation;
import com.blueair.viewcore.view.StatusLabelState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0012HÆ\u0003Je\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0010HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceDetailsState;", "", "shouldShowGraphScreen", "", "device", "Lcom/blueair/core/model/Device;", "selectedSensorType", "Lcom/blueair/core/model/SensorType;", "selectedSensorDatapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "selectedSetting", "Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "sensorStatusLabelState", "Lcom/blueair/viewcore/view/StatusLabelState;", "settingsTitleResId", "", "assignedLocation", "Lcom/blueair/core/model/TrackedLocation;", "<init>", "(ZLcom/blueair/core/model/Device;Lcom/blueair/core/model/SensorType;Ljava/util/List;Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;Lcom/blueair/viewcore/view/StatusLabelState;ILcom/blueair/core/model/TrackedLocation;)V", "getShouldShowGraphScreen", "()Z", "getDevice", "()Lcom/blueair/core/model/Device;", "getSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "getSelectedSensorDatapoints", "()Ljava/util/List;", "getSelectedSetting", "()Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "getSensorStatusLabelState", "()Lcom/blueair/viewcore/view/StatusLabelState;", "getSettingsTitleResId", "()I", "getAssignedLocation", "()Lcom/blueair/core/model/TrackedLocation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetailsState {
   private final TrackedLocation assignedLocation;
   private final Device device;
   private final List selectedSensorDatapoints;
   private final SensorType selectedSensorType;
   private final DeviceSettingsType selectedSetting;
   private final StatusLabelState sensorStatusLabelState;
   private final int settingsTitleResId;
   private final boolean shouldShowGraphScreen;

   public DeviceDetailsState(boolean var1, Device var2, SensorType var3, List var4, DeviceSettingsType var5, StatusLabelState var6, int var7, TrackedLocation var8) {
      Intrinsics.checkNotNullParameter(var2, "device");
      Intrinsics.checkNotNullParameter(var4, "selectedSensorDatapoints");
      Intrinsics.checkNotNullParameter(var5, "selectedSetting");
      super();
      this.shouldShowGraphScreen = var1;
      this.device = var2;
      this.selectedSensorType = var3;
      this.selectedSensorDatapoints = var4;
      this.selectedSetting = var5;
      this.sensorStatusLabelState = var6;
      this.settingsTitleResId = var7;
      this.assignedLocation = var8;
   }

   // $FF: synthetic method
   public static DeviceDetailsState copy$default(DeviceDetailsState var0, boolean var1, Device var2, SensorType var3, List var4, DeviceSettingsType var5, StatusLabelState var6, int var7, TrackedLocation var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.shouldShowGraphScreen;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.device;
      }

      if ((var9 & 4) != 0) {
         var3 = var0.selectedSensorType;
      }

      if ((var9 & 8) != 0) {
         var4 = var0.selectedSensorDatapoints;
      }

      if ((var9 & 16) != 0) {
         var5 = var0.selectedSetting;
      }

      if ((var9 & 32) != 0) {
         var6 = var0.sensorStatusLabelState;
      }

      if ((var9 & 64) != 0) {
         var7 = var0.settingsTitleResId;
      }

      if ((var9 & 128) != 0) {
         var8 = var0.assignedLocation;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final boolean component1() {
      return this.shouldShowGraphScreen;
   }

   public final Device component2() {
      return this.device;
   }

   public final SensorType component3() {
      return this.selectedSensorType;
   }

   public final List component4() {
      return this.selectedSensorDatapoints;
   }

   public final DeviceSettingsType component5() {
      return this.selectedSetting;
   }

   public final StatusLabelState component6() {
      return this.sensorStatusLabelState;
   }

   public final int component7() {
      return this.settingsTitleResId;
   }

   public final TrackedLocation component8() {
      return this.assignedLocation;
   }

   public final DeviceDetailsState copy(boolean var1, Device var2, SensorType var3, List var4, DeviceSettingsType var5, StatusLabelState var6, int var7, TrackedLocation var8) {
      Intrinsics.checkNotNullParameter(var2, "device");
      Intrinsics.checkNotNullParameter(var4, "selectedSensorDatapoints");
      Intrinsics.checkNotNullParameter(var5, "selectedSetting");
      return new DeviceDetailsState(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceDetailsState)) {
         return false;
      } else {
         var1 = var1;
         if (this.shouldShowGraphScreen != var1.shouldShowGraphScreen) {
            return false;
         } else if (!Intrinsics.areEqual(this.device, var1.device)) {
            return false;
         } else if (this.selectedSensorType != var1.selectedSensorType) {
            return false;
         } else if (!Intrinsics.areEqual(this.selectedSensorDatapoints, var1.selectedSensorDatapoints)) {
            return false;
         } else if (this.selectedSetting != var1.selectedSetting) {
            return false;
         } else if (!Intrinsics.areEqual(this.sensorStatusLabelState, var1.sensorStatusLabelState)) {
            return false;
         } else if (this.settingsTitleResId != var1.settingsTitleResId) {
            return false;
         } else {
            return Intrinsics.areEqual(this.assignedLocation, var1.assignedLocation);
         }
      }
   }

   public final TrackedLocation getAssignedLocation() {
      return this.assignedLocation;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final List getSelectedSensorDatapoints() {
      return this.selectedSensorDatapoints;
   }

   public final SensorType getSelectedSensorType() {
      return this.selectedSensorType;
   }

   public final DeviceSettingsType getSelectedSetting() {
      return this.selectedSetting;
   }

   public final StatusLabelState getSensorStatusLabelState() {
      return this.sensorStatusLabelState;
   }

   public final int getSettingsTitleResId() {
      return this.settingsTitleResId;
   }

   public final boolean getShouldShowGraphScreen() {
      return this.shouldShowGraphScreen;
   }

   public int hashCode() {
      int var5 = AddDeviceState$$ExternalSyntheticBackport0.m(this.shouldShowGraphScreen);
      int var4 = this.device.hashCode();
      SensorType var9 = this.selectedSensorType;
      int var3 = 0;
      int var1;
      if (var9 == null) {
         var1 = 0;
      } else {
         var1 = var9.hashCode();
      }

      int var7 = this.selectedSensorDatapoints.hashCode();
      int var6 = this.selectedSetting.hashCode();
      StatusLabelState var10 = this.sensorStatusLabelState;
      int var2;
      if (var10 == null) {
         var2 = 0;
      } else {
         var2 = var10.hashCode();
      }

      int var8 = this.settingsTitleResId;
      TrackedLocation var11 = this.assignedLocation;
      if (var11 != null) {
         var3 = var11.hashCode();
      }

      return ((((((var5 * 31 + var4) * 31 + var1) * 31 + var7) * 31 + var6) * 31 + var2) * 31 + var8) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceDetailsState(shouldShowGraphScreen=");
      var1.append(this.shouldShowGraphScreen);
      var1.append(", device=");
      var1.append(this.device);
      var1.append(", selectedSensorType=");
      var1.append(this.selectedSensorType);
      var1.append(", selectedSensorDatapoints=");
      var1.append(this.selectedSensorDatapoints);
      var1.append(", selectedSetting=");
      var1.append(this.selectedSetting);
      var1.append(", sensorStatusLabelState=");
      var1.append(this.sensorStatusLabelState);
      var1.append(", settingsTitleResId=");
      var1.append(this.settingsTitleResId);
      var1.append(", assignedLocation=");
      var1.append(this.assignedLocation);
      var1.append(')');
      return var1.toString();
   }
}
