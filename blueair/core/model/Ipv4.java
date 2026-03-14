package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"},
   d2 = {"Lcom/blueair/core/model/Ipv4;", "Landroid/os/Parcelable;", "ip", "", "gw", "dns", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getIp", "()Ljava/lang/String;", "getGw", "getDns", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Ipv4 implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final List dns;
   private final String gw;
   private final String ip;

   public Ipv4(String var1, String var2, List var3) {
      this.ip = var1;
      this.gw = var2;
      this.dns = var3;
   }

   // $FF: synthetic method
   public Ipv4(String var1, String var2, List var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Ipv4 copy$default(Ipv4 var0, String var1, String var2, List var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.ip;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.gw;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.dns;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.ip;
   }

   public final String component2() {
      return this.gw;
   }

   public final List component3() {
      return this.dns;
   }

   public final Ipv4 copy(String var1, String var2, List var3) {
      return new Ipv4(var1, var2, var3);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Ipv4)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.ip, var1.ip)) {
            return false;
         } else if (!Intrinsics.areEqual(this.gw, var1.gw)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.dns, var1.dns);
         }
      }
   }

   public final List getDns() {
      return this.dns;
   }

   public final String getGw() {
      return this.gw;
   }

   public final String getIp() {
      return this.ip;
   }

   public int hashCode() {
      String var4 = this.ip;
      int var3 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      var4 = this.gw;
      int var2;
      if (var4 == null) {
         var2 = 0;
      } else {
         var2 = var4.hashCode();
      }

      List var6 = this.dns;
      if (var6 != null) {
         var3 = var6.hashCode();
      }

      return (var1 * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Ipv4(ip=");
      var1.append(this.ip);
      var1.append(", gw=");
      var1.append(this.gw);
      var1.append(", dns=");
      var1.append(this.dns);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.ip);
      var1.writeString(this.gw);
      var1.writeStringList(this.dns);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final Ipv4 createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new Ipv4(var1.readString(), var1.readString(), (List)var1.createStringArrayList());
      }

      public final Ipv4[] newArray(int var1) {
         return new Ipv4[var1];
      }
   }
}
