package com.blueair.devicedetails.viewmodel;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.model.TrackedLocation;
import com.blueair.viewcore.view.StatusLabelState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0012HÆ\u0003Je\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0010HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceDetailsState;", "", "shouldShowGraphScreen", "", "device", "Lcom/blueair/core/model/Device;", "selectedSensorType", "Lcom/blueair/core/model/SensorType;", "selectedSensorDatapoints", "", "Lcom/blueair/core/model/SimpleDatapoint;", "selectedSetting", "Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "sensorStatusLabelState", "Lcom/blueair/viewcore/view/StatusLabelState;", "settingsTitleResId", "", "assignedLocation", "Lcom/blueair/core/model/TrackedLocation;", "<init>", "(ZLcom/blueair/core/model/Device;Lcom/blueair/core/model/SensorType;Ljava/util/List;Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;Lcom/blueair/viewcore/view/StatusLabelState;ILcom/blueair/core/model/TrackedLocation;)V", "getShouldShowGraphScreen", "()Z", "getDevice", "()Lcom/blueair/core/model/Device;", "getSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "getSelectedSensorDatapoints", "()Ljava/util/List;", "getSelectedSetting", "()Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "getSensorStatusLabelState", "()Lcom/blueair/viewcore/view/StatusLabelState;", "getSettingsTitleResId", "()I", "getAssignedLocation", "()Lcom/blueair/core/model/TrackedLocation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsState {
    private final TrackedLocation assignedLocation;
    private final Device device;
    private final List<SimpleDatapoint> selectedSensorDatapoints;
    private final SensorType selectedSensorType;
    private final DeviceSettingsType selectedSetting;
    private final StatusLabelState sensorStatusLabelState;
    private final int settingsTitleResId;
    private final boolean shouldShowGraphScreen;

    public static /* synthetic */ DeviceDetailsState copy$default(DeviceDetailsState deviceDetailsState, boolean z, Device device2, SensorType sensorType, List<SimpleDatapoint> list, DeviceSettingsType deviceSettingsType, StatusLabelState statusLabelState, int i, TrackedLocation trackedLocation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = deviceDetailsState.shouldShowGraphScreen;
        }
        if ((i2 & 2) != 0) {
            device2 = deviceDetailsState.device;
        }
        if ((i2 & 4) != 0) {
            sensorType = deviceDetailsState.selectedSensorType;
        }
        if ((i2 & 8) != 0) {
            list = deviceDetailsState.selectedSensorDatapoints;
        }
        if ((i2 & 16) != 0) {
            deviceSettingsType = deviceDetailsState.selectedSetting;
        }
        if ((i2 & 32) != 0) {
            statusLabelState = deviceDetailsState.sensorStatusLabelState;
        }
        if ((i2 & 64) != 0) {
            i = deviceDetailsState.settingsTitleResId;
        }
        if ((i2 & 128) != 0) {
            trackedLocation = deviceDetailsState.assignedLocation;
        }
        int i3 = i;
        TrackedLocation trackedLocation2 = trackedLocation;
        DeviceSettingsType deviceSettingsType2 = deviceSettingsType;
        StatusLabelState statusLabelState2 = statusLabelState;
        List<SimpleDatapoint> list2 = list;
        Device device3 = device2;
        return deviceDetailsState.copy(z, device3, sensorType, list2, deviceSettingsType2, statusLabelState2, i3, trackedLocation2);
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

    public final List<SimpleDatapoint> component4() {
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

    public final DeviceDetailsState copy(boolean z, Device device2, SensorType sensorType, List<SimpleDatapoint> list, DeviceSettingsType deviceSettingsType, StatusLabelState statusLabelState, int i, TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(list, "selectedSensorDatapoints");
        Intrinsics.checkNotNullParameter(deviceSettingsType, "selectedSetting");
        return new DeviceDetailsState(z, device2, sensorType, list, deviceSettingsType, statusLabelState, i, trackedLocation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceDetailsState)) {
            return false;
        }
        DeviceDetailsState deviceDetailsState = (DeviceDetailsState) obj;
        return this.shouldShowGraphScreen == deviceDetailsState.shouldShowGraphScreen && Intrinsics.areEqual((Object) this.device, (Object) deviceDetailsState.device) && this.selectedSensorType == deviceDetailsState.selectedSensorType && Intrinsics.areEqual((Object) this.selectedSensorDatapoints, (Object) deviceDetailsState.selectedSensorDatapoints) && this.selectedSetting == deviceDetailsState.selectedSetting && Intrinsics.areEqual((Object) this.sensorStatusLabelState, (Object) deviceDetailsState.sensorStatusLabelState) && this.settingsTitleResId == deviceDetailsState.settingsTitleResId && Intrinsics.areEqual((Object) this.assignedLocation, (Object) deviceDetailsState.assignedLocation);
    }

    public int hashCode() {
        int m = ((AddDeviceState$$ExternalSyntheticBackport0.m(this.shouldShowGraphScreen) * 31) + this.device.hashCode()) * 31;
        SensorType sensorType = this.selectedSensorType;
        int i = 0;
        int hashCode = (((((m + (sensorType == null ? 0 : sensorType.hashCode())) * 31) + this.selectedSensorDatapoints.hashCode()) * 31) + this.selectedSetting.hashCode()) * 31;
        StatusLabelState statusLabelState = this.sensorStatusLabelState;
        int hashCode2 = (((hashCode + (statusLabelState == null ? 0 : statusLabelState.hashCode())) * 31) + this.settingsTitleResId) * 31;
        TrackedLocation trackedLocation = this.assignedLocation;
        if (trackedLocation != null) {
            i = trackedLocation.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "DeviceDetailsState(shouldShowGraphScreen=" + this.shouldShowGraphScreen + ", device=" + this.device + ", selectedSensorType=" + this.selectedSensorType + ", selectedSensorDatapoints=" + this.selectedSensorDatapoints + ", selectedSetting=" + this.selectedSetting + ", sensorStatusLabelState=" + this.sensorStatusLabelState + ", settingsTitleResId=" + this.settingsTitleResId + ", assignedLocation=" + this.assignedLocation + ')';
    }

    public DeviceDetailsState(boolean z, Device device2, SensorType sensorType, List<SimpleDatapoint> list, DeviceSettingsType deviceSettingsType, StatusLabelState statusLabelState, int i, TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(device2, "device");
        Intrinsics.checkNotNullParameter(list, "selectedSensorDatapoints");
        Intrinsics.checkNotNullParameter(deviceSettingsType, "selectedSetting");
        this.shouldShowGraphScreen = z;
        this.device = device2;
        this.selectedSensorType = sensorType;
        this.selectedSensorDatapoints = list;
        this.selectedSetting = deviceSettingsType;
        this.sensorStatusLabelState = statusLabelState;
        this.settingsTitleResId = i;
        this.assignedLocation = trackedLocation;
    }

    public final boolean getShouldShowGraphScreen() {
        return this.shouldShowGraphScreen;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final SensorType getSelectedSensorType() {
        return this.selectedSensorType;
    }

    public final List<SimpleDatapoint> getSelectedSensorDatapoints() {
        return this.selectedSensorDatapoints;
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

    public final TrackedLocation getAssignedLocation() {
        return this.assignedLocation;
    }
}
