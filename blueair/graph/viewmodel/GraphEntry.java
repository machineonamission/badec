package com.blueair.graph.viewmodel;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.github.mikephil.charting.data.Entry;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"},
   d2 = {"Lcom/blueair/graph/viewmodel/GraphEntry;", "Lcom/github/mikephil/charting/data/Entry;", "xx", "", "yy", "", "<init>", "(JF)V", "getXx", "()J", "getYy", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphEntry extends Entry {
   private final long xx;
   private final float yy;

   public GraphEntry(long var1, float var3) {
      this.xx = var1;
      this.yy = var3;
   }

   // $FF: synthetic method
   public static GraphEntry copy$default(GraphEntry var0, long var1, float var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.xx;
      }

      if ((var4 & 2) != 0) {
         var3 = var0.yy;
      }

      return var0.copy(var1, var3);
   }

   public final long component1() {
      return this.xx;
   }

   public final float component2() {
      return this.yy;
   }

   public final GraphEntry copy(long var1, float var3) {
      return new GraphEntry(var1, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GraphEntry)) {
         return false;
      } else {
         GraphEntry var2 = (GraphEntry)var1;
         if (this.xx != var2.xx) {
            return false;
         } else {
            return Float.compare(this.yy, var2.yy) == 0;
         }
      }
   }

   public final long getXx() {
      return this.xx;
   }

   public final float getYy() {
      return this.yy;
   }

   public int hashCode() {
      return AddDeviceState$$ExternalSyntheticBackport0.m(this.xx) * 31 + Float.floatToIntBits(this.yy);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GraphEntry(xx=");
      var1.append(this.xx);
      var1.append(", yy=");
      var1.append(this.yy);
      var1.append(')');
      return var1.toString();
   }
}
