package com.blueair.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.util.LinkUtils;
import com.blueair.login.databinding.ActivityDeleteAccountConfirmBinding;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.view.ProgressBlockerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0014\u0010\f\u001a\u00020\t*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"},
   d2 = {"Lcom/blueair/login/DeleteAccountConfirmActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setNoticeText", "Landroid/widget/TextView;", "country", "onDeletionFailed", "onAccountDeleted", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeleteAccountConfirmActivity extends BaseActivity {
   private final String screenName = "side_menu_profile_delete_account";

   // $FF: synthetic method
   public static void $r8$lambda$5Y_2UZWts5s6k2CJrobcZLrpaO8/* $FF was: $r8$lambda$5Y-2UZWts5s6k2CJrobcZLrpaO8*/(DeleteAccountConfirmActivity var0, View var1) {
      onCreate$lambda$2$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$DpZHwHZKEFaxRjvnBt8PC1N1o_k/* $FF was: $r8$lambda$DpZHwHZKEFaxRjvnBt8PC1N1o-k*/(DeleteAccountConfirmActivity var0, View var1) {
      onCreate$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$h5qo4LTlLwAXjq43w_UhQ8Mh4Is/* $FF was: $r8$lambda$h5qo4LTlLwAXjq43w-UhQ8Mh4Is*/(DeleteAccountConfirmViewModel var0, String var1, Bundle var2) {
      onCreate$lambda$3(var0, var1, var2);
   }

   private final void onAccountDeleted() {
      this.finishAffinity();
      this.startActivity(new Intent((Context)this, PostDeleteAccountActivity.class));
   }

   private static final void onCreate$lambda$2$lambda$0(DeleteAccountConfirmActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$2$lambda$1(DeleteAccountConfirmActivity var0, View var1) {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, com.blueair.viewcore.R.string.confirmation_dialog_title_delete_account, com.blueair.viewcore.R.string.confirmation_dialog_text_delete_account, com.blueair.viewcore.R.string.delete, com.blueair.viewcore.R.string.btn_cancel, true, true, false, (String[])null, 192, (Object)null).show(var0.getSupportFragmentManager(), DeleteAccountConfirmActivity.class.getName());
   }

   private static final void onCreate$lambda$3(DeleteAccountConfirmViewModel var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.deleteAccount();
      }

   }

   private final void onDeletionFailed() {
      Toast.makeText((Context)this, com.blueair.viewcore.R.string.toast_delete_account_failed, 0).show();
   }

   private final void setNoticeText(TextView var1, String var2) {
      var2 = this.getString(com.blueair.viewcore.R.string.notice_delete_account_link, new Object[]{LinkUtils.INSTANCE.getPrivacyLinkFromCountryCode(var2)});
      Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
      var1.setText((CharSequence)HtmlCompat.fromHtml(var2, 0));
      var1.setMovementMethod(LinkMovementMethod.getInstance());
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      DeleteAccountConfirmViewModel var4 = (DeleteAccountConfirmViewModel)(new ViewModelProvider((ViewModelStoreOwner)this)).get(DeleteAccountConfirmViewModel.class);
      ActivityDeleteAccountConfirmBinding var2 = (ActivityDeleteAccountConfirmBinding)DataBindingUtil.setContentView((Activity)this, R.layout.activity_delete_account_confirm);
      var2.btnClose.setOnClickListener(new DeleteAccountConfirmActivity$$ExternalSyntheticLambda0(this));
      var2.btnDelete.setOnClickListener(new DeleteAccountConfirmActivity$$ExternalSyntheticLambda1(this));
      Flow var5 = FlowKt.onEach((Flow)var4.getState(), new Function2(var2, this, (Continuation)null) {
         final ActivityDeleteAccountConfirmBinding $this_apply;
         Object L$0;
         int label;
         final DeleteAccountConfirmActivity this$0;

         {
            this.$this_apply = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.$this_apply, this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(DeleteAccountState var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            DeleteAccountState var3 = (DeleteAccountState)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               ProgressBlockerView var5 = this.$this_apply.loading;
               Intrinsics.checkNotNullExpressionValue(var5, "loading");
               View var6 = (View)var5;
               byte var2;
               if (Intrinsics.areEqual(var3, DeleteAccountState.Deleting.INSTANCE)) {
                  var2 = 0;
               } else {
                  var2 = 8;
               }

               var6.setVisibility(var2);
               if (Intrinsics.areEqual(var3, DeleteAccountState.Deleted.INSTANCE)) {
                  this.this$0.onAccountDeleted();
               } else if (Intrinsics.areEqual(var3, DeleteAccountState.Failed.INSTANCE)) {
                  this.this$0.onDeletionFailed();
               } else if (var3 instanceof DeleteAccountState.Idle) {
                  DeleteAccountConfirmActivity var7 = this.this$0;
                  TextView var4 = this.$this_apply.notice;
                  Intrinsics.checkNotNullExpressionValue(var4, "notice");
                  var7.setNoticeText(var4, ((DeleteAccountState.Idle)var3).getCountry());
               }

               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
      LifecycleOwner var3 = (LifecycleOwner)this;
      FlowKt.launchIn(var5, (CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var3));
      this.getSupportFragmentManager().setFragmentResultListener("CONFIRMATION", var3, new DeleteAccountConfirmActivity$$ExternalSyntheticLambda2(var4));
   }
}
