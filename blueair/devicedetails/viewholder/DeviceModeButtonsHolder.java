package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.UiAutoMode;
import com.blueair.core.model.UiG4NightMode;
import com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010%\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0014\u0010'\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u0014\u0010)\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0014\u0010+\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0014\u0010-\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0012R\u0014\u0010/\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001aR\u0014\u00103\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0012R\u0014\u00105\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0016R\u0014\u00107\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001a¨\u0006="},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/ModeButtonsHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "autoModeRoot", "Landroid/view/View;", "getAutoModeRoot", "()Landroid/view/View;", "autoModeTitleView", "Landroid/widget/TextView;", "getAutoModeTitleView", "()Landroid/widget/TextView;", "autoModeImageView", "Landroid/widget/ImageView;", "getAutoModeImageView", "()Landroid/widget/ImageView;", "nightModeRoot", "getNightModeRoot", "nightModeTitleView", "getNightModeTitleView", "nightModeImageView", "getNightModeImageView", "standByModeRoot", "getStandByModeRoot", "standByModeBackground", "getStandByModeBackground", "standByModeTitleView", "getStandByModeTitleView", "manualModeRoot", "getManualModeRoot", "manualModeTitleView", "getManualModeTitleView", "manualModeImageView", "getManualModeImageView", "childLockRoot", "getChildLockRoot", "childLockTitleView", "getChildLockTitleView", "childLockImageView", "getChildLockImageView", "disinfectionRoot", "getDisinfectionRoot", "disinfectionTitleView", "getDisinfectionTitleView", "disinfectionImageView", "getDisinfectionImageView", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModeButtonsHolder extends ModeButtonsHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ImageView autoModeImageView;
   private final View autoModeRoot;
   private final TextView autoModeTitleView;
   private final HolderDeviceButtonsModeBinding binding;
   private final ImageView childLockImageView;
   private final View childLockRoot;
   private final TextView childLockTitleView;
   private final ImageView disinfectionImageView;
   private final View disinfectionRoot;
   private final TextView disinfectionTitleView;
   private final ImageView manualModeImageView;
   private final View manualModeRoot;
   private final TextView manualModeTitleView;
   private final ImageView nightModeImageView;
   private final View nightModeRoot;
   private final TextView nightModeTitleView;
   private final Function1 onModeSelectedListener;
   private final ImageView standByModeBackground;
   private final View standByModeRoot;
   private final TextView standByModeTitleView;

   // $FF: synthetic method
   public static void $r8$lambda$1kyCxa6k9I4c6yUr57lEabplNKg(DeviceModeButtonsHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2tVQ5pXybfeYPU_BgfSdvI2U1ZI(DeviceModeButtonsHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Hy3PVZxhHKT9xFchvtbKI0SU4RQ(DeviceModeButtonsHolder var0, View var1) {
      _init_$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$coUzx6nGXhR7_X0AmvbhwaJewGM(DeviceModeButtonsHolder var0, View var1) {
      _init_$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$iIVzlEPh9CSLDZZYMc1aLe1BfOU(DeviceModeButtonsHolder var0, View var1) {
      _init_$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$y_3gzK8ZYU2VPTvdLFgUZy8E40A/* $FF was: $r8$lambda$y-3gzK8ZYU2VPTvdLFgUZy8E40A*/(DeviceModeButtonsHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceModeButtonsHolder(HolderDeviceButtonsModeBinding var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onModeSelectedListener");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.onModeSelectedListener = var2;
      LinearLayout var5 = var1.automodeRoot;
      Intrinsics.checkNotNullExpressionValue(var5, "automodeRoot");
      this.autoModeRoot = (View)var5;
      TextView var6 = var1.automodeTitleview;
      Intrinsics.checkNotNullExpressionValue(var6, "automodeTitleview");
      this.autoModeTitleView = var6;
      AppCompatImageView var7 = var1.automodeImageview;
      Intrinsics.checkNotNullExpressionValue(var7, "automodeImageview");
      this.autoModeImageView = (ImageView)var7;
      LinearLayout var8 = var1.nightmodeRoot;
      Intrinsics.checkNotNullExpressionValue(var8, "nightmodeRoot");
      this.nightModeRoot = (View)var8;
      TextView var9 = var1.nightmodeTitleview;
      Intrinsics.checkNotNullExpressionValue(var9, "nightmodeTitleview");
      this.nightModeTitleView = var9;
      AppCompatImageView var10 = var1.nightmodeImageview;
      Intrinsics.checkNotNullExpressionValue(var10, "nightmodeImageview");
      this.nightModeImageView = (ImageView)var10;
      LinearLayout var11 = var1.standbyModeRoot;
      Intrinsics.checkNotNullExpressionValue(var11, "standbyModeRoot");
      this.standByModeRoot = (View)var11;
      AppCompatImageView var12 = var1.standbyModeImageview;
      Intrinsics.checkNotNullExpressionValue(var12, "standbyModeImageview");
      this.standByModeBackground = (ImageView)var12;
      TextView var13 = var1.standbyModeTitleview;
      Intrinsics.checkNotNullExpressionValue(var13, "standbyModeTitleview");
      this.standByModeTitleView = var13;
      LinearLayout var14 = var1.manualModeRoot;
      Intrinsics.checkNotNullExpressionValue(var14, "manualModeRoot");
      this.manualModeRoot = (View)var14;
      AppCompatTextView var15 = var1.manualModeTitleview;
      Intrinsics.checkNotNullExpressionValue(var15, "manualModeTitleview");
      this.manualModeTitleView = (TextView)var15;
      AppCompatImageView var16 = var1.manualModeImageview;
      Intrinsics.checkNotNullExpressionValue(var16, "manualModeImageview");
      this.manualModeImageView = (ImageView)var16;
      LinearLayout var17 = var1.childLockRoot;
      Intrinsics.checkNotNullExpressionValue(var17, "childLockRoot");
      this.childLockRoot = (View)var17;
      AppCompatTextView var18 = var1.childLockTitleview;
      Intrinsics.checkNotNullExpressionValue(var18, "childLockTitleview");
      this.childLockTitleView = (TextView)var18;
      AppCompatImageView var19 = var1.childLockImageview;
      Intrinsics.checkNotNullExpressionValue(var19, "childLockImageview");
      this.childLockImageView = (ImageView)var19;
      LinearLayout var20 = var1.disinfectionRoot;
      Intrinsics.checkNotNullExpressionValue(var20, "disinfectionRoot");
      this.disinfectionRoot = (View)var20;
      AppCompatTextView var21 = var1.disinfectionTitleview;
      Intrinsics.checkNotNullExpressionValue(var21, "disinfectionTitleview");
      this.disinfectionTitleView = (TextView)var21;
      AppCompatImageView var4 = var1.disinfectionImageview;
      Intrinsics.checkNotNullExpressionValue(var4, "disinfectionImageview");
      this.disinfectionImageView = (ImageView)var4;
      this.getAutoModeRoot().setOnClickListener(new DeviceModeButtonsHolder$$ExternalSyntheticLambda0(this));
      this.getStandByModeRoot().setOnClickListener(new DeviceModeButtonsHolder$$ExternalSyntheticLambda1(this));
      this.getNightModeRoot().setOnClickListener(new DeviceModeButtonsHolder$$ExternalSyntheticLambda2(this));
      this.getManualModeRoot().setOnClickListener(new DeviceModeButtonsHolder$$ExternalSyntheticLambda3(this));
      this.getChildLockRoot().setOnClickListener(new DeviceModeButtonsHolder$$ExternalSyntheticLambda4(this));
      this.getDisinfectionRoot().setOnClickListener(new DeviceModeButtonsHolder$$ExternalSyntheticLambda5(this));
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, this.getAutoModeRoot(), Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, this.getStandByModeRoot(), Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, this.getNightModeRoot(), Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, this.getManualModeRoot(), Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, this.getChildLockRoot(), Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
      ViewUtils.setAccessibilityDelegate$default(ViewUtils.INSTANCE, this.getDisinfectionRoot(), Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
   }

   private static final void _init_$lambda$0(DeviceModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.AUTO);
   }

   private static final void _init_$lambda$1(DeviceModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.STANDBY);
   }

   private static final void _init_$lambda$2(DeviceModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.NIGHT);
   }

   private static final void _init_$lambda$3(DeviceModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.FAN_SPEED);
   }

   private static final void _init_$lambda$4(DeviceModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.CHILD_LOCK);
   }

   private static final void _init_$lambda$5(DeviceModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.DISINFECTION);
   }

   private static final void update$updateModes(DeviceModeButtonsHolder var0, Device var1, boolean var2, HasChildLock var3) {
      ModeButtonsHolder var4 = var0;
      HasG4NightMode var5 = (HasG4NightMode)var1;
      ModeButtonsHolder.updateAutoModeBtnViews$default(var4, var5.getUiAutoMode(), false, var1, 2, (Object)null);
      ModeButtonsHolder.updateNightModeBtnViews$default(var4, var5.getUiG4NightMode(), false, 2, (Object)null);
      ModeButtonsHolder.updateManualModeBtnViews$default(var4, var2, false, 2, (Object)null);
      if (var3 != null) {
         var2 = var3.isChildLockOn();
      } else {
         var2 = false;
      }

      ModeButtonsHolder.updateChildLockBtnViews$default(var4, var2, false, 2, (Object)null);
   }

   public ImageView getAutoModeImageView() {
      return this.autoModeImageView;
   }

   public View getAutoModeRoot() {
      return this.autoModeRoot;
   }

   public TextView getAutoModeTitleView() {
      return this.autoModeTitleView;
   }

   public final HolderDeviceButtonsModeBinding getBinding() {
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
      return this.disinfectionImageView;
   }

   public View getDisinfectionRoot() {
      return this.disinfectionRoot;
   }

   public TextView getDisinfectionTitleView() {
      return this.disinfectionTitleView;
   }

   public ImageView getManualModeImageView() {
      return this.manualModeImageView;
   }

   public View getManualModeRoot() {
      return this.manualModeRoot;
   }

   public TextView getManualModeTitleView() {
      return this.manualModeTitleView;
   }

   public ImageView getNightModeImageView() {
      return this.nightModeImageView;
   }

   public View getNightModeRoot() {
      return this.nightModeRoot;
   }

   public TextView getNightModeTitleView() {
      return this.nightModeTitleView;
   }

   public ImageView getStandByModeBackground() {
      return this.standByModeBackground;
   }

   public View getStandByModeRoot() {
      return this.standByModeRoot;
   }

   public TextView getStandByModeTitleView() {
      return this.standByModeTitleView;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      HasFanSpeed var7 = (HasFanSpeed)var1;
      HasChildLock var5;
      if (var1 instanceof HasChildLock) {
         var5 = (HasChildLock)var1;
      } else {
         var5 = null;
      }

      boolean var3 = DeviceKt.isG4orB4orNB(var1);
      boolean var4 = DeviceKt.supportDisinfection(var1);
      ViewExtensionsKt.show(this.getManualModeRoot(), true);
      ViewExtensionsKt.show(this.getNightModeRoot(), var3);
      ViewExtensionsKt.show(this.getStandByModeRoot(), var3);
      ViewExtensionsKt.show(this.getChildLockRoot(), var3);
      ViewExtensionsKt.show(this.getDisinfectionRoot(), var4);
      boolean var2 = Intrinsics.areEqual(var7.getUiAutoMode(), UiAutoMode.Off.INSTANCE);
      if (var3) {
         if (var2 && Intrinsics.areEqual(((HasG4NightMode)var7).getUiG4NightMode(), UiG4NightMode.Off.INSTANCE)) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      if (var3) {
         ModeButtonsHolder var14 = this;
         HasStandBy var16 = (HasStandBy)var7;
         ModeButtonsHolder.updateStandbyModeBtnViews$default(var14, var16.isStandByOn(), false, 2, (Object)null);
         if (var16.isStandByOn()) {
            this.updateAutoModeBtnViews(UiAutoMode.Off.INSTANCE, true, var1);
            this.updateNightModeBtnViews(UiG4NightMode.Off.INSTANCE, true);
            this.updateManualModeBtnViews(false, true);
            this.updateChildLockBtnViews(false, true);
            if (var4) {
               this.updateDisinfectionBtnViews(false, true);
            }

         } else {
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var9 = new StringBuilder("g4 mode: night mode ui = ");
            HasG4NightMode var17 = (HasG4NightMode)var1;
            var9.append(var17.getUiG4NightMode());
            var9.append(" & automode ui = ");
            var9.append(var17.getUiAutoMode());
            var8.d(var9.toString(), new Object[0]);
            if (var4) {
               Boolean var18 = ((HasDisinfection)var1).getDisinfection();
               if (var18 != null) {
                  var3 = var18;
               } else {
                  var3 = false;
               }

               ModeButtonsHolder.updateDisinfectionBtnViews$default(var14, var3, false, 2, (Object)null);
               this.getDisinfectionRoot().setSelected(var3);
               if (var3) {
                  ModeButtonsHolder.updateAutoModeBtnViews$default(var14, UiAutoMode.Off.INSTANCE, false, var1, 2, (Object)null);
                  ModeButtonsHolder.updateNightModeBtnViews$default(var14, UiG4NightMode.Off.INSTANCE, false, 2, (Object)null);
                  ModeButtonsHolder.updateManualModeBtnViews$default(var14, false, false, 2, (Object)null);
                  if (var5 != null) {
                     var2 = var5.isChildLockOn();
                  } else {
                     var2 = false;
                  }

                  ModeButtonsHolder.updateChildLockBtnViews$default(var14, var2, false, 2, (Object)null);
               } else {
                  update$updateModes(this, var1, var2, var5);
               }
            } else {
               update$updateModes(this, var1, var2, var5);
            }
         }
      } else {
         UiAutoMode var12 = var7.getUiAutoMode();
         Timber.Forest var15 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("legacy mode:  automode ui = ");
         var6.append(var12);
         var15.d(var6.toString(), new Object[0]);
         ModeButtonsHolder var13 = this;
         ModeButtonsHolder.updateAutoModeBtnViews$default(var13, var12, false, var1, 2, (Object)null);
         ModeButtonsHolder.updateManualModeBtnViews$default(var13, var2, false, 2, (Object)null);
      }
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsHolder;", "parentView", "Landroid/view/ViewGroup;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"},
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

      public final DeviceModeButtonsHolder newInstance(ViewGroup var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onModeSelectedListener");
         HolderDeviceButtonsModeBinding var3 = HolderDeviceButtonsModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceModeButtonsHolder(var3, var2);
      }
   }
}
