package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.adapter.DeviceModel;
import com.blueair.adddevice.adapter.SelectDeviceModelAdapter;
import com.blueair.adddevice.adapter.SelectDeviceModelAdapterKt;
import com.blueair.adddevice.fragment.RegionMismatchFragment;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.AblEnvironment;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.OnboardingStartedEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.DialogUtils;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020&H\u0002J\u0010\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020IH\u0016J\b\u0010P\u001a\u00020IH\u0016J\"\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020S2\b\u0010U\u001a\u0004\u0018\u00010VH\u0017J\u001a\u0010W\u001a\u0002072\u0006\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u000207H\u0002J\b\u0010[\u001a\u000207H\u0003J\"\u0010\\\u001a\u00020I2\u0006\u0010]\u001a\u00020S2\u0006\u0010^\u001a\u00020S2\b\b\u0002\u0010_\u001a\u000207H\u0002J-\u0010`\u001a\u00020I2\u0006\u0010R\u001a\u00020S2\u000e\u0010a\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0=2\u0006\u0010b\u001a\u00020cH\u0017¢\u0006\u0002\u0010dR\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R!\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\b8\u00109R(\u0010;\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020> ?*\n\u0012\u0004\u0012\u00020>\u0018\u00010=0=0<X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSelectModelFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "addService", "Lcom/blueair/adddevice/service/AddDeviceService;", "getAddService", "()Lcom/blueair/adddevice/service/AddDeviceService;", "addService$delegate", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "deviceModelSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/adapter/DeviceModel;", "getDeviceModelSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceModelSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/adddevice/adapter/SelectDeviceModelAdapter;", "getAdapter", "()Lcom/blueair/adddevice/adapter/SelectDeviceModelAdapter;", "adapter$delegate", "selectedDeviceModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "regionMismatch", "", "getRegionMismatch", "()Z", "regionMismatch$delegate", "requestBluetoothPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "openDeviceOnBoarding", "model", "logOnboardingStartEvent", "deviceType", "Lcom/blueair/core/model/DeviceType;", "onPause", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "isWifiPermissionsEnabled", "activity", "Landroid/app/Activity;", "isIcp", "isBluetoothPermissionsEnabled", "showPermissionDialog", "titleTextResId", "bodyTextResId", "isLocation", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceSelectModelFragment extends Fragment implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "addService", "getAddService()Lcom/blueair/adddevice/service/AddDeviceService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceSelectModelFragment.class, "deviceModelSelectPublisher", "getDeviceModelSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int GRIDVIEW_NUMBER_OF_COLUMNS = 2;
   private static final int REQUEST_CODE_LOGIN;
   private final Lazy adapter$delegate;
   private final Lazy addService$delegate;
   private final Lazy analyticsService$delegate;
   private final Lazy authService$delegate;
   private final LazyPublishSubject deviceModelSelectPublisher$delegate;
   private final Lazy di$delegate;
   private final Lazy locationPermissionTracker$delegate;
   private final Lazy locationService$delegate;
   private final Lazy regionMismatch$delegate;
   private final ActivityResultLauncher requestBluetoothPermissionsLauncher;
   private final Lazy rxSubs$delegate;
   private DeviceModel selectedDeviceModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$1id_qKLGhpZUZ_c_S9IpTIXrO9A/* $FF was: $r8$lambda$1id_qKLGhpZUZ-c-S9IpTIXrO9A*/() {
      return showPermissionDialog$lambda$16$lambda$14$lambda$13();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GP7RlZiIn_A0_FYa9VK4OPbS8Og/* $FF was: $r8$lambda$GP7RlZiIn_A0-FYa9VK4OPbS8Og*/(AddDeviceSelectModelFragment var0, String var1, Bundle var2) {
      return isWifiPermissionsEnabled$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static SelectDeviceModelAdapter $r8$lambda$KVaXaWNLTvz9TQcDKbXlyCPMApc(AddDeviceSelectModelFragment var0) {
      return adapter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MwHDpvlPjbO2ap05d_KPCu7t3lw(AddDeviceSelectModelFragment var0, DeviceModel var1) {
      return onResume$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$TFAQ4LkvJKNMudj7kzphdtxsgjo(AddDeviceSelectModelFragment var0) {
      return regionMismatch_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ZVUZ0P6_OuT5pl5pmgQYro6Z9Ho/* $FF was: $r8$lambda$ZVUZ0P6-OuT5pl5pmgQYro6Z9Ho*/(AddDeviceSelectModelFragment var0, Map var1) {
      requestBluetoothPermissionsLauncher$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$joHHJNgPzSzJZ7v3_jItPz9qDFk(AddDeviceSelectModelFragment var0, boolean var1, String var2, Bundle var3) {
      showPermissionDialog$lambda$16(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static CompositeDisposable $r8$lambda$mOVmohIcZrqcb0URN2fzl2lh_Bw/* $FF was: $r8$lambda$mOVmohIcZrqcb0URN2fzl2lh-Bw*/() {
      return rxSubs_delegate$lambda$1();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$y8rKfJPgYoC8uyRjH6XZHJY1OCE(AddDeviceSelectModelFragment var0, OnBackPressedCallback var1) {
      return onCreateView$lambda$5(var0, var1);
   }

   static {
      REQUEST_CODE_LOGIN = ViewUtils.INSTANCE.genRequestCode();
   }

   public AddDeviceSelectModelFragment() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI(this);
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var5 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.addService$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AddDeviceService.class)), (Object)null).provideDelegate(this, var1[1]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analyticsService$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AnalyticsService.class)), (Object)null).provideDelegate(this, var1[2]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, LocationService.class)), (Object)null).provideDelegate(this, var1[3]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationPermissionTracker$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, LocationPermissionTracker.class)), (Object)null).provideDelegate(this, var1[4]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AuthService.class)), (Object)null).provideDelegate(this, var1[5]);
      this.deviceModelSelectPublisher$delegate = new LazyPublishSubject();
      this.adapter$delegate = LazyKt.lazy(new AddDeviceSelectModelFragment$$ExternalSyntheticLambda2(this));
      this.rxSubs$delegate = LazyKt.lazy(new AddDeviceSelectModelFragment$$ExternalSyntheticLambda3());
      this.regionMismatch$delegate = LazyKt.lazy(new AddDeviceSelectModelFragment$$ExternalSyntheticLambda4(this));
      ActivityResultLauncher var4 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.RequestMultiplePermissions()), new AddDeviceSelectModelFragment$$ExternalSyntheticLambda5(this));
      Intrinsics.checkNotNullExpressionValue(var4, "registerForActivityResult(...)");
      this.requestBluetoothPermissionsLauncher = var4;
   }

   private static final SelectDeviceModelAdapter adapter_delegate$lambda$0(AddDeviceSelectModelFragment var0) {
      return new SelectDeviceModelAdapter(var0.getLocationService(), var0.getDeviceModelSelectPublisher());
   }

   private final SelectDeviceModelAdapter getAdapter() {
      return (SelectDeviceModelAdapter)this.adapter$delegate.getValue();
   }

   private final AddDeviceService getAddService() {
      return (AddDeviceService)this.addService$delegate.getValue();
   }

   private final AnalyticsService getAnalyticsService() {
      return (AnalyticsService)this.analyticsService$delegate.getValue();
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final PublishSubject getDeviceModelSelectPublisher() {
      return this.deviceModelSelectPublisher$delegate.getValue(this, $$delegatedProperties[6]);
   }

   private final LocationPermissionTracker getLocationPermissionTracker() {
      return (LocationPermissionTracker)this.locationPermissionTracker$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final boolean getRegionMismatch() {
      return (Boolean)this.regionMismatch$delegate.getValue();
   }

   private final CompositeDisposable getRxSubs() {
      return (CompositeDisposable)this.rxSubs$delegate.getValue();
   }

   private final boolean isBluetoothPermissionsEnabled() {
      BluetoothUtils var2 = BluetoothUtils.INSTANCE;
      Context var1 = this.requireContext();
      Intrinsics.checkNotNullExpressionValue(var1, "requireContext(...)");
      if (!var2.hasBluetoothPermissions(var1)) {
         DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_bluetooth, R.string.permission_request_message_bluetooth);
         this.requestBluetoothPermissionsLauncher.launch(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"});
         return false;
      } else {
         return true;
      }
   }

   private final boolean isWifiPermissionsEnabled(Activity var1, boolean var2) {
      if (var2 && VERSION.SDK_INT >= 31) {
         return true;
      } else {
         LocationUtils var4 = LocationUtils.INSTANCE;
         Context var5 = (Context)var1;
         if (var4.isLocationEnabled(var5)) {
            if (!LocationUtils.INSTANCE.isLocationPermissionGranted(var5)) {
               if (this.getLocationPermissionTracker().shouldShowLocationRequestPermissionDialog(this)) {
                  this.showPermissionDialog(R.string.wh_location_permission_dialog_title, R.string.location_permission_connect_12, true);
               } else {
                  int var8;
                  if (VERSION.SDK_INT >= 31) {
                     var8 = R.string.location_permission_connect_12;
                  } else {
                     var8 = R.string.location_permission_connect;
                  }

                  this.showPermissionDialog(R.string.wh_location_permission_dialog_title, var8, true);
               }

               return false;
            } else {
               return true;
            }
         } else {
            FragmentManager var9 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var9, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
            DialogFragment var6;
            if (!(var9.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var9.isStateSaved()) {
               int var3;
               if (VERSION.SDK_INT <= 26) {
                  var3 = R.string.enable_loc_wifi_android_o;
               } else {
                  var3 = R.string.enable_loc_wifi;
               }

               var6 = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, 0, var3, R.string.enable_locations, R.string.btn_cancel, false, false, false, (String[])null, 224, (Object)null);
               ((DialogFragment)var6).show(var9, "ConfirmationDialogCentered");
            } else {
               var6 = null;
            }

            var6 = var6;
            if (var6 != null) {
               FragmentKt.setFragmentResultListener((Fragment)var6, "CONFIRMATION", new AddDeviceSelectModelFragment$$ExternalSyntheticLambda0(this));
            }

            return false;
         }
      }
   }

   // $FF: synthetic method
   static boolean isWifiPermissionsEnabled$default(AddDeviceSelectModelFragment var0, Activity var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return var0.isWifiPermissionsEnabled(var1, var2);
   }

   private static final Unit isWifiPermissionsEnabled$lambda$12(AddDeviceSelectModelFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         Intent var3 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
         var3.setFlags(268435456);
         var0.startActivity(var3);
      }

      return Unit.INSTANCE;
   }

   private final void logOnboardingStartEvent(DeviceType var1) {
      this.getAnalyticsService().amplitudeLog(new OnboardingStartedEvent(var1.getName()));
   }

   private static final Unit onCreateView$lambda$5(AddDeviceSelectModelFragment var0, OnBackPressedCallback var1) {
      Intrinsics.checkNotNullParameter(var1, "$this$addCallback");
      if (!Intrinsics.areEqual(var0.getAdapter().getDeviceList(), var0.getAdapter().getDefaultModelList())) {
         var0.getAdapter().setDeviceList(var0.getAdapter().getDefaultModelList());
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$7(AddDeviceSelectModelFragment var0, DeviceModel var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         if (var0.getAddService().isUserLoggedIn()) {
            Intrinsics.checkNotNull(var1);
            var0.openDeviceOnBoarding(var1);
         } else {
            var0.selectedDeviceModel = var1;
            var0.startActivityForResult(Actions.openWelcomeIntent$default(Actions.INSTANCE, (Context)var2, false, 2, (Object)null), REQUEST_CODE_LOGIN);
         }
      }

      return Unit.INSTANCE;
   }

   private final void openDeviceOnBoarding(DeviceModel var1) {
      FragmentActivity var3 = this.getActivity();
      if (var3 != null) {
         if (SelectDeviceModelAdapterKt.legacy(var1) && this.getRegionMismatch()) {
            RegionMismatchFragment.Companion.newInstance().show(var3.getSupportFragmentManager(), (String)null);
            return;
         }

         int var2 = AddDeviceSelectModelFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  if (var2 == 4 && this.isWifiPermissionsEnabled((Activity)var3, true) && this.isBluetoothPermissionsEnabled()) {
                     this.logOnboardingStartEvent(DeviceType.Icp.INSTANCE);
                     this.getAddService().selectDevice(40);
                     return;
                  }
               } else if (isWifiPermissionsEnabled$default(this, (Activity)var3, false, 2, (Object)null)) {
                  this.logOnboardingStartEvent(DeviceType.Aware.INSTANCE);
                  this.getAddService().selectDevice(1);
                  return;
               }
            } else if (isWifiPermissionsEnabled$default(this, (Activity)var3, false, 2, (Object)null)) {
               this.logOnboardingStartEvent(DeviceType.Sense.INSTANCE);
               this.getAddService().selectDevice(2);
               return;
            }
         } else if (isWifiPermissionsEnabled$default(this, (Activity)var3, false, 2, (Object)null)) {
            this.logOnboardingStartEvent(DeviceType.Classic.INSTANCE);
            this.getAddService().selectDevice(3);
         }
      }

   }

   private static final boolean regionMismatch_delegate$lambda$2(AddDeviceSelectModelFragment var0) {
      if (AblEnvironment.INSTANCE.isUAT()) {
         return false;
      } else {
         if (!var0.getLocationService().isInChina()) {
            CharSequence var1 = (CharSequence)var0.getLocationService().getAblRegion();
            if (var1 != null && var1.length() != 0 && !Intrinsics.areEqual(var0.getAuthService().getAblHomeHost(), AblEnvironment.INSTANCE.getBaseUrl()) && !Intrinsics.areEqual(var0.getLocationService().getAblRegion(), StringsKt.substringBefore$default(StringsKt.substringAfter$default(var0.getAuthService().getAblHomeHost(), "https://api-", (String)null, 2, (Object)null), ".", (String)null, 2, (Object)null))) {
               return true;
            }
         }

         return false;
      }
   }

   private static final void requestBluetoothPermissionsLauncher$lambda$4(AddDeviceSelectModelFragment var0, Map var1) {
      Iterable var5 = (Iterable)var1.values();
      boolean var4 = var5 instanceof Collection;
      boolean var3 = true;
      boolean var2;
      if (var4 && ((Collection)var5).isEmpty()) {
         var2 = var3;
      } else {
         Iterator var6 = var5.iterator();

         while(true) {
            var2 = var3;
            if (!var6.hasNext()) {
               break;
            }

            if (!(Boolean)var6.next()) {
               var2 = false;
               break;
            }
         }
      }

      if (!BluetoothUtils.INSTANCE.shouldShowBluetoothRequestPermissionDialog(var0) && !var2) {
         showPermissionDialog$default(var0, R.string.bluetooth_permission_dialog_title, R.string.bluetooth_permission_12, false, 4, (Object)null);
      }

   }

   private static final CompositeDisposable rxSubs_delegate$lambda$1() {
      return new CompositeDisposable();
   }

   private final void showPermissionDialog(int var1, int var2, boolean var3) {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, var1, var2, R.string.btn_goto_settings, R.string.btn_cancel, true, false, false, (String[])null, 224, (Object)null).show(this.getChildFragmentManager(), (String)null);
      this.getChildFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda6(this, var3));
   }

   // $FF: synthetic method
   static void showPermissionDialog$default(AddDeviceSelectModelFragment var0, int var1, int var2, boolean var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      var0.showPermissionDialog(var1, var2, var3);
   }

   private static final void showPermissionDialog$lambda$16(AddDeviceSelectModelFragment var0, boolean var1, String var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "result");
      if (var3.getBoolean("IS_CONFIRMED")) {
         Intent var4 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
         var4.setFlags(268435456);
         StringBuilder var5 = new StringBuilder("package:");
         Context var37 = var0.getContext();
         Object var45 = null;
         String var38;
         if (var37 != null) {
            var38 = var37.getPackageName();
         } else {
            var38 = null;
         }

         var5.append(var38);
         var4.setData(Uri.parse(var5.toString()));

         label301: {
            Throwable var10000;
            label307: {
               try {
                  Result.Companion var39 = Result.Companion;
               } catch (Throwable var35) {
                  var10000 = var35;
                  boolean var10001 = false;
                  break label307;
               }

               Unit var41;
               if (var1) {
                  try {
                     LocationPermissionTracker var48 = var0.getLocationPermissionTracker();
                     Fragment var40 = var0;
                     AddDeviceSelectModelFragment$$ExternalSyntheticLambda8 var46 = new AddDeviceSelectModelFragment$$ExternalSyntheticLambda8();
                     var48.requestLocationPermission(var40, var46);
                     var41 = Unit.INSTANCE;
                  } catch (Throwable var34) {
                     var10000 = var34;
                     boolean var50 = false;
                     break label307;
                  }
               } else {
                  try {
                     var49 = var0.getContext();
                  } catch (Throwable var33) {
                     var10000 = var33;
                     boolean var51 = false;
                     break label307;
                  }

                  var41 = (Unit)var45;
                  if (var49 != null) {
                     try {
                        var49.startActivity(var4);
                        var41 = Unit.INSTANCE;
                     } catch (Throwable var32) {
                        var10000 = var32;
                        boolean var52 = false;
                        break label307;
                     }
                  }
               }

               label288:
               try {
                  var43 = Result.constructor-impl(var41);
                  break label301;
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var53 = false;
                  break label288;
               }
            }

            Throwable var47 = var10000;
            Result.Companion var42 = Result.Companion;
            var43 = Result.constructor-impl(ResultKt.createFailure(var47));
         }

         if (Result.exceptionOrNull-impl(var43) != null) {
            ViewUtils var44 = ViewUtils.INSTANCE;
            FragmentActivity var36 = var0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(var36, "requireActivity(...)");
            var44.showSnackbar((Activity)var36, R.string.bluetooth_permission_12, ViewUtils.MessageType.INFO.INSTANCE);
         }
      }

   }

   private static final Unit showPermissionDialog$lambda$16$lambda$14$lambda$13() {
      DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_connect, R.string.permission_request_message_location_connect);
      return Unit.INSTANCE;
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == REQUEST_CODE_LOGIN && this.getAddService().isUserLoggedIn()) {
         DeviceModel var4 = this.selectedDeviceModel;
         if (var4 != null) {
            this.openDeviceOnBoarding(var4);
         }
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      View var4 = var1.inflate(com.blueair.adddevice.R.layout.fragment_add_device_select_model, var2, false);
      ((RecyclerView)var4.findViewById(com.blueair.adddevice.R.id.rv_list)).setAdapter(this.getAdapter());
      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         OnBackPressedDispatcher var6 = var5.getOnBackPressedDispatcher();
         if (var6 != null) {
            OnBackPressedDispatcherKt.addCallback$default(var6, this.getViewLifecycleOwner(), false, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda7(this), 2, (Object)null);
         }
      }

      return var4;
   }

   public void onDestroy() {
      this.getRxSubs().clear();
      super.onDestroy();
   }

   public void onPause() {
      this.getRxSubs().clear();
      super.onPause();
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      Intrinsics.checkNotNullParameter(var2, "permissions");
      Intrinsics.checkNotNullParameter(var3, "grantResults");
      if (var1 == 10101 && ArraysKt.contains(var3, -1)) {
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4 && this.shouldShowRequestPermissionRationale(var2[var5]); ++var5) {
         }
      }

   }

   public void onResume() {
      super.onResume();
      CompositeDisposable var1 = this.getRxSubs();
      Observable var2 = RxExtensionsKt.filterRapidClicks(RxExtensionsKt.uiThread((Observable)this.getDeviceModelSelectPublisher()));
      Intrinsics.checkNotNullExpressionValue(var2, "filterRapidClicks(...)");
      var1.add(RxExtensionsKt.subscribeAndLogE(var2, new AddDeviceSelectModelFragment$$ExternalSyntheticLambda1(this)));
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceSelectModelFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceSelectModelFragment;", "GRIDVIEW_NUMBER_OF_COLUMNS", "", "REQUEST_CODE_LOGIN", "getREQUEST_CODE_LOGIN", "()I", "adddevice_otherRelease"},
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

      public final int getREQUEST_CODE_LOGIN() {
         return AddDeviceSelectModelFragment.REQUEST_CODE_LOGIN;
      }

      public final AddDeviceSelectModelFragment newInstance() {
         return new AddDeviceSelectModelFragment();
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
         int[] var0 = new int[DeviceModel.values().length];

         try {
            var0[DeviceModel.CLASSIC.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceModel.SENSE.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceModel.AWARE.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceModel.ICP.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
