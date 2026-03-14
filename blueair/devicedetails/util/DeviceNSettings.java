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

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceNSettings;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM_NAME", "TIME_ZONE", "TEMPERATURE", "DRY_MODE", "TRIGGER_AUTO", "TRIGGER_NIGHT", "PRODUCT_INFO", "SYSTEM_INFO", "DELETE", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DeviceNSettings {
   private static final EnumEntries $ENTRIES;
   private static final DeviceNSettings[] $VALUES;
   CUSTOM_NAME;

   public static final Companion Companion;
   DELETE,
   DRY_MODE,
   PRODUCT_INFO,
   SYSTEM_INFO,
   TEMPERATURE,
   TIME_ZONE,
   TRIGGER_AUTO,
   TRIGGER_NIGHT;

   // $FF: synthetic method
   private static final DeviceNSettings[] $values() {
      return new DeviceNSettings[]{CUSTOM_NAME, TIME_ZONE, TEMPERATURE, DRY_MODE, TRIGGER_AUTO, TRIGGER_NIGHT, PRODUCT_INFO, SYSTEM_INFO, DELETE};
   }

   static {
      DeviceNSettings[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceNSettings$Companion;", "", "<init>", "()V", "getSupportedSettings", "", "Lcom/blueair/devicedetails/util/DeviceNSettings;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final List getSupportedSettings(Device var1) {
         if (var1 == null) {
            return CollectionsKt.emptyList();
         } else {
            DeviceNSettings[] var5 = DeviceNSettings.values();
            Collection var4 = (Collection)(new ArrayList());

            for(DeviceNSettings var6 : var5) {
               if (DeviceNSettingsKt.supportSetting(var1, var6)) {
                  var4.add(var6);
               }
            }

            return (List)var4;
         }
      }
   }
}
