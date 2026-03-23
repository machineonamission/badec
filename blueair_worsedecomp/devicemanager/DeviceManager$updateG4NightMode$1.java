package com.blueair.devicemanager;

import com.blueair.core.model.HasG4NightMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {1553, 1555}, m = "updateG4NightMode", n = {"device", "connection", "nightMode", "device", "connection", "nightMode"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateG4NightMode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$updateG4NightMode$1(DeviceManager deviceManager, Continuation<? super DeviceManager$updateG4NightMode$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateG4NightMode((HasG4NightMode) null, false, this);
    }
}
