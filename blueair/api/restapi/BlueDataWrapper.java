package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.api.utils.BlueCloudSensor;
import com.blueair.core.model.IndoorDatapoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\b¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\bHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006#"},
   d2 = {"Lcom/blueair/api/restapi/BlueDataWrapper;", "", "did", "", "start", "", "end", "sensors", "", "datapoints", "", "<init>", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;)V", "getDid", "()Ljava/lang/String;", "getStart", "()J", "getEnd", "getSensors", "()Ljava/util/List;", "getDatapoints", "convertToSimpleIndoorDataPoints", "Lcom/blueair/core/model/IndoorDatapoint;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueDataWrapper {
   private final List datapoints;
   private final String did;
   private final long end;
   private final List sensors;
   private final long start;

   public BlueDataWrapper(String var1, long var2, long var4, List var6, List var7) {
      Intrinsics.checkNotNullParameter(var1, "did");
      Intrinsics.checkNotNullParameter(var6, "sensors");
      Intrinsics.checkNotNullParameter(var7, "datapoints");
      super();
      this.did = var1;
      this.start = var2;
      this.end = var4;
      this.sensors = var6;
      this.datapoints = var7;
   }

   // $FF: synthetic method
   public static BlueDataWrapper copy$default(BlueDataWrapper var0, String var1, long var2, long var4, List var6, List var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.did;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.start;
      }

      if ((var8 & 4) != 0) {
         var4 = var0.end;
      }

      if ((var8 & 8) != 0) {
         var6 = var0.sensors;
      }

      if ((var8 & 16) != 0) {
         var7 = var0.datapoints;
      }

      return var0.copy(var1, var2, var4, var6, var7);
   }

   public final String component1() {
      return this.did;
   }

   public final long component2() {
      return this.start;
   }

   public final long component3() {
      return this.end;
   }

   public final List component4() {
      return this.sensors;
   }

   public final List component5() {
      return this.datapoints;
   }

   public final List convertToSimpleIndoorDataPoints() {
      List var28 = (List)(new ArrayList());

      for(List var29 : (Iterable)this.datapoints) {
         Double var7 = (Double)var29.get(0);
         long var4;
         if (var7 != null) {
            var4 = (long)var7;
         } else {
            var4 = System.currentTimeMillis() / 1000L;
         }

         Iterator var13 = ((Iterable)this.sensors).iterator();
         Float var8 = 0.0F;
         Float var10 = 0.0F;
         Float var9 = 0.0F;
         int var1 = 0;
         Float var12 = 0.0F;
         Float var11 = 0.0F;
         Float var15 = 0.0F;
         Float var14 = 0.0F;
         Float var17 = 0.0F;
         Float var16 = 0.0F;

         Float var18;
         Float var64;
         for(var18 = 0.0F; var13.hasNext(); var9 = var64) {
            Object var31 = var13.next();
            int var2 = var1 + 1;
            if (var1 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            String var30 = (String)var31;
            Timber.Forest var19 = Timber.Forest;
            StringBuilder var32 = new StringBuilder("convertToSimpleIndoorDataPoints: index = ");
            var32.append(var1);
            var32.append(", sensor = ");
            var32.append(var30);
            var19.d(var32.toString(), new Object[0]);
            boolean var3 = Intrinsics.areEqual(var30, BlueCloudSensor.PM1.INSTANCE.getName());
            Object var24 = null;
            Object var22 = null;
            Object var20 = null;
            Object var26 = null;
            Object var25 = null;
            Float var33 = null;
            Object var23 = null;
            Object var21 = null;
            Object var27 = null;
            Object var56 = null;
            Float var57;
            Float var58;
            Float var59;
            Float var60;
            Float var61;
            Float var62;
            Float var63;
            if (var3) {
               Double var55 = (Double)var29.get(var2);
               var33 = (Float)var56;
               if (var55 != null) {
                  var33 = (float)var55;
               }

               var57 = var17;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.PM10.INSTANCE.getName())) {
               Double var54 = (Double)var29.get(var2);
               var33 = (Float)var24;
               if (var54 != null) {
                  var33 = (float)var54;
               }

               var57 = var33;
               var33 = var18;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.PM25.INSTANCE.getName())) {
               Double var53 = (Double)var29.get(var2);
               var33 = (Float)var22;
               if (var53 != null) {
                  var33 = (float)var53;
               }

               var58 = var33;
               var33 = var18;
               var57 = var17;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.VOC.INSTANCE.getName())) {
               Double var52 = (Double)var29.get(var2);
               var33 = (Float)var20;
               if (var52 != null) {
                  var33 = (float)var52;
               }

               var59 = var33;
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.HCHO.INSTANCE.getName())) {
               Double var51 = (Double)var29.get(var2);
               var33 = (Float)var26;
               if (var51 != null) {
                  var33 = (float)var51;
               }

               var60 = var33;
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var59 = var15;
               var61 = var12;
               var62 = var11;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.Temperature.INSTANCE.getName())) {
               Double var50 = (Double)var29.get(var2);
               var33 = (Float)var25;
               if (var50 != null) {
                  var33 = (float)var50;
               }

               var61 = var33;
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var62 = var11;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.Humidity.INSTANCE.getName())) {
               Double var49 = (Double)var29.get(var2);
               if (var49 != null) {
                  var33 = (float)var49;
               }

               var62 = var33;
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var63 = var10;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.Fan.INSTANCE.getName())) {
               Double var48 = (Double)var29.get(var2);
               var33 = (Float)var23;
               if (var48 != null) {
                  var33 = (float)var48;
               }

               var63 = var33;
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var64 = var9;
            } else if (Intrinsics.areEqual(var30, BlueCloudSensor.Weight.INSTANCE.getName())) {
               Double var46 = (Double)var29.get(var2);
               var33 = (Float)var21;
               if (var46 != null) {
                  var33 = (float)var46;
               }

               var64 = var33;
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var63 = var10;
            } else {
               var33 = var18;
               var57 = var17;
               var58 = var16;
               var59 = var15;
               var60 = var14;
               var61 = var12;
               var62 = var11;
               var63 = var10;
               var64 = var9;
               if (Intrinsics.areEqual(var30, BlueCloudSensor.RPM.INSTANCE.getName())) {
                  Double var44 = (Double)var29.get(var2);
                  var33 = (Float)var27;
                  if (var44 != null) {
                     var33 = (float)var44;
                  }

                  var8 = var33;
                  var64 = var9;
                  var63 = var10;
                  var62 = var11;
                  var61 = var12;
                  var60 = var14;
                  var59 = var15;
                  var58 = var16;
                  var57 = var17;
                  var33 = var18;
               }
            }

            var1 = var2;
            var18 = var33;
            var17 = var57;
            var16 = var58;
            var15 = var59;
            var14 = var60;
            var12 = var61;
            var11 = var62;
            var10 = var63;
         }

         IndoorDatapoint var47 = new IndoorDatapoint(var4, var18, var17, var16, var15, var14, var12, var11, var10, var9, var8);
         Timber.Forest var45 = Timber.Forest;
         StringBuilder var43 = new StringBuilder("convertToSimpleIndoorDataPoints: idp = ");
         var43.append(var47);
         var45.d(var43.toString(), new Object[0]);
         var28.add(var47);
      }

      return var28;
   }

   public final BlueDataWrapper copy(String var1, long var2, long var4, List var6, List var7) {
      Intrinsics.checkNotNullParameter(var1, "did");
      Intrinsics.checkNotNullParameter(var6, "sensors");
      Intrinsics.checkNotNullParameter(var7, "datapoints");
      return new BlueDataWrapper(var1, var2, var4, var6, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueDataWrapper)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.did, var1.did)) {
            return false;
         } else if (this.start != var1.start) {
            return false;
         } else if (this.end != var1.end) {
            return false;
         } else if (!Intrinsics.areEqual(this.sensors, var1.sensors)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.datapoints, var1.datapoints);
         }
      }
   }

   public final List getDatapoints() {
      return this.datapoints;
   }

   public final String getDid() {
      return this.did;
   }

   public final long getEnd() {
      return this.end;
   }

   public final List getSensors() {
      return this.sensors;
   }

   public final long getStart() {
      return this.start;
   }

   public int hashCode() {
      return (((this.did.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.start)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.end)) * 31 + this.sensors.hashCode()) * 31 + this.datapoints.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueDataWrapper(did=");
      var1.append(this.did);
      var1.append(", start=");
      var1.append(this.start);
      var1.append(", end=");
      var1.append(this.end);
      var1.append(", sensors=");
      var1.append(this.sensors);
      var1.append(", datapoints=");
      var1.append(this.datapoints);
      var1.append(')');
      return var1.toString();
   }
}
