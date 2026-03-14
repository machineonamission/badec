package com.blueair.core.util;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/util/TimezoneList;", "", "version", "", "time", "", "timezones", "", "Ljava/util/TimeZone;", "<init>", "(Ljava/lang/String;JLjava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getTime", "()J", "getTimezones", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TimezoneList {
   private final long time;
   private final List timezones;
   private final String version;

   public TimezoneList(String var1, long var2, List var4) {
      Intrinsics.checkNotNullParameter(var1, "version");
      Intrinsics.checkNotNullParameter(var4, "timezones");
      super();
      this.version = var1;
      this.time = var2;
      this.timezones = var4;
   }

   // $FF: synthetic method
   public static TimezoneList copy$default(TimezoneList var0, String var1, long var2, List var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.version;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.time;
      }

      if ((var5 & 4) != 0) {
         var4 = var0.timezones;
      }

      return var0.copy(var1, var2, var4);
   }

   public final String component1() {
      return this.version;
   }

   public final long component2() {
      return this.time;
   }

   public final List component3() {
      return this.timezones;
   }

   public final TimezoneList copy(String var1, long var2, List var4) {
      Intrinsics.checkNotNullParameter(var1, "version");
      Intrinsics.checkNotNullParameter(var4, "timezones");
      return new TimezoneList(var1, var2, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof TimezoneList)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.version, var1.version)) {
            return false;
         } else if (this.time != var1.time) {
            return false;
         } else {
            return Intrinsics.areEqual(this.timezones, var1.timezones);
         }
      }
   }

   public final long getTime() {
      return this.time;
   }

   public final List getTimezones() {
      return this.timezones;
   }

   public final String getVersion() {
      return this.version;
   }

   public int hashCode() {
      return (this.version.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.time)) * 31 + this.timezones.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("TimezoneList(version=");
      var1.append(this.version);
      var1.append(", time=");
      var1.append(this.time);
      var1.append(", timezones=");
      var1.append(this.timezones);
      var1.append(')');
      return var1.toString();
   }
}
