package com.blueair.login;

import android.widget.TextView;
import com.blueair.login.DeleteAccountState;
import com.blueair.login.databinding.ActivityDeleteAccountConfirmBinding;
import com.blueair.viewcore.view.ProgressBlockerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/blueair/login/DeleteAccountState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.DeleteAccountConfirmActivity$onCreate$1$3", f = "DeleteAccountConfirmActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeleteAccountConfirmActivity.kt */
final class DeleteAccountConfirmActivity$onCreate$1$3 extends SuspendLambda implements Function2<DeleteAccountState, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivityDeleteAccountConfirmBinding $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeleteAccountConfirmActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeleteAccountConfirmActivity$onCreate$1$3(ActivityDeleteAccountConfirmBinding activityDeleteAccountConfirmBinding, DeleteAccountConfirmActivity deleteAccountConfirmActivity, Continuation<? super DeleteAccountConfirmActivity$onCreate$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = activityDeleteAccountConfirmBinding;
        this.this$0 = deleteAccountConfirmActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeleteAccountConfirmActivity$onCreate$1$3 deleteAccountConfirmActivity$onCreate$1$3 = new DeleteAccountConfirmActivity$onCreate$1$3(this.$this_apply, this.this$0, continuation);
        deleteAccountConfirmActivity$onCreate$1$3.L$0 = obj;
        return deleteAccountConfirmActivity$onCreate$1$3;
    }

    public final Object invoke(DeleteAccountState deleteAccountState, Continuation<? super Unit> continuation) {
        return ((DeleteAccountConfirmActivity$onCreate$1$3) create(deleteAccountState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DeleteAccountState deleteAccountState = (DeleteAccountState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressBlockerView progressBlockerView = this.$this_apply.loading;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "loading");
            progressBlockerView.setVisibility(Intrinsics.areEqual((Object) deleteAccountState, (Object) DeleteAccountState.Deleting.INSTANCE) ? 0 : 8);
            if (Intrinsics.areEqual((Object) deleteAccountState, (Object) DeleteAccountState.Deleted.INSTANCE)) {
                this.this$0.onAccountDeleted();
            } else if (Intrinsics.areEqual((Object) deleteAccountState, (Object) DeleteAccountState.Failed.INSTANCE)) {
                this.this$0.onDeletionFailed();
            } else if (deleteAccountState instanceof DeleteAccountState.Idle) {
                DeleteAccountConfirmActivity deleteAccountConfirmActivity = this.this$0;
                TextView textView = this.$this_apply.notice;
                Intrinsics.checkNotNullExpressionValue(textView, "notice");
                deleteAccountConfirmActivity.setNoticeText(textView, ((DeleteAccountState.Idle) deleteAccountState).getCountry());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
