package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"},
   d2 = {"Lcom/blueair/api/restapi/GetGoogleAuthCodeReq;", "", "clientId", "", "idToken", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getIdToken", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GetGoogleAuthCodeReq {
   private final String clientId;
   private final String idToken;
   private final String type;

   public GetGoogleAuthCodeReq(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "clientId");
      Intrinsics.checkNotNullParameter(var2, "idToken");
      Intrinsics.checkNotNullParameter(var3, "type");
      super();
      this.clientId = var1;
      this.idToken = var2;
      this.type = var3;
   }

   // $FF: synthetic method
   public GetGoogleAuthCodeReq(String var1, String var2, String var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = "google";
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static GetGoogleAuthCodeReq copy$default(GetGoogleAuthCodeReq var0, String var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.clientId;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.idToken;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.type;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.clientId;
   }

   public final String component2() {
      return this.idToken;
   }

   public final String component3() {
      return this.type;
   }

   public final GetGoogleAuthCodeReq copy(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "clientId");
      Intrinsics.checkNotNullParameter(var2, "idToken");
      Intrinsics.checkNotNullParameter(var3, "type");
      return new GetGoogleAuthCodeReq(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof GetGoogleAuthCodeReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.clientId, var1.clientId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.idToken, var1.idToken)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.type, var1.type);
         }
      }
   }

   public final String getClientId() {
      return this.clientId;
   }

   public final String getIdToken() {
      return this.idToken;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return (this.clientId.hashCode() * 31 + this.idToken.hashCode()) * 31 + this.type.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("GetGoogleAuthCodeReq(clientId=");
      var1.append(this.clientId);
      var1.append(", idToken=");
      var1.append(this.idToken);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(')');
      return var1.toString();
   }
}
