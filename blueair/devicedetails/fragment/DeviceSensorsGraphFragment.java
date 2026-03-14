package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasTemperatureUnit;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsGraphBinding;
import com.blueair.devicedetails.dialog.AboutAirQualityDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.GraphViewV2;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020&H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00061"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsGraphFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "deviceDetailsViewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceSensorsGraphBinding;", "lastData", "Lcom/blueair/core/model/IndoorDatapoint;", "value", "", "isStandByOn", "setStandByOn", "(Z)V", "isOffline", "setOffline", "lastMainMode", "Lcom/blueair/core/model/MainMode;", "lastTemperatureUnit", "", "Ljava/lang/Integer;", "lastSensorMode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showSensorData", "selectedSensor", "Lcom/blueair/core/model/SensorType;", "updateAqiData", "dataPoint", "onResume", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSensorsGraphFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private FragmentDeviceSensorsGraphBinding binding;
   private DeviceDetailsViewModel deviceDetailsViewModel;
   private boolean isOffline;
   private boolean isStandByOn;
   private IndoorDatapoint lastData;
   private MainMode lastMainMode;
   private Integer lastSensorMode;
   private Integer lastTemperatureUnit;
   public DeviceSensorsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$07e9i_owBH_unOSI_MkDNVPAlFs/* $FF was: $r8$lambda$07e9i_owBH-unOSI_MkDNVPAlFs*/(FragmentDeviceSensorsGraphBinding var0, DeviceSensorsGraphFragment var1, CompoundButton var2, boolean var3) {
      onViewCreated$lambda$18$lambda$1(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$0MZtSkSXsG3iUeCcF4hj7N8G2EI(DeviceSensorsGraphFragment var0, FragmentDeviceSensorsGraphBinding var1, View var2) {
      onViewCreated$lambda$18$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$E9fZyXZDzbc2ju8LXZAeQsJTIQE(FragmentDeviceSensorsGraphBinding var0, List var1) {
      return onViewCreated$lambda$18$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$MOYW26_EWLICDQ0RqVW6cMg_kF4(FragmentDeviceSensorsGraphBinding var0, View var1) {
      onViewCreated$lambda$18$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Mn1GRhOSY0l4XkgZQUIybuHHKos(FragmentDeviceSensorsGraphBinding var0, int var1, String var2) {
      return onViewCreated$lambda$18$lambda$7$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$S_2khUJID10v_eKHtSsjsdoeU_8/* $FF was: $r8$lambda$S-2khUJID10v_eKHtSsjsdoeU-8*/(DeviceSensorsGraphFragment var0, Device var1) {
      return onViewCreated$lambda$18$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$T0ahG8VWU39nL3LyD_Uf1BtrmRA/* $FF was: $r8$lambda$T0ahG8VWU39nL3LyD-Uf1BtrmRA*/(DeviceSensorsGraphFragment var0, FragmentDeviceSensorsGraphBinding var1, List var2) {
      return onViewCreated$lambda$18$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YLiVeEtzg0vlVgOih9W26vlhZWw(FragmentDeviceSensorsGraphBinding var0, Boolean var1) {
      return onViewCreated$lambda$18$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$c4t2GwIBBvYirLSUlfDs9aAuh_s/* $FF was: $r8$lambda$c4t2GwIBBvYirLSUlfDs9aAuh-s*/(DeviceSensorsGraphFragment var0, Boolean var1) {
      return onViewCreated$lambda$18$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$f05cHQ4GW_jauMRK_bUWkwvzd_Y/* $FF was: $r8$lambda$f05cHQ4GW_jauMRK-bUWkwvzd-Y*/(DeviceSensorsGraphFragment var0, DeviceData var1) {
      return onViewCreated$lambda$18$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$kPBysCjcCifZKGftdJTj0XGA3bo(DeviceSensorsGraphFragment var0, int var1, String var2) {
      return onViewCreated$lambda$18$lambda$4$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kghUNyFb6B6nWwLIe52mxqfvwxY(FragmentDeviceSensorsGraphBinding var0, DeviceSensorsGraphFragment var1, View var2) {
      onViewCreated$lambda$18$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zuDELsta232leKEt2mdUriBhYiA(DeviceSensorsGraphFragment var0, View var1) {
      onViewCreated$lambda$18$lambda$17(var0, var1);
   }

   private static final void onViewCreated$lambda$18$lambda$0(FragmentDeviceSensorsGraphBinding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   private static final void onViewCreated$lambda$18$lambda$1(FragmentDeviceSensorsGraphBinding var0, DeviceSensorsGraphFragment var1, CompoundButton var2, boolean var3) {
      boolean var4;
      label15: {
         Group var6 = var0.expendedContent;
         Intrinsics.checkNotNullExpressionValue(var6, "expendedContent");
         ViewExtensionsKt.show((View)var6, var3 ^ true);
         MaterialButton var7 = var0.btnAbout;
         Intrinsics.checkNotNullExpressionValue(var7, "btnAbout");
         var8 = (View)var7;
         if (!var3) {
            CharSequence var5 = var0.btnAbout.getText();
            if (var5 != null && var5.length() != 0) {
               var4 = true;
               break label15;
            }
         }

         var4 = false;
      }

      ViewExtensionsKt.show(var8, var4);
      var1.getViewModel().getGraphExpended().setValue(var3 ^ true);
   }

   private static final Unit onViewCreated$lambda$18$lambda$10(DeviceSensorsGraphFragment var0, FragmentDeviceSensorsGraphBinding var1, List var2) {
      Timber.Forest var10 = Timber.Forest;
      StringBuilder var9 = new StringBuilder("liveSelectedSensorHistoricalData: ");
      var9.append(var2.size());
      var10.d(var9.toString(), new Object[0]);
      List var17 = (List)var0.getViewModel().getLiveSelectedSensorRealTimeData().getValue();
      SimpleDatapoint var12 = null;
      Object var15 = null;
      if (var17 != null) {
         Iterator var11 = ((Iterable)var17).iterator();
         if (!var11.hasNext()) {
            var12 = (SimpleDatapoint)var15;
         } else {
            var12 = (SimpleDatapoint)var11.next();
            if (var11.hasNext()) {
               long var3 = ((SimpleDatapoint)var12).getTimeInMillis();
               var15 = var12;

               do {
                  Object var18 = var11.next();
                  long var7 = ((SimpleDatapoint)var18).getTimeInMillis();
                  var12 = (SimpleDatapoint)var15;
                  long var5 = var3;
                  if (var3 < var7) {
                     var12 = (SimpleDatapoint)var18;
                     var5 = var7;
                  }

                  var15 = var12;
                  var3 = var5;
               } while(var11.hasNext());
            }
         }

         var12 = var12;
      }

      GraphViewV2 var14 = var1.graph;
      if (var12 != null) {
         Intrinsics.checkNotNull(var2);
         var2 = CollectionsKt.plus((Collection)var2, var12);
      }

      Intrinsics.checkNotNull(var2);
      var14.updateHistoricalData(var2);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$18$lambda$11(FragmentDeviceSensorsGraphBinding var0, List var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("liveSelectedSensorRealTimeData: ");
      var3.append(var1.size());
      var2.d(var3.toString(), new Object[0]);
      GraphViewV2 var4 = var0.graph;
      Intrinsics.checkNotNull(var1);
      var4.updateRealTimeData(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$18$lambda$12(DeviceSensorsGraphFragment var0, DeviceData var1) {
      var0.updateAqiData(var1.getLatestDatapoint(), var0.isStandByOn, var0.isOffline);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$18$lambda$14(DeviceSensorsGraphFragment var0, Device var1) {
      boolean var3;
      label51: {
         if (var1 != null) {
            boolean var4 = DeviceKt.isStandByOn(var1);
            var3 = true;
            if (var4) {
               break label51;
            }
         }

         var3 = false;
      }

      var0.setStandByOn(var3);
      HasSensorData var5;
      if (var1 instanceof HasSensorData) {
         var5 = (HasSensorData)var1;
      } else {
         var5 = null;
      }

      if (var5 != null) {
         var0.getViewModel().updateDevice(var5);
      }

      if (var1 instanceof HasDehumidifierMainMode) {
         HasDehumidifierMainMode var9 = (HasDehumidifierMainMode)var1;
         if (var9.mainMode() != var0.lastMainMode) {
            var0.updateAqiData(var0.lastData, var0.isStandByOn, var0.isOffline);
            var0.lastMainMode = var9.mainMode();
         }
      }

      if (var1 instanceof DeviceBlue40) {
         var5 = (DeviceBlue40)var1;
         int var2 = var5.getSensorMode();
         Integer var6 = var0.lastSensorMode;
         if (var6 == null || var2 != var6) {
            var0.updateAqiData(var0.lastData, var0.isStandByOn, var0.isOffline);
            var0.lastSensorMode = var5.getSensorMode();
         }
      }

      if (var1 instanceof HasTemperatureUnit) {
         HasTemperatureUnit var11 = (HasTemperatureUnit)var1;
         int var8 = var11.getTemperatureUnit();
         Integer var7 = var0.lastTemperatureUnit;
         if (var7 == null || var8 != var7) {
            var0.lastTemperatureUnit = var11.getTemperatureUnit();
            if (var0.getViewModel().getLiveSelectedSensor().getValue() == SensorType.TMP) {
               var0.showSensorData(SensorType.TMP);
               DeviceSensorsViewModel.selectSensor$default(var0.getViewModel(), SensorType.TMP, false, 2, (Object)null);
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$18$lambda$15(DeviceSensorsGraphFragment var0, Boolean var1) {
      Intrinsics.checkNotNull(var1);
      var0.setOffline(var1);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$18$lambda$17(DeviceSensorsGraphFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("AboutAirQualityDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("AboutAirQualityDialogFragment") instanceof AboutAirQualityDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)AboutAirQualityDialogFragment.Companion.newInstance()).show(var2, "AboutAirQualityDialogFragment");
      }

   }

   private static final void onViewCreated$lambda$18$lambda$4(DeviceSensorsGraphFragment var0, FragmentDeviceSensorsGraphBinding var1, View var2) {
      if (var0.getViewModel().getSupportedSensors().size() > 1) {
         DialogUtils var8 = DialogUtils.INSTANCE;
         TextView var6 = var1.dropdownMenuSensors;
         Intrinsics.checkNotNullExpressionValue(var6, "dropdownMenuSensors");
         View var3 = (View)var6;
         Iterable var4 = (Iterable)var0.getViewModel().getSupportedSensors();
         Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));

         for(SensorType var5 : var4) {
            String var10 = var0.getString(GraphUiUtils.INSTANCE.getSensorName(var5));
            Intrinsics.checkNotNullExpressionValue(var10, "getString(...)");
            var7.add(var10);
         }

         DialogUtils.showDropDownList$default(var8, var3, (List)var7, 0, 0, 0, 0, false, new DeviceSensorsGraphFragment$$ExternalSyntheticLambda2(var0), 124, (Object)null);
      }

   }

   private static final Unit onViewCreated$lambda$18$lambda$4$lambda$3(DeviceSensorsGraphFragment var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      DeviceSensorsViewModel.selectSensor$default(var0.getViewModel(), (SensorType)var0.getViewModel().getSupportedSensors().get(var1), false, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$18$lambda$7(FragmentDeviceSensorsGraphBinding var0, DeviceSensorsGraphFragment var1, View var2) {
      DialogUtils var7 = DialogUtils.INSTANCE;
      TextView var3 = var0.dropdownMenuScale;
      Intrinsics.checkNotNullExpressionValue(var3, "dropdownMenuScale");
      View var4 = (View)var3;
      Iterable var5 = (Iterable)CollectionsKt.listOf(new Integer[]{R.string.day_label, R.string.week_label, R.string.month_label});
      Collection var8 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var5, 10)));
      Iterator var9 = var5.iterator();

      while(var9.hasNext()) {
         String var6 = var1.getString(((Number)var9.next()).intValue());
         Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
         var8.add(var6);
      }

      DialogUtils.showDropDownList$default(var7, var4, (List)var8, 0, 0, 0, 0, false, new DeviceSensorsGraphFragment$$ExternalSyntheticLambda3(var0), 124, (Object)null);
   }

   private static final Unit onViewCreated$lambda$18$lambda$7$lambda$6(FragmentDeviceSensorsGraphBinding var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "item");
      var0.dropdownMenuScale.setText((CharSequence)var2);
      var0.graph.setTimeScale((ChartTimeScale)ChartTimeScale.getEntries().get(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$18$lambda$8(FragmentDeviceSensorsGraphBinding var0, Boolean var1) {
      var0.expendSwitch.setChecked(var1 ^ true);
      return Unit.INSTANCE;
   }

   private final void setOffline(boolean var1) {
      if (this.isOffline != var1) {
         this.isOffline = var1;
         this.updateAqiData((IndoorDatapoint)null, this.isStandByOn, var1);
      }
   }

   private final void setStandByOn(boolean var1) {
      if (this.isStandByOn != var1) {
         this.isStandByOn = var1;
         this.updateAqiData((IndoorDatapoint)null, var1, this.isOffline);
      }
   }

   private final void showSensorData(SensorType var1) {
      FragmentDeviceSensorsGraphBinding var3 = this.binding;
      Object var5 = null;
      FragmentDeviceSensorsGraphBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.dropdownMenuSensors.setText(GraphUiUtils.INSTANCE.getSensorName(var1));
      int var2 = DeviceSensorsGraphFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      GraphViewV2.DataType var10;
      if (var2 != 1) {
         if (var2 != 2) {
            var10 = new GraphViewV2.DataType.AQI(this.getViewModel().getDevice(), var1);
         } else {
            var10 = new GraphViewV2.DataType.TMP(this.getViewModel().getDevice(), this.getViewModel().isTempCelsius());
         }
      } else {
         var10 = new GraphViewV2.DataType.HUM(this.getViewModel().getDevice());
      }

      var4.graph.setDataType(var10);
      var2 = DeviceSensorsGraphFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      Integer var11;
      if (var2 != 1) {
         if (var2 != 3) {
            if (var2 != 4) {
               if (var2 != 5) {
                  if (var2 != 6) {
                     if (var2 != 7) {
                        var11 = (Integer)var5;
                     } else {
                        var11 = R.string.about_hcho;
                     }
                  } else {
                     var11 = R.string.about_tvoc;
                  }
               } else {
                  var11 = R.string.about_pm_10;
               }
            } else {
               var11 = R.string.about_pm_25;
            }
         } else {
            var11 = R.string.about_pm_1;
         }
      } else {
         var11 = R.string.about_humidity;
      }

      if (var11 == null) {
         var4.btnAbout.setText((CharSequence)"");
         MaterialButton var6 = var4.btnAbout;
         Intrinsics.checkNotNullExpressionValue(var6, "btnAbout");
         ViewExtensionsKt.show((View)var6, false);
      } else {
         var4.btnAbout.setText(var11);
         MaterialButton var12 = var4.btnAbout;
         Intrinsics.checkNotNullExpressionValue(var12, "btnAbout");
         ViewExtensionsKt.show((View)var12, var4.expendSwitch.isChecked() ^ true);
         var12 = var4.btnAbout;
         var2 = DeviceSensorsGraphFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            if (var2 != 3) {
               if (var2 != 4) {
                  if (var2 != 5) {
                     if (var2 != 6) {
                        if (var2 != 7) {
                           var2 = R.drawable.ic_pm25_primary;
                        } else {
                           var2 = R.drawable.ic_hcho_primary;
                        }
                     } else {
                        var2 = R.drawable.ic_tvoc_primary;
                     }
                  } else {
                     var2 = R.drawable.ic_pm10_primary;
                  }
               } else {
                  var2 = R.drawable.ic_pm25_primary;
               }
            } else {
               var2 = R.drawable.ic_pm1_primary;
            }
         } else {
            var2 = R.drawable.ic_hum;
         }

         var12.setIconResource(var2);
      }

      this.updateAqiData(this.lastData, this.isStandByOn, this.isOffline);
   }

   private final void updateAqiData(IndoorDatapoint var1, boolean var2, boolean var3) {
      this.lastData = var1;
      FragmentDeviceSensorsGraphBinding var7 = this.binding;
      Object var9 = null;
      Object var8 = null;
      FragmentDeviceSensorsGraphBinding var6 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      if (var3) {
         var6.aqiIcon.setImageResource(GraphUiUtils.INSTANCE.getSeverityDot6Null());
         var6.aqiValue.setText(R.string.offline_label);
         var6.descriptionText.setText(R.string.offline_label);
      } else if (var2) {
         var6.aqiIcon.setImageResource(GraphUiUtils.INSTANCE.getSeverityDot6Null());
         var6.aqiValue.setText((CharSequence)"-");
         var6.descriptionText.setText((CharSequence)"-");
      } else {
         DeviceDetailsViewModel var10 = this.deviceDetailsViewModel;
         DeviceDetailsViewModel var16 = var10;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceDetailsViewModel");
            var16 = null;
         }

         Device var17 = var16.getDevice();
         IndoorAirStatusLabel var12;
         if (var17 == null || !(var17 instanceof DeviceHumidifier) && !(var17 instanceof DeviceHumidifier20) && !DeviceKt.isHumidifyModeOn(var17) && (!(var17 instanceof HasDehumidifierMainMode) || !((HasDehumidifierMainMode)var17).isInMainMode(MainMode.Dehumidification))) {
            IndoorAirStatusLabel var25 = IndoorAirStatusLabel.Companion.fromDeviceAndSensorsAndDatapoint$default(IndoorAirStatusLabel.Companion, var1, this.getViewModel().getDevice(), IndoorAirRatingRanges.Companion.getAirRatingSensors(this.getViewModel().getDevice()), true, false, 16, (Object)null);
            SensorType var26 = this.getViewModel().getSelectedSensor();
            Float var20;
            if (var1 != null) {
               var20 = var1.valueFor(var26);
            } else {
               var20 = null;
            }

            IndoorAirStatusLabel var21;
            if (var20 == null) {
               var21 = (IndoorAirStatusLabel)var8;
            } else {
               var21 = IndoorAirStatusLabel.Companion.fromDeviceAndSensorAndDatapoint(var1, this.getViewModel().getDevice(), var26, true);
            }

            if (var21 == null) {
               var6.descriptionText.setText(R.string.label_reading);
            } else {
               float var4;
               int var5;
               TextView var11;
               label55: {
                  var11 = var6.descriptionText;
                  var5 = R.string.aqi_level_description;
                  var24 = this.getString(GraphUiUtils.INSTANCE.getSensorName(var26));
                  if (var1 != null) {
                     Float var14 = var1.valueFor(var26);
                     if (var14 != null) {
                        var4 = var14;
                        break label55;
                     }
                  }

                  var4 = 0.0F;
               }

               var11.setText((CharSequence)this.getString(var5, new Object[]{var24, (int)var4, this.getString(var21.getTextResId())}));
            }

            var12 = var25;
         } else {
            Float var18;
            if (var1 != null) {
               var18 = var1.getHum();
            } else {
               var18 = null;
            }

            if (var18 == null) {
               var12 = (IndoorAirStatusLabel)var9;
            } else {
               IndoorAirStatusLabel.Companion var19 = IndoorAirStatusLabel.Companion;
               HasSensorData var23 = this.getViewModel().getDevice();
               Float var13 = var1.getHum();
               Intrinsics.checkNotNull(var13);
               var12 = var19.fromValueAndSensor(var23, (double)var13, SensorType.HUM);
            }
         }

         if (var12 == null) {
            var6.aqiIcon.setImageResource(GraphUiUtils.INSTANCE.getSeverityDot6Null());
            var6.aqiValue.setText(R.string.label_reading);
         } else {
            var6.aqiIcon.setImageResource(var12.getIndoorAirQualityIcon6());
            var6.aqiValue.setText(var12.getLabelResId());
         }
      }

      View var15 = var6.clickView;
      StringBuilder var22 = new StringBuilder();
      var22.append(var6.title.getText());
      var22.append(", ");
      var22.append(var6.aqiValue.getText());
      var15.setContentDescription((CharSequence)var22.toString());
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
      BaseFragment var7 = this;
      this.setViewModel((DeviceSensorsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceSensorsViewModel.class)));
      this.deviceDetailsViewModel = (DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class));
      FragmentDeviceSensorsGraphBinding var6 = FragmentDeviceSensorsGraphBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      FragmentDeviceSensorsGraphBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      ShadowLayout var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return (View)var5;
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().refresh();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentDeviceSensorsGraphBinding var6 = this.binding;
      Object var3 = null;
      FragmentDeviceSensorsGraphBinding var5 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      var5.clickView.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda0(var5));
      var5.expendSwitch.setOnCheckedChangeListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda5(var5, this));
      if (this.getViewModel().getSupportedSensors().size() > 1) {
         var5.dropdownMenuSensors.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda6(this, var5));
      } else {
         var5.dropdownMenuSensors.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }

      var5.dropdownMenuScale.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda7(var5, this));
      this.getViewModel().getLiveSelectedSensor().observe(this.getViewLifecycleOwner(), new Observer(new Function1(this) {
         public final void invoke(SensorType var1) {
            Intrinsics.checkNotNullParameter(var1, "p0");
            ((DeviceSensorsGraphFragment)this.receiver).showSensorData(var1);
         }
      }) {
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
      this.getViewModel().getGraphExpended().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda8(var5)) {
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
      this.getViewModel().getLiveSelectedSensorHistoricalData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda9(this, var5)) {
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
      this.getViewModel().getLiveSelectedSensorRealTimeData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda10(var5)) {
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
      this.getViewModel().getLiveDeviceRealTimeData().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda11(this)) {
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
      DeviceDetailsViewModel var4 = this.deviceDetailsViewModel;
      DeviceDetailsViewModel var7 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceDetailsViewModel");
         var7 = null;
      }

      var7.getLiveDevice().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda12(this)) {
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
      var7 = this.deviceDetailsViewModel;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("deviceDetailsViewModel");
         var7 = (DeviceDetailsViewModel)var3;
      }

      var7.getDeviceOffline().observe(this.getViewLifecycleOwner(), new Observer(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda1(this)) {
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
      var5.btnAbout.setOnClickListener(new DeviceSensorsGraphFragment$$ExternalSyntheticLambda4(this));
      ViewUtils var11 = ViewUtils.INSTANCE;
      TextView var9 = var5.dropdownMenuSensors;
      Intrinsics.checkNotNullExpressionValue(var9, "dropdownMenuSensors");
      ViewUtils.setAccessibilityDelegate$default(var11, (View)var9, Reflection.getOrCreateKotlinClass(Spinner.class), (String)null, (Function2)null, 12, (Object)null);
      var11 = ViewUtils.INSTANCE;
      var9 = var5.dropdownMenuScale;
      Intrinsics.checkNotNullExpressionValue(var9, "dropdownMenuScale");
      ViewUtils.setAccessibilityDelegate$default(var11, (View)var9, Reflection.getOrCreateKotlinClass(Spinner.class), (String)null, (Function2)null, 12, (Object)null);
      if (this.getViewModel().getDevice() instanceof DeviceFanTable) {
         var5.title.setText(R.string.room_temperature);
      }

   }

   public void setViewModel(DeviceSensorsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsGraphFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSensorsGraphFragment;", "devicedetails_otherRelease"},
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

      public final DeviceSensorsGraphFragment newInstance() {
         return new DeviceSensorsGraphFragment();
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
            var0[SensorType.HUM.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.PM1.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 5;
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
