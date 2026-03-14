package com.blueair.viewcore.view;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001e2\u00020\u0001:\u000e\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB1\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0003J\r\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0082\u0001\r\u001f !\"#$%&'()*+¨\u0006,"},
   d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "", "textResId", "", "backgroundResId", "colorRes", "labelResId", "<init>", "(IIII)V", "getTextResId", "()I", "getBackgroundResId", "getColorRes", "getLabelResId", "getIndoorAirQualityIcon6", "getIndoorAirStatusProgressDrawable", "()Ljava/lang/Integer;", "Excellent", "Good", "Moderate", "Polluted", "VeryPolluted", "Ideal", "Moist", "Dry", "ReplaceFilter", "ReplaceFilterPercentage", "Offline", "Connecting", "Updating", "Companion", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Connecting;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Dry;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Excellent;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Good;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Ideal;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moderate;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moist;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Offline;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Polluted;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilter;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilterPercentage;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Updating;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$VeryPolluted;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class IndoorAirStatusLabel {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final int backgroundResId;
   private final int colorRes;
   private final int labelResId;
   private final int textResId;

   private IndoorAirStatusLabel(int var1, int var2, int var3, int var4) {
      this.textResId = var1;
      this.backgroundResId = var2;
      this.colorRes = var3;
      this.labelResId = var4;
   }

   // $FF: synthetic method
   public IndoorAirStatusLabel(int var1, int var2, int var3, int var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = var1;
      }

      this(var1, var2, var3, var4, (DefaultConstructorMarker)null);
   }

   // $FF: synthetic method
   public IndoorAirStatusLabel(int var1, int var2, int var3, int var4, DefaultConstructorMarker var5) {
      this(var1, var2, var3, var4);
   }

   public final int getBackgroundResId() {
      return this.backgroundResId;
   }

   public final int getColorRes() {
      return this.colorRes;
   }

   public final int getIndoorAirQualityIcon6() {
      if (Intrinsics.areEqual(this, IndoorAirStatusLabel.Excellent.INSTANCE)) {
         return R.drawable.ic_aqi_dot_excellent_6;
      } else if (!Intrinsics.areEqual(this, IndoorAirStatusLabel.Ideal.INSTANCE) && !Intrinsics.areEqual(this, IndoorAirStatusLabel.Good.INSTANCE)) {
         if (!Intrinsics.areEqual(this, IndoorAirStatusLabel.Moist.INSTANCE) && !Intrinsics.areEqual(this, IndoorAirStatusLabel.Moderate.INSTANCE)) {
            if (Intrinsics.areEqual(this, IndoorAirStatusLabel.Polluted.INSTANCE)) {
               return R.drawable.ic_aqi_dot_polluted_6;
            } else {
               return !Intrinsics.areEqual(this, IndoorAirStatusLabel.Dry.INSTANCE) && !Intrinsics.areEqual(this, IndoorAirStatusLabel.VeryPolluted.INSTANCE) ? R.drawable.ic_aqi_dot_null_6 : R.drawable.ic_aqi_dot_vpolluted_6;
            }
         } else {
            return R.drawable.ic_aqi_dot_moderate_6;
         }
      } else {
         return R.drawable.ic_aqi_dot_good_6;
      }
   }

   public final Integer getIndoorAirStatusProgressDrawable() {
      if (Intrinsics.areEqual(this, IndoorAirStatusLabel.Excellent.INSTANCE)) {
         return R.drawable.progressbar_blue;
      } else if (Intrinsics.areEqual(this, IndoorAirStatusLabel.Good.INSTANCE)) {
         return R.drawable.progressbar_green;
      } else if (Intrinsics.areEqual(this, IndoorAirStatusLabel.Moderate.INSTANCE)) {
         return R.drawable.progressbar_yellow;
      } else if (Intrinsics.areEqual(this, IndoorAirStatusLabel.Polluted.INSTANCE)) {
         return R.drawable.progressbar_peach;
      } else if (Intrinsics.areEqual(this, IndoorAirStatusLabel.VeryPolluted.INSTANCE)) {
         return R.drawable.progressbar_warmpink;
      } else {
         return Intrinsics.areEqual(this, IndoorAirStatusLabel.Offline.INSTANCE) ? R.drawable.progressbar_offline : null;
      }
   }

   public final int getLabelResId() {
      return this.labelResId;
   }

   public final int getTextResId() {
      return this.textResId;
   }

   @Metadata(
      d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ*\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ<\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bJ \u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tJ(\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u001d"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Companion;", "", "<init>", "()V", "fromDeviceAndSensor", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "fromSensorOnly", "", "fromDeviceAndSensorAndDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "fromDeviceAndSensorsAndDatapoint", "sensorTypes", "", "nullableRating", "fromValueAndSensor", "realValue", "", "fromIndoorRating", "indoorAirRating", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "filterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "connectivityStatus", "Lcom/blueair/core/model/ConnectivityStatus;", "viewcore_otherRelease"},
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
      public static IndoorAirStatusLabel fromDeviceAndSensor$default(Companion var0, HasSensorData var1, SensorType var2, boolean var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = false;
         }

         return var0.fromDeviceAndSensor(var1, var2, var3);
      }

      // $FF: synthetic method
      public static IndoorAirStatusLabel fromDeviceAndSensorAndDatapoint$default(Companion var0, IndoorDatapoint var1, HasSensorData var2, SensorType var3, boolean var4, int var5, Object var6) {
         if ((var5 & 8) != 0) {
            var4 = false;
         }

         return var0.fromDeviceAndSensorAndDatapoint(var1, var2, var3, var4);
      }

      // $FF: synthetic method
      public static IndoorAirStatusLabel fromDeviceAndSensorsAndDatapoint$default(Companion var0, IndoorDatapoint var1, HasSensorData var2, List var3, boolean var4, boolean var5, int var6, Object var7) {
         if ((var6 & 8) != 0) {
            var4 = false;
         }

         if ((var6 & 16) != 0) {
            var5 = false;
         }

         return var0.fromDeviceAndSensorsAndDatapoint(var1, var2, var3, var4, var5);
      }

      private final IndoorAirStatusLabel fromIndoorRating(IndoorAirRatingRanges.IndoorAirRating var1, FilterLifeTime var2, ConnectivityStatus var3) {
         if (var3 == ConnectivityStatus.OFFLINE) {
            return IndoorAirStatusLabel.Offline.INSTANCE;
         } else if (var3 == ConnectivityStatus.CONNECTING) {
            return IndoorAirStatusLabel.Connecting.INSTANCE;
         } else {
            if (var2 instanceof FilterLifeTime.FilterDaysLeft) {
               if (((FilterLifeTime.FilterDaysLeft)var2).getFilterLife() < 7) {
                  return IndoorAirStatusLabel.ReplaceFilter.INSTANCE;
               }
            } else if (var2 instanceof FilterLifeTime.FilterPercentageLeft) {
               return IndoorAirStatusLabel.ReplaceFilterPercentage.INSTANCE;
            }

            if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE)) {
               return IndoorAirStatusLabel.Excellent.INSTANCE;
            } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE)) {
               return IndoorAirStatusLabel.Good.INSTANCE;
            } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE)) {
               return IndoorAirStatusLabel.Moderate.INSTANCE;
            } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE)) {
               return IndoorAirStatusLabel.Polluted.INSTANCE;
            } else {
               return Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE) ? (IndoorAirStatusLabel)IndoorAirStatusLabel.VeryPolluted.INSTANCE : null;
            }
         }
      }

      private final IndoorAirStatusLabel fromIndoorRating(IndoorAirRatingRanges.IndoorAirRating var1, HasSensorData var2) {
         ConnectivityStatus var5 = var2.getConnectivityStatus();
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("fromIndoorRating: device = ");
         var3.append(var2);
         var4.d(var3.toString(), new Object[0]);
         if (DeviceKt.isG4orB4orNB(var2)) {
            if (var5 == ConnectivityStatus.OFFLINE || var5 == ConnectivityStatus.CONNECTING) {
               return null;
            }
         } else {
            if (var5 == ConnectivityStatus.OFFLINE) {
               return IndoorAirStatusLabel.Offline.INSTANCE;
            }

            if (var5 == ConnectivityStatus.CONNECTING) {
               return IndoorAirStatusLabel.Connecting.INSTANCE;
            }
         }

         if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE)) {
            return IndoorAirStatusLabel.Excellent.INSTANCE;
         } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE)) {
            return IndoorAirStatusLabel.Good.INSTANCE;
         } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE)) {
            return IndoorAirStatusLabel.Moderate.INSTANCE;
         } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE)) {
            return IndoorAirStatusLabel.Polluted.INSTANCE;
         } else if (Intrinsics.areEqual(var1, IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE)) {
            return IndoorAirStatusLabel.VeryPolluted.INSTANCE;
         } else {
            return null;
         }
      }

      public final IndoorAirStatusLabel fromDeviceAndSensor(HasSensorData var1, SensorType var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var2, "sensorType");
         IndoorAirRatingRanges.IndoorAirRating var4 = var1.aqiFor(var2);
         return var3 ? this.fromIndoorRating(var4, var1) : this.fromIndoorRating(var4, DeviceKt.getFilterLifeTime(var1), var1.getConnectivityStatus());
      }

      public final IndoorAirStatusLabel fromDeviceAndSensorAndDatapoint(IndoorDatapoint var1, HasSensorData var2, SensorType var3, boolean var4) {
         Intrinsics.checkNotNullParameter(var1, "dataPoint");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intrinsics.checkNotNullParameter(var3, "sensorType");
         IndoorAirRatingRanges.IndoorAirRating var5 = IndoorAirRatingRanges.Companion.instance(var2).ratingFromDatapoint(var1, var3);
         return var4 ? this.fromIndoorRating(var5, var2) : this.fromIndoorRating(var5, DeviceKt.getFilterLifeTime(var2), var2.getConnectivityStatus());
      }

      public final IndoorAirStatusLabel fromDeviceAndSensorsAndDatapoint(IndoorDatapoint var1, HasSensorData var2, List var3, boolean var4, boolean var5) {
         Intrinsics.checkNotNullParameter(var2, "device");
         Intrinsics.checkNotNullParameter(var3, "sensorTypes");
         Pair var6 = IndoorAirRatingRanges.Companion.instance(var2).voteWorstRating(var3, var1);
         IndoorAirRatingRanges.IndoorAirRating var7 = IndoorAirRatingRanges.IndoorAirRating.Companion.fromIndex(((Number)var6.getSecond()).intValue());
         if (var7 == null && !var5) {
            return null;
         } else {
            return var4 ? this.fromIndoorRating(var7, var2) : this.fromIndoorRating(var7, DeviceKt.getFilterLifeTime(var2), var2.getConnectivityStatus());
         }
      }

      public final IndoorAirStatusLabel fromValueAndSensor(HasSensorData var1, double var2, SensorType var4) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var4, "sensorType");
         if (var4 == SensorType.HUM) {
            if (var2 < (double)30.0F) {
               return IndoorAirStatusLabel.Dry.INSTANCE;
            } else {
               return (double)30.0F <= var2 && var2 <= (double)50.0F ? (IndoorAirStatusLabel)IndoorAirStatusLabel.Ideal.INSTANCE : (IndoorAirStatusLabel)IndoorAirStatusLabel.Moist.INSTANCE;
            }
         } else {
            return this.fromIndoorRating(var1.aqiFor(var2, var4), (FilterLifeTime)null, (ConnectivityStatus)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Connecting;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Connecting extends IndoorAirStatusLabel {
      public static final Connecting INSTANCE = new Connecting();

      private Connecting() {
         super(R.string.connecting, R.drawable.status_label_grey, R.color.light_gray, 0, 8, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Dry;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Dry extends IndoorAirStatusLabel {
      public static final Dry INSTANCE = new Dry();

      private Dry() {
         super(R.string.humidity_level_dry, R.drawable.status_label_vpolluted, R.color.color_vpolluted, R.string.humidity_level_dry, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Excellent;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Excellent extends IndoorAirStatusLabel {
      public static final Excellent INSTANCE = new Excellent();

      private Excellent() {
         super(R.string.excellent, R.drawable.status_label_excellent, R.color.color_excellent, R.string.label_excellent_air, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Good;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Good extends IndoorAirStatusLabel {
      public static final Good INSTANCE = new Good();

      private Good() {
         super(R.string.good, R.drawable.status_label_good, R.color.color_good, R.string.state_good_air, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Ideal;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Ideal extends IndoorAirStatusLabel {
      public static final Ideal INSTANCE = new Ideal();

      private Ideal() {
         super(R.string.humidity_level_ideal, R.drawable.status_label_good, R.color.color_good, R.string.ideal_hum_table_title_hum, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moderate;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Moderate extends IndoorAirStatusLabel {
      public static final Moderate INSTANCE = new Moderate();

      private Moderate() {
         super(R.string.moderate, R.drawable.status_label_moderate, R.color.color_moderate, R.string.label_moderate_air, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moist;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Moist extends IndoorAirStatusLabel {
      public static final Moist INSTANCE = new Moist();

      private Moist() {
         super(R.string.humidity_level_moist, R.drawable.status_label_moderate, R.color.color_moderate, R.string.humidity_level_moist, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Offline;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Offline extends IndoorAirStatusLabel {
      public static final Offline INSTANCE = new Offline();

      private Offline() {
         super(R.string.offline_label, R.drawable.status_label_grey, R.color.light_gray, 0, 8, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Polluted;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Polluted extends IndoorAirStatusLabel {
      public static final Polluted INSTANCE = new Polluted();

      private Polluted() {
         super(R.string.polluted, R.drawable.status_label_polluted, R.color.color_polluted, R.string.label_polluted_air, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilter;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ReplaceFilter extends IndoorAirStatusLabel {
      public static final ReplaceFilter INSTANCE = new ReplaceFilter();

      private ReplaceFilter() {
         super(R.string.filter_usage, R.drawable.filter_progress_replace, R.color.bruno_blue, 0, 8, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilterPercentage;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ReplaceFilterPercentage extends IndoorAirStatusLabel {
      public static final ReplaceFilterPercentage INSTANCE = new ReplaceFilterPercentage();

      private ReplaceFilterPercentage() {
         super(R.string.filter_usage_percentage, R.drawable.filter_progress_replace, R.color.error_red, 0, 8, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Updating;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Updating extends IndoorAirStatusLabel {
      public static final Updating INSTANCE = new Updating();

      private Updating() {
         super(R.string.firmware_updating, R.drawable.status_label_grey, R.color.light_gray, 0, 8, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$VeryPolluted;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class VeryPolluted extends IndoorAirStatusLabel {
      public static final VeryPolluted INSTANCE = new VeryPolluted();

      private VeryPolluted() {
         super(R.string.vpolluted, R.drawable.status_label_vpolluted, R.color.color_vpolluted, R.string.label_vpolluted_air, (DefaultConstructorMarker)null);
      }
   }
}
