package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasWick;", "Lcom/blueair/core/model/Device;", "wickdryEnabled", "", "getWickdryEnabled", "()Z", "wickdryOn", "getWickdryOn", "wickdryLeftTime", "", "getWickdryLeftTime", "()I", "wickdryLeftTimeUpdateTime", "", "getWickdryLeftTimeUpdateTime", "()J", "wickUsage", "getWickUsage", "waterShortage", "getWaterShortage", "getWickLifeLeft", "getWickDryLeftSeconds", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasWick extends Device {
    boolean getWaterShortage();

    int getWickDryLeftSeconds();

    int getWickLifeLeft();

    int getWickUsage();

    boolean getWickdryEnabled();

    int getWickdryLeftTime();

    long getWickdryLeftTimeUpdateTime();

    boolean getWickdryOn();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasWick hasWick) {
            return Device.CC.$default$getConnectivityStatus(hasWick);
        }

        @Deprecated
        public static TimeZone getTimezone(HasWick hasWick, Context context) {
            return Device.CC.$default$getTimezone(hasWick, context);
        }

        @Deprecated
        public static DeviceType getType(HasWick hasWick) {
            return Device.CC.$default$getType(hasWick);
        }

        @Deprecated
        public static boolean isOnline(HasWick hasWick) {
            return Device.CC.$default$isOnline(hasWick);
        }

        @Deprecated
        public static boolean isUsDevice(HasWick hasWick) {
            return Device.CC.$default$isUsDevice(hasWick);
        }

        @Deprecated
        public static int getWickLifeLeft(HasWick hasWick) {
            return CC.$default$getWickLifeLeft(hasWick);
        }

        @Deprecated
        public static int getWickDryLeftSeconds(HasWick hasWick) {
            return CC.$default$getWickDryLeftSeconds(hasWick);
        }
    }

    /* renamed from: com.blueair.core.model.HasWick$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static int $default$getWickLifeLeft(HasWick _this) {
            return RangesKt.coerceIn(100 - _this.getWickUsage(), 0, 100);
        }

        public static int $default$getWickDryLeftSeconds(HasWick _this) {
            return RangesKt.coerceAtLeast((int) (((long) _this.getWickdryLeftTime()) - ((System.currentTimeMillis() / ((long) 1000)) - _this.getWickdryLeftTimeUpdateTime())), 0);
        }
    }
}
