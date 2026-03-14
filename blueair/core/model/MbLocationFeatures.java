package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006$"},
   d2 = {"Lcom/blueair/core/model/MbLocationFeatures;", "", "place_type", "", "", "text", "place_name", "properties", "Lcom/blueair/core/model/MbLocationProperties;", "address", "center", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/MbLocationProperties;Ljava/lang/String;Ljava/util/List;)V", "getPlace_type", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "getPlace_name", "getProperties", "()Lcom/blueair/core/model/MbLocationProperties;", "getAddress", "getCenter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class MbLocationFeatures {
   private final String address;
   private final List center;
   private final String place_name;
   private final List place_type;
   private final MbLocationProperties properties;
   private final String text;

   public MbLocationFeatures(List var1, String var2, String var3, MbLocationProperties var4, String var5, List var6) {
      Intrinsics.checkNotNullParameter(var1, "place_type");
      Intrinsics.checkNotNullParameter(var2, "text");
      Intrinsics.checkNotNullParameter(var3, "place_name");
      Intrinsics.checkNotNullParameter(var4, "properties");
      Intrinsics.checkNotNullParameter(var6, "center");
      super();
      this.place_type = var1;
      this.text = var2;
      this.place_name = var3;
      this.properties = var4;
      this.address = var5;
      this.center = var6;
   }

   // $FF: synthetic method
   public static MbLocationFeatures copy$default(MbLocationFeatures var0, List var1, String var2, String var3, MbLocationProperties var4, String var5, List var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.place_type;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.text;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.place_name;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.properties;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.address;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.center;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   public final List component1() {
      return this.place_type;
   }

   public final String component2() {
      return this.text;
   }

   public final String component3() {
      return this.place_name;
   }

   public final MbLocationProperties component4() {
      return this.properties;
   }

   public final String component5() {
      return this.address;
   }

   public final List component6() {
      return this.center;
   }

   public final MbLocationFeatures copy(List var1, String var2, String var3, MbLocationProperties var4, String var5, List var6) {
      Intrinsics.checkNotNullParameter(var1, "place_type");
      Intrinsics.checkNotNullParameter(var2, "text");
      Intrinsics.checkNotNullParameter(var3, "place_name");
      Intrinsics.checkNotNullParameter(var4, "properties");
      Intrinsics.checkNotNullParameter(var6, "center");
      return new MbLocationFeatures(var1, var2, var3, var4, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof MbLocationFeatures)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.place_type, var1.place_type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.text, var1.text)) {
            return false;
         } else if (!Intrinsics.areEqual(this.place_name, var1.place_name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.properties, var1.properties)) {
            return false;
         } else if (!Intrinsics.areEqual(this.address, var1.address)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.center, var1.center);
         }
      }
   }

   public final String getAddress() {
      return this.address;
   }

   public final List getCenter() {
      return this.center;
   }

   public final String getPlace_name() {
      return this.place_name;
   }

   public final List getPlace_type() {
      return this.place_type;
   }

   public final MbLocationProperties getProperties() {
      return this.properties;
   }

   public final String getText() {
      return this.text;
   }

   public int hashCode() {
      int var3 = this.place_type.hashCode();
      int var2 = this.text.hashCode();
      int var4 = this.place_name.hashCode();
      int var5 = this.properties.hashCode();
      String var6 = this.address;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      return ((((var3 * 31 + var2) * 31 + var4) * 31 + var5) * 31 + var1) * 31 + this.center.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("MbLocationFeatures(place_type=");
      var1.append(this.place_type);
      var1.append(", text=");
      var1.append(this.text);
      var1.append(", place_name=");
      var1.append(this.place_name);
      var1.append(", properties=");
      var1.append(this.properties);
      var1.append(", address=");
      var1.append(this.address);
      var1.append(", center=");
      var1.append(this.center);
      var1.append(')');
      return var1.toString();
   }
}
