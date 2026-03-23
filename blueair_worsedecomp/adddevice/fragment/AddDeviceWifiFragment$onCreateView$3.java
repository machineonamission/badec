package com.blueair.adddevice.fragment;

import com.blueair.core.model.Ssid;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.AddDeviceWifiFragment$onCreateView$3", f = "AddDeviceWifiFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceWifiFragment.kt */
final class AddDeviceWifiFragment$onCreateView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AddDeviceWifiFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceWifiFragment$onCreateView$3(AddDeviceWifiFragment addDeviceWifiFragment, Continuation<? super AddDeviceWifiFragment$onCreateView$3> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceWifiFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AddDeviceWifiFragment$onCreateView$3 addDeviceWifiFragment$onCreateView$3 = new AddDeviceWifiFragment$onCreateView$3(this.this$0, continuation);
        addDeviceWifiFragment$onCreateView$3.L$0 = obj;
        return addDeviceWifiFragment$onCreateView$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceWifiFragment$onCreateView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FlowKt.launchIn(FlowKt.onEach(this.this$0.getViewModel().getSsids(), new AdaptedFunctionReference(this.this$0) {
                public final Object invoke(List<Ssid> list, Continuation<? super Unit> continuation) {
                    return ((AddDeviceWifiFragment) this.receiver).updateSsidList(list);
                }
            }), coroutineScope);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
