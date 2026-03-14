package com.blueair.api.restapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/api/restapi/MqttIncludeWrapper;", "", "include", "", "Lcom/blueair/api/restapi/MqttFilterWrapper;", "<init>", "(Ljava/util/List;)V", "getInclude", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MqttIncludeWrapper {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final List include;

   public MqttIncludeWrapper(List var1) {
      Intrinsics.checkNotNullParameter(var1, "include");
      super();
      this.include = var1;
   }

   // $FF: synthetic method
   public static MqttIncludeWrapper copy$default(MqttIncludeWrapper var0, List var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.include;
      }

      return var0.copy(var1);
   }

   public final List component1() {
      return this.include;
   }

   public final MqttIncludeWrapper copy(List var1) {
      Intrinsics.checkNotNullParameter(var1, "include");
      return new MqttIncludeWrapper(var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof MqttIncludeWrapper)) {
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
      StringBuilder var1 = new StringBuilder("MqttIncludeWrapper(include=");
      var1.append(this.include);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"},
      d2 = {"Lcom/blueair/api/restapi/MqttIncludeWrapper$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/api/restapi/MqttIncludeWrapper;", "deviceUids", "", "", "api_otherRelease"},
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

      public final MqttIncludeWrapper from(List var1) {
         Intrinsics.checkNotNullParameter(var1, "deviceUids");
         Iterable var2 = (Iterable)var1;
         Collection var3 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            var3.add(new MqttFilterWrapper(new MqttFilter((String)var4.next())));
         }

         return new MqttIncludeWrapper((List)var3);
      }
   }
}
