package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "},
   d2 = {"Lcom/blueair/api/restapi/AlexaLinkAppReq;", "", "clientId", "", "responseType", "state", "scope", "redirectUri", "userAccepted", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getClientId", "()Ljava/lang/String;", "getResponseType", "getState", "getScope", "getRedirectUri", "getUserAccepted", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AlexaLinkAppReq {
   private final String clientId;
   private final String redirectUri;
   private final String responseType;
   private final String scope;
   private final String state;
   private final boolean userAccepted;

   public AlexaLinkAppReq(String var1, String var2, String var3, String var4, String var5, boolean var6) {
      Intrinsics.checkNotNullParameter(var1, "clientId");
      Intrinsics.checkNotNullParameter(var2, "responseType");
      Intrinsics.checkNotNullParameter(var3, "state");
      Intrinsics.checkNotNullParameter(var4, "scope");
      Intrinsics.checkNotNullParameter(var5, "redirectUri");
      super();
      this.clientId = var1;
      this.responseType = var2;
      this.state = var3;
      this.scope = var4;
      this.redirectUri = var5;
      this.userAccepted = var6;
   }

   // $FF: synthetic method
   public static AlexaLinkAppReq copy$default(AlexaLinkAppReq var0, String var1, String var2, String var3, String var4, String var5, boolean var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.clientId;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.responseType;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.state;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.scope;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.redirectUri;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.userAccepted;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   public final String component1() {
      return this.clientId;
   }

   public final String component2() {
      return this.responseType;
   }

   public final String component3() {
      return this.state;
   }

   public final String component4() {
      return this.scope;
   }

   public final String component5() {
      return this.redirectUri;
   }

   public final boolean component6() {
      return this.userAccepted;
   }

   public final AlexaLinkAppReq copy(String var1, String var2, String var3, String var4, String var5, boolean var6) {
      Intrinsics.checkNotNullParameter(var1, "clientId");
      Intrinsics.checkNotNullParameter(var2, "responseType");
      Intrinsics.checkNotNullParameter(var3, "state");
      Intrinsics.checkNotNullParameter(var4, "scope");
      Intrinsics.checkNotNullParameter(var5, "redirectUri");
      return new AlexaLinkAppReq(var1, var2, var3, var4, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AlexaLinkAppReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.clientId, var1.clientId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.responseType, var1.responseType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.state, var1.state)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scope, var1.scope)) {
            return false;
         } else if (!Intrinsics.areEqual(this.redirectUri, var1.redirectUri)) {
            return false;
         } else {
            return this.userAccepted == var1.userAccepted;
         }
      }
   }

   public final String getClientId() {
      return this.clientId;
   }

   public final String getRedirectUri() {
      return this.redirectUri;
   }

   public final String getResponseType() {
      return this.responseType;
   }

   public final String getScope() {
      return this.scope;
   }

   public final String getState() {
      return this.state;
   }

   public final boolean getUserAccepted() {
      return this.userAccepted;
   }

   public int hashCode() {
      return ((((this.clientId.hashCode() * 31 + this.responseType.hashCode()) * 31 + this.state.hashCode()) * 31 + this.scope.hashCode()) * 31 + this.redirectUri.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.userAccepted);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AlexaLinkAppReq(clientId=");
      var1.append(this.clientId);
      var1.append(", responseType=");
      var1.append(this.responseType);
      var1.append(", state=");
      var1.append(this.state);
      var1.append(", scope=");
      var1.append(this.scope);
      var1.append(", redirectUri=");
      var1.append(this.redirectUri);
      var1.append(", userAccepted=");
      var1.append(this.userAccepted);
      var1.append(')');
      return var1.toString();
   }
}
