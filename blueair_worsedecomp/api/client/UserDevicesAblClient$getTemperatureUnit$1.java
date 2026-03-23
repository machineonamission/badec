package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.UserDevicesAblClient", f = "UserDevicesAblClient.kt", i = {}, l = {119}, m = "getTemperatureUnit", n = {}, s = {})
/* compiled from: UserDevicesAblClient.kt */
final class UserDevicesAblClient$getTemperatureUnit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserDevicesAblClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserDevicesAblClient$getTemperatureUnit$1(UserDevicesAblClient userDevicesAblClient, Continuation<? super UserDevicesAblClient$getTemperatureUnit$1> continuation) {
        super(continuation);
        this.this$0 = userDevicesAblClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getTemperatureUnit(this);
    }
}
