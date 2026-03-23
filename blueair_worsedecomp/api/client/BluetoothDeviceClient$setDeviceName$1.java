package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.api.client.BluetoothDeviceClient", f = "BluetoothDeviceClient.kt", i = {0, 1, 1, 1}, l = {105, 112}, m = "setDeviceName", n = {"nuValue", "nuValue", "oldDataResponse", "oldData"}, s = {"L$0", "L$0", "L$1", "L$2"})
/* compiled from: BluetoothDeviceClient.kt */
final class BluetoothDeviceClient$setDeviceName$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BluetoothDeviceClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BluetoothDeviceClient$setDeviceName$1(BluetoothDeviceClient bluetoothDeviceClient, Continuation<? super BluetoothDeviceClient$setDeviceName$1> continuation) {
        super(continuation);
        this.this$0 = bluetoothDeviceClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setDeviceName((String) null, this);
    }
}
