package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.databinding.HolderDeviceSensorCardBinding;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJE\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\b\u0001\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006%"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSensorCardBinding;", "isCelsius", "", "tintDark", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSensorCardBinding;ZZ)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSensorCardBinding;", "()Z", "setCelsius", "(Z)V", "getTintDark", "setTintDark", "update", "", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "sensorValue", "", "updateTime", "", "isStandByOn", "isOffline", "isSelected", "(Lcom/blueair/core/model/HasSensorData;Lcom/blueair/core/model/SensorType;Ljava/lang/Float;JZZZ)V", "getColor", "", "colorRes", "getString", "", "stringRes", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSensorCardHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceSensorCardBinding binding;
   private boolean isCelsius;
   private boolean tintDark;

   public DeviceSensorCardHolder(HolderDeviceSensorCardBinding var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      this.isCelsius = var2;
      this.tintDark = var3;
      ViewUtils var4 = ViewUtils.INSTANCE;
      ConstraintLayout var5 = var1.cardContainer;
      Intrinsics.checkNotNullExpressionValue(var5, "cardContainer");
      ViewUtils.setAccessibilityDelegate$default(var4, (View)var5, Reflection.getOrCreateKotlinClass(Button.class), (String)null, (Function2)null, 12, (Object)null);
   }

   // $FF: synthetic method
   public DeviceSensorCardHolder(HolderDeviceSensorCardBinding var1, boolean var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   private final int getColor(int var1) {
      return this.binding.getRoot().getContext().getColor(var1);
   }

   private final String getString(int var1) {
      String var2 = this.binding.getRoot().getContext().getString(var1);
      Intrinsics.checkNotNullExpressionValue(var2, "getString(...)");
      return var2;
   }

   public final HolderDeviceSensorCardBinding getBinding() {
      return this.binding;
   }

   public final boolean getTintDark() {
      return this.tintDark;
   }

   public final boolean isCelsius() {
      return this.isCelsius;
   }

   public final void setCelsius(boolean var1) {
      this.isCelsius = var1;
   }

   public final void setTintDark(boolean var1) {
      this.tintDark = var1;
   }

   public final void update(HasSensorData var1, SensorType var2, Float var3, long var4, boolean var6, boolean var7, boolean var8) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "sensorType");
      HolderDeviceSensorCardBinding var14 = this.binding;
      var14.cardContainer.setBackgroundResource(R.drawable.rounded_rectangle_white90_r16);
      if (this.tintDark) {
         var14.cardContainer.setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.white_15)));
      } else {
         var14.cardContainer.setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.powder_blue)));
      }

      ImageView var13 = var14.sensorIcon;
      int var11;
      switch (DeviceSensorCardHolder.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()]) {
         case 1:
            var11 = R.drawable.ic_pm1;
            break;
         case 2:
            var11 = R.drawable.ic_pm25;
            break;
         case 3:
            var11 = R.drawable.ic_pm10;
            break;
         case 4:
            var11 = R.drawable.ic_hum;
            break;
         case 5:
            var11 = R.drawable.ic_tmp;
            break;
         case 6:
            var11 = R.drawable.ic_tvoc;
            break;
         case 7:
            var11 = R.drawable.ic_hcho;
            break;
         default:
            var11 = R.drawable.ic_pm25;
      }

      var13.setImageResource(var11);
      var14.sensorLabel.setText(GraphUiUtils.INSTANCE.getSensorName(var2));
      int var12;
      String var15;
      Integer var20;
      if (var7) {
         var20 = GraphUiUtils.INSTANCE.getSeverityDot6Null();
         var15 = this.getString(R.string.offline_label);
         var11 = R.color.surface_dark_55;
         var12 = R.color.surface_dark_55;
      } else if (var6) {
         var20 = GraphUiUtils.INSTANCE.getSeverityDot6Null();
         var11 = R.color.surface_dark_65;
         var12 = R.color.colorPrimaryText;
         var15 = "-";
      } else {
         if (var3 != null && System.currentTimeMillis() - var4 < 20000L) {
            label84: {
               var11 = DeviceSensorCardHolder.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
               if (var11 != 4) {
                  if (var11 != 5) {
                     var11 = IndoorAirRatingRanges.Companion.instance(var1).getRangePosition(var3, var2);
                     Integer var17 = (Integer)CollectionsKt.getOrNull(GraphUiUtils.INSTANCE.getSeverityDots6(), var11);
                     if (var2 == SensorType.HCHO) {
                        DecimalFormat var27 = new DecimalFormat("0.00");
                        var27.setRoundingMode(RoundingMode.DOWN);
                        String var28 = var27.format((double)var3 / (double)10000);
                        Intrinsics.checkNotNull(var28);
                        var20 = var17;
                        var15 = var28;
                     } else {
                        String var29 = String.valueOf(MathKt.roundToInt(var3));
                        var20 = var17;
                        var15 = var29;
                     }
                     break label84;
                  }

                  float var10;
                  if (this.isCelsius) {
                     var10 = var3;
                  } else {
                     var10 = DeviceData.Companion.convertCelsiusToFahrenheit(var3);
                  }

                  var11 = MathKt.roundToInt(var10);
                  StringBuilder var16 = new StringBuilder();
                  var16.append(var11);
                  var16.append('°');
                  char var9;
                  if (this.isCelsius) {
                     var9 = 'C';
                  } else {
                     var9 = 'F';
                  }

                  var16.append(var9);
                  var15 = var16.toString();
               } else {
                  StringBuilder var18 = new StringBuilder();
                  var18.append(MathKt.roundToInt(var3));
                  var18.append('%');
                  var15 = var18.toString();
               }

               var20 = null;
            }
         } else {
            var20 = GraphUiUtils.INSTANCE.getSeverityDot6Null();
            var15 = this.getString(R.string.label_reading);
         }

         var11 = R.color.surface_dark_65;
         var12 = R.color.colorPrimaryText;
      }

      if (var20 != null && !SetsKt.setOf(new SensorType[]{SensorType.HUM, SensorType.TMP}).contains(var2)) {
         var13 = var14.aqiIcon;
         Intrinsics.checkNotNullExpressionValue(var13, "aqiIcon");
         ViewExtensionsKt.show((View)var13, true);
         var14.aqiIcon.setImageResource(var20);
      } else {
         ImageView var21 = var14.aqiIcon;
         Intrinsics.checkNotNullExpressionValue(var21, "aqiIcon");
         ViewExtensionsKt.show((View)var21, false);
      }

      var14.aqiValue.setText((CharSequence)var15);
      var14.sensorLabel.setTextColor(this.getColor(var11));
      var14.aqiValue.setTextColor(this.getColor(var12));
      if (var8 || this.tintDark) {
         if (var8) {
            var14.cardContainer.setBackgroundResource(R.drawable.rounded_rectangle_primary_r16);
            var14.cardContainer.setBackgroundTintList((ColorStateList)null);
         }

         ImageView var19 = var14.sensorIcon;
         switch (DeviceSensorCardHolder.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()]) {
            case 1:
               var11 = R.drawable.ic_pm1_selected;
               break;
            case 2:
               var11 = R.drawable.ic_pm25_selected;
               break;
            case 3:
               var11 = R.drawable.ic_pm10_selected;
               break;
            case 4:
               var11 = R.drawable.ic_hum_selected;
               break;
            case 5:
               var11 = R.drawable.ic_tmp_selected;
               break;
            case 6:
               var11 = R.drawable.ic_tvoc_selected;
               break;
            case 7:
               var11 = R.drawable.ic_hcho_selected;
               break;
            default:
               var11 = R.drawable.ic_pm25_selected;
         }

         var19.setImageResource(var11);
         var14.sensorLabel.setTextColor(this.getColor(R.color.white_65));
         var14.aqiValue.setTextColor(this.getColor(R.color.white));
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder;", "parentView", "Landroid/view/ViewGroup;", "isCelsius", "", "devicedetails_otherRelease"},
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

      public final DeviceSensorCardHolder newInstance(ViewGroup var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceSensorCardBinding var3 = HolderDeviceSensorCardBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceSensorCardHolder(var3, var2, false, 4, (DefaultConstructorMarker)null);
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
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.PM1.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
