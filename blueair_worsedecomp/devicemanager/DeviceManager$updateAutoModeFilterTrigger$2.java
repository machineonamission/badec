package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.FilterTrigger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0}, l = {1620}, m = "updateAutoModeFilterTrigger", n = {"device", "nuFilterTrigger", "nuG4NightModeTrigger", "connection", "nuTriggerPair"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateAutoModeFilterTrigger$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$updateAutoModeFilterTrigger$2(DeviceManager deviceManager, Continuation<? super DeviceManager$updateAutoModeFilterTrigger$2> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateAutoModeFilterTrigger((Device) null, (FilterTrigger) null, (FilterTrigger) null, this);
    }
}
