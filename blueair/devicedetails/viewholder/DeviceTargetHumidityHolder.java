package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.databinding.HolderDeviceTargetHumidityBinding;
import com.blueair.devicedetails.util.DeviceControlUtils;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%Bf\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0016J\u001e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0018R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetHumidityHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceTargetHumidityBinding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onShowHintListener", "Lkotlin/Function1;", "onTargetSetListener", "", "Lkotlin/ParameterName;", "name", "autoRh", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTargetHumidityBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "inTouch", "minHum", "getMinHum", "()I", "update", "autorh", "disabled", "active", "forceOffline", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "canActive", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTargetHumidityHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Device device;
   private boolean inTouch;
   private final boolean isInSchedule;
   private final Function0 onOpenInfoListener;
   private final Function1 onShowHintListener;
   private final Function1 onTargetSetListener;

   public DeviceTargetHumidityHolder(HolderDeviceTargetHumidityBinding var1, Device var2, boolean var3, Function0 var4, Function1 var5, Function1 var6) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var5, "onShowHintListener");
      Intrinsics.checkNotNullParameter(var6, "onTargetSetListener");
      super(var1);
      this.device = var2;
      this.isInSchedule = var3;
      this.onOpenInfoListener = var4;
      this.onShowHintListener = var5;
      this.onTargetSetListener = var6;
      var1.ivInfo.setOnClickListener(new DeviceTargetHumidityHolder$$ExternalSyntheticLambda0(this));
      var1.clickView.setOnClickListener(new DeviceTargetHumidityHolder$$ExternalSyntheticLambda1(var1));
      var1.expendSwitch.setChecked(false);
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceTargetHumidityHolder$$ExternalSyntheticLambda2(var1));
      TextView var7 = var1.tvProgress0;
      StringBuilder var8 = new StringBuilder();
      var8.append(this.getMinHum());
      var8.append('%');
      var7.setText((CharSequence)var8.toString());
      if (VERSION.SDK_INT >= 26) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var1.seekbar, this.getMinHum());
      }

      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var1, this) {
         final HolderDeviceTargetHumidityBinding $this_apply;
         final DeviceTargetHumidityHolder this$0;

         {
            this.$this_apply = var1;
            this.this$0 = var2;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            TextView var4 = this.$this_apply.progressText;
            StringBuilder var5 = new StringBuilder();
            var5.append(var2);
            var5.append('%');
            var4.setText((CharSequence)var5.toString());
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = true;
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = false;
            this.this$0.onTargetSetListener.invoke(var1.getProgress());
         }
      });
   }

   private final int getMinHum() {
      return 30;
   }

   static final void lambda$3$lambda$0(DeviceTargetHumidityHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   static final void lambda$3$lambda$1(HolderDeviceTargetHumidityBinding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   static final void lambda$3$lambda$2(HolderDeviceTargetHumidityBinding var0, CompoundButton var1, boolean var2) {
      Group var3 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var3, "expendedContent");
      ViewExtensionsKt.show((View)var3, var2 ^ true);
   }

   private final void update(int var1) {
      var1 = RangesKt.coerceIn(var1, this.getMinHum(), 80);
      ((HolderDeviceTargetHumidityBinding)this.getBinding()).seekbar.setProgress(var1);
      TextView var2 = ((HolderDeviceTargetHumidityBinding)this.getBinding()).progressText;
      StringBuilder var3 = new StringBuilder();
      var3.append(var1);
      var3.append('%');
      var2.setText((CharSequence)var3.toString());
   }

   private final void update(boolean var1, boolean var2) {
      HolderDeviceTargetHumidityBinding var3 = (HolderDeviceTargetHumidityBinding)this.getBinding();
      Boolean var4 = false;
      if (var1) {
         var3.clickView.setEnabled(false);
         var3.expendSwitch.setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.fill_grey)));
         SwitchCompat var9 = var3.expendSwitch;
         Intrinsics.checkNotNullExpressionValue(var9, "expendSwitch");
         ViewExtensionsKt.show((View)var9, true);
         var3.expendSwitch.setChecked(true);
         Group var10 = var3.expendedContent;
         Intrinsics.checkNotNullExpressionValue(var10, "expendedContent");
         ViewExtensionsKt.show((View)var10, false);
         var3.getRoot().setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_5)));
         var3.leadingIcon.setImageResource(R.drawable.ic_hum_disabled);
         var3.title.setTextColor(this.getColor(R.color.surface_dark_55));
         var3.progressText.setText((CharSequence)"");
         this.onShowHintListener.invoke(var4);
      } else {
         var3.getRoot().setBackgroundTintList((ColorStateList)null);
         var3.expendSwitch.setBackgroundTintList((ColorStateList)null);
         var3.leadingIcon.setImageResource(R.drawable.ic_hum);
         var3.title.setTextColor(this.getColor(R.color.colorPrimaryText));
         if (var2) {
            var3.clickView.setEnabled(true);
            SwitchCompat var5 = var3.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var5, "expendSwitch");
            ViewExtensionsKt.show((View)var5, true);
            Group var8 = var3.expendedContent;
            Intrinsics.checkNotNullExpressionValue(var8, "expendedContent");
            ViewExtensionsKt.show((View)var8, var3.expendSwitch.isChecked() ^ true);
            this.onShowHintListener.invoke(var4);
         } else {
            var3.clickView.setEnabled(false);
            SwitchCompat var6 = var3.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var6, "expendSwitch");
            ViewExtensionsKt.show((View)var6, false);
            Group var7 = var3.expendedContent;
            Intrinsics.checkNotNullExpressionValue(var7, "expendedContent");
            ViewExtensionsKt.show((View)var7, false);
            var3.progressText.setText((CharSequence)"");
            this.onShowHintListener.invoke(true);
         }
      }
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void setDevice(Device var1) {
      this.device = var1;
   }

   public final void update(int var1, DeviceCreateEditScheduleViewModel.PurifierMode var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var2, "mode");
      this.update(var1);
      DeviceCreateEditScheduleViewModel.PurifierMode var6 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
      boolean var5 = true;
      boolean var4;
      if (var2 == var6) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO && var3) {
         var3 = var5;
      } else {
         var3 = false;
      }

      this.update(var4, var3);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.device = var1;
      if (!this.inTouch) {
         if (var1 instanceof HasAutoRh) {
            this.update(((HasAutoRh)var1).getAutoRh());
         }

         boolean var4 = false;
         boolean var3;
         if (!var2 && var1.isOnline() && !DeviceKt.isStandByOn(var1)) {
            var3 = false;
         } else {
            var3 = true;
         }

         label67: {
            if (var1 instanceof HasDehumidifierMainMode) {
               var1 = (HasDehumidifierMainMode)var1;
               var2 = var4;
               if (!var1.isInMainMode(MainMode.Dehumidification)) {
                  break label67;
               }

               var2 = var4;
               if (!var1.isInDehSubMode(DehSubMode.AUTO)) {
                  break label67;
               }
            } else if (var1 instanceof DeviceHumidifier20) {
               DeviceHumidifier20 var5 = (DeviceHumidifier20)var1;
               var2 = var4;
               if (var5.getWickdryOn()) {
                  break label67;
               }

               var2 = var4;
               if (var5.isInWaterLevel(WaterLevel.SHORTAGE)) {
                  break label67;
               }

               var2 = var4;
               if (!DeviceControlUtils.INSTANCE.checkAutoMode(var1)) {
                  break label67;
               }
            } else if (var1 instanceof HasHumMode) {
               var2 = var4;
               if (!((HasHumMode)var1).getHumMode()) {
                  break label67;
               }

               var2 = var4;
               if (!DeviceControlUtils.INSTANCE.checkAutoMode(var1)) {
                  break label67;
               }
            } else if (var1 instanceof DeviceCombo2in120) {
               var2 = var4;
               if (!DeviceKt.isHumidifyModeOn(var1)) {
                  break label67;
               }

               var1 = (DeviceCombo2in120)var1;
               var2 = var4;
               if (var1.isInWaterLevel(WaterLevel.SHORTAGE)) {
                  break label67;
               }

               var2 = var4;
               if (!var1.isInHumSubMode(HumSubMode.AUTO)) {
                  break label67;
               }
            } else {
               if (!(var1 instanceof DeviceHumidifier)) {
                  var2 = DeviceControlUtils.INSTANCE.checkAutoMode(var1);
                  break label67;
               }

               var2 = var4;
               if (!DeviceControlUtils.INSTANCE.checkAutoMode(var1)) {
                  break label67;
               }

               var1 = var1;
               if (Intrinsics.areEqual(var1.getHardware(), "hum_n")) {
                  var2 = var4;
                  if (var1.getWaterShortage()) {
                     break label67;
                  }
               }
            }

            var2 = true;
         }

         this.update(var3, var2);
      }
   }

   @Metadata(
      d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e0\u0010¨\u0006\u0016"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetHumidityHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTargetHumidityHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onShowHintListener", "Lkotlin/Function1;", "onTargetSetListener", "", "Lkotlin/ParameterName;", "name", "autoRh", "devicedetails_otherRelease"},
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

      public final DeviceTargetHumidityHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function0 var4, Function1 var5, Function1 var6) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var5, "onShowHintListener");
         Intrinsics.checkNotNullParameter(var6, "onTargetSetListener");
         HolderDeviceTargetHumidityBinding var7 = HolderDeviceTargetHumidityBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
         return new DeviceTargetHumidityHolder(var7, var2, var3, var4, var5, var6);
      }
   }
}
