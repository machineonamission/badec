package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleInstruction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010$\u001a\u00020%J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008d\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u000fHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u00069"},
   d2 = {"Lcom/blueair/database/entity/DeviceScheduleEntity;", "", "deviceId", "", "scheduleId", "scheduleName", "startTime", "endTime", "instructions", "", "Lcom/blueair/database/entity/DeviceScheduleInstructionEntity;", "paused", "", "daysOfWeek", "", "", "timeZone", "endInstructions", "scheduleEndType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/Set;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getScheduleId", "getScheduleName", "getStartTime", "getEndTime", "getInstructions", "()Ljava/util/List;", "getPaused", "()Z", "getDaysOfWeek", "()Ljava/util/Set;", "getTimeZone", "getEndInstructions", "getScheduleEndType", "toDeviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "toDaysOfWeek", "Lcom/blueair/core/model/DayOfWeek;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DEVICE_SCHEDULE_TABLE = "device_schedule_table";
   private final Set daysOfWeek;
   private final String deviceId;
   private final List endInstructions;
   private final String endTime;
   private final List instructions;
   private final boolean paused;
   private final String scheduleEndType;
   private final String scheduleId;
   private final String scheduleName;
   private final String startTime;
   private final String timeZone;

   public DeviceScheduleEntity(String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "scheduleId");
      Intrinsics.checkNotNullParameter(var3, "scheduleName");
      Intrinsics.checkNotNullParameter(var4, "startTime");
      Intrinsics.checkNotNullParameter(var5, "endTime");
      Intrinsics.checkNotNullParameter(var6, "instructions");
      Intrinsics.checkNotNullParameter(var8, "daysOfWeek");
      Intrinsics.checkNotNullParameter(var9, "timeZone");
      super();
      this.deviceId = var1;
      this.scheduleId = var2;
      this.scheduleName = var3;
      this.startTime = var4;
      this.endTime = var5;
      this.instructions = var6;
      this.paused = var7;
      this.daysOfWeek = var8;
      this.timeZone = var9;
      this.endInstructions = var10;
      this.scheduleEndType = var11;
   }

   // $FF: synthetic method
   public static DeviceScheduleEntity copy$default(DeviceScheduleEntity var0, String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.deviceId;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.scheduleId;
      }

      if ((var12 & 4) != 0) {
         var3 = var0.scheduleName;
      }

      if ((var12 & 8) != 0) {
         var4 = var0.startTime;
      }

      if ((var12 & 16) != 0) {
         var5 = var0.endTime;
      }

      if ((var12 & 32) != 0) {
         var6 = var0.instructions;
      }

      if ((var12 & 64) != 0) {
         var7 = var0.paused;
      }

      if ((var12 & 128) != 0) {
         var8 = var0.daysOfWeek;
      }

      if ((var12 & 256) != 0) {
         var9 = var0.timeZone;
      }

      if ((var12 & 512) != 0) {
         var10 = var0.endInstructions;
      }

      if ((var12 & 1024) != 0) {
         var11 = var0.scheduleEndType;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final String component1() {
      return this.deviceId;
   }

   public final List component10() {
      return this.endInstructions;
   }

   public final String component11() {
      return this.scheduleEndType;
   }

   public final String component2() {
      return this.scheduleId;
   }

   public final String component3() {
      return this.scheduleName;
   }

   public final String component4() {
      return this.startTime;
   }

   public final String component5() {
      return this.endTime;
   }

   public final List component6() {
      return this.instructions;
   }

   public final boolean component7() {
      return this.paused;
   }

   public final Set component8() {
      return this.daysOfWeek;
   }

   public final String component9() {
      return this.timeZone;
   }

   public final DeviceScheduleEntity copy(String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "scheduleId");
      Intrinsics.checkNotNullParameter(var3, "scheduleName");
      Intrinsics.checkNotNullParameter(var4, "startTime");
      Intrinsics.checkNotNullParameter(var5, "endTime");
      Intrinsics.checkNotNullParameter(var6, "instructions");
      Intrinsics.checkNotNullParameter(var8, "daysOfWeek");
      Intrinsics.checkNotNullParameter(var9, "timeZone");
      return new DeviceScheduleEntity(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceScheduleEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceId, var1.deviceId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleId, var1.scheduleId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleName, var1.scheduleName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.startTime, var1.startTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.endTime, var1.endTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.instructions, var1.instructions)) {
            return false;
         } else if (this.paused != var1.paused) {
            return false;
         } else if (!Intrinsics.areEqual(this.daysOfWeek, var1.daysOfWeek)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeZone, var1.timeZone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.endInstructions, var1.endInstructions)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.scheduleEndType, var1.scheduleEndType);
         }
      }
   }

   public final Set getDaysOfWeek() {
      return this.daysOfWeek;
   }

   public final String getDeviceId() {
      return this.deviceId;
   }

   public final List getEndInstructions() {
      return this.endInstructions;
   }

   public final String getEndTime() {
      return this.endTime;
   }

   public final List getInstructions() {
      return this.instructions;
   }

   public final boolean getPaused() {
      return this.paused;
   }

   public final String getScheduleEndType() {
      return this.scheduleEndType;
   }

   public final String getScheduleId() {
      return this.scheduleId;
   }

   public final String getScheduleName() {
      return this.scheduleName;
   }

   public final String getStartTime() {
      return this.startTime;
   }

   public final String getTimeZone() {
      return this.timeZone;
   }

   public int hashCode() {
      int var4 = this.deviceId.hashCode();
      int var7 = this.scheduleId.hashCode();
      int var10 = this.scheduleName.hashCode();
      int var3 = this.startTime.hashCode();
      int var6 = this.endTime.hashCode();
      int var11 = this.instructions.hashCode();
      int var5 = AddDeviceState$$ExternalSyntheticBackport0.m(this.paused);
      int var8 = this.daysOfWeek.hashCode();
      int var9 = this.timeZone.hashCode();
      List var12 = this.endInstructions;
      int var2 = 0;
      int var1;
      if (var12 == null) {
         var1 = 0;
      } else {
         var1 = var12.hashCode();
      }

      String var13 = this.scheduleEndType;
      if (var13 != null) {
         var2 = var13.hashCode();
      }

      return (((((((((var4 * 31 + var7) * 31 + var10) * 31 + var3) * 31 + var6) * 31 + var11) * 31 + var5) * 31 + var8) * 31 + var9) * 31 + var1) * 31 + var2;
   }

   public final Set toDaysOfWeek() {
      Set var3 = (Set)(new LinkedHashSet());
      Iterator var2 = this.daysOfWeek.iterator();

      while(var2.hasNext()) {
         int var1 = ((Number)var2.next()).intValue();
         var3.add(DayOfWeek.Companion.getByDBValue(var1));
      }

      return CollectionsKt.toSet((Iterable)CollectionsKt.filterNotNull((Iterable)var3));
   }

   public final DeviceSchedule toDeviceSchedule() {
      String var6 = this.scheduleId;
      String var4 = this.deviceId;
      String var3 = this.scheduleName;
      String var7 = this.startTime;
      String var5 = this.endTime;
      Iterable var8 = (Iterable)this.instructions;
      Collection var2 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
      Iterator var15 = var8.iterator();

      while(var15.hasNext()) {
         var2.add(((DeviceScheduleInstructionEntity)var15.next()).toDeviceScheduleInstruction());
      }

      List var16 = (List)var2;
      boolean var1 = this.paused;
      Set var9 = this.toDaysOfWeek();
      String var10 = this.timeZone;
      List var12 = this.endInstructions;
      if (var12 != null) {
         Iterable var11 = (Iterable)var12;
         Collection var13 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var11, 10)));
         Iterator var17 = var11.iterator();

         while(var17.hasNext()) {
            var13.add(((DeviceScheduleInstructionEntity)var17.next()).toDeviceScheduleInstruction());
         }

         var12 = (List)var13;
      } else {
         var12 = null;
      }

      return new DeviceSchedule(var6, var4, var3, var7, var5, var16, var1, var9, var10, var12, this.scheduleEndType);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceScheduleEntity(deviceId=");
      var1.append(this.deviceId);
      var1.append(", scheduleId=");
      var1.append(this.scheduleId);
      var1.append(", scheduleName=");
      var1.append(this.scheduleName);
      var1.append(", startTime=");
      var1.append(this.startTime);
      var1.append(", endTime=");
      var1.append(this.endTime);
      var1.append(", instructions=");
      var1.append(this.instructions);
      var1.append(", paused=");
      var1.append(this.paused);
      var1.append(", daysOfWeek=");
      var1.append(this.daysOfWeek);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(", endInstructions=");
      var1.append(this.endInstructions);
      var1.append(", scheduleEndType=");
      var1.append(this.scheduleEndType);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/database/entity/DeviceScheduleEntity$Companion;", "", "<init>", "()V", "DEVICE_SCHEDULE_TABLE", "", "fromDeviceSchedule", "Lcom/blueair/database/entity/DeviceScheduleEntity;", "deviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "fromDaysOfWeek", "", "", "daysOfWeek", "Lcom/blueair/core/model/DayOfWeek;", "database_otherRelease"},
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

      public final Set fromDaysOfWeek(Set var1) {
         Intrinsics.checkNotNullParameter(var1, "daysOfWeek");
         Set var2 = (Set)(new LinkedHashSet());
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.add(((DayOfWeek)var3.next()).getDbValue());
         }

         return CollectionsKt.toSet((Iterable)var2);
      }

      public final DeviceScheduleEntity fromDeviceSchedule(DeviceSchedule var1) {
         Intrinsics.checkNotNullParameter(var1, "deviceSchedule");
         String var4 = var1.getScheduleId();
         String var5 = var1.getScheduleName();
         if (var4 != null && var5 != null) {
            List var3 = var1.getEndInstructions();
            if (var3 != null) {
               Iterable var6 = (Iterable)var3;
               Collection var12 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var6, 10)));

               for(DeviceScheduleInstruction var7 : var6) {
                  var12.add(DeviceScheduleInstructionEntity.Companion.fromDeviceScheduleInstruction(var7));
               }

               var3 = (List)var12;
            } else {
               var3 = null;
            }

            String var15 = var1.getDeviceId();
            String var8 = var1.getStartTime();
            String var16 = var1.getEndTime();
            Iterable var10 = (Iterable)var1.getInstructions();
            Collection var9 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var10, 10)));

            for(DeviceScheduleInstruction var11 : var10) {
               var9.add(DeviceScheduleInstructionEntity.Companion.fromDeviceScheduleInstruction(var11));
            }

            List var19 = (List)var9;
            boolean var2 = var1.getPaused();
            Set var20 = this.fromDaysOfWeek(var1.getDaysOfWeek());
            String var17 = var1.getTimeZone();
            if (var3 != null && ((Collection)var3).size() == 0) {
               var3 = null;
            }

            return new DeviceScheduleEntity(var15, var4, var5, var8, var16, var19, var2, var20, var17, var3, var1.getScheduleEndType());
         } else {
            return null;
         }
      }
   }
}
