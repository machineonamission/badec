package com.blueair.adddevice.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.Lifecycle.State;
import com.blueair.adddevice.R;
import com.blueair.adddevice.activity.AddDeviceActivityLegacy;
import com.blueair.adddevice.adapter.ScannedDevicesAdapter;
import com.blueair.adddevice.databinding.FragmentBluetoothScanResultBinding;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.adddevice.model.BluetoothConnectingInfo;
import com.blueair.adddevice.model.BluetoothConnectingState;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.adddevice.viewholder.BluetoothEnableHolder;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.auth.LocationService;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
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
   d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020E2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010N\u001a\u00020\u001aH\u0016J\u0010\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&H\u0002J\u0018\u0010Q\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u00020\u001aH\u0016J\b\u0010U\u001a\u00020\u001aH\u0016J\b\u0010V\u001a\u00020\u001aH\u0002J\b\u0010W\u001a\u00020\u001aH\u0002J\b\u0010X\u001a\u00020\u001aH\u0002J\u0010\u0010Y\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&H\u0002J\u0012\u0010Z\u001a\u00020\u001a2\b\b\u0002\u0010[\u001a\u00020\u001cH\u0002J\u0016\u0010\\\u001a\u00020\u001a2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020&0^H\u0002J\b\u0010_\u001a\u00020\u001aH\u0002J\b\u0010`\u001a\u00020\u001aH\u0002J\b\u0010a\u001a\u00020\u001aH\u0003J-\u0010b\u001a\u00020\u001a2\u0006\u0010c\u001a\u00020S2\u000e\u0010d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0A2\u0006\u0010e\u001a\u00020fH\u0017¢\u0006\u0002\u0010gR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R!\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010*\u001a\u0004\b,\u0010(R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b<\u0010=R(\u0010?\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b B*\n\u0012\u0004\u0012\u00020\b\u0018\u00010A0A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010h\u001a\u00020iX\u0096\u0005¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0018\u0010l\u001a\u00020\u0002X\u0096\u000f¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006q"},
   d2 = {"Lcom/blueair/adddevice/fragment/BluetoothScanResultFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/adddevice/databinding/FragmentBluetoothScanResultBinding;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "showProgress", "", "shouldShowProgress", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "deviceSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/BluetoothDevice;", "getDeviceSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "legacySelectPublisher", "getLegacySelectPublisher", "legacySelectPublisher$delegate", "deviceSelectedStateListening", "Lio/reactivex/disposables/Disposable;", "pendingConnectableDevice", "connectInstructionsDialog", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "connectJob", "Lkotlinx/coroutines/Job;", "adapter", "Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter;", "getAdapter", "()Lcom/blueair/adddevice/adapter/ScannedDevicesAdapter;", "adapter$delegate", "bluetoothEnableHolder", "Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder;", "getBluetoothEnableHolder", "()Lcom/blueair/adddevice/viewholder/BluetoothEnableHolder;", "bluetoothEnableHolder$delegate", "requestBluetoothPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "deviceDetectJob", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "startConnectBleDevice", "device", "connectBleDevice", "attempt", "", "onPause", "onDestroy", "reset", "deselectDevice", "onSelectionLost", "showBluetoothTroubleshooting", "handleInitialState", "hasBluetoothEnabled", "showScanningResults", "devices", "", "checkHideScanningFragment", "checkTitleVisible", "showEnableLocationBluetooth", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothScanResultFragment extends BaseFragment implements ProgressFragment, BaseFragmentInterface {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BluetoothScanResultFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BluetoothScanResultFragment.class, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BluetoothScanResultFragment.class, "deviceSelectPublisher", "getDeviceSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BluetoothScanResultFragment.class, "legacySelectPublisher", "getLegacySelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   private final AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
   private final Lazy adapter$delegate;
   private FragmentBluetoothScanResultBinding binding;
   private final Lazy bluetoothEnableHolder$delegate;
   private ConnectInstructionsDialog connectInstructionsDialog;
   private Job connectJob;
   private Job deviceDetectJob;
   private final LazyPublishSubject deviceSelectPublisher$delegate;
   private Disposable deviceSelectedStateListening;
   private final LazyPublishSubject legacySelectPublisher$delegate;
   private final Lazy locationPermissionTracker$delegate;
   private final Lazy locationService$delegate;
   private BluetoothDevice pendingConnectableDevice;
   private ProgressBlockerView progressBlockerView;
   private final ActivityResultLauncher requestBluetoothPermissionsLauncher;
   private final String screenName = "add_device_scan";

   // $FF: synthetic method
   public static void $r8$lambda$7B4Fr8KZZUD_yle8YEXjV4xkPFg(BluetoothScanResultFragment var0, DialogInterface var1, int var2) {
      onResume$lambda$19$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$8vVl6Ru84w1gjqytdQ9ObsjXwqw(BluetoothScanResultFragment var0, BluetoothDevice var1) {
      return onResume$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$HS6OcH2Wc8eS_adV0nmVrDUP980/* $FF was: $r8$lambda$HS6OcH2Wc8eS-adV0nmVrDUP980*/(BluetoothScanResultFragment var0, ConnectInstructionsDialog var1, BluetoothDevice var2) {
      return startConnectBleDevice$lambda$25$lambda$24$lambda$23(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Ipj8brBB4WzS257y9cs0tcWwJZk(Function1 var0, Object var1) {
      onResume$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$JPehKX_Q43MlBSrAHl6X8tXu6zI/* $FF was: $r8$lambda$JPehKX-Q43MlBSrAHl6X8tXu6zI*/(BluetoothScanResultFragment var0, String var1, Bundle var2) {
      return startConnectBleDevice$lambda$27$lambda$26(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$NfBKGUC4la_PPkKxfNIqyuFQE4U/* $FF was: $r8$lambda$NfBKGUC4la-PPkKxfNIqyuFQE4U*/(BluetoothScanResultFragment var0, String var1, Bundle var2) {
      return showBluetoothTroubleshooting$lambda$35(var0, var1, var2);
   }

   // $FF: synthetic method
   public static ScannedDevicesAdapter $r8$lambda$OFxnDMpDNrNV9wXrEl8I0mDQe_Y(BluetoothScanResultFragment var0) {
      return adapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PEwHCxSTt8EWrZ6SoPjvV0WhvGM(BluetoothScanResultFragment var0, BluetoothDevice var1, boolean var2) {
      return onSelectionLost$lambda$33$lambda$32(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Rv8__fGc8wv_lTKb0en81IZnVMk/* $FF was: $r8$lambda$Rv8__fGc8wv-lTKb0en81IZnVMk*/(BluetoothScanResultFragment var0, Map var1) {
      requestBluetoothPermissionsLauncher$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$TiTh13fbAXRA2mFldluvEI6NXjo(BluetoothScanResultFragment var0, BleDeviceState var1) {
      return connectBleDevice$lambda$30$lambda$29(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$__4B69sdDJRuIqfZhVrJp_IrOTA/* $FF was: $r8$lambda$_-4B69sdDJRuIqfZhVrJp-IrOTA*/(Function1 var0, Object var1) {
      return onResume$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_0CdTta6sSYJcY39fq3A6sFGOkA(DialogInterface var0, int var1) {
      onResume$lambda$19$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_WzVIZyP3u__QM_3gSPmcE93rTI(BluetoothScanResultFragment var0, String var1, Bundle var2) {
      return onCreateView$lambda$8$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$iRzahfV_Sck9e4qKhTwZXDB7VnM/* $FF was: $r8$lambda$iRzahfV-Sck9e4qKhTwZXDB7VnM*/(BluetoothScanResultFragment var0, View var1) {
      showEnableLocationBluetooth$lambda$38(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$j_8nV1T8ISZrI17RTzGOtaMmFxA/* $FF was: $r8$lambda$j-8nV1T8ISZrI17RTzGOtaMmFxA*/(BluetoothScanResultFragment var0, BluetoothDevice var1, boolean var2) {
      return onResume$lambda$19$lambda$18$lambda$17(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jj_NaL46VVbWbn_HPc_0dwdG6O0/* $FF was: $r8$lambda$jj-NaL46VVbWbn-HPc_0dwdG6O0*/(Function1 var0, Object var1) {
      onResume$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$rggGu0lt0pWQelNUyD91BMVGDGY(BluetoothScanResultFragment var0, View var1) {
      onCreateView$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$skXwMKpEW_RO48wm0eQ1DhA4rEo/* $FF was: $r8$lambda$skXwMKpEW-RO48wm0eQ1DhA4rEo*/(BluetoothScanResultFragment var0, Boolean var1) {
      return onResume$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static BluetoothEnableHolder $r8$lambda$tSXSepFCn37oOC5o_3ieGW_V4CM(BluetoothScanResultFragment var0) {
      return bluetoothEnableHolder_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uOiNOCwJpNdGyNA9NTb7t126Erc(Throwable var0) {
      return onResume$lambda$11(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wk6S_i_FiG1QkOZLg6Lg_W7wPQQ(BluetoothScanResultFragment var0, BluetoothDevice var1) {
      return onResume$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zPplBUyEbTCJrB3gXKeu7uYJzFI(BluetoothScanResultFragment var0, Boolean var1) {
      return onResume$lambda$21(var0, var1);
   }

   public BluetoothScanResultFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, LocationService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.locationService$delegate = var3.provideDelegate(this, var5[0]);
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationPermissionTracker$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationPermissionTracker.class)), (Object)null).provideDelegate(this, var5[1]);
      this.deviceSelectPublisher$delegate = new LazyPublishSubject();
      this.legacySelectPublisher$delegate = new LazyPublishSubject();
      this.adapter$delegate = LazyKt.lazy(new BluetoothScanResultFragment$$ExternalSyntheticLambda4(this));
      this.bluetoothEnableHolder$delegate = LazyKt.lazy(new BluetoothScanResultFragment$$ExternalSyntheticLambda5(this));
      ActivityResultLauncher var4 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestMultiplePermissions()), new BluetoothScanResultFragment$$ExternalSyntheticLambda6(this));
      Intrinsics.checkNotNullExpressionValue(var4, "registerForActivityResult(...)");
      this.requestBluetoothPermissionsLauncher = var4;
   }

   private static final ScannedDevicesAdapter adapter_delegate$lambda$0(BluetoothScanResultFragment var0) {
      return new ScannedDevicesAdapter(var0.getDeviceSelectPublisher(), var0.getLegacySelectPublisher(), var0.getLocationService());
   }

   private static final BluetoothEnableHolder bluetoothEnableHolder_delegate$lambda$1(BluetoothScanResultFragment var0) {
      BluetoothEnableHolder.Companion var2 = BluetoothEnableHolder.Companion;
      FragmentBluetoothScanResultBinding var1 = var0.binding;
      FragmentBluetoothScanResultBinding var3 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      FrameLayout var4 = var3.scanningFragment;
      Intrinsics.checkNotNullExpressionValue(var4, "scanningFragment");
      return var2.newInstance((ViewGroup)var4);
   }

   private final void checkHideScanningFragment() {
      if (!this.getAdapter().getHasEmptyState()) {
         FragmentBluetoothScanResultBinding var2 = this.binding;
         FragmentBluetoothScanResultBinding var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var1 = null;
         }

         var1.scanningFragment.setVisibility(8);
      }

   }

   private final void checkTitleVisible() {
      FragmentBluetoothScanResultBinding var3 = this.binding;
      FragmentBluetoothScanResultBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      Group var4 = var2.groupTitle;
      Intrinsics.checkNotNullExpressionValue(var4, "groupTitle");
      View var5 = (View)var4;
      byte var1;
      if (!this.getAdapter().getHasEmptyState()) {
         var1 = 0;
      } else {
         var1 = 8;
      }

      var5.setVisibility(var1);
   }

   private final void connectBleDevice(BluetoothDevice var1, int var2) {
      Observable var3 = this.getViewModel().selectBluetoothDevice(var1, true);
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("connectBleDevice: device = ");
      var4.append(var1);
      var4.append(", attempt = ");
      var4.append(var2);
      var4.append(", result = ");
      var4.append(var3);
      var4.append(", hasSelectedBleDevice = ");
      var4.append(this.getViewModel().getHasSelectedBleDevice());
      var5.d(var4.toString(), new Object[0]);
      if (var2 >= 2 && var3 != null) {
         Disposable var6 = RxExtensionsKt.subscribeAndLogE(RxExtensionsKt.uiThread(var3), new BluetoothScanResultFragment$$ExternalSyntheticLambda7(this));
         this.getRxSubs().add(var6);
         this.deviceSelectedStateListening = var6;
      }

      ConnectInstructionsDialog var7 = this.connectInstructionsDialog;
      if (var7 != null && var7.isVisible()) {
         this.getAdapter().setConnectingInfo(new BluetoothConnectingInfo(var1.getMac(), BluetoothConnectingState.Connecting.INSTANCE));
      }

      this.connectJob = BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final int $attempt;
         final BluetoothDevice $device;
         private Object L$0;
         boolean Z$0;
         int label;
         final BluetoothScanResultFragment this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$attempt = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, this.$device, this.$attempt, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label51: {
               CoroutineScope var6 = (CoroutineScope)this.L$0;
               Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     ResultKt.throwOnFailure(var1);
                     break label51;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  Deferred var4 = BuildersKt.async$default(var6, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final BluetoothScanResultFragment this$0;

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
                           if (var2 == 1) {
                              ResultKt.throwOnFailure(var1);
                              return var1;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        } else {
                           ResultKt.throwOnFailure(var1);
                           AddDeviceViewModel var4 = this.this$0.getViewModel();
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           Object var6 = var4.connectAndEstablishSessionAndStartProvisioningForBleDeviceSync(var5);
                           return var6 == var3 ? var3 : var6;
                        }
                     }
                  }, 2, (Object)null);
                  Continuation var7 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
                  this.label = 1;
                  Object var12 = var4.await(var7);
                  var1 = var12;
                  if (var12 == var5) {
                     return var5;
                  }
               }

               boolean var3 = (Boolean)var1;
               Timber.Forest var8 = Timber.Forest;
               StringBuilder var13 = new StringBuilder("deviceSelectPublisher: connectAndEstablishSessionForBleDeviceSync result = ");
               var13.append(var3);
               var8.d(var13.toString(), new Object[0]);
               ConnectInstructionsDialog var9 = this.this$0.connectInstructionsDialog;
               if (var9 == null || !var9.isVisible()) {
                  this.this$0.getAdapter().setConnectingInfo((BluetoothConnectingInfo)null);
                  return Unit.INSTANCE;
               }

               if (var3) {
                  this.this$0.getAdapter().setConnectingInfo(new BluetoothConnectingInfo(this.$device.getMac(), BluetoothConnectingState.Connected.INSTANCE));
                  var9 = this.this$0.connectInstructionsDialog;
                  if (var9 != null) {
                     var9.dismissAllowingStateLoss();
                  }

                  this.this$0.getViewModel().gotoWifiList();
                  return Unit.INSTANCE;
               }

               if (this.$attempt >= 2) {
                  this.this$0.onSelectionLost();
                  return Unit.INSTANCE;
               }

               Continuation var10 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var6);
               this.Z$0 = var3;
               this.label = 2;
               if (DelayKt.delay(10000L, var10) == var5) {
                  return var5;
               }
            }

            this.this$0.connectBleDevice(this.$device, this.$attempt + 1);
            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final Unit connectBleDevice$lambda$30$lambda$29(BluetoothScanResultFragment var0, BleDeviceState var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("deviceSelectPublisher: state = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      if (Intrinsics.areEqual(var1, BleDeviceState.Disconnected.INSTANCE)) {
         var0.onSelectionLost();
         Disposable var4 = var0.deviceSelectedStateListening;
         if (var4 != null) {
            var0.getRxSubs().remove(var4);
            var4.dispose();
            var0.deviceSelectedStateListening = null;
         }
      }

      return Unit.INSTANCE;
   }

   private final void deselectDevice() {
      if (this.getViewModel().getHasSelectedBleDevice()) {
         AddDeviceViewModel var3;
         String var4;
         label17: {
            var3 = this.getViewModel();
            BleDeviceError var1 = this.getViewModel().getSelectedBleDeviceError();
            if (var1 != null) {
               String var2 = var1.getMessage();
               var4 = var2;
               if (var2 != null) {
                  break label17;
               }
            }

            var4 = "";
         }

         var3.postAnalyticsEvent(new AnalyticEvent.BT_PRODUCT_SELECTED_ERROR(var4));
      }

      this.getAdapter().setConnectingInfo((BluetoothConnectingInfo)null);
      this.getViewModel().deselectBluetoothDevice();
      Disposable var5 = this.deviceSelectedStateListening;
      if (var5 != null) {
         this.getRxSubs().remove(var5);
      }

      this.deviceSelectedStateListening = null;
   }

   private final ScannedDevicesAdapter getAdapter() {
      return (ScannedDevicesAdapter)this.adapter$delegate.getValue();
   }

   private final BluetoothEnableHolder getBluetoothEnableHolder() {
      return (BluetoothEnableHolder)this.bluetoothEnableHolder$delegate.getValue();
   }

   private final PublishSubject getDeviceSelectPublisher() {
      return this.deviceSelectPublisher$delegate.getValue(this, $$delegatedProperties[2]);
   }

   private final PublishSubject getLegacySelectPublisher() {
      return this.legacySelectPublisher$delegate.getValue(this, $$delegatedProperties[3]);
   }

   private final LocationPermissionTracker getLocationPermissionTracker() {
      return (LocationPermissionTracker)this.locationPermissionTracker$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final void handleInitialState(boolean var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("handleInitialState: hasBluetoothEnabled = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      FragmentBluetoothScanResultBinding var4 = this.binding;
      Object var20 = null;
      FragmentBluetoothScanResultBinding var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.scanningFragment.removeAllViews();
      var4 = this.binding;
      var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      label57: {
         var6.scanningFragment.setVisibility(0);
         this.getViewModel().getLvDeviceScanned().setValue(false);
         if (VERSION.SDK_INT < 31) {
            LocationUtils var5 = LocationUtils.INSTANCE;
            var4 = this.binding;
            var6 = var4;
            if (var4 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var6 = null;
            }

            Context var9 = var6.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(var9, "getContext(...)");
            if (!var5.isLocationPermissionGranted(var9)) {
               break label57;
            }
         }

         if (VERSION.SDK_INT < 31) {
            LocationUtils var27 = LocationUtils.INSTANCE;
            var4 = this.binding;
            var6 = var4;
            if (var4 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var6 = null;
            }

            Context var11 = var6.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(var11, "getContext(...)");
            if (!var27.isLocationEnabled(var11)) {
               break label57;
            }
         }

         BluetoothUtils var12 = BluetoothUtils.INSTANCE;
         Context var26 = this.requireContext();
         Intrinsics.checkNotNullExpressionValue(var26, "requireContext(...)");
         if (var12.hasBluetoothPermissions(var26) && var1) {
            Timber.Forest var13 = Timber.Forest;
            StringBuilder var21 = new StringBuilder("startBluetoothScanning: childFragmentManager = ");
            var21.append(this.getChildFragmentManager());
            var13.d(var21.toString(), new Object[0]);
            this.getViewModel().startBluetoothScanning();
            FragmentBluetoothScanResultBinding var22 = this.binding;
            FragmentBluetoothScanResultBinding var14 = var22;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var14 = null;
            }

            AppCompatTextView var15 = var14.btnHelp;
            Intrinsics.checkNotNullExpressionValue(var15, "btnHelp");
            ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
            FragmentManager var16 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var16, "getChildFragmentManager(...)");
            FragmentTransaction var17 = var16.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(var17, "beginTransaction()");
            var17.replace(R.id.scanning_fragment, BluetoothScanningFragment.Companion.newInstance(), (String)null);
            var17.commit();
            if (this.deviceDetectJob == null) {
               this.deviceDetectJob = BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
                  int label;
                  final BluetoothScanResultFragment this$0;

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
                        if (DelayKt.delay(500L, var4) == var3) {
                           return var3;
                        }
                     }

                     this.this$0.getAdapter().setHideSingleDevice(false);
                     this.this$0.checkHideScanningFragment();
                     this.this$0.checkTitleVisible();
                     return Unit.INSTANCE;
                  }
               }, 3, (Object)null);
               return;
            }

            return;
         }
      }

      this.showEnableLocationBluetooth();
      var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (FragmentBluetoothScanResultBinding)var20;
      }

      AppCompatTextView var19 = var6.btnHelp;
      Intrinsics.checkNotNullExpressionValue(var19, "btnHelp");
      ViewExtensionsKt.hide((View)var19);
      if (!this.getAdapter().getHasEmptyState()) {
         this.getViewModel().resetScanResult();
      }

   }

   // $FF: synthetic method
   static void handleInitialState$default(BluetoothScanResultFragment var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.getViewModel().isBluetoothEnabled();
      }

      var0.handleInitialState(var1);
   }

   private static final void onCreateView$lambda$8(BluetoothScanResultFragment var0, View var1) {
      FragmentManager var4 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
      boolean var2 = var4.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog;
      Object var3 = null;
      TroubleshootingDialog var5 = (TroubleshootingDialog)var3;
      if (!var2) {
         var5 = (TroubleshootingDialog)var3;
         if (!var4.isStateSaved()) {
            var5 = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, "action_type_bluetooth_cant_see", (Device)null, 2, (Object)null);
            ((DialogFragment)var5).show(var4, "TroubleshootingDialog");
         }
      }

      var5 = var5;
      if (var5 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var5, "TroubleshootingDialog", new BluetoothScanResultFragment$$ExternalSyntheticLambda0(var0));
      }

   }

   private static final Unit onCreateView$lambda$8$lambda$7(BluetoothScanResultFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_retry")) {
         FragmentBluetoothScanResultBinding var4 = var0.binding;
         FragmentBluetoothScanResultBinding var3 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var3 = null;
         }

         var3.scanningFragment.setVisibility(0);
         var0.getViewModel().resetScanResult();
      }

      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$10(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final Unit onResume$lambda$11(Throwable var0) {
      Intrinsics.checkNotNullParameter(var0, "t");
      Timber.Forest.e(var0, "Connection Change Observer failed", new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$12(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final boolean onResume$lambda$13(BluetoothScanResultFragment var0, BluetoothDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      return var0.getAdapter().getConnectingInfo() == null;
   }

   private static final boolean onResume$lambda$14(Function1 var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "p0");
      return (Boolean)var0.invoke(var1);
   }

   private static final Unit onResume$lambda$19(BluetoothScanResultFragment var0, BluetoothDevice var1) {
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("deviceSelectPublisher: device = ");
      var6.append(var1);
      var5.d(var6.toString(), new Object[0]);
      var0.getViewModel().postAnalyticsEvent(new AnalyticEvent.BT_PRODUCT_SELECTED(var1.getMac()));
      if (var1.isUnknownSku()) {
         (new AlertDialog.Builder(var0.requireContext())).setTitle(com.blueair.viewcore.R.string.update_the_app_title).setMessage(com.blueair.viewcore.R.string.go_to_market_and_update_app).setPositiveButton(com.blueair.viewcore.R.string.snackbar_ok, new BluetoothScanResultFragment$$ExternalSyntheticLambda10(var0)).setNegativeButton(com.blueair.viewcore.R.string.later, new BluetoothScanResultFragment$$ExternalSyntheticLambda12()).show();
      } else if (!Intrinsics.areEqual(var1.isOnline(), true)) {
         if (Intrinsics.areEqual(var1.isOnline(), false)) {
            FragmentManager var7 = var0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var7, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var7.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var7.isStateSaved()) {
               ConfirmationDialogLeftAligned.Companion var8 = ConfirmationDialogLeftAligned.Companion;
               int var2 = com.blueair.viewcore.R.string.label_reconnect_your_device;
               int var4 = com.blueair.viewcore.R.string.reconnect_device_msg;
               int var3 = com.blueair.viewcore.R.string.btn_cancel;
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var8, var2, (Integer)null, var4, com.blueair.viewcore.R.string.confirmation_positive_default, var3, false, false, false, false, (String[])null, (String)null, (Integer)null, new BluetoothScanResultFragment$$ExternalSyntheticLambda13(var0, var1), 3936, (Object)null)).show(var7, "ConfirmationDialogLeftAligned");
            }
         } else {
            Intrinsics.checkNotNull(var1);
            var0.startConnectBleDevice(var1);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onResume$lambda$19$lambda$15(BluetoothScanResultFragment var0, DialogInterface var1, int var2) {
      var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var0.getLocationService().getMarketLink())));
   }

   private static final void onResume$lambda$19$lambda$16(DialogInterface var0, int var1) {
   }

   private static final Unit onResume$lambda$19$lambda$18$lambda$17(BluetoothScanResultFragment var0, BluetoothDevice var1, boolean var2) {
      if (var2) {
         BuildersKt.launch$default(var0, (CoroutineContext)null, (CoroutineStart)null, new Function2(var0, var1, (Continuation)null) {
            final BluetoothDevice $device;
            int label;
            final BluetoothScanResultFragment this$0;

            {
               this.this$0 = var1;
               this.$device = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, var2));
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
                  Function2 var6 = new Function2(this.this$0, this.$device, (Continuation)null) {
                     final BluetoothDevice $device;
                     int label;
                     final BluetoothScanResultFragment this$0;

                     {
                        this.this$0 = var1;
                        this.$device = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, var2));
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
                           AddDeviceViewModel var6 = this.this$0.getViewModel();
                           BluetoothDevice var5 = this.$device;
                           Intrinsics.checkNotNull(var5);
                           Continuation var4 = (Continuation)this;
                           this.label = 1;
                           if (var6.removeOwnedDevice(var5, var4) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (BuildersKt.withContext(var4, var6, var5) == var3) {
                     return var3;
                  }
               }

               this.this$0.showProgress(false);
               var1 = this.this$0;
               BluetoothDevice var8 = this.$device;
               Intrinsics.checkNotNull(var8);
               var1.startConnectBleDevice(var8);
               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$21(BluetoothScanResultFragment var0, Boolean var1) {
      if (var0.isAdded()) {
         Context var2 = var0.getContext();
         if (var2 != null) {
            var2.startActivity(new Intent(var2, AddDeviceActivityLegacy.class));
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$9(BluetoothScanResultFragment var0, Boolean var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("connectionChangedObserver: hasBluetooth = ");
      var3.append(var1);
      var3.append(", hasSelectedBleDevice = ");
      var3.append(var0.getViewModel().getHasSelectedBleDevice());
      var2.d(var3.toString(), new Object[0]);
      if (!var1) {
         if (var0.getViewModel().getHasSelectedBleDevice()) {
            var0.onSelectionLost();
         }

         var0.getViewModel().stopBluetoothScanning();
      }

      Intrinsics.checkNotNull(var1);
      var0.handleInitialState(var1);
      return Unit.INSTANCE;
   }

   private final void onSelectionLost() {
      BluetoothDevice var5 = this.getViewModel().getSelectedUiDevice();
      if (var5 != null) {
         Timber.Forest var6 = Timber.Forest;
         StringBuilder var7 = new StringBuilder("onSelectionLost: ");
         var7.append(var5);
         var6.d(var7.toString(), new Object[0]);
         this.deselectDevice();

         try {
            Timber.Forest.d("show connection lost dialog", new Object[0]);
            FragmentManager var11 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var11, "getChildFragmentManager(...)");
            if (!(var11.findFragmentByTag("TroubleConnectingBluetooth") instanceof ConfirmationDialogLeftAligned)) {
               FragmentManager var13 = this.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var13, "getChildFragmentManager(...)");
               if (!(var13.findFragmentByTag("TroubleConnectingBluetooth") instanceof ConfirmationDialogLeftAligned) && !var13.isStateSaved()) {
                  ConfirmationDialogLeftAligned.Companion var8 = ConfirmationDialogLeftAligned.Companion;
                  int var4 = com.blueair.viewcore.R.string.label_trouble_connecting_bluetooth;
                  int var3 = com.blueair.viewcore.R.string.hint_trouble_connecting_bluetooth;
                  int var1 = com.blueair.viewcore.R.string.connection_to_purifier_try_again;
                  int var2 = com.blueair.viewcore.R.string.action_read_tips;
                  BluetoothScanResultFragment$$ExternalSyntheticLambda9 var12 = new BluetoothScanResultFragment$$ExternalSyntheticLambda9(this, var5);
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var8, var4, (Integer)null, var3, var1, var2, false, false, false, false, (String[])null, (String)null, (Integer)null, var12, 3936, (Object)null)).show(var13, "TroubleConnectingBluetooth");
               }
            }
         } catch (Throwable var10) {
            Timber.Forest.e(var10, "failed to show connection lost dialog", new Object[0]);
            return;
         }
      }

   }

   private static final Unit onSelectionLost$lambda$33$lambda$32(BluetoothScanResultFragment var0, BluetoothDevice var1, boolean var2) {
      ConnectInstructionsDialog var3 = var0.connectInstructionsDialog;
      if (var3 != null) {
         var3.dismissAllowingStateLoss();
      }

      if (var2) {
         var0.getViewModel().restart();
      } else {
         var0.showBluetoothTroubleshooting(var1);
      }

      return Unit.INSTANCE;
   }

   private static final void requestBluetoothPermissionsLauncher$lambda$5(BluetoothScanResultFragment var0, Map var1) {
      boolean var2;
      label267: {
         Iterable var20 = (Iterable)var1.values();
         if (!(var20 instanceof Collection) || !((Collection)var20).isEmpty()) {
            Iterator var21 = var20.iterator();

            while(var21.hasNext()) {
               if (!(Boolean)var21.next()) {
                  var2 = false;
                  break label267;
               }
            }
         }

         var2 = true;
      }

      boolean var3 = BluetoothUtils.INSTANCE.shouldShowBluetoothRequestPermissionDialog(var0);
      ViewUtils var4 = null;
      if (!var3 && !var2) {
         Intent var5 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
         StringBuilder var6 = new StringBuilder("package:");
         Context var22 = var0.getContext();
         String var23;
         if (var22 != null) {
            var23 = var22.getPackageName();
         } else {
            var23 = null;
         }

         var6.append(var23);
         var5.setData(Uri.parse(var6.toString()));

         label243: {
            Throwable var10000;
            label265: {
               try {
                  Result.Companion var24 = Result.Companion;
                  var30 = var0.getContext();
               } catch (Throwable var18) {
                  var10000 = var18;
                  boolean var10001 = false;
                  break label265;
               }

               Unit var25 = var4;
               if (var30 != null) {
                  try {
                     var30.startActivity(var5);
                     var25 = Unit.INSTANCE;
                  } catch (Throwable var17) {
                     var10000 = var17;
                     boolean var31 = false;
                     break label265;
                  }
               }

               label235:
               try {
                  var27 = Result.constructor-impl(var25);
                  break label243;
               } catch (Throwable var16) {
                  var10000 = var16;
                  boolean var32 = false;
                  break label235;
               }
            }

            Throwable var26 = var10000;
            Result.Companion var28 = Result.Companion;
            var27 = Result.constructor-impl(ResultKt.createFailure(var26));
         }

         if (Result.exceptionOrNull-impl(var27) != null) {
            var4 = ViewUtils.INSTANCE;
            FragmentActivity var19 = var0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(var19, "requireActivity(...)");
            var4.showSnackbar((Activity)var19, com.blueair.viewcore.R.string.bluetooth_permission_12, ViewUtils.MessageType.INFO.INSTANCE);
         }

         Result.box-impl(var27);
      } else {
         handleInitialState$default(var0, false, 1, (Object)null);
      }
   }

   private final void reset() {
      this.deselectDevice();
      this.getViewModel().reset();
      Job var1 = this.deviceDetectJob;
      if (var1 != null) {
         kotlinx.coroutines.Job.DefaultImpls.cancel$default(var1, (CancellationException)null, 1, (Object)null);
      }

   }

   private final void showBluetoothTroubleshooting(BluetoothDevice var1) {
      FragmentManager var2 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
      DialogFragment var3;
      if (!(var2.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var2.isStateSaved()) {
         var3 = TroubleshootingDialog.Companion.newInstanceForBluetooth(var1);
         ((DialogFragment)var3).show(var2, "TroubleshootingDialog");
         var2.executePendingTransactions();
      } else {
         var3 = null;
      }

      var3 = var3;
      if (var3 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var3, "TroubleshootingDialog", new BluetoothScanResultFragment$$ExternalSyntheticLambda21(this));
      }

   }

   private static final Unit showBluetoothTroubleshooting$lambda$35(BluetoothScanResultFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("action_retry")) {
         var0.reset();
         handleInitialState$default(var0, false, 1, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private final void showEnableLocationBluetooth() {
      Timber.Forest.d("enableLocationPermission", new Object[0]);
      this.getBluetoothEnableHolder().getBinding().bleEnableBtn.setOnClickListener(new BluetoothScanResultFragment$$ExternalSyntheticLambda8(this));
      Context var5 = this.getContext();
      Object var2 = null;
      if (var5 != null) {
         BluetoothEnableHolder var4;
         Pair var9;
         label28: {
            var4 = this.getBluetoothEnableHolder();
            if (VERSION.SDK_INT < 31) {
               LocationUtils var6 = LocationUtils.INSTANCE;
               FragmentBluetoothScanResultBinding var3 = this.binding;
               FragmentBluetoothScanResultBinding var1 = var3;
               if (var3 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("binding");
                  var1 = null;
               }

               Context var7 = var1.rootLayout.getContext();
               Intrinsics.checkNotNullExpressionValue(var7, "getContext(...)");
               if (!var6.isLocationEnabled(var7)) {
                  var9 = new Pair(var5.getString(com.blueair.viewcore.R.string.label_allow_nearby_devices), var5.getString(com.blueair.viewcore.R.string.msg_allow_nearby_devices));
                  break label28;
               }
            }

            BluetoothUtils var8 = BluetoothUtils.INSTANCE;
            Context var13 = this.requireContext();
            Intrinsics.checkNotNullExpressionValue(var13, "requireContext(...)");
            if (!var8.hasBluetoothPermissions(var13)) {
               var9 = new Pair(var5.getString(com.blueair.viewcore.R.string.label_allow_nearby_devices), var5.getString(com.blueair.viewcore.R.string.msg_allow_nearby_devices));
            } else if (!this.getViewModel().isBluetoothEnabled()) {
               var9 = new Pair(var5.getString(com.blueair.viewcore.R.string.label_turn_bluetooth_on), var5.getString(com.blueair.viewcore.R.string.msg_turn_bluetooth_on));
            } else {
               var9 = new Pair(var5.getString(com.blueair.viewcore.R.string.label_allow_nearby_devices), var5.getString(com.blueair.viewcore.R.string.msg_allow_nearby_devices));
            }
         }

         var4.update(var9);
      }

      FragmentBluetoothScanResultBinding var10 = this.binding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = (FragmentBluetoothScanResultBinding)var2;
      }

      FrameLayout var12 = var10.scanningFragment;
      View var11 = this.getBluetoothEnableHolder().itemView;
      FrameLayout.LayoutParams var14 = new FrameLayout.LayoutParams(this.getBluetoothEnableHolder().itemView.getLayoutParams());
      var14.gravity = 17;
      Unit var15 = Unit.INSTANCE;
      var12.addView(var11, (ViewGroup.LayoutParams)var14);
   }

   private static final void showEnableLocationBluetooth$lambda$38(BluetoothScanResultFragment var0, View var1) {
      AddDeviceUtils.INSTANCE.showEnableLocationBluetooth(var0, var0.getLocationPermissionTracker(), var0.requestBluetoothPermissionsLauncher);
   }

   private final void showScanningResults(List var1) {
      android.bluetooth.BluetoothDevice var4 = this.getViewModel().getSelectedBleDevice();
      if (var4 != null) {
         Iterator var3 = ((Iterable)var1).iterator();

         Object var2;
         do {
            if (!var3.hasNext()) {
               var2 = null;
               break;
            }

            var2 = var3.next();
         } while(!Intrinsics.areEqual(((BluetoothDevice)var2).getMac(), var4.getAddress()));

         if (var2 == null) {
            this.onSelectionLost();
         }
      }

      this.getAdapter().setDevices(var1);
      this.checkHideScanningFragment();
      this.checkTitleVisible();
      this.getViewModel().getLvDeviceScanned().setValue(((Collection)var1).isEmpty() ^ true);
   }

   private final void startConnectBleDevice(BluetoothDevice var1) {
      this.getViewModel().logStep0SelectDevice(var1);
      boolean var3 = var1.getButtonPressNeeded();
      boolean var2 = true;
      if (var3) {
         if (var1.getConnectable()) {
            this.getViewModel().logStep1ConnectionInstructions(var1, "detect");
            this.connectBleDevice(var1, 1);
         } else {
            var2 = false;
         }
      } else {
         this.getViewModel().logStep1ConnectionInstructions(var1, "null");
         this.connectBleDevice(var1, 1);
      }

      FragmentManager var5 = this.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConnectInstructionsDialog", "getSimpleName(...)");
      DialogFragment var4;
      if (!(var5.findFragmentByTag("ConnectInstructionsDialog") instanceof ConnectInstructionsDialog) && !var5.isStateSaved()) {
         String var6;
         if (var1.getHasNoAutoButton()) {
            var6 = "action_fan_speed";
         } else {
            var6 = "action_auto";
         }

         ConnectInstructionsDialog var7 = ConnectInstructionsDialog.Companion.newInstance(var1.getFamilyName(), var6, var1, var2);
         var7.setOnCountdown(new BluetoothScanResultFragment$$ExternalSyntheticLambda2(this, var7, var1));
         var4 = var7;
         ((DialogFragment)var4).show(var5, "ConnectInstructionsDialog");
      } else {
         var4 = null;
      }

      var4 = var4;
      if (var4 != null) {
         this.pendingConnectableDevice = var1;
         this.connectInstructionsDialog = var4;
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var4, "ConnectInstructionsDialog", new BluetoothScanResultFragment$$ExternalSyntheticLambda3(this));
      }

   }

   private static final Unit startConnectBleDevice$lambda$25$lambda$24$lambda$23(BluetoothScanResultFragment var0, ConnectInstructionsDialog var1, BluetoothDevice var2) {
      BluetoothDevice var3 = var0.pendingConnectableDevice;
      if (var3 != null) {
         var1.getViewModel().logStep1ConnectionInstructions(var2, "force");
         var0.connectBleDevice(var3, 1);
         var1.switchConnecting();
      }

      return Unit.INSTANCE;
   }

   private static final Unit startConnectBleDevice$lambda$27$lambda$26(BluetoothScanResultFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      var0.pendingConnectableDevice = null;
      var0.connectInstructionsDialog = null;
      Job var3 = var0.connectJob;
      if (var3 != null) {
         kotlinx.coroutines.Job.DefaultImpls.cancel$default(var3, (CancellationException)null, 1, (Object)null);
      }

      var0.connectJob = null;
      if (!Intrinsics.areEqual(var0.getViewModel().isSelectedBleDeviceConnected(), true)) {
         var0.deselectDevice();
      }

      return Unit.INSTANCE;
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentBluetoothScanResultBinding var2 = this.binding;
      FragmentBluetoothScanResultBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var3 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "rootLayout");
      return var3;
   }

   public CompositeDisposable getRxSubs() {
      return this.$$delegate_0.getRxSubs();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public AddDeviceViewModel getViewModel() {
      return this.$$delegate_0.getViewModel();
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Timber.Forest.d("onCreateView", new Object[0]);
      FragmentActivity var10 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var10, "requireActivity(...)");
      this.setViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var10)).get(AddDeviceViewModel.class)));
      FragmentBluetoothScanResultBinding var11 = FragmentBluetoothScanResultBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var11, "inflate(...)");
      this.binding = var11;
      Object var9 = null;
      FragmentBluetoothScanResultBinding var4 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.listview.setAdapter(this.getAdapter());
      var11 = this.binding;
      var4 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnHelp.setOnClickListener(new BluetoothScanResultFragment$$ExternalSyntheticLambda1(this));
      var11 = this.binding;
      var4 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      this.setProgressBlockerView(var4.progressView);
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (FragmentBluetoothScanResultBinding)var9;
      }

      ConstraintLayout var8 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var8, "getRoot(...)");
      return (View)var8;
   }

   public void onDestroy() {
      this.clearProgressFragment();
      super.onDestroy();
   }

   public void onPause() {
      this.getViewModel().stopBluetoothScanning();
      this.deviceSelectedStateListening = null;
      super.onPause();
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      Intrinsics.checkNotNullParameter(var2, "permissions");
      Intrinsics.checkNotNullParameter(var3, "grantResults");
      handleInitialState$default(this, false, 1, (Object)null);
   }

   public void onResume() {
      super.onResume();
      Timber.Forest.d("onResume", new Object[0]);
      this.reset();
      this.getRxSubs().add(RxExtensionsKt.uiThread(this.getViewModel().getBluetoothConnectionStateObserver()).subscribe(new BluetoothScanResultFragment$$ExternalSyntheticLambda14(new BluetoothScanResultFragment$$ExternalSyntheticLambda11(this)), new BluetoothScanResultFragment$$ExternalSyntheticLambda16(new BluetoothScanResultFragment$$ExternalSyntheticLambda15())));
      CompositeDisposable var1 = this.getRxSubs();
      Observable var2 = RxExtensionsKt.uiThread((Observable)this.getDeviceSelectPublisher()).throttleFirst(500L, TimeUnit.MILLISECONDS).filter(new BluetoothScanResultFragment$$ExternalSyntheticLambda18(new BluetoothScanResultFragment$$ExternalSyntheticLambda17(this)));
      Intrinsics.checkNotNullExpressionValue(var2, "filter(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new BluetoothScanResultFragment$$ExternalSyntheticLambda19(this)));
      var1 = this.getRxSubs();
      var2 = RxExtensionsKt.filterRapidClicks((Observable)this.getLegacySelectPublisher());
      Intrinsics.checkNotNullExpressionValue(var2, "filterRapidClicks(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new BluetoothScanResultFragment$$ExternalSyntheticLambda20(this)));
      handleInitialState$default(this, false, 1, (Object)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Timber.Forest.d("onViewCreated", new Object[0]);
      LifecycleOwner var3 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var3, "getViewLifecycleOwner(...)");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var3), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final BluetoothScanResultFragment this$0;

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
               LifecycleOwner var4 = this.this$0.getViewLifecycleOwner();
               Intrinsics.checkNotNullExpressionValue(var4, "getViewLifecycleOwner(...)");
               Lifecycle.State var7 = State.STARTED;
               Function2 var6 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final BluetoothScanResultFragment this$0;

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
                        StateFlow var4 = this.this$0.getViewModel().getBleDevicesFlow();
                        FlowCollector var5 = new FlowCollector(this.this$0) {
                           final BluetoothScanResultFragment this$0;

                           // $FF: synthetic method
                           public static CharSequence $r8$lambda$Fd1qUJK44DWoIPrhtlO4AHjgCMY(BluetoothDevice var0) {
                              return emit$lambda$0(var0);
                           }

                           {
                              this.this$0 = var1;
                           }

                           private static final CharSequence emit$lambda$0(BluetoothDevice var0) {
                              Intrinsics.checkNotNullParameter(var0, "it");
                              StringBuilder var1 = new StringBuilder();
                              var1.append(var0.getModelName());
                              var1.append('-');
                              var1.append(var0.getConnectable());
                              return (CharSequence)var1.toString();
                           }

                           public final Object emit(List var1, Continuation var2) {
                              Timber.Forest var3 = Timber.Forest;
                              StringBuilder var4 = new StringBuilder("liveBleDeviceObserver: ");
                              Iterable var6 = (Iterable)var1;
                              var4.append(CollectionsKt.joinToString$default(var6, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new BluetoothScanResultFragment$onViewCreated$1$1$1$$ExternalSyntheticLambda0(), 31, (Object)null));
                              var3.d(var4.toString(), new Object[0]);
                              BluetoothDevice var10 = this.this$0.pendingConnectableDevice;
                              if (var10 != null) {
                                 BluetoothScanResultFragment var9 = this.this$0;
                                 Iterator var5 = var6.iterator();

                                 do {
                                    if (!var5.hasNext()) {
                                       var7 = null;
                                       break;
                                    }

                                    var7 = var5.next();
                                 } while(!Intrinsics.areEqual(((BluetoothDevice)var7).getMac(), var10.getMac()));

                                 var10 = (BluetoothDevice)var7;
                                 if (var10 != null && var10.getConnectable()) {
                                    var9.pendingConnectableDevice = null;
                                    ConnectInstructionsDialog var8 = var9.connectInstructionsDialog;
                                    if (var8 != null) {
                                       var8.switchConnecting();
                                    }

                                    var9.getViewModel().logStep1ConnectionInstructions(var10, "detect");
                                    var9.connectBleDevice(var10, 1);
                                 }
                              }

                              this.this$0.showScanningResults(var1);
                              return Unit.INSTANCE;
                           }
                        };
                        Continuation var6 = (Continuation)this;
                        this.label = 1;
                        if (var4.collect(var5, var6) == var3) {
                           return var3;
                        }
                     }

                     throw new KotlinNothingValueException();
                  }
               };
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (RepeatOnLifecycleKt.repeatOnLifecycle(var4, var7, var6, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(AddDeviceViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.$$delegate_0.setViewModel(var1);
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
   }

   public void showProgress(boolean var1) {
      ProgressFragment$_CC.showProgress$default(this, this.getContext(), var1, (Integer)null, 4, (Object)null);
   }
}
