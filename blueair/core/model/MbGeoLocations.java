package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"},
   d2 = {"Lcom/blueair/core/model/MbGeoLocations;", "", "type", "", "query", "", "features", "Lcom/blueair/core/model/MbLocationFeatures;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getQuery", "()Ljava/util/List;", "getFeatures", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MbGeoLocations {
   private final List features;
   private final List query;
   private final String type;

   public MbGeoLocations(String var1, List var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "query");
      Intrinsics.checkNotNullParameter(var3, "features");
      super();
      this.type = var1;
      this.query = var2;
      this.features = var3;
   }

   // $FF: synthetic method
   public static MbGeoLocations copy$default(MbGeoLocations var0, String var1, List var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.query;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.features;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.type;
   }

   public final List component2() {
      return this.query;
   }

   public final List component3() {
      return this.features;
   }

   public final MbGeoLocations copy(String var1, List var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "query");
      Intrinsics.checkNotNullParameter(var3, "features");
      return new MbGeoLocations(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof MbGeoLocations)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.query, var1.query)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.features, var1.features);
         }
      }
   }

   public final List getFeatures() {
      return this.features;
   }

   public final List getQuery() {
      return this.query;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return (this.type.hashCode() * 31 + this.query.hashCode()) * 31 + this.features.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("MbGeoLocations(type=");
      var1.append(this.type);
      var1.append(", query=");
      var1.append(this.query);
      var1.append(", features=");
      var1.append(this.features);
      var1.append(')');
      return var1.toString();
   }
}
