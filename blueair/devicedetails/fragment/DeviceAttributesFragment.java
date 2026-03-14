package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCleanAirEta;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasDetectCat;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasDisplayMode;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasGestureRecognition;
import com.blueair.core.model.HasHinsMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWaterTank;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.model.TimerState;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicedetails.adapter.DeviceAttributesAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceAttributesBinding;
import com.blueair.devicedetails.dialog.DeviceFanPresetDialogFragment;
import com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment;
import com.blueair.devicedetails.dialog.DeviceOscillationSettingsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceSetTimezoneDialogFragment;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.PopupInfoDialogFragment;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.connectivityhelper.NetUtil;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
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
   d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001HB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J$\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u0002032\u0006\u0010A\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010B\u001a\u000203H\u0016J\u0010\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020\u001fH\u0002J\u001e\u0010E\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002030GH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100¨\u0006I"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceAttributesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "networkSnack", "Lcom/google/android/material/snackbar/Snackbar;", "getNetworkSnack", "()Lcom/google/android/material/snackbar/Snackbar;", "networkSnack$delegate", "Lkotlin/Lazy;", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "deviceAttributesBinding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceAttributesBinding;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "actionType", "", "attributeActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "getAttributeActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "attributeActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceAttributesAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceAttributesAdapter;", "adapter$delegate", "showProgress", "", "shouldShowProgress", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "hasDeviceAttributesChanged", "liveDevice", "shouldDoDbAndApiCall", "call", "Lkotlin/Function0;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAttributesFragment extends BaseFragment implements ProgressFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceAttributesFragment.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceAttributesFragment.class, "attributeActionPublisher", "getAttributeActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String KEY_ACTION_TYPE = "key_action_type";
   public static final String KEY_DEVICE = "key_device";
   public static final long THROTTLE_LONG_MILLISECONDS = 1000L;
   public static final long THROTTLE_SHORT_MILLISECONDS = 300L;
   private String actionType;
   private final Lazy adapter$delegate;
   private final Lazy analyticsService$delegate;
   private final LazyPublishSubject attributeActionPublisher$delegate;
   private Device device;
   private FragmentDeviceAttributesBinding deviceAttributesBinding;
   private final Lazy networkSnack$delegate = LazyKt.lazy(new DeviceAttributesFragment$$ExternalSyntheticLambda1(this));
   private ProgressBlockerView progressBlockerView;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$0fDTeI8cnB0IqdaC5s61LfXDHII(DeviceAttributesFragment var0, Device var1) {
      return onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Snackbar $r8$lambda$HGbWGEXvFJaS1_FgwFKVbXjcQM0/* $FF was: $r8$lambda$HGbWGEXvFJaS1-FgwFKVbXjcQM0*/(DeviceAttributesFragment var0) {
      return networkSnack_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Jtw0r_dAxCSF_B5AlDQ1CV_Cqik/* $FF was: $r8$lambda$Jtw0r_dAxCSF_B5AlDQ1CV-Cqik*/(AttributeAction var0, Device var1, DeviceAttributesFragment var2) {
      return onResume$lambda$28$lambda$27$lambda$26(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$RfwaCuyjvpg5XtYJuB5k7P4Gyw8(DeviceAttributesFragment var0, Boolean var1) {
      return onViewCreated$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$dI_2bQjOu4_1la_VyhtO78954t8/* $FF was: $r8$lambda$dI-2bQjOu4-1la-VyhtO78954t8*/(DeviceAttributesFragment var0, IndoorDatapoint var1) {
      return onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceAttributesAdapter $r8$lambda$g_h5lJDs0RscTjDaMArztuvN_xo/* $FF was: $r8$lambda$g_h5lJDs0RscTjDaMArztuvN-xo*/(DeviceAttributesFragment var0) {
      return adapter_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jv_80ML2mTREhKXFNsVXo8ju7Ig(DeviceAttributesFragment var0, Device var1, AttributeAction var2, boolean var3) {
      return onResume$lambda$28$lambda$27$lambda$26$lambda$22$lambda$21(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$w4PKsIgU_xLgWPaU3Dx5U8XnWAQ(DeviceAttributesFragment var0, AttributeAction var1) {
      return onResume$lambda$28(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yZwNMp4I86lyaOdGW_xcBNDGAH8(DeviceAttributesFragment var0, boolean var1) {
      return onViewCreated$lambda$4(var0, var1);
   }

   public DeviceAttributesFragment() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analyticsService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, AnalyticsService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.attributeActionPublisher$delegate = new LazyPublishSubject();
      this.adapter$delegate = LazyKt.lazy(new DeviceAttributesFragment$$ExternalSyntheticLambda2(this));
   }

   private static final DeviceAttributesAdapter adapter_delegate$lambda$1(DeviceAttributesFragment var0) {
      return new DeviceAttributesAdapter(var0.getAttributeActionPublisher());
   }

   private final DeviceAttributesAdapter getAdapter() {
      return (DeviceAttributesAdapter)this.adapter$delegate.getValue();
   }

   private final AnalyticsService getAnalyticsService() {
      return (AnalyticsService)this.analyticsService$delegate.getValue();
   }

   private final PublishSubject getAttributeActionPublisher() {
      return this.attributeActionPublisher$delegate.getValue(this, $$delegatedProperties[1]);
   }

   private final Snackbar getNetworkSnack() {
      return (Snackbar)this.networkSnack$delegate.getValue();
   }

   private final boolean hasDeviceAttributesChanged(Device var1) {
      HasFanSpeed var33 = this.getAdapter().getDevice();
      HasFanSpeed var34;
      if (var33 instanceof HasFanSpeed) {
         var34 = var33;
      } else {
         var34 = null;
      }

      if (var1 instanceof HasFanSpeed) {
         var33 = (HasFanSpeed)var1;
      } else {
         var33 = null;
      }

      AutoMode var35;
      if (var34 != null) {
         var35 = var34.getAutoMode();
      } else {
         var35 = null;
      }

      AutoMode var36;
      if (var33 != null) {
         var36 = var33.getAutoMode();
      } else {
         var36 = null;
      }

      boolean var2;
      if (var35 != var36) {
         var2 = true;
      } else {
         var2 = false;
      }

      FanSpeedEnum var141;
      if (var34 != null) {
         var141 = var34.getFanSpeedEnum();
      } else {
         var141 = null;
      }

      FanSpeedEnum var158;
      if (var33 != null) {
         var158 = var33.getFanSpeedEnum();
      } else {
         var158 = null;
      }

      boolean var3;
      if (var141 != var158) {
         var3 = true;
      } else {
         var3 = false;
      }

      Device var142 = this.getAdapter().getDevice();
      HasStandBy var143;
      if (var142 instanceof HasStandBy) {
         var143 = (HasStandBy)var142;
      } else {
         var143 = null;
      }

      Boolean var144;
      if (var143 != null) {
         var144 = var143.isStandByOn();
      } else {
         var144 = null;
      }

      HasStandBy var159;
      if (var1 instanceof HasStandBy) {
         var159 = (HasStandBy)var1;
      } else {
         var159 = null;
      }

      Boolean var160;
      if (var159 != null) {
         var160 = var159.isStandByOn();
      } else {
         var160 = null;
      }

      boolean var13 = Intrinsics.areEqual(var144, var160);
      Device var145 = this.getAdapter().getDevice();
      HasEcoMode var146;
      if (var145 instanceof HasEcoMode) {
         var146 = (HasEcoMode)var145;
      } else {
         var146 = null;
      }

      Boolean var147;
      if (var146 != null) {
         var147 = var146.isEcoModeOn();
      } else {
         var147 = null;
      }

      HasEcoMode var161;
      if (var1 instanceof HasEcoMode) {
         var161 = (HasEcoMode)var1;
      } else {
         var161 = null;
      }

      Boolean var162;
      if (var161 != null) {
         var162 = var161.isEcoModeOn();
      } else {
         var162 = null;
      }

      boolean var11 = Intrinsics.areEqual(var147, var162);
      Device var148 = this.getAdapter().getDevice();
      HasHinsMode var149;
      if (var148 instanceof HasHinsMode) {
         var149 = (HasHinsMode)var148;
      } else {
         var149 = null;
      }

      Boolean var150;
      if (var149 != null) {
         var150 = var149.isHinsModeOn();
      } else {
         var150 = null;
      }

      boolean var14 = var1 instanceof HasHinsMode;
      HasHinsMode var163;
      if (var14) {
         var163 = (HasHinsMode)var1;
      } else {
         var163 = null;
      }

      Boolean var164;
      if (var163 != null) {
         var164 = var163.isHinsModeOn();
      } else {
         var164 = null;
      }

      boolean var12 = Intrinsics.areEqual(var150, var164);
      Device var151 = this.getAdapter().getDevice();
      HasHinsMode var152;
      if (var151 instanceof HasHinsMode) {
         var152 = (HasHinsMode)var151;
      } else {
         var152 = null;
      }

      Boolean var153;
      if (var152 != null) {
         var153 = var152.isHinsNightModeOn();
      } else {
         var153 = null;
      }

      HasHinsMode var165;
      if (var14) {
         var165 = (HasHinsMode)var1;
      } else {
         var165 = null;
      }

      Boolean var166;
      if (var165 != null) {
         var166 = var165.isHinsNightModeOn();
      } else {
         var166 = null;
      }

      boolean var16 = Intrinsics.areEqual(var153, var166);
      Device var154 = this.getAdapter().getDevice();
      HasG4NightMode var155;
      if (var154 instanceof HasG4NightMode) {
         var155 = (HasG4NightMode)var154;
      } else {
         var155 = null;
      }

      Boolean var156;
      if (var155 != null) {
         var156 = var155.isG4NightModeOn();
      } else {
         var156 = null;
      }

      HasG4NightMode var167;
      if (var1 instanceof HasG4NightMode) {
         var167 = (HasG4NightMode)var1;
      } else {
         var167 = null;
      }

      Boolean var168;
      if (var167 != null) {
         var168 = var167.isG4NightModeOn();
      } else {
         var168 = null;
      }

      boolean var18 = Intrinsics.areEqual(var156, var168);
      Integer var106;
      if (var34 != null) {
         var106 = var34.getFilterLife();
      } else {
         var106 = null;
      }

      Integer var43;
      if (var33 != null) {
         var43 = var33.getFilterLife();
      } else {
         var43 = null;
      }

      var14 = Intrinsics.areEqual(var106, var43);
      Device var44 = this.getAdapter().getDevice();
      HasSafetySwitch var45;
      if (var44 instanceof HasSafetySwitch) {
         var45 = (HasSafetySwitch)var44;
      } else {
         var45 = null;
      }

      Boolean var46;
      if (var45 != null) {
         var46 = var45.isSafetySwitchOn();
      } else {
         var46 = null;
      }

      HasSafetySwitch var107;
      if (var1 instanceof HasSafetySwitch) {
         var107 = (HasSafetySwitch)var1;
      } else {
         var107 = null;
      }

      Boolean var108;
      if (var107 != null) {
         var108 = var107.isSafetySwitchOn();
      } else {
         var108 = null;
      }

      boolean var17 = Intrinsics.areEqual(var46, var108);
      Device var47 = this.getAdapter().getDevice();
      HasGermShieldMode var48;
      if (var47 instanceof HasGermShieldMode) {
         var48 = (HasGermShieldMode)var47;
      } else {
         var48 = null;
      }

      Boolean var49;
      if (var48 != null) {
         var49 = var48.isGermShieldModeOn();
      } else {
         var49 = null;
      }

      boolean var19 = var1 instanceof HasGermShieldMode;
      HasGermShieldMode var109;
      if (var19) {
         var109 = (HasGermShieldMode)var1;
      } else {
         var109 = null;
      }

      Boolean var110;
      if (var109 != null) {
         var110 = var109.isGermShieldModeOn();
      } else {
         var110 = null;
      }

      boolean var15 = Intrinsics.areEqual(var49, var110);
      HasGermShieldMode var50 = this.getAdapter().getDevice();
      if (var50 instanceof HasGermShieldMode) {
         var50 = var50;
      } else {
         var50 = null;
      }

      Boolean var52;
      if (var50 != null) {
         var52 = var50.isGermShieldNightModeOn();
      } else {
         var52 = null;
      }

      HasGermShieldMode var111;
      if (var19) {
         var111 = (HasGermShieldMode)var1;
      } else {
         var111 = null;
      }

      Boolean var112;
      if (var111 != null) {
         var112 = var111.isGermShieldNightModeOn();
      } else {
         var112 = null;
      }

      boolean var25 = Intrinsics.areEqual(var52, var112);
      Device var53 = this.getAdapter().getDevice();
      HasBrightness var54;
      if (var53 instanceof HasBrightness) {
         var54 = (HasBrightness)var53;
      } else {
         var54 = null;
      }

      Integer var55;
      if (var54 != null) {
         var55 = var54.getBrightness();
      } else {
         var55 = null;
      }

      HasBrightness var113;
      if (var1 instanceof HasBrightness) {
         var113 = (HasBrightness)var1;
      } else {
         var113 = null;
      }

      Integer var114;
      if (var113 != null) {
         var114 = var113.getBrightness();
      } else {
         var114 = null;
      }

      boolean var27 = Intrinsics.areEqual(var55, var114);
      Device var56 = this.getAdapter().getDevice();
      ConnectivityStatus var57;
      if (var56 != null) {
         var57 = var56.getConnectivityStatus();
      } else {
         var57 = null;
      }

      boolean var4;
      if (var57 != var1.getConnectivityStatus()) {
         var4 = true;
      } else {
         var4 = false;
      }

      HasDisinfection var58 = this.getAdapter().getDevice();
      boolean var5;
      if (var58 != null && var58.getUpdateProgress() == var1.getUpdateProgress()) {
         var5 = true;
      } else {
         var5 = false;
      }

      boolean var6;
      label743: {
         if (this.getAdapter().getDevice() instanceof HasDisinfection && var1 instanceof HasDisinfection) {
            var58 = this.getAdapter().getDevice();
            if (var58 instanceof HasDisinfection) {
               var58 = (HasDisinfection)var58;
            } else {
               var58 = null;
            }

            if (var58 != null) {
               var156 = var58.getDisinfection();
               HasDisinfection var115 = (HasDisinfection)var1;
               if (!Intrinsics.areEqual(var156, var115.getDisinfection()) || !Intrinsics.areEqual(var58.getDisinfectLeftTime(), var115.getDisinfectLeftTime())) {
                  var6 = true;
                  break label743;
               }
            }
         }

         var6 = false;
      }

      var58 = this.getAdapter().getDevice();
      HasChildLock var62;
      if (var58 instanceof HasChildLock) {
         var62 = (HasChildLock)var58;
      } else {
         var62 = null;
      }

      Boolean var63;
      if (var62 != null) {
         var63 = var62.isChildLockOn();
      } else {
         var63 = null;
      }

      HasChildLock var116;
      if (var1 instanceof HasChildLock) {
         var116 = (HasChildLock)var1;
      } else {
         var116 = null;
      }

      Boolean var117;
      if (var116 != null) {
         var117 = var116.isChildLockOn();
      } else {
         var117 = null;
      }

      boolean var22 = Intrinsics.areEqual(var63, var117);
      Device var64 = this.getAdapter().getDevice();
      String var65;
      if (var64 != null) {
         var65 = var64.getTimeZone();
      } else {
         var65 = null;
      }

      boolean var30 = Intrinsics.areEqual(var65, var1.getTimeZone());
      DeviceAttributesFragment var66 = this;
      Device var67 = this.getAdapter().getDevice();
      HasWick var68;
      if (var67 instanceof HasWick) {
         var68 = (HasWick)var67;
      } else {
         var68 = null;
      }

      HasWick var118;
      if (var1 instanceof HasWick) {
         var118 = (HasWick)var1;
      } else {
         var118 = null;
      }

      boolean var7;
      if (var68 == null || var118 == null || var68.getWickUsage() == var118.getWickUsage() && var68.getWickdryOn() == var118.getWickdryOn() && var68.getWickdryLeftTime() == var118.getWickdryLeftTime() && var68.getWickdryLeftTimeUpdateTime() == var118.getWickdryLeftTimeUpdateTime() && var68.getWickdryEnabled() == var118.getWickdryEnabled() && var68.getWaterShortage() == var118.getWaterShortage()) {
         var7 = false;
      } else {
         var7 = true;
      }

      var68 = this.getAdapter().getDevice();
      HasAutoRh var70;
      if (var68 instanceof HasAutoRh) {
         var70 = (HasAutoRh)var68;
      } else {
         var70 = null;
      }

      Integer var71;
      if (var70 != null) {
         var71 = var70.getAutoRh();
      } else {
         var71 = null;
      }

      HasAutoRh var119;
      if (var1 instanceof HasAutoRh) {
         var119 = (HasAutoRh)var1;
      } else {
         var119 = null;
      }

      Integer var120;
      if (var119 != null) {
         var120 = var119.getAutoRh();
      } else {
         var120 = null;
      }

      var19 = Intrinsics.areEqual(var71, var120);
      Device var72 = this.getAdapter().getDevice();
      HasTimer var73;
      if (var72 instanceof HasTimer) {
         var73 = (HasTimer)var72;
      } else {
         var73 = null;
      }

      HasTimer var121;
      if (var1 instanceof HasTimer) {
         var121 = (HasTimer)var1;
      } else {
         var121 = null;
      }

      boolean var8;
      if (var73 == null || var121 == null || var73.getTimerStatus() == var121.getTimerStatus() && var73.getTimerDuration() == var121.getTimerDuration() && var73.getTimerLeftTime() == var121.getTimerLeftTime() && var73.getTimerLeftTimeUpdateTime() == var121.getTimerLeftTimeUpdateTime()) {
         var8 = false;
      } else {
         var8 = true;
      }

      var73 = this.getAdapter().getDevice();
      HasOscillation var75;
      if (var73 instanceof HasOscillation) {
         var75 = (HasOscillation)var73;
      } else {
         var75 = null;
      }

      HasOscillation var122;
      if (var1 instanceof HasOscillation) {
         var122 = (HasOscillation)var1;
      } else {
         var122 = null;
      }

      boolean var9;
      if (var75 == null || var122 == null || var75.getOscillationState() == var122.getOscillationState() && var75.getOscillationAngle() == var122.getOscillationAngle() && var75.getOscillationDirection() == var122.getOscillationDirection() && var75.getOscillationFanSpeed() == var122.getOscillationFanSpeed()) {
         var9 = false;
      } else {
         var9 = true;
      }

      var75 = this.getAdapter().getDevice();
      HasMainMode var77;
      if (var75 instanceof HasMainMode) {
         var77 = (HasMainMode)var75;
      } else {
         var77 = null;
      }

      HasMainMode var123;
      if (var1 instanceof HasMainMode) {
         var123 = (HasMainMode)var1;
      } else {
         var123 = null;
      }

      int var39;
      label682: {
         label681: {
            if (var77 != null && var123 != null) {
               if (var77.getMainMode() != var123.getMainMode() || var77.getApSubMode() != var123.getApSubMode()) {
                  break label681;
               }

               if (var77 instanceof HasCombo3in1MainMode && var123 instanceof HasCombo3in1MainMode) {
                  var77 = var77;
                  var39 = var77.getApFanSpeed();
                  HasCombo3in1MainMode var124 = (HasCombo3in1MainMode)var123;
                  if (var39 != var124.getApFanSpeed() || var77.getHeatSubMode() != var124.getHeatSubMode() || var77.getHeatFanSpeed() != var124.getHeatFanSpeed() || var77.getHeatAutoTmp() != var124.getHeatAutoTmp() || var77.getHeatEcoTmp() != var124.getHeatEcoTmp() || var77.getCoolSubMode() != var124.getCoolSubMode() || var77.getCoolFanSpeed() != var124.getCoolFanSpeed() || var77.getCoolAutoTag() != var124.getCoolAutoTag() || !Arrays.equals(var77.getCoolAutoPresets(), var124.getCoolAutoPresets()) || var77.getCoolEcoTag() != var124.getCoolEcoTag() || !Arrays.equals(var77.getCoolEcoPresets(), var124.getCoolEcoPresets())) {
                     break label681;
                  }
               } else if (var77 instanceof HasDehumidifierMainMode && var123 instanceof HasDehumidifierMainMode) {
                  if (((HasDehumidifierMainMode)var77).getDehSubMode() != ((HasDehumidifierMainMode)var123).getDehSubMode()) {
                     break label681;
                  }
               } else if (var77 instanceof HasPetMainMode && var123 instanceof HasPetMainMode && ((HasPetMainMode)var77).getSmartSubMode() != ((HasPetMainMode)var123).getSmartSubMode()) {
                  break label681;
               }
            }

            var39 = 0;
            break label682;
         }

         var39 = 1;
      }

      var77 = this.getAdapter().getDevice();
      HasTemperatureUnit var80;
      if (var77 instanceof HasTemperatureUnit) {
         var80 = (HasTemperatureUnit)var77;
      } else {
         var80 = null;
      }

      Integer var81;
      if (var80 != null) {
         var81 = var80.getTemperatureUnit();
      } else {
         var81 = null;
      }

      HasTemperatureUnit var125;
      if (var1 instanceof HasTemperatureUnit) {
         var125 = (HasTemperatureUnit)var1;
      } else {
         var125 = null;
      }

      Integer var126;
      if (var125 != null) {
         var126 = var125.getTemperatureUnit();
      } else {
         var126 = null;
      }

      boolean var29 = Intrinsics.areEqual(var81, var126);
      Device var82 = this.getAdapter().getDevice();
      HasMode var83;
      if (var82 instanceof HasMode) {
         var83 = (HasMode)var82;
      } else {
         var83 = null;
      }

      Integer var84;
      if (var83 != null) {
         var84 = var83.getMode();
      } else {
         var84 = null;
      }

      HasMode var127;
      if (var1 instanceof HasMode) {
         var127 = (HasMode)var1;
      } else {
         var127 = null;
      }

      Integer var128;
      if (var127 != null) {
         var128 = var127.getMode();
      } else {
         var128 = null;
      }

      boolean var24 = Intrinsics.areEqual(var84, var128);
      Device var85 = this.getAdapter().getDevice();
      HasHumMode var86;
      if (var85 instanceof HasHumMode) {
         var86 = (HasHumMode)var85;
      } else {
         var86 = null;
      }

      Boolean var87;
      if (var86 != null) {
         var87 = var86.getHumMode();
      } else {
         var87 = null;
      }

      HasHumMode var129;
      if (var1 instanceof HasHumMode) {
         var129 = (HasHumMode)var1;
      } else {
         var129 = null;
      }

      Boolean var130;
      if (var129 != null) {
         var130 = var129.getHumMode();
      } else {
         var130 = null;
      }

      boolean var28 = Intrinsics.areEqual(var87, var130);
      Device var88 = this.getAdapter().getDevice();
      HasWaterLevel var89;
      if (var88 instanceof HasWaterLevel) {
         var89 = (HasWaterLevel)var88;
      } else {
         var89 = null;
      }

      Integer var90;
      if (var89 != null) {
         var90 = var89.getWaterLevel();
      } else {
         var90 = null;
      }

      HasWaterLevel var131;
      if (var1 instanceof HasWaterLevel) {
         var131 = (HasWaterLevel)var1;
      } else {
         var131 = null;
      }

      Integer var132;
      if (var131 != null) {
         var132 = var131.getWaterLevel();
      } else {
         var132 = null;
      }

      boolean var23 = Intrinsics.areEqual(var90, var132);
      Device var91 = this.getAdapter().getDevice();
      HasWaterTank var92;
      if (var91 instanceof HasWaterTank) {
         var92 = (HasWaterTank)var91;
      } else {
         var92 = null;
      }

      Boolean var93;
      if (var92 != null) {
         var93 = var92.getWaterTankFailure();
      } else {
         var93 = null;
      }

      HasWaterTank var133;
      if (var1 instanceof HasWaterTank) {
         var133 = (HasWaterTank)var1;
      } else {
         var133 = null;
      }

      Boolean var134;
      if (var133 != null) {
         var134 = var133.getWaterTankFailure();
      } else {
         var134 = null;
      }

      boolean var21 = Intrinsics.areEqual(var93, var134);
      Device var94 = this.getAdapter().getDevice();
      HasDetectCat var95;
      if (var94 instanceof HasDetectCat) {
         var95 = (HasDetectCat)var94;
      } else {
         var95 = null;
      }

      Boolean var96;
      if (var95 != null) {
         var96 = var95.getDetectCat();
      } else {
         var96 = null;
      }

      HasDetectCat var135;
      if (var1 instanceof HasDetectCat) {
         var135 = (HasDetectCat)var1;
      } else {
         var135 = null;
      }

      Boolean var136;
      if (var135 != null) {
         var136 = var135.getDetectCat();
      } else {
         var136 = null;
      }

      boolean var26 = Intrinsics.areEqual(var96, var136);
      Device var97 = this.getAdapter().getDevice();
      HasCleanAirEta var98;
      if (var97 instanceof HasCleanAirEta) {
         var98 = (HasCleanAirEta)var97;
      } else {
         var98 = null;
      }

      Integer var99;
      if (var98 != null) {
         var99 = var98.getCleanAirEta();
      } else {
         var99 = null;
      }

      HasCleanAirEta var137;
      if (var1 instanceof HasCleanAirEta) {
         var137 = (HasCleanAirEta)var1;
      } else {
         var137 = null;
      }

      Integer var138;
      if (var137 != null) {
         var138 = var137.getCleanAirEta();
      } else {
         var138 = null;
      }

      boolean var32 = Intrinsics.areEqual(var99, var138);
      Device var100 = this.getAdapter().getDevice();
      HasDisplayMode var101;
      if (var100 instanceof HasDisplayMode) {
         var101 = (HasDisplayMode)var100;
      } else {
         var101 = null;
      }

      Integer var102;
      if (var101 != null) {
         var102 = var101.getPanelDisplayMode();
      } else {
         var102 = null;
      }

      HasDisplayMode var139;
      if (var1 instanceof HasDisplayMode) {
         var139 = (HasDisplayMode)var1;
      } else {
         var139 = null;
      }

      Integer var140;
      if (var139 != null) {
         var140 = var139.getPanelDisplayMode();
      } else {
         var140 = null;
      }

      boolean var31 = Intrinsics.areEqual(var102, var140);
      Device var103 = this.getAdapter().getDevice();
      HasGestureRecognition var104;
      if (var103 instanceof HasGestureRecognition) {
         var104 = (HasGestureRecognition)var103;
      } else {
         var104 = null;
      }

      Boolean var105;
      if (var104 != null) {
         var105 = var104.getHoverEnabled();
      } else {
         var105 = null;
      }

      if (var1 instanceof HasGestureRecognition) {
         var1 = var1;
      } else {
         var1 = null;
      }

      Boolean var38;
      if (var1 != null) {
         var38 = var1.getHoverEnabled();
      } else {
         var38 = null;
      }

      boolean var20 = Intrinsics.areEqual(var105, var38);
      return var2 || var3 || !var13 || !var11 || !var18 || !var14 || !var17 || !var15 || !var25 || !var27 || var4 || !var5 || var6 || !var22 || !var30 || !var12 || !var16 || var7 || !var19 || var8 || var9 || var39 || !var29 || !var24 || !var28 || !var23 || !var21 || !var26 || !var32 || !var31 || !var20;
   }

   private static final Snackbar networkSnack_delegate$lambda$0(DeviceAttributesFragment var0) {
      FragmentDeviceAttributesBinding var2 = var0.deviceAttributesBinding;
      FragmentDeviceAttributesBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
         var1 = null;
      }

      return Snackbar.make((View)var1.getRoot(), (CharSequence)var0.getString(R.string.connection_lost), -2);
   }

   private static final Unit onResume$lambda$28(DeviceAttributesFragment var0, AttributeAction var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("throttleLatest action: ");
      var3.append(var1);
      var2.v(var3.toString(), new Object[0]);
      Device var5 = var0.getAdapter().getDevice();
      Device var4 = var5;
      if (var5 == null) {
         var4 = var0.device;
      }

      if (var4 != null) {
         var0.shouldDoDbAndApiCall(var4, new DeviceAttributesFragment$$ExternalSyntheticLambda4(var1, var4, var0));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$28$lambda$27$lambda$26(AttributeAction var0, Device var1, DeviceAttributesFragment var2) {
      if (var0 instanceof AttributeAction.FanSpeedAction) {
         if (var1 instanceof HasCombo3in1MainMode) {
            int var4 = ((FanSpeedEnum)((AttributeAction.FanSpeedAction)var0).getValue()).toServerValue((HasFanSpeed)var1);
            MainMode var8 = ((HasMainMode)var1).mainMode();
            int var3 = DeviceAttributesFragment.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()];
            if (var3 != 1) {
               if (var3 != 2) {
                  if (var3 != 3) {
                     Unit var9 = Unit.INSTANCE;
                  } else {
                     var2.getViewModel().setHeatFanSpeed(var1, var4);
                  }
               } else {
                  var2.getViewModel().setApFanSpeed(var1, var4);
               }
            } else {
               var2.getViewModel().setCoolFanSpeed(var1, var4);
            }
         } else {
            var2.getViewModel().fanspeedSliderChanged(var1, (FanSpeedEnum)((AttributeAction.FanSpeedAction)var0).getValue());
         }
      } else if (var0 instanceof AttributeAction.AutoModeAction) {
         var2.getViewModel().autoModeChanged(var1, (Boolean)((AttributeAction.AutoModeAction)var0).getValue());
      } else {
         boolean var5 = var0 instanceof AttributeAction.AutoRhInfoAction;
         Object var7 = null;
         Object var6 = null;
         if (var5) {
            FragmentManager var10 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var10, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
            if (!(var10.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !var10.isStateSaved()) {
               int var36;
               if (var1 instanceof DeviceCombo2in1) {
                  var36 = R.string.target_humidity_info_2in1;
               } else {
                  var36 = R.string.target_humidity_info;
               }

               ((DialogFragment)PopupInfoDialogFragment.Companion.newInstance(R.string.humidity_target, (Integer)null, var36)).show(var10, "PopupInfoDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.AutoRhAction) {
            var2.getViewModel().autorhChanged(var1, ((Number)((AttributeAction.AutoRhAction)var0).getValue()).intValue());
         } else if (var0 instanceof AttributeAction.BrightnessAction) {
            var2.getViewModel().brightnessChanged(var1, (Brightness)((AttributeAction.BrightnessAction)var0).getValue());
         } else if (var0 instanceof AttributeAction.BrightnessPercentageAction) {
            var2.getViewModel().brightnessChanged(var1, ((Number)((AttributeAction.BrightnessPercentageAction)var0).getValue()).intValue());
         } else if (Intrinsics.areEqual(var0, AttributeAction.ChildLockAction.INSTANCE)) {
            var2.getViewModel().childLockChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.DisinfectionModeAction.INSTANCE)) {
            var2.getViewModel().disinfectionChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.EcoModeAction.INSTANCE)) {
            var2.getViewModel().ecoModeChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.GsnmSwitchAction.INSTANCE)) {
            var2.getViewModel().gsnmChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.ManualModeAction.INSTANCE)) {
            var2.getViewModel().setManualMode(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.NightModeAction.INSTANCE)) {
            var2.getViewModel().g4NightModeChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.OpenDisinfectionInfoAction.INSTANCE)) {
            FragmentManager var11 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var11, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var11.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var11.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.disinfection, (Integer)null, R.string.disinfection_description, R.string.close, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8128, (Object)null)).show(var11, "ConfirmationDialogLeftAligned");
            }
         } else if (var0 instanceof AttributeAction.OpenFilterInfoAction) {
            FragmentManager var12 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var12, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
            if (!(var12.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !var12.isStateSaved()) {
               int var37;
               if (!(var1 instanceof DeviceNewClassic) && !(var1 instanceof DevicePet20)) {
                  var37 = R.string.filter_maintenance_description;
               } else {
                  var37 = R.string.filter_maintenance_description_nc;
               }

               ((DialogFragment)PopupInfoDialogFragment.Companion.newInstance(R.string.filter_status, R.string.filter_maintenance, var37)).show(var12, "PopupInfoDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.OpenFilterPageAction) {
            if (DeviceKt.useNewFilterConfig(var1)) {
               FragmentManager var45 = var2.getParentFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var45, "getParentFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
               DialogFragment var32 = (DialogFragment)var6;
               if (!(var45.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment)) {
                  var32 = (DialogFragment)var6;
                  if (!var45.isStateSaved()) {
                     var32 = DeviceNFilterDialogFragment.Companion.newInstance$default(DeviceNFilterDialogFragment.Companion, var1, (String)null, DeviceFilterType.FILTER, (Boolean)((AttributeAction.OpenFilterPageAction)var0).getValue(), false, 16, (Object)null);
                     var32.show(var45, "DeviceNFilterDialogFragment");
                  }
               }

               BaseDialogFragment var13 = (BaseDialogFragment)var32;
            } else {
               FragmentManager var33 = var2.getParentFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var33, "getParentFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("DeviceFilterPageDialogFragment", "getSimpleName(...)");
               BaseDialogFragment var14 = (BaseDialogFragment)var7;
               if (!(var33.findFragmentByTag("DeviceFilterPageDialogFragment") instanceof DeviceFilterPageDialogFragment)) {
                  var14 = (BaseDialogFragment)var7;
                  if (!var33.isStateSaved()) {
                     var14 = DeviceFilterPageDialogFragment.Companion.newInstance$default(DeviceFilterPageDialogFragment.Companion, var1, false, 2, (Object)null);
                     ((DialogFragment)var14).show(var33, "DeviceFilterPageDialogFragment");
                  }
               }

               var14 = var14;
            }
         } else if (Intrinsics.areEqual(var0, AttributeAction.OpenGermShieldInfoAction.INSTANCE)) {
            FragmentManager var16 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var16, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var16.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var16.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.germ_shield_plus, (Integer)null, R.string.germ_shield_plus_mode_description, R.string.close, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8128, (Object)null)).show(var16, "ConfirmationDialogLeftAligned");
            }
         } else if (Intrinsics.areEqual(var0, AttributeAction.StandbyModeAction.INSTANCE)) {
            var2.getViewModel().standByChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.TimeZoneAction.INSTANCE)) {
            FragmentManager var17 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var17, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceSetTimezoneDialogFragment", "getSimpleName(...)");
            if (!(var17.findFragmentByTag("DeviceSetTimezoneDialogFragment") instanceof DeviceSetTimezoneDialogFragment) && !var17.isStateSaved()) {
               ((DialogFragment)DeviceSetTimezoneDialogFragment.Companion.newInstance(var1)).show(var17, "DeviceSetTimezoneDialogFragment");
            }
         } else if (Intrinsics.areEqual(var0, AttributeAction.TroubleShootAction.INSTANCE)) {
            FragmentManager var18 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var18, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
            if (!(var18.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var18.isStateSaved()) {
               ((DialogFragment)TroubleshootingDialog.Companion.newInstance("action_type_device_offline", var1)).show(var18, "TroubleshootingDialog");
               var18.executePendingTransactions();
            }

            var2.getAnalyticsService().event(new AnalyticEvent.TAP_TROUBLESHOOTING());
            Unit var19 = Unit.INSTANCE;
         } else if (Intrinsics.areEqual(var0, AttributeAction.OpenWickInfoAction.INSTANCE)) {
            FragmentManager var20 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var20, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
            if (!(var20.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !var20.isStateSaved()) {
               ((DialogFragment)PopupInfoDialogFragment.Companion.newInstance(R.string.wick_status, R.string.wick_maintenance, R.string.wick_maintenance_description)).show(var20, "PopupInfoDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.OpenWickPageAction) {
            FragmentManager var34 = var2.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var34, "getParentFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
            if (!(var34.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !var34.isStateSaved()) {
               ((DialogFragment)DeviceNFilterDialogFragment.Companion.newInstance$default(DeviceNFilterDialogFragment.Companion, var1, (String)null, DeviceFilterType.WICK, (Boolean)((AttributeAction.OpenWickPageAction)var0).getValue(), false, 16, (Object)null)).show(var34, "DeviceNFilterDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.OpenTimerInfoAction) {
            FragmentManager var21 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var21, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
            if (!(var21.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !var21.isStateSaved()) {
               ((DialogFragment)PopupInfoDialogFragment.Companion.newInstance(R.string.timer, (Integer)null, R.string.timer_description)).show(var21, "PopupInfoDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.TimerStateAction) {
            var2.getViewModel().timerStatusChanged(var1, ((TimerState)((AttributeAction.TimerStateAction)var0).getValue()).getValue());
         } else if (var0 instanceof AttributeAction.TimerDurationAction) {
            var2.getViewModel().timerDurationChanged(var1, ((Number)((AttributeAction.TimerDurationAction)var0).getValue()).intValue());
         } else if (var0 instanceof AttributeAction.OpenDryModeInfoAction) {
            FragmentManager var35 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var35, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DialogFragment", "getSimpleName(...)");
            if (!(var35.findFragmentByTag("DialogFragment") instanceof DialogFragment) && !var35.isStateSaved()) {
               DialogFragment var22;
               if (var1 instanceof DeviceCombo2in1) {
                  var22 = ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.dry_mode, (Integer)null, R.string.dry_mode_description_2in1_short, R.string.add_device_success_btn_okay, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null);
               } else {
                  var22 = PopupInfoDialogFragment.Companion.newInstance(R.string.dry_mode, (Integer)null, R.string.dry_mode_description);
               }

               var22.show(var35, "DialogFragment");
            }
         } else if (var0 instanceof AttributeAction.DryModeCancelAction) {
            var2.getViewModel().wickDryCanceled(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.OscillationEnableAction.INSTANCE)) {
            var2.getViewModel().oscillationStateChanged(var1);
         } else if (Intrinsics.areEqual(var0, AttributeAction.OscillationSettingAction.INSTANCE)) {
            FragmentManager var23 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var23, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceOscillationSettingsDialogFragment", "getSimpleName(...)");
            if (!(var23.findFragmentByTag("DeviceOscillationSettingsDialogFragment") instanceof DeviceOscillationSettingsDialogFragment) && !var23.isStateSaved()) {
               ((DialogFragment)DeviceOscillationSettingsDialogFragment.Companion.newInstance(var1)).show(var23, "DeviceOscillationSettingsDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.MainModeAction) {
            var2.getViewModel().setMainMode(var1, ((MainMode)((AttributeAction.MainModeAction)var0).getValue()).getValue());
         } else if (var0 instanceof AttributeAction.ApSubModeAction) {
            if (var1 instanceof DevicePet20) {
               var2.getViewModel().setApSubMode(var1, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue(), true);
            } else if (var1 instanceof DeviceCombo3in1) {
               MainMode var41 = ((DeviceCombo3in1)var1).mainMode();
               int var38 = DeviceAttributesFragment.WhenMappings.$EnumSwitchMapping$0[var41.ordinal()];
               if (var38 != 1) {
                  if (var38 != 2) {
                     if (var38 != 3) {
                        Unit var24 = Unit.INSTANCE;
                     } else {
                        var2.getViewModel().setHeatSubMode(var1, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue());
                     }
                  } else {
                     DeviceDetailsViewModel.setApSubMode$default(var2.getViewModel(), var1, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue(), false, 4, (Object)null);
                  }
               } else {
                  var2.getViewModel().setCoolSubMode(var1, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue());
               }
            }

            Unit var25 = Unit.INSTANCE;
         } else if (var0 instanceof AttributeAction.SmartSubModeAction) {
            AttributeAction.SmartSubModeAction var42 = (AttributeAction.SmartSubModeAction)var0;
            if ((SmartSubMode)var42.getValue() == SmartSubMode.AUTO_OFF) {
               FragmentManager var43 = var2.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var43, "getChildFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
               if (!(var43.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var43.isStateSaved()) {
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer)null, R.string.prompt_turn_off_smart_auto, R.string.snackbar_ok, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new DeviceAttributesFragment$$ExternalSyntheticLambda0(var2, var1, var0), 3680, (Object)null)).show(var43, "ConfirmationDialogLeftAligned");
               }
            } else {
               var2.getViewModel().setSmartSubMode(var1, ((SmartSubMode)var42.getValue()).getValue());
            }
         } else if (var0 instanceof AttributeAction.PeelingAction) {
            var2.getViewModel().setTare(var1);
            FragmentManager var26 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var26, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var26.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var26.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer)null, R.string.prompt_peeling_in_progress, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var26, "ConfirmationDialogLeftAligned");
            }
         } else if (var0 instanceof AttributeAction.TargetTemperatureAction) {
            if (var1 instanceof HasCombo3in1MainMode) {
               ApSubMode var44 = ((HasCombo3in1MainMode)var1).currentSubMode();
               int var39 = DeviceAttributesFragment.WhenMappings.$EnumSwitchMapping$1[var44.ordinal()];
               if (var39 != 1) {
                  if (var39 != 2) {
                     Unit var27 = Unit.INSTANCE;
                  } else {
                     var2.getViewModel().setHeatEcoTmp(var1, ((Number)((AttributeAction.TargetTemperatureAction)var0).getValue()).doubleValue());
                  }
               } else {
                  var2.getViewModel().setHeatAutoTmp(var1, ((Number)((AttributeAction.TargetTemperatureAction)var0).getValue()).doubleValue());
               }
            }

            Unit var28 = Unit.INSTANCE;
         } else if (var0 instanceof AttributeAction.OpenFanPresetPageAction) {
            FragmentManager var29 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var29, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceFanPresetDialogFragment", "getSimpleName(...)");
            if (!(var29.findFragmentByTag("DeviceFanPresetDialogFragment") instanceof DeviceFanPresetDialogFragment) && !var29.isStateSaved()) {
               ((DialogFragment)DeviceFanPresetDialogFragment.Companion.newInstance(var1)).show(var29, "DeviceFanPresetDialogFragment");
            }
         } else if (var0 instanceof AttributeAction.OpenHinsInfoAction) {
            FragmentManager var31 = var2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var31, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var31.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var31.isStateSaved()) {
               int var40;
               if ((Boolean)((AttributeAction.OpenHinsInfoAction)var0).getValue()) {
                  var40 = R.string.photon_pure_night;
               } else {
                  var40 = R.string.photon_pure;
               }

               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var40, (Integer)null, R.string.photon_pure_description, R.string.close, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8128, (Object)null)).show(var31, "ConfirmationDialogLeftAligned");
            }
         } else if (var0 instanceof AttributeAction.HinsLockAction) {
            if ((Boolean)((AttributeAction.HinsLockAction)var0).getValue()) {
               var2.getViewModel().hinsNightModeChanged(var1);
            } else {
               var2.getViewModel().hinsModeChanged(var1);
            }
         } else if (var0 instanceof AttributeAction.ModeAction) {
            var2.getViewModel().setMode(var1, ((Mode)((AttributeAction.ModeAction)var0).getValue()).getValue());
         } else if (var0 instanceof AttributeAction.HumModeAction) {
            var2.getViewModel().humModeChanged(var1);
         } else {
            Unit var30 = Unit.INSTANCE;
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$28$lambda$27$lambda$26$lambda$22$lambda$21(DeviceAttributesFragment var0, Device var1, AttributeAction var2, boolean var3) {
      if (var3) {
         var0.getViewModel().setSmartSubMode(var1, ((SmartSubMode)((AttributeAction.SmartSubModeAction)var2).getValue()).getValue());
      } else {
         var0.getAdapter().notifySubAutoChanged();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$3(DeviceAttributesFragment var0, Device var1) {
      Intrinsics.checkNotNull(var1);
      if (var0.hasDeviceAttributesChanged(var1)) {
         var0.getAdapter().setDevice(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$4(DeviceAttributesFragment var0, boolean var1) {
      if (var1) {
         var0.getNetworkSnack().dismiss();
         var0.getAdapter().setForceOffline(false);
      } else {
         var0.getNetworkSnack().show();
         var0.getAdapter().setForceOffline(true);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$6(DeviceAttributesFragment var0, Boolean var1) {
      if (var1) {
         FragmentManager var3 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var3.isStateSaved()) {
            int var2;
            if (var0.device instanceof DeviceCombo2in1) {
               var2 = R.string.prompt_target_humidity_2in1;
            } else {
               var2 = R.string.prompt_target_humidity;
            }

            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.humidity_target, (Integer)null, var2, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var3, "ConfirmationDialogLeftAligned");
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$7(DeviceAttributesFragment var0, IndoorDatapoint var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("liveLatestDataPoint = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      var0.getAdapter().setLatestDatapoint(var1);
      return Unit.INSTANCE;
   }

   private final void shouldDoDbAndApiCall(Device var1, Function0 var2) {
      if (var1 instanceof HasSafetySwitch) {
         Context var3 = this.getContext();
         if (var3 == null || NetUtil.INSTANCE.isProbablyOnline(var3)) {
            if (ViewUtils.INSTANCE.shouldShowFilterDoorPopup((HasSafetySwitch)var1)) {
               ConfirmationDialogCentered.Companion var5 = ConfirmationDialogCentered.Companion;
               FragmentManager var4 = this.getParentFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var4, "getParentFragmentManager(...)");
               var5.showFilterDoorOpenDialog(var4);
            } else {
               var2.invoke();
            }
         }
      } else {
         var2.invoke();
      }
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public final Device getDevice() {
      return this.device;
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      FragmentDeviceAttributesBinding var2 = this.deviceAttributesBinding;
      FragmentDeviceAttributesBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
         var1 = null;
      }

      return var1.layoutMain;
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentDeviceAttributesBinding var4 = FragmentDeviceAttributesBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.deviceAttributesBinding = var4;
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceDetailsViewModel.class)));
      Bundle var5 = this.getArguments();
      Object var16 = null;
      Device var6;
      if (var5 != null) {
         var6 = (Device)var5.getParcelable("key_device");
      } else {
         var6 = null;
      }

      this.device = var6;
      Bundle var7 = this.getArguments();
      String var8;
      if (var7 != null) {
         var8 = var7.getString("key_action_type");
      } else {
         var8 = null;
      }

      this.actionType = var8;
      Device var9 = this.device;
      if (var9 != null) {
         this.getViewModel().setDeviceId(var9.getUid());
      }

      FragmentDeviceAttributesBinding var17 = this.deviceAttributesBinding;
      FragmentDeviceAttributesBinding var10 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
         var10 = null;
      }

      RecyclerView.ItemAnimator var11 = var10.recyclerViewAttributes.getItemAnimator();
      SimpleItemAnimator var12;
      if (var11 instanceof SimpleItemAnimator) {
         var12 = (SimpleItemAnimator)var11;
      } else {
         var12 = null;
      }

      if (var12 != null) {
         var12.setSupportsChangeAnimations(false);
      }

      var17 = this.deviceAttributesBinding;
      FragmentDeviceAttributesBinding var13 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
         var13 = null;
      }

      var13.recyclerViewAttributes.setAdapter(this.getAdapter());
      var13 = this.deviceAttributesBinding;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceAttributesBinding");
         var13 = (FragmentDeviceAttributesBinding)var16;
      }

      ConstraintLayout var15 = var13.getRoot();
      Intrinsics.checkNotNullExpressionValue(var15, "getRoot(...)");
      return (View)var15;
   }

   public void onResume() {
      super.onResume();
      CompositeDisposable var2 = this.getRxSubs();
      Observable var3 = this.getAttributeActionPublisher().throttleLatest(300L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var3, "throttleLatest(...)");
      var2.add(RxExtensionsKt.subscribeAndLogE(var3, new DeviceAttributesFragment$$ExternalSyntheticLambda3(this)));
      String var4 = this.actionType;
      if (var4 != null) {
         label25: {
            int var1 = var4.hashCode();
            if (var1 != -2123968024) {
               if (var1 != -1274492040) {
                  if (var1 == 590772454 && var4.equals("wick_purchase")) {
                     this.getAttributeActionPublisher().onNext(new AttributeAction.OpenWickPageAction(false));
                  }
                  break label25;
               }

               if (!var4.equals("filter")) {
                  break label25;
               }
            } else if (!var4.equals("filter_purchase")) {
               break label25;
            }

            this.getAttributeActionPublisher().onNext(new AttributeAction.OpenFilterPageAction(false));
         }
      }

      this.actionType = null;
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      LiveData var3 = this.getViewModel().getLiveDevice();
      LifecycleOwner var6 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var6, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var3, var6, new DeviceAttributesFragment$$ExternalSyntheticLambda5(this));
      var3 = this.getViewModel().getNetworkAvailable();
      var6 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var6, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var3, var6, new DeviceAttributesFragment$$ExternalSyntheticLambda6(this));
      this.getViewModel().getAutoModeFirstClicked().observe(this.getViewLifecycleOwner(), new Observer(new DeviceAttributesFragment$$ExternalSyntheticLambda7(this)) {
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
      if (this.device instanceof HasSensorData) {
         this.getViewModel().getLiveLatestDataPoint().observe(this.getViewLifecycleOwner(), new Observer(new DeviceAttributesFragment$$ExternalSyntheticLambda8(this)) {
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
      }

      Device var5 = this.device;
      if (var5 != null && DeviceKt.supportDisinfection(var5)) {
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final DeviceAttributesFragment this$0;

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
               Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(30000L, var6) == var5) {
                     return var5;
                  }
               }

               do {
                  var1 = this.this$0.getAdapter().getDevice();
                  if (var1 instanceof HasDisinfection) {
                     var1 = (HasDisinfection)var1;
                  } else {
                     var1 = null;
                  }

                  if (var1 != null && Intrinsics.areEqual(var1.getDisinfection(), Boxing.boxBoolean(true)) && var1.getDisinfectLeftTime() != null && var1.getDisinfectLeftTimeUpdateTime() != null) {
                     long var3 = System.currentTimeMillis() / (long)1000;
                     Long var9 = var1.getDisinfectLeftTimeUpdateTime();
                     Intrinsics.checkNotNull(var9);
                     if (var3 - (long)((int)var9) > 25L) {
                        this.this$0.getAdapter().notifyDisinfectLeftTimeChanged();
                     }
                  }

                  var10 = (Continuation)this;
                  this.label = 1;
               } while(DelayKt.delay(30000L, var10) != var5);

               return var5;
            }
         }, 3, (Object)null);
      }

      if (this.device instanceof HasTimer) {
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final DeviceAttributesFragment this$0;

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
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(1000L, var5) == var3) {
                     return var3;
                  }
               }

               do {
                  var1 = this.this$0.getAdapter().getDevice();
                  if (var1 instanceof HasTimer) {
                     var1 = (HasTimer)var1;
                  } else {
                     var1 = null;
                  }

                  if (var1 != null) {
                     DeviceAttributesFragment var4 = this.this$0;
                     if (SetsKt.setOf(new TimerState[]{TimerState.START, TimerState.RESUME}).contains(var1.timerStatus())) {
                        var4.getAdapter().notifyTimerLeftTimeChanged();
                     }
                  }

                  var8 = (Continuation)this;
                  this.label = 1;
               } while(DelayKt.delay(1000L, var8) != var3);

               return var3;
            }
         }, 3, (Object)null);
      }

      if (this.device instanceof HasWick) {
         BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final DeviceAttributesFragment this$0;

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
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(1000L, var5) == var3) {
                     return var3;
                  }
               }

               do {
                  var1 = this.this$0.getAdapter().getDevice();
                  if (var1 instanceof HasWick) {
                     var1 = (HasWick)var1;
                  } else {
                     var1 = null;
                  }

                  if (var1 != null) {
                     DeviceAttributesFragment var4 = this.this$0;
                     if (var1.getWickdryOn()) {
                        var4.getAdapter().notifyWickDryLeftTimeChanged();
                     }
                  }

                  var8 = (Continuation)this;
                  this.label = 1;
               } while(DelayKt.delay(1000L, var8) != var3);

               return var3;
            }
         }, 3, (Object)null);
      }

   }

   public final void setDevice(Device var1) {
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
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceAttributesFragment$Companion;", "", "<init>", "()V", "KEY_DEVICE", "", "KEY_ACTION_TYPE", "THROTTLE_SHORT_MILLISECONDS", "", "THROTTLE_LONG_MILLISECONDS", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceAttributesFragment;", "device", "Lcom/blueair/core/model/Device;", "actionType", "devicedetails_otherRelease"},
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
      public static DeviceAttributesFragment newInstance$default(Companion var0, Device var1, String var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.newInstance(var1, var2);
      }

      public final DeviceAttributesFragment newInstance(Device var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceAttributesFragment var3 = new DeviceAttributesFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("key_device", var1), TuplesKt.to("key_action_type", var2)}));
         return var3;
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
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.COOL.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[MainMode.AirPurify.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.AUTO.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ApSubMode.ECO.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
