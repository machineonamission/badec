package com.blueair.android.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.android.activity.AccountLinkingActivity;
import com.blueair.android.databinding.ActivityAccountLinkingBinding;
import com.blueair.android.viewmodel.LinkingState;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/blueair/android/viewmodel/LinkingState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.activity.AccountLinkingActivity$onCreate$1$3", f = "AccountLinkingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountLinkingActivity.kt */
final class AccountLinkingActivity$onCreate$1$3 extends SuspendLambda implements Function2<LinkingState, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $linked;
    final /* synthetic */ AccountLinkingActivity.LinkingText $linkingText;
    final /* synthetic */ ActivityAccountLinkingBinding $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AccountLinkingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountLinkingActivity$onCreate$1$3(ActivityAccountLinkingBinding activityAccountLinkingBinding, AccountLinkingActivity accountLinkingActivity, boolean z, AccountLinkingActivity.LinkingText linkingText, Continuation<? super AccountLinkingActivity$onCreate$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = activityAccountLinkingBinding;
        this.this$0 = accountLinkingActivity;
        this.$linked = z;
        this.$linkingText = linkingText;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountLinkingActivity$onCreate$1$3 accountLinkingActivity$onCreate$1$3 = new AccountLinkingActivity$onCreate$1$3(this.$this_apply, this.this$0, this.$linked, this.$linkingText, continuation);
        accountLinkingActivity$onCreate$1$3.L$0 = obj;
        return accountLinkingActivity$onCreate$1$3;
    }

    public final Object invoke(LinkingState linkingState, Continuation<? super Unit> continuation) {
        return ((AccountLinkingActivity$onCreate$1$3) create(linkingState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LinkingState linkingState = (LinkingState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressBlockerView progressBlockerView = this.$this_apply.loading;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "loading");
            progressBlockerView.setVisibility(Intrinsics.areEqual((Object) linkingState, (Object) LinkingState.Loading.INSTANCE) ? 0 : 8);
            if (linkingState instanceof LinkingState.UrlGot) {
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((LinkingState.UrlGot) linkingState).getUrl())));
            } else if (linkingState instanceof LinkingState.Success) {
                if (this.$linked) {
                    this.$this_apply.title.setText(this.$linkingText.getUnlinkedTitle());
                    AppCompatTextView appCompatTextView = this.$this_apply.title;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "title");
                    appCompatTextView.setVisibility(0);
                    AppCompatTextView appCompatTextView2 = this.$this_apply.body;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "body");
                    appCompatTextView2.setVisibility(8);
                    AppCompatTextView appCompatTextView3 = this.$this_apply.txtAllowDescription;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "txtAllowDescription");
                    appCompatTextView3.setVisibility(8);
                    this.$this_apply.btnAllow.setText(R.string.close);
                    this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda0(this.this$0));
                    MaterialButton materialButton = this.$this_apply.btnNotNow;
                    Intrinsics.checkNotNullExpressionValue(materialButton, "btnNotNow");
                    materialButton.setVisibility(8);
                } else {
                    this.$this_apply.title.setText(this.$linkingText.getLinkedTitle());
                    AppCompatTextView appCompatTextView4 = this.$this_apply.title;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "title");
                    appCompatTextView4.setVisibility(0);
                    this.$this_apply.subtitle.setText(this.$linkingText.getLinkedSubTitle());
                    AppCompatTextView appCompatTextView5 = this.$this_apply.subtitle;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "subtitle");
                    appCompatTextView5.setVisibility(0);
                    this.$this_apply.body.setText(this.$linkingText.getLinkedBody());
                    AppCompatTextView appCompatTextView6 = this.$this_apply.txtAllowDescription;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView6, "txtAllowDescription");
                    appCompatTextView6.setVisibility(8);
                    this.$this_apply.btnAllow.setText(R.string.close);
                    this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda1(this.this$0));
                    MaterialButton materialButton2 = this.$this_apply.btnNotNow;
                    Intrinsics.checkNotNullExpressionValue(materialButton2, "btnNotNow");
                    materialButton2.setVisibility(8);
                }
            } else if (Intrinsics.areEqual((Object) linkingState, (Object) LinkingState.Failed.INSTANCE)) {
                if (this.$linked) {
                    this.$this_apply.title.setText(this.$linkingText.getUnlinkFailedTitle());
                    AppCompatTextView appCompatTextView7 = this.$this_apply.title;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView7, "title");
                    appCompatTextView7.setVisibility(0);
                    AppCompatImageView appCompatImageView = this.$this_apply.imgError;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "imgError");
                    appCompatImageView.setVisibility(0);
                    AppCompatTextView appCompatTextView8 = this.$this_apply.body;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView8, "body");
                    appCompatTextView8.setVisibility(8);
                    AppCompatTextView appCompatTextView9 = this.$this_apply.txtAllowDescription;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView9, "txtAllowDescription");
                    appCompatTextView9.setVisibility(8);
                    this.$this_apply.btnAllow.setText(R.string.close);
                    this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda2(this.this$0));
                    MaterialButton materialButton3 = this.$this_apply.btnNotNow;
                    Intrinsics.checkNotNullExpressionValue(materialButton3, "btnNotNow");
                    materialButton3.setVisibility(8);
                } else {
                    this.$this_apply.title.setText(this.$linkingText.getLinkFailedTitle());
                    AppCompatTextView appCompatTextView10 = this.$this_apply.title;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView10, "title");
                    appCompatTextView10.setVisibility(0);
                    AppCompatImageView appCompatImageView2 = this.$this_apply.imgError;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "imgError");
                    appCompatImageView2.setVisibility(0);
                    AppCompatTextView appCompatTextView11 = this.$this_apply.body;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView11, "body");
                    appCompatTextView11.setVisibility(8);
                    AppCompatTextView appCompatTextView12 = this.$this_apply.txtAllowDescription;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView12, "txtAllowDescription");
                    appCompatTextView12.setVisibility(8);
                    this.$this_apply.btnAllow.setText(R.string.close);
                    this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda3(this.this$0));
                    MaterialButton materialButton4 = this.$this_apply.btnNotNow;
                    Intrinsics.checkNotNullExpressionValue(materialButton4, "btnNotNow");
                    materialButton4.setVisibility(8);
                }
            } else if (Intrinsics.areEqual((Object) linkingState, (Object) LinkingState.Cancel.INSTANCE)) {
                this.this$0.finish();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(AccountLinkingActivity accountLinkingActivity, View view) {
        accountLinkingActivity.closeClicked(false);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(AccountLinkingActivity accountLinkingActivity, View view) {
        accountLinkingActivity.closeClicked(true);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(AccountLinkingActivity accountLinkingActivity, View view) {
        accountLinkingActivity.closeClicked(true);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3(AccountLinkingActivity accountLinkingActivity, View view) {
        accountLinkingActivity.closeClicked(false);
    }
}
