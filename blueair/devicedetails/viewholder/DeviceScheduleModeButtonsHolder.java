package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.UiAutoMode;
import com.blueair.core.model.UiG4NightMode;
import com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding;
import com.blueair.devicedetails.databinding.HolderScheduleDeviceButtonsModeBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Z2\u00020\u0001:\u0001ZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020VH\u0016J\u0016\u0010W\u001a\u00020\t2\u0006\u0010U\u001a\u00020V2\u0006\u0010X\u001a\u00020\bJ\b\u0010Y\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u001eR\u001b\u0010#\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u001eR\u001b\u0010&\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b1\u0010)R\u001b\u00103\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0015\u001a\u0004\b4\u0010.R\u001b\u00106\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b7\u0010)R\u001b\u00109\u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b:\u0010\u001eR\u001b\u0010<\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b=\u0010.R\u001b\u0010?\u001a\u00020'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0015\u001a\u0004\b@\u0010)R\u001b\u0010B\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bC\u0010.R\u0016\u0010E\u001a\u0004\u0018\u00010'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010)R\u0016\u0010G\u001a\u0004\u0018\u00010,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0016\u0010I\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001eR\u001d\u0010K\u001a\u0004\u0018\u00010'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0015\u001a\u0004\bL\u0010)R\u001d\u0010N\u001a\u0004\u0018\u00010,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0015\u001a\u0004\bO\u0010.R\u001d\u0010Q\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0015\u001a\u0004\bR\u0010\u001e¨\u0006["},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/ModeButtonsHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "supportDisinfection", "", "onPurifierModeChanged", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "", "<init>", "(Landroidx/viewbinding/ViewBinding;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getSupportDisinfection", "()Z", "disinfectionBinding", "Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "getDisinfectionBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "disinfectionBinding$delegate", "Lkotlin/Lazy;", "otherBinding", "Lcom/blueair/devicedetails/databinding/HolderScheduleDeviceButtonsModeBinding;", "getOtherBinding", "()Lcom/blueair/devicedetails/databinding/HolderScheduleDeviceButtonsModeBinding;", "otherBinding$delegate", "autoModeImageView", "Landroid/widget/ImageView;", "getAutoModeImageView", "()Landroid/widget/ImageView;", "autoModeImageView$delegate", "nightModeImageView", "getNightModeImageView", "nightModeImageView$delegate", "manualModeImageView", "getManualModeImageView", "manualModeImageView$delegate", "autoModeRoot", "Landroid/view/View;", "getAutoModeRoot", "()Landroid/view/View;", "autoModeRoot$delegate", "autoModeTitleView", "Landroid/widget/TextView;", "getAutoModeTitleView", "()Landroid/widget/TextView;", "autoModeTitleView$delegate", "nightModeRoot", "getNightModeRoot", "nightModeRoot$delegate", "nightModeTitleView", "getNightModeTitleView", "nightModeTitleView$delegate", "standByModeRoot", "getStandByModeRoot", "standByModeRoot$delegate", "standByModeBackground", "getStandByModeBackground", "standByModeBackground$delegate", "standByModeTitleView", "getStandByModeTitleView", "standByModeTitleView$delegate", "manualModeRoot", "getManualModeRoot", "manualModeRoot$delegate", "manualModeTitleView", "getManualModeTitleView", "manualModeTitleView$delegate", "childLockRoot", "getChildLockRoot", "childLockTitleView", "getChildLockTitleView", "childLockImageView", "getChildLockImageView", "disinfectionRoot", "getDisinfectionRoot", "disinfectionRoot$delegate", "disinfectionTitleView", "getDisinfectionTitleView", "disinfectionTitleView$delegate", "disinfectionImageView", "getDisinfectionImageView", "disinfectionImageView$delegate", "update", "device", "Lcom/blueair/core/model/Device;", "bind", "mode", "bindListeners", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleModeButtonsHolder extends ModeButtonsHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy autoModeImageView$delegate;
   private final Lazy autoModeRoot$delegate;
   private final Lazy autoModeTitleView$delegate;
   private final ViewBinding binding;
   private final ImageView childLockImageView;
   private final View childLockRoot;
   private final TextView childLockTitleView;
   private final Lazy disinfectionBinding$delegate;
   private final Lazy disinfectionImageView$delegate;
   private final Lazy disinfectionRoot$delegate;
   private final Lazy disinfectionTitleView$delegate;
   private final Lazy manualModeImageView$delegate;
   private final Lazy manualModeRoot$delegate;
   private final Lazy manualModeTitleView$delegate;
   private final Lazy nightModeImageView$delegate;
   private final Lazy nightModeRoot$delegate;
   private final Lazy nightModeTitleView$delegate;
   private final Function1 onPurifierModeChanged;
   private final Lazy otherBinding$delegate;
   private final Lazy standByModeBackground$delegate;
   private final Lazy standByModeRoot$delegate;
   private final Lazy standByModeTitleView$delegate;
   private final boolean supportDisinfection;

   // $FF: synthetic method
   public static ViewGroup $r8$lambda$1T8kA7_LjGF6HuZJm46ZXjOr6_A/* $FF was: $r8$lambda$1T8kA7-LjGF6HuZJm46ZXjOr6-A*/(DeviceScheduleModeButtonsHolder var0) {
      return standByModeRoot_delegate$lambda$9(var0);
   }

   // $FF: synthetic method
   public static AppCompatImageView $r8$lambda$1x_TgNQgWwrAI12n4kM_ieRZa9Y(DeviceScheduleModeButtonsHolder var0) {
      return autoModeImageView_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2oCPk21mwSCCtdDSEiQVKNZ81hg(DeviceScheduleModeButtonsHolder var0, View var1) {
      bindListeners$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4fLwA77d2zhrgUg9VzQ_CStwUtU/* $FF was: $r8$lambda$4fLwA77d2zhrgUg9VzQ-CStwUtU*/(DeviceScheduleModeButtonsHolder var0, View var1) {
      bindListeners$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static LinearLayout $r8$lambda$5dBrA6g6KMq_mKIqXgz0JhHdcuU/* $FF was: $r8$lambda$5dBrA6g6KMq-mKIqXgz0JhHdcuU*/(DeviceScheduleModeButtonsHolder var0) {
      return disinfectionRoot_delegate$lambda$14(var0);
   }

   // $FF: synthetic method
   public static HolderDeviceButtonsModeBinding $r8$lambda$CP_b0WyP81tjcu822XLodRwnLNA(DeviceScheduleModeButtonsHolder var0) {
      return disinfectionBinding_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static HolderScheduleDeviceButtonsModeBinding $r8$lambda$EXOAVpwZJzka4_nwRAOEgdwLvP4(DeviceScheduleModeButtonsHolder var0) {
      return otherBinding_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static AppCompatImageView $r8$lambda$GQPyQgab6MFt_eeBgZQ9tVyOtKU/* $FF was: $r8$lambda$GQPyQgab6MFt-eeBgZQ9tVyOtKU*/(DeviceScheduleModeButtonsHolder var0) {
      return standByModeBackground_delegate$lambda$10(var0);
   }

   // $FF: synthetic method
   public static AppCompatTextView $r8$lambda$MVxurBmXe34EkG4qScjc8DC1QWA(DeviceScheduleModeButtonsHolder var0) {
      return manualModeTitleView_delegate$lambda$13(var0);
   }

   // $FF: synthetic method
   public static TextView $r8$lambda$bWiUo84sy5acQx4qLYj81k9d2cU(DeviceScheduleModeButtonsHolder var0) {
      return autoModeTitleView_delegate$lambda$6(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$e23f95KjNiZJC7_80kkrAVh18mA/* $FF was: $r8$lambda$e23f95KjNiZJC7-80kkrAVh18mA*/(DeviceScheduleModeButtonsHolder var0, View var1) {
      bindListeners$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static TextView $r8$lambda$gIfNbJi60Es2zYM8iZGNHfai98w(DeviceScheduleModeButtonsHolder var0) {
      return nightModeTitleView_delegate$lambda$8(var0);
   }

   // $FF: synthetic method
   public static AppCompatImageView $r8$lambda$gap2V8Y2Lku7CnTm_Glj_EbDHbA(DeviceScheduleModeButtonsHolder var0) {
      return manualModeImageView_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static ViewGroup $r8$lambda$hUJ_baLNUrvro8_87NFEd23RQX8(DeviceScheduleModeButtonsHolder var0) {
      return manualModeRoot_delegate$lambda$12(var0);
   }

   // $FF: synthetic method
   public static AppCompatImageView $r8$lambda$jF5Mjb0aNwrdYQQghPRWZTaSgPc(DeviceScheduleModeButtonsHolder var0) {
      return nightModeImageView_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static TextView $r8$lambda$kDuc133gtlaYke7ctmCG4Us5SWU(DeviceScheduleModeButtonsHolder var0) {
      return standByModeTitleView_delegate$lambda$11(var0);
   }

   // $FF: synthetic method
   public static AppCompatImageView $r8$lambda$nlWrilzjCq_kroLFnm08Rv7n2rw/* $FF was: $r8$lambda$nlWrilzjCq-kroLFnm08Rv7n2rw*/(DeviceScheduleModeButtonsHolder var0) {
      return disinfectionImageView_delegate$lambda$16(var0);
   }

   // $FF: synthetic method
   public static ViewGroup $r8$lambda$rKjAQuVMMSA3nSp6tYPw3iVlOzE(DeviceScheduleModeButtonsHolder var0) {
      return nightModeRoot_delegate$lambda$7(var0);
   }

   // $FF: synthetic method
   public static AppCompatTextView $r8$lambda$rrUITmb_gaHFqDX67sE2dqxzMww/* $FF was: $r8$lambda$rrUITmb-gaHFqDX67sE2dqxzMww*/(DeviceScheduleModeButtonsHolder var0) {
      return disinfectionTitleView_delegate$lambda$15(var0);
   }

   // $FF: synthetic method
   public static ViewGroup $r8$lambda$s5880MntDAa2dJKnRZ3Urz2kPA4(DeviceScheduleModeButtonsHolder var0) {
      return autoModeRoot_delegate$lambda$5(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$z0gPfVRsIwUj0RPnU_Lg7x_3AuQ/* $FF was: $r8$lambda$z0gPfVRsIwUj0RPnU-Lg7x_3AuQ*/(DeviceScheduleModeButtonsHolder var0, View var1) {
      bindListeners$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zhwUxR0LSrUxivn3WqwtnZGljv4(DeviceScheduleModeButtonsHolder var0, View var1) {
      bindListeners$lambda$19(var0, var1);
   }

   public DeviceScheduleModeButtonsHolder(ViewBinding var1, boolean var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onPurifierModeChanged");
      View var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super(var4);
      this.binding = var1;
      this.supportDisinfection = var2;
      this.onPurifierModeChanged = var3;
      this.disinfectionBinding$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda17(this));
      this.otherBinding$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda4(this));
      this.autoModeImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda5(this));
      this.nightModeImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda6(this));
      this.manualModeImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda7(this));
      this.autoModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda8(this));
      this.autoModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda9(this));
      this.nightModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda10(this));
      this.nightModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda12(this));
      this.standByModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda13(this));
      this.standByModeBackground$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda18(this));
      this.standByModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda19(this));
      this.manualModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda20(this));
      this.manualModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda21(this));
      this.disinfectionRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda1(this));
      this.disinfectionTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda2(this));
      this.disinfectionImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda3(this));
   }

   private static final AppCompatImageView autoModeImageView_delegate$lambda$2(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().automodeImageview : var0.getOtherBinding().automodeImageview;
   }

   private static final ViewGroup autoModeRoot_delegate$lambda$5(DeviceScheduleModeButtonsHolder var0) {
      Object var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().automodeRoot;
      } else {
         var1 = var0.getOtherBinding().automodeRoot;
      }

      Intrinsics.checkNotNullExpressionValue(var1, "automodeRoot");
      return (ViewGroup)var1;
   }

   private static final TextView autoModeTitleView_delegate$lambda$6(DeviceScheduleModeButtonsHolder var0) {
      TextView var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().automodeTitleview;
      } else {
         var1 = var0.getOtherBinding().automodeTitleview;
      }

      Intrinsics.checkNotNull(var1);
      return var1;
   }

   private final void bindListeners() {
      this.getStandByModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda0(this));
      this.getAutoModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda11(this));
      this.getManualModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda14(this));
      this.getNightModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda15(this));
      if (this.supportDisinfection) {
         View var1 = this.getDisinfectionRoot();
         if (var1 != null) {
            var1.setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda16(this));
         }
      }

   }

   private static final void bindListeners$lambda$17(DeviceScheduleModeButtonsHolder var0, View var1) {
      var0.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY);
   }

   private static final void bindListeners$lambda$18(DeviceScheduleModeButtonsHolder var0, View var1) {
      var0.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.AUTO);
   }

   private static final void bindListeners$lambda$19(DeviceScheduleModeButtonsHolder var0, View var1) {
      var0.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL);
   }

   private static final void bindListeners$lambda$20(DeviceScheduleModeButtonsHolder var0, View var1) {
      var0.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT);
   }

   private static final void bindListeners$lambda$21(DeviceScheduleModeButtonsHolder var0, View var1) {
      var0.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION);
   }

   private static final HolderDeviceButtonsModeBinding disinfectionBinding_delegate$lambda$0(DeviceScheduleModeButtonsHolder var0) {
      ViewBinding var1 = var0.binding;
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding");
      return (HolderDeviceButtonsModeBinding)var1;
   }

   private static final AppCompatImageView disinfectionImageView_delegate$lambda$16(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().disinfectionImageview : null;
   }

   private static final LinearLayout disinfectionRoot_delegate$lambda$14(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().disinfectionRoot : null;
   }

   private static final AppCompatTextView disinfectionTitleView_delegate$lambda$15(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().disinfectionTitleview : null;
   }

   private final HolderDeviceButtonsModeBinding getDisinfectionBinding() {
      return (HolderDeviceButtonsModeBinding)this.disinfectionBinding$delegate.getValue();
   }

   private final HolderScheduleDeviceButtonsModeBinding getOtherBinding() {
      return (HolderScheduleDeviceButtonsModeBinding)this.otherBinding$delegate.getValue();
   }

   private static final AppCompatImageView manualModeImageView_delegate$lambda$4(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().manualModeImageview : var0.getOtherBinding().manualModeImageview;
   }

   private static final ViewGroup manualModeRoot_delegate$lambda$12(DeviceScheduleModeButtonsHolder var0) {
      Object var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().manualModeRoot;
      } else {
         var1 = var0.getOtherBinding().manualModeRoot;
      }

      Intrinsics.checkNotNullExpressionValue(var1, "manualModeRoot");
      return (ViewGroup)var1;
   }

   private static final AppCompatTextView manualModeTitleView_delegate$lambda$13(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().manualModeTitleview : var0.getOtherBinding().manualModeTitleview;
   }

   private static final AppCompatImageView nightModeImageView_delegate$lambda$3(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().nightmodeImageview : var0.getOtherBinding().nightmodeImageview;
   }

   private static final ViewGroup nightModeRoot_delegate$lambda$7(DeviceScheduleModeButtonsHolder var0) {
      Object var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().nightmodeRoot;
      } else {
         var1 = var0.getOtherBinding().nightmodeRoot;
      }

      Intrinsics.checkNotNullExpressionValue(var1, "nightmodeRoot");
      return (ViewGroup)var1;
   }

   private static final TextView nightModeTitleView_delegate$lambda$8(DeviceScheduleModeButtonsHolder var0) {
      TextView var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().nightmodeTitleview;
      } else {
         var1 = var0.getOtherBinding().nightmodeTitleview;
      }

      Intrinsics.checkNotNull(var1);
      return var1;
   }

   private static final HolderScheduleDeviceButtonsModeBinding otherBinding_delegate$lambda$1(DeviceScheduleModeButtonsHolder var0) {
      ViewBinding var1 = var0.binding;
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderScheduleDeviceButtonsModeBinding");
      return (HolderScheduleDeviceButtonsModeBinding)var1;
   }

   private static final AppCompatImageView standByModeBackground_delegate$lambda$10(DeviceScheduleModeButtonsHolder var0) {
      return var0.supportDisinfection ? var0.getDisinfectionBinding().standbyModeImageview : var0.getOtherBinding().standbyModeImageview;
   }

   private static final ViewGroup standByModeRoot_delegate$lambda$9(DeviceScheduleModeButtonsHolder var0) {
      Object var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().standbyModeRoot;
      } else {
         var1 = var0.getOtherBinding().standbyModeRoot;
      }

      Intrinsics.checkNotNullExpressionValue(var1, "standbyModeRoot");
      return (ViewGroup)var1;
   }

   private static final TextView standByModeTitleView_delegate$lambda$11(DeviceScheduleModeButtonsHolder var0) {
      TextView var1;
      if (var0.supportDisinfection) {
         var1 = var0.getDisinfectionBinding().standbyModeTitleview;
      } else {
         var1 = (TextView)var0.getOtherBinding().standbyModeTitleview;
      }

      Intrinsics.checkNotNull(var1);
      return var1;
   }

   public final void bind(Device var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "mode");
      Timber.Forest var10 = Timber.Forest;
      StringBuilder var9 = new StringBuilder("bind: device = ");
      var9.append(var1);
      var9.append(", mode = ");
      var9.append(var2);
      var10.d(var9.toString(), new Object[0]);
      boolean var3;
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT) {
         var5 = true;
      } else {
         var5 = false;
      }

      boolean var6;
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
         var6 = true;
      } else {
         var6 = false;
      }

      boolean var7;
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION) {
         var7 = true;
      } else {
         var7 = false;
      }

      this.bindListeners();
      if (DeviceKt.isG4orB4orNB(var1)) {
         ViewExtensionsKt.show(this.getStandByModeRoot(), true);
         this.updateStandbyModeBtnViews(var3 ^ true, true);
         ViewExtensionsKt.show(this.getNightModeRoot(), true);
         ModeButtonsHolder var15 = this;
         Object var11;
         if (var5) {
            var11 = UiG4NightMode.On.INSTANCE;
         } else {
            var11 = UiG4NightMode.Off.INSTANCE;
         }

         ModeButtonsHolder.updateNightModeBtnViews$default(var15, (UiG4NightMode)var11, false, 2, (Object)null);
      } else {
         View var12 = this.getAutoModeRoot();
         boolean var8;
         if (var1 instanceof HasFanSpeed && ((HasFanSpeed)var1).getAutoMode() != AutoMode.NOT_AVAILABLE) {
            var8 = true;
         } else {
            var8 = false;
         }

         ViewExtensionsKt.show(var12, var8);
         if (var1 instanceof HasLinkingCapability) {
            ViewExtensionsKt.show(this.getAutoModeRoot(), ((HasLinkingCapability)var1).isLinked());
         }

         ViewExtensionsKt.show(this.getNightModeRoot(), false);
         ViewExtensionsKt.show(this.getStandByModeRoot(), false);
      }

      if (this.supportDisinfection) {
         View var13 = this.getDisinfectionRoot();
         if (var13 != null) {
            ViewExtensionsKt.show(var13, true);
         }

         ModeButtonsHolder.updateDisinfectionBtnViews$default(this, var7, false, 2, (Object)null);
      }

      ModeButtonsHolder var16 = this;
      Object var14;
      if (var4) {
         var14 = UiAutoMode.On.INSTANCE;
      } else {
         var14 = UiAutoMode.Off.INSTANCE;
      }

      ModeButtonsHolder.updateAutoModeBtnViews$default(var16, (UiAutoMode)var14, false, var1, 2, (Object)null);
      ViewExtensionsKt.show$default(this.getManualModeRoot(), false, 1, (Object)null);
      ModeButtonsHolder.updateManualModeBtnViews$default(var16, var6, false, 2, (Object)null);
   }

   public ImageView getAutoModeImageView() {
      Object var1 = this.autoModeImageView$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (ImageView)var1;
   }

   public View getAutoModeRoot() {
      return (View)this.autoModeRoot$delegate.getValue();
   }

   public TextView getAutoModeTitleView() {
      return (TextView)this.autoModeTitleView$delegate.getValue();
   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public ImageView getChildLockImageView() {
      return this.childLockImageView;
   }

   public View getChildLockRoot() {
      return this.childLockRoot;
   }

   public TextView getChildLockTitleView() {
      return this.childLockTitleView;
   }

   public ImageView getDisinfectionImageView() {
      return (ImageView)this.disinfectionImageView$delegate.getValue();
   }

   public View getDisinfectionRoot() {
      return (View)this.disinfectionRoot$delegate.getValue();
   }

   public TextView getDisinfectionTitleView() {
      return (TextView)this.disinfectionTitleView$delegate.getValue();
   }

   public ImageView getManualModeImageView() {
      Object var1 = this.manualModeImageView$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (ImageView)var1;
   }

   public View getManualModeRoot() {
      return (View)this.manualModeRoot$delegate.getValue();
   }

   public TextView getManualModeTitleView() {
      Object var1 = this.manualModeTitleView$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (TextView)var1;
   }

   public ImageView getNightModeImageView() {
      Object var1 = this.nightModeImageView$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (ImageView)var1;
   }

   public View getNightModeRoot() {
      return (View)this.nightModeRoot$delegate.getValue();
   }

   public TextView getNightModeTitleView() {
      return (TextView)this.nightModeTitleView$delegate.getValue();
   }

   public ImageView getStandByModeBackground() {
      Object var1 = this.standByModeBackground$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (ImageView)var1;
   }

   public View getStandByModeRoot() {
      return (View)this.standByModeRoot$delegate.getValue();
   }

   public TextView getStandByModeTitleView() {
      return (TextView)this.standByModeTitleView$delegate.getValue();
   }

   public final boolean getSupportDisinfection() {
      return this.supportDisinfection;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleModeButtonsHolder;", "parent", "Landroid/view/ViewGroup;", "supportDisinfection", "", "onPurifierModeChanged", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "", "devicedetails_otherRelease"},
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

      public final DeviceScheduleModeButtonsHolder newInstance(ViewGroup var1, boolean var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         Intrinsics.checkNotNullParameter(var3, "onPurifierModeChanged");
         LayoutInflater var4 = LayoutInflater.from(var1.getContext());
         ViewBinding var6;
         if (var2) {
            HolderDeviceButtonsModeBinding var5 = HolderDeviceButtonsModeBinding.inflate(var4, var1, false);
            Intrinsics.checkNotNull(var5);
            var6 = var5;
         } else {
            HolderScheduleDeviceButtonsModeBinding var7 = HolderScheduleDeviceButtonsModeBinding.inflate(var4, var1, false);
            Intrinsics.checkNotNull(var7);
            var6 = var7;
         }

         return new DeviceScheduleModeButtonsHolder(var6, var2, var3);
      }
   }
}
