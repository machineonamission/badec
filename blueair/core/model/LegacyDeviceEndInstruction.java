package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"},
   d2 = {"Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "", "fan_speed", "", "brightness", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFan_speed", "()Ljava/lang/String;", "getBrightness", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LegacyDeviceEndInstruction {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String brightness;
   private final String fan_speed;

   public LegacyDeviceEndInstruction() {
      this((String)null, (String)null, 3, (DefaultConstructorMarker)null);
   }

   public LegacyDeviceEndInstruction(String var1, String var2) {
      this.fan_speed = var1;
      this.brightness = var2;
   }

   // $FF: synthetic method
   public LegacyDeviceEndInstruction(String var1, String var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 1) != 0) {
         var1 = null;
      }

      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   // $FF: synthetic method
   public static LegacyDeviceEndInstruction copy$default(LegacyDeviceEndInstruction var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.fan_speed;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.brightness;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.fan_speed;
   }

   public final String component2() {
      return this.brightness;
   }

   public final LegacyDeviceEndInstruction copy(String var1, String var2) {
      return new LegacyDeviceEndInstruction(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof LegacyDeviceEndInstruction)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.fan_speed, var1.fan_speed)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.brightness, var1.brightness);
         }
      }
   }

   public final String getBrightness() {
      return this.brightness;
   }

   public final String getFan_speed() {
      return this.fan_speed;
   }

   public int hashCode() {
      String var3 = this.fan_speed;
      int var2 = 0;
      int var1;
      if (var3 == null) {
         var1 = 0;
      } else {
         var1 = var3.hashCode();
      }

      var3 = this.brightness;
      if (var3 != null) {
         var2 = var3.hashCode();
      }

      return var1 * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("LegacyDeviceEndInstruction(fan_speed=");
      var1.append(this.fan_speed);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/LegacyDeviceEndInstruction$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/core/model/LegacyDeviceEndInstruction;", "instruction", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "core_otherRelease"},
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

      public final LegacyDeviceEndInstruction newInstance(DeviceScheduleInstruction var1) {
         String var2;
         if (var1 != null) {
            var2 = var1.getValue();
         } else {
            var2 = null;
         }

         if (var2 != null) {
            var2 = var1.getName();
            if (Intrinsics.areEqual(var2, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS.getInstructionName())) {
               return new LegacyDeviceEndInstruction((String)null, var1.getValue(), 1, (DefaultConstructorMarker)null);
            }

            if (Intrinsics.areEqual(var2, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName())) {
               return new LegacyDeviceEndInstruction(var1.getValue(), (String)null, 2, (DefaultConstructorMarker)null);
            }
         }

         return null;
      }
   }
}
