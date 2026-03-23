package com.blueair.antifake.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.viewmodel.AntiFakeViewModel", f = "AntiFakeViewModel.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8}, l = {227, 240, 243, 247, 247, 247, 267, 271, 275}, m = "connectBluetoothAndResetFilter", n = {"device", "device", "bleService", "device", "bleService", "connectResult", "device", "bleService", "connectResult", "filterUsage", "device", "bleService", "connectResult", "filterUsage", "device", "bleService", "connectResult", "filterUsage", "device", "bleService", "connectResult", "filterUsage", "device", "bleService", "connectResult", "device", "bleService", "connectResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
/* compiled from: AntiFakeViewModel.kt */
final class AntiFakeViewModel$connectBluetoothAndResetFilter$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AntiFakeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AntiFakeViewModel$connectBluetoothAndResetFilter$1(AntiFakeViewModel antiFakeViewModel, Continuation<? super AntiFakeViewModel$connectBluetoothAndResetFilter$1> continuation) {
        super(continuation);
        this.this$0 = antiFakeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.connectBluetoothAndResetFilter(this);
    }
}
