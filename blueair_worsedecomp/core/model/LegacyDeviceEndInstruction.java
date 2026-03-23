package com.blueair.core.model;

import com.blueair.core.model.DeviceScheduleInstruction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "", "fan_speed", "", "brightness", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFan_speed", "()Ljava/lang/String;", "getBrightness", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LegacyDeviceEndInstruction.kt */
public final class LegacyDeviceEndInstruction {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String brightness;
    private final String fan_speed;

    public LegacyDeviceEndInstruction() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LegacyDeviceEndInstruction copy$default(LegacyDeviceEndInstruction legacyDeviceEndInstruction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legacyDeviceEndInstruction.fan_speed;
        }
        if ((i & 2) != 0) {
            str2 = legacyDeviceEndInstruction.brightness;
        }
        return legacyDeviceEndInstruction.copy(str, str2);
    }

    public final String component1() {
        return this.fan_speed;
    }

    public final String component2() {
        return this.brightness;
    }

    public final LegacyDeviceEndInstruction copy(String str, String str2) {
        return new LegacyDeviceEndInstruction(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LegacyDeviceEndInstruction)) {
            return false;
        }
        LegacyDeviceEndInstruction legacyDeviceEndInstruction = (LegacyDeviceEndInstruction) obj;
        return Intrinsics.areEqual((Object) this.fan_speed, (Object) legacyDeviceEndInstruction.fan_speed) && Intrinsics.areEqual((Object) this.brightness, (Object) legacyDeviceEndInstruction.brightness);
    }

    public int hashCode() {
        String str = this.fan_speed;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.brightness;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LegacyDeviceEndInstruction(fan_speed=" + this.fan_speed + ", brightness=" + this.brightness + ')';
    }

    public LegacyDeviceEndInstruction(String str, String str2) {
        this.fan_speed = str;
        this.brightness = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyDeviceEndInstruction(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getFan_speed() {
        return this.fan_speed;
    }

    public final String getBrightness() {
        return this.brightness;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/LegacyDeviceEndInstruction$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "instruction", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LegacyDeviceEndInstruction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LegacyDeviceEndInstruction newInstance(DeviceScheduleInstruction deviceScheduleInstruction) {
            if ((deviceScheduleInstruction != null ? deviceScheduleInstruction.getValue() : null) != null) {
                String name = deviceScheduleInstruction.getName();
                if (Intrinsics.areEqual((Object) name, (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS.getInstructionName())) {
                    return new LegacyDeviceEndInstruction((String) null, deviceScheduleInstruction.getValue(), 1, (DefaultConstructorMarker) null);
                }
                if (Intrinsics.areEqual((Object) name, (Object) DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName())) {
                    return new LegacyDeviceEndInstruction(deviceScheduleInstruction.getValue(), (String) null, 2, (DefaultConstructorMarker) null);
                }
            }
            return null;
        }
    }
}
