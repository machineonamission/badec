package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasMainMode;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasDehumidifierMainMode;", "Lcom/blueair/core/model/HasMainMode;", "dehSubMode", "", "getDehSubMode", "()I", "Lcom/blueair/core/model/DehSubMode;", "isInDehSubMode", "", "subMode", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasDehumidifierMainMode extends HasMainMode {
    DehSubMode dehSubMode();

    int getDehSubMode();

    boolean isInDehSubMode(DehSubMode dehSubMode);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ApSubMode apSubMode(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return HasMainMode.CC.$default$apSubMode(hasDehumidifierMainMode);
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return Device.CC.$default$getConnectivityStatus(hasDehumidifierMainMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasDehumidifierMainMode hasDehumidifierMainMode, Context context) {
            return Device.CC.$default$getTimezone(hasDehumidifierMainMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return Device.CC.$default$getType(hasDehumidifierMainMode);
        }

        @Deprecated
        public static boolean isInApSubMode(HasDehumidifierMainMode hasDehumidifierMainMode, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return HasMainMode.CC.$default$isInApSubMode(hasDehumidifierMainMode, apSubMode);
        }

        @Deprecated
        public static boolean isInMainMode(HasDehumidifierMainMode hasDehumidifierMainMode, MainMode mainMode) {
            Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            return HasMainMode.CC.$default$isInMainMode(hasDehumidifierMainMode, mainMode);
        }

        @Deprecated
        public static boolean isOnline(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return Device.CC.$default$isOnline(hasDehumidifierMainMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return Device.CC.$default$isUsDevice(hasDehumidifierMainMode);
        }

        @Deprecated
        public static MainMode mainMode(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return HasMainMode.CC.$default$mainMode(hasDehumidifierMainMode);
        }

        @Deprecated
        public static DehSubMode dehSubMode(HasDehumidifierMainMode hasDehumidifierMainMode) {
            return CC.$default$dehSubMode(hasDehumidifierMainMode);
        }

        @Deprecated
        public static boolean isInDehSubMode(HasDehumidifierMainMode hasDehumidifierMainMode, DehSubMode dehSubMode) {
            Intrinsics.checkNotNullParameter(dehSubMode, "subMode");
            return CC.$default$isInDehSubMode(hasDehumidifierMainMode, dehSubMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasDehumidifierMainMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static DehSubMode $default$dehSubMode(HasDehumidifierMainMode _this) {
            Object obj;
            Iterator it = DehSubMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((DehSubMode) obj).getValue() == _this.getDehSubMode()) {
                    break;
                }
            }
            DehSubMode dehSubMode = (DehSubMode) obj;
            return dehSubMode == null ? DehSubMode.AUTO : dehSubMode;
        }

        public static boolean $default$isInDehSubMode(HasDehumidifierMainMode _this, DehSubMode dehSubMode) {
            Intrinsics.checkNotNullParameter(dehSubMode, "subMode");
            return _this.getDehSubMode() == dehSubMode.getValue();
        }
    }
}
