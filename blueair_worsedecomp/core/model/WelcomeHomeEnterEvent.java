package com.blueair.core.model;

import com.blueair.database.entity.DeviceDataEntity;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/WelcomeHomeEnterEvent;", "Lcom/blueair/core/model/AmplitudeEvent;", "deviceId", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AmplitudeEvent.kt */
public final class WelcomeHomeEnterEvent extends AmplitudeEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WelcomeHomeEnterEvent(String str) {
        super(AmplitudeEventKt.EVENT_WELCOME_HOME_EVENT, MapsKt.mapOf(TuplesKt.to("Device ID", str), TuplesKt.to(AmplitudeEventKt.PROP_TRIGGERED_WITH, AmplitudeEventKt.TRIGGERED_WITH_ENTER)));
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
    }
}
