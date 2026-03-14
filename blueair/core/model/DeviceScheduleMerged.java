package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 n2\u00020\u0001:\u0001nB\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010Y\u001a\u0002032\u0006\u0010Z\u001a\u00020\u0000J\u0010\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020\nJ\u000e\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aJ\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010d\u001a\u00020_J\u0013\u0010e\u001a\u0002032\b\u0010Z\u001a\u0004\u0018\u00010fHÖ\u0003J\t\u0010g\u001a\u00020_HÖ\u0001J\t\u0010h\u001a\u00020\nHÖ\u0001J\u0016\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020_R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R&\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0003X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\f\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\u0006R&\u0010*\u001a\b\u0012\u0004\u0012\u00020&0\u0003X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\f\u001a\u0004\b,\u0010\b\"\u0004\b-\u0010\u0006R\"\u0010.\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R \u00102\u001a\u000203X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u00109\u001a\u0002038F¢\u0006\f\u0012\u0004\b:\u0010\f\u001a\u0004\b9\u00106R\u0017\u0010;\u001a\u0002038F¢\u0006\f\u0012\u0004\b<\u0010\f\u001a\u0004\b;\u00106R\u0017\u0010=\u001a\u0002038F¢\u0006\f\u0012\u0004\b>\u0010\f\u001a\u0004\b=\u00106R\u0017\u0010?\u001a\u0002038F¢\u0006\f\u0012\u0004\b@\u0010\f\u001a\u0004\b?\u00106R\u0017\u0010A\u001a\u0002038F¢\u0006\f\u0012\u0004\bB\u0010\f\u001a\u0004\bA\u00106R\u0017\u0010C\u001a\u0002038F¢\u0006\f\u0012\u0004\bD\u0010\f\u001a\u0004\bC\u00106R\u0017\u0010E\u001a\u0002038F¢\u0006\f\u0012\u0004\bF\u0010\f\u001a\u0004\bE\u00106R\u0017\u0010G\u001a\u0002038F¢\u0006\f\u0012\u0004\bH\u0010\f\u001a\u0004\bG\u00106R\u0017\u0010I\u001a\u0002038F¢\u0006\f\u0012\u0004\bJ\u0010\f\u001a\u0004\bI\u00106R\u0017\u0010K\u001a\u0002038F¢\u0006\f\u0012\u0004\bL\u0010\f\u001a\u0004\bK\u00106R\u0017\u0010M\u001a\u0002038F¢\u0006\f\u0012\u0004\bN\u0010\f\u001a\u0004\bM\u00106R\u0017\u0010O\u001a\u0002038F¢\u0006\f\u0012\u0004\bP\u0010\f\u001a\u0004\bO\u00106R\u0017\u0010Q\u001a\u0002038F¢\u0006\f\u0012\u0004\bR\u0010\f\u001a\u0004\bQ\u00106R\u0017\u0010S\u001a\u0002038F¢\u0006\f\u0012\u0004\bT\u0010\f\u001a\u0004\bS\u00106R\u0017\u0010U\u001a\u0002038F¢\u0006\f\u0012\u0004\bV\u0010\f\u001a\u0004\bU\u00106R\u0017\u0010W\u001a\u0002038F¢\u0006\f\u0012\u0004\bX\u0010\f\u001a\u0004\bW\u00106¨\u0006o"},
   d2 = {"Lcom/blueair/core/model/DeviceScheduleMerged;", "Landroid/os/Parcelable;", "schedule", "", "Lcom/blueair/core/model/DeviceSchedule;", "<init>", "(Ljava/util/List;)V", "getSchedule", "()Ljava/util/List;", "name", "", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "startTime", "getStartTime$annotations", "getStartTime", "setStartTime", "endTime", "getEndTime$annotations", "getEndTime", "setEndTime", "daysOfWeek", "", "Lcom/blueair/core/model/DayOfWeek;", "getDaysOfWeek$annotations", "getDaysOfWeek", "()Ljava/util/Set;", "setDaysOfWeek", "(Ljava/util/Set;)V", "timeZone", "getTimeZone$annotations", "getTimeZone", "setTimeZone", "instructions", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "getInstructions$annotations", "getInstructions", "setInstructions", "endInstructions", "getEndInstructions$annotations", "getEndInstructions", "setEndInstructions", "endScheduleMode", "getEndScheduleMode$annotations", "getEndScheduleMode", "setEndScheduleMode", "paused", "", "getPaused$annotations", "getPaused", "()Z", "setPaused", "(Z)V", "isManual", "isManual$annotations", "isAutoMode", "isAutoMode$annotations", "isNightMode", "isNightMode$annotations", "isStandbyMode", "isStandbyMode$annotations", "isDisinfectionMode", "isDisinfectionMode$annotations", "isEcoMode", "isEcoMode$annotations", "isSkinMode", "isSkinMode$annotations", "isCoolMainMode", "isCoolMainMode$annotations", "isAirPurifyMainMode", "isAirPurifyMainMode$annotations", "isHeatMainMode", "isHeatMainMode$annotations", "isSmartMainMode", "isSmartMainMode$annotations", "isDehMainMode", "isDehMainMode$annotations", "isHumMainMode", "isHumMainMode$annotations", "isHumMode", "isHumMode$annotations", "isDryingMode", "isDryingMode$annotations", "isContinuousMode", "isContinuousMode$annotations", "isSameMergedSchedules", "other", "timeToCalendar", "Ljava/util/Calendar;", "time", "fetchFanSpeed", "", "device", "Lcom/blueair/core/model/Device;", "component1", "copy", "describeContents", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleMerged implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Set daysOfWeek;
   private List endInstructions;
   private String endScheduleMode;
   private String endTime;
   private List instructions;
   private String name;
   private boolean paused;
   private final List schedule;
   private String startTime;
   private String timeZone;

   private DeviceScheduleMerged(List var1) {
      this.schedule = var1;
      DeviceSchedule var4 = (DeviceSchedule)CollectionsKt.first(var1);
      String var3 = var4.getScheduleName();
      String var2 = var3;
      if (var3 == null) {
         StringBuilder var9 = new StringBuilder();
         var9.append(var4.getStartTime());
         var9.append(' ');
         var9.append(var4.getEndTime());
         var2 = var9.toString();
      }

      this.name = var2;
      this.startTime = var4.getStartTime();
      this.endTime = var4.getEndTime();
      this.daysOfWeek = var4.getDaysOfWeek();
      this.timeZone = var4.getTimeZone();
      Iterable var10 = (Iterable)var1;
      Collection var6 = (Collection)(new ArrayList());
      Iterator var11 = var10.iterator();

      while(var11.hasNext()) {
         CollectionsKt.addAll(var6, (Iterable)((DeviceSchedule)var11.next()).getInstructions());
      }

      this.instructions = (List)var6;
      Iterable var7 = (Iterable)this.schedule;
      Collection var13 = (Collection)(new ArrayList());

      for(Iterator var5 = var7.iterator(); var5.hasNext(); CollectionsKt.addAll(var13, (Iterable)var8)) {
         List var12 = ((DeviceSchedule)var5.next()).getEndInstructions();
         var8 = var12;
         if (var12 == null) {
            var8 = CollectionsKt.emptyList();
         }
      }

      this.endInstructions = (List)var13;
      this.endScheduleMode = var4.getScheduleEndType();
      this.paused = var4.getPaused();
   }

   // $FF: synthetic method
   public DeviceScheduleMerged(List var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   // $FF: synthetic method
   public static DeviceScheduleMerged copy$default(DeviceScheduleMerged var0, List var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.schedule;
      }

      return var0.copy(var1);
   }

   // $FF: synthetic method
   public static void getDaysOfWeek$annotations() {
   }

   // $FF: synthetic method
   public static void getEndInstructions$annotations() {
   }

   // $FF: synthetic method
   public static void getEndScheduleMode$annotations() {
   }

   // $FF: synthetic method
   public static void getEndTime$annotations() {
   }

   // $FF: synthetic method
   public static void getInstructions$annotations() {
   }

   // $FF: synthetic method
   public static void getName$annotations() {
   }

   // $FF: synthetic method
   public static void getPaused$annotations() {
   }

   // $FF: synthetic method
   public static void getStartTime$annotations() {
   }

   // $FF: synthetic method
   public static void getTimeZone$annotations() {
   }

   // $FF: synthetic method
   public static void isAirPurifyMainMode$annotations() {
   }

   // $FF: synthetic method
   public static void isAutoMode$annotations() {
   }

   // $FF: synthetic method
   public static void isContinuousMode$annotations() {
   }

   // $FF: synthetic method
   public static void isCoolMainMode$annotations() {
   }

   // $FF: synthetic method
   public static void isDehMainMode$annotations() {
   }

   // $FF: synthetic method
   public static void isDisinfectionMode$annotations() {
   }

   // $FF: synthetic method
   public static void isDryingMode$annotations() {
   }

   // $FF: synthetic method
   public static void isEcoMode$annotations() {
   }

   // $FF: synthetic method
   public static void isHeatMainMode$annotations() {
   }

   // $FF: synthetic method
   public static void isHumMainMode$annotations() {
   }

   // $FF: synthetic method
   public static void isHumMode$annotations() {
   }

   // $FF: synthetic method
   public static void isManual$annotations() {
   }

   // $FF: synthetic method
   public static void isNightMode$annotations() {
   }

   // $FF: synthetic method
   public static void isSkinMode$annotations() {
   }

   // $FF: synthetic method
   public static void isSmartMainMode$annotations() {
   }

   // $FF: synthetic method
   public static void isStandbyMode$annotations() {
   }

   public final List component1() {
      return this.schedule;
   }

   public final DeviceScheduleMerged copy(List var1) {
      Intrinsics.checkNotNullParameter(var1, "schedule");
      return new DeviceScheduleMerged(var1);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceScheduleMerged)) {
         return false;
      } else {
         var1 = var1;
         return Intrinsics.areEqual(this.schedule, var1.schedule);
      }
   }

   public final int fetchFanSpeed(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Set var2 = SetsKt.setOf(new String[]{DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_FAN_SPEED.getInstructionName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_FAN_SPEED.getInstructionName()});
      Iterator var3 = ((Iterable)this.schedule).iterator();
      Integer var6 = null;

      while(var3.hasNext()) {
         for(DeviceScheduleInstruction var5 : ((DeviceSchedule)var3.next()).getInstructions()) {
            if (var2.contains(var5.getName())) {
               var6 = StringsKt.toIntOrNull(var5.getValue());
               break;
            }
         }
      }

      if (var6 != null) {
         return var6;
      } else {
         return 0;
      }
   }

   public final Set getDaysOfWeek() {
      return this.daysOfWeek;
   }

   public final List getEndInstructions() {
      return this.endInstructions;
   }

   public final String getEndScheduleMode() {
      return this.endScheduleMode;
   }

   public final String getEndTime() {
      return this.endTime;
   }

   public final List getInstructions() {
      return this.instructions;
   }

   public final String getName() {
      return this.name;
   }

   public final boolean getPaused() {
      return this.paused;
   }

   public final List getSchedule() {
      return this.schedule;
   }

   public final String getStartTime() {
      return this.startTime;
   }

   public final String getTimeZone() {
      return this.timeZone;
   }

   public int hashCode() {
      return this.schedule.hashCode();
   }

   public final boolean isAirPurifyMainMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var5 : var2) {
                  if (Intrinsics.areEqual(var5.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual(var5.getValue(), String.valueOf(MainMode.AirPurify.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isAutoMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var5.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getDefaultValue()) || Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getDefaultValue())) {
                     return true;
                  }

                  CharSequence var4 = (CharSequence)var3.getName();
                  if ((new Regex("(ap|heat|cool|hum)submode")).matches(var4) && Intrinsics.areEqual(var3.getValue(), String.valueOf(ApSubMode.AUTO.getValue())) || Intrinsics.areEqual(var3.getName(), "dehsubmode") && Intrinsics.areEqual(var3.getValue(), String.valueOf(DehSubMode.AUTO.getValue())) || Intrinsics.areEqual(var3.getName(), "humsubmode") && Intrinsics.areEqual(var3.getValue(), String.valueOf(HumSubMode.AUTO.getValue())) || Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), String.valueOf(Mode.AUTO.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isContinuousMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var5 : var2) {
                  if (Intrinsics.areEqual(var5.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE.getInstructionName()) && Intrinsics.areEqual(var5.getValue(), String.valueOf(DehSubMode.CONTINUOUS.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isCoolMainMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), String.valueOf(MainMode.COOL.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isDehMainMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), String.valueOf(MainMode.Dehumidification.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isDisinfectionMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var5 : var2) {
                  if (Intrinsics.areEqual(var5.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getInstructionName()) && Intrinsics.areEqual(var5.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getDefaultValue())) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isDryingMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var5 : var2) {
                  if (Intrinsics.areEqual(var5.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE.getInstructionName()) && Intrinsics.areEqual(var5.getValue(), String.valueOf(DehSubMode.DRYING.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isEcoMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var5.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var6 : var2) {
                  if (Intrinsics.areEqual(var6.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getInstructionName()) && Intrinsics.areEqual(var6.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getDefaultValue())) {
                     return true;
                  }

                  CharSequence var3 = (CharSequence)var6.getName();
                  if ((new Regex("(ap|heat|cool)submode")).matches(var3) && Intrinsics.areEqual(var6.getValue(), String.valueOf(ApSubMode.ECO.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isHeatMainMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), String.valueOf(MainMode.HEAT.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isHumMainMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var5 : var2) {
                  if (Intrinsics.areEqual(var5.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual(var5.getValue(), String.valueOf(MainMode.Humidification.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isHumMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), "true")) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isManual() {
      return !this.isAutoMode() && !this.isNightMode() && !this.isEcoMode();
   }

   public final boolean isNightMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var5.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var4 : var2) {
                  if (Intrinsics.areEqual(var4.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getInstructionName()) && Intrinsics.areEqual(var4.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getDefaultValue())) {
                     return true;
                  }

                  CharSequence var6 = (CharSequence)var4.getName();
                  if ((new Regex("(ap|heat|cool|hum)submode")).matches(var6) && Intrinsics.areEqual(var4.getValue(), String.valueOf(ApSubMode.NIGHT.getValue())) || Intrinsics.areEqual(var4.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE.getInstructionName()) && Intrinsics.areEqual(var4.getValue(), String.valueOf(Mode.NIGHT.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isSameMergedSchedules(DeviceScheduleMerged var1) {
      Intrinsics.checkNotNullParameter(var1, "other");
      Iterable var2 = (Iterable)var1.schedule;
      Collection var4 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         var4.add(((DeviceSchedule)var6.next()).getScheduleId());
      }

      List var5 = (List)var4;
      Iterable var3 = (Iterable)this.schedule;
      Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
      Iterator var10 = var3.iterator();

      while(var10.hasNext()) {
         var7.add(((DeviceSchedule)var10.next()).getScheduleId());
      }

      List var8 = (List)var7;
      if (((Collection)var5).size() == ((Collection)var8).size()) {
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            if (!var5.contains((String)var9.next())) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public final boolean isSkinMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), String.valueOf(HumSubMode.SKIN.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isSmartMainMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var5 : var2) {
                  if (Intrinsics.areEqual(var5.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName()) && Intrinsics.areEqual(var5.getValue(), String.valueOf(MainMode.SMART.getValue()))) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final boolean isStandbyMode() {
      Iterable var1 = (Iterable)this.schedule;
      if (var1 instanceof Collection && ((Collection)var1).isEmpty()) {
         return false;
      } else {
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Iterable var2 = (Iterable)((DeviceSchedule)var4.next()).getInstructions();
            if (!(var2 instanceof Collection) || !((Collection)var2).isEmpty()) {
               for(DeviceScheduleInstruction var3 : var2) {
                  if (Intrinsics.areEqual(var3.getName(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getInstructionName()) && Intrinsics.areEqual(var3.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getDefaultValue())) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public final void setDaysOfWeek(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.daysOfWeek = var1;
   }

   public final void setEndInstructions(List var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.endInstructions = var1;
   }

   public final void setEndScheduleMode(String var1) {
      this.endScheduleMode = var1;
   }

   public final void setEndTime(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.endTime = var1;
   }

   public final void setInstructions(List var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.instructions = var1;
   }

   public final void setName(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.name = var1;
   }

   public final void setPaused(boolean var1) {
      this.paused = var1;
   }

   public final void setStartTime(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.startTime = var1;
   }

   public final void setTimeZone(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.timeZone = var1;
   }

   public final Calendar timeToCalendar(String var1) {
      Intrinsics.checkNotNullParameter(var1, "time");
      List var3 = StringsKt.split$default((CharSequence)var1, new String[]{":"}, false, 0, 6, (Object)null);
      if (((Collection)var3).size() != 2) {
         return null;
      } else {
         Calendar var2 = Calendar.getInstance();
         var2.set(11, Integer.parseInt((String)var3.get(0)));
         var2.set(12, Integer.parseInt((String)var3.get(1)));
         return var2;
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceScheduleMerged(schedule=");
      var1.append(this.schedule);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      List var3 = this.schedule;
      var1.writeInt(var3.size());
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         ((DeviceSchedule)var4.next()).writeToParcel(var1, var2);
      }

   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"},
      d2 = {"Lcom/blueair/core/model/DeviceScheduleMerged$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/core/model/DeviceScheduleMerged;", "deviceSchedules", "", "Lcom/blueair/core/model/DeviceSchedule;", "core_otherRelease"},
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

      public final DeviceScheduleMerged newInstance(List var1) {
         Intrinsics.checkNotNullParameter(var1, "deviceSchedules");
         if (var1.isEmpty()) {
            return null;
         } else {
            Collection var5 = (Collection)var1;
            int var4 = var5.size();

            for(int var2 = 0; var2 < var4; ++var2) {
               int var3;
               if (var2 >= var5.size() - 1) {
                  var3 = 0;
               } else {
                  var3 = var2 + 1;
               }

               ((DeviceSchedule)var1.get(var2)).isSameTimeSchedule((DeviceSchedule)var1.get(var3));
            }

            return new DeviceScheduleMerged(var1, (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceScheduleMerged createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         int var3 = var1.readInt();
         ArrayList var4 = new ArrayList(var3);

         for(int var2 = 0; var2 != var3; ++var2) {
            var4.add(DeviceSchedule.CREATOR.createFromParcel(var1));
         }

         return new DeviceScheduleMerged((List)var4, (DefaultConstructorMarker)null);
      }

      public final DeviceScheduleMerged[] newArray(int var1) {
         return new DeviceScheduleMerged[var1];
      }
   }
}
