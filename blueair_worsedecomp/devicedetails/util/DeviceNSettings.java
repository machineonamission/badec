package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceNSettings;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM_NAME", "TIME_ZONE", "TEMPERATURE", "DRY_MODE", "TRIGGER_AUTO", "TRIGGER_NIGHT", "PRODUCT_INFO", "SYSTEM_INFO", "DELETE", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNSettings.kt */
public enum DeviceNSettings {
    CUSTOM_NAME,
    TIME_ZONE,
    TEMPERATURE,
    DRY_MODE,
    TRIGGER_AUTO,
    TRIGGER_NIGHT,
    PRODUCT_INFO,
    SYSTEM_INFO,
    DELETE;
    
    public static final Companion Companion = null;

    public static EnumEntries<DeviceNSettings> getEntries() {
        return $ENTRIES;
    }

    static {
        DeviceNSettings[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceNSettings$Companion;", "", "<init>", "()V", "getSupportedSettings", "", "Lcom/blueair/devicedetails/util/DeviceNSettings;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceNSettings.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceNSettings> getSupportedSettings(Device device) {
            if (device == null) {
                return CollectionsKt.emptyList();
            }
            DeviceNSettings[] values = DeviceNSettings.values();
            Collection arrayList = new ArrayList();
            for (DeviceNSettings deviceNSettings : values) {
                if (DeviceNSettingsKt.supportSetting(device, deviceNSettings)) {
                    arrayList.add(deviceNSettings);
                }
            }
            return (List) arrayList;
        }
    }
}
