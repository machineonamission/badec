package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceTargetTemperatureV2Binding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-BR\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0016J\u001e\u0010 \u001a\u00020\n2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\"\u001a\u00020\rH\u0002J \u0010 \u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u001c\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u0007H\u0002J\u0018\u0010+\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0007H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0017R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onTargetSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tmp", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureV2Binding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "temperatureDegree", "", "temperatureUnit", "startTemp", "", "endTemp", "inTouch", "isTempC", "update", "forceOffline", "tmpInCelsius", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "inHeatMode", "disabled", "active", "disablePanel", "showExpendSwitch", "hideProgressText", "refreshTempUnit", "isEcoMode", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTargetTemperatureV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Device device;
   private int endTemp;
   private boolean inTouch;
   private final boolean isInSchedule;
   private boolean isTempC;
   private final Function0 onOpenInfoListener;
   private final Function1 onTargetSetListener;
   private int startTemp;
   private final CharSequence temperatureDegree;
   private CharSequence temperatureUnit;

   public DeviceTargetTemperatureV2Holder(HolderDeviceTargetTemperatureV2Binding var1, Device var2, boolean var3, Function0 var4, Function1 var5) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var5, "onTargetSetListener");
      super(var1);
      this.device = var2;
      this.isInSchedule = var3;
      this.onOpenInfoListener = var4;
      this.onTargetSetListener = var5;
      CharSequence var6 = this.itemView.getContext().getText(R.string.temperature_degree);
      Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
      this.temperatureDegree = var6;
      var6 = this.itemView.getContext().getText(R.string.temperature_unit_c);
      Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
      this.temperatureUnit = var6;
      this.startTemp = 15;
      this.endTemp = 24;
      this.isTempC = true;
      Device var8 = this.device;
      if (var8 != null) {
         this.isTempC = DeviceKt.isCelsiusUnit(var8);
      }

      var1.ivInfo.setOnClickListener(new DeviceTargetTemperatureV2Holder$$ExternalSyntheticLambda0(this));
      var1.clickView.setOnClickListener(new DeviceTargetTemperatureV2Holder$$ExternalSyntheticLambda1(var1));
      var1.expendSwitch.setChecked(false);
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceTargetTemperatureV2Holder$$ExternalSyntheticLambda2(var1));
      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var1, this) {
         final HolderDeviceTargetTemperatureV2Binding $this_apply;
         final DeviceTargetTemperatureV2Holder this$0;

         {
            this.$this_apply = var1;
            this.this$0 = var2;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            TextView var5 = this.$this_apply.progressText;
            StringBuilder var4 = new StringBuilder();
            var4.append(var2);
            var4.append(this.this$0.temperatureDegree);
            var4.append(this.this$0.temperatureUnit);
            var5.setText((CharSequence)var4.toString());
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = true;
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = false;
            double var2;
            if (this.this$0.isTempC) {
               var2 = (double)var1.getProgress();
            } else {
               var2 = DeviceData.Companion.convertFahrenheitToCelsius((double)var1.getProgress());
            }

            this.this$0.onTargetSetListener.invoke(var2);
         }
      });
   }

   private final void disablePanel(boolean var1, boolean var2) {
      HolderDeviceTargetTemperatureV2Binding var3 = (HolderDeviceTargetTemperatureV2Binding)this.getBinding();
      var3.clickView.setEnabled(false);
      var3.expendSwitch.setChecked(true);
      SwitchCompat var4 = var3.expendSwitch;
      Intrinsics.checkNotNullExpressionValue(var4, "expendSwitch");
      ViewExtensionsKt.show((View)var4, var1);
      Group var5 = var3.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var5, "expendedContent");
      ViewExtensionsKt.show((View)var5, false);
      if (var2) {
         var3.progressText.setText((CharSequence)"");
      }

   }

   // $FF: synthetic method
   static void disablePanel$default(DeviceTargetTemperatureV2Holder var0, boolean var1, boolean var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = false;
      }

      if ((var3 & 2) != 0) {
         var2 = true;
      }

      var0.disablePanel(var1, var2);
   }

   static final void lambda$4$lambda$1(DeviceTargetTemperatureV2Holder var0, View var1) {
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type android.widget.ImageView");
      if (((ImageView)var1).getImageTintList() == null) {
         var0.onOpenInfoListener.invoke();
      }

   }

   static final void lambda$4$lambda$2(HolderDeviceTargetTemperatureV2Binding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   static final void lambda$4$lambda$3(HolderDeviceTargetTemperatureV2Binding var0, CompoundButton var1, boolean var2) {
      Group var3 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var3, "expendedContent");
      ViewExtensionsKt.show((View)var3, var2 ^ true);
   }

   private final void refreshTempUnit(Device var1, boolean var2) {
      byte var3;
      if (var2) {
         var3 = 24;
      } else {
         var3 = 37;
      }

      var2 = DeviceKt.isCelsiusUnit(var1);
      this.isTempC = var2;
      if (var2) {
         this.startTemp = 15;
         this.endTemp = var3;
         CharSequence var5 = this.itemView.getContext().getText(R.string.temperature_unit_c);
         Intrinsics.checkNotNullExpressionValue(var5, "getText(...)");
         this.temperatureUnit = var5;
      } else {
         this.startTemp = DeviceData.Companion.convertCelsiusToFahrenheit(15);
         this.endTemp = DeviceData.Companion.convertCelsiusToFahrenheit(var3);
         CharSequence var6 = this.itemView.getContext().getText(R.string.temperature_unit_f);
         Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
         this.temperatureUnit = var6;
      }

      AccessibleSeekBar var7 = ((HolderDeviceTargetTemperatureV2Binding)this.getBinding()).seekbar;
      var7.setMax(this.endTemp);
      if (VERSION.SDK_INT >= 26) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var7, this.startTemp);
      }

      TextView var8 = ((HolderDeviceTargetTemperatureV2Binding)this.getBinding()).tvProgress0;
      StringBuilder var4 = new StringBuilder();
      var4.append(this.startTemp);
      var4.append(this.temperatureDegree);
      var4.append(this.temperatureUnit);
      var8.setText((CharSequence)var4.toString());
      TextView var11 = ((HolderDeviceTargetTemperatureV2Binding)this.getBinding()).tvProgress100;
      StringBuilder var9 = new StringBuilder();
      var9.append(this.endTemp);
      var9.append(this.temperatureDegree);
      var9.append(this.temperatureUnit);
      var11.setText((CharSequence)var9.toString());
   }

   private final void update(double var1) {
      if (!this.isTempC) {
         var1 = DeviceData.Companion.convertCelsiusToFahrenheit(var1);
      }

      int var3 = RangesKt.coerceIn(MathKt.roundToInt(var1), this.startTemp, this.endTemp);
      ((HolderDeviceTargetTemperatureV2Binding)this.getBinding()).seekbar.setProgress(var3);
      TextView var5 = ((HolderDeviceTargetTemperatureV2Binding)this.getBinding()).progressText;
      StringBuilder var4 = new StringBuilder();
      var4.append(var3);
      var4.append(this.temperatureDegree);
      var4.append(this.temperatureUnit);
      var5.setText((CharSequence)var4.toString());
   }

   private final void update(boolean var1, boolean var2, boolean var3) {
      HolderDeviceTargetTemperatureV2Binding var4 = (HolderDeviceTargetTemperatureV2Binding)this.getBinding();
      if (var1) {
         var4.clickView.setEnabled(false);
         var4.expendSwitch.setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.fill_grey)));
         disablePanel$default(this, true, false, 2, (Object)null);
         var4.getRoot().setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_5)));
      } else {
         label27: {
            var4.getRoot().setBackgroundTintList((ColorStateList)null);
            var4.expendSwitch.setBackgroundTintList((ColorStateList)null);
            if (var3) {
               if (var2) {
                  var4.clickView.setEnabled(true);
                  SwitchCompat var5 = var4.expendSwitch;
                  Intrinsics.checkNotNullExpressionValue(var5, "expendSwitch");
                  ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
                  Group var6 = var4.expendedContent;
                  Intrinsics.checkNotNullExpressionValue(var6, "expendedContent");
                  ViewExtensionsKt.show((View)var6, var4.expendSwitch.isChecked() ^ true);
               } else {
                  disablePanel$default(this, false, false, 3, (Object)null);
               }

               Device var7 = this.device;
               if (var7 != null && var7.isUsDevice()) {
                  disablePanel$default(this, false, var2 ^ true, 1, (Object)null);
                  break label27;
               }
            } else {
               disablePanel$default(this, false, false, 3, (Object)null);
            }

            var4.leadingIcon.setImageTintList((ColorStateList)null);
            var4.ivInfo.setImageTintList((ColorStateList)null);
            var4.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            return;
         }
      }

      ColorStateList var8 = ColorStateList.valueOf(this.getColor(R.color.surface_dark_45));
      Intrinsics.checkNotNullExpressionValue(var8, "valueOf(...)");
      var4.leadingIcon.setImageTintList(var8);
      var4.ivInfo.setImageTintList(var8);
      var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
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

   public final void update(double var1, DeviceCreateEditScheduleViewModel.PurifierMode var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var3, "mode");
      Device var7 = this.device;
      boolean var6 = true;
      if (var7 != null) {
         boolean var5;
         if (var3 == DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.refreshTempUnit(var7, var5);
      }

      this.update(var1);
      boolean var8;
      if (var3 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         var8 = true;
      } else {
         var8 = false;
      }

      if (var3 != DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
         var6 = false;
      }

      this.update(var8, var6, var4);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.device = var1;
      if (!this.inTouch && var1 instanceof HasCombo3in1MainMode) {
         HasCombo3in1MainMode var7 = (HasCombo3in1MainMode)var1;
         this.refreshTempUnit(var1, var7.isInSubMode(ApSubMode.ECO));
         ApSubMode var6 = var7.currentSubMode();
         int var3 = DeviceTargetTemperatureV2Holder.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
         boolean var5 = true;
         if (var3 != 1) {
            if (var3 == 2) {
               this.update(var7.getHeatAutoTmp());
            }
         } else {
            this.update(var7.getHeatEcoTmp());
         }

         boolean var4 = var5;
         if (!var2) {
            var4 = var5;
            if (var1.isOnline()) {
               if (DeviceKt.isStandByOn(var1)) {
                  var4 = var5;
               } else {
                  var4 = false;
               }
            }
         }

         this.update(var4, var7.isInSubMode(ApSubMode.AUTO), var7.isInMainMode(MainMode.HEAT));
      }

   }

   @Metadata(
      d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e0\u0010¨\u0006\u0015"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onTargetSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tmp", "devicedetails_otherRelease"},
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

      public final DeviceTargetTemperatureV2Holder newInstance(ViewGroup var1, Device var2, boolean var3, Function0 var4, Function1 var5) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var5, "onTargetSetListener");
         HolderDeviceTargetTemperatureV2Binding var6 = HolderDeviceTargetTemperatureV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
         return new DeviceTargetTemperatureV2Holder(var6, var2, var3, var4, var5);
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
         int[] var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.ECO.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ApSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
