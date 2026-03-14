package com.blueair.android.viewholder;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.HolderDeviceBinding;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoLevel;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWaterTank;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.WaterLevel;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.util.DisinfectionUtils;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;

@Metadata(
   d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020(H\u0002J\u001a\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u001f\u00103\u001a\u00020\"2\u0006\u0010#\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\"H\u0002J\u0010\u00109\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010:\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010;\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\"2\u0006\u0010#\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u0002022\u0006\u0010B\u001a\u000202H\u0002J\u0018\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0002J \u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u0002022\u0006\u0010B\u001a\u0002022\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\"2\u0006\u0010B\u001a\u000202H\u0002J\u0010\u0010H\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010I\u001a\u00020\"2\u0006\u0010#\u001a\u00020JH\u0002J\u001a\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u0002022\b\b\u0002\u0010M\u001a\u00020(H\u0002J\u001a\u0010N\u001a\u00020\"2\u0006\u0010#\u001a\u0002042\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010O\u001a\u00020\"H\u0002J\b\u0010P\u001a\u00020\"H\u0002J!\u0010Q\u001a\u00020\"2\u0012\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140S\"\u00020\u0014H\u0002¢\u0006\u0002\u0010TJ\u0010\u0010U\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010V\u001a\u0002022\u0006\u0010W\u001a\u000202H\u0002J)\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u0002022\u0012\u0010Z\u001a\n\u0012\u0006\b\u0001\u0012\u00020[0S\"\u00020[H\u0002¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u000200H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"},
   d2 = {"Lcom/blueair/android/viewholder/DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lorg/kodein/di/DIAware;", "binding", "Lcom/blueair/android/databinding/HolderDeviceBinding;", "<init>", "(Lcom/blueair/android/databinding/HolderDeviceBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/HolderDeviceBinding;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "standByModeClickView", "Landroid/view/View;", "getStandByModeClickView", "()Landroid/view/View;", "offlineInfoView", "getOfflineInfoView", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getTimeFormatter", "()Ljava/text/SimpleDateFormat;", "timeFormatter$delegate", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "update", "", "device", "Lcom/blueair/core/model/Device;", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "forceOffline", "", "hydrateStandby", "offline", "setOnlineDevice", "hydrateMode", "mode", "Lcom/blueair/core/model/Mode;", "formatCountdownText", "", "leftSeconds", "", "hydrateHumidity", "Lcom/blueair/core/model/HasSensorData;", "hum", "", "(Lcom/blueair/core/model/HasSensorData;Ljava/lang/Float;)V", "setOfflineDevice", "setSafetySwitchOffDevice", "showDeviceMode", "showDeviceApSubMode", "subMode", "Lcom/blueair/core/model/ApSubMode;", "showDeviceCoolSubMode", "Lcom/blueair/core/model/HasCoolMainMode;", "showMode", "offset", "iconRes", "modeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "text", "", "showWarning", "showFilterWickStatus", "hydrateTimer", "Lcom/blueair/core/model/HasTimer;", "hydrateFilterStatus", "lifeLeft", "wickFilter", "showAirQuality", "hideMode1", "hideMode2", "hideViews", "views", "", "([Landroid/view/View;)V", "hydrateAlarm", "getColor", "colorRes", "getString", "textRes", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "fetchPattern", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceViewHolder extends RecyclerView.ViewHolder implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceViewHolder.class, "di", "getDi()Lorg/kodein/di/DI;", 0)))};
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceBinding binding;
   private final Calendar calendar;
   private final ConstraintLayout clickView;
   private final Lazy di$delegate;
   private final View offlineInfoView;
   private final View standByModeClickView;
   private final Lazy timeFormatter$delegate;

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$j8e9l3g0K4HTs_CisPuxs0EyRak(DeviceViewHolder var0) {
      return timeFormatter_delegate$lambda$0(var0);
   }

   public DeviceViewHolder(HolderDeviceBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      Context var2 = this.itemView.getContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getContext(...)");
      this.di$delegate = ClosestKt.closestDI(var2).provideDelegate(this, $$delegatedProperties[0]);
      ConstraintLayout var4 = var1.foregroundLayout;
      Intrinsics.checkNotNullExpressionValue(var4, "foregroundLayout");
      this.clickView = var4;
      SwitchCompat var5 = var1.standbySwitch;
      Intrinsics.checkNotNullExpressionValue(var5, "standbySwitch");
      this.standByModeClickView = (View)var5;
      ImageView var6 = var1.ivOfflineInfo;
      Intrinsics.checkNotNullExpressionValue(var6, "ivOfflineInfo");
      this.offlineInfoView = (View)var6;
      this.timeFormatter$delegate = LazyKt.lazy(new DeviceViewHolder$$ExternalSyntheticLambda0(this));
      this.calendar = Calendar.getInstance();
      ViewUtils var7 = ViewUtils.INSTANCE;
      ConstraintLayout var3 = var1.foregroundLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "foregroundLayout");
      ViewUtils.setAccessibilityDelegate$default(var7, (View)var3, (KClass)null, this.getString(R.string.button_role), (Function2)null, 10, (Object)null);
      var1.ivOfflineInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{this.getString(R.string.offline_label)}));
   }

   private final String fetchPattern() {
      return DateFormat.is24HourFormat(this.itemView.getContext()) ? "HH:mm" : "hh:mm a";
   }

   private final String formatCountdownText(int var1) {
      var1 = (int)Math.ceil((double)var1 / (double)60.0F);
      String var2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{var1 / 60, var1 % 60}, 2));
      Intrinsics.checkNotNullExpressionValue(var2, "format(...)");
      return var2;
   }

   private final int getColor(int var1) {
      return this.itemView.getContext().getColor(var1);
   }

   private final String getString(int var1, Object... var2) {
      String var3 = this.itemView.getContext().getString(var1, Arrays.copyOf(var2, var2.length));
      Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
      return var3;
   }

   private final SimpleDateFormat getTimeFormatter() {
      return (SimpleDateFormat)this.timeFormatter$delegate.getValue();
   }

   private final void hideMode1() {
      LinearLayout var1 = this.binding.llMode1;
      Intrinsics.checkNotNullExpressionValue(var1, "llMode1");
      ((View)var1).setVisibility(8);
   }

   private final void hideMode2() {
      LinearLayout var1 = this.binding.llMode2;
      Intrinsics.checkNotNullExpressionValue(var1, "llMode2");
      ((View)var1).setVisibility(8);
   }

   private final void hideViews(View... var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var1[var2].setVisibility(8);
      }

   }

   private final void hydrateAlarm(Device var1) {
      if (var1 instanceof HasAlarm) {
         this.calendar.setTimeZone(var1.getTimezone(this.itemView.getContext()));
         this.calendar.setTimeInMillis(System.currentTimeMillis());
         int var2 = this.calendar.get(11);
         int var3 = this.calendar.get(12);
         int var4 = this.calendar.get(7);
         int var6 = var2 * 3600 + var3 * 60 + this.calendar.get(13);
         Ref.IntRef var10 = new Ref.IntRef();
         var10.element = 86400;
         Ref.IntRef var8 = new Ref.IntRef();
         var8.element = 7;
         Ref.BooleanRef var9 = new Ref.BooleanRef();
         Iterator var12 = ((Iterable)((HasAlarm)var1).getAlarms()).iterator();

         while(true) {
            boolean var7 = var12.hasNext();
            var2 = 0;
            var3 = 0;
            if (!var7) {
               if (var10.element < 86400) {
                  var2 = var10.element / 3600;
                  this.calendar.set(11, var2);
                  this.calendar.set(12, (var10.element - var2 * 3600) / 60);
                  String var13 = this.fetchPattern();
                  this.getTimeFormatter().setTimeZone(this.calendar.getTimeZone());
                  if (!Intrinsics.areEqual(var13, this.getTimeFormatter().toPattern())) {
                     this.getTimeFormatter().applyPattern(var13);
                  }

                  this.binding.itvAlarm.setText(this.getTimeFormatter().format(this.calendar.getTime()));
                  SimpleIconTextView var14 = this.binding.itvAlarm;
                  Intrinsics.checkNotNullExpressionValue(var14, "itvAlarm");
                  ViewExtensionsKt.show$default((View)var14, false, 1, (Object)null);
               }
               break;
            }

            DeviceAlarm var11 = (DeviceAlarm)var12.next();
            if (var11 != null && var11.getEnabled() && !var9.element) {
               int var5 = var11.getSecondsInDay();
               BitSet var20 = BitSet.valueOf(new byte[]{(byte)var11.getRepeats()});
               if (var20.get(7)) {
                  if (var5 >= var6) {
                     var2 = var3;
                  } else {
                     var2 = 1;
                  }

                  hydrateAlarm$checkEarliest(86400, var8, var10, var9, var6, var2, var5);
               } else {
                  var3 = var8.element;
                  if (var3 >= 0) {
                     while(true) {
                        if ((var2 != 0 || var5 >= var6) && var20.get((var2 + (var4 + 5) % 7) % 7)) {
                           hydrateAlarm$checkEarliest(86400, var8, var10, var9, var6, var2, var5);
                           if (var9.element) {
                              return;
                           }
                        }

                        if (var2 == var3) {
                           break;
                        }

                        ++var2;
                     }
                  }
               }
            }
         }
      }

   }

   private static final boolean hydrateAlarm$checkEarliest(int var0, Ref.IntRef var1, Ref.IntRef var2, Ref.BooleanRef var3, int var4, int var5, int var6) {
      int var8 = var5 * var0 + var6;
      int var7 = var1.element;
      int var9 = var2.element;
      boolean var10 = false;
      if (var7 * var0 + var9 > var8) {
         var1.element = var5;
         var2.element = var6;
         if (var8 == var4) {
            var10 = true;
         }

         var3.element = var10;
         return true;
      } else {
         return false;
      }
   }

   private final void hydrateFilterStatus(int var1, boolean var2) {
      if (ArraysKt.contains(new int[]{0, 5, 10}, var1)) {
         if (var2) {
            this.binding.tvWickFilterStatus.setText((CharSequence)this.getString(R.string.wick_filter_left, var1));
            TextView var4 = this.binding.tvWickFilterStatus;
            Intrinsics.checkNotNullExpressionValue(var4, "tvWickFilterStatus");
            ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
            return;
         }

         this.binding.tvAirFilterStatus.setText((CharSequence)this.getString(R.string.air_filter_left, var1));
         TextView var3 = this.binding.tvAirFilterStatus;
         Intrinsics.checkNotNullExpressionValue(var3, "tvAirFilterStatus");
         ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
      }

   }

   // $FF: synthetic method
   static void hydrateFilterStatus$default(DeviceViewHolder var0, int var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.hydrateFilterStatus(var1, var2);
   }

   private final void hydrateHumidity(HasSensorData var1, Float var2) {
      int var11;
      label15: {
         var11 = R.color.fill_grey;
         int var4 = var11;
         if (var2 != null) {
            float var3 = ((Number)var2).floatValue();
            IndoorAirStatusLabel var6 = IndoorAirStatusLabel.Companion.fromValueAndSensor(var1, (double)var2, SensorType.HUM);
            var4 = var11;
            if (var6 != null) {
               var4 = var6.getColorRes();
            }

            String var9 = this.getString(R.string.humidity_value, MathKt.roundToInt(var3));
            var11 = var4;
            var7 = var9;
            if (var9 != null) {
               break label15;
            }
         }

         var7 = this.getString(R.string.label_reading);
         var11 = var4;
      }

      this.binding.ivDegreeIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(this.binding.ivDegreeIndicator.getContext(), var11));
      View var10 = this.binding.ivDegreeIndicator;
      Intrinsics.checkNotNullExpressionValue(var10, "ivDegreeIndicator");
      ViewExtensionsKt.show$default(var10, false, 1, (Object)null);
      this.binding.tvDegree.setText((CharSequence)var7);
      TextView var8 = this.binding.tvDegree;
      Intrinsics.checkNotNullExpressionValue(var8, "tvDegree");
      ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
   }

   private final void hydrateMode(Device var1, Mode var2) {
      int var3 = DeviceViewHolder.WhenMappings.$EnumSwitchMapping$2[var2.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               if (var3 != 4) {
                  if (var3 == 5) {
                     this.showMode(1, ModeIcon.SKIN);
                  } else {
                     throw new NoWhenBranchMatchedException();
                  }
               } else {
                  this.showMode(1, ModeIcon.ECO);
               }
            } else {
               this.showMode(1, ModeIcon.NIGHT);
            }
         } else {
            this.showMode(1, ModeIcon.AUTO.proofread(var1));
         }
      } else {
         this.showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), (CharSequence)String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(var1)));
      }
   }

   private final void hydrateStandby(Device var1, boolean var2) {
      HolderDeviceBinding var5 = this.binding;
      boolean var4 = var1 instanceof HasStandBy;
      boolean var3 = false;
      if (!var4) {
         SwitchCompat var6 = var5.standbySwitch;
         Intrinsics.checkNotNullExpressionValue(var6, "standbySwitch");
         ViewExtensionsKt.show((View)var6, false);
      } else {
         if (var2 || !DeviceKt.isSafetySwitchOn(var1)) {
            var3 = true;
         }

         var5.standbySwitch.setEnabled(var3 ^ true);
         var5.standbySwitch.setChecked(((HasStandBy)var1).isStandByOn() ^ true);
      }
   }

   private final void hydrateTimer(HasTimer var1) {
      int var2 = var1.getLeftSeconds();
      if (var2 > 0) {
         this.binding.tvTimer.setText((CharSequence)this.formatCountdownText(var2));
         LinearLayout var3 = this.binding.llTimer;
         Intrinsics.checkNotNullExpressionValue(var3, "llTimer");
         ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
      }

   }

   private final void setOfflineDevice() {
      this.hideMode1();
      HolderDeviceBinding var1 = this.binding;
      this.showMode(1, 0, (CharSequence)this.getString(R.string.offline_label));
      ImageView var2 = var1.ivOfflineInfo;
      Intrinsics.checkNotNullExpressionValue(var2, "ivOfflineInfo");
      ViewExtensionsKt.show$default((View)var2, false, 1, (Object)null);
      TextView var3 = var1.safetySwitchText;
      Intrinsics.checkNotNullExpressionValue(var3, "safetySwitchText");
      ViewExtensionsKt.hide((View)var3);
      var1.deviceName.setTextColor(this.getColor(R.color.surface_dark_55));
   }

   private final void setOnlineDevice(Device var1, IndoorDatapoint var2) {
      HolderDeviceBinding var6 = this.binding;
      var6.deviceName.setTextColor(this.getColor(R.color.colorPrimaryText));
      ImageView var23 = var6.childLockIcon;
      Intrinsics.checkNotNullExpressionValue(var23, "childLockIcon");
      View var24 = (View)var23;
      boolean var5;
      if (var1 instanceof HasChildLock && ((HasChildLock)var1).isChildLockOn()) {
         var5 = true;
      } else {
         var5 = false;
      }

      ViewExtensionsKt.show(var24, var5);
      var5 = var1 instanceof HasWick;
      Object var8 = null;
      Object var9 = null;
      DevicePet20 var7 = null;
      Object var12 = null;
      Object var11 = null;
      Object var10 = null;
      HasWick var25;
      if (var5) {
         var25 = (HasWick)var1;
      } else {
         var25 = null;
      }

      if (var25 != null && var25.getWickdryOn()) {
         this.hideMode1();
         String var49 = this.formatCountdownText(((HasWick)var1).getWickDryLeftSeconds());
         this.showMode(1, R.drawable.icon_dry_mode_flat, (CharSequence)var49);
         if (var1 instanceof HasSensorData && !DeviceKt.isStandByOn(var1)) {
            HasSensorData var58 = (HasSensorData)var1;
            Float var50 = (Float)var10;
            if (var2 != null) {
               var50 = var2.getHum();
            }

            this.hydrateHumidity(var58, var50);
            if (DeviceKt.hasAirFilter(var1)) {
               this.showAirQuality(var58, var2);
            }
         }

         this.showFilterWickStatus(var1);
      } else if (DeviceKt.isDisinfectionOn(var1)) {
         this.hideMode1();
         DisinfectionUtils var26 = DisinfectionUtils.INSTANCE;
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasDisinfection");
         String var27 = var26.getCountdownText((HasDisinfection)var1);
         this.showMode(1, ModeIcon.DISINFECTION.getFlatIcon(), (CharSequence)var27);
         if (var1 instanceof HasSensorData && DeviceKt.hasAirFilter(var1)) {
            this.showAirQuality((HasSensorData)var1, var2);
         }

         this.showFilterWickStatus(var1);
      } else if (DeviceKt.isStandByOn(var1)) {
         this.hideMode1();
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceDehumidifier) {
         DeviceDehumidifier var28 = (DeviceDehumidifier)var1;
         if (var28.isInMainMode(MainMode.Dehumidification)) {
            this.showMode(0, R.drawable.mode_icon_dehum_flat);
            DehSubMode var29 = var28.dehSubMode();
            int var4 = DeviceViewHolder.WhenMappings.$EnumSwitchMapping$0[var29.ordinal()];
            if (var4 != 1) {
               if (var4 != 2) {
                  if (var4 != 3) {
                     throw new NoWhenBranchMatchedException();
                  }

                  this.showMode(1, ModeIcon.CONTINUOUS);
               } else {
                  this.showMode(1, ModeIcon.AUTO.proofread(var1));
               }
            } else {
               this.showMode(1, ModeIcon.DRYING.proofread(var1));
            }
         } else {
            this.showMode(0, ModeIcon.AIR_PURIFY.getFlatIcon());
            this.showDeviceApSubMode(var1, var28.apSubMode());
         }

         HasSensorData var51 = (HasSensorData)var1;
         this.showAirQuality(var51, var2);
         Float var30 = (Float)var8;
         if (var2 != null) {
            var30 = var2.getHum();
         }

         this.hydrateHumidity(var51, var30);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceBlue40) {
         this.hideMode1();
         this.showDeviceApSubMode(var1, ((DeviceBlue40)var1).apSubMode());
         this.showAirQuality((HasSensorData)var1, var2);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceMiniRestful) {
         this.hideMode1();
         this.showDeviceApSubMode(var1, ((DeviceMiniRestful)var1).apSubMode());
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DevicePet20) {
         this.hideMode1();
         var7 = (DevicePet20)var1;
         MainMode var31 = var7.mainMode();
         if (DeviceViewHolder.WhenMappings.$EnumSwitchMapping$1[var31.ordinal()] == 1) {
            this.showMode(1, ModeIcon.SMART);
         } else {
            this.showDeviceApSubMode(var1, var7.apSubMode());
         }

         this.showAirQuality((HasSensorData)var1, var2);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceCombo3in1) {
         DeviceCombo3in1 var32 = (DeviceCombo3in1)var1;
         MainMode var53 = var32.mainMode();
         int var20 = DeviceViewHolder.WhenMappings.$EnumSwitchMapping$1[var53.ordinal()];
         if (var20 != 2) {
            if (var20 != 3) {
               if (var20 == 4) {
                  this.showMode(0, ModeIcon.HEAT);
               }
            } else {
               this.showMode(0, ModeIcon.COOL);
            }
         } else {
            this.showMode(0, ModeIcon.AIR_PURIFY);
         }

         this.showDeviceApSubMode(var1, var32.currentSubMode());
         IndoorDatapoint var33;
         if (var2 == null) {
            var33 = var32.getLatestSensorDatapoint();
         } else {
            var33 = var2;
         }

         label187: {
            if (var33 != null) {
               Float var34 = var33.getTmp();
               if (var34 != null) {
                  float var3 = ((Number)var34).floatValue();
                  String var36;
                  if (DeviceKt.isCelsiusUnit(var1)) {
                     StringBuilder var35 = new StringBuilder();
                     var35.append(MathKt.roundToInt(var3));
                     var35.append("°C");
                     var36 = var35.toString();
                  } else {
                     StringBuilder var37 = new StringBuilder();
                     var37.append(MathKt.roundToInt(DeviceData.Companion.convertCelsiusToFahrenheit(var3)));
                     var37.append("°F");
                     var36 = var37.toString();
                  }

                  var54 = var36;
                  if (var36 != null) {
                     break label187;
                  }
               }
            }

            var54 = this.getString(R.string.label_reading);
         }

         this.binding.ivDegreeIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(this.binding.ivDegreeIndicator.getContext(), R.color.grey_200));
         View var38 = this.binding.ivDegreeIndicator;
         Intrinsics.checkNotNullExpressionValue(var38, "ivDegreeIndicator");
         ViewExtensionsKt.show$default(var38, false, 1, (Object)null);
         this.binding.tvDegree.setText((CharSequence)var54);
         TextView var39 = this.binding.tvDegree;
         Intrinsics.checkNotNullExpressionValue(var39, "tvDegree");
         ViewExtensionsKt.show$default((View)var39, false, 1, (Object)null);
         this.showAirQuality((HasSensorData)var1, var2);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceFanTable) {
         this.hideMode1();
         this.showDeviceCoolSubMode((HasCoolMainMode)var1);
         IndoorDatapoint var40 = var2;
         if (var2 == null) {
            var40 = ((DeviceFanTable)var1).getLatestSensorDatapoint();
         }

         label178: {
            if (var40 != null) {
               Float var13 = var40.getTmp();
               if (var13 != null) {
                  float var19 = ((Number)var13).floatValue();
                  String var15;
                  if (DeviceKt.isCelsiusUnit(var1)) {
                     StringBuilder var14 = new StringBuilder();
                     var14.append(MathKt.roundToInt(var19));
                     var14.append("°C");
                     var15 = var14.toString();
                  } else {
                     StringBuilder var16 = new StringBuilder();
                     var16.append(MathKt.roundToInt(DeviceData.Companion.convertCelsiusToFahrenheit(var19)));
                     var16.append("°F");
                     var15 = var16.toString();
                  }

                  var41 = var15;
                  if (var15 != null) {
                     break label178;
                  }
               }
            }

            var41 = this.getString(R.string.label_reading);
         }

         this.binding.ivDegreeIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(this.binding.ivDegreeIndicator.getContext(), R.color.neutral_light));
         View var17 = this.binding.ivDegreeIndicator;
         Intrinsics.checkNotNullExpressionValue(var17, "ivDegreeIndicator");
         ViewExtensionsKt.show$default(var17, false, 1, (Object)null);
         this.binding.tvDegree.setText((CharSequence)var41);
         TextView var18 = this.binding.tvDegree;
         Intrinsics.checkNotNullExpressionValue(var18, "tvDegree");
         ViewExtensionsKt.show$default((View)var18, false, 1, (Object)null);
         this.hydrateTimer((HasTimer)var1);
      } else if (var1 instanceof DeviceCombo2in1) {
         DeviceCombo2in1 var42 = (DeviceCombo2in1)var1;
         if (var42.getHumMode()) {
            this.showMode(0, ModeIcon.HUM);
         } else {
            this.showMode(0, ModeIcon.AIR_PURIFY.getFlatIcon());
         }

         this.hydrateMode(var1, var42.mode());
         var7 = (HasSensorData)var1;
         this.showAirQuality(var7, var2);
         Float var43 = (Float)var9;
         if (var2 != null) {
            var43 = var2.getHum();
         }

         this.hydrateHumidity(var7, var43);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceCombo2in120) {
         DeviceCombo2in120 var44 = (DeviceCombo2in120)var1;
         Mode var45;
         if (var44.isInMainMode(MainMode.Humidification)) {
            this.showMode(0, ModeIcon.HUM);
            var45 = var44.humSubMode().toMode();
         } else {
            this.showMode(0, ModeIcon.AIR_PURIFY.getFlatIcon());
            var45 = var44.apSubMode().toMode();
         }

         this.hydrateMode(var1, var45);
         HasSensorData var59 = (HasSensorData)var1;
         this.showAirQuality(var59, var2);
         Float var46 = var7;
         if (var2 != null) {
            var46 = var2.getHum();
         }

         this.hydrateHumidity(var59, var46);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceHumidifier) {
         this.hideMode1();
         this.showDeviceMode(var1);
         var7 = (HasSensorData)var1;
         Float var47 = (Float)var12;
         if (var2 != null) {
            var47 = var2.getHum();
         }

         this.hydrateHumidity(var7, var47);
         this.showFilterWickStatus(var1);
      } else if (var1 instanceof DeviceHumidifier20) {
         this.hideMode1();
         this.showDeviceMode(var1);
         var7 = (HasSensorData)var1;
         Float var48 = (Float)var11;
         if (var2 != null) {
            var48 = var2.getHum();
         }

         this.hydrateHumidity(var7, var48);
         this.showFilterWickStatus(var1);
      } else {
         this.hideMode1();
         this.showDeviceMode(var1);
         if (var1 instanceof HasSensorData) {
            this.showAirQuality((HasSensorData)var1, var2);
            this.showFilterWickStatus(var1);
         } else {
            this.showFilterWickStatus(var1);
         }
      }

      if (!DeviceKt.isStandByOn(var1)) {
         if (var5) {
            if (var1 instanceof HasWaterLevel) {
               var5 = ((HasWaterLevel)var1).isInWaterLevel(WaterLevel.SHORTAGE);
            } else {
               var5 = ((HasWick)var1).getWaterShortage();
            }

            if (var5) {
               this.showWarning(R.drawable.icon_water_shortage_flat);
            }
         }

         if (var1 instanceof HasWaterTank && var1 instanceof HasWaterLevel && !(var1 instanceof DeviceCombo2in120) && ((HasWaterLevel)var1).isInWaterLevel(WaterLevel.FULL)) {
            this.showWarning(R.drawable.icon_water_tank_full_flat);
         }
      }

   }

   private final void setSafetySwitchOffDevice(Device var1) {
      HolderDeviceBinding var5 = this.binding;
      ImageView var3 = var5.childLockIcon;
      Intrinsics.checkNotNullExpressionValue(var3, "childLockIcon");
      LinearLayout var2 = var5.llTimer;
      Intrinsics.checkNotNullExpressionValue(var2, "llTimer");
      LinearLayout var6 = var5.llMode1;
      Intrinsics.checkNotNullExpressionValue(var6, "llMode1");
      LinearLayout var7 = var5.llMode2;
      Intrinsics.checkNotNullExpressionValue(var7, "llMode2");
      AppCompatImageView var4 = var5.ivWarning;
      Intrinsics.checkNotNullExpressionValue(var4, "ivWarning");
      this.hideViews(var3, var2, var6, var7, var4);
      var5.deviceName.setTextColor(this.getColor(R.color.surface_dark_55));
      if (DeviceKt.hasFrontPanel(var1)) {
         var5.safetySwitchText.setText(R.string.front_panel_open);
      } else {
         var5.safetySwitchText.setText(R.string.close_filter_cover);
      }

      TextView var8 = var5.safetySwitchText;
      Intrinsics.checkNotNullExpressionValue(var8, "safetySwitchText");
      ViewExtensionsKt.show((View)var8, true);
      this.showFilterWickStatus(var1);
   }

   private final void showAirQuality(HasSensorData var1, IndoorDatapoint var2) {
      int var3 = R.color.fill_grey;
      String var4 = this.getString(R.string.label_reading);
      Context var5 = this.binding.tvAirQuality.getContext();
      IndoorAirStatusLabel var9 = IndoorAirStatusLabel.Companion.fromDeviceAndSensorsAndDatapoint$default(IndoorAirStatusLabel.Companion, var2, var1, IndoorAirRatingRanges.Companion.getAirRatingSensors(var1), true, false, 16, (Object)null);
      String var6 = var4;
      if (var9 != null) {
         var6 = this.getString(var9.getLabelResId());
         var3 = var9.getColorRes();
      }

      HolderDeviceBinding var10 = this.binding;
      var10.tvAirQuality.setText((CharSequence)var6);
      var10.airQualityIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(var5, var3));
      View var7 = var10.airQualityIndicator;
      Intrinsics.checkNotNullExpressionValue(var7, "airQualityIndicator");
      ViewExtensionsKt.show$default(var7, false, 1, (Object)null);
      TextView var8 = var10.tvAirQuality;
      Intrinsics.checkNotNullExpressionValue(var8, "tvAirQuality");
      ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
   }

   private final void showDeviceApSubMode(Device var1, ApSubMode var2) {
      int var3 = DeviceViewHolder.WhenMappings.$EnumSwitchMapping$3[var2.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               if (var3 == 4) {
                  this.showMode(1, ModeIcon.ECO.getFlatIcon());
               } else {
                  throw new NoWhenBranchMatchedException();
               }
            } else {
               this.showMode(1, ModeIcon.NIGHT.getFlatIcon());
            }
         } else {
            this.showMode(1, ModeIcon.AUTO.proofread(var1).getFlatIcon());
         }
      } else {
         this.showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), (CharSequence)String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(var1)));
      }
   }

   private final void showDeviceCoolSubMode(HasCoolMainMode var1) {
      CoolSubMode var3 = var1.coolSubMode();
      int var2 = DeviceViewHolder.WhenMappings.$EnumSwitchMapping$5[var3.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               this.showMode(1, ModeIcon.NIGHT.getFlatIcon());
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            AutoLevel var5 = AutoLevel.Companion.fromValue(var1.getCoolAutoLevel());
            var2 = DeviceViewHolder.WhenMappings.$EnumSwitchMapping$4[var5.ordinal()];
            String var6;
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     throw new NoWhenBranchMatchedException();
                  }

                  var6 = this.getString(R.string.label_low);
               } else {
                  var6 = this.getString(R.string.label_medium);
               }
            } else {
               var6 = this.getString(R.string.label_high);
            }

            this.showMode(1, ModeIcon.AUTO.proofread(var1).getFlatIcon(), (CharSequence)var6);
         }
      } else {
         this.showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), (CharSequence)String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(var1)));
      }
   }

   private final void showDeviceMode(Device var1) {
      boolean var2 = var1 instanceof HasFanSpeed;
      if (var2 && ((HasFanSpeed)var1).getAutoMode() == AutoMode.ON) {
         this.showMode(1, ModeIcon.AUTO.proofread(var1));
      } else if (var1 instanceof HasG4NightMode && ((HasG4NightMode)var1).isG4NightModeOn()) {
         this.showMode(1, ModeIcon.NIGHT);
      } else if (var1 instanceof HasEcoMode && ((HasEcoMode)var1).isEcoModeOn()) {
         this.showMode(1, ModeIcon.ECO);
      } else if (var2) {
         this.showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), (CharSequence)String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(var1)));
      } else {
         this.hideMode2();
      }
   }

   private final void showFilterWickStatus(Device var1) {
      Integer var2 = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(var1);
      if (var2 != null) {
         hydrateFilterStatus$default(this, ((Number)var2).intValue(), false, 2, (Object)null);
      }

      if (var1 instanceof HasWick) {
         this.hydrateFilterStatus(((HasWick)var1).getWickLifeLeft(), true);
      }

   }

   private final void showMode(int var1, int var2) {
      this.showMode(var1, var2, (CharSequence)"");
   }

   private final void showMode(int var1, int var2, CharSequence var3) {
      ImageView var7;
      TextView var8;
      ViewGroup var10;
      if (var1 == 0) {
         var7 = this.binding.modeIcon1;
         Intrinsics.checkNotNullExpressionValue(var7, "modeIcon1");
         AppCompatTextView var6 = this.binding.modeText1;
         Intrinsics.checkNotNullExpressionValue(var6, "modeText1");
         var8 = (TextView)var6;
         LinearLayout var9 = this.binding.llMode1;
         Intrinsics.checkNotNullExpressionValue(var9, "llMode1");
         var10 = (ViewGroup)var9;
      } else {
         var7 = this.binding.modeIcon2;
         Intrinsics.checkNotNullExpressionValue(var7, "modeIcon2");
         AppCompatTextView var11 = this.binding.modeText2;
         Intrinsics.checkNotNullExpressionValue(var11, "modeText2");
         var8 = (TextView)var11;
         LinearLayout var12 = this.binding.llMode2;
         Intrinsics.checkNotNullExpressionValue(var12, "llMode2");
         var10 = (ViewGroup)var12;
      }

      boolean var5 = true;
      boolean var4;
      if (var2 != 0) {
         var7.setImageResource(var2);
         ViewExtensionsKt.show$default((View)var7, false, 1, (Object)null);
         ((AppCompatTextView)var8).setImportantForAccessibility(2);
         var4 = true;
      } else {
         ViewExtensionsKt.hide((View)var7);
         ((AppCompatTextView)var8).setImportantForAccessibility(1);
         var4 = false;
      }

      if (var3.length() > 0) {
         ((AppCompatTextView)var8).setText(var3);
         ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
         var4 = var5;
      } else {
         ViewExtensionsKt.hide((View)var8);
      }

      ViewExtensionsKt.show((View)var10, var4);
   }

   private final void showMode(int var1, ModeIcon var2) {
      this.showMode(var1, var2.getFlatIcon());
   }

   private final void showWarning(int var1) {
      AppCompatImageView var2 = this.binding.ivWarning;
      Intrinsics.checkNotNullExpressionValue(var2, "ivWarning");
      ViewExtensionsKt.show((View)var2, true);
      this.binding.ivWarning.setImageResource(var1);
   }

   private static final SimpleDateFormat timeFormatter_delegate$lambda$0(DeviceViewHolder var0) {
      return new SimpleDateFormat(var0.fetchPattern());
   }

   public final HolderDeviceBinding getBinding() {
      return this.binding;
   }

   public final ConstraintLayout getClickView() {
      return this.clickView;
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final View getOfflineInfoView() {
      return this.offlineInfoView;
   }

   public final View getStandByModeClickView() {
      return this.standByModeClickView;
   }

   public final void update(Device var1, IndoorDatapoint var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      int var5 = 0;
      if (!var3 && var1.isOnline()) {
         var3 = false;
      } else {
         var3 = true;
      }

      HolderDeviceBinding var7 = this.binding;
      var7.deviceName.setText((CharSequence)var1.getName());
      ImageView var8 = var7.deviceImg;
      DeviceImage var9 = DeviceConfigProvider.INSTANCE.getDeviceImage(var1);
      int var4;
      if (var9 != null) {
         var4 = var9.getDevice();
      } else {
         var4 = 0;
      }

      var8.setImageResource(var4);
      Flow var27 = var7.flowStatus;
      Intrinsics.checkNotNullExpressionValue(var27, "flowStatus");
      ViewExtensionsKt.show$default((View)var27, false, 1, (Object)null);
      this.hideMode2();
      ImageView var11 = var7.ivOfflineInfo;
      Intrinsics.checkNotNullExpressionValue(var11, "ivOfflineInfo");
      LinearLayout var15 = var7.llTimer;
      Intrinsics.checkNotNullExpressionValue(var15, "llTimer");
      ImageView var14 = var7.childLockIcon;
      Intrinsics.checkNotNullExpressionValue(var14, "childLockIcon");
      AppCompatImageView var12 = var7.ivWarning;
      Intrinsics.checkNotNullExpressionValue(var12, "ivWarning");
      SimpleIconTextView var28 = var7.itvAlarm;
      Intrinsics.checkNotNullExpressionValue(var28, "itvAlarm");
      View var13 = var7.airQualityIndicator;
      Intrinsics.checkNotNullExpressionValue(var13, "airQualityIndicator");
      TextView var29 = var7.tvAirQuality;
      Intrinsics.checkNotNullExpressionValue(var29, "tvAirQuality");
      View var16 = var7.ivDegreeIndicator;
      Intrinsics.checkNotNullExpressionValue(var16, "ivDegreeIndicator");
      TextView var10 = var7.tvDegree;
      Intrinsics.checkNotNullExpressionValue(var10, "tvDegree");
      TextView var17 = var7.tvAirFilterStatus;
      Intrinsics.checkNotNullExpressionValue(var17, "tvAirFilterStatus");
      TextView var25 = var7.tvWickFilterStatus;
      Intrinsics.checkNotNullExpressionValue(var25, "tvWickFilterStatus");
      this.hideViews(var11, var15, var14, var12, var28, var13, var29, var16, var10, var17, var25);
      if (var3) {
         this.setOfflineDevice();
      } else {
         this.setOnlineDevice(var1, var2);
         if (DeviceKt.isSafetySwitchOn(var1)) {
            TextView var20 = this.binding.safetySwitchText;
            Intrinsics.checkNotNullExpressionValue(var20, "safetySwitchText");
            ViewExtensionsKt.hide((View)var20);
         } else {
            this.setSafetySwitchOffDevice(var1);
         }
      }

      this.hydrateStandby(var1, var3);
      this.hydrateAlarm(var1);
      HolderDeviceBinding var18 = this.binding;
      int[] var26 = var18.flowStatus.getReferencedIds();
      Intrinsics.checkNotNullExpressionValue(var26, "getReferencedIds(...)");
      int var6 = var26.length;

      for(int var23 = var5; var23 < var6; ++var23) {
         var5 = var26[var23];
         View var21 = var18.foregroundLayout.getViewById(var5);
         Intrinsics.checkNotNullExpressionValue(var21, "getViewById(...)");
         if (var21.getVisibility() != 8) {
            return;
         }
      }

      Flow var19 = var18.flowStatus;
      Intrinsics.checkNotNullExpressionValue(var19, "flowStatus");
      ViewExtensionsKt.hide((View)var19);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/android/viewholder/DeviceViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/viewholder/DeviceViewHolder;", "parentView", "Landroid/view/ViewGroup;", "app_otherRelease"},
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

      public final DeviceViewHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceBinding var2 = HolderDeviceBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceViewHolder(var2);
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
      public static final int[] $EnumSwitchMapping$1;
      public static final int[] $EnumSwitchMapping$2;
      public static final int[] $EnumSwitchMapping$3;
      public static final int[] $EnumSwitchMapping$4;
      public static final int[] $EnumSwitchMapping$5;

      static {
         int[] var0 = new int[DehSubMode.values().length];

         try {
            var0[DehSubMode.DRYING.ordinal()] = 1;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[DehSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[DehSubMode.CONTINUOUS.ordinal()] = 3;
         } catch (NoSuchFieldError var21) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.SMART.ordinal()] = 1;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[MainMode.AirPurify.ordinal()] = 2;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 3;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 4;
         } catch (NoSuchFieldError var17) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[Mode.values().length];

         try {
            var0[Mode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[Mode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[Mode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[Mode.ECO.ordinal()] = 4;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[Mode.SKIN.ordinal()] = 5;
         } catch (NoSuchFieldError var12) {
         }

         $EnumSwitchMapping$2 = var0;
         var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[ApSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[ApSubMode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[ApSubMode.ECO.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         $EnumSwitchMapping$3 = var0;
         var0 = new int[AutoLevel.values().length];

         try {
            var0[AutoLevel.HIGH.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[AutoLevel.MEDIUM.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[AutoLevel.LOW.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         $EnumSwitchMapping$4 = var0;
         var0 = new int[CoolSubMode.values().length];

         try {
            var0[CoolSubMode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[CoolSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CoolSubMode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$5 = var0;
      }
   }
}
