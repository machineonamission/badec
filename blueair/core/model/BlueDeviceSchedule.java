package com.blueair.core.model;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J»\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0003\u0010\u000e\u001a\u00020\u00032\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\fHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001e¨\u0006;"},
   d2 = {"Lcom/blueair/core/model/BlueDeviceSchedule;", "", "deviceid", "", "scheduleid", "scheduleName", "scheduleStartTime", "scheduleEndTime", "scheduleMode", "", "Lcom/blueair/core/model/ScheduleMode;", "scheduleActive", "", "scheduleRepeatOn", "scheduleEndType", "scheduleEndCustomMode", "isNewScheduleName", "", "scheduleStartTimeLocal", "scheduleEndTimeLocal", "scheduleRepeatOnLocal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDeviceid", "()Ljava/lang/String;", "getScheduleid", "getScheduleName", "getScheduleStartTime", "getScheduleEndTime", "getScheduleMode", "()Ljava/util/List;", "getScheduleActive", "()I", "getScheduleRepeatOn", "getScheduleEndType", "getScheduleEndCustomMode", "()Z", "getScheduleStartTimeLocal", "getScheduleEndTimeLocal", "getScheduleRepeatOnLocal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueDeviceSchedule {
   private final String deviceid;
   private final boolean isNewScheduleName;
   private final int scheduleActive;
   private final List scheduleEndCustomMode;
   private final String scheduleEndTime;
   private final String scheduleEndTimeLocal;
   private final String scheduleEndType;
   private final List scheduleMode;
   private final String scheduleName;
   private final List scheduleRepeatOn;
   private final List scheduleRepeatOnLocal;
   private final String scheduleStartTime;
   private final String scheduleStartTimeLocal;
   private final String scheduleid;

   public BlueDeviceSchedule(String var1, String var2, @Json(name = "schedule-name") String var3, @Json(name = "schedule-start-time") String var4, @Json(name = "schedule-end-time") String var5, @Json(name = "schedule-mode") List var6, @Json(name = "schedule-active") int var7, @Json(name = "schedule-repeat-on") List var8, @Json(name = "schedule-type") String var9, @Json(name = "schedule-custom-setting") List var10, @Json(name = "schedule-name-is-new") boolean var11, @Json(name = "schedule-start-time-local") String var12, @Json(name = "schedule-end-time-local") String var13, @Json(name = "schedule-repeat-on-local") List var14) {
      Intrinsics.checkNotNullParameter(var1, "deviceid");
      Intrinsics.checkNotNullParameter(var4, "scheduleStartTime");
      Intrinsics.checkNotNullParameter(var5, "scheduleEndTime");
      Intrinsics.checkNotNullParameter(var6, "scheduleMode");
      Intrinsics.checkNotNullParameter(var8, "scheduleRepeatOn");
      Intrinsics.checkNotNullParameter(var9, "scheduleEndType");
      Intrinsics.checkNotNullParameter(var10, "scheduleEndCustomMode");
      super();
      this.deviceid = var1;
      this.scheduleid = var2;
      this.scheduleName = var3;
      this.scheduleStartTime = var4;
      this.scheduleEndTime = var5;
      this.scheduleMode = var6;
      this.scheduleActive = var7;
      this.scheduleRepeatOn = var8;
      this.scheduleEndType = var9;
      this.scheduleEndCustomMode = var10;
      this.isNewScheduleName = var11;
      this.scheduleStartTimeLocal = var12;
      this.scheduleEndTimeLocal = var13;
      this.scheduleRepeatOnLocal = var14;
   }

   // $FF: synthetic method
   public BlueDeviceSchedule(String var1, String var2, String var3, String var4, String var5, List var6, int var7, List var8, String var9, List var10, boolean var11, String var12, String var13, List var14, int var15, DefaultConstructorMarker var16) {
      if ((var15 & 2) != 0) {
         var2 = null;
      }

      if ((var15 & 256) != 0) {
         var9 = "previous";
      }

      if ((var15 & 512) != 0) {
         var10 = CollectionsKt.emptyList();
      }

      if ((var15 & 1024) != 0) {
         var11 = false;
      }

      if ((var15 & 2048) != 0) {
         var12 = null;
      }

      if ((var15 & 4096) != 0) {
         var13 = null;
      }

      if ((var15 & 8192) != 0) {
         var14 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
   }

   // $FF: synthetic method
   public static BlueDeviceSchedule copy$default(BlueDeviceSchedule var0, String var1, String var2, String var3, String var4, String var5, List var6, int var7, List var8, String var9, List var10, boolean var11, String var12, String var13, List var14, int var15, Object var16) {
      if ((var15 & 1) != 0) {
         var1 = var0.deviceid;
      }

      if ((var15 & 2) != 0) {
         var2 = var0.scheduleid;
      }

      if ((var15 & 4) != 0) {
         var3 = var0.scheduleName;
      }

      if ((var15 & 8) != 0) {
         var4 = var0.scheduleStartTime;
      }

      if ((var15 & 16) != 0) {
         var5 = var0.scheduleEndTime;
      }

      if ((var15 & 32) != 0) {
         var6 = var0.scheduleMode;
      }

      if ((var15 & 64) != 0) {
         var7 = var0.scheduleActive;
      }

      if ((var15 & 128) != 0) {
         var8 = var0.scheduleRepeatOn;
      }

      if ((var15 & 256) != 0) {
         var9 = var0.scheduleEndType;
      }

      if ((var15 & 512) != 0) {
         var10 = var0.scheduleEndCustomMode;
      }

      if ((var15 & 1024) != 0) {
         var11 = var0.isNewScheduleName;
      }

      if ((var15 & 2048) != 0) {
         var12 = var0.scheduleStartTimeLocal;
      }

      if ((var15 & 4096) != 0) {
         var13 = var0.scheduleEndTimeLocal;
      }

      if ((var15 & 8192) != 0) {
         var14 = var0.scheduleRepeatOnLocal;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
   }

   public final String component1() {
      return this.deviceid;
   }

   public final List component10() {
      return this.scheduleEndCustomMode;
   }

   public final boolean component11() {
      return this.isNewScheduleName;
   }

   public final String component12() {
      return this.scheduleStartTimeLocal;
   }

   public final String component13() {
      return this.scheduleEndTimeLocal;
   }

   public final List component14() {
      return this.scheduleRepeatOnLocal;
   }

   public final String component2() {
      return this.scheduleid;
   }

   public final String component3() {
      return this.scheduleName;
   }

   public final String component4() {
      return this.scheduleStartTime;
   }

   public final String component5() {
      return this.scheduleEndTime;
   }

   public final List component6() {
      return this.scheduleMode;
   }

   public final int component7() {
      return this.scheduleActive;
   }

   public final List component8() {
      return this.scheduleRepeatOn;
   }

   public final String component9() {
      return this.scheduleEndType;
   }

   public final BlueDeviceSchedule copy(String var1, String var2, @Json(name = "schedule-name") String var3, @Json(name = "schedule-start-time") String var4, @Json(name = "schedule-end-time") String var5, @Json(name = "schedule-mode") List var6, @Json(name = "schedule-active") int var7, @Json(name = "schedule-repeat-on") List var8, @Json(name = "schedule-type") String var9, @Json(name = "schedule-custom-setting") List var10, @Json(name = "schedule-name-is-new") boolean var11, @Json(name = "schedule-start-time-local") String var12, @Json(name = "schedule-end-time-local") String var13, @Json(name = "schedule-repeat-on-local") List var14) {
      Intrinsics.checkNotNullParameter(var1, "deviceid");
      Intrinsics.checkNotNullParameter(var4, "scheduleStartTime");
      Intrinsics.checkNotNullParameter(var5, "scheduleEndTime");
      Intrinsics.checkNotNullParameter(var6, "scheduleMode");
      Intrinsics.checkNotNullParameter(var8, "scheduleRepeatOn");
      Intrinsics.checkNotNullParameter(var9, "scheduleEndType");
      Intrinsics.checkNotNullParameter(var10, "scheduleEndCustomMode");
      return new BlueDeviceSchedule(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof BlueDeviceSchedule)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.deviceid, var1.deviceid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleid, var1.scheduleid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleName, var1.scheduleName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleStartTime, var1.scheduleStartTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleEndTime, var1.scheduleEndTime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleMode, var1.scheduleMode)) {
            return false;
         } else if (this.scheduleActive != var1.scheduleActive) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleRepeatOn, var1.scheduleRepeatOn)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleEndType, var1.scheduleEndType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleEndCustomMode, var1.scheduleEndCustomMode)) {
            return false;
         } else if (this.isNewScheduleName != var1.isNewScheduleName) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleStartTimeLocal, var1.scheduleStartTimeLocal)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scheduleEndTimeLocal, var1.scheduleEndTimeLocal)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.scheduleRepeatOnLocal, var1.scheduleRepeatOnLocal);
         }
      }
   }

   public final String getDeviceid() {
      return this.deviceid;
   }

   public final int getScheduleActive() {
      return this.scheduleActive;
   }

   public final List getScheduleEndCustomMode() {
      return this.scheduleEndCustomMode;
   }

   public final String getScheduleEndTime() {
      return this.scheduleEndTime;
   }

   public final String getScheduleEndTimeLocal() {
      return this.scheduleEndTimeLocal;
   }

   public final String getScheduleEndType() {
      return this.scheduleEndType;
   }

   public final List getScheduleMode() {
      return this.scheduleMode;
   }

   public final String getScheduleName() {
      return this.scheduleName;
   }

   public final List getScheduleRepeatOn() {
      return this.scheduleRepeatOn;
   }

   public final List getScheduleRepeatOnLocal() {
      return this.scheduleRepeatOnLocal;
   }

   public final String getScheduleStartTime() {
      return this.scheduleStartTime;
   }

   public final String getScheduleStartTimeLocal() {
      return this.scheduleStartTimeLocal;
   }

   public final String getScheduleid() {
      return this.scheduleid;
   }

   public int hashCode() {
      int var6 = this.deviceid.hashCode();
      String var15 = this.scheduleid;
      int var5 = 0;
      int var1;
      if (var15 == null) {
         var1 = 0;
      } else {
         var1 = var15.hashCode();
      }

      var15 = this.scheduleName;
      int var2;
      if (var15 == null) {
         var2 = 0;
      } else {
         var2 = var15.hashCode();
      }

      int var13 = this.scheduleStartTime.hashCode();
      int var8 = this.scheduleEndTime.hashCode();
      int var7 = this.scheduleMode.hashCode();
      int var11 = this.scheduleActive;
      int var12 = this.scheduleRepeatOn.hashCode();
      int var10 = this.scheduleEndType.hashCode();
      int var9 = this.scheduleEndCustomMode.hashCode();
      int var14 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isNewScheduleName);
      var15 = this.scheduleStartTimeLocal;
      int var3;
      if (var15 == null) {
         var3 = 0;
      } else {
         var3 = var15.hashCode();
      }

      var15 = this.scheduleEndTimeLocal;
      int var4;
      if (var15 == null) {
         var4 = 0;
      } else {
         var4 = var15.hashCode();
      }

      List var19 = this.scheduleRepeatOnLocal;
      if (var19 != null) {
         var5 = var19.hashCode();
      }

      return ((((((((((((var6 * 31 + var1) * 31 + var2) * 31 + var13) * 31 + var8) * 31 + var7) * 31 + var11) * 31 + var12) * 31 + var10) * 31 + var9) * 31 + var14) * 31 + var3) * 31 + var4) * 31 + var5;
   }

   public final boolean isNewScheduleName() {
      return this.isNewScheduleName;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("BlueDeviceSchedule(deviceid=");
      var1.append(this.deviceid);
      var1.append(", scheduleid=");
      var1.append(this.scheduleid);
      var1.append(", scheduleName=");
      var1.append(this.scheduleName);
      var1.append(", scheduleStartTime=");
      var1.append(this.scheduleStartTime);
      var1.append(", scheduleEndTime=");
      var1.append(this.scheduleEndTime);
      var1.append(", scheduleMode=");
      var1.append(this.scheduleMode);
      var1.append(", scheduleActive=");
      var1.append(this.scheduleActive);
      var1.append(", scheduleRepeatOn=");
      var1.append(this.scheduleRepeatOn);
      var1.append(", scheduleEndType=");
      var1.append(this.scheduleEndType);
      var1.append(", scheduleEndCustomMode=");
      var1.append(this.scheduleEndCustomMode);
      var1.append(", isNewScheduleName=");
      var1.append(this.isNewScheduleName);
      var1.append(", scheduleStartTimeLocal=");
      var1.append(this.scheduleStartTimeLocal);
      var1.append(", scheduleEndTimeLocal=");
      var1.append(this.scheduleEndTimeLocal);
      var1.append(", scheduleRepeatOnLocal=");
      var1.append(this.scheduleRepeatOnLocal);
      var1.append(')');
      return var1.toString();
   }
}
