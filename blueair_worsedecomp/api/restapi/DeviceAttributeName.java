package com.blueair.api.restapi;

import io.flatcircle.stomp.StompService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/blueair/api/restapi/DeviceAttributeName;", "", "attributeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAttributeName", "()Ljava/lang/String;", "Brightness", "FanSpeed", "FilterRemainingMinutes", "ChildLock", "DealerCountry", "DealerName", "FanUsage", "Mode", "FilterType", "AutoModeDependency", "PurchaseDate", "SerialNumber", "UnknownAttribute", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAblRestApi.kt */
public enum DeviceAttributeName {
    Brightness("brightness"),
    FanSpeed(StompService.ATTRIBUTE_FAN_SPEED),
    FilterRemainingMinutes("filter_remaining_minutes"),
    ChildLock("child_lock"),
    DealerCountry("dealerCountry"),
    DealerName("dealerName"),
    FanUsage("fan_usage"),
    Mode("mode"),
    FilterType("filterType"),
    AutoModeDependency("auto_mode_dependency"),
    PurchaseDate("purchaseDate"),
    SerialNumber("serial"),
    UnknownAttribute("unknown");
    
    public static final Companion Companion = null;
    private final String attributeName;

    public static EnumEntries<DeviceAttributeName> getEntries() {
        return $ENTRIES;
    }

    private DeviceAttributeName(String str) {
        this.attributeName = str;
    }

    public final String getAttributeName() {
        return this.attributeName;
    }

    static {
        DeviceAttributeName[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/api/restapi/DeviceAttributeName$Companion;", "", "<init>", "()V", "fromName", "Lcom/blueair/api/restapi/DeviceAttributeName;", "name", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAblRestApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceAttributeName fromName(String str) {
            DeviceAttributeName deviceAttributeName;
            Intrinsics.checkNotNullParameter(str, "name");
            DeviceAttributeName[] values = DeviceAttributeName.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceAttributeName = null;
                    break;
                }
                deviceAttributeName = values[i];
                if (Intrinsics.areEqual((Object) deviceAttributeName.getAttributeName(), (Object) str)) {
                    break;
                }
                i++;
            }
            return deviceAttributeName == null ? DeviceAttributeName.UnknownAttribute : deviceAttributeName;
        }
    }
}
