package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.util.PhoneUtil;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.ActivityWelcomeHomeConfigBinding;
import com.blueair.devicedetails.dialog.SimpleWelcomeHomePermissionsDialogFragment;
import com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel;
import com.blueair.outdoor.ui.activity.SearchActivity;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.ViewUtilsKt;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.io.Serializable;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\b\u00101\u001a\u00020,H\u0002J\u0012\u00102\u001a\u00020,2\b\b\u0002\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u00020,H\u0002J\b\u00106\u001a\u00020,H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u00108\u001a\u00020,2\b\b\u0002\u00103\u001a\u00020\u001eH\u0002J\b\u00109\u001a\u00020,H\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000¨\u0006>"},
   d2 = {"Lcom/blueair/devicedetails/activity/WelcomeHomeConfigActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityWelcomeHomeConfigBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/CreateUpdateWelcomeHomeViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/CreateUpdateWelcomeHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "getMap", "()Lcom/google/android/gms/maps/GoogleMap;", "setMap", "(Lcom/google/android/gms/maps/GoogleMap;)V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "marker", "Lcom/google/android/gms/maps/model/Marker;", "circle", "Lcom/google/android/gms/maps/model/Circle;", "playServicesAvailable", "", "icon", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "getIcon", "()Lcom/google/android/gms/maps/model/BitmapDescriptor;", "icon$delegate", "radiusColor", "", "getRadiusColor", "()I", "radiusColor$delegate", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "initRadiusButtons", "initMap", "requestLocation", "animate", "showArrivingHomeInfoDialog", "bindViewModel", "renderFailure", "onMapReady", "updateMarker", "updateRadius", "handleActivityResult", "result", "Landroidx/activity/result/ActivityResult;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomeConfigActivity extends BaseActivity implements OnMapReadyCallback {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityWelcomeHomeConfigBinding binding;
   private Circle circle;
   private HasWelcomeHome device;
   private FusedLocationProviderClient fusedLocationClient;
   private final Lazy icon$delegate;
   private GoogleMap map;
   private Marker marker;
   private boolean playServicesAvailable;
   private final Lazy radiusColor$delegate;
   private final String screenName = "device_settings_welcome_home";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$0uB5PFmMK8iITiWGpEBhE62TJn0(WelcomeHomeConfigActivity var0, View var1) {
      bindViewModel$lambda$25(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$1_qdmsLP479v5OLot1fJNu6x65E/* $FF was: $r8$lambda$1-qdmsLP479v5OLot1fJNu6x65E*/(WelcomeHomeConfigActivity var0, Boolean var1) {
      return bindViewModel$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$13uC5NaCZlhx5Z6oEL_fZZc_wWw/* $FF was: $r8$lambda$13uC5NaCZlhx5Z6oEL-fZZc_wWw*/(WelcomeHomeConfigActivity var0, View var1) {
      initView$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2lVd16lwvrn_V2tp8AcQ1QLCMFs(WelcomeHomeConfigActivity var0) {
      return onMapReady$lambda$30$lambda$29(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4N1iWj0ZHwzMIk6hSq4ZuffDvXc(WelcomeHomeConfigActivity var0, LatLng var1) {
      onMapReady$lambda$30(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4h2fo_o3QQas_nV3rv70mdYnAY0/* $FF was: $r8$lambda$4h2fo-o3QQas-nV3rv70mdYnAY0*/(WelcomeHomeConfigActivity var0, Boolean var1) {
      return bindViewModel$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$73izXKSP8VNPcjXeOYg9MtQ5vKE(WelcomeHomeConfigActivity var0, ActivityResult var1) {
      initView$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$92FlBWj863r2vYVtGDBlR8CPNmM(WelcomeHomeConfigActivity var0, View var1) {
      return initView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BzJcn0heF2dR0HHGqqOVi46DEQM(WelcomeHomeConfigActivity var0, ActivityResultLauncher var1, View var2) {
      initView$lambda$9(var0, var1, var2);
   }

   // $FF: synthetic method
   public static int $r8$lambda$DUj84lp0OQNwm1iyBRs8fSGuHGk(WelcomeHomeConfigActivity var0) {
      return radiusColor_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DyilgPXnB8PkVdzSRLi_3ktGMxc(WelcomeHomeConfigActivity var0, Unit var1) {
      return bindViewModel$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$EDJENNBCkK6ExbgtuGLtjNtTarc(WelcomeHomeConfigActivity var0, View var1) {
      initView$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$K9WFHdMrB59zZo_MNGNzOJQJpio(WelcomeHomeConfigActivity var0, View var1) {
      initView$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$W7TTs34dquxYUqbrWVFT_U_8F34/* $FF was: $r8$lambda$W7TTs34dquxYUqbrWVFT-U_8F34*/(WelcomeHomeConfigActivity var0, View var1) {
      initView$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WV_LlVDGT4iCC5DGxnJoQSX5aJI(WelcomeHomeConfigActivity var0, boolean var1, Location var2) {
      return requestLocation$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$biNQm_AW1E3NN5_3Kh8kWt_zphs/* $FF was: $r8$lambda$biNQm_AW1E3NN5-3Kh8kWt-zphs*/(WelcomeHomeConfigActivity var0, Unit var1) {
      return bindViewModel$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cla_cnKuVKmVqt2Dc8nDEyBV_pk(WelcomeHomeConfigActivity var0, View var1) {
      initRadiusButtons$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fAGcPzzEr4EtCC4uoC8a_GaxjBE(WelcomeHomeConfigActivity var0, View var1) {
      initRadiusButtons$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fNqreQMkd1JQ8Iit8J7rPUjihiE(WelcomeHomeConfigActivity var0) {
      onMapReady$lambda$30$lambda$29$lambda$28(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fkBjlzCOE3SA4swsIxrUChSah80(WelcomeHomeConfigActivity var0, String var1, Bundle var2) {
      initView$lambda$7$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$hR_lkfxrTObtKwm1XodECkX9_Po/* $FF was: $r8$lambda$hR-lkfxrTObtKwm1XodECkX9_Po*/(Function1 var0, Object var1) {
      requestLocation$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$l7L9qWYuRXS10hCscQ0xbj19ng8(WelcomeHomeConfigActivity var0, View var1) {
      initRadiusButtons$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static BitmapDescriptor $r8$lambda$mRPmipFbq2nX9dAydqcAvx01EGM(WelcomeHomeConfigActivity var0) {
      return icon_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qigC_eemeLQhsiddC8m0s1naDkE/* $FF was: $r8$lambda$qigC-eemeLQhsiddC8m0s1naDkE*/(GoogleMap var0, WelcomeHomeConfigActivity var1, MaterialCardView var2) {
      onMapReady$lambda$27$lambda$26(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$tocjFsJQ2_Ba6loSCnLF_0ccIuU/* $FF was: $r8$lambda$tocjFsJQ2_Ba6loSCnLF-0ccIuU*/(WelcomeHomeConfigActivity var0, View var1) {
      initRadiusButtons$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$z1hSzVCxBqfn4G7oYrs8OxbskFE(WelcomeHomeConfigActivity var0, boolean var1) {
      return bindViewModel$lambda$25$lambda$24$lambda$23(var0, var1);
   }

   public WelcomeHomeConfigActivity() {
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
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(CreateUpdateWelcomeHomeViewModel.class), new Function0(var1) {
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
      this.icon$delegate = LazyKt.lazy(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda15(this));
      this.radiusColor$delegate = LazyKt.lazy(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda16(this));
   }

   private final void bindViewModel() {
      ActivityWelcomeHomeConfigBinding var3 = this.binding;
      Object var2 = null;
      ActivityWelcomeHomeConfigBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.setVm(this.getViewModel());
      LifecycleOwner var4 = (LifecycleOwner)this;
      var1.setLifecycleOwner(var4);
      CreateUpdateWelcomeHomeViewModel var5 = this.getViewModel();
      HasWelcomeHome var9 = this.device;
      HasWelcomeHome var6 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var6 = null;
      }

      var5.setDevice(var6);
      this.getViewModel().getSaveEnabled().observe(var4, new Observer(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda5(this)) {
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
      this.getViewModel().getLoading().observe(var4, new Observer(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda6(this)) {
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
      this.getViewModel().getFailure().observe(var4, new Observer(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda7(this)) {
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
      this.getViewModel().getSuccess().observe(var4, new Observer(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda8(this)) {
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
      FusedLocationProviderClient var7 = LocationServices.getFusedLocationProviderClient((Activity)this);
      Intrinsics.checkNotNullExpressionValue(var7, "getFusedLocationProviderClient(...)");
      this.fusedLocationClient = var7;
      this.getViewModel().setUseShortAddress(true);
      this.getViewModel().loadHomeLocation();
      ActivityWelcomeHomeConfigBinding var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (ActivityWelcomeHomeConfigBinding)var2;
      }

      var8.btnSave.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda9(this));
   }

   private static final Unit bindViewModel$lambda$19(WelcomeHomeConfigActivity var0, Boolean var1) {
      ActivityWelcomeHomeConfigBinding var2 = var0.binding;
      ActivityWelcomeHomeConfigBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      MaterialButton var4 = var3.btnSave;
      Intrinsics.checkNotNull(var1);
      var4.setEnabled(var1);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$20(WelcomeHomeConfigActivity var0, Boolean var1) {
      ActivityWelcomeHomeConfigBinding var2 = var0.binding;
      ActivityWelcomeHomeConfigBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      ProgressBlockerView var4 = var3.progressView;
      Intrinsics.checkNotNullExpressionValue(var4, "progressView");
      View var5 = (View)var4;
      Intrinsics.checkNotNull(var1);
      ViewExtensionsKt.show(var5, var1);
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$21(WelcomeHomeConfigActivity var0, Unit var1) {
      var0.renderFailure();
      return Unit.INSTANCE;
   }

   private static final Unit bindViewModel$lambda$22(WelcomeHomeConfigActivity var0, Unit var1) {
      var0.finish();
      return Unit.INSTANCE;
   }

   private static final void bindViewModel$lambda$25(WelcomeHomeConfigActivity var0, View var1) {
      if (Intrinsics.areEqual(var0.getViewModel().getWelcomeHomeExist().getValue(), true)) {
         var0.getViewModel().saveHomeLocation();
      } else {
         FragmentManager var2 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("SimpleWelcomeHomePermissionsDialogFragment", "getSimpleName(...)");
         if (!(var2.findFragmentByTag("SimpleWelcomeHomePermissionsDialogFragment") instanceof SimpleWelcomeHomePermissionsDialogFragment) && !var2.isStateSaved()) {
            ((DialogFragment)SimpleWelcomeHomePermissionsDialogFragment.Companion.newInstance(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda17(var0))).show(var2, "SimpleWelcomeHomePermissionsDialogFragment");
         }

      }
   }

   private static final Unit bindViewModel$lambda$25$lambda$24$lambda$23(WelcomeHomeConfigActivity var0, boolean var1) {
      if (var1) {
         var0.getViewModel().saveHomeLocation();
      }

      return Unit.INSTANCE;
   }

   private final BitmapDescriptor getIcon() {
      return (BitmapDescriptor)this.icon$delegate.getValue();
   }

   private final int getRadiusColor() {
      return ((Number)this.radiusColor$delegate.getValue()).intValue();
   }

   private final CreateUpdateWelcomeHomeViewModel getViewModel() {
      return (CreateUpdateWelcomeHomeViewModel)this.viewModel$delegate.getValue();
   }

   private final void handleActivityResult(ActivityResult var1) {
      if (var1.getResultCode() == -1) {
         Intent var3 = var1.getData();
         if (var3 != null) {
            if (VERSION.SDK_INT >= 33) {
               CustomPlace var2 = (CustomPlace)BlueairApp$$ExternalSyntheticApiModelOutline0.m(var3, "place", CustomPlace.class);
               if (var2 != null) {
                  this.getViewModel().setCustomPlace(var2);
                  updateMarker$default(this, false, 1, (Object)null);
                  return;
               }

               TrackedLocation var4 = (TrackedLocation)BlueairApp$$ExternalSyntheticApiModelOutline0.m(var3, "savedloc", TrackedLocation.class);
               if (var4 != null) {
                  this.getViewModel().setTrackedLocation(var4);
                  updateMarker$default(this, false, 1, (Object)null);
                  return;
               }
            } else {
               CustomPlace var6 = (CustomPlace)var3.getParcelableExtra("place");
               if (var6 != null) {
                  this.getViewModel().setCustomPlace(var6);
                  updateMarker$default(this, false, 1, (Object)null);
                  return;
               }

               TrackedLocation var5 = (TrackedLocation)var3.getParcelableExtra("savedloc");
               if (var5 != null) {
                  this.getViewModel().setTrackedLocation(var5);
                  updateMarker$default(this, false, 1, (Object)null);
               }
            }
         }
      }

   }

   private static final BitmapDescriptor icon_delegate$lambda$0(WelcomeHomeConfigActivity var0) {
      return var0.playServicesAvailable ? BitmapDescriptorFactory.fromResource(R.drawable.ic_home_marker) : null;
   }

   private final void initMap() {
      SupportMapFragment var1 = SupportMapFragment.newInstance();
      Intrinsics.checkNotNullExpressionValue(var1, "newInstance(...)");
      this.getSupportFragmentManager().beginTransaction().replace(com.blueair.outdoor.R.id.map_container, (Fragment)var1).commit();
      var1.getMapAsync(this);
   }

   private final void initRadiusButtons() {
      ActivityWelcomeHomeConfigBinding var3 = this.binding;
      Object var2 = null;
      ActivityWelcomeHomeConfigBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.tvCar.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda10(this));
      var3 = this.binding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.tvBicycle.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda12(this));
      var3 = this.binding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.tvWalk.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda13(this));
      var1 = this.binding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = (ActivityWelcomeHomeConfigBinding)var2;
      }

      var1.tvCommute.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda14(this));
   }

   private static final void initRadiusButtons$lambda$10(WelcomeHomeConfigActivity var0, View var1) {
      var0.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.CAR);
      var0.updateRadius();
   }

   private static final void initRadiusButtons$lambda$11(WelcomeHomeConfigActivity var0, View var1) {
      var0.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.BICYCLE);
      var0.updateRadius();
   }

   private static final void initRadiusButtons$lambda$12(WelcomeHomeConfigActivity var0, View var1) {
      var0.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.WALK);
      var0.updateRadius();
   }

   private static final void initRadiusButtons$lambda$13(WelcomeHomeConfigActivity var0, View var1) {
      var0.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.COMMUTE);
      var0.updateRadius();
   }

   private final void initView() {
      ActivityWelcomeHomeConfigBinding var3 = this.binding;
      Object var2 = null;
      ActivityWelcomeHomeConfigBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.gpsBtn.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda21(this));
      var3 = this.binding;
      var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      AppCompatImageView var5 = var1.imInfo;
      Intrinsics.checkNotNullExpressionValue(var5, "imInfo");
      ViewUtilsKt.setOnClickListener((View)var5, 2000L, new WelcomeHomeConfigActivity$$ExternalSyntheticLambda22(this));
      var3 = this.binding;
      ActivityWelcomeHomeConfigBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.imInfo.setContentDescription((CharSequence)this.getString(com.blueair.viewcore.R.string.more_info_about, new Object[]{this.getString(com.blueair.viewcore.R.string.how_do_you_arrive_title)}));
      var3 = this.binding;
      var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnBack.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda23(this));
      var3 = this.binding;
      var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnClose.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda24(this));
      var3 = this.binding;
      var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnDeleteHome.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda25(this));
      this.initRadiusButtons();
      this.initMap();
      ActivityResultLauncher var16 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new WelcomeHomeConfigActivity$$ExternalSyntheticLambda26(this));
      Intrinsics.checkNotNullExpressionValue(var16, "registerForActivityResult(...)");
      var6 = this.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (ActivityWelcomeHomeConfigBinding)var2;
      }

      var6.tvAddress.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda1(this, var16));
   }

   private static final void initView$lambda$2(WelcomeHomeConfigActivity var0, View var1) {
      var0.requestLocation(true);
   }

   private static final Unit initView$lambda$3(WelcomeHomeConfigActivity var0, View var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.showArrivingHomeInfoDialog();
      return Unit.INSTANCE;
   }

   private static final void initView$lambda$4(WelcomeHomeConfigActivity var0, View var1) {
      var0.finish();
   }

   private static final void initView$lambda$5(WelcomeHomeConfigActivity var0, View var1) {
      var0.finish();
   }

   private static final void initView$lambda$7(WelcomeHomeConfigActivity var0, View var1) {
      ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, com.blueair.viewcore.R.string.delete_home_title, com.blueair.viewcore.R.string.delete_home_content, com.blueair.viewcore.R.string.delete_home_positive, com.blueair.viewcore.R.string.btn_cancel, true, false, false, (String[])null, 224, (Object)null).show(var0.getSupportFragmentManager(), "Delete home dialog");
      var0.getSupportFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)var0, new WelcomeHomeConfigActivity$$ExternalSyntheticLambda11(var0));
   }

   private static final void initView$lambda$7$lambda$6(WelcomeHomeConfigActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         ActivityWelcomeHomeConfigBinding var5 = var0.binding;
         ActivityWelcomeHomeConfigBinding var3 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var3 = null;
         }

         ProgressBlockerView var4 = var3.progressView;
         Intrinsics.checkNotNullExpressionValue(var4, "progressView");
         ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
         var0.getViewModel().deleteWelcomeHome();
      }

   }

   private static final void initView$lambda$8(WelcomeHomeConfigActivity var0, ActivityResult var1) {
      Intrinsics.checkNotNull(var1);
      var0.handleActivityResult(var1);
   }

   private static final void initView$lambda$9(WelcomeHomeConfigActivity var0, ActivityResultLauncher var1, View var2) {
      Intent var3 = new Intent((Context)var0, SearchActivity.class);
      var3.putExtra("request_code", (Serializable)SearchActivity.SearchType.MAPBOX);
      var1.launch(var3);
   }

   private static final void onMapReady$lambda$27$lambda$26(GoogleMap var0, WelcomeHomeConfigActivity var1, MaterialCardView var2) {
      ActivityWelcomeHomeConfigBinding var7 = var1.binding;
      ActivityWelcomeHomeConfigBinding var6 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      int var4 = var6.tvAddress.getBottom();
      int var5 = var2.getHeight();
      Intrinsics.checkNotNull(var2);
      ViewGroup.LayoutParams var8 = ((View)var2).getLayoutParams();
      ViewGroup.MarginLayoutParams var9;
      if (var8 instanceof ViewGroup.MarginLayoutParams) {
         var9 = (ViewGroup.MarginLayoutParams)var8;
      } else {
         var9 = null;
      }

      int var3;
      if (var9 != null) {
         var3 = var9.bottomMargin;
      } else {
         var3 = 0;
      }

      var0.setPadding(0, var4, 0, var5 + var3);
      if (var1.getViewModel().getAddress().getValue() != null) {
         updateMarker$default(var1, false, 1, (Object)null);
      }

   }

   private static final void onMapReady$lambda$30(WelcomeHomeConfigActivity var0, LatLng var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setAddressFromLatLng(var1.latitude, var1.longitude, new WelcomeHomeConfigActivity$$ExternalSyntheticLambda4(var0));
   }

   private static final Unit onMapReady$lambda$30$lambda$29(WelcomeHomeConfigActivity var0) {
      var0.runOnUiThread(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda18(var0));
      return Unit.INSTANCE;
   }

   private static final void onMapReady$lambda$30$lambda$29$lambda$28(WelcomeHomeConfigActivity var0) {
      var0.updateMarker(true);
   }

   private static final int radiusColor_delegate$lambda$1(WelcomeHomeConfigActivity var0) {
      return ContextCompat.getColor((Context)var0, com.blueair.viewcore.R.color.blue_opaque);
   }

   private final void renderFailure() {
      ViewUtils var3 = ViewUtils.INSTANCE;
      ActivityWelcomeHomeConfigBinding var2 = this.binding;
      ActivityWelcomeHomeConfigBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ConstraintLayout var4 = var1.rootLayout;
      Intrinsics.checkNotNullExpressionValue(var4, "rootLayout");
      var3.showSnackbar((View)var4, com.blueair.viewcore.R.string.something_went_wrong, ViewUtils.MessageType.ERROR.INSTANCE);
   }

   private final void requestLocation(boolean var1) {
      FusedLocationProviderClient var3 = this.fusedLocationClient;
      FusedLocationProviderClient var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
         var2 = null;
      }

      var2.getLastLocation().addOnSuccessListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda20(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda19(this, var1)));
   }

   // $FF: synthetic method
   static void requestLocation$default(WelcomeHomeConfigActivity var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = false;
      }

      var0.requestLocation(var1);
   }

   private static final Unit requestLocation$lambda$15(WelcomeHomeConfigActivity var0, boolean var1, Location var2) {
      if (var0.playServicesAvailable && var2 != null) {
         CameraUpdate var4 = CameraUpdateFactory.newLatLngZoom(new LatLng(var2.getLatitude(), var2.getLongitude()), 16.0F);
         Intrinsics.checkNotNullExpressionValue(var4, "newLatLngZoom(...)");
         GoogleMap var3 = var0.map;
         if (var1) {
            if (var3 != null) {
               var3.animateCamera(var4);
            }
         } else if (var3 != null) {
            var3.moveCamera(var4);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void requestLocation$lambda$16(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final void showArrivingHomeInfoDialog() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.label_arriving_home, (Integer)null, com.blueair.viewcore.R.string.arriving_home_info, (Integer)null, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8032, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
      }

   }

   private final void updateMarker(boolean var1) {
      Marker var4 = this.marker;
      if (var4 != null) {
         var4.remove();
      }

      Double var7 = this.getViewModel().getLat();
      if (var7 != null) {
         ((Number)var7).doubleValue();
         MarkerOptions var8 = new MarkerOptions();
         Double var5 = this.getViewModel().getLat();
         Intrinsics.checkNotNull(var5);
         double var2 = var5;
         var5 = this.getViewModel().getLng();
         Intrinsics.checkNotNull(var5);
         MarkerOptions var15 = var8.position(new LatLng(var2, var5)).icon(this.getIcon());
         Intrinsics.checkNotNullExpressionValue(var15, "icon(...)");
         GoogleMap var9 = this.map;
         Marker var10;
         if (var9 != null) {
            var10 = var9.addMarker(var15);
         } else {
            var10 = null;
         }

         this.marker = var10;
         this.updateRadius();
         if (this.playServicesAvailable) {
            Double var11 = this.getViewModel().getLat();
            Intrinsics.checkNotNull(var11);
            var2 = var11;
            var11 = this.getViewModel().getLng();
            Intrinsics.checkNotNull(var11);
            CameraUpdate var13 = CameraUpdateFactory.newLatLngZoom(new LatLng(var2, var11), 16.0F);
            Intrinsics.checkNotNullExpressionValue(var13, "newLatLngZoom(...)");
            if (var1) {
               GoogleMap var16 = this.map;
               if (var16 != null) {
                  var16.animateCamera(var13);
                  return;
               }
            } else {
               GoogleMap var17 = this.map;
               if (var17 != null) {
                  var17.moveCamera(var13);
               }
            }
         }
      }

   }

   // $FF: synthetic method
   static void updateMarker$default(WelcomeHomeConfigActivity var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = false;
      }

      var0.updateMarker(var1);
   }

   private final void updateRadius() {
      if (this.getViewModel().getAddress().getValue() != null) {
         WelcomeHomeLocation.WelcomeHomeRadius var3 = this.getViewModel().getSelectedRadius();
         if (var3 != null) {
            Circle var4 = this.circle;
            if (var4 != null) {
               var4.remove();
            }

            CircleOptions var8 = new CircleOptions();
            Double var5 = this.getViewModel().getLat();
            Intrinsics.checkNotNull(var5);
            double var1 = var5;
            var5 = this.getViewModel().getLng();
            Intrinsics.checkNotNull(var5);
            var8 = var8.center(new LatLng(var1, var5)).radius((double)var3.getValue()).fillColor(this.getRadiusColor()).strokeWidth(0.0F);
            Intrinsics.checkNotNullExpressionValue(var8, "strokeWidth(...)");
            GoogleMap var6 = this.map;
            Circle var7;
            if (var6 != null) {
               var7 = var6.addCircle(var8);
            } else {
               var7 = null;
            }

            this.circle = var7;
         }
      }

   }

   public final GoogleMap getMap() {
      return this.map;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      BaseLokaliseActivity var2 = this;
      ActivityWelcomeHomeConfigBinding var3 = null;
      BaseLokaliseActivity.immersiveStatusBar$default(var2, false, 1, (Object)null);
      ViewDataBinding var5 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_welcome_home_config);
      Intrinsics.checkNotNullExpressionValue(var5, "setContentView(...)");
      ActivityWelcomeHomeConfigBinding var6 = (ActivityWelcomeHomeConfigBinding)var5;
      this.binding = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
      } else {
         var3 = var6;
      }

      this.setContentView(var3.getRoot());
      this.playServicesAvailable = PhoneUtil.INSTANCE.isGoogleServicesAvailable((Context)this);
      Parcelable var4 = this.getIntent().getParcelableExtra("device");
      if (var4 != null) {
         this.device = (HasWelcomeHome)var4;
         this.bindViewModel();
         this.initView();
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onMapReady(GoogleMap var1) {
      Intrinsics.checkNotNullParameter(var1, "map");
      this.map = var1;
      var1.setMyLocationEnabled(true);
      var1.getUiSettings().setCompassEnabled(false);
      var1.getUiSettings().setMapToolbarEnabled(true);
      var1.getUiSettings().setZoomControlsEnabled(false);
      var1.getUiSettings().setRotateGesturesEnabled(false);
      var1.getUiSettings().setTiltGesturesEnabled(false);
      var1.getUiSettings().setIndoorLevelPickerEnabled(false);
      var1.getUiSettings().setMyLocationButtonEnabled(false);
      var1.getUiSettings().setMapToolbarEnabled(false);
      ActivityWelcomeHomeConfigBinding var3 = this.binding;
      ActivityWelcomeHomeConfigBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      MaterialCardView var4 = var2.cvHome;
      var4.post(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda2(var1, this, var4));
      var1.setMaxZoomPreference(16.0F);
      var1.setOnMapClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda3(this));
      if (this.getViewModel().getAddress().getValue() == null) {
         requestLocation$default(this, false, 1, (Object)null);
      }

   }

   public final void setMap(GoogleMap var1) {
      this.map = var1;
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/activity/WelcomeHomeConfigActivity$Companion;", "", "<init>", "()V", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "devicedetails_otherRelease"},
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

      public final Intent getLaunchIntent(Context var1, HasWelcomeHome var2) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intent var3 = new Intent(var1, WelcomeHomeConfigActivity.class);
         var3.putExtra("device", var2);
         return var3;
      }
   }
}
