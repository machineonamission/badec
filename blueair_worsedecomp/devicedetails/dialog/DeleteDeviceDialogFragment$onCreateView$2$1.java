package com.blueair.devicedetails.dialog;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.dialog.DeleteDeviceDialogFragment$onCreateView$2$1", f = "DeleteDeviceDialogFragment.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeleteDeviceDialogFragment.kt */
final class DeleteDeviceDialogFragment$onCreateView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeleteDeviceDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeleteDeviceDialogFragment$onCreateView$2$1(DeleteDeviceDialogFragment deleteDeviceDialogFragment, Continuation<? super DeleteDeviceDialogFragment$onCreateView$2$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteDeviceDialogFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteDeviceDialogFragment$onCreateView$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeleteDeviceDialogFragment$onCreateView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FragmentActivity activity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.showProgress(true);
            final DeleteDeviceDialogFragment deleteDeviceDialogFragment = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.showProgress(false);
        this.this$0.dismissAllowingStateLoss();
        if (this.this$0.isFromActivity() && (activity = this.this$0.getActivity()) != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.dialog.DeleteDeviceDialogFragment$onCreateView$2$1$1", f = "DeleteDeviceDialogFragment.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.dialog.DeleteDeviceDialogFragment$onCreateView$2$1$1  reason: invalid class name */
    /* compiled from: DeleteDeviceDialogFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(deleteDeviceDialogFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (deleteDeviceDialogFragment.getViewModel().removeDeviceWithLock(deleteDeviceDialogFragment.getDevice(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
