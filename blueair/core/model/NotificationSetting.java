package com.blueair.core.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/model/NotificationSetting;", "", "type", "", "enabled", "", "limit", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getType", "()Ljava/lang/String;", "getEnabled", "()I", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isEnabled", "", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/lang/Integer;)Lcom/blueair/core/model/NotificationSetting;", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationSetting {
   private final int enabled;
   private final Integer limit;
   private final String type;

   public NotificationSetting(@Json(name = "message_type") String var1, @Json(name = "to_receive_notifications") int var2, @Json(name = "message_limit_count") Integer var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      super();
      this.type = var1;
      this.enabled = var2;
      this.limit = var3;
   }

   // $FF: synthetic method
   public NotificationSetting(String var1, int var2, Integer var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = 0;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3);
   }

   // $FF: synthetic method
   public static NotificationSetting copy$default(NotificationSetting var0, String var1, int var2, Integer var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.enabled;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.limit;
      }

      return var0.copy(var1, var2, var3);
   }

   public final String component1() {
      return this.type;
   }

   public final int component2() {
      return this.enabled;
   }

   public final Integer component3() {
      return this.limit;
   }

   public final NotificationSetting copy(@Json(name = "message_type") String var1, @Json(name = "to_receive_notifications") int var2, @Json(name = "message_limit_count") Integer var3) {
      Intrinsics.checkNotNullParameter(var1, "type");
      return new NotificationSetting(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof NotificationSetting)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (this.enabled != var1.enabled) {
            return false;
         } else {
            return Intrinsics.areEqual(this.limit, var1.limit);
         }
      }
   }

   public final int getEnabled() {
      return this.enabled;
   }

   public final Integer getLimit() {
      return this.limit;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      int var2 = this.type.hashCode();
      int var3 = this.enabled;
      Integer var4 = this.limit;
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         var1 = var4.hashCode();
      }

      return (var2 * 31 + var3) * 31 + var1;
   }

   public final boolean isEnabled() {
      return this.enabled != 0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("NotificationSetting(type=");
      var1.append(this.type);
      var1.append(", enabled=");
      var1.append(this.enabled);
      var1.append(", limit=");
      var1.append(this.limit);
      var1.append(')');
      return var1.toString();
   }
}
