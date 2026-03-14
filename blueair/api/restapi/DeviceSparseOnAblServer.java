package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"},
   d2 = {"Lcom/blueair/api/restapi/DeviceSparseOnAblServer;", "", "name", "", "userId", "", "uuid", "mac", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUserId", "()I", "getUuid", "getMac", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSparseOnAblServer {
   private final String mac;
   private final String name;
   private final int userId;
   private final String uuid;

   public DeviceSparseOnAblServer(String var1, int var2, String var3, String var4) {
      Intrinsics.checkNotNullParameter(var3, "uuid");
      super();
      this.name = var1;
      this.userId = var2;
      this.uuid = var3;
      this.mac = var4;
   }

   // $FF: synthetic method
   public static DeviceSparseOnAblServer copy$default(DeviceSparseOnAblServer var0, String var1, int var2, String var3, String var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.userId;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.uuid;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.mac;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final String component1() {
      return this.name;
   }

   public final int component2() {
      return this.userId;
   }

   public final String component3() {
      return this.uuid;
   }

   public final String component4() {
      return this.mac;
   }

   public final DeviceSparseOnAblServer copy(String var1, int var2, String var3, String var4) {
      Intrinsics.checkNotNullParameter(var3, "uuid");
      return new DeviceSparseOnAblServer(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceSparseOnAblServer)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.userId != var1.userId) {
            return false;
         } else if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.mac, var1.mac);
         }
      }
   }

   public final String getMac() {
      return this.mac;
   }

   public final String getName() {
      return this.name;
   }

   public final int getUserId() {
      return this.userId;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      String var5 = this.name;
      int var2 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      int var3 = this.userId;
      int var4 = this.uuid.hashCode();
      var5 = this.mac;
      if (var5 != null) {
         var2 = var5.hashCode();
      }

      return ((var1 * 31 + var3) * 31 + var4) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceSparseOnAblServer(name=");
      var1.append(this.name);
      var1.append(", userId=");
      var1.append(this.userId);
      var1.append(", uuid=");
      var1.append(this.uuid);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(')');
      return var1.toString();
   }
}
