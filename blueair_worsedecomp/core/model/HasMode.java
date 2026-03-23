package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasMode;", "Lcom/blueair/core/model/Device;", "mode", "", "getMode", "()I", "Lcom/blueair/core/model/Mode;", "isInMode", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasMode extends Device {
    int getMode();

    boolean isInMode(Mode mode);

    Mode mode();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasMode hasMode) {
            return Device.CC.$default$getConnectivityStatus(hasMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasMode hasMode, Context context) {
            return Device.CC.$default$getTimezone(hasMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasMode hasMode) {
            return Device.CC.$default$getType(hasMode);
        }

        @Deprecated
        public static boolean isOnline(HasMode hasMode) {
            return Device.CC.$default$isOnline(hasMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasMode hasMode) {
            return Device.CC.$default$isUsDevice(hasMode);
        }

        @Deprecated
        public static Mode mode(HasMode hasMode) {
            return CC.$default$mode(hasMode);
        }

        @Deprecated
        public static boolean isInMode(HasMode hasMode, Mode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return CC.$default$isInMode(hasMode, mode);
        }
    }

    /* renamed from: com.blueair.core.model.HasMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static Mode $default$mode(HasMode _this) {
            Object obj;
            Iterator it = Mode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Mode) obj).getValue() == _this.getMode()) {
                    break;
                }
            }
            Mode mode = (Mode) obj;
            return mode == null ? Mode.FAN : mode;
        }

        public static boolean $default$isInMode(HasMode _this, Mode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            return _this.getMode() == mode.getValue();
        }
    }
}
