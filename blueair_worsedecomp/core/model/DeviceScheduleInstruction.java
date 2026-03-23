package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import io.flatcircle.stomp.StompService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/blueair/core/model/DeviceScheduleInstruction;", "Landroid/os/Parcelable;", "name", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "toBlueScheduleInstruction", "Lcom/blueair/core/model/ScheduleMode;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleInstruction.kt */
public final class DeviceScheduleInstruction implements Parcelable {
    public static final Parcelable.Creator<DeviceScheduleInstruction> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String name;
    private final String value;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleInstruction.kt */
    public static final class Creator implements Parcelable.Creator<DeviceScheduleInstruction> {
        public final DeviceScheduleInstruction createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeviceScheduleInstruction(parcel.readString(), parcel.readString());
        }

        public final DeviceScheduleInstruction[] newArray(int i) {
            return new DeviceScheduleInstruction[i];
        }
    }

    public static /* synthetic */ DeviceScheduleInstruction copy$default(DeviceScheduleInstruction deviceScheduleInstruction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceScheduleInstruction.name;
        }
        if ((i & 2) != 0) {
            str2 = deviceScheduleInstruction.value;
        }
        return deviceScheduleInstruction.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final DeviceScheduleInstruction copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new DeviceScheduleInstruction(str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceScheduleInstruction)) {
            return false;
        }
        DeviceScheduleInstruction deviceScheduleInstruction = (DeviceScheduleInstruction) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) deviceScheduleInstruction.name) && Intrinsics.areEqual((Object) this.value, (Object) deviceScheduleInstruction.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "DeviceScheduleInstruction(name=" + this.name + ", value=" + this.value + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    public DeviceScheduleInstruction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.name = str;
        this.value = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0006\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0013"}, d2 = {"Lcom/blueair/core/model/DeviceScheduleInstruction$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "instruction", "Lcom/blueair/core/model/DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType;", "value", "", "fromLegacy", "Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "fromLegacyToEndInstruction", "", "Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "fromBlueDeviceSchedule", "scheduleMode", "Lcom/blueair/core/model/ScheduleMode;", "DeviceScheduleInstructionType", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleInstruction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/blueair/core/model/DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType;", "", "instructionName", "", "defaultValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getInstructionName", "()Ljava/lang/String;", "getDefaultValue", "LEGACY_MODE", "LEGACY_FAN_SPEED", "LEGACY_BRIGHTNESS", "AUTO_MODE", "AUTO_RH", "NIGHTMODE", "BRIGHTNESS", "FAN_SPEED", "STANDBY", "DISINFECTION", "ECO", "MAIN_MODE", "AP_SUB_MODE", "SMART_SUB_MODE", "HEAT_SUB_MODE", "COOL_SUB_MODE", "AP_FAN_SPEED", "HEAT_FAN_SPEED", "COOL_FAN_SPEED", "HEAT_AUTO_TMP", "HEAT_ECO_TMP", "OSCILLATION_STATE", "MODE", "HUM_MODE", "DEH_SUB_MODE", "HUM_SUB_MODE", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: DeviceScheduleInstruction.kt */
        public enum DeviceScheduleInstructionType {
            LEGACY_MODE("mode", "auto"),
            LEGACY_FAN_SPEED(StompService.ATTRIBUTE_FAN_SPEED, AppEventsConstants.EVENT_PARAM_VALUE_YES),
            LEGACY_BRIGHTNESS("brightness", AppEventsConstants.EVENT_PARAM_VALUE_YES),
            AUTO_MODE("automode", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE),
            AUTO_RH("autorh", "50"),
            NIGHTMODE("nightmode", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE),
            BRIGHTNESS("ledbrightness", AppEventsConstants.EVENT_PARAM_VALUE_YES),
            FAN_SPEED("fanspeed", AppEventsConstants.EVENT_PARAM_VALUE_YES),
            STANDBY("standby", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE),
            DISINFECTION("disinfection", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE),
            ECO("eco", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE),
            MAIN_MODE("mainmode", AppEventsConstants.EVENT_PARAM_VALUE_NO),
            AP_SUB_MODE("apsubmode", ExifInterface.GPS_MEASUREMENT_2D),
            SMART_SUB_MODE("smartsubmode", AppEventsConstants.EVENT_PARAM_VALUE_NO),
            HEAT_SUB_MODE("heatsubmode", ExifInterface.GPS_MEASUREMENT_2D),
            COOL_SUB_MODE("coolsubmode", ExifInterface.GPS_MEASUREMENT_2D),
            AP_FAN_SPEED("fsp0", "11"),
            HEAT_FAN_SPEED("heatfs", "11"),
            COOL_FAN_SPEED("coolfs", "11"),
            HEAT_AUTO_TMP("heattemp", "22"),
            HEAT_ECO_TMP("ecoheattemp", "22"),
            OSCILLATION_STATE("oscstate", AppEventsConstants.EVENT_PARAM_VALUE_NO),
            MODE("mode", ExifInterface.GPS_MEASUREMENT_2D),
            HUM_MODE("hummode", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE),
            DEH_SUB_MODE("dehsubmode", AppEventsConstants.EVENT_PARAM_VALUE_YES),
            HUM_SUB_MODE("humsubmode", ExifInterface.GPS_MEASUREMENT_2D);
            
            private final String defaultValue;
            private final String instructionName;

            public static EnumEntries<DeviceScheduleInstructionType> getEntries() {
                return $ENTRIES;
            }

            private DeviceScheduleInstructionType(String str, String str2) {
                this.instructionName = str;
                this.defaultValue = str2;
            }

            public final String getDefaultValue() {
                return this.defaultValue;
            }

            public final String getInstructionName() {
                return this.instructionName;
            }

            static {
                DeviceScheduleInstructionType[] $values;
                $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            }
        }

        private Companion() {
        }

        public final DeviceScheduleInstruction newInstance(DeviceScheduleInstructionType deviceScheduleInstructionType, String str) {
            Intrinsics.checkNotNullParameter(deviceScheduleInstructionType, "instruction");
            Intrinsics.checkNotNullParameter(str, "value");
            return new DeviceScheduleInstruction(deviceScheduleInstructionType.getInstructionName(), str);
        }

        public final DeviceScheduleInstruction fromLegacy(LegacyDeviceScheduleInstruction legacyDeviceScheduleInstruction) {
            Intrinsics.checkNotNullParameter(legacyDeviceScheduleInstruction, "instruction");
            return new DeviceScheduleInstruction(legacyDeviceScheduleInstruction.getAttrName(), legacyDeviceScheduleInstruction.getAttrValue());
        }

        public final List<DeviceScheduleInstruction> fromLegacyToEndInstruction(LegacyDeviceEndInstruction legacyDeviceEndInstruction) {
            Intrinsics.checkNotNullParameter(legacyDeviceEndInstruction, "instruction");
            List<DeviceScheduleInstruction> arrayList = new ArrayList<>();
            if (legacyDeviceEndInstruction.getBrightness() != null) {
                arrayList.add(new DeviceScheduleInstruction(DeviceScheduleInstructionType.LEGACY_BRIGHTNESS.getInstructionName(), legacyDeviceEndInstruction.getBrightness()));
            }
            if (legacyDeviceEndInstruction.getFan_speed() != null) {
                arrayList.add(new DeviceScheduleInstruction(DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName(), legacyDeviceEndInstruction.getFan_speed()));
            }
            return arrayList;
        }

        public final DeviceScheduleInstruction fromBlueDeviceSchedule(ScheduleMode scheduleMode) {
            if (scheduleMode == null) {
                return null;
            }
            String n = scheduleMode.getN();
            Object v = scheduleMode.getV();
            if (v == null) {
                v = scheduleMode.getVb();
            }
            return new DeviceScheduleInstruction(n, String.valueOf(v));
        }
    }

    public final ScheduleMode toBlueScheduleInstruction() {
        Integer intOrNull = StringsKt.toIntOrNull(this.value);
        if (intOrNull == null) {
            return new ScheduleMode(this.name, (Integer) null, Boolean.valueOf(Boolean.parseBoolean(this.value)), 2, (DefaultConstructorMarker) null);
        }
        return new ScheduleMode(this.name, intOrNull, (Boolean) null, 4, (DefaultConstructorMarker) null);
    }
}
