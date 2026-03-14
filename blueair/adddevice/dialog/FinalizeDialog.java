package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.DialogOnboardingFinalizeBinding;
import com.blueair.adddevice.viewmodel.FinalizeViewModel;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"},
   d2 = {"Lcom/blueair/adddevice/dialog/FinalizeDialog;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/adddevice/databinding/DialogOnboardingFinalizeBinding;", "onboardingJob", "Lkotlinx/coroutines/Job;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;)V", "pageIndex", "Landroidx/lifecycle/MutableLiveData;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "gotoHomepage", "dismissAndGotoScanDevice", "showProgress", "shouldShowProgress", "", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FinalizeDialog extends BaseDialogFragment {
   public static final String ACTION_CHOOSE_DEVICE = "action_choose_device";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String REQUEST_KEY = "FinalizeDialog";
   private DialogOnboardingFinalizeBinding binding;
   private Job onboardingJob;
   private final MutableLiveData pageIndex = new MutableLiveData(0);
   private final String screenName = "add_device_finalize";
   public FinalizeViewModel viewModel;

   // $FF: synthetic method
   public static boolean $r8$lambda$18XHvvmL9panSGHdXriXb8ilxAY(FinalizeDialog var0, DialogInterface var1, int var2, KeyEvent var3) {
      return onStart$lambda$9(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$3EcxHS2krArxA_VvaLGy4advr1w(FinalizeDialog var0, String[] var1, Integer var2) {
      return onCreateView$lambda$8(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$JMVAjYxnQLopO4gO_FFriUzGxXg(FinalizeDialog var0, View var1) {
      onCreateView$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$M5JrIv3gU8NqdAcvaTV9EFo53xw(FinalizeDialog var0, View var1) {
      onCreateView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Mr2wjIZ98Aqw8PqHYE2N_iWweUM(FinalizeDialog var0, boolean var1) {
      return onCreateView$lambda$3$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OZ30_qqAFa2yowEc67Xr9lzHZe8/* $FF was: $r8$lambda$OZ30-qqAFa2yowEc67Xr9lzHZe8*/(FinalizeDialog var0, View var1) {
      onCreateView$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pNYSxgkBcWMzx6wVRItMkrZj9T0(FinalizeDialog var0, View var1) {
      onCreateView$lambda$3(var0, var1);
   }

   private final void dismissAndGotoScanDevice() {
      this.dismiss();
      FragmentKt.setFragmentResult((Fragment)this, "FinalizeDialog", BundleKt.bundleOf(new Pair[]{TuplesKt.to("action_choose_device", true)}));
   }

   private final void gotoHomepage() {
      this.dismiss();
      Actions var2 = Actions.INSTANCE;
      Context var1 = this.requireContext();
      Intrinsics.checkNotNullExpressionValue(var1, "requireContext(...)");
      this.startActivity(var2.openHomeIntent(var1));
      FragmentActivity var3 = this.getActivity();
      if (var3 != null) {
         var3.finish();
      }

   }

   private static final void onCreateView$lambda$3(FinalizeDialog var0, View var1) {
      DialogOnboardingFinalizeBinding var5 = var0.binding;
      DialogOnboardingFinalizeBinding var6 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      Group var7 = var6.groupSuccess;
      Intrinsics.checkNotNullExpressionValue(var7, "groupSuccess");
      if (((View)var7).getVisibility() == 0) {
         var0.gotoHomepage();
      } else {
         FragmentManager var9 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var9, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var9.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var9.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion var8 = ConfirmationDialogLeftAligned.Companion;
            int var3 = R.string.label_ensure_leave;
            int var4 = R.string.quit_device_setup_confirmation;
            int var2 = R.string.action_leave;
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var8, var3, (Integer)null, var4, R.string.action_continue, var2, false, false, false, false, (String[])null, (String)null, (Integer)null, new FinalizeDialog$$ExternalSyntheticLambda5(var0), 3936, (Object)null)).show(var9, "ConfirmationDialogLeftAligned");
         }

      }
   }

   private static final Unit onCreateView$lambda$3$lambda$2$lambda$1(FinalizeDialog var0, boolean var1) {
      if (!var1) {
         var0.gotoHomepage();
      }

      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$4(FinalizeDialog var0, View var1) {
      var0.gotoHomepage();
   }

   private static final void onCreateView$lambda$5(FinalizeDialog var0, View var1) {
      var0.dismissAndGotoScanDevice();
   }

   private static final void onCreateView$lambda$6(FinalizeDialog var0, View var1) {
      var0.dismissAndGotoScanDevice();
   }

   private static final Unit onCreateView$lambda$8(FinalizeDialog var0, String[] var1, Integer var2) {
      DialogOnboardingFinalizeBinding var3 = var0.binding;
      DialogOnboardingFinalizeBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      TextView var5 = var4.text;
      Intrinsics.checkNotNull(var2);
      var5.setText((CharSequence)var1[var2]);
      return Unit.INSTANCE;
   }

   private static final boolean onStart$lambda$9(FinalizeDialog var0, DialogInterface var1, int var2, KeyEvent var3) {
      if (var2 == 4) {
         var0.dismissAndGotoScanDevice();
         return true;
      } else {
         return false;
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public FinalizeViewModel getViewModel() {
      FinalizeViewModel var1 = this.viewModel;
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
      int var4 = 0;
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

      DialogOnboardingFinalizeBinding var8 = DialogOnboardingFinalizeBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var8, "inflate(...)");
      this.binding = var8;
      this.setViewModel((FinalizeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(FinalizeViewModel.class)));
      DialogOnboardingFinalizeBinding var17 = this.binding;
      Object var6 = null;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      var8.closeButton.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda0(this));
      var17 = this.binding;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      var8.btnContinue.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda1(this));
      var17 = this.binding;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      var8.btnAddAnother.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda2(this));
      var17 = this.binding;
      var8 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      label65: {
         var8.btnBack.setOnClickListener(new FinalizeDialog$$ExternalSyntheticLambda3(this));
         Bundle var13 = this.getArguments();
         if (var13 != null) {
            String var21 = var13.getString("deviceId");
            var14 = var21;
            if (var21 != null) {
               break label65;
            }
         }

         var14 = "";
      }

      label60: {
         Bundle var22 = this.getArguments();
         if (var22 != null) {
            String var28 = var22.getString("deviceName");
            var23 = var28;
            if (var28 != null) {
               break label60;
            }
         }

         var23 = "Default";
      }

      Bundle var29 = this.getArguments();
      BluetoothDevice var30;
      if (var29 != null) {
         var30 = (BluetoothDevice)var29.getParcelable("bluetoothDevice");
      } else {
         var30 = null;
      }

      Intrinsics.checkNotNull(var30);
      DialogOnboardingFinalizeBinding var7 = this.binding;
      DialogOnboardingFinalizeBinding var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      ConstraintLayout var34 = var5.clRoot;
      DeviceImage var31 = DeviceConfigProvider.INSTANCE.getDeviceImage(var30);
      if (var31 != null) {
         var4 = var31.getBgOnboarding();
      }

      var34.setBackgroundResource(var4);
      String[] var37 = this.getResources().getStringArray(R.array.onboarding_finalize_step);
      Intrinsics.checkNotNullExpressionValue(var37, "getStringArray(...)");
      DialogOnboardingFinalizeBinding var35 = this.binding;
      DialogOnboardingFinalizeBinding var32 = var35;
      if (var35 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var32 = null;
      }

      var32.headerMsg.setText((CharSequence)var23);
      this.pageIndex.observe(this.getViewLifecycleOwner(), new Observer(new FinalizeDialog$$ExternalSyntheticLambda4(this, var37)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      CoroutineScope var33 = this;
      this.onboardingJob = BuildersKt.launch$default(var33, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var37, (Continuation)null) {
         final String[] $texts;
         int I$0;
         int label;
         final FinalizeDialog this$0;

         {
            this.this$0 = var1;
            this.$texts = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$texts, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               var2 = this.I$0;
               ResultKt.throwOnFailure(var1);
               int var3 = var2 + 1;
               String[] var5 = this.$texts;
               var2 = var3;
               if (var3 >= var5.length) {
                  if (var5.length > 1) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }
               }
            } else {
               ResultKt.throwOnFailure(var1);
               var2 = 0;
            }

            while(true) {
               this.this$0.pageIndex.postValue(Boxing.boxInt(var2));
               Continuation var6 = (Continuation)this;
               this.I$0 = var2;
               this.label = 1;
               if (DelayKt.delay(5000L, var6) == var4) {
                  return var4;
               }

               int var10 = var2 + 1;
               String[] var7 = this.$texts;
               var2 = var10;
               if (var10 >= var7.length) {
                  if (var7.length > 1) {
                     var2 = 1;
                  } else {
                     var2 = 0;
                  }
               }
            }
         }
      }, 3, (Object)null);
      List var36 = (List)(new ArrayList());
      var36.add(BuildersKt.async$default(var33, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final FinalizeDialog this$0;

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
               FinalizeViewModel var5 = this.this$0.getViewModel();
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.setPushToken(var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null));
      if (((CharSequence)var14).length() > 0) {
         var36.add(BuildersKt.async$default(var33, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var14, var23, (Continuation)null) {
            final String $deviceId;
            final String $deviceName;
            int label;
            final FinalizeDialog this$0;

            {
               this.this$0 = var1;
               this.$deviceId = var2;
               this.$deviceName = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceId, this.$deviceName, var2));
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
                  FinalizeViewModel var7 = this.this$0.getViewModel();
                  String var5 = this.$deviceId;
                  String var6 = this.$deviceName;
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var7.commitDeviceName(var5, var6, var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null));
         var36.add(BuildersKt.async$default(var33, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var14, (Continuation)null) {
            final String $deviceId;
            int label;
            final FinalizeDialog this$0;

            {
               this.this$0 = var1;
               this.$deviceId = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceId, var2));
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
                  FinalizeViewModel var7 = this.this$0.getViewModel();
                  String var5 = this.$deviceId;
                  TimeZone var6 = TimeZone.getDefault();
                  Intrinsics.checkNotNullExpressionValue(var6, "getDefault(...)");
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var7.commitDeviceTimezone(var5, var6, var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null));
         var36.add(BuildersKt.async$default(var33, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var14, (Continuation)null) {
            final String $deviceId;
            int label;
            final FinalizeDialog this$0;

            {
               this.this$0 = var1;
               this.$deviceId = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceId, var2));
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
                  FinalizeViewModel var6 = this.this$0.getViewModel();
                  String var5 = this.$deviceId;
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var6.ensureInitialOnline(var5, var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null));
      }

      BuildersKt.launch$default(var33, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var36, this, var14, (Continuation)null) {
         final String $deviceId;
         final List $jobs;
         Object L$0;
         int label;
         final FinalizeDialog this$0;

         {
            this.$jobs = var1;
            this.this$0 = var2;
            this.$deviceId = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$jobs, this.this$0, this.$deviceId, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5;
            Throwable var10000;
            label437: {
               var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 == 2 || var2 == 3) {
                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     if (var2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     Throwable var3 = (Throwable)this.L$0;
                     ResultKt.throwOnFailure(var1);
                     var27 = var3;
                     throw var27;
                  }

                  try {
                     ResultKt.throwOnFailure(var1);
                  } catch (Throwable var26) {
                     var10000 = var26;
                     boolean var10001 = false;
                     break label437;
                  }
               } else {
                  ResultKt.throwOnFailure(var1);

                  try {
                     Collection var28 = (Collection)this.$jobs;
                     Continuation var34 = (Continuation)this;
                     this.label = 1;
                     if (AwaitKt.awaitAll(var28, var34) == var5) {
                        return var5;
                     }
                  } catch (Throwable var25) {
                     var10000 = var25;
                     boolean var46 = false;
                     break label437;
                  }
               }

               try {
                  this.this$0.getViewModel().notifyAnalytics();
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var47 = false;
                  break label437;
               }

               this.this$0.getViewModel().resubscribeMqttRt5s(this.$deviceId);
               Job var40 = this.this$0.onboardingJob;
               Job var32 = var40;
               if (var40 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("onboardingJob");
                  var32 = null;
               }

               kotlinx.coroutines.Job.DefaultImpls.cancel$default(var32, (CancellationException)null, 1, (Object)null);
               CoroutineContext var41 = (CoroutineContext)Dispatchers.getMain();
               Function2 var33 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final FinalizeDialog this$0;

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
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        ConstraintSet var4 = new ConstraintSet();
                        DialogOnboardingFinalizeBinding var3 = this.this$0.binding;
                        Object var2 = null;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var4.clone(var1.clRoot);
                        var3 = this.this$0.binding;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var4.setVerticalBias(var1.icon.getId(), 0.64F);
                        var3 = this.this$0.binding;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var4.applyTo(var1.clRoot);
                        var3 = this.this$0.binding;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        Group var9 = var1.groupSuccess;
                        Intrinsics.checkNotNullExpressionValue(var9, "groupSuccess");
                        ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
                        var3 = this.this$0.binding;
                        DialogOnboardingFinalizeBinding var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.icon.cancelAnimation();
                        var3 = this.this$0.binding;
                        var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.icon.setImageResource(R.drawable.ic_success_contained);
                        var3 = this.this$0.binding;
                        var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.title.setText(R.string.onboarding_finalize_device_added);
                        var3 = this.this$0.binding;
                        var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.text.setText(R.string.onboarding_finalize_success_msg);
                        var10 = this.this$0.binding;
                        if (var10 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = (DialogOnboardingFinalizeBinding)var2;
                        }

                        var10.progressIndicator.setProgress(6);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var45 = (Continuation)this;
               this.label = 2;
               if (BuildersKt.withContext(var41, var33, var45) != var5) {
                  return Unit.INSTANCE;
               }

               return var5;
            }

            Throwable var29 = var10000;

            try {
               Timber.Forest var37 = Timber.Forest;
               StringBuilder var43 = new StringBuilder("exception happens when doing finalize: ");
               var43.append(var29.getMessage());
               var37.e(var29, var43.toString(), new Object[0]);
            } catch (Throwable var23) {
               var27 = var23;
               this.this$0.getViewModel().resubscribeMqttRt5s(this.$deviceId);
               Job var4 = this.this$0.onboardingJob;
               Job var35 = var4;
               if (var4 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("onboardingJob");
                  var35 = null;
               }

               kotlinx.coroutines.Job.DefaultImpls.cancel$default(var35, (CancellationException)null, 1, (Object)null);
               CoroutineContext var42 = (CoroutineContext)Dispatchers.getMain();
               Function2 var36 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final FinalizeDialog this$0;

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
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        ConstraintSet var4 = new ConstraintSet();
                        DialogOnboardingFinalizeBinding var3 = this.this$0.binding;
                        Object var2 = null;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var4.clone(var1.clRoot);
                        var3 = this.this$0.binding;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var4.setVerticalBias(var1.icon.getId(), 0.64F);
                        var3 = this.this$0.binding;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var4.applyTo(var1.clRoot);
                        var3 = this.this$0.binding;
                        var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        Group var9 = var1.groupSuccess;
                        Intrinsics.checkNotNullExpressionValue(var9, "groupSuccess");
                        ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
                        var3 = this.this$0.binding;
                        DialogOnboardingFinalizeBinding var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.icon.cancelAnimation();
                        var3 = this.this$0.binding;
                        var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.icon.setImageResource(R.drawable.ic_success_contained);
                        var3 = this.this$0.binding;
                        var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.title.setText(R.string.onboarding_finalize_device_added);
                        var3 = this.this$0.binding;
                        var10 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = null;
                        }

                        var10.text.setText(R.string.onboarding_finalize_success_msg);
                        var10 = this.this$0.binding;
                        if (var10 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var10 = (DialogOnboardingFinalizeBinding)var2;
                        }

                        var10.progressIndicator.setProgress(6);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var6 = (Continuation)this;
               this.L$0 = var23;
               this.label = 4;
               if (BuildersKt.withContext(var42, var36, var6) == var5) {
                  return var5;
               }

               throw var27;
            }

            this.this$0.getViewModel().resubscribeMqttRt5s(this.$deviceId);
            Job var38 = this.this$0.onboardingJob;
            Job var30 = var38;
            if (var38 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("onboardingJob");
               var30 = null;
            }

            kotlinx.coroutines.Job.DefaultImpls.cancel$default(var30, (CancellationException)null, 1, (Object)null);
            CoroutineContext var39 = (CoroutineContext)Dispatchers.getMain();
            Function2 var44 = new Function2(this.this$0, (Continuation)null) {
               int label;
               final FinalizeDialog this$0;

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
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     ConstraintSet var4 = new ConstraintSet();
                     DialogOnboardingFinalizeBinding var3 = this.this$0.binding;
                     Object var2 = null;
                     var1 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var1 = null;
                     }

                     var4.clone(var1.clRoot);
                     var3 = this.this$0.binding;
                     var1 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var1 = null;
                     }

                     var4.setVerticalBias(var1.icon.getId(), 0.64F);
                     var3 = this.this$0.binding;
                     var1 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var1 = null;
                     }

                     var4.applyTo(var1.clRoot);
                     var3 = this.this$0.binding;
                     var1 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var1 = null;
                     }

                     Group var9 = var1.groupSuccess;
                     Intrinsics.checkNotNullExpressionValue(var9, "groupSuccess");
                     ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
                     var3 = this.this$0.binding;
                     DialogOnboardingFinalizeBinding var10 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = null;
                     }

                     var10.icon.cancelAnimation();
                     var3 = this.this$0.binding;
                     var10 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = null;
                     }

                     var10.icon.setImageResource(R.drawable.ic_success_contained);
                     var3 = this.this$0.binding;
                     var10 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = null;
                     }

                     var10.title.setText(R.string.onboarding_finalize_device_added);
                     var3 = this.this$0.binding;
                     var10 = var3;
                     if (var3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = null;
                     }

                     var10.text.setText(R.string.onboarding_finalize_success_msg);
                     var10 = this.this$0.binding;
                     if (var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = (DialogOnboardingFinalizeBinding)var2;
                     }

                     var10.progressIndicator.setProgress(6);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var31 = (Continuation)this;
            this.label = 3;
            if (BuildersKt.withContext(var39, var44, var31) != var5) {
               return Unit.INSTANCE;
            } else {
               return var5;
            }
         }
      }, 2, (Object)null);
      var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (DialogOnboardingFinalizeBinding)var6;
      }

      AbsorbInsetFrameLayout var16 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var16, "getRoot(...)");
      return (View)var16;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -1);
         }
      }

      var1 = this.getDialog();
      if (var1 != null) {
         var1.setOnKeyListener(new FinalizeDialog$$ExternalSyntheticLambda6(this));
      }

      DialogUtils.INSTANCE.immersiveStatusBar(this.getDialog(), true, true);
   }

   public void setViewModel(FinalizeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/adddevice/dialog/FinalizeDialog$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ACTION_CHOOSE_DEVICE", "newInstance", "Lcom/blueair/adddevice/dialog/FinalizeDialog;", "deviceId", "deviceName", "bluetoothDevice", "Lcom/blueair/core/model/BluetoothDevice;", "adddevice_otherRelease"},
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

      public final FinalizeDialog newInstance(String var1, String var2, BluetoothDevice var3) {
         Intrinsics.checkNotNullParameter(var1, "deviceId");
         Intrinsics.checkNotNullParameter(var2, "deviceName");
         Intrinsics.checkNotNullParameter(var3, "bluetoothDevice");
         FinalizeDialog var4 = new FinalizeDialog();
         var4.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("deviceId", var1), TuplesKt.to("deviceName", var2), TuplesKt.to("bluetoothDevice", var3)}));
         return var4;
      }
   }
}
