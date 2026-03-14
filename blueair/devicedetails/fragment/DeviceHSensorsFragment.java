package com.blueair.devicedetails.fragment;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.os.BundleKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IOutdoorPollutants;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.devicedetails.databinding.FragmentDeviceHSensorsBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceHSensorsHasWickBinding;
import com.blueair.devicedetails.databinding.GraphTabItemBinding;
import com.blueair.devicedetails.dialog.DeviceHHumidityLevelsDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.GraphViewH;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.tabs.TabLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010\u001f\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0003J\u0018\u00103\u001a\u00020*2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001cH\u0002J\u0010\u00107\u001a\u0002002\u0006\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u00020*H\u0016J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u001cH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u0006="},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceHSensorsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "binding", "Landroidx/viewbinding/ViewBinding;", "groupAqi", "Landroidx/constraintlayout/widget/Group;", "graph", "Lcom/blueair/graph/view/GraphViewH;", "graphTabs", "Lcom/google/android/material/tabs/TabLayout;", "humidityData", "Landroid/widget/TextView;", "temperatureData", "particleData", "aqiData", "particleTitle", "contentTemp", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentHum", "sensorDataSubscribed", "", "previousGraphDataType", "Lcom/blueair/graph/view/GraphViewH$DataType;", "device", "Lcom/blueair/core/model/HasSensorData;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setGraphDataType", "dataType", "setupGraphTabs", "getSensorTitle", "", "sensorType", "Lcom/blueair/core/model/SensorType;", "updateTabItem", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "selected", "getColor", "id", "onResume", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHSensorsFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String KEY_DEVICE = "KEY_DEVICE";
   private static final String TAG = Reflection.getOrCreateKotlinClass(DeviceHSensorsFragment.class).getSimpleName();
   private TextView aqiData;
   private ViewBinding binding;
   private ConstraintLayout contentHum;
   private ConstraintLayout contentTemp;
   private HasSensorData device;
   private GraphViewH graph;
   private TabLayout graphTabs;
   private Group groupAqi;
   private TextView humidityData;
   private TextView particleData;
   private TextView particleTitle;
   private GraphViewH.DataType previousGraphDataType;
   private boolean sensorDataSubscribed;
   private TextView temperatureData;
   public DeviceSensorsViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$_KqelvzK7g0tGN3lhlJ_aX0enIY/* $FF was: $r8$lambda$-KqelvzK7g0tGN3lhlJ_aX0enIY*/(DeviceHSensorsFragment var0, List var1) {
      return onViewCreated$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$CLNlocWowKScIGZIk_zxMw_cYiE/* $FF was: $r8$lambda$CLNlocWowKScIGZIk-zxMw-cYiE*/(DeviceHSensorsFragment var0, boolean var1, AqiData var2) {
      return onViewCreated$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$CSDOxCLnZN__uXRlM5_Q8A9g7EM(DeviceHSensorsFragment var0, View var1) {
      setGraphDataType$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$E3jFusKavaG6JdSsFuiTSRWRvmA(DeviceHSensorsFragment var0, boolean var1, IndoorAirRatingRanges var2, Boolean var3) {
      return onViewCreated$lambda$6(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$IjkniyWFmvO4sF7LA0_Drq_GIfU/* $FF was: $r8$lambda$IjkniyWFmvO4sF7LA0_Drq-GIfU*/(DeviceHSensorsFragment var0, boolean var1, IndoorAirRatingRanges var2, DeviceData var3) {
      return onViewCreated$lambda$5(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$YNu2UU03PMNmOug0y1mtQtgo0iI(DeviceHSensorsFragment var0, SensorType var1, TabLayout.Tab var2, View var3) {
      setupGraphTabs$lambda$17$lambda$15$lambda$14(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$a5MmC_I27WY7czBwNFIbb__Cydo/* $FF was: $r8$lambda$a5MmC_I27WY7czBwNFIbb--Cydo*/(Object var0) {
      onViewCreated$lambda$9$lambda$7(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bRw1O8ace_IpMsV63ZNXb6NaJGA/* $FF was: $r8$lambda$bRw1O8ace-IpMsV63ZNXb6NaJGA*/(DeviceHSensorsFragment var0, List var1) {
      return onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gG6cVuG3I0f4HVCVou4JHZvf3Mk(DeviceHSensorsFragment var0, HasSensorData var1) {
      return onViewCreated$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$yV3XfdgEhHMwTBa8kI48JZSAfWM(Object var0) {
      onViewCreated$lambda$9$lambda$8(var0);
   }

   private final int getColor(int var1) {
      return this.requireContext().getColor(var1);
   }

   private final int getSensorTitle(HasSensorData var1, SensorType var2) {
      boolean var3 = var1 instanceof DevicePet20;
      switch (DeviceHSensorsFragment.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()]) {
         case 1:
            if (var3) {
               return R.string.pet_sensor_pm1;
            }

            return R.string.pm1_title_short;
         case 2:
            if (var3) {
               return R.string.pet_sensor_pm25;
            }

            return R.string.pm25_title;
         case 3:
            if (var3) {
               return R.string.pet_sensor_pm10;
            }

            return R.string.pm10_title_short;
         case 4:
            if (var3) {
               return R.string.pet_sensor_tvoc;
            }

            return R.string.voc_title_short;
         case 5:
            return R.string.hcho_title;
         case 6:
            return R.string.humidity_levels;
         case 7:
            return R.string.indoor_temperature;
         case 8:
            return R.string.fan_title;
         case 9:
         case 10:
            return 0;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   private static final Unit onViewCreated$lambda$10(DeviceHSensorsFragment var0, boolean var1, AqiData var2) {
      TextView var5 = var0.aqiData;
      OutdoorPollutants var4 = null;
      TextView var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("aqiData");
         var3 = null;
      }

      if (var2 != null) {
         var4 = var2.getPollutants();
      }

      onViewCreated$updateOutdoorAqiValueText(var1, var0, var3, var4, true);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$2(DeviceHSensorsFragment var0, List var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("liveSelectedSensorHistoricalData: ");
      var2.append(var1.size());
      var3.d(var2.toString(), new Object[0]);
      GraphViewH var5 = var0.graph;
      GraphViewH var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graph");
         var4 = null;
      }

      Intrinsics.checkNotNull(var1);
      var4.updateHistoricalData(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$3(DeviceHSensorsFragment var0, List var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("liveSelectedSensorRealTimeData: ");
      var3.append(var1.size());
      var2.d(var3.toString(), new Object[0]);
      GraphViewH var5 = var0.graph;
      GraphViewH var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graph");
         var4 = null;
      }

      Intrinsics.checkNotNull(var1);
      var4.updateRealTimeData(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$5(DeviceHSensorsFragment var0, boolean var1, IndoorAirRatingRanges var2, DeviceData var3) {
      onViewCreated$updateSensorCards(var0, var1, var2, var3);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$6(DeviceHSensorsFragment var0, boolean var1, IndoorAirRatingRanges var2, Boolean var3) {
      onViewCreated$updateSensorCards(var0, var1, var2, (DeviceData)var0.getViewModel().getLiveDeviceLatestData().getValue());
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$9(DeviceHSensorsFragment var0, HasSensorData var1) {
      Intrinsics.checkNotNull(var1);
      var0.device = var1;
      var0.getViewModel().updateDevice(var1);
      Device var3 = var1;
      boolean var2 = DeviceKt.isStandByOn(var3);
      GraphViewH.DataType var4;
      if (var1 instanceof DeviceHumidifier) {
         var4 = new GraphViewH.DataType.HUM(var1);
      } else if (var1 instanceof HasHumMode) {
         if (!var2 && ((HasHumMode)var1).getHumMode()) {
            var4 = new GraphViewH.DataType.HUM(var1);
         } else {
            var4 = new GraphViewH.DataType.AQI(var1, SensorType.PM25);
         }

         var4 = var4;
      } else if (var1 instanceof HasCombo3in1MainMode) {
         if (!var2 && ((HasMainMode)var1).isInMainMode(MainMode.HEAT)) {
            var4 = new GraphViewH.DataType.TMP(var1, DeviceKt.isCelsiusUnit(var3));
         } else {
            var4 = new GraphViewH.DataType.AQI(var1, SensorType.PM25);
         }
      } else {
         var4 = new GraphViewH.DataType.AQI(var1, SensorType.PM25);
      }

      if (!Intrinsics.areEqual(var0.previousGraphDataType, var4)) {
         var0.previousGraphDataType = var4;
         var0.setGraphDataType(var4);
         if (!var0.sensorDataSubscribed) {
            var0.sensorDataSubscribed = true;
            var0.getViewModel().getRealTimeDataListener().observe(var0.getViewLifecycleOwner(), new DeviceHSensorsFragment$$ExternalSyntheticLambda5());
            var0.getViewModel().getHistoricalDataListener().observe(var0.getViewLifecycleOwner(), new DeviceHSensorsFragment$$ExternalSyntheticLambda6());
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$9$lambda$7(Object var0) {
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("realTimeDataListener: thread = ");
      var2.append(Thread.currentThread());
      var1.d(var2.toString(), new Object[0]);
   }

   private static final void onViewCreated$lambda$9$lambda$8(Object var0) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("historicalDataListener: thread = ");
      var1.append(Thread.currentThread());
      var2.d(var1.toString(), new Object[0]);
   }

   private static final void onViewCreated$updateHumText(DeviceHSensorsFragment var0, Float var1) {
      TextView var2 = var0.humidityData;
      TextView var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("humidityData");
         var3 = null;
      }

      String var4;
      if (var1 == null) {
         var4 = "-";
      } else {
         StringBuilder var5 = new StringBuilder();
         var5.append(MathKt.roundToInt(var1));
         var5.append('%');
         var4 = var5.toString();
      }

      var3.setText((CharSequence)var4);
   }

   private static final void onViewCreated$updateOutdoorAqiValueText(boolean var0, DeviceHSensorsFragment var1, TextView var2, IOutdoorPollutants var3, boolean var4) {
      label33: {
         if (var3 != null) {
            Double var8 = var3.getCalculatedAQI();
            if (var8 != null) {
               var9 = (float)var8;
               break label33;
            }
         }

         var9 = null;
      }

      int var5;
      String var7;
      if (var9 == null) {
         if (!var4) {
            return;
         }

         var5 = GraphUiUtils.INSTANCE.getSeverityDot8Null();
         var7 = "-";
      } else {
         int var6 = RangesKt.coerceIn(OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition(var9, PollutantType.AQI.INSTANCE), 0, GraphUiUtils.INSTANCE.getSeverityDots8().size() - 1);
         var5 = ((Number)GraphUiUtils.INSTANCE.getSeverityDots8().get(var6)).intValue();
         if (var0) {
            var7 = var1.getResources().getStringArray(R.array.severity_strings)[var6];
            Intrinsics.checkNotNullExpressionValue(var7, "get(...)");
         } else {
            var7 = String.valueOf((int)var9);
         }
      }

      var2.setText((CharSequence)var7);
      int var10;
      if (var0) {
         var10 = var5;
      } else {
         var10 = 0;
      }

      if (var0) {
         var5 = 0;
      }

      TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(var2, var10, 0, var5, 0);
   }

   private static final void onViewCreated$updateParticleText(DeviceHSensorsFragment var0, boolean var1, IndoorAirRatingRanges var2, TextView var3, List var4, IndoorDatapoint var5) {
      IndoorAirRatingRanges.Companion var12 = IndoorAirRatingRanges.Companion;
      HasSensorData var11 = var0.device;
      Object var10 = null;
      HasSensorData var9 = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var9 = null;
      }

      SensorType var18 = (SensorType)var12.instance(var9).voteWorstRating(var4, var5).getFirst();
      Float var15;
      if (var5 != null) {
         var15 = var5.valueFor(var18);
      } else {
         var15 = null;
      }

      if (var15 == null) {
         var3.setText((CharSequence)"-");
         TextView var14 = var0.particleData;
         if (var14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleData");
            var14 = (TextView)var10;
         }

         int var16;
         if (var1) {
            var16 = GraphUiUtils.INSTANCE.getSeverityDot8Null();
         } else {
            var16 = 0;
         }

         int var17;
         if (var1) {
            var17 = 0;
         } else {
            var17 = GraphUiUtils.INSTANCE.getSeverityDot8Null();
         }

         TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(var14, var16, 0, var17, 0);
      } else {
         int var8 = RangesKt.coerceIn(var2.getRangePosition(var15, var18), 0, GraphUiUtils.INSTANCE.getSeverityDots8().size() - 1);
         int var7 = ((Number)GraphUiUtils.INSTANCE.getSeverityDots8().get(var8)).intValue();
         int var6;
         if (var1) {
            var6 = var7;
         } else {
            var6 = 0;
         }

         if (var1) {
            var7 = 0;
         }

         TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(var3, var6, 0, var7, 0);
         String var13;
         if (var1) {
            var13 = var0.getResources().getStringArray(R.array.severity_strings)[var8];
         } else {
            var13 = String.valueOf(MathKt.roundToInt(var15));
         }

         var3.setText((CharSequence)var13);
      }
   }

   private static final void onViewCreated$updateSensorCards(DeviceHSensorsFragment var0, boolean var1, IndoorAirRatingRanges var2, DeviceData var3) {
      HasSensorData var11;
      Object var12;
      label63: {
         var12 = null;
         var11 = null;
         if (var3 != null) {
            List var15 = var3.getRawDataPoints();
            if (var15 != null) {
               Iterator var14 = ((Iterable)var15).iterator();
               Object var17;
               if (!var14.hasNext()) {
                  var17 = null;
               } else {
                  var17 = var14.next();
                  if (var14.hasNext()) {
                     long var4 = ((IndoorDatapoint)var17).getTimeInSeconds();
                     Object var10 = var17;

                     do {
                        Object var13 = var14.next();
                        long var8 = ((IndoorDatapoint)var13).getTimeInSeconds();
                        var17 = var10;
                        long var6 = var4;
                        if (var4 < var8) {
                           var17 = var13;
                           var6 = var8;
                        }

                        var10 = var17;
                        var4 = var6;
                     } while(var14.hasNext());
                  }
               }

               var16 = (IndoorDatapoint)var17;
               break label63;
            }
         }

         var16 = null;
      }

      if (var16 != null && !Intrinsics.areEqual(var0.getViewModel().getDisableSensorCards().getValue(), true)) {
         HasSensorData var24 = var0.device;
         HasSensorData var21 = var24;
         if (var24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var21 = null;
         }

         if (!(var21 instanceof DevicePet20)) {
            onViewCreated$updateHumText(var0, var16.getHum());
            onViewCreated$updateTmpText(var0, var16.getTmp(), var0.getViewModel().isTempCelsius());
         }

         TextView var25 = var0.particleData;
         TextView var22 = var25;
         if (var25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleData");
            var22 = null;
         }

         IndoorAirRatingRanges.Companion var27 = IndoorAirRatingRanges.Companion;
         HasSensorData var26 = var0.device;
         if (var26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
         } else {
            var11 = var26;
         }

         onViewCreated$updateParticleText(var0, var1, var2, var22, var27.getAirRatingSensors(var11), var16);
      } else {
         onViewCreated$updateHumText(var0, (Float)null);
         onViewCreated$updateTmpText(var0, (Float)null, var0.getViewModel().isTempCelsius());
         TextView var19 = var0.particleData;
         TextView var18 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleData");
            var18 = null;
         }

         IndoorAirRatingRanges.Companion var23 = IndoorAirRatingRanges.Companion;
         HasSensorData var20 = var0.device;
         if (var20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var20 = (HasSensorData)var12;
         }

         onViewCreated$updateParticleText(var0, var1, var2, var18, var23.getAirRatingSensors(var20), (IndoorDatapoint)null);
      }
   }

   private static final void onViewCreated$updateTmpText(DeviceHSensorsFragment var0, Float var1, boolean var2) {
      Object var6 = null;
      Object var7 = null;
      if (var1 == null) {
         TextView var9 = var0.temperatureData;
         if (var9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("temperatureData");
            var9 = (TextView)var7;
         }

         var9.setText((CharSequence)"-");
      } else {
         float var4;
         if (var2) {
            var4 = var1;
         } else {
            var4 = DeviceData.Companion.convertCelsiusToFahrenheit(var1);
         }

         int var5 = MathKt.roundToInt(var4);
         TextView var8 = var0.temperatureData;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("temperatureData");
            var8 = (TextView)var6;
         }

         StringBuilder var10 = new StringBuilder();
         var10.append(var5);
         var10.append('°');
         char var3;
         if (var2) {
            var3 = 'C';
         } else {
            var3 = 'F';
         }

         var10.append(var3);
         var8.setText((CharSequence)var10.toString());
      }
   }

   private final void setGraphDataType(GraphViewH.DataType var1) {
      GraphViewH var5 = this.graph;
      Object var4 = null;
      GraphViewH var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graph");
         var3 = null;
      }

      label55: {
         var3.setDataType(var1);
         var19 = var1.toSensorType();
         DeviceSensorsViewModel.selectSensor$default(this.getViewModel(), var19, false, 2, (Object)null);
         if (var1 instanceof GraphViewH.DataType.HUM) {
            HasSensorData var12 = this.device;
            HasSensorData var6 = var12;
            if (var12 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var6 = null;
            }

            if (var6 instanceof DeviceHumidifier) {
               GraphViewH var14 = this.graph;
               GraphViewH var8 = var14;
               if (var14 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("graph");
                  var8 = null;
               }

               var8.setTitle(this.getString(R.string.humidity_levels), new DeviceHSensorsFragment$$ExternalSyntheticLambda4(this));
               break label55;
            }
         }

         var3 = this.graph;
         GraphViewH var7 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graph");
            var7 = null;
         }

         var7.setTitle((String)null, (View.OnClickListener)null);
      }

      TabLayout var15 = this.graphTabs;
      TabLayout var9 = var15;
      if (var15 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
         var9 = null;
      }

      if (((View)var9).getVisibility() == 0) {
         int var2 = this.getViewModel().getSupportedSensorTabs().indexOf(var19);
         if (var2 >= 0) {
            var15 = this.graphTabs;
            var9 = var15;
            if (var15 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
               var9 = null;
            }

            var15 = this.graphTabs;
            if (var15 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
               var15 = (TabLayout)var4;
            }

            var9.selectTab(var15.getTabAt(var2));
            return;
         }

         var15 = this.graphTabs;
         var9 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            var9 = null;
         }

         var9.selectTab((TabLayout.Tab)null);
      }

   }

   private static final void setGraphDataType$lambda$12(DeviceHSensorsFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceHHumidityLevelsDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceHHumidityLevelsDialogFragment") instanceof DeviceHHumidityLevelsDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)DeviceHHumidityLevelsDialogFragment.Companion.newInstance()).show(var2, "DeviceHHumidityLevelsDialogFragment");
      }

   }

   private final void setupGraphTabs() {
      TabLayout var5 = this.graphTabs;
      Object var4 = null;
      TabLayout var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
         var3 = null;
      }

      if (((View)var3).getVisibility() == 0) {
         Iterator var6 = ((Iterable)this.getViewModel().getSupportedSensorTabs()).iterator();

         for(int var1 = 0; var6.hasNext(); ++var1) {
            Object var11 = var6.next();
            if (var1 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            SensorType var7 = (SensorType)var11;
            var5 = this.graphTabs;
            TabLayout var12 = var5;
            if (var5 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
               var12 = null;
            }

            TabLayout.Tab var8 = var12.newTab();
            Intrinsics.checkNotNullExpressionValue(var8, "newTab(...)");
            GraphTabItemBinding var9 = GraphTabItemBinding.inflate(LayoutInflater.from(this.getContext()));
            TextView var10 = var9.text;
            HasSensorData var22 = this.device;
            HasSensorData var13 = var22;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var13 = null;
            }

            var10.setText(this.getSensorTitle(var13, var7));
            SensorType var14 = SensorType.HUM;
            boolean var2 = true;
            if (var7 == var14) {
               ImageButton var15 = var9.infoIcon;
               Intrinsics.checkNotNullExpressionValue(var15, "infoIcon");
               ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
               var9.infoIcon.setOnClickListener(new DeviceHSensorsFragment$$ExternalSyntheticLambda3(this, var7, var8));
            }

            ImageButton var16 = var9.infoIcon;
            Intrinsics.checkNotNullExpressionValue(var16, "infoIcon");
            View var17 = (View)var16;
            if (var7 != SensorType.HUM) {
               var2 = false;
            }

            ViewExtensionsKt.show(var17, var2);
            Intrinsics.checkNotNullExpressionValue(var9, "apply(...)");
            var8.setTag(var7);
            var8.setCustomView((View)var9.getRoot());
            var8.view.setBackground((Drawable)null);
            var8.view.setPadding(14, 0, 14, 0);
            TabLayout var23 = this.graphTabs;
            TabLayout var18 = var23;
            if (var23 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
               var18 = null;
            }

            var18.addTab(var8);
            ViewCompat.setAccessibilityDelegate((View)var8.view, new AccessibilityDelegateCompat(this, var1) {
               final int $index;
               final DeviceHSensorsFragment this$0;

               {
                  this.this$0 = var1;
                  this.$index = var2;
               }

               public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
                  Intrinsics.checkNotNullParameter(var1, "v");
                  Intrinsics.checkNotNullParameter(var2, "info");
                  super.onInitializeAccessibilityNodeInfo(var1, var2);
                  var2.setStateDescription((CharSequence)this.this$0.getString(R.string.device_details_sensor_type_state_description, new Object[]{this.$index + 1, this.this$0.getViewModel().getSupportedSensors().size()}));
               }
            });
         }

         var5 = this.graphTabs;
         var3 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            var3 = null;
         }

         var3.selectTab((TabLayout.Tab)null);
         var3 = this.graphTabs;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            var3 = (TabLayout)var4;
         }

         var3.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(this) {
            final DeviceHSensorsFragment this$0;

            {
               this.this$0 = var1;
            }

            public void onTabReselected(TabLayout.Tab var1) {
            }

            public void onTabSelected(TabLayout.Tab var1) {
               if (var1 != null) {
                  this.this$0.updateTabItem(var1, true);
                  Object var7 = var1.getTag();
                  boolean var2 = var7 instanceof SensorType;
                  Object var4 = null;
                  SensorType var8;
                  if (var2) {
                     var8 = (SensorType)var7;
                  } else {
                     var8 = null;
                  }

                  if (var8 != null) {
                     DeviceHSensorsFragment var6 = this.this$0;
                     GraphViewH.DataType var10;
                     switch (null.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()]) {
                        case 1:
                           HasSensorData var21 = var6.device;
                           HasSensorData var15 = var21;
                           if (var21 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var15 = null;
                           }

                           var10 = new GraphViewH.DataType.AQI(var15, SensorType.PM1);
                           break;
                        case 2:
                           HasSensorData var20 = var6.device;
                           HasSensorData var14 = var20;
                           if (var20 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var14 = null;
                           }

                           var10 = new GraphViewH.DataType.AQI(var14, SensorType.PM25);
                           break;
                        case 3:
                           HasSensorData var19 = var6.device;
                           HasSensorData var13 = var19;
                           if (var19 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var13 = null;
                           }

                           var10 = new GraphViewH.DataType.AQI(var13, SensorType.PM10);
                           break;
                        case 4:
                           HasSensorData var18 = var6.device;
                           HasSensorData var12 = var18;
                           if (var18 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var12 = null;
                           }

                           var10 = new GraphViewH.DataType.AQI(var12, SensorType.VOC);
                           break;
                        case 5:
                           HasSensorData var17 = var6.device;
                           HasSensorData var11 = var17;
                           if (var17 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var11 = null;
                           }

                           var10 = new GraphViewH.DataType.HUM(var11);
                           break;
                        case 6:
                           HasSensorData var3 = var6.device;
                           HasSensorData var9 = var3;
                           if (var3 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var9 = null;
                           }

                           HasSensorData var5 = var6.device;
                           var3 = var5;
                           if (var5 == null) {
                              Intrinsics.throwUninitializedPropertyAccessException("device");
                              var3 = null;
                           }

                           var10 = new GraphViewH.DataType.TMP(var9, DeviceKt.isCelsiusUnit(var3));
                           break;
                        default:
                           return;
                     }

                     GraphViewH var22 = var6.graph;
                     if (var22 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("graph");
                        var22 = (GraphViewH)var4;
                     }

                     if (!Intrinsics.areEqual(var10, var22.getDataType())) {
                        var6.setGraphDataType(var10);
                     }
                  }
               }

            }

            public void onTabUnselected(TabLayout.Tab var1) {
               if (var1 != null) {
                  this.this$0.updateTabItem(var1, false);
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
                  } catch (NoSuchFieldError var7) {
                  }

                  try {
                     var0[SensorType.PM25.ordinal()] = 2;
                  } catch (NoSuchFieldError var6) {
                  }

                  try {
                     var0[SensorType.PM10.ordinal()] = 3;
                  } catch (NoSuchFieldError var5) {
                  }

                  try {
                     var0[SensorType.VOC.ordinal()] = 4;
                  } catch (NoSuchFieldError var4) {
                  }

                  try {
                     var0[SensorType.HUM.ordinal()] = 5;
                  } catch (NoSuchFieldError var3) {
                  }

                  try {
                     var0[SensorType.TMP.ordinal()] = 6;
                  } catch (NoSuchFieldError var2) {
                  }

                  $EnumSwitchMapping$0 = var0;
               }
            }
         });
      }

   }

   private static final void setupGraphTabs$lambda$17$lambda$15$lambda$14(DeviceHSensorsFragment var0, SensorType var1, TabLayout.Tab var2, View var3) {
      TabLayout var4 = var0.graphTabs;
      Object var5 = null;
      TabLayout var9 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
         var9 = null;
      }

      TabLayout var6 = var0.graphTabs;
      var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
         var4 = null;
      }

      TabLayout.Tab var10 = var9.getTabAt(var4.getSelectedTabPosition());
      Object var11;
      if (var10 != null) {
         var11 = var10.getTag();
      } else {
         var11 = null;
      }

      if (var11 == var1) {
         FragmentManager var8 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var8, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceHHumidityLevelsDialogFragment", "getSimpleName(...)");
         if (!(var8.findFragmentByTag("DeviceHHumidityLevelsDialogFragment") instanceof DeviceHHumidityLevelsDialogFragment) && !var8.isStateSaved()) {
            ((DialogFragment)DeviceHHumidityLevelsDialogFragment.Companion.newInstance()).show(var8, "DeviceHHumidityLevelsDialogFragment");
         }

      } else {
         TabLayout var7 = var0.graphTabs;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
            var7 = (TabLayout)var5;
         }

         var7.selectTab(var2);
      }
   }

   private final void updateTabItem(TabLayout.Tab var1, boolean var2) {
      View var4 = var1.getCustomView();
      Intrinsics.checkNotNull(var4);
      GraphTabItemBinding var5 = GraphTabItemBinding.bind(var4);
      Intrinsics.checkNotNullExpressionValue(var5, "bind(...)");
      if (var2) {
         var5.text.setTextColor(-1);
         var5.infoIcon.setImageTintList(ColorStateList.valueOf(-1));
         var5.getRoot().setBackgroundResource(R.drawable.rounded_square_marienblue_r1000);
      } else {
         int var3 = this.getColor(R.color.colorPrimaryText);
         var5.text.setTextColor(var3);
         var5.infoIcon.setImageTintList((ColorStateList)null);
         var5.getRoot().setBackgroundResource(R.drawable.rounded_square_outlined_r1000);
      }
   }

   public DeviceSensorsViewModel getViewModel() {
      DeviceSensorsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setViewModel((DeviceSensorsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceSensorsViewModel.class)));
      var3 = this.getArguments();
      HasSensorData var44;
      if (var3 != null) {
         var44 = (HasSensorData)var3.getParcelable("KEY_DEVICE");
      } else {
         var44 = null;
      }

      if (var44 != null) {
         this.device = var44;
         HasSensorData var4 = var44;
         if (var44 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var4 = null;
         }

         ViewBinding var16;
         if (var4 instanceof HasWick) {
            FragmentDeviceHSensorsHasWickBinding var45 = FragmentDeviceHSensorsHasWickBinding.inflate(var1, var2, false);
            Group var5 = var45.groupAqi;
            Intrinsics.checkNotNullExpressionValue(var5, "groupAqi");
            this.groupAqi = var5;
            GraphViewH var6 = var45.deviceGraph;
            Intrinsics.checkNotNullExpressionValue(var6, "deviceGraph");
            this.graph = var6;
            TabLayout var7 = var45.graphTabs;
            Intrinsics.checkNotNullExpressionValue(var7, "graphTabs");
            this.graphTabs = var7;
            TextView var8 = var45.humidityData;
            Intrinsics.checkNotNullExpressionValue(var8, "humidityData");
            this.humidityData = var8;
            var8 = var45.temperatureData;
            Intrinsics.checkNotNullExpressionValue(var8, "temperatureData");
            this.temperatureData = var8;
            var8 = var45.particleData;
            Intrinsics.checkNotNullExpressionValue(var8, "particleData");
            this.particleData = var8;
            var8 = var45.aqiData;
            Intrinsics.checkNotNullExpressionValue(var8, "aqiData");
            this.aqiData = var8;
            var8 = var45.particleTitle;
            Intrinsics.checkNotNullExpressionValue(var8, "particleTitle");
            this.particleTitle = var8;
            ConstraintLayout var13 = var45.contentTemperature;
            Intrinsics.checkNotNullExpressionValue(var13, "contentTemperature");
            this.contentTemp = var13;
            var13 = var45.contentHumidity;
            Intrinsics.checkNotNullExpressionValue(var13, "contentHumidity");
            this.contentHum = var13;
            View var47 = var45.separator2;
            Intrinsics.checkNotNullExpressionValue(var47, "separator2");
            HasSensorData var26 = this.device;
            HasSensorData var15 = var26;
            if (var26 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var15 = null;
            }

            ViewExtensionsKt.show(var47, var15 instanceof DeviceHumidifier);
            Intrinsics.checkNotNull(var45);
            var16 = var45;
         } else {
            var16 = FragmentDeviceHSensorsBinding.inflate(var1, var2, false);
            Group var27 = var16.groupAqi;
            Intrinsics.checkNotNullExpressionValue(var27, "groupAqi");
            this.groupAqi = var27;
            GraphViewH var28 = var16.deviceGraph;
            Intrinsics.checkNotNullExpressionValue(var28, "deviceGraph");
            this.graph = var28;
            TabLayout var29 = var16.graphTabs;
            Intrinsics.checkNotNullExpressionValue(var29, "graphTabs");
            this.graphTabs = var29;
            TextView var30 = var16.humidityData;
            Intrinsics.checkNotNullExpressionValue(var30, "humidityData");
            this.humidityData = var30;
            var30 = var16.temperatureData;
            Intrinsics.checkNotNullExpressionValue(var30, "temperatureData");
            this.temperatureData = var30;
            var30 = var16.particleData;
            Intrinsics.checkNotNullExpressionValue(var30, "particleData");
            this.particleData = var30;
            var30 = var16.aqiData;
            Intrinsics.checkNotNullExpressionValue(var30, "aqiData");
            this.aqiData = var30;
            var30 = var16.particleTitle;
            Intrinsics.checkNotNullExpressionValue(var30, "particleTitle");
            this.particleTitle = var30;
            ConstraintLayout var35 = var16.contentTemperature;
            Intrinsics.checkNotNullExpressionValue(var35, "contentTemperature");
            this.contentTemp = var35;
            var35 = var16.contentHumidity;
            Intrinsics.checkNotNullExpressionValue(var35, "contentHumidity");
            this.contentHum = var35;
            Intrinsics.checkNotNull(var16);
            var16 = var16;
         }

         this.binding = var16;
         HasSensorData var37 = this.device;
         HasSensorData var18 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var18 = null;
         }

         if (var18 instanceof DeviceHumidifier) {
            TabLayout var38 = this.graphTabs;
            TabLayout var19 = var38;
            if (var38 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("graphTabs");
               var19 = null;
            }

            ViewExtensionsKt.hide((View)var19);
         } else if (var18 instanceof DevicePet20) {
            ConstraintLayout var39 = this.contentTemp;
            ConstraintLayout var20 = var39;
            if (var39 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("contentTemp");
               var20 = null;
            }

            ViewExtensionsKt.hide((View)var20);
            var39 = this.contentHum;
            var20 = var39;
            if (var39 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("contentHum");
               var20 = null;
            }

            ViewExtensionsKt.hide((View)var20);
            TextView var41 = this.particleTitle;
            TextView var22 = var41;
            if (var41 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("particleTitle");
               var22 = null;
            }

            var22.setText(R.string.indoor_aqi);
         }

         DeviceSensorsViewModel var46 = this.getViewModel();
         var37 = this.device;
         var18 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var18 = null;
         }

         var46.init(var18, true);
         ViewBinding var24 = this.binding;
         if (var24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var24 = null;
         }

         View var25 = var24.getRoot();
         Intrinsics.checkNotNullExpressionValue(var25, "getRoot(...)");
         return var25;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().refresh();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.setupGraphTabs();
      Group var17 = this.groupAqi;
      Object var5 = null;
      Group var7 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("groupAqi");
         var7 = null;
      }

      ViewExtensionsKt.show((View)var7, this.getViewModel().getSupportPM25());
      HasSensorData var18 = this.device;
      HasSensorData var8 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var8 = null;
      }

      boolean var4 = var8 instanceof DevicePet20;
      if (var4) {
         TextView var19 = this.particleData;
         TextView var9 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleData");
            var9 = null;
         }

         com.blueair.viewcore.ViewExtensionsKt.unbold(var9);
         var19 = this.aqiData;
         var9 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqiData");
            var9 = null;
         }

         com.blueair.viewcore.ViewExtensionsKt.unbold(var9);
         var19 = this.particleTitle;
         var9 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleTitle");
            var9 = null;
         }

         float var3 = var9.getTextSize();
         var19 = this.particleData;
         var9 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("particleData");
            var9 = null;
         }

         var9.setTextSize(var3);
         var19 = this.aqiData;
         var9 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aqiData");
            var9 = null;
         }

         var9.setTextSize(var3);
         if (VERSION.SDK_INT >= 26) {
            var19 = this.particleData;
            var9 = var19;
            if (var19 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("particleData");
               var9 = null;
            }

            TextView var6 = this.particleData;
            var19 = var6;
            if (var6 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("particleData");
               var19 = null;
            }

            BlueairApp$$ExternalSyntheticApiModelOutline0.m(var9, BlueairApp$$ExternalSyntheticApiModelOutline0.m(var19), MathKt.roundToInt(var3), 1, 0);
            var19 = this.aqiData;
            var9 = var19;
            if (var19 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("aqiData");
               var9 = null;
            }

            var19 = this.aqiData;
            if (var19 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("aqiData");
               var19 = (TextView)var5;
            }

            BlueairApp$$ExternalSyntheticApiModelOutline0.m(var9, BlueairApp$$ExternalSyntheticApiModelOutline0.m(var19), MathKt.roundToInt(var3), 1, 0);
         }
      }

      IndoorAirRatingRanges var16 = this.getViewModel().getIndoorAirRatings();
      this.getViewModel().getLiveSelectedSensorHistoricalData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceHSensorsFragment$$ExternalSyntheticLambda7(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getLiveSelectedSensorRealTimeData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceHSensorsFragment$$ExternalSyntheticLambda8(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getLiveDeviceLatestData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceHSensorsFragment$$ExternalSyntheticLambda9(this, var4, var16)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getDisableSensorCards().observe(this.getViewLifecycleOwner(), new Observer(new DeviceHSensorsFragment$$ExternalSyntheticLambda10(this, var4, var16)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getLiveDevice().observe(this.getViewLifecycleOwner(), new Observer(new DeviceHSensorsFragment$$ExternalSyntheticLambda11(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getLiveAqiData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceHSensorsFragment$$ExternalSyntheticLambda2(this, var4)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   public void setViewModel(DeviceSensorsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceHSensorsFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "KEY_DEVICE", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceHSensorsFragment;", "device", "Lcom/blueair/core/model/HasSensorData;", "devicedetails_otherRelease"},
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

      public final String getTAG() {
         return DeviceHSensorsFragment.TAG;
      }

      public final DeviceHSensorsFragment newInstance(HasSensorData var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceHSensorsFragment var2 = new DeviceHSensorsFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("KEY_DEVICE", var1)}));
         return var2;
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
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.FAN.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.WEIGHT.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.RPM.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
