package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/core/model/UserInfoCollectionRecord;", "", "value", "", "time", "", "<init>", "(Ljava/lang/String;J)V", "getValue", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserInfoCollectionRecord {
   private final long time;
   private final String value;

   public UserInfoCollectionRecord(String var1, long var2) {
      Intrinsics.checkNotNullParameter(var1, "value");
      super();
      this.value = var1;
      this.time = var2;
   }

   // $FF: synthetic method
   public UserInfoCollectionRecord(String var1, long var2, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = System.currentTimeMillis();
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static UserInfoCollectionRecord copy$default(UserInfoCollectionRecord var0, String var1, long var2, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.value;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.time;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.value;
   }

   public final long component2() {
      return this.time;
   }

   public final UserInfoCollectionRecord copy(String var1, long var2) {
      Intrinsics.checkNotNullParameter(var1, "value");
      return new UserInfoCollectionRecord(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof UserInfoCollectionRecord)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.value, var1.value)) {
            return false;
         } else {
            return this.time == var1.time;
         }
      }
   }

   public final long getTime() {
      return this.time;
   }

   public final String getValue() {
      return this.value;
   }

   public int hashCode() {
      return this.value.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.time);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("UserInfoCollectionRecord(value=");
      var1.append(this.value);
      var1.append(", time=");
      var1.append(this.time);
      var1.append(')');
      return var1.toString();
   }
}
