package com.blueair.auth.retrofit;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"},
   d2 = {"Lcom/blueair/auth/retrofit/SetPushTokenRequest;", "", "token", "", "enabled", "", "osType", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getEnabled", "()Z", "getOsType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SetPushTokenRequest {
   private final boolean enabled;
   private final String osType;
   private final String token;

   public SetPushTokenRequest(String var1, @Json(name = "is_enable") boolean var2, @Json(name = "os_type") String var3) {
      Intrinsics.checkNotNullParameter(var1, "token");
      Intrinsics.checkNotNullParameter(var3, "osType");
      super();
      this.token = var1;
      this.enabled = var2;
      this.osType = var3;
   }

   // $FF: synthetic method
   public SetPushTokenRequest(String var1, boolean var2, String var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = "android";
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static SetPushTokenRequest copy$default(SetPushTokenRequest var0, String var1, boolean var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.token;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.enabled;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.osType;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.token;
   }

   public final boolean component2() {
      return this.enabled;
   }

   public final String component3() {
      return this.osType;
   }

   public final SetPushTokenRequest copy(String var1, @Json(name = "is_enable") boolean var2, @Json(name = "os_type") String var3) {
      Intrinsics.checkNotNullParameter(var1, "token");
      Intrinsics.checkNotNullParameter(var3, "osType");
      return new SetPushTokenRequest(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SetPushTokenRequest)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.token, var1.token)) {
            return false;
         } else if (this.enabled != var1.enabled) {
            return false;
         } else {
            return Intrinsics.areEqual(this.osType, var1.osType);
         }
      }
   }

   public final boolean getEnabled() {
      return this.enabled;
   }

   public final String getOsType() {
      return this.osType;
   }

   public final String getToken() {
      return this.token;
   }

   public int hashCode() {
      return (this.token.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.enabled)) * 31 + this.osType.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SetPushTokenRequest(token=");
      var1.append(this.token);
      var1.append(", enabled=");
      var1.append(this.enabled);
      var1.append(", osType=");
      var1.append(this.osType);
      var1.append(')');
      return var1.toString();
   }
}
