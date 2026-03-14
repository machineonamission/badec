package com.blueair.devicedetails.util;

import com.blueair.core.model.AutoMode;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DevicePet20;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b'\b\u0086\u0081\u0002\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006("},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceAttribute;", "", "<init>", "(Ljava/lang/String;I)V", "SEPARATOR", "GERMSHIELD_STATUS", "STANDBY_MODE", "DISINFECTION_STATUS", "AUTO_MODE", "MANUAL_MODE", "CLEAN_AIR_ETA", "OFFLINE", "MODE_BUTTONS", "GERMSHIELD_NM", "BRIGHTNESS", "FILTER_STATUS", "TIMEZONE", "OTA", "N_HINS", "N_OFFLINE", "N_ON_OFF", "N_MODE_BUTTONS", "DRY_MODE", "AUTO_RH", "TIMER", "WICK_STATUS", "N_CLEAN_AIR_ETA", "N_FAN_SPEED", "N_BRIGHTNESS", "N_FILTER_STATUS", "N_CHILD_LOCK", "FAN_PRESET", "TARGET_TEMPERATURE", "OSCILLATION", "WATER_LEVEL", "HUM_ON_OFF", "WEIGHT", "SUB_AUTO", "DETECT_CAT", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DeviceAttribute {
   private static final EnumEntries $ENTRIES;
   private static final DeviceAttribute[] $VALUES;
   private static final DeviceAttribute[] ATTRIBUTES;
   AUTO_MODE,
   AUTO_RH,
   BRIGHTNESS,
   CLEAN_AIR_ETA;

   public static final Companion Companion;
   DETECT_CAT,
   DISINFECTION_STATUS,
   DRY_MODE,
   FAN_PRESET,
   FILTER_STATUS,
   GERMSHIELD_NM,
   GERMSHIELD_STATUS,
   HUM_ON_OFF,
   MANUAL_MODE,
   MODE_BUTTONS,
   N_BRIGHTNESS,
   N_CHILD_LOCK,
   N_CLEAN_AIR_ETA,
   N_FAN_SPEED,
   N_FILTER_STATUS,
   N_HINS,
   N_MODE_BUTTONS,
   N_OFFLINE,
   N_ON_OFF,
   OFFLINE,
   OSCILLATION,
   OTA,
   SEPARATOR,
   STANDBY_MODE,
   SUB_AUTO,
   TARGET_TEMPERATURE,
   TIMER,
   TIMEZONE,
   WATER_LEVEL,
   WEIGHT,
   WICK_STATUS;

   private static boolean showDetectCat;

   // $FF: synthetic method
   private static final DeviceAttribute[] $values() {
      return new DeviceAttribute[]{SEPARATOR, GERMSHIELD_STATUS, STANDBY_MODE, DISINFECTION_STATUS, AUTO_MODE, MANUAL_MODE, CLEAN_AIR_ETA, OFFLINE, MODE_BUTTONS, GERMSHIELD_NM, BRIGHTNESS, FILTER_STATUS, TIMEZONE, OTA, N_HINS, N_OFFLINE, N_ON_OFF, N_MODE_BUTTONS, DRY_MODE, AUTO_RH, TIMER, WICK_STATUS, N_CLEAN_AIR_ETA, N_FAN_SPEED, N_BRIGHTNESS, N_FILTER_STATUS, N_CHILD_LOCK, FAN_PRESET, TARGET_TEMPERATURE, OSCILLATION, WATER_LEVEL, HUM_ON_OFF, WEIGHT, SUB_AUTO, DETECT_CAT};
   }

   static {
      DeviceAttribute[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
      ATTRIBUTES = values();
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   @Metadata(
      d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fJ\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\fH\u0002J6\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceAttribute$Companion;", "", "<init>", "()V", "showDetectCat", "", "getShowDetectCat", "()Z", "setShowDetectCat", "(Z)V", "ATTRIBUTES", "", "Lcom/blueair/devicedetails/util/DeviceAttribute;", "getATTRIBUTES", "()[Lcom/blueair/devicedetails/util/DeviceAttribute;", "[Lcom/blueair/devicedetails/util/DeviceAttribute;", "getSupportedAttributes", "", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "legacyWithSensorsAttributeCheck", "autoMode", "Lcom/blueair/core/model/AutoMode;", "attribute", "offlineAttributeCheck", "otaAttributeCheck", "checkConnectivityStatus", "setOnline", "Lkotlin/Function0;", "setOta", "devicedetails_otherRelease"},
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
      public static boolean checkConnectivityStatus$default(Companion var0, Device var1, DeviceAttribute var2, Function0 var3, Function0 var4, int var5, Object var6) {
         if ((var5 & 8) != 0) {
            var4 = null;
         }

         return var0.checkConnectivityStatus(var1, var2, var3, var4);
      }

      // $FF: synthetic method
      public static List getSupportedAttributes$default(Companion var0, Device var1, boolean var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = false;
         }

         return var0.getSupportedAttributes(var1, var2);
      }

      private final boolean offlineAttributeCheck(DeviceAttribute var1) {
         return DeviceAttribute.Companion.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 4;
      }

      private final boolean otaAttributeCheck(DeviceAttribute var1) {
         return DeviceAttribute.Companion.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 5;
      }

      public final boolean checkConnectivityStatus(Device var1, DeviceAttribute var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var2, "attribute");
         Intrinsics.checkNotNullParameter(var3, "setOnline");
         ConnectivityStatus var6 = var1.getConnectivityStatus();
         int var5 = DeviceAttribute.Companion.WhenMappings.$EnumSwitchMapping$1[var6.ordinal()];
         if (var5 != 1) {
            if (var5 != 2) {
               return this.offlineAttributeCheck(var2);
            } else {
               return var4 != null ? (Boolean)var4.invoke() : this.otaAttributeCheck(var2);
            }
         } else {
            return (Boolean)var3.invoke();
         }
      }

      public final DeviceAttribute[] getATTRIBUTES() {
         return DeviceAttribute.ATTRIBUTES;
      }

      public final boolean getShowDetectCat() {
         return DeviceAttribute.showDetectCat;
      }

      public final List getSupportedAttributes(Device var1, boolean var2) {
         DeviceAttribute[] var8 = this.getATTRIBUTES();
         Collection var6 = (Collection)(new ArrayList());

         for(DeviceAttribute var7 : var8) {
            boolean var5;
            if (var1 != null) {
               var5 = DeviceAttributeKt.access$supportAttribute(var1, var7, var2);
            } else {
               var5 = false;
            }

            if (var5) {
               var6.add(var7);
            }
         }

         List var13 = (List)var6;
         if (var1 instanceof DevicePet20) {
            Iterable var20 = (Iterable)CollectionsKt.listOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_ON_OFF, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.TIMER, DeviceAttribute.DETECT_CAT, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.N_FILTER_STATUS});
            Collection var12 = (Collection)(new ArrayList());

            for(Object var25 : var20) {
               if (var13.contains((DeviceAttribute)var25)) {
                  var12.add(var25);
               }
            }

            return (List)var12;
         } else if (var1 instanceof DeviceCombo2in1) {
            Iterable var18 = (Iterable)CollectionsKt.listOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_ON_OFF, DeviceAttribute.HUM_ON_OFF, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.DRY_MODE, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.AUTO_RH, DeviceAttribute.TIMER, DeviceAttribute.WATER_LEVEL, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.N_FILTER_STATUS, DeviceAttribute.WICK_STATUS});
            Collection var11 = (Collection)(new ArrayList());

            for(Object var19 : var18) {
               if (var13.contains((DeviceAttribute)var19)) {
                  var11.add(var19);
               }
            }

            return (List)var11;
         } else if (var1 instanceof DeviceCombo3in1) {
            Iterable var16 = (Iterable)CollectionsKt.listOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_ON_OFF, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.FAN_PRESET, DeviceAttribute.TARGET_TEMPERATURE, DeviceAttribute.OSCILLATION, DeviceAttribute.TIMER, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.N_FILTER_STATUS});
            Collection var10 = (Collection)(new ArrayList());

            for(Object var17 : var16) {
               if (var13.contains((DeviceAttribute)var17)) {
                  var10.add(var17);
               }
            }

            return (List)var10;
         } else if (var1 instanceof DeviceHumidifier) {
            Iterable var14 = (Iterable)CollectionsKt.listOf(new DeviceAttribute[]{DeviceAttribute.N_OFFLINE, DeviceAttribute.N_MODE_BUTTONS, DeviceAttribute.DRY_MODE, DeviceAttribute.N_FAN_SPEED, DeviceAttribute.AUTO_RH, DeviceAttribute.TIMER, DeviceAttribute.N_BRIGHTNESS, DeviceAttribute.N_CHILD_LOCK, DeviceAttribute.WICK_STATUS});
            Collection var9 = (Collection)(new ArrayList());

            for(Object var15 : var14) {
               if (var13.contains((DeviceAttribute)var15)) {
                  var9.add(var15);
               }
            }

            return (List)var9;
         } else {
            return var13;
         }
      }

      public final boolean legacyWithSensorsAttributeCheck(AutoMode var1, DeviceAttribute var2) {
         Intrinsics.checkNotNullParameter(var1, "autoMode");
         Intrinsics.checkNotNullParameter(var2, "attribute");
         if (var1 == AutoMode.ON) {
            int var4 = DeviceAttribute.Companion.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
            return var4 == 1 || var4 == 2;
         } else {
            int var3 = DeviceAttribute.Companion.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
            return var3 == 2 || var3 == 3;
         }
      }

      public final void setShowDetectCat(boolean var1) {
         DeviceAttribute.showDetectCat = var1;
      }

      // $FF: synthetic class
      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WhenMappings {
         public static final int[] $EnumSwitchMapping$0;
         public static final int[] $EnumSwitchMapping$1;

         static {
            int[] var0 = new int[DeviceAttribute.values().length];

            try {
               var0[DeviceAttribute.AUTO_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError var8) {
            }

            try {
               var0[DeviceAttribute.MODE_BUTTONS.ordinal()] = 2;
            } catch (NoSuchFieldError var7) {
            }

            try {
               var0[DeviceAttribute.MANUAL_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError var6) {
            }

            try {
               var0[DeviceAttribute.OFFLINE.ordinal()] = 4;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[DeviceAttribute.OTA.ordinal()] = 5;
            } catch (NoSuchFieldError var4) {
            }

            $EnumSwitchMapping$0 = var0;
            var0 = new int[ConnectivityStatus.values().length];

            try {
               var0[ConnectivityStatus.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[ConnectivityStatus.UPDATING.ordinal()] = 2;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$1 = var0;
         }
      }
   }
}
