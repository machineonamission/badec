package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001d"},
   d2 = {"Lcom/blueair/core/model/DeviceScheduleInstruction;", "Landroid/os/Parcelable;", "name", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "toBlueScheduleInstruction", "Lcom/blueair/core/model/ScheduleMode;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleInstruction implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String name;
   private final String value;

   public DeviceScheduleInstruction(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "name");
      Intrinsics.checkNotNullParameter(var2, "value");
      super();
      this.name = var1;
      this.value = var2;
   }

   // $FF: synthetic method
   public static DeviceScheduleInstruction copy$default(DeviceScheduleInstruction var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.value;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.name;
   }

   public final String component2() {
      return this.value;
   }

   public final DeviceScheduleInstruction copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "name");
      Intrinsics.checkNotNullParameter(var2, "value");
      return new DeviceScheduleInstruction(var1, var2);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceScheduleInstruction)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }
   }

   public final String getName() {
      return this.name;
   }

   public final String getValue() {
      return this.value;
   }

   public int hashCode() {
      return this.name.hashCode() * 31 + this.value.hashCode();
   }

   public final ScheduleMode toBlueScheduleInstruction() {
      Integer var1 = StringsKt.toIntOrNull(this.value);
      return var1 == null ? new ScheduleMode(this.name, (Integer)null, Boolean.parseBoolean(this.value), 2, (DefaultConstructorMarker)null) : new ScheduleMode(this.name, var1, (Boolean)null, 4, (DefaultConstructorMarker)null);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceScheduleInstruction(name=");
      var1.append(this.name);
      var1.append(", value=");
      var1.append(this.value);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.name);
      var1.writeString(this.value);
   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0006\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0013"},
      d2 = {"Lcom/blueair/core/model/DeviceScheduleInstruction$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "instruction", "Lcom/blueair/core/model/DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType;", "value", "", "fromLegacy", "Lcom/blueair/core/model/LegacyDeviceScheduleInstruction;", "fromLegacyToEndInstruction", "", "Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "fromBlueDeviceSchedule", "scheduleMode", "Lcom/blueair/core/model/ScheduleMode;", "DeviceScheduleInstructionType", "core_otherRelease"},
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

      public final DeviceScheduleInstruction fromBlueDeviceSchedule(ScheduleMode var1) {
         if (var1 != null) {
            String var4 = var1.getN();
            Integer var3 = var1.getV();
            Object var2 = var3;
            if (var3 == null) {
               var2 = var1.getVb();
            }

            return new DeviceScheduleInstruction(var4, String.valueOf(var2));
         } else {
            return null;
         }
      }

      public final DeviceScheduleInstruction fromLegacy(LegacyDeviceScheduleInstruction var1) {
         Intrinsics.checkNotNullParameter(var1, "instruction");
         return new DeviceScheduleInstruction(var1.getAttrName(), var1.getAttrValue());
      }

      public final List fromLegacyToEndInstruction(LegacyDeviceEndInstruction var1) {
         Intrinsics.checkNotNullParameter(var1, "instruction");
         List var2 = (List)(new ArrayList());
         if (var1.getBrightness() != null) {
            var2.add(new DeviceScheduleInstruction(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS.getInstructionName(), var1.getBrightness()));
         }

         if (var1.getFan_speed() != null) {
            var2.add(new DeviceScheduleInstruction(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName(), var1.getFan_speed()));
         }

         return var2;
      }

      public final DeviceScheduleInstruction newInstance(DeviceScheduleInstructionType var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "instruction");
         Intrinsics.checkNotNullParameter(var2, "value");
         return new DeviceScheduleInstruction(var1.getInstructionName(), var2);
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"},
         d2 = {"Lcom/blueair/core/model/DeviceScheduleInstruction$Companion$DeviceScheduleInstructionType;", "", "instructionName", "", "defaultValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getInstructionName", "()Ljava/lang/String;", "getDefaultValue", "LEGACY_MODE", "LEGACY_FAN_SPEED", "LEGACY_BRIGHTNESS", "AUTO_MODE", "AUTO_RH", "NIGHTMODE", "BRIGHTNESS", "FAN_SPEED", "STANDBY", "DISINFECTION", "ECO", "MAIN_MODE", "AP_SUB_MODE", "SMART_SUB_MODE", "HEAT_SUB_MODE", "COOL_SUB_MODE", "AP_FAN_SPEED", "HEAT_FAN_SPEED", "COOL_FAN_SPEED", "HEAT_AUTO_TMP", "HEAT_ECO_TMP", "OSCILLATION_STATE", "MODE", "HUM_MODE", "DEH_SUB_MODE", "HUM_SUB_MODE", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static enum DeviceScheduleInstructionType {
         private static final EnumEntries $ENTRIES;
         private static final DeviceScheduleInstructionType[] $VALUES;
         AP_FAN_SPEED("fsp0", "11"),
         AP_SUB_MODE("apsubmode", "2"),
         AUTO_MODE("automode", "true"),
         AUTO_RH("autorh", "50"),
         BRIGHTNESS("ledbrightness", "1"),
         COOL_FAN_SPEED("coolfs", "11"),
         COOL_SUB_MODE("coolsubmode", "2"),
         DEH_SUB_MODE("dehsubmode", "1"),
         DISINFECTION("disinfection", "true"),
         ECO("eco", "true"),
         FAN_SPEED("fanspeed", "1"),
         HEAT_AUTO_TMP("heattemp", "22"),
         HEAT_ECO_TMP("ecoheattemp", "22"),
         HEAT_FAN_SPEED("heatfs", "11"),
         HEAT_SUB_MODE("heatsubmode", "2"),
         HUM_MODE("hummode", "true"),
         HUM_SUB_MODE("humsubmode", "2"),
         LEGACY_BRIGHTNESS("brightness", "1"),
         LEGACY_FAN_SPEED("fan_speed", "1"),
         LEGACY_MODE("mode", "auto"),
         MAIN_MODE("mainmode", "0"),
         MODE("mode", "2"),
         NIGHTMODE("nightmode", "true"),
         OSCILLATION_STATE("oscstate", "0"),
         SMART_SUB_MODE("smartsubmode", "0"),
         STANDBY("standby", "true");

         private final String defaultValue;
         private final String instructionName;

         // $FF: synthetic method
         private static final DeviceScheduleInstructionType[] $values() {
            return new DeviceScheduleInstructionType[]{LEGACY_MODE, LEGACY_FAN_SPEED, LEGACY_BRIGHTNESS, AUTO_MODE, AUTO_RH, NIGHTMODE, BRIGHTNESS, FAN_SPEED, STANDBY, DISINFECTION, ECO, MAIN_MODE, AP_SUB_MODE, SMART_SUB_MODE, HEAT_SUB_MODE, COOL_SUB_MODE, AP_FAN_SPEED, HEAT_FAN_SPEED, COOL_FAN_SPEED, HEAT_AUTO_TMP, HEAT_ECO_TMP, OSCILLATION_STATE, MODE, HUM_MODE, DEH_SUB_MODE, HUM_SUB_MODE};
         }

         static {
            DeviceScheduleInstructionType[] var0 = $values();
            $VALUES = var0;
            $ENTRIES = EnumEntriesKt.enumEntries(var0);
         }

         private DeviceScheduleInstructionType(String var3, String var4) {
            this.instructionName = var3;
            this.defaultValue = var4;
         }

         public static EnumEntries getEntries() {
            return $ENTRIES;
         }

         public final String getDefaultValue() {
            return this.defaultValue;
         }

         public final String getInstructionName() {
            return this.instructionName;
         }
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceScheduleInstruction createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new DeviceScheduleInstruction(var1.readString(), var1.readString());
      }

      public final DeviceScheduleInstruction[] newArray(int var1) {
         return new DeviceScheduleInstruction[var1];
      }
   }
}
