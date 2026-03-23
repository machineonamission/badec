package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.UserDevicesAblClient", f = "UserDevicesAblClient.kt", i = {1, 1}, l = {48, 61}, m = "getDevices", n = {"sparseDevices", "detailDeviceCalls"}, s = {"L$0", "L$1"})
/* compiled from: UserDevicesAblClient.kt */
final class UserDevicesAblClient$getDevices$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserDevicesAblClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserDevicesAblClient$getDevices$1(UserDevicesAblClient userDevicesAblClient, Continuation<? super UserDevicesAblClient$getDevices$1> continuation) {
        super(continuation);
        this.this$0 = userDevicesAblClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDevices(this);
    }
}
