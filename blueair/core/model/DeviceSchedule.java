package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.TimeUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0000J\u0006\u0010&\u001a\u00020'J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0091\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u00104\u001a\u000205J\u0013\u00106\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000205HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000205R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u0006@"},
   d2 = {"Lcom/blueair/core/model/DeviceSchedule;", "Landroid/os/Parcelable;", "scheduleId", "", "deviceId", "scheduleName", "startTime", "endTime", "instructions", "", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "paused", "", "daysOfWeek", "", "Lcom/blueair/core/model/DayOfWeek;", "timeZone", "endInstructions", "scheduleEndType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/Set;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getScheduleId", "()Ljava/lang/String;", "getDeviceId", "getScheduleName", "getStartTime", "getEndTime", "getInstructions", "()Ljava/util/List;", "getPaused", "()Z", "getDaysOfWeek", "()Ljava/util/Set;", "getTimeZone", "getEndInstructions", "getScheduleEndType", "isSameTimeSchedule", "other", "toBlueDeviceSchedule", "Lcom/blueair/core/model/BlueDeviceSchedule;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSchedule implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
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

   public DeviceSchedule(String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11) {
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Intrinsics.checkNotNullParameter(var4, "startTime");
      Intrinsics.checkNotNullParameter(var5, "endTime");
      Intrinsics.checkNotNullParameter(var6, "instructions");
      Intrinsics.checkNotNullParameter(var8, "daysOfWeek");
      Intrinsics.checkNotNullParameter(var9, "timeZone");
      super();
      this.scheduleId = var1;
      this.deviceId = var2;
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
   public DeviceSchedule(String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11, int var12, DefaultConstructorMarker var13) {
      if ((var12 & 1) != 0) {
         var1 = null;
      }

      if ((var12 & 4) != 0) {
         var3 = null;
      }

      if ((var12 & 1024) != 0) {
         var11 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   // $FF: synthetic method
   public static DeviceSchedule copy$default(DeviceSchedule var0, String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.scheduleId;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.deviceId;
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
      return this.scheduleId;
   }

   public final List component10() {
      return this.endInstructions;
   }

   public final String component11() {
      return this.scheduleEndType;
   }

   public final String component2() {
      return this.deviceId;
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

   public final DeviceSchedule copy(String var1, String var2, String var3, String var4, String var5, List var6, boolean var7, Set var8, String var9, List var10, String var11) {
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Intrinsics.checkNotNullParameter(var4, "startTime");
      Intrinsics.checkNotNullParameter(var5, "endTime");
      Intrinsics.checkNotNullParameter(var6, "instructions");
      Intrinsics.checkNotNullParameter(var8, "daysOfWeek");
      Intrinsics.checkNotNullParameter(var9, "timeZone");
      return new DeviceSchedule(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceSchedule)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.scheduleId, var1.scheduleId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceId, var1.deviceId)) {
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
      String var12 = this.scheduleId;
      int var4 = 0;
      int var1;
      if (var12 == null) {
         var1 = 0;
      } else {
         var1 = var12.hashCode();
      }

      int var5 = this.deviceId.hashCode();
      var12 = this.scheduleName;
      int var2;
      if (var12 == null) {
         var2 = 0;
      } else {
         var2 = var12.hashCode();
      }

      int var11 = this.startTime.hashCode();
      int var6 = this.endTime.hashCode();
      int var10 = this.instructions.hashCode();
      int var7 = AddDeviceState$$ExternalSyntheticBackport0.m(this.paused);
      int var9 = this.daysOfWeek.hashCode();
      int var8 = this.timeZone.hashCode();
      List var14 = this.endInstructions;
      int var3;
      if (var14 == null) {
         var3 = 0;
      } else {
         var3 = var14.hashCode();
      }

      String var15 = this.scheduleEndType;
      if (var15 != null) {
         var4 = var15.hashCode();
      }

      return (((((((((var1 * 31 + var5) * 31 + var2) * 31 + var11) * 31 + var6) * 31 + var10) * 31 + var7) * 31 + var9) * 31 + var8) * 31 + var3) * 31 + var4;
   }

   public final boolean isSameTimeSchedule(DeviceSchedule var1) {
      Intrinsics.checkNotNullParameter(var1, "other");
      return Intrinsics.areEqual(this.startTime, var1.startTime) && Intrinsics.areEqual(this.endTime, var1.endTime) && Intrinsics.areEqual(this.daysOfWeek, var1.daysOfWeek) && Intrinsics.areEqual(this.deviceId, var1.deviceId);
   }

   public final BlueDeviceSchedule toBlueDeviceSchedule() {
      int var1 = TimeUtils.INSTANCE.getLocalToUTCDateOffset(this.startTime, this.timeZone);
      String var7 = this.deviceId;
      String var6 = this.scheduleId;
      String var4 = this.scheduleName;
      String var3 = var4;
      if (var4 == null) {
         StringBuilder var13 = new StringBuilder();
         var13.append(this.startTime);
         var13.append(" - ");
         var13.append(this.endTime);
         var3 = var13.toString();
      }

      String var9 = TimeUtils.INSTANCE.convertLocalTimeToUTC(this.startTime, this.timeZone);
      String var8 = TimeUtils.INSTANCE.convertLocalTimeToUTC(this.endTime, this.timeZone);
      Iterable var5 = (Iterable)this.instructions;
      Collection var14 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var5, 10)));
      Iterator var17 = var5.iterator();

      while(var17.hasNext()) {
         var14.add(((DeviceScheduleInstruction)var17.next()).toBlueScheduleInstruction());
      }

      List var10 = (List)var14;
      byte var2 = this.paused;
      Iterable var18 = (Iterable)this.daysOfWeek;
      var14 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var18, 10)));
      Iterator var19 = var18.iterator();

      while(var19.hasNext()) {
         var14.add(((DayOfWeek)var19.next()).plusDays(var1).getBlueValue());
      }

      List var11 = (List)var14;
      String var20 = this.scheduleEndType;
      String var16 = var20;
      if (var20 == null) {
         var16 = "previous";
      }

      List var21 = this.endInstructions;
      if (var21 != null) {
         Iterable var12 = (Iterable)var21;
         Collection var22 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var12, 10)));
         Iterator var24 = var12.iterator();

         while(var24.hasNext()) {
            var22.add(((DeviceScheduleInstruction)var24.next()).toBlueScheduleInstruction());
         }

         var21 = (List)var22;
      } else {
         var21 = CollectionsKt.emptyList();
      }

      return new BlueDeviceSchedule(var7, var6, var3, var9, var8, var10, var2 ^ 1, var11, var16, var21, true, (String)null, (String)null, (List)null);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceSchedule(scheduleId=");
      var1.append(this.scheduleId);
      var1.append(", deviceId=");
      var1.append(this.deviceId);
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

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.scheduleId);
      var1.writeString(this.deviceId);
      var1.writeString(this.scheduleName);
      var1.writeString(this.startTime);
      var1.writeString(this.endTime);
      List var3 = this.instructions;
      var1.writeInt(var3.size());
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         ((DeviceScheduleInstruction)var4.next()).writeToParcel(var1, var2);
      }

      var1.writeInt(this.paused);
      Set var5 = this.daysOfWeek;
      var1.writeInt(var5.size());
      Iterator var6 = var5.iterator();

      while(var6.hasNext()) {
         var1.writeString(((DayOfWeek)var6.next()).name());
      }

      var1.writeString(this.timeZone);
      List var7 = this.endInstructions;
      if (var7 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var7.size());
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            ((DeviceScheduleInstruction)var8.next()).writeToParcel(var1, var2);
         }
      }

      var1.writeString(this.scheduleEndType);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/core/model/DeviceSchedule$Companion;", "", "<init>", "()V", "toLegacy", "", "Lcom/blueair/core/model/LegacyDeviceSchedule;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "userId", "", "(Lcom/blueair/core/model/DeviceSchedule;Ljava/lang/Integer;)Ljava/util/List;", "fromLegacy", "fromBlueDeviceSchedule", "Lcom/blueair/core/model/BlueDeviceSchedule;", "core_otherRelease"},
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

      // $FF: synthetic method
      public static List toLegacy$default(Companion var0, DeviceSchedule var1, Integer var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.toLegacy(var1, var2);
      }

      public final DeviceSchedule fromBlueDeviceSchedule(BlueDeviceSchedule var1) {
         Intrinsics.checkNotNullParameter(var1, "schedule");
         Iterable var5 = (Iterable)var1.getScheduleMode();
         Collection var4 = (Collection)(new ArrayList());

         for(ScheduleMode var6 : var5) {
            DeviceScheduleInstruction var31 = DeviceScheduleInstruction.Companion.fromBlueDeviceSchedule(var6);
            if (var31 != null) {
               var4.add(var31);
            }
         }

         List var9 = (List)var4;
         var5 = (Iterable)var1.getScheduleEndCustomMode();
         var4 = (Collection)(new ArrayList());

         for(ScheduleMode var32 : var5) {
            DeviceScheduleInstruction var33 = DeviceScheduleInstruction.Companion.fromBlueDeviceSchedule(var32);
            if (var33 != null) {
               var4.add(var33);
            }
         }

         List var10 = (List)var4;
         String var7;
         List var28;
         String var34;
         if (var1.getScheduleStartTimeLocal() != null && var1.getScheduleEndTimeLocal() != null && var1.getScheduleRepeatOnLocal() != null) {
            var7 = var1.getScheduleStartTimeLocal();
            var34 = var1.getScheduleEndTimeLocal();
            Iterable var29 = (Iterable)var1.getScheduleRepeatOnLocal();
            var4 = (Collection)(new ArrayList());

            for(String var35 : var29) {
               DayOfWeek var36 = DayOfWeek.Companion.getByBlueValue(var35);
               if (var36 != null) {
                  var4.add(var36);
               }
            }

            var28 = (List)var4;
         } else {
            var7 = TimeUtils.convertUTCTimeToLocalTime$default(TimeUtils.INSTANCE, var1.getScheduleStartTime(), (TimeZone)null, 2, (Object)null);
            var34 = TimeUtils.convertUTCTimeToLocalTime$default(TimeUtils.INSTANCE, var1.getScheduleEndTime(), (TimeZone)null, 2, (Object)null);
            int var2 = TimeUtils.INSTANCE.getUTCtoLocalDateOffset(var1.getScheduleStartTime());
            Iterable var14 = (Iterable)var1.getScheduleRepeatOn();
            Collection var27 = (Collection)(new ArrayList());

            for(String var15 : var14) {
               DayOfWeek var16 = DayOfWeek.Companion.getByBlueValue(var15);
               if (var16 != null) {
                  var16 = var16.plusDays(var2);
               } else {
                  var16 = null;
               }

               if (var16 != null) {
                  var27.add(var16);
               }
            }

            var28 = (List)var27;
         }

         String var19 = var1.getScheduleName();
         String var37 = "";
         if (var19 == null) {
            var19 = var37;
         } else if (var1.isNewScheduleName()) {
            var19 = var1.getScheduleName();
         } else {
            Regex var22;
            if (var1.getScheduleName().length() == 13) {
               StringBuilder var21 = new StringBuilder();
               var21.append(var7);
               var21.append(" - ");
               var21.append(var34);
               var22 = new Regex(var21.toString());
            } else {
               StringBuilder var23 = new StringBuilder();
               var23.append(TimeUtils.INSTANCE.convert24HourTo12Hour(var7));
               var23.append("( .+) - ");
               var23.append(TimeUtils.INSTANCE.convert24HourTo12Hour(var34));
               var23.append("( .+)");
               var22 = new Regex(var23.toString());
            }

            if (var22.matches((CharSequence)var1.getScheduleName())) {
               var19 = var37;
            } else {
               var19 = var1.getScheduleName();
            }
         }

         var37 = var1.getScheduleid();
         String var11 = var1.getDeviceid();
         int var12 = var1.getScheduleActive();
         boolean var3 = true;
         if (var12 == 1) {
            var3 = false;
         }

         return new DeviceSchedule(var37, var11, var19, var7, var34, var9, var3, CollectionsKt.toSet((Iterable)var28), "", var10, var1.getScheduleEndType());
      }

      public final DeviceSchedule fromLegacy(LegacyDeviceSchedule var1) {
         Intrinsics.checkNotNullParameter(var1, "schedule");
         List var4 = CollectionsKt.listOf(DeviceScheduleInstruction.Companion.fromLegacy(var1.getInstructions()));
         List var3 = CollectionsKt.emptyList();
         if (var1.getDoOnEndInstructions() != null) {
            var3 = DeviceScheduleInstruction.Companion.fromLegacyToEndInstruction(var1.getDoOnEndInstructions());
         }

         String var5 = var1.getId();
         String var6 = var1.getUuid();
         StringBuilder var7 = new StringBuilder();
         var7.append(var1.getStartTime());
         var7.append(" - ");
         var7.append(var1.getEndTime());
         String var13 = var7.toString();
         String var10 = var1.getStartTime();
         String var8 = var1.getEndTime();
         Iterable var11 = (Iterable)var1.getDaysOfWeek();
         Collection var9 = (Collection)(new ArrayList());
         Iterator var12 = var11.iterator();

         while(var12.hasNext()) {
            int var2 = ((Number)var12.next()).intValue();
            DayOfWeek var14 = DayOfWeek.Companion.getByAblValue(var2);
            if (var14 != null) {
               var9.add(var14);
            }
         }

         return new DeviceSchedule(var5, var6, var13, var10, var8, var4, false, CollectionsKt.toSet((Iterable)((List)var9)), var1.getTimeZone(), var3, (String)null, 1024, (DefaultConstructorMarker)null);
      }

      public final List toLegacy(DeviceSchedule var1, Integer var2) {
         Intrinsics.checkNotNullParameter(var1, "schedule");
         List var8 = (List)(new ArrayList());
         int var5 = ((Collection)var1.getInstructions()).size();

         for(int var3 = 0; var3 < var5; ++var3) {
            DeviceScheduleInstruction var9 = (DeviceScheduleInstruction)var1.getInstructions().get(var3);
            List var7 = var1.getEndInstructions();
            LegacyDeviceEndInstruction var6 = null;
            DeviceScheduleInstruction var15;
            if (var7 != null) {
               var15 = (DeviceScheduleInstruction)var7.get(var3);
            } else {
               var15 = null;
            }

            if (var15 != null) {
               var6 = LegacyDeviceEndInstruction.Companion.newInstance(var15);
            }

            String var12 = var1.getScheduleId();
            int var4;
            if (var2 != null) {
               var4 = var2;
            } else {
               var4 = 0;
            }

            String var16 = var1.getDeviceId();
            String var10 = var1.getStartTime();
            String var11 = var1.getEndTime();
            LegacyDeviceScheduleInstruction var13 = new LegacyDeviceScheduleInstruction(var9.getName(), var9.getValue());
            Iterable var14 = (Iterable)var1.getDaysOfWeek();
            Collection var17 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var14, 10)));
            Iterator var18 = var14.iterator();

            while(var18.hasNext()) {
               var17.add(((DayOfWeek)var18.next()).getAblValue());
            }

            var8.add(new LegacyDeviceSchedule(var12, var4, var16, var10, var11, var13, (List)var17, var1.getTimeZone(), var6));
         }

         return var8;
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceSchedule createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var7 = var1.readString();
         String var8 = var1.readString();
         String var11 = var1.readString();
         String var9 = var1.readString();
         String var10 = var1.readString();
         int var4 = var1.readInt();
         ArrayList var6 = new ArrayList(var4);
         byte var3 = 0;

         for(int var2 = 0; var2 != var4; ++var2) {
            var6.add(DeviceScheduleInstruction.CREATOR.createFromParcel(var1));
         }

         List var12 = (List)var6;
         boolean var5;
         if (var1.readInt() != 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         var4 = var1.readInt();
         LinkedHashSet var19 = new LinkedHashSet(var4);

         for(int var15 = 0; var15 != var4; ++var15) {
            var19.add(DayOfWeek.valueOf(var1.readString()));
         }

         Set var13 = (Set)var19;
         String var14 = var1.readString();
         ArrayList var20;
         if (var1.readInt() == 0) {
            var20 = null;
         } else {
            var4 = var1.readInt();
            var20 = new ArrayList(var4);

            for(int var16 = var3; var16 != var4; ++var16) {
               var20.add(DeviceScheduleInstruction.CREATOR.createFromParcel(var1));
            }
         }

         return new DeviceSchedule(var7, var8, var11, var9, var10, var12, var5, var13, var14, (List)var20, var1.readString());
      }

      public final DeviceSchedule[] newArray(int var1) {
         return new DeviceSchedule[var1];
      }
   }
}
