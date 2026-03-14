package com.blueair.api.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ<\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"},
   d2 = {"Lcom/blueair/api/model/SensorData;", "", "name", "", "value", "timeDelta", "", "baseTime", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "getTimeDelta", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBaseTime", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Long;Ljava/lang/Long;)Lcom/blueair/api/model/SensorData;", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SensorData {
   private final Long baseTime;
   private final String name;
   private final Long timeDelta;
   private final Object value;

   public SensorData(@Json(name = "n") String var1, @Json(name = "v") Object var2, @Json(name = "t") Long var3, @Json(name = "bt") Long var4) {
      Intrinsics.checkNotNullParameter(var1, "name");
      super();
      this.name = var1;
      this.value = var2;
      this.timeDelta = var3;
      this.baseTime = var4;
   }

   // $FF: synthetic method
   public static SensorData copy$default(SensorData var0, String var1, Object var2, Long var3, Long var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.value;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.timeDelta;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.baseTime;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.name;
   }

   public final Object component2() {
      return this.value;
   }

   public final Long component3() {
      return this.timeDelta;
   }

   public final Long component4() {
      return this.baseTime;
   }

   public final SensorData copy(@Json(name = "n") String var1, @Json(name = "v") Object var2, @Json(name = "t") Long var3, @Json(name = "bt") Long var4) {
      Intrinsics.checkNotNullParameter(var1, "name");
      return new SensorData(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SensorData)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.value, var1.value)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeDelta, var1.timeDelta)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.baseTime, var1.baseTime);
         }
      }
   }

   public final Long getBaseTime() {
      return this.baseTime;
   }

   public final String getName() {
      return this.name;
   }

   public final Long getTimeDelta() {
      return this.timeDelta;
   }

   public final Object getValue() {
      return this.value;
   }

   public int hashCode() {
      int var4 = this.name.hashCode();
      Object var5 = this.value;
      int var3 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      Long var6 = this.timeDelta;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      var6 = this.baseTime;
      if (var6 != null) {
         var3 = var6.hashCode();
      }

      return ((var4 * 31 + var1) * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SensorData(name=");
      var1.append(this.name);
      var1.append(", value=");
      var1.append(this.value);
      var1.append(", timeDelta=");
      var1.append(this.timeDelta);
      var1.append(", baseTime=");
      var1.append(this.baseTime);
      var1.append(')');
      return var1.toString();
   }
}
