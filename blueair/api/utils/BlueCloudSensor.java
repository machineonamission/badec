package com.blueair.api.utils;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u000b\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\n\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"},
   d2 = {"Lcom/blueair/api/utils/BlueCloudSensor;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "PM1", "PM25", "PM10", "VOC", "HCHO", "Humidity", "Temperature", "Fan", "Weight", "RPM", "Lcom/blueair/api/utils/BlueCloudSensor$Fan;", "Lcom/blueair/api/utils/BlueCloudSensor$HCHO;", "Lcom/blueair/api/utils/BlueCloudSensor$Humidity;", "Lcom/blueair/api/utils/BlueCloudSensor$PM1;", "Lcom/blueair/api/utils/BlueCloudSensor$PM10;", "Lcom/blueair/api/utils/BlueCloudSensor$PM25;", "Lcom/blueair/api/utils/BlueCloudSensor$RPM;", "Lcom/blueair/api/utils/BlueCloudSensor$Temperature;", "Lcom/blueair/api/utils/BlueCloudSensor$VOC;", "Lcom/blueair/api/utils/BlueCloudSensor$Weight;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BlueCloudSensor {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final Lazy sensorNames$delegate = LazyKt.lazy(new BlueCloudSensor$$ExternalSyntheticLambda0());
   private static final Lazy sensors$delegate = LazyKt.lazy(new BlueCloudSensor$$ExternalSyntheticLambda1());
   private final String name;

   // $FF: synthetic method
   public static List $r8$lambda$AqD6sBa7uHpvsrFPojW_EcJGTxQ/* $FF was: $r8$lambda$AqD6sBa7uHpvsrFPojW-EcJGTxQ*/() {
      return sensorNames_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static List $r8$lambda$di8wpvEilP2ssk_24YTvYQBP1zc() {
      return sensors_delegate$lambda$1();
   }

   private BlueCloudSensor(String var1) {
      this.name = var1;
   }

   // $FF: synthetic method
   public BlueCloudSensor(String var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   private static final List sensorNames_delegate$lambda$0() {
      return CollectionsKt.listOf(new String[]{BlueCloudSensor.PM1.INSTANCE.getName(), BlueCloudSensor.PM25.INSTANCE.getName(), BlueCloudSensor.PM10.INSTANCE.getName(), BlueCloudSensor.VOC.INSTANCE.getName(), BlueCloudSensor.HCHO.INSTANCE.getName(), BlueCloudSensor.Humidity.INSTANCE.getName(), BlueCloudSensor.Temperature.INSTANCE.getName(), BlueCloudSensor.Fan.INSTANCE.getName(), BlueCloudSensor.Weight.INSTANCE.getName(), BlueCloudSensor.RPM.INSTANCE.getName()});
   }

   private static final List sensors_delegate$lambda$1() {
      return CollectionsKt.listOf(new BlueCloudSensor[]{BlueCloudSensor.PM1.INSTANCE, BlueCloudSensor.PM25.INSTANCE, BlueCloudSensor.PM10.INSTANCE, BlueCloudSensor.VOC.INSTANCE, BlueCloudSensor.HCHO.INSTANCE, BlueCloudSensor.Humidity.INSTANCE, BlueCloudSensor.Temperature.INSTANCE, BlueCloudSensor.Fan.INSTANCE, BlueCloudSensor.Weight.INSTANCE, BlueCloudSensor.RPM.INSTANCE});
   }

   public final String getName() {
      return this.name;
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\b¨\u0006\u000f"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$Companion;", "", "<init>", "()V", "sensorNames", "", "", "getSensorNames", "()Ljava/util/List;", "sensorNames$delegate", "Lkotlin/Lazy;", "sensors", "Lcom/blueair/api/utils/BlueCloudSensor;", "getSensors", "sensors$delegate", "api_otherRelease"},
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

      public final List getSensorNames() {
         return (List)BlueCloudSensor.sensorNames$delegate.getValue();
      }

      public final List getSensors() {
         return (List)BlueCloudSensor.sensors$delegate.getValue();
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$Fan;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Fan extends BlueCloudSensor {
      public static final Fan INSTANCE = new Fan();

      private Fan() {
         super("fsp0", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$HCHO;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HCHO extends BlueCloudSensor {
      public static final HCHO INSTANCE = new HCHO();

      private HCHO() {
         super("hcho", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$Humidity;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Humidity extends BlueCloudSensor {
      public static final Humidity INSTANCE = new Humidity();

      private Humidity() {
         super("h", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$PM1;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PM1 extends BlueCloudSensor {
      public static final PM1 INSTANCE = new PM1();

      private PM1() {
         super("pm1", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$PM10;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PM10 extends BlueCloudSensor {
      public static final PM10 INSTANCE = new PM10();

      private PM10() {
         super("pm10", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$PM25;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PM25 extends BlueCloudSensor {
      public static final PM25 INSTANCE = new PM25();

      private PM25() {
         super("pm2_5", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$RPM;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class RPM extends BlueCloudSensor {
      public static final RPM INSTANCE = new RPM();

      private RPM() {
         super("rpm", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$Temperature;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Temperature extends BlueCloudSensor {
      public static final Temperature INSTANCE = new Temperature();

      private Temperature() {
         super("t", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$VOC;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class VOC extends BlueCloudSensor {
      public static final VOC INSTANCE = new VOC();

      private VOC() {
         super("tVOC", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/api/utils/BlueCloudSensor$Weight;", "Lcom/blueair/api/utils/BlueCloudSensor;", "<init>", "()V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Weight extends BlueCloudSensor {
      public static final Weight INSTANCE = new Weight();

      private Weight() {
         super("weight", (DefaultConstructorMarker)null);
      }
   }
}
