package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/Device;", "brightness", "", "getBrightness", "()I", "brightnessEnum", "Lcom/blueair/core/model/Brightness;", "getBrightnessEnum", "()Lcom/blueair/core/model/Brightness;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasBrightness extends Device {
    int getBrightness();

    Brightness getBrightnessEnum();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasBrightness hasBrightness) {
            return Device.CC.$default$getConnectivityStatus(hasBrightness);
        }

        @Deprecated
        public static TimeZone getTimezone(HasBrightness hasBrightness, Context context) {
            return Device.CC.$default$getTimezone(hasBrightness, context);
        }

        @Deprecated
        public static DeviceType getType(HasBrightness hasBrightness) {
            return Device.CC.$default$getType(hasBrightness);
        }

        @Deprecated
        public static boolean isOnline(HasBrightness hasBrightness) {
            return Device.CC.$default$isOnline(hasBrightness);
        }

        @Deprecated
        public static boolean isUsDevice(HasBrightness hasBrightness) {
            return Device.CC.$default$isUsDevice(hasBrightness);
        }

        @Deprecated
        public static Brightness getBrightnessEnum(HasBrightness hasBrightness) {
            return CC.$default$getBrightnessEnum(hasBrightness);
        }
    }

    /* renamed from: com.blueair.core.model.HasBrightness$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static Brightness $default$getBrightnessEnum(HasBrightness _this) {
            return Brightness.Companion.fromServerValue(_this, _this.getBrightness());
        }
    }
}
