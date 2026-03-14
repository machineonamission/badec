package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.PanelDisplayMode;
import com.blueair.core.model.SimpleEvent;
import com.blueair.core.model.UserManual;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicedetails.adapter.DeviceSettingsAdapter;
import com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding;
import com.blueair.devicedetails.dialog.DeleteDeviceDialogFragment;
import com.blueair.devicedetails.dialog.DeviceC3TemperatureDialogFragment;
import com.blueair.devicedetails.dialog.DeviceErrorReportDialogFragment;
import com.blueair.devicedetails.dialog.DeviceHDryModeDialogFragment;
import com.blueair.devicedetails.dialog.DeviceLinkDialogFragment;
import com.blueair.devicedetails.dialog.DeviceSetTimezoneDialogFragment;
import com.blueair.devicedetails.dialog.DeviceSettingInfoDialogFragment;
import com.blueair.devicedetails.fragment.EmptyFragment;
import com.blueair.devicedetails.util.DeviceSetting;
import com.blueair.devicedetails.util.WelcomeHomePermissionManager;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010M\u001a\u00020:2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u00020:H\u0014J\u0016\u0010Q\u001a\u00020:2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020:0SH\u0002J\b\u0010T\u001a\u00020:H\u0002J\b\u0010U\u001a\u00020:H\u0002J\b\u0010V\u001a\u00020:H\u0002J\b\u0010W\u001a\u00020:H\u0002J\b\u0010X\u001a\u00020:H\u0002J\b\u0010Y\u001a\u00020:H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b!\u0010\u0019R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b$\u0010\u0019R-\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0'0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b(\u0010\u0019R!\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001b\u001a\u0004\b+\u0010\u0019R!\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b.\u0010\u0019R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b1\u0010\u0019R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001b\u001a\u0004\b4\u0010\u0019R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001b\u001a\u0004\b7\u0010\u0019R!\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b;\u0010\u0019R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020:0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020:0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020B0AX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000f\u001a\u0004\bJ\u0010K¨\u0006["},
   d2 = {"Lcom/blueair/devicedetails/activity/DeviceSettingsActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceSettingsBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "welcomeHomeViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "getWelcomeHomeViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "welcomeHomeViewModel$delegate", "deviceInfoPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getDeviceInfoPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceInfoPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "childLockPublisher", "Lcom/blueair/core/model/Device;", "getChildLockPublisher", "childLockPublisher$delegate", "standbyPublisher", "getStandbyPublisher", "standbyPublisher$delegate", "germShieldPublisher", "getGermShieldPublisher", "germShieldPublisher$delegate", "eventPublisher", "Lcom/blueair/core/model/SimpleEvent;", "getEventPublisher", "eventPublisher$delegate", "autoRefreshPublisher", "getAutoRefreshPublisher", "autoRefreshPublisher$delegate", "hourFormatPublisher", "getHourFormatPublisher", "hourFormatPublisher$delegate", "displayModePublisher", "getDisplayModePublisher", "displayModePublisher$delegate", "linkedDevicePublisher", "getLinkedDevicePublisher", "linkedDevicePublisher$delegate", "deviceNameClickPublisher", "getDeviceNameClickPublisher", "deviceNameClickPublisher$delegate", "timezonePublisher", "", "getTimezonePublisher", "timezonePublisher$delegate", "triggerChangedListener", "Lkotlin/reflect/KFunction0;", "errorReportListener", "inputLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "welcomeHomeLauncher", "locationPermissionManager", "Lcom/blueair/devicedetails/util/WelcomeHomePermissionManager;", "userManual", "Lcom/blueair/core/model/UserManual;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter;", "adapter$delegate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "prepareLocationPermissionManager", "onDone", "Lkotlin/Function0;", "addOrEditHomeLocation", "bindViewModel", "excludeCertainSettings", "updateWelcomeHome", "checkForAutoModeTriggerUpdate", "onErrorReportClicked", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSettingsActivity extends BaseActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "deviceInfoPublisher", "getDeviceInfoPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "childLockPublisher", "getChildLockPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "standbyPublisher", "getStandbyPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "germShieldPublisher", "getGermShieldPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "eventPublisher", "getEventPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "autoRefreshPublisher", "getAutoRefreshPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "hourFormatPublisher", "getHourFormatPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "displayModePublisher", "getDisplayModePublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "linkedDevicePublisher", "getLinkedDevicePublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "deviceNameClickPublisher", "getDeviceNameClickPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSettingsActivity.class, "timezonePublisher", "getTimezonePublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy adapter$delegate;
   private final LazyPublishSubject autoRefreshPublisher$delegate;
   private ActivityDeviceSettingsBinding binding;
   private final LazyPublishSubject childLockPublisher$delegate;
   private final LazyPublishSubject deviceInfoPublisher$delegate;
   private final LazyPublishSubject deviceNameClickPublisher$delegate;
   private final LazyPublishSubject displayModePublisher$delegate;
   private final KFunction errorReportListener;
   private final LazyPublishSubject eventPublisher$delegate;
   private final LazyPublishSubject germShieldPublisher$delegate;
   private final LazyPublishSubject hourFormatPublisher$delegate;
   private ActivityResultLauncher inputLauncher;
   private final LazyPublishSubject linkedDevicePublisher$delegate;
   private WelcomeHomePermissionManager locationPermissionManager;
   private final String screenName = "device_settings";
   private final LazyPublishSubject standbyPublisher$delegate;
   private final LazyPublishSubject timezonePublisher$delegate;
   private final KFunction triggerChangedListener;
   private UserManual userManual;
   private final Lazy viewModel$delegate;
   private ActivityResultLauncher welcomeHomeLauncher;
   private final Lazy welcomeHomeViewModel$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$1_tQ_72FJ751QRmis2oI4hzkx80/* $FF was: $r8$lambda$1-tQ_72FJ751QRmis2oI4hzkx80*/(DeviceSettingsActivity var0, Boolean var1) {
      return onResume$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$18YT334NyLlKs7cLLO8R47v_hfo/* $FF was: $r8$lambda$18YT334NyLlKs7cLLO8R47v-hfo*/(DeviceSettingsActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$EpwCXPkmqhLC_b5CRB1lzubShXI/* $FF was: $r8$lambda$EpwCXPkmqhLC-b5CRB1lzubShXI*/(DeviceSettingsActivity var0, ActivityResult var1) {
      onCreate$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GBVphpkrmwZZwHzlRyHukvwgBjc(DeviceSettingsActivity var0) {
      return onResume$lambda$27$lambda$23$lambda$21(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$HOmMTPYIXD6NXqda7wWNSNnExQA(DeviceSettingsActivity var0, View var1) {
      onCreate$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$IwXjjj6RjU_QVymsjB8J7LRiQqk/* $FF was: $r8$lambda$IwXjjj6RjU-QVymsjB8J7LRiQqk*/(DeviceSettingsActivity var0) {
      updateWelcomeHome$lambda$38(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Nl6E10N4_m3nvK_eyik3aY3rXP8/* $FF was: $r8$lambda$Nl6E10N4_m3nvK-eyik3aY3rXP8*/(DeviceSettingsActivity var0, Boolean var1) {
      return onResume$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$S_Pemfh__xPh2G9Vk8uKXsYd228/* $FF was: $r8$lambda$S-Pemfh--xPh2G9Vk8uKXsYd228*/(DeviceSettingsActivity var0, String var1) {
      return bindViewModel$lambda$37(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SjjsrnPUJVgUnB7ak3fBlt_dmiQ(DeviceSettingsActivity var0, Device var1) {
      return onResume$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SujJMJTgtl_N5_XfZ7R_Qmv7hX8/* $FF was: $r8$lambda$SujJMJTgtl_N5-XfZ7R-Qmv7hX8*/(DeviceSettingsActivity var0, Device var1) {
      return onResume$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$T1Dh_pDcNumKZjtJcMYtMJv8Szk/* $FF was: $r8$lambda$T1Dh-pDcNumKZjtJcMYtMJv8Szk*/(DeviceSettingsActivity var0, Device var1) {
      return onResume$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$T6TQvUqNxCI_wbyO6cp1pD0l0wk/* $FF was: $r8$lambda$T6TQvUqNxCI-wbyO6cp1pD0l0wk*/(DeviceSettingsActivity var0) {
      return addOrEditHomeLocation$lambda$30$lambda$29(var0);
   }

   // $FF: synthetic method
   public static DeviceSettingsAdapter $r8$lambda$TQefg6rKxbKSlkoxX6Lxn0T3dxM(DeviceSettingsActivity var0) {
      return adapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$UHsT_vUYktjE1256BQ1Upd_aJxc/* $FF was: $r8$lambda$UHsT-vUYktjE1256BQ1Upd_aJxc*/(DeviceSettingsActivity var0, Function0 var1, Fragment var2) {
      return prepareLocationPermissionManager$lambda$28(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$UwAayTD5a40aIeTKdgM6M96_r0A(DeviceSettingsActivity var0, Boolean var1) {
      return bindViewModel$lambda$36(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Z95infws7fN4OOY5X9DSXAtCohE(DeviceSettingsActivity var0, Boolean var1) {
      return bindViewModel$lambda$35(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ZQUIw5IzmX2_Lc2nAN61QI2NGaI(DeviceSettingsActivity var0, Device var1) {
      return onResume$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$a6Ct_sVCyM83_P5ph_WkEQWsCsM/* $FF was: $r8$lambda$a6Ct_sVCyM83-P5ph-WkEQWsCsM*/(DeviceSettingsActivity var0, List var1) {
      return bindViewModel$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bXPkOvo7iRjKEMpycse3gvmGLMg(DeviceSettingsActivity var0) {
      return addOrEditHomeLocation$lambda$30(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bwa6_hpd3yf4JXwErd0Mxoap2as/* $FF was: $r8$lambda$bwa6-hpd3yf4JXwErd0Mxoap2as*/(DeviceSettingsActivity var0, Unit var1) {
      return onResume$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$cSzTfsYmp0JBpKP57j7x4Fa9Wdc(DeviceSettingsActivity var0, Device var1) {
      return bindViewModel$lambda$32(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fYKUg56pEU5w_kZ1JxC14JD2eJs/* $FF was: $r8$lambda$fYKUg56pEU5w-kZ1JxC14JD2eJs*/(DeviceSettingsActivity var0) {
      return onResume$lambda$27$lambda$23(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$hkuc5eOyZ80itLFN4sN2PQn5U6U(DeviceSettingsActivity var0, SimpleEvent var1) {
      return onResume$lambda$27(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$k7dQRiOiOXIRl1ZzgkGoaCxd_2Y(DeviceSettingsActivity var0, Device var1) {
      return onResume$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pzve_8rzjJyXWwc0fy21OnI_1vw(DeviceSettingsActivity var0, Boolean var1) {
      return onResume$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qA_rvTSwXIwWLo8gHD7stFtGXBg/* $FF was: $r8$lambda$qA-rvTSwXIwWLo8gHD7stFtGXBg*/(DeviceSettingsActivity var0, ActivityResult var1) {
      onCreate$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$r8jM_awuVMihqdVF_oFW7t4g4eo/* $FF was: $r8$lambda$r8jM-awuVMihqdVF_oFW7t4g4eo*/(DeviceSettingsActivity var0, Boolean var1) {
      return bindViewModel$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ud8TRAJbyNKKV_dJFIrPG2X_I8M/* $FF was: $r8$lambda$ud8TRAJbyNKKV-dJFIrPG2X_I8M*/(DeviceSettingsActivity var0, WelcomeHomeLocation var1) {
      return bindViewModel$lambda$34(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wQjPjx8R_yX30FznMZVr_xCsxg8/* $FF was: $r8$lambda$wQjPjx8R-yX30FznMZVr-xCsxg8*/(DeviceSettingsActivity var0) {
      return onResume$lambda$27$lambda$23$lambda$22(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wllHS12oeyrV_04p3NguhX1zqfQ(DeviceSettingsActivity var0, Device var1) {
      return onResume$lambda$12(var0, var1);
   }

   public DeviceSettingsActivity() {
      ComponentActivity var1 = (ComponentActivity)this;
      Function0 var2 = new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceDetailsViewModel.class), new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var2, new Function0((Function0)null, var1) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      var2 = new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.welcomeHomeViewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceWelcomeHomeViewModel.class), new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var2, new Function0((Function0)null, var1) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      this.deviceInfoPublisher$delegate = new LazyPublishSubject();
      this.childLockPublisher$delegate = new LazyPublishSubject();
      this.standbyPublisher$delegate = new LazyPublishSubject();
      this.germShieldPublisher$delegate = new LazyPublishSubject();
      this.eventPublisher$delegate = new LazyPublishSubject();
      this.autoRefreshPublisher$delegate = new LazyPublishSubject();
      this.hourFormatPublisher$delegate = new LazyPublishSubject();
      this.displayModePublisher$delegate = new LazyPublishSubject();
      this.linkedDevicePublisher$delegate = new LazyPublishSubject();
      this.deviceNameClickPublisher$delegate = new LazyPublishSubject();
      this.timezonePublisher$delegate = new LazyPublishSubject();
      this.triggerChangedListener = (KFunction)(new Function0(this) {
         public final void invoke() {
            ((DeviceSettingsActivity)this.receiver).checkForAutoModeTriggerUpdate();
         }
      });
      this.errorReportListener = (KFunction)(new Function0(this) {
         public final void invoke() {
            ((DeviceSettingsActivity)this.receiver).onErrorReportClicked();
         }
      });
      this.adapter$delegate = LazyKt.lazy(new DeviceSettingsActivity$$ExternalSyntheticLambda0(this));
   }

   private static final DeviceSettingsAdapter adapter_delegate$lambda$0(DeviceSettingsActivity var0) {
      return new DeviceSettingsAdapter(var0.getDeviceInfoPublisher(), var0.getChildLockPublisher(), var0.getStandbyPublisher(), var0.getGermShieldPublisher(), var0.getLinkedDevicePublisher(), var0.getDeviceNameClickPublisher(), var0.getAutoRefreshPublisher(), var0.getHourFormatPublisher(), var0.getDisplayModePublisher(), var0.getTimezonePublisher(), var0.getEventPublisher(), (Function0)var0.triggerChangedListener, (Function0)var0.errorReportListener);
   }

   private final void addOrEditHomeLocation() {
      Device var1 = this.getViewModel().getDevice();
      Intrinsics.checkNotNull(var1);
      if (var1 instanceof HasWelcomeHome) {
         this.prepareLocationPermissionManager(new DeviceSettingsActivity$$ExternalSyntheticLambda21(this));
      }

   }

   private static final Unit addOrEditHomeLocation$lambda$30(DeviceSettingsActivity var0) {
      WelcomeHomePermissionManager var1 = var0.locationPermissionManager;
      if (var1 != null) {
         WelcomeHomePermissionManager.checkAndRequest$default(var1, (Function0)null, new DeviceSettingsActivity$$ExternalSyntheticLambda11(var0), 1, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit addOrEditHomeLocation$lambda$30$lambda$29(DeviceSettingsActivity var0) {
      ActivityResultLauncher var2 = var0.welcomeHomeLauncher;
      ActivityResultLauncher var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("welcomeHomeLauncher");
         var1 = null;
      }

      WelcomeHomeConfigActivity.Companion var5 = WelcomeHomeConfigActivity.Companion;
      Context var3 = (Context)var0;
      Device var4 = var0.getViewModel().getDevice();
      Intrinsics.checkNotNull(var4);
      var1.launch(var5.getLaunchIntent(var3, (HasWelcomeHome)var4));
      return Unit.INSTANCE;
   }

   private final void bindViewModel() {
      // $FF: Couldn't be decompiled
   }

   private static final Unit bindViewModel$lambda$31(DeviceSettingsActivity var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceList");
      DeviceSettingsAdapter var4 = var0.getAdapter();
      Iterable var2 = (Iterable)var1;
      Collection var5 = (Collection)(new ArrayList());

      for(Object var3 : var2) {
         if (var3 instanceof DeviceAware) {
            var5.add(var3);
         }
      }

      var4.setAwares((List)var5);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$32(DeviceSettingsActivity var0, Device var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("liveDevice = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      var0.getViewModel().setDevice(var1);
      var0.getAdapter().setDevice(var1);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$33(DeviceSettingsActivity var0, Boolean var1) {
      DeviceSettingsAdapter var2 = var0.getAdapter();
      Intrinsics.checkNotNull(var1);
      var2.setDeviceOffline(var1);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$34(DeviceSettingsActivity var0, WelcomeHomeLocation var1) {
      var0.getWelcomeHomeViewModel().loadHomeLocation(var1);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$35(DeviceSettingsActivity var0, Boolean var1) {
      var0.updateWelcomeHome();
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$36(DeviceSettingsActivity var0, Boolean var1) {
      var0.updateWelcomeHome();
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$37(DeviceSettingsActivity var0, String var1) {
      var0.updateWelcomeHome();
      return Unit.INSTANCE;
   }

   private final void checkForAutoModeTriggerUpdate() {
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Setting onBackPressed called: auto selected = ");
      var2.append(this.getAdapter().getAutoModeTriggerSelected());
      var2.append(" & g4 night mode selected = ");
      var2.append(this.getAdapter().getG4NightModeTriggerSelected());
      var1.d(var2.toString(), new Object[0]);
      Device var4 = this.getAdapter().getDevice();
      FilterTrigger var6 = this.getAdapter().getAutoModeTriggerSelected();
      FilterTrigger var3 = this.getAdapter().getG4NightModeTriggerSelected();
      if (var4 instanceof HasG4NightMode) {
         if (var6 != null || var3 != null) {
            FilterTrigger var5 = var6;
            if (var6 == null) {
               var5 = ((HasG4NightMode)var4).getTrigger();
            }

            var6 = var3;
            if (var3 == null) {
               var6 = ((HasG4NightMode)var4).getG4NightModeTrigger();
            }

            Timber.Forest var9 = Timber.Forest;
            StringBuilder var8 = new StringBuilder("Setting onBackPressed called: send auto selected = ");
            var8.append(var5);
            var8.append(" & g4 night mode selected = ");
            var8.append(var6);
            var9.d(var8.toString(), new Object[0]);
            this.getViewModel().autoModeFilterTriggerChanged(var5, var6);
            return;
         }
      } else if (var4 instanceof HasFanSpeed && var6 != null) {
         this.getViewModel().autoModeFilterTriggerChanged(var6);
      }

   }

   private final void excludeCertainSettings() {
      UserManual var1 = this.userManual;
      String var2;
      if (var1 != null) {
         var2 = var1.getLink();
      } else {
         var2 = null;
      }

      CharSequence var3 = (CharSequence)var2;
      if (var3 == null || var3.length() == 0) {
         this.getAdapter().addExcluedeSetting(DeviceSetting.USER_MANUAL.INSTANCE);
      }

      Device var4 = this.getViewModel().getDevice();
      Intrinsics.checkNotNull(var4);
      if (!(var4 instanceof HasWelcomeHome) || !this.getViewModel().isInWelcomeHomeRegion()) {
         this.getAdapter().addExcluedeSetting(DeviceSetting.WELCOME_HOME.INSTANCE);
      }
   }

   private final DeviceSettingsAdapter getAdapter() {
      return (DeviceSettingsAdapter)this.adapter$delegate.getValue();
   }

   private final PublishSubject getAutoRefreshPublisher() {
      return this.autoRefreshPublisher$delegate.getValue(this, $$delegatedProperties[5]);
   }

   private final PublishSubject getChildLockPublisher() {
      return this.childLockPublisher$delegate.getValue(this, $$delegatedProperties[1]);
   }

   private final PublishSubject getDeviceInfoPublisher() {
      return this.deviceInfoPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final PublishSubject getDeviceNameClickPublisher() {
      return this.deviceNameClickPublisher$delegate.getValue(this, $$delegatedProperties[9]);
   }

   private final PublishSubject getDisplayModePublisher() {
      return this.displayModePublisher$delegate.getValue(this, $$delegatedProperties[7]);
   }

   private final PublishSubject getEventPublisher() {
      return this.eventPublisher$delegate.getValue(this, $$delegatedProperties[4]);
   }

   private final PublishSubject getGermShieldPublisher() {
      return this.germShieldPublisher$delegate.getValue(this, $$delegatedProperties[3]);
   }

   private final PublishSubject getHourFormatPublisher() {
      return this.hourFormatPublisher$delegate.getValue(this, $$delegatedProperties[6]);
   }

   private final PublishSubject getLinkedDevicePublisher() {
      return this.linkedDevicePublisher$delegate.getValue(this, $$delegatedProperties[8]);
   }

   private final PublishSubject getStandbyPublisher() {
      return this.standbyPublisher$delegate.getValue(this, $$delegatedProperties[2]);
   }

   private final PublishSubject getTimezonePublisher() {
      return this.timezonePublisher$delegate.getValue(this, $$delegatedProperties[10]);
   }

   private final DeviceDetailsViewModel getViewModel() {
      return (DeviceDetailsViewModel)this.viewModel$delegate.getValue();
   }

   private final DeviceWelcomeHomeViewModel getWelcomeHomeViewModel() {
      return (DeviceWelcomeHomeViewModel)this.welcomeHomeViewModel$delegate.getValue();
   }

   private static final void onCreate$lambda$2(DeviceSettingsActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeleteDeviceDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeleteDeviceDialogFragment") instanceof DeleteDeviceDialogFragment) && !var2.isStateSaved()) {
         DeleteDeviceDialogFragment.Companion var4 = DeleteDeviceDialogFragment.Companion;
         Device var3 = var0.getViewModel().getDevice();
         Intrinsics.checkNotNull(var3);
         ((DialogFragment)var4.newInstance(var3, true)).show(var2, "DeleteDeviceDialogFragment");
      }

   }

   private static final void onCreate$lambda$3(DeviceSettingsActivity var0, View var1) {
      var0.onBackPressed();
   }

   private static final void onCreate$lambda$5(DeviceSettingsActivity var0, ActivityResult var1) {
      if (var1.getResultCode() == -1) {
         Intent var4 = var1.getData();
         if (var4 != null) {
            String var5 = var4.getStringExtra("extra_input");
            if (var5 != null) {
               DeviceDetailsViewModel var2 = var0.getViewModel();
               Device var3 = var0.getViewModel().getDevice();
               Intrinsics.checkNotNull(var3);
               var2.setDeviceName(var3, var5);
            }
         }
      }

   }

   private static final void onCreate$lambda$6(DeviceSettingsActivity var0, ActivityResult var1) {
      var0.updateWelcomeHome();
   }

   private final void onErrorReportClicked() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceErrorReportDialogFragment", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("DeviceErrorReportDialogFragment") instanceof DeviceErrorReportDialogFragment) && !var1.isStateSaved()) {
         DeviceErrorReportDialogFragment.Companion var3 = DeviceErrorReportDialogFragment.Companion;
         Device var2 = this.getViewModel().getDevice();
         Intrinsics.checkNotNull(var2);
         ((DialogFragment)var3.newInstance(var2)).show(var1, "DeviceErrorReportDialogFragment");
      }

   }

   private static final Unit onResume$lambda$10(DeviceSettingsActivity var0, Device var1) {
      DeviceDetailsViewModel var2 = var0.getViewModel();
      Intrinsics.checkNotNull(var1);
      var2.childLockChanged(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$11(DeviceSettingsActivity var0, Device var1) {
      DeviceDetailsViewModel var2 = var0.getViewModel();
      Intrinsics.checkNotNull(var1);
      var2.standByChanged(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$12(DeviceSettingsActivity var0, Device var1) {
      DeviceDetailsViewModel var2 = var0.getViewModel();
      Intrinsics.checkNotNull(var1);
      var2.germShieldChanged(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$13(DeviceSettingsActivity var0, Device var1) {
      DeviceDetailsViewModel var2 = var0.getViewModel();
      Intrinsics.checkNotNull(var1);
      var2.autoRefreshEnabledChanged(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$14(DeviceSettingsActivity var0, Boolean var1) {
      DeviceDetailsViewModel var2 = var0.getViewModel();
      Device var3 = var0.getViewModel().getDevice();
      Intrinsics.checkNotNull(var3);
      Intrinsics.checkNotNull(var1);
      var2.setUse24Hour(var3, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$15(DeviceSettingsActivity var0, Boolean var1) {
      DeviceDetailsViewModel var2 = var0.getViewModel();
      Device var3 = var0.getViewModel().getDevice();
      Intrinsics.checkNotNull(var3);
      PanelDisplayMode var4;
      if (var1) {
         var4 = PanelDisplayMode.ON;
      } else {
         var4 = PanelDisplayMode.OFF;
      }

      var2.setPanelDisplayMode(var3, var4.getValue());
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$17(DeviceSettingsActivity var0, Device var1) {
      if (var1 instanceof HasLinkingCapability) {
         FragmentManager var2 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceLinkDialogFragment", "getSimpleName(...)");
         if (!(var2.findFragmentByTag("DeviceLinkDialogFragment") instanceof DeviceLinkDialogFragment) && !var2.isStateSaved()) {
            ((DialogFragment)DeviceLinkDialogFragment.Companion.newInstance((HasLinkingCapability)var1)).show(var2, "DeviceLinkDialogFragment");
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$18(DeviceSettingsActivity var0, Device var1) {
      ActivityResultLauncher var3 = var0.inputLauncher;
      ActivityResultLauncher var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputLauncher");
         var2 = null;
      }

      CustomInputActivity.Companion var5 = CustomInputActivity.Companion;
      Context var7 = (Context)var0;
      String var4 = var0.getString(R.string.custom_name);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      String var6 = var0.getString(R.string.device_name);
      Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
      var2.launch(var5.getLaunchIntent(var7, "device_settings_set_name", var4, var6, var1.getName(), 30));
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$20(DeviceSettingsActivity var0, Unit var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceSetTimezoneDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceSetTimezoneDialogFragment") instanceof DeviceSetTimezoneDialogFragment) && !var2.isStateSaved()) {
         DeviceSetTimezoneDialogFragment.Companion var4 = DeviceSetTimezoneDialogFragment.Companion;
         Device var3 = var0.getViewModel().getDevice();
         Intrinsics.checkNotNull(var3);
         ((DialogFragment)var4.newInstance(var3)).show(var2, "DeviceSetTimezoneDialogFragment");
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$27(DeviceSettingsActivity var0, SimpleEvent var1) {
      switch (var2) {
         case "EVENT_GERMSHIELD_NIGHT_CHECK":
            var0.getViewModel().gsnmChanged((Device)var1.getData());
            break;
         case "EVENT_DRYMODE_CLICK":
            FragmentManager var4 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceHDryModeDialogFragment", "getSimpleName(...)");
            if (!(var4.findFragmentByTag("DeviceHDryModeDialogFragment") instanceof DeviceHDryModeDialogFragment) && !var4.isStateSaved()) {
               ((DialogFragment)DeviceHDryModeDialogFragment.Companion.newInstance()).show(var4, "DeviceHDryModeDialogFragment");
            }
            break;
         case "EVENT_TEMPERATURE_CLICK":
            FragmentManager var3 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceC3TemperatureDialogFragment", "getSimpleName(...)");
            if (!(var3.findFragmentByTag("DeviceC3TemperatureDialogFragment") instanceof DeviceC3TemperatureDialogFragment) && !var3.isStateSaved()) {
               ((DialogFragment)DeviceC3TemperatureDialogFragment.Companion.newInstance()).show(var3, "DeviceC3TemperatureDialogFragment");
            }
            break;
         case "EVENT_REFRESHER_CHECK":
            Object var6 = var1.getData();
            Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type com.blueair.core.model.HasRemoveYellowWater");
            HasRemoveYellowWater var7 = (HasRemoveYellowWater)var6;
            var0.getViewModel().setYwrmEnabled(var7, Intrinsics.areEqual(var7.getYwrmEnabled(), false));
            break;
         case "EVENT_TVOC_CHECK":
            var0.getViewModel().sensorModeChange((Device)var1.getData());
            break;
         case "EVENT_USERMANUAL_CLICK":
            UserManual var5 = var0.userManual;
            if (var5 != null) {
               UserManualActivity.Companion.launch((Context)var0, "device_settings_manual", var5.getLink(), var5.getStartIndex());
            }
            break;
         case "EVENT_WELCOME_ENABLED_CHANGE":
            if (!var0.getWelcomeHomeViewModel().isEnabled()) {
               var0.prepareLocationPermissionManager(new DeviceSettingsActivity$$ExternalSyntheticLambda22(var0));
            } else {
               var0.getWelcomeHomeViewModel().setWelcomeHomeEnabled(false);
            }
            break;
         case "EVENT_HOME_LOCATION_CLICK":
            var0.addOrEditHomeLocation();
            break;
         case "EVENT_AUTODRY_CHECK":
            var0.getViewModel().wickDryEnabledChanged((Device)var1.getData());
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$27$lambda$23(DeviceSettingsActivity var0) {
      WelcomeHomePermissionManager var1 = var0.locationPermissionManager;
      if (var1 != null) {
         var1.checkAndRequest(new DeviceSettingsActivity$$ExternalSyntheticLambda18(var0), new DeviceSettingsActivity$$ExternalSyntheticLambda19(var0));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$27$lambda$23$lambda$21(DeviceSettingsActivity var0) {
      var0.updateWelcomeHome();
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$27$lambda$23$lambda$22(DeviceSettingsActivity var0) {
      if (Intrinsics.areEqual(var0.getWelcomeHomeViewModel().getWelcomeHomeExist().getValue(), false)) {
         var0.addOrEditHomeLocation();
      } else {
         var0.getWelcomeHomeViewModel().setWelcomeHomeEnabled(true);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$9(DeviceSettingsActivity var0, Boolean var1) {
      Device var3 = var0.getViewModel().getDevice();
      if (var3 != null) {
         var0.getViewModel().ensureUseProtectRegion();
         FragmentManager var2 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceSettingInfoDialogFragment", "getSimpleName(...)");
         if (!(var2.findFragmentByTag("DeviceSettingInfoDialogFragment") instanceof DeviceSettingInfoDialogFragment) && !var2.isStateSaved()) {
            ((DialogFragment)DeviceSettingInfoDialogFragment.Companion.newInstance(var3)).show(var2, "DeviceSettingInfoDialogFragment");
         }
      }

      return Unit.INSTANCE;
   }

   private final void prepareLocationPermissionManager(Function0 var1) {
      if (this.locationPermissionManager == null) {
         EmptyFragment.Companion var3 = EmptyFragment.Companion;
         FragmentManager var2 = this.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
         var3.buildIn(var2, new DeviceSettingsActivity$$ExternalSyntheticLambda20(this, var1));
      } else {
         var1.invoke();
      }
   }

   private static final Unit prepareLocationPermissionManager$lambda$28(DeviceSettingsActivity var0, Function0 var1, Fragment var2) {
      Intrinsics.checkNotNullParameter(var2, "it");
      var0.locationPermissionManager = new WelcomeHomePermissionManager(var2);
      var1.invoke();
      return Unit.INSTANCE;
   }

   private final void updateWelcomeHome() {
      ActivityDeviceSettingsBinding var2 = this.binding;
      ActivityDeviceSettingsBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.recyclerViewSettingsContainer.post(new DeviceSettingsActivity$$ExternalSyntheticLambda23(this));
   }

   private static final void updateWelcomeHome$lambda$38(DeviceSettingsActivity var0) {
      var0.getAdapter().notifyItemChanged(DeviceSetting.WELCOME_HOME.INSTANCE);
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      DeviceDetailsViewModel var3 = this.getViewModel();
      Parcelable var2 = this.getIntent().getParcelableExtra("device");
      if (var2 != null) {
         var3.setDevice((Device)var2);
         super.onCreate(var1);
         BaseLokaliseActivity var4 = this;
         Object var11 = null;
         BaseLokaliseActivity.immersiveStatusBar$default(var4, false, 1, (Object)null);
         this.setStatusMode(true);
         this.bindViewModel();
         ActivityDeviceSettingsBinding var12 = this.binding;
         ActivityDeviceSettingsBinding var5 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         var5.recyclerViewSettingsContainer.getRecyclerView().setAdapter(this.getAdapter());
         var12 = this.binding;
         var5 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         var5.buttonDeleteProduct.setOnClickListener(new DeviceSettingsActivity$$ExternalSyntheticLambda24(this));
         var12 = this.binding;
         var5 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var5 = null;
         }

         var5.btnBack.setOnClickListener(new DeviceSettingsActivity$$ExternalSyntheticLambda25(this));
         ActivityResultLauncher var8 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new DeviceSettingsActivity$$ExternalSyntheticLambda26(this));
         Intrinsics.checkNotNullExpressionValue(var8, "registerForActivityResult(...)");
         this.inputLauncher = var8;
         var8 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new DeviceSettingsActivity$$ExternalSyntheticLambda27(this));
         Intrinsics.checkNotNullExpressionValue(var8, "registerForActivityResult(...)");
         this.welcomeHomeLauncher = var8;
         ActivityDeviceSettingsBinding var10 = this.binding;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = (ActivityDeviceSettingsBinding)var11;
         }

         var10.recyclerViewContainer.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this) {
            private long lastScrollTime;
            final DeviceSettingsActivity this$0;

            {
               this.this$0 = var1;
            }

            public final long getLastScrollTime() {
               return this.lastScrollTime;
            }

            public void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5) {
               Intrinsics.checkNotNullParameter(var1, "v");
               this.lastScrollTime = System.currentTimeMillis();
               ActivityDeviceSettingsBinding var7 = this.this$0.binding;
               ActivityDeviceSettingsBinding var6 = var7;
               if (var7 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var6 = null;
               }

               var6.bottomBar.setBackgroundColor(-1);
               var7 = this.this$0.binding;
               var6 = var7;
               if (var7 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var6 = null;
               }

               View var9 = var6.separator;
               Intrinsics.checkNotNullExpressionValue(var9, "separator");
               ViewExtensionsKt.show$default(var9, false, 1, (Object)null);
               ((View)var1).postDelayed(new Runnable(this, this.this$0) {
                  final <undefinedtype> this$0;
                  final DeviceSettingsActivity this$1$inlined;

                  public {
                     this.this$0 = var1;
                     this.this$1$inlined = var2;
                  }

                  public final void run() {
                     if (System.currentTimeMillis() - this.this$0.getLastScrollTime() > 250L) {
                        ActivityDeviceSettingsBinding var3 = this.this$1$inlined.binding;
                        Object var2 = null;
                        ActivityDeviceSettingsBinding var1 = var3;
                        if (var3 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = null;
                        }

                        var1.bottomBar.setBackgroundColor(0);
                        var1 = this.this$1$inlined.binding;
                        if (var1 == null) {
                           Intrinsics.throwUninitializedPropertyAccessException("binding");
                           var1 = (ActivityDeviceSettingsBinding)var2;
                        }

                        View var5 = var1.separator;
                        Intrinsics.checkNotNullExpressionValue(var5, "separator");
                        ViewExtensionsKt.hide(var5);
                     }

                  }
               }, 300L);
            }

            public final void setLastScrollTime(long var1) {
               this.lastScrollTime = var1;
            }
         });
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   protected void onResume() {
      super.onResume();
      CompositeDisposable var2 = this.getRxSubs();
      Observable var1 = RxExtensionsKt.filterRapidClicks((Observable)this.getDeviceInfoPublisher());
      Intrinsics.checkNotNullExpressionValue(var1, "filterRapidClicks(...)");
      var2.add(RxExtensionsKt.subscribeAndLogE(var1, new DeviceSettingsActivity$$ExternalSyntheticLambda6(this)));
      CompositeDisposable var3 = this.getRxSubs();
      Observable var13 = RxExtensionsKt.filterRapidClicks((Observable)this.getChildLockPublisher());
      Intrinsics.checkNotNullExpressionValue(var13, "filterRapidClicks(...)");
      var3.add(RxExtensionsKt.subscribeAndLogE(var13, new DeviceSettingsActivity$$ExternalSyntheticLambda8(this)));
      var3 = this.getRxSubs();
      var13 = RxExtensionsKt.filterRapidClicks((Observable)this.getStandbyPublisher());
      Intrinsics.checkNotNullExpressionValue(var13, "filterRapidClicks(...)");
      var3.add(RxExtensionsKt.subscribeAndLogE(var13, new DeviceSettingsActivity$$ExternalSyntheticLambda9(this)));
      CompositeDisposable var15 = this.getRxSubs();
      Observable var5 = RxExtensionsKt.filterRapidClicks((Observable)this.getGermShieldPublisher());
      Intrinsics.checkNotNullExpressionValue(var5, "filterRapidClicks(...)");
      var15.add(RxExtensionsKt.subscribeAndLogE(var5, new DeviceSettingsActivity$$ExternalSyntheticLambda10(this)));
      CompositeDisposable var6 = this.getRxSubs();
      Observable var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getAutoRefreshPublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda12(this)));
      var6 = this.getRxSubs();
      var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getHourFormatPublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda13(this)));
      var6 = this.getRxSubs();
      var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getDisplayModePublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda14(this)));
      var6 = this.getRxSubs();
      var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getLinkedDevicePublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda15(this)));
      var6 = this.getRxSubs();
      var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getDeviceNameClickPublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda16(this)));
      var6 = this.getRxSubs();
      var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getTimezonePublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda17(this)));
      var6 = this.getRxSubs();
      var16 = RxExtensionsKt.filterRapidClicks((Observable)this.getEventPublisher());
      Intrinsics.checkNotNullExpressionValue(var16, "filterRapidClicks(...)");
      var6.add(RxExtensionsKt.subscribeAndLogE(var16, new DeviceSettingsActivity$$ExternalSyntheticLambda7(this)));
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/activity/DeviceSettingsActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final void launch(Context var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intent var3 = new Intent(var1, DeviceSettingsActivity.class);
         var3.putExtra("device", var2);
         var1.startActivity(var3);
      }
   }
}
