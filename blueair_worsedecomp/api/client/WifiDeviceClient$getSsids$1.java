package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.WifiDeviceClient", f = "WifiDeviceClient.kt", i = {}, l = {99}, m = "getSsids", n = {}, s = {})
/* compiled from: WifiDeviceClient.kt */
final class WifiDeviceClient$getSsids$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiDeviceClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiDeviceClient$getSsids$1(WifiDeviceClient wifiDeviceClient, Continuation<? super WifiDeviceClient$getSsids$1> continuation) {
        super(continuation);
        this.this$0 = wifiDeviceClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSsids(this);
    }
}
