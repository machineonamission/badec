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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001$B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006%"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceControl;", "", "group", "Lcom/blueair/devicedetails/util/DeviceControlGroup;", "<init>", "(Ljava/lang/String;ILcom/blueair/devicedetails/util/DeviceControlGroup;)V", "getGroup", "()Lcom/blueair/devicedetails/util/DeviceControlGroup;", "OFFLINE", "MSG_FILTER_DOOR_OPEN", "MSG_FRONT_PANEL_OPEN", "MSG_TOP_PART_DISPLACED", "MSG_WATER_TANK_FULL", "MSG_WATER_TANK_FAILURE", "MSG_WATER_TANK_SHORTAGE", "MAIN_MODES_DEHUM", "MODE_HUMIDIFICATION", "GERM_SHIELD", "MODE_BUTTONS", "SKIN_HINT", "SMART_HINT", "FAN_SPEED", "TARGET_HUM", "WICK_DRYING", "AUTO_REFRESH", "AUTO_DRY", "SCHEDULE", "MOOD_LAMP", "NIGHT_LAMP", "ALARMS", "BRIGHTNESS", "FILTER", "WICK", "REFRESHER", "TIMER", "SETTINGS", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceControl.kt */
public enum DeviceControl {
    OFFLINE(DeviceControlGroup.MESSAGE),
    MSG_FILTER_DOOR_OPEN(DeviceControlGroup.MODE),
    MSG_FRONT_PANEL_OPEN(DeviceControlGroup.MODE),
    MSG_TOP_PART_DISPLACED(DeviceControlGroup.MODE),
    MSG_WATER_TANK_FULL(DeviceControlGroup.MODE),
    MSG_WATER_TANK_FAILURE(DeviceControlGroup.MODE),
    MSG_WATER_TANK_SHORTAGE(DeviceControlGroup.MODE),
    MAIN_MODES_DEHUM(DeviceControlGroup.MODE),
    MODE_HUMIDIFICATION(DeviceControlGroup.MODE),
    GERM_SHIELD(DeviceControlGroup.MODE),
    MODE_BUTTONS(DeviceControlGroup.MODE),
    SKIN_HINT(DeviceControlGroup.MODE),
    SMART_HINT(DeviceControlGroup.MODE),
    FAN_SPEED(DeviceControlGroup.CONTROL),
    TARGET_HUM(DeviceControlGroup.CONTROL),
    WICK_DRYING(DeviceControlGroup.LIGHT),
    AUTO_REFRESH(DeviceControlGroup.SCHEDULE),
    AUTO_DRY(DeviceControlGroup.SCHEDULE),
    SCHEDULE(DeviceControlGroup.SCHEDULE),
    MOOD_LAMP(DeviceControlGroup.SCHEDULE),
    NIGHT_LAMP(DeviceControlGroup.SCHEDULE),
    ALARMS(DeviceControlGroup.SCHEDULE),
    BRIGHTNESS(DeviceControlGroup.FILTER),
    FILTER(DeviceControlGroup.FILTER),
    WICK(DeviceControlGroup.FILTER),
    REFRESHER(DeviceControlGroup.FILTER),
    TIMER(DeviceControlGroup.FILTER),
    SETTINGS(DeviceControlGroup.FILTER);
    
    public static final Companion Companion = null;
    private final DeviceControlGroup group;

    public static EnumEntries<DeviceControl> getEntries() {
        return $ENTRIES;
    }

    private DeviceControl(DeviceControlGroup deviceControlGroup) {
        this.group = deviceControlGroup;
    }

    public final DeviceControlGroup getGroup() {
        return this.group;
    }

    static {
        DeviceControl[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceControl$Companion;", "", "<init>", "()V", "getSupportedControls", "", "Lcom/blueair/devicedetails/util/DeviceControl;", "device", "Lcom/blueair/core/model/Device;", "group", "Lcom/blueair/devicedetails/util/DeviceControlGroup;", "forceOffline", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceControl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ List getSupportedControls$default(Companion companion, Device device, DeviceControlGroup deviceControlGroup, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getSupportedControls(device, deviceControlGroup, z);
        }

        public final List<DeviceControl> getSupportedControls(Device device, DeviceControlGroup deviceControlGroup, boolean z) {
            Intrinsics.checkNotNullParameter(deviceControlGroup, "group");
            if (device == null) {
                return CollectionsKt.emptyList();
            }
            Collection arrayList = new ArrayList();
            for (Object next : DeviceControl.getEntries()) {
                DeviceControl deviceControl = (DeviceControl) next;
                if (deviceControl.getGroup() == deviceControlGroup && DeviceControlKt.supportControl(device, deviceControl, z)) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }
}
