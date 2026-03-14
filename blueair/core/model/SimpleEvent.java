package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"},
   d2 = {"Lcom/blueair/core/model/SimpleEvent;", "T", "R", "", "eventType", "data", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getEventType", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getData", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/blueair/core/model/SimpleEvent;", "equals", "", "other", "hashCode", "", "toString", "", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleEvent {
   private final Object data;
   private final Object eventType;

   public SimpleEvent(Object var1, Object var2) {
      this.eventType = var1;
      this.data = var2;
   }

   // $FF: synthetic method
   public static SimpleEvent copy$default(SimpleEvent var0, Object var1, Object var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.eventType;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.data;
      }

      return var0.copy(var1, var2);
   }

   public final Object component1() {
      return this.eventType;
   }

   public final Object component2() {
      return this.data;
   }

   public final SimpleEvent copy(Object var1, Object var2) {
      return new SimpleEvent(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SimpleEvent)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.eventType, var1.eventType)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.data, var1.data);
         }
      }
   }

   public final Object getData() {
      return this.data;
   }

   public final Object getEventType() {
      return this.eventType;
   }

   public int hashCode() {
      Object var3 = this.eventType;
      int var2 = 0;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      var3 = this.data;
      if (var3 != null) {
         var2 = var3.hashCode();
      }

      return var1 * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SimpleEvent(eventType=");
      var1.append(this.eventType);
      var1.append(", data=");
      var1.append(this.data);
      var1.append(')');
      return var1.toString();
   }
}
