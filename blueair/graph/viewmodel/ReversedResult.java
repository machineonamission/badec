package com.blueair.graph.viewmodel;

import com.blueair.core.model.SimpleDatapoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"},
   d2 = {"Lcom/blueair/graph/viewmodel/ReversedResult;", "", "dataPoint", "Lcom/blueair/core/model/SimpleDatapoint;", "compareDataPoint", "<init>", "(Lcom/blueair/core/model/SimpleDatapoint;Lcom/blueair/core/model/SimpleDatapoint;)V", "getDataPoint", "()Lcom/blueair/core/model/SimpleDatapoint;", "getCompareDataPoint", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ReversedResult {
   private final SimpleDatapoint compareDataPoint;
   private final SimpleDatapoint dataPoint;

   public ReversedResult(SimpleDatapoint var1, SimpleDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "dataPoint");
      super();
      this.dataPoint = var1;
      this.compareDataPoint = var2;
   }

   // $FF: synthetic method
   public static ReversedResult copy$default(ReversedResult var0, SimpleDatapoint var1, SimpleDatapoint var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.dataPoint;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.compareDataPoint;
      }

      return var0.copy(var1, var2);
   }

   public final SimpleDatapoint component1() {
      return this.dataPoint;
   }

   public final SimpleDatapoint component2() {
      return this.compareDataPoint;
   }

   public final ReversedResult copy(SimpleDatapoint var1, SimpleDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "dataPoint");
      return new ReversedResult(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ReversedResult)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.dataPoint, var1.dataPoint)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.compareDataPoint, var1.compareDataPoint);
         }
      }
   }

   public final SimpleDatapoint getCompareDataPoint() {
      return this.compareDataPoint;
   }

   public final SimpleDatapoint getDataPoint() {
      return this.dataPoint;
   }

   public int hashCode() {
      int var2 = this.dataPoint.hashCode();
      SimpleDatapoint var3 = this.compareDataPoint;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      return var2 * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ReversedResult(dataPoint=");
      var1.append(this.dataPoint);
      var1.append(", compareDataPoint=");
      var1.append(this.compareDataPoint);
      var1.append(')');
      return var1.toString();
   }
}
