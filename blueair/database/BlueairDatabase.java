package com.blueair.database;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.blueair.database.dao.AqiDataDao;
import com.blueair.database.dao.DeviceDao;
import com.blueair.database.dao.DeviceDataDao;
import com.blueair.database.dao.DeviceScheduleDao;
import com.blueair.database.dao.NotificationDao;
import com.blueair.database.dao.TrackedLocationDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"},
   d2 = {"Lcom/blueair/database/BlueairDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "deviceDao", "Lcom/blueair/database/dao/DeviceDao;", "deviceDataDao", "Lcom/blueair/database/dao/DeviceDataDao;", "trackedLocationDao", "Lcom/blueair/database/dao/TrackedLocationDao;", "aqiDataDao", "Lcom/blueair/database/dao/AqiDataDao;", "deviceScheduleDao", "Lcom/blueair/database/dao/DeviceScheduleDao;", "notificationDao", "Lcom/blueair/database/dao/NotificationDao;", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BlueairDatabase extends RoomDatabase {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DATABASE_NAME = "blueair.db";
   private static BlueairDatabase INSTANCE;
   private static final <undefinedtype> MIGRATION_41_42 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN sku TEXT");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN compatibility TEXT");
      }
   };
   private static final <undefinedtype> MIGRATION_42_43 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN lat REAL");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN lng REAL");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN radius INTEGER");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN textValue TEXT");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN isEnabled INTEGER");
      }
   };
   private static final <undefinedtype> MIGRATION_43_44 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_schedule_table ADD COLUMN scheduleEndType TEXT");
      }
   };
   private static final <undefinedtype> MIGRATION_44_45 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN disinfection INTEGER");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN disinfectLeftTime INTEGER");
      }
   };
   private static final <undefinedtype> MIGRATION_45_46 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN isGermShieldNightModeOn INTEGER");
      }
   };
   private static final <undefinedtype> MIGRATION_46_47 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_data ADD COLUMN hcho REAL");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN hcho REAL");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN hchoRanges TEXT NOT NULL DEFAULT ''");
      }
   };
   private static final <undefinedtype> MIGRATION_47_48 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE device_table ADD COLUMN disinfectLeftTimeUpdateTime INTEGER");
      }
   };
   private static final <undefinedtype> MIGRATION_48_49 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("CREATE TABLE IF NOT EXISTS `device_table_new` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `modelName` TEXT NOT NULL, `typeIndex` INTEGER NOT NULL, `fanSpeed` INTEGER, `filterLife` INTEGER, `autoModeText` TEXT, `brightness` INTEGER, `info` TEXT, `hasFinishedOnboarding` INTEGER NOT NULL, `lastSelectedSensorType` INTEGER, `isAblDevice` INTEGER NOT NULL, `isNightModeOn` INTEGER NOT NULL, `isChildLockOn` INTEGER NOT NULL, `linkedDeviceUid` TEXT, `connectivityStatusIndex` INTEGER NOT NULL, `lastConnectivityMillis` INTEGER NOT NULL, `mac` TEXT NOT NULL, `mcuFirmware` TEXT NOT NULL, `wifiFirmware` TEXT NOT NULL, `timeZone` TEXT NOT NULL, `serial` TEXT NOT NULL, `purchaseDate` TEXT NOT NULL, `dealerName` TEXT NOT NULL, `dealerCountry` TEXT NOT NULL, `filterType` TEXT NOT NULL, `filterTrigger` TEXT NOT NULL, `pm1Ranges` TEXT NOT NULL, `pm10Ranges` TEXT NOT NULL, `pm25Ranges` TEXT NOT NULL, `vocRanges` TEXT NOT NULL, `hchoRanges` TEXT NOT NULL, `updateProgress` INTEGER NOT NULL, `isStandByOn` INTEGER NOT NULL, `isG4NightModeOn` INTEGER NOT NULL, `isGermShieldOn` INTEGER NOT NULL, `isGermShieldNightModeOn` INTEGER, `isSafetySwitchOn` INTEGER NOT NULL, `g4NightModefilterTrigger` TEXT NOT NULL, `aimInstalled` INTEGER NOT NULL, `sku` TEXT, `compatibility` TEXT, `disinfection` INTEGER, `disinfectLeftTime` INTEGER, `disinfectLeftTimeUpdateTime` INTEGER, `uuid` TEXT, `ssid` TEXT, `bssid` TEXT, `ipv4` TEXT, `ipv6` TEXT, `timeInSeconds` INTEGER, `pm1` REAL, `pm10` REAL, `pm25` REAL, `voc` REAL, `hcho` REAL, `tmp` REAL, `hum` REAL, `fan` REAL, `lat` REAL, `lng` REAL, `radius` INTEGER, `textValue` TEXT, `isEnabled` INTEGER, PRIMARY KEY(`uid`))");
         var1.execSQL("INSERT INTO `device_table_new` (`uid`, `name`, `modelName`, `typeIndex`, `fanSpeed`, `filterLife`, `autoModeText`, `brightness`, `info`, `hasFinishedOnboarding`, `lastSelectedSensorType`, `isAblDevice`, `isNightModeOn`, `isChildLockOn`, `linkedDeviceUid`, `connectivityStatusIndex`, `lastConnectivityMillis`, `mac`, `mcuFirmware`, `wifiFirmware`, `timeZone`, `serial`, `purchaseDate`, `dealerName`, `dealerCountry`, `filterType`, `filterTrigger`, `pm1Ranges`, `pm10Ranges`, `pm25Ranges`, `vocRanges`, `hchoRanges`, `updateProgress`, `isStandByOn`, `isG4NightModeOn`, `isGermShieldOn`, `isGermShieldNightModeOn`, `isSafetySwitchOn`, `g4NightModefilterTrigger`, `aimInstalled`, `sku`, `compatibility`, `disinfection`, `disinfectLeftTime`, `disinfectLeftTimeUpdateTime`, `uuid`, `ssid`, `bssid`, `ipv4`, `ipv6`, `timeInSeconds`, `pm1`, `pm10`, `pm25`, `voc`, `hcho`, `tmp`, `hum`, `fan`, `lat`, `lng`, `radius`, `textValue`, `isEnabled`) SELECT `uid`, `name`, `modelName`, `typeIndex`, `fanSpeed`, `filterLife`, `autoModeText`, `brightness`, `info`, `hasFinishedOnboarding`, `lastSelectedSensorType`, `isAblDevice`, `isNightModeOn`, `isChildLockOn`, `linkedDeviceUid`, `connectivityStatusIndex`, `lastConnectivityMillis`, `mac`, `mcuFirmware`, `wifiFirmware`, `timeZone`, `serial`, `purchaseDate`, `dealerName`, `dealerCountry`, `filterType`, `filterTrigger`, `pm1Ranges`, `pm10Ranges`, `pm25Ranges`, `vocRanges`, `hchoRanges`, `updateProgress`, `isStandByOn`, `isG4NightModeOn`, `isGermShieldOn`, `isGermShieldNightModeOn`, `isSafetySwitchOn`, `g4NightModefilterTrigger`, `aimInstalled`, `sku`, `compatibility`, `disinfection`, `disinfectLeftTime`, `disinfectLeftTimeUpdateTime`, `uuid`, `ssid`, `bssid`, `ipv4`, `ipv6`, `timeInSeconds`, `pm1`, `pm10`, `pm25`, `voc`, `hcho`, `tmp`, `hum`, `fan`, `lat`, `lng`, `radius`, `textValue`, `isEnabled` FROM `device_table`");
         var1.execSQL("DROP TABLE `device_table`");
         var1.execSQL("ALTER TABLE `device_table_new` RENAME TO `device_table`");
         var1.execSQL("DROP TABLE `tracked_location_table`");
         var1.execSQL("CREATE TABLE IF NOT EXISTS `tracked_location_table` (`id` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `locationName` TEXT, `cityName` TEXT, `countryName` TEXT, `countryCode` TEXT, `mapType` TEXT, PRIMARY KEY(`id`))");
         var1.execSQL("DROP TABLE `tracked_location_data_table`");
         var1.execSQL("CREATE TABLE IF NOT EXISTS `aqi_data_table` (`trackedLocationId` TEXT NOT NULL, `datetime` INTEGER NOT NULL, `co` REAL, `no2` REAL, `o3` REAL, `pm10` REAL, `pm25` REAL, `so2` REAL, `aqi` REAL, PRIMARY KEY(`trackedLocationId`))");
      }
   };
   private static final <undefinedtype> MIGRATION_49_50 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN isEcoModeOn INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_50_51 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "database");
         var1.execSQL("ALTER TABLE `tracked_location_table` ADD COLUMN stateName TEXT");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN isHinsModeOn INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN isHinsNightModeOn INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_51_52 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryEnabled INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryOn INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryLeftTime INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryLeftTimeUpdateTime INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickUsage INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN waterShortage INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN autoRh INTEGER NOT NULL DEFAULT 50");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN timerStatus INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN timerDuration INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN timerLeftTime INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN timerLeftTimeUpdateTime INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_52_53 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN temperatureUnit INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationState INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationAngle INTEGER NOT NULL DEFAULT 90");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationDirection INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationFanSpeed INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN mainMode INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN apSubMode INTEGER NOT NULL DEFAULT 2");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN apFanSpeed INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN heatSubMode INTEGER NOT NULL DEFAULT 2");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN heatFanSpeed INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN heatAutoTmp REAL NOT NULL DEFAULT 22.0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN heatEcoTmp REAL NOT NULL DEFAULT 22.0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolSubMode INTEGER NOT NULL DEFAULT 2");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolFanSpeed INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolAutoTag INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolAutoPresets TEXT NOT NULL DEFAULT ''");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolEcoTag INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolEcoPresets TEXT NOT NULL DEFAULT ''");
      }
   };
   private static final <undefinedtype> MIGRATION_53_54 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN locationId TEXT");
      }
   };
   private static final <undefinedtype> MIGRATION_54_55 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN mode INTEGER NOT NULL DEFAULT 1");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN waterLevel INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN humMode INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_55_56 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN hardware TEXT NOT NULL DEFAULT ''");
      }
   };
   private static final <undefinedtype> MIGRATION_56_57 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN dehSubMode INTEGER NOT NULL DEFAULT 1");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN waterTankFailure INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN smartSubMode INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN detectCat INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN weight REAL");
         var1.execSQL("ALTER TABLE `device_data` ADD COLUMN weight REAL");
      }
   };
   private static final <undefinedtype> MIGRATION_58_59 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN cleanAirEta INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN panelDisplayMode INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN hoverEnabled INTEGER NOT NULL DEFAULT 1");
      }
   };
   private static final <undefinedtype> MIGRATION_59_60 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshEnabled INTEGER NOT NULL DEFAULT 1");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshStatus INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshDuration INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshTimeStamp INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshStartTimeStamp INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshEndTimeStamp INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN roomType INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_60_61 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN bodyMounted INTEGER NOT NULL DEFAULT 1");
      }
   };
   private static final <undefinedtype> MIGRATION_61_62 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN nightLampEnabled INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN nightLampBrightness INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryDuration INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryDone INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_62_63 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN ywrmEnabled INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN ywrmUsage INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN nightLampSteplessBrightness INTEGER NOT NULL DEFAULT 1");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN alarms TEXT NOT NULL DEFAULT ''");
      }
   };
   private static final <undefinedtype> MIGRATION_64_65 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("CREATE TABLE IF NOT EXISTS `_new_device_table` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `modelName` TEXT NOT NULL, `typeIndex` INTEGER NOT NULL, `fanSpeed` INTEGER, `filterLife` INTEGER, `autoModeText` TEXT, `brightness` INTEGER, `info` TEXT, `hasFinishedOnboarding` INTEGER NOT NULL, `lastSelectedSensorType` INTEGER, `isAblDevice` INTEGER NOT NULL, `isNightModeOn` INTEGER NOT NULL, `isChildLockOn` INTEGER NOT NULL, `linkedDeviceUid` TEXT, `connectivityStatusIndex` INTEGER NOT NULL, `lastConnectivityMillis` INTEGER NOT NULL, `mac` TEXT NOT NULL, `mcuFirmware` TEXT NOT NULL, `wifiFirmware` TEXT NOT NULL, `hardware` TEXT NOT NULL, `timeZone` TEXT NOT NULL, `serial` TEXT NOT NULL, `purchaseDate` TEXT NOT NULL, `dealerName` TEXT NOT NULL, `dealerCountry` TEXT NOT NULL, `filterType` TEXT NOT NULL, `filterTrigger` TEXT NOT NULL, `pm1Ranges` TEXT NOT NULL, `pm10Ranges` TEXT NOT NULL, `pm25Ranges` TEXT NOT NULL, `vocRanges` TEXT NOT NULL, `hchoRanges` TEXT NOT NULL, `updateProgress` INTEGER NOT NULL, `isStandByOn` INTEGER NOT NULL, `isEcoModeOn` INTEGER NOT NULL, `isHinsModeOn` INTEGER NOT NULL, `isHinsNightModeOn` INTEGER NOT NULL, `isG4NightModeOn` INTEGER NOT NULL, `isGermShieldOn` INTEGER NOT NULL, `isGermShieldNightModeOn` INTEGER, `isSafetySwitchOn` INTEGER NOT NULL, `g4NightModefilterTrigger` TEXT NOT NULL, `aimInstalled` INTEGER NOT NULL, `sku` TEXT, `compatibility` TEXT, `locationId` TEXT, `disinfection` INTEGER, `disinfectLeftTime` INTEGER, `disinfectLeftTimeUpdateTime` INTEGER, `wickdryEnabled` INTEGER NOT NULL, `wickdryOn` INTEGER NOT NULL, `wickdryLeftTime` INTEGER NOT NULL, `wickdryLeftTimeUpdateTime` INTEGER NOT NULL, `wickUsage` INTEGER NOT NULL, `waterShortage` INTEGER NOT NULL, `autoRh` INTEGER NOT NULL, `timerStatus` INTEGER NOT NULL, `timerDuration` INTEGER NOT NULL, `timerLeftTime` INTEGER NOT NULL, `timerLeftTimeUpdateTime` INTEGER NOT NULL, `temperatureUnit` INTEGER NOT NULL, `oscillationState` INTEGER NOT NULL, `oscillationAngle` INTEGER NOT NULL, `oscillationDirection` INTEGER NOT NULL, `oscillationFanSpeed` INTEGER NOT NULL, `mainMode` INTEGER NOT NULL, `apSubMode` INTEGER NOT NULL, `apFanSpeed` INTEGER NOT NULL, `heatSubMode` INTEGER NOT NULL, `heatFanSpeed` INTEGER NOT NULL, `heatAutoTmp` REAL NOT NULL, `heatEcoTmp` REAL NOT NULL, `coolSubMode` INTEGER NOT NULL, `coolFanSpeed` INTEGER NOT NULL, `coolAutoTag` INTEGER NOT NULL, `coolAutoPresets` TEXT NOT NULL, `coolEcoTag` INTEGER NOT NULL, `coolEcoPresets` TEXT NOT NULL, `humMode` INTEGER NOT NULL, `mode` INTEGER NOT NULL, `waterLevel` INTEGER NOT NULL, `dehSubMode` INTEGER NOT NULL, `waterTankFailure` INTEGER NOT NULL, `smartSubMode` INTEGER NOT NULL, `detectCat` INTEGER NOT NULL, `bodyMounted` INTEGER NOT NULL, `cleanAirEta` INTEGER NOT NULL, `panelDisplayMode` INTEGER NOT NULL, `hoverEnabled` INTEGER NOT NULL, `airRefreshEnabled` INTEGER NOT NULL, `airRefreshStatus` INTEGER NOT NULL, `airRefreshDuration` INTEGER NOT NULL, `airRefreshTimeStamp` INTEGER NOT NULL, `airRefreshStartTimeStamp` INTEGER NOT NULL, `airRefreshEndTimeStamp` INTEGER NOT NULL, `roomType` INTEGER NOT NULL, `nightLampBrightness` INTEGER NOT NULL, `wickdryDuration` INTEGER NOT NULL, `wickdryDone` INTEGER NOT NULL, `ywrmEnabled` INTEGER, `ywrmUsage` INTEGER NOT NULL, `nightLampSteplessBrightness` INTEGER NOT NULL, `alarms` TEXT NOT NULL, `uuid` TEXT, `ssid` TEXT, `bssid` TEXT, `ipv4` TEXT, `ipv6` TEXT, `timeInSeconds` INTEGER, `pm1` REAL, `pm10` REAL, `pm25` REAL, `voc` REAL, `hcho` REAL, `tmp` REAL, `hum` REAL, `fan` REAL, `weight` REAL, `lat` REAL, `lng` REAL, `radius` INTEGER, `textValue` TEXT, `isEnabled` INTEGER, `humSubMode` INTEGER NOT NULL DEFAULT 2, PRIMARY KEY(`uid`))");
         var1.execSQL("INSERT INTO `_new_device_table` (`uid`,`name`,`modelName`,`typeIndex`,`fanSpeed`,`filterLife`,`autoModeText`,`brightness`,`info`,`hasFinishedOnboarding`,`lastSelectedSensorType`,`isAblDevice`,`isNightModeOn`,`isChildLockOn`,`linkedDeviceUid`,`connectivityStatusIndex`,`lastConnectivityMillis`,`mac`,`mcuFirmware`,`wifiFirmware`,`hardware`,`timeZone`,`serial`,`purchaseDate`,`dealerName`,`dealerCountry`,`filterType`,`filterTrigger`,`pm1Ranges`,`pm10Ranges`,`pm25Ranges`,`vocRanges`,`hchoRanges`,`updateProgress`,`isStandByOn`,`isEcoModeOn`,`isHinsModeOn`,`isHinsNightModeOn`,`isG4NightModeOn`,`isGermShieldOn`,`isGermShieldNightModeOn`,`isSafetySwitchOn`,`g4NightModefilterTrigger`,`aimInstalled`,`sku`,`compatibility`,`locationId`,`disinfection`,`disinfectLeftTime`,`disinfectLeftTimeUpdateTime`,`wickdryEnabled`,`wickdryOn`,`wickdryLeftTime`,`wickdryLeftTimeUpdateTime`,`wickUsage`,`waterShortage`,`autoRh`,`timerStatus`,`timerDuration`,`timerLeftTime`,`timerLeftTimeUpdateTime`,`temperatureUnit`,`oscillationState`,`oscillationAngle`,`oscillationDirection`,`oscillationFanSpeed`,`mainMode`,`apSubMode`,`apFanSpeed`,`heatSubMode`,`heatFanSpeed`,`heatAutoTmp`,`heatEcoTmp`,`coolSubMode`,`coolFanSpeed`,`coolAutoTag`,`coolAutoPresets`,`coolEcoTag`,`coolEcoPresets`,`humMode`,`mode`,`waterLevel`,`dehSubMode`,`waterTankFailure`,`smartSubMode`,`detectCat`,`bodyMounted`,`cleanAirEta`,`panelDisplayMode`,`hoverEnabled`,`airRefreshEnabled`,`airRefreshStatus`,`airRefreshDuration`,`airRefreshTimeStamp`,`airRefreshStartTimeStamp`,`airRefreshEndTimeStamp`,`roomType`,`nightLampBrightness`,`wickdryDuration`,`wickdryDone`,`ywrmUsage`,`nightLampSteplessBrightness`,`alarms`,`uuid`,`ssid`,`bssid`,`ipv4`,`ipv6`,`timeInSeconds`,`pm1`,`pm10`,`pm25`,`voc`,`hcho`,`tmp`,`hum`,`fan`,`weight`,`lat`,`lng`,`radius`,`textValue`,`isEnabled`) SELECT `uid`,`name`,`modelName`,`typeIndex`,`fanSpeed`,`filterLife`,`autoModeText`,`brightness`,`info`,`hasFinishedOnboarding`,`lastSelectedSensorType`,`isAblDevice`,`isNightModeOn`,`isChildLockOn`,`linkedDeviceUid`,`connectivityStatusIndex`,`lastConnectivityMillis`,`mac`,`mcuFirmware`,`wifiFirmware`,`hardware`,`timeZone`,`serial`,`purchaseDate`,`dealerName`,`dealerCountry`,`filterType`,`filterTrigger`,`pm1Ranges`,`pm10Ranges`,`pm25Ranges`,`vocRanges`,`hchoRanges`,`updateProgress`,`isStandByOn`,`isEcoModeOn`,`isHinsModeOn`,`isHinsNightModeOn`,`isG4NightModeOn`,`isGermShieldOn`,`isGermShieldNightModeOn`,`isSafetySwitchOn`,`g4NightModefilterTrigger`,`aimInstalled`,`sku`,`compatibility`,`locationId`,`disinfection`,`disinfectLeftTime`,`disinfectLeftTimeUpdateTime`,`wickdryEnabled`,`wickdryOn`,`wickdryLeftTime`,`wickdryLeftTimeUpdateTime`,`wickUsage`,`waterShortage`,`autoRh`,`timerStatus`,`timerDuration`,`timerLeftTime`,`timerLeftTimeUpdateTime`,`temperatureUnit`,`oscillationState`,`oscillationAngle`,`oscillationDirection`,`oscillationFanSpeed`,`mainMode`,`apSubMode`,`apFanSpeed`,`heatSubMode`,`heatFanSpeed`,`heatAutoTmp`,`heatEcoTmp`,`coolSubMode`,`coolFanSpeed`,`coolAutoTag`,`coolAutoPresets`,`coolEcoTag`,`coolEcoPresets`,`humMode`,`mode`,`waterLevel`,`dehSubMode`,`waterTankFailure`,`smartSubMode`,`detectCat`,`bodyMounted`,`cleanAirEta`,`panelDisplayMode`,`hoverEnabled`,`airRefreshEnabled`,`airRefreshStatus`,`airRefreshDuration`,`airRefreshTimeStamp`,`airRefreshStartTimeStamp`,`airRefreshEndTimeStamp`,`roomType`,`nightLampBrightness`,`wickdryDuration`,`wickdryDone`,`ywrmUsage`,`nightLampSteplessBrightness`,`alarms`,`uuid`,`ssid`,`bssid`,`ipv4`,`ipv6`,`timeInSeconds`,`pm1`,`pm10`,`pm25`,`voc`,`hcho`,`tmp`,`hum`,`fan`,`weight`,`lat`,`lng`,`radius`,`textValue`,`isEnabled` FROM `device_table`");
         var1.execSQL("DROP TABLE `device_table`");
         var1.execSQL("ALTER TABLE `_new_device_table` RENAME TO `device_table`");
      }
   };
   private static final <undefinedtype> MIGRATION_65_66 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN use24Hour INTEGER NOT NULL DEFAULT 1");
      }
   };
   private static final <undefinedtype> MIGRATION_66_67 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN waterInfill INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_67_68 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN sensorMode INTEGER NOT NULL DEFAULT 1");
      }
   };
   private static final <undefinedtype> MIGRATION_68_69 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("CREATE TABLE notification_table_new (\n    deviceId TEXT NOT NULL,\n    type TEXT NOT NULL,\n    subType TEXT NOT NULL,\n    subLevel INTEGER NOT NULL,\n    dismissed INTEGER NOT NULL DEFAULT 0,\n    datetime INTEGER NOT NULL,\n    dismissTime INTEGER NOT NULL DEFAULT 0,\n    PRIMARY KEY(deviceId, type, subType),\n    FOREIGN KEY(deviceId) REFERENCES device_table(uid) ON DELETE CASCADE\n)");
         var1.execSQL("INSERT INTO notification_table_new \n(deviceId, type, subType, subLevel, dismissed, datetime, dismissTime)\nSELECT \n    deviceId, \n    'FILTER_LIFE' AS type, \n    filterType AS subType,  \n    filterLifeLevel AS subLevel, \n    dismissed,\n    datetime,\n    0 AS dismissTime \nFROM notification_table");
         var1.execSQL("DROP TABLE notification_table");
         var1.execSQL("ALTER TABLE notification_table_new RENAME TO notification_table");
      }
   };
   private static final <undefinedtype> MIGRATION_69_70 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolFanSpeedLevel INTEGER NOT NULL DEFAULT 2");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN coolAutoLevel INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN nightModeStartTime INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN horizontalOscillationState INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN horizontalOscillationFixAngle INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN horizontalOscillationMinAngle INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN horizontalOscillationMaxAngle INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN verticalOscillationState INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN verticalOscillationFixAngle INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN verticalOscillationMinAngle INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN verticalOscillationMaxAngle INTEGER NOT NULL DEFAULT 0");
      }
   };
   private static final <undefinedtype> MIGRATION_70_71 = new Migration() {
      public void migrate(SupportSQLiteDatabase var1) {
         Intrinsics.checkNotNullParameter(var1, "db");
         var1.execSQL("ALTER TABLE `device_data` ADD COLUMN rpm REAL");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN rpm REAL");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN rpm1 INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationMode INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN horizontalCalibrationState INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN verticalCalibrationState INTEGER NOT NULL DEFAULT 0");
         var1.execSQL("ALTER TABLE `device_table` ADD COLUMN nightPeriods TEXT NOT NULL DEFAULT ''");
      }
   };

   public abstract AqiDataDao aqiDataDao();

   public abstract DeviceDao deviceDao();

   public abstract DeviceDataDao deviceDataDao();

   public abstract DeviceScheduleDao deviceScheduleDao();

   public abstract NotificationDao notificationDao();

   public abstract TrackedLocationDao trackedLocationDao();

   @Metadata(
      d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u001c\u0010\u0013\u0016\u0019\u001c\u001f\"%(+.147:=@CFILORUX[^a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010JR\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010PR\u0010\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0004\n\u0002\u0010SR\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010VR\u0010\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010YR\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010b¨\u0006c"},
      d2 = {"Lcom/blueair/database/BlueairDatabase$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/blueair/database/BlueairDatabase;", "getINSTANCE", "()Lcom/blueair/database/BlueairDatabase;", "setINSTANCE", "(Lcom/blueair/database/BlueairDatabase;)V", "getDatabase", "context", "Landroid/content/Context;", "DATABASE_NAME", "", "MIGRATION_41_42", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_41_42$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_41_42$1;", "MIGRATION_42_43", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_42_43$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_42_43$1;", "MIGRATION_43_44", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_43_44$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_43_44$1;", "MIGRATION_44_45", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_44_45$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_44_45$1;", "MIGRATION_45_46", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_45_46$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_45_46$1;", "MIGRATION_46_47", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_46_47$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_46_47$1;", "MIGRATION_47_48", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_47_48$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_47_48$1;", "MIGRATION_48_49", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_48_49$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_48_49$1;", "MIGRATION_49_50", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_49_50$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_49_50$1;", "MIGRATION_50_51", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_50_51$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_50_51$1;", "MIGRATION_51_52", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_51_52$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_51_52$1;", "MIGRATION_52_53", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_52_53$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_52_53$1;", "MIGRATION_53_54", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_53_54$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_53_54$1;", "MIGRATION_54_55", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_54_55$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_54_55$1;", "MIGRATION_55_56", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_55_56$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_55_56$1;", "MIGRATION_56_57", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_56_57$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_56_57$1;", "MIGRATION_58_59", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_58_59$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_58_59$1;", "MIGRATION_59_60", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_59_60$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_59_60$1;", "MIGRATION_60_61", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_60_61$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_60_61$1;", "MIGRATION_61_62", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_61_62$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_61_62$1;", "MIGRATION_62_63", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_62_63$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_62_63$1;", "MIGRATION_64_65", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_64_65$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_64_65$1;", "MIGRATION_65_66", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_65_66$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_65_66$1;", "MIGRATION_66_67", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_66_67$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_66_67$1;", "MIGRATION_67_68", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_67_68$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_67_68$1;", "MIGRATION_68_69", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_68_69$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_68_69$1;", "MIGRATION_69_70", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_69_70$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_69_70$1;", "MIGRATION_70_71", "com/blueair/database/BlueairDatabase$Companion$MIGRATION_70_71$1", "Lcom/blueair/database/BlueairDatabase$Companion$MIGRATION_70_71$1;", "database_otherRelease"},
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

      public final BlueairDatabase getDatabase(Context var1) {
         Intrinsics.checkNotNullParameter(var1, "context");
         if (this.getINSTANCE() == null) {
            KClass var2 = Reflection.getOrCreateKotlinClass(BlueairDatabase.class);
            synchronized(var2){}

            try {
               BlueairDatabase.Companion.setINSTANCE((BlueairDatabase)Room.databaseBuilder(var1, BlueairDatabase.class, "blueair.db").addMigrations(new Migration[]{BlueairDatabase.MIGRATION_41_42, BlueairDatabase.MIGRATION_42_43, BlueairDatabase.MIGRATION_43_44, BlueairDatabase.MIGRATION_44_45, BlueairDatabase.MIGRATION_45_46, BlueairDatabase.MIGRATION_46_47, BlueairDatabase.MIGRATION_47_48, BlueairDatabase.MIGRATION_48_49, BlueairDatabase.MIGRATION_49_50, BlueairDatabase.MIGRATION_50_51, BlueairDatabase.MIGRATION_51_52, BlueairDatabase.MIGRATION_52_53, BlueairDatabase.MIGRATION_53_54, BlueairDatabase.MIGRATION_54_55, BlueairDatabase.MIGRATION_55_56, BlueairDatabase.MIGRATION_56_57, BlueairDatabase.MIGRATION_58_59, BlueairDatabase.MIGRATION_59_60, BlueairDatabase.MIGRATION_60_61, BlueairDatabase.MIGRATION_61_62, BlueairDatabase.MIGRATION_62_63, BlueairDatabase.MIGRATION_64_65, BlueairDatabase.MIGRATION_65_66, BlueairDatabase.MIGRATION_66_67, BlueairDatabase.MIGRATION_67_68, BlueairDatabase.MIGRATION_68_69, BlueairDatabase.MIGRATION_69_70, BlueairDatabase.MIGRATION_70_71}).fallbackToDestructiveMigration(true).build());
               Unit var5 = Unit.INSTANCE;
            } finally {
               ;
            }
         }

         BlueairDatabase var6 = this.getINSTANCE();
         Intrinsics.checkNotNull(var6);
         return var6;
      }

      public final BlueairDatabase getINSTANCE() {
         return BlueairDatabase.INSTANCE;
      }

      public final void setINSTANCE(BlueairDatabase var1) {
         BlueairDatabase.INSTANCE = var1;
      }
   }
}
