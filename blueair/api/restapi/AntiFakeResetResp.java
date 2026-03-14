package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"},
   d2 = {"Lcom/blueair/api/restapi/AntiFakeResetResp;", "", "status", "", "message", "", "ciphertext", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getStatus", "()I", "getMessage", "()Ljava/lang/String;", "getCiphertext", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AntiFakeResetResp {
   private final String ciphertext;
   private final String message;
   private final int status;

   public AntiFakeResetResp(int var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var2, "message");
      super();
      this.status = var1;
      this.message = var2;
      this.ciphertext = var3;
   }

   // $FF: synthetic method
   public static AntiFakeResetResp copy$default(AntiFakeResetResp var0, int var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.status;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.message;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.ciphertext;
      }

      return var0.copy(var1, var2, var3);
   }

   public final int component1() {
      return this.status;
   }

   public final String component2() {
      return this.message;
   }

   public final String component3() {
      return this.ciphertext;
   }

   public final AntiFakeResetResp copy(int var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var2, "message");
      return new AntiFakeResetResp(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AntiFakeResetResp)) {
         return false;
      } else {
         var1 = var1;
         if (this.status != var1.status) {
            return false;
         } else if (!Intrinsics.areEqual(this.message, var1.message)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.ciphertext, var1.ciphertext);
         }
      }
   }

   public final String getCiphertext() {
      return this.ciphertext;
   }

   public final String getMessage() {
      return this.message;
   }

   public final int getStatus() {
      return this.status;
   }

   public int hashCode() {
      int var2 = this.status;
      int var3 = this.message.hashCode();
      String var4 = this.ciphertext;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      return (var2 * 31 + var3) * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AntiFakeResetResp(status=");
      var1.append(this.status);
      var1.append(", message=");
      var1.append(this.message);
      var1.append(", ciphertext=");
      var1.append(this.ciphertext);
      var1.append(')');
      return var1.toString();
   }
}
