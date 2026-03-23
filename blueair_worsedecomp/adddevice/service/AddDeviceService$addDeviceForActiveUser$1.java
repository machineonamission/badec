package com.blueair.adddevice.service;

import com.blueair.adddevice.DeviceInformationLegacy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.service.AddDeviceService", f = "AddDeviceService.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {776, 793, 799, 801}, m = "addDeviceForActiveUser", n = {"origDeviceInfo", "origDeviceInfo", "verifiedDeviceId", "nuDeviceId", "origDeviceInfo", "verifiedDeviceId", "nuDeviceId", "origDeviceInfo", "verifiedDeviceId", "nuDeviceId"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: AddDeviceService.kt */
final class AddDeviceService$addDeviceForActiveUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceService$addDeviceForActiveUser$1(AddDeviceService addDeviceService, Continuation<? super AddDeviceService$addDeviceForActiveUser$1> continuation) {
        super(continuation);
        this.this$0 = addDeviceService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addDeviceForActiveUser((DeviceInformationLegacy) null, this);
    }
}
