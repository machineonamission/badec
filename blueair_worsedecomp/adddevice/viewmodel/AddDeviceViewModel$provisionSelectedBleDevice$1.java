package com.blueair.adddevice.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.AddDeviceViewModel", f = "AddDeviceViewModel.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {374, 376, 409, 415, 416}, m = "provisionSelectedBleDevice", n = {"bleService", "device", "randResult", "randResultValue", "failure", "i", "bleService", "device", "randResult", "randResultValue", "failure", "i", "bleService", "device", "randResult", "randResultValue", "cloudRegion", "config", "failure", "bleService", "device", "randResult", "randResultValue", "cloudRegion", "config", "ssid", "passw", "failure", "bleService", "device", "randResult", "randResultValue", "cloudRegion", "config", "ssid", "passw", "failure"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
/* compiled from: AddDeviceViewModel.kt */
final class AddDeviceViewModel$provisionSelectedBleDevice$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceViewModel$provisionSelectedBleDevice$1(AddDeviceViewModel addDeviceViewModel, Continuation<? super AddDeviceViewModel$provisionSelectedBleDevice$1> continuation) {
        super(continuation);
        this.this$0 = addDeviceViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.provisionSelectedBleDevice(this);
    }
}
