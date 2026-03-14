package com.blueair.adddevice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u00039:;B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0007H\u0007J\u0010\u00101\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0010\u00103\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u0010\u00104\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u000e\u00105\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0007J\u0010\u00106\u001a\u0002022\u0006\u0010.\u001a\u00020\u0007H\u0007J\u000e\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006<"},
   d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy;", "", "<init>", "()V", "UNKNOWN", "", "DEVICE_COMPATIBILITY_UNKNOWN", "", "DEVICE_COMPATIBILITY_AWARE", "DEVICE_COMPATIBILITY_SENSE", "DEVICE_COMPATIBILITY_CLASSIC", "DEVICE_COMPATIBILITY_CLASSIC_205", "DEVICE_COMPATIBILITY_CLASSIC_205S", "DEVICE_COMPATIBILITY_CLASSIC_305", "DEVICE_COMPATIBILITY_CLASSIC_405", "DEVICE_COMPATIBILITY_CLASSIC_405S", "DEVICE_COMPATIBILITY_CLASSIC_505", "DEVICE_COMPATIBILITY_CLASSIC_605", "DEVICE_COMPATIBILITY_CLASSIC_605S", "DEVICE_COMPATIBILITY_CLASSIC_260", "DEVICE_COMPATIBILITY_CLASSIC_260i", "DEVICE_COMPATIBILITY_CLASSIC_280i", "DEVICE_COMPATIBILITY_CLASSIC_290i", "DEVICE_COMPATIBILITY_CLASSIC_460", "DEVICE_COMPATIBILITY_CLASSIC_460i", "DEVICE_COMPATIBILITY_CLASSIC_480i", "DEVICE_COMPATIBILITY_CLASSIC_490i", "DEVICE_COMPATIBILITY_CLASSIC_560", "DEVICE_COMPATIBILITY_CLASSIC_580i", "DEVICE_COMPATIBILITY_CLASSIC_660", "DEVICE_COMPATIBILITY_CLASSIC_680i", "DEVICE_COMPATIBILITY_CLASSIC_690i", "DEVICE_COMPATIBILITY_CLASSIC_380i", "DEVICE_COMPATIBILITY_ICP", "DEVICE_COMPATIBILITY_STRING_ICP", "AWARE_CONFIG_SSID", "SENSE_CONFIG_SSID", "CLASSIC_CONFIG_SSID", "EMUALTOR_SSID", "DEVICE_CONFIG_MODE_AUTO", "DEVICE_CONFIG_MODE_MANUAL", "getDeviceCompatibilityFromModel", "model", "castDeviceCompatibility", "code", "getDeviceModelNameForDisplay", "deviceCompatibilityType", "getDeviceCompatibilityForBackend", "deviceCompatilityType", "isClassicWithoutSensorBoard", "", "isClassicWithSensorBoard", "isClassic", "getManualModeWiFiSSID", "isUnknown", "isManualDeviceNetwork", "ssid", "CompatibilityType", "ConfigurationMode", "AddDeviceBackendException", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceUtilsLegacy {
   public static final String AWARE_CONFIG_SSID = "aware-config";
   public static final String CLASSIC_CONFIG_SSID = "classic-config";
   public static final int DEVICE_COMPATIBILITY_AWARE = 1;
   public static final int DEVICE_COMPATIBILITY_CLASSIC = 3;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_205 = 4;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_205S = 5;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_260 = 12;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_260i = 13;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_280i = 14;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_290i = 15;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_305 = 6;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_380i = 25;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_405 = 7;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_405S = 8;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_460 = 16;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_460i = 17;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_480i = 18;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_490i = 19;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_505 = 9;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_560 = 20;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_580i = 21;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_605 = 10;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_605S = 11;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_660 = 22;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_680i = 23;
   public static final int DEVICE_COMPATIBILITY_CLASSIC_690i = 24;
   public static final int DEVICE_COMPATIBILITY_ICP = 40;
   public static final int DEVICE_COMPATIBILITY_SENSE = 2;
   public static final String DEVICE_COMPATIBILITY_STRING_ICP = "icp_p2i";
   public static final int DEVICE_COMPATIBILITY_UNKNOWN = 0;
   public static final int DEVICE_CONFIG_MODE_AUTO = 0;
   public static final int DEVICE_CONFIG_MODE_MANUAL = 1;
   public static final String EMUALTOR_SSID = "WiredSSID";
   public static final DeviceUtilsLegacy INSTANCE = new DeviceUtilsLegacy();
   public static final String SENSE_CONFIG_SSID = "sense-config";
   public static final String UNKNOWN = "Unknown";

   private DeviceUtilsLegacy() {
   }

   @JvmStatic
   public static final int castDeviceCompatibility(int var0) {
      if (var0 != 40) {
         switch (var0) {
            case 1:
               return 1;
            case 2:
               return 2;
            case 3:
               return 3;
            case 4:
               return 4;
            case 5:
               return 5;
            case 6:
               return 6;
            case 7:
               return 7;
            case 8:
               return 8;
            case 9:
               return 9;
            case 10:
               return 10;
            case 11:
               return 11;
            case 12:
               return 12;
            case 13:
               return 13;
            case 14:
               return 14;
            case 15:
               return 15;
            case 16:
               return 16;
            case 17:
               return 17;
            case 18:
               return 18;
            case 19:
               return 19;
            case 20:
               return 20;
            case 21:
               return 21;
            case 22:
               return 22;
            case 23:
               return 23;
            case 24:
               return 24;
            case 25:
               return 25;
            default:
               return 0;
         }
      } else {
         return 40;
      }
   }

   @JvmStatic
   public static final String getDeviceCompatibilityForBackend(int var0) {
      if (var0 != 40) {
         switch (var0) {
            case 1:
               return "aware";
            case 2:
               return "sense+";
            case 3:
               return "classic";
            case 4:
               return "classic_205";
            case 5:
               return "classic_205S";
            case 6:
               return "classic_305";
            case 7:
               return "classic_405";
            case 8:
               return "classic_405S";
            case 9:
               return "classic_505";
            case 10:
               return "classic_605";
            case 11:
               return "classic_605S";
            case 12:
               return "classic_260";
            case 13:
               return "classic_260i";
            case 14:
               return "classic_280i";
            case 15:
               return "classic_290i";
            case 16:
               return "classic_460";
            case 17:
               return "classic_460i";
            case 18:
               return "classic_480i";
            case 19:
               return "classic_490i";
            case 20:
               return "classic_560";
            case 21:
               return "classic_580i";
            case 22:
               return "classic_660";
            case 23:
               return "classic_680i";
            case 24:
               return "classic_690i";
            case 25:
               return "classic_380i";
            default:
               return "unknown";
         }
      } else {
         return "icp_p2i";
      }
   }

   @JvmStatic
   public static final int getDeviceCompatibilityFromModel(String var0) {
      if (var0 == null) {
         return 0;
      } else {
         switch (var0) {
            case "sense+":
               return 2;
            case "classic_205":
               return 4;
            case "classic_260":
               return 12;
            case "classic_305":
               return 6;
            case "classic_405":
               return 7;
            case "classic_460":
               return 16;
            case "classic_505":
               return 9;
            case "classic_560":
               return 20;
            case "classic_605":
               return 10;
            case "classic_660":
               return 22;
            case "classic_205S":
               return 5;
            case "classic_260i":
               return 13;
            case "classic_280i":
               return 14;
            case "classic_290i":
               return 15;
            case "classic_380i":
               return 25;
            case "classic_405S":
               return 8;
            case "classic_460i":
               return 17;
            case "classic_480i":
               return 18;
            case "classic_490i":
               return 19;
            case "classic_580i":
               return 21;
            case "classic_605S":
               return 11;
            case "classic_680i":
               return 23;
            case "classic_690i":
               return 24;
            case "aware":
               return 1;
            case "classic":
               return 3;
            case "icp_p2i":
               return 40;
         }

         return 0;
      }
   }

   @JvmStatic
   public static final String getDeviceModelNameForDisplay(int var0) {
      switch (var0) {
         case 1:
            return "Aware";
         case 2:
            return "Sense+";
         case 3:
            return "Classic";
         case 4:
            return "Classic 205";
         case 5:
            return "Classic 205S";
         case 6:
            return "Classic 305";
         case 7:
            return "Classic 405";
         case 8:
            return "Classic 405S";
         case 9:
            return "Classic 505";
         case 10:
            return "Classic 605";
         case 11:
            return "Classic 605S";
         case 12:
            return "Classic 260";
         case 13:
            return "Classic 260i";
         case 14:
            return "Classic 280i";
         case 15:
            return "Classic 290i";
         case 16:
            return "Classic 460";
         case 17:
            return "Classic 460i";
         case 18:
            return "Classic 480i";
         case 19:
            return "Classic 490i";
         case 20:
            return "Classic 560";
         case 21:
            return "Classic 580i";
         case 22:
            return "Classic 660";
         case 23:
            return "Classic 680i";
         case 24:
            return "Classic 690i";
         case 25:
            return "Classic 380i";
         default:
            return "Unknown";
      }
   }

   @JvmStatic
   public static final boolean isClassic(int var0) {
      return isClassicWithoutSensorBoard(var0) || isClassicWithSensorBoard(var0);
   }

   @JvmStatic
   public static final boolean isClassicWithSensorBoard(int var0) {
      return var0 == 13 || var0 == 14 || var0 == 15 || var0 == 17 || var0 == 18 || var0 == 19 || var0 == 21 || var0 == 23 || var0 == 24 || var0 == 5 || var0 == 8 || var0 == 11 || var0 == 25;
   }

   @JvmStatic
   public static final boolean isClassicWithoutSensorBoard(int var0) {
      return var0 == 3 || var0 == 4 || var0 == 6 || var0 == 7 || var0 == 9 || var0 == 10 || var0 == 12 || var0 == 16 || var0 == 20 || var0 == 22;
   }

   @JvmStatic
   public static final boolean isUnknown(int var0) {
      return var0 == 0;
   }

   public final String getManualModeWiFiSSID(int var1) {
      if (var1 == 1) {
         return "aware-config";
      } else if (var1 == 2) {
         return "sense-config";
      } else {
         return isClassic(var1) ? "classic-config" : "";
      }
   }

   public final boolean isManualDeviceNetwork(String var1) {
      Intrinsics.checkNotNullParameter(var1, "ssid");
      return Intrinsics.areEqual(var1, "aware-config") || Intrinsics.areEqual(var1, "sense-config") || Intrinsics.areEqual(var1, "classic-config");
   }

   @Metadata(
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy$AddDeviceBackendException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "uiMessage", "", "<init>", "(Ljava/lang/String;)V", "getUiMessage", "()Ljava/lang/String;", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AddDeviceBackendException extends RuntimeException {
      private final String uiMessage;

      public AddDeviceBackendException(String var1) {
         Intrinsics.checkNotNullParameter(var1, "uiMessage");
         super(var1);
         this.uiMessage = var1;
      }

      public final String getUiMessage() {
         return this.uiMessage;
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   @Metadata(
      d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"},
      d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy$CompatibilityType;", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
   public @interface CompatibilityType {
   }

   @Retention(RetentionPolicy.SOURCE)
   @Metadata(
      d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"},
      d2 = {"Lcom/blueair/adddevice/DeviceUtilsLegacy$ConfigurationMode;", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
   public @interface ConfigurationMode {
   }
}
