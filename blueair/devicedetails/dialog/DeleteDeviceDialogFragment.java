package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.DialogfragmentDeleteDeviceBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u001eH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\u001f¨\u00064"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeleteDeviceDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeleteDeviceBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "isFromActivity", "", "()Z", "isFromActivity$delegate", "Lkotlin/Lazy;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeleteDeviceDialogFragment extends BaseDialogFragment implements ProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String EXTRA_IS_FROM_ACTIVITY = "EXTRA_IS_FROM_ACTIVITY";
   public Device device;
   private final Lazy isFromActivity$delegate = LazyKt.lazy(new DeleteDeviceDialogFragment$$ExternalSyntheticLambda0(this));
   private ProgressBlockerView progressBlockerView;
   private final String screenName = "device_settings_delete";
   private DialogfragmentDeleteDeviceBinding viewDataBinding;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$31vUgK9N8L16ePWuF23QWFrF9ww(DeleteDeviceDialogFragment var0, View var1) {
      onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$BJWTHO36nqoUp8vdd5DqLzyDTZE(DeleteDeviceDialogFragment var0) {
      return isFromActivity_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$htghl5FVoHynRZPwtW8anhO77nk(DeleteDeviceDialogFragment var0, View var1) {
      onCreateView$lambda$4(var0, var1);
   }

   private static final boolean isFromActivity_delegate$lambda$0(DeleteDeviceDialogFragment var0) {
      Bundle var1 = var0.getArguments();
      return var1 != null ? var1.getBoolean("EXTRA_IS_FROM_ACTIVITY") : false;
   }

   private static final void onCreateView$lambda$3(DeleteDeviceDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$4(DeleteDeviceDialogFragment var0, View var1) {
      Dialog var2 = var0.getDialog();
      if (var2 != null) {
         var2.setCancelable(false);
      }

      var2 = var0.getDialog();
      if (var2 != null) {
         var2.setCanceledOnTouchOutside(false);
      }

      BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, (Continuation)null) {
         int label;
         final DeleteDeviceDialogFragment this$0;

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
               this.this$0.showProgress(true);
               CoroutineContext var4 = (CoroutineContext)Dispatchers.getIO();
               Function2 var5 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final DeleteDeviceDialogFragment this$0;

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
                        DeviceDetailsViewModel var5 = this.this$0.getViewModel();
                        var1 = this.this$0.getDevice();
                        Continuation var4 = (Continuation)this;
                        this.label = 1;
                        if (var5.removeDeviceWithLock(var1, var4) == var3) {
                           return var3;
                        }
                     }

                     return Unit.INSTANCE;
                  }
               };
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (BuildersKt.withContext(var4, var5, var6) == var3) {
                  return var3;
               }
            }

            this.this$0.showProgress(false);
            this.this$0.dismissAllowingStateLoss();
            if (this.this$0.isFromActivity()) {
               FragmentActivity var7 = this.this$0.getActivity();
               if (var7 != null) {
                  var7.finish();
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public final Device getDevice() {
      Device var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      DialogfragmentDeleteDeviceBinding var2 = this.viewDataBinding;
      DialogfragmentDeleteDeviceBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "rootLayout");
      return var3;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceDetailsViewModel getViewModel() {
      DeviceDetailsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   public final boolean isFromActivity() {
      return (Boolean)this.isFromActivity$delegate.getValue();
   }

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var2 = this.getActivity();
      View var4 = null;
      LayoutInflater var6;
      if (var2 != null) {
         var6 = var2.getLayoutInflater();
      } else {
         var6 = null;
      }

      if (var6 != null) {
         var4 = var6.inflate(R.layout.dialogfragment_delete_device, (ViewGroup)null);
      }

      Dialog var7 = new Dialog(this.requireContext());
      if (var4 != null) {
         var7.setContentView(var4);
      }

      FragmentActivity var3 = this.getActivity();
      if (var3 != null) {
         Window var5 = var7.getWindow();
         if (var5 != null) {
            var5.setBackgroundDrawable(ContextCompat.getDrawable((Context)var3, com.blueair.viewcore.R.drawable.rounded_rectangle_white));
         }
      }

      var7.show();
      return var7;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentDeleteDeviceBinding var4 = DialogfragmentDeleteDeviceBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.viewDataBinding = var4;
      FragmentActivity var5 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var5, "requireActivity(...)");
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var5)).get(DeviceDetailsViewModel.class)));
      DialogfragmentDeleteDeviceBinding var11 = this.viewDataBinding;
      Object var10 = null;
      DialogfragmentDeleteDeviceBinding var6 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      this.setProgressBlockerView(var6.progressView);
      var11 = this.viewDataBinding;
      var6 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.cancelView.setOnClickListener(new DeleteDeviceDialogFragment$$ExternalSyntheticLambda1(this));
      var11 = this.viewDataBinding;
      var6 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.okView.setOnClickListener(new DeleteDeviceDialogFragment$$ExternalSyntheticLambda2(this));
      var6 = this.viewDataBinding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = (DialogfragmentDeleteDeviceBinding)var10;
      }

      return (View)var6.getRoot();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Bundle var4 = this.getArguments();
      Object var8 = null;
      Device var5;
      if (var4 != null) {
         var5 = (Device)var4.getParcelable("device");
      } else {
         var5 = null;
      }

      if (var5 != null) {
         this.setDevice(var5);
         DialogfragmentDeleteDeviceBinding var3 = this.viewDataBinding;
         DialogfragmentDeleteDeviceBinding var6 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.dialogTitle.setText((CharSequence)this.getString(com.blueair.viewcore.R.string.delete_product_title, new Object[]{this.getDevice().getName()}));
         var6 = this.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (DialogfragmentDeleteDeviceBinding)var8;
         }

         var6.dialogMsg.setText((CharSequence)this.getString(com.blueair.viewcore.R.string.delete_confirmation_msg, new Object[]{this.getDevice().getName()}));
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   public void showProgress(boolean var1) {
      ProgressFragment$_CC.showProgress$default(this, this.getContext(), var1, (Integer)null, 4, (Object)null);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeleteDeviceDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_IS_FROM_ACTIVITY", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeleteDeviceDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "isFromActivity", "", "devicedetails_otherRelease"},
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

      public final DeleteDeviceDialogFragment newInstance(Device var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeleteDeviceDialogFragment var3 = new DeleteDeviceDialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1), TuplesKt.to("EXTRA_IS_FROM_ACTIVITY", var2)}));
         return var3;
      }
   }
}
