package com.blueair.antifake.fragmnet;

import com.blueair.antifake.databinding.FragmentSearchDeviceBinding;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.antifake.fragmnet.SearchDeviceFragment$onCreateView$5", f = "SearchDeviceFragment.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SearchDeviceFragment.kt */
final class SearchDeviceFragment$onCreateView$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SearchDeviceFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchDeviceFragment$onCreateView$5(SearchDeviceFragment searchDeviceFragment, Continuation<? super SearchDeviceFragment$onCreateView$5> continuation) {
        super(2, continuation);
        this.this$0 = searchDeviceFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchDeviceFragment$onCreateView$5(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchDeviceFragment$onCreateView$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(20000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.showProgress(false);
        if (this.this$0.adapter.getItemCount() == 0) {
            FragmentSearchDeviceBinding access$getBinding$p = this.this$0.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            MaterialButton materialButton = access$getBinding$p.btnCustomerSupport;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnCustomerSupport");
            ViewExtensionsKt.show$default(materialButton, false, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
