package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasMainMode;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasPetMainMode;", "Lcom/blueair/core/model/HasMainMode;", "smartSubMode", "", "getSmartSubMode", "()I", "Lcom/blueair/core/model/SmartSubMode;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasPetMainMode extends HasMainMode {
    int getSmartSubMode();

    SmartSubMode smartSubMode();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ApSubMode apSubMode(HasPetMainMode hasPetMainMode) {
            return HasMainMode.CC.$default$apSubMode(hasPetMainMode);
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasPetMainMode hasPetMainMode) {
            return Device.CC.$default$getConnectivityStatus(hasPetMainMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasPetMainMode hasPetMainMode, Context context) {
            return Device.CC.$default$getTimezone(hasPetMainMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasPetMainMode hasPetMainMode) {
            return Device.CC.$default$getType(hasPetMainMode);
        }

        @Deprecated
        public static boolean isInApSubMode(HasPetMainMode hasPetMainMode, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return HasMainMode.CC.$default$isInApSubMode(hasPetMainMode, apSubMode);
        }

        @Deprecated
        public static boolean isInMainMode(HasPetMainMode hasPetMainMode, MainMode mainMode) {
            Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            return HasMainMode.CC.$default$isInMainMode(hasPetMainMode, mainMode);
        }

        @Deprecated
        public static boolean isOnline(HasPetMainMode hasPetMainMode) {
            return Device.CC.$default$isOnline(hasPetMainMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasPetMainMode hasPetMainMode) {
            return Device.CC.$default$isUsDevice(hasPetMainMode);
        }

        @Deprecated
        public static MainMode mainMode(HasPetMainMode hasPetMainMode) {
            return HasMainMode.CC.$default$mainMode(hasPetMainMode);
        }

        @Deprecated
        public static SmartSubMode smartSubMode(HasPetMainMode hasPetMainMode) {
            return CC.$default$smartSubMode(hasPetMainMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasPetMainMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static SmartSubMode $default$smartSubMode(HasPetMainMode _this) {
            Object obj;
            Iterator it = SmartSubMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((SmartSubMode) obj).getValue() == _this.getSmartSubMode()) {
                    break;
                }
            }
            SmartSubMode smartSubMode = (SmartSubMode) obj;
            return smartSubMode == null ? SmartSubMode.AUTO_ON : smartSubMode;
        }
    }
}
