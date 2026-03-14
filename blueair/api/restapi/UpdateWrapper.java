package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"},
   d2 = {"Lcom/blueair/api/restapi/UpdateWrapper;", "", "uuid", "", "da", "di", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getUuid", "()Ljava/lang/String;", "getDa", "()Ljava/lang/Object;", "getDi", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UpdateWrapper {
   private final Object da;
   private final Object di;
   private final String uuid;

   public UpdateWrapper(String var1, Object var2, Object var3) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      super();
      this.uuid = var1;
      this.da = var2;
      this.di = var3;
   }

   // $FF: synthetic method
   public UpdateWrapper(String var1, Object var2, Object var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static UpdateWrapper copy$default(UpdateWrapper var0, String var1, Object var2, Object var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.uuid;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.da;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.di;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.uuid;
   }

   public final Object component2() {
      return this.da;
   }

   public final Object component3() {
      return this.di;
   }

   public final UpdateWrapper copy(String var1, Object var2, Object var3) {
      Intrinsics.checkNotNullParameter(var1, "uuid");
      return new UpdateWrapper(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UpdateWrapper)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.da, var1.da)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.di, var1.di);
         }
      }
   }

   public final Object getDa() {
      return this.da;
   }

   public final Object getDi() {
      return this.di;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      int var3 = this.uuid.hashCode();
      Object var4 = this.da;
      int var2 = 0;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      var4 = this.di;
      if (var4 != null) {
         var2 = var4.hashCode();
      }

      return (var3 * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UpdateWrapper(uuid=");
      var1.append(this.uuid);
      var1.append(", da=");
      var1.append(this.da);
      var1.append(", di=");
      var1.append(this.di);
      var1.append(')');
      return var1.toString();
   }
}
