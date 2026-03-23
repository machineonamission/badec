package com.blueair.adddevice.fragment;

import com.blueair.adddevice.databinding.FragmentAddDeviceWifiBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isRefreshing", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.AddDeviceWifiFragment$onCreateView$2", f = "AddDeviceWifiFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceWifiFragment.kt */
final class AddDeviceWifiFragment$onCreateView$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ AddDeviceWifiFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceWifiFragment$onCreateView$2(AddDeviceWifiFragment addDeviceWifiFragment, Continuation<? super AddDeviceWifiFragment$onCreateView$2> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceWifiFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AddDeviceWifiFragment$onCreateView$2 addDeviceWifiFragment$onCreateView$2 = new AddDeviceWifiFragment$onCreateView$2(this.this$0, continuation);
        addDeviceWifiFragment$onCreateView$2.Z$0 = ((Boolean) obj).booleanValue();
        return addDeviceWifiFragment$onCreateView$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((AddDeviceWifiFragment$onCreateView$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentAddDeviceWifiBinding access$getViewDataBinding$p = this.this$0.viewDataBinding;
            if (access$getViewDataBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                access$getViewDataBinding$p = null;
            }
            access$getViewDataBinding$p.swipeToRefresh.setRefreshing(z);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
