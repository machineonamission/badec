package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"},
   d2 = {"Lcom/blueair/api/restapi/SimpleResponse;", "", "state", "", "message", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getState", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/blueair/api/restapi/SimpleResponse;", "equals", "", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleResponse {
   private final String message;
   private final Integer state;

   public SimpleResponse(Integer var1, String var2) {
      this.state = var1;
      this.message = var2;
   }

   // $FF: synthetic method
   public static SimpleResponse copy$default(SimpleResponse var0, Integer var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.state;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.message;
      }

      return var0.copy(var1, var2);
   }

   public final Integer component1() {
      return this.state;
   }

   public final String component2() {
      return this.message;
   }

   public final SimpleResponse copy(Integer var1, String var2) {
      return new SimpleResponse(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SimpleResponse)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.state, var1.state)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.message, var1.message);
         }
      }
   }

   public final String getMessage() {
      return this.message;
   }

   public final Integer getState() {
      return this.state;
   }

   public int hashCode() {
      Integer var3 = this.state;
      int var2 = 0;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      String var4 = this.message;
      if (var4 != null) {
         var2 = var4.hashCode();
      }

      return var1 * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SimpleResponse(state=");
      var1.append(this.state);
      var1.append(", message=");
      var1.append(this.message);
      var1.append(')');
      return var1.toString();
   }
}
