package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"},
   d2 = {"Lcom/blueair/api/restapi/AntiFakeVerifyResult;", "", "status", "", "message", "", "type", "supportedDeviceSku", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStatus", "()I", "getMessage", "()Ljava/lang/String;", "getType", "getSupportedDeviceSku", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AntiFakeVerifyResult {
   private final String message;
   private final int status;
   private final List supportedDeviceSku;
   private final String type;

   public AntiFakeVerifyResult(int var1, String var2, @Json(name = "ctype") String var3, @Json(name = "deviceskus") List var4) {
      Intrinsics.checkNotNullParameter(var2, "message");
      super();
      this.status = var1;
      this.message = var2;
      this.type = var3;
      this.supportedDeviceSku = var4;
   }

   // $FF: synthetic method
   public static AntiFakeVerifyResult copy$default(AntiFakeVerifyResult var0, int var1, String var2, String var3, List var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.status;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.message;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.type;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.supportedDeviceSku;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final int component1() {
      return this.status;
   }

   public final String component2() {
      return this.message;
   }

   public final String component3() {
      return this.type;
   }

   public final List component4() {
      return this.supportedDeviceSku;
   }

   public final AntiFakeVerifyResult copy(int var1, String var2, @Json(name = "ctype") String var3, @Json(name = "deviceskus") List var4) {
      Intrinsics.checkNotNullParameter(var2, "message");
      return new AntiFakeVerifyResult(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof AntiFakeVerifyResult)) {
         return false;
      } else {
         var1 = var1;
         if (this.status != var1.status) {
            return false;
         } else if (!Intrinsics.areEqual(this.message, var1.message)) {
            return false;
         } else if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.supportedDeviceSku, var1.supportedDeviceSku);
         }
      }
   }

   public final String getMessage() {
      return this.message;
   }

   public final int getStatus() {
      return this.status;
   }

   public final List getSupportedDeviceSku() {
      return this.supportedDeviceSku;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      int var4 = this.status;
      int var3 = this.message.hashCode();
      String var5 = this.type;
      int var2 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      List var6 = this.supportedDeviceSku;
      if (var6 != null) {
         var2 = var6.hashCode();
      }

      return ((var4 * 31 + var3) * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AntiFakeVerifyResult(status=");
      var1.append(this.status);
      var1.append(", message=");
      var1.append(this.message);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(", supportedDeviceSku=");
      var1.append(this.supportedDeviceSku);
      var1.append(')');
      return var1.toString();
   }
}
