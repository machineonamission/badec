package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b#\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006."},
   d2 = {"Lcom/blueair/database/entity/NotificationEntity;", "", "deviceId", "", "type", "subType", "subLevel", "", "dismissed", "", "dismissTime", "", "datetime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJJ)V", "getDeviceId", "()Ljava/lang/String;", "getType", "getSubType", "getSubLevel", "()I", "setSubLevel", "(I)V", "getDismissed", "()Z", "setDismissed", "(Z)V", "getDismissTime", "()J", "setDismissTime", "(J)V", "getDatetime", "setDatetime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String NOTIFICATION_TABLE = "notification_table";
   private long datetime;
   private final String deviceId;
   private long dismissTime;
   private boolean dismissed;
   private int subLevel;
   private final String subType;
   private final String type;

   public NotificationEntity(String var1, String var2, String var3, int var4, boolean var5, long var6, long var8) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "type");
      Intrinsics.checkNotNullParameter(var3, "subType");
      super();
      this.deviceId = var1;
      this.type = var2;
      this.subType = var3;
      this.subLevel = var4;
      this.dismissed = var5;
      this.dismissTime = var6;
      this.datetime = var8;
   }

   // $FF: synthetic method
   public NotificationEntity(String var1, String var2, String var3, int var4, boolean var5, long var6, long var8, int var10, DefaultConstructorMarker var11) {
      if ((var10 & 16) != 0) {
         var5 = false;
      }

      if ((var10 & 32) != 0) {
         var6 = 0L;
      }

      if ((var10 & 64) != 0) {
         var8 = System.currentTimeMillis();
      }

      this(var1, var2, var3, var4, var5, var6, var8);
   }

   // $FF: synthetic method
   public static NotificationEntity copy$default(NotificationEntity var0, String var1, String var2, String var3, int var4, boolean var5, long var6, long var8, int var10, Object var11) {
      if ((var10 & 1) != 0) {
         var1 = var0.deviceId;
      }

      if ((var10 & 2) != 0) {
         var2 = var0.type;
      }

      if ((var10 & 4) != 0) {
         var3 = var0.subType;
      }

      if ((var10 & 8) != 0) {
         var4 = var0.subLevel;
      }

      if ((var10 & 16) != 0) {
         var5 = var0.dismissed;
      }

      if ((var10 & 32) != 0) {
         var6 = var0.dismissTime;
      }

      if ((var10 & 64) != 0) {
         var8 = var0.datetime;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var8);
   }

   public final String component1() {
      return this.deviceId;
   }

   public final String component2() {
      return this.type;
   }

   public final String component3() {
      return this.subType;
   }

   public final int component4() {
      return this.subLevel;
   }

   public final boolean component5() {
      return this.dismissed;
   }

   public final long component6() {
      return this.dismissTime;
   }

   public final long component7() {
      return this.datetime;
   }

   public final NotificationEntity copy(String var1, String var2, String var3, int var4, boolean var5, long var6, long var8) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "type");
      Intrinsics.checkNotNullParameter(var3, "subType");
      return new NotificationEntity(var1, var2, var3, var4, var5, var6, var8);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof NotificationEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceId, var1.deviceId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.subType, var1.subType)) {
            return false;
         } else if (this.subLevel != var1.subLevel) {
            return false;
         } else if (this.dismissed != var1.dismissed) {
            return false;
         } else if (this.dismissTime != var1.dismissTime) {
            return false;
         } else {
            return this.datetime == var1.datetime;
         }
      }
   }

   public final long getDatetime() {
      return this.datetime;
   }

   public final String getDeviceId() {
      return this.deviceId;
   }

   public final long getDismissTime() {
      return this.dismissTime;
   }

   public final boolean getDismissed() {
      return this.dismissed;
   }

   public final int getSubLevel() {
      return this.subLevel;
   }

   public final String getSubType() {
      return this.subType;
   }

   public final String getType() {
      return this.type;
   }

   public int hashCode() {
      return (((((this.deviceId.hashCode() * 31 + this.type.hashCode()) * 31 + this.subType.hashCode()) * 31 + this.subLevel) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.dismissed)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.dismissTime)) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.datetime);
   }

   public final void setDatetime(long var1) {
      this.datetime = var1;
   }

   public final void setDismissTime(long var1) {
      this.dismissTime = var1;
   }

   public final void setDismissed(boolean var1) {
      this.dismissed = var1;
   }

   public final void setSubLevel(int var1) {
      this.subLevel = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("NotificationEntity(deviceId=");
      var1.append(this.deviceId);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(", subType=");
      var1.append(this.subType);
      var1.append(", subLevel=");
      var1.append(this.subLevel);
      var1.append(", dismissed=");
      var1.append(this.dismissed);
      var1.append(", dismissTime=");
      var1.append(this.dismissTime);
      var1.append(", datetime=");
      var1.append(this.datetime);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/database/entity/NotificationEntity$Companion;", "", "<init>", "()V", "NOTIFICATION_TABLE", "", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }
}
