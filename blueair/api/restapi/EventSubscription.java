package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"},
   d2 = {"Lcom/blueair/api/restapi/EventSubscription;", "", "include", "", "Lcom/blueair/api/restapi/Include;", "<init>", "(Ljava/util/List;)V", "getInclude", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class EventSubscription {
   private final List include;

   public EventSubscription(List var1) {
      Intrinsics.checkNotNullParameter(var1, "include");
      super();
      this.include = var1;
   }

   // $FF: synthetic method
   public static EventSubscription copy$default(EventSubscription var0, List var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.include;
      }

      return var0.copy(var1);
   }

   public final List component1() {
      return this.include;
   }

   public final EventSubscription copy(List var1) {
      Intrinsics.checkNotNullParameter(var1, "include");
      return new EventSubscription(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof EventSubscription)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.include, var1.include);
      }
   }

   public final List getInclude() {
      return this.include;
   }

   public int hashCode() {
      return this.include.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("EventSubscription(include=");
      var1.append(this.include);
      var1.append(')');
      return var1.toString();
   }
}
