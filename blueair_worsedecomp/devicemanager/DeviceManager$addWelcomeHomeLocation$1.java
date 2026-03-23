package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.WelcomeHomeLocation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {2155, 2157, 2163}, m = "addWelcomeHomeLocation", n = {"device", "location", "connection", "device", "location", "connection", "$this$addWelcomeHomeLocation_u24lambda_u2453", "$i$a$-apply-DeviceManager$addWelcomeHomeLocation$2", "device", "location", "connection", "$this$addWelcomeHomeLocation_u24lambda_u2453", "$i$a$-apply-DeviceManager$addWelcomeHomeLocation$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$addWelcomeHomeLocation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$addWelcomeHomeLocation$1(DeviceManager deviceManager, Continuation<? super DeviceManager$addWelcomeHomeLocation$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addWelcomeHomeLocation((Device) null, (WelcomeHomeLocation) null, this);
    }
}
