package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001c2\u00020\u0001:\u0015\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001cB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0014\u001d\u001e\u001f !\"#$%&'()*+,-./0¨\u00061"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "CUSTOM_NAME", "LINKED_DEVICE", "TIMEZONE", "GERM_SHIELD_MODE", "AUTO_MODE_TRIGGERS", "STANDBY_MODE", "CHILD_LOCK_MODE", "PRODUCT_INFO", "ERROR_REPORT", "DISPLAY_MODE", "TVOC", "AUTO_REFRESH", "WELCOME_HOME", "TEMPERATURE", "DRY_MODE", "USER_MANUAL", "WATER_REFRESHER", "WICK_DRY", "HOUR_FORMAT", "GERM_SHIELD_IN_NIGHT_MODE", "Companion", "Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_MODE_TRIGGERS;", "Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_REFRESH;", "Lcom/blueair/devicedetails/util/DeviceSetting$CHILD_LOCK_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$CUSTOM_NAME;", "Lcom/blueair/devicedetails/util/DeviceSetting$DISPLAY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$DRY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$ERROR_REPORT;", "Lcom/blueair/devicedetails/util/DeviceSetting$GERM_SHIELD_IN_NIGHT_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$GERM_SHIELD_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$HOUR_FORMAT;", "Lcom/blueair/devicedetails/util/DeviceSetting$LINKED_DEVICE;", "Lcom/blueair/devicedetails/util/DeviceSetting$PRODUCT_INFO;", "Lcom/blueair/devicedetails/util/DeviceSetting$STANDBY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$TEMPERATURE;", "Lcom/blueair/devicedetails/util/DeviceSetting$TIMEZONE;", "Lcom/blueair/devicedetails/util/DeviceSetting$TVOC;", "Lcom/blueair/devicedetails/util/DeviceSetting$USER_MANUAL;", "Lcom/blueair/devicedetails/util/DeviceSetting$WATER_REFRESHER;", "Lcom/blueair/devicedetails/util/DeviceSetting$WELCOME_HOME;", "Lcom/blueair/devicedetails/util/DeviceSetting$WICK_DRY;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeviceSetting {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final Lazy SETTINGS$delegate = LazyKt.lazy(new DeviceSetting$$ExternalSyntheticLambda0());
   private static final Lazy settingsToViewType$delegate = LazyKt.lazy(new DeviceSetting$$ExternalSyntheticLambda1());
   private final String name;

   // $FF: synthetic method
   public static Map $r8$lambda$YhAqHC5sRbqffaPwGhOGLiPxSBg() {
      return settingsToViewType_delegate$lambda$2();
   }

   // $FF: synthetic method
   public static List $r8$lambda$ySUgn_aMK_fleDxnmaNGcB2aS2g/* $FF was: $r8$lambda$ySUgn_aMK-fleDxnmaNGcB2aS2g*/() {
      return SETTINGS_delegate$lambda$0();
   }

   private DeviceSetting(String var1) {
      this.name = var1;
   }

   // $FF: synthetic method
   public DeviceSetting(String var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   private static final List SETTINGS_delegate$lambda$0() {
      return CollectionsKt.listOf(new DeviceSetting[]{DeviceSetting.CUSTOM_NAME.INSTANCE, DeviceSetting.LINKED_DEVICE.INSTANCE, DeviceSetting.HOUR_FORMAT.INSTANCE, DeviceSetting.TIMEZONE.INSTANCE, DeviceSetting.TEMPERATURE.INSTANCE, DeviceSetting.DRY_MODE.INSTANCE, DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE, DeviceSetting.CHILD_LOCK_MODE.INSTANCE, DeviceSetting.DISPLAY_MODE.INSTANCE, DeviceSetting.TVOC.INSTANCE, DeviceSetting.AUTO_REFRESH.INSTANCE, DeviceSetting.WICK_DRY.INSTANCE, DeviceSetting.WATER_REFRESHER.INSTANCE, DeviceSetting.WELCOME_HOME.INSTANCE, DeviceSetting.USER_MANUAL.INSTANCE, DeviceSetting.PRODUCT_INFO.INSTANCE, DeviceSetting.ERROR_REPORT.INSTANCE});
   }

   private static final Map settingsToViewType_delegate$lambda$2() {
      Iterable var2 = (Iterable)Companion.getSETTINGS();
      Collection var1 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var4 = var2.iterator();

      for(int var0 = 0; var4.hasNext(); ++var0) {
         Object var3 = var4.next();
         if (var0 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         var1.add(TuplesKt.to((DeviceSetting)var3, var0));
      }

      return MapsKt.toMap((Iterable)((List)var1));
   }

   public final String getName() {
      return this.name;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_MODE_TRIGGERS;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AUTO_MODE_TRIGGERS extends DeviceSetting {
      public static final AUTO_MODE_TRIGGERS INSTANCE = new AUTO_MODE_TRIGGERS();

      private AUTO_MODE_TRIGGERS() {
         super("auto_mode_triggers", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_REFRESH;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AUTO_REFRESH extends DeviceSetting {
      public static final AUTO_REFRESH INSTANCE = new AUTO_REFRESH();

      private AUTO_REFRESH() {
         super("auto_refresh", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$CHILD_LOCK_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CHILD_LOCK_MODE extends DeviceSetting {
      public static final CHILD_LOCK_MODE INSTANCE = new CHILD_LOCK_MODE();

      private CHILD_LOCK_MODE() {
         super("child_lock_mode", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$CUSTOM_NAME;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CUSTOM_NAME extends DeviceSetting {
      public static final CUSTOM_NAME INSTANCE = new CUSTOM_NAME();

      private CUSTOM_NAME() {
         super("custom_name", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$Companion;", "", "<init>", "()V", "SETTINGS", "", "Lcom/blueair/devicedetails/util/DeviceSetting;", "getSETTINGS", "()Ljava/util/List;", "SETTINGS$delegate", "Lkotlin/Lazy;", "settingsToViewType", "", "", "getSettingsToViewType", "()Ljava/util/Map;", "settingsToViewType$delegate", "getSupportedSettings", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final List getSETTINGS() {
         return (List)DeviceSetting.SETTINGS$delegate.getValue();
      }

      public final Map getSettingsToViewType() {
         return (Map)DeviceSetting.settingsToViewType$delegate.getValue();
      }

      public final List getSupportedSettings(Device var1) {
         Iterable var4 = (Iterable)this.getSETTINGS();
         Collection var3 = (Collection)(new ArrayList());

         for(Object var5 : var4) {
            DeviceSetting var6 = (DeviceSetting)var5;
            boolean var2;
            if (var1 != null) {
               var2 = DeviceSettingKt.supportSetting(var1, var6);
            } else {
               var2 = false;
            }

            if (var2) {
               var3.add(var5);
            }
         }

         return (List)var3;
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$DISPLAY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DISPLAY_MODE extends DeviceSetting {
      public static final DISPLAY_MODE INSTANCE = new DISPLAY_MODE();

      private DISPLAY_MODE() {
         super("display_mode", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$DRY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DRY_MODE extends DeviceSetting {
      public static final DRY_MODE INSTANCE = new DRY_MODE();

      private DRY_MODE() {
         super("dry_mode", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$ERROR_REPORT;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ERROR_REPORT extends DeviceSetting {
      public static final ERROR_REPORT INSTANCE = new ERROR_REPORT();

      private ERROR_REPORT() {
         super("error_report", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$GERM_SHIELD_IN_NIGHT_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GERM_SHIELD_IN_NIGHT_MODE extends DeviceSetting {
      public static final GERM_SHIELD_IN_NIGHT_MODE INSTANCE = new GERM_SHIELD_IN_NIGHT_MODE();

      private GERM_SHIELD_IN_NIGHT_MODE() {
         super("germ_shield_in_night_mode", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$GERM_SHIELD_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GERM_SHIELD_MODE extends DeviceSetting {
      public static final GERM_SHIELD_MODE INSTANCE = new GERM_SHIELD_MODE();

      private GERM_SHIELD_MODE() {
         super("germ_shield_mode", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$HOUR_FORMAT;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class HOUR_FORMAT extends DeviceSetting {
      public static final HOUR_FORMAT INSTANCE = new HOUR_FORMAT();

      private HOUR_FORMAT() {
         super("hour_format", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$LINKED_DEVICE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LINKED_DEVICE extends DeviceSetting {
      public static final LINKED_DEVICE INSTANCE = new LINKED_DEVICE();

      private LINKED_DEVICE() {
         super("linked_device", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$PRODUCT_INFO;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PRODUCT_INFO extends DeviceSetting {
      public static final PRODUCT_INFO INSTANCE = new PRODUCT_INFO();

      private PRODUCT_INFO() {
         super("product_info", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$STANDBY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class STANDBY_MODE extends DeviceSetting {
      public static final STANDBY_MODE INSTANCE = new STANDBY_MODE();

      private STANDBY_MODE() {
         super("standby_mode", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$TEMPERATURE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TEMPERATURE extends DeviceSetting {
      public static final TEMPERATURE INSTANCE = new TEMPERATURE();

      private TEMPERATURE() {
         super("temperature", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$TIMEZONE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TIMEZONE extends DeviceSetting {
      public static final TIMEZONE INSTANCE = new TIMEZONE();

      private TIMEZONE() {
         super("timezone", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$TVOC;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TVOC extends DeviceSetting {
      public static final TVOC INSTANCE = new TVOC();

      private TVOC() {
         super("tvoc", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$USER_MANUAL;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class USER_MANUAL extends DeviceSetting {
      public static final USER_MANUAL INSTANCE = new USER_MANUAL();

      private USER_MANUAL() {
         super("user_manual", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$WATER_REFRESHER;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WATER_REFRESHER extends DeviceSetting {
      public static final WATER_REFRESHER INSTANCE = new WATER_REFRESHER();

      private WATER_REFRESHER() {
         super("water_refresher", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$WELCOME_HOME;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WELCOME_HOME extends DeviceSetting {
      public static final WELCOME_HOME INSTANCE = new WELCOME_HOME();

      private WELCOME_HOME() {
         super("welcome_home", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$WICK_DRY;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WICK_DRY extends DeviceSetting {
      public static final WICK_DRY INSTANCE = new WICK_DRY();

      private WICK_DRY() {
         super("wick_dry", (DefaultConstructorMarker)null);
      }
   }
}
