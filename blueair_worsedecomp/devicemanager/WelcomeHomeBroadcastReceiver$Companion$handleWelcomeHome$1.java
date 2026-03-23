package com.blueair.devicemanager;

import com.blueair.core.service.AnalyticsService;
import com.blueair.devicemanager.WelcomeHomeBroadcastReceiver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.WelcomeHomeBroadcastReceiver$Companion", f = "WelcomeHomeBroadcastReceiver.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {70, 77, 79, 80, 85}, m = "handleWelcomeHome", n = {"deviceManager", "analyticsService", "scheduleService", "deviceId", "isMinRadius", "isEnter", "deviceManager", "analyticsService", "scheduleService", "deviceId", "schedules", "isMinRadius", "isEnter", "inScheduleTime", "deviceManager", "analyticsService", "scheduleService", "deviceId", "schedules", "isMinRadius", "isEnter", "inScheduleTime", "deviceManager", "analyticsService", "scheduleService", "deviceId", "schedules", "isMinRadius", "isEnter", "inScheduleTime", "deviceManager", "analyticsService", "scheduleService", "deviceId", "schedules", "isMinRadius", "isEnter", "inScheduleTime"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "Z$2"})
/* compiled from: WelcomeHomeBroadcastReceiver.kt */
final class WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WelcomeHomeBroadcastReceiver.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1(WelcomeHomeBroadcastReceiver.Companion companion, Continuation<? super WelcomeHomeBroadcastReceiver$Companion$handleWelcomeHome$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleWelcomeHome((DeviceManager) null, (AnalyticsService) null, (DeviceScheduleService) null, (String) null, false, false, this);
    }
}
