package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.viewholder.DeviceScheduleBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleManualModeViewHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleTitleHeaderViewHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0018\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isCustom", "", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "onPurifierModeChanged", "Lkotlin/Function1;", "", "onFanSpeedChanged", "onBrightnessChanged", "<init>", "(ZLcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "()Z", "value", "", "", "options", "setOptions", "(Ljava/util/List;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "reconfigureViews", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleInstructionAdapter extends RecyclerView.Adapter {
   public static final int BRIGHTNESS_VIEW = 3;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int FAN_SPEED_VIEW = 2;
   public static final int MODE_BUTTONS_HEADER = 0;
   public static final int MODE_BUTTONS_VIEW = 1;
   private Object brightness;
   private Device device;
   private FanSpeedEnum fanSpeed;
   private final boolean isCustom;
   private DeviceCreateEditScheduleViewModel.PurifierMode mode;
   private final Function1 onBrightnessChanged;
   private final Function1 onFanSpeedChanged;
   private final Function1 onPurifierModeChanged;
   private List options;

   // $FF: synthetic method
   public static Unit $r8$lambda$AVjy_nHkzn_AMN2JJqT9YYFOgYE/* $FF was: $r8$lambda$AVjy_nHkzn-AMN2JJqT9YYFOgYE*/(DeviceScheduleInstructionAdapter var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      return onCreateViewHolder$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$TzNBa6u84dzNOZlaEW1WpRToqmc(DeviceScheduleInstructionAdapter var0, Object var1) {
      return onCreateViewHolder$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Y_wWM2J5LMJtYJ5A41B_MqBrtcw(DeviceScheduleInstructionAdapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$1(var0, var1);
   }

   public DeviceScheduleInstructionAdapter(boolean var1, DeviceCreateEditScheduleViewModel.PurifierMode var2, FanSpeedEnum var3, Object var4, Function1 var5, Function1 var6, Function1 var7) {
      Intrinsics.checkNotNullParameter(var2, "mode");
      Intrinsics.checkNotNullParameter(var3, "fanSpeed");
      Intrinsics.checkNotNullParameter(var4, "brightness");
      Intrinsics.checkNotNullParameter(var5, "onPurifierModeChanged");
      Intrinsics.checkNotNullParameter(var6, "onFanSpeedChanged");
      Intrinsics.checkNotNullParameter(var7, "onBrightnessChanged");
      super();
      this.isCustom = var1;
      this.mode = var2;
      this.fanSpeed = var3;
      this.brightness = var4;
      this.onPurifierModeChanged = var5;
      this.onFanSpeedChanged = var6;
      this.onBrightnessChanged = var7;
      this.options = CollectionsKt.emptyList();
   }

   private static final Unit onCreateViewHolder$lambda$0(DeviceScheduleInstructionAdapter var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.mode = var1;
      var0.reconfigureViews();
      var0.onPurifierModeChanged.invoke(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$1(DeviceScheduleInstructionAdapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.fanSpeed = var1;
      var0.onFanSpeedChanged.invoke(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$2(DeviceScheduleInstructionAdapter var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "nuBrightness");
      var0.brightness = var1;
      var0.onBrightnessChanged.invoke(var1);
      return Unit.INSTANCE;
   }

   private final void reconfigureViews() {
      List var1 = (List)(new ArrayList());
      if (this.device instanceof HasFanSpeed) {
         if (!this.isCustom) {
            var1.add(0);
         }

         var1.add(1);
      }

      if (this.device instanceof HasFanSpeed && this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
         var1.add(2);
      }

      if (this.device instanceof HasBrightness && this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT && this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY && this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION && this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
         var1.add(3);
      }

      this.setOptions(var1);
   }

   private final void setOptions(List var1) {
      this.options = var1;
      this.notifyDataSetChanged();
   }

   public final Device getDevice() {
      return this.device;
   }

   public int getItemCount() {
      return ((Collection)this.options).size();
   }

   public int getItemViewType(int var1) {
      return ((Number)this.options.get(var1)).intValue();
   }

   public final boolean isCustom() {
      return this.isCustom;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof DeviceScheduleTitleHeaderViewHolder) {
         ((DeviceScheduleTitleHeaderViewHolder)var1).bind();
      } else {
         if (var1 instanceof DeviceScheduleModeButtonsHolder) {
            Device var3 = this.device;
            if (var3 != null) {
               ((DeviceScheduleModeButtonsHolder)var1).bind(var3, this.mode);
               return;
            }
         } else if (var1 instanceof DeviceScheduleManualModeViewHolder) {
            Device var4 = this.device;
            if (var4 != null && var4 instanceof HasFanSpeed) {
               ((DeviceScheduleManualModeViewHolder)var1).bind((HasFanSpeed)var4, this.fanSpeed);
               return;
            }
         } else if (var1 instanceof DeviceScheduleBrightnessHolder) {
            Device var5 = this.device;
            if (var5 != null) {
               ((DeviceScheduleBrightnessHolder)var1).bind(var5, this.brightness);
            }
         }

      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 == 3) {
                  return DeviceScheduleBrightnessHolder.Companion.newInstance(var1, new DeviceScheduleInstructionAdapter$$ExternalSyntheticLambda2(this));
               } else {
                  throw new Exception("View not supported");
               }
            } else {
               return DeviceScheduleManualModeViewHolder.Companion.newInstance(var1, new DeviceScheduleInstructionAdapter$$ExternalSyntheticLambda1(this));
            }
         } else {
            DeviceScheduleModeButtonsHolder.Companion var5 = DeviceScheduleModeButtonsHolder.Companion;
            boolean var4 = this.isCustom;
            boolean var3 = false;
            if (!var4) {
               Device var6 = this.device;
               if (var6 != null) {
                  var3 = DeviceKt.supportDisinfection(var6);
               }
            }

            return var5.newInstance(var1, var3, new DeviceScheduleInstructionAdapter$$ExternalSyntheticLambda0(this));
         }
      } else {
         return DeviceScheduleTitleHeaderViewHolder.Companion.newInstance(var1, R.string.purifier_mode);
      }
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         this.reconfigureViews();
      }

   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleInstructionAdapter$Companion;", "", "<init>", "()V", "MODE_BUTTONS_HEADER", "", "MODE_BUTTONS_VIEW", "FAN_SPEED_VIEW", "BRIGHTNESS_VIEW", "devicedetails_otherRelease"},
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
   }
}
