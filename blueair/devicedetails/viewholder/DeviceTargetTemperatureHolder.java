package com.blueair.devicedetails.viewholder;

import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceTargetTemperatureBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onTemperatureSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "temperature", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceTargetTemperatureBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "value", "isEcoMode", "setEcoMode", "(Z)V", "temperatureDegree", "", "temperatureUnit", "startTemp", "", "endTemp", "isTempC", "enableView", "enable", "refreshTempUnit", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTargetTemperatureHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceTargetTemperatureBinding binding;
   private final Device device;
   private int endTemp;
   private boolean isEcoMode;
   private final boolean isInSchedule;
   private boolean isTempC;
   private final Function1 onTemperatureSetListener;
   private int startTemp;
   private final CharSequence temperatureDegree;
   private CharSequence temperatureUnit;

   public DeviceTargetTemperatureHolder(HolderDeviceTargetTemperatureBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onTemperatureSetListener");
      FrameLayout var7 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      super((View)var7);
      this.binding = var1;
      this.device = var2;
      this.isInSchedule = var3;
      this.onTemperatureSetListener = var4;
      boolean var6;
      if (var2 instanceof HasCombo3in1MainMode && ((HasCombo3in1MainMode)var2).isInSubMode(ApSubMode.ECO)) {
         var6 = true;
      } else {
         var6 = false;
      }

      this.isEcoMode = var6;
      CharSequence var11 = this.itemView.getContext().getText(R.string.temperature_degree);
      Intrinsics.checkNotNullExpressionValue(var11, "getText(...)");
      this.temperatureDegree = var11;
      CharSequence var12 = this.itemView.getContext().getText(R.string.temperature_unit_c);
      Intrinsics.checkNotNullExpressionValue(var12, "getText(...)");
      this.temperatureUnit = var12;
      this.startTemp = 15;
      this.endTemp = 24;
      this.isTempC = true;
      if (var2 != null) {
         this.refreshTempUnit(var2);
      }

      AccessibleSeekBar var8 = var1.seekbar;
      var8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceTargetTemperatureHolder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            TextView var5 = this.this$0.getBinding().progressText;
            StringBuilder var4 = new StringBuilder();
            var4.append(var2);
            var4.append(this.this$0.temperatureDegree);
            var4.append(this.this$0.temperatureUnit);
            var5.setText((CharSequence)var4.toString());
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            double var2;
            if (this.this$0.isTempC) {
               var2 = (double)var1.getProgress();
            } else {
               var2 = DeviceData.Companion.convertFahrenheitToCelsius((double)var1.getProgress());
            }

            this.this$0.onTemperatureSetListener.invoke(var2);
         }
      });
      var8.setMax(this.endTemp);
      if (VERSION.SDK_INT >= 26) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var8, this.startTemp);
      }

      int var5;
      if (this.isEcoMode) {
         var5 = R.drawable.progressbar_slim_gradient_78;
      } else {
         var5 = R.drawable.progressbar_slim_gradient_32;
      }

      var8.setProgressDrawable(AppCompatResources.getDrawable(var8.getContext(), var5));
      TextView var9 = var1.startTemp;
      StringBuilder var13 = new StringBuilder();
      var13.append(this.startTemp);
      var13.append(var11);
      var13.append(this.temperatureUnit);
      var9.setText((CharSequence)var13.toString());
      TextView var14 = var1.endTemp;
      StringBuilder var10 = new StringBuilder();
      var10.append(this.endTemp);
      var10.append(var11);
      var10.append(this.temperatureUnit);
      var14.setText((CharSequence)var10.toString());
      if (var3) {
         var1.contentContainer.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
      }

   }

   // $FF: synthetic method
   public DeviceTargetTemperatureHolder(HolderDeviceTargetTemperatureBinding var1, Device var2, boolean var3, Function1 var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3, var4);
   }

   private final void enableView(boolean var1) {
      AccessibleSeekBar var2 = this.binding.seekbar;
      Intrinsics.checkNotNullExpressionValue(var2, "seekbar");
      ViewExtensionsKt.show((View)var2, var1);
      TextView var3 = this.binding.startTemp;
      Intrinsics.checkNotNullExpressionValue(var3, "startTemp");
      ViewExtensionsKt.show((View)var3, var1);
      var3 = this.binding.endTemp;
      Intrinsics.checkNotNullExpressionValue(var3, "endTemp");
      ViewExtensionsKt.show((View)var3, var1);
   }

   private final void refreshTempUnit(Device var1) {
      byte var2;
      if (this.isEcoMode) {
         var2 = 24;
      } else {
         var2 = 37;
      }

      boolean var3 = DeviceKt.isCelsiusUnit(var1);
      this.isTempC = var3;
      if (var3) {
         this.startTemp = 15;
         this.endTemp = var2;
         CharSequence var5 = this.itemView.getContext().getText(R.string.temperature_unit_c);
         Intrinsics.checkNotNullExpressionValue(var5, "getText(...)");
         this.temperatureUnit = var5;
      } else {
         this.startTemp = DeviceData.Companion.convertCelsiusToFahrenheit(15);
         this.endTemp = DeviceData.Companion.convertCelsiusToFahrenheit(var2);
         CharSequence var6 = this.itemView.getContext().getText(R.string.temperature_unit_f);
         Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
         this.temperatureUnit = var6;
      }

      AccessibleSeekBar var7 = this.binding.seekbar;
      var7.setMax(this.endTemp);
      if (VERSION.SDK_INT >= 26) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var7, this.startTemp);
      }

      TextView var4 = this.binding.startTemp;
      StringBuilder var8 = new StringBuilder();
      var8.append(this.startTemp);
      var8.append(this.temperatureDegree);
      var8.append(this.temperatureUnit);
      var4.setText((CharSequence)var8.toString());
      var4 = this.binding.endTemp;
      var8 = new StringBuilder();
      var8.append(this.endTemp);
      var8.append(this.temperatureDegree);
      var8.append(this.temperatureUnit);
      var4.setText((CharSequence)var8.toString());
   }

   private final void setEcoMode(boolean var1) {
      this.isEcoMode = var1;
      byte var2;
      if (var1) {
         var2 = 24;
      } else {
         var2 = 37;
      }

      this.endTemp = var2;
   }

   public final HolderDeviceTargetTemperatureBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void update(double var1) {
      int var3 = RangesKt.coerceIn(MathKt.roundToInt(var1), this.startTemp, this.endTemp);
      this.binding.seekbar.setProgress(var3);
      TextView var4 = this.binding.progressText;
      StringBuilder var5 = new StringBuilder();
      var5.append(var3);
      var5.append(this.temperatureDegree);
      var5.append(this.temperatureUnit);
      var4.setText((CharSequence)var5.toString());
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasCombo3in1MainMode) {
         this.refreshTempUnit(var1);
         boolean var5 = DeviceKt.isCelsiusUnit(var1);
         HasCombo3in1MainMode var7 = (HasCombo3in1MainMode)var1;
         ApSubMode var6 = var7.currentSubMode();
         int var4 = DeviceTargetTemperatureHolder.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
         if (var4 != 1) {
            if (var4 == 2) {
               double var2;
               if (var5) {
                  var2 = var7.getHeatAutoTmp();
               } else {
                  var2 = DeviceData.Companion.convertCelsiusToFahrenheit(var7.getHeatAutoTmp());
               }

               this.update(var2);
            }
         } else {
            double var8;
            if (var5) {
               var8 = var7.getHeatEcoTmp();
            } else {
               var8 = DeviceData.Companion.convertCelsiusToFahrenheit(var7.getHeatEcoTmp());
            }

            this.update(var8);
         }

         if (var1.isUsDevice() && var7.isInMainMode(MainMode.HEAT)) {
            var4 = 1;
         } else {
            var4 = 0;
         }

         this.enableView((boolean)(var4 ^ true));
      }

   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTargetTemperatureHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onTemperatureSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "temperature", "", "devicedetails_otherRelease"},
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
      public static DeviceTargetTemperatureHolder newInstance$default(Companion var0, ViewGroup var1, Device var2, boolean var3, Function1 var4, int var5, Object var6) {
         if ((var5 & 4) != 0) {
            var3 = false;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceTargetTemperatureHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onTemperatureSetListener");
         HolderDeviceTargetTemperatureBinding var5 = HolderDeviceTargetTemperatureBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceTargetTemperatureHolder(var5, var2, var3, var4);
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
