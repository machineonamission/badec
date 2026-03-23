package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\bH\u0016J\b\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasMainMode;", "Lcom/blueair/core/model/HasSKU;", "mainMode", "", "getMainMode", "()I", "apSubMode", "getApSubMode", "Lcom/blueair/core/model/MainMode;", "isInMainMode", "", "Lcom/blueair/core/model/ApSubMode;", "isInApSubMode", "subMode", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasMainMode extends HasSKU {
    ApSubMode apSubMode();

    int getApSubMode();

    int getMainMode();

    boolean isInApSubMode(ApSubMode apSubMode);

    boolean isInMainMode(MainMode mainMode);

    MainMode mainMode();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasMainMode hasMainMode) {
            return Device.CC.$default$getConnectivityStatus(hasMainMode);
        }

        @Deprecated
        public static TimeZone getTimezone(HasMainMode hasMainMode, Context context) {
            return Device.CC.$default$getTimezone(hasMainMode, context);
        }

        @Deprecated
        public static DeviceType getType(HasMainMode hasMainMode) {
            return Device.CC.$default$getType(hasMainMode);
        }

        @Deprecated
        public static boolean isOnline(HasMainMode hasMainMode) {
            return Device.CC.$default$isOnline(hasMainMode);
        }

        @Deprecated
        public static boolean isUsDevice(HasMainMode hasMainMode) {
            return Device.CC.$default$isUsDevice(hasMainMode);
        }

        @Deprecated
        public static MainMode mainMode(HasMainMode hasMainMode) {
            return CC.$default$mainMode(hasMainMode);
        }

        @Deprecated
        public static boolean isInMainMode(HasMainMode hasMainMode, MainMode mainMode) {
            Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            return CC.$default$isInMainMode(hasMainMode, mainMode);
        }

        @Deprecated
        public static ApSubMode apSubMode(HasMainMode hasMainMode) {
            return CC.$default$apSubMode(hasMainMode);
        }

        @Deprecated
        public static boolean isInApSubMode(HasMainMode hasMainMode, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return CC.$default$isInApSubMode(hasMainMode, apSubMode);
        }
    }

    /* renamed from: com.blueair.core.model.HasMainMode$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static MainMode $default$mainMode(HasMainMode _this) {
            Object obj;
            Iterator it = MainMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((MainMode) obj).getValue() == _this.getMainMode()) {
                    break;
                }
            }
            MainMode mainMode = (MainMode) obj;
            return mainMode == null ? MainMode.AirPurify : mainMode;
        }

        public static boolean $default$isInMainMode(HasMainMode _this, MainMode mainMode) {
            Intrinsics.checkNotNullParameter(mainMode, "mainMode");
            return _this.getMainMode() == mainMode.getValue();
        }

        public static ApSubMode $default$apSubMode(HasMainMode _this) {
            Object obj;
            Iterator it = ApSubMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ApSubMode) obj).getValue() == _this.getApSubMode()) {
                    break;
                }
            }
            ApSubMode apSubMode = (ApSubMode) obj;
            return apSubMode == null ? ApSubMode.FAN : apSubMode;
        }

        public static boolean $default$isInApSubMode(HasMainMode _this, ApSubMode apSubMode) {
            Intrinsics.checkNotNullParameter(apSubMode, "subMode");
            return _this.getApSubMode() == apSubMode.getValue();
        }
    }
}
