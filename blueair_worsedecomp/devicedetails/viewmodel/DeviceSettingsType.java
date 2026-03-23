package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "", "<init>", "(Ljava/lang/String;I)V", "Fanspeed", "Brightness", "Childlock", "Nightmode", "Linking", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsType.kt */
public enum DeviceSettingsType {
    Fanspeed,
    Brightness,
    Childlock,
    Nightmode,
    Linking;

    public static EnumEntries<DeviceSettingsType> getEntries() {
        return $ENTRIES;
    }

    static {
        DeviceSettingsType[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
