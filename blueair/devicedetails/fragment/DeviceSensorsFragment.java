package com.blueair.devicedetails.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.Pollutant;
import com.blueair.core.model.SensorType;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsBinding;
import com.blueair.devicedetails.databinding.SensorItemBinding;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.utils.GraphUiUtils;
import com.blueair.graph.view.FanHistoryGraphView;
import com.blueair.graph.view.GraphView;
import com.blueair.graph.view.IndoorGraphView;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\b\u0010(\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u001e\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010+2\u0006\u00103\u001a\u00020'H\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010/2\u0006\u00106\u001a\u000207H\u0003R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"},
   d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "Lkotlin/Lazy;", "showProgress", "", "shouldShowProgress", "", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceSensorsBinding;", "tabSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onDestroyView", "observeViewModel", "getSensorTitle", "", "sensorType", "Lcom/blueair/core/model/SensorType;", "initUi", "updateSelectedTab", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "selected", "updateTabs", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "outdoorDataPoint", "Lcom/blueair/core/model/AqiData;", "getTab", "sensor", "updateSensorInfo", "getIndoorDataForTimestamp", "unixTime", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSensorsFragment extends BaseFragment {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceSensorsFragment.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String KEY_DEVICE = "KEY_DEVICE";
   private static final String TAG = Reflection.getOrCreateKotlinClass(DeviceSensorsFragment.class).getSimpleName();
   private final Lazy analyticsService$delegate;
   private boolean tabSelected;
   private FragmentDeviceSensorsBinding viewDataBinding;
   public DeviceSensorsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$2jdrDr1PRFa94Y75Eo54xzNuNfI(DeviceSensorsFragment var0, View var1) {
      initUi$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4yFdQoCAYqX_AbJHcjpAclLZ5ek/* $FF was: $r8$lambda$4yFdQoCAYqX-AbJHcjpAclLZ5ek*/(Object var0) {
      observeViewModel$lambda$5(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$A13m3JNVIf25b1mwcYAuTkejc58(DeviceSensorsFragment var0, Set var1) {
      observeViewModel$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$FxabRw4uGNHymXChUNSIZTIwIEo(DeviceSensorsFragment var0, List var1) {
      observeViewModel$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UijGh_xPTo41EJsbWW1W_gcg3_k/* $FF was: $r8$lambda$UijGh-xPTo41EJsbWW1W-gcg3_k*/(DeviceSensorsFragment var0, List var1) {
      observeViewModel$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$c6Gbv04yDXpCDiaioaru5pl6IcE(DeviceSensorsFragment var0, GraphView.ScaleEvent var1) {
      observeViewModel$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$gNEpzfJgG8zyBsAWGA7G6MjmkAE(DeviceSensorsFragment var0, GraphView.ScaleEvent var1) {
      observeViewModel$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$j31Hywa_8_WuldfMdPa8RV7E5II/* $FF was: $r8$lambda$j31Hywa-8-WuldfMdPa8RV7E5II*/(DeviceSensorsFragment var0, List var1) {
      observeViewModel$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jFN_EYu3Wn1P27ls6JMhbtdDucI/* $FF was: $r8$lambda$jFN-EYu3Wn1P27ls6JMhbtdDucI*/(DeviceSensorsFragment var0, GraphView.SelectedPoint var1) {
      observeViewModel$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jOmLB9BgYZVPZ52jjBrvH88kWzY(DeviceSensorsFragment var0) {
      initUi$lambda$18$lambda$17(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nrQAsSxaNmJE2jSTzF1xcB6h_WI(DeviceSensorsFragment var0, SensorType var1) {
      observeViewModel$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$sII_LwB96YnD81aDNjvnh6nerd4(Object var0) {
      observeViewModel$lambda$6(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vQ_FV6TsWrtI3ZdM4m7zMUaR_Hw/* $FF was: $r8$lambda$vQ_FV6TsWrtI3ZdM4m7zMUaR-Hw*/(DeviceSensorsFragment var0, List var1) {
      observeViewModel$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vvsVqKyoQWZ2dGt7WlSDL7COe7c(DeviceSensorsFragment var0, GraphView.SelectedPoint var1) {
      observeViewModel$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zWEJcJdbI_hva2KhWhOwtxGzVd8/* $FF was: $r8$lambda$zWEJcJdbI-hva2KhWhOwtxGzVd8*/(DeviceSensorsFragment var0, View var1) {
      initUi$lambda$18(var0, var1);
   }

   public DeviceSensorsFragment() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analyticsService$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AnalyticsService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final AnalyticsService getAnalyticsService() {
      return (AnalyticsService)this.analyticsService$delegate.getValue();
   }

   private final IndoorDatapoint getIndoorDataForTimestamp(long var1) {
      List var11;
      label70: {
         DeviceData var10 = this.getViewModel().getLastDeviceHistoricalData();
         if (var10 != null) {
            List var18 = var10.getDatapoints();
            var11 = var18;
            if (var18 != null) {
               break label70;
            }
         }

         var11 = CollectionsKt.emptyList();
      }

      List var20;
      label65: {
         DeviceData var19 = this.getViewModel().getLastDeviceRealTimeData();
         if (var19 != null) {
            List var12 = var19.getDatapoints();
            var20 = var12;
            if (var12 != null) {
               break label65;
            }
         }

         var20 = CollectionsKt.emptyList();
      }

      List var27;
      label60: {
         Collection var25 = (Collection)var20;
         if (var25 != null && !var25.isEmpty()) {
            IndoorDatapoint var26 = (IndoorDatapoint)CollectionsKt.lastOrNull(var11);
            long var3;
            if (var26 != null) {
               var3 = var26.getTimeInSeconds();
            } else {
               var3 = 0L;
            }

            if (var1 > var3) {
               var27 = var20;
               break label60;
            }
         }

         var27 = var11;
      }

      Iterator var16 = ((Iterable)var27).iterator();
      boolean var9 = var16.hasNext();
      Object var14 = null;
      Object var28;
      if (!var9) {
         var28 = null;
      } else {
         var28 = var16.next();
         if (var16.hasNext()) {
            long var17 = Math.abs(var1 - ((IndoorDatapoint)var28).getTimeInSeconds());
            Object var13 = var28;

            do {
               Object var15 = var16.next();
               long var7 = Math.abs(var1 - ((IndoorDatapoint)var15).getTimeInSeconds());
               var28 = var13;
               long var5 = var17;
               if (var17 > var7) {
                  var28 = var15;
                  var5 = var7;
               }

               var13 = var28;
               var17 = var5;
            } while(var16.hasNext());
         }
      }

      IndoorDatapoint var32 = (IndoorDatapoint)var28;
      Timber.Forest var30 = Timber.Forest;
      StringBuilder var31 = new StringBuilder("getIndoorDataForTimestamp: unixTime = ");
      var31.append(var1);
      var31.append(", bestMatch = ");
      Long var29;
      if (var32 != null) {
         var29 = var32.getTimeInSeconds();
      } else {
         var29 = null;
      }

      var31.append(var29);
      var31.append(", latest historical = ");
      IndoorDatapoint var22 = (IndoorDatapoint)CollectionsKt.lastOrNull(var11);
      Long var23;
      if (var22 != null) {
         var23 = var22.getTimeInSeconds();
      } else {
         var23 = null;
      }

      var31.append(var23);
      var31.append(", first realtime = ");
      var23 = (Long)var14;
      if (var20 != null) {
         IndoorDatapoint var21 = (IndoorDatapoint)CollectionsKt.firstOrNull(var20);
         var23 = (Long)var14;
         if (var21 != null) {
            var23 = var21.getTimeInSeconds();
         }
      }

      var31.append(var23);
      var30.d(var31.toString(), new Object[0]);
      return var32;
   }

   private final int getSensorTitle(SensorType var1) {
      switch (DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            return R.string.pm1_title_short;
         case 2:
            return R.string.pm25_title;
         case 3:
            return R.string.pm10_title_short;
         case 4:
            return R.string.voc_title_short;
         case 5:
            return R.string.hcho_title;
         case 6:
            return R.string.hum_expanded;
         case 7:
            return R.string.temp_expanded;
         case 8:
            return R.string.fan_title;
         case 9:
         case 10:
            return 0;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   private final TabLayout.Tab getTab(SensorType var1) {
      FragmentDeviceSensorsBinding var3 = this.viewDataBinding;
      FragmentDeviceSensorsBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      return var2.sensorTabs.getTabAt(this.getViewModel().getSensorPos(var1));
   }

   private final void initUi() {
      FragmentDeviceSensorsBinding var6 = this.viewDataBinding;
      Object var5 = null;
      FragmentDeviceSensorsBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      IndoorGraphView var31 = var4.deviceGraph;
      LifecycleOwner var13 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var13, "getViewLifecycleOwner(...)");
      var31.attachLifeCycle(var13);
      FragmentDeviceSensorsBinding var32 = this.viewDataBinding;
      FragmentDeviceSensorsBinding var14 = var32;
      if (var32 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var14 = null;
      }

      FanHistoryGraphView var33 = var14.fanGraph;
      LifecycleOwner var15 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var15, "getViewLifecycleOwner(...)");
      var33.attachLifeCycle(var15);
      Iterator var7 = ((Iterable)this.getViewModel().getSupportedSensors()).iterator();
      int var1 = 0;

      while(true) {
         boolean var3 = var7.hasNext();
         int var2 = 8;
         if (!var3) {
            FragmentDeviceSensorsBinding var36 = this.viewDataBinding;
            FragmentDeviceSensorsBinding var20 = var36;
            if (var36 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
               var20 = null;
            }

            var20.sensorTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(this) {
               final DeviceSensorsFragment this$0;

               {
                  this.this$0 = var1;
               }

               public void onTabReselected(TabLayout.Tab var1) {
               }

               public void onTabSelected(TabLayout.Tab var1) {
                  if (var1 != null) {
                     this.this$0.tabSelected = true;
                     this.this$0.updateSelectedTab(var1, true);
                     SensorType var2 = this.this$0.getViewModel().getSensorAtPos(var1.getPosition());
                     if (var2 != null) {
                        DeviceSensorsViewModel.selectSensor$default(this.this$0.getViewModel(), var2, false, 2, (Object)null);
                     }
                  }

               }

               public void onTabUnselected(TabLayout.Tab var1) {
                  if (var1 != null) {
                     this.this$0.updateSelectedTab(var1, false);
                  }

               }
            });
            var36 = this.viewDataBinding;
            var20 = var36;
            if (var36 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
               var20 = null;
            }

            var1 = var20.sensorTabs.getSelectedTabPosition();
            var2 = this.getViewModel().getSensorPos(this.getViewModel().getSelectedSensor());
            if (var1 == var2) {
               var36 = this.viewDataBinding;
               var20 = var36;
               if (var36 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var20 = null;
               }

               TabLayout.Tab var23 = var20.sensorTabs.getTabAt(var1);
               if (var23 != null) {
                  this.updateSelectedTab(var23, true);
               }
            } else {
               var36 = this.viewDataBinding;
               var20 = var36;
               if (var36 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var20 = null;
               }

               TabLayout.Tab var44 = var20.sensorTabs.getTabAt(var2);
               if (var44 != null) {
                  var36 = this.viewDataBinding;
                  var20 = var36;
                  if (var36 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                     var20 = null;
                  }

                  var20.sensorTabs.selectTab(var44);
               }
            }

            if (this.getViewModel().getShowFanHistory()) {
               var36 = this.viewDataBinding;
               var20 = var36;
               if (var36 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var20 = null;
               }

               var20.buttonCollapse.setVisibility(0);
            } else {
               var36 = this.viewDataBinding;
               var20 = var36;
               if (var36 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var20 = null;
               }

               var20.buttonCollapse.setVisibility(8);
            }

            var36 = this.viewDataBinding;
            var20 = var36;
            if (var36 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
               var20 = null;
            }

            var20.buttonCollapse.setOnClickListener(new DeviceSensorsFragment$$ExternalSyntheticLambda6(this));
            var20 = this.viewDataBinding;
            if (var20 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
               var20 = (FragmentDeviceSensorsBinding)var5;
            }

            MaterialButton var30 = var20.deviceGraph.getButtonInfo();
            if (var30 != null) {
               var30.setOnClickListener(new DeviceSensorsFragment$$ExternalSyntheticLambda7(this));
            }

            return;
         }

         Object var16 = var7.next();
         if (var1 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         SensorType var9 = (SensorType)var16;
         View var10 = LayoutInflater.from(this.getContext()).inflate(com.blueair.devicedetails.R.layout.sensor_item, (ViewGroup)null);
         FragmentDeviceSensorsBinding var34 = this.viewDataBinding;
         FragmentDeviceSensorsBinding var17 = var34;
         if (var34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var17 = null;
         }

         TabLayout.Tab var8 = var17.sensorTabs.newTab();
         Intrinsics.checkNotNullExpressionValue(var8, "newTab(...)");
         var8.setCustomView(var10);
         var8.view.setBackground((Drawable)null);
         var8.view.setPadding(12, 0, 12, 0);
         ((TextView)var10.findViewById(com.blueair.devicedetails.R.id.sensor_label)).setText(this.getSensorTitle(var9));
         ImageView var18 = (ImageView)var10.findViewById(com.blueair.devicedetails.R.id.sensor_color);
         if (!SetsKt.setOf(new SensorType[]{SensorType.HUM, SensorType.TMP}).contains(var9)) {
            var2 = 0;
         }

         var18.setVisibility(var2);
         var34 = this.viewDataBinding;
         FragmentDeviceSensorsBinding var19 = var34;
         if (var34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var19 = null;
         }

         var19.sensorTabs.addTab(var8);
         ViewCompat.setAccessibilityDelegate((View)var8.view, new AccessibilityDelegateCompat(this, var1) {
            final int $index;
            final DeviceSensorsFragment this$0;

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
         ++var1;
      }
   }

   private static final void initUi$lambda$18(DeviceSensorsFragment var0, View var1) {
      FragmentDeviceSensorsBinding var4 = var0.viewDataBinding;
      Object var2 = null;
      Object var3 = null;
      FragmentDeviceSensorsBinding var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      if (var6.fanGraph.getVisibility() == 0) {
         FragmentDeviceSensorsBinding var13 = var0.viewDataBinding;
         var6 = var13;
         if (var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.fanGraph.setVisibility(8);
         var13 = var0.viewDataBinding;
         var6 = var13;
         if (var13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.fanValue.setVisibility(4);
         FragmentDeviceSensorsBinding var5 = var0.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (FragmentDeviceSensorsBinding)var3;
         }

         var5.buttonCollapse.setIconResource(R.drawable.ic_chevron_down_marineblue);
      } else {
         FragmentDeviceSensorsBinding var15 = var0.viewDataBinding;
         var6 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.fanGraph.setVisibility(0);
         var15 = var0.viewDataBinding;
         var6 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.fanValue.setVisibility(0);
         var15 = var0.viewDataBinding;
         var6 = var15;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = null;
         }

         var6.buttonCollapse.setIconResource(R.drawable.ic_chevron_up_marineblue);
         var6 = var0.viewDataBinding;
         if (var6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var6 = (FragmentDeviceSensorsBinding)var2;
         }

         var6.fanGraph.post(new DeviceSensorsFragment$$ExternalSyntheticLambda0(var0));
         var0.getAnalyticsService().event(new AnalyticEvent.OPEN_FAN_HISTORY());
      }
   }

   private static final void initUi$lambda$18$lambda$17(DeviceSensorsFragment var0) {
      FragmentDeviceSensorsBinding var1 = var0.viewDataBinding;
      FragmentDeviceSensorsBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      var2.fanGraph.refresh();
   }

   private static final void initUi$lambda$20(DeviceSensorsFragment var0, View var1) {
      FragmentManager var7 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var7, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var7.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var7.isStateSaved()) {
         SensorType var5 = var0.getViewModel().getSelectedSensor();
         int var4 = var0.getSensorTitle(var5);
         int var2;
         switch (DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
            case 1:
               var2 = R.string.pm1_descript;
               break;
            case 2:
               var2 = R.string.pm25_descript;
               break;
            case 3:
               var2 = R.string.pm10_descript;
               break;
            case 4:
               var2 = R.string.voc_descript;
               break;
            case 5:
               var2 = R.string.hcho_descript;
               break;
            case 6:
               var2 = R.string.humid_descript;
               break;
            case 7:
               var2 = R.string.temp_descript;
               break;
            case 8:
            case 9:
            case 10:
               var2 = 0;
               break;
            default:
               throw new NoWhenBranchMatchedException();
         }

         int var3 = DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
         Integer var6;
         if (var3 != 1 && var3 != 2 && var3 != 3) {
            if (var3 != 4) {
               if (var3 != 5) {
                  if (var3 != 7) {
                     var6 = null;
                  } else {
                     if (var0.getViewModel().isTempCelsius()) {
                        var3 = R.string.temperature_celsius;
                     } else {
                        var3 = R.string.temperature_fahrenheit;
                     }

                     var6 = var3;
                  }
               } else {
                  var6 = R.string.mg_m3;
               }
            } else {
               var6 = R.string.voc_unit;
            }
         } else {
            var6 = R.string.µg_m3;
         }

         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, var4, var6, var2, R.string.close, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8128, (Object)null)).show(var7, "ConfirmationDialogLeftAligned");
      }

   }

   private final void observeViewModel() {
      this.getViewModel().getLiveSelectedSensor().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda8(this));
      this.getViewModel().getLiveSelectedSensorHistoricalData().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda11(this));
      this.getViewModel().getLiveSelectedSensorRealTimeData().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda12(this));
      this.getViewModel().getHistoricalDataListener().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda13());
      this.getViewModel().getRealTimeDataListener().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda14());
      FragmentDeviceSensorsBinding var3 = this.viewDataBinding;
      Object var2 = null;
      FragmentDeviceSensorsBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.deviceGraph.getLiveSelectedDataPoint().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda1(this));
      if (this.getViewModel().getShowFanHistory()) {
         var3 = this.viewDataBinding;
         var1 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = null;
         }

         var1.deviceGraph.getLiveScale().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda2(this));
         var3 = this.viewDataBinding;
         var1 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = null;
         }

         var1.deviceGraph.getLiveTimeStamps().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda3(this));
         var3 = this.viewDataBinding;
         var1 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = null;
         }

         var1.fanGraph.getLiveScale().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda4(this));
         this.getViewModel().getLiveFanSensorHistoricalData().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda5(this));
         this.getViewModel().getLiveFanSensorRealTimeData().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda9(this));
         var1 = this.viewDataBinding;
         if (var1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var1 = (FragmentDeviceSensorsBinding)var2;
         }

         var1.fanGraph.getLiveSelectedDataPoint().observe(this.getViewLifecycleOwner(), new DeviceSensorsFragment$$ExternalSyntheticLambda10(this));
      }

   }

   private static final void observeViewModel$lambda$10(DeviceSensorsFragment var0, GraphView.ScaleEvent var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("fanGraph.liveScale: scale = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      if (var1.getExplicit()) {
         FragmentDeviceSensorsBinding var5 = var0.viewDataBinding;
         FragmentDeviceSensorsBinding var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var4 = null;
         }

         GraphView.updateScale$default(var4.deviceGraph, var1.getTimeScale(), false, 2, (Object)null);
      }

   }

   private static final void observeViewModel$lambda$11(DeviceSensorsFragment var0, List var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("liveFanSensorHistoricalData: size = ");
      var2.append(var1.size());
      var2.append(", thread = ");
      var2.append(Thread.currentThread());
      var3.d(var2.toString(), new Object[0]);
      LifecycleOwner var4 = var0.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var4, "getViewLifecycleOwner(...)");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var4), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, var0, (Continuation)null) {
         final List $data;
         int label;
         final DeviceSensorsFragment this$0;

         {
            this.$data = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$data, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Timber.Forest var3 = Timber.Forest;
               StringBuilder var6 = new StringBuilder("liveFanSensorHistoricalData: size = ");
               var6.append(this.$data.size());
               var6.append(", thread = ");
               var6.append(Thread.currentThread());
               var3.d(var6.toString(), new Object[0]);
               FragmentDeviceSensorsBinding var9 = this.this$0.viewDataBinding;
               FragmentDeviceSensorsBinding var7 = var9;
               if (var9 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var7 = null;
               }

               FanHistoryGraphView var8 = var7.fanGraph;
               List var5 = this.$data;
               Intrinsics.checkNotNull(var5);
               Continuation var10 = (Continuation)this;
               this.label = 1;
               if (var8.updateHistorical(var5, var10) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final void observeViewModel$lambda$12(DeviceSensorsFragment var0, List var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("liveFanSensorRealTimeData: size = ");
      var3.append(var1.size());
      var3.append(", thread = ");
      var3.append(Thread.currentThread());
      var2.d(var3.toString(), new Object[0]);
      LifecycleOwner var4 = var0.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var4, "getViewLifecycleOwner(...)");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var4), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, var0, (Continuation)null) {
         final List $data;
         int label;
         final DeviceSensorsFragment this$0;

         {
            this.$data = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$data, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Timber.Forest var6 = Timber.Forest;
               StringBuilder var3 = new StringBuilder("liveFanSensorRealTimeData: size = ");
               var3.append(this.$data.size());
               var3.append(", thread = ");
               var3.append(Thread.currentThread());
               var6.d(var3.toString(), new Object[0]);
               FragmentDeviceSensorsBinding var9 = this.this$0.viewDataBinding;
               FragmentDeviceSensorsBinding var7 = var9;
               if (var9 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var7 = null;
               }

               FanHistoryGraphView var5 = var7.fanGraph;
               List var8 = this.$data;
               Intrinsics.checkNotNull(var8);
               Continuation var10 = (Continuation)this;
               this.label = 1;
               if (var5.updateRealTime(var8, var10) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final void observeViewModel$lambda$13(DeviceSensorsFragment var0, GraphView.SelectedPoint var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("fanGraph.liveSelectedDataPoint: explicit = ");
      var2.append(var1.getExplicit());
      var3.d(var2.toString(), new Object[0]);
      FragmentDeviceSensorsBinding var4 = var0.viewDataBinding;
      Object var7 = null;
      FragmentDeviceSensorsBinding var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.fanValue.setText((CharSequence)String.valueOf(MathKt.roundToInt(var1.getPoint().getValue())));
      if (var1.getExplicit()) {
         FragmentDeviceSensorsBinding var5 = var0.viewDataBinding;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var5 = (FragmentDeviceSensorsBinding)var7;
         }

         var5.deviceGraph.gotoTime(var1.getPoint().getTimeInMillis());
      }

   }

   private static final void observeViewModel$lambda$2(DeviceSensorsFragment var0, SensorType var1) {
      if (var1 != null) {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var2 = new StringBuilder("selected sensor = ");
         var2.append(var1);
         var3.d(var2.toString(), new Object[0]);
         FragmentDeviceSensorsBinding var5 = var0.viewDataBinding;
         FragmentDeviceSensorsBinding var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var4 = null;
         }

         var4.deviceGraph.setSensorType(var1);
         var0.updateSensorInfo(var1);
      }

   }

   private static final void observeViewModel$lambda$3(DeviceSensorsFragment var0, List var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("liveSelectedSensorHistoricalData: size = ");
      var3.append(var1.size());
      var3.append(", thread = ");
      var3.append(Thread.currentThread());
      var2.d(var3.toString(), new Object[0]);
      LifecycleOwner var4 = var0.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var4, "getViewLifecycleOwner(...)");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var4), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, (Continuation)null) {
         final List $data;
         int label;
         final DeviceSensorsFragment this$0;

         {
            this.this$0 = var1;
            this.$data = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$data, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               FragmentDeviceSensorsBinding var4 = this.this$0.viewDataBinding;
               FragmentDeviceSensorsBinding var8 = var4;
               if (var4 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var8 = null;
               }

               IndoorGraphView var7 = var8.deviceGraph;
               List var10 = this.$data;
               Intrinsics.checkNotNull(var10);
               boolean var3 = this.this$0.getViewModel().isTempCelsius();
               IndoorAirRatingRanges var9 = this.this$0.getViewModel().getIndoorAirRatings();
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var7.updateHistorical(var10, var3, var9, var6) == var5) {
                  return var5;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final void observeViewModel$lambda$4(DeviceSensorsFragment var0, List var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("liveSelectedSensorRealTimeData: size = ");
      var2.append(var1.size());
      var2.append(", time = ");
      var2.append(Calendar.getInstance().getTime());
      var3.d(var2.toString(), new Object[0]);
      LifecycleOwner var4 = var0.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var4, "getViewLifecycleOwner(...)");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var4), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, (Continuation)null) {
         final List $data;
         int label;
         final DeviceSensorsFragment this$0;

         {
            this.this$0 = var1;
            this.$data = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$data, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               FragmentDeviceSensorsBinding var4 = this.this$0.viewDataBinding;
               FragmentDeviceSensorsBinding var8 = var4;
               if (var4 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var8 = null;
               }

               IndoorGraphView var9 = var8.deviceGraph;
               List var6 = this.$data;
               Intrinsics.checkNotNull(var6);
               boolean var3 = this.this$0.getViewModel().isTempCelsius();
               IndoorAirRatingRanges var10 = this.this$0.getViewModel().getIndoorAirRatings();
               Continuation var7 = (Continuation)this;
               this.label = 1;
               if (var9.updateRealTime(var6, var3, var10, var7) == var5) {
                  return var5;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final void observeViewModel$lambda$5(Object var0) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("historicalDataListener: thread = ");
      var1.append(Thread.currentThread());
      var2.d(var1.toString(), new Object[0]);
   }

   private static final void observeViewModel$lambda$6(Object var0) {
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("realTimeDataListener: thread = ");
      var2.append(Thread.currentThread());
      var1.d(var2.toString(), new Object[0]);
   }

   private static final void observeViewModel$lambda$7(DeviceSensorsFragment var0, GraphView.SelectedPoint var1) {
      LifecycleOwner var2 = var0.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var2, "getViewLifecycleOwner(...)");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var2), (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(var1, var0, (Continuation)null) {
         final GraphView.SelectedPoint $it;
         int label;
         final DeviceSensorsFragment this$0;

         {
            this.$it = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$it, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            Object var3 = null;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               CoroutineContext var4 = (CoroutineContext)Dispatchers.getIO();
               Function2 var6 = new Function2(this.this$0, this.$it, (Continuation)null) {
                  final GraphView.SelectedPoint $it;
                  int label;
                  final DeviceSensorsFragment this$0;

                  {
                     this.this$0 = var1;
                     this.$it = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        return this.this$0.getIndoorDataForTimestamp(this.$it.getPoint().getTimeInSeconds());
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var7 = (Continuation)this;
               this.label = 1;
               Object var10 = BuildersKt.withContext(var4, var6, var7);
               var1 = var10;
               if (var10 == var5) {
                  return var5;
               }
            }

            IndoorDatapoint var11 = (IndoorDatapoint)var1;
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var12 = new StringBuilder("deviceGraph.liveSelectedDataPoint: explicit = ");
            var12.append(this.$it.getExplicit());
            var12.append(", graph = ");
            var12.append(this.$it.getPoint());
            var12.append(" ; indoorDataPoint = ");
            var12.append(var11);
            var8.d(var12.toString(), new Object[0]);
            DeviceSensorsFragment.updateTabs$default(this.this$0, var11, (AqiData)null, 2, (Object)null);
            if (this.this$0.getViewModel().getShowFanHistory() && this.$it.getExplicit()) {
               FragmentDeviceSensorsBinding var9 = this.this$0.viewDataBinding;
               if (var9 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                  var9 = (FragmentDeviceSensorsBinding)var3;
               }

               var9.fanGraph.gotoTime(this.$it.getPoint().getTimeInMillis());
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final void observeViewModel$lambda$8(DeviceSensorsFragment var0, GraphView.ScaleEvent var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("deviceGraph.liveScale: scale = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      if (var1.getExplicit()) {
         FragmentDeviceSensorsBinding var5 = var0.viewDataBinding;
         FragmentDeviceSensorsBinding var4 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var4 = null;
         }

         GraphView.updateScale$default(var4.fanGraph, var1.getTimeScale(), false, 2, (Object)null);
      }

   }

   private static final void observeViewModel$lambda$9(DeviceSensorsFragment var0, Set var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("deviceGraphliveTimeStamps: timeStamps = ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      FragmentDeviceSensorsBinding var6 = var0.viewDataBinding;
      FragmentDeviceSensorsBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var4 = null;
      }

      FanHistoryGraphView var5 = var4.fanGraph;
      Intrinsics.checkNotNull(var1);
      var5.setTimeStampFilter(var1);
   }

   private final void updateSelectedTab(TabLayout.Tab var1, boolean var2) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("updateSelected: tab = ");
      var5.append(var1.getPosition());
      var5.append(", selected = ");
      var5.append(var2);
      var4.d(var5.toString(), new Object[0]);
      SensorItemBinding var6 = SensorItemBinding.bind((View)var1.view);
      Intrinsics.checkNotNullExpressionValue(var6, "bind(...)");
      var6.sensorLabel.setSelected(var2);
      var6.sensorVal.setSelected(var2);
      var6.sensorAltVal.setSelected(var2);
      LinearLayout var7 = var6.sensorLayout;
      float var3;
      if (var2) {
         var3 = 1.0F;
      } else {
         var3 = 0.9F;
      }

      var7.setAlpha(var3);
      var7.setSelected(var2);
   }

   private final void updateSensorInfo(SensorType var1) {
      FragmentDeviceSensorsBinding var4 = this.viewDataBinding;
      Object var3 = null;
      FragmentDeviceSensorsBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var2 = null;
      }

      MaterialButton var5 = var2.deviceGraph.getButtonInfo();
      if (var5 != null) {
         ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
      }

      FragmentDeviceSensorsBinding var6 = this.viewDataBinding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = (FragmentDeviceSensorsBinding)var3;
      }

      MaterialButton var8 = var6.deviceGraph.getButtonInfo();
      if (var8 != null) {
         StringBuilder var7 = new StringBuilder();
         var7.append(this.getString(R.string.title_activity_about));
         var7.append(' ');
         var7.append(this.getString(this.getSensorTitle(var1)));
         var8.setText((CharSequence)var7.toString());
      }

   }

   private final void updateTabs(IndoorDatapoint var1, AqiData var2) {
      if (this.tabSelected) {
         this.tabSelected = false;
      } else {
         for(SensorType var8 : (Iterable)this.getViewModel().getSupportedSensors()) {
            Object var6;
            Float var13;
            label104: {
               IndoorAirRatingRanges var4 = this.getViewModel().getIndoorAirRatings();
               int var3 = DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()];
               var6 = null;
               switch (var3) {
                  case 1:
                     if (var1 != null) {
                        Float var18 = var1.getPm1();
                        if (var18 != null) {
                           var13 = RangesKt.coerceAtMost(var18, (float)ArraysKt.last(var4.getPm1Ranges()));
                           break label104;
                        }
                     }
                     break;
                  case 2:
                     if (var1 != null) {
                        Float var17 = var1.getPm25();
                        if (var17 != null) {
                           var13 = RangesKt.coerceAtMost(var17, (float)ArraysKt.last(var4.getPm25Ranges()));
                           break label104;
                        }
                     }
                     break;
                  case 3:
                     if (var1 != null) {
                        Float var16 = var1.getPm10();
                        if (var16 != null) {
                           var13 = RangesKt.coerceAtMost(var16, (float)ArraysKt.last(var4.getPm10Ranges()));
                           break label104;
                        }
                     }
                     break;
                  case 4:
                     if (var1 != null) {
                        Float var15 = var1.getVoc();
                        if (var15 != null) {
                           var13 = RangesKt.coerceAtMost(var15, (float)ArraysKt.last(var4.getVocRanges()));
                           break label104;
                        }
                     }
                     break;
                  case 5:
                     if (var1 != null) {
                        Float var5 = var1.getHcho();
                        if (var5 != null) {
                           var13 = RangesKt.coerceAtMost(var5, (float)ArraysKt.last(var4.getHchoRanges()));
                           break label104;
                        }
                     }
                     break;
                  case 6:
                     if (var1 != null) {
                        var13 = var1.getHum();
                        break label104;
                     }
                     break;
                  case 7:
                     if (var1 != null) {
                        var13 = var1.getTmp();
                        break label104;
                     }
                     break;
                  case 8:
                     if (var1 != null) {
                        var13 = var1.getFan();
                        break label104;
                     }
                     break;
                  case 9:
                     if (var1 != null) {
                        var13 = var1.getWeight();
                        break label104;
                     }
                     break;
                  case 10:
                     if (var1 != null) {
                        var13 = var1.getRpm();
                        break label104;
                     }
                     break;
                  default:
                     throw new NoWhenBranchMatchedException();
               }

               var13 = null;
            }

            int var11 = DeviceSensorsFragment.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()];
            Double var19;
            if (var11 != 2) {
               if (var11 != 3) {
                  var19 = (Double)var6;
               } else {
                  var19 = (Double)var6;
                  if (var2 != null) {
                     OutdoorPollutants var9 = var2.getPollutants();
                     var19 = (Double)var6;
                     if (var9 != null) {
                        Pollutant var22 = var9.getPm10();
                        var19 = (Double)var6;
                        if (var22 != null) {
                           var19 = var22.getConcentration();
                        }
                     }
                  }
               }
            } else {
               var19 = (Double)var6;
               if (var2 != null) {
                  OutdoorPollutants var23 = var2.getPollutants();
                  var19 = (Double)var6;
                  if (var23 != null) {
                     Pollutant var24 = var23.getPm25();
                     var19 = (Double)var6;
                     if (var24 != null) {
                        var19 = var24.getConcentration();
                     }
                  }
               }
            }

            TabLayout.Tab var20 = this.getTab(var8);
            if (var20 != null) {
               SensorItemBinding var10 = SensorItemBinding.bind((View)var20.view);
               Intrinsics.checkNotNullExpressionValue(var10, "bind(...)");
               TextView var25 = var10.sensorVal;
               Intrinsics.checkNotNullExpressionValue(var25, "sensorVal");
               TextView var21 = var10.sensorAltVal;
               Intrinsics.checkNotNullExpressionValue(var21, "sensorAltVal");
               ImageView var26 = var10.sensorColor;
               Intrinsics.checkNotNullExpressionValue(var26, "sensorColor");
               var25.setText((CharSequence)var8.formatValue(var13));
               if (var13 != null) {
                  var11 = this.getViewModel().getIndoorAirRatings().getRangePosition(var13, var8);
                  if (var11 < 0 || var11 >= GraphUiUtils.INSTANCE.getSeverityDots().size()) {
                     var11 = GraphUiUtils.INSTANCE.getSeverityDots().size() - 1;
                  }

                  var26.setImageResource(((Number)GraphUiUtils.INSTANCE.getSeverityDots().get(var11)).intValue());
               } else {
                  var26.setImageResource(R.drawable.ic_marker_dot_good);
               }

               if (var13 != null && var19 != null) {
                  StringBuilder var14 = new StringBuilder("(");
                  var14.append(MathKt.roundToInt(var19));
                  var14.append(')');
                  var21.setText((CharSequence)var14.toString());
                  var21.setVisibility(0);
               } else {
                  var21.setVisibility(8);
               }
            }
         }

      }
   }

   // $FF: synthetic method
   static void updateTabs$default(DeviceSensorsFragment var0, IndoorDatapoint var1, AqiData var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.updateTabs(var1, var2);
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
      FragmentDeviceSensorsBinding var18 = FragmentDeviceSensorsBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var18, "inflate(...)");
      var18.setDeviceSensorViewModel((DeviceSensorsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceSensorsViewModel.class)));
      var18.setLifecycleOwner(this.getViewLifecycleOwner());
      this.viewDataBinding = var18;
      Object var17 = null;
      FragmentDeviceSensorsBinding var6 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      ViewGroup.LayoutParams var4 = var6.getRoot().getLayoutParams();
      var4.height = -1;
      var4.width = -1;
      var18 = this.viewDataBinding;
      var6 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.getRoot().setLayoutParams(var4);
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var25 = new StringBuilder("onCreateView: viewDataBinding = ");
      var18 = this.viewDataBinding;
      var6 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var25.append(var6);
      var25.append(", root = ");
      var18 = this.viewDataBinding;
      var6 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var25.append(var6.getRoot());
      var25.append(", outdoorViewModel = ");
      var18 = this.viewDataBinding;
      var6 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var25.append(var6.getDeviceSensorViewModel());
      var5.d(var25.toString(), new Object[0]);
      var18 = this.viewDataBinding;
      var6 = var18;
      if (var18 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      DeviceSensorsViewModel var12 = var6.getDeviceSensorViewModel();
      if (var12 != null) {
         this.setViewModel(var12);
         DeviceSensorsViewModel var24 = this.getViewModel();
         Bundle var13 = this.getArguments();
         HasSensorData var14;
         if (var13 != null) {
            var14 = (HasSensorData)var13.getParcelable("KEY_DEVICE");
         } else {
            var14 = null;
         }

         if (var14 != null) {
            DeviceSensorsViewModel.init$default(var24, var14, false, 2, (Object)null);
            FragmentDeviceSensorsBinding var15 = this.viewDataBinding;
            if (var15 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
               var15 = (FragmentDeviceSensorsBinding)var17;
            }

            View var16 = var15.getRoot();
            Intrinsics.checkNotNullExpressionValue(var16, "getRoot(...)");
            return var16;
         } else {
            throw new IllegalStateException("Required value was null.".toString());
         }
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onDestroyView() {
      super.onDestroyView();
   }

   public void onResume() {
      super.onResume();
      this.getViewModel().refresh();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.initUi();
      this.observeViewModel();
   }

   public void setViewModel(DeviceSensorsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSensorsFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "KEY_DEVICE", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSensorsFragment;", "device", "Lcom/blueair/core/model/HasSensorData;", "devicedetails_otherRelease"},
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
         return DeviceSensorsFragment.TAG;
      }

      public final DeviceSensorsFragment newInstance(HasSensorData var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceSensorsFragment var3 = new DeviceSensorsFragment();
         Bundle var2 = new Bundle();
         var2.putParcelable("KEY_DEVICE", var1);
         var3.setArguments(var2);
         return var3;
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
