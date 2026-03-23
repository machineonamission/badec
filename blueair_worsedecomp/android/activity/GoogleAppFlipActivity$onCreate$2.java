package com.blueair.android.activity;

import com.blueair.android.databinding.ActivityGoogleAppFlipBinding;
import com.blueair.android.viewmodel.LinkingState;
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
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/blueair/android/viewmodel/LinkingState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.activity.GoogleAppFlipActivity$onCreate$2", f = "GoogleAppFlipActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GoogleAppFlipActivity.kt */
final class GoogleAppFlipActivity$onCreate$2 extends SuspendLambda implements Function2<LinkingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleAppFlipActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoogleAppFlipActivity$onCreate$2(GoogleAppFlipActivity googleAppFlipActivity, Continuation<? super GoogleAppFlipActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = googleAppFlipActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleAppFlipActivity$onCreate$2 googleAppFlipActivity$onCreate$2 = new GoogleAppFlipActivity$onCreate$2(this.this$0, continuation);
        googleAppFlipActivity$onCreate$2.L$0 = obj;
        return googleAppFlipActivity$onCreate$2;
    }

    public final Object invoke(LinkingState linkingState, Continuation<? super Unit> continuation) {
        return ((GoogleAppFlipActivity$onCreate$2) create(linkingState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LinkingState linkingState = (LinkingState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ActivityGoogleAppFlipBinding access$getBinding$p = this.this$0.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            ProgressBlockerView progressBlockerView = access$getBinding$p.loading;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "loading");
            progressBlockerView.setVisibility(Intrinsics.areEqual((Object) linkingState, (Object) LinkingState.Loading.INSTANCE) ? 0 : 8);
            if (linkingState instanceof LinkingState.AuthCodeGot) {
                LinkingState.AuthCodeGot authCodeGot = (LinkingState.AuthCodeGot) linkingState;
                if (StringsKt.isBlank(authCodeGot.getCode())) {
                    GoogleAppFlipActivity.setErrorResult$default(this.this$0, -2, 2, 16, "USER_AUTHENTICATION_FAILED", false, 16, (Object) null);
                } else {
                    this.this$0.setSuccessResult(authCodeGot.getCode());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
