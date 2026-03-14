package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"},
   d2 = {"Lcom/blueair/core/model/PollutantType;", "", "code", "", "<init>", "(I)V", "getCode", "()I", "Companion", "CO", "NO2", "O3", "PM10", "PM25", "SO2", "AQI", "Lcom/blueair/core/model/PollutantType$AQI;", "Lcom/blueair/core/model/PollutantType$CO;", "Lcom/blueair/core/model/PollutantType$NO2;", "Lcom/blueair/core/model/PollutantType$O3;", "Lcom/blueair/core/model/PollutantType$PM10;", "Lcom/blueair/core/model/PollutantType$PM25;", "Lcom/blueair/core/model/PollutantType$SO2;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class PollutantType {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final int code;

   private PollutantType(int var1) {
      this.code = var1;
   }

   // $FF: synthetic method
   public PollutantType(int var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final int getCode() {
      return this.code;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$AQI;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AQI extends PollutantType {
      public static final AQI INSTANCE = new AQI();

      private AQI() {
         super(6, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$CO;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CO extends PollutantType {
      public static final CO INSTANCE = new CO();

      private CO() {
         super(0, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0005¨\u0006\r"},
      d2 = {"Lcom/blueair/core/model/PollutantType$Companion;", "", "<init>", "()V", "fromCode", "Lcom/blueair/core/model/PollutantType;", "code", "", "fromSensorType", "sensorType", "Lcom/blueair/core/model/SensorType;", "toSensorType", "pollutantType", "core_otherRelease"},
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

      public final PollutantType fromCode(int var1) {
         if (var1 == PollutantType.CO.INSTANCE.getCode()) {
            return PollutantType.CO.INSTANCE;
         } else if (var1 == PollutantType.NO2.INSTANCE.getCode()) {
            return PollutantType.NO2.INSTANCE;
         } else if (var1 == PollutantType.O3.INSTANCE.getCode()) {
            return PollutantType.O3.INSTANCE;
         } else if (var1 == PollutantType.PM10.INSTANCE.getCode()) {
            return PollutantType.PM10.INSTANCE;
         } else if (var1 == PollutantType.PM25.INSTANCE.getCode()) {
            return PollutantType.PM25.INSTANCE;
         } else {
            return var1 == PollutantType.SO2.INSTANCE.getCode() ? (PollutantType)PollutantType.SO2.INSTANCE : (PollutantType)PollutantType.AQI.INSTANCE;
         }
      }

      public final PollutantType fromSensorType(SensorType var1) {
         Intrinsics.checkNotNullParameter(var1, "sensorType");
         int var2 = PollutantType.Companion.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         if (var2 != 1) {
            return var2 != 2 ? null : (PollutantType)PollutantType.PM10.INSTANCE;
         } else {
            return PollutantType.PM25.INSTANCE;
         }
      }

      public final SensorType toSensorType(PollutantType var1) {
         Intrinsics.checkNotNullParameter(var1, "pollutantType");
         if (Intrinsics.areEqual(var1, PollutantType.PM25.INSTANCE)) {
            return SensorType.PM25;
         } else {
            return Intrinsics.areEqual(var1, PollutantType.PM10.INSTANCE) ? SensorType.PM10 : null;
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
               var0[SensorType.PM25.ordinal()] = 1;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[SensorType.PM10.ordinal()] = 2;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$NO2;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NO2 extends PollutantType {
      public static final NO2 INSTANCE = new NO2();

      private NO2() {
         super(1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$O3;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class O3 extends PollutantType {
      public static final O3 INSTANCE = new O3();

      private O3() {
         super(2, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$PM10;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PM10 extends PollutantType {
      public static final PM10 INSTANCE = new PM10();

      private PM10() {
         super(3, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$PM25;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PM25 extends PollutantType {
      public static final PM25 INSTANCE = new PM25();

      private PM25() {
         super(4, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/PollutantType$SO2;", "Lcom/blueair/core/model/PollutantType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SO2 extends PollutantType {
      public static final SO2 INSTANCE = new SO2();

      private SO2() {
         super(5, (DefaultConstructorMarker)null);
      }
   }
}
