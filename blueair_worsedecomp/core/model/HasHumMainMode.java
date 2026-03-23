package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasMainMode;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasHumMainMode;", "Lcom/blueair/core/model/HasMainMode;", "humSubMode", "", "getHumSubMode", "()I", "Lcom/blueair/core/model/HumSubMode;", "isInHumSubMode", "", "subMode", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasHumMainMode extends HasMainMode {
    int getHumSubMode();

    HumSubMode humSubMode();

    boolean isInHumSubMode(HumSubMode humSubMode);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ApSubMode apSubMode(HasHumMainMode hasHumMainMode) {
            return HasMainMode.CC.$default$apSubMode(hasHumMainMode);
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasHumMainMode hasHumMainMode) {
            return Device.CC.$default$getConnectivityStatus(hasHumMainMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasHumMainMode hasHumMainMode, Context context) {
            return Device.CC.$default$getTimezone(hasHumMainMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasHumMainMode hasHumMainMode) {
            return Device.CC.$default$getType(hasHumMainMode);
        }

        @Deprecated
        public static boolean isInApSubMode(HasHumMainMode hasHumMainMode, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return HasMainMode.CC.$default$isInApSubMode(hasHumMainMode, apSubMode);
        }

        @Deprecated
        public static boolean isInMainMode(HasHumMainMode hasHumMainMode, MainMode mainMode) {
            Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            return HasMainMode.CC.$default$isInMainMode(hasHumMainMode, mainMode);
        }

        @Deprecated
        public static boolean isOnline(HasHumMainMode hasHumMainMode) {
            return Device.CC.$default$isOnline(hasHumMainMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasHumMainMode hasHumMainMode) {
            return Device.CC.$default$isUsDevice(hasHumMainMode);
        }

        @Deprecated
        public static MainMode mainMode(HasHumMainMode hasHumMainMode) {
            return HasMainMode.CC.$default$mainMode(hasHumMainMode);
        }

        @Deprecated
        public static HumSubMode humSubMode(HasHumMainMode hasHumMainMode) {
            return CC.$default$humSubMode(hasHumMainMode);
        }

        @Deprecated
        public static boolean isInHumSubMode(HasHumMainMode hasHumMainMode, HumSubMode humSubMode) {
            Intrinsics.checkNotNullParameter(humSubMode, "subMode");
            return CC.$default$isInHumSubMode(hasHumMainMode, humSubMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasHumMainMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static HumSubMode $default$humSubMode(HasHumMainMode _this) {
            Object obj;
            Iterator it = HumSubMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((HumSubMode) obj).getValue() == _this.getHumSubMode()) {
                    break;
                }
            }
            HumSubMode humSubMode = (HumSubMode) obj;
            return humSubMode == null ? HumSubMode.AUTO : humSubMode;
        }

        public static boolean $default$isInHumSubMode(HasHumMainMode _this, HumSubMode humSubMode) {
            Intrinsics.checkNotNullParameter(humSubMode, "subMode");
            return _this.getHumSubMode() == humSubMode.getValue();
        }
    }
}
