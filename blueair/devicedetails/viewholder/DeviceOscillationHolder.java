package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.OscillationDirection;
import com.blueair.devicedetails.databinding.HolderDeviceOscillationBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOscillationHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationBinding;", "isInSchedule", "", "onOscillationSwitchListener", "Lkotlin/Function1;", "", "onOpenOscillationListener", "Lkotlin/Function0;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationBinding;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationBinding;", "()Z", "update", "device", "Lcom/blueair/core/model/Device;", "disableSettings", "disabled", "allowDirectionSetting", "isOscillationEnabled", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOscillationHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceOscillationBinding binding;
   private final boolean isInSchedule;
   private final Function0 onOpenOscillationListener;
   private final Function1 onOscillationSwitchListener;

   // $FF: synthetic method
   public static void $r8$lambda$97gxlGydnI6RVa_4YlxebVGgQis(DeviceOscillationHolder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$aotX6ea5D9w5NdfFqNdYQVpuqkI(DeviceOscillationHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   public DeviceOscillationHolder(HolderDeviceOscillationBinding var1, boolean var2, Function1 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOscillationSwitchListener");
      Intrinsics.checkNotNullParameter(var4, "onOpenOscillationListener");
      FrameLayout var6 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      super((View)var6);
      this.binding = var1;
      this.isInSchedule = var2;
      this.onOscillationSwitchListener = var3;
      this.onOpenOscillationListener = var4;
      var1.switchBtn.setOnCheckedChangeListener(new DeviceOscillationHolder$$ExternalSyntheticLambda0(this));
      var1.contentOscillationSettings.setOnClickListener(new DeviceOscillationHolder$$ExternalSyntheticLambda1(this));
      View var9 = var1.spacer1;
      Intrinsics.checkNotNullExpressionValue(var9, "spacer1");
      ViewExtensionsKt.show(var9, var2 ^ true);
      var9 = var1.spacer2;
      Intrinsics.checkNotNullExpressionValue(var9, "spacer2");
      ViewExtensionsKt.show(var9, var2 ^ true);
      ConstraintLayout var11 = var1.contentOscillationFanView;
      Intrinsics.checkNotNullExpressionValue(var11, "contentOscillationFanView");
      ViewExtensionsKt.show((View)var11, var2 ^ true);
      var11 = var1.contentOscillationSettings;
      Intrinsics.checkNotNullExpressionValue(var11, "contentOscillationSettings");
      ViewExtensionsKt.show((View)var11, var2 ^ true);
      if (var2) {
         var1.contentContainer.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
         int var5 = this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.device_details_humidifier_margin_horizontal);
         ConstraintLayout var7 = var1.contentTitle;
         Intrinsics.checkNotNullExpressionValue(var7, "contentTitle");
         View var8 = (View)var7;
         var8.setPadding(var5, var8.getPaddingTop(), var5, var8.getPaddingBottom());
      }

   }

   // $FF: synthetic method
   public DeviceOscillationHolder(HolderDeviceOscillationBinding var1, boolean var2, Function1 var3, Function0 var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var2 = false;
      }

      this(var1, var2, var3, var4);
   }

   private static final void _init_$lambda$0(DeviceOscillationHolder var0, CompoundButton var1, boolean var2) {
      var0.onOscillationSwitchListener.invoke(var2);
   }

   private static final void _init_$lambda$1(DeviceOscillationHolder var0, View var1) {
      var0.onOpenOscillationListener.invoke();
   }

   private final void disableSettings(boolean var1, boolean var2) {
      this.binding.switchBtn.setEnabled(var1 ^ true);
      ConstraintLayout var5 = this.binding.contentOscillationSettings;
      Intrinsics.checkNotNullExpressionValue(var5, "contentOscillationSettings");
      View var8 = (View)var5;
      boolean var4;
      if (var1 && !var2) {
         var4 = false;
      } else {
         var4 = true;
      }

      ViewExtensionsKt.show(var8, var4);
      Context var9 = this.itemView.getContext();
      int var3;
      if (var1) {
         var3 = R.color.light_gray;
      } else {
         var3 = R.color.colorPrimaryText;
      }

      var3 = var9.getColor(var3);
      this.binding.directionTitle.setTextColor(var3);
      this.binding.direction.setTextColor(var3);
      this.binding.oscillationAngleTitle.setTextColor(var3);
      this.binding.angle.setTextColor(var3);
      this.binding.speedTitle.setTextColor(var3);
      this.binding.speed.setTextColor(var3);
      if (var1 && var2) {
         var3 = this.itemView.getContext().getColor(R.color.colorPrimaryText);
         this.binding.directionTitle.setTextColor(var3);
         this.binding.direction.setTextColor(var3);
      }

   }

   public final HolderDeviceOscillationBinding getBinding() {
      return this.binding;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasOscillation) {
         HolderDeviceOscillationBinding var6 = this.binding;
         SwitchCompat var8 = var6.switchBtn;
         HasOscillation var7 = (HasOscillation)var1;
         var8.setCheckedSilence(var7.isOscillationEnabled());
         var6.fanView.animateFanAngles(var7.getOscillationAngle(), var7.oscillationDirection());
         OscillationDirection var12 = var7.oscillationDirection();
         int var2 = DeviceOscillationHolder.WhenMappings.$EnumSwitchMapping$0[var12.ordinal()];
         boolean var5 = true;
         int var3;
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var2 = R.drawable.ic_arrow_right_off;
               var3 = R.string.oscillation_direction_right;
            } else {
               var2 = R.drawable.ic_arrow_left_off;
               var3 = R.string.oscillation_direction_left;
            }
         } else {
            var2 = R.drawable.ic_arrow_straight_off;
            var3 = R.string.oscillation_direction_straight;
         }

         var6.angleDirection.setImageResource(var2);
         var6.direction.setText(var3);
         TextView var13 = var6.angle;
         StringBuilder var9 = new StringBuilder();
         var9.append(var7.getOscillationAngle());
         var9.append('°');
         var13.setText((CharSequence)var9.toString());
         var6.speed.setText((CharSequence)String.valueOf(var7.oscillationFanSpeed().getDisplayValue()));
         if (var1 instanceof HasCombo3in1MainMode) {
            boolean var4;
            label40: {
               if (((HasMainMode)var1).isInMainMode(MainMode.HEAT)) {
                  var4 = var5;
                  if (var1.isUsDevice()) {
                     break label40;
                  }
               }

               HasCombo3in1MainMode var11 = (HasCombo3in1MainMode)var1;
               if (var11.isInSubMode(ApSubMode.FAN)) {
                  var4 = var5;
                  if (var11.currentFanSpeed() == 0) {
                     break label40;
                  }
               }

               if (var11.isInSubMode(ApSubMode.ECO)) {
                  var4 = var5;
               } else {
                  var4 = false;
               }
            }

            this.disableSettings(var4, ((HasCombo3in1MainMode)var1).isInSubMode(ApSubMode.ECO));
         }
      }

   }

   public final void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasOscillation) {
         this.binding.switchBtn.setCheckedSilence(var2);
      }
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOscillationHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOscillationHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOscillationSwitchListener", "Lkotlin/Function1;", "", "onOpenOscillationListener", "Lkotlin/Function0;", "devicedetails_otherRelease"},
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
      public static DeviceOscillationHolder newInstance$default(Companion var0, ViewGroup var1, boolean var2, Function1 var3, Function0 var4, int var5, Object var6) {
         if ((var5 & 2) != 0) {
            var2 = false;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceOscillationHolder newInstance(ViewGroup var1, boolean var2, Function1 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOscillationSwitchListener");
         Intrinsics.checkNotNullParameter(var4, "onOpenOscillationListener");
         HolderDeviceOscillationBinding var5 = HolderDeviceOscillationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         var5.fanView.setInAttribute(true);
         Intrinsics.checkNotNullExpressionValue(var5, "apply(...)");
         return new DeviceOscillationHolder(var5, var2, var3, var4);
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
         int[] var0 = new int[OscillationDirection.values().length];

         try {
            var0[OscillationDirection.STRAIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[OscillationDirection.LEFT.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[OscillationDirection.RIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
