package com.blueair.api.restapi;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"},
   d2 = {"Lcom/blueair/api/restapi/Da;", "", "nightMode", "Lcom/blueair/api/restapi/ConfigurationAutoMode;", "autoMode", "<init>", "(Lcom/blueair/api/restapi/ConfigurationAutoMode;Lcom/blueair/api/restapi/ConfigurationAutoMode;)V", "getNightMode", "()Lcom/blueair/api/restapi/ConfigurationAutoMode;", "getAutoMode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Da {
   private final ConfigurationAutoMode autoMode;
   private final ConfigurationAutoMode nightMode;

   public Da(@Json(name = "nm") ConfigurationAutoMode var1, @Json(name = "am") ConfigurationAutoMode var2) {
      this.nightMode = var1;
      this.autoMode = var2;
   }

   // $FF: synthetic method
   public static Da copy$default(Da var0, ConfigurationAutoMode var1, ConfigurationAutoMode var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.nightMode;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.autoMode;
      }

      return var0.copy(var1, var2);
   }

   public final ConfigurationAutoMode component1() {
      return this.nightMode;
   }

   public final ConfigurationAutoMode component2() {
      return this.autoMode;
   }

   public final Da copy(@Json(name = "nm") ConfigurationAutoMode var1, @Json(name = "am") ConfigurationAutoMode var2) {
      return new Da(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof Da)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.nightMode, var1.nightMode)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.autoMode, var1.autoMode);
         }
      }
   }

   public final ConfigurationAutoMode getAutoMode() {
      return this.autoMode;
   }

   public final ConfigurationAutoMode getNightMode() {
      return this.nightMode;
   }

   public int hashCode() {
      ConfigurationAutoMode var3 = this.nightMode;
      int var2 = 0;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      var3 = this.autoMode;
      if (var3 != null) {
         var2 = var3.hashCode();
      }

      return var1 * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("Da(nightMode=");
      var1.append(this.nightMode);
      var1.append(", autoMode=");
      var1.append(this.autoMode);
      var1.append(')');
      return var1.toString();
   }
}
