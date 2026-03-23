package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.UserDevicesBlueClient", f = "UserDevicesBlueClient.kt", i = {0, 0}, l = {383}, m = "getGoogleAuthCode", n = {"clientId", "gigyaJwt"}, s = {"L$0", "L$1"})
/* compiled from: UserDevicesBlueClient.kt */
final class UserDevicesBlueClient$getGoogleAuthCode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserDevicesBlueClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserDevicesBlueClient$getGoogleAuthCode$1(UserDevicesBlueClient userDevicesBlueClient, Continuation<? super UserDevicesBlueClient$getGoogleAuthCode$1> continuation) {
        super(continuation);
        this.this$0 = userDevicesBlueClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getGoogleAuthCode((String) null, (String) null, this);
    }
}
