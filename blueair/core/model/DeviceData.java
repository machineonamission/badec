package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\bJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J-\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006*"},
   d2 = {"Lcom/blueair/core/model/DeviceData;", "", "deviceId", "", "rawDataPoints", "", "Lcom/blueair/core/model/IndoorDatapoint;", "isCelsius", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "getDeviceId", "()Ljava/lang/String;", "getRawDataPoints", "()Ljava/util/List;", "()Z", "datapoints", "getDatapoints$annotations", "()V", "getDatapoints", "datapoints$delegate", "Lkotlin/Lazy;", "toSimpleDataPoints", "Lcom/blueair/core/model/SimpleDatapoint;", "sensorType", "Lcom/blueair/core/model/SensorType;", "ignoreTemperatureUnit", "latestDatapoint", "getLatestDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "oldestDatapoint", "getOldestDatapoint", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceData {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final long REAL_TIME_MAX_DELAY = 20000L;
   private final Lazy datapoints$delegate;
   private final String deviceId;
   private final boolean isCelsius;
   private final List rawDataPoints;

   // $FF: synthetic method
   public static List $r8$lambda$ea2yY_tyssLKfUV_BuvAWKnS9mI/* $FF was: $r8$lambda$ea2yY_tyssLKfUV-BuvAWKnS9mI*/(DeviceData var0) {
      return datapoints_delegate$lambda$1(var0);
   }

   public DeviceData(String var1, List var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "rawDataPoints");
      super();
      this.deviceId = var1;
      this.rawDataPoints = var2;
      this.isCelsius = var3;
      this.datapoints$delegate = LazyKt.lazy(new DeviceData$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public static DeviceData copy$default(DeviceData var0, String var1, List var2, boolean var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.deviceId;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.rawDataPoints;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.isCelsius;
      }

      return var0.copy(var1, var2, var3);
   }

   private static final List datapoints_delegate$lambda$1(DeviceData var0) {
      if (var0.isCelsius) {
         return var0.rawDataPoints;
      } else {
         Iterable var4 = (Iterable)var0.rawDataPoints;
         Collection var2 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));

         for(IndoorDatapoint var1 : var4) {
            IndoorDatapoint var5 = var1;
            if (var1.getTmp() != null) {
               var5 = IndoorDatapoint.copy$default(var1, 0L, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, Companion.convertCelsiusToFahrenheit(var1.getTmp()), (Float)null, (Float)null, (Float)null, (Float)null, 1983, (Object)null);
            }

            var2.add(var5);
         }

         return (List)var2;
      }
   }

   // $FF: synthetic method
   public static void getDatapoints$annotations() {
   }

   // $FF: synthetic method
   public static List toSimpleDataPoints$default(DeviceData var0, SensorType var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return var0.toSimpleDataPoints(var1, var2);
   }

   public final String component1() {
      return this.deviceId;
   }

   public final List component2() {
      return this.rawDataPoints;
   }

   public final boolean component3() {
      return this.isCelsius;
   }

   public final DeviceData copy(String var1, List var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "rawDataPoints");
      return new DeviceData(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceId, var1.deviceId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.rawDataPoints, var1.rawDataPoints)) {
            return false;
         } else {
            return this.isCelsius == var1.isCelsius;
         }
      }
   }

   public final List getDatapoints() {
      return (List)this.datapoints$delegate.getValue();
   }

   public final String getDeviceId() {
      return this.deviceId;
   }

   public final IndoorDatapoint getLatestDatapoint() {
      return (IndoorDatapoint)CollectionsKt.firstOrNull(CollectionsKt.sortedWith((Iterable)this.getDatapoints(), new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((IndoorDatapoint)var2).getTimeInSeconds(), (Comparable)((IndoorDatapoint)var1).getTimeInSeconds());
         }
      }));
   }

   public final IndoorDatapoint getOldestDatapoint() {
      return (IndoorDatapoint)CollectionsKt.firstOrNull(CollectionsKt.sortedWith((Iterable)this.getDatapoints(), new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((IndoorDatapoint)var1).getTimeInSeconds(), (Comparable)((IndoorDatapoint)var2).getTimeInSeconds());
         }
      }));
   }

   public final List getRawDataPoints() {
      return this.rawDataPoints;
   }

   public int hashCode() {
      return (this.deviceId.hashCode() * 31 + this.rawDataPoints.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.isCelsius);
   }

   public final boolean isCelsius() {
      return this.isCelsius;
   }

   public final List toSimpleDataPoints(SensorType var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      List var9;
      switch (DeviceData.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            Iterable var34 = (Iterable)this.rawDataPoints;
            Collection var48 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var34, 10)));

            for(IndoorDatapoint var35 : var34) {
               SimpleDatapoint var36;
               if (var35.getPm1() == null) {
                  var36 = null;
               } else {
                  var36 = new SimpleDatapoint(var35.getTimeInSeconds(), var35.getPm1());
               }

               var48.add(var36);
            }

            var9 = (List)var48;
            break;
         case 2:
            Iterable var31 = (Iterable)this.rawDataPoints;
            Collection var47 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var31, 10)));

            for(IndoorDatapoint var32 : var31) {
               SimpleDatapoint var33;
               if (var32.getPm10() == null) {
                  var33 = null;
               } else {
                  var33 = new SimpleDatapoint(var32.getTimeInSeconds(), var32.getPm10());
               }

               var47.add(var33);
            }

            var9 = (List)var47;
            break;
         case 3:
            Iterable var28 = (Iterable)this.rawDataPoints;
            Collection var46 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var28, 10)));

            for(IndoorDatapoint var29 : var28) {
               SimpleDatapoint var30;
               if (var29.getPm25() == null) {
                  var30 = null;
               } else {
                  var30 = new SimpleDatapoint(var29.getTimeInSeconds(), var29.getPm25());
               }

               var46.add(var30);
            }

            var9 = (List)var46;
            break;
         case 4:
            Iterable var25 = (Iterable)this.rawDataPoints;
            Collection var45 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var25, 10)));

            for(IndoorDatapoint var26 : var25) {
               SimpleDatapoint var27;
               if (var26.getVoc() == null) {
                  var27 = null;
               } else {
                  var27 = new SimpleDatapoint(var26.getTimeInSeconds(), var26.getVoc());
               }

               var45.add(var27);
            }

            var9 = (List)var45;
            break;
         case 5:
            Iterable var22 = (Iterable)this.rawDataPoints;
            Collection var44 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var22, 10)));

            for(IndoorDatapoint var23 : var22) {
               SimpleDatapoint var24;
               if (var23.getHcho() == null) {
                  var24 = null;
               } else {
                  var24 = new SimpleDatapoint(var23.getTimeInSeconds(), var23.getHcho());
               }

               var44.add(var24);
            }

            var9 = (List)var44;
            break;
         case 6:
            Iterable var19 = (Iterable)this.rawDataPoints;
            Collection var43 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var19, 10)));

            for(IndoorDatapoint var20 : var19) {
               SimpleDatapoint var21;
               if (var20.getHum() == null) {
                  var21 = null;
               } else {
                  var21 = new SimpleDatapoint(var20.getTimeInSeconds(), var20.getHum());
               }

               var43.add(var21);
            }

            var9 = (List)var43;
            break;
         case 7:
            Iterable var16 = (Iterable)this.rawDataPoints;
            Collection var42 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var16, 10)));

            for(IndoorDatapoint var17 : var16) {
               SimpleDatapoint var18;
               if (var17.getTmp() == null) {
                  var18 = null;
               } else {
                  var18 = new SimpleDatapoint(var17.getTimeInSeconds(), var17.getTmp());
               }

               var42.add(var18);
            }

            var9 = (List)var42;
            break;
         case 8:
            Iterable var13 = (Iterable)this.rawDataPoints;
            Collection var41 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var13, 10)));

            for(IndoorDatapoint var14 : var13) {
               SimpleDatapoint var15;
               if (var14.getFan() == null) {
                  var15 = null;
               } else {
                  var15 = new SimpleDatapoint(var14.getTimeInSeconds(), var14.getFan());
               }

               var41.add(var15);
            }

            var9 = (List)var41;
            break;
         case 9:
            Iterable var10 = (Iterable)this.rawDataPoints;
            Collection var40 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var10, 10)));

            for(IndoorDatapoint var11 : var10) {
               SimpleDatapoint var12;
               if (var11.getWeight() == null) {
                  var12 = null;
               } else {
                  var12 = new SimpleDatapoint(var11.getTimeInSeconds(), var11.getWeight());
               }

               var40.add(var12);
            }

            var9 = (List)var40;
            break;
         case 10:
            Iterable var3 = (Iterable)this.rawDataPoints;
            Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));

            for(IndoorDatapoint var7 : var3) {
               SimpleDatapoint var8;
               if (var7.getRpm() == null) {
                  var8 = null;
               } else {
                  var8 = new SimpleDatapoint(var7.getTimeInSeconds(), var7.getRpm());
               }

               var4.add(var8);
            }

            var9 = (List)var4;
            break;
         default:
            throw new NoWhenBranchMatchedException();
      }

      var9 = CollectionsKt.filterNotNull((Iterable)var9);
      if (var1 == SensorType.TMP && !this.isCelsius && !var2) {
         Iterable var38 = (Iterable)var9;
         Collection var6 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var38, 10)));

         for(SimpleDatapoint var39 : var38) {
            var6.add(SimpleDatapoint.copy$default(var39, 0L, Companion.convertCelsiusToFahrenheit(var39.getValue()), 1, (Object)null));
         }

         return (List)var6;
      } else {
         return var9;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceData(deviceId=");
      var1.append(this.deviceId);
      var1.append(", rawDataPoints=");
      var1.append(this.rawDataPoints);
      var1.append(", isCelsius=");
      var1.append(this.isCelsius);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"},
      d2 = {"Lcom/blueair/core/model/DeviceData$Companion;", "", "<init>", "()V", "REAL_TIME_MAX_DELAY", "", "convertCelsiusToFahrenheit", "", "celsius", "", "", "convertFahrenheitToCelsius", "fahrenheit", "toServerValue", "fromServerValue", "value", "core_otherRelease"},
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

      public final double convertCelsiusToFahrenheit(double var1) {
         return var1 * (double)9.0F / (double)5.0F + (double)32.0F;
      }

      public final float convertCelsiusToFahrenheit(float var1) {
         return (float)this.convertCelsiusToFahrenheit((double)var1);
      }

      public final int convertCelsiusToFahrenheit(int var1) {
         return MathKt.roundToInt(this.convertCelsiusToFahrenheit((float)var1));
      }

      public final double convertFahrenheitToCelsius(double var1) {
         return (var1 - (double)32.0F) * (double)5.0F / (double)9.0F;
      }

      public final float convertFahrenheitToCelsius(float var1) {
         return (float)this.convertFahrenheitToCelsius((double)var1);
      }

      public final int convertFahrenheitToCelsius(int var1) {
         return MathKt.roundToInt(this.convertFahrenheitToCelsius((float)var1));
      }

      public final double fromServerValue(int var1) {
         return (double)var1 / (double)10.0F;
      }

      public final int toServerValue(double var1) {
         return MathKt.roundToInt(var1 * (double)10);
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
            var0[SensorType.PM10.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 3;
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
