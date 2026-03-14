package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.adapter.DeviceSensorCardsAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding;
import com.blueair.devicedetails.fragment.DeviceControlsFragment;
import com.blueair.devicedetails.fragment.DeviceMessagesFragment;
import com.blueair.devicedetails.fragment.DeviceSensorsGraphFragment;
import com.blueair.devicedetails.util.DeviceDetailsLauncher;
import com.blueair.devicedetails.util.DeviceDetailsLauncher$_CC;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\u001a\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u001cH\u0002J\b\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020\u001cH\u0002J\b\u00106\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\b\u00108\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u001cH\u0016J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001a¨\u0006@"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsV2DialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceDetailsV2Binding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "sensorsViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "statusBarHeight", "", "sensorCardsAdapter", "Lcom/blueair/devicedetails/adapter/DeviceSensorCardsAdapter;", "value", "", "shouldTintDark", "setShouldTintDark", "(Z)V", "onStart", "", "onResume", "onPause", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "blurTitleBar", "bindViewModel", "updateTintDark", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "refreshHeaderWhenChanged", "showDeviceMessages", "showDeviceSensorsGraph", "showDeviceControls", "scrollToView", "tag", "scrollToFilterStatus", "scrollToWickStatus", "scrollToRefresherStatus", "handleActions", "showProgress", "shouldShowProgress", "dismiss", "onCancel", "dialog", "Landroid/content/DialogInterface;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDetailsV2DialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String REQUEST_KEY_DEVICE_DETAILS_CLOSED = "REQUEST_KEY_DEVICE_DETAILS_CLOSED";
   public static final String REQUEST_KEY_HANDLE_ACTION = "REQUEST_KEY_HANDLE_ACTION";
   private static String jumpToAction;
   private DialogfragmentDeviceDetailsV2Binding binding;
   private final String screenName = "device_details";
   private final DeviceSensorCardsAdapter sensorCardsAdapter = new DeviceSensorCardsAdapter();
   private DeviceSensorsViewModel sensorsViewModel;
   private boolean shouldTintDark;
   private int statusBarHeight = 70;
   public DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$6buz1j3wlf4gwUySGBjWZqIx8Vg(DeviceDetailsV2DialogFragment var0, SensorType var1) {
      return bindViewModel$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$8zDE_j1Fma9BxAQCXr68Mvdp80A/* $FF was: $r8$lambda$8zDE-j1Fma9BxAQCXr68Mvdp80A*/(DeviceDetailsV2DialogFragment var0, View var1) {
      bindViewModel$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$B_AzU2jKPU9PVZZxX0U5JJ_HIvg/* $FF was: $r8$lambda$B-AzU2jKPU9PVZZxX0U5JJ-HIvg*/(DeviceDetailsV2DialogFragment var0, SensorType var1) {
      return bindViewModel$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Dht7Q_xHEMLUucZHkwzsxEL6P58(DeviceDetailsV2DialogFragment var0, List var1, int var2, String var3) {
      return bindViewModel$lambda$10$lambda$9$lambda$8(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$EpBi6tVRxy6WTqU5jbucTuLltag(DeviceDetailsV2DialogFragment var0, Boolean var1) {
      return bindViewModel$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Hg3fd3D1Pd_If4osni3KczOImvg/* $FF was: $r8$lambda$Hg3fd3D1Pd-If4osni3KczOImvg*/(DeviceDetailsV2DialogFragment var0, DeviceData var1) {
      return bindViewModel$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KA53CpGSkBAUnk2Us130MZ_iaJE/* $FF was: $r8$lambda$KA53CpGSkBAUnk2Us130MZ-iaJE*/(Object var0) {
      bindViewModel$lambda$15(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$T46yhcHMHNn5UDTK_xThSGwRxrY/* $FF was: $r8$lambda$T46yhcHMHNn5UDTK-xThSGwRxrY*/(DeviceDetailsV2DialogFragment var0, Boolean var1) {
      return bindViewModel$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$TQ59Wwzf9RTmo1erLbXE2pa1ni0(DeviceDetailsV2DialogFragment var0, Device var1) {
      return bindViewModel$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$XIYQJLJ7vmxu94b8POKk32r6d_o(DeviceDetailsV2DialogFragment var0, List var1) {
      return bindViewModel$lambda$10$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$c3zJX5Zw7b8FKSvkR4FE_N30p_0(DeviceDetailsV2DialogFragment var0, CompoundButton var1, boolean var2) {
      bindViewModel$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$gawHgclDqIpdFJ5pNa8Ssbtzb_k(NestedScrollView var0, String var1) {
      scrollToView$lambda$24(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$l_fmY7Ntb7h7lMn3owP6S3x2C4w(DeviceDetailsV2DialogFragment var0, String var1, Bundle var2) {
      onViewCreated$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$q1f0c0SGKLvpvsNBj9XchHWnmLY(Object var0) {
      bindViewModel$lambda$16(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$rNnf4FDfyz34VzMqlkjEsqf_pKM(DeviceDetailsV2DialogFragment var0, View var1) {
      bindViewModel$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$r_VPQlUoXThnwfzhvv7eA91dptE(DeviceDetailsV2DialogFragment var0, View var1, int var2, int var3, int var4, int var5) {
      blurTitleBar$lambda$3(var0, var1, var2, var3, var4, var5);
   }

   private final void bindViewModel() {
      DialogfragmentDeviceDetailsV2Binding var3 = this.binding;
      DeviceSensorsViewModel var4 = null;
      DialogfragmentDeviceDetailsV2Binding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.btnBack.setOnClickListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda7(this));
      var3 = this.binding;
      var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.btnStandby.setOnCheckedChangeListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda9(this));
      var3 = this.binding;
      var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.deviceName.setOnClickListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda10(this));
      Device var5 = this.getViewModel().getDevice();
      if (var5 != null) {
         var3 = this.binding;
         var2 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         ImageView var28 = var2.deviceImage;
         DeviceImage var9 = DeviceConfigProvider.INSTANCE.getDeviceImage(var5);
         int var1;
         if (var9 != null) {
            var1 = var9.getBgDetails();
         } else {
            var1 = 0;
         }

         var28.setImageResource(var1);
         updateTintDark$default(this, var5, false, 2, (Object)null);
      }

      this.showDeviceMessages();
      if (this.getViewModel().getDevice() instanceof HasSensorData) {
         var3 = this.binding;
         var2 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         var2.sensorCardList.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext(), 0, false)));
         var3 = this.binding;
         var2 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var2 = null;
         }

         RecyclerView.ItemAnimator var12 = var2.sensorCardList.getItemAnimator();
         SimpleItemAnimator var13;
         if (var12 instanceof SimpleItemAnimator) {
            var13 = (SimpleItemAnimator)var12;
         } else {
            var13 = null;
         }

         if (var13 != null) {
            var13.setSupportsChangeAnimations(false);
         }

         DeviceSensorCardsAdapter var14 = this.sensorCardsAdapter;
         Device var31 = this.getViewModel().getDevice();
         Intrinsics.checkNotNull(var31, "null cannot be cast to non-null type com.blueair.core.model.HasSensorData");
         var14.setDevice((HasSensorData)var31);
         DeviceSensorCardsAdapter var45 = this.sensorCardsAdapter;
         DeviceSensorsViewModel var32 = this.sensorsViewModel;
         DeviceSensorsViewModel var15 = var32;
         if (var32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var15 = null;
         }

         var45.setCelsius(var15.isTempCelsius());
         var45 = this.sensorCardsAdapter;
         var32 = this.sensorsViewModel;
         var15 = var32;
         if (var32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var15 = null;
         }

         var45.setSensors(var15.getSupportedSensors());
         Timber.Forest var34 = Timber.Forest;
         StringBuilder var17 = new StringBuilder("sensors: ");
         var17.append(this.sensorCardsAdapter.getSensors());
         var34.d(var17.toString(), new Object[0]);
         this.sensorCardsAdapter.getLiveSelectedSensorType().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda11(this)) {
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
         DeviceSensorsViewModel var35 = this.sensorsViewModel;
         DeviceSensorsViewModel var18 = var35;
         if (var35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var18 = null;
         }

         var18.getGraphExpended().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda12(this)) {
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
         DialogfragmentDeviceDetailsV2Binding var36 = this.binding;
         DialogfragmentDeviceDetailsV2Binding var19 = var36;
         if (var36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var19 = null;
         }

         var19.sensorCardList.setAdapter(this.sensorCardsAdapter);
         DeviceSensorsViewModel var37 = this.sensorsViewModel;
         DeviceSensorsViewModel var20 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var20 = null;
         }

         var20.getLiveSelectedSensor().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda13(this)) {
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
         var37 = this.sensorsViewModel;
         var20 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var20 = null;
         }

         var20.getRealTimeDataListener().observe(this.getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda14());
         var37 = this.sensorsViewModel;
         var20 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var20 = null;
         }

         var20.getHistoricalDataListener().observe(this.getViewLifecycleOwner(), new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda15());
         var37 = this.sensorsViewModel;
         var20 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var20 = null;
         }

         var20.getLiveDeviceRealTimeData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda1(this)) {
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
         var37 = this.sensorsViewModel;
         var20 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var20 = null;
         }

         DeviceSensorsViewModel var47 = this.sensorsViewModel;
         var37 = var47;
         if (var47 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var37 = null;
         }

         SensorType var48 = var37.getLastSelectedSensor();
         SensorType var43 = var48;
         if (var48 == null) {
            DeviceSensorsViewModel var49 = this.sensorsViewModel;
            DeviceSensorsViewModel var44 = var49;
            if (var49 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
               var44 = null;
            }

            var43 = var44.getDefaultSelectedSensor();
         }

         DeviceSensorsViewModel var50 = this.sensorsViewModel;
         if (var50 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
         } else {
            var4 = var50;
         }

         var20.selectSensor(var43, var4.getLastGraphExpended());
         this.showDeviceSensorsGraph();
      }

      this.showDeviceControls();
      this.getViewModel().getLiveDevice().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda2(this)) {
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
      this.getViewModel().getDeviceOffline().observe(this.getViewLifecycleOwner(), new Observer(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda8(this)) {
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

   private static final void bindViewModel$lambda$10(DeviceDetailsV2DialogFragment var0, View var1) {
      var0.getViewModel().getDevices(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda4(var0));
   }

   private static final Unit bindViewModel$lambda$10$lambda$9(DeviceDetailsV2DialogFragment var0, List var1) {
      Intrinsics.checkNotNullParameter(var1, "devices");
      Device var7 = var0.getViewModel().getDevice();
      Intrinsics.checkNotNull(var7);
      Iterable var8 = (Iterable)var1;
      Collection var12 = (Collection)(new ArrayList());

      for(Object var9 : var8) {
         if (!Intrinsics.areEqual(((Device)var9).getUid(), var7.getUid())) {
            var12.add(var9);
         }
      }

      List var27 = (List)var12;
      var12 = (Collection)CollectionsKt.listOf(var7.getName());
      var8 = (Iterable)var27;
      Collection var18 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
      Iterator var22 = var8.iterator();

      while(var22.hasNext()) {
         var18.add(((Device)var22.next()).getName());
      }

      List var10 = CollectionsKt.plus(var12, (Iterable)((List)var18));
      float var2 = TypedValueCompat.dpToPx(1.0F, var0.getResources().getDisplayMetrics());
      DialogfragmentDeviceDetailsV2Binding var23 = var0.binding;
      Object var19 = null;
      DialogfragmentDeviceDetailsV2Binding var14 = var23;
      if (var23 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = null;
      }

      int var6 = var14.deviceNameMaxWidth.getWidth();
      var23 = var0.binding;
      var14 = var23;
      if (var23 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = null;
      }

      int var4 = (var14.deviceName.getWidth() - var6) / 2;
      DialogUtils var11 = DialogUtils.INSTANCE;
      var23 = var0.binding;
      var14 = var23;
      if (var23 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = null;
      }

      TextView var26 = var14.deviceName;
      Intrinsics.checkNotNullExpressionValue(var26, "deviceName");
      var14 = var0.binding;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var14 = (DialogfragmentDeviceDetailsV2Binding)var19;
      }

      int var5 = -var14.deviceName.getHeight();
      int var3 = MathKt.roundToInt((float)10 * var2);
      var11.showDropDownList((View)var26, var10, var6, var4, var5 - var3, 10, true, new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda6(var0, var27));
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$10$lambda$9$lambda$8(DeviceDetailsV2DialogFragment var0, List var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var3, "<unused var>");
      if (var2 > 0) {
         Fragment var4 = var0.getParentFragment();
         DeviceDetailsLauncher var5;
         if (var4 instanceof DeviceDetailsLauncher) {
            var5 = (DeviceDetailsLauncher)var4;
         } else {
            var5 = null;
         }

         if (var5 != null) {
            DeviceDetailsLauncher$_CC.openDeviceDetails$default(var5, (Device)var1.get(var2 - 1), (String)null, 2, (Object)null);
         }

         var0.dismiss();
      }

      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$12(DeviceDetailsV2DialogFragment var0, SensorType var1) {
      if (var1 != null) {
         DeviceSensorsViewModel var2 = var0.sensorsViewModel;
         DeviceSensorsViewModel var3 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var3 = null;
         }

         var3.selectSensor(var1, true);
      }

      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$13(DeviceDetailsV2DialogFragment var0, Boolean var1) {
      DeviceSensorsViewModel var4 = var0.sensorsViewModel;
      Object var3 = null;
      DeviceSensorsViewModel var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
         var2 = null;
      }

      Intrinsics.checkNotNull(var1);
      var2.setLastGraphExpended(var1);
      if (var1) {
         DeviceSensorCardsAdapter var6 = var0.sensorCardsAdapter;
         DeviceSensorsViewModel var5 = var0.sensorsViewModel;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
            var5 = (DeviceSensorsViewModel)var3;
         }

         var6.setSelectedSensorType(var5.getSelectedSensor());
      } else {
         var0.sensorCardsAdapter.setSelectedSensorType((SensorType)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$14(DeviceDetailsV2DialogFragment var0, SensorType var1) {
      DeviceSensorsViewModel var4 = var0.sensorsViewModel;
      Object var3 = null;
      DeviceSensorsViewModel var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
         var2 = null;
      }

      var2.setLastSelectedSensor(var1);
      var2 = var0.sensorsViewModel;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
         var2 = (DeviceSensorsViewModel)var3;
      }

      if (Intrinsics.areEqual(var2.getGraphExpended().getValue(), true)) {
         var0.sensorCardsAdapter.setSelectedSensorType(var1);
      }

      return Unit.INSTANCE;
   }

   private static final void bindViewModel$lambda$15(Object var0) {
   }

   private static final void bindViewModel$lambda$16(Object var0) {
   }

   private static final Unit bindViewModel$lambda$17(DeviceDetailsV2DialogFragment var0, DeviceData var1) {
      DeviceSensorCardsAdapter var2 = var0.sensorCardsAdapter;
      Intrinsics.checkNotNull(var1);
      var2.updateSensorData(var1);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$18(DeviceDetailsV2DialogFragment var0, Device var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("liveDevice = ");
      var2.append(var1);
      var3.v(var2.toString(), new Object[0]);
      if (var1 == null) {
         var0.dismiss();
      } else {
         DialogfragmentDeviceDetailsV2Binding var6 = var0.binding;
         DialogfragmentDeviceDetailsV2Binding var4 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.deviceName.setText((CharSequence)var1.getName());
         var6 = var0.binding;
         var4 = var6;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.btnStandby.setCheckedSilence(DeviceKt.isStandByOn(var1));
         var0.sensorCardsAdapter.setStandBy(DeviceKt.isStandByOn(var1));
         if (var1 instanceof HasTemperatureUnit) {
            var0.sensorCardsAdapter.setCelsius(DeviceKt.isCelsiusUnit(var1));
         }

         var0.getViewModel().setDevice(var1);
         updateTintDark$default(var0, var1, false, 2, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$20(DeviceDetailsV2DialogFragment var0, Boolean var1) {
      DialogfragmentDeviceDetailsV2Binding var5 = var0.binding;
      DialogfragmentDeviceDetailsV2Binding var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      boolean var2;
      label21: {
         var9 = var4.btnStandby;
         if (!var1) {
            Device var6 = var0.getViewModel().getDevice();
            if (var6 != null) {
               boolean var3 = DeviceKt.isSafetySwitchOn(var6);
               var2 = true;
               if (var3) {
                  break label21;
               }
            }
         }

         var2 = false;
      }

      var9.setEnabled(var2);
      DeviceSensorCardsAdapter var7 = var0.sensorCardsAdapter;
      Intrinsics.checkNotNull(var1);
      var7.setOffline(var1);
      Device var8 = var0.getViewModel().getDevice();
      if (var8 != null) {
         var0.updateTintDark(var8, var1);
      }

      return Unit.INSTANCE;
   }

   private static final void bindViewModel$lambda$4(DeviceDetailsV2DialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void bindViewModel$lambda$5(DeviceDetailsV2DialogFragment var0, CompoundButton var1, boolean var2) {
      DeviceDetailsViewModel var4 = var0.getViewModel();
      Device var3 = var0.getViewModel().getDevice();
      Intrinsics.checkNotNull(var3);
      var4.standByChanged(var3);
   }

   private final void blurTitleBar() {
      DialogfragmentDeviceDetailsV2Binding var3 = this.binding;
      Object var2 = null;
      DialogfragmentDeviceDetailsV2Binding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var4 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var4, "rootLayout");
      DialogUtils var5 = DialogUtils.INSTANCE;
      Context var8 = var4.getContext();
      Intrinsics.checkNotNullExpressionValue(var8, "getContext(...)");
      this.statusBarHeight = var5.getStatusBarHeight(var8);
      DialogfragmentDeviceDetailsV2Binding var9 = this.binding;
      DialogfragmentDeviceDetailsV2Binding var6 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.bvTitle.setupWith((ViewGroup)var4).setBlurRadius(25.0F).setBlurEnabled(false);
      var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (DialogfragmentDeviceDetailsV2Binding)var2;
      }

      var6.scrollable.setOnScrollChangeListener(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda5(this));
   }

   private static final void blurTitleBar$lambda$3(DeviceDetailsV2DialogFragment var0, View var1, int var2, int var3, int var4, int var5) {
      var4 = var0.statusBarHeight;
      boolean var7 = true;
      var2 = 0;
      boolean var6;
      if (var3 > var4) {
         var6 = true;
      } else {
         var6 = false;
      }

      DialogfragmentDeviceDetailsV2Binding var9 = var0.binding;
      Object var8 = null;
      DialogfragmentDeviceDetailsV2Binding var11 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      View var12 = var11.vBottomDivider;
      Intrinsics.checkNotNullExpressionValue(var12, "vBottomDivider");
      if (var12.getVisibility() != 0) {
         var7 = false;
      }

      if (var7 != var6) {
         var9 = var0.binding;
         DialogfragmentDeviceDetailsV2Binding var13 = var9;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var13 = null;
         }

         View var14 = var13.vBottomDivider;
         Intrinsics.checkNotNullExpressionValue(var14, "vBottomDivider");
         if (!var6) {
            var2 = 8;
         }

         var14.setVisibility(var2);
         DialogfragmentDeviceDetailsV2Binding var10 = var0.binding;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = (DialogfragmentDeviceDetailsV2Binding)var8;
         }

         var10.bvTitle.setBlurEnabled(var6);
      }

   }

   private final void handleActions() {
      String var2 = this.getViewModel().getActionType();
      String var1 = var2;
      if (var2 == null) {
         var1 = jumpToAction;
      }

      if (var1 != null) {
         label43: {
            switch (var1.hashCode()) {
               case -2123968024:
                  if (var1.equals("filter_purchase")) {
                     this.scrollToFilterStatus();
                     return;
                  }
                  break label43;
               case -1785478504:
                  if (var1.equals("refresher_purchase")) {
                     this.scrollToRefresherStatus();
                     return;
                  }
                  break label43;
               case -1774126825:
                  if (var1.equals("wick_status")) {
                     this.scrollToWickStatus();
                  }
                  break label43;
               case -1274492040:
                  if (!var1.equals("filter")) {
                     break label43;
                  }
                  break;
               case -757923495:
                  var1.equals("device_details");
                  break label43;
               case -547902823:
                  if (!var1.equals("filter_status")) {
                     break label43;
                  }
                  break;
               case 590772454:
                  if (var1.equals("wick_purchase")) {
                     this.scrollToWickStatus();
                     return;
                  }
                  break label43;
               case 1919485769:
                  if (var1.equals("refresher_status")) {
                     this.scrollToRefresherStatus();
                  }
               default:
                  break label43;
            }

            this.scrollToFilterStatus();
         }
      }

      this.getViewModel().setActionType((String)null);
      jumpToAction = null;
   }

   private static final void onViewCreated$lambda$2(DeviceDetailsV2DialogFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      var0.handleActions();
   }

   private final void refreshHeaderWhenChanged() {
      boolean var3 = this.shouldTintDark;
      int var1 = 0;
      byte var2 = 0;
      Object var5 = null;
      Object var6 = null;
      if (var3) {
         DialogfragmentDeviceDetailsV2Binding var17 = this.binding;
         DialogfragmentDeviceDetailsV2Binding var4 = var17;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.btnBack.setBackgroundResource(R.drawable.bg_circle_dark15);
         var17 = this.binding;
         var4 = var17;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.btnBack.setImageTintList(ColorStateList.valueOf(-1));
         var17 = this.binding;
         var4 = var17;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = null;
         }

         var4.btnStandby.setBackgroundResource(R.drawable.bg_standby_night);
         this.sensorCardsAdapter.setTintDark(true);
         Device var20 = this.getViewModel().getDevice();
         if (var20 != null) {
            var4 = this.binding;
            if (var4 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var4 = (DialogfragmentDeviceDetailsV2Binding)var6;
            }

            ImageView var11 = var4.deviceImage;
            DeviceImage var21 = DeviceConfigProvider.INSTANCE.getDeviceImage(var20);
            var1 = var2;
            if (var21 != null) {
               var1 = var21.getBgDetailsNight();
            }

            var11.setImageResource(var1);
            return;
         }
      } else {
         DialogfragmentDeviceDetailsV2Binding var23 = this.binding;
         DialogfragmentDeviceDetailsV2Binding var12 = var23;
         if (var23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.btnBack.setBackgroundResource(R.drawable.bg_circle_dark5);
         var23 = this.binding;
         var12 = var23;
         if (var23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.btnBack.setImageTintList((ColorStateList)null);
         var23 = this.binding;
         var12 = var23;
         if (var23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.btnStandby.setBackgroundResource(R.drawable.bg_switch_standby);
         this.sensorCardsAdapter.setTintDark(false);
         Device var26 = this.getViewModel().getDevice();
         if (var26 != null) {
            var12 = this.binding;
            if (var12 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var12 = (DialogfragmentDeviceDetailsV2Binding)var5;
            }

            ImageView var16 = var12.deviceImage;
            DeviceImage var22 = DeviceConfigProvider.INSTANCE.getDeviceImage(var26);
            if (var22 != null) {
               var1 = var22.getBgDetails();
            }

            var16.setImageResource(var1);
         }
      }

   }

   private final void scrollToFilterStatus() {
      this.scrollToView("FILTER");
   }

   private final void scrollToRefresherStatus() {
      this.scrollToView("REFRESHER");
   }

   private final void scrollToView(String var1) {
      DialogfragmentDeviceDetailsV2Binding var3 = this.binding;
      DialogfragmentDeviceDetailsV2Binding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      NestedScrollView var4 = var2.scrollable;
      Intrinsics.checkNotNullExpressionValue(var4, "scrollable");
      var4.postDelayed(new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda0(var4, var1), 500L);
   }

   private static final void scrollToView$lambda$24(NestedScrollView var0, String var1) {
      if (var0.findViewWithTag(var1) != null) {
         var0.fullScroll(130);
      }

   }

   private final void scrollToWickStatus() {
      this.scrollToView("WICK");
   }

   private final void setShouldTintDark(boolean var1) {
      if (this.shouldTintDark != var1) {
         this.shouldTintDark = var1;
         this.refreshHeaderWhenChanged();
      }

   }

   private final void showDeviceControls() {
      FragmentTransaction var3 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var3, "beginTransaction(...)");
      DeviceControlsFragment var4 = DeviceControlsFragment.Companion.newInstance();
      DialogfragmentDeviceDetailsV2Binding var2 = this.binding;
      DialogfragmentDeviceDetailsV2Binding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var3.replace(var1.devicesControlsContainer.getId(), var4);
      var3.commitAllowingStateLoss();
   }

   private final void showDeviceMessages() {
      FragmentTransaction var3 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var3, "beginTransaction(...)");
      DeviceMessagesFragment var4 = DeviceMessagesFragment.Companion.newInstance();
      DialogfragmentDeviceDetailsV2Binding var2 = this.binding;
      DialogfragmentDeviceDetailsV2Binding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var3.replace(var1.messagesContainer.getId(), var4);
      var3.commitAllowingStateLoss();
   }

   private final void showDeviceSensorsGraph() {
      FragmentTransaction var3 = this.getChildFragmentManager().beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var3, "beginTransaction(...)");
      DeviceSensorsGraphFragment var4 = DeviceSensorsGraphFragment.Companion.newInstance();
      DialogfragmentDeviceDetailsV2Binding var2 = this.binding;
      DialogfragmentDeviceDetailsV2Binding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var3.replace(var1.graphContainer.getId(), var4);
      var3.commitAllowingStateLoss();
   }

   private final void updateTintDark(Device var1, boolean var2) {
      label18: {
         if (var1 instanceof DeviceFanTable && !var2 && var1.isOnline()) {
            var1 = var1;
            if (!var1.isStandByOn() && var1.isInSubMode(CoolSubMode.NIGHT)) {
               var2 = true;
               break label18;
            }
         }

         var2 = false;
      }

      this.setShouldTintDark(var2);
   }

   // $FF: synthetic method
   static void updateTintDark$default(DeviceDetailsV2DialogFragment var0, Device var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.updateTintDark(var1, var2);
   }

   public void dismiss() {
      FragmentKt.setFragmentResult((Fragment)this, "REQUEST_KEY_DEVICE_DETAILS_CLOSED", BundleKt.bundleOf());
      super.dismiss();
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

   public void onCancel(DialogInterface var1) {
      Intrinsics.checkNotNullParameter(var1, "dialog");
      FragmentKt.setFragmentResult((Fragment)this, "REQUEST_KEY_DEVICE_DETAILS_CLOSED", BundleKt.bundleOf());
      super.onCancel(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      Dialog var9 = this.getDialog();
      if (var9 != null) {
         this.setStyle(0, R.style.DialogTheme);
         Window var10 = var9.getWindow();
         if (var10 != null) {
            var10.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }

         Dialog var11 = this.getDialog();
         if (var11 != null) {
            Window var12 = var11.getWindow();
            if (var12 != null) {
               var12.setWindowAnimations(R.style.dialog_animation);
            }
         }
      }

      DialogfragmentDeviceDetailsV2Binding var4 = DialogfragmentDeviceDetailsV2Binding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      BaseDialogFragment var5 = this;
      this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class)));
      this.sensorsViewModel = (DeviceSensorsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceSensorsViewModel.class));
      DialogfragmentDeviceDetailsV2Binding var8 = this.binding;
      DialogfragmentDeviceDetailsV2Binding var6 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      ConstraintLayout var7 = var6.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      return (View)var7;
   }

   public void onPause() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.handleActions();
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

      DialogUtils.INSTANCE.immersiveStatusBar(this.getDialog(), true, true);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Bundle var5 = this.getArguments();
      Object var3 = null;
      Device var6;
      if (var5 != null) {
         var6 = (Device)var5.getParcelable("device");
      } else {
         var6 = null;
      }

      if (var6 != null) {
         DeviceDetailsViewModel var4 = this.getViewModel();
         var2 = this.getArguments();
         String var8;
         if (var2 != null) {
            var8 = var2.getString("action_type");
         } else {
            var8 = null;
         }

         var4.setActionType(var8);
         jumpToAction = null;
         Timber.Forest var9 = Timber.Forest;
         StringBuilder var12 = new StringBuilder("onViewCreated: viewModel = ");
         var12.append(this.getViewModel());
         var12.append(",  device = ");
         var12.append(var6);
         var12.append(", actionType = ");
         var12.append(this.getViewModel().getActionType());
         var9.d(var12.toString(), new Object[0]);
         this.getViewModel().setAttachedToDeviceDetailsDialogFragment(true);
         this.getViewModel().setDeviceId(var6.getUid());
         this.getViewModel().setDevice(var6);
         HasSensorData var10;
         if (var6 instanceof HasSensorData) {
            var10 = (HasSensorData)var6;
         } else {
            var10 = null;
         }

         if (var10 != null) {
            DeviceSensorsViewModel var11 = this.sensorsViewModel;
            if (var11 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("sensorsViewModel");
               var11 = (DeviceSensorsViewModel)var3;
            }

            var11.init((HasSensorData)var6, true);
         }

         this.bindViewModel();
         this.getChildFragmentManager().setFragmentResultListener("REQUEST_KEY_HANDLE_ACTION", (LifecycleOwner)this, new DeviceDetailsV2DialogFragment$$ExternalSyntheticLambda3(this));
         this.blurTitleBar();
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceDetailsV2DialogFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY_HANDLE_ACTION", "", "REQUEST_KEY_DEVICE_DETAILS_CLOSED", "jumpToAction", "getJumpToAction", "()Ljava/lang/String;", "setJumpToAction", "(Ljava/lang/String;)V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceDetailsV2DialogFragment;", "device", "Lcom/blueair/core/model/Device;", "actionType", "devicedetails_otherRelease"},
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
      public static DeviceDetailsV2DialogFragment newInstance$default(Companion var0, Device var1, String var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.newInstance(var1, var2);
      }

      public final String getJumpToAction() {
         return DeviceDetailsV2DialogFragment.jumpToAction;
      }

      public final DeviceDetailsV2DialogFragment newInstance(Device var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceDetailsV2DialogFragment var3 = new DeviceDetailsV2DialogFragment();
         var3.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1), TuplesKt.to("action_type", var2)}));
         return var3;
      }

      public final void setJumpToAction(String var1) {
         DeviceDetailsV2DialogFragment.jumpToAction = var1;
      }
   }
}
