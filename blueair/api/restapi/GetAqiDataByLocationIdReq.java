package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"},
   d2 = {"Lcom/blueair/api/restapi/GetAqiDataByLocationIdReq;", "", "locationIds", "", "", "range", "", "type", "<init>", "(Ljava/util/List;DLjava/lang/String;)V", "getLocationIds", "()Ljava/util/List;", "getRange", "()D", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GetAqiDataByLocationIdReq {
   private final List locationIds;
   private final double range;
   private final String type;

   public GetAqiDataByLocationIdReq(List var1, double var2, String var4) {
      Intrinsics.checkNotNullParameter(var1, "locationIds");
      Intrinsics.checkNotNullParameter(var4, "type");
      super();
      this.locationIds = var1;
      this.range = var2;
      this.type = var4;
   }

   // $FF: synthetic method
   public GetAqiDataByLocationIdReq(List var1, double var2, String var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var2 = (double)300.0F;
      }

      if ((var5 & 4) != 0) {
         var4 = "id";
      }

      this(var1, var2, var4);
   }

   // $FF: synthetic method
   public static GetAqiDataByLocationIdReq copy$default(GetAqiDataByLocationIdReq var0, List var1, double var2, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.locationIds;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.range;
      }

      if ((var5 & 4) != 0) {
         var4 = var0.type;
      }

      return var0.copy(var1, var2, var4);
   }

   public final List component1() {
      return this.locationIds;
   }

   public final double component2() {
      return this.range;
   }

   public final String component3() {
      return this.type;
   }

   public final GetAqiDataByLocationIdReq copy(List var1, double var2, String var4) {
      Intrinsics.checkNotNullParameter(var1, "locationIds");
      Intrinsics.checkNotNullParameter(var4, "type");
      return new GetAqiDataByLocationIdReq(var1, var2, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GetAqiDataByLocationIdReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.locationIds, var1.locationIds)) {
            return false;
         } else if (Double.compare(this.range, var1.range) != 0) {
            return false;
         } else {
            return Intrinsics.areEqual(this.type, var1.type);
         }
      }
   }

   public final List getLocationIds() {
      return this.locationIds;
   }

   public final double getRange() {
      return this.range;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return (this.locationIds.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.range)) * 31 + this.type.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GetAqiDataByLocationIdReq(locationIds=");
      var1.append(this.locationIds);
      var1.append(", range=");
      var1.append(this.range);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(')');
      return var1.toString();
   }
}
