package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AirRefreshState;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoLevel;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasNightModeTiming;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HasWickDryDuration;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.core.model.TimerState;
import com.blueair.core.model.WickDryingGear;
import com.blueair.devicedetails.activity.AlarmListActivity;
import com.blueair.devicedetails.activity.DeviceFilterDetailActivity;
import com.blueair.devicedetails.activity.DeviceSettingsActivity;
import com.blueair.devicedetails.activity.ScheduleListActivity;
import com.blueair.devicedetails.adapter.DeviceControlsAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceControlsBinding;
import com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment;
import com.blueair.devicedetails.dialog.DeviceDualOscillationSettingsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceOscillationSettingsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceTimerPickerV2DialogFragment;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceControl;
import com.blueair.devicedetails.util.DeviceControlGroup;
import com.blueair.devicedetails.util.DeviceControlUtils;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020=H\u0002J*\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\u00172\f\u0010E\u001a\b\u0012\u0004\u0012\u00020=0FH\u0002J\u0010\u0010G\u001a\u00020=2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00140\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b$\u0010!R\u001b\u0010&\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b'\u0010!R\u001b\u0010)\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000f\u001a\u0004\b*\u0010!R\u001b\u0010,\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b-\u0010!R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001f008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000f\u001a\u0004\b1\u00102¨\u0006L"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceControlsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "schedulesViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "getSchedulesViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "schedulesViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceControlsBinding;", "schedulePageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "controlActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "getControlActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "controlActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "filterDetailLauncher", "kotlin.jvm.PlatformType", "adapterMode", "Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "getAdapterMode", "()Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "adapterMode$delegate", "adapterControl", "getAdapterControl", "adapterControl$delegate", "adapterLight", "getAdapterLight", "adapterLight$delegate", "adapterSchedule", "getAdapterSchedule", "adapterSchedule$delegate", "adapterFilter", "getAdapterFilter", "adapterFilter$delegate", "adapters", "", "getAdapters", "()Ljava/util/List;", "adapters$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "showTimePickerDialog", "shouldDoDbAndApiCall", "device", "Lcom/blueair/core/model/Device;", "action", "call", "Lkotlin/Function0;", "checkWickDryingAndCancel", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceControlsFragment extends BaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceControlsFragment.class, "controlActionPublisher", "getControlActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy adapterControl$delegate;
   private final Lazy adapterFilter$delegate;
   private final Lazy adapterLight$delegate;
   private final Lazy adapterMode$delegate;
   private final Lazy adapterSchedule$delegate;
   private final Lazy adapters$delegate;
   private FragmentDeviceControlsBinding binding;
   private final LazyPublishSubject controlActionPublisher$delegate;
   private final ActivityResultLauncher filterDetailLauncher;
   private final ActivityResultLauncher schedulePageLauncher;
   private final Lazy schedulesViewModel$delegate;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$1hMM4ZxcEXWzneQgt7tZ6uTkxAA(DeviceControlsFragment var0, AttributeAction var1) {
      return onResume$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2mR8n1N_Tf4a6PIXV6sfDIE__0A/* $FF was: $r8$lambda$2mR8n1N-Tf4a6PIXV6sfDIE--0A*/(DeviceControlsFragment var0, View var1) {
      onCreateView$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$7qzY_ZH3yHVAfP5YWvZB4sfT9eo(DeviceControlsFragment var0, boolean var1) {
      return onViewCreated$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceControlsAdapter $r8$lambda$90I_kEf6nkeQUtUy8Us4JtLmlk4(DeviceControlsFragment var0) {
      return adapterMode_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static DeviceControlsAdapter $r8$lambda$9OMOWMV___7RXHhVIPji5Miukmk/* $FF was: $r8$lambda$9OMOWMV-__7RXHhVIPji5Miukmk*/(DeviceControlsFragment var0) {
      return adapterSchedule_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ACriEbLXX8GoTklIKtNnYIuBlxA(DeviceControlsFragment var0, List var1) {
      return onViewCreated$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$AggNDt_K3hO38kYpn30CVnn4zM0/* $FF was: $r8$lambda$AggNDt-K3hO38kYpn30CVnn4zM0*/(DeviceControlsFragment var0, boolean var1) {
      return onResume$lambda$49$lambda$48$lambda$47$lambda$36$lambda$35(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$AkMAJHqq_IdB3caVJGkPIUaFlso(DeviceControlsFragment var0, Device var1) {
      return onViewCreated$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$I7XUumyFpMs26GSHD_BZoBjOndQ/* $FF was: $r8$lambda$I7XUumyFpMs26GSHD-BZoBjOndQ*/(DeviceControlsFragment var0, boolean var1) {
      return onResume$lambda$49$lambda$48$lambda$47$lambda$21$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static List $r8$lambda$NP2Rm7WlV9x0t9uC5TFfZopcm0Q(DeviceControlsFragment var0) {
      return adapters_delegate$lambda$7(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Od3Zx61NHwImmdkfH3ty5nxP4XE(DeviceControlsFragment var0, HasTimer var1, int var2) {
      return showTimePickerDialog$lambda$53$lambda$52$lambda$51$lambda$50(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Oh07bp4vE6oyejCAV7xxekG7UcU(DeviceControlsFragment var0, Device var1, boolean var2) {
      return onResume$lambda$49$lambda$48$lambda$47$lambda$25$lambda$24$lambda$23(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$VnchiDktSfREG5m2_dqvZi2qmAA(DeviceControlsFragment var0) {
      return onCreateView$lambda$11(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Yc9JCBwgPpAokM9WgfKZlSb3pqI(AttributeAction var0, DeviceControlsFragment var1, Device var2) {
      return onResume$lambda$49$lambda$48$lambda$47(var0, var1, var2);
   }

   // $FF: synthetic method
   public static DeviceControlsAdapter $r8$lambda$f72g51BU14wE6kIsdKOi9evk5l8(DeviceControlsFragment var0) {
      return adapterFilter_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static DeviceControlsAdapter $r8$lambda$jQ7x8rwrnfVChl0ihZtw0Wb_LFI(DeviceControlsFragment var0) {
      return adapterLight_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$rNrJjfy_iwiZUU_Vh_6H_6WAlzo/* $FF was: $r8$lambda$rNrJjfy-iwiZUU_Vh_6H_6WAlzo*/(DeviceControlsFragment var0) {
      return onCreateView$lambda$12(var0);
   }

   // $FF: synthetic method
   public static DeviceControlsAdapter $r8$lambda$uvELGstlDv6NvrFA1QDQhM4lAgc(DeviceControlsFragment var0) {
      return adapterControl_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$v8EXzgv0x1pcGILmwBzWfBt51H0(DeviceControlsFragment var0) {
      return onCreateView$lambda$10(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$wfN3YR_8b73FM2H5mIa4XHajp14/* $FF was: $r8$lambda$wfN3YR-8b73FM2H5mIa4XHajp14*/(DeviceControlsFragment var0, AttributeAction var1) {
      return onResume$lambda$49(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xNzoXjcNS8ImXxz_cU_kSOgRjbY/* $FF was: $r8$lambda$xNzoXjcNS8ImXxz-cU_kSOgRjbY*/(ActivityResult var0) {
      filterDetailLauncher$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$y88nbQFexoe_EbUByNb6SYIHWW4(DeviceControlsFragment var0, ActivityResult var1) {
      schedulePageLauncher$lambda$0(var0, var1);
   }

   public DeviceControlsFragment() {
      Fragment var1 = this;
      Function0 var2 = new Function0(var1) {
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final Fragment invoke() {
            return this.$this_viewModels;
         }
      };
      Lazy var5 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0(var2) {
         final Function0 $ownerProducer;

         public {
            this.$ownerProducer = var1;
         }

         public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner)this.$ownerProducer.invoke();
         }
      });
      this.schedulesViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(var1, Reflection.getOrCreateKotlinClass(DeviceSchedulesViewModel.class), new Function0(var5) {
         final Lazy $owner$delegate;

         public {
            this.$owner$delegate = var1;
         }

         public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate).getViewModelStore();
         }
      }, new Function0((Function0)null, var5) {
         final Function0 $extrasProducer;
         final Lazy $owner$delegate;

         public {
            this.$extrasProducer = var1;
            this.$owner$delegate = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            ViewModelStoreOwner var3 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var4;
            if (var3 instanceof HasDefaultViewModelProviderFactory) {
               var4 = (HasDefaultViewModelProviderFactory)var3;
            } else {
               var4 = null;
            }

            return var4 != null ? var4.getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         }
      }, new Function0(var1, var5) {
         final Lazy $owner$delegate;
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
            this.$owner$delegate = var2;
         }

         public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner var1 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var2;
            if (var1 instanceof HasDefaultViewModelProviderFactory) {
               var2 = (HasDefaultViewModelProviderFactory)var1;
            } else {
               var2 = null;
            }

            if (var2 != null) {
               ViewModelProvider.Factory var3 = var2.getDefaultViewModelProviderFactory();
               if (var3 != null) {
                  return var3;
               }
            }

            ViewModelProvider.Factory var4 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(var4, "defaultViewModelProviderFactory");
            return var4;
         }
      });
      ActivityResultLauncher var3 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new DeviceControlsFragment$$ExternalSyntheticLambda18(this));
      Intrinsics.checkNotNullExpressionValue(var3, "registerForActivityResult(...)");
      this.schedulePageLauncher = var3;
      this.controlActionPublisher$delegate = new LazyPublishSubject();
      var3 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new DeviceControlsFragment$$ExternalSyntheticLambda19());
      Intrinsics.checkNotNullExpressionValue(var3, "registerForActivityResult(...)");
      this.filterDetailLauncher = var3;
      this.adapterMode$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda20(this));
      this.adapterControl$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda21(this));
      this.adapterLight$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda1(this));
      this.adapterSchedule$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda2(this));
      this.adapterFilter$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda3(this));
      this.adapters$delegate = LazyKt.lazy(new DeviceControlsFragment$$ExternalSyntheticLambda4(this));
   }

   private static final DeviceControlsAdapter adapterControl_delegate$lambda$3(DeviceControlsFragment var0) {
      return new DeviceControlsAdapter(DeviceControlGroup.CONTROL, var0.getControlActionPublisher());
   }

   private static final DeviceControlsAdapter adapterFilter_delegate$lambda$6(DeviceControlsFragment var0) {
      return new DeviceControlsAdapter(DeviceControlGroup.FILTER, var0.getControlActionPublisher());
   }

   private static final DeviceControlsAdapter adapterLight_delegate$lambda$4(DeviceControlsFragment var0) {
      return new DeviceControlsAdapter(DeviceControlGroup.LIGHT, var0.getControlActionPublisher());
   }

   private static final DeviceControlsAdapter adapterMode_delegate$lambda$2(DeviceControlsFragment var0) {
      return new DeviceControlsAdapter(DeviceControlGroup.MODE, var0.getControlActionPublisher());
   }

   private static final DeviceControlsAdapter adapterSchedule_delegate$lambda$5(DeviceControlsFragment var0) {
      return new DeviceControlsAdapter(DeviceControlGroup.SCHEDULE, var0.getControlActionPublisher());
   }

   private static final List adapters_delegate$lambda$7(DeviceControlsFragment var0) {
      return CollectionsKt.listOf(new DeviceControlsAdapter[]{var0.getAdapterMode(), var0.getAdapterControl(), var0.getAdapterLight(), var0.getAdapterSchedule(), var0.getAdapterFilter()});
   }

   private final void checkWickDryingAndCancel(Device var1) {
      if (var1 instanceof DeviceHumidifier20 && ((DeviceHumidifier20)var1).getWickdryOn()) {
         this.getViewModel().wickDryCanceled(var1);
      }

   }

   private static final void filterDetailLauncher$lambda$1(ActivityResult var0) {
   }

   private final DeviceControlsAdapter getAdapterControl() {
      return (DeviceControlsAdapter)this.adapterControl$delegate.getValue();
   }

   private final DeviceControlsAdapter getAdapterFilter() {
      return (DeviceControlsAdapter)this.adapterFilter$delegate.getValue();
   }

   private final DeviceControlsAdapter getAdapterLight() {
      return (DeviceControlsAdapter)this.adapterLight$delegate.getValue();
   }

   private final DeviceControlsAdapter getAdapterMode() {
      return (DeviceControlsAdapter)this.adapterMode$delegate.getValue();
   }

   private final DeviceControlsAdapter getAdapterSchedule() {
      return (DeviceControlsAdapter)this.adapterSchedule$delegate.getValue();
   }

   private final List getAdapters() {
      return (List)this.adapters$delegate.getValue();
   }

   private final PublishSubject getControlActionPublisher() {
      return this.controlActionPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final DeviceSchedulesViewModel getSchedulesViewModel() {
      return (DeviceSchedulesViewModel)this.schedulesViewModel$delegate.getValue();
   }

   private static final Unit onCreateView$lambda$10(DeviceControlsFragment var0) {
      FragmentDeviceControlsBinding var3 = var0.binding;
      FragmentDeviceControlsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ShadowedRecyclerViewLayout var4 = var2.rvControlGroup;
      Intrinsics.checkNotNullExpressionValue(var4, "rvControlGroup");
      View var5 = (View)var4;
      boolean var1;
      if (var0.getAdapterControl().getItemCount() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      ViewExtensionsKt.show(var5, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$11(DeviceControlsFragment var0) {
      FragmentDeviceControlsBinding var3 = var0.binding;
      FragmentDeviceControlsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      ShadowedRecyclerViewLayout var4 = var2.rvFilterGroup;
      Intrinsics.checkNotNullExpressionValue(var4, "rvFilterGroup");
      View var5 = (View)var4;
      boolean var1;
      if (var0.getAdapterFilter().getItemCount() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      ViewExtensionsKt.show(var5, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateView$lambda$12(DeviceControlsFragment var0) {
      FragmentDeviceControlsBinding var3 = var0.binding;
      FragmentDeviceControlsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      RecyclerView var4 = var2.rvLightGroup;
      Intrinsics.checkNotNullExpressionValue(var4, "rvLightGroup");
      View var5 = (View)var4;
      boolean var1;
      if (var0.getAdapterLight().getItemCount() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      ViewExtensionsKt.show(var5, var1);
      return Unit.INSTANCE;
   }

   private static final void onCreateView$lambda$13(DeviceControlsFragment var0, View var1) {
      FragmentDeviceControlsBinding var2 = var0.binding;
      FragmentDeviceControlsBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      ConstraintLayout var4 = var3.controlsHintContainer;
      Intrinsics.checkNotNullExpressionValue(var4, "controlsHintContainer");
      ViewExtensionsKt.show((View)var4, false);
      var0.getViewModel().setControlsHintClosedBefore(true);
   }

   private static final Unit onResume$lambda$19(DeviceControlsFragment var0, AttributeAction var1) {
      if (var1 instanceof AttributeAction.AutoRhShowHintAction) {
         BuildersKt.launch$default(var0, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(var1, var0, (Continuation)null) {
            final AttributeAction $action;
            int label;
            final DeviceControlsFragment this$0;

            {
               this.$action = var1;
               this.this$0 = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.$action, this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label != 0) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               } else {
                  ResultKt.throwOnFailure(var1);
                  boolean var2 = (Boolean)((AttributeAction.AutoRhShowHintAction)this.$action).getValue();
                  var1 = null;
                  Object var3 = null;
                  if (var2 && !this.this$0.getViewModel().getControlsHintClosedBefore()) {
                     FragmentDeviceControlsBinding var4 = this.this$0.binding;
                     var1 = var4;
                     if (var4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var1 = null;
                     }

                     var1.controlsHintText.setText(DeviceControlUtils.INSTANCE.obtainTargetHumidityInfoRes(this.this$0.getViewModel().getDevice()));
                     var1 = this.this$0.binding;
                     if (var1 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var1 = (FragmentDeviceControlsBinding)var3;
                     }

                     ConstraintLayout var9 = var1.controlsHintContainer;
                     Intrinsics.checkNotNullExpressionValue(var9, "controlsHintContainer");
                     ViewExtensionsKt.show((View)var9, true);
                  } else {
                     FragmentDeviceControlsBinding var10 = this.this$0.binding;
                     if (var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                     } else {
                        var1 = var10;
                     }

                     ConstraintLayout var6 = var1.controlsHintContainer;
                     Intrinsics.checkNotNullExpressionValue(var6, "controlsHintContainer");
                     ViewExtensionsKt.show((View)var6, false);
                  }

                  return Unit.INSTANCE;
               }
            }
         }, 2, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$49(DeviceControlsFragment var0, AttributeAction var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("throttleLatest action: ");
      var3.append(var1);
      var2.v(var3.toString(), new Object[0]);
      Device var4 = var0.getViewModel().getDevice();
      if (var4 != null) {
         Intrinsics.checkNotNull(var1);
         var0.shouldDoDbAndApiCall(var4, var1, new DeviceControlsFragment$$ExternalSyntheticLambda0(var1, var0, var4));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$49$lambda$48$lambda$47(AttributeAction var0, DeviceControlsFragment var1, Device var2) {
      if (var0 instanceof AttributeAction.MainModeAction) {
         var1.getViewModel().setMainMode(var2, ((MainMode)((AttributeAction.MainModeAction)var0).getValue()).getValue());
      } else if (var0 instanceof AttributeAction.ApSubModeAction) {
         if (var2 instanceof DeviceCombo3in1) {
            MainMode var5 = ((DeviceCombo3in1)var2).mainMode();
            int var3 = DeviceControlsFragment.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
            if (var3 != 1) {
               if (var3 != 2) {
                  if (var3 != 3) {
                     Unit var6 = Unit.INSTANCE;
                  } else {
                     var1.getViewModel().setHeatSubMode(var2, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue());
                  }
               } else {
                  var1.getViewModel().setCoolSubMode(var2, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue());
               }
            } else {
               DeviceDetailsViewModel.setApSubMode$default(var1.getViewModel(), var2, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue(), false, 4, (Object)null);
            }
         } else {
            var1.getViewModel().setApSubMode(var2, ((ApSubMode)((AttributeAction.ApSubModeAction)var0).getValue()).getValue(), var2 instanceof DevicePet20);
         }
      } else if (var0 instanceof AttributeAction.DehSubModeAction) {
         var1.getViewModel().setDehSubMode(var2, ((DehSubMode)((AttributeAction.DehSubModeAction)var0).getValue()).getValue());
      } else if (var0 instanceof AttributeAction.ModeAction) {
         var1.getViewModel().setMode(var2, ((Mode)((AttributeAction.ModeAction)var0).getValue()).getValue());
      } else if (var0 instanceof AttributeAction.FanSpeedAction) {
         if (var2 instanceof HasCombo3in1MainMode) {
            int var4 = ((FanSpeedEnum)((AttributeAction.FanSpeedAction)var0).getValue()).toServerValue(var2);
            MainMode var7 = ((HasCombo3in1MainMode)var2).mainMode();
            int var72 = DeviceControlsFragment.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
            if (var72 != 1) {
               if (var72 != 2) {
                  if (var72 != 3) {
                     Unit var8 = Unit.INSTANCE;
                  } else {
                     var1.getViewModel().setHeatFanSpeed(var2, var4);
                  }
               } else {
                  var1.getViewModel().setCoolFanSpeed(var2, var4);
               }
            } else {
               var1.getViewModel().setApFanSpeed(var2, var4);
            }
         } else if (var2 instanceof HasCoolMainMode) {
            var1.getViewModel().setCoolFanSpeedLevel(var2, ((FanSpeedEnum)((AttributeAction.FanSpeedAction)var0).getValue()).toServerValue(var2));
         } else {
            var1.getViewModel().fanspeedSliderChanged(var2, (FanSpeedEnum)((AttributeAction.FanSpeedAction)var0).getValue());
         }
      } else if (var0 instanceof AttributeAction.BrightnessPercentageAction) {
         var1.getViewModel().brightnessChanged(var2, ((Number)((AttributeAction.BrightnessPercentageAction)var0).getValue()).intValue());
      } else if (var0 instanceof AttributeAction.AutoRefreshInfoAction) {
         FragmentManager var9 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var9, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var9.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var9.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.auto_refresh, (Integer)null, R.string.auto_refresh_info, R.string.btn_goto_settings, (Integer)null, false, true, false, false, (String[])null, (String)null, (Integer)null, new DeviceControlsFragment$$ExternalSyntheticLambda11(var1), 3872, (Object)null)).show(var9, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.AutoRefreshCancelAction) {
         var1.getViewModel().setAutoRefreshStatus(var2, AirRefreshState.CANCEL.getValue());
      } else if (var0 instanceof AttributeAction.AutoRefreshHintClosedAction) {
         var1.getViewModel().setAutoRefreshHintClosedBefore(true);
         var1.getAdapterSchedule().setAutoRefreshHintClosedBefore(true);
         Unit var10 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.AutoRhInfoAction) {
         FragmentManager var11 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var11, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var11.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var11.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.target_humidity, (Integer)null, DeviceControlUtils.INSTANCE.obtainTargetHumidityInfoRes(var2), R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var11, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.AutoRhAction) {
         var1.getViewModel().autorhChanged(var2, ((Number)((AttributeAction.AutoRhAction)var0).getValue()).intValue());
      } else if (var0 instanceof AttributeAction.ChildLockAction) {
         HasChildLock var12;
         if (var2 instanceof HasChildLock) {
            var12 = (HasChildLock)var2;
         } else {
            var12 = null;
         }

         if (var12 != null) {
            var12 = (HasChildLock)var2;
            if (var12.isChildLockOn()) {
               var1.getViewModel().childLockChanged(var2);
            } else {
               int var73;
               if (var12 instanceof DeviceMiniRestful) {
                  var73 = R.string.display_lock_instructions_mini;
               } else if (!(var12 instanceof DeviceBlue40) && !(var12 instanceof DevicePet20) && !(var12 instanceof DeviceHumidifier20)) {
                  if (!(var12 instanceof DeviceHumidifier) && !(var12 instanceof DeviceCombo2in120)) {
                     if (!(var12 instanceof DeviceB4) && !(var12 instanceof DeviceB4sp)) {
                        if (var12 instanceof DeviceG4) {
                           if (((DeviceG4)var2).isPlus()) {
                              var73 = R.string.display_lock_instructions;
                           } else {
                              var73 = R.string.display_lock_instructions_v4;
                           }
                        } else if (var12 instanceof DeviceNewClassic) {
                           var73 = R.string.display_lock_instructions_v5;
                        } else {
                           var73 = R.string.display_lock_instructions;
                        }
                     } else {
                        var73 = R.string.display_lock_instructions_v4;
                     }
                  } else {
                     var73 = R.string.display_lock_instructions_v3;
                  }
               } else {
                  var73 = R.string.display_lock_instructions_v2;
               }

               FragmentManager var14 = var1.getChildFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var14, "getChildFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
               if (!(var14.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var14.isStateSaved()) {
                  ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.lock_device_ui, (Integer)null, var73, R.string.confirm, R.string.btn_cancel, false, false, false, false, (String[])null, (String)null, (Integer)null, new DeviceControlsFragment$$ExternalSyntheticLambda14(var1, var2), 3936, (Object)null)).show(var14, "ConfirmationDialogLeftAligned");
               }
            }

            Unit var15 = Unit.INSTANCE;
            var15 = Unit.INSTANCE;
         }
      } else if (var0 instanceof AttributeAction.OpenDeviceSchedulesAction) {
         Context var17 = var1.getContext();
         if (var17 != null) {
            var1.schedulePageLauncher.launch(ScheduleListActivity.Companion.intent(var17, var2));
            Unit var18 = Unit.INSTANCE;
            var18 = Unit.INSTANCE;
         }
      } else if (var0 instanceof AttributeAction.OpenDeviceSettingsAction) {
         Context var20 = var1.getContext();
         if (var20 != null) {
            Intent var21 = new Intent(var20, DeviceSettingsActivity.class);
            var21.putExtra("device", var2);
            var1.startActivity(var21);
            Unit var22 = Unit.INSTANCE;
            var22 = Unit.INSTANCE;
         }
      } else if (var0 instanceof AttributeAction.OpenFilterInfoAction) {
         FragmentManager var24 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var24, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var24.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var24.isStateSaved()) {
            int var74 = R.string.real_track_instruction;
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_real_track_tech, (Integer)null, var74, R.string.confirmation_positive_default, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var24, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.OpenWickInfoAction) {
         FragmentManager var25 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var25, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var25.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var25.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.wick_maintenance, (Integer)null, R.string.wick_maintenance_description, R.string.confirmation_positive_default, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var25, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.OpenCubeInfoAction) {
         FragmentManager var26 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var26, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var26.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var26.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_water_refresher, (Integer)null, R.string.water_refresher_instructions, (Integer)null, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var26, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.OpenFilterPageAction) {
         if ((Boolean)((AttributeAction.OpenFilterPageAction)var0).getValue()) {
            FragmentManager var27 = var1.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var27, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
            if (!(var27.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !var27.isStateSaved()) {
               ((DialogFragment)BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, var2, (String)null, DeviceFilterType.FILTER, false, (String)null, 24, (Object)null)).show(var27, "BuyFilterV2DialogFragment");
            }
         } else {
            ActivityResultLauncher var83 = var1.filterDetailLauncher;
            DeviceFilterDetailActivity.Companion var28 = DeviceFilterDetailActivity.Companion;
            Context var65 = var1.requireContext();
            Intrinsics.checkNotNullExpressionValue(var65, "requireContext(...)");
            var83.launch(DeviceFilterDetailActivity.Companion.getLaunchIntent$default(var28, var65, var2, (String)null, DeviceFilterType.FILTER, false, 16, (Object)null));
            Unit var29 = Unit.INSTANCE;
         }
      } else if (var0 instanceof AttributeAction.OpenWickPageAction) {
         if ((Boolean)((AttributeAction.OpenWickPageAction)var0).getValue()) {
            FragmentManager var30 = var1.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var30, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
            if (!(var30.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !var30.isStateSaved()) {
               ((DialogFragment)BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, var2, (String)null, DeviceFilterType.WICK, false, (String)null, 24, (Object)null)).show(var30, "BuyFilterV2DialogFragment");
            }
         } else {
            ActivityResultLauncher var31 = var1.filterDetailLauncher;
            DeviceFilterDetailActivity.Companion var84 = DeviceFilterDetailActivity.Companion;
            Context var66 = var1.requireContext();
            Intrinsics.checkNotNullExpressionValue(var66, "requireContext(...)");
            var31.launch(DeviceFilterDetailActivity.Companion.getLaunchIntent$default(var84, var66, var2, (String)null, DeviceFilterType.WICK, false, 16, (Object)null));
            Unit var32 = Unit.INSTANCE;
         }
      } else if (var0 instanceof AttributeAction.OpenCubePageAction) {
         if ((Boolean)((AttributeAction.OpenCubePageAction)var0).getValue()) {
            FragmentManager var33 = var1.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var33, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
            if (!(var33.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !var33.isStateSaved()) {
               ((DialogFragment)BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, var2, (String)null, DeviceFilterType.REFRESHER, false, (String)null, 24, (Object)null)).show(var33, "BuyFilterV2DialogFragment");
            }
         } else {
            ActivityResultLauncher var34 = var1.filterDetailLauncher;
            DeviceFilterDetailActivity.Companion var85 = DeviceFilterDetailActivity.Companion;
            Context var67 = var1.requireContext();
            Intrinsics.checkNotNullExpressionValue(var67, "requireContext(...)");
            var34.launch(DeviceFilterDetailActivity.Companion.getLaunchIntent$default(var85, var67, var2, (String)null, DeviceFilterType.REFRESHER, false, 16, (Object)null));
            Unit var35 = Unit.INSTANCE;
         }
      } else if (var0 instanceof AttributeAction.DisinfectionModeAction) {
         var1.getViewModel().disinfectionChanged(var2);
      } else if (var0 instanceof AttributeAction.AutoModeAction) {
         var1.checkWickDryingAndCancel(var2);
         if (DeviceKt.isCancellable(var2) || (Boolean)((AttributeAction.AutoModeAction)var0).getValue()) {
            var1.getViewModel().autoModeChanged(var2, (Boolean)((AttributeAction.AutoModeAction)var0).getValue());
         }

         Unit var36 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.EcoModeAction) {
         var1.getViewModel().ecoModeChanged(var2);
      } else if (var0 instanceof AttributeAction.ManualModeAction) {
         var1.checkWickDryingAndCancel(var2);
         var1.getViewModel().setManualMode(var2);
      } else if (var0 instanceof AttributeAction.NightModeAction) {
         var1.checkWickDryingAndCancel(var2);
         if (var2 instanceof HasG4NightMode && (DeviceKt.isCancellable(var2) || !((HasG4NightMode)var2).isG4NightModeOn())) {
            var1.getViewModel().g4NightModeChanged(var2);
         }

         Unit var37 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.TimerStateAction) {
         var1.getViewModel().timerStatusChanged(var2, ((TimerState)((AttributeAction.TimerStateAction)var0).getValue()).getValue());
      } else if (var0 instanceof AttributeAction.SelectTimerDurationAction) {
         var1.showTimePickerDialog();
         Unit var38 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.MoodLampAction) {
         var1.getViewModel().setNightLampBrightness(var2, ((MoodLampEnum)((AttributeAction.MoodLampAction)var0).getValue()).toServerValue());
      } else if (var0 instanceof AttributeAction.NightLampAction) {
         var1.getViewModel().setNightLampSteplessBrightness(var2, ((Number)((AttributeAction.NightLampAction)var0).getValue()).intValue());
      } else if (var0 instanceof AttributeAction.WickDryingInfoAction) {
         int var75;
         if (var2 instanceof DeviceCombo2in120) {
            var75 = R.string.wick_drying_info_2in120;
         } else {
            var75 = R.string.wick_drying_info;
         }

         FragmentManager var39 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var39, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var39.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var39.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_wick_drying, (Integer)null, var75, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var39, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.WickDryingAction) {
         var0 = (AttributeAction.WickDryingAction)var0;
         if (var0.getValue() == WickDryingGear.OFF) {
            var1.getViewModel().wickDryCanceled(var2);
         } else {
            var1.getViewModel().updateWickDryDurationAndRestart(var2, ((WickDryingGear)var0.getValue()).getDuration());
         }
      } else if (var0 instanceof AttributeAction.OpenDeviceAlarmsAction) {
         AlarmListActivity.Companion var41 = AlarmListActivity.Companion;
         Context var68 = var1.requireContext();
         Intrinsics.checkNotNullExpressionValue(var68, "requireContext(...)");
         var41.launch(var68);
         Unit var42 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.OpenDryModeInfoAction) {
         FragmentManager var43 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var43, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var43.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var43.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion var86 = ConfirmationDialogLeftAligned.Companion;
            int var80 = R.string.label_auto_dry;
            int var76;
            if (var2 instanceof DeviceHumidifier) {
               var76 = R.string.auto_dry_instructions;
            } else {
               var76 = R.string.auto_dry_instructions_v2;
            }

            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var86, var80, (Integer)null, var76, R.string.btn_goto_settings, (Integer)null, false, true, false, false, (String[])null, (String)null, (Integer)null, new DeviceControlsFragment$$ExternalSyntheticLambda15(var1), 3872, (Object)null)).show(var43, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.DryModeCancelAction) {
         var1.getViewModel().wickDryCanceled(var2);
      } else if (var0 instanceof AttributeAction.HumModeAction) {
         if (var2 instanceof HasHumMainMode) {
            if (((HasHumMainMode)var2).isInMainMode(MainMode.Humidification)) {
               var1.getViewModel().setMainMode(var2, MainMode.AirPurify.getValue());
            } else {
               var1.getViewModel().setMainMode(var2, MainMode.Humidification.getValue());
            }
         } else {
            var1.getViewModel().humModeChanged(var2);
         }
      } else if (var0 instanceof AttributeAction.CloseHumHintAction) {
         var1.getViewModel().setHumHintClosedBefore(true);
         var1.getAdapterMode().setHumHintClosedBefore(true);
         Unit var44 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.CloseSkinHintAction) {
         var1.getViewModel().setSkinHintClosedBefore(true);
         Unit var45 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.CloseSmartHintAction) {
         var1.getViewModel().setSmartHintClosedBefore(true);
         Unit var46 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.CloseHeatingHintAction) {
         var1.getViewModel().setHeatingHintClosedBefore(true);
         Unit var47 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.CloseCantHeatHintAction) {
         var1.getViewModel().setCantHeatHintClosedBefore(true);
         Unit var48 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.HumSubModeAction) {
         var1.getViewModel().setHumSubMode(var2, ((HumSubMode)((AttributeAction.HumSubModeAction)var0).getValue()).getValue());
      } else if (Intrinsics.areEqual(var0, AttributeAction.OscillationEnableAction.INSTANCE)) {
         var1.getViewModel().oscillationStateChanged(var2);
      } else if (Intrinsics.areEqual(var0, AttributeAction.OscillationSettingAction.INSTANCE)) {
         FragmentManager var49 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var49, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceOscillationSettingsDialogFragment", "getSimpleName(...)");
         if (!(var49.findFragmentByTag("DeviceOscillationSettingsDialogFragment") instanceof DeviceOscillationSettingsDialogFragment) && !var49.isStateSaved()) {
            ((DialogFragment)DeviceOscillationSettingsDialogFragment.Companion.newInstance(var2)).show(var49, "DeviceOscillationSettingsDialogFragment");
         }
      } else if (var0 instanceof AttributeAction.OpenTargetTmpInfoAction) {
         FragmentManager var50 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var50, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var50.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var50.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.target_temperature, (Integer)null, R.string.target_temperature_info, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var50, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.TargetTemperatureAction) {
         if (var2 instanceof HasCombo3in1MainMode) {
            ApSubMode var87 = ((HasCombo3in1MainMode)var2).currentSubMode();
            int var77 = DeviceControlsFragment.WhenMappings.$EnumSwitchMapping$1[var87.ordinal()];
            if (var77 != 1) {
               if (var77 != 2) {
                  Unit var51 = Unit.INSTANCE;
               } else {
                  var1.getViewModel().setHeatEcoTmp(var2, ((Number)((AttributeAction.TargetTemperatureAction)var0).getValue()).doubleValue());
               }
            } else {
               var1.getViewModel().setHeatAutoTmp(var2, ((Number)((AttributeAction.TargetTemperatureAction)var0).getValue()).doubleValue());
            }
         }

         Unit var52 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.OpenDisinfectionInfoAction) {
         FragmentManager var53 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var53, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var53.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var53.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.disinfection_title, (Integer)null, R.string.disinfection_description, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var53, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.OpenHinsInfoAction) {
         FragmentManager var69 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var69, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var69.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var69.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion var71 = ConfirmationDialogLeftAligned.Companion;
            var0 = var0;
            int var78;
            if ((Boolean)var0.getValue()) {
               var78 = R.string.photon_pure_night;
            } else {
               var78 = R.string.photon_pure;
            }

            int var81;
            if ((Boolean)var0.getValue()) {
               var81 = R.string.photon_pure_night_description;
            } else {
               var81 = R.string.photon_pure_description;
            }

            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(var71, var78, (Integer)null, var81, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var69, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.HinsLockAction) {
         if ((Boolean)((AttributeAction.HinsLockAction)var0).getValue()) {
            var1.getViewModel().hinsNightModeChanged(var2);
         } else {
            var1.getViewModel().hinsModeChanged(var2);
         }
      } else if (var0 instanceof AttributeAction.OpenGermShieldInfoAction) {
         if (var2 instanceof HasGermShieldMode) {
            int var79;
            int var82;
            if (((HasGermShieldMode)var2).isGermShieldPlus()) {
               var82 = R.string.germ_shield_plus;
               var79 = R.string.germ_shield_plus_mode_summary_v2;
            } else {
               var82 = R.string.germ_shield_tm;
               var79 = R.string.germ_shield_mode_summary_v2;
            }

            FragmentManager var55 = var1.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var55, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var55.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var55.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var82, (Integer)null, var79, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var55, "ConfirmationDialogLeftAligned");
            }
         }

         Unit var56 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.OpenGsnmInfoAction) {
         FragmentManager var57 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var57, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var57.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var57.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.germ_shield_in_night_mode, (Integer)null, R.string.germ_shield_in_night_mode_description, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var57, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.GermShieldSwitchAction) {
         var1.getViewModel().germShieldChanged(var2);
      } else if (var0 instanceof AttributeAction.GsnmSwitchAction) {
         var1.getViewModel().gsnmChanged(var2);
      } else if (var0 instanceof AttributeAction.CoolSubModeAction) {
         var1.getViewModel().setCoolSubMode(var2, ((CoolSubMode)((AttributeAction.CoolSubModeAction)var0).getValue()).getValue());
      } else if (var0 instanceof AttributeAction.DualOscillationSettingAction) {
         FragmentManager var70 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var70, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceDualOscillationSettingsDialogFragment", "getSimpleName(...)");
         if (!(var70.findFragmentByTag("DeviceDualOscillationSettingsDialogFragment") instanceof DeviceDualOscillationSettingsDialogFragment) && !var70.isStateSaved()) {
            ((DialogFragment)DeviceDualOscillationSettingsDialogFragment.Companion.newInstance(var2, (Boolean)((AttributeAction.DualOscillationSettingAction)var0).getValue())).show(var70, "DeviceDualOscillationSettingsDialogFragment");
         }
      } else if (var0 instanceof AttributeAction.DualOscillationStateAction) {
         Unit var58 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.AutoLevelAction) {
         var1.getViewModel().setCoolAutoLevel(var2, ((AutoLevel)((AttributeAction.AutoLevelAction)var0).getValue()).getValue());
      } else if (var0 instanceof AttributeAction.AutoLevelInfoAction) {
         FragmentManager var59 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var59, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var59.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var59.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.auto_mode, (Integer)null, R.string.auto_level_description, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var59, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.OscillationLoopHintClosedAction) {
         var1.getAdapterSchedule().setLoopHintClosedBefore(true);
         var1.getViewModel().setOscillationLoopHintClosedBefore(true);
         Unit var60 = Unit.INSTANCE;
      } else if (var0 instanceof AttributeAction.OscillationLoopInfoAction) {
         FragmentManager var61 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var61, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var61.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var61.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.loop, (Integer)null, R.string.oscillation_loop_description, R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var61, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.OscillationLoopStateAction) {
         var1.getViewModel().oscillationModeChange(var2);
      } else if (var0 instanceof AttributeAction.NightSleepInfoAction) {
         FragmentManager var62 = var1.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var62, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var62.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var62.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.night, (Integer)null, R.string.night_sleep_description, (Integer)null, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var62, "ConfirmationDialogLeftAligned");
         }
      } else if (var0 instanceof AttributeAction.NightSleepHintClosedAction) {
         var1.getAdapterSchedule().setNightSleepHintClosedBefore(true);
         var1.getViewModel().setNightSleepHintClosedBefore(true);
         Unit var63 = Unit.INSTANCE;
      } else {
         Unit var64 = Unit.INSTANCE;
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$49$lambda$48$lambda$47$lambda$21$lambda$20(DeviceControlsFragment var0, boolean var1) {
      if (var1) {
         var0.getControlActionPublisher().onNext(AttributeAction.OpenDeviceSettingsAction.INSTANCE);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$49$lambda$48$lambda$47$lambda$25$lambda$24$lambda$23(DeviceControlsFragment var0, Device var1, boolean var2) {
      if (var2) {
         var0.getViewModel().childLockChanged(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$49$lambda$48$lambda$47$lambda$36$lambda$35(DeviceControlsFragment var0, boolean var1) {
      if (var1) {
         var0.getControlActionPublisher().onNext(AttributeAction.OpenDeviceSettingsAction.INSTANCE);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$15(DeviceControlsFragment var0, Device var1) {
      Iterator var2 = ((Iterable)var0.getAdapters()).iterator();

      while(var2.hasNext()) {
         ((DeviceControlsAdapter)var2.next()).setDevice(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$17(DeviceControlsFragment var0, boolean var1) {
      Iterator var2 = ((Iterable)var0.getAdapters()).iterator();

      while(var2.hasNext()) {
         ((DeviceControlsAdapter)var2.next()).setForceOffline(var1 ^ true);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$18(DeviceControlsFragment var0, List var1) {
      DeviceControlsAdapter var2 = var0.getAdapterSchedule();
      Intrinsics.checkNotNull(var1);
      var2.notifySchedulesUpdate(var1);
      return Unit.INSTANCE;
   }

   private static final void schedulePageLauncher$lambda$0(DeviceControlsFragment var0, ActivityResult var1) {
      var0.getSchedulesViewModel().refreshDeviceSchedule(true);
   }

   private final void shouldDoDbAndApiCall(Device var1, AttributeAction var2, Function0 var3) {
      var3.invoke();
   }

   private final void showTimePickerDialog() {
      Device var4 = this.getViewModel().getDevice();
      boolean var3 = var4 instanceof HasTimer;
      Object var6 = null;
      HasTimer var10;
      if (var3) {
         var10 = (HasTimer)var4;
      } else {
         var10 = null;
      }

      if (var10 != null) {
         Context var5 = this.getContext();
         if (var5 != null) {
            String var8 = var5.getString(R.string.label_stay_on_for);
            Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
            var3 = var10 instanceof DeviceDehumidifier;
            byte var2 = 24;
            byte var1 = var2;
            if (!var3) {
               var1 = var2;
               if (!(var10 instanceof DevicePet20)) {
                  var1 = var2;
                  if (!(var10 instanceof DeviceCombo2in1)) {
                     if (var10 instanceof DeviceCombo3in1) {
                        var1 = var2;
                     } else if (DeviceKt.useV2UI(var10)) {
                        var1 = var2;
                     } else {
                        var1 = 12;
                     }
                  }
               }
            }

            FragmentManager var7 = this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var7, "getChildFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerV2DialogFragment", "getSimpleName(...)");
            DialogFragment var12 = (DialogFragment)var6;
            if (!(var7.findFragmentByTag("DeviceTimerPickerV2DialogFragment") instanceof DeviceTimerPickerV2DialogFragment)) {
               var12 = (DialogFragment)var6;
               if (!var7.isStateSaved()) {
                  DeviceTimerPickerV2DialogFragment var13 = DeviceTimerPickerV2DialogFragment.Companion.newInstance(var8, var1, var10.getTimerDuration(), true);
                  var13.setOnPickResult(new DeviceControlsFragment$$ExternalSyntheticLambda13(this, var10));
                  var12 = var13;
                  var12.show(var7, "DeviceTimerPickerV2DialogFragment");
               }
            }

            DeviceTimerPickerV2DialogFragment var11 = (DeviceTimerPickerV2DialogFragment)var12;
         }
      }

   }

   private static final Unit showTimePickerDialog$lambda$53$lambda$52$lambda$51$lambda$50(DeviceControlsFragment var0, HasTimer var1, int var2) {
      var0.getViewModel().updateTimerDurationAndRestart(var1, var2);
      return Unit.INSTANCE;
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

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentDeviceControlsBinding var4 = FragmentDeviceControlsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      BaseFragment var5 = this;
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class)));
      Device var6 = this.getViewModel().getDevice();
      if (var6 != null) {
         this.getSchedulesViewModel().setDevice(var6);
         this.getSchedulesViewModel().refreshDeviceSchedule(false);
      }

      FragmentDeviceControlsBinding var19 = this.binding;
      Object var18 = null;
      FragmentDeviceControlsBinding var7 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.rvModeButtons.setAdapter(this.getAdapterMode());
      var19 = this.binding;
      var7 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.rvModeButtons.setItemAnimator((RecyclerView.ItemAnimator)null);
      var19 = this.binding;
      var7 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.rvControlGroup.getRecyclerView().setAdapter(this.getAdapterControl());
      var19 = this.binding;
      var7 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      RecyclerView var11 = var7.rvLightGroup;
      var11.addItemDecoration(new SimpleSpacingDecoration(0, (int)TypedValueCompat.dpToPx(24.0F, var11.getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker)null));
      var11.setAdapter(this.getAdapterLight());
      var11.setItemAnimator((RecyclerView.ItemAnimator)null);
      var19 = this.binding;
      FragmentDeviceControlsBinding var12 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      var12.rvScheduleGroup.setAdapter(this.getAdapterSchedule());
      var19 = this.binding;
      var12 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      var12.rvScheduleGroup.setItemAnimator((RecyclerView.ItemAnimator)null);
      var19 = this.binding;
      var12 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      var12.rvFilterGroup.getRecyclerView().setAdapter(this.getAdapterFilter());
      this.getAdapterControl().setOnItemCountChangedListener(new DeviceControlsFragment$$ExternalSyntheticLambda5(this));
      this.getAdapterFilter().setOnItemCountChangedListener(new DeviceControlsFragment$$ExternalSyntheticLambda6(this));
      this.getAdapterLight().setOnItemCountChangedListener(new DeviceControlsFragment$$ExternalSyntheticLambda7(this));
      var19 = this.binding;
      var12 = var19;
      if (var19 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = null;
      }

      var12.btnCloseControlsHint.setOnClickListener(new DeviceControlsFragment$$ExternalSyntheticLambda8(this));
      var12 = this.binding;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = (FragmentDeviceControlsBinding)var18;
      }

      ConstraintLayout var17 = var12.getRoot();
      Intrinsics.checkNotNullExpressionValue(var17, "getRoot(...)");
      return (View)var17;
   }

   public void onResume() {
      super.onResume();
      this.getAdapterSchedule().setAutoRefreshHintClosedBefore(this.getViewModel().getAutoRefreshHintClosedBefore());
      this.getAdapterMode().setHumHintClosedBefore(this.getViewModel().getHumHintClosedBefore());
      if (this.getViewModel().getSkinHintClosedBefore()) {
         this.getAdapterMode().markSkinHintClosedBefore();
      }

      if (this.getViewModel().getSmartHintClosedBefore()) {
         this.getAdapterMode().markSmartHintClosedBefore();
      }

      if (this.getViewModel().getHeatingHintClosedBefore()) {
         this.getAdapterMode().markHeatingHintClosedBefore();
      }

      if (this.getViewModel().getCantHeatHintClosedBefore()) {
         this.getAdapterMode().markCantHeatHintClosedBefore();
      }

      this.getAdapterSchedule().setLoopHintClosedBefore(this.getViewModel().getOscillationLoopHintClosedBefore());
      this.getAdapterSchedule().setNightSleepHintClosedBefore(this.getViewModel().getNightSleepHintClosedBefore());
      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getControlActionPublisher(), new DeviceControlsFragment$$ExternalSyntheticLambda16(this)));
      CompositeDisposable var3 = this.getRxSubs();
      Observable var2 = this.getControlActionPublisher().throttleLatest(300L, TimeUnit.MILLISECONDS);
      Intrinsics.checkNotNullExpressionValue(var2, "throttleLatest(...)");
      var3.add(RxExtensionsKt.subscribeAndLogE(var2, new DeviceControlsFragment$$ExternalSyntheticLambda17(this)));
      String var4 = this.getViewModel().getActionType();
      if (var4 != null) {
         label35: {
            int var1 = var4.hashCode();
            if (var1 != -2123968024) {
               if (var1 != -1274492040) {
                  if (var1 == 590772454 && var4.equals("wick_purchase")) {
                     this.getControlActionPublisher().onNext(new AttributeAction.OpenWickPageAction(false));
                  }
                  break label35;
               }

               if (!var4.equals("filter")) {
                  break label35;
               }
            } else if (!var4.equals("filter_purchase")) {
               break label35;
            }

            this.getControlActionPublisher().onNext(new AttributeAction.OpenFilterPageAction(false));
         }
      }

      this.getViewModel().setActionType((String)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      LiveData var3 = this.getViewModel().getLiveDevice();
      LifecycleOwner var6 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var6, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var3, var6, new DeviceControlsFragment$$ExternalSyntheticLambda9(this));
      var3 = this.getViewModel().getNetworkAvailable();
      var6 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var6, "getViewLifecycleOwner(...)");
      LiveDataExtensionsKt.observeNonNull(var3, var6, new DeviceControlsFragment$$ExternalSyntheticLambda10(this));
      this.getSchedulesViewModel().getSchedules().observe(this.getViewLifecycleOwner(), new Observer(new DeviceControlsFragment$$ExternalSyntheticLambda12(this)) {
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
      if (!DeviceControlUtils.INSTANCE.shouldShowTimer(this.getViewModel().getDevice()) && !(this.getViewModel().getDevice() instanceof HasAirRefresh) && !(this.getViewModel().getDevice() instanceof HasWick)) {
         Device var5 = this.getViewModel().getDevice();
         if ((var5 == null || !DeviceKt.supportDisinfection(var5)) && !(this.getViewModel().getDevice() instanceof HasNightModeTiming)) {
            return;
         }
      }

      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final DeviceControlsFragment this$0;

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
               Continuation var7 = (Continuation)this;
               this.label = 1;
               if (DelayKt.delay(1000L, var7) == var5) {
                  return var5;
               }
            }

            do {
               var1 = this.this$0.getViewModel().getDevice();
               boolean var3 = var1 instanceof HasTimer;
               Object var4 = null;
               if (var3) {
                  var1 = (HasTimer)var1;
               } else {
                  var1 = null;
               }

               if (var1 != null) {
                  DeviceControlsFragment var6 = this.this$0;
                  if (SetsKt.setOf(new TimerState[]{TimerState.START, TimerState.RESUME}).contains(var1.timerStatus())) {
                     var6.getAdapterFilter().notifyItemChanged(DeviceControl.TIMER);
                  }
               }

               var1 = this.this$0.getViewModel().getDevice();
               if (var1 instanceof HasAirRefresh) {
                  var1 = (HasAirRefresh)var1;
               } else {
                  var1 = null;
               }

               if (var1 != null) {
                  DeviceControlsFragment var19 = this.this$0;
                  if (var1.isInAirRefreshStatus(AirRefreshState.START)) {
                     var19.getAdapterSchedule().notifyItemChanged(DeviceControl.AUTO_REFRESH);
                  }
               }

               var1 = this.this$0.getViewModel().getDevice();
               if (var1 instanceof HasWick) {
                  var1 = (HasWick)var1;
               } else {
                  var1 = null;
               }

               if (var1 != null) {
                  DeviceControlsFragment var20 = this.this$0;
                  if (var1.getWickdryOn()) {
                     if (var1 instanceof HasWickDryDuration) {
                        var20.getAdapterLight().notifyItemChanged(DeviceControl.WICK_DRYING);
                     } else {
                        var20.getAdapterSchedule().notifyItemChanged(DeviceControl.AUTO_DRY);
                     }
                  }
               }

               var1 = this.this$0.getViewModel().getDevice();
               if (var1 instanceof HasDisinfection) {
                  var1 = (HasDisinfection)var1;
               } else {
                  var1 = null;
               }

               if (var1 != null) {
                  DeviceControlsFragment var21 = this.this$0;
                  if (DeviceKt.isDisinfectionOn(var1)) {
                     var21.getAdapterSchedule().notifyItemChanged(DeviceControl.DISINFECTION);
                  }
               }

               Device var22 = this.this$0.getViewModel().getDevice();
               var1 = (HasNightModeTiming)var4;
               if (var22 instanceof HasNightModeTiming) {
                  var1 = (HasNightModeTiming)var22;
               }

               if (var1 != null) {
                  DeviceControlsFragment var18 = this.this$0;
                  if (var1 instanceof HasCoolMainMode && ((HasCoolMainMode)var1).isInSubMode(CoolSubMode.NIGHT)) {
                     var18.getAdapterSchedule().notifyItemChanged(DeviceControl.NIGHT_SLEEP);
                  }
               }

               var17 = (Continuation)this;
               this.label = 1;
            } while(DelayKt.delay(1000L, var17) != var5);

            return var5;
         }
      }, 3, (Object)null);
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceControlsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceControlsFragment;", "devicedetails_otherRelease"},
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

      public final DeviceControlsFragment newInstance() {
         return new DeviceControlsFragment();
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
            var0[MainMode.AirPurify.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 2;
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
