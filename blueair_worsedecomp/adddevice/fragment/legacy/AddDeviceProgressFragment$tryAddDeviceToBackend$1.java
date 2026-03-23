package com.blueair.adddevice.fragment.legacy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment", f = "AddDeviceProgressFragment.kt", i = {0, 1}, l = {92, 93}, m = "tryAddDeviceToBackend", n = {"attempts", "attempts"}, s = {"I$0", "I$0"})
/* compiled from: AddDeviceProgressFragment.kt */
final class AddDeviceProgressFragment$tryAddDeviceToBackend$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AddDeviceProgressFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceProgressFragment$tryAddDeviceToBackend$1(AddDeviceProgressFragment addDeviceProgressFragment, Continuation<? super AddDeviceProgressFragment$tryAddDeviceToBackend$1> continuation) {
        super(continuation);
        this.this$0 = addDeviceProgressFragment;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryAddDeviceToBackend(0, this);
    }
}
