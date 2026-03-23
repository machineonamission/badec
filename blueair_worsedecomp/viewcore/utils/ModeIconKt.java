package com.blueair.viewcore.utils;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceBluePremium;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.MainMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"getSupportedModes", "", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lcom/blueair/core/model/Device;", "exceptStandBy", "", "isMainMode", "mainMode", "Lcom/blueair/core/model/MainMode;", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: ModeIcon.kt */
public final class ModeIconKt {
    public static /* synthetic */ List getSupportedModes$default(Device device, boolean z, boolean z2, MainMode mainMode, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            mainMode = null;
        }
        return getSupportedModes(device, z, z2, mainMode);
    }

    public static final List<ModeIcon> getSupportedModes(Device device, boolean z, boolean z2, MainMode mainMode) {
        if (device == null) {
            return CollectionsKt.emptyList();
        }
        if (z2) {
            if (!(device instanceof DeviceCombo3in1)) {
                return CollectionsKt.emptyList();
            }
            return CollectionsKt.listOf(ModeIcon.COOL, ModeIcon.AIR_PURIFY, ModeIcon.HEAT);
        } else if (device instanceof DeviceDehumidifier) {
            if (mainMode == null) {
                mainMode = ((DeviceDehumidifier) device).mainMode();
            }
            if (mainMode == MainMode.Dehumidification) {
                return CollectionsKt.listOf(ModeIcon.DRYING, ModeIcon.AUTO, ModeIcon.CONTINUOUS);
            }
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.NIGHT);
        } else if (device instanceof DeviceMiniRestful) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.NIGHT);
        } else if (device instanceof DeviceBlue40) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.ECO);
        } else if (device instanceof DevicePet20) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.SMART, ModeIcon.NIGHT);
        } else if ((device instanceof DeviceHumidifier) || (device instanceof DeviceHumidifier20)) {
            List<ModeIcon> listOf = CollectionsKt.listOf(ModeIcon.STANDBY, ModeIcon.FAN_SPEED, ModeIcon.AUTO.proofread(device), ModeIcon.NIGHT);
            return z ? CollectionsKt.drop(listOf, 1) : listOf;
        } else if (device instanceof DeviceCombo3in1) {
            return CollectionsKt.listOf(ModeIcon.ECO, ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT);
        } else if (device instanceof DeviceCombo2in120) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.SKIN);
        } else if (device instanceof DeviceCombo2in1) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT);
        } else if (device instanceof DeviceNewClassic) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.NIGHT, ModeIcon.AUTO, ModeIcon.ECO);
        } else if ((device instanceof DeviceBlue) || (device instanceof DeviceBluePremium) || (device instanceof DeviceB4) || (device instanceof DeviceB4sp)) {
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT);
        } else if (!(device instanceof DeviceG4)) {
            return CollectionsKt.emptyList();
        } else {
            if (((DeviceG4) device).isPlus()) {
                return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.DISINFECTION);
            }
            return CollectionsKt.listOf(ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT);
        }
    }
}
