package com.blueair.core.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/core/util/TimezoneNames;", "", "version", "", "timezoneNames", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getTimezoneNames", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TimezoneNames {
   private final List timezoneNames;
   private final String version;

   public TimezoneNames(String var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "version");
      Intrinsics.checkNotNullParameter(var2, "timezoneNames");
      super();
      this.version = var1;
      this.timezoneNames = var2;
   }

   // $FF: synthetic method
   public static TimezoneNames copy$default(TimezoneNames var0, String var1, List var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.version;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.timezoneNames;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.version;
   }

   public final List component2() {
      return this.timezoneNames;
   }

   public final TimezoneNames copy(String var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "version");
      Intrinsics.checkNotNullParameter(var2, "timezoneNames");
      return new TimezoneNames(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof TimezoneNames)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.version, var1.version)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.timezoneNames, var1.timezoneNames);
         }
      }
   }

   public final List getTimezoneNames() {
      return this.timezoneNames;
   }

   public final String getVersion() {
      return this.version;
   }

   public int hashCode() {
      return this.version.hashCode() * 31 + this.timezoneNames.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("TimezoneNames(version=");
      var1.append(this.version);
      var1.append(", timezoneNames=");
      var1.append(this.timezoneNames);
      var1.append(')');
      return var1.toString();
   }
}
