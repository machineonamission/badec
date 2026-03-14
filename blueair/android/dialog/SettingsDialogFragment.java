package com.blueair.android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.databinding.DialogfragmentSettingsBinding;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.push.NotificationService;
import com.blueair.sdk.GoogleOssSdk;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020.H\u0016J\b\u00102\u001a\u00020.H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"},
   d2 = {"Lcom/blueair/android/dialog/SettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "Lkotlin/Lazy;", "viewDataBinding", "Lcom/blueair/android/databinding/DialogfragmentSettingsBinding;", "getViewDataBinding", "()Lcom/blueair/android/databinding/DialogfragmentSettingsBinding;", "setViewDataBinding", "(Lcom/blueair/android/databinding/DialogfragmentSettingsBinding;)V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "firstResume", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupAccessibility", "", "showProgress", "shouldShowProgress", "onStart", "onPause", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SettingsDialogFragment extends BaseDialogFragment implements ProgressFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(SettingsDialogFragment.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0)))};
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private boolean firstResume;
   private final Lazy notificationService$delegate;
   private ProgressBlockerView progressBlockerView;
   private final String screenName = "side_menu_settings";
   public DialogfragmentSettingsBinding viewDataBinding;
   public HomeViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$Sv0WGiRUVv7BOlL9UAXHEZ7xtAA(SettingsDialogFragment var0, View var1) {
      onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$VR2OBWqagfEsX1_Zkjd2E7kUpgs(SettingsDialogFragment var0, View var1) {
      onCreateView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_OxdqYa0dDLMyo_jKpp7rRAYVuU(SettingsDialogFragment var0, View var1) {
      onCreateView$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ww9mhfQ2nGTl3OXmjgh11XE4gEw(SettingsDialogFragment var0, View var1) {
      onCreateView$lambda$5(var0, var1);
   }

   public SettingsDialogFragment() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.notificationService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, NotificationService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.firstResume = true;
   }

   private final NotificationService getNotificationService() {
      return (NotificationService)this.notificationService$delegate.getValue();
   }

   private static final void onCreateView$lambda$3(SettingsDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("NotificationCenterDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("NotificationCenterDialogFragment") instanceof NotificationCenterDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)NotificationCenterDialogFragment.Companion.newInstance()).show(var2, "NotificationCenterDialogFragment");
      }

   }

   private static final void onCreateView$lambda$4(SettingsDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$5(SettingsDialogFragment var0, View var1) {
      var0.getViewModel().toggleIsTempCelsius();
   }

   private static final void onCreateView$lambda$6(SettingsDialogFragment var0, View var1) {
      GoogleOssSdk var3 = GoogleOssSdk.INSTANCE;
      Context var2 = var0.requireContext();
      Intrinsics.checkNotNullExpressionValue(var2, "requireContext(...)");
      var3.startOssLicensesMenuActivity(var2);
   }

   private static final void onCreateView$setNotificationCenterVisibility(SettingsDialogFragment var0, boolean var1) {
      LinearLayout var4 = var0.getViewDataBinding().itemNotification;
      Intrinsics.checkNotNullExpressionValue(var4, "itemNotification");
      View var7 = (View)var4;
      byte var3 = 0;
      byte var2;
      if (var1) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var7.setVisibility(var2);
      View var5 = var0.getViewDataBinding().notificationSeparator;
      Intrinsics.checkNotNullExpressionValue(var5, "notificationSeparator");
      if (var1) {
         var2 = var3;
      } else {
         var2 = 8;
      }

      var5.setVisibility(var2);
   }

   private final void setupAccessibility() {
      this.getViewDataBinding().itemTempSetting.setAccessibilityDelegate(new View.AccessibilityDelegate() {
         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            var2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, (CharSequence)var1.getResources().getString(R.string.temperature_scale_click_description)));
         }
      });
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      ConstraintLayout var1 = this.getViewDataBinding().rootLayout;
      Intrinsics.checkNotNullExpressionValue(var1, "rootLayout");
      return var1;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public final DialogfragmentSettingsBinding getViewDataBinding() {
      DialogfragmentSettingsBinding var1 = this.viewDataBinding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         return null;
      }
   }

   public HomeViewModel getViewModel() {
      HomeViewModel var1 = this.viewModel;
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var7 = this.getDialog();
      if (var7 != null) {
         Window var8 = var7.getWindow();
         if (var8 != null) {
            var8.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var8.setWindowAnimations(R.style.dialog_animation);
            var8.setGravity(80);
         }
      }

      FragmentActivity var9 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var9, "requireActivity(...)");
      HomeViewModel var10 = (HomeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var9)).get(HomeViewModel.class));
      this.setViewModel(var10);
      DialogfragmentSettingsBinding var4 = DialogfragmentSettingsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      var4.setHomeViewModel(var10);
      var4.setLifecycleOwner((LifecycleOwner)this.requireActivity());
      this.setViewDataBinding(var4);
      this.getViewModel().getTemperatureSettings();
      if (this.getNotificationService().getEnabled()) {
         LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this).launchWhenResumed(new Function2(this, (Continuation)null) {
            private Object L$0;
            int label;
            final SettingsDialogFragment this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               CoroutineScope var2 = (CoroutineScope)this.L$0;
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  FlowKt.launchIn(FlowKt.onEach((Flow)this.this$0.getViewModel().isUserSignedIn(), new Function2(this.this$0, (Continuation)null) {
                     boolean Z$0;
                     int label;
                     final SettingsDialogFragment this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                        var3.Z$0 = (Boolean)var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(boolean var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        boolean var2 = this.Z$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           SettingsDialogFragment.onCreateView$setNotificationCenterVisibility(this.this$0, var2);
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  }), var2);
                  return Unit.INSTANCE;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         });
         this.getViewDataBinding().itemNotification.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda0(this));
      } else {
         onCreateView$setNotificationCenterVisibility(this, false);
      }

      this.getViewDataBinding().closeBtn.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda1(this));
      this.getViewDataBinding().itemTempSetting.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda2(this));
      LinearLayout var5 = this.getViewDataBinding().itemLicense;
      Intrinsics.checkNotNullExpressionValue(var5, "itemLicense");
      ViewExtensionsKt.hide((View)var5);
      this.getViewDataBinding().itemLicense.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda3(this));
      this.setupAccessibility();
      View var6 = this.getViewDataBinding().getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return var6;
   }

   public void onPause() {
      super.onPause();
      this.firstResume = false;
      this.hideProgress(this.getContext());
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

   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public final void setViewDataBinding(DialogfragmentSettingsBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewDataBinding = var1;
   }

   public void setViewModel(HomeViewModel var1) {
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
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/android/dialog/SettingsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/dialog/SettingsDialogFragment;", "app_otherRelease"},
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

      public final SettingsDialogFragment newInstance() {
         return new SettingsDialogFragment();
      }
   }
}
