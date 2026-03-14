package com.blueair.core.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jm\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"},
   d2 = {"Lcom/blueair/core/model/LegacyDeviceSchedule;", "", "id", "", "userId", "", "uuid", "startTime", "endTime", "instructions", "Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "daysOfWeek", "", "timeZone", "doOnEndInstructions", "Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;Ljava/util/List;Ljava/lang/String;Lcom/blueair/core/model/LegacyDeviceEndInstruction;)V", "getId", "()Ljava/lang/String;", "getUserId", "()I", "getUuid", "getStartTime", "getEndTime", "getInstructions", "()Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "getDaysOfWeek", "()Ljava/util/List;", "getTimeZone", "getDoOnEndInstructions", "()Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LegacyDeviceSchedule {
   private final List daysOfWeek;
   private final LegacyDeviceEndInstruction doOnEndInstructions;
   private final String endTime;
   private final String id;
   private final LegacyDeviceScheduleInstruction instructions;
   private final String startTime;
   private final String timeZone;
   private final int userId;
   private final String uuid;

   public LegacyDeviceSchedule(String var1, int var2, String var3, String var4, String var5, LegacyDeviceScheduleInstruction var6, List var7, String var8, LegacyDeviceEndInstruction var9) {
      Intrinsics.checkNotNullParameter(var3, "uuid");
      Intrinsics.checkNotNullParameter(var4, "startTime");
      Intrinsics.checkNotNullParameter(var5, "endTime");
      Intrinsics.checkNotNullParameter(var6, "instructions");
      Intrinsics.checkNotNullParameter(var7, "daysOfWeek");
      Intrinsics.checkNotNullParameter(var8, "timeZone");
      super();
      this.id = var1;
      this.userId = var2;
      this.uuid = var3;
      this.startTime = var4;
      this.endTime = var5;
      this.instructions = var6;
      this.daysOfWeek = var7;
      this.timeZone = var8;
      this.doOnEndInstructions = var9;
   }

   // $FF: synthetic method
   public LegacyDeviceSchedule(String var1, int var2, String var3, String var4, String var5, LegacyDeviceScheduleInstruction var6, List var7, String var8, LegacyDeviceEndInstruction var9, int var10, DefaultConstructorMarker var11) {
      if ((var10 & 256) != 0) {
         var9 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   // $FF: synthetic method
   public static LegacyDeviceSchedule copy$default(LegacyDeviceSchedule var0, String var1, int var2, String var3, String var4, String var5, LegacyDeviceScheduleInstruction var6, List var7, String var8, LegacyDeviceEndInstruction var9, int var10, Object var11) {
      if ((var10 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var10 & 2) != 0) {
         var2 = var0.userId;
      }

      if ((var10 & 4) != 0) {
         var3 = var0.uuid;
      }

      if ((var10 & 8) != 0) {
         var4 = var0.startTime;
      }

      if ((var10 & 16) != 0) {
         var5 = var0.endTime;
      }

      if ((var10 & 32) != 0) {
         var6 = var0.instructions;
      }

      if ((var10 & 64) != 0) {
         var7 = var0.daysOfWeek;
      }

      if ((var10 & 128) != 0) {
         var8 = var0.timeZone;
      }

      if ((var10 & 256) != 0) {
         var9 = var0.doOnEndInstructions;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public final String component1() {
      return this.id;
   }

   public final int component2() {
      return this.userId;
   }

   public final String component3() {
      return this.uuid;
   }

   public final String component4() {
      return this.startTime;
   }

   public final String component5() {
      return this.endTime;
   }

   public final LegacyDeviceScheduleInstruction component6() {
      return this.instructions;
   }

   public final List component7() {
      return this.daysOfWeek;
   }

   public final String component8() {
      return this.timeZone;
   }

   public final LegacyDeviceEndInstruction component9() {
      return this.doOnEndInstructions;
   }

   public final LegacyDeviceSchedule copy(String var1, int var2, String var3, String var4, String var5, LegacyDeviceScheduleInstruction var6, List var7, String var8, LegacyDeviceEndInstruction var9) {
      Intrinsics.checkNotNullParameter(var3, "uuid");
      Intrinsics.checkNotNullParameter(var4, "startTime");
      Intrinsics.checkNotNullParameter(var5, "endTime");
      Intrinsics.checkNotNullParameter(var6, "instructions");
      Intrinsics.checkNotNullParameter(var7, "daysOfWeek");
      Intrinsics.checkNotNullParameter(var8, "timeZone");
      return new LegacyDeviceSchedule(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof LegacyDeviceSchedule)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (this.userId != var1.userId) {
            return false;
         } else if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.startTime, var1.startTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.endTime, var1.endTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.instructions, var1.instructions)) {
            return false;
         } else if (!Intrinsics.areEqual(this.daysOfWeek, var1.daysOfWeek)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeZone, var1.timeZone)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.doOnEndInstructions, var1.doOnEndInstructions);
         }
      }
   }

   public final List getDaysOfWeek() {
      return this.daysOfWeek;
   }

   public final LegacyDeviceEndInstruction getDoOnEndInstructions() {
      return this.doOnEndInstructions;
   }

   public final String getEndTime() {
      return this.endTime;
   }

   public final String getId() {
      return this.id;
   }

   public final LegacyDeviceScheduleInstruction getInstructions() {
      return this.instructions;
   }

   public final String getStartTime() {
      return this.startTime;
   }

   public final String getTimeZone() {
      return this.timeZone;
   }

   public final int getUserId() {
      return this.userId;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      String var10 = this.id;
      int var2 = 0;
      int var1;
      if (var10 == null) {
         var1 = 0;
      } else {
         var1 = var10.hashCode();
      }

      int var9 = this.userId;
      int var8 = this.uuid.hashCode();
      int var4 = this.startTime.hashCode();
      int var7 = this.endTime.hashCode();
      int var5 = this.instructions.hashCode();
      int var3 = this.daysOfWeek.hashCode();
      int var6 = this.timeZone.hashCode();
      LegacyDeviceEndInstruction var11 = this.doOnEndInstructions;
      if (var11 != null) {
         var2 = var11.hashCode();
      }

      return (((((((var1 * 31 + var9) * 31 + var8) * 31 + var4) * 31 + var7) * 31 + var5) * 31 + var3) * 31 + var6) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LegacyDeviceSchedule(id=");
      var1.append(this.id);
      var1.append(", userId=");
      var1.append(this.userId);
      var1.append(", uuid=");
      var1.append(this.uuid);
      var1.append(", startTime=");
      var1.append(this.startTime);
      var1.append(", endTime=");
      var1.append(this.endTime);
      var1.append(", instructions=");
      var1.append(this.instructions);
      var1.append(", daysOfWeek=");
      var1.append(this.daysOfWeek);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(", doOnEndInstructions=");
      var1.append(this.doOnEndInstructions);
      var1.append(')');
      return var1.toString();
   }
}
