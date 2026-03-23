package com.blueair.devicemanager;

import com.blueair.devicemanager.DeviceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$Companion", f = "DeviceManager.kt", i = {0, 0, 1, 1}, l = {2650, 2653}, m = "startMigrationOtaPolling", n = {"deviceManager", "deviceId", "deviceManager", "deviceId"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$Companion$startMigrationOtaPolling$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$Companion$startMigrationOtaPolling$1(DeviceManager.Companion companion, Continuation<? super DeviceManager$Companion$startMigrationOtaPolling$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startMigrationOtaPolling((DeviceManager) null, (String) null, this);
    }
}
