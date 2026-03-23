package com.blueair.adddevice.fragment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.WifiPasswordFragment$onResume$7$1$success$1", f = "WifiPasswordFragment.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WifiPasswordFragment.kt */
final class WifiPasswordFragment$onResume$7$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ WifiPasswordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WifiPasswordFragment$onResume$7$1$success$1(WifiPasswordFragment wifiPasswordFragment, Continuation<? super WifiPasswordFragment$onResume$7$1$success$1> continuation) {
        super(2, continuation);
        this.this$0 = wifiPasswordFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiPasswordFragment$onResume$7$1$success$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((WifiPasswordFragment$onResume$7$1$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object provisionSelectedBleDevice = this.this$0.getViewModel().provisionSelectedBleDevice(this);
            return provisionSelectedBleDevice == coroutine_suspended ? coroutine_suspended : provisionSelectedBleDevice;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
