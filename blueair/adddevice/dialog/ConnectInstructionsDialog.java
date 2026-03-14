package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.databinding.DialogConnectInstructionsBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;

@Metadata(
   d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\u0006\u0010)\u001a\u00020\u0012J\b\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020-H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006/"},
   d2 = {"Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/adddevice/databinding/DialogConnectInstructionsBinding;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "onCountdown", "Lkotlin/Function0;", "", "getOnCountdown", "()Lkotlin/jvm/functions/Function0;", "setOnCountdown", "(Lkotlin/jvm/functions/Function0;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setImageAndAnim", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "onStart", "onResume", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "switchConnecting", "hydrateConnecting", "showProgress", "shouldShowProgress", "", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConnectInstructionsDialog extends BaseDialogFragment {
   public static final String ACTION_AUTO = "action_auto";
   public static final String ACTION_FAN_SPEED = "action_fan_speed";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_BLUETOOTH_DEVICE = "extra_bluetooth_device";
   private static final String EXTRA_DEVICE_CONNECTABLE = "extra_device_connectable";
   public static final String REQUEST_KEY = "ConnectInstructionsDialog";
   private DialogConnectInstructionsBinding binding;
   private Function0 onCountdown;
   private final String screenName = "add_device_pairing";
   public AddDeviceViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$KNeYz_nQOcjGV04wGh7C7a2KcY8/* $FF was: $r8$lambda$KNeYz-nQOcjGV04wGh7C7a2KcY8*/(ConnectInstructionsDialog var0) {
      switchConnecting$lambda$7(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_Sm2EQz9nhXyTuh5UKYXd1yRhl4(ConnectInstructionsDialog var0, View var1) {
      onCreateView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dnV5iGgBYPcqLEJQJlAxuAgb6IU(ConnectInstructionsDialog var0, View var1) {
      onCreateView$lambda$1(var0, var1);
   }

   private final void hydrateConnecting() {
      DialogConnectInstructionsBinding var4 = this.binding;
      DialogConnectInstructionsBinding var3 = null;
      DialogConnectInstructionsBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      int var1 = (int)TypedValueCompat.dpToPx(14.0F, this.getResources().getDisplayMetrics());
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
      } else {
         var3 = var4;
      }

      AppCompatImageView var6 = var3.ivIndicator;
      Intrinsics.checkNotNullExpressionValue(var6, "ivIndicator");
      ((View)var6).setPadding(var1, var1, var1, var1);
      var2.ivIndicator.setImageResource(R.drawable.icon_bluetooth_on);
      var2.contentTitleTextview.setText(R.string.connecting);
      var2.contentTextview.setText(R.string.msg_connecting_to_bluetooth);
      var2.lavAnim.cancelAnimation();
      LottieAnimationView var5 = var2.lavAnim;
      Intrinsics.checkNotNullExpressionValue(var5, "lavAnim");
      ViewExtensionsKt.hide((View)var5);
   }

   private static final void onCreateView$lambda$1(ConnectInstructionsDialog var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$2(ConnectInstructionsDialog var0, View var1) {
      var0.dismiss();
   }

   private final void setImageAndAnim(BluetoothDevice var1) {
      DeviceImage var3 = DeviceConfigProvider.INSTANCE.getDeviceImage(var1);
      if (var3 != null) {
         DialogConnectInstructionsBinding var2 = this.binding;
         DialogConnectInstructionsBinding var5 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         var5.ivDevice.setImageResource(var3.getDevice());
         var2 = this.binding;
         var5 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         LottieAnimationView var7 = var5.lavAnim;
         Intrinsics.checkNotNullExpressionValue(var7, "lavAnim");
         View var8 = (View)var7;
         ViewGroup.LayoutParams var12 = var8.getLayoutParams();
         if (var12 != null) {
            var12 = (ViewGroup.LayoutParams)((ConstraintLayout.LayoutParams)var12);
            ConstraintLayout.LayoutParams var4 = (ConstraintLayout.LayoutParams)var12;
            var4.horizontalBias = var3.getBtnX();
            var4.verticalBias = var3.getBtnY();
            var8.setLayoutParams(var12);
            DialogConnectInstructionsBinding var14 = this.binding;
            DialogConnectInstructionsBinding var9 = var14;
            if (var14 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var9 = null;
            }

            LottieAnimationView var10 = var9.lavAnim;
            Intrinsics.checkNotNullExpressionValue(var10, "lavAnim");
            ViewExtensionsKt.show$default((View)var10, false, 1, (Object)null);
         } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
         }
      }
   }

   private static final void switchConnecting$lambda$7(ConnectInstructionsDialog var0) {
      var0.hydrateConnecting();
   }

   public final Function0 getOnCountdown() {
      return this.onCountdown;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public AddDeviceViewModel getViewModel() {
      AddDeviceViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var24 = this.getDialog();
      if (var24 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var25 = var24.getWindow();
         if (var25 != null) {
            var25.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var26 = this.getDialog();
         if (var26 != null) {
            Window var27 = var26.getWindow();
            if (var27 != null) {
               var27.setWindowAnimations(R.style.dialog_animation);
            }
         }
      }

      FragmentActivity var28 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var28, "requireActivity(...)");
      this.setViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var28)).get(AddDeviceViewModel.class)));
      DialogConnectInstructionsBinding var29 = DialogConnectInstructionsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var29, "inflate(...)");
      this.binding = var29;
      Object var23 = null;
      DialogConnectInstructionsBinding var7 = var29;
      if (var29 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.closeButton.setOnClickListener(new ConnectInstructionsDialog$$ExternalSyntheticLambda0(this));
      var29 = this.binding;
      var7 = var29;
      if (var29 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.btnBack.setOnClickListener(new ConnectInstructionsDialog$$ExternalSyntheticLambda1(this));
      Bundle var5 = this.getArguments();
      if (var5 != null) {
         String var9 = var5.getString("device", "");
         Intrinsics.checkNotNull(var9);
         CharSequence var6 = (CharSequence)var9;
         if (var6.length() > 0) {
            var29 = this.binding;
            DialogConnectInstructionsBinding var10 = var29;
            if (var29 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = null;
            }

            var10.tvSubtitle.setText(var6);
            var29 = this.binding;
            var10 = var29;
            if (var29 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var10 = null;
            }

            AppCompatTextView var12 = var10.tvSubtitle;
            Intrinsics.checkNotNullExpressionValue(var12, "tvSubtitle");
            ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
         }

         BluetoothDevice var13 = (BluetoothDevice)var5.getParcelable("extra_bluetooth_device");
         if (var13 != null) {
            this.setImageAndAnim(var13);
         }

         if (var5.getBoolean("extra_device_connectable")) {
            this.hydrateConnecting();
         } else {
            if (Intrinsics.areEqual(var5.getString("action_type", "action_auto"), "action_fan_speed")) {
               var29 = this.binding;
               DialogConnectInstructionsBinding var14 = var29;
               if (var29 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var14 = null;
               }

               var14.ivIndicator.setImageResource(R.drawable.ic_fanspeed);
               var29 = this.binding;
               var14 = var29;
               if (var29 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var14 = null;
               }

               var14.contentTextview.setText(R.string.wifi_start_connecting_fan);
            } else if (var13 != null && var13.getUseWaterdropAuto()) {
               int var4 = (int)TypedValueCompat.dpToPx(8.0F, this.getResources().getDisplayMetrics());
               var29 = this.binding;
               DialogConnectInstructionsBinding var16 = var29;
               if (var29 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var16 = null;
               }

               AppCompatImageView var17 = var16.ivIndicator;
               Intrinsics.checkNotNullExpressionValue(var17, "ivIndicator");
               ((View)var17).setPadding(var4, var4, var4, var4);
               var29 = this.binding;
               DialogConnectInstructionsBinding var18 = var29;
               if (var29 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var18 = null;
               }

               var18.ivIndicator.setImageResource(R.drawable.ic_waterdrop_auto_flat);
               var29 = this.binding;
               var18 = var29;
               if (var29 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var18 = null;
               }

               var18.contentTextview.setText(R.string.wifi_connect_instruction_auto_humidity);
            }

            LifecycleOwner var20 = this.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(var20, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var20), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
               int label;
               final ConnectInstructionsDialog this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     Continuation var4 = (Continuation)this;
                     this.label = 1;
                     if (DelayKt.delay(60000L, var4) == var3) {
                        return var3;
                     }
                  }

                  Function0 var5 = this.this$0.getOnCountdown();
                  if (var5 != null) {
                     var5.invoke();
                  }

                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         }
      }

      var7 = this.binding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = (DialogConnectInstructionsBinding)var23;
      }

      LinearLayout var22 = var7.getRoot();
      Intrinsics.checkNotNullExpressionValue(var22, "getRoot(...)");
      return (View)var22;
   }

   public void onDismiss(DialogInterface var1) {
      Intrinsics.checkNotNullParameter(var1, "dialog");
      super.onDismiss(var1);
      FragmentKt.setFragmentResult((Fragment)this, "ConnectInstructionsDialog", BundleKt.bundleOf());
      this.onCountdown = null;
   }

   public void onResume() {
      super.onResume();
      Bundle var1 = this.getArguments();
      String var2;
      if (var1 != null && var1.getBoolean("extra_device_connectable", false)) {
         var2 = "connecting";
      } else {
         var2 = "connect_instructions";
      }

      this.getViewModel().recordResume(var2);
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.addFlags(Integer.MIN_VALUE);
            var2.getDecorView().setSystemUiVisibility(8448);
            var2.setStatusBarColor(0);
            var2.setLayout(-1, -1);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
   }

   public final void setOnCountdown(Function0 var1) {
      this.onCountdown = var1;
   }

   public void setViewModel(AddDeviceViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   public final void switchConnecting() {
      DialogConnectInstructionsBinding var1 = null;
      this.onCountdown = null;
      Bundle var2 = this.getArguments();
      if (var2 != null) {
         var2.putBoolean("extra_device_connectable", true);
      }

      DialogConnectInstructionsBinding var3 = this.binding;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
      } else {
         var1 = var3;
      }

      var1.getRoot().post(new ConnectInstructionsDialog$$ExternalSyntheticLambda2(this));
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"},
      d2 = {"Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ACTION_AUTO", "ACTION_FAN_SPEED", "EXTRA_DEVICE_CONNECTABLE", "EXTRA_BLUETOOTH_DEVICE", "newInstance", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "deviceName", "actionType", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "connectable", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      public static ConnectInstructionsDialog newInstance$default(Companion var0, String var1, String var2, BluetoothDevice var3, boolean var4, int var5, Object var6) {
         if ((var5 & 8) != 0) {
            var4 = false;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final ConnectInstructionsDialog newInstance(String var1, String var2, BluetoothDevice var3, boolean var4) {
         Intrinsics.checkNotNullParameter(var1, "deviceName");
         Intrinsics.checkNotNullParameter(var2, "actionType");
         Intrinsics.checkNotNullParameter(var3, "bluetoothDevice");
         ConnectInstructionsDialog var5 = new ConnectInstructionsDialog();
         Bundle var6 = new Bundle();
         var6.putString("device", var1);
         var6.putString("action_type", var2);
         var6.putBoolean("extra_device_connectable", var4);
         var6.putParcelable("extra_bluetooth_device", var3);
         var5.setArguments(var6);
         return var5;
      }
   }
}
