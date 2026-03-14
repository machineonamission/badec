package com.blueair.android.fragment;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.android.adapter.DeviceListAdapter;
import com.blueair.android.databinding.FragmentIndoorBinding;
import com.blueair.android.dialog.RateUsDialogFragment;
import com.blueair.android.viewmodel.IndoorViewModel;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.InAppReviewEvent;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.devicedetails.activity.DevicesAlarmListActivity;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment;
import com.blueair.devicedetails.util.DeviceDetailsLauncher;
import com.blueair.devicedetails.util.DeviceDetailsLauncher$_CC;
import com.blueair.sdk.GooglePlayAppReviewSdk;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.BlockerDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00020\u0005:\u0001wB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\b\u0010Q\u001a\u00020RH\u0016J\u0012\u0010S\u001a\u00020%2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020%2\u0006\u0010W\u001a\u00020UH\u0016J$\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020Y2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010`\u001a\u00020%H\u0016J\b\u0010a\u001a\u00020%H\u0002J\u0006\u0010b\u001a\u00020%J\b\u0010c\u001a\u00020\tH\u0003J\u0010\u0010d\u001a\u00020%2\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010g\u001a\u00020%H\u0002J\u001e\u0010h\u001a\u00020%2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020f0j2\u0006\u0010k\u001a\u00020\tH\u0002J\b\u0010l\u001a\u00020%H\u0016J\u001a\u0010m\u001a\u00020%2\u0006\u0010n\u001a\u00020)2\b\u0010o\u001a\u0004\u0018\u00010fH\u0016J\"\u0010p\u001a\u00020%2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020r2\b\u0010t\u001a\u0004\u0018\u00010NH\u0017J\b\u0010u\u001a\u00020%H\u0002J\b\u0010v\u001a\u00020%H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R!\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b0\u0010+R!\u00102\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b3\u0010+R!\u00105\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b6\u0010+R!\u00108\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b9\u0010+R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0018\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0010\u0012\f\u0012\n O*\u0004\u0018\u00010N0N0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020N0MX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006x"},
   d2 = {"Lcom/blueair/android/fragment/IndoorFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/IndoorViewModel;", "Lcom/blueair/devicedetails/util/DeviceDetailsLauncher;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "forceRefresh", "", "lastBleRequest", "", "indoorBinding", "Lcom/blueair/android/databinding/FragmentIndoorBinding;", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/IndoorViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/IndoorViewModel;)V", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "Lkotlin/Lazy;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "showProgress", "", "shouldShowProgress", "deviceSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/Device;", "getDeviceSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "autoModePublisher", "Lcom/blueair/core/model/HasFanSpeed;", "getAutoModePublisher", "autoModePublisher$delegate", "nightModePublisher", "getNightModePublisher", "nightModePublisher$delegate", "standByModePublisher", "getStandByModePublisher", "standByModePublisher$delegate", "offlineClickPublisher", "getOfflineClickPublisher", "offlineClickPublisher$delegate", "shouldCheckRateUsAndWelcomeHome", "networkSnack", "Lcom/google/android/material/snackbar/Snackbar;", "getNetworkSnack", "()Lcom/google/android/material/snackbar/Snackbar;", "networkSnack$delegate", "adapter", "Lcom/blueair/android/adapter/DeviceListAdapter;", "getAdapter", "()Lcom/blueair/android/adapter/DeviceListAdapter;", "adapter$delegate", "firstNotEmptyDeviceListLiveData", "initialSetupCallFinished", "blockerDialog", "Landroidx/fragment/app/DialogFragment;", "getBlockerDialog", "()Landroidx/fragment/app/DialogFragment;", "launcherConnectDevice", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "devicesAlarmLauncher", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "observeViewModel", "connectDevice", "isBluetoothEnabled", "showHelpUsImprove", "trigger", "", "requestInAppReview", "showDstPrompt", "nullTimezoneDeviceIdList", "", "isTriggeredByLocal", "onResume", "openDeviceDetails", "device", "actionType", "onActivityResult", "requestCode", "", "resultCode", "data", "handleDeviceDetailsDialogClosed", "onDestroy", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IndoorFragment extends BaseFragment implements DeviceDetailsLauncher, ProgressFragment, BaseFragmentInterface {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorFragment.class, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorFragment.class, "deviceSelectPublisher", "getDeviceSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorFragment.class, "autoModePublisher", "getAutoModePublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorFragment.class, "nightModePublisher", "getNightModePublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorFragment.class, "standByModePublisher", "getStandByModePublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorFragment.class, "offlineClickPublisher", "getOfflineClickPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final int $stable = 8;
   @Deprecated
   public static final String BLUEAIR_URL = "https://www.blueair.com";
   private static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   @Deprecated
   public static final int REQUEST_BLE_DELTA_MILLIS = 20000;
   private static final int REQUEST_CODE_CONNECT_PRODUCT;
   private static final int REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED;
   @Deprecated
   public static final int REQUEST_CODE_ENABLE_BT = 1230;
   private final Lazy adapter$delegate;
   private final LazyPublishSubject autoModePublisher$delegate;
   private final LazyPublishSubject deviceSelectPublisher$delegate;
   private final ActivityResultLauncher devicesAlarmLauncher;
   private boolean firstNotEmptyDeviceListLiveData;
   private boolean forceRefresh;
   private FragmentIndoorBinding indoorBinding;
   private boolean initialSetupCallFinished;
   private long lastBleRequest;
   private final ActivityResultLauncher launcherConnectDevice;
   private final Lazy locationPermissionTracker$delegate;
   private final Lazy networkSnack$delegate;
   private final LazyPublishSubject nightModePublisher$delegate;
   private final LazyPublishSubject offlineClickPublisher$delegate;
   private ProgressBlockerView progressBlockerView;
   private final Lazy rxSubs$delegate = LazyKt.lazy(new IndoorFragment$$ExternalSyntheticLambda16());
   private boolean shouldCheckRateUsAndWelcomeHome;
   private final LazyPublishSubject standByModePublisher$delegate;
   public IndoorViewModel viewModel;

   // $FF: synthetic method
   public static DeviceListAdapter $r8$lambda$_6LQINUoVaT2ROTfS4omCFht8zs/* $FF was: $r8$lambda$-6LQINUoVaT2ROTfS4omCFht8zs*/(IndoorFragment var0) {
      return adapter_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$3hshC2e7mQ4XgHcwlzzYNTSgrJY(IndoorFragment var0, List var1) {
      return observeViewModel$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4v3pwh3l5n18QiD3FuObfikxFRY(IndoorFragment var0, boolean var1) {
      return observeViewModel$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4yjhx3deY2abizT4zYDtoJBW_jA/* $FF was: $r8$lambda$4yjhx3deY2abizT4zYDtoJBW-jA*/(IndoorFragment var0, boolean var1, TimeZone var2, boolean var3) {
      return showDstPrompt$lambda$28$lambda$25(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BcVla68asexcu6ArLtNd8A3pXus(IndoorFragment var0, ActivityResult var1) {
      launcherConnectDevice$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DvqrQPsNnGkt91WDQX3S_fc0zok/* $FF was: $r8$lambda$DvqrQPsNnGkt91WDQX3S-fc0zok*/(IndoorFragment var0, List var1) {
      return observeViewModel$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Ft1z5u4vHm1baVkf6lnKSIoBv44(IndoorFragment var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$IIIHv9VWGWnvmIWTNba3ocpZY2U() {
      return observeViewModel$lambda$13$lambda$10();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$N_AIDUsxSKft7S1_4NiGII0LIwU(IndoorFragment var0, Device var1) {
      return onResume$lambda$29(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$RLdiF7960OoeyYuqr2hqXRv8FpE(IndoorFragment var0, Device var1) {
      return onResume$lambda$34(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$TdRniZmNlfXWMbILVjPQfMZZ1kI(IndoorFragment var0, List var1) {
      return observeViewModel$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static Snackbar $r8$lambda$UopOJVqlocYd0Hx1YtZU4HKiAQs(IndoorFragment var0) {
      return networkSnack_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Z_SWKKUELuW4dIMY0luVbd7be04(ConfirmationDialogLeftAligned var0, TimeZone var1, TextView var2, TextView var3, TextView var4, MaterialButton var5, MaterialButton var6) {
      return showDstPrompt$lambda$28$lambda$27$lambda$26(var0, var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bFm7OPyHsa5enVRv0TWvV_vNUio/* $FF was: $r8$lambda$bFm7OPyHsa5enVRv0TWvV-vNUio*/(AnalyticsService var0) {
      return requestInAppReview$lambda$20$lambda$19(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$dnTQFcBe7CJGPVzo9WNu0zPaOTY(IndoorFragment var0, Device var1) {
      return onResume$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gfZ3LnR5tlZH_0dEaZAhMfZydtQ/* $FF was: $r8$lambda$gfZ3LnR5tlZH-0dEaZAhMfZydtQ*/(IndoorFragment var0, String var1, Bundle var2) {
      return openDeviceDetails$lambda$38$lambda$36(var0, var1, var2);
   }

   // $FF: synthetic method
   public static CompositeDisposable $r8$lambda$gvX6vut_65PM35H6IFr_H8X5274() {
      return rxSubs_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$j0ISrVAUdZB_JrP4BfMGK8gXLMc/* $FF was: $r8$lambda$j0ISrVAUdZB-JrP4BfMGK8gXLMc*/(IndoorFragment var0, Device var1) {
      return onResume$lambda$32(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jtwzhqSLMnDlqNksGJheODUovjI(IndoorFragment var0) {
      return observeViewModel$lambda$17$lambda$16(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$mYbNnK1bScHwtjgVj91_wtvrJp8(ActivityResult var0) {
      devicesAlarmLauncher$lambda$4(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nLem2tbE5ytCA4_EDVFIm_JljHo/* $FF was: $r8$lambda$nLem2tbE5ytCA4-EDVFIm_JljHo*/(IndoorFragment var0, View var1) {
      onViewCreated$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uqhH9OP9cvjfuHaxTlVZqXzbKUc(IndoorFragment var0, HasFanSpeed var1) {
      return onResume$lambda$30(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xNUNkgu80akOIzy847dPkQwLbQU(IndoorFragment var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   static {
      REQUEST_CODE_CONNECT_PRODUCT = ViewUtils.INSTANCE.genRequestCode();
      REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED = ViewUtils.INSTANCE.genRequestCode();
   }

   public IndoorFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationPermissionTracker$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, LocationPermissionTracker.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.deviceSelectPublisher$delegate = new LazyPublishSubject();
      this.autoModePublisher$delegate = new LazyPublishSubject();
      this.nightModePublisher$delegate = new LazyPublishSubject();
      this.standByModePublisher$delegate = new LazyPublishSubject();
      this.offlineClickPublisher$delegate = new LazyPublishSubject();
      this.shouldCheckRateUsAndWelcomeHome = true;
      this.networkSnack$delegate = LazyKt.lazy(new IndoorFragment$$ExternalSyntheticLambda17(this));
      this.adapter$delegate = LazyKt.lazy(new IndoorFragment$$ExternalSyntheticLambda18(this));
      this.firstNotEmptyDeviceListLiveData = true;
      ActivityResultLauncher var3 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new IndoorFragment$$ExternalSyntheticLambda19(this));
      Intrinsics.checkNotNullExpressionValue(var3, "registerForActivityResult(...)");
      this.launcherConnectDevice = var3;
      var3 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new IndoorFragment$$ExternalSyntheticLambda20());
      Intrinsics.checkNotNullExpressionValue(var3, "registerForActivityResult(...)");
      this.devicesAlarmLauncher = var3;
   }

   private static final DeviceListAdapter adapter_delegate$lambda$2(IndoorFragment var0) {
      return new DeviceListAdapter(var0.getDeviceSelectPublisher(), var0.getStandByModePublisher(), var0.getOfflineClickPublisher());
   }

   private static final void devicesAlarmLauncher$lambda$4(ActivityResult var0) {
   }

   private final DeviceListAdapter getAdapter() {
      return (DeviceListAdapter)this.adapter$delegate.getValue();
   }

   private final PublishSubject getAutoModePublisher() {
      return this.autoModePublisher$delegate.getValue(this, $$delegatedProperties[2]);
   }

   private final DialogFragment getBlockerDialog() {
      FragmentManager var1 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DialogFragment", "getSimpleName(...)");
      Fragment var2 = var1.findFragmentByTag("DialogFragment");
      Fragment var3 = var2;
      if (!(var2 instanceof DialogFragment)) {
         var3 = null;
      }

      return (DialogFragment)var3;
   }

   private final PublishSubject getDeviceSelectPublisher() {
      return this.deviceSelectPublisher$delegate.getValue(this, $$delegatedProperties[1]);
   }

   private final LocationPermissionTracker getLocationPermissionTracker() {
      return (LocationPermissionTracker)this.locationPermissionTracker$delegate.getValue();
   }

   private final Snackbar getNetworkSnack() {
      return (Snackbar)this.networkSnack$delegate.getValue();
   }

   private final PublishSubject getNightModePublisher() {
      return this.nightModePublisher$delegate.getValue(this, $$delegatedProperties[3]);
   }

   private final PublishSubject getOfflineClickPublisher() {
      return this.offlineClickPublisher$delegate.getValue(this, $$delegatedProperties[5]);
   }

   private final PublishSubject getStandByModePublisher() {
      return this.standByModePublisher$delegate.getValue(this, $$delegatedProperties[4]);
   }

   private final void handleDeviceDetailsDialogClosed() {
      if (this.getViewModel().shouldShowRateUsT2()) {
         this.showHelpUsImprove("T2");
      } else if (this.getViewModel().shouldShowRateUsT3()) {
         this.showHelpUsImprove("T3");
      }

      if (Intrinsics.areEqual(this.getViewModel().getNetworkAvailable().getValue(), false)) {
         this.getNetworkSnack().show();
      }

   }

   private final boolean isBluetoothEnabled() {
      BluetoothAdapter var1 = BluetoothAdapter.getDefaultAdapter();
      return var1 != null && var1.isEnabled();
   }

   private static final void launcherConnectDevice$lambda$3(IndoorFragment var0, ActivityResult var1) {
      if (var0.getViewModel().isUserLoggedIn()) {
         var0.connectDevice();
      }

   }

   private static final Snackbar networkSnack_delegate$lambda$1(IndoorFragment var0) {
      return Snackbar.make(var0.requireActivity().findViewById(16908290), (CharSequence)var0.getString(R.string.connection_lost), -2);
   }

   private final void observeViewModel() {
      LiveData var1 = this.getViewModel().getNetworkAvailable();
      LifecycleOwner var2 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var2, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var1, var2, new IndoorFragment$$ExternalSyntheticLambda21(this));
      var1 = this.getViewModel().getLiveDevicesWithLatestDataPoint();
      var2 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var2, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var1, var2, new IndoorFragment$$ExternalSyntheticLambda22(this));
      var1 = this.getViewModel().getLiveDevices();
      var2 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var2, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var1, var2, new IndoorFragment$$ExternalSyntheticLambda1(this));
      LiveData var8 = (LiveData)this.getViewModel().getNullTimezoneDeviceIdList();
      LifecycleOwner var5 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var5, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var8, var5, new IndoorFragment$$ExternalSyntheticLambda2(this));
   }

   private static final Unit observeViewModel$lambda$13(IndoorFragment var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getAdapter().setCurrentList(var1);
      Collection var9 = (Collection)var1;
      if (!var9.isEmpty()) {
         FragmentActivity var6 = var0.getActivity();
         boolean var5;
         if (var6 != null) {
            var5 = var6.hasWindowFocus();
         } else {
            var5 = true;
         }

         if (System.currentTimeMillis() - var0.lastBleRequest > 20000L && var5 && var0.getViewModel().containsIcpDevice()) {
            if (!var0.isBluetoothEnabled()) {
               Timber.Forest.w("ble not enabled", new Object[0]);
               var0.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1230);
            }

            LocationUtils var13 = LocationUtils.INSTANCE;
            Context var7 = var0.requireContext();
            Intrinsics.checkNotNullExpressionValue(var7, "requireContext(...)");
            if (!var13.isLocationPermissionGranted(var7)) {
               var0.getLocationPermissionTracker().requestLocationPermissionDialogOnly(var0, new IndoorFragment$$ExternalSyntheticLambda14());
            }

            var0.lastBleRequest = System.currentTimeMillis();
         }
      }

      Iterator var14 = ((Iterable)var1).iterator();
      int var3 = 0;

      while(var14.hasNext()) {
         Device var21 = (Device)((Pair)var14.next()).getFirst();
         if (var21 instanceof HasAlarm) {
            Iterable var22 = (Iterable)((HasAlarm)var21).getAlarms();
            int var4;
            if (var22 instanceof Collection && ((Collection)var22).isEmpty()) {
               var4 = 0;
            } else {
               Iterator var8 = var22.iterator();
               int var2 = 0;

               while(true) {
                  var4 = var2;
                  if (!var8.hasNext()) {
                     break;
                  }

                  DeviceAlarm var23 = (DeviceAlarm)var8.next();
                  if (var23 != null && var23.getEnabled()) {
                     var4 = var2 + 1;
                     var2 = var4;
                     if (var4 < 0) {
                        CollectionsKt.throwCountOverflow();
                        var2 = var4;
                     }
                  }
               }
            }

            var3 += var4;
         }
      }

      FragmentIndoorBinding var25 = var0.indoorBinding;
      Object var24 = null;
      FragmentIndoorBinding var15 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var15 = null;
      }

      ShadowLayout var16 = var15.slAlarm;
      Intrinsics.checkNotNullExpressionValue(var16, "slAlarm");
      ViewExtensionsKt.show((View)var16, false);
      var25 = var0.indoorBinding;
      FragmentIndoorBinding var17 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var17 = null;
      }

      TextView var18 = var17.tvAlarmValue;
      String var27 = var0.getString(R.string.schedule_active);
      Intrinsics.checkNotNullExpressionValue(var27, "getString(...)");
      var27 = String.format(var27, Arrays.copyOf(new Object[]{var3}, 1));
      Intrinsics.checkNotNullExpressionValue(var27, "format(...)");
      var18.setText((CharSequence)var27);
      FragmentIndoorBinding var29 = var0.indoorBinding;
      FragmentIndoorBinding var19 = var29;
      if (var29 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var19 = null;
      }

      ConstraintLayout var20 = var19.emptyLayout;
      Intrinsics.checkNotNullExpressionValue(var20, "emptyLayout");
      ViewExtensionsKt.show((View)var20, var1.isEmpty());
      FragmentIndoorBinding var10 = var0.indoorBinding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var10 = (FragmentIndoorBinding)var24;
      }

      AppCompatImageView var11 = var10.ivAddFooter;
      Intrinsics.checkNotNullExpressionValue(var11, "ivAddFooter");
      ViewExtensionsKt.show((View)var11, var9.isEmpty() ^ true);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$13$lambda$10() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_service, R.string.permission_request_message_location_service);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$17(IndoorFragment var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      if (var0.firstNotEmptyDeviceListLiveData && !((Collection)var1).isEmpty()) {
         var0.firstNotEmptyDeviceListLiveData = false;
         Iterable var3 = (Iterable)var1;
         Collection var2 = (Collection)(new ArrayList());

         for(Object var4 : var3) {
            Device var5 = (Device)var4;
            if (var5 instanceof HasBlueCloudFunctions && StringsKt.isBlank((CharSequence)var5.getTimeZone())) {
               var2.add(var4);
            }
         }

         var3 = (Iterable)((List)var2);
         var2 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
         Iterator var9 = var3.iterator();

         while(var9.hasNext()) {
            var2.add(((Device)var9.next()).getUid());
         }

         var0.showDstPrompt((List)var2, true);
      }

      if (var0.shouldCheckRateUsAndWelcomeHome) {
         var0.shouldCheckRateUsAndWelcomeHome = false;
         var0.getViewModel().runWhAndRateUsLogic(var1, new IndoorFragment$$ExternalSyntheticLambda11(var0), (Function0)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$17$lambda$16(IndoorFragment var0) {
      var0.showHelpUsImprove("T1");
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$18(IndoorFragment var0, List var1) {
      Intrinsics.checkNotNull(var1);
      var0.showDstPrompt(var1, false);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$9(IndoorFragment var0, boolean var1) {
      if (var1) {
         var0.getNetworkSnack().dismiss();
         var0.getAdapter().setForceOffline(false);
         var0.getViewModel().refreshDeviceList(true);
      } else {
         var0.getNetworkSnack().show();
         var0.getAdapter().setForceOffline(true);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$29(IndoorFragment var0, Device var1) {
      DeviceDetailsLauncher var2 = var0;
      Intrinsics.checkNotNull(var1);
      DeviceDetailsLauncher$_CC.openDeviceDetails$default(var2, var1, (String)null, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$30(IndoorFragment var0, HasFanSpeed var1) {
      if (var1 instanceof HasCombo3in1MainMode) {
         var0.getViewModel().setMainMode((HasCombo3in1MainMode)var1, MainMode.COOL);
      } else if (var1 instanceof HasMode) {
         var0.getViewModel().setToMode((HasMode)var1, Mode.AUTO);
      } else {
         IndoorViewModel var2 = var0.getViewModel();
         Intrinsics.checkNotNull(var1);
         var2.autoModeChanged(var1, var1.getAutoMode());
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$31(IndoorFragment var0, Device var1) {
      if (var1 instanceof HasCombo3in1MainMode) {
         var0.getViewModel().setMainMode((HasCombo3in1MainMode)var1, MainMode.AirPurify);
      } else if (var1 instanceof HasMode) {
         var0.getViewModel().setToMode((HasMode)var1, Mode.NIGHT);
      } else {
         IndoorViewModel var2 = var0.getViewModel();
         Intrinsics.checkNotNull(var1);
         var2.g4NightModeChanged(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$32(IndoorFragment var0, Device var1) {
      IndoorViewModel var2 = var0.getViewModel();
      Intrinsics.checkNotNull(var1);
      var2.standByChanged(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$34(IndoorFragment var0, Device var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var2.isStateSaved()) {
         ((DialogFragment)TroubleshootingDialog.Companion.newInstance("action_type_device_offline", var1)).show(var2, "TroubleshootingDialog");
         var2.executePendingTransactions();
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$6(IndoorFragment var0, View var1) {
      var0.connectDevice();
   }

   private static final void onViewCreated$lambda$7(IndoorFragment var0, View var1) {
      var0.connectDevice();
   }

   private static final void onViewCreated$lambda$8(IndoorFragment var0, View var1) {
      ActivityResultLauncher var2 = var0.devicesAlarmLauncher;
      DevicesAlarmListActivity.Companion var3 = DevicesAlarmListActivity.Companion;
      Context var4 = var1.getContext();
      Intrinsics.checkNotNullExpressionValue(var4, "getContext(...)");
      var2.launch(var3.intent(var4));
   }

   private static final Unit openDeviceDetails$lambda$38$lambda$36(IndoorFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "data");
      var0.handleDeviceDetailsDialogClosed();
      return Unit.INSTANCE;
   }

   private final void requestInAppReview() {
      FragmentActivity var1 = this.getActivity();
      if (var1 != null) {
         GooglePlayAppReviewSdk.INSTANCE.createAppReviewManager((Activity)var1).requestInAppReview(new IndoorFragment$$ExternalSyntheticLambda0(this.getAnalytics()));
      }

   }

   private static final Unit requestInAppReview$lambda$20$lambda$19(AnalyticsService var0) {
      var0.amplitudeLog(new InAppReviewEvent());
      return Unit.INSTANCE;
   }

   private static final CompositeDisposable rxSubs_delegate$lambda$0() {
      return new CompositeDisposable();
   }

   private final void showDstPrompt(List var1, boolean var2) {
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("showDstPrompt: ");
      var4.append(var1);
      var4.append(", ");
      var4.append(var2);
      var5.d(var4.toString(), new Object[0]);
      if (!var2) {
         this.initialSetupCallFinished = true;
         DialogFragment var8 = this.getBlockerDialog();
         if (var8 != null) {
            var8.dismiss();
         }
      }

      if (!var1.isEmpty()) {
         if (this.getViewModel().getHasConfirmedDstPromptDialog()) {
            IndoorViewModel var11 = this.getViewModel();
            TimeZone var14 = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(var14, "getDefault(...)");
            var11.ensureDeviceTimezone(var1, var14, this.requireContext());
            return;
         }

         TimezoneUtils var6 = TimezoneUtils.INSTANCE;
         Context var12 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var12, "requireContext(...)");
         TimeZone var9 = TimeZone.getDefault();
         Intrinsics.checkNotNullExpressionValue(var9, "getDefault(...)");
         var9 = var6.ensureValidTimezone(var12, var9);
         int var3;
         if (var9.inDaylightTime(new Date())) {
            var3 = R.string.dst_prompt_dialog_content_in_dst;
         } else {
            var3 = R.string.dst_prompt_dialog_content_not_in_dst;
         }

         FragmentManager var7 = this.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var7, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var7.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var7.isStateSaved()) {
            ConfirmationDialogLeftAligned var13 = ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.dst_prompt_dialog_title, (Integer)null, var3, R.string.confirm, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, new IndoorFragment$$ExternalSyntheticLambda3(this, var2, var9), 4064, (Object)null);
            var13.setCancelable(false);
            var13.setViewBinder(new IndoorFragment$$ExternalSyntheticLambda4(var13, var9));
            ((DialogFragment)var13).show(var7, "ConfirmationDialogLeftAligned");
         }
      }

   }

   private static final Unit showDstPrompt$lambda$28$lambda$25(IndoorFragment var0, boolean var1, TimeZone var2, boolean var3) {
      if (var3) {
         var0.getViewModel().setHasConfirmedDstPromptDialog(true);
         if (var1 && !var0.initialSetupCallFinished) {
            FragmentManager var11 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var11, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BlockerDialogFragment", "getSimpleName(...)");
            if (!(var11.findFragmentByTag("BlockerDialogFragment") instanceof BlockerDialogFragment) && !var11.isStateSaved()) {
               BlockerDialogFragment var9 = new BlockerDialogFragment();
               var9.setCancelable(false);
               ((DialogFragment)var9).show(var11, "BlockerDialogFragment");
            }
         } else {
            List var7 = (List)var0.getViewModel().getNullTimezoneDeviceIdList().getValue();
            if (var7 != null && !((Collection)var7).isEmpty()) {
               var0.getViewModel().ensureDeviceTimezone(var7, var2, (Context)null);
            }

            if (!Intrinsics.areEqual(var2, TimeZone.getDefault())) {
               int var4;
               if (var2.useDaylightTime()) {
                  var4 = R.string.dst_prompt_dialog_content_timezone_not_found_dst;
               } else {
                  var4 = R.string.dst_prompt_dialog_content_timezone_not_found_not_dst;
               }

               FragmentManager var8 = var0.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var8, "getChildFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
               if (!(var8.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var8.isStateSaved()) {
                  ConfirmationDialogLeftAligned.Companion var12 = ConfirmationDialogLeftAligned.Companion;
                  int var6 = R.string.prompt;
                  int var5 = R.string.close;
                  String var10 = var2.getID();
                  Intrinsics.checkNotNullExpressionValue(var10, "getID(...)");
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var12, var6, (Integer)null, var4, var5, (Integer)null, false, false, false, false, new String[]{var10}, (String)null, (Integer)null, (Function1)null, 7648, (Object)null)).show(var8, "ConfirmationDialogLeftAligned");
               }
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit showDstPrompt$lambda$28$lambda$27$lambda$26(ConfirmationDialogLeftAligned var0, TimeZone var1, TextView var2, TextView var3, TextView var4, MaterialButton var5, MaterialButton var6) {
      Intrinsics.checkNotNullParameter(var2, "title");
      Intrinsics.checkNotNullParameter(var3, "subTitle");
      Intrinsics.checkNotNullParameter(var4, "body");
      Intrinsics.checkNotNullParameter(var5, "positiveBtn");
      Intrinsics.checkNotNullParameter(var6, "negativeBtn");
      String var9 = var4.getText().toString();
      StringBuilder var10 = new StringBuilder("<b>");
      TimezoneUtils var11 = TimezoneUtils.INSTANCE;
      Context var7 = var0.requireContext();
      Intrinsics.checkNotNullExpressionValue(var7, "requireContext(...)");
      var10.append(var11.getDisplayName(var7, var1));
      var10.append("</b>");
      Spanned var8 = HtmlCompat.fromHtml(StringsKt.replace$default(var9, "%s", var10.toString(), false, 4, (Object)null), 0);
      Intrinsics.checkNotNullExpressionValue(var8, "fromHtml(...)");
      var4.setText((CharSequence)var8);
      return Unit.INSTANCE;
   }

   private final void showHelpUsImprove(String var1) {
      RateUsDialogFragment.Companion.newInstance(this.getViewModel().isInChina(), var1).show(this.getChildFragmentManager(), "RateUs");
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public final void connectDevice() {
      if (this.getViewModel().isUserLoggedIn()) {
         Actions var5 = Actions.INSTANCE;
         Context var4 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var4, "requireContext(...)");
         this.startActivityForResult(var5.openAddDeviceIntent(var4), REQUEST_CODE_CONNECT_PRODUCT);
      } else {
         ActivityResultLauncher var1 = this.launcherConnectDevice;
         Actions var3 = Actions.INSTANCE;
         Context var2 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var2, "requireContext(...)");
         var1.launch(Actions.openWelcomeIntent$default(var3, var2, false, 2, (Object)null));
      }
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentIndoorBinding var2 = this.indoorBinding;
      FragmentIndoorBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.layoutMain;
      Intrinsics.checkNotNullExpressionValue(var3, "layoutMain");
      return var3;
   }

   public CompositeDisposable getRxSubs() {
      return (CompositeDisposable)this.rxSubs$delegate.getValue();
   }

   public IndoorViewModel getViewModel() {
      IndoorViewModel var1 = this.viewModel;
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

   @kotlin.Deprecated(
      message = "Deprecated in Java"
   )
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      boolean var4;
      if (!this.forceRefresh && var1 != REQUEST_CODE_CONNECT_PRODUCT) {
         var4 = false;
      } else {
         var4 = true;
      }

      this.forceRefresh = var4;
      if (var1 == REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED) {
         this.handleDeviceDetailsDialogClosed();
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      boolean var2 = true;
      if (var1 != null) {
         var2 = var1.getBoolean("SHOULD_CHECK_RATE_US_AND_WELCOME_HOME", true);
      }

      this.shouldCheckRateUsAndWelcomeHome = var2;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentIndoorBinding var10 = FragmentIndoorBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var10, "inflate(...)");
      FragmentActivity var4 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
      var10.setIndoorViewModel((IndoorViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var4)).get(IndoorViewModel.class)));
      IndoorViewModel var5 = var10.getIndoorViewModel();
      if (var5 != null) {
         this.setViewModel(var5);
         var10.listDevices.setAdapter(this.getAdapter());
         RecyclerView.ItemAnimator var6 = var10.listDevices.getItemAnimator();
         SimpleItemAnimator var7;
         if (var6 instanceof SimpleItemAnimator) {
            var7 = (SimpleItemAnimator)var6;
         } else {
            var7 = null;
         }

         if (var7 != null) {
            var7.setSupportsChangeAnimations(false);
         }

         this.indoorBinding = var10;
         FragmentIndoorBinding var8 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
            var8 = null;
         }

         View var9 = var8.getRoot();
         Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
         return var9;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onDestroy() {
      this.clearProgressFragment();
      super.onDestroy();
   }

   public void onResume() {
      super.onResume();
      IndoorViewModel var2 = this.getViewModel();
      boolean var1;
      if (this.getHasBeenPaused() && !this.forceRefresh) {
         var1 = false;
      } else {
         var1 = true;
      }

      var2.refreshDeviceList(var1);
      this.forceRefresh = false;
      CompositeDisposable var3 = this.getRxSubs();
      Observable var4 = this.getDeviceSelectPublisher().throttleFirst(1L, TimeUnit.SECONDS);
      Intrinsics.checkNotNullExpressionValue(var4, "throttleFirst(...)");
      var3.add(RxExtensionsKt.subscribeAndLogE(var4, new IndoorFragment$$ExternalSyntheticLambda8(this)));
      CompositeDisposable var5 = this.getRxSubs();
      Observable var9 = this.getAutoModePublisher().throttleLatest(1000L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var9, "throttleLatest(...)");
      var5.add(RxExtensionsKt.subscribeAndLogE(var9, new IndoorFragment$$ExternalSyntheticLambda9(this)));
      var5 = this.getRxSubs();
      var9 = this.getNightModePublisher().throttleLatest(1000L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var9, "throttleLatest(...)");
      var5.add(RxExtensionsKt.subscribeAndLogE(var9, new IndoorFragment$$ExternalSyntheticLambda10(this)));
      var5 = this.getRxSubs();
      var9 = this.getStandByModePublisher().throttleLatest(1000L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var9, "throttleLatest(...)");
      var5.add(RxExtensionsKt.subscribeAndLogE(var9, new IndoorFragment$$ExternalSyntheticLambda12(this)));
      CompositeDisposable var12 = this.getRxSubs();
      Observable var8 = this.getOfflineClickPublisher().throttleLatest(1000L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var8, "throttleLatest(...)");
      var12.add(RxExtensionsKt.subscribeAndLogE(var8, new IndoorFragment$$ExternalSyntheticLambda13(this)));
   }

   public void onSaveInstanceState(Bundle var1) {
      Intrinsics.checkNotNullParameter(var1, "outState");
      var1.putBoolean("SHOULD_CHECK_RATE_US_AND_WELCOME_HOME", this.shouldCheckRateUsAndWelcomeHome);
      super.onSaveInstanceState(var1);
   }

   public void onStart() {
      super.onStart();
      if (this.getViewModel().shouldShowInAppReview()) {
         this.requestInAppReview();
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentIndoorBinding var3 = this.indoorBinding;
      Object var7 = null;
      FragmentIndoorBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var4 = null;
      }

      var4.ivAddFooter.setOnClickListener(new IndoorFragment$$ExternalSyntheticLambda5(this));
      var3 = this.indoorBinding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var4 = null;
      }

      var4.btnAddProduct.setOnClickListener(new IndoorFragment$$ExternalSyntheticLambda6(this));
      this.observeViewModel();
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final IndoorFragment this$0;

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
               this.this$0.getAdapter().notifyCountdownAndTimerChanged();
            } else {
               ResultKt.throwOnFailure(var1);
            }

            while(true) {
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (DelayKt.delay(1000L, var4) == var3) {
                  return var3;
               }

               this.this$0.getAdapter().notifyCountdownAndTimerChanged();
            }
         }
      }, 3, (Object)null);
      var4 = this.indoorBinding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("indoorBinding");
         var4 = (FragmentIndoorBinding)var7;
      }

      var4.slAlarm.setOnClickListener(new IndoorFragment$$ExternalSyntheticLambda7(this));
   }

   public void openDeviceDetails(Device var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS().getViewModelStore().clear();
      UserInfoCollectionsManager.INSTANCE.addRecord(UserInfoItem.DEVICE_MAC, var1.getMac(), false);
      UserInfoCollectionsManager var4 = UserInfoCollectionsManager.INSTANCE;
      UserInfoItem var3 = UserInfoItem.DEVICE_SERIAL;
      StringBuilder var5 = new StringBuilder();
      var5.append(var1.getUid());
      var5.append('_');
      var5.append(var1.getSerial());
      var4.addRecord(var3, var5.toString(), false);
      UserInfoCollectionsManager.addRecord$default(UserInfoCollectionsManager.INSTANCE, UserInfoItem.DEVICE_SENSOR_DATA, "", false, 4, (Object)null);
      FragmentActivity var9 = this.getActivity();
      if (var9 != null) {
         if (DeviceKt.useV2UI(var1)) {
            FragmentManager var11 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var11, "getChildFragmentManager(...)");
            String var10 = var1.getUid();
            DialogFragment var6;
            if (!(var11.findFragmentByTag(var10) instanceof DeviceDetailsV2DialogFragment) && !var11.isStateSaved()) {
               var6 = DeviceDetailsV2DialogFragment.Companion.newInstance(var1, var2);
               ((DialogFragment)var6).show(var11, var10);
            } else {
               var6 = null;
            }

            var6 = var6;
            if (var6 != null) {
               FragmentKt.setFragmentResultListener((Fragment)var6, "REQUEST_KEY_DEVICE_DETAILS_CLOSED", new IndoorFragment$$ExternalSyntheticLambda15(this));
               return;
            }
         } else {
            Fragment var12 = var9.getSupportFragmentManager().findFragmentByTag("Device_Details_Dialog");
            if (var12 != null) {
               Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment");
               ((DeviceDetailsDialogFragment)var12).dismiss();
            }

            DeviceDetailsDialogFragment var8 = DeviceDetailsDialogFragment.Companion.newInstance(var1, var2);
            var8.setTargetFragment(this, REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED);
            var8.show(var9.getSupportFragmentManager(), "Device_Details_Dialog");
         }
      }

   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(IndoorViewModel var1) {
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
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/android/fragment/IndoorFragment$Companion;", "", "<init>", "()V", "REQUEST_CODE_ENABLE_BT", "", "REQUEST_BLE_DELTA_MILLIS", "BLUEAIR_URL", "", "REQUEST_CODE_CONNECT_PRODUCT", "getREQUEST_CODE_CONNECT_PRODUCT", "()I", "REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED", "getREQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final int getREQUEST_CODE_CONNECT_PRODUCT() {
         return IndoorFragment.REQUEST_CODE_CONNECT_PRODUCT;
      }

      public final int getREQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED() {
         return IndoorFragment.REQUEST_CODE_DEVICE_DETAILS_DIALOG_CLOSED;
      }
   }
}
