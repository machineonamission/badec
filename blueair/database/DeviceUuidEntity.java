package com.blueair.database;

import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.Ipv4;
import com.blueair.core.model.Ipv6;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"},
   d2 = {"Lcom/blueair/database/DeviceUuidEntity;", "", "uuid", "", "ssid", "bssid", "ipv4", "ipv6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getSsid", "getBssid", "getIpv4", "getIpv6", "toDeviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceUuidEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String bssid;
   private final String ipv4;
   private final String ipv6;
   private final String ssid;
   private final String uuid;

   public DeviceUuidEntity(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      super();
      this.uuid = var1;
      this.ssid = var2;
      this.bssid = var3;
      this.ipv4 = var4;
      this.ipv6 = var5;
   }

   // $FF: synthetic method
   public static DeviceUuidEntity copy$default(DeviceUuidEntity var0, String var1, String var2, String var3, String var4, String var5, int var6, Object var7) {
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

   public final String component4() {
      return this.ipv4;
   }

   public final String component5() {
      return this.ipv6;
   }

   public final DeviceUuidEntity copy(String var1, String var2, String var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      return new DeviceUuidEntity(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceUuidEntity)) {
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

   public final String getIpv4() {
      return this.ipv4;
   }

   public final String getIpv6() {
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

      var6 = this.ipv4;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      var6 = this.ipv6;
      if (var6 != null) {
         var4 = var6.hashCode();
      }

      return (((var5 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4;
   }

   public final DeviceUuid toDeviceUuid() {
      return new DeviceUuid(this.uuid, this.ssid, this.bssid, new Ipv4(this.ipv4, (String)null, (List)null, 6, (DefaultConstructorMarker)null), new Ipv6(this.ipv6, (String)null, (List)null, 6, (DefaultConstructorMarker)null));
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceUuidEntity(uuid=");
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

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/database/DeviceUuidEntity$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/database/DeviceUuidEntity;", "uid", "Lcom/blueair/core/model/DeviceUuid;", "database_otherRelease"},
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

      public final DeviceUuidEntity from(DeviceUuid var1) {
         Intrinsics.checkNotNullParameter(var1, "uid");
         String var6 = var1.getUuid();
         String var5 = var1.getSsid();
         String var4 = var1.getBssid();
         Ipv4 var2 = var1.getIpv4();
         Object var3 = null;
         String var9;
         if (var2 != null) {
            var9 = var2.getIp();
         } else {
            var9 = null;
         }

         Ipv6 var7 = var1.getIpv6();
         String var8 = (String)var3;
         if (var7 != null) {
            var8 = var7.getIpv6();
         }

         return new DeviceUuidEntity(var6, var5, var4, var9, var8);
      }
   }
}
