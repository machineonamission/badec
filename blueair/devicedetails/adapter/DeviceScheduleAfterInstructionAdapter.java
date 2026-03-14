package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.viewholder.DeviceScheduleBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceScheduleManualModeViewHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
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
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0016J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "onFanSpeedChanged", "Lkotlin/Function1;", "", "onBrightnessChanged", "<init>", "(Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "value", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "mode", "getMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "", "", "options", "setOptions", "(Ljava/util/List;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "reconfigureViews", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleAfterInstructionAdapter extends RecyclerView.Adapter {
   public static final int BRIGHTNESS_VIEW = 2;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int FAN_SPEED_VIEW = 1;
   private Object brightness;
   private Device device;
   private FanSpeedEnum fanSpeed;
   private DeviceCreateEditScheduleViewModel.PurifierMode mode;
   private final Function1 onBrightnessChanged;
   private final Function1 onFanSpeedChanged;
   private List options;

   // $FF: synthetic method
   public static Unit $r8$lambda$OKS0UIZFVDfXo2BH60HKQuT2KvU(DeviceScheduleAfterInstructionAdapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$radNNbN_M1DdfTRNCOWSVUD_Pk4(DeviceScheduleAfterInstructionAdapter var0, Object var1) {
      return onCreateViewHolder$lambda$1(var0, var1);
   }

   public DeviceScheduleAfterInstructionAdapter(FanSpeedEnum var1, Object var2, Function1 var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeed");
      Intrinsics.checkNotNullParameter(var2, "brightness");
      Intrinsics.checkNotNullParameter(var3, "onFanSpeedChanged");
      Intrinsics.checkNotNullParameter(var4, "onBrightnessChanged");
      super();
      this.fanSpeed = var1;
      this.brightness = var2;
      this.onFanSpeedChanged = var3;
      this.onBrightnessChanged = var4;
      this.mode = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
      this.options = CollectionsKt.emptyList();
   }

   private static final Unit onCreateViewHolder$lambda$0(DeviceScheduleAfterInstructionAdapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.fanSpeed = var1;
      var0.onFanSpeedChanged.invoke(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$1(DeviceScheduleAfterInstructionAdapter var0, Object var1) {
      Intrinsics.checkNotNullParameter(var1, "nuBrightness");
      var0.brightness = var1;
      var0.onBrightnessChanged.invoke(var1);
      return Unit.INSTANCE;
   }

   private final void reconfigureViews() {
      List var1 = (List)(new ArrayList());
      if (this.device instanceof HasFanSpeed) {
         var1.add(1);
      }

      if (this.device instanceof HasBrightness) {
         var1.add(2);
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

   public final DeviceCreateEditScheduleViewModel.PurifierMode getMode() {
      return this.mode;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof DeviceScheduleManualModeViewHolder) {
         Device var3 = this.device;
         if (var3 != null && var3 instanceof HasFanSpeed) {
            ((DeviceScheduleManualModeViewHolder)var1).bind((HasFanSpeed)var3, this.fanSpeed);
            return;
         }
      } else if (var1 instanceof DeviceScheduleBrightnessHolder) {
         Device var4 = this.device;
         if (var4 != null) {
            ((DeviceScheduleBrightnessHolder)var1).bind(var4, this.brightness);
         }
      }

   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      if (var2 != 1) {
         if (var2 == 2) {
            return DeviceScheduleBrightnessHolder.Companion.newInstance(var1, new DeviceScheduleAfterInstructionAdapter$$ExternalSyntheticLambda1(this));
         } else {
            throw new Exception("View not supported");
         }
      } else {
         return DeviceScheduleManualModeViewHolder.Companion.newInstance(var1, new DeviceScheduleAfterInstructionAdapter$$ExternalSyntheticLambda0(this));
      }
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         this.reconfigureViews();
      }

   }

   public final void setMode(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.mode = var1;
      this.reconfigureViews();
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleAfterInstructionAdapter$Companion;", "", "<init>", "()V", "FAN_SPEED_VIEW", "", "BRIGHTNESS_VIEW", "devicedetails_otherRelease"},
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
