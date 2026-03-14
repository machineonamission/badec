package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.IndoorDatapoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\bHÆ\u0003J_\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006&"},
   d2 = {"Lcom/blueair/api/restapi/DatapointsWrapper;", "", "uuid", "", "start", "", "end", "sensors", "", "units", "datapoints", "", "<init>", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getUuid", "()Ljava/lang/String;", "getStart", "()J", "getEnd", "getSensors", "()Ljava/util/List;", "getUnits", "getDatapoints", "convertToIndoorDataPoints", "Lcom/blueair/core/model/IndoorDatapoint;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DatapointsWrapper {
   private final List datapoints;
   private final long end;
   private final List sensors;
   private final long start;
   private final List units;
   private final String uuid;

   public DatapointsWrapper(String var1, long var2, long var4, List var6, List var7, List var8) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      Intrinsics.checkNotNullParameter(var6, "sensors");
      Intrinsics.checkNotNullParameter(var7, "units");
      Intrinsics.checkNotNullParameter(var8, "datapoints");
      super();
      this.uuid = var1;
      this.start = var2;
      this.end = var4;
      this.sensors = var6;
      this.units = var7;
      this.datapoints = var8;
   }

   // $FF: synthetic method
   public static DatapointsWrapper copy$default(DatapointsWrapper var0, String var1, long var2, long var4, List var6, List var7, List var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.uuid;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.start;
      }

      if ((var9 & 4) != 0) {
         var4 = var0.end;
      }

      if ((var9 & 8) != 0) {
         var6 = var0.sensors;
      }

      if ((var9 & 16) != 0) {
         var7 = var0.units;
      }

      if ((var9 & 32) != 0) {
         var8 = var0.datapoints;
      }

      return var0.copy(var1, var2, var4, var6, var7, var8);
   }

   public final String component1() {
      return this.uuid;
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
      return this.units;
   }

   public final List component6() {
      return this.datapoints;
   }

   public final List convertToIndoorDataPoints() {
      List var16 = (List)(new ArrayList());

      for(List var19 : (Iterable)this.datapoints) {
         long var2 = this.start;
         Iterator var18 = ((Iterable)this.sensors).iterator();
         int var1 = 0;
         Float var15 = null;
         Float var14 = null;
         Float var10 = var14;
         Float var11 = var14;
         Float var12 = var14;

         Float var9;
         Float var13;
         for(var13 = var14; var18.hasNext(); var10 = var9) {
            Object var4 = var18.next();
            if (var1 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            Float var6;
            Float var7;
            Float var8;
            Float var29;
            label75: {
               String var5 = (String)var4;
               String var21;
               switch (var5.hashCode()) {
                  case 3581:
                     if (!var5.equals("pm")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var28 = (Double)var19.get(var1);
                        if (var28 != null) {
                           var6 = (float)var28;
                           var22 = var15;
                           var29 = var14;
                           var7 = var12;
                           var8 = var11;
                           var9 = var10;
                        } else {
                           var6 = null;
                           var9 = var10;
                           var8 = var11;
                           var7 = var12;
                           var29 = var14;
                           var22 = var15;
                        }
                     }
                     break label75;
                  case 98630:
                     var21 = "co2";
                     break;
                  case 103680:
                     if (!var5.equals("hum")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var27 = (Double)var19.get(var1);
                        if (var27 != null) {
                           var9 = (float)var27;
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                        } else {
                           var9 = null;
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                        }
                     }
                     break label75;
                  case 111060:
                     if (!var5.equals("pm1")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var26 = (Double)var19.get(var1);
                        if (var26 != null) {
                           var22 = (float)var26;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                           var9 = var10;
                        } else {
                           var22 = null;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                           var9 = var10;
                        }
                     }
                     break label75;
                  case 114967:
                     if (!var5.equals("tmp")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var25 = (Double)var19.get(var1);
                        if (var25 != null) {
                           var8 = (float)var25;
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var9 = var10;
                        } else {
                           var8 = null;
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var9 = var10;
                        }
                     }
                     break label75;
                  case 116938:
                     if (!var5.equals("voc")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var24 = (Double)var19.get(var1);
                        if (var24 != null) {
                           var7 = (float)var24;
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var8 = var11;
                           var9 = var10;
                        } else {
                           var7 = null;
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var8 = var11;
                           var9 = var10;
                        }
                     }
                     break label75;
                  case 3442908:
                     if (!var5.equals("pm10")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var23 = (Double)var19.get(var1);
                        if (var23 != null) {
                           var29 = (float)var23;
                           var22 = var15;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                           var9 = var10;
                        } else {
                           var29 = null;
                           var22 = var15;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                           var9 = var10;
                        }
                     }
                     break label75;
                  case 3560141:
                     if (!var5.equals("time")) {
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                     } else {
                        Double var20 = (Double)var19.get(var1);
                        var22 = var15;
                        var29 = var14;
                        var6 = var13;
                        var7 = var12;
                        var8 = var11;
                        var9 = var10;
                        if (var20 != null) {
                           var2 = MathKt.roundToLong(var20);
                           var22 = var15;
                           var29 = var14;
                           var6 = var13;
                           var7 = var12;
                           var8 = var11;
                           var9 = var10;
                        }
                     }
                     break label75;
                  case 1813824405:
                     var21 = "allpollu";
                     break;
                  default:
                     var22 = var15;
                     var29 = var14;
                     var6 = var13;
                     var7 = var12;
                     var8 = var11;
                     var9 = var10;
                     break label75;
               }

               var5.equals(var21);
               var22 = var15;
               var29 = var14;
               var6 = var13;
               var7 = var12;
               var8 = var11;
               var9 = var10;
            }

            ++var1;
            var15 = var22;
            var14 = var29;
            var13 = var6;
            var12 = var7;
            var11 = var8;
         }

         var16.add(new IndoorDatapoint(var2, var15, var14, var13, var12, (Float)null, var11, var10, (Float)null, (Float)null, (Float)null));
      }

      return var16;
   }

   public final DatapointsWrapper copy(String var1, long var2, long var4, List var6, List var7, List var8) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      Intrinsics.checkNotNullParameter(var6, "sensors");
      Intrinsics.checkNotNullParameter(var7, "units");
      Intrinsics.checkNotNullParameter(var8, "datapoints");
      return new DatapointsWrapper(var1, var2, var4, var6, var7, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DatapointsWrapper)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (this.start != var1.start) {
            return false;
         } else if (this.end != var1.end) {
            return false;
         } else if (!Intrinsics.areEqual(this.sensors, var1.sensors)) {
            return false;
         } else if (!Intrinsics.areEqual(this.units, var1.units)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.datapoints, var1.datapoints);
         }
      }
   }

   public final List getDatapoints() {
      return this.datapoints;
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

   public final List getUnits() {
      return this.units;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      return ((((this.uuid.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.start)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.end)) * 31 + this.sensors.hashCode()) * 31 + this.units.hashCode()) * 31 + this.datapoints.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DatapointsWrapper(uuid=");
      var1.append(this.uuid);
      var1.append(", start=");
      var1.append(this.start);
      var1.append(", end=");
      var1.append(this.end);
      var1.append(", sensors=");
      var1.append(this.sensors);
      var1.append(", units=");
      var1.append(this.units);
      var1.append(", datapoints=");
      var1.append(this.datapoints);
      var1.append(')');
      return var1.toString();
   }
}
