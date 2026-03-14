package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
   d2 = {"Lcom/blueair/api/restapi/ShopifyMultiPassReq;", "", "email", "", "return_to", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getReturn_to", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ShopifyMultiPassReq {
   private final String email;
   private final String return_to;

   public ShopifyMultiPassReq(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "email");
      Intrinsics.checkNotNullParameter(var2, "return_to");
      super();
      this.email = var1;
      this.return_to = var2;
   }

   // $FF: synthetic method
   public static ShopifyMultiPassReq copy$default(ShopifyMultiPassReq var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.email;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.return_to;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.email;
   }

   public final String component2() {
      return this.return_to;
   }

   public final ShopifyMultiPassReq copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "email");
      Intrinsics.checkNotNullParameter(var2, "return_to");
      return new ShopifyMultiPassReq(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ShopifyMultiPassReq)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.email, var1.email)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.return_to, var1.return_to);
         }
      }
   }

   public final String getEmail() {
      return this.email;
   }

   public final String getReturn_to() {
      return this.return_to;
   }

   public int hashCode() {
      return this.email.hashCode() * 31 + this.return_to.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ShopifyMultiPassReq(email=");
      var1.append(this.email);
      var1.append(", return_to=");
      var1.append(this.return_to);
      var1.append(')');
      return var1.toString();
   }
}
