package com.blueair.api.restapi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/api/restapi/DeviceConfigQuery;", "", "id", "", "r", "Lcom/blueair/api/restapi/Ree;", "<init>", "(Ljava/lang/String;Lcom/blueair/api/restapi/Ree;)V", "getId", "()Ljava/lang/String;", "getR", "()Lcom/blueair/api/restapi/Ree;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceConfigQuery {
   private final String id;
   private final Ree r;

   public DeviceConfigQuery(String var1, Ree var2) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "r");
      super();
      this.id = var1;
      this.r = var2;
   }

   // $FF: synthetic method
   public DeviceConfigQuery(String var1, Ree var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = new Ree((List)null, 1, (DefaultConstructorMarker)null);
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static DeviceConfigQuery copy$default(DeviceConfigQuery var0, String var1, Ree var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.r;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.id;
   }

   public final Ree component2() {
      return this.r;
   }

   public final DeviceConfigQuery copy(String var1, Ree var2) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "r");
      return new DeviceConfigQuery(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceConfigQuery)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.r, var1.r);
         }
      }
   }

   public final String getId() {
      return this.id;
   }

   public final Ree getR() {
      return this.r;
   }

   public int hashCode() {
      return this.id.hashCode() * 31 + this.r.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceConfigQuery(id=");
      var1.append(this.id);
      var1.append(", r=");
      var1.append(this.r);
      var1.append(')');
      return var1.toString();
   }
}
