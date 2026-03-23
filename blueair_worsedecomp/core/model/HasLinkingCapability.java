package com.blueair.core.model;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasFanSpeed;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/blueair/core/model/HasLinkingCapability;", "Lcom/blueair/core/model/HasFanSpeed;", "linkedToUid", "", "getLinkedToUid", "()Ljava/lang/String;", "setLinkedToUid", "(Ljava/lang/String;)V", "isLinked", "", "()Z", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public interface HasLinkingCapability extends HasFanSpeed {
    String getLinkedToUid();

    boolean isLinked();

    void setLinkedToUid(String str);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static AutoMode getAutoMode(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getAutoMode(hasLinkingCapability);
        }

        @Deprecated
        public static ConnectivityStatus getConnectivityStatus(HasLinkingCapability hasLinkingCapability) {
            return Device.CC.$default$getConnectivityStatus(hasLinkingCapability);
        }

        @Deprecated
        public static FanSpeedEnum getFanSpeedEnum(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getFanSpeedEnum(hasLinkingCapability);
        }

        @Deprecated
        public static Filter getFilter(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getFilter(hasLinkingCapability);
        }

        @Deprecated
        public static boolean getHasGear0(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getHasGear0(hasLinkingCapability);
        }

        @Deprecated
        public static boolean getHasGear4(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getHasGear4(hasLinkingCapability);
        }

        @Deprecated
        public static TimeZone getTimezone(HasLinkingCapability hasLinkingCapability, Context context) {
            return Device.CC.$default$getTimezone(hasLinkingCapability, context);
        }

        @Deprecated
        public static FilterTrigger getTrigger(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getTrigger(hasLinkingCapability);
        }

        @Deprecated
        public static DeviceType getType(HasLinkingCapability hasLinkingCapability) {
            return Device.CC.$default$getType(hasLinkingCapability);
        }

        @Deprecated
        public static UiAutoMode getUiAutoMode(HasLinkingCapability hasLinkingCapability) {
            return HasFanSpeed.CC.$default$getUiAutoMode(hasLinkingCapability);
        }

        @Deprecated
        public static boolean isOnline(HasLinkingCapability hasLinkingCapability) {
            return Device.CC.$default$isOnline(hasLinkingCapability);
        }

        @Deprecated
        public static boolean isUsDevice(HasLinkingCapability hasLinkingCapability) {
            return Device.CC.$default$isUsDevice(hasLinkingCapability);
        }

        @Deprecated
        public static boolean isLinked(HasLinkingCapability hasLinkingCapability) {
            return CC.$default$isLinked(hasLinkingCapability);
        }
    }

    /* renamed from: com.blueair.core.model.HasLinkingCapability$-CC  reason: invalid class name */
    /* compiled from: Device.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$isLinked(HasLinkingCapability _this) {
            String linkedToUid = _this.getLinkedToUid();
            return linkedToUid != null && linkedToUid.length() > 0;
        }
    }
}
