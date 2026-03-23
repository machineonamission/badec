package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.UserDevicesBlueClient", f = "UserDevicesBlueClient.kt", i = {0}, l = {454}, m = "getLocationDevices", n = {"locationId"}, s = {"L$0"})
/* compiled from: UserDevicesBlueClient.kt */
final class UserDevicesBlueClient$getLocationDevices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserDevicesBlueClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserDevicesBlueClient$getLocationDevices$1(UserDevicesBlueClient userDevicesBlueClient, Continuation<? super UserDevicesBlueClient$getLocationDevices$1> continuation) {
        super(continuation);
        this.this$0 = userDevicesBlueClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLocationDevices((String) null, this);
    }
}
