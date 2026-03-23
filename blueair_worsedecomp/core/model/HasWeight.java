package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasWeight;", "Lcom/blueair/core/model/HasSKU;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasWeight extends HasSKU {

    /* renamed from: com.blueair.core.model.HasWeight$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasWeight hasWeight) {
            return Device.CC.$default$getConnectivityStatus(hasWeight);
        }

        @Deprecated
        public static TimeZone getTimezone(HasWeight hasWeight, Context context) {
            return Device.CC.$default$getTimezone(hasWeight, context);
        }

        @Deprecated
        public static DeviceType getType(HasWeight hasWeight) {
            return Device.CC.$default$getType(hasWeight);
        }

        @Deprecated
        public static boolean isOnline(HasWeight hasWeight) {
            return Device.CC.$default$isOnline(hasWeight);
        }

        @Deprecated
        public static boolean isUsDevice(HasWeight hasWeight) {
            return Device.CC.$default$isUsDevice(hasWeight);
        }
    }
}
