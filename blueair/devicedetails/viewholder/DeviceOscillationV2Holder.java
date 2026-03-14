package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.OscillationDirection;
import com.blueair.devicedetails.databinding.HolderDeviceOscillationV2Binding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0017J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOscillationV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationV2Binding;", "binding", "isInSchedule", "", "onOscillationSwitchListener", "Lkotlin/Function1;", "", "onOpenOscillationListener", "Lkotlin/Function0;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceOscillationV2Binding;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "()Z", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "disableSettings", "disabled", "allowDirectionSetting", "oscillationEnabled", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "updateBackground", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceOscillationV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final boolean isInSchedule;
   private final Function0 onOpenOscillationListener;
   private final Function1 onOscillationSwitchListener;

   // $FF: synthetic method
   public static void $r8$lambda$TKldlve5b0hmWVWgGxpf1DGQSWY(DeviceOscillationV2Holder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dOc8wecNblKzX3BR5MnyutO_5nI(DeviceOscillationV2Holder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   public DeviceOscillationV2Holder(HolderDeviceOscillationV2Binding var1, boolean var2, Function1 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOscillationSwitchListener");
      super(var1);
      this.isInSchedule = var2;
      this.onOscillationSwitchListener = var3;
      this.onOpenOscillationListener = var4;
      var1.switchBtn.setOnCheckedChangeListener(new DeviceOscillationV2Holder$$ExternalSyntheticLambda0(this));
      View var6 = var1.spacer1;
      Intrinsics.checkNotNullExpressionValue(var6, "spacer1");
      ViewExtensionsKt.show(var6, var2 ^ true);
      ConstraintLayout var7 = var1.contentOscillationFanView;
      Intrinsics.checkNotNullExpressionValue(var7, "contentOscillationFanView");
      ViewExtensionsKt.show((View)var7, var2 ^ true);
      MaterialButton var8 = var1.btnSettings;
      Intrinsics.checkNotNullExpressionValue(var8, "btnSettings");
      ViewExtensionsKt.show((View)var8, var2 ^ true);
      if (var2) {
         var1.contentContainer.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
         int var5 = this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.device_details_humidifier_margin_horizontal);
         ConstraintLayout var9 = var1.contentTitle;
         Intrinsics.checkNotNullExpressionValue(var9, "contentTitle");
         View var10 = (View)var9;
         var10.setPadding(var5, var10.getPaddingTop(), var5, var10.getPaddingBottom());
      }

      var1.btnSettings.setOnClickListener(new DeviceOscillationV2Holder$$ExternalSyntheticLambda1(this));
   }

   // $FF: synthetic method
   public DeviceOscillationV2Holder(HolderDeviceOscillationV2Binding var1, boolean var2, Function1 var3, Function0 var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var2 = false;
      }

      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private static final void _init_$lambda$0(DeviceOscillationV2Holder var0, CompoundButton var1, boolean var2) {
      var0.onOscillationSwitchListener.invoke(var2);
   }

   private static final void _init_$lambda$1(DeviceOscillationV2Holder var0, View var1) {
      Function0 var2 = var0.onOpenOscillationListener;
      if (var2 != null) {
         var2.invoke();
      }

   }

   private final void disableSettings(boolean var1, boolean var2) {
      ((HolderDeviceOscillationV2Binding)this.getBinding()).switchBtn.setEnabled(var1 ^ true);
      MaterialButton var7 = ((HolderDeviceOscillationV2Binding)this.getBinding()).btnSettings;
      boolean var6 = false;
      boolean var5;
      if (var1 && !var2) {
         var5 = false;
      } else {
         var5 = true;
      }

      label30: {
         var7.setEnabled(var5);
         var9 = ((HolderDeviceOscillationV2Binding)this.getBinding()).fanView;
         if (var1) {
            var5 = var6;
            if (!var2) {
               break label30;
            }
         }

         var5 = true;
      }

      var9.setEnabled(var5);
      int var4 = this.itemView.getContext().getColor(R.color.colorPrimaryText);
      int var3;
      if (var1) {
         var3 = this.itemView.getContext().getColor(R.color.surface_dark_55);
      } else {
         var3 = var4;
      }

      if (var2) {
         ((HolderDeviceOscillationV2Binding)this.getBinding()).direction.setTextColor(var4);
      } else {
         ((HolderDeviceOscillationV2Binding)this.getBinding()).direction.setTextColor(var3);
      }

      ((HolderDeviceOscillationV2Binding)this.getBinding()).angle.setTextColor(var3);
      ((HolderDeviceOscillationV2Binding)this.getBinding()).speed.setTextColor(var3);
      ((HolderDeviceOscillationV2Binding)this.getBinding()).title.setTextColor(var3);
      if (var1) {
         ((HolderDeviceOscillationV2Binding)this.getBinding()).leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
      } else {
         ((HolderDeviceOscillationV2Binding)this.getBinding()).leadingIcon.setImageTintList((ColorStateList)null);
      }
   }

   private final void updateBackground(boolean var1) {
      LinearLayout var3 = ((HolderDeviceOscillationV2Binding)this.getBinding()).getRoot();
      Drawable var2;
      if (var1) {
         var2 = (Drawable)(new ColorDrawable(this.getColor(R.color.surface_dark_5)));
      } else {
         var2 = null;
      }

      var3.setBackground(var2);
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasOscillation) {
         boolean var5 = false;
         if (!var2 && var1.isOnline() && !DeviceKt.isStandByOn(var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         HolderDeviceOscillationV2Binding var10 = (HolderDeviceOscillationV2Binding)this.getBinding();
         SwitchCompat var11 = var10.switchBtn;
         HasOscillation var9 = (HasOscillation)var1;
         var11.setCheckedSilence(var9.isOscillationEnabled());
         var10.fanView.animateFanAngles(var9.getOscillationAngle(), var9.oscillationDirection());
         if (var1 instanceof HasCombo3in1MainMode) {
            boolean var4;
            label112: {
               if (!((HasMainMode)var1).isInMainMode(MainMode.HEAT) || !var1.isUsDevice()) {
                  HasCombo3in1MainMode var18 = (HasCombo3in1MainMode)var1;
                  if ((!var18.isInSubMode(ApSubMode.FAN) || var18.currentFanSpeed() != 0) && !var18.isInSubMode(ApSubMode.ECO)) {
                     var4 = 0;
                     break label112;
                  }
               }

               var4 = 1;
            }

            boolean var8 = ((HasCombo3in1MainMode)var1).isInSubMode(ApSubMode.ECO);
            boolean var6;
            if (!var4 && !var2) {
               var6 = false;
            } else {
               var6 = true;
            }

            boolean var7;
            if (var8 && !var2) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.disableSettings(var6, var7);
            int var3 = var5;
            if (!var2) {
               label107: {
                  if (var4) {
                     var3 = var5;
                     if (!var8) {
                        break label107;
                     }
                  }

                  var3 = 1;
               }
            }

            OscillationDirection var12 = var9.oscillationDirection();
            var4 = DeviceOscillationV2Holder.WhenMappings.$EnumSwitchMapping$0[var12.ordinal()];
            if (var4 != 1) {
               if (var4 != 2) {
                  if (var4 != 3) {
                     throw new NoWhenBranchMatchedException();
                  }

                  if (var3) {
                     var4 = R.drawable.ic_arrow_right_on;
                  } else {
                     var4 = R.drawable.ic_arrow_right_disable;
                  }

                  var3 = R.string.oscillation_direction_right;
               } else {
                  if (var3) {
                     var4 = R.drawable.ic_arrow_left_on;
                  } else {
                     var4 = R.drawable.ic_arrow_left_disable;
                  }

                  var3 = R.string.oscillation_direction_left;
               }
            } else {
               if (var3) {
                  var4 = R.drawable.ic_arrow_straight_on;
               } else {
                  var4 = R.drawable.ic_arrow_straight_disable;
               }

               var3 = R.string.oscillation_direction_straight;
            }

            var10.angleDirection.setImageResource(var4);
            var10.direction.setText(var3);
            this.updateBackground(var2);
         }

         TextView var19 = var10.angle;
         StringBuilder var13 = new StringBuilder();
         var13.append(var9.getOscillationAngle());
         var13.append('°');
         var19.setText((CharSequence)var13.toString());
         var10.speed.setText((CharSequence)String.valueOf(var9.oscillationFanSpeed().getDisplayValue()));
      }
   }

   public final void update(boolean var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      Intrinsics.checkNotNullParameter(var2, "mode");
      ((HolderDeviceOscillationV2Binding)this.getBinding()).switchBtn.setCheckedSilence(var1);
      DeviceCreateEditScheduleViewModel.PurifierMode var4 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
      boolean var3 = true;
      if (var2 != var4 && var2 != DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
         var1 = false;
      } else {
         var1 = true;
      }

      this.disableSettings(var1, false);
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         var1 = var3;
      } else {
         var1 = false;
      }

      this.updateBackground(var1);
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceOscillationV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceOscillationV2Holder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOscillationSwitchListener", "Lkotlin/Function1;", "", "onOpenOscillationListener", "Lkotlin/Function0;", "devicedetails_otherRelease"},
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
      public static DeviceOscillationV2Holder newInstance$default(Companion var0, ViewGroup var1, boolean var2, Function1 var3, Function0 var4, int var5, Object var6) {
         if ((var5 & 2) != 0) {
            var2 = false;
         }

         if ((var5 & 8) != 0) {
            var4 = null;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceOscillationV2Holder newInstance(ViewGroup var1, boolean var2, Function1 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOscillationSwitchListener");
         HolderDeviceOscillationV2Binding var5 = HolderDeviceOscillationV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         var5.fanView.setInAttribute(true);
         Intrinsics.checkNotNullExpressionValue(var5, "apply(...)");
         return new DeviceOscillationV2Holder(var5, var2, var3, var4);
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
