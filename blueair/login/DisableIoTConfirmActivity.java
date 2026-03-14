package com.blueair.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.login.databinding.ActivityDisableIotConfirmBinding;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
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
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002¨\u0006\n"},
   d2 = {"Lcom/blueair/login/DisableIoTConfirmActivity;", "Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDisablingFailed", "onIoTDisabled", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DisableIoTConfirmActivity extends BaseLokaliseActivity {
   // $FF: synthetic method
   public static void $r8$lambda$HsJT4_k7Ztchha_iDgjTE0lqzHE/* $FF was: $r8$lambda$HsJT4_k7Ztchha-iDgjTE0lqzHE*/(DisableIoTConfirmViewModel var0, String var1, Bundle var2) {
      onCreate$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OvWrMQnP1ZQBxJ9SKBqQBJquKaw(DisableIoTConfirmActivity var0, View var1) {
      onCreate$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nQIuHJhf2oUp7Tb4R4ySsbAFKwo(DisableIoTConfirmActivity var0, View var1) {
      onCreate$lambda$2$lambda$0(var0, var1);
   }

   private static final void onCreate$lambda$2$lambda$0(DisableIoTConfirmActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$2$lambda$1(DisableIoTConfirmActivity var0, View var1) {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, com.blueair.viewcore.R.string.confirmation_dialog_title_delete_account, com.blueair.viewcore.R.string.confirmation_dialog_text_disable_iot, com.blueair.viewcore.R.string.delete, com.blueair.viewcore.R.string.btn_cancel, true, true, false, (String[])null, 192, (Object)null).show(var0.getSupportFragmentManager(), DisableIoTConfirmActivity.class.getName());
   }

   private static final void onCreate$lambda$3(DisableIoTConfirmViewModel var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.disableIoT();
      }

   }

   private final void onDisablingFailed() {
      Toast.makeText((Context)this, com.blueair.viewcore.R.string.toast_disable_iot_failed, 0).show();
   }

   private final void onIoTDisabled() {
      this.finishAffinity();
      this.startActivity(new Intent((Context)this, PostDisableIoTActivity.class));
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      DisableIoTConfirmViewModel var4 = (DisableIoTConfirmViewModel)(new ViewModelProvider((ViewModelStoreOwner)this)).get(DisableIoTConfirmViewModel.class);
      ActivityDisableIotConfirmBinding var2 = (ActivityDisableIotConfirmBinding)DataBindingUtil.setContentView((Activity)this, R.layout.activity_disable_iot_confirm);
      var2.btnClose.setOnClickListener(new DisableIoTConfirmActivity$$ExternalSyntheticLambda0(this));
      var2.btnDelete.setOnClickListener(new DisableIoTConfirmActivity$$ExternalSyntheticLambda1(this));
      Flow var5 = FlowKt.onEach((Flow)var4.getState(), new Function2(var2, this, (Continuation)null) {
         final ActivityDisableIotConfirmBinding $this_apply;
         Object L$0;
         int label;
         final DisableIoTConfirmActivity this$0;

         {
            this.$this_apply = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.$this_apply, this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(DisableIoTState var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            DisableIoTState var4 = (DisableIoTState)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               ProgressBlockerView var6 = this.$this_apply.loading;
               Intrinsics.checkNotNullExpressionValue(var6, "loading");
               View var5 = (View)var6;
               DisableIoTState var7 = DisableIoTState.Disabling;
               byte var3 = 0;
               boolean var2;
               if (var4 == var7) {
                  var2 = 1;
               } else {
                  var2 = 0;
               }

               if (var2) {
                  var2 = var3;
               } else {
                  var2 = (byte)8;
               }

               var5.setVisibility(var2);
               var2 = null.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
               if (var2 != 1) {
                  if (var2 == 2) {
                     this.this$0.onDisablingFailed();
                  }
               } else {
                  this.this$0.onIoTDisabled();
               }

               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }

         // $FF: synthetic class
         @Metadata(
            k = 3,
            mv = {2, 2, 0},
            xi = 48
         )
         public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
               int[] var0 = new int[DisableIoTState.values().length];

               try {
                  var0[DisableIoTState.Disabled.ordinal()] = 1;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[DisableIoTState.Failed.ordinal()] = 2;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var0;
            }
         }
      });
      LifecycleOwner var3 = (LifecycleOwner)this;
      FlowKt.launchIn(var5, (CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var3));
      this.getSupportFragmentManager().setFragmentResultListener("CONFIRMATION", var3, new DisableIoTConfirmActivity$$ExternalSyntheticLambda2(var4));
   }
}
