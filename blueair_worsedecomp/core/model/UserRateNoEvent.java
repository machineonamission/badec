package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/UserRateNoEvent;", "Lcom/blueair/core/model/AmplitudeEvent;", "trigger", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AmplitudeEvent.kt */
public final class UserRateNoEvent extends AmplitudeEvent {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserRateNoEvent(String str) {
        super(AmplitudeEventKt.EVENT_USER_RATE, MapsKt.mapOf(TuplesKt.to(AmplitudeEventKt.PROP_INTERACTED_WITH, AmplitudeEventKt.INTERACTED_WITH_NO), TuplesKt.to(AmplitudeEventKt.PROP_TRIGGER, str)));
        Intrinsics.checkNotNullParameter(str, "trigger");
    }
}
