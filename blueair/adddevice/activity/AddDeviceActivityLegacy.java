package com.blueair.adddevice.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionSet;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.ActivityAddDeviceLegacyBinding;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigProgressFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigurationFailedStepOne;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoConfigurationFailedStepTwo;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoStepOneFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceAutoStepTwoFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceConfigureNetworkFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualConfigProgressFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualConfigurationFailed;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualStepOneFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualStepTwoFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceManualUserValidateFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceMigrationOtaFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceResetDeviceFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSelectModelFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSetNameFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSetupTextFragment;
import com.blueair.adddevice.fragment.legacy.AddDeviceSuccessFragment;
import com.blueair.adddevice.fragment.legacy.ClassicTroubleShootingFragment;
import com.blueair.adddevice.fragment.legacy.IcpAddDeviceFragment;
import com.blueair.adddevice.fragment.legacy.IcpPairDeviceFragment;
import com.blueair.adddevice.fragment.legacy.IcpSaveDeviceFragment;
import com.blueair.adddevice.fragment.legacy.IcpSetupDeviceFragment;
import com.blueair.adddevice.model.AddDeviceState;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.extensions.ToolbarExtensionsKt;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0015J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\b\u0010?\u001a\u000209H\u0014J\b\u0010@\u001a\u000209H\u0014J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020;H\u0014J\b\u0010C\u001a\u000209H\u0017J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000209H\u0002J\u0006\u0010I\u001a\u000209J\u0006\u0010J\u001a\u000209J\u000e\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020\u0019J\u000e\u0010M\u001a\u0002092\u0006\u0010N\u001a\u00020\u0019J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020SH\u0002J\u0018\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020PH\u0002J\u0012\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u00020EH\u0002J\b\u0010Z\u001a\u000209H\u0002J\b\u0010[\u001a\u00020EH\u0002J+\u0010\\\u001a\u0002092\u0006\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050`2\u0006\u0010a\u001a\u00020bH\u0016¢\u0006\u0002\u0010cR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\r\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\r\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"},
   d2 = {"Lcom/blueair/adddevice/activity/AddDeviceActivityLegacy;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "addDeviceService", "Lcom/blueair/adddevice/service/AddDeviceService;", "getAddDeviceService", "()Lcom/blueair/adddevice/service/AddDeviceService;", "addDeviceService$delegate", "Lkotlin/Lazy;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "currentScreen", "Lcom/blueair/adddevice/utils/AddDeviceUtils$AddDeviceScreen;", "asyncSubs", "Lio/reactivex/disposables/CompositeDisposable;", "binding", "Lcom/blueair/adddevice/databinding/ActivityAddDeviceLegacyBinding;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar$delegate", "addDeviceAppbar", "Lcom/google/android/material/appbar/AppBarLayout;", "getAddDeviceAppbar", "()Lcom/google/android/material/appbar/AppBarLayout;", "addDeviceAppbar$delegate", "layoutExpandedToolbar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutExpandedToolbar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "layoutExpandedToolbar$delegate", "collapsingToolbar", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbar", "()Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "collapsingToolbar$delegate", "btnClose", "Landroidx/appcompat/widget/AppCompatImageButton;", "getBtnClose", "()Landroidx/appcompat/widget/AppCompatImageButton;", "btnClose$delegate", "oldScreen", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "enableBackgroundAnimation", "disableBackgroundAnimation", "setBackgroundImage", "onResumeFragments", "onPause", "onSaveInstanceState", "outState", "onBackPressed", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCloseClick", "updateBackAllowedUi", "handleBack", "goBackToScreen", "targetScreen", "goForwardToScreen", "nextScreen", "animationTransaction", "Landroidx/fragment/app/FragmentTransaction;", "transaction", "nextFragment", "Landroidx/fragment/app/Fragment;", "recursivelyAddSharedTransitions", "parent", "Landroid/view/ViewGroup;", "fragmentTransaction", "expandToolbar", "shouldExpandToolbar", "finishAddDevice", "canWriteMarshmallowSettings", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceActivityLegacy extends BaseActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceActivityLegacy.class, "addDeviceService", "getAddDeviceService()Lcom/blueair/adddevice/service/AddDeviceService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceActivityLegacy.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceActivityLegacy.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String PARAM_DEVICE_COMPATIBILITY = "PARAM_DEVICE_COMPATIBILITY";
   public static final String PARAM_SELECTED_DEVICE = "SELECTED_DEVICE";
   private static final int REQUEST_LOCATION_PERMISSION = 104;
   private static final int REQUEST_NETWORK_AND_BASIC_LOCATION_PERMISSIONS = 105;
   private static final int REQUEST_NETWORK_PERMISSIONS = 101;
   private static final String STATE_KEY = "state_key";
   private static final int WRITE_PERMISSION_REQUEST = 103;
   private final Lazy addDeviceAppbar$delegate;
   private final Lazy addDeviceService$delegate;
   private final CompositeDisposable asyncSubs;
   private ActivityAddDeviceLegacyBinding binding;
   private final Lazy btnClose$delegate;
   private final Lazy collapsingToolbar$delegate;
   private AddDeviceUtils.AddDeviceScreen currentScreen;
   private final Lazy deviceManager$delegate;
   private final Lazy layoutExpandedToolbar$delegate;
   private AddDeviceUtils.AddDeviceScreen oldScreen;
   private final Lazy prefs$delegate;
   private final String screenName = "add_device_legacy";
   private final Lazy toolbar$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$EiQ944H0f7e6NbYkkWlRx450XAo(AddDeviceActivityLegacy var0, String var1) {
      return onResumeFragments$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$GhoGxuaJ1q9fuvy95vFBfl8m_Xg/* $FF was: $r8$lambda$GhoGxuaJ1q9fuvy95vFBfl8m-Xg*/(AddDeviceActivityLegacy var0, View var1) {
      onCreate$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static ConstraintLayout $r8$lambda$QW_O9JKXc56FJ9hbE260OjW2BJA/* $FF was: $r8$lambda$QW-O9JKXc56FJ9hbE260OjW2BJA*/(AddDeviceActivityLegacy var0) {
      return layoutExpandedToolbar_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static CollapsingToolbarLayout $r8$lambda$VlMCTxR34QK5kCTr_77DiVhH7D4/* $FF was: $r8$lambda$VlMCTxR34QK5kCTr-77DiVhH7D4*/(AddDeviceActivityLegacy var0) {
      return collapsingToolbar_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static AppBarLayout $r8$lambda$WjPoHZVAD4uEm2lWPyJso_yhO6s(AddDeviceActivityLegacy var0) {
      return addDeviceAppbar_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_fTRT0o__0dY9g_GX27T4aYkDpE/* $FF was: $r8$lambda$_fTRT0o--0dY9g-GX27T4aYkDpE*/(AddDeviceActivityLegacy var0, AddDeviceState var1) {
      return onResumeFragments$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static AppCompatImageButton $r8$lambda$hG_xDjeStDyZRarEMecgIuJxz5w(AddDeviceActivityLegacy var0) {
      return btnClose_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$h_AGqEiFmrb7kNMvy9xwZY268_0/* $FF was: $r8$lambda$h_AGqEiFmrb7kNMvy9xwZY268-0*/(AddDeviceActivityLegacy var0, View var1) {
      onCreate$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tGzWmXCoI5_NWPOEaFT7RPKNX_U/* $FF was: $r8$lambda$tGzWmXCoI5-NWPOEaFT7RPKNX-U*/(AddDeviceActivityLegacy var0, AddDeviceUtils.AddDeviceScreen var1) {
      return onResumeFragments$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Toolbar $r8$lambda$u23gI_kCFFtXAX8i3XR8EFU_l70/* $FF was: $r8$lambda$u23gI-kCFFtXAX8i3XR8EFU-l70*/(AddDeviceActivityLegacy var0) {
      return toolbar_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$z1BqeKII_0DKQxaV6Hb8cclHuoQ(AddDeviceActivityLegacy var0, AddDeviceUtils.AddDeviceScreen var1) {
      return onResumeFragments$lambda$9(var0, var1);
   }

   public AddDeviceActivityLegacy() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AddDeviceService.class)), (Object)null);
      KProperty[] var4 = $$delegatedProperties;
      this.addDeviceService$delegate = var3.provideDelegate(this, var4[0]);
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var4[1]);
      var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceManager$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, DeviceManager.class)), (Object)null).provideDelegate(this, var4[2]);
      this.currentScreen = AddDeviceUtils.AddDeviceScreen.NONE;
      this.asyncSubs = new CompositeDisposable();
      this.toolbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda0(this));
      this.addDeviceAppbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda2(this));
      this.layoutExpandedToolbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda3(this));
      this.collapsingToolbar$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda4(this));
      this.btnClose$delegate = LazyKt.lazy(new AddDeviceActivityLegacy$$ExternalSyntheticLambda5(this));
      this.oldScreen = AddDeviceUtils.AddDeviceScreen.NONE;
   }

   private static final AppBarLayout addDeviceAppbar_delegate$lambda$1(AddDeviceActivityLegacy var0) {
      return (AppBarLayout)var0.findViewById(R.id.add_device_appbar);
   }

   private final FragmentTransaction animationTransaction(FragmentTransaction var1, Fragment var2) {
      if (this.getSupportFragmentManager().getBackStackEntryCount() - 1 < 0) {
         return var1;
      } else {
         TransitionSet var3 = new TransitionSet();
         Transition var4 = TransitionInflater.from((Context)this).inflateTransition(17760257);
         if (var4 != null) {
            var3.addTransition(var4);
         }

         var3.setDuration(250L);
         var2.setSharedElementEnterTransition(var3);
         var2.setSharedElementReturnTransition(var3);
         ActivityAddDeviceLegacyBinding var7 = this.binding;
         ActivityAddDeviceLegacyBinding var5 = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         FrameLayout var6 = var5.contentFragment;
         Intrinsics.checkNotNullExpressionValue(var6, "contentFragment");
         this.recursivelyAddSharedTransitions((ViewGroup)var6, var1);
         return var1;
      }
   }

   private static final AppCompatImageButton btnClose_delegate$lambda$4(AddDeviceActivityLegacy var0) {
      return (AppCompatImageButton)var0.findViewById(R.id.btnClose);
   }

   private final boolean canWriteMarshmallowSettings() {
      return VERSION.SDK_INT == 23 ? System.canWrite((Context)this) : false;
   }

   private static final CollapsingToolbarLayout collapsingToolbar_delegate$lambda$3(AddDeviceActivityLegacy var0) {
      return (CollapsingToolbarLayout)var0.findViewById(R.id.collapsing_toolbar);
   }

   private final void disableBackgroundAnimation() {
      ActivityAddDeviceLegacyBinding var2 = this.binding;
      ActivityAddDeviceLegacyBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      Drawable var3 = var1.layoutAddDeviceCoordinator.getBackground();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      ((AnimationDrawable)var3).stop();
      Timber.Forest.d("执行disableBackgroundAnimation", new Object[0]);
   }

   private final void enableBackgroundAnimation() {
      ActivityAddDeviceLegacyBinding var2 = this.binding;
      ActivityAddDeviceLegacyBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      Drawable var3 = var1.layoutAddDeviceCoordinator.getBackground();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AnimationDrawable var4 = (AnimationDrawable)var3;
      if (!var4.isRunning()) {
         var4.setEnterFadeDuration(3000);
         var4.setExitFadeDuration(3000);
      }

      var4.setOneShot(false);
      var4.start();
   }

   private final void expandToolbar(boolean var1) {
      Object var4 = null;
      AppBarLayout.LayoutParams var3 = null;
      if (var1) {
         this.getToolbar().setTitle((CharSequence)"");
         ActionBar var8 = this.getSupportActionBar();
         if (var8 != null) {
            var8.setHomeAsUpIndicator(com.blueair.viewcore.R.drawable.ic_close);
         }

         this.getLayoutExpandedToolbar().setVisibility(0);
         this.getBtnClose().setImageResource(com.blueair.viewcore.R.drawable.ic_close_outlined_primary);
         this.getCollapsingToolbar().setContentScrimColor(-1);
         this.setStatusBarColor(-1, true);
         ViewGroup.LayoutParams var9 = this.getCollapsingToolbar().getLayoutParams();
         if (var9 instanceof AppBarLayout.LayoutParams) {
            var3 = (AppBarLayout.LayoutParams)var9;
         }

         if (var3 != null) {
            var3.setScrollFlags(0);
         }
      } else {
         this.getToolbar().setTitle(com.blueair.viewcore.R.string.add_device);
         ActionBar var6 = this.getSupportActionBar();
         if (var6 != null) {
            var6.setHomeAsUpIndicator(com.blueair.viewcore.R.drawable.ic_arrow_back_white);
         }

         ToolbarExtensionsKt.changeToolbarFont(this.getToolbar(), (Context)this, com.blueair.viewcore.R.font.gilroy_bold);
         int var2 = this.getColor(com.blueair.viewcore.R.color.colorPrimary);
         this.getBtnClose().setImageResource(com.blueair.viewcore.R.drawable.ic_close);
         this.getCollapsingToolbar().setContentScrimColor(0);
         this.setStatusBarColor(var2, false);
         this.getLayoutExpandedToolbar().setVisibility(4);
         ViewGroup.LayoutParams var5 = this.getCollapsingToolbar().getLayoutParams();
         AppBarLayout.LayoutParams var7 = (AppBarLayout.LayoutParams)var4;
         if (var5 instanceof AppBarLayout.LayoutParams) {
            var7 = (AppBarLayout.LayoutParams)var5;
         }

         if (var7 != null) {
            var7.setScrollFlags(3);
         }
      }

      this.getAddDeviceAppbar().setExpanded(var1);
   }

   // $FF: synthetic method
   static void expandToolbar$default(AddDeviceActivityLegacy var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.expandToolbar(var1);
   }

   private final void finishAddDevice() {
      DeviceInformationLegacy var2 = this.getAddDeviceService().getState().getDeviceInfo();
      Bundle var1 = new Bundle();
      if (var2 != null) {
         var1.putString("SELECTED_DEVICE", var2.getId());
         var1.putString("PARAM_DEVICE_COMPATIBILITY", var2.getCompatibility());
      }

      Intent var3 = new Intent();
      var3.putExtras(var1);
      this.setResult(-1, var3);
      this.finish();
      this.startActivity(Actions.INSTANCE.openHomeIntent((Context)this));
   }

   private final AppBarLayout getAddDeviceAppbar() {
      Object var1 = this.addDeviceAppbar$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (AppBarLayout)var1;
   }

   private final AddDeviceService getAddDeviceService() {
      return (AddDeviceService)this.addDeviceService$delegate.getValue();
   }

   private final AppCompatImageButton getBtnClose() {
      Object var1 = this.btnClose$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (AppCompatImageButton)var1;
   }

   private final CollapsingToolbarLayout getCollapsingToolbar() {
      Object var1 = this.collapsingToolbar$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (CollapsingToolbarLayout)var1;
   }

   private final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
   }

   private final ConstraintLayout getLayoutExpandedToolbar() {
      Object var1 = this.layoutExpandedToolbar$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (ConstraintLayout)var1;
   }

   private final UnsecurePrefs getPrefs() {
      return (UnsecurePrefs)this.prefs$delegate.getValue();
   }

   private final Toolbar getToolbar() {
      Object var1 = this.toolbar$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Toolbar)var1;
   }

   private static final ConstraintLayout layoutExpandedToolbar_delegate$lambda$2(AddDeviceActivityLegacy var0) {
      return (ConstraintLayout)var0.findViewById(R.id.layout_expanded_toolbar);
   }

   private final void onCloseClick() {
      this.getAddDeviceService().setWifiPassword("");
      Prefs var1 = this.getPrefs();
      Object var2 = PreferencesHelper.INSTANCE.get(var1.getBackend(), "KEY_LEGACY_DEVICE_TO_DELETE", (Object)null, Reflection.getOrCreateKotlinClass(String.class));
      if (((CharSequence)((String)var2)).length() <= 0) {
         var2 = null;
      }

      String var3 = (String)var2;
      if (var3 != null) {
         BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var3, (Continuation)null) {
            final String $it;
            int label;
            final AddDeviceActivityLegacy this$0;

            {
               this.this$0 = var1;
               this.$it = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var2));
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
                  DeviceManager var4 = this.this$0.getDeviceManager();
                  String var5 = this.$it;
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (var4.removeAblDeviceRemote(var5, var6) == var3) {
                     return var3;
                  }
               }

               this.this$0.getPrefs().remove("KEY_LEGACY_DEVICE_TO_DELETE");
               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

      if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE) {
         this.finish();
      } else {
         this.goBackToScreen(AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE);
         this.getAddDeviceService().initState((AddDeviceState)null);
      }
   }

   private static final void onCreate$lambda$5(AddDeviceActivityLegacy var0, View var1) {
      var0.onCloseClick();
   }

   private static final void onCreate$lambda$6(AddDeviceActivityLegacy var0, View var1) {
      var0.onCloseClick();
   }

   private static final Unit onResumeFragments$lambda$10(AddDeviceActivityLegacy var0, AddDeviceState var1) {
      var0.finishAddDevice();
      return Unit.INSTANCE;
   }

   private static final Unit onResumeFragments$lambda$7(AddDeviceActivityLegacy var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "msg");
      ViewUtils.INSTANCE.showSnackbar((Activity)var0, var1, ViewUtils.MessageType.ERROR.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onResumeFragments$lambda$8(AddDeviceActivityLegacy var0, AddDeviceUtils.AddDeviceScreen var1) {
      Intrinsics.checkNotNullParameter(var1, "nextScreen");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("screenChangeObserver success, next screen = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      var0.goForwardToScreen(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResumeFragments$lambda$9(AddDeviceActivityLegacy var0, AddDeviceUtils.AddDeviceScreen var1) {
      Intrinsics.checkNotNullParameter(var1, "screen");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("screenRevertObserver success, screen = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      var0.goBackToScreen(var1);
      return Unit.INSTANCE;
   }

   private final void recursivelyAddSharedTransitions(ViewGroup var1, FragmentTransaction var2) {
      int var4 = var1.getChildCount();

      for(int var3 = 0; var3 < var4; ++var3) {
         View var5 = var1.getChildAt(var3);
         if (var5 instanceof ViewGroup) {
            this.recursivelyAddSharedTransitions((ViewGroup)var5, var2);
         } else if (var5 != null) {
            CharSequence var6 = (CharSequence)var5.getTransitionName();
            if (var6 != null && var6.length() != 0) {
               try {
                  Intrinsics.checkNotNull(var2.addSharedElement(var5, var5.getTransitionName()));
               } catch (IllegalArgumentException var9) {
                  Timber.Forest var10 = Timber.Forest;
                  Throwable var7 = (Throwable)var9;
                  StringBuilder var8 = new StringBuilder("There is more than one element in this screen with the same transitionName of ");
                  var8.append(var5.getTransitionName());
                  var10.w(var7, var8.toString(), new Object[0]);
               }
            }
         }
      }

   }

   private final void setBackgroundImage() {
      this.getPrefs().remove("KEY_LEGACY_DEVICE_TO_DELETE");
      ViewExtensionsKt.hide((View)this.getToolbar());
      ActivityAddDeviceLegacyBinding var2 = this.binding;
      ActivityAddDeviceLegacyBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.layoutAddDeviceCoordinator.setBackground(this.getDrawable(R.drawable.background_indoor_success_layered));
   }

   private static final Toolbar toolbar_delegate$lambda$0(AddDeviceActivityLegacy var0) {
      Toolbar var1 = (Toolbar)var0.findViewById(R.id.add_device_toolbar);
      var1.setTitleTextColor(-1);
      return var1;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public final void goBackToScreen(AddDeviceUtils.AddDeviceScreen var1) {
      Intrinsics.checkNotNullParameter(var1, "targetScreen");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("goBackToScreen: targetScreen = ");
      var4.append(var1);
      var4.append(", currentScreen = ");
      var4.append(this.currentScreen);
      var3.d(var4.toString(), new Object[0]);
      if (this.currentScreen != var1) {
         if (AddDeviceActivityLegacy.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 1) {
            expandToolbar$default(this, false, 1, (Object)null);
         } else {
            this.expandToolbar(false);
         }

         if (!AddDeviceUtils.INSTANCE.screenAllowsBack(var1)) {
            this.getToolbar().setTitle((CharSequence)"");
         }

         int var2 = AddDeviceActivityLegacy.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 2 && var2 != 3) {
            this.disableBackgroundAnimation();
         } else {
            this.enableBackgroundAnimation();
         }

         var3 = Timber.Forest;
         var4 = new StringBuilder("goBackToScreen: stack name = ");
         var4.append(var1);
         var3.d(var4.toString(), new Object[0]);
         this.getSupportFragmentManager().popBackStack(var1.toString(), 1);
         this.currentScreen = var1;
         this.invalidateOptionsMenu();
         this.updateBackAllowedUi();
      }
   }

   public final void goForwardToScreen(AddDeviceUtils.AddDeviceScreen var1) {
      Intrinsics.checkNotNullParameter(var1, "nextScreen");
      this.oldScreen = this.currentScreen;
      Timber.Forest var8 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("goForwardToScreen: nextScreen = ");
      var7.append(var1);
      var7.append(", currentScreen = ");
      var7.append(this.currentScreen);
      var8.d(var7.toString(), new Object[0]);
      if (this.currentScreen != var1) {
         AddDeviceState var16 = this.getAddDeviceService().getState();
         int var2 = AddDeviceActivityLegacy.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         Object var19 = null;
         Fragment var17;
         switch (var2) {
            case 1:
               var17 = AddDeviceSelectModelFragment.Companion.newInstance();
               break;
            case 2:
               var17 = AddDeviceSetupTextFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 3:
               var17 = IcpAddDeviceFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 4:
               var17 = IcpSetupDeviceFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 5:
               var17 = IcpPairDeviceFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 6:
               var17 = IcpSaveDeviceFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 7:
               var17 = AddDeviceSetNameFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 8:
               var17 = AddDeviceAutoStepOneFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 9:
               var17 = AddDeviceAutoStepTwoFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 10:
               var17 = AddDeviceAutoConfigProgressFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 11:
               var17 = AddDeviceSetNameFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 12:
               var17 = AddDeviceAutoConfigurationFailedStepOne.Companion.newInstance(var16.getDeviceType());
               break;
            case 13:
               var17 = AddDeviceAutoConfigurationFailedStepTwo.Companion.newInstance(var16.getDeviceType());
               break;
            case 14:
               var17 = AddDeviceResetDeviceFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 15:
               var17 = AddDeviceManualConfigurationFailed.Companion.newInstance(var16.getDeviceType());
               break;
            case 16:
               var17 = AddDeviceManualUserValidateFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 17:
               var17 = AddDeviceSuccessFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 18:
               if (var16.getDeviceType() == 3) {
                  this.getToolbar().setTitle((CharSequence)this.getString(com.blueair.viewcore.R.string.manual_configuration));
               }

               var17 = AddDeviceManualStepOneFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 19:
               Timber.Forest var11 = Timber.Forest;
               StringBuilder var21 = new StringBuilder("deviceType = ");
               var21.append(this.getAddDeviceService().getState().getDeviceType());
               var21.append(", CHANGE_WIFI_STATE = ");
               Context var25 = (Context)this;
               var21.append(ContextCompat.checkSelfPermission(var25, "android.permission.CHANGE_WIFI_STATE"));
               var21.append(", ACCESS_COARSE_LOCATION = ");
               var21.append(ContextCompat.checkSelfPermission(var25, "android.permission.ACCESS_COARSE_LOCATION"));
               var11.d(var21.toString(), new Object[0]);
               var17 = AddDeviceManualStepTwoFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 20:
               String var10 = this.getAddDeviceService().getCurrentNetworkSSIDEstimate();
               String var9 = this.getAddDeviceService().getSettingsWiFiNetworkPassword();
               var17 = AddDeviceConfigureNetworkFragment.Companion.newInstance(var16.getDeviceType(), var16.getCurrentConfigMode(), var10, var9);
               break;
            case 21:
               AddDeviceManualConfigProgressFragment var18;
               if (ContextCompat.checkSelfPermission((Context)this, "android.permission.CHANGE_NETWORK_STATE") != 0 && !this.canWriteMarshmallowSettings()) {
                  DialogUtils.INSTANCE.showRequestPermissionHint(com.blueair.viewcore.R.string.permission_request_title_network_settings, com.blueair.viewcore.R.string.permission_request_message_network_settings);
                  ActivityCompat.requestPermissions((Activity)this, new String[]{"android.permission.CHANGE_NETWORK_STATE"}, 101);
                  var18 = null;
               } else {
                  var18 = AddDeviceManualConfigProgressFragment.Companion.newInstance(var16.getDeviceType());
               }

               var17 = var18;
               break;
            case 22:
               var17 = AddDeviceMigrationOtaFragment.Companion.newInstance(var16.getDeviceType());
               break;
            case 23:
               var17 = new ClassicTroubleShootingFragment();
               break;
            default:
               var17 = null;
         }

         var2 = AddDeviceActivityLegacy.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         boolean var4 = true;
         boolean var6;
         if (var2 == 1) {
            var6 = true;
         } else {
            var6 = false;
         }

         if (AddDeviceActivityLegacy.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 17) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         int var5 = AddDeviceActivityLegacy.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         boolean var3 = var4;
         if (var5 != 2) {
            var3 = var4;
            if (var5 != 3) {
               var3 = false;
            }
         }

         Timber.Forest var26 = Timber.Forest;
         StringBuilder var22 = new StringBuilder("screenFragment = ");
         var22.append(var17);
         var26.d(var22.toString(), new Object[0]);
         if (var17 != null) {
            this.expandToolbar(var6);
            if (var3) {
               this.enableBackgroundAnimation();
            } else {
               this.disableBackgroundAnimation();
            }

            if (!AddDeviceUtils.INSTANCE.screenAllowsBack(var1)) {
               this.getToolbar().setTitle((CharSequence)"");
            }

            if (AddDeviceUtils.INSTANCE.screenHasNoToolbar(var1)) {
               this.getToolbar().setBackgroundColor(this.getResources().getColor(com.blueair.viewcore.R.color.transparent));
               this.getToolbar().removeAllViews();
            }

            if (var2) {
               this.setBackgroundImage();
            }

            FragmentTransaction var23 = this.getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(var23, "beginTransaction(...)");
            var23 = this.animationTransaction(var23, var17);
            this.currentScreen = var1;
            this.invalidateOptionsMenu();
            this.updateBackAllowedUi();
            ViewHelperUtil var27 = ViewHelperUtil.INSTANCE;
            ActivityAddDeviceLegacyBinding var12 = this.binding;
            if (var12 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = (ActivityAddDeviceLegacyBinding)var19;
            }

            var27.hideSoftKeyboard((View)var12.contentFragment);
            Timber.Forest var20 = Timber.Forest;
            StringBuilder var13 = new StringBuilder("goForwardToScreen, add old fragment to backstack ");
            var13.append(this.oldScreen);
            var20.d(var13.toString(), new Object[0]);
            var23.replace(R.id.content_fragment, var17);
            var23.addToBackStack(this.oldScreen.toString());
            var23.commitAllowingStateLoss();
         } else {
            Timber.Forest.w("gotoNextScreen, but no valid screen foundIp", new Object[0]);
         }
      }
   }

   public final void handleBack() {
      if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_2 && this.getAddDeviceService().getTroubleshootThirdItemSelected()) {
         this.getAddDeviceService().showManualStep1();
      } else if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1 && this.getAddDeviceService().getTroubleshoot()) {
         this.getAddDeviceService().showAutoStep2();
      } else if (this.currentScreen != AddDeviceUtils.AddDeviceScreen.CONFIG_NETWORK && this.getAddDeviceService().getTroubleshoot()) {
         this.getAddDeviceService().troubleshoot();
      } else if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.TROUBLESHOOT) {
         this.getAddDeviceService().startConnectToNetworkClassic();
      } else if (this.currentScreen == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE) {
         this.finish();
      } else if (!AddDeviceUtils.INSTANCE.screenDoesNotAllowBack(this.currentScreen)) {
         if (this.oldScreen == AddDeviceUtils.AddDeviceScreen.MIGRATION_OTA && this.currentScreen == AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE) {
            this.finish();
         }

         boolean var1;
         AddDeviceUtils.AddDeviceScreen var2;
         do {
            var1 = this.getAddDeviceService().popState();
            if (var1) {
               var2 = AddDeviceUtils.INSTANCE.getScreen(this.getAddDeviceService().getState());
            } else {
               var2 = null;
            }

            Timber.Forest var3 = Timber.Forest;
            StringBuilder var4 = new StringBuilder("handleBack loop: canGoBack = ");
            var4.append(var1);
            var4.append(", targetScreen = ");
            var4.append(var2);
            var4.append(", screenAllowsBack = ");
            var4.append(AddDeviceUtils.INSTANCE.screenAllowsBack(var2));
            var3.d(var4.toString(), new Object[0]);
         } while(var1 && AddDeviceUtils.INSTANCE.screenAllowsBack(var2) && (var2 == this.currentScreen || var2 == AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS || var2 == AddDeviceUtils.AddDeviceScreen.MANUAL_PROGRESS));

         Timber.Forest var6 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("handleBack: canGoBack = ");
         var5.append(var1);
         var5.append(", targetScreen = ");
         var5.append(var2);
         var5.append(", currentScreen = ");
         var5.append(this.currentScreen);
         var6.d(var5.toString(), new Object[0]);
         if (var1 && var2 != null) {
            this.goBackToScreen(var2);
         } else {
            Timber.Forest.d("handleBack: finish", new Object[0]);
            this.finish();
         }
      }
   }

   @Deprecated(
      message = "Deprecated in Java",
      replaceWith = @ReplaceWith(
   expression = "handleBack()",
   imports = {}
)
   )
   public void onBackPressed() {
      this.handleBack();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityAddDeviceLegacyBinding var4 = ActivityAddDeviceLegacyBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      Object var3 = null;
      ActivityAddDeviceLegacyBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      this.setContentView((View)var2.getRoot());
      this.setStatusBarColor(-1, true);
      this.disableBackgroundAnimation();
      this.setSupportActionBar(this.getToolbar());
      var4 = this.binding;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ViewGroup.LayoutParams var9 = var2.addDeviceAppbar.getLayoutParams();
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
      CoordinatorLayout.LayoutParams var13 = (CoordinatorLayout.LayoutParams)var9;
      AppBarLayout.Behavior var10 = new AppBarLayout.Behavior();
      var10.setDragCallback((AppBarLayout.BaseBehavior.BaseDragCallback)(new AppBarLayout.Behavior.DragCallback() {
         public boolean canDrag(AppBarLayout var1) {
            Intrinsics.checkNotNullParameter(var1, "appBarLayout");
            return false;
         }
      }));
      var13.setBehavior((CoordinatorLayout.Behavior)var10);
      AddDeviceState var5;
      if (var1 != null) {
         var5 = (AddDeviceState)var1.getParcelable("state_key");
      } else {
         var5 = null;
      }

      this.getAddDeviceService().initState(var5);
      ActivityAddDeviceLegacyBinding var11 = this.binding;
      ActivityAddDeviceLegacyBinding var6 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnClose.setOnClickListener(new AddDeviceActivityLegacy$$ExternalSyntheticLambda10(this));
      var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (ActivityAddDeviceLegacyBinding)var3;
      }

      var6.btnBack.setOnClickListener(new AddDeviceActivityLegacy$$ExternalSyntheticLambda1(this));
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      if (var1.getItemId() == 16908332) {
         this.handleBack();
         return true;
      } else {
         return false;
      }
   }

   protected void onPause() {
      this.asyncSubs.clear();
      super.onPause();
   }

   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      Intrinsics.checkNotNullParameter(var2, "permissions");
      Intrinsics.checkNotNullParameter(var3, "grantResults");
      super.onRequestPermissionsResult(var1, var2, var3);
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("onRequestPermissionsResult: requestCode = ");
      var8.append(var1);
      var8.append(", grantResults = ");
      var8.append(var3);
      var8.append(", grantResults.length = ");
      var8.append(var3.length);
      String var18 = var8.toString();
      byte var5 = 0;
      var7.d(var18, new Object[0]);
      int var6 = var2.length;

      for(int var4 = 0; var4 < var6; ++var4) {
         var7 = Timber.Forest;
         StringBuilder var19 = new StringBuilder("permission = ");
         var19.append(var2[var4]);
         var19.append(", result = ");
         var19.append(var3[var4]);
         var7.d(var19.toString(), new Object[0]);
      }

      int var14 = 1;
      var6 = 1;
      if (var1 != 101) {
         if (var1 != 105) {
            return;
         }

         if (var3.length == 0) {
            var1 = var6;
         } else {
            var1 = 0;
         }

         if (!var1) {
            var14 = var3.length;
            var1 = var5;

            while(true) {
               if (var1 >= var14) {
                  this.goForwardToScreen(AddDeviceUtils.INSTANCE.getScreen(this.getAddDeviceService().getState()));
                  return;
               }

               if (var3[var1] != 0) {
                  break;
               }

               ++var1;
            }
         }
      } else {
         if (var3.length == 0) {
            var1 = var14;
         } else {
            var1 = 0;
         }

         if (!var1 && var3[0] == 0) {
            this.goForwardToScreen(AddDeviceUtils.INSTANCE.getScreen(this.getAddDeviceService().getState()));
            return;
         }
      }

      if (VERSION.SDK_INT == 23) {
         Intent var12 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
         StringBuilder var13 = new StringBuilder("package:");
         var13.append(this.getPackageName());
         var12.setData(Uri.parse(var13.toString()));
         this.startActivityForResult(var12, 103);
      } else {
         ViewUtils.INSTANCE.showError((Activity)this, com.blueair.viewcore.R.string.add_device_info_missing);
      }
   }

   protected void onResumeFragments() {
      super.onResumeFragments();
      if (this.getAddDeviceService().getState().isSuccess()) {
         this.finishAddDevice();
      } else {
         CompositeDisposable var1 = this.asyncSubs;
         Observable var2 = this.getAddDeviceService().getMessageDisplayObserver().observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var2, "observeOn(...)");
         var1.add(RxExtensionsKt.subscribeAndLogE(var2, new AddDeviceActivityLegacy$$ExternalSyntheticLambda6(this)));
         CompositeDisposable var6 = this.asyncSubs;
         Observable var3 = this.getAddDeviceService().getScreenChangeObserver().observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var3, "observeOn(...)");
         var6.add(RxExtensionsKt.subscribeAndLogE(var3, new AddDeviceActivityLegacy$$ExternalSyntheticLambda7(this)));
         var6 = this.asyncSubs;
         var3 = this.getAddDeviceService().getScreenRevertObserver().observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var3, "observeOn(...)");
         var6.add(RxExtensionsKt.subscribeAndLogE(var3, new AddDeviceActivityLegacy$$ExternalSyntheticLambda8(this)));
         var6 = this.asyncSubs;
         var3 = this.getAddDeviceService().getSuccessObserver().observeOn(AndroidSchedulers.mainThread());
         Intrinsics.checkNotNullExpressionValue(var3, "observeOn(...)");
         var6.add(RxExtensionsKt.subscribeAndLogE(var3, new AddDeviceActivityLegacy$$ExternalSyntheticLambda9(this)));
         this.goForwardToScreen(AddDeviceUtils.INSTANCE.getScreen(this.getAddDeviceService().getState()));
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      Intrinsics.checkNotNullParameter(var1, "outState");
      var1.putParcelable("state_key", this.getAddDeviceService().getState());
      super.onSaveInstanceState(var1);
   }

   public final void updateBackAllowedUi() {
      ActionBar var1 = this.getSupportActionBar();
      if (var1 != null) {
         var1.setDisplayHomeAsUpEnabled(AddDeviceUtils.INSTANCE.screenAllowsBack(this.currentScreen));
      }

   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/adddevice/activity/AddDeviceActivityLegacy$Companion;", "", "<init>", "()V", "STATE_KEY", "", "REQUEST_NETWORK_PERMISSIONS", "", "WRITE_PERMISSION_REQUEST", "REQUEST_LOCATION_PERMISSION", "REQUEST_NETWORK_AND_BASIC_LOCATION_PERMISSIONS", "PARAM_SELECTED_DEVICE", "PARAM_DEVICE_COMPATIBILITY", "adddevice_otherRelease"},
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
         int[] var0 = new int[AddDeviceUtils.AddDeviceScreen.values().length];

         try {
            var0[AddDeviceUtils.AddDeviceScreen.SELECT_DEVICE.ordinal()] = 1;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.SETUP_TEXT.ordinal()] = 2;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.ICP_ADD_DEVICE.ordinal()] = 3;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.ICP_SETUP_DEVICE.ordinal()] = 4;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.ICP_PAIR_DEVICE.ordinal()] = 5;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.ICP_SAVE_DEVICE.ordinal()] = 6;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.ICP_NAME_DEVICE.ordinal()] = 7;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.AUTO_STEP_1.ordinal()] = 8;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.AUTO_STEP_2.ordinal()] = 9;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.AUTO_PROGRESS.ordinal()] = 10;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.NAME_DEVICE.ordinal()] = 11;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_1.ordinal()] = 12;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.AUTO_FAIL_STEP_2.ordinal()] = 13;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.RESET_DEVICE.ordinal()] = 14;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.MANUAL_FAIL.ordinal()] = 15;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.MANUAL_VALIDATE.ordinal()] = 16;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.SUCCESS.ordinal()] = 17;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_1.ordinal()] = 18;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.MANUAL_STEP_2.ordinal()] = 19;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.CONFIG_NETWORK.ordinal()] = 20;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.MANUAL_PROGRESS.ordinal()] = 21;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.MIGRATION_OTA.ordinal()] = 22;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[AddDeviceUtils.AddDeviceScreen.TROUBLESHOOT.ordinal()] = 23;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
