package com.blueair.auth.retrofit;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"},
   d2 = {"Lcom/blueair/auth/retrofit/BlueLoginDetails;", "", "access_token", "", "token_type", "expires_in", "", "refresh_token", "id_token", "custom_auth_name", "custom_auth_signature", "custom_auth_token", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "getToken_type", "getExpires_in", "()I", "getRefresh_token", "getId_token", "getCustom_auth_name", "getCustom_auth_signature", "getCustom_auth_token", "isEmpty", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueLoginDetails {
   private final String access_token;
   private final String custom_auth_name;
   private final String custom_auth_signature;
   private final String custom_auth_token;
   private final int expires_in;
   private final String id_token;
   private final String refresh_token;
   private final String token_type;

   public BlueLoginDetails() {
      this((String)null, (String)null, 0, (String)null, (String)null, (String)null, (String)null, (String)null, 255, (DefaultConstructorMarker)null);
   }

   public BlueLoginDetails(String var1, String var2, int var3, String var4, String var5, @Json(name = "ba_X-Amz-CustomAuthorizer-Name") String var6, @Json(name = "ba_X-Amz-CustomAuthorizer-Signature") String var7, @Json(name = "ba_X-Amz-CustomAuthorizer-Token") String var8) {
      Intrinsics.checkNotNullParameter(var1, "access_token");
      Intrinsics.checkNotNullParameter(var2, "token_type");
      Intrinsics.checkNotNullParameter(var4, "refresh_token");
      Intrinsics.checkNotNullParameter(var5, "id_token");
      Intrinsics.checkNotNullParameter(var6, "custom_auth_name");
      Intrinsics.checkNotNullParameter(var7, "custom_auth_signature");
      Intrinsics.checkNotNullParameter(var8, "custom_auth_token");
      super();
      this.access_token = var1;
      this.token_type = var2;
      this.expires_in = var3;
      this.refresh_token = var4;
      this.id_token = var5;
      this.custom_auth_name = var6;
      this.custom_auth_signature = var7;
      this.custom_auth_token = var8;
   }

   // $FF: synthetic method
   public BlueLoginDetails(String var1, String var2, int var3, String var4, String var5, String var6, String var7, String var8, int var9, DefaultConstructorMarker var10) {
      if ((var9 & 1) != 0) {
         var1 = "";
      }

      if ((var9 & 2) != 0) {
         var2 = "";
      }

      if ((var9 & 4) != 0) {
         var3 = 0;
      }

      if ((var9 & 8) != 0) {
         var4 = "";
      }

      if ((var9 & 16) != 0) {
         var5 = "";
      }

      if ((var9 & 32) != 0) {
         var6 = "";
      }

      if ((var9 & 64) != 0) {
         var7 = "";
      }

      if ((var9 & 128) != 0) {
         var8 = "";
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   // $FF: synthetic method
   public static BlueLoginDetails copy$default(BlueLoginDetails var0, String var1, String var2, int var3, String var4, String var5, String var6, String var7, String var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.access_token;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.token_type;
      }

      if ((var9 & 4) != 0) {
         var3 = var0.expires_in;
      }

      if ((var9 & 8) != 0) {
         var4 = var0.refresh_token;
      }

      if ((var9 & 16) != 0) {
         var5 = var0.id_token;
      }

      if ((var9 & 32) != 0) {
         var6 = var0.custom_auth_name;
      }

      if ((var9 & 64) != 0) {
         var7 = var0.custom_auth_signature;
      }

      if ((var9 & 128) != 0) {
         var8 = var0.custom_auth_token;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final String component1() {
      return this.access_token;
   }

   public final String component2() {
      return this.token_type;
   }

   public final int component3() {
      return this.expires_in;
   }

   public final String component4() {
      return this.refresh_token;
   }

   public final String component5() {
      return this.id_token;
   }

   public final String component6() {
      return this.custom_auth_name;
   }

   public final String component7() {
      return this.custom_auth_signature;
   }

   public final String component8() {
      return this.custom_auth_token;
   }

   public final BlueLoginDetails copy(String var1, String var2, int var3, String var4, String var5, @Json(name = "ba_X-Amz-CustomAuthorizer-Name") String var6, @Json(name = "ba_X-Amz-CustomAuthorizer-Signature") String var7, @Json(name = "ba_X-Amz-CustomAuthorizer-Token") String var8) {
      Intrinsics.checkNotNullParameter(var1, "access_token");
      Intrinsics.checkNotNullParameter(var2, "token_type");
      Intrinsics.checkNotNullParameter(var4, "refresh_token");
      Intrinsics.checkNotNullParameter(var5, "id_token");
      Intrinsics.checkNotNullParameter(var6, "custom_auth_name");
      Intrinsics.checkNotNullParameter(var7, "custom_auth_signature");
      Intrinsics.checkNotNullParameter(var8, "custom_auth_token");
      return new BlueLoginDetails(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueLoginDetails)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.access_token, var1.access_token)) {
            return false;
         } else if (!Intrinsics.areEqual(this.token_type, var1.token_type)) {
            return false;
         } else if (this.expires_in != var1.expires_in) {
            return false;
         } else if (!Intrinsics.areEqual(this.refresh_token, var1.refresh_token)) {
            return false;
         } else if (!Intrinsics.areEqual(this.id_token, var1.id_token)) {
            return false;
         } else if (!Intrinsics.areEqual(this.custom_auth_name, var1.custom_auth_name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.custom_auth_signature, var1.custom_auth_signature)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.custom_auth_token, var1.custom_auth_token);
         }
      }
   }

   public final String getAccess_token() {
      return this.access_token;
   }

   public final String getCustom_auth_name() {
      return this.custom_auth_name;
   }

   public final String getCustom_auth_signature() {
      return this.custom_auth_signature;
   }

   public final String getCustom_auth_token() {
      return this.custom_auth_token;
   }

   public final int getExpires_in() {
      return this.expires_in;
   }

   public final String getId_token() {
      return this.id_token;
   }

   public final String getRefresh_token() {
      return this.refresh_token;
   }

   public final String getToken_type() {
      return this.token_type;
   }

   public int hashCode() {
      return ((((((this.access_token.hashCode() * 31 + this.token_type.hashCode()) * 31 + this.expires_in) * 31 + this.refresh_token.hashCode()) * 31 + this.id_token.hashCode()) * 31 + this.custom_auth_name.hashCode()) * 31 + this.custom_auth_signature.hashCode()) * 31 + this.custom_auth_token.hashCode();
   }

   public final boolean isEmpty() {
      return ((CharSequence)this.id_token).length() == 0 && ((CharSequence)this.access_token).length() == 0 && ((CharSequence)this.custom_auth_name).length() == 0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueLoginDetails(access_token=");
      var1.append(this.access_token);
      var1.append(", token_type=");
      var1.append(this.token_type);
      var1.append(", expires_in=");
      var1.append(this.expires_in);
      var1.append(", refresh_token=");
      var1.append(this.refresh_token);
      var1.append(", id_token=");
      var1.append(this.id_token);
      var1.append(", custom_auth_name=");
      var1.append(this.custom_auth_name);
      var1.append(", custom_auth_signature=");
      var1.append(this.custom_auth_signature);
      var1.append(", custom_auth_token=");
      var1.append(this.custom_auth_token);
      var1.append(')');
      return var1.toString();
   }
}
