package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Json(
   name = "uuid"
)
@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"},
   d2 = {"Lcom/blueair/core/model/DeviceUuid;", "Landroid/os/Parcelable;", "uuid", "", "ssid", "bssid", "ipv4", "Lcom/blueair/core/model/Ipv4;", "ipv6", "Lcom/blueair/core/model/Ipv6;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Ipv4;Lcom/blueair/core/model/Ipv6;)V", "getUuid", "()Ljava/lang/String;", "getSsid", "getBssid", "getIpv4", "()Lcom/blueair/core/model/Ipv4;", "getIpv6", "()Lcom/blueair/core/model/Ipv6;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceUuid implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final String bssid;
   private final Ipv4 ipv4;
   private final Ipv6 ipv6;
   private final String ssid;
   private final String uuid;

   public DeviceUuid(String var1, String var2, String var3, Ipv4 var4, Ipv6 var5) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      super();
      this.uuid = var1;
      this.ssid = var2;
      this.bssid = var3;
      this.ipv4 = var4;
      this.ipv6 = var5;
   }

   // $FF: synthetic method
   public static DeviceUuid copy$default(DeviceUuid var0, String var1, String var2, String var3, Ipv4 var4, Ipv6 var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.uuid;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.ssid;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.bssid;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.ipv4;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.ipv6;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.uuid;
   }

   public final String component2() {
      return this.ssid;
   }

   public final String component3() {
      return this.bssid;
   }

   public final Ipv4 component4() {
      return this.ipv4;
   }

   public final Ipv6 component5() {
      return this.ipv6;
   }

   public final DeviceUuid copy(String var1, String var2, String var3, Ipv4 var4, Ipv6 var5) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      return new DeviceUuid(var1, var2, var3, var4, var5);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceUuid)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ssid, var1.ssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.bssid, var1.bssid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ipv4, var1.ipv4)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.ipv6, var1.ipv6);
         }
      }
   }

   public final String getBssid() {
      return this.bssid;
   }

   public final Ipv4 getIpv4() {
      return this.ipv4;
   }

   public final Ipv6 getIpv6() {
      return this.ipv6;
   }

   public final String getSsid() {
      return this.ssid;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      int var5 = this.uuid.hashCode();
      String var6 = this.ssid;
      int var4 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.bssid;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      Ipv4 var8 = this.ipv4;
      int var3;
      if (var8 == null) {
         var3 = 0;
      } else {
         var3 = var8.hashCode();
      }

      Ipv6 var9 = this.ipv6;
      if (var9 != null) {
         var4 = var9.hashCode();
      }

      return (((var5 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceUuid(uuid=");
      var1.append(this.uuid);
      var1.append(", ssid=");
      var1.append(this.ssid);
      var1.append(", bssid=");
      var1.append(this.bssid);
      var1.append(", ipv4=");
      var1.append(this.ipv4);
      var1.append(", ipv6=");
      var1.append(this.ipv6);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.uuid);
      var1.writeString(this.ssid);
      var1.writeString(this.bssid);
      Ipv4 var3 = this.ipv4;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var3.writeToParcel(var1, var2);
      }

      Ipv6 var4 = this.ipv6;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceUuid createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var7 = var1.readString();
         String var6 = var1.readString();
         String var5 = var1.readString();
         int var2 = var1.readInt();
         Object var4 = null;
         Object var3;
         if (var2 == 0) {
            var3 = null;
         } else {
            var3 = Ipv4.CREATOR.createFromParcel(var1);
         }

         Ipv4 var9 = (Ipv4)var3;
         Object var8;
         if (var1.readInt() == 0) {
            var8 = var4;
         } else {
            var8 = Ipv6.CREATOR.createFromParcel(var1);
         }

         return new DeviceUuid(var7, var6, var5, var9, (Ipv6)var8);
      }

      public final DeviceUuid[] newArray(int var1) {
         return new DeviceUuid[var1];
      }
   }
}
