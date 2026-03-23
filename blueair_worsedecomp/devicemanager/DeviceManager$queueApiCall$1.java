package com.blueair.devicemanager;

import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {2668, 406, 406}, m = "queueApiCall", n = {"action", "$this$withLock_u24default$iv", "$i$f$withLock", "action", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$queueApiCall$2", "action", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$queueApiCall$2"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$queueApiCall$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$queueApiCall$1(DeviceManager deviceManager, Continuation<? super DeviceManager$queueApiCall$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.queueApiCall((Function1<? super Continuation<? super ApiResult<SimpleResponse>>, ? extends Object>) null, this);
    }
}
