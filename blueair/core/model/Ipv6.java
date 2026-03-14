package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Json(
   name = "ipv6"
)
@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"},
   d2 = {"Lcom/blueair/core/model/Ipv6;", "Landroid/os/Parcelable;", "ipv6", "", "gwv6", "dnsv6", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getIpv6", "()Ljava/lang/String;", "getGwv6", "getDnsv6", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Ipv6 implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final List dnsv6;
   private final String gwv6;
   private final String ipv6;

   public Ipv6(String var1, String var2, List var3) {
      this.ipv6 = var1;
      this.gwv6 = var2;
      this.dnsv6 = var3;
   }

   // $FF: synthetic method
   public Ipv6(String var1, String var2, List var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Ipv6 copy$default(Ipv6 var0, String var1, String var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.ipv6;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.gwv6;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.dnsv6;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.ipv6;
   }

   public final String component2() {
      return this.gwv6;
   }

   public final List component3() {
      return this.dnsv6;
   }

   public final Ipv6 copy(String var1, String var2, List var3) {
      return new Ipv6(var1, var2, var3);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Ipv6)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.ipv6, var1.ipv6)) {
            return false;
         } else if (!Intrinsics.areEqual(this.gwv6, var1.gwv6)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.dnsv6, var1.dnsv6);
         }
      }
   }

   public final List getDnsv6() {
      return this.dnsv6;
   }

   public final String getGwv6() {
      return this.gwv6;
   }

   public final String getIpv6() {
      return this.ipv6;
   }

   public int hashCode() {
      String var4 = this.ipv6;
      int var3 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      var4 = this.gwv6;
      int var2;
      if (var4 == null) {
         var2 = 0;
      } else {
         var2 = var4.hashCode();
      }

      List var6 = this.dnsv6;
      if (var6 != null) {
         var3 = var6.hashCode();
      }

      return (var1 * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Ipv6(ipv6=");
      var1.append(this.ipv6);
      var1.append(", gwv6=");
      var1.append(this.gwv6);
      var1.append(", dnsv6=");
      var1.append(this.dnsv6);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.ipv6);
      var1.writeString(this.gwv6);
      var1.writeStringList(this.dnsv6);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final Ipv6 createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new Ipv6(var1.readString(), var1.readString(), (List)var1.createStringArrayList());
      }

      public final Ipv6[] newArray(int var1) {
         return new Ipv6[var1];
      }
   }
}
