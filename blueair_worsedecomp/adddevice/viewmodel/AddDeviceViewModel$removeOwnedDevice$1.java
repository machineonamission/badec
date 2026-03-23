package com.blueair.adddevice.viewmodel;

import com.blueair.core.model.BluetoothDevice;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.AddDeviceViewModel", f = "AddDeviceViewModel.kt", i = {0, 0, 0}, l = {598}, m = "removeOwnedDevice", n = {"bluetoothDevice", "device", "$i$a$-let-AddDeviceViewModel$removeOwnedDevice$3"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: AddDeviceViewModel.kt */
final class AddDeviceViewModel$removeOwnedDevice$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceViewModel$removeOwnedDevice$1(AddDeviceViewModel addDeviceViewModel, Continuation<? super AddDeviceViewModel$removeOwnedDevice$1> continuation) {
        super(continuation);
        this.this$0 = addDeviceViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeOwnedDevice((BluetoothDevice) null, this);
    }
}
