package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\b\u0086\u0081\u0002\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00061"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceControl;", "", "group", "Lcom/blueair/devicedetails/util/DeviceControlGroup;", "<init>", "(Ljava/lang/String;ILcom/blueair/devicedetails/util/DeviceControlGroup;)V", "getGroup", "()Lcom/blueair/devicedetails/util/DeviceControlGroup;", "OFFLINE", "MSG_FILTER_DOOR_OPEN", "MSG_FRONT_PANEL_OPEN", "MSG_TOP_PART_DISPLACED", "MSG_WATER_TANK_FULL", "MSG_WATER_TANK_FAILURE", "MSG_WATER_TANK_SHORTAGE", "MAIN_MODES_DEHUM", "MODE_HUMIDIFICATION", "MAIN_MODES_COMBO3IN1", "MODE_BUTTONS", "SKIN_HINT", "SMART_HINT", "HEATING_HINT", "CANT_HEAT_HINT", "FAN_SPEED", "OSCILLATION", "TARGET_TEMPERATURE", "TARGET_HUM", "AUTO_LEVEL", "WICK_DRYING", "NIGHT_SLEEP", "AUTO_REFRESH", "AUTO_DRY", "DISINFECTION", "GERM_SHIELD_NIGHT", "GERM_SHIELD", "HINS_PURE_NIGHT", "HINS_PURE", "DUAL_OSCILLATION", "SCHEDULE", "MOOD_LAMP", "NIGHT_LAMP", "ALARMS", "BRIGHTNESS", "FILTER", "WICK", "REFRESHER", "TIMER", "SETTINGS", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DeviceControl {
   private static final EnumEntries $ENTRIES;
   private static final DeviceControl[] $VALUES;
   ALARMS(DeviceControlGroup.SCHEDULE),
   AUTO_DRY(DeviceControlGroup.SCHEDULE),
   AUTO_LEVEL(DeviceControlGroup.CONTROL),
   AUTO_REFRESH(DeviceControlGroup.SCHEDULE),
   BRIGHTNESS(DeviceControlGroup.FILTER),
   CANT_HEAT_HINT(DeviceControlGroup.MODE);

   public static final Companion Companion;
   DISINFECTION(DeviceControlGroup.SCHEDULE),
   DUAL_OSCILLATION(DeviceControlGroup.SCHEDULE),
   FAN_SPEED(DeviceControlGroup.CONTROL),
   FILTER(DeviceControlGroup.FILTER),
   GERM_SHIELD(DeviceControlGroup.SCHEDULE),
   GERM_SHIELD_NIGHT(DeviceControlGroup.SCHEDULE),
   HEATING_HINT(DeviceControlGroup.MODE),
   HINS_PURE(DeviceControlGroup.SCHEDULE),
   HINS_PURE_NIGHT(DeviceControlGroup.SCHEDULE),
   MAIN_MODES_COMBO3IN1(DeviceControlGroup.MODE),
   MAIN_MODES_DEHUM(DeviceControlGroup.MODE),
   MODE_BUTTONS(DeviceControlGroup.MODE),
   MODE_HUMIDIFICATION(DeviceControlGroup.MODE),
   MOOD_LAMP(DeviceControlGroup.SCHEDULE),
   MSG_FILTER_DOOR_OPEN(DeviceControlGroup.MODE),
   MSG_FRONT_PANEL_OPEN(DeviceControlGroup.MODE),
   MSG_TOP_PART_DISPLACED(DeviceControlGroup.MODE),
   MSG_WATER_TANK_FAILURE(DeviceControlGroup.MODE),
   MSG_WATER_TANK_FULL(DeviceControlGroup.MODE),
   MSG_WATER_TANK_SHORTAGE(DeviceControlGroup.MODE),
   NIGHT_LAMP(DeviceControlGroup.SCHEDULE),
   NIGHT_SLEEP(DeviceControlGroup.SCHEDULE),
   OFFLINE(DeviceControlGroup.MESSAGE),
   OSCILLATION(DeviceControlGroup.CONTROL),
   REFRESHER(DeviceControlGroup.FILTER),
   SCHEDULE(DeviceControlGroup.SCHEDULE),
   SETTINGS(DeviceControlGroup.FILTER),
   SKIN_HINT(DeviceControlGroup.MODE),
   SMART_HINT(DeviceControlGroup.MODE),
   TARGET_HUM(DeviceControlGroup.CONTROL),
   TARGET_TEMPERATURE(DeviceControlGroup.CONTROL),
   TIMER(DeviceControlGroup.FILTER),
   WICK(DeviceControlGroup.FILTER),
   WICK_DRYING(DeviceControlGroup.LIGHT);

   private final DeviceControlGroup group;

   // $FF: synthetic method
   private static final DeviceControl[] $values() {
      return new DeviceControl[]{OFFLINE, MSG_FILTER_DOOR_OPEN, MSG_FRONT_PANEL_OPEN, MSG_TOP_PART_DISPLACED, MSG_WATER_TANK_FULL, MSG_WATER_TANK_FAILURE, MSG_WATER_TANK_SHORTAGE, MAIN_MODES_DEHUM, MODE_HUMIDIFICATION, MAIN_MODES_COMBO3IN1, MODE_BUTTONS, SKIN_HINT, SMART_HINT, HEATING_HINT, CANT_HEAT_HINT, FAN_SPEED, OSCILLATION, TARGET_TEMPERATURE, TARGET_HUM, AUTO_LEVEL, WICK_DRYING, NIGHT_SLEEP, AUTO_REFRESH, AUTO_DRY, DISINFECTION, GERM_SHIELD_NIGHT, GERM_SHIELD, HINS_PURE_NIGHT, HINS_PURE, DUAL_OSCILLATION, SCHEDULE, MOOD_LAMP, NIGHT_LAMP, ALARMS, BRIGHTNESS, FILTER, WICK, REFRESHER, TIMER, SETTINGS};
   }

   static {
      DeviceControl[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private DeviceControl(DeviceControlGroup var3) {
      this.group = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final DeviceControlGroup getGroup() {
      return this.group;
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceControl$Companion;", "", "<init>", "()V", "getSupportedControls", "", "Lcom/blueair/devicedetails/util/DeviceControl;", "device", "Lcom/blueair/core/model/Device;", "group", "Lcom/blueair/devicedetails/util/DeviceControlGroup;", "forceOffline", "", "devicedetails_otherRelease"},
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
      public static List getSupportedControls$default(Companion var0, Device var1, DeviceControlGroup var2, boolean var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = false;
         }

         return var0.getSupportedControls(var1, var2, var3);
      }

      public final List getSupportedControls(Device var1, DeviceControlGroup var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var2, "group");
         if (var1 == null) {
            return CollectionsKt.emptyList();
         } else {
            Iterable var5 = (Iterable)DeviceControl.getEntries();
            Collection var4 = (Collection)(new ArrayList());

            for(Object var7 : var5) {
               DeviceControl var8 = (DeviceControl)var7;
               if (var8.getGroup() == var2 && DeviceControlKt.access$supportControl(var1, var8, var3)) {
                  var4.add(var7);
               }
            }

            return (List)var4;
         }
      }
   }
}
