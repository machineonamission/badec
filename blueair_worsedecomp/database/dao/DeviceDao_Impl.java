package com.blueair.database.dao;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.material3.MenuKt;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.database.DeviceAlarmListConverter;
import com.blueair.database.DeviceUuidEntity;
import com.blueair.database.DoubleArrayConverter;
import com.blueair.database.entity.DeviceEntity;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import okhttp3.internal.ws.WebSocketProtocol;

public final class DeviceDao_Impl implements DeviceDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<DeviceEntity> __insertAdapterOfDeviceEntity = new EntityInsertAdapter<DeviceEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `device_table` (`uid`,`name`,`modelName`,`typeIndex`,`fanSpeed`,`filterLife`,`autoModeText`,`brightness`,`info`,`hasFinishedOnboarding`,`lastSelectedSensorType`,`isAblDevice`,`isNightModeOn`,`isChildLockOn`,`linkedDeviceUid`,`connectivityStatusIndex`,`lastConnectivityMillis`,`mac`,`mcuFirmware`,`wifiFirmware`,`hardware`,`timeZone`,`serial`,`purchaseDate`,`dealerName`,`dealerCountry`,`filterType`,`filterTrigger`,`pm1Ranges`,`pm10Ranges`,`pm25Ranges`,`vocRanges`,`hchoRanges`,`updateProgress`,`isStandByOn`,`isEcoModeOn`,`isHinsModeOn`,`isHinsNightModeOn`,`isG4NightModeOn`,`isGermShieldOn`,`isGermShieldNightModeOn`,`isSafetySwitchOn`,`g4NightModefilterTrigger`,`aimInstalled`,`sku`,`compatibility`,`locationId`,`disinfection`,`disinfectLeftTime`,`disinfectLeftTimeUpdateTime`,`wickdryEnabled`,`wickdryOn`,`wickdryLeftTime`,`wickdryLeftTimeUpdateTime`,`wickUsage`,`waterShortage`,`autoRh`,`timerStatus`,`timerDuration`,`timerLeftTime`,`timerLeftTimeUpdateTime`,`temperatureUnit`,`oscillationState`,`oscillationAngle`,`oscillationDirection`,`oscillationFanSpeed`,`mainMode`,`apSubMode`,`apFanSpeed`,`heatSubMode`,`heatFanSpeed`,`heatAutoTmp`,`heatEcoTmp`,`coolSubMode`,`coolFanSpeed`,`coolAutoTag`,`coolAutoPresets`,`coolEcoTag`,`coolEcoPresets`,`humMode`,`mode`,`waterLevel`,`dehSubMode`,`waterTankFailure`,`smartSubMode`,`detectCat`,`bodyMounted`,`cleanAirEta`,`panelDisplayMode`,`hoverEnabled`,`airRefreshEnabled`,`airRefreshStatus`,`airRefreshDuration`,`airRefreshTimeStamp`,`airRefreshStartTimeStamp`,`airRefreshEndTimeStamp`,`roomType`,`nightLampBrightness`,`wickdryDuration`,`wickdryDone`,`ywrmEnabled`,`ywrmUsage`,`nightLampSteplessBrightness`,`alarms`,`humSubMode`,`use24Hour`,`waterInfill`,`sensorMode`,`uuid`,`ssid`,`bssid`,`ipv4`,`ipv6`,`timeInSeconds`,`pm1`,`pm10`,`pm25`,`voc`,`hcho`,`tmp`,`hum`,`fan`,`weight`,`lat`,`lng`,`radius`,`textValue`,`isEnabled`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, DeviceEntity deviceEntity) {
            if (deviceEntity.getUid() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, deviceEntity.getUid());
            }
            if (deviceEntity.getName() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, deviceEntity.getName());
            }
            if (deviceEntity.getModelName() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, deviceEntity.getModelName());
            }
            sQLiteStatement.bindLong(4, (long) deviceEntity.getTypeIndex());
            if (deviceEntity.getFanSpeed() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindLong(5, (long) deviceEntity.getFanSpeed().intValue());
            }
            if (deviceEntity.getFilterLife() == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindLong(6, (long) deviceEntity.getFilterLife().intValue());
            }
            if (deviceEntity.getAutoModeText() == null) {
                sQLiteStatement.bindNull(7);
            } else {
                sQLiteStatement.bindText(7, deviceEntity.getAutoModeText());
            }
            if (deviceEntity.getBrightness() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindLong(8, (long) deviceEntity.getBrightness().intValue());
            }
            if (deviceEntity.getInfo() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindText(9, deviceEntity.getInfo());
            }
            sQLiteStatement.bindLong(10, deviceEntity.getHasFinishedOnboarding() ? 1 : 0);
            if (deviceEntity.getLastSelectedSensorType() == null) {
                sQLiteStatement.bindNull(11);
            } else {
                sQLiteStatement.bindLong(11, (long) deviceEntity.getLastSelectedSensorType().intValue());
            }
            sQLiteStatement.bindLong(12, deviceEntity.isAblDevice() ? 1 : 0);
            sQLiteStatement.bindLong(13, deviceEntity.isNightModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(14, deviceEntity.isChildLockOn() ? 1 : 0);
            if (deviceEntity.getLinkedDeviceUid() == null) {
                sQLiteStatement.bindNull(15);
            } else {
                sQLiteStatement.bindText(15, deviceEntity.getLinkedDeviceUid());
            }
            sQLiteStatement.bindLong(16, (long) deviceEntity.getConnectivityStatusIndex());
            sQLiteStatement.bindLong(17, deviceEntity.getLastConnectivityMillis());
            if (deviceEntity.getMac() == null) {
                sQLiteStatement.bindNull(18);
            } else {
                sQLiteStatement.bindText(18, deviceEntity.getMac());
            }
            if (deviceEntity.getMcuFirmware() == null) {
                sQLiteStatement.bindNull(19);
            } else {
                sQLiteStatement.bindText(19, deviceEntity.getMcuFirmware());
            }
            if (deviceEntity.getWifiFirmware() == null) {
                sQLiteStatement.bindNull(20);
            } else {
                sQLiteStatement.bindText(20, deviceEntity.getWifiFirmware());
            }
            if (deviceEntity.getHardware() == null) {
                sQLiteStatement.bindNull(21);
            } else {
                sQLiteStatement.bindText(21, deviceEntity.getHardware());
            }
            if (deviceEntity.getTimeZone() == null) {
                sQLiteStatement.bindNull(22);
            } else {
                sQLiteStatement.bindText(22, deviceEntity.getTimeZone());
            }
            if (deviceEntity.getSerial() == null) {
                sQLiteStatement.bindNull(23);
            } else {
                sQLiteStatement.bindText(23, deviceEntity.getSerial());
            }
            if (deviceEntity.getPurchaseDate() == null) {
                sQLiteStatement.bindNull(24);
            } else {
                sQLiteStatement.bindText(24, deviceEntity.getPurchaseDate());
            }
            if (deviceEntity.getDealerName() == null) {
                sQLiteStatement.bindNull(25);
            } else {
                sQLiteStatement.bindText(25, deviceEntity.getDealerName());
            }
            if (deviceEntity.getDealerCountry() == null) {
                sQLiteStatement.bindNull(26);
            } else {
                sQLiteStatement.bindText(26, deviceEntity.getDealerCountry());
            }
            if (deviceEntity.getFilterType() == null) {
                sQLiteStatement.bindNull(27);
            } else {
                sQLiteStatement.bindText(27, deviceEntity.getFilterType());
            }
            if (deviceEntity.getFilterTrigger() == null) {
                sQLiteStatement.bindNull(28);
            } else {
                sQLiteStatement.bindText(28, deviceEntity.getFilterTrigger());
            }
            String fromDoubleArray = DoubleArrayConverter.fromDoubleArray(deviceEntity.getPm1Ranges());
            if (fromDoubleArray == null) {
                sQLiteStatement.bindNull(29);
            } else {
                sQLiteStatement.bindText(29, fromDoubleArray);
            }
            String fromDoubleArray2 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getPm10Ranges());
            if (fromDoubleArray2 == null) {
                sQLiteStatement.bindNull(30);
            } else {
                sQLiteStatement.bindText(30, fromDoubleArray2);
            }
            String fromDoubleArray3 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getPm25Ranges());
            if (fromDoubleArray3 == null) {
                sQLiteStatement.bindNull(31);
            } else {
                sQLiteStatement.bindText(31, fromDoubleArray3);
            }
            String fromDoubleArray4 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getVocRanges());
            if (fromDoubleArray4 == null) {
                sQLiteStatement.bindNull(32);
            } else {
                sQLiteStatement.bindText(32, fromDoubleArray4);
            }
            String fromDoubleArray5 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getHchoRanges());
            if (fromDoubleArray5 == null) {
                sQLiteStatement.bindNull(33);
            } else {
                sQLiteStatement.bindText(33, fromDoubleArray5);
            }
            sQLiteStatement.bindLong(34, (long) deviceEntity.getUpdateProgress());
            sQLiteStatement.bindLong(35, deviceEntity.isStandByOn() ? 1 : 0);
            sQLiteStatement.bindLong(36, deviceEntity.isEcoModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(37, deviceEntity.isHinsModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(38, deviceEntity.isHinsNightModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(39, deviceEntity.isG4NightModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(40, deviceEntity.isGermShieldOn() ? 1 : 0);
            Integer num = null;
            Integer valueOf = deviceEntity.isGermShieldNightModeOn() == null ? null : Integer.valueOf(deviceEntity.isGermShieldNightModeOn().booleanValue() ? 1 : 0);
            if (valueOf == null) {
                sQLiteStatement.bindNull(41);
            } else {
                sQLiteStatement.bindLong(41, (long) valueOf.intValue());
            }
            sQLiteStatement.bindLong(42, deviceEntity.isSafetySwitchOn() ? 1 : 0);
            if (deviceEntity.getG4NightModefilterTrigger() == null) {
                sQLiteStatement.bindNull(43);
            } else {
                sQLiteStatement.bindText(43, deviceEntity.getG4NightModefilterTrigger());
            }
            sQLiteStatement.bindLong(44, deviceEntity.getAimInstalled() ? 1 : 0);
            if (deviceEntity.getSku() == null) {
                sQLiteStatement.bindNull(45);
            } else {
                sQLiteStatement.bindText(45, deviceEntity.getSku());
            }
            if (deviceEntity.getCompatibility() == null) {
                sQLiteStatement.bindNull(46);
            } else {
                sQLiteStatement.bindText(46, deviceEntity.getCompatibility());
            }
            if (deviceEntity.getLocationId() == null) {
                sQLiteStatement.bindNull(47);
            } else {
                sQLiteStatement.bindText(47, deviceEntity.getLocationId());
            }
            Integer valueOf2 = deviceEntity.getDisinfection() == null ? null : Integer.valueOf(deviceEntity.getDisinfection().booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                sQLiteStatement.bindNull(48);
            } else {
                sQLiteStatement.bindLong(48, (long) valueOf2.intValue());
            }
            if (deviceEntity.getDisinfectLeftTime() == null) {
                sQLiteStatement.bindNull(49);
            } else {
                sQLiteStatement.bindLong(49, (long) deviceEntity.getDisinfectLeftTime().intValue());
            }
            if (deviceEntity.getDisinfectLeftTimeUpdateTime() == null) {
                sQLiteStatement.bindNull(50);
            } else {
                sQLiteStatement.bindLong(50, deviceEntity.getDisinfectLeftTimeUpdateTime().longValue());
            }
            sQLiteStatement.bindLong(51, deviceEntity.getWickdryEnabled() ? 1 : 0);
            sQLiteStatement.bindLong(52, deviceEntity.getWickdryOn() ? 1 : 0);
            sQLiteStatement.bindLong(53, (long) deviceEntity.getWickdryLeftTime());
            sQLiteStatement.bindLong(54, deviceEntity.getWickdryLeftTimeUpdateTime());
            sQLiteStatement.bindLong(55, (long) deviceEntity.getWickUsage());
            sQLiteStatement.bindLong(56, deviceEntity.getWaterShortage() ? 1 : 0);
            sQLiteStatement.bindLong(57, (long) deviceEntity.getAutoRh());
            sQLiteStatement.bindLong(58, (long) deviceEntity.getTimerStatus());
            sQLiteStatement.bindLong(59, (long) deviceEntity.getTimerDuration());
            sQLiteStatement.bindLong(60, (long) deviceEntity.getTimerLeftTime());
            sQLiteStatement.bindLong(61, deviceEntity.getTimerLeftTimeUpdateTime());
            sQLiteStatement.bindLong(62, (long) deviceEntity.getTemperatureUnit());
            sQLiteStatement.bindLong(63, (long) deviceEntity.getOscillationState());
            sQLiteStatement.bindLong(64, (long) deviceEntity.getOscillationAngle());
            sQLiteStatement.bindLong(65, (long) deviceEntity.getOscillationDirection());
            sQLiteStatement.bindLong(66, (long) deviceEntity.getOscillationFanSpeed());
            sQLiteStatement.bindLong(67, (long) deviceEntity.getMainMode());
            sQLiteStatement.bindLong(68, (long) deviceEntity.getApSubMode());
            sQLiteStatement.bindLong(69, (long) deviceEntity.getApFanSpeed());
            sQLiteStatement.bindLong(70, (long) deviceEntity.getHeatSubMode());
            sQLiteStatement.bindLong(71, (long) deviceEntity.getHeatFanSpeed());
            sQLiteStatement.bindDouble(72, deviceEntity.getHeatAutoTmp());
            sQLiteStatement.bindDouble(73, deviceEntity.getHeatEcoTmp());
            sQLiteStatement.bindLong(74, (long) deviceEntity.getCoolSubMode());
            sQLiteStatement.bindLong(75, (long) deviceEntity.getCoolFanSpeed());
            sQLiteStatement.bindLong(76, (long) deviceEntity.getCoolAutoTag());
            String fromDoubleArray6 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getCoolAutoPresets());
            if (fromDoubleArray6 == null) {
                sQLiteStatement.bindNull(77);
            } else {
                sQLiteStatement.bindText(77, fromDoubleArray6);
            }
            sQLiteStatement.bindLong(78, (long) deviceEntity.getCoolEcoTag());
            String fromDoubleArray7 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getCoolEcoPresets());
            if (fromDoubleArray7 == null) {
                sQLiteStatement.bindNull(79);
            } else {
                sQLiteStatement.bindText(79, fromDoubleArray7);
            }
            sQLiteStatement.bindLong(80, deviceEntity.getHumMode() ? 1 : 0);
            sQLiteStatement.bindLong(81, (long) deviceEntity.getMode());
            sQLiteStatement.bindLong(82, (long) deviceEntity.getWaterLevel());
            sQLiteStatement.bindLong(83, (long) deviceEntity.getDehSubMode());
            sQLiteStatement.bindLong(84, deviceEntity.getWaterTankFailure() ? 1 : 0);
            sQLiteStatement.bindLong(85, (long) deviceEntity.getSmartSubMode());
            sQLiteStatement.bindLong(86, deviceEntity.getDetectCat() ? 1 : 0);
            sQLiteStatement.bindLong(87, deviceEntity.getBodyMounted() ? 1 : 0);
            sQLiteStatement.bindLong(88, (long) deviceEntity.getCleanAirEta());
            sQLiteStatement.bindLong(89, (long) deviceEntity.getPanelDisplayMode());
            sQLiteStatement.bindLong(90, deviceEntity.getHoverEnabled() ? 1 : 0);
            sQLiteStatement.bindLong(91, deviceEntity.getAirRefreshEnabled() ? 1 : 0);
            sQLiteStatement.bindLong(92, (long) deviceEntity.getAirRefreshStatus());
            sQLiteStatement.bindLong(93, (long) deviceEntity.getAirRefreshDuration());
            sQLiteStatement.bindLong(94, (long) deviceEntity.getAirRefreshTimeStamp());
            sQLiteStatement.bindLong(95, (long) deviceEntity.getAirRefreshStartTimeStamp());
            sQLiteStatement.bindLong(96, (long) deviceEntity.getAirRefreshEndTimeStamp());
            sQLiteStatement.bindLong(97, (long) deviceEntity.getRoomType());
            sQLiteStatement.bindLong(98, (long) deviceEntity.getNightLampBrightness());
            sQLiteStatement.bindLong(99, (long) deviceEntity.getWickdryDuration());
            sQLiteStatement.bindLong(100, deviceEntity.getWickdryDone() ? 1 : 0);
            if (deviceEntity.getYwrmEnabled() != null) {
                num = Integer.valueOf(deviceEntity.getYwrmEnabled().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                sQLiteStatement.bindNull(101);
            } else {
                sQLiteStatement.bindLong(101, (long) num.intValue());
            }
            sQLiteStatement.bindLong(102, (long) deviceEntity.getYwrmUsage());
            sQLiteStatement.bindLong(103, (long) deviceEntity.getNightLampSteplessBrightness());
            String fromDeviceAlarmList = DeviceAlarmListConverter.fromDeviceAlarmList(deviceEntity.getAlarms());
            if (fromDeviceAlarmList == null) {
                sQLiteStatement.bindNull(104);
            } else {
                sQLiteStatement.bindText(104, fromDeviceAlarmList);
            }
            sQLiteStatement.bindLong(105, (long) deviceEntity.getHumSubMode());
            sQLiteStatement.bindLong(106, deviceEntity.getUse24Hour() ? 1 : 0);
            sQLiteStatement.bindLong(107, deviceEntity.getWaterInfill() ? 1 : 0);
            sQLiteStatement.bindLong(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (long) deviceEntity.getSensorMode());
            DeviceUuidEntity deviceUuid = deviceEntity.getDeviceUuid();
            if (deviceUuid != null) {
                if (deviceUuid.getUuid() == null) {
                    sQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                } else {
                    sQLiteStatement.bindText(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, deviceUuid.getUuid());
                }
                if (deviceUuid.getSsid() == null) {
                    sQLiteStatement.bindNull(110);
                } else {
                    sQLiteStatement.bindText(110, deviceUuid.getSsid());
                }
                if (deviceUuid.getBssid() == null) {
                    sQLiteStatement.bindNull(111);
                } else {
                    sQLiteStatement.bindText(111, deviceUuid.getBssid());
                }
                if (deviceUuid.getIpv4() == null) {
                    sQLiteStatement.bindNull(112);
                } else {
                    sQLiteStatement.bindText(112, deviceUuid.getIpv4());
                }
                if (deviceUuid.getIpv6() == null) {
                    sQLiteStatement.bindNull(113);
                } else {
                    sQLiteStatement.bindText(113, deviceUuid.getIpv6());
                }
            } else {
                sQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                sQLiteStatement.bindNull(110);
                sQLiteStatement.bindNull(111);
                sQLiteStatement.bindNull(112);
                sQLiteStatement.bindNull(113);
            }
            IndoorDatapoint latestSensorDatapoint = deviceEntity.getLatestSensorDatapoint();
            if (latestSensorDatapoint != null) {
                sQLiteStatement.bindLong(114, latestSensorDatapoint.getTimeInSeconds());
                if (latestSensorDatapoint.getPm1() == null) {
                    sQLiteStatement.bindNull(115);
                } else {
                    sQLiteStatement.bindDouble(115, (double) latestSensorDatapoint.getPm1().floatValue());
                }
                if (latestSensorDatapoint.getPm10() == null) {
                    sQLiteStatement.bindNull(116);
                } else {
                    sQLiteStatement.bindDouble(116, (double) latestSensorDatapoint.getPm10().floatValue());
                }
                if (latestSensorDatapoint.getPm25() == null) {
                    sQLiteStatement.bindNull(117);
                } else {
                    sQLiteStatement.bindDouble(117, (double) latestSensorDatapoint.getPm25().floatValue());
                }
                if (latestSensorDatapoint.getVoc() == null) {
                    sQLiteStatement.bindNull(118);
                } else {
                    sQLiteStatement.bindDouble(118, (double) latestSensorDatapoint.getVoc().floatValue());
                }
                if (latestSensorDatapoint.getHcho() == null) {
                    sQLiteStatement.bindNull(119);
                } else {
                    sQLiteStatement.bindDouble(119, (double) latestSensorDatapoint.getHcho().floatValue());
                }
                if (latestSensorDatapoint.getTmp() == null) {
                    sQLiteStatement.bindNull(MenuKt.InTransitionDuration);
                } else {
                    sQLiteStatement.bindDouble(MenuKt.InTransitionDuration, (double) latestSensorDatapoint.getTmp().floatValue());
                }
                if (latestSensorDatapoint.getHum() == null) {
                    sQLiteStatement.bindNull(121);
                } else {
                    sQLiteStatement.bindDouble(121, (double) latestSensorDatapoint.getHum().floatValue());
                }
                if (latestSensorDatapoint.getFan() == null) {
                    sQLiteStatement.bindNull(122);
                } else {
                    sQLiteStatement.bindDouble(122, (double) latestSensorDatapoint.getFan().floatValue());
                }
                if (latestSensorDatapoint.getWeight() == null) {
                    sQLiteStatement.bindNull(123);
                } else {
                    sQLiteStatement.bindDouble(123, (double) latestSensorDatapoint.getWeight().floatValue());
                }
            } else {
                sQLiteStatement.bindNull(114);
                sQLiteStatement.bindNull(115);
                sQLiteStatement.bindNull(116);
                sQLiteStatement.bindNull(117);
                sQLiteStatement.bindNull(118);
                sQLiteStatement.bindNull(119);
                sQLiteStatement.bindNull(MenuKt.InTransitionDuration);
                sQLiteStatement.bindNull(121);
                sQLiteStatement.bindNull(122);
                sQLiteStatement.bindNull(123);
            }
            WelcomeHomeLocation welcomeHome = deviceEntity.getWelcomeHome();
            if (welcomeHome != null) {
                sQLiteStatement.bindDouble(124, welcomeHome.getLat());
                sQLiteStatement.bindDouble(125, welcomeHome.getLng());
                sQLiteStatement.bindLong(WebSocketProtocol.PAYLOAD_SHORT, (long) welcomeHome.getRadius());
                if (welcomeHome.getTextValue() == null) {
                    sQLiteStatement.bindNull(127);
                } else {
                    sQLiteStatement.bindText(127, welcomeHome.getTextValue());
                }
                sQLiteStatement.bindLong(128, welcomeHome.isEnabled() ? 1 : 0);
                return;
            }
            sQLiteStatement.bindNull(124);
            sQLiteStatement.bindNull(125);
            sQLiteStatement.bindNull(WebSocketProtocol.PAYLOAD_SHORT);
            sQLiteStatement.bindNull(127);
            sQLiteStatement.bindNull(128);
        }
    };
    private final EntityDeleteOrUpdateAdapter<DeviceEntity> __updateAdapterOfDeviceEntity = new EntityDeleteOrUpdateAdapter<DeviceEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "UPDATE OR REPLACE `device_table` SET `uid` = ?,`name` = ?,`modelName` = ?,`typeIndex` = ?,`fanSpeed` = ?,`filterLife` = ?,`autoModeText` = ?,`brightness` = ?,`info` = ?,`hasFinishedOnboarding` = ?,`lastSelectedSensorType` = ?,`isAblDevice` = ?,`isNightModeOn` = ?,`isChildLockOn` = ?,`linkedDeviceUid` = ?,`connectivityStatusIndex` = ?,`lastConnectivityMillis` = ?,`mac` = ?,`mcuFirmware` = ?,`wifiFirmware` = ?,`hardware` = ?,`timeZone` = ?,`serial` = ?,`purchaseDate` = ?,`dealerName` = ?,`dealerCountry` = ?,`filterType` = ?,`filterTrigger` = ?,`pm1Ranges` = ?,`pm10Ranges` = ?,`pm25Ranges` = ?,`vocRanges` = ?,`hchoRanges` = ?,`updateProgress` = ?,`isStandByOn` = ?,`isEcoModeOn` = ?,`isHinsModeOn` = ?,`isHinsNightModeOn` = ?,`isG4NightModeOn` = ?,`isGermShieldOn` = ?,`isGermShieldNightModeOn` = ?,`isSafetySwitchOn` = ?,`g4NightModefilterTrigger` = ?,`aimInstalled` = ?,`sku` = ?,`compatibility` = ?,`locationId` = ?,`disinfection` = ?,`disinfectLeftTime` = ?,`disinfectLeftTimeUpdateTime` = ?,`wickdryEnabled` = ?,`wickdryOn` = ?,`wickdryLeftTime` = ?,`wickdryLeftTimeUpdateTime` = ?,`wickUsage` = ?,`waterShortage` = ?,`autoRh` = ?,`timerStatus` = ?,`timerDuration` = ?,`timerLeftTime` = ?,`timerLeftTimeUpdateTime` = ?,`temperatureUnit` = ?,`oscillationState` = ?,`oscillationAngle` = ?,`oscillationDirection` = ?,`oscillationFanSpeed` = ?,`mainMode` = ?,`apSubMode` = ?,`apFanSpeed` = ?,`heatSubMode` = ?,`heatFanSpeed` = ?,`heatAutoTmp` = ?,`heatEcoTmp` = ?,`coolSubMode` = ?,`coolFanSpeed` = ?,`coolAutoTag` = ?,`coolAutoPresets` = ?,`coolEcoTag` = ?,`coolEcoPresets` = ?,`humMode` = ?,`mode` = ?,`waterLevel` = ?,`dehSubMode` = ?,`waterTankFailure` = ?,`smartSubMode` = ?,`detectCat` = ?,`bodyMounted` = ?,`cleanAirEta` = ?,`panelDisplayMode` = ?,`hoverEnabled` = ?,`airRefreshEnabled` = ?,`airRefreshStatus` = ?,`airRefreshDuration` = ?,`airRefreshTimeStamp` = ?,`airRefreshStartTimeStamp` = ?,`airRefreshEndTimeStamp` = ?,`roomType` = ?,`nightLampBrightness` = ?,`wickdryDuration` = ?,`wickdryDone` = ?,`ywrmEnabled` = ?,`ywrmUsage` = ?,`nightLampSteplessBrightness` = ?,`alarms` = ?,`humSubMode` = ?,`use24Hour` = ?,`waterInfill` = ?,`sensorMode` = ?,`uuid` = ?,`ssid` = ?,`bssid` = ?,`ipv4` = ?,`ipv6` = ?,`timeInSeconds` = ?,`pm1` = ?,`pm10` = ?,`pm25` = ?,`voc` = ?,`hcho` = ?,`tmp` = ?,`hum` = ?,`fan` = ?,`weight` = ?,`lat` = ?,`lng` = ?,`radius` = ?,`textValue` = ?,`isEnabled` = ? WHERE `uid` = ?";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, DeviceEntity deviceEntity) {
            if (deviceEntity.getUid() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, deviceEntity.getUid());
            }
            if (deviceEntity.getName() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, deviceEntity.getName());
            }
            if (deviceEntity.getModelName() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, deviceEntity.getModelName());
            }
            sQLiteStatement.bindLong(4, (long) deviceEntity.getTypeIndex());
            if (deviceEntity.getFanSpeed() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindLong(5, (long) deviceEntity.getFanSpeed().intValue());
            }
            if (deviceEntity.getFilterLife() == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindLong(6, (long) deviceEntity.getFilterLife().intValue());
            }
            if (deviceEntity.getAutoModeText() == null) {
                sQLiteStatement.bindNull(7);
            } else {
                sQLiteStatement.bindText(7, deviceEntity.getAutoModeText());
            }
            if (deviceEntity.getBrightness() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindLong(8, (long) deviceEntity.getBrightness().intValue());
            }
            if (deviceEntity.getInfo() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindText(9, deviceEntity.getInfo());
            }
            sQLiteStatement.bindLong(10, deviceEntity.getHasFinishedOnboarding() ? 1 : 0);
            if (deviceEntity.getLastSelectedSensorType() == null) {
                sQLiteStatement.bindNull(11);
            } else {
                sQLiteStatement.bindLong(11, (long) deviceEntity.getLastSelectedSensorType().intValue());
            }
            sQLiteStatement.bindLong(12, deviceEntity.isAblDevice() ? 1 : 0);
            sQLiteStatement.bindLong(13, deviceEntity.isNightModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(14, deviceEntity.isChildLockOn() ? 1 : 0);
            if (deviceEntity.getLinkedDeviceUid() == null) {
                sQLiteStatement.bindNull(15);
            } else {
                sQLiteStatement.bindText(15, deviceEntity.getLinkedDeviceUid());
            }
            sQLiteStatement.bindLong(16, (long) deviceEntity.getConnectivityStatusIndex());
            sQLiteStatement.bindLong(17, deviceEntity.getLastConnectivityMillis());
            if (deviceEntity.getMac() == null) {
                sQLiteStatement.bindNull(18);
            } else {
                sQLiteStatement.bindText(18, deviceEntity.getMac());
            }
            if (deviceEntity.getMcuFirmware() == null) {
                sQLiteStatement.bindNull(19);
            } else {
                sQLiteStatement.bindText(19, deviceEntity.getMcuFirmware());
            }
            if (deviceEntity.getWifiFirmware() == null) {
                sQLiteStatement.bindNull(20);
            } else {
                sQLiteStatement.bindText(20, deviceEntity.getWifiFirmware());
            }
            if (deviceEntity.getHardware() == null) {
                sQLiteStatement.bindNull(21);
            } else {
                sQLiteStatement.bindText(21, deviceEntity.getHardware());
            }
            if (deviceEntity.getTimeZone() == null) {
                sQLiteStatement.bindNull(22);
            } else {
                sQLiteStatement.bindText(22, deviceEntity.getTimeZone());
            }
            if (deviceEntity.getSerial() == null) {
                sQLiteStatement.bindNull(23);
            } else {
                sQLiteStatement.bindText(23, deviceEntity.getSerial());
            }
            if (deviceEntity.getPurchaseDate() == null) {
                sQLiteStatement.bindNull(24);
            } else {
                sQLiteStatement.bindText(24, deviceEntity.getPurchaseDate());
            }
            if (deviceEntity.getDealerName() == null) {
                sQLiteStatement.bindNull(25);
            } else {
                sQLiteStatement.bindText(25, deviceEntity.getDealerName());
            }
            if (deviceEntity.getDealerCountry() == null) {
                sQLiteStatement.bindNull(26);
            } else {
                sQLiteStatement.bindText(26, deviceEntity.getDealerCountry());
            }
            if (deviceEntity.getFilterType() == null) {
                sQLiteStatement.bindNull(27);
            } else {
                sQLiteStatement.bindText(27, deviceEntity.getFilterType());
            }
            if (deviceEntity.getFilterTrigger() == null) {
                sQLiteStatement.bindNull(28);
            } else {
                sQLiteStatement.bindText(28, deviceEntity.getFilterTrigger());
            }
            String fromDoubleArray = DoubleArrayConverter.fromDoubleArray(deviceEntity.getPm1Ranges());
            if (fromDoubleArray == null) {
                sQLiteStatement.bindNull(29);
            } else {
                sQLiteStatement.bindText(29, fromDoubleArray);
            }
            String fromDoubleArray2 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getPm10Ranges());
            if (fromDoubleArray2 == null) {
                sQLiteStatement.bindNull(30);
            } else {
                sQLiteStatement.bindText(30, fromDoubleArray2);
            }
            String fromDoubleArray3 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getPm25Ranges());
            if (fromDoubleArray3 == null) {
                sQLiteStatement.bindNull(31);
            } else {
                sQLiteStatement.bindText(31, fromDoubleArray3);
            }
            String fromDoubleArray4 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getVocRanges());
            if (fromDoubleArray4 == null) {
                sQLiteStatement.bindNull(32);
            } else {
                sQLiteStatement.bindText(32, fromDoubleArray4);
            }
            String fromDoubleArray5 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getHchoRanges());
            if (fromDoubleArray5 == null) {
                sQLiteStatement.bindNull(33);
            } else {
                sQLiteStatement.bindText(33, fromDoubleArray5);
            }
            sQLiteStatement.bindLong(34, (long) deviceEntity.getUpdateProgress());
            sQLiteStatement.bindLong(35, deviceEntity.isStandByOn() ? 1 : 0);
            sQLiteStatement.bindLong(36, deviceEntity.isEcoModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(37, deviceEntity.isHinsModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(38, deviceEntity.isHinsNightModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(39, deviceEntity.isG4NightModeOn() ? 1 : 0);
            sQLiteStatement.bindLong(40, deviceEntity.isGermShieldOn() ? 1 : 0);
            Integer num = null;
            Integer valueOf = deviceEntity.isGermShieldNightModeOn() == null ? null : Integer.valueOf(deviceEntity.isGermShieldNightModeOn().booleanValue() ? 1 : 0);
            if (valueOf == null) {
                sQLiteStatement.bindNull(41);
            } else {
                sQLiteStatement.bindLong(41, (long) valueOf.intValue());
            }
            sQLiteStatement.bindLong(42, deviceEntity.isSafetySwitchOn() ? 1 : 0);
            if (deviceEntity.getG4NightModefilterTrigger() == null) {
                sQLiteStatement.bindNull(43);
            } else {
                sQLiteStatement.bindText(43, deviceEntity.getG4NightModefilterTrigger());
            }
            sQLiteStatement.bindLong(44, deviceEntity.getAimInstalled() ? 1 : 0);
            if (deviceEntity.getSku() == null) {
                sQLiteStatement.bindNull(45);
            } else {
                sQLiteStatement.bindText(45, deviceEntity.getSku());
            }
            if (deviceEntity.getCompatibility() == null) {
                sQLiteStatement.bindNull(46);
            } else {
                sQLiteStatement.bindText(46, deviceEntity.getCompatibility());
            }
            if (deviceEntity.getLocationId() == null) {
                sQLiteStatement.bindNull(47);
            } else {
                sQLiteStatement.bindText(47, deviceEntity.getLocationId());
            }
            Integer valueOf2 = deviceEntity.getDisinfection() == null ? null : Integer.valueOf(deviceEntity.getDisinfection().booleanValue() ? 1 : 0);
            if (valueOf2 == null) {
                sQLiteStatement.bindNull(48);
            } else {
                sQLiteStatement.bindLong(48, (long) valueOf2.intValue());
            }
            if (deviceEntity.getDisinfectLeftTime() == null) {
                sQLiteStatement.bindNull(49);
            } else {
                sQLiteStatement.bindLong(49, (long) deviceEntity.getDisinfectLeftTime().intValue());
            }
            if (deviceEntity.getDisinfectLeftTimeUpdateTime() == null) {
                sQLiteStatement.bindNull(50);
            } else {
                sQLiteStatement.bindLong(50, deviceEntity.getDisinfectLeftTimeUpdateTime().longValue());
            }
            sQLiteStatement.bindLong(51, deviceEntity.getWickdryEnabled() ? 1 : 0);
            sQLiteStatement.bindLong(52, deviceEntity.getWickdryOn() ? 1 : 0);
            sQLiteStatement.bindLong(53, (long) deviceEntity.getWickdryLeftTime());
            sQLiteStatement.bindLong(54, deviceEntity.getWickdryLeftTimeUpdateTime());
            sQLiteStatement.bindLong(55, (long) deviceEntity.getWickUsage());
            sQLiteStatement.bindLong(56, deviceEntity.getWaterShortage() ? 1 : 0);
            sQLiteStatement.bindLong(57, (long) deviceEntity.getAutoRh());
            sQLiteStatement.bindLong(58, (long) deviceEntity.getTimerStatus());
            sQLiteStatement.bindLong(59, (long) deviceEntity.getTimerDuration());
            sQLiteStatement.bindLong(60, (long) deviceEntity.getTimerLeftTime());
            sQLiteStatement.bindLong(61, deviceEntity.getTimerLeftTimeUpdateTime());
            sQLiteStatement.bindLong(62, (long) deviceEntity.getTemperatureUnit());
            sQLiteStatement.bindLong(63, (long) deviceEntity.getOscillationState());
            sQLiteStatement.bindLong(64, (long) deviceEntity.getOscillationAngle());
            sQLiteStatement.bindLong(65, (long) deviceEntity.getOscillationDirection());
            sQLiteStatement.bindLong(66, (long) deviceEntity.getOscillationFanSpeed());
            sQLiteStatement.bindLong(67, (long) deviceEntity.getMainMode());
            sQLiteStatement.bindLong(68, (long) deviceEntity.getApSubMode());
            sQLiteStatement.bindLong(69, (long) deviceEntity.getApFanSpeed());
            sQLiteStatement.bindLong(70, (long) deviceEntity.getHeatSubMode());
            sQLiteStatement.bindLong(71, (long) deviceEntity.getHeatFanSpeed());
            sQLiteStatement.bindDouble(72, deviceEntity.getHeatAutoTmp());
            sQLiteStatement.bindDouble(73, deviceEntity.getHeatEcoTmp());
            sQLiteStatement.bindLong(74, (long) deviceEntity.getCoolSubMode());
            sQLiteStatement.bindLong(75, (long) deviceEntity.getCoolFanSpeed());
            sQLiteStatement.bindLong(76, (long) deviceEntity.getCoolAutoTag());
            String fromDoubleArray6 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getCoolAutoPresets());
            if (fromDoubleArray6 == null) {
                sQLiteStatement.bindNull(77);
            } else {
                sQLiteStatement.bindText(77, fromDoubleArray6);
            }
            sQLiteStatement.bindLong(78, (long) deviceEntity.getCoolEcoTag());
            String fromDoubleArray7 = DoubleArrayConverter.fromDoubleArray(deviceEntity.getCoolEcoPresets());
            if (fromDoubleArray7 == null) {
                sQLiteStatement.bindNull(79);
            } else {
                sQLiteStatement.bindText(79, fromDoubleArray7);
            }
            sQLiteStatement.bindLong(80, deviceEntity.getHumMode() ? 1 : 0);
            sQLiteStatement.bindLong(81, (long) deviceEntity.getMode());
            sQLiteStatement.bindLong(82, (long) deviceEntity.getWaterLevel());
            sQLiteStatement.bindLong(83, (long) deviceEntity.getDehSubMode());
            sQLiteStatement.bindLong(84, deviceEntity.getWaterTankFailure() ? 1 : 0);
            sQLiteStatement.bindLong(85, (long) deviceEntity.getSmartSubMode());
            sQLiteStatement.bindLong(86, deviceEntity.getDetectCat() ? 1 : 0);
            sQLiteStatement.bindLong(87, deviceEntity.getBodyMounted() ? 1 : 0);
            sQLiteStatement.bindLong(88, (long) deviceEntity.getCleanAirEta());
            sQLiteStatement.bindLong(89, (long) deviceEntity.getPanelDisplayMode());
            sQLiteStatement.bindLong(90, deviceEntity.getHoverEnabled() ? 1 : 0);
            sQLiteStatement.bindLong(91, deviceEntity.getAirRefreshEnabled() ? 1 : 0);
            sQLiteStatement.bindLong(92, (long) deviceEntity.getAirRefreshStatus());
            sQLiteStatement.bindLong(93, (long) deviceEntity.getAirRefreshDuration());
            sQLiteStatement.bindLong(94, (long) deviceEntity.getAirRefreshTimeStamp());
            sQLiteStatement.bindLong(95, (long) deviceEntity.getAirRefreshStartTimeStamp());
            sQLiteStatement.bindLong(96, (long) deviceEntity.getAirRefreshEndTimeStamp());
            sQLiteStatement.bindLong(97, (long) deviceEntity.getRoomType());
            sQLiteStatement.bindLong(98, (long) deviceEntity.getNightLampBrightness());
            sQLiteStatement.bindLong(99, (long) deviceEntity.getWickdryDuration());
            sQLiteStatement.bindLong(100, deviceEntity.getWickdryDone() ? 1 : 0);
            if (deviceEntity.getYwrmEnabled() != null) {
                num = Integer.valueOf(deviceEntity.getYwrmEnabled().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                sQLiteStatement.bindNull(101);
            } else {
                sQLiteStatement.bindLong(101, (long) num.intValue());
            }
            sQLiteStatement.bindLong(102, (long) deviceEntity.getYwrmUsage());
            sQLiteStatement.bindLong(103, (long) deviceEntity.getNightLampSteplessBrightness());
            String fromDeviceAlarmList = DeviceAlarmListConverter.fromDeviceAlarmList(deviceEntity.getAlarms());
            if (fromDeviceAlarmList == null) {
                sQLiteStatement.bindNull(104);
            } else {
                sQLiteStatement.bindText(104, fromDeviceAlarmList);
            }
            sQLiteStatement.bindLong(105, (long) deviceEntity.getHumSubMode());
            sQLiteStatement.bindLong(106, deviceEntity.getUse24Hour() ? 1 : 0);
            sQLiteStatement.bindLong(107, deviceEntity.getWaterInfill() ? 1 : 0);
            sQLiteStatement.bindLong(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, (long) deviceEntity.getSensorMode());
            DeviceUuidEntity deviceUuid = deviceEntity.getDeviceUuid();
            if (deviceUuid != null) {
                if (deviceUuid.getUuid() == null) {
                    sQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                } else {
                    sQLiteStatement.bindText(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, deviceUuid.getUuid());
                }
                if (deviceUuid.getSsid() == null) {
                    sQLiteStatement.bindNull(110);
                } else {
                    sQLiteStatement.bindText(110, deviceUuid.getSsid());
                }
                if (deviceUuid.getBssid() == null) {
                    sQLiteStatement.bindNull(111);
                } else {
                    sQLiteStatement.bindText(111, deviceUuid.getBssid());
                }
                if (deviceUuid.getIpv4() == null) {
                    sQLiteStatement.bindNull(112);
                } else {
                    sQLiteStatement.bindText(112, deviceUuid.getIpv4());
                }
                if (deviceUuid.getIpv6() == null) {
                    sQLiteStatement.bindNull(113);
                } else {
                    sQLiteStatement.bindText(113, deviceUuid.getIpv6());
                }
            } else {
                sQLiteStatement.bindNull(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
                sQLiteStatement.bindNull(110);
                sQLiteStatement.bindNull(111);
                sQLiteStatement.bindNull(112);
                sQLiteStatement.bindNull(113);
            }
            IndoorDatapoint latestSensorDatapoint = deviceEntity.getLatestSensorDatapoint();
            if (latestSensorDatapoint != null) {
                sQLiteStatement.bindLong(114, latestSensorDatapoint.getTimeInSeconds());
                if (latestSensorDatapoint.getPm1() == null) {
                    sQLiteStatement.bindNull(115);
                } else {
                    sQLiteStatement.bindDouble(115, (double) latestSensorDatapoint.getPm1().floatValue());
                }
                if (latestSensorDatapoint.getPm10() == null) {
                    sQLiteStatement.bindNull(116);
                } else {
                    sQLiteStatement.bindDouble(116, (double) latestSensorDatapoint.getPm10().floatValue());
                }
                if (latestSensorDatapoint.getPm25() == null) {
                    sQLiteStatement.bindNull(117);
                } else {
                    sQLiteStatement.bindDouble(117, (double) latestSensorDatapoint.getPm25().floatValue());
                }
                if (latestSensorDatapoint.getVoc() == null) {
                    sQLiteStatement.bindNull(118);
                } else {
                    sQLiteStatement.bindDouble(118, (double) latestSensorDatapoint.getVoc().floatValue());
                }
                if (latestSensorDatapoint.getHcho() == null) {
                    sQLiteStatement.bindNull(119);
                } else {
                    sQLiteStatement.bindDouble(119, (double) latestSensorDatapoint.getHcho().floatValue());
                }
                if (latestSensorDatapoint.getTmp() == null) {
                    sQLiteStatement.bindNull(MenuKt.InTransitionDuration);
                } else {
                    sQLiteStatement.bindDouble(MenuKt.InTransitionDuration, (double) latestSensorDatapoint.getTmp().floatValue());
                }
                if (latestSensorDatapoint.getHum() == null) {
                    sQLiteStatement.bindNull(121);
                } else {
                    sQLiteStatement.bindDouble(121, (double) latestSensorDatapoint.getHum().floatValue());
                }
                if (latestSensorDatapoint.getFan() == null) {
                    sQLiteStatement.bindNull(122);
                } else {
                    sQLiteStatement.bindDouble(122, (double) latestSensorDatapoint.getFan().floatValue());
                }
                if (latestSensorDatapoint.getWeight() == null) {
                    sQLiteStatement.bindNull(123);
                } else {
                    sQLiteStatement.bindDouble(123, (double) latestSensorDatapoint.getWeight().floatValue());
                }
            } else {
                sQLiteStatement.bindNull(114);
                sQLiteStatement.bindNull(115);
                sQLiteStatement.bindNull(116);
                sQLiteStatement.bindNull(117);
                sQLiteStatement.bindNull(118);
                sQLiteStatement.bindNull(119);
                sQLiteStatement.bindNull(MenuKt.InTransitionDuration);
                sQLiteStatement.bindNull(121);
                sQLiteStatement.bindNull(122);
                sQLiteStatement.bindNull(123);
            }
            WelcomeHomeLocation welcomeHome = deviceEntity.getWelcomeHome();
            if (welcomeHome != null) {
                sQLiteStatement.bindDouble(124, welcomeHome.getLat());
                sQLiteStatement.bindDouble(125, welcomeHome.getLng());
                sQLiteStatement.bindLong(WebSocketProtocol.PAYLOAD_SHORT, (long) welcomeHome.getRadius());
                if (welcomeHome.getTextValue() == null) {
                    sQLiteStatement.bindNull(127);
                } else {
                    sQLiteStatement.bindText(127, welcomeHome.getTextValue());
                }
                sQLiteStatement.bindLong(128, welcomeHome.isEnabled() ? 1 : 0);
            } else {
                sQLiteStatement.bindNull(124);
                sQLiteStatement.bindNull(125);
                sQLiteStatement.bindNull(WebSocketProtocol.PAYLOAD_SHORT);
                sQLiteStatement.bindNull(127);
                sQLiteStatement.bindNull(128);
            }
            if (deviceEntity.getUid() == null) {
                sQLiteStatement.bindNull(129);
            } else {
                sQLiteStatement.bindText(129, deviceEntity.getUid());
            }
        }
    };

    public DeviceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public void insert(DeviceEntity deviceEntity) {
        deviceEntity.getClass();
        DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda55(this, deviceEntity));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$0$com-blueair-database-dao-DeviceDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m8291lambda$insert$0$comblueairdatabasedaoDeviceDao_Impl(DeviceEntity deviceEntity, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDeviceEntity.insert(sQLiteConnection, deviceEntity);
        return null;
    }

    public int update(DeviceEntity deviceEntity) {
        deviceEntity.getClass();
        return ((Integer) DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda96(this, deviceEntity))).intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$update$1$com-blueair-database-dao-DeviceDao_Impl  reason: not valid java name */
    public /* synthetic */ Integer m8292lambda$update$1$comblueairdatabasedaoDeviceDao_Impl(DeviceEntity deviceEntity, SQLiteConnection sQLiteConnection) {
        return Integer.valueOf(this.__updateAdapterOfDeviceEntity.handle(sQLiteConnection, deviceEntity));
    }

    public List<DeviceEntity> getDevices() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new DeviceDao_Impl$$ExternalSyntheticLambda92());
    }

    /* JADX WARNING: Removed duplicated region for block: B:316:0x0b0b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0b0e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0b1a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0b1d A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0b29 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0b2c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0b38 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0b3b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0b47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0b4a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0c28 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0c2f A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0c44 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0c47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0c58 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0c5c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0c6e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0c72 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0c84 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0c88 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0c9a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0c9e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0cb0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0cb4 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0cc6 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0cca A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0cdc A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0ce0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0d68 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0d74 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0d78 A[Catch:{ all -> 0x0e50 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.List lambda$getDevices$2(androidx.sqlite.SQLiteConnection r263) {
        /*
            java.lang.String r0 = "SELECT * from device_table ORDER BY modelName DESC"
            r1 = r263
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r0)
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0e50 }
            java.lang.String r2 = "name"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0e50 }
            java.lang.String r3 = "modelName"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0e50 }
            java.lang.String r4 = "typeIndex"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0e50 }
            java.lang.String r5 = "fanSpeed"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0e50 }
            java.lang.String r6 = "filterLife"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0e50 }
            java.lang.String r7 = "autoModeText"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0e50 }
            java.lang.String r8 = "brightness"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0e50 }
            java.lang.String r9 = "info"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0e50 }
            java.lang.String r10 = "hasFinishedOnboarding"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0e50 }
            java.lang.String r11 = "lastSelectedSensorType"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0e50 }
            java.lang.String r12 = "isAblDevice"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0e50 }
            java.lang.String r13 = "isNightModeOn"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0e50 }
            java.lang.String r14 = "isChildLockOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0e50 }
            java.lang.String r15 = "linkedDeviceUid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r263 = r15
            java.lang.String r15 = "connectivityStatusIndex"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r16 = r15
            java.lang.String r15 = "lastConnectivityMillis"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r17 = r15
            java.lang.String r15 = "mac"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r18 = r15
            java.lang.String r15 = "mcuFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r19 = r15
            java.lang.String r15 = "wifiFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r20 = r15
            java.lang.String r15 = "hardware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r21 = r15
            java.lang.String r15 = "timeZone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r22 = r15
            java.lang.String r15 = "serial"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r23 = r15
            java.lang.String r15 = "purchaseDate"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r24 = r15
            java.lang.String r15 = "dealerName"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r25 = r15
            java.lang.String r15 = "dealerCountry"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r26 = r15
            java.lang.String r15 = "filterType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r27 = r15
            java.lang.String r15 = "filterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r28 = r15
            java.lang.String r15 = "pm1Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r29 = r15
            java.lang.String r15 = "pm10Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r30 = r15
            java.lang.String r15 = "pm25Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r31 = r15
            java.lang.String r15 = "vocRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r32 = r15
            java.lang.String r15 = "hchoRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r33 = r15
            java.lang.String r15 = "updateProgress"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r34 = r15
            java.lang.String r15 = "isStandByOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r35 = r15
            java.lang.String r15 = "isEcoModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r36 = r15
            java.lang.String r15 = "isHinsModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r37 = r15
            java.lang.String r15 = "isHinsNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r38 = r15
            java.lang.String r15 = "isG4NightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r39 = r15
            java.lang.String r15 = "isGermShieldOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r40 = r15
            java.lang.String r15 = "isGermShieldNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r41 = r15
            java.lang.String r15 = "isSafetySwitchOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r42 = r15
            java.lang.String r15 = "g4NightModefilterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r43 = r15
            java.lang.String r15 = "aimInstalled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r44 = r15
            java.lang.String r15 = "sku"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r45 = r15
            java.lang.String r15 = "compatibility"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r46 = r15
            java.lang.String r15 = "locationId"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r47 = r15
            java.lang.String r15 = "disinfection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r48 = r15
            java.lang.String r15 = "disinfectLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r49 = r15
            java.lang.String r15 = "disinfectLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r50 = r15
            java.lang.String r15 = "wickdryEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r51 = r15
            java.lang.String r15 = "wickdryOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r52 = r15
            java.lang.String r15 = "wickdryLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r53 = r15
            java.lang.String r15 = "wickdryLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r54 = r15
            java.lang.String r15 = "wickUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r55 = r15
            java.lang.String r15 = "waterShortage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r56 = r15
            java.lang.String r15 = "autoRh"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r57 = r15
            java.lang.String r15 = "timerStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r58 = r15
            java.lang.String r15 = "timerDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r59 = r15
            java.lang.String r15 = "timerLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r60 = r15
            java.lang.String r15 = "timerLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r61 = r15
            java.lang.String r15 = "temperatureUnit"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r62 = r15
            java.lang.String r15 = "oscillationState"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r63 = r15
            java.lang.String r15 = "oscillationAngle"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r64 = r15
            java.lang.String r15 = "oscillationDirection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r65 = r15
            java.lang.String r15 = "oscillationFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r66 = r15
            java.lang.String r15 = "mainMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r67 = r15
            java.lang.String r15 = "apSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r68 = r15
            java.lang.String r15 = "apFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r69 = r15
            java.lang.String r15 = "heatSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r70 = r15
            java.lang.String r15 = "heatFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r71 = r15
            java.lang.String r15 = "heatAutoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r72 = r15
            java.lang.String r15 = "heatEcoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r73 = r15
            java.lang.String r15 = "coolSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r74 = r15
            java.lang.String r15 = "coolFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r75 = r15
            java.lang.String r15 = "coolAutoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r76 = r15
            java.lang.String r15 = "coolAutoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r77 = r15
            java.lang.String r15 = "coolEcoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r78 = r15
            java.lang.String r15 = "coolEcoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r79 = r15
            java.lang.String r15 = "humMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r80 = r15
            java.lang.String r15 = "mode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r81 = r15
            java.lang.String r15 = "waterLevel"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r82 = r15
            java.lang.String r15 = "dehSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r83 = r15
            java.lang.String r15 = "waterTankFailure"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r84 = r15
            java.lang.String r15 = "smartSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r85 = r15
            java.lang.String r15 = "detectCat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r86 = r15
            java.lang.String r15 = "bodyMounted"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r87 = r15
            java.lang.String r15 = "cleanAirEta"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r88 = r15
            java.lang.String r15 = "panelDisplayMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r89 = r15
            java.lang.String r15 = "hoverEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r90 = r15
            java.lang.String r15 = "airRefreshEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r91 = r15
            java.lang.String r15 = "airRefreshStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r92 = r15
            java.lang.String r15 = "airRefreshDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r93 = r15
            java.lang.String r15 = "airRefreshTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r94 = r15
            java.lang.String r15 = "airRefreshStartTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r95 = r15
            java.lang.String r15 = "airRefreshEndTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r96 = r15
            java.lang.String r15 = "roomType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r97 = r15
            java.lang.String r15 = "nightLampBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r98 = r15
            java.lang.String r15 = "wickdryDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r99 = r15
            java.lang.String r15 = "wickdryDone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r100 = r15
            java.lang.String r15 = "ywrmEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r101 = r15
            java.lang.String r15 = "ywrmUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r102 = r15
            java.lang.String r15 = "nightLampSteplessBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r103 = r15
            java.lang.String r15 = "alarms"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r104 = r15
            java.lang.String r15 = "humSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r105 = r15
            java.lang.String r15 = "use24Hour"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r106 = r15
            java.lang.String r15 = "waterInfill"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r107 = r15
            java.lang.String r15 = "sensorMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r108 = r15
            java.lang.String r15 = "uuid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r109 = r15
            java.lang.String r15 = "ssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r110 = r15
            java.lang.String r15 = "bssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r111 = r15
            java.lang.String r15 = "ipv4"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r112 = r15
            java.lang.String r15 = "ipv6"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r113 = r15
            java.lang.String r15 = "timeInSeconds"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r114 = r15
            java.lang.String r15 = "pm1"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r115 = r15
            java.lang.String r15 = "pm10"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r116 = r15
            java.lang.String r15 = "pm25"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r117 = r15
            java.lang.String r15 = "voc"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r118 = r15
            java.lang.String r15 = "hcho"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r119 = r15
            java.lang.String r15 = "tmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r120 = r15
            java.lang.String r15 = "hum"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r121 = r15
            java.lang.String r15 = "fan"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r122 = r15
            java.lang.String r15 = "weight"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r123 = r15
            java.lang.String r15 = "lat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r124 = r15
            java.lang.String r15 = "lng"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r125 = r15
            java.lang.String r15 = "radius"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r126 = r15
            java.lang.String r15 = "textValue"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r127 = r15
            java.lang.String r15 = "isEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r128 = r15
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0e50 }
            r15.<init>()     // Catch:{ all -> 0x0e50 }
        L_0x03f2:
            boolean r129 = r1.step()     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0e4c
            boolean r129 = r1.isNull(r0)     // Catch:{ all -> 0x0e50 }
            r130 = 0
            if (r129 == 0) goto L_0x0403
            r132 = r130
            goto L_0x0409
        L_0x0403:
            java.lang.String r129 = r1.getText(r0)     // Catch:{ all -> 0x0e50 }
            r132 = r129
        L_0x0409:
            boolean r129 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0412
            r133 = r130
            goto L_0x0418
        L_0x0412:
            java.lang.String r129 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r133 = r129
        L_0x0418:
            boolean r129 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0425
            r134 = r130
            r129 = r2
            r248 = r3
            goto L_0x042f
        L_0x0425:
            java.lang.String r129 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r134 = r129
            r248 = r3
            r129 = r2
        L_0x042f:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x043f
            r135 = r2
            r136 = r130
            goto L_0x044c
        L_0x043f:
            r135 = r2
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r136 = r2
        L_0x044c:
            boolean r2 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0455
            r137 = r130
            goto L_0x0460
        L_0x0455:
            long r2 = r1.getLong(r6)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r137 = r2
        L_0x0460:
            boolean r2 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0469
            r138 = r130
            goto L_0x046f
        L_0x0469:
            java.lang.String r2 = r1.getText(r7)     // Catch:{ all -> 0x0e50 }
            r138 = r2
        L_0x046f:
            boolean r2 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0478
            r139 = r130
            goto L_0x0483
        L_0x0478:
            long r2 = r1.getLong(r8)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r139 = r2
        L_0x0483:
            boolean r2 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x048c
            r140 = r130
            goto L_0x0492
        L_0x048c:
            java.lang.String r2 = r1.getText(r9)     // Catch:{ all -> 0x0e50 }
            r140 = r2
        L_0x0492:
            long r2 = r1.getLong(r10)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = 1
            r131 = 0
            if (r2 == 0) goto L_0x049f
            r142 = r3
            goto L_0x04a1
        L_0x049f:
            r142 = r131
        L_0x04a1:
            boolean r2 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x04ad
            r141 = r3
            r2 = r4
            r144 = r130
            goto L_0x04bb
        L_0x04ad:
            r141 = r3
            r2 = r4
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r144 = r3
        L_0x04bb:
            long r3 = r1.getLong(r12)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04c5
            r145 = r141
            goto L_0x04c7
        L_0x04c5:
            r145 = r131
        L_0x04c7:
            long r3 = r1.getLong(r13)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04d1
            r146 = r141
            goto L_0x04d3
        L_0x04d1:
            r146 = r131
        L_0x04d3:
            long r3 = r1.getLong(r14)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04dd
            r147 = r141
            goto L_0x04df
        L_0x04dd:
            r147 = r131
        L_0x04df:
            r3 = r263
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x04f1
            r148 = r130
        L_0x04e9:
            r263 = r2
            r4 = r16
            r16 = r3
            goto L_0x04f8
        L_0x04f1:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r148 = r4
            goto L_0x04e9
        L_0x04f8:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r17
            long r150 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r149 = r2
            r2 = r18
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0514
            r152 = r130
        L_0x050f:
            r18 = r2
            r2 = r19
            goto L_0x051b
        L_0x0514:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r152 = r17
            goto L_0x050f
        L_0x051b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0528
            r153 = r130
        L_0x0523:
            r19 = r2
            r2 = r20
            goto L_0x052f
        L_0x0528:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r153 = r17
            goto L_0x0523
        L_0x052f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x053c
            r154 = r130
        L_0x0537:
            r20 = r2
            r2 = r21
            goto L_0x0543
        L_0x053c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r154 = r17
            goto L_0x0537
        L_0x0543:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0550
            r155 = r130
        L_0x054b:
            r21 = r2
            r2 = r22
            goto L_0x0557
        L_0x0550:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r155 = r17
            goto L_0x054b
        L_0x0557:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0564
            r156 = r130
        L_0x055f:
            r22 = r2
            r2 = r23
            goto L_0x056b
        L_0x0564:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r156 = r17
            goto L_0x055f
        L_0x056b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0578
            r157 = r130
        L_0x0573:
            r23 = r2
            r2 = r24
            goto L_0x057f
        L_0x0578:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r157 = r17
            goto L_0x0573
        L_0x057f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x058c
            r158 = r130
        L_0x0587:
            r24 = r2
            r2 = r25
            goto L_0x0593
        L_0x058c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r158 = r17
            goto L_0x0587
        L_0x0593:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05a0
            r159 = r130
        L_0x059b:
            r25 = r2
            r2 = r26
            goto L_0x05a7
        L_0x05a0:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r159 = r17
            goto L_0x059b
        L_0x05a7:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05b4
            r160 = r130
        L_0x05af:
            r26 = r2
            r2 = r27
            goto L_0x05bb
        L_0x05b4:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r160 = r17
            goto L_0x05af
        L_0x05bb:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05c8
            r161 = r130
        L_0x05c3:
            r27 = r2
            r2 = r28
            goto L_0x05cf
        L_0x05c8:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r161 = r17
            goto L_0x05c3
        L_0x05cf:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05dc
            r162 = r130
        L_0x05d7:
            r28 = r2
            r2 = r29
            goto L_0x05e3
        L_0x05dc:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r162 = r17
            goto L_0x05d7
        L_0x05e3:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05ec
            r17 = r130
            goto L_0x05f0
        L_0x05ec:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x05f0:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r29 = r2
            r2 = r30
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0601
            r17 = r130
            goto L_0x0605
        L_0x0601:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0605:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r30 = r2
            r2 = r31
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0616
            r17 = r130
            goto L_0x061a
        L_0x0616:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x061a:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r31 = r2
            r2 = r32
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x062b
            r17 = r130
            goto L_0x062f
        L_0x062b:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x062f:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r32 = r2
            r2 = r33
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0640
            r17 = r130
            goto L_0x0644
        L_0x0640:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0644:
            double[] r167 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r33 = r2
            r17 = r4
            r2 = r34
            r34 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r168 = r3
            r4 = r35
            r35 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0665
            r169 = r141
            goto L_0x0667
        L_0x0665:
            r169 = r131
        L_0x0667:
            r2 = r36
            r36 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0675
            r170 = r141
            goto L_0x0677
        L_0x0675:
            r170 = r131
        L_0x0677:
            r3 = r37
            r37 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0685
            r171 = r141
            goto L_0x0687
        L_0x0685:
            r171 = r131
        L_0x0687:
            r5 = r2
            r4 = r38
            r38 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0696
            r172 = r141
            goto L_0x0698
        L_0x0696:
            r172 = r131
        L_0x0698:
            r2 = r39
            r39 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06a6
            r173 = r141
            goto L_0x06a8
        L_0x06a6:
            r173 = r131
        L_0x06a8:
            r3 = r40
            r40 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x06b6
            r174 = r141
            goto L_0x06b8
        L_0x06b6:
            r174 = r131
        L_0x06b8:
            r4 = r41
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x06c6
            r5 = r2
            r41 = r3
            r2 = r130
            goto L_0x06d2
        L_0x06c6:
            r5 = r2
            r41 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x06d2:
            if (r2 != 0) goto L_0x06db
            r175 = r130
        L_0x06d6:
            r2 = r42
            r42 = r4
            goto L_0x06ed
        L_0x06db:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x06e4
            r2 = r141
            goto L_0x06e6
        L_0x06e4:
            r2 = r131
        L_0x06e6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r175 = r2
            goto L_0x06d6
        L_0x06ed:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06f7
            r176 = r141
            goto L_0x06f9
        L_0x06f7:
            r176 = r131
        L_0x06f9:
            r3 = r43
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x070a
            r177 = r130
        L_0x0703:
            r43 = r2
            r4 = r44
            r44 = r3
            goto L_0x0711
        L_0x070a:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r177 = r4
            goto L_0x0703
        L_0x0711:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x071b
            r178 = r141
            goto L_0x071d
        L_0x071b:
            r178 = r131
        L_0x071d:
            r2 = r45
            boolean r3 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x072a
            r179 = r130
        L_0x0727:
            r3 = r46
            goto L_0x0731
        L_0x072a:
            java.lang.String r3 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r179 = r3
            goto L_0x0727
        L_0x0731:
            boolean r45 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r45 == 0) goto L_0x073e
            r180 = r130
        L_0x0739:
            r45 = r2
            r2 = r47
            goto L_0x0745
        L_0x073e:
            java.lang.String r45 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r180 = r45
            goto L_0x0739
        L_0x0745:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0752
            r182 = r130
        L_0x074d:
            r47 = r2
            r2 = r48
            goto L_0x0759
        L_0x0752:
            java.lang.String r46 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r182 = r46
            goto L_0x074d
        L_0x0759:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0766
            r48 = r3
            r46 = r4
            r3 = r130
            goto L_0x0773
        L_0x0766:
            r48 = r3
            r46 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0773:
            if (r3 != 0) goto L_0x077a
            r183 = r130
        L_0x0777:
            r3 = r49
            goto L_0x078c
        L_0x077a:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0783
            r3 = r141
            goto L_0x0785
        L_0x0783:
            r3 = r131
        L_0x0785:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r183 = r3
            goto L_0x0777
        L_0x078c:
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0799
            r49 = r5
            r184 = r130
        L_0x0796:
            r4 = r50
            goto L_0x07a7
        L_0x0799:
            r49 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0e50 }
            r184 = r4
            goto L_0x0796
        L_0x07a7:
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x07b6
            r185 = r130
        L_0x07af:
            r50 = r2
            r5 = r51
            r51 = r3
            goto L_0x07c1
        L_0x07b6:
            long r185 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            java.lang.Long r5 = java.lang.Long.valueOf(r185)     // Catch:{ all -> 0x0e50 }
            r185 = r5
            goto L_0x07af
        L_0x07c1:
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x07cb
            r186 = r141
            goto L_0x07cd
        L_0x07cb:
            r186 = r131
        L_0x07cd:
            r2 = r52
            r52 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x07db
            r187 = r141
            goto L_0x07dd
        L_0x07db:
            r187 = r131
        L_0x07dd:
            r3 = r53
            r53 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r54
            long r189 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            r54 = r2
            r188 = r4
            r2 = r55
            r55 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r191 = r3
            r4 = r56
            r56 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0809
            r192 = r141
            goto L_0x080b
        L_0x0809:
            r192 = r131
        L_0x080b:
            r2 = r57
            r57 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r193 = r3
            r4 = r58
            r58 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r249 = r4
            r3 = r59
            r59 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r194 = r2
            r5 = r60
            r60 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r61
            long r197 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r196 = r2
            r195 = r4
            r2 = r62
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r62 = r2
            r199 = r3
            r4 = r63
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r63 = r5
            r3 = r64
            r64 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r200 = r2
            r5 = r65
            r65 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r201 = r4
            r3 = r66
            r66 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r202 = r2
            r5 = r67
            r67 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r203 = r4
            r3 = r68
            r68 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r204 = r2
            r5 = r69
            r69 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r205 = r4
            r3 = r70
            r70 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r206 = r2
            r5 = r71
            r71 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r72
            double r209 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            r208 = r2
            r2 = r73
            double r211 = r1.getDouble(r2)     // Catch:{ all -> 0x0e50 }
            r73 = r2
            r72 = r3
            r207 = r4
            r2 = r74
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r74 = r2
            r213 = r3
            r4 = r75
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r75 = r5
            r3 = r76
            r76 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r77
            boolean r77 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r77 == 0) goto L_0x08e5
            r77 = r130
            goto L_0x08e9
        L_0x08e5:
            java.lang.String r77 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
        L_0x08e9:
            double[] r216 = com.blueair.database.DoubleArrayConverter.fromString(r77)     // Catch:{ all -> 0x0e50 }
            r214 = r2
            r77 = r3
            r215 = r4
            r2 = r78
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r4 = r79
            boolean r78 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r78 == 0) goto L_0x0905
            r78 = r130
            goto L_0x0909
        L_0x0905:
            java.lang.String r78 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
        L_0x0909:
            double[] r218 = com.blueair.database.DoubleArrayConverter.fromString(r78)     // Catch:{ all -> 0x0e50 }
            r78 = r2
            r217 = r3
            r79 = r4
            r2 = r80
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x091f
            r219 = r141
            goto L_0x0921
        L_0x091f:
            r219 = r131
        L_0x0921:
            r80 = r5
            r3 = r81
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r81 = r2
            r5 = r82
            r82 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r220 = r4
            r3 = r83
            r83 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r221 = r2
            r5 = r84
            r84 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0950
            r223 = r141
            goto L_0x0952
        L_0x0950:
            r223 = r131
        L_0x0952:
            r222 = r4
            r2 = r85
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r85 = r2
            r224 = r3
            r4 = r86
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x096b
            r225 = r141
            goto L_0x096d
        L_0x096b:
            r225 = r131
        L_0x096d:
            r86 = r4
            r2 = r87
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x097b
            r226 = r141
            goto L_0x097d
        L_0x097b:
            r226 = r131
        L_0x097d:
            r87 = r5
            r3 = r88
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r88 = r2
            r5 = r89
            r89 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r227 = r4
            r3 = r90
            r90 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x09a1
            r229 = r141
            goto L_0x09a3
        L_0x09a1:
            r229 = r131
        L_0x09a3:
            r228 = r2
            r5 = r3
            r4 = r91
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x09b2
            r230 = r141
            goto L_0x09b4
        L_0x09b2:
            r230 = r131
        L_0x09b4:
            r91 = r4
            r2 = r92
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r92 = r2
            r231 = r3
            r4 = r93
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r93 = r5
            r3 = r94
            r94 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r232 = r2
            r5 = r95
            r95 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r233 = r4
            r3 = r96
            r96 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r234 = r2
            r5 = r97
            r97 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r235 = r4
            r3 = r98
            r98 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r236 = r2
            r5 = r99
            r99 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r237 = r4
            r3 = r100
            r100 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0a1a
            r239 = r141
            goto L_0x0a1c
        L_0x0a1a:
            r239 = r131
        L_0x0a1c:
            r4 = r101
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x0a2a
            r238 = r2
            r5 = r3
            r2 = r130
            goto L_0x0a36
        L_0x0a2a:
            r238 = r2
            r5 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0a36:
            if (r2 != 0) goto L_0x0a3f
            r240 = r130
        L_0x0a3a:
            r101 = r4
            r2 = r102
            goto L_0x0a51
        L_0x0a3f:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a48
            r2 = r141
            goto L_0x0a4a
        L_0x0a48:
            r2 = r131
        L_0x0a4a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r240 = r2
            goto L_0x0a3a
        L_0x0a51:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r102 = r2
            r241 = r3
            r4 = r103
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r104
            boolean r103 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r103 == 0) goto L_0x0a6c
            r103 = r130
            goto L_0x0a70
        L_0x0a6c:
            java.lang.String r103 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0a70:
            java.util.List r243 = com.blueair.database.DeviceAlarmListConverter.fromString(r103)     // Catch:{ all -> 0x0e50 }
            r242 = r2
            r104 = r3
            r103 = r4
            r2 = r105
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r105 = r2
            r244 = r3
            r4 = r106
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a91
            r245 = r141
            goto L_0x0a93
        L_0x0a91:
            r245 = r131
        L_0x0a93:
            r106 = r4
            r2 = r107
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0aa1
            r246 = r141
            goto L_0x0aa3
        L_0x0aa1:
            r246 = r131
        L_0x0aa3:
            r107 = r5
            r3 = r108
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r109
            boolean r108 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r108 == 0) goto L_0x0af5
            r108 = r2
            r2 = r110
            boolean r109 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r109 == 0) goto L_0x0aea
            r109 = r3
            r3 = r111
            boolean r110 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0ae5
            r247 = r4
            r4 = r112
            boolean r110 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0b01
            r110 = r6
            r6 = r113
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 != 0) goto L_0x0add
            goto L_0x0b05
        L_0x0add:
            r250 = r130
        L_0x0adf:
            r111 = r2
            r2 = r114
            goto L_0x0b56
        L_0x0ae5:
            r247 = r4
            r110 = r6
            goto L_0x0af2
        L_0x0aea:
            r109 = r3
            r247 = r4
            r110 = r6
            r3 = r111
        L_0x0af2:
            r4 = r112
            goto L_0x0b03
        L_0x0af5:
            r108 = r2
            r109 = r3
            r247 = r4
            r2 = r110
            r3 = r111
            r4 = r112
        L_0x0b01:
            r110 = r6
        L_0x0b03:
            r6 = r113
        L_0x0b05:
            boolean r111 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b0e
            r251 = r130
            goto L_0x0b14
        L_0x0b0e:
            java.lang.String r111 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
            r251 = r111
        L_0x0b14:
            boolean r111 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b1d
            r252 = r130
            goto L_0x0b23
        L_0x0b1d:
            java.lang.String r111 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r252 = r111
        L_0x0b23:
            boolean r111 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b2c
            r253 = r130
            goto L_0x0b32
        L_0x0b2c:
            java.lang.String r111 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r253 = r111
        L_0x0b32:
            boolean r111 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b3b
            r254 = r130
            goto L_0x0b41
        L_0x0b3b:
            java.lang.String r111 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
            r254 = r111
        L_0x0b41:
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b4a
            r255 = r130
            goto L_0x0b50
        L_0x0b4a:
            java.lang.String r111 = r1.getText(r6)     // Catch:{ all -> 0x0e50 }
            r255 = r111
        L_0x0b50:
            com.blueair.database.DeviceUuidEntity r250 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0e50 }
            r250.<init>(r251, r252, r253, r254, r255)     // Catch:{ all -> 0x0e50 }
            goto L_0x0adf
        L_0x0b56:
            boolean r112 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r112 == 0) goto L_0x0bfa
            r112 = r3
            r3 = r115
            boolean r113 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r113 == 0) goto L_0x0bdd
            r113 = r4
            r4 = r116
            boolean r114 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r114 == 0) goto L_0x0bc2
            r114 = r5
            r5 = r117
            boolean r115 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r115 == 0) goto L_0x0c06
            r115 = r6
            r6 = r118
            boolean r116 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r116 == 0) goto L_0x0be9
            r116 = r7
            r7 = r119
            boolean r117 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r117 == 0) goto L_0x0bce
            r117 = r8
            r8 = r120
            boolean r118 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r118 == 0) goto L_0x0c12
            r118 = r9
            r9 = r121
            boolean r119 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r119 == 0) goto L_0x0bf5
            r119 = r10
            r10 = r122
            boolean r120 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r120 == 0) goto L_0x0bda
            r120 = r11
            r11 = r123
            boolean r121 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r121 != 0) goto L_0x0bb8
            goto L_0x0c1e
        L_0x0bb8:
            r121 = r12
            r122 = r13
            r143 = r130
        L_0x0bbe:
            r12 = r124
            goto L_0x0cf5
        L_0x0bc2:
            r114 = r5
            r115 = r6
            r116 = r7
            r5 = r117
            r6 = r118
            r7 = r119
        L_0x0bce:
            r117 = r8
            r118 = r9
            r119 = r10
            r8 = r120
            r9 = r121
            r10 = r122
        L_0x0bda:
            r120 = r11
            goto L_0x0c1c
        L_0x0bdd:
            r113 = r4
            r114 = r5
            r115 = r6
            r4 = r116
            r5 = r117
            r6 = r118
        L_0x0be9:
            r116 = r7
            r117 = r8
            r118 = r9
            r7 = r119
            r8 = r120
            r9 = r121
        L_0x0bf5:
            r119 = r10
            r120 = r11
            goto L_0x0c1a
        L_0x0bfa:
            r112 = r3
            r113 = r4
            r114 = r5
            r3 = r115
            r4 = r116
            r5 = r117
        L_0x0c06:
            r115 = r6
            r116 = r7
            r117 = r8
            r6 = r118
            r7 = r119
            r8 = r120
        L_0x0c12:
            r118 = r9
            r119 = r10
            r120 = r11
            r9 = r121
        L_0x0c1a:
            r10 = r122
        L_0x0c1c:
            r11 = r123
        L_0x0c1e:
            long r252 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            boolean r121 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r121 == 0) goto L_0x0c2f
            r121 = r12
            r122 = r13
            r254 = r130
            goto L_0x0c3e
        L_0x0c2f:
            r121 = r12
            r122 = r13
            double r12 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r254 = r12
        L_0x0c3e:
            boolean r12 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c47
            r255 = r130
            goto L_0x0c52
        L_0x0c47:
            double r12 = r1.getDouble(r4)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r255 = r12
        L_0x0c52:
            boolean r12 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c5c
            r256 = r130
            goto L_0x0c68
        L_0x0c5c:
            double r12 = r1.getDouble(r5)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r256 = r12
        L_0x0c68:
            boolean r12 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c72
            r257 = r130
            goto L_0x0c7e
        L_0x0c72:
            double r12 = r1.getDouble(r6)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r257 = r12
        L_0x0c7e:
            boolean r12 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c88
            r258 = r130
            goto L_0x0c94
        L_0x0c88:
            double r12 = r1.getDouble(r7)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r258 = r12
        L_0x0c94:
            boolean r12 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c9e
            r259 = r130
            goto L_0x0caa
        L_0x0c9e:
            double r12 = r1.getDouble(r8)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r259 = r12
        L_0x0caa:
            boolean r12 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cb4
            r260 = r130
            goto L_0x0cc0
        L_0x0cb4:
            double r12 = r1.getDouble(r9)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r260 = r12
        L_0x0cc0:
            boolean r12 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cca
            r261 = r130
            goto L_0x0cd6
        L_0x0cca:
            double r12 = r1.getDouble(r10)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r261 = r12
        L_0x0cd6:
            boolean r12 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0ce0
            r262 = r130
            goto L_0x0cec
        L_0x0ce0:
            double r12 = r1.getDouble(r11)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r262 = r12
        L_0x0cec:
            com.blueair.core.model.IndoorDatapoint r251 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0e50 }
            r251.<init>(r252, r254, r255, r256, r257, r258, r259, r260, r261, r262)     // Catch:{ all -> 0x0e50 }
            r143 = r251
            goto L_0x0bbe
        L_0x0cf5:
            boolean r13 = r1.isNull(r12)     // Catch:{ all -> 0x0e50 }
            if (r13 == 0) goto L_0x0d3c
            r13 = r125
            boolean r123 = r1.isNull(r13)     // Catch:{ all -> 0x0e50 }
            if (r123 == 0) goto L_0x0d31
            r123 = r2
            r2 = r126
            boolean r124 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r124 == 0) goto L_0x0d2c
            r124 = r3
            r3 = r127
            boolean r125 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r125 == 0) goto L_0x0d46
            r125 = r4
            r4 = r128
            boolean r126 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r126 != 0) goto L_0x0d22
            goto L_0x0d4a
        L_0x0d22:
            r128 = r3
            r126 = r5
            r127 = r6
            r181 = r130
            r6 = r2
            goto L_0x0d85
        L_0x0d2c:
            r124 = r3
            r125 = r4
            goto L_0x0d39
        L_0x0d31:
            r123 = r2
            r124 = r3
            r125 = r4
            r2 = r126
        L_0x0d39:
            r3 = r127
            goto L_0x0d48
        L_0x0d3c:
            r123 = r2
            r124 = r3
            r13 = r125
            r2 = r126
            r3 = r127
        L_0x0d46:
            r125 = r4
        L_0x0d48:
            r4 = r128
        L_0x0d4a:
            double r252 = r1.getDouble(r12)     // Catch:{ all -> 0x0e50 }
            double r254 = r1.getDouble(r13)     // Catch:{ all -> 0x0e50 }
            r126 = r5
            r127 = r6
            long r5 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r5 = (int) r5     // Catch:{ all -> 0x0e50 }
            boolean r6 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r6 == 0) goto L_0x0d68
        L_0x0d61:
            r6 = r2
            r128 = r3
            r257 = r130
            goto L_0x0d6d
        L_0x0d68:
            java.lang.String r130 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            goto L_0x0d61
        L_0x0d6d:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0d78
            r258 = r141
            goto L_0x0d7b
        L_0x0d78:
            r258 = r131
        L_0x0d7b:
            com.blueair.core.model.WelcomeHomeLocation r251 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0e50 }
            r256 = r5
            r251.<init>(r252, r254, r256, r257, r258)     // Catch:{ all -> 0x0e50 }
            r181 = r251
        L_0x0d85:
            com.blueair.database.entity.DeviceEntity r131 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0e50 }
            r141 = r250
            r131.<init>(r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r191, r192, r193, r194, r195, r196, r197, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r211, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247)     // Catch:{ all -> 0x0e50 }
            r2 = r131
            r15.add(r2)     // Catch:{ all -> 0x0e50 }
            r2 = r4
            r4 = r263
            r263 = r16
            r16 = r17
            r17 = r34
            r34 = r35
            r35 = r36
            r36 = r40
            r40 = r41
            r41 = r42
            r42 = r43
            r43 = r44
            r44 = r46
            r46 = r48
            r48 = r50
            r50 = r52
            r52 = r54
            r54 = r59
            r59 = r60
            r60 = r63
            r63 = r64
            r64 = r65
            r65 = r66
            r66 = r67
            r67 = r68
            r68 = r69
            r69 = r70
            r70 = r71
            r71 = r75
            r75 = r76
            r76 = r77
            r77 = r80
            r80 = r81
            r81 = r82
            r82 = r83
            r83 = r84
            r84 = r87
            r87 = r88
            r88 = r89
            r89 = r90
            r90 = r93
            r93 = r94
            r94 = r95
            r95 = r96
            r96 = r97
            r97 = r98
            r98 = r99
            r99 = r100
            r100 = r107
            r107 = r108
            r108 = r109
            r109 = r114
            r114 = r123
            r123 = r11
            r11 = r120
            r120 = r8
            r8 = r117
            r117 = r126
            r126 = r6
            r6 = r110
            r110 = r111
            r111 = r112
            r112 = r113
            r113 = r115
            r115 = r124
            r124 = r12
            r12 = r121
            r121 = r9
            r9 = r118
            r118 = r127
            r127 = r128
            r128 = r2
            r2 = r119
            r119 = r7
            r7 = r116
            r116 = r125
            r125 = r13
            r13 = r122
            r122 = r10
            r10 = r2
            r5 = r37
            r37 = r38
            r38 = r39
            r39 = r49
            r49 = r51
            r51 = r53
            r53 = r55
            r55 = r56
            r56 = r57
            r57 = r58
            r2 = r129
            r3 = r248
            r58 = r249
            goto L_0x03f2
        L_0x0e4c:
            r1.close()
            return r15
        L_0x0e50:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$getDevices$2(androidx.sqlite.SQLiteConnection):java.util.List");
    }

    public Object getDevices(Continuation<? super List<DeviceEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new DeviceDao_Impl$$ExternalSyntheticLambda5(), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:316:0x0b0b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0b0e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0b1a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0b1d A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0b29 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0b2c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0b38 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0b3b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0b47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0b4a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0c28 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0c2f A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0c44 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0c47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0c58 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0c5c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0c6e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0c72 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0c84 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0c88 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0c9a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0c9e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0cb0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0cb4 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0cc6 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0cca A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0cdc A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0ce0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0d68 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0d74 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0d78 A[Catch:{ all -> 0x0e50 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.List lambda$getDevices$3(androidx.sqlite.SQLiteConnection r263) {
        /*
            java.lang.String r0 = "SELECT * from device_table ORDER BY modelName DESC"
            r1 = r263
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r0)
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0e50 }
            java.lang.String r2 = "name"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0e50 }
            java.lang.String r3 = "modelName"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0e50 }
            java.lang.String r4 = "typeIndex"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0e50 }
            java.lang.String r5 = "fanSpeed"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0e50 }
            java.lang.String r6 = "filterLife"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0e50 }
            java.lang.String r7 = "autoModeText"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0e50 }
            java.lang.String r8 = "brightness"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0e50 }
            java.lang.String r9 = "info"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0e50 }
            java.lang.String r10 = "hasFinishedOnboarding"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0e50 }
            java.lang.String r11 = "lastSelectedSensorType"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0e50 }
            java.lang.String r12 = "isAblDevice"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0e50 }
            java.lang.String r13 = "isNightModeOn"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0e50 }
            java.lang.String r14 = "isChildLockOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0e50 }
            java.lang.String r15 = "linkedDeviceUid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r263 = r15
            java.lang.String r15 = "connectivityStatusIndex"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r16 = r15
            java.lang.String r15 = "lastConnectivityMillis"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r17 = r15
            java.lang.String r15 = "mac"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r18 = r15
            java.lang.String r15 = "mcuFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r19 = r15
            java.lang.String r15 = "wifiFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r20 = r15
            java.lang.String r15 = "hardware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r21 = r15
            java.lang.String r15 = "timeZone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r22 = r15
            java.lang.String r15 = "serial"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r23 = r15
            java.lang.String r15 = "purchaseDate"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r24 = r15
            java.lang.String r15 = "dealerName"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r25 = r15
            java.lang.String r15 = "dealerCountry"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r26 = r15
            java.lang.String r15 = "filterType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r27 = r15
            java.lang.String r15 = "filterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r28 = r15
            java.lang.String r15 = "pm1Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r29 = r15
            java.lang.String r15 = "pm10Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r30 = r15
            java.lang.String r15 = "pm25Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r31 = r15
            java.lang.String r15 = "vocRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r32 = r15
            java.lang.String r15 = "hchoRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r33 = r15
            java.lang.String r15 = "updateProgress"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r34 = r15
            java.lang.String r15 = "isStandByOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r35 = r15
            java.lang.String r15 = "isEcoModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r36 = r15
            java.lang.String r15 = "isHinsModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r37 = r15
            java.lang.String r15 = "isHinsNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r38 = r15
            java.lang.String r15 = "isG4NightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r39 = r15
            java.lang.String r15 = "isGermShieldOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r40 = r15
            java.lang.String r15 = "isGermShieldNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r41 = r15
            java.lang.String r15 = "isSafetySwitchOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r42 = r15
            java.lang.String r15 = "g4NightModefilterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r43 = r15
            java.lang.String r15 = "aimInstalled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r44 = r15
            java.lang.String r15 = "sku"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r45 = r15
            java.lang.String r15 = "compatibility"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r46 = r15
            java.lang.String r15 = "locationId"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r47 = r15
            java.lang.String r15 = "disinfection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r48 = r15
            java.lang.String r15 = "disinfectLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r49 = r15
            java.lang.String r15 = "disinfectLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r50 = r15
            java.lang.String r15 = "wickdryEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r51 = r15
            java.lang.String r15 = "wickdryOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r52 = r15
            java.lang.String r15 = "wickdryLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r53 = r15
            java.lang.String r15 = "wickdryLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r54 = r15
            java.lang.String r15 = "wickUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r55 = r15
            java.lang.String r15 = "waterShortage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r56 = r15
            java.lang.String r15 = "autoRh"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r57 = r15
            java.lang.String r15 = "timerStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r58 = r15
            java.lang.String r15 = "timerDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r59 = r15
            java.lang.String r15 = "timerLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r60 = r15
            java.lang.String r15 = "timerLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r61 = r15
            java.lang.String r15 = "temperatureUnit"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r62 = r15
            java.lang.String r15 = "oscillationState"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r63 = r15
            java.lang.String r15 = "oscillationAngle"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r64 = r15
            java.lang.String r15 = "oscillationDirection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r65 = r15
            java.lang.String r15 = "oscillationFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r66 = r15
            java.lang.String r15 = "mainMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r67 = r15
            java.lang.String r15 = "apSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r68 = r15
            java.lang.String r15 = "apFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r69 = r15
            java.lang.String r15 = "heatSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r70 = r15
            java.lang.String r15 = "heatFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r71 = r15
            java.lang.String r15 = "heatAutoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r72 = r15
            java.lang.String r15 = "heatEcoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r73 = r15
            java.lang.String r15 = "coolSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r74 = r15
            java.lang.String r15 = "coolFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r75 = r15
            java.lang.String r15 = "coolAutoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r76 = r15
            java.lang.String r15 = "coolAutoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r77 = r15
            java.lang.String r15 = "coolEcoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r78 = r15
            java.lang.String r15 = "coolEcoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r79 = r15
            java.lang.String r15 = "humMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r80 = r15
            java.lang.String r15 = "mode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r81 = r15
            java.lang.String r15 = "waterLevel"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r82 = r15
            java.lang.String r15 = "dehSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r83 = r15
            java.lang.String r15 = "waterTankFailure"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r84 = r15
            java.lang.String r15 = "smartSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r85 = r15
            java.lang.String r15 = "detectCat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r86 = r15
            java.lang.String r15 = "bodyMounted"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r87 = r15
            java.lang.String r15 = "cleanAirEta"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r88 = r15
            java.lang.String r15 = "panelDisplayMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r89 = r15
            java.lang.String r15 = "hoverEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r90 = r15
            java.lang.String r15 = "airRefreshEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r91 = r15
            java.lang.String r15 = "airRefreshStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r92 = r15
            java.lang.String r15 = "airRefreshDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r93 = r15
            java.lang.String r15 = "airRefreshTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r94 = r15
            java.lang.String r15 = "airRefreshStartTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r95 = r15
            java.lang.String r15 = "airRefreshEndTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r96 = r15
            java.lang.String r15 = "roomType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r97 = r15
            java.lang.String r15 = "nightLampBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r98 = r15
            java.lang.String r15 = "wickdryDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r99 = r15
            java.lang.String r15 = "wickdryDone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r100 = r15
            java.lang.String r15 = "ywrmEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r101 = r15
            java.lang.String r15 = "ywrmUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r102 = r15
            java.lang.String r15 = "nightLampSteplessBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r103 = r15
            java.lang.String r15 = "alarms"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r104 = r15
            java.lang.String r15 = "humSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r105 = r15
            java.lang.String r15 = "use24Hour"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r106 = r15
            java.lang.String r15 = "waterInfill"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r107 = r15
            java.lang.String r15 = "sensorMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r108 = r15
            java.lang.String r15 = "uuid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r109 = r15
            java.lang.String r15 = "ssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r110 = r15
            java.lang.String r15 = "bssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r111 = r15
            java.lang.String r15 = "ipv4"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r112 = r15
            java.lang.String r15 = "ipv6"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r113 = r15
            java.lang.String r15 = "timeInSeconds"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r114 = r15
            java.lang.String r15 = "pm1"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r115 = r15
            java.lang.String r15 = "pm10"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r116 = r15
            java.lang.String r15 = "pm25"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r117 = r15
            java.lang.String r15 = "voc"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r118 = r15
            java.lang.String r15 = "hcho"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r119 = r15
            java.lang.String r15 = "tmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r120 = r15
            java.lang.String r15 = "hum"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r121 = r15
            java.lang.String r15 = "fan"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r122 = r15
            java.lang.String r15 = "weight"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r123 = r15
            java.lang.String r15 = "lat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r124 = r15
            java.lang.String r15 = "lng"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r125 = r15
            java.lang.String r15 = "radius"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r126 = r15
            java.lang.String r15 = "textValue"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r127 = r15
            java.lang.String r15 = "isEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r128 = r15
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0e50 }
            r15.<init>()     // Catch:{ all -> 0x0e50 }
        L_0x03f2:
            boolean r129 = r1.step()     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0e4c
            boolean r129 = r1.isNull(r0)     // Catch:{ all -> 0x0e50 }
            r130 = 0
            if (r129 == 0) goto L_0x0403
            r132 = r130
            goto L_0x0409
        L_0x0403:
            java.lang.String r129 = r1.getText(r0)     // Catch:{ all -> 0x0e50 }
            r132 = r129
        L_0x0409:
            boolean r129 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0412
            r133 = r130
            goto L_0x0418
        L_0x0412:
            java.lang.String r129 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r133 = r129
        L_0x0418:
            boolean r129 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0425
            r134 = r130
            r129 = r2
            r248 = r3
            goto L_0x042f
        L_0x0425:
            java.lang.String r129 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r134 = r129
            r248 = r3
            r129 = r2
        L_0x042f:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x043f
            r135 = r2
            r136 = r130
            goto L_0x044c
        L_0x043f:
            r135 = r2
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r136 = r2
        L_0x044c:
            boolean r2 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0455
            r137 = r130
            goto L_0x0460
        L_0x0455:
            long r2 = r1.getLong(r6)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r137 = r2
        L_0x0460:
            boolean r2 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0469
            r138 = r130
            goto L_0x046f
        L_0x0469:
            java.lang.String r2 = r1.getText(r7)     // Catch:{ all -> 0x0e50 }
            r138 = r2
        L_0x046f:
            boolean r2 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0478
            r139 = r130
            goto L_0x0483
        L_0x0478:
            long r2 = r1.getLong(r8)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r139 = r2
        L_0x0483:
            boolean r2 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x048c
            r140 = r130
            goto L_0x0492
        L_0x048c:
            java.lang.String r2 = r1.getText(r9)     // Catch:{ all -> 0x0e50 }
            r140 = r2
        L_0x0492:
            long r2 = r1.getLong(r10)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = 1
            r131 = 0
            if (r2 == 0) goto L_0x049f
            r142 = r3
            goto L_0x04a1
        L_0x049f:
            r142 = r131
        L_0x04a1:
            boolean r2 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x04ad
            r141 = r3
            r2 = r4
            r144 = r130
            goto L_0x04bb
        L_0x04ad:
            r141 = r3
            r2 = r4
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r144 = r3
        L_0x04bb:
            long r3 = r1.getLong(r12)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04c5
            r145 = r141
            goto L_0x04c7
        L_0x04c5:
            r145 = r131
        L_0x04c7:
            long r3 = r1.getLong(r13)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04d1
            r146 = r141
            goto L_0x04d3
        L_0x04d1:
            r146 = r131
        L_0x04d3:
            long r3 = r1.getLong(r14)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04dd
            r147 = r141
            goto L_0x04df
        L_0x04dd:
            r147 = r131
        L_0x04df:
            r3 = r263
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x04f1
            r148 = r130
        L_0x04e9:
            r263 = r2
            r4 = r16
            r16 = r3
            goto L_0x04f8
        L_0x04f1:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r148 = r4
            goto L_0x04e9
        L_0x04f8:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r17
            long r150 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r149 = r2
            r2 = r18
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0514
            r152 = r130
        L_0x050f:
            r18 = r2
            r2 = r19
            goto L_0x051b
        L_0x0514:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r152 = r17
            goto L_0x050f
        L_0x051b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0528
            r153 = r130
        L_0x0523:
            r19 = r2
            r2 = r20
            goto L_0x052f
        L_0x0528:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r153 = r17
            goto L_0x0523
        L_0x052f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x053c
            r154 = r130
        L_0x0537:
            r20 = r2
            r2 = r21
            goto L_0x0543
        L_0x053c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r154 = r17
            goto L_0x0537
        L_0x0543:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0550
            r155 = r130
        L_0x054b:
            r21 = r2
            r2 = r22
            goto L_0x0557
        L_0x0550:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r155 = r17
            goto L_0x054b
        L_0x0557:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0564
            r156 = r130
        L_0x055f:
            r22 = r2
            r2 = r23
            goto L_0x056b
        L_0x0564:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r156 = r17
            goto L_0x055f
        L_0x056b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0578
            r157 = r130
        L_0x0573:
            r23 = r2
            r2 = r24
            goto L_0x057f
        L_0x0578:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r157 = r17
            goto L_0x0573
        L_0x057f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x058c
            r158 = r130
        L_0x0587:
            r24 = r2
            r2 = r25
            goto L_0x0593
        L_0x058c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r158 = r17
            goto L_0x0587
        L_0x0593:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05a0
            r159 = r130
        L_0x059b:
            r25 = r2
            r2 = r26
            goto L_0x05a7
        L_0x05a0:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r159 = r17
            goto L_0x059b
        L_0x05a7:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05b4
            r160 = r130
        L_0x05af:
            r26 = r2
            r2 = r27
            goto L_0x05bb
        L_0x05b4:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r160 = r17
            goto L_0x05af
        L_0x05bb:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05c8
            r161 = r130
        L_0x05c3:
            r27 = r2
            r2 = r28
            goto L_0x05cf
        L_0x05c8:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r161 = r17
            goto L_0x05c3
        L_0x05cf:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05dc
            r162 = r130
        L_0x05d7:
            r28 = r2
            r2 = r29
            goto L_0x05e3
        L_0x05dc:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r162 = r17
            goto L_0x05d7
        L_0x05e3:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05ec
            r17 = r130
            goto L_0x05f0
        L_0x05ec:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x05f0:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r29 = r2
            r2 = r30
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0601
            r17 = r130
            goto L_0x0605
        L_0x0601:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0605:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r30 = r2
            r2 = r31
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0616
            r17 = r130
            goto L_0x061a
        L_0x0616:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x061a:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r31 = r2
            r2 = r32
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x062b
            r17 = r130
            goto L_0x062f
        L_0x062b:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x062f:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r32 = r2
            r2 = r33
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0640
            r17 = r130
            goto L_0x0644
        L_0x0640:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0644:
            double[] r167 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r33 = r2
            r17 = r4
            r2 = r34
            r34 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r168 = r3
            r4 = r35
            r35 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0665
            r169 = r141
            goto L_0x0667
        L_0x0665:
            r169 = r131
        L_0x0667:
            r2 = r36
            r36 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0675
            r170 = r141
            goto L_0x0677
        L_0x0675:
            r170 = r131
        L_0x0677:
            r3 = r37
            r37 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0685
            r171 = r141
            goto L_0x0687
        L_0x0685:
            r171 = r131
        L_0x0687:
            r5 = r2
            r4 = r38
            r38 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0696
            r172 = r141
            goto L_0x0698
        L_0x0696:
            r172 = r131
        L_0x0698:
            r2 = r39
            r39 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06a6
            r173 = r141
            goto L_0x06a8
        L_0x06a6:
            r173 = r131
        L_0x06a8:
            r3 = r40
            r40 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x06b6
            r174 = r141
            goto L_0x06b8
        L_0x06b6:
            r174 = r131
        L_0x06b8:
            r4 = r41
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x06c6
            r5 = r2
            r41 = r3
            r2 = r130
            goto L_0x06d2
        L_0x06c6:
            r5 = r2
            r41 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x06d2:
            if (r2 != 0) goto L_0x06db
            r175 = r130
        L_0x06d6:
            r2 = r42
            r42 = r4
            goto L_0x06ed
        L_0x06db:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x06e4
            r2 = r141
            goto L_0x06e6
        L_0x06e4:
            r2 = r131
        L_0x06e6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r175 = r2
            goto L_0x06d6
        L_0x06ed:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06f7
            r176 = r141
            goto L_0x06f9
        L_0x06f7:
            r176 = r131
        L_0x06f9:
            r3 = r43
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x070a
            r177 = r130
        L_0x0703:
            r43 = r2
            r4 = r44
            r44 = r3
            goto L_0x0711
        L_0x070a:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r177 = r4
            goto L_0x0703
        L_0x0711:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x071b
            r178 = r141
            goto L_0x071d
        L_0x071b:
            r178 = r131
        L_0x071d:
            r2 = r45
            boolean r3 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x072a
            r179 = r130
        L_0x0727:
            r3 = r46
            goto L_0x0731
        L_0x072a:
            java.lang.String r3 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r179 = r3
            goto L_0x0727
        L_0x0731:
            boolean r45 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r45 == 0) goto L_0x073e
            r180 = r130
        L_0x0739:
            r45 = r2
            r2 = r47
            goto L_0x0745
        L_0x073e:
            java.lang.String r45 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r180 = r45
            goto L_0x0739
        L_0x0745:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0752
            r182 = r130
        L_0x074d:
            r47 = r2
            r2 = r48
            goto L_0x0759
        L_0x0752:
            java.lang.String r46 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r182 = r46
            goto L_0x074d
        L_0x0759:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0766
            r48 = r3
            r46 = r4
            r3 = r130
            goto L_0x0773
        L_0x0766:
            r48 = r3
            r46 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0773:
            if (r3 != 0) goto L_0x077a
            r183 = r130
        L_0x0777:
            r3 = r49
            goto L_0x078c
        L_0x077a:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0783
            r3 = r141
            goto L_0x0785
        L_0x0783:
            r3 = r131
        L_0x0785:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r183 = r3
            goto L_0x0777
        L_0x078c:
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0799
            r49 = r5
            r184 = r130
        L_0x0796:
            r4 = r50
            goto L_0x07a7
        L_0x0799:
            r49 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0e50 }
            r184 = r4
            goto L_0x0796
        L_0x07a7:
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x07b6
            r185 = r130
        L_0x07af:
            r50 = r2
            r5 = r51
            r51 = r3
            goto L_0x07c1
        L_0x07b6:
            long r185 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            java.lang.Long r5 = java.lang.Long.valueOf(r185)     // Catch:{ all -> 0x0e50 }
            r185 = r5
            goto L_0x07af
        L_0x07c1:
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x07cb
            r186 = r141
            goto L_0x07cd
        L_0x07cb:
            r186 = r131
        L_0x07cd:
            r2 = r52
            r52 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x07db
            r187 = r141
            goto L_0x07dd
        L_0x07db:
            r187 = r131
        L_0x07dd:
            r3 = r53
            r53 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r54
            long r189 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            r54 = r2
            r188 = r4
            r2 = r55
            r55 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r191 = r3
            r4 = r56
            r56 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0809
            r192 = r141
            goto L_0x080b
        L_0x0809:
            r192 = r131
        L_0x080b:
            r2 = r57
            r57 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r193 = r3
            r4 = r58
            r58 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r249 = r4
            r3 = r59
            r59 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r194 = r2
            r5 = r60
            r60 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r61
            long r197 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r196 = r2
            r195 = r4
            r2 = r62
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r62 = r2
            r199 = r3
            r4 = r63
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r63 = r5
            r3 = r64
            r64 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r200 = r2
            r5 = r65
            r65 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r201 = r4
            r3 = r66
            r66 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r202 = r2
            r5 = r67
            r67 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r203 = r4
            r3 = r68
            r68 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r204 = r2
            r5 = r69
            r69 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r205 = r4
            r3 = r70
            r70 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r206 = r2
            r5 = r71
            r71 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r72
            double r209 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            r208 = r2
            r2 = r73
            double r211 = r1.getDouble(r2)     // Catch:{ all -> 0x0e50 }
            r73 = r2
            r72 = r3
            r207 = r4
            r2 = r74
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r74 = r2
            r213 = r3
            r4 = r75
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r75 = r5
            r3 = r76
            r76 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r77
            boolean r77 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r77 == 0) goto L_0x08e5
            r77 = r130
            goto L_0x08e9
        L_0x08e5:
            java.lang.String r77 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
        L_0x08e9:
            double[] r216 = com.blueair.database.DoubleArrayConverter.fromString(r77)     // Catch:{ all -> 0x0e50 }
            r214 = r2
            r77 = r3
            r215 = r4
            r2 = r78
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r4 = r79
            boolean r78 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r78 == 0) goto L_0x0905
            r78 = r130
            goto L_0x0909
        L_0x0905:
            java.lang.String r78 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
        L_0x0909:
            double[] r218 = com.blueair.database.DoubleArrayConverter.fromString(r78)     // Catch:{ all -> 0x0e50 }
            r78 = r2
            r217 = r3
            r79 = r4
            r2 = r80
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x091f
            r219 = r141
            goto L_0x0921
        L_0x091f:
            r219 = r131
        L_0x0921:
            r80 = r5
            r3 = r81
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r81 = r2
            r5 = r82
            r82 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r220 = r4
            r3 = r83
            r83 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r221 = r2
            r5 = r84
            r84 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0950
            r223 = r141
            goto L_0x0952
        L_0x0950:
            r223 = r131
        L_0x0952:
            r222 = r4
            r2 = r85
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r85 = r2
            r224 = r3
            r4 = r86
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x096b
            r225 = r141
            goto L_0x096d
        L_0x096b:
            r225 = r131
        L_0x096d:
            r86 = r4
            r2 = r87
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x097b
            r226 = r141
            goto L_0x097d
        L_0x097b:
            r226 = r131
        L_0x097d:
            r87 = r5
            r3 = r88
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r88 = r2
            r5 = r89
            r89 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r227 = r4
            r3 = r90
            r90 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x09a1
            r229 = r141
            goto L_0x09a3
        L_0x09a1:
            r229 = r131
        L_0x09a3:
            r228 = r2
            r5 = r3
            r4 = r91
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x09b2
            r230 = r141
            goto L_0x09b4
        L_0x09b2:
            r230 = r131
        L_0x09b4:
            r91 = r4
            r2 = r92
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r92 = r2
            r231 = r3
            r4 = r93
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r93 = r5
            r3 = r94
            r94 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r232 = r2
            r5 = r95
            r95 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r233 = r4
            r3 = r96
            r96 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r234 = r2
            r5 = r97
            r97 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r235 = r4
            r3 = r98
            r98 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r236 = r2
            r5 = r99
            r99 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r237 = r4
            r3 = r100
            r100 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0a1a
            r239 = r141
            goto L_0x0a1c
        L_0x0a1a:
            r239 = r131
        L_0x0a1c:
            r4 = r101
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x0a2a
            r238 = r2
            r5 = r3
            r2 = r130
            goto L_0x0a36
        L_0x0a2a:
            r238 = r2
            r5 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0a36:
            if (r2 != 0) goto L_0x0a3f
            r240 = r130
        L_0x0a3a:
            r101 = r4
            r2 = r102
            goto L_0x0a51
        L_0x0a3f:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a48
            r2 = r141
            goto L_0x0a4a
        L_0x0a48:
            r2 = r131
        L_0x0a4a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r240 = r2
            goto L_0x0a3a
        L_0x0a51:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r102 = r2
            r241 = r3
            r4 = r103
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r104
            boolean r103 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r103 == 0) goto L_0x0a6c
            r103 = r130
            goto L_0x0a70
        L_0x0a6c:
            java.lang.String r103 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0a70:
            java.util.List r243 = com.blueair.database.DeviceAlarmListConverter.fromString(r103)     // Catch:{ all -> 0x0e50 }
            r242 = r2
            r104 = r3
            r103 = r4
            r2 = r105
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r105 = r2
            r244 = r3
            r4 = r106
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a91
            r245 = r141
            goto L_0x0a93
        L_0x0a91:
            r245 = r131
        L_0x0a93:
            r106 = r4
            r2 = r107
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0aa1
            r246 = r141
            goto L_0x0aa3
        L_0x0aa1:
            r246 = r131
        L_0x0aa3:
            r107 = r5
            r3 = r108
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r109
            boolean r108 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r108 == 0) goto L_0x0af5
            r108 = r2
            r2 = r110
            boolean r109 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r109 == 0) goto L_0x0aea
            r109 = r3
            r3 = r111
            boolean r110 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0ae5
            r247 = r4
            r4 = r112
            boolean r110 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0b01
            r110 = r6
            r6 = r113
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 != 0) goto L_0x0add
            goto L_0x0b05
        L_0x0add:
            r250 = r130
        L_0x0adf:
            r111 = r2
            r2 = r114
            goto L_0x0b56
        L_0x0ae5:
            r247 = r4
            r110 = r6
            goto L_0x0af2
        L_0x0aea:
            r109 = r3
            r247 = r4
            r110 = r6
            r3 = r111
        L_0x0af2:
            r4 = r112
            goto L_0x0b03
        L_0x0af5:
            r108 = r2
            r109 = r3
            r247 = r4
            r2 = r110
            r3 = r111
            r4 = r112
        L_0x0b01:
            r110 = r6
        L_0x0b03:
            r6 = r113
        L_0x0b05:
            boolean r111 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b0e
            r251 = r130
            goto L_0x0b14
        L_0x0b0e:
            java.lang.String r111 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
            r251 = r111
        L_0x0b14:
            boolean r111 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b1d
            r252 = r130
            goto L_0x0b23
        L_0x0b1d:
            java.lang.String r111 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r252 = r111
        L_0x0b23:
            boolean r111 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b2c
            r253 = r130
            goto L_0x0b32
        L_0x0b2c:
            java.lang.String r111 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r253 = r111
        L_0x0b32:
            boolean r111 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b3b
            r254 = r130
            goto L_0x0b41
        L_0x0b3b:
            java.lang.String r111 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
            r254 = r111
        L_0x0b41:
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b4a
            r255 = r130
            goto L_0x0b50
        L_0x0b4a:
            java.lang.String r111 = r1.getText(r6)     // Catch:{ all -> 0x0e50 }
            r255 = r111
        L_0x0b50:
            com.blueair.database.DeviceUuidEntity r250 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0e50 }
            r250.<init>(r251, r252, r253, r254, r255)     // Catch:{ all -> 0x0e50 }
            goto L_0x0adf
        L_0x0b56:
            boolean r112 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r112 == 0) goto L_0x0bfa
            r112 = r3
            r3 = r115
            boolean r113 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r113 == 0) goto L_0x0bdd
            r113 = r4
            r4 = r116
            boolean r114 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r114 == 0) goto L_0x0bc2
            r114 = r5
            r5 = r117
            boolean r115 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r115 == 0) goto L_0x0c06
            r115 = r6
            r6 = r118
            boolean r116 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r116 == 0) goto L_0x0be9
            r116 = r7
            r7 = r119
            boolean r117 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r117 == 0) goto L_0x0bce
            r117 = r8
            r8 = r120
            boolean r118 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r118 == 0) goto L_0x0c12
            r118 = r9
            r9 = r121
            boolean r119 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r119 == 0) goto L_0x0bf5
            r119 = r10
            r10 = r122
            boolean r120 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r120 == 0) goto L_0x0bda
            r120 = r11
            r11 = r123
            boolean r121 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r121 != 0) goto L_0x0bb8
            goto L_0x0c1e
        L_0x0bb8:
            r121 = r12
            r122 = r13
            r143 = r130
        L_0x0bbe:
            r12 = r124
            goto L_0x0cf5
        L_0x0bc2:
            r114 = r5
            r115 = r6
            r116 = r7
            r5 = r117
            r6 = r118
            r7 = r119
        L_0x0bce:
            r117 = r8
            r118 = r9
            r119 = r10
            r8 = r120
            r9 = r121
            r10 = r122
        L_0x0bda:
            r120 = r11
            goto L_0x0c1c
        L_0x0bdd:
            r113 = r4
            r114 = r5
            r115 = r6
            r4 = r116
            r5 = r117
            r6 = r118
        L_0x0be9:
            r116 = r7
            r117 = r8
            r118 = r9
            r7 = r119
            r8 = r120
            r9 = r121
        L_0x0bf5:
            r119 = r10
            r120 = r11
            goto L_0x0c1a
        L_0x0bfa:
            r112 = r3
            r113 = r4
            r114 = r5
            r3 = r115
            r4 = r116
            r5 = r117
        L_0x0c06:
            r115 = r6
            r116 = r7
            r117 = r8
            r6 = r118
            r7 = r119
            r8 = r120
        L_0x0c12:
            r118 = r9
            r119 = r10
            r120 = r11
            r9 = r121
        L_0x0c1a:
            r10 = r122
        L_0x0c1c:
            r11 = r123
        L_0x0c1e:
            long r252 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            boolean r121 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r121 == 0) goto L_0x0c2f
            r121 = r12
            r122 = r13
            r254 = r130
            goto L_0x0c3e
        L_0x0c2f:
            r121 = r12
            r122 = r13
            double r12 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r254 = r12
        L_0x0c3e:
            boolean r12 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c47
            r255 = r130
            goto L_0x0c52
        L_0x0c47:
            double r12 = r1.getDouble(r4)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r255 = r12
        L_0x0c52:
            boolean r12 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c5c
            r256 = r130
            goto L_0x0c68
        L_0x0c5c:
            double r12 = r1.getDouble(r5)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r256 = r12
        L_0x0c68:
            boolean r12 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c72
            r257 = r130
            goto L_0x0c7e
        L_0x0c72:
            double r12 = r1.getDouble(r6)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r257 = r12
        L_0x0c7e:
            boolean r12 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c88
            r258 = r130
            goto L_0x0c94
        L_0x0c88:
            double r12 = r1.getDouble(r7)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r258 = r12
        L_0x0c94:
            boolean r12 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c9e
            r259 = r130
            goto L_0x0caa
        L_0x0c9e:
            double r12 = r1.getDouble(r8)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r259 = r12
        L_0x0caa:
            boolean r12 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cb4
            r260 = r130
            goto L_0x0cc0
        L_0x0cb4:
            double r12 = r1.getDouble(r9)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r260 = r12
        L_0x0cc0:
            boolean r12 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cca
            r261 = r130
            goto L_0x0cd6
        L_0x0cca:
            double r12 = r1.getDouble(r10)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r261 = r12
        L_0x0cd6:
            boolean r12 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0ce0
            r262 = r130
            goto L_0x0cec
        L_0x0ce0:
            double r12 = r1.getDouble(r11)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r262 = r12
        L_0x0cec:
            com.blueair.core.model.IndoorDatapoint r251 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0e50 }
            r251.<init>(r252, r254, r255, r256, r257, r258, r259, r260, r261, r262)     // Catch:{ all -> 0x0e50 }
            r143 = r251
            goto L_0x0bbe
        L_0x0cf5:
            boolean r13 = r1.isNull(r12)     // Catch:{ all -> 0x0e50 }
            if (r13 == 0) goto L_0x0d3c
            r13 = r125
            boolean r123 = r1.isNull(r13)     // Catch:{ all -> 0x0e50 }
            if (r123 == 0) goto L_0x0d31
            r123 = r2
            r2 = r126
            boolean r124 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r124 == 0) goto L_0x0d2c
            r124 = r3
            r3 = r127
            boolean r125 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r125 == 0) goto L_0x0d46
            r125 = r4
            r4 = r128
            boolean r126 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r126 != 0) goto L_0x0d22
            goto L_0x0d4a
        L_0x0d22:
            r128 = r3
            r126 = r5
            r127 = r6
            r181 = r130
            r6 = r2
            goto L_0x0d85
        L_0x0d2c:
            r124 = r3
            r125 = r4
            goto L_0x0d39
        L_0x0d31:
            r123 = r2
            r124 = r3
            r125 = r4
            r2 = r126
        L_0x0d39:
            r3 = r127
            goto L_0x0d48
        L_0x0d3c:
            r123 = r2
            r124 = r3
            r13 = r125
            r2 = r126
            r3 = r127
        L_0x0d46:
            r125 = r4
        L_0x0d48:
            r4 = r128
        L_0x0d4a:
            double r252 = r1.getDouble(r12)     // Catch:{ all -> 0x0e50 }
            double r254 = r1.getDouble(r13)     // Catch:{ all -> 0x0e50 }
            r126 = r5
            r127 = r6
            long r5 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r5 = (int) r5     // Catch:{ all -> 0x0e50 }
            boolean r6 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r6 == 0) goto L_0x0d68
        L_0x0d61:
            r6 = r2
            r128 = r3
            r257 = r130
            goto L_0x0d6d
        L_0x0d68:
            java.lang.String r130 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            goto L_0x0d61
        L_0x0d6d:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0d78
            r258 = r141
            goto L_0x0d7b
        L_0x0d78:
            r258 = r131
        L_0x0d7b:
            com.blueair.core.model.WelcomeHomeLocation r251 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0e50 }
            r256 = r5
            r251.<init>(r252, r254, r256, r257, r258)     // Catch:{ all -> 0x0e50 }
            r181 = r251
        L_0x0d85:
            com.blueair.database.entity.DeviceEntity r131 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0e50 }
            r141 = r250
            r131.<init>(r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r191, r192, r193, r194, r195, r196, r197, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r211, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247)     // Catch:{ all -> 0x0e50 }
            r2 = r131
            r15.add(r2)     // Catch:{ all -> 0x0e50 }
            r2 = r4
            r4 = r263
            r263 = r16
            r16 = r17
            r17 = r34
            r34 = r35
            r35 = r36
            r36 = r40
            r40 = r41
            r41 = r42
            r42 = r43
            r43 = r44
            r44 = r46
            r46 = r48
            r48 = r50
            r50 = r52
            r52 = r54
            r54 = r59
            r59 = r60
            r60 = r63
            r63 = r64
            r64 = r65
            r65 = r66
            r66 = r67
            r67 = r68
            r68 = r69
            r69 = r70
            r70 = r71
            r71 = r75
            r75 = r76
            r76 = r77
            r77 = r80
            r80 = r81
            r81 = r82
            r82 = r83
            r83 = r84
            r84 = r87
            r87 = r88
            r88 = r89
            r89 = r90
            r90 = r93
            r93 = r94
            r94 = r95
            r95 = r96
            r96 = r97
            r97 = r98
            r98 = r99
            r99 = r100
            r100 = r107
            r107 = r108
            r108 = r109
            r109 = r114
            r114 = r123
            r123 = r11
            r11 = r120
            r120 = r8
            r8 = r117
            r117 = r126
            r126 = r6
            r6 = r110
            r110 = r111
            r111 = r112
            r112 = r113
            r113 = r115
            r115 = r124
            r124 = r12
            r12 = r121
            r121 = r9
            r9 = r118
            r118 = r127
            r127 = r128
            r128 = r2
            r2 = r119
            r119 = r7
            r7 = r116
            r116 = r125
            r125 = r13
            r13 = r122
            r122 = r10
            r10 = r2
            r5 = r37
            r37 = r38
            r38 = r39
            r39 = r49
            r49 = r51
            r51 = r53
            r53 = r55
            r55 = r56
            r56 = r57
            r57 = r58
            r2 = r129
            r3 = r248
            r58 = r249
            goto L_0x03f2
        L_0x0e4c:
            r1.close()
            return r15
        L_0x0e50:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$getDevices$3(androidx.sqlite.SQLiteConnection):java.util.List");
    }

    public LiveData<List<DeviceEntity>> getLiveDevices() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DeviceEntity.DEVICE_TABLE}, false, new DeviceDao_Impl$$ExternalSyntheticLambda46());
    }

    /* JADX WARNING: Removed duplicated region for block: B:316:0x0b0b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0b0e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0b1a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0b1d A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0b29 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0b2c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0b38 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0b3b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0b47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0b4a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0c28 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0c2f A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0c44 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0c47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0c58 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0c5c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0c6e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0c72 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0c84 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0c88 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0c9a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0c9e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0cb0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0cb4 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0cc6 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0cca A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0cdc A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0ce0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0d68 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0d74 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0d78 A[Catch:{ all -> 0x0e50 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.List lambda$getLiveDevices$4(androidx.sqlite.SQLiteConnection r263) {
        /*
            java.lang.String r0 = "SELECT * from device_table ORDER BY modelName DESC"
            r1 = r263
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r0)
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0e50 }
            java.lang.String r2 = "name"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0e50 }
            java.lang.String r3 = "modelName"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0e50 }
            java.lang.String r4 = "typeIndex"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0e50 }
            java.lang.String r5 = "fanSpeed"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0e50 }
            java.lang.String r6 = "filterLife"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0e50 }
            java.lang.String r7 = "autoModeText"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0e50 }
            java.lang.String r8 = "brightness"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0e50 }
            java.lang.String r9 = "info"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0e50 }
            java.lang.String r10 = "hasFinishedOnboarding"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0e50 }
            java.lang.String r11 = "lastSelectedSensorType"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0e50 }
            java.lang.String r12 = "isAblDevice"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0e50 }
            java.lang.String r13 = "isNightModeOn"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0e50 }
            java.lang.String r14 = "isChildLockOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0e50 }
            java.lang.String r15 = "linkedDeviceUid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r263 = r15
            java.lang.String r15 = "connectivityStatusIndex"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r16 = r15
            java.lang.String r15 = "lastConnectivityMillis"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r17 = r15
            java.lang.String r15 = "mac"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r18 = r15
            java.lang.String r15 = "mcuFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r19 = r15
            java.lang.String r15 = "wifiFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r20 = r15
            java.lang.String r15 = "hardware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r21 = r15
            java.lang.String r15 = "timeZone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r22 = r15
            java.lang.String r15 = "serial"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r23 = r15
            java.lang.String r15 = "purchaseDate"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r24 = r15
            java.lang.String r15 = "dealerName"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r25 = r15
            java.lang.String r15 = "dealerCountry"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r26 = r15
            java.lang.String r15 = "filterType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r27 = r15
            java.lang.String r15 = "filterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r28 = r15
            java.lang.String r15 = "pm1Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r29 = r15
            java.lang.String r15 = "pm10Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r30 = r15
            java.lang.String r15 = "pm25Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r31 = r15
            java.lang.String r15 = "vocRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r32 = r15
            java.lang.String r15 = "hchoRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r33 = r15
            java.lang.String r15 = "updateProgress"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r34 = r15
            java.lang.String r15 = "isStandByOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r35 = r15
            java.lang.String r15 = "isEcoModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r36 = r15
            java.lang.String r15 = "isHinsModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r37 = r15
            java.lang.String r15 = "isHinsNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r38 = r15
            java.lang.String r15 = "isG4NightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r39 = r15
            java.lang.String r15 = "isGermShieldOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r40 = r15
            java.lang.String r15 = "isGermShieldNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r41 = r15
            java.lang.String r15 = "isSafetySwitchOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r42 = r15
            java.lang.String r15 = "g4NightModefilterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r43 = r15
            java.lang.String r15 = "aimInstalled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r44 = r15
            java.lang.String r15 = "sku"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r45 = r15
            java.lang.String r15 = "compatibility"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r46 = r15
            java.lang.String r15 = "locationId"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r47 = r15
            java.lang.String r15 = "disinfection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r48 = r15
            java.lang.String r15 = "disinfectLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r49 = r15
            java.lang.String r15 = "disinfectLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r50 = r15
            java.lang.String r15 = "wickdryEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r51 = r15
            java.lang.String r15 = "wickdryOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r52 = r15
            java.lang.String r15 = "wickdryLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r53 = r15
            java.lang.String r15 = "wickdryLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r54 = r15
            java.lang.String r15 = "wickUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r55 = r15
            java.lang.String r15 = "waterShortage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r56 = r15
            java.lang.String r15 = "autoRh"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r57 = r15
            java.lang.String r15 = "timerStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r58 = r15
            java.lang.String r15 = "timerDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r59 = r15
            java.lang.String r15 = "timerLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r60 = r15
            java.lang.String r15 = "timerLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r61 = r15
            java.lang.String r15 = "temperatureUnit"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r62 = r15
            java.lang.String r15 = "oscillationState"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r63 = r15
            java.lang.String r15 = "oscillationAngle"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r64 = r15
            java.lang.String r15 = "oscillationDirection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r65 = r15
            java.lang.String r15 = "oscillationFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r66 = r15
            java.lang.String r15 = "mainMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r67 = r15
            java.lang.String r15 = "apSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r68 = r15
            java.lang.String r15 = "apFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r69 = r15
            java.lang.String r15 = "heatSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r70 = r15
            java.lang.String r15 = "heatFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r71 = r15
            java.lang.String r15 = "heatAutoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r72 = r15
            java.lang.String r15 = "heatEcoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r73 = r15
            java.lang.String r15 = "coolSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r74 = r15
            java.lang.String r15 = "coolFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r75 = r15
            java.lang.String r15 = "coolAutoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r76 = r15
            java.lang.String r15 = "coolAutoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r77 = r15
            java.lang.String r15 = "coolEcoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r78 = r15
            java.lang.String r15 = "coolEcoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r79 = r15
            java.lang.String r15 = "humMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r80 = r15
            java.lang.String r15 = "mode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r81 = r15
            java.lang.String r15 = "waterLevel"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r82 = r15
            java.lang.String r15 = "dehSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r83 = r15
            java.lang.String r15 = "waterTankFailure"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r84 = r15
            java.lang.String r15 = "smartSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r85 = r15
            java.lang.String r15 = "detectCat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r86 = r15
            java.lang.String r15 = "bodyMounted"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r87 = r15
            java.lang.String r15 = "cleanAirEta"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r88 = r15
            java.lang.String r15 = "panelDisplayMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r89 = r15
            java.lang.String r15 = "hoverEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r90 = r15
            java.lang.String r15 = "airRefreshEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r91 = r15
            java.lang.String r15 = "airRefreshStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r92 = r15
            java.lang.String r15 = "airRefreshDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r93 = r15
            java.lang.String r15 = "airRefreshTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r94 = r15
            java.lang.String r15 = "airRefreshStartTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r95 = r15
            java.lang.String r15 = "airRefreshEndTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r96 = r15
            java.lang.String r15 = "roomType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r97 = r15
            java.lang.String r15 = "nightLampBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r98 = r15
            java.lang.String r15 = "wickdryDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r99 = r15
            java.lang.String r15 = "wickdryDone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r100 = r15
            java.lang.String r15 = "ywrmEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r101 = r15
            java.lang.String r15 = "ywrmUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r102 = r15
            java.lang.String r15 = "nightLampSteplessBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r103 = r15
            java.lang.String r15 = "alarms"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r104 = r15
            java.lang.String r15 = "humSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r105 = r15
            java.lang.String r15 = "use24Hour"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r106 = r15
            java.lang.String r15 = "waterInfill"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r107 = r15
            java.lang.String r15 = "sensorMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r108 = r15
            java.lang.String r15 = "uuid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r109 = r15
            java.lang.String r15 = "ssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r110 = r15
            java.lang.String r15 = "bssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r111 = r15
            java.lang.String r15 = "ipv4"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r112 = r15
            java.lang.String r15 = "ipv6"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r113 = r15
            java.lang.String r15 = "timeInSeconds"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r114 = r15
            java.lang.String r15 = "pm1"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r115 = r15
            java.lang.String r15 = "pm10"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r116 = r15
            java.lang.String r15 = "pm25"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r117 = r15
            java.lang.String r15 = "voc"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r118 = r15
            java.lang.String r15 = "hcho"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r119 = r15
            java.lang.String r15 = "tmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r120 = r15
            java.lang.String r15 = "hum"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r121 = r15
            java.lang.String r15 = "fan"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r122 = r15
            java.lang.String r15 = "weight"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r123 = r15
            java.lang.String r15 = "lat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r124 = r15
            java.lang.String r15 = "lng"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r125 = r15
            java.lang.String r15 = "radius"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r126 = r15
            java.lang.String r15 = "textValue"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r127 = r15
            java.lang.String r15 = "isEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r128 = r15
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0e50 }
            r15.<init>()     // Catch:{ all -> 0x0e50 }
        L_0x03f2:
            boolean r129 = r1.step()     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0e4c
            boolean r129 = r1.isNull(r0)     // Catch:{ all -> 0x0e50 }
            r130 = 0
            if (r129 == 0) goto L_0x0403
            r132 = r130
            goto L_0x0409
        L_0x0403:
            java.lang.String r129 = r1.getText(r0)     // Catch:{ all -> 0x0e50 }
            r132 = r129
        L_0x0409:
            boolean r129 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0412
            r133 = r130
            goto L_0x0418
        L_0x0412:
            java.lang.String r129 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r133 = r129
        L_0x0418:
            boolean r129 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0425
            r134 = r130
            r129 = r2
            r248 = r3
            goto L_0x042f
        L_0x0425:
            java.lang.String r129 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r134 = r129
            r248 = r3
            r129 = r2
        L_0x042f:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x043f
            r135 = r2
            r136 = r130
            goto L_0x044c
        L_0x043f:
            r135 = r2
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r136 = r2
        L_0x044c:
            boolean r2 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0455
            r137 = r130
            goto L_0x0460
        L_0x0455:
            long r2 = r1.getLong(r6)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r137 = r2
        L_0x0460:
            boolean r2 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0469
            r138 = r130
            goto L_0x046f
        L_0x0469:
            java.lang.String r2 = r1.getText(r7)     // Catch:{ all -> 0x0e50 }
            r138 = r2
        L_0x046f:
            boolean r2 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0478
            r139 = r130
            goto L_0x0483
        L_0x0478:
            long r2 = r1.getLong(r8)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r139 = r2
        L_0x0483:
            boolean r2 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x048c
            r140 = r130
            goto L_0x0492
        L_0x048c:
            java.lang.String r2 = r1.getText(r9)     // Catch:{ all -> 0x0e50 }
            r140 = r2
        L_0x0492:
            long r2 = r1.getLong(r10)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = 1
            r131 = 0
            if (r2 == 0) goto L_0x049f
            r142 = r3
            goto L_0x04a1
        L_0x049f:
            r142 = r131
        L_0x04a1:
            boolean r2 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x04ad
            r141 = r3
            r2 = r4
            r144 = r130
            goto L_0x04bb
        L_0x04ad:
            r141 = r3
            r2 = r4
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r144 = r3
        L_0x04bb:
            long r3 = r1.getLong(r12)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04c5
            r145 = r141
            goto L_0x04c7
        L_0x04c5:
            r145 = r131
        L_0x04c7:
            long r3 = r1.getLong(r13)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04d1
            r146 = r141
            goto L_0x04d3
        L_0x04d1:
            r146 = r131
        L_0x04d3:
            long r3 = r1.getLong(r14)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04dd
            r147 = r141
            goto L_0x04df
        L_0x04dd:
            r147 = r131
        L_0x04df:
            r3 = r263
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x04f1
            r148 = r130
        L_0x04e9:
            r263 = r2
            r4 = r16
            r16 = r3
            goto L_0x04f8
        L_0x04f1:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r148 = r4
            goto L_0x04e9
        L_0x04f8:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r17
            long r150 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r149 = r2
            r2 = r18
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0514
            r152 = r130
        L_0x050f:
            r18 = r2
            r2 = r19
            goto L_0x051b
        L_0x0514:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r152 = r17
            goto L_0x050f
        L_0x051b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0528
            r153 = r130
        L_0x0523:
            r19 = r2
            r2 = r20
            goto L_0x052f
        L_0x0528:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r153 = r17
            goto L_0x0523
        L_0x052f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x053c
            r154 = r130
        L_0x0537:
            r20 = r2
            r2 = r21
            goto L_0x0543
        L_0x053c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r154 = r17
            goto L_0x0537
        L_0x0543:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0550
            r155 = r130
        L_0x054b:
            r21 = r2
            r2 = r22
            goto L_0x0557
        L_0x0550:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r155 = r17
            goto L_0x054b
        L_0x0557:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0564
            r156 = r130
        L_0x055f:
            r22 = r2
            r2 = r23
            goto L_0x056b
        L_0x0564:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r156 = r17
            goto L_0x055f
        L_0x056b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0578
            r157 = r130
        L_0x0573:
            r23 = r2
            r2 = r24
            goto L_0x057f
        L_0x0578:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r157 = r17
            goto L_0x0573
        L_0x057f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x058c
            r158 = r130
        L_0x0587:
            r24 = r2
            r2 = r25
            goto L_0x0593
        L_0x058c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r158 = r17
            goto L_0x0587
        L_0x0593:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05a0
            r159 = r130
        L_0x059b:
            r25 = r2
            r2 = r26
            goto L_0x05a7
        L_0x05a0:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r159 = r17
            goto L_0x059b
        L_0x05a7:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05b4
            r160 = r130
        L_0x05af:
            r26 = r2
            r2 = r27
            goto L_0x05bb
        L_0x05b4:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r160 = r17
            goto L_0x05af
        L_0x05bb:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05c8
            r161 = r130
        L_0x05c3:
            r27 = r2
            r2 = r28
            goto L_0x05cf
        L_0x05c8:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r161 = r17
            goto L_0x05c3
        L_0x05cf:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05dc
            r162 = r130
        L_0x05d7:
            r28 = r2
            r2 = r29
            goto L_0x05e3
        L_0x05dc:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r162 = r17
            goto L_0x05d7
        L_0x05e3:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05ec
            r17 = r130
            goto L_0x05f0
        L_0x05ec:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x05f0:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r29 = r2
            r2 = r30
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0601
            r17 = r130
            goto L_0x0605
        L_0x0601:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0605:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r30 = r2
            r2 = r31
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0616
            r17 = r130
            goto L_0x061a
        L_0x0616:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x061a:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r31 = r2
            r2 = r32
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x062b
            r17 = r130
            goto L_0x062f
        L_0x062b:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x062f:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r32 = r2
            r2 = r33
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0640
            r17 = r130
            goto L_0x0644
        L_0x0640:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0644:
            double[] r167 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r33 = r2
            r17 = r4
            r2 = r34
            r34 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r168 = r3
            r4 = r35
            r35 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0665
            r169 = r141
            goto L_0x0667
        L_0x0665:
            r169 = r131
        L_0x0667:
            r2 = r36
            r36 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0675
            r170 = r141
            goto L_0x0677
        L_0x0675:
            r170 = r131
        L_0x0677:
            r3 = r37
            r37 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0685
            r171 = r141
            goto L_0x0687
        L_0x0685:
            r171 = r131
        L_0x0687:
            r5 = r2
            r4 = r38
            r38 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0696
            r172 = r141
            goto L_0x0698
        L_0x0696:
            r172 = r131
        L_0x0698:
            r2 = r39
            r39 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06a6
            r173 = r141
            goto L_0x06a8
        L_0x06a6:
            r173 = r131
        L_0x06a8:
            r3 = r40
            r40 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x06b6
            r174 = r141
            goto L_0x06b8
        L_0x06b6:
            r174 = r131
        L_0x06b8:
            r4 = r41
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x06c6
            r5 = r2
            r41 = r3
            r2 = r130
            goto L_0x06d2
        L_0x06c6:
            r5 = r2
            r41 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x06d2:
            if (r2 != 0) goto L_0x06db
            r175 = r130
        L_0x06d6:
            r2 = r42
            r42 = r4
            goto L_0x06ed
        L_0x06db:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x06e4
            r2 = r141
            goto L_0x06e6
        L_0x06e4:
            r2 = r131
        L_0x06e6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r175 = r2
            goto L_0x06d6
        L_0x06ed:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06f7
            r176 = r141
            goto L_0x06f9
        L_0x06f7:
            r176 = r131
        L_0x06f9:
            r3 = r43
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x070a
            r177 = r130
        L_0x0703:
            r43 = r2
            r4 = r44
            r44 = r3
            goto L_0x0711
        L_0x070a:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r177 = r4
            goto L_0x0703
        L_0x0711:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x071b
            r178 = r141
            goto L_0x071d
        L_0x071b:
            r178 = r131
        L_0x071d:
            r2 = r45
            boolean r3 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x072a
            r179 = r130
        L_0x0727:
            r3 = r46
            goto L_0x0731
        L_0x072a:
            java.lang.String r3 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r179 = r3
            goto L_0x0727
        L_0x0731:
            boolean r45 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r45 == 0) goto L_0x073e
            r180 = r130
        L_0x0739:
            r45 = r2
            r2 = r47
            goto L_0x0745
        L_0x073e:
            java.lang.String r45 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r180 = r45
            goto L_0x0739
        L_0x0745:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0752
            r182 = r130
        L_0x074d:
            r47 = r2
            r2 = r48
            goto L_0x0759
        L_0x0752:
            java.lang.String r46 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r182 = r46
            goto L_0x074d
        L_0x0759:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0766
            r48 = r3
            r46 = r4
            r3 = r130
            goto L_0x0773
        L_0x0766:
            r48 = r3
            r46 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0773:
            if (r3 != 0) goto L_0x077a
            r183 = r130
        L_0x0777:
            r3 = r49
            goto L_0x078c
        L_0x077a:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0783
            r3 = r141
            goto L_0x0785
        L_0x0783:
            r3 = r131
        L_0x0785:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r183 = r3
            goto L_0x0777
        L_0x078c:
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0799
            r49 = r5
            r184 = r130
        L_0x0796:
            r4 = r50
            goto L_0x07a7
        L_0x0799:
            r49 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0e50 }
            r184 = r4
            goto L_0x0796
        L_0x07a7:
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x07b6
            r185 = r130
        L_0x07af:
            r50 = r2
            r5 = r51
            r51 = r3
            goto L_0x07c1
        L_0x07b6:
            long r185 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            java.lang.Long r5 = java.lang.Long.valueOf(r185)     // Catch:{ all -> 0x0e50 }
            r185 = r5
            goto L_0x07af
        L_0x07c1:
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x07cb
            r186 = r141
            goto L_0x07cd
        L_0x07cb:
            r186 = r131
        L_0x07cd:
            r2 = r52
            r52 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x07db
            r187 = r141
            goto L_0x07dd
        L_0x07db:
            r187 = r131
        L_0x07dd:
            r3 = r53
            r53 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r54
            long r189 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            r54 = r2
            r188 = r4
            r2 = r55
            r55 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r191 = r3
            r4 = r56
            r56 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0809
            r192 = r141
            goto L_0x080b
        L_0x0809:
            r192 = r131
        L_0x080b:
            r2 = r57
            r57 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r193 = r3
            r4 = r58
            r58 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r249 = r4
            r3 = r59
            r59 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r194 = r2
            r5 = r60
            r60 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r61
            long r197 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r196 = r2
            r195 = r4
            r2 = r62
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r62 = r2
            r199 = r3
            r4 = r63
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r63 = r5
            r3 = r64
            r64 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r200 = r2
            r5 = r65
            r65 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r201 = r4
            r3 = r66
            r66 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r202 = r2
            r5 = r67
            r67 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r203 = r4
            r3 = r68
            r68 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r204 = r2
            r5 = r69
            r69 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r205 = r4
            r3 = r70
            r70 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r206 = r2
            r5 = r71
            r71 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r72
            double r209 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            r208 = r2
            r2 = r73
            double r211 = r1.getDouble(r2)     // Catch:{ all -> 0x0e50 }
            r73 = r2
            r72 = r3
            r207 = r4
            r2 = r74
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r74 = r2
            r213 = r3
            r4 = r75
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r75 = r5
            r3 = r76
            r76 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r77
            boolean r77 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r77 == 0) goto L_0x08e5
            r77 = r130
            goto L_0x08e9
        L_0x08e5:
            java.lang.String r77 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
        L_0x08e9:
            double[] r216 = com.blueair.database.DoubleArrayConverter.fromString(r77)     // Catch:{ all -> 0x0e50 }
            r214 = r2
            r77 = r3
            r215 = r4
            r2 = r78
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r4 = r79
            boolean r78 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r78 == 0) goto L_0x0905
            r78 = r130
            goto L_0x0909
        L_0x0905:
            java.lang.String r78 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
        L_0x0909:
            double[] r218 = com.blueair.database.DoubleArrayConverter.fromString(r78)     // Catch:{ all -> 0x0e50 }
            r78 = r2
            r217 = r3
            r79 = r4
            r2 = r80
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x091f
            r219 = r141
            goto L_0x0921
        L_0x091f:
            r219 = r131
        L_0x0921:
            r80 = r5
            r3 = r81
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r81 = r2
            r5 = r82
            r82 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r220 = r4
            r3 = r83
            r83 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r221 = r2
            r5 = r84
            r84 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0950
            r223 = r141
            goto L_0x0952
        L_0x0950:
            r223 = r131
        L_0x0952:
            r222 = r4
            r2 = r85
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r85 = r2
            r224 = r3
            r4 = r86
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x096b
            r225 = r141
            goto L_0x096d
        L_0x096b:
            r225 = r131
        L_0x096d:
            r86 = r4
            r2 = r87
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x097b
            r226 = r141
            goto L_0x097d
        L_0x097b:
            r226 = r131
        L_0x097d:
            r87 = r5
            r3 = r88
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r88 = r2
            r5 = r89
            r89 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r227 = r4
            r3 = r90
            r90 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x09a1
            r229 = r141
            goto L_0x09a3
        L_0x09a1:
            r229 = r131
        L_0x09a3:
            r228 = r2
            r5 = r3
            r4 = r91
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x09b2
            r230 = r141
            goto L_0x09b4
        L_0x09b2:
            r230 = r131
        L_0x09b4:
            r91 = r4
            r2 = r92
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r92 = r2
            r231 = r3
            r4 = r93
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r93 = r5
            r3 = r94
            r94 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r232 = r2
            r5 = r95
            r95 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r233 = r4
            r3 = r96
            r96 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r234 = r2
            r5 = r97
            r97 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r235 = r4
            r3 = r98
            r98 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r236 = r2
            r5 = r99
            r99 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r237 = r4
            r3 = r100
            r100 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0a1a
            r239 = r141
            goto L_0x0a1c
        L_0x0a1a:
            r239 = r131
        L_0x0a1c:
            r4 = r101
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x0a2a
            r238 = r2
            r5 = r3
            r2 = r130
            goto L_0x0a36
        L_0x0a2a:
            r238 = r2
            r5 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0a36:
            if (r2 != 0) goto L_0x0a3f
            r240 = r130
        L_0x0a3a:
            r101 = r4
            r2 = r102
            goto L_0x0a51
        L_0x0a3f:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a48
            r2 = r141
            goto L_0x0a4a
        L_0x0a48:
            r2 = r131
        L_0x0a4a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r240 = r2
            goto L_0x0a3a
        L_0x0a51:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r102 = r2
            r241 = r3
            r4 = r103
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r104
            boolean r103 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r103 == 0) goto L_0x0a6c
            r103 = r130
            goto L_0x0a70
        L_0x0a6c:
            java.lang.String r103 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0a70:
            java.util.List r243 = com.blueair.database.DeviceAlarmListConverter.fromString(r103)     // Catch:{ all -> 0x0e50 }
            r242 = r2
            r104 = r3
            r103 = r4
            r2 = r105
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r105 = r2
            r244 = r3
            r4 = r106
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a91
            r245 = r141
            goto L_0x0a93
        L_0x0a91:
            r245 = r131
        L_0x0a93:
            r106 = r4
            r2 = r107
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0aa1
            r246 = r141
            goto L_0x0aa3
        L_0x0aa1:
            r246 = r131
        L_0x0aa3:
            r107 = r5
            r3 = r108
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r109
            boolean r108 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r108 == 0) goto L_0x0af5
            r108 = r2
            r2 = r110
            boolean r109 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r109 == 0) goto L_0x0aea
            r109 = r3
            r3 = r111
            boolean r110 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0ae5
            r247 = r4
            r4 = r112
            boolean r110 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0b01
            r110 = r6
            r6 = r113
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 != 0) goto L_0x0add
            goto L_0x0b05
        L_0x0add:
            r250 = r130
        L_0x0adf:
            r111 = r2
            r2 = r114
            goto L_0x0b56
        L_0x0ae5:
            r247 = r4
            r110 = r6
            goto L_0x0af2
        L_0x0aea:
            r109 = r3
            r247 = r4
            r110 = r6
            r3 = r111
        L_0x0af2:
            r4 = r112
            goto L_0x0b03
        L_0x0af5:
            r108 = r2
            r109 = r3
            r247 = r4
            r2 = r110
            r3 = r111
            r4 = r112
        L_0x0b01:
            r110 = r6
        L_0x0b03:
            r6 = r113
        L_0x0b05:
            boolean r111 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b0e
            r251 = r130
            goto L_0x0b14
        L_0x0b0e:
            java.lang.String r111 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
            r251 = r111
        L_0x0b14:
            boolean r111 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b1d
            r252 = r130
            goto L_0x0b23
        L_0x0b1d:
            java.lang.String r111 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r252 = r111
        L_0x0b23:
            boolean r111 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b2c
            r253 = r130
            goto L_0x0b32
        L_0x0b2c:
            java.lang.String r111 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r253 = r111
        L_0x0b32:
            boolean r111 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b3b
            r254 = r130
            goto L_0x0b41
        L_0x0b3b:
            java.lang.String r111 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
            r254 = r111
        L_0x0b41:
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b4a
            r255 = r130
            goto L_0x0b50
        L_0x0b4a:
            java.lang.String r111 = r1.getText(r6)     // Catch:{ all -> 0x0e50 }
            r255 = r111
        L_0x0b50:
            com.blueair.database.DeviceUuidEntity r250 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0e50 }
            r250.<init>(r251, r252, r253, r254, r255)     // Catch:{ all -> 0x0e50 }
            goto L_0x0adf
        L_0x0b56:
            boolean r112 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r112 == 0) goto L_0x0bfa
            r112 = r3
            r3 = r115
            boolean r113 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r113 == 0) goto L_0x0bdd
            r113 = r4
            r4 = r116
            boolean r114 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r114 == 0) goto L_0x0bc2
            r114 = r5
            r5 = r117
            boolean r115 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r115 == 0) goto L_0x0c06
            r115 = r6
            r6 = r118
            boolean r116 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r116 == 0) goto L_0x0be9
            r116 = r7
            r7 = r119
            boolean r117 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r117 == 0) goto L_0x0bce
            r117 = r8
            r8 = r120
            boolean r118 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r118 == 0) goto L_0x0c12
            r118 = r9
            r9 = r121
            boolean r119 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r119 == 0) goto L_0x0bf5
            r119 = r10
            r10 = r122
            boolean r120 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r120 == 0) goto L_0x0bda
            r120 = r11
            r11 = r123
            boolean r121 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r121 != 0) goto L_0x0bb8
            goto L_0x0c1e
        L_0x0bb8:
            r121 = r12
            r122 = r13
            r143 = r130
        L_0x0bbe:
            r12 = r124
            goto L_0x0cf5
        L_0x0bc2:
            r114 = r5
            r115 = r6
            r116 = r7
            r5 = r117
            r6 = r118
            r7 = r119
        L_0x0bce:
            r117 = r8
            r118 = r9
            r119 = r10
            r8 = r120
            r9 = r121
            r10 = r122
        L_0x0bda:
            r120 = r11
            goto L_0x0c1c
        L_0x0bdd:
            r113 = r4
            r114 = r5
            r115 = r6
            r4 = r116
            r5 = r117
            r6 = r118
        L_0x0be9:
            r116 = r7
            r117 = r8
            r118 = r9
            r7 = r119
            r8 = r120
            r9 = r121
        L_0x0bf5:
            r119 = r10
            r120 = r11
            goto L_0x0c1a
        L_0x0bfa:
            r112 = r3
            r113 = r4
            r114 = r5
            r3 = r115
            r4 = r116
            r5 = r117
        L_0x0c06:
            r115 = r6
            r116 = r7
            r117 = r8
            r6 = r118
            r7 = r119
            r8 = r120
        L_0x0c12:
            r118 = r9
            r119 = r10
            r120 = r11
            r9 = r121
        L_0x0c1a:
            r10 = r122
        L_0x0c1c:
            r11 = r123
        L_0x0c1e:
            long r252 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            boolean r121 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r121 == 0) goto L_0x0c2f
            r121 = r12
            r122 = r13
            r254 = r130
            goto L_0x0c3e
        L_0x0c2f:
            r121 = r12
            r122 = r13
            double r12 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r254 = r12
        L_0x0c3e:
            boolean r12 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c47
            r255 = r130
            goto L_0x0c52
        L_0x0c47:
            double r12 = r1.getDouble(r4)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r255 = r12
        L_0x0c52:
            boolean r12 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c5c
            r256 = r130
            goto L_0x0c68
        L_0x0c5c:
            double r12 = r1.getDouble(r5)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r256 = r12
        L_0x0c68:
            boolean r12 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c72
            r257 = r130
            goto L_0x0c7e
        L_0x0c72:
            double r12 = r1.getDouble(r6)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r257 = r12
        L_0x0c7e:
            boolean r12 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c88
            r258 = r130
            goto L_0x0c94
        L_0x0c88:
            double r12 = r1.getDouble(r7)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r258 = r12
        L_0x0c94:
            boolean r12 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c9e
            r259 = r130
            goto L_0x0caa
        L_0x0c9e:
            double r12 = r1.getDouble(r8)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r259 = r12
        L_0x0caa:
            boolean r12 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cb4
            r260 = r130
            goto L_0x0cc0
        L_0x0cb4:
            double r12 = r1.getDouble(r9)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r260 = r12
        L_0x0cc0:
            boolean r12 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cca
            r261 = r130
            goto L_0x0cd6
        L_0x0cca:
            double r12 = r1.getDouble(r10)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r261 = r12
        L_0x0cd6:
            boolean r12 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0ce0
            r262 = r130
            goto L_0x0cec
        L_0x0ce0:
            double r12 = r1.getDouble(r11)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r262 = r12
        L_0x0cec:
            com.blueair.core.model.IndoorDatapoint r251 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0e50 }
            r251.<init>(r252, r254, r255, r256, r257, r258, r259, r260, r261, r262)     // Catch:{ all -> 0x0e50 }
            r143 = r251
            goto L_0x0bbe
        L_0x0cf5:
            boolean r13 = r1.isNull(r12)     // Catch:{ all -> 0x0e50 }
            if (r13 == 0) goto L_0x0d3c
            r13 = r125
            boolean r123 = r1.isNull(r13)     // Catch:{ all -> 0x0e50 }
            if (r123 == 0) goto L_0x0d31
            r123 = r2
            r2 = r126
            boolean r124 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r124 == 0) goto L_0x0d2c
            r124 = r3
            r3 = r127
            boolean r125 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r125 == 0) goto L_0x0d46
            r125 = r4
            r4 = r128
            boolean r126 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r126 != 0) goto L_0x0d22
            goto L_0x0d4a
        L_0x0d22:
            r128 = r3
            r126 = r5
            r127 = r6
            r181 = r130
            r6 = r2
            goto L_0x0d85
        L_0x0d2c:
            r124 = r3
            r125 = r4
            goto L_0x0d39
        L_0x0d31:
            r123 = r2
            r124 = r3
            r125 = r4
            r2 = r126
        L_0x0d39:
            r3 = r127
            goto L_0x0d48
        L_0x0d3c:
            r123 = r2
            r124 = r3
            r13 = r125
            r2 = r126
            r3 = r127
        L_0x0d46:
            r125 = r4
        L_0x0d48:
            r4 = r128
        L_0x0d4a:
            double r252 = r1.getDouble(r12)     // Catch:{ all -> 0x0e50 }
            double r254 = r1.getDouble(r13)     // Catch:{ all -> 0x0e50 }
            r126 = r5
            r127 = r6
            long r5 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r5 = (int) r5     // Catch:{ all -> 0x0e50 }
            boolean r6 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r6 == 0) goto L_0x0d68
        L_0x0d61:
            r6 = r2
            r128 = r3
            r257 = r130
            goto L_0x0d6d
        L_0x0d68:
            java.lang.String r130 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            goto L_0x0d61
        L_0x0d6d:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0d78
            r258 = r141
            goto L_0x0d7b
        L_0x0d78:
            r258 = r131
        L_0x0d7b:
            com.blueair.core.model.WelcomeHomeLocation r251 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0e50 }
            r256 = r5
            r251.<init>(r252, r254, r256, r257, r258)     // Catch:{ all -> 0x0e50 }
            r181 = r251
        L_0x0d85:
            com.blueair.database.entity.DeviceEntity r131 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0e50 }
            r141 = r250
            r131.<init>(r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r191, r192, r193, r194, r195, r196, r197, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r211, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247)     // Catch:{ all -> 0x0e50 }
            r2 = r131
            r15.add(r2)     // Catch:{ all -> 0x0e50 }
            r2 = r4
            r4 = r263
            r263 = r16
            r16 = r17
            r17 = r34
            r34 = r35
            r35 = r36
            r36 = r40
            r40 = r41
            r41 = r42
            r42 = r43
            r43 = r44
            r44 = r46
            r46 = r48
            r48 = r50
            r50 = r52
            r52 = r54
            r54 = r59
            r59 = r60
            r60 = r63
            r63 = r64
            r64 = r65
            r65 = r66
            r66 = r67
            r67 = r68
            r68 = r69
            r69 = r70
            r70 = r71
            r71 = r75
            r75 = r76
            r76 = r77
            r77 = r80
            r80 = r81
            r81 = r82
            r82 = r83
            r83 = r84
            r84 = r87
            r87 = r88
            r88 = r89
            r89 = r90
            r90 = r93
            r93 = r94
            r94 = r95
            r95 = r96
            r96 = r97
            r97 = r98
            r98 = r99
            r99 = r100
            r100 = r107
            r107 = r108
            r108 = r109
            r109 = r114
            r114 = r123
            r123 = r11
            r11 = r120
            r120 = r8
            r8 = r117
            r117 = r126
            r126 = r6
            r6 = r110
            r110 = r111
            r111 = r112
            r112 = r113
            r113 = r115
            r115 = r124
            r124 = r12
            r12 = r121
            r121 = r9
            r9 = r118
            r118 = r127
            r127 = r128
            r128 = r2
            r2 = r119
            r119 = r7
            r7 = r116
            r116 = r125
            r125 = r13
            r13 = r122
            r122 = r10
            r10 = r2
            r5 = r37
            r37 = r38
            r38 = r39
            r39 = r49
            r49 = r51
            r51 = r53
            r53 = r55
            r55 = r56
            r56 = r57
            r57 = r58
            r2 = r129
            r3 = r248
            r58 = r249
            goto L_0x03f2
        L_0x0e4c:
            r1.close()
            return r15
        L_0x0e50:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$getLiveDevices$4(androidx.sqlite.SQLiteConnection):java.util.List");
    }

    public Flow<List<DeviceEntity>> getFlowDevices() {
        return FlowUtil.createFlow(this.__db, false, new String[]{DeviceEntity.DEVICE_TABLE}, new DeviceDao_Impl$$ExternalSyntheticLambda59());
    }

    /* JADX WARNING: Removed duplicated region for block: B:316:0x0b0b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0b0e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0b1a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0b1d A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0b29 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0b2c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0b38 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0b3b A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0b47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0b4a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x0c28 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0c2f A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0c44 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0c47 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0c58 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0c5c A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0c6e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0c72 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0c84 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0c88 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0c9a A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0c9e A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0cb0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0cb4 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0cc6 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0cca A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0cdc A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0ce0 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0d68 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0d74 A[Catch:{ all -> 0x0e50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0d78 A[Catch:{ all -> 0x0e50 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.List lambda$getFlowDevices$5(androidx.sqlite.SQLiteConnection r263) {
        /*
            java.lang.String r0 = "SELECT * from device_table ORDER BY modelName DESC"
            r1 = r263
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r0)
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0e50 }
            java.lang.String r2 = "name"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0e50 }
            java.lang.String r3 = "modelName"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0e50 }
            java.lang.String r4 = "typeIndex"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0e50 }
            java.lang.String r5 = "fanSpeed"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0e50 }
            java.lang.String r6 = "filterLife"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0e50 }
            java.lang.String r7 = "autoModeText"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0e50 }
            java.lang.String r8 = "brightness"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0e50 }
            java.lang.String r9 = "info"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0e50 }
            java.lang.String r10 = "hasFinishedOnboarding"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0e50 }
            java.lang.String r11 = "lastSelectedSensorType"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0e50 }
            java.lang.String r12 = "isAblDevice"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0e50 }
            java.lang.String r13 = "isNightModeOn"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0e50 }
            java.lang.String r14 = "isChildLockOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0e50 }
            java.lang.String r15 = "linkedDeviceUid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r263 = r15
            java.lang.String r15 = "connectivityStatusIndex"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r16 = r15
            java.lang.String r15 = "lastConnectivityMillis"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r17 = r15
            java.lang.String r15 = "mac"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r18 = r15
            java.lang.String r15 = "mcuFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r19 = r15
            java.lang.String r15 = "wifiFirmware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r20 = r15
            java.lang.String r15 = "hardware"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r21 = r15
            java.lang.String r15 = "timeZone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r22 = r15
            java.lang.String r15 = "serial"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r23 = r15
            java.lang.String r15 = "purchaseDate"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r24 = r15
            java.lang.String r15 = "dealerName"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r25 = r15
            java.lang.String r15 = "dealerCountry"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r26 = r15
            java.lang.String r15 = "filterType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r27 = r15
            java.lang.String r15 = "filterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r28 = r15
            java.lang.String r15 = "pm1Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r29 = r15
            java.lang.String r15 = "pm10Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r30 = r15
            java.lang.String r15 = "pm25Ranges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r31 = r15
            java.lang.String r15 = "vocRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r32 = r15
            java.lang.String r15 = "hchoRanges"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r33 = r15
            java.lang.String r15 = "updateProgress"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r34 = r15
            java.lang.String r15 = "isStandByOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r35 = r15
            java.lang.String r15 = "isEcoModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r36 = r15
            java.lang.String r15 = "isHinsModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r37 = r15
            java.lang.String r15 = "isHinsNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r38 = r15
            java.lang.String r15 = "isG4NightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r39 = r15
            java.lang.String r15 = "isGermShieldOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r40 = r15
            java.lang.String r15 = "isGermShieldNightModeOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r41 = r15
            java.lang.String r15 = "isSafetySwitchOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r42 = r15
            java.lang.String r15 = "g4NightModefilterTrigger"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r43 = r15
            java.lang.String r15 = "aimInstalled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r44 = r15
            java.lang.String r15 = "sku"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r45 = r15
            java.lang.String r15 = "compatibility"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r46 = r15
            java.lang.String r15 = "locationId"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r47 = r15
            java.lang.String r15 = "disinfection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r48 = r15
            java.lang.String r15 = "disinfectLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r49 = r15
            java.lang.String r15 = "disinfectLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r50 = r15
            java.lang.String r15 = "wickdryEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r51 = r15
            java.lang.String r15 = "wickdryOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r52 = r15
            java.lang.String r15 = "wickdryLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r53 = r15
            java.lang.String r15 = "wickdryLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r54 = r15
            java.lang.String r15 = "wickUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r55 = r15
            java.lang.String r15 = "waterShortage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r56 = r15
            java.lang.String r15 = "autoRh"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r57 = r15
            java.lang.String r15 = "timerStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r58 = r15
            java.lang.String r15 = "timerDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r59 = r15
            java.lang.String r15 = "timerLeftTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r60 = r15
            java.lang.String r15 = "timerLeftTimeUpdateTime"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r61 = r15
            java.lang.String r15 = "temperatureUnit"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r62 = r15
            java.lang.String r15 = "oscillationState"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r63 = r15
            java.lang.String r15 = "oscillationAngle"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r64 = r15
            java.lang.String r15 = "oscillationDirection"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r65 = r15
            java.lang.String r15 = "oscillationFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r66 = r15
            java.lang.String r15 = "mainMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r67 = r15
            java.lang.String r15 = "apSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r68 = r15
            java.lang.String r15 = "apFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r69 = r15
            java.lang.String r15 = "heatSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r70 = r15
            java.lang.String r15 = "heatFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r71 = r15
            java.lang.String r15 = "heatAutoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r72 = r15
            java.lang.String r15 = "heatEcoTmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r73 = r15
            java.lang.String r15 = "coolSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r74 = r15
            java.lang.String r15 = "coolFanSpeed"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r75 = r15
            java.lang.String r15 = "coolAutoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r76 = r15
            java.lang.String r15 = "coolAutoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r77 = r15
            java.lang.String r15 = "coolEcoTag"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r78 = r15
            java.lang.String r15 = "coolEcoPresets"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r79 = r15
            java.lang.String r15 = "humMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r80 = r15
            java.lang.String r15 = "mode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r81 = r15
            java.lang.String r15 = "waterLevel"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r82 = r15
            java.lang.String r15 = "dehSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r83 = r15
            java.lang.String r15 = "waterTankFailure"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r84 = r15
            java.lang.String r15 = "smartSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r85 = r15
            java.lang.String r15 = "detectCat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r86 = r15
            java.lang.String r15 = "bodyMounted"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r87 = r15
            java.lang.String r15 = "cleanAirEta"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r88 = r15
            java.lang.String r15 = "panelDisplayMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r89 = r15
            java.lang.String r15 = "hoverEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r90 = r15
            java.lang.String r15 = "airRefreshEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r91 = r15
            java.lang.String r15 = "airRefreshStatus"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r92 = r15
            java.lang.String r15 = "airRefreshDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r93 = r15
            java.lang.String r15 = "airRefreshTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r94 = r15
            java.lang.String r15 = "airRefreshStartTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r95 = r15
            java.lang.String r15 = "airRefreshEndTimeStamp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r96 = r15
            java.lang.String r15 = "roomType"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r97 = r15
            java.lang.String r15 = "nightLampBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r98 = r15
            java.lang.String r15 = "wickdryDuration"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r99 = r15
            java.lang.String r15 = "wickdryDone"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r100 = r15
            java.lang.String r15 = "ywrmEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r101 = r15
            java.lang.String r15 = "ywrmUsage"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r102 = r15
            java.lang.String r15 = "nightLampSteplessBrightness"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r103 = r15
            java.lang.String r15 = "alarms"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r104 = r15
            java.lang.String r15 = "humSubMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r105 = r15
            java.lang.String r15 = "use24Hour"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r106 = r15
            java.lang.String r15 = "waterInfill"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r107 = r15
            java.lang.String r15 = "sensorMode"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r108 = r15
            java.lang.String r15 = "uuid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r109 = r15
            java.lang.String r15 = "ssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r110 = r15
            java.lang.String r15 = "bssid"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r111 = r15
            java.lang.String r15 = "ipv4"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r112 = r15
            java.lang.String r15 = "ipv6"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r113 = r15
            java.lang.String r15 = "timeInSeconds"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r114 = r15
            java.lang.String r15 = "pm1"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r115 = r15
            java.lang.String r15 = "pm10"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r116 = r15
            java.lang.String r15 = "pm25"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r117 = r15
            java.lang.String r15 = "voc"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r118 = r15
            java.lang.String r15 = "hcho"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r119 = r15
            java.lang.String r15 = "tmp"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r120 = r15
            java.lang.String r15 = "hum"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r121 = r15
            java.lang.String r15 = "fan"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r122 = r15
            java.lang.String r15 = "weight"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r123 = r15
            java.lang.String r15 = "lat"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r124 = r15
            java.lang.String r15 = "lng"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r125 = r15
            java.lang.String r15 = "radius"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r126 = r15
            java.lang.String r15 = "textValue"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r127 = r15
            java.lang.String r15 = "isEnabled"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0e50 }
            r128 = r15
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0e50 }
            r15.<init>()     // Catch:{ all -> 0x0e50 }
        L_0x03f2:
            boolean r129 = r1.step()     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0e4c
            boolean r129 = r1.isNull(r0)     // Catch:{ all -> 0x0e50 }
            r130 = 0
            if (r129 == 0) goto L_0x0403
            r132 = r130
            goto L_0x0409
        L_0x0403:
            java.lang.String r129 = r1.getText(r0)     // Catch:{ all -> 0x0e50 }
            r132 = r129
        L_0x0409:
            boolean r129 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0412
            r133 = r130
            goto L_0x0418
        L_0x0412:
            java.lang.String r129 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r133 = r129
        L_0x0418:
            boolean r129 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r129 == 0) goto L_0x0425
            r134 = r130
            r129 = r2
            r248 = r3
            goto L_0x042f
        L_0x0425:
            java.lang.String r129 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r134 = r129
            r248 = r3
            r129 = r2
        L_0x042f:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x043f
            r135 = r2
            r136 = r130
            goto L_0x044c
        L_0x043f:
            r135 = r2
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r136 = r2
        L_0x044c:
            boolean r2 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0455
            r137 = r130
            goto L_0x0460
        L_0x0455:
            long r2 = r1.getLong(r6)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r137 = r2
        L_0x0460:
            boolean r2 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0469
            r138 = r130
            goto L_0x046f
        L_0x0469:
            java.lang.String r2 = r1.getText(r7)     // Catch:{ all -> 0x0e50 }
            r138 = r2
        L_0x046f:
            boolean r2 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0478
            r139 = r130
            goto L_0x0483
        L_0x0478:
            long r2 = r1.getLong(r8)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r139 = r2
        L_0x0483:
            boolean r2 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x048c
            r140 = r130
            goto L_0x0492
        L_0x048c:
            java.lang.String r2 = r1.getText(r9)     // Catch:{ all -> 0x0e50 }
            r140 = r2
        L_0x0492:
            long r2 = r1.getLong(r10)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = 1
            r131 = 0
            if (r2 == 0) goto L_0x049f
            r142 = r3
            goto L_0x04a1
        L_0x049f:
            r142 = r131
        L_0x04a1:
            boolean r2 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x04ad
            r141 = r3
            r2 = r4
            r144 = r130
            goto L_0x04bb
        L_0x04ad:
            r141 = r3
            r2 = r4
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r144 = r3
        L_0x04bb:
            long r3 = r1.getLong(r12)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04c5
            r145 = r141
            goto L_0x04c7
        L_0x04c5:
            r145 = r131
        L_0x04c7:
            long r3 = r1.getLong(r13)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04d1
            r146 = r141
            goto L_0x04d3
        L_0x04d1:
            r146 = r131
        L_0x04d3:
            long r3 = r1.getLong(r14)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x04dd
            r147 = r141
            goto L_0x04df
        L_0x04dd:
            r147 = r131
        L_0x04df:
            r3 = r263
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x04f1
            r148 = r130
        L_0x04e9:
            r263 = r2
            r4 = r16
            r16 = r3
            goto L_0x04f8
        L_0x04f1:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r148 = r4
            goto L_0x04e9
        L_0x04f8:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r17
            long r150 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r149 = r2
            r2 = r18
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0514
            r152 = r130
        L_0x050f:
            r18 = r2
            r2 = r19
            goto L_0x051b
        L_0x0514:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r152 = r17
            goto L_0x050f
        L_0x051b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0528
            r153 = r130
        L_0x0523:
            r19 = r2
            r2 = r20
            goto L_0x052f
        L_0x0528:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r153 = r17
            goto L_0x0523
        L_0x052f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x053c
            r154 = r130
        L_0x0537:
            r20 = r2
            r2 = r21
            goto L_0x0543
        L_0x053c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r154 = r17
            goto L_0x0537
        L_0x0543:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0550
            r155 = r130
        L_0x054b:
            r21 = r2
            r2 = r22
            goto L_0x0557
        L_0x0550:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r155 = r17
            goto L_0x054b
        L_0x0557:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0564
            r156 = r130
        L_0x055f:
            r22 = r2
            r2 = r23
            goto L_0x056b
        L_0x0564:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r156 = r17
            goto L_0x055f
        L_0x056b:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0578
            r157 = r130
        L_0x0573:
            r23 = r2
            r2 = r24
            goto L_0x057f
        L_0x0578:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r157 = r17
            goto L_0x0573
        L_0x057f:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x058c
            r158 = r130
        L_0x0587:
            r24 = r2
            r2 = r25
            goto L_0x0593
        L_0x058c:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r158 = r17
            goto L_0x0587
        L_0x0593:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05a0
            r159 = r130
        L_0x059b:
            r25 = r2
            r2 = r26
            goto L_0x05a7
        L_0x05a0:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r159 = r17
            goto L_0x059b
        L_0x05a7:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05b4
            r160 = r130
        L_0x05af:
            r26 = r2
            r2 = r27
            goto L_0x05bb
        L_0x05b4:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r160 = r17
            goto L_0x05af
        L_0x05bb:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05c8
            r161 = r130
        L_0x05c3:
            r27 = r2
            r2 = r28
            goto L_0x05cf
        L_0x05c8:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r161 = r17
            goto L_0x05c3
        L_0x05cf:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05dc
            r162 = r130
        L_0x05d7:
            r28 = r2
            r2 = r29
            goto L_0x05e3
        L_0x05dc:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r162 = r17
            goto L_0x05d7
        L_0x05e3:
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x05ec
            r17 = r130
            goto L_0x05f0
        L_0x05ec:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x05f0:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r29 = r2
            r2 = r30
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0601
            r17 = r130
            goto L_0x0605
        L_0x0601:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0605:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r30 = r2
            r2 = r31
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0616
            r17 = r130
            goto L_0x061a
        L_0x0616:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x061a:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r31 = r2
            r2 = r32
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x062b
            r17 = r130
            goto L_0x062f
        L_0x062b:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x062f:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r32 = r2
            r2 = r33
            boolean r17 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r17 == 0) goto L_0x0640
            r17 = r130
            goto L_0x0644
        L_0x0640:
            java.lang.String r17 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0644:
            double[] r167 = com.blueair.database.DoubleArrayConverter.fromString(r17)     // Catch:{ all -> 0x0e50 }
            r33 = r2
            r17 = r4
            r2 = r34
            r34 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r168 = r3
            r4 = r35
            r35 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0665
            r169 = r141
            goto L_0x0667
        L_0x0665:
            r169 = r131
        L_0x0667:
            r2 = r36
            r36 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0675
            r170 = r141
            goto L_0x0677
        L_0x0675:
            r170 = r131
        L_0x0677:
            r3 = r37
            r37 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0685
            r171 = r141
            goto L_0x0687
        L_0x0685:
            r171 = r131
        L_0x0687:
            r5 = r2
            r4 = r38
            r38 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0696
            r172 = r141
            goto L_0x0698
        L_0x0696:
            r172 = r131
        L_0x0698:
            r2 = r39
            r39 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06a6
            r173 = r141
            goto L_0x06a8
        L_0x06a6:
            r173 = r131
        L_0x06a8:
            r3 = r40
            r40 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x06b6
            r174 = r141
            goto L_0x06b8
        L_0x06b6:
            r174 = r131
        L_0x06b8:
            r4 = r41
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x06c6
            r5 = r2
            r41 = r3
            r2 = r130
            goto L_0x06d2
        L_0x06c6:
            r5 = r2
            r41 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x06d2:
            if (r2 != 0) goto L_0x06db
            r175 = r130
        L_0x06d6:
            r2 = r42
            r42 = r4
            goto L_0x06ed
        L_0x06db:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x06e4
            r2 = r141
            goto L_0x06e6
        L_0x06e4:
            r2 = r131
        L_0x06e6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r175 = r2
            goto L_0x06d6
        L_0x06ed:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x06f7
            r176 = r141
            goto L_0x06f9
        L_0x06f7:
            r176 = r131
        L_0x06f9:
            r3 = r43
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x070a
            r177 = r130
        L_0x0703:
            r43 = r2
            r4 = r44
            r44 = r3
            goto L_0x0711
        L_0x070a:
            java.lang.String r4 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r177 = r4
            goto L_0x0703
        L_0x0711:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x071b
            r178 = r141
            goto L_0x071d
        L_0x071b:
            r178 = r131
        L_0x071d:
            r2 = r45
            boolean r3 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x072a
            r179 = r130
        L_0x0727:
            r3 = r46
            goto L_0x0731
        L_0x072a:
            java.lang.String r3 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r179 = r3
            goto L_0x0727
        L_0x0731:
            boolean r45 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r45 == 0) goto L_0x073e
            r180 = r130
        L_0x0739:
            r45 = r2
            r2 = r47
            goto L_0x0745
        L_0x073e:
            java.lang.String r45 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r180 = r45
            goto L_0x0739
        L_0x0745:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0752
            r182 = r130
        L_0x074d:
            r47 = r2
            r2 = r48
            goto L_0x0759
        L_0x0752:
            java.lang.String r46 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r182 = r46
            goto L_0x074d
        L_0x0759:
            boolean r46 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r46 == 0) goto L_0x0766
            r48 = r3
            r46 = r4
            r3 = r130
            goto L_0x0773
        L_0x0766:
            r48 = r3
            r46 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0773:
            if (r3 != 0) goto L_0x077a
            r183 = r130
        L_0x0777:
            r3 = r49
            goto L_0x078c
        L_0x077a:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0783
            r3 = r141
            goto L_0x0785
        L_0x0783:
            r3 = r131
        L_0x0785:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0e50 }
            r183 = r3
            goto L_0x0777
        L_0x078c:
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0799
            r49 = r5
            r184 = r130
        L_0x0796:
            r4 = r50
            goto L_0x07a7
        L_0x0799:
            r49 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0e50 }
            r184 = r4
            goto L_0x0796
        L_0x07a7:
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x07b6
            r185 = r130
        L_0x07af:
            r50 = r2
            r5 = r51
            r51 = r3
            goto L_0x07c1
        L_0x07b6:
            long r185 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            java.lang.Long r5 = java.lang.Long.valueOf(r185)     // Catch:{ all -> 0x0e50 }
            r185 = r5
            goto L_0x07af
        L_0x07c1:
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x07cb
            r186 = r141
            goto L_0x07cd
        L_0x07cb:
            r186 = r131
        L_0x07cd:
            r2 = r52
            r52 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x07db
            r187 = r141
            goto L_0x07dd
        L_0x07db:
            r187 = r131
        L_0x07dd:
            r3 = r53
            r53 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r54
            long r189 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            r54 = r2
            r188 = r4
            r2 = r55
            r55 = r3
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r191 = r3
            r4 = r56
            r56 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0809
            r192 = r141
            goto L_0x080b
        L_0x0809:
            r192 = r131
        L_0x080b:
            r2 = r57
            r57 = r4
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r193 = r3
            r4 = r58
            r58 = r2
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r249 = r4
            r3 = r59
            r59 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r194 = r2
            r5 = r60
            r60 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r61
            long r197 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            r196 = r2
            r195 = r4
            r2 = r62
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r62 = r2
            r199 = r3
            r4 = r63
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r63 = r5
            r3 = r64
            r64 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r200 = r2
            r5 = r65
            r65 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r201 = r4
            r3 = r66
            r66 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r202 = r2
            r5 = r67
            r67 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r203 = r4
            r3 = r68
            r68 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r204 = r2
            r5 = r69
            r69 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r205 = r4
            r3 = r70
            r70 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r206 = r2
            r5 = r71
            r71 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r72
            double r209 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            r208 = r2
            r2 = r73
            double r211 = r1.getDouble(r2)     // Catch:{ all -> 0x0e50 }
            r73 = r2
            r72 = r3
            r207 = r4
            r2 = r74
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r74 = r2
            r213 = r3
            r4 = r75
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r75 = r5
            r3 = r76
            r76 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r77
            boolean r77 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r77 == 0) goto L_0x08e5
            r77 = r130
            goto L_0x08e9
        L_0x08e5:
            java.lang.String r77 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
        L_0x08e9:
            double[] r216 = com.blueair.database.DoubleArrayConverter.fromString(r77)     // Catch:{ all -> 0x0e50 }
            r214 = r2
            r77 = r3
            r215 = r4
            r2 = r78
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r4 = r79
            boolean r78 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r78 == 0) goto L_0x0905
            r78 = r130
            goto L_0x0909
        L_0x0905:
            java.lang.String r78 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
        L_0x0909:
            double[] r218 = com.blueair.database.DoubleArrayConverter.fromString(r78)     // Catch:{ all -> 0x0e50 }
            r78 = r2
            r217 = r3
            r79 = r4
            r2 = r80
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x091f
            r219 = r141
            goto L_0x0921
        L_0x091f:
            r219 = r131
        L_0x0921:
            r80 = r5
            r3 = r81
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r81 = r2
            r5 = r82
            r82 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r220 = r4
            r3 = r83
            r83 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r221 = r2
            r5 = r84
            r84 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0950
            r223 = r141
            goto L_0x0952
        L_0x0950:
            r223 = r131
        L_0x0952:
            r222 = r4
            r2 = r85
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r85 = r2
            r224 = r3
            r4 = r86
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x096b
            r225 = r141
            goto L_0x096d
        L_0x096b:
            r225 = r131
        L_0x096d:
            r86 = r4
            r2 = r87
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x097b
            r226 = r141
            goto L_0x097d
        L_0x097b:
            r226 = r131
        L_0x097d:
            r87 = r5
            r3 = r88
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r88 = r2
            r5 = r89
            r89 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r227 = r4
            r3 = r90
            r90 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x09a1
            r229 = r141
            goto L_0x09a3
        L_0x09a1:
            r229 = r131
        L_0x09a3:
            r228 = r2
            r5 = r3
            r4 = r91
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x09b2
            r230 = r141
            goto L_0x09b4
        L_0x09b2:
            r230 = r131
        L_0x09b4:
            r91 = r4
            r2 = r92
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r92 = r2
            r231 = r3
            r4 = r93
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r93 = r5
            r3 = r94
            r94 = r4
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r232 = r2
            r5 = r95
            r95 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r233 = r4
            r3 = r96
            r96 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r234 = r2
            r5 = r97
            r97 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r235 = r4
            r3 = r98
            r98 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r236 = r2
            r5 = r99
            r99 = r3
            long r2 = r1.getLong(r5)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r237 = r4
            r3 = r100
            r100 = r5
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            if (r4 == 0) goto L_0x0a1a
            r239 = r141
            goto L_0x0a1c
        L_0x0a1a:
            r239 = r131
        L_0x0a1c:
            r4 = r101
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r5 == 0) goto L_0x0a2a
            r238 = r2
            r5 = r3
            r2 = r130
            goto L_0x0a36
        L_0x0a2a:
            r238 = r2
            r5 = r3
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e50 }
        L_0x0a36:
            if (r2 != 0) goto L_0x0a3f
            r240 = r130
        L_0x0a3a:
            r101 = r4
            r2 = r102
            goto L_0x0a51
        L_0x0a3f:
            int r2 = r2.intValue()     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a48
            r2 = r141
            goto L_0x0a4a
        L_0x0a48:
            r2 = r131
        L_0x0a4a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0e50 }
            r240 = r2
            goto L_0x0a3a
        L_0x0a51:
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r102 = r2
            r241 = r3
            r4 = r103
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            r3 = r104
            boolean r103 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r103 == 0) goto L_0x0a6c
            r103 = r130
            goto L_0x0a70
        L_0x0a6c:
            java.lang.String r103 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
        L_0x0a70:
            java.util.List r243 = com.blueair.database.DeviceAlarmListConverter.fromString(r103)     // Catch:{ all -> 0x0e50 }
            r242 = r2
            r104 = r3
            r103 = r4
            r2 = r105
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            r105 = r2
            r244 = r3
            r4 = r106
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0a91
            r245 = r141
            goto L_0x0a93
        L_0x0a91:
            r245 = r131
        L_0x0a93:
            r106 = r4
            r2 = r107
            long r3 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r3 = (int) r3     // Catch:{ all -> 0x0e50 }
            if (r3 == 0) goto L_0x0aa1
            r246 = r141
            goto L_0x0aa3
        L_0x0aa1:
            r246 = r131
        L_0x0aa3:
            r107 = r5
            r3 = r108
            long r4 = r1.getLong(r3)     // Catch:{ all -> 0x0e50 }
            int r4 = (int) r4     // Catch:{ all -> 0x0e50 }
            r5 = r109
            boolean r108 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r108 == 0) goto L_0x0af5
            r108 = r2
            r2 = r110
            boolean r109 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r109 == 0) goto L_0x0aea
            r109 = r3
            r3 = r111
            boolean r110 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0ae5
            r247 = r4
            r4 = r112
            boolean r110 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r110 == 0) goto L_0x0b01
            r110 = r6
            r6 = r113
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 != 0) goto L_0x0add
            goto L_0x0b05
        L_0x0add:
            r250 = r130
        L_0x0adf:
            r111 = r2
            r2 = r114
            goto L_0x0b56
        L_0x0ae5:
            r247 = r4
            r110 = r6
            goto L_0x0af2
        L_0x0aea:
            r109 = r3
            r247 = r4
            r110 = r6
            r3 = r111
        L_0x0af2:
            r4 = r112
            goto L_0x0b03
        L_0x0af5:
            r108 = r2
            r109 = r3
            r247 = r4
            r2 = r110
            r3 = r111
            r4 = r112
        L_0x0b01:
            r110 = r6
        L_0x0b03:
            r6 = r113
        L_0x0b05:
            boolean r111 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b0e
            r251 = r130
            goto L_0x0b14
        L_0x0b0e:
            java.lang.String r111 = r1.getText(r5)     // Catch:{ all -> 0x0e50 }
            r251 = r111
        L_0x0b14:
            boolean r111 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b1d
            r252 = r130
            goto L_0x0b23
        L_0x0b1d:
            java.lang.String r111 = r1.getText(r2)     // Catch:{ all -> 0x0e50 }
            r252 = r111
        L_0x0b23:
            boolean r111 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b2c
            r253 = r130
            goto L_0x0b32
        L_0x0b2c:
            java.lang.String r111 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            r253 = r111
        L_0x0b32:
            boolean r111 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b3b
            r254 = r130
            goto L_0x0b41
        L_0x0b3b:
            java.lang.String r111 = r1.getText(r4)     // Catch:{ all -> 0x0e50 }
            r254 = r111
        L_0x0b41:
            boolean r111 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r111 == 0) goto L_0x0b4a
            r255 = r130
            goto L_0x0b50
        L_0x0b4a:
            java.lang.String r111 = r1.getText(r6)     // Catch:{ all -> 0x0e50 }
            r255 = r111
        L_0x0b50:
            com.blueair.database.DeviceUuidEntity r250 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0e50 }
            r250.<init>(r251, r252, r253, r254, r255)     // Catch:{ all -> 0x0e50 }
            goto L_0x0adf
        L_0x0b56:
            boolean r112 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r112 == 0) goto L_0x0bfa
            r112 = r3
            r3 = r115
            boolean r113 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r113 == 0) goto L_0x0bdd
            r113 = r4
            r4 = r116
            boolean r114 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r114 == 0) goto L_0x0bc2
            r114 = r5
            r5 = r117
            boolean r115 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r115 == 0) goto L_0x0c06
            r115 = r6
            r6 = r118
            boolean r116 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r116 == 0) goto L_0x0be9
            r116 = r7
            r7 = r119
            boolean r117 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r117 == 0) goto L_0x0bce
            r117 = r8
            r8 = r120
            boolean r118 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r118 == 0) goto L_0x0c12
            r118 = r9
            r9 = r121
            boolean r119 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r119 == 0) goto L_0x0bf5
            r119 = r10
            r10 = r122
            boolean r120 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r120 == 0) goto L_0x0bda
            r120 = r11
            r11 = r123
            boolean r121 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r121 != 0) goto L_0x0bb8
            goto L_0x0c1e
        L_0x0bb8:
            r121 = r12
            r122 = r13
            r143 = r130
        L_0x0bbe:
            r12 = r124
            goto L_0x0cf5
        L_0x0bc2:
            r114 = r5
            r115 = r6
            r116 = r7
            r5 = r117
            r6 = r118
            r7 = r119
        L_0x0bce:
            r117 = r8
            r118 = r9
            r119 = r10
            r8 = r120
            r9 = r121
            r10 = r122
        L_0x0bda:
            r120 = r11
            goto L_0x0c1c
        L_0x0bdd:
            r113 = r4
            r114 = r5
            r115 = r6
            r4 = r116
            r5 = r117
            r6 = r118
        L_0x0be9:
            r116 = r7
            r117 = r8
            r118 = r9
            r7 = r119
            r8 = r120
            r9 = r121
        L_0x0bf5:
            r119 = r10
            r120 = r11
            goto L_0x0c1a
        L_0x0bfa:
            r112 = r3
            r113 = r4
            r114 = r5
            r3 = r115
            r4 = r116
            r5 = r117
        L_0x0c06:
            r115 = r6
            r116 = r7
            r117 = r8
            r6 = r118
            r7 = r119
            r8 = r120
        L_0x0c12:
            r118 = r9
            r119 = r10
            r120 = r11
            r9 = r121
        L_0x0c1a:
            r10 = r122
        L_0x0c1c:
            r11 = r123
        L_0x0c1e:
            long r252 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            boolean r121 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r121 == 0) goto L_0x0c2f
            r121 = r12
            r122 = r13
            r254 = r130
            goto L_0x0c3e
        L_0x0c2f:
            r121 = r12
            r122 = r13
            double r12 = r1.getDouble(r3)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r254 = r12
        L_0x0c3e:
            boolean r12 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c47
            r255 = r130
            goto L_0x0c52
        L_0x0c47:
            double r12 = r1.getDouble(r4)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r255 = r12
        L_0x0c52:
            boolean r12 = r1.isNull(r5)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c5c
            r256 = r130
            goto L_0x0c68
        L_0x0c5c:
            double r12 = r1.getDouble(r5)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r256 = r12
        L_0x0c68:
            boolean r12 = r1.isNull(r6)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c72
            r257 = r130
            goto L_0x0c7e
        L_0x0c72:
            double r12 = r1.getDouble(r6)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r257 = r12
        L_0x0c7e:
            boolean r12 = r1.isNull(r7)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c88
            r258 = r130
            goto L_0x0c94
        L_0x0c88:
            double r12 = r1.getDouble(r7)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r258 = r12
        L_0x0c94:
            boolean r12 = r1.isNull(r8)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0c9e
            r259 = r130
            goto L_0x0caa
        L_0x0c9e:
            double r12 = r1.getDouble(r8)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r259 = r12
        L_0x0caa:
            boolean r12 = r1.isNull(r9)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cb4
            r260 = r130
            goto L_0x0cc0
        L_0x0cb4:
            double r12 = r1.getDouble(r9)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r260 = r12
        L_0x0cc0:
            boolean r12 = r1.isNull(r10)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0cca
            r261 = r130
            goto L_0x0cd6
        L_0x0cca:
            double r12 = r1.getDouble(r10)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r261 = r12
        L_0x0cd6:
            boolean r12 = r1.isNull(r11)     // Catch:{ all -> 0x0e50 }
            if (r12 == 0) goto L_0x0ce0
            r262 = r130
            goto L_0x0cec
        L_0x0ce0:
            double r12 = r1.getDouble(r11)     // Catch:{ all -> 0x0e50 }
            float r12 = (float) r12     // Catch:{ all -> 0x0e50 }
            java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x0e50 }
            r262 = r12
        L_0x0cec:
            com.blueair.core.model.IndoorDatapoint r251 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0e50 }
            r251.<init>(r252, r254, r255, r256, r257, r258, r259, r260, r261, r262)     // Catch:{ all -> 0x0e50 }
            r143 = r251
            goto L_0x0bbe
        L_0x0cf5:
            boolean r13 = r1.isNull(r12)     // Catch:{ all -> 0x0e50 }
            if (r13 == 0) goto L_0x0d3c
            r13 = r125
            boolean r123 = r1.isNull(r13)     // Catch:{ all -> 0x0e50 }
            if (r123 == 0) goto L_0x0d31
            r123 = r2
            r2 = r126
            boolean r124 = r1.isNull(r2)     // Catch:{ all -> 0x0e50 }
            if (r124 == 0) goto L_0x0d2c
            r124 = r3
            r3 = r127
            boolean r125 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r125 == 0) goto L_0x0d46
            r125 = r4
            r4 = r128
            boolean r126 = r1.isNull(r4)     // Catch:{ all -> 0x0e50 }
            if (r126 != 0) goto L_0x0d22
            goto L_0x0d4a
        L_0x0d22:
            r128 = r3
            r126 = r5
            r127 = r6
            r181 = r130
            r6 = r2
            goto L_0x0d85
        L_0x0d2c:
            r124 = r3
            r125 = r4
            goto L_0x0d39
        L_0x0d31:
            r123 = r2
            r124 = r3
            r125 = r4
            r2 = r126
        L_0x0d39:
            r3 = r127
            goto L_0x0d48
        L_0x0d3c:
            r123 = r2
            r124 = r3
            r13 = r125
            r2 = r126
            r3 = r127
        L_0x0d46:
            r125 = r4
        L_0x0d48:
            r4 = r128
        L_0x0d4a:
            double r252 = r1.getDouble(r12)     // Catch:{ all -> 0x0e50 }
            double r254 = r1.getDouble(r13)     // Catch:{ all -> 0x0e50 }
            r126 = r5
            r127 = r6
            long r5 = r1.getLong(r2)     // Catch:{ all -> 0x0e50 }
            int r5 = (int) r5     // Catch:{ all -> 0x0e50 }
            boolean r6 = r1.isNull(r3)     // Catch:{ all -> 0x0e50 }
            if (r6 == 0) goto L_0x0d68
        L_0x0d61:
            r6 = r2
            r128 = r3
            r257 = r130
            goto L_0x0d6d
        L_0x0d68:
            java.lang.String r130 = r1.getText(r3)     // Catch:{ all -> 0x0e50 }
            goto L_0x0d61
        L_0x0d6d:
            long r2 = r1.getLong(r4)     // Catch:{ all -> 0x0e50 }
            int r2 = (int) r2     // Catch:{ all -> 0x0e50 }
            if (r2 == 0) goto L_0x0d78
            r258 = r141
            goto L_0x0d7b
        L_0x0d78:
            r258 = r131
        L_0x0d7b:
            com.blueair.core.model.WelcomeHomeLocation r251 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0e50 }
            r256 = r5
            r251.<init>(r252, r254, r256, r257, r258)     // Catch:{ all -> 0x0e50 }
            r181 = r251
        L_0x0d85:
            com.blueair.database.entity.DeviceEntity r131 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0e50 }
            r141 = r250
            r131.<init>(r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r191, r192, r193, r194, r195, r196, r197, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r211, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247)     // Catch:{ all -> 0x0e50 }
            r2 = r131
            r15.add(r2)     // Catch:{ all -> 0x0e50 }
            r2 = r4
            r4 = r263
            r263 = r16
            r16 = r17
            r17 = r34
            r34 = r35
            r35 = r36
            r36 = r40
            r40 = r41
            r41 = r42
            r42 = r43
            r43 = r44
            r44 = r46
            r46 = r48
            r48 = r50
            r50 = r52
            r52 = r54
            r54 = r59
            r59 = r60
            r60 = r63
            r63 = r64
            r64 = r65
            r65 = r66
            r66 = r67
            r67 = r68
            r68 = r69
            r69 = r70
            r70 = r71
            r71 = r75
            r75 = r76
            r76 = r77
            r77 = r80
            r80 = r81
            r81 = r82
            r82 = r83
            r83 = r84
            r84 = r87
            r87 = r88
            r88 = r89
            r89 = r90
            r90 = r93
            r93 = r94
            r94 = r95
            r95 = r96
            r96 = r97
            r97 = r98
            r98 = r99
            r99 = r100
            r100 = r107
            r107 = r108
            r108 = r109
            r109 = r114
            r114 = r123
            r123 = r11
            r11 = r120
            r120 = r8
            r8 = r117
            r117 = r126
            r126 = r6
            r6 = r110
            r110 = r111
            r111 = r112
            r112 = r113
            r113 = r115
            r115 = r124
            r124 = r12
            r12 = r121
            r121 = r9
            r9 = r118
            r118 = r127
            r127 = r128
            r128 = r2
            r2 = r119
            r119 = r7
            r7 = r116
            r116 = r125
            r125 = r13
            r13 = r122
            r122 = r10
            r10 = r2
            r5 = r37
            r37 = r38
            r38 = r39
            r39 = r49
            r49 = r51
            r51 = r53
            r53 = r55
            r55 = r56
            r56 = r57
            r57 = r58
            r2 = r129
            r3 = r248
            r58 = r249
            goto L_0x03f2
        L_0x0e4c:
            r1.close()
            return r15
        L_0x0e50:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$getFlowDevices$5(androidx.sqlite.SQLiteConnection):java.util.List");
    }

    public LiveData<DeviceEntity> liveDevice(String str) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DeviceEntity.DEVICE_TABLE}, false, new DeviceDao_Impl$$ExternalSyntheticLambda73(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v0, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v1, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v2, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v3, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v5, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX WARNING: type inference failed for: r129v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0a0e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0a11 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0a1d A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0a20 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0a2c A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0a2f A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a3b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0a3e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a4a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0a4d A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0b2b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0b32 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0b47 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0b4a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0b5b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0b5e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0b6f A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0b72 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0b83 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0b86 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0b97 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0b9a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0bab A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x0bae A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0bbf A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0bc2 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0bd3 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0bd6 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0c2b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0c2c A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0c37 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0c39 A[Catch:{ all -> 0x0c5a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceEntity lambda$liveDevice$6(java.lang.String r249, androidx.sqlite.SQLiteConnection r250) {
        /*
            r0 = r249
            java.lang.String r1 = "SELECT * from device_table WHERE uid = ?"
            r2 = r250
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0c5a }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0c5a }
        L_0x0014:
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0c5a }
            java.lang.String r3 = "name"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0c5a }
            java.lang.String r4 = "modelName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0c5a }
            java.lang.String r5 = "typeIndex"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0c5a }
            java.lang.String r6 = "fanSpeed"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0c5a }
            java.lang.String r7 = "filterLife"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0c5a }
            java.lang.String r8 = "autoModeText"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0c5a }
            java.lang.String r9 = "brightness"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0c5a }
            java.lang.String r10 = "info"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0c5a }
            java.lang.String r11 = "hasFinishedOnboarding"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0c5a }
            java.lang.String r12 = "lastSelectedSensorType"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0c5a }
            java.lang.String r13 = "isAblDevice"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0c5a }
            java.lang.String r14 = "isNightModeOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0c5a }
            java.lang.String r15 = "isChildLockOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0c5a }
            java.lang.String r2 = "linkedDeviceUid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r249 = r2
            java.lang.String r2 = "connectivityStatusIndex"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r16 = r2
            java.lang.String r2 = "lastConnectivityMillis"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r17 = r2
            java.lang.String r2 = "mac"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r18 = r2
            java.lang.String r2 = "mcuFirmware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r19 = r2
            java.lang.String r2 = "wifiFirmware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r20 = r2
            java.lang.String r2 = "hardware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r21 = r2
            java.lang.String r2 = "timeZone"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r22 = r2
            java.lang.String r2 = "serial"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r23 = r2
            java.lang.String r2 = "purchaseDate"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r24 = r2
            java.lang.String r2 = "dealerName"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r25 = r2
            java.lang.String r2 = "dealerCountry"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r26 = r2
            java.lang.String r2 = "filterType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r27 = r2
            java.lang.String r2 = "filterTrigger"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r28 = r2
            java.lang.String r2 = "pm1Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r29 = r2
            java.lang.String r2 = "pm10Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r30 = r2
            java.lang.String r2 = "pm25Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r31 = r2
            java.lang.String r2 = "vocRanges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r32 = r2
            java.lang.String r2 = "hchoRanges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r33 = r2
            java.lang.String r2 = "updateProgress"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r34 = r2
            java.lang.String r2 = "isStandByOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r35 = r2
            java.lang.String r2 = "isEcoModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r36 = r2
            java.lang.String r2 = "isHinsModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r37 = r2
            java.lang.String r2 = "isHinsNightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r38 = r2
            java.lang.String r2 = "isG4NightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r39 = r2
            java.lang.String r2 = "isGermShieldOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r40 = r2
            java.lang.String r2 = "isGermShieldNightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r41 = r2
            java.lang.String r2 = "isSafetySwitchOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r42 = r2
            java.lang.String r2 = "g4NightModefilterTrigger"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r43 = r2
            java.lang.String r2 = "aimInstalled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r44 = r2
            java.lang.String r2 = "sku"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r45 = r2
            java.lang.String r2 = "compatibility"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r46 = r2
            java.lang.String r2 = "locationId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r47 = r2
            java.lang.String r2 = "disinfection"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r48 = r2
            java.lang.String r2 = "disinfectLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r49 = r2
            java.lang.String r2 = "disinfectLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r50 = r2
            java.lang.String r2 = "wickdryEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r51 = r2
            java.lang.String r2 = "wickdryOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r52 = r2
            java.lang.String r2 = "wickdryLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r53 = r2
            java.lang.String r2 = "wickdryLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r54 = r2
            java.lang.String r2 = "wickUsage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r55 = r2
            java.lang.String r2 = "waterShortage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r56 = r2
            java.lang.String r2 = "autoRh"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r57 = r2
            java.lang.String r2 = "timerStatus"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r58 = r2
            java.lang.String r2 = "timerDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r59 = r2
            java.lang.String r2 = "timerLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r60 = r2
            java.lang.String r2 = "timerLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r61 = r2
            java.lang.String r2 = "temperatureUnit"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r62 = r2
            java.lang.String r2 = "oscillationState"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r63 = r2
            java.lang.String r2 = "oscillationAngle"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r64 = r2
            java.lang.String r2 = "oscillationDirection"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r65 = r2
            java.lang.String r2 = "oscillationFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r66 = r2
            java.lang.String r2 = "mainMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r67 = r2
            java.lang.String r2 = "apSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r68 = r2
            java.lang.String r2 = "apFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r69 = r2
            java.lang.String r2 = "heatSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r70 = r2
            java.lang.String r2 = "heatFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r71 = r2
            java.lang.String r2 = "heatAutoTmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r72 = r2
            java.lang.String r2 = "heatEcoTmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r73 = r2
            java.lang.String r2 = "coolSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r74 = r2
            java.lang.String r2 = "coolFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r75 = r2
            java.lang.String r2 = "coolAutoTag"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r76 = r2
            java.lang.String r2 = "coolAutoPresets"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r77 = r2
            java.lang.String r2 = "coolEcoTag"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r78 = r2
            java.lang.String r2 = "coolEcoPresets"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r79 = r2
            java.lang.String r2 = "humMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r80 = r2
            java.lang.String r2 = "mode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r81 = r2
            java.lang.String r2 = "waterLevel"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r82 = r2
            java.lang.String r2 = "dehSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r83 = r2
            java.lang.String r2 = "waterTankFailure"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r84 = r2
            java.lang.String r2 = "smartSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r85 = r2
            java.lang.String r2 = "detectCat"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r86 = r2
            java.lang.String r2 = "bodyMounted"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r87 = r2
            java.lang.String r2 = "cleanAirEta"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r88 = r2
            java.lang.String r2 = "panelDisplayMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r89 = r2
            java.lang.String r2 = "hoverEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r90 = r2
            java.lang.String r2 = "airRefreshEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r91 = r2
            java.lang.String r2 = "airRefreshStatus"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r92 = r2
            java.lang.String r2 = "airRefreshDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r93 = r2
            java.lang.String r2 = "airRefreshTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r94 = r2
            java.lang.String r2 = "airRefreshStartTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r95 = r2
            java.lang.String r2 = "airRefreshEndTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r96 = r2
            java.lang.String r2 = "roomType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r97 = r2
            java.lang.String r2 = "nightLampBrightness"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r98 = r2
            java.lang.String r2 = "wickdryDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r99 = r2
            java.lang.String r2 = "wickdryDone"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r100 = r2
            java.lang.String r2 = "ywrmEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r101 = r2
            java.lang.String r2 = "ywrmUsage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r102 = r2
            java.lang.String r2 = "nightLampSteplessBrightness"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r103 = r2
            java.lang.String r2 = "alarms"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r104 = r2
            java.lang.String r2 = "humSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r105 = r2
            java.lang.String r2 = "use24Hour"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r106 = r2
            java.lang.String r2 = "waterInfill"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r107 = r2
            java.lang.String r2 = "sensorMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r108 = r2
            java.lang.String r2 = "uuid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r109 = r2
            java.lang.String r2 = "ssid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r110 = r2
            java.lang.String r2 = "bssid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r111 = r2
            java.lang.String r2 = "ipv4"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r112 = r2
            java.lang.String r2 = "ipv6"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r113 = r2
            java.lang.String r2 = "timeInSeconds"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r114 = r2
            java.lang.String r2 = "pm1"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r115 = r2
            java.lang.String r2 = "pm10"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r116 = r2
            java.lang.String r2 = "pm25"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r117 = r2
            java.lang.String r2 = "voc"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r118 = r2
            java.lang.String r2 = "hcho"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r119 = r2
            java.lang.String r2 = "tmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r120 = r2
            java.lang.String r2 = "hum"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r121 = r2
            java.lang.String r2 = "fan"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r122 = r2
            java.lang.String r2 = "weight"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r123 = r2
            java.lang.String r2 = "lat"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r124 = r2
            java.lang.String r2 = "lng"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r125 = r2
            java.lang.String r2 = "radius"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r126 = r2
            java.lang.String r2 = "textValue"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r127 = r2
            java.lang.String r2 = "isEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            boolean r128 = r1.step()     // Catch:{ all -> 0x0c5a }
            r129 = 0
            if (r128 == 0) goto L_0x0c56
            boolean r128 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r128 == 0) goto L_0x0407
            r131 = r129
            goto L_0x040d
        L_0x0407:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0c5a }
            r131 = r0
        L_0x040d:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0416
            r132 = r129
            goto L_0x041c
        L_0x0416:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r132 = r0
        L_0x041c:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0425
            r133 = r129
            goto L_0x042b
        L_0x0425:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
            r133 = r0
        L_0x042b:
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r0 = (int) r3     // Catch:{ all -> 0x0c5a }
            boolean r3 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0439
            r135 = r129
            goto L_0x0444
        L_0x0439:
            long r3 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r135 = r3
        L_0x0444:
            boolean r3 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x044d
            r136 = r129
            goto L_0x0458
        L_0x044d:
            long r3 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r136 = r3
        L_0x0458:
            boolean r3 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0461
            r137 = r129
            goto L_0x0467
        L_0x0461:
            java.lang.String r3 = r1.getText(r8)     // Catch:{ all -> 0x0c5a }
            r137 = r3
        L_0x0467:
            boolean r3 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0470
            r138 = r129
            goto L_0x047b
        L_0x0470:
            long r3 = r1.getLong(r9)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r138 = r3
        L_0x047b:
            boolean r3 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0484
            r139 = r129
            goto L_0x048a
        L_0x0484:
            java.lang.String r3 = r1.getText(r10)     // Catch:{ all -> 0x0c5a }
            r139 = r3
        L_0x048a:
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0494
            r141 = 1
            goto L_0x0496
        L_0x0494:
            r141 = 0
        L_0x0496:
            boolean r3 = r1.isNull(r12)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x049f
            r143 = r129
            goto L_0x04aa
        L_0x049f:
            long r5 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r143 = r3
        L_0x04aa:
            long r5 = r1.getLong(r13)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04b4
            r144 = 1
            goto L_0x04b6
        L_0x04b4:
            r144 = 0
        L_0x04b6:
            long r5 = r1.getLong(r14)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04c0
            r145 = 1
            goto L_0x04c2
        L_0x04c0:
            r145 = 0
        L_0x04c2:
            long r5 = r1.getLong(r15)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04cc
            r146 = 1
            goto L_0x04ce
        L_0x04cc:
            r146 = 0
        L_0x04ce:
            r3 = r249
            boolean r5 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x04db
            r147 = r129
        L_0x04d8:
            r3 = r16
            goto L_0x04e2
        L_0x04db:
            java.lang.String r3 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r147 = r3
            goto L_0x04d8
        L_0x04e2:
            long r5 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            r5 = r17
            long r149 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r18
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x04fa
            r151 = r129
        L_0x04f7:
            r5 = r19
            goto L_0x0501
        L_0x04fa:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r151 = r5
            goto L_0x04f7
        L_0x0501:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x050c
            r152 = r129
        L_0x0509:
            r5 = r20
            goto L_0x0513
        L_0x050c:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r152 = r5
            goto L_0x0509
        L_0x0513:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x051e
            r153 = r129
        L_0x051b:
            r5 = r21
            goto L_0x0525
        L_0x051e:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r153 = r5
            goto L_0x051b
        L_0x0525:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0530
            r154 = r129
        L_0x052d:
            r5 = r22
            goto L_0x0537
        L_0x0530:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r154 = r5
            goto L_0x052d
        L_0x0537:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0542
            r155 = r129
        L_0x053f:
            r5 = r23
            goto L_0x0549
        L_0x0542:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r155 = r5
            goto L_0x053f
        L_0x0549:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0554
            r156 = r129
        L_0x0551:
            r5 = r24
            goto L_0x055b
        L_0x0554:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r156 = r5
            goto L_0x0551
        L_0x055b:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0566
            r157 = r129
        L_0x0563:
            r5 = r25
            goto L_0x056d
        L_0x0566:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r157 = r5
            goto L_0x0563
        L_0x056d:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0578
            r158 = r129
        L_0x0575:
            r5 = r26
            goto L_0x057f
        L_0x0578:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r158 = r5
            goto L_0x0575
        L_0x057f:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x058a
            r159 = r129
        L_0x0587:
            r5 = r27
            goto L_0x0591
        L_0x058a:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r159 = r5
            goto L_0x0587
        L_0x0591:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x059c
            r160 = r129
        L_0x0599:
            r5 = r28
            goto L_0x05a3
        L_0x059c:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r160 = r5
            goto L_0x0599
        L_0x05a3:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05ae
            r161 = r129
        L_0x05ab:
            r5 = r29
            goto L_0x05b5
        L_0x05ae:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r161 = r5
            goto L_0x05ab
        L_0x05b5:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05be
            r5 = r129
            goto L_0x05c2
        L_0x05be:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05c2:
            double[] r162 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r30
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05d1
            r5 = r129
            goto L_0x05d5
        L_0x05d1:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05d5:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r31
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05e4
            r5 = r129
            goto L_0x05e8
        L_0x05e4:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05e8:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r32
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05f7
            r5 = r129
            goto L_0x05fb
        L_0x05f7:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05fb:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r33
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x060a
            r5 = r129
            goto L_0x060e
        L_0x060a:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x060e:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r34
            long r5 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r5 = (int) r5     // Catch:{ all -> 0x0c5a }
            r6 = r35
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0625
            r168 = 1
            goto L_0x0627
        L_0x0625:
            r168 = 0
        L_0x0627:
            r6 = r36
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0633
            r169 = 1
            goto L_0x0635
        L_0x0633:
            r169 = 0
        L_0x0635:
            r6 = r37
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0641
            r170 = 1
            goto L_0x0643
        L_0x0641:
            r170 = 0
        L_0x0643:
            r6 = r38
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x064f
            r171 = 1
            goto L_0x0651
        L_0x064f:
            r171 = 0
        L_0x0651:
            r6 = r39
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x065d
            r172 = 1
            goto L_0x065f
        L_0x065d:
            r172 = 0
        L_0x065f:
            r6 = r40
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x066b
            r173 = 1
            goto L_0x066d
        L_0x066b:
            r173 = 0
        L_0x066d:
            r6 = r41
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0678
            r6 = r129
            goto L_0x0681
        L_0x0678:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
        L_0x0681:
            if (r6 != 0) goto L_0x0688
            r174 = r129
        L_0x0685:
            r6 = r42
            goto L_0x0698
        L_0x0688:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0690
            r6 = 1
            goto L_0x0691
        L_0x0690:
            r6 = 0
        L_0x0691:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r174 = r6
            goto L_0x0685
        L_0x0698:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x06a2
            r175 = 1
            goto L_0x06a4
        L_0x06a2:
            r175 = 0
        L_0x06a4:
            r6 = r43
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06b1
            r176 = r129
        L_0x06ae:
            r6 = r44
            goto L_0x06b8
        L_0x06b1:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r176 = r6
            goto L_0x06ae
        L_0x06b8:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x06c2
            r177 = 1
            goto L_0x06c4
        L_0x06c2:
            r177 = 0
        L_0x06c4:
            r6 = r45
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06d1
            r178 = r129
        L_0x06ce:
            r6 = r46
            goto L_0x06d8
        L_0x06d1:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r178 = r6
            goto L_0x06ce
        L_0x06d8:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06e3
            r179 = r129
        L_0x06e0:
            r6 = r47
            goto L_0x06ea
        L_0x06e3:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r179 = r6
            goto L_0x06e0
        L_0x06ea:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06f5
            r181 = r129
        L_0x06f2:
            r6 = r48
            goto L_0x06fc
        L_0x06f5:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r181 = r6
            goto L_0x06f2
        L_0x06fc:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0705
            r6 = r129
            goto L_0x070e
        L_0x0705:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
        L_0x070e:
            if (r6 != 0) goto L_0x0715
            r182 = r129
        L_0x0712:
            r6 = r49
            goto L_0x0725
        L_0x0715:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x071d
            r6 = 1
            goto L_0x071e
        L_0x071d:
            r6 = 0
        L_0x071e:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r182 = r6
            goto L_0x0712
        L_0x0725:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0730
            r183 = r129
        L_0x072d:
            r6 = r50
            goto L_0x073c
        L_0x0730:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r183 = r6
            goto L_0x072d
        L_0x073c:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0747
            r184 = r129
        L_0x0744:
            r6 = r51
            goto L_0x0752
        L_0x0747:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r184 = r6
            goto L_0x0744
        L_0x0752:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x075c
            r185 = 1
            goto L_0x075e
        L_0x075c:
            r185 = 0
        L_0x075e:
            r6 = r52
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x076a
            r186 = 1
            goto L_0x076c
        L_0x076a:
            r186 = 0
        L_0x076c:
            r6 = r53
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            r7 = r54
            long r188 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            r7 = r55
            long r7 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            int r7 = (int) r7     // Catch:{ all -> 0x0c5a }
            r8 = r56
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x0c5a }
            int r8 = (int) r8     // Catch:{ all -> 0x0c5a }
            if (r8 == 0) goto L_0x078c
            r191 = 1
            goto L_0x078e
        L_0x078c:
            r191 = 0
        L_0x078e:
            r8 = r57
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x0c5a }
            int r8 = (int) r8     // Catch:{ all -> 0x0c5a }
            r9 = r58
            long r9 = r1.getLong(r9)     // Catch:{ all -> 0x0c5a }
            int r9 = (int) r9     // Catch:{ all -> 0x0c5a }
            r10 = r59
            long r10 = r1.getLong(r10)     // Catch:{ all -> 0x0c5a }
            int r10 = (int) r10     // Catch:{ all -> 0x0c5a }
            r11 = r60
            long r11 = r1.getLong(r11)     // Catch:{ all -> 0x0c5a }
            int r11 = (int) r11     // Catch:{ all -> 0x0c5a }
            r12 = r61
            long r196 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            r12 = r62
            long r12 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            int r12 = (int) r12     // Catch:{ all -> 0x0c5a }
            r13 = r63
            long r13 = r1.getLong(r13)     // Catch:{ all -> 0x0c5a }
            int r13 = (int) r13     // Catch:{ all -> 0x0c5a }
            r14 = r64
            long r14 = r1.getLong(r14)     // Catch:{ all -> 0x0c5a }
            int r14 = (int) r14     // Catch:{ all -> 0x0c5a }
            r167 = r5
            r15 = r65
            long r4 = r1.getLong(r15)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r148 = r3
            r201 = r4
            r5 = r66
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r67
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r202 = r3
            r203 = r4
            r5 = r68
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r69
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r204 = r3
            r205 = r4
            r5 = r70
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r71
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r72
            double r208 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r73
            double r210 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            r206 = r3
            r207 = r4
            r5 = r74
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r75
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r212 = r3
            r213 = r4
            r5 = r76
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r77
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0838
            r4 = r129
            goto L_0x083c
        L_0x0838:
            java.lang.String r4 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
        L_0x083c:
            double[] r215 = com.blueair.database.DoubleArrayConverter.fromString(r4)     // Catch:{ all -> 0x0c5a }
            r4 = r78
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r79
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0852
            r5 = r129
            goto L_0x0856
        L_0x0852:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0856:
            double[] r217 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r214 = r3
            r216 = r4
            r5 = r80
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x086a
            r218 = 1
            goto L_0x086c
        L_0x086a:
            r218 = 0
        L_0x086c:
            r3 = r81
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r82
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r219 = r3
            r220 = r4
            r5 = r83
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r84
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0891
            r222 = 1
            goto L_0x0893
        L_0x0891:
            r222 = 0
        L_0x0893:
            r4 = r85
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r221 = r3
            r223 = r4
            r5 = r86
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08aa
            r224 = 1
            goto L_0x08ac
        L_0x08aa:
            r224 = 0
        L_0x08ac:
            r3 = r87
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08b8
            r225 = 1
            goto L_0x08ba
        L_0x08b8:
            r225 = 0
        L_0x08ba:
            r3 = r88
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r89
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r226 = r3
            r227 = r4
            r5 = r90
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08d8
            r228 = 1
            goto L_0x08da
        L_0x08d8:
            r228 = 0
        L_0x08da:
            r3 = r91
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08e6
            r229 = 1
            goto L_0x08e8
        L_0x08e6:
            r229 = 0
        L_0x08e8:
            r3 = r92
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r93
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r230 = r3
            r231 = r4
            r5 = r94
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r95
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r232 = r3
            r233 = r4
            r5 = r96
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r97
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r234 = r3
            r235 = r4
            r5 = r98
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r99
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r236 = r3
            r237 = r4
            r5 = r100
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x093c
            r238 = 1
            goto L_0x093e
        L_0x093c:
            r238 = 0
        L_0x093e:
            r3 = r101
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0949
            r3 = r129
            goto L_0x0952
        L_0x0949:
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
        L_0x0952:
            if (r3 != 0) goto L_0x0959
            r239 = r129
        L_0x0956:
            r3 = r102
            goto L_0x0969
        L_0x0959:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0961
            r3 = 1
            goto L_0x0962
        L_0x0961:
            r3 = 0
        L_0x0962:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r239 = r3
            goto L_0x0956
        L_0x0969:
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r103
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r104
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0980
            r5 = r129
            goto L_0x0984
        L_0x0980:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0984:
            java.util.List r242 = com.blueair.database.DeviceAlarmListConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r240 = r3
            r241 = r4
            r5 = r105
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r106
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x099f
            r244 = 1
            goto L_0x09a1
        L_0x099f:
            r244 = 0
        L_0x09a1:
            r4 = r107
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x09ad
            r245 = 1
            goto L_0x09af
        L_0x09ad:
            r245 = 0
        L_0x09af:
            r4 = r108
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r109
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x09fa
            r15 = r110
            boolean r16 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09f3
            r134 = r0
            r0 = r111
            boolean r16 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09ee
            r243 = r3
            r3 = r112
            boolean r16 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09eb
            r246 = r4
            r4 = r113
            boolean r16 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r16 != 0) goto L_0x09e5
            goto L_0x0a08
        L_0x09e5:
            r140 = r129
        L_0x09e7:
            r0 = r114
            goto L_0x0a5b
        L_0x09eb:
            r246 = r4
            goto L_0x0a06
        L_0x09ee:
            r243 = r3
            r246 = r4
            goto L_0x0a04
        L_0x09f3:
            r134 = r0
            r243 = r3
            r246 = r4
            goto L_0x0a02
        L_0x09fa:
            r134 = r0
            r243 = r3
            r246 = r4
            r15 = r110
        L_0x0a02:
            r0 = r111
        L_0x0a04:
            r3 = r112
        L_0x0a06:
            r4 = r113
        L_0x0a08:
            boolean r16 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0a11
            r17 = r129
            goto L_0x0a17
        L_0x0a11:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r17 = r5
        L_0x0a17:
            boolean r5 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0a20
            r18 = r129
            goto L_0x0a26
        L_0x0a20:
            java.lang.String r5 = r1.getText(r15)     // Catch:{ all -> 0x0c5a }
            r18 = r5
        L_0x0a26:
            boolean r5 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0a2f
            r19 = r129
            goto L_0x0a35
        L_0x0a2f:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0c5a }
            r19 = r0
        L_0x0a35:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0a3e
            r20 = r129
            goto L_0x0a44
        L_0x0a3e:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r20 = r0
        L_0x0a44:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0a4d
            r21 = r129
            goto L_0x0a53
        L_0x0a4d:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
            r21 = r0
        L_0x0a53:
            com.blueair.database.DeviceUuidEntity r16 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0c5a }
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0c5a }
            r140 = r16
            goto L_0x09e7
        L_0x0a5b:
            boolean r3 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0b05
            r3 = r115
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0afa
            r4 = r116
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0aef
            r5 = r117
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0ae4
            r15 = r118
            boolean r16 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ad9
            r187 = r6
            r6 = r119
            boolean r16 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ad0
            r190 = r7
            r7 = r120
            boolean r16 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ac9
            r192 = r8
            r8 = r121
            boolean r16 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ac3
            r193 = r9
            r9 = r122
            boolean r16 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0abf
            r194 = r10
            r10 = r123
            boolean r16 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r16 != 0) goto L_0x0ab5
            goto L_0x0b21
        L_0x0ab5:
            r195 = r11
            r198 = r12
            r142 = r129
        L_0x0abb:
            r0 = r124
            goto L_0x0bea
        L_0x0abf:
            r194 = r10
            goto L_0x0b1f
        L_0x0ac3:
            r193 = r9
            r194 = r10
            goto L_0x0b1d
        L_0x0ac9:
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b1b
        L_0x0ad0:
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b19
        L_0x0ad9:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b17
        L_0x0ae4:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b15
        L_0x0aef:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b13
        L_0x0afa:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b11
        L_0x0b05:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            r3 = r115
        L_0x0b11:
            r4 = r116
        L_0x0b13:
            r5 = r117
        L_0x0b15:
            r15 = r118
        L_0x0b17:
            r6 = r119
        L_0x0b19:
            r7 = r120
        L_0x0b1b:
            r8 = r121
        L_0x0b1d:
            r9 = r122
        L_0x0b1f:
            r10 = r123
        L_0x0b21:
            long r16 = r1.getLong(r0)     // Catch:{ all -> 0x0c5a }
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b32
            r195 = r11
            r198 = r12
            r18 = r129
            goto L_0x0b41
        L_0x0b32:
            r195 = r11
            r198 = r12
            double r11 = r1.getDouble(r3)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r11     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r18 = r0
        L_0x0b41:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b4a
            r19 = r129
            goto L_0x0b55
        L_0x0b4a:
            double r3 = r1.getDouble(r4)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r19 = r0
        L_0x0b55:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b5e
            r20 = r129
            goto L_0x0b69
        L_0x0b5e:
            double r3 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r20 = r0
        L_0x0b69:
            boolean r0 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b72
            r21 = r129
            goto L_0x0b7d
        L_0x0b72:
            double r3 = r1.getDouble(r15)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r21 = r0
        L_0x0b7d:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b86
            r22 = r129
            goto L_0x0b91
        L_0x0b86:
            double r3 = r1.getDouble(r6)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r22 = r0
        L_0x0b91:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b9a
            r23 = r129
            goto L_0x0ba5
        L_0x0b9a:
            double r3 = r1.getDouble(r7)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r23 = r0
        L_0x0ba5:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bae
            r24 = r129
            goto L_0x0bb9
        L_0x0bae:
            double r3 = r1.getDouble(r8)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r24 = r0
        L_0x0bb9:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bc2
            r25 = r129
            goto L_0x0bcd
        L_0x0bc2:
            double r3 = r1.getDouble(r9)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r25 = r0
        L_0x0bcd:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bd6
            r26 = r129
            goto L_0x0be1
        L_0x0bd6:
            double r3 = r1.getDouble(r10)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r26 = r0
        L_0x0be1:
            com.blueair.core.model.IndoorDatapoint r15 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0c5a }
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0c5a }
            r142 = r15
            goto L_0x0abb
        L_0x0bea:
            boolean r3 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0c12
            r3 = r125
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0c14
            r4 = r126
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0c16
            r5 = r127
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0c18
            boolean r6 = r1.isNull(r2)     // Catch:{ all -> 0x0c5a }
            if (r6 != 0) goto L_0x0c0f
            goto L_0x0c18
        L_0x0c0f:
            r180 = r129
            goto L_0x0c4b
        L_0x0c12:
            r3 = r125
        L_0x0c14:
            r4 = r126
        L_0x0c16:
            r5 = r127
        L_0x0c18:
            double r6 = r1.getDouble(r0)     // Catch:{ all -> 0x0c5a }
            double r8 = r1.getDouble(r3)     // Catch:{ all -> 0x0c5a }
            long r3 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r0 = (int) r3     // Catch:{ all -> 0x0c5a }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0c2c
            goto L_0x0c30
        L_0x0c2c:
            java.lang.String r129 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0c30:
            long r2 = r1.getLong(r2)     // Catch:{ all -> 0x0c5a }
            int r2 = (int) r2     // Catch:{ all -> 0x0c5a }
            if (r2 == 0) goto L_0x0c39
            r2 = 1
            goto L_0x0c3a
        L_0x0c39:
            r2 = 0
        L_0x0c3a:
            com.blueair.core.model.WelcomeHomeLocation r3 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0c5a }
            r247 = r8
            r9 = r2
            r2 = r3
            r3 = r6
            r5 = r247
            r7 = r0
            r8 = r129
            r2.<init>(r3, r5, r7, r8, r9)     // Catch:{ all -> 0x0c5a }
            r180 = r2
        L_0x0c4b:
            com.blueair.database.entity.DeviceEntity r130 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0c5a }
            r199 = r13
            r200 = r14
            r130.<init>(r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r190, r191, r192, r193, r194, r195, r196, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r210, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246)     // Catch:{ all -> 0x0c5a }
            r129 = r130
        L_0x0c56:
            r1.close()
            return r129
        L_0x0c5a:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$liveDevice$6(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceEntity");
    }

    public DeviceEntity device(String str) {
        return (DeviceEntity) DBUtil.performBlocking(this.__db, true, false, new DeviceDao_Impl$$ExternalSyntheticLambda38(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v0, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v1, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v2, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v3, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v5, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX WARNING: type inference failed for: r129v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0a0e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0a11 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0a1d A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0a20 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0a2c A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0a2f A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a3b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0a3e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a4a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0a4d A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0b2b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0b32 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0b47 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0b4a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0b5b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0b5e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0b6f A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0b72 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0b83 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0b86 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0b97 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0b9a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0bab A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x0bae A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0bbf A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0bc2 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0bd3 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0bd6 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0c2b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0c2c A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0c37 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0c39 A[Catch:{ all -> 0x0c5a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceEntity lambda$device$7(java.lang.String r249, androidx.sqlite.SQLiteConnection r250) {
        /*
            r0 = r249
            java.lang.String r1 = "SELECT * from device_table WHERE uid = ?"
            r2 = r250
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0c5a }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0c5a }
        L_0x0014:
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0c5a }
            java.lang.String r3 = "name"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0c5a }
            java.lang.String r4 = "modelName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0c5a }
            java.lang.String r5 = "typeIndex"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0c5a }
            java.lang.String r6 = "fanSpeed"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0c5a }
            java.lang.String r7 = "filterLife"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0c5a }
            java.lang.String r8 = "autoModeText"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0c5a }
            java.lang.String r9 = "brightness"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0c5a }
            java.lang.String r10 = "info"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0c5a }
            java.lang.String r11 = "hasFinishedOnboarding"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0c5a }
            java.lang.String r12 = "lastSelectedSensorType"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0c5a }
            java.lang.String r13 = "isAblDevice"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0c5a }
            java.lang.String r14 = "isNightModeOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0c5a }
            java.lang.String r15 = "isChildLockOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0c5a }
            java.lang.String r2 = "linkedDeviceUid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r249 = r2
            java.lang.String r2 = "connectivityStatusIndex"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r16 = r2
            java.lang.String r2 = "lastConnectivityMillis"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r17 = r2
            java.lang.String r2 = "mac"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r18 = r2
            java.lang.String r2 = "mcuFirmware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r19 = r2
            java.lang.String r2 = "wifiFirmware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r20 = r2
            java.lang.String r2 = "hardware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r21 = r2
            java.lang.String r2 = "timeZone"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r22 = r2
            java.lang.String r2 = "serial"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r23 = r2
            java.lang.String r2 = "purchaseDate"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r24 = r2
            java.lang.String r2 = "dealerName"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r25 = r2
            java.lang.String r2 = "dealerCountry"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r26 = r2
            java.lang.String r2 = "filterType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r27 = r2
            java.lang.String r2 = "filterTrigger"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r28 = r2
            java.lang.String r2 = "pm1Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r29 = r2
            java.lang.String r2 = "pm10Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r30 = r2
            java.lang.String r2 = "pm25Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r31 = r2
            java.lang.String r2 = "vocRanges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r32 = r2
            java.lang.String r2 = "hchoRanges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r33 = r2
            java.lang.String r2 = "updateProgress"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r34 = r2
            java.lang.String r2 = "isStandByOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r35 = r2
            java.lang.String r2 = "isEcoModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r36 = r2
            java.lang.String r2 = "isHinsModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r37 = r2
            java.lang.String r2 = "isHinsNightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r38 = r2
            java.lang.String r2 = "isG4NightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r39 = r2
            java.lang.String r2 = "isGermShieldOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r40 = r2
            java.lang.String r2 = "isGermShieldNightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r41 = r2
            java.lang.String r2 = "isSafetySwitchOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r42 = r2
            java.lang.String r2 = "g4NightModefilterTrigger"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r43 = r2
            java.lang.String r2 = "aimInstalled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r44 = r2
            java.lang.String r2 = "sku"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r45 = r2
            java.lang.String r2 = "compatibility"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r46 = r2
            java.lang.String r2 = "locationId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r47 = r2
            java.lang.String r2 = "disinfection"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r48 = r2
            java.lang.String r2 = "disinfectLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r49 = r2
            java.lang.String r2 = "disinfectLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r50 = r2
            java.lang.String r2 = "wickdryEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r51 = r2
            java.lang.String r2 = "wickdryOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r52 = r2
            java.lang.String r2 = "wickdryLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r53 = r2
            java.lang.String r2 = "wickdryLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r54 = r2
            java.lang.String r2 = "wickUsage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r55 = r2
            java.lang.String r2 = "waterShortage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r56 = r2
            java.lang.String r2 = "autoRh"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r57 = r2
            java.lang.String r2 = "timerStatus"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r58 = r2
            java.lang.String r2 = "timerDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r59 = r2
            java.lang.String r2 = "timerLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r60 = r2
            java.lang.String r2 = "timerLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r61 = r2
            java.lang.String r2 = "temperatureUnit"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r62 = r2
            java.lang.String r2 = "oscillationState"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r63 = r2
            java.lang.String r2 = "oscillationAngle"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r64 = r2
            java.lang.String r2 = "oscillationDirection"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r65 = r2
            java.lang.String r2 = "oscillationFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r66 = r2
            java.lang.String r2 = "mainMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r67 = r2
            java.lang.String r2 = "apSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r68 = r2
            java.lang.String r2 = "apFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r69 = r2
            java.lang.String r2 = "heatSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r70 = r2
            java.lang.String r2 = "heatFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r71 = r2
            java.lang.String r2 = "heatAutoTmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r72 = r2
            java.lang.String r2 = "heatEcoTmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r73 = r2
            java.lang.String r2 = "coolSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r74 = r2
            java.lang.String r2 = "coolFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r75 = r2
            java.lang.String r2 = "coolAutoTag"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r76 = r2
            java.lang.String r2 = "coolAutoPresets"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r77 = r2
            java.lang.String r2 = "coolEcoTag"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r78 = r2
            java.lang.String r2 = "coolEcoPresets"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r79 = r2
            java.lang.String r2 = "humMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r80 = r2
            java.lang.String r2 = "mode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r81 = r2
            java.lang.String r2 = "waterLevel"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r82 = r2
            java.lang.String r2 = "dehSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r83 = r2
            java.lang.String r2 = "waterTankFailure"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r84 = r2
            java.lang.String r2 = "smartSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r85 = r2
            java.lang.String r2 = "detectCat"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r86 = r2
            java.lang.String r2 = "bodyMounted"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r87 = r2
            java.lang.String r2 = "cleanAirEta"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r88 = r2
            java.lang.String r2 = "panelDisplayMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r89 = r2
            java.lang.String r2 = "hoverEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r90 = r2
            java.lang.String r2 = "airRefreshEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r91 = r2
            java.lang.String r2 = "airRefreshStatus"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r92 = r2
            java.lang.String r2 = "airRefreshDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r93 = r2
            java.lang.String r2 = "airRefreshTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r94 = r2
            java.lang.String r2 = "airRefreshStartTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r95 = r2
            java.lang.String r2 = "airRefreshEndTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r96 = r2
            java.lang.String r2 = "roomType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r97 = r2
            java.lang.String r2 = "nightLampBrightness"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r98 = r2
            java.lang.String r2 = "wickdryDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r99 = r2
            java.lang.String r2 = "wickdryDone"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r100 = r2
            java.lang.String r2 = "ywrmEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r101 = r2
            java.lang.String r2 = "ywrmUsage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r102 = r2
            java.lang.String r2 = "nightLampSteplessBrightness"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r103 = r2
            java.lang.String r2 = "alarms"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r104 = r2
            java.lang.String r2 = "humSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r105 = r2
            java.lang.String r2 = "use24Hour"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r106 = r2
            java.lang.String r2 = "waterInfill"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r107 = r2
            java.lang.String r2 = "sensorMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r108 = r2
            java.lang.String r2 = "uuid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r109 = r2
            java.lang.String r2 = "ssid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r110 = r2
            java.lang.String r2 = "bssid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r111 = r2
            java.lang.String r2 = "ipv4"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r112 = r2
            java.lang.String r2 = "ipv6"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r113 = r2
            java.lang.String r2 = "timeInSeconds"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r114 = r2
            java.lang.String r2 = "pm1"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r115 = r2
            java.lang.String r2 = "pm10"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r116 = r2
            java.lang.String r2 = "pm25"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r117 = r2
            java.lang.String r2 = "voc"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r118 = r2
            java.lang.String r2 = "hcho"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r119 = r2
            java.lang.String r2 = "tmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r120 = r2
            java.lang.String r2 = "hum"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r121 = r2
            java.lang.String r2 = "fan"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r122 = r2
            java.lang.String r2 = "weight"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r123 = r2
            java.lang.String r2 = "lat"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r124 = r2
            java.lang.String r2 = "lng"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r125 = r2
            java.lang.String r2 = "radius"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r126 = r2
            java.lang.String r2 = "textValue"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r127 = r2
            java.lang.String r2 = "isEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            boolean r128 = r1.step()     // Catch:{ all -> 0x0c5a }
            r129 = 0
            if (r128 == 0) goto L_0x0c56
            boolean r128 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r128 == 0) goto L_0x0407
            r131 = r129
            goto L_0x040d
        L_0x0407:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0c5a }
            r131 = r0
        L_0x040d:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0416
            r132 = r129
            goto L_0x041c
        L_0x0416:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r132 = r0
        L_0x041c:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0425
            r133 = r129
            goto L_0x042b
        L_0x0425:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
            r133 = r0
        L_0x042b:
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r0 = (int) r3     // Catch:{ all -> 0x0c5a }
            boolean r3 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0439
            r135 = r129
            goto L_0x0444
        L_0x0439:
            long r3 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r135 = r3
        L_0x0444:
            boolean r3 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x044d
            r136 = r129
            goto L_0x0458
        L_0x044d:
            long r3 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r136 = r3
        L_0x0458:
            boolean r3 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0461
            r137 = r129
            goto L_0x0467
        L_0x0461:
            java.lang.String r3 = r1.getText(r8)     // Catch:{ all -> 0x0c5a }
            r137 = r3
        L_0x0467:
            boolean r3 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0470
            r138 = r129
            goto L_0x047b
        L_0x0470:
            long r3 = r1.getLong(r9)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r138 = r3
        L_0x047b:
            boolean r3 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0484
            r139 = r129
            goto L_0x048a
        L_0x0484:
            java.lang.String r3 = r1.getText(r10)     // Catch:{ all -> 0x0c5a }
            r139 = r3
        L_0x048a:
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0494
            r141 = 1
            goto L_0x0496
        L_0x0494:
            r141 = 0
        L_0x0496:
            boolean r3 = r1.isNull(r12)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x049f
            r143 = r129
            goto L_0x04aa
        L_0x049f:
            long r5 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r143 = r3
        L_0x04aa:
            long r5 = r1.getLong(r13)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04b4
            r144 = 1
            goto L_0x04b6
        L_0x04b4:
            r144 = 0
        L_0x04b6:
            long r5 = r1.getLong(r14)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04c0
            r145 = 1
            goto L_0x04c2
        L_0x04c0:
            r145 = 0
        L_0x04c2:
            long r5 = r1.getLong(r15)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04cc
            r146 = 1
            goto L_0x04ce
        L_0x04cc:
            r146 = 0
        L_0x04ce:
            r3 = r249
            boolean r5 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x04db
            r147 = r129
        L_0x04d8:
            r3 = r16
            goto L_0x04e2
        L_0x04db:
            java.lang.String r3 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r147 = r3
            goto L_0x04d8
        L_0x04e2:
            long r5 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            r5 = r17
            long r149 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r18
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x04fa
            r151 = r129
        L_0x04f7:
            r5 = r19
            goto L_0x0501
        L_0x04fa:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r151 = r5
            goto L_0x04f7
        L_0x0501:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x050c
            r152 = r129
        L_0x0509:
            r5 = r20
            goto L_0x0513
        L_0x050c:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r152 = r5
            goto L_0x0509
        L_0x0513:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x051e
            r153 = r129
        L_0x051b:
            r5 = r21
            goto L_0x0525
        L_0x051e:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r153 = r5
            goto L_0x051b
        L_0x0525:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0530
            r154 = r129
        L_0x052d:
            r5 = r22
            goto L_0x0537
        L_0x0530:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r154 = r5
            goto L_0x052d
        L_0x0537:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0542
            r155 = r129
        L_0x053f:
            r5 = r23
            goto L_0x0549
        L_0x0542:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r155 = r5
            goto L_0x053f
        L_0x0549:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0554
            r156 = r129
        L_0x0551:
            r5 = r24
            goto L_0x055b
        L_0x0554:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r156 = r5
            goto L_0x0551
        L_0x055b:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0566
            r157 = r129
        L_0x0563:
            r5 = r25
            goto L_0x056d
        L_0x0566:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r157 = r5
            goto L_0x0563
        L_0x056d:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0578
            r158 = r129
        L_0x0575:
            r5 = r26
            goto L_0x057f
        L_0x0578:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r158 = r5
            goto L_0x0575
        L_0x057f:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x058a
            r159 = r129
        L_0x0587:
            r5 = r27
            goto L_0x0591
        L_0x058a:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r159 = r5
            goto L_0x0587
        L_0x0591:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x059c
            r160 = r129
        L_0x0599:
            r5 = r28
            goto L_0x05a3
        L_0x059c:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r160 = r5
            goto L_0x0599
        L_0x05a3:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05ae
            r161 = r129
        L_0x05ab:
            r5 = r29
            goto L_0x05b5
        L_0x05ae:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r161 = r5
            goto L_0x05ab
        L_0x05b5:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05be
            r5 = r129
            goto L_0x05c2
        L_0x05be:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05c2:
            double[] r162 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r30
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05d1
            r5 = r129
            goto L_0x05d5
        L_0x05d1:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05d5:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r31
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05e4
            r5 = r129
            goto L_0x05e8
        L_0x05e4:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05e8:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r32
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05f7
            r5 = r129
            goto L_0x05fb
        L_0x05f7:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05fb:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r33
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x060a
            r5 = r129
            goto L_0x060e
        L_0x060a:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x060e:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r34
            long r5 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r5 = (int) r5     // Catch:{ all -> 0x0c5a }
            r6 = r35
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0625
            r168 = 1
            goto L_0x0627
        L_0x0625:
            r168 = 0
        L_0x0627:
            r6 = r36
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0633
            r169 = 1
            goto L_0x0635
        L_0x0633:
            r169 = 0
        L_0x0635:
            r6 = r37
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0641
            r170 = 1
            goto L_0x0643
        L_0x0641:
            r170 = 0
        L_0x0643:
            r6 = r38
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x064f
            r171 = 1
            goto L_0x0651
        L_0x064f:
            r171 = 0
        L_0x0651:
            r6 = r39
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x065d
            r172 = 1
            goto L_0x065f
        L_0x065d:
            r172 = 0
        L_0x065f:
            r6 = r40
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x066b
            r173 = 1
            goto L_0x066d
        L_0x066b:
            r173 = 0
        L_0x066d:
            r6 = r41
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0678
            r6 = r129
            goto L_0x0681
        L_0x0678:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
        L_0x0681:
            if (r6 != 0) goto L_0x0688
            r174 = r129
        L_0x0685:
            r6 = r42
            goto L_0x0698
        L_0x0688:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0690
            r6 = 1
            goto L_0x0691
        L_0x0690:
            r6 = 0
        L_0x0691:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r174 = r6
            goto L_0x0685
        L_0x0698:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x06a2
            r175 = 1
            goto L_0x06a4
        L_0x06a2:
            r175 = 0
        L_0x06a4:
            r6 = r43
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06b1
            r176 = r129
        L_0x06ae:
            r6 = r44
            goto L_0x06b8
        L_0x06b1:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r176 = r6
            goto L_0x06ae
        L_0x06b8:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x06c2
            r177 = 1
            goto L_0x06c4
        L_0x06c2:
            r177 = 0
        L_0x06c4:
            r6 = r45
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06d1
            r178 = r129
        L_0x06ce:
            r6 = r46
            goto L_0x06d8
        L_0x06d1:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r178 = r6
            goto L_0x06ce
        L_0x06d8:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06e3
            r179 = r129
        L_0x06e0:
            r6 = r47
            goto L_0x06ea
        L_0x06e3:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r179 = r6
            goto L_0x06e0
        L_0x06ea:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06f5
            r181 = r129
        L_0x06f2:
            r6 = r48
            goto L_0x06fc
        L_0x06f5:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r181 = r6
            goto L_0x06f2
        L_0x06fc:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0705
            r6 = r129
            goto L_0x070e
        L_0x0705:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
        L_0x070e:
            if (r6 != 0) goto L_0x0715
            r182 = r129
        L_0x0712:
            r6 = r49
            goto L_0x0725
        L_0x0715:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x071d
            r6 = 1
            goto L_0x071e
        L_0x071d:
            r6 = 0
        L_0x071e:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r182 = r6
            goto L_0x0712
        L_0x0725:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0730
            r183 = r129
        L_0x072d:
            r6 = r50
            goto L_0x073c
        L_0x0730:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r183 = r6
            goto L_0x072d
        L_0x073c:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0747
            r184 = r129
        L_0x0744:
            r6 = r51
            goto L_0x0752
        L_0x0747:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r184 = r6
            goto L_0x0744
        L_0x0752:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x075c
            r185 = 1
            goto L_0x075e
        L_0x075c:
            r185 = 0
        L_0x075e:
            r6 = r52
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x076a
            r186 = 1
            goto L_0x076c
        L_0x076a:
            r186 = 0
        L_0x076c:
            r6 = r53
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            r7 = r54
            long r188 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            r7 = r55
            long r7 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            int r7 = (int) r7     // Catch:{ all -> 0x0c5a }
            r8 = r56
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x0c5a }
            int r8 = (int) r8     // Catch:{ all -> 0x0c5a }
            if (r8 == 0) goto L_0x078c
            r191 = 1
            goto L_0x078e
        L_0x078c:
            r191 = 0
        L_0x078e:
            r8 = r57
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x0c5a }
            int r8 = (int) r8     // Catch:{ all -> 0x0c5a }
            r9 = r58
            long r9 = r1.getLong(r9)     // Catch:{ all -> 0x0c5a }
            int r9 = (int) r9     // Catch:{ all -> 0x0c5a }
            r10 = r59
            long r10 = r1.getLong(r10)     // Catch:{ all -> 0x0c5a }
            int r10 = (int) r10     // Catch:{ all -> 0x0c5a }
            r11 = r60
            long r11 = r1.getLong(r11)     // Catch:{ all -> 0x0c5a }
            int r11 = (int) r11     // Catch:{ all -> 0x0c5a }
            r12 = r61
            long r196 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            r12 = r62
            long r12 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            int r12 = (int) r12     // Catch:{ all -> 0x0c5a }
            r13 = r63
            long r13 = r1.getLong(r13)     // Catch:{ all -> 0x0c5a }
            int r13 = (int) r13     // Catch:{ all -> 0x0c5a }
            r14 = r64
            long r14 = r1.getLong(r14)     // Catch:{ all -> 0x0c5a }
            int r14 = (int) r14     // Catch:{ all -> 0x0c5a }
            r167 = r5
            r15 = r65
            long r4 = r1.getLong(r15)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r148 = r3
            r201 = r4
            r5 = r66
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r67
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r202 = r3
            r203 = r4
            r5 = r68
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r69
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r204 = r3
            r205 = r4
            r5 = r70
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r71
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r72
            double r208 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r73
            double r210 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            r206 = r3
            r207 = r4
            r5 = r74
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r75
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r212 = r3
            r213 = r4
            r5 = r76
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r77
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0838
            r4 = r129
            goto L_0x083c
        L_0x0838:
            java.lang.String r4 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
        L_0x083c:
            double[] r215 = com.blueair.database.DoubleArrayConverter.fromString(r4)     // Catch:{ all -> 0x0c5a }
            r4 = r78
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r79
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0852
            r5 = r129
            goto L_0x0856
        L_0x0852:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0856:
            double[] r217 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r214 = r3
            r216 = r4
            r5 = r80
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x086a
            r218 = 1
            goto L_0x086c
        L_0x086a:
            r218 = 0
        L_0x086c:
            r3 = r81
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r82
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r219 = r3
            r220 = r4
            r5 = r83
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r84
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0891
            r222 = 1
            goto L_0x0893
        L_0x0891:
            r222 = 0
        L_0x0893:
            r4 = r85
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r221 = r3
            r223 = r4
            r5 = r86
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08aa
            r224 = 1
            goto L_0x08ac
        L_0x08aa:
            r224 = 0
        L_0x08ac:
            r3 = r87
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08b8
            r225 = 1
            goto L_0x08ba
        L_0x08b8:
            r225 = 0
        L_0x08ba:
            r3 = r88
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r89
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r226 = r3
            r227 = r4
            r5 = r90
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08d8
            r228 = 1
            goto L_0x08da
        L_0x08d8:
            r228 = 0
        L_0x08da:
            r3 = r91
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08e6
            r229 = 1
            goto L_0x08e8
        L_0x08e6:
            r229 = 0
        L_0x08e8:
            r3 = r92
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r93
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r230 = r3
            r231 = r4
            r5 = r94
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r95
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r232 = r3
            r233 = r4
            r5 = r96
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r97
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r234 = r3
            r235 = r4
            r5 = r98
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r99
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r236 = r3
            r237 = r4
            r5 = r100
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x093c
            r238 = 1
            goto L_0x093e
        L_0x093c:
            r238 = 0
        L_0x093e:
            r3 = r101
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0949
            r3 = r129
            goto L_0x0952
        L_0x0949:
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
        L_0x0952:
            if (r3 != 0) goto L_0x0959
            r239 = r129
        L_0x0956:
            r3 = r102
            goto L_0x0969
        L_0x0959:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0961
            r3 = 1
            goto L_0x0962
        L_0x0961:
            r3 = 0
        L_0x0962:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r239 = r3
            goto L_0x0956
        L_0x0969:
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r103
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r104
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0980
            r5 = r129
            goto L_0x0984
        L_0x0980:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0984:
            java.util.List r242 = com.blueair.database.DeviceAlarmListConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r240 = r3
            r241 = r4
            r5 = r105
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r106
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x099f
            r244 = 1
            goto L_0x09a1
        L_0x099f:
            r244 = 0
        L_0x09a1:
            r4 = r107
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x09ad
            r245 = 1
            goto L_0x09af
        L_0x09ad:
            r245 = 0
        L_0x09af:
            r4 = r108
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r109
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x09fa
            r15 = r110
            boolean r16 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09f3
            r134 = r0
            r0 = r111
            boolean r16 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09ee
            r243 = r3
            r3 = r112
            boolean r16 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09eb
            r246 = r4
            r4 = r113
            boolean r16 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r16 != 0) goto L_0x09e5
            goto L_0x0a08
        L_0x09e5:
            r140 = r129
        L_0x09e7:
            r0 = r114
            goto L_0x0a5b
        L_0x09eb:
            r246 = r4
            goto L_0x0a06
        L_0x09ee:
            r243 = r3
            r246 = r4
            goto L_0x0a04
        L_0x09f3:
            r134 = r0
            r243 = r3
            r246 = r4
            goto L_0x0a02
        L_0x09fa:
            r134 = r0
            r243 = r3
            r246 = r4
            r15 = r110
        L_0x0a02:
            r0 = r111
        L_0x0a04:
            r3 = r112
        L_0x0a06:
            r4 = r113
        L_0x0a08:
            boolean r16 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0a11
            r17 = r129
            goto L_0x0a17
        L_0x0a11:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r17 = r5
        L_0x0a17:
            boolean r5 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0a20
            r18 = r129
            goto L_0x0a26
        L_0x0a20:
            java.lang.String r5 = r1.getText(r15)     // Catch:{ all -> 0x0c5a }
            r18 = r5
        L_0x0a26:
            boolean r5 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0a2f
            r19 = r129
            goto L_0x0a35
        L_0x0a2f:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0c5a }
            r19 = r0
        L_0x0a35:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0a3e
            r20 = r129
            goto L_0x0a44
        L_0x0a3e:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r20 = r0
        L_0x0a44:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0a4d
            r21 = r129
            goto L_0x0a53
        L_0x0a4d:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
            r21 = r0
        L_0x0a53:
            com.blueair.database.DeviceUuidEntity r16 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0c5a }
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0c5a }
            r140 = r16
            goto L_0x09e7
        L_0x0a5b:
            boolean r3 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0b05
            r3 = r115
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0afa
            r4 = r116
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0aef
            r5 = r117
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0ae4
            r15 = r118
            boolean r16 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ad9
            r187 = r6
            r6 = r119
            boolean r16 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ad0
            r190 = r7
            r7 = r120
            boolean r16 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ac9
            r192 = r8
            r8 = r121
            boolean r16 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ac3
            r193 = r9
            r9 = r122
            boolean r16 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0abf
            r194 = r10
            r10 = r123
            boolean r16 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r16 != 0) goto L_0x0ab5
            goto L_0x0b21
        L_0x0ab5:
            r195 = r11
            r198 = r12
            r142 = r129
        L_0x0abb:
            r0 = r124
            goto L_0x0bea
        L_0x0abf:
            r194 = r10
            goto L_0x0b1f
        L_0x0ac3:
            r193 = r9
            r194 = r10
            goto L_0x0b1d
        L_0x0ac9:
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b1b
        L_0x0ad0:
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b19
        L_0x0ad9:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b17
        L_0x0ae4:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b15
        L_0x0aef:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b13
        L_0x0afa:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b11
        L_0x0b05:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            r3 = r115
        L_0x0b11:
            r4 = r116
        L_0x0b13:
            r5 = r117
        L_0x0b15:
            r15 = r118
        L_0x0b17:
            r6 = r119
        L_0x0b19:
            r7 = r120
        L_0x0b1b:
            r8 = r121
        L_0x0b1d:
            r9 = r122
        L_0x0b1f:
            r10 = r123
        L_0x0b21:
            long r16 = r1.getLong(r0)     // Catch:{ all -> 0x0c5a }
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b32
            r195 = r11
            r198 = r12
            r18 = r129
            goto L_0x0b41
        L_0x0b32:
            r195 = r11
            r198 = r12
            double r11 = r1.getDouble(r3)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r11     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r18 = r0
        L_0x0b41:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b4a
            r19 = r129
            goto L_0x0b55
        L_0x0b4a:
            double r3 = r1.getDouble(r4)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r19 = r0
        L_0x0b55:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b5e
            r20 = r129
            goto L_0x0b69
        L_0x0b5e:
            double r3 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r20 = r0
        L_0x0b69:
            boolean r0 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b72
            r21 = r129
            goto L_0x0b7d
        L_0x0b72:
            double r3 = r1.getDouble(r15)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r21 = r0
        L_0x0b7d:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b86
            r22 = r129
            goto L_0x0b91
        L_0x0b86:
            double r3 = r1.getDouble(r6)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r22 = r0
        L_0x0b91:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b9a
            r23 = r129
            goto L_0x0ba5
        L_0x0b9a:
            double r3 = r1.getDouble(r7)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r23 = r0
        L_0x0ba5:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bae
            r24 = r129
            goto L_0x0bb9
        L_0x0bae:
            double r3 = r1.getDouble(r8)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r24 = r0
        L_0x0bb9:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bc2
            r25 = r129
            goto L_0x0bcd
        L_0x0bc2:
            double r3 = r1.getDouble(r9)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r25 = r0
        L_0x0bcd:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bd6
            r26 = r129
            goto L_0x0be1
        L_0x0bd6:
            double r3 = r1.getDouble(r10)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r26 = r0
        L_0x0be1:
            com.blueair.core.model.IndoorDatapoint r15 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0c5a }
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0c5a }
            r142 = r15
            goto L_0x0abb
        L_0x0bea:
            boolean r3 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0c12
            r3 = r125
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0c14
            r4 = r126
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0c16
            r5 = r127
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0c18
            boolean r6 = r1.isNull(r2)     // Catch:{ all -> 0x0c5a }
            if (r6 != 0) goto L_0x0c0f
            goto L_0x0c18
        L_0x0c0f:
            r180 = r129
            goto L_0x0c4b
        L_0x0c12:
            r3 = r125
        L_0x0c14:
            r4 = r126
        L_0x0c16:
            r5 = r127
        L_0x0c18:
            double r6 = r1.getDouble(r0)     // Catch:{ all -> 0x0c5a }
            double r8 = r1.getDouble(r3)     // Catch:{ all -> 0x0c5a }
            long r3 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r0 = (int) r3     // Catch:{ all -> 0x0c5a }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0c2c
            goto L_0x0c30
        L_0x0c2c:
            java.lang.String r129 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0c30:
            long r2 = r1.getLong(r2)     // Catch:{ all -> 0x0c5a }
            int r2 = (int) r2     // Catch:{ all -> 0x0c5a }
            if (r2 == 0) goto L_0x0c39
            r2 = 1
            goto L_0x0c3a
        L_0x0c39:
            r2 = 0
        L_0x0c3a:
            com.blueair.core.model.WelcomeHomeLocation r3 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0c5a }
            r247 = r8
            r9 = r2
            r2 = r3
            r3 = r6
            r5 = r247
            r7 = r0
            r8 = r129
            r2.<init>(r3, r5, r7, r8, r9)     // Catch:{ all -> 0x0c5a }
            r180 = r2
        L_0x0c4b:
            com.blueair.database.entity.DeviceEntity r130 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0c5a }
            r199 = r13
            r200 = r14
            r130.<init>(r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r190, r191, r192, r193, r194, r195, r196, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r210, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246)     // Catch:{ all -> 0x0c5a }
            r129 = r130
        L_0x0c56:
            r1.close()
            return r129
        L_0x0c5a:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$device$7(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceEntity");
    }

    public Flow<DeviceEntity> getFlowDevice(String str) {
        return FlowUtil.createFlow(this.__db, false, new String[]{DeviceEntity.DEVICE_TABLE}, new DeviceDao_Impl$$ExternalSyntheticLambda42(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v0, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v1, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v2, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v3, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r129v5, resolved type: com.blueair.database.entity.DeviceEntity} */
    /* JADX WARNING: type inference failed for: r129v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0a0e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0a11 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0a1d A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0a20 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0a2c A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0a2f A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a3b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0a3e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a4a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0a4d A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0b2b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x0b32 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0b47 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x0b4a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0b5b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0b5e A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0b6f A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0b72 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0b83 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0b86 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0b97 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0b9a A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0bab A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x0bae A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0bbf A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0bc2 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0bd3 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0bd6 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x0c2b A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0c2c A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0c37 A[Catch:{ all -> 0x0c5a }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x0c39 A[Catch:{ all -> 0x0c5a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceEntity lambda$getFlowDevice$8(java.lang.String r249, androidx.sqlite.SQLiteConnection r250) {
        /*
            r0 = r249
            java.lang.String r1 = "SELECT * from device_table WHERE uid = ?"
            r2 = r250
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0c5a }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0c5a }
        L_0x0014:
            java.lang.String r0 = "uid"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0c5a }
            java.lang.String r3 = "name"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0c5a }
            java.lang.String r4 = "modelName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0c5a }
            java.lang.String r5 = "typeIndex"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0c5a }
            java.lang.String r6 = "fanSpeed"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0c5a }
            java.lang.String r7 = "filterLife"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0c5a }
            java.lang.String r8 = "autoModeText"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0c5a }
            java.lang.String r9 = "brightness"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0c5a }
            java.lang.String r10 = "info"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0c5a }
            java.lang.String r11 = "hasFinishedOnboarding"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0c5a }
            java.lang.String r12 = "lastSelectedSensorType"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0c5a }
            java.lang.String r13 = "isAblDevice"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0c5a }
            java.lang.String r14 = "isNightModeOn"
            int r14 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r14)     // Catch:{ all -> 0x0c5a }
            java.lang.String r15 = "isChildLockOn"
            int r15 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r15)     // Catch:{ all -> 0x0c5a }
            java.lang.String r2 = "linkedDeviceUid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r249 = r2
            java.lang.String r2 = "connectivityStatusIndex"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r16 = r2
            java.lang.String r2 = "lastConnectivityMillis"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r17 = r2
            java.lang.String r2 = "mac"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r18 = r2
            java.lang.String r2 = "mcuFirmware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r19 = r2
            java.lang.String r2 = "wifiFirmware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r20 = r2
            java.lang.String r2 = "hardware"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r21 = r2
            java.lang.String r2 = "timeZone"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r22 = r2
            java.lang.String r2 = "serial"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r23 = r2
            java.lang.String r2 = "purchaseDate"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r24 = r2
            java.lang.String r2 = "dealerName"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r25 = r2
            java.lang.String r2 = "dealerCountry"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r26 = r2
            java.lang.String r2 = "filterType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r27 = r2
            java.lang.String r2 = "filterTrigger"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r28 = r2
            java.lang.String r2 = "pm1Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r29 = r2
            java.lang.String r2 = "pm10Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r30 = r2
            java.lang.String r2 = "pm25Ranges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r31 = r2
            java.lang.String r2 = "vocRanges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r32 = r2
            java.lang.String r2 = "hchoRanges"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r33 = r2
            java.lang.String r2 = "updateProgress"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r34 = r2
            java.lang.String r2 = "isStandByOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r35 = r2
            java.lang.String r2 = "isEcoModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r36 = r2
            java.lang.String r2 = "isHinsModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r37 = r2
            java.lang.String r2 = "isHinsNightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r38 = r2
            java.lang.String r2 = "isG4NightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r39 = r2
            java.lang.String r2 = "isGermShieldOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r40 = r2
            java.lang.String r2 = "isGermShieldNightModeOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r41 = r2
            java.lang.String r2 = "isSafetySwitchOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r42 = r2
            java.lang.String r2 = "g4NightModefilterTrigger"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r43 = r2
            java.lang.String r2 = "aimInstalled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r44 = r2
            java.lang.String r2 = "sku"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r45 = r2
            java.lang.String r2 = "compatibility"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r46 = r2
            java.lang.String r2 = "locationId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r47 = r2
            java.lang.String r2 = "disinfection"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r48 = r2
            java.lang.String r2 = "disinfectLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r49 = r2
            java.lang.String r2 = "disinfectLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r50 = r2
            java.lang.String r2 = "wickdryEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r51 = r2
            java.lang.String r2 = "wickdryOn"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r52 = r2
            java.lang.String r2 = "wickdryLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r53 = r2
            java.lang.String r2 = "wickdryLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r54 = r2
            java.lang.String r2 = "wickUsage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r55 = r2
            java.lang.String r2 = "waterShortage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r56 = r2
            java.lang.String r2 = "autoRh"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r57 = r2
            java.lang.String r2 = "timerStatus"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r58 = r2
            java.lang.String r2 = "timerDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r59 = r2
            java.lang.String r2 = "timerLeftTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r60 = r2
            java.lang.String r2 = "timerLeftTimeUpdateTime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r61 = r2
            java.lang.String r2 = "temperatureUnit"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r62 = r2
            java.lang.String r2 = "oscillationState"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r63 = r2
            java.lang.String r2 = "oscillationAngle"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r64 = r2
            java.lang.String r2 = "oscillationDirection"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r65 = r2
            java.lang.String r2 = "oscillationFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r66 = r2
            java.lang.String r2 = "mainMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r67 = r2
            java.lang.String r2 = "apSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r68 = r2
            java.lang.String r2 = "apFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r69 = r2
            java.lang.String r2 = "heatSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r70 = r2
            java.lang.String r2 = "heatFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r71 = r2
            java.lang.String r2 = "heatAutoTmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r72 = r2
            java.lang.String r2 = "heatEcoTmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r73 = r2
            java.lang.String r2 = "coolSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r74 = r2
            java.lang.String r2 = "coolFanSpeed"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r75 = r2
            java.lang.String r2 = "coolAutoTag"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r76 = r2
            java.lang.String r2 = "coolAutoPresets"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r77 = r2
            java.lang.String r2 = "coolEcoTag"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r78 = r2
            java.lang.String r2 = "coolEcoPresets"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r79 = r2
            java.lang.String r2 = "humMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r80 = r2
            java.lang.String r2 = "mode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r81 = r2
            java.lang.String r2 = "waterLevel"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r82 = r2
            java.lang.String r2 = "dehSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r83 = r2
            java.lang.String r2 = "waterTankFailure"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r84 = r2
            java.lang.String r2 = "smartSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r85 = r2
            java.lang.String r2 = "detectCat"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r86 = r2
            java.lang.String r2 = "bodyMounted"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r87 = r2
            java.lang.String r2 = "cleanAirEta"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r88 = r2
            java.lang.String r2 = "panelDisplayMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r89 = r2
            java.lang.String r2 = "hoverEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r90 = r2
            java.lang.String r2 = "airRefreshEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r91 = r2
            java.lang.String r2 = "airRefreshStatus"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r92 = r2
            java.lang.String r2 = "airRefreshDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r93 = r2
            java.lang.String r2 = "airRefreshTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r94 = r2
            java.lang.String r2 = "airRefreshStartTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r95 = r2
            java.lang.String r2 = "airRefreshEndTimeStamp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r96 = r2
            java.lang.String r2 = "roomType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r97 = r2
            java.lang.String r2 = "nightLampBrightness"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r98 = r2
            java.lang.String r2 = "wickdryDuration"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r99 = r2
            java.lang.String r2 = "wickdryDone"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r100 = r2
            java.lang.String r2 = "ywrmEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r101 = r2
            java.lang.String r2 = "ywrmUsage"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r102 = r2
            java.lang.String r2 = "nightLampSteplessBrightness"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r103 = r2
            java.lang.String r2 = "alarms"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r104 = r2
            java.lang.String r2 = "humSubMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r105 = r2
            java.lang.String r2 = "use24Hour"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r106 = r2
            java.lang.String r2 = "waterInfill"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r107 = r2
            java.lang.String r2 = "sensorMode"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r108 = r2
            java.lang.String r2 = "uuid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r109 = r2
            java.lang.String r2 = "ssid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r110 = r2
            java.lang.String r2 = "bssid"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r111 = r2
            java.lang.String r2 = "ipv4"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r112 = r2
            java.lang.String r2 = "ipv6"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r113 = r2
            java.lang.String r2 = "timeInSeconds"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r114 = r2
            java.lang.String r2 = "pm1"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r115 = r2
            java.lang.String r2 = "pm10"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r116 = r2
            java.lang.String r2 = "pm25"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r117 = r2
            java.lang.String r2 = "voc"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r118 = r2
            java.lang.String r2 = "hcho"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r119 = r2
            java.lang.String r2 = "tmp"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r120 = r2
            java.lang.String r2 = "hum"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r121 = r2
            java.lang.String r2 = "fan"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r122 = r2
            java.lang.String r2 = "weight"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r123 = r2
            java.lang.String r2 = "lat"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r124 = r2
            java.lang.String r2 = "lng"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r125 = r2
            java.lang.String r2 = "radius"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r126 = r2
            java.lang.String r2 = "textValue"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            r127 = r2
            java.lang.String r2 = "isEnabled"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0c5a }
            boolean r128 = r1.step()     // Catch:{ all -> 0x0c5a }
            r129 = 0
            if (r128 == 0) goto L_0x0c56
            boolean r128 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r128 == 0) goto L_0x0407
            r131 = r129
            goto L_0x040d
        L_0x0407:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0c5a }
            r131 = r0
        L_0x040d:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0416
            r132 = r129
            goto L_0x041c
        L_0x0416:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r132 = r0
        L_0x041c:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0425
            r133 = r129
            goto L_0x042b
        L_0x0425:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
            r133 = r0
        L_0x042b:
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r0 = (int) r3     // Catch:{ all -> 0x0c5a }
            boolean r3 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0439
            r135 = r129
            goto L_0x0444
        L_0x0439:
            long r3 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r135 = r3
        L_0x0444:
            boolean r3 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x044d
            r136 = r129
            goto L_0x0458
        L_0x044d:
            long r3 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r136 = r3
        L_0x0458:
            boolean r3 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0461
            r137 = r129
            goto L_0x0467
        L_0x0461:
            java.lang.String r3 = r1.getText(r8)     // Catch:{ all -> 0x0c5a }
            r137 = r3
        L_0x0467:
            boolean r3 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0470
            r138 = r129
            goto L_0x047b
        L_0x0470:
            long r3 = r1.getLong(r9)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r138 = r3
        L_0x047b:
            boolean r3 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0484
            r139 = r129
            goto L_0x048a
        L_0x0484:
            java.lang.String r3 = r1.getText(r10)     // Catch:{ all -> 0x0c5a }
            r139 = r3
        L_0x048a:
            long r3 = r1.getLong(r11)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0494
            r141 = 1
            goto L_0x0496
        L_0x0494:
            r141 = 0
        L_0x0496:
            boolean r3 = r1.isNull(r12)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x049f
            r143 = r129
            goto L_0x04aa
        L_0x049f:
            long r5 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r143 = r3
        L_0x04aa:
            long r5 = r1.getLong(r13)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04b4
            r144 = 1
            goto L_0x04b6
        L_0x04b4:
            r144 = 0
        L_0x04b6:
            long r5 = r1.getLong(r14)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04c0
            r145 = 1
            goto L_0x04c2
        L_0x04c0:
            r145 = 0
        L_0x04c2:
            long r5 = r1.getLong(r15)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x04cc
            r146 = 1
            goto L_0x04ce
        L_0x04cc:
            r146 = 0
        L_0x04ce:
            r3 = r249
            boolean r5 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x04db
            r147 = r129
        L_0x04d8:
            r3 = r16
            goto L_0x04e2
        L_0x04db:
            java.lang.String r3 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r147 = r3
            goto L_0x04d8
        L_0x04e2:
            long r5 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r5     // Catch:{ all -> 0x0c5a }
            r5 = r17
            long r149 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r18
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x04fa
            r151 = r129
        L_0x04f7:
            r5 = r19
            goto L_0x0501
        L_0x04fa:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r151 = r5
            goto L_0x04f7
        L_0x0501:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x050c
            r152 = r129
        L_0x0509:
            r5 = r20
            goto L_0x0513
        L_0x050c:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r152 = r5
            goto L_0x0509
        L_0x0513:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x051e
            r153 = r129
        L_0x051b:
            r5 = r21
            goto L_0x0525
        L_0x051e:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r153 = r5
            goto L_0x051b
        L_0x0525:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0530
            r154 = r129
        L_0x052d:
            r5 = r22
            goto L_0x0537
        L_0x0530:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r154 = r5
            goto L_0x052d
        L_0x0537:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0542
            r155 = r129
        L_0x053f:
            r5 = r23
            goto L_0x0549
        L_0x0542:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r155 = r5
            goto L_0x053f
        L_0x0549:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0554
            r156 = r129
        L_0x0551:
            r5 = r24
            goto L_0x055b
        L_0x0554:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r156 = r5
            goto L_0x0551
        L_0x055b:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0566
            r157 = r129
        L_0x0563:
            r5 = r25
            goto L_0x056d
        L_0x0566:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r157 = r5
            goto L_0x0563
        L_0x056d:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0578
            r158 = r129
        L_0x0575:
            r5 = r26
            goto L_0x057f
        L_0x0578:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r158 = r5
            goto L_0x0575
        L_0x057f:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x058a
            r159 = r129
        L_0x0587:
            r5 = r27
            goto L_0x0591
        L_0x058a:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r159 = r5
            goto L_0x0587
        L_0x0591:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x059c
            r160 = r129
        L_0x0599:
            r5 = r28
            goto L_0x05a3
        L_0x059c:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r160 = r5
            goto L_0x0599
        L_0x05a3:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05ae
            r161 = r129
        L_0x05ab:
            r5 = r29
            goto L_0x05b5
        L_0x05ae:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r161 = r5
            goto L_0x05ab
        L_0x05b5:
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05be
            r5 = r129
            goto L_0x05c2
        L_0x05be:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05c2:
            double[] r162 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r30
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05d1
            r5 = r129
            goto L_0x05d5
        L_0x05d1:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05d5:
            double[] r163 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r31
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05e4
            r5 = r129
            goto L_0x05e8
        L_0x05e4:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05e8:
            double[] r164 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r32
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x05f7
            r5 = r129
            goto L_0x05fb
        L_0x05f7:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x05fb:
            double[] r165 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r33
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x060a
            r5 = r129
            goto L_0x060e
        L_0x060a:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x060e:
            double[] r166 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r34
            long r5 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r5 = (int) r5     // Catch:{ all -> 0x0c5a }
            r6 = r35
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0625
            r168 = 1
            goto L_0x0627
        L_0x0625:
            r168 = 0
        L_0x0627:
            r6 = r36
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0633
            r169 = 1
            goto L_0x0635
        L_0x0633:
            r169 = 0
        L_0x0635:
            r6 = r37
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0641
            r170 = 1
            goto L_0x0643
        L_0x0641:
            r170 = 0
        L_0x0643:
            r6 = r38
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x064f
            r171 = 1
            goto L_0x0651
        L_0x064f:
            r171 = 0
        L_0x0651:
            r6 = r39
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x065d
            r172 = 1
            goto L_0x065f
        L_0x065d:
            r172 = 0
        L_0x065f:
            r6 = r40
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x066b
            r173 = 1
            goto L_0x066d
        L_0x066b:
            r173 = 0
        L_0x066d:
            r6 = r41
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0678
            r6 = r129
            goto L_0x0681
        L_0x0678:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
        L_0x0681:
            if (r6 != 0) goto L_0x0688
            r174 = r129
        L_0x0685:
            r6 = r42
            goto L_0x0698
        L_0x0688:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0690
            r6 = 1
            goto L_0x0691
        L_0x0690:
            r6 = 0
        L_0x0691:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r174 = r6
            goto L_0x0685
        L_0x0698:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x06a2
            r175 = 1
            goto L_0x06a4
        L_0x06a2:
            r175 = 0
        L_0x06a4:
            r6 = r43
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06b1
            r176 = r129
        L_0x06ae:
            r6 = r44
            goto L_0x06b8
        L_0x06b1:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r176 = r6
            goto L_0x06ae
        L_0x06b8:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x06c2
            r177 = 1
            goto L_0x06c4
        L_0x06c2:
            r177 = 0
        L_0x06c4:
            r6 = r45
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06d1
            r178 = r129
        L_0x06ce:
            r6 = r46
            goto L_0x06d8
        L_0x06d1:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r178 = r6
            goto L_0x06ce
        L_0x06d8:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06e3
            r179 = r129
        L_0x06e0:
            r6 = r47
            goto L_0x06ea
        L_0x06e3:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r179 = r6
            goto L_0x06e0
        L_0x06ea:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x06f5
            r181 = r129
        L_0x06f2:
            r6 = r48
            goto L_0x06fc
        L_0x06f5:
            java.lang.String r6 = r1.getText(r6)     // Catch:{ all -> 0x0c5a }
            r181 = r6
            goto L_0x06f2
        L_0x06fc:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0705
            r6 = r129
            goto L_0x070e
        L_0x0705:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
        L_0x070e:
            if (r6 != 0) goto L_0x0715
            r182 = r129
        L_0x0712:
            r6 = r49
            goto L_0x0725
        L_0x0715:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x071d
            r6 = 1
            goto L_0x071e
        L_0x071d:
            r6 = 0
        L_0x071e:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r182 = r6
            goto L_0x0712
        L_0x0725:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0730
            r183 = r129
        L_0x072d:
            r6 = r50
            goto L_0x073c
        L_0x0730:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r183 = r6
            goto L_0x072d
        L_0x073c:
            boolean r7 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r7 == 0) goto L_0x0747
            r184 = r129
        L_0x0744:
            r6 = r51
            goto L_0x0752
        L_0x0747:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0c5a }
            r184 = r6
            goto L_0x0744
        L_0x0752:
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x075c
            r185 = 1
            goto L_0x075e
        L_0x075c:
            r185 = 0
        L_0x075e:
            r6 = r52
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x076a
            r186 = 1
            goto L_0x076c
        L_0x076a:
            r186 = 0
        L_0x076c:
            r6 = r53
            long r6 = r1.getLong(r6)     // Catch:{ all -> 0x0c5a }
            int r6 = (int) r6     // Catch:{ all -> 0x0c5a }
            r7 = r54
            long r188 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            r7 = r55
            long r7 = r1.getLong(r7)     // Catch:{ all -> 0x0c5a }
            int r7 = (int) r7     // Catch:{ all -> 0x0c5a }
            r8 = r56
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x0c5a }
            int r8 = (int) r8     // Catch:{ all -> 0x0c5a }
            if (r8 == 0) goto L_0x078c
            r191 = 1
            goto L_0x078e
        L_0x078c:
            r191 = 0
        L_0x078e:
            r8 = r57
            long r8 = r1.getLong(r8)     // Catch:{ all -> 0x0c5a }
            int r8 = (int) r8     // Catch:{ all -> 0x0c5a }
            r9 = r58
            long r9 = r1.getLong(r9)     // Catch:{ all -> 0x0c5a }
            int r9 = (int) r9     // Catch:{ all -> 0x0c5a }
            r10 = r59
            long r10 = r1.getLong(r10)     // Catch:{ all -> 0x0c5a }
            int r10 = (int) r10     // Catch:{ all -> 0x0c5a }
            r11 = r60
            long r11 = r1.getLong(r11)     // Catch:{ all -> 0x0c5a }
            int r11 = (int) r11     // Catch:{ all -> 0x0c5a }
            r12 = r61
            long r196 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            r12 = r62
            long r12 = r1.getLong(r12)     // Catch:{ all -> 0x0c5a }
            int r12 = (int) r12     // Catch:{ all -> 0x0c5a }
            r13 = r63
            long r13 = r1.getLong(r13)     // Catch:{ all -> 0x0c5a }
            int r13 = (int) r13     // Catch:{ all -> 0x0c5a }
            r14 = r64
            long r14 = r1.getLong(r14)     // Catch:{ all -> 0x0c5a }
            int r14 = (int) r14     // Catch:{ all -> 0x0c5a }
            r167 = r5
            r15 = r65
            long r4 = r1.getLong(r15)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r148 = r3
            r201 = r4
            r5 = r66
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r67
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r202 = r3
            r203 = r4
            r5 = r68
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r69
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r204 = r3
            r205 = r4
            r5 = r70
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r71
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r72
            double r208 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            r5 = r73
            double r210 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            r206 = r3
            r207 = r4
            r5 = r74
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r75
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r212 = r3
            r213 = r4
            r5 = r76
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r77
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0838
            r4 = r129
            goto L_0x083c
        L_0x0838:
            java.lang.String r4 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
        L_0x083c:
            double[] r215 = com.blueair.database.DoubleArrayConverter.fromString(r4)     // Catch:{ all -> 0x0c5a }
            r4 = r78
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r79
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0852
            r5 = r129
            goto L_0x0856
        L_0x0852:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0856:
            double[] r217 = com.blueair.database.DoubleArrayConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r214 = r3
            r216 = r4
            r5 = r80
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x086a
            r218 = 1
            goto L_0x086c
        L_0x086a:
            r218 = 0
        L_0x086c:
            r3 = r81
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r82
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r219 = r3
            r220 = r4
            r5 = r83
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r84
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0891
            r222 = 1
            goto L_0x0893
        L_0x0891:
            r222 = 0
        L_0x0893:
            r4 = r85
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r221 = r3
            r223 = r4
            r5 = r86
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08aa
            r224 = 1
            goto L_0x08ac
        L_0x08aa:
            r224 = 0
        L_0x08ac:
            r3 = r87
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08b8
            r225 = 1
            goto L_0x08ba
        L_0x08b8:
            r225 = 0
        L_0x08ba:
            r3 = r88
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r89
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r226 = r3
            r227 = r4
            r5 = r90
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08d8
            r228 = 1
            goto L_0x08da
        L_0x08d8:
            r228 = 0
        L_0x08da:
            r3 = r91
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x08e6
            r229 = 1
            goto L_0x08e8
        L_0x08e6:
            r229 = 0
        L_0x08e8:
            r3 = r92
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r93
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r230 = r3
            r231 = r4
            r5 = r94
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r95
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r232 = r3
            r233 = r4
            r5 = r96
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r97
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r234 = r3
            r235 = r4
            r5 = r98
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r99
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r236 = r3
            r237 = r4
            r5 = r100
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x093c
            r238 = 1
            goto L_0x093e
        L_0x093c:
            r238 = 0
        L_0x093e:
            r3 = r101
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0949
            r3 = r129
            goto L_0x0952
        L_0x0949:
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0c5a }
        L_0x0952:
            if (r3 != 0) goto L_0x0959
            r239 = r129
        L_0x0956:
            r3 = r102
            goto L_0x0969
        L_0x0959:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0961
            r3 = 1
            goto L_0x0962
        L_0x0961:
            r3 = 0
        L_0x0962:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0c5a }
            r239 = r3
            goto L_0x0956
        L_0x0969:
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r103
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r104
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0980
            r5 = r129
            goto L_0x0984
        L_0x0980:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0984:
            java.util.List r242 = com.blueair.database.DeviceAlarmListConverter.fromString(r5)     // Catch:{ all -> 0x0c5a }
            r240 = r3
            r241 = r4
            r5 = r105
            long r3 = r1.getLong(r5)     // Catch:{ all -> 0x0c5a }
            int r3 = (int) r3     // Catch:{ all -> 0x0c5a }
            r4 = r106
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x099f
            r244 = 1
            goto L_0x09a1
        L_0x099f:
            r244 = 0
        L_0x09a1:
            r4 = r107
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x09ad
            r245 = 1
            goto L_0x09af
        L_0x09ad:
            r245 = 0
        L_0x09af:
            r4 = r108
            long r4 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r4 = (int) r4     // Catch:{ all -> 0x0c5a }
            r5 = r109
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x09fa
            r15 = r110
            boolean r16 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09f3
            r134 = r0
            r0 = r111
            boolean r16 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09ee
            r243 = r3
            r3 = r112
            boolean r16 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x09eb
            r246 = r4
            r4 = r113
            boolean r16 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r16 != 0) goto L_0x09e5
            goto L_0x0a08
        L_0x09e5:
            r140 = r129
        L_0x09e7:
            r0 = r114
            goto L_0x0a5b
        L_0x09eb:
            r246 = r4
            goto L_0x0a06
        L_0x09ee:
            r243 = r3
            r246 = r4
            goto L_0x0a04
        L_0x09f3:
            r134 = r0
            r243 = r3
            r246 = r4
            goto L_0x0a02
        L_0x09fa:
            r134 = r0
            r243 = r3
            r246 = r4
            r15 = r110
        L_0x0a02:
            r0 = r111
        L_0x0a04:
            r3 = r112
        L_0x0a06:
            r4 = r113
        L_0x0a08:
            boolean r16 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0a11
            r17 = r129
            goto L_0x0a17
        L_0x0a11:
            java.lang.String r5 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
            r17 = r5
        L_0x0a17:
            boolean r5 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0a20
            r18 = r129
            goto L_0x0a26
        L_0x0a20:
            java.lang.String r5 = r1.getText(r15)     // Catch:{ all -> 0x0c5a }
            r18 = r5
        L_0x0a26:
            boolean r5 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0a2f
            r19 = r129
            goto L_0x0a35
        L_0x0a2f:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0c5a }
            r19 = r0
        L_0x0a35:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0a3e
            r20 = r129
            goto L_0x0a44
        L_0x0a3e:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x0c5a }
            r20 = r0
        L_0x0a44:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0a4d
            r21 = r129
            goto L_0x0a53
        L_0x0a4d:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x0c5a }
            r21 = r0
        L_0x0a53:
            com.blueair.database.DeviceUuidEntity r16 = new com.blueair.database.DeviceUuidEntity     // Catch:{ all -> 0x0c5a }
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0c5a }
            r140 = r16
            goto L_0x09e7
        L_0x0a5b:
            boolean r3 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0b05
            r3 = r115
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0afa
            r4 = r116
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0aef
            r5 = r117
            boolean r15 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r15 == 0) goto L_0x0ae4
            r15 = r118
            boolean r16 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ad9
            r187 = r6
            r6 = r119
            boolean r16 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ad0
            r190 = r7
            r7 = r120
            boolean r16 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ac9
            r192 = r8
            r8 = r121
            boolean r16 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0ac3
            r193 = r9
            r9 = r122
            boolean r16 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r16 == 0) goto L_0x0abf
            r194 = r10
            r10 = r123
            boolean r16 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r16 != 0) goto L_0x0ab5
            goto L_0x0b21
        L_0x0ab5:
            r195 = r11
            r198 = r12
            r142 = r129
        L_0x0abb:
            r0 = r124
            goto L_0x0bea
        L_0x0abf:
            r194 = r10
            goto L_0x0b1f
        L_0x0ac3:
            r193 = r9
            r194 = r10
            goto L_0x0b1d
        L_0x0ac9:
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b1b
        L_0x0ad0:
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b19
        L_0x0ad9:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b17
        L_0x0ae4:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b15
        L_0x0aef:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b13
        L_0x0afa:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            goto L_0x0b11
        L_0x0b05:
            r187 = r6
            r190 = r7
            r192 = r8
            r193 = r9
            r194 = r10
            r3 = r115
        L_0x0b11:
            r4 = r116
        L_0x0b13:
            r5 = r117
        L_0x0b15:
            r15 = r118
        L_0x0b17:
            r6 = r119
        L_0x0b19:
            r7 = r120
        L_0x0b1b:
            r8 = r121
        L_0x0b1d:
            r9 = r122
        L_0x0b1f:
            r10 = r123
        L_0x0b21:
            long r16 = r1.getLong(r0)     // Catch:{ all -> 0x0c5a }
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b32
            r195 = r11
            r198 = r12
            r18 = r129
            goto L_0x0b41
        L_0x0b32:
            r195 = r11
            r198 = r12
            double r11 = r1.getDouble(r3)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r11     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r18 = r0
        L_0x0b41:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b4a
            r19 = r129
            goto L_0x0b55
        L_0x0b4a:
            double r3 = r1.getDouble(r4)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r19 = r0
        L_0x0b55:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b5e
            r20 = r129
            goto L_0x0b69
        L_0x0b5e:
            double r3 = r1.getDouble(r5)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r20 = r0
        L_0x0b69:
            boolean r0 = r1.isNull(r15)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b72
            r21 = r129
            goto L_0x0b7d
        L_0x0b72:
            double r3 = r1.getDouble(r15)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r21 = r0
        L_0x0b7d:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b86
            r22 = r129
            goto L_0x0b91
        L_0x0b86:
            double r3 = r1.getDouble(r6)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r22 = r0
        L_0x0b91:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0b9a
            r23 = r129
            goto L_0x0ba5
        L_0x0b9a:
            double r3 = r1.getDouble(r7)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r23 = r0
        L_0x0ba5:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bae
            r24 = r129
            goto L_0x0bb9
        L_0x0bae:
            double r3 = r1.getDouble(r8)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r24 = r0
        L_0x0bb9:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bc2
            r25 = r129
            goto L_0x0bcd
        L_0x0bc2:
            double r3 = r1.getDouble(r9)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r25 = r0
        L_0x0bcd:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0c5a }
            if (r0 == 0) goto L_0x0bd6
            r26 = r129
            goto L_0x0be1
        L_0x0bd6:
            double r3 = r1.getDouble(r10)     // Catch:{ all -> 0x0c5a }
            float r0 = (float) r3     // Catch:{ all -> 0x0c5a }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0c5a }
            r26 = r0
        L_0x0be1:
            com.blueair.core.model.IndoorDatapoint r15 = new com.blueair.core.model.IndoorDatapoint     // Catch:{ all -> 0x0c5a }
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0c5a }
            r142 = r15
            goto L_0x0abb
        L_0x0bea:
            boolean r3 = r1.isNull(r0)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0c12
            r3 = r125
            boolean r4 = r1.isNull(r3)     // Catch:{ all -> 0x0c5a }
            if (r4 == 0) goto L_0x0c14
            r4 = r126
            boolean r5 = r1.isNull(r4)     // Catch:{ all -> 0x0c5a }
            if (r5 == 0) goto L_0x0c16
            r5 = r127
            boolean r6 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r6 == 0) goto L_0x0c18
            boolean r6 = r1.isNull(r2)     // Catch:{ all -> 0x0c5a }
            if (r6 != 0) goto L_0x0c0f
            goto L_0x0c18
        L_0x0c0f:
            r180 = r129
            goto L_0x0c4b
        L_0x0c12:
            r3 = r125
        L_0x0c14:
            r4 = r126
        L_0x0c16:
            r5 = r127
        L_0x0c18:
            double r6 = r1.getDouble(r0)     // Catch:{ all -> 0x0c5a }
            double r8 = r1.getDouble(r3)     // Catch:{ all -> 0x0c5a }
            long r3 = r1.getLong(r4)     // Catch:{ all -> 0x0c5a }
            int r0 = (int) r3     // Catch:{ all -> 0x0c5a }
            boolean r3 = r1.isNull(r5)     // Catch:{ all -> 0x0c5a }
            if (r3 == 0) goto L_0x0c2c
            goto L_0x0c30
        L_0x0c2c:
            java.lang.String r129 = r1.getText(r5)     // Catch:{ all -> 0x0c5a }
        L_0x0c30:
            long r2 = r1.getLong(r2)     // Catch:{ all -> 0x0c5a }
            int r2 = (int) r2     // Catch:{ all -> 0x0c5a }
            if (r2 == 0) goto L_0x0c39
            r2 = 1
            goto L_0x0c3a
        L_0x0c39:
            r2 = 0
        L_0x0c3a:
            com.blueair.core.model.WelcomeHomeLocation r3 = new com.blueair.core.model.WelcomeHomeLocation     // Catch:{ all -> 0x0c5a }
            r247 = r8
            r9 = r2
            r2 = r3
            r3 = r6
            r5 = r247
            r7 = r0
            r8 = r129
            r2.<init>(r3, r5, r7, r8, r9)     // Catch:{ all -> 0x0c5a }
            r180 = r2
        L_0x0c4b:
            com.blueair.database.entity.DeviceEntity r130 = new com.blueair.database.entity.DeviceEntity     // Catch:{ all -> 0x0c5a }
            r199 = r13
            r200 = r14
            r130.<init>(r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r190, r191, r192, r193, r194, r195, r196, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r210, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246)     // Catch:{ all -> 0x0c5a }
            r129 = r130
        L_0x0c56:
            r1.close()
            return r129
        L_0x0c5a:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDao_Impl.lambda$getFlowDevice$8(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceEntity");
    }

    public Object updateName(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda90(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateName$9(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET name = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateTimezone(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda13(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateTimezone$10(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET timeZone = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateLatestSensorDataPoint(String str, long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda69(j, f, f2, f3, f4, f5, f6, f7, f8, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateLatestSensorDataPoint$11(long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET timeInSeconds = ?, pm1 = ?, pm10 = ?, pm25 = ?, voc = ?, hcho = ?, tmp = ?, hum = ?, fan = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, j);
            if (f == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindDouble(2, (double) f.floatValue());
            }
            if (f2 == null) {
                prepare.bindNull(3);
            } else {
                prepare.bindDouble(3, (double) f2.floatValue());
            }
            if (f3 == null) {
                prepare.bindNull(4);
            } else {
                prepare.bindDouble(4, (double) f3.floatValue());
            }
            if (f4 == null) {
                prepare.bindNull(5);
            } else {
                prepare.bindDouble(5, (double) f4.floatValue());
            }
            if (f5 == null) {
                prepare.bindNull(6);
            } else {
                prepare.bindDouble(6, (double) f5.floatValue());
            }
            if (f6 == null) {
                prepare.bindNull(7);
            } else {
                prepare.bindDouble(7, (double) f6.floatValue());
            }
            if (f7 == null) {
                prepare.bindNull(8);
            } else {
                prepare.bindDouble(8, (double) f7.floatValue());
            }
            if (f8 == null) {
                prepare.bindNull(9);
            } else {
                prepare.bindDouble(9, (double) f8.floatValue());
            }
            if (str == null) {
                prepare.bindNull(10);
            } else {
                prepare.bindText(10, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateLastSelectedSensorType(String str, Integer num, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda37(num, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateLastSelectedSensorType$12(Integer num, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET lastSelectedSensorType = ? WHERE uid = ?");
        if (num == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateFanSpeed(String str, Integer num, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda61(num, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateFanSpeed$13(Integer num, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET fanSpeed = ? WHERE uid = ?");
        if (num == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateFanSpeedAndAutoMode(String str, Integer num, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda71(num, str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateFanSpeedAndAutoMode$14(Integer num, String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET fanSpeed = ?, autoModeText = ? WHERE uid = ?");
        if (num == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        if (str2 == null) {
            prepare.bindNull(3);
        } else {
            prepare.bindText(3, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateAutoMode(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda0(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAutoMode$15(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET autoModeText = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateBrightness(String str, Integer num, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda103(num, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateBrightness$16(Integer num, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET brightness = ? WHERE uid = ?");
        if (num == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateChildLock(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda67(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateChildLock$17(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isChildLockOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateLinkedDeviceUid(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda58(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateLinkedDeviceUid$18(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET linkedDeviceUid = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateConnectivityStatus(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda10(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateConnectivityStatus$19(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET connectivityStatusIndex = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateProgress(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda56(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateProgress$20(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET updateProgress = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateFilterLife(String str, Integer num, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda60(num, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateFilterLife$21(Integer num, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET filterLife = ? WHERE uid = ?");
        if (num == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateSku(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda9(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateSku$22(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET sku = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateCompatibility(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda106(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCompatibility$23(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET compatibility = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateSensorRange(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda18(str2, str3, str4, str5, str6, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateSensorRange$24(String str, String str2, String str3, String str4, String str5, String str6, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET pm1Ranges = ?, pm10Ranges = ?, pm25Ranges = ?, vocRanges = ?, hchoRanges = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        if (str3 == null) {
            prepare.bindNull(3);
        } else {
            prepare.bindText(3, str3);
        }
        if (str4 == null) {
            prepare.bindNull(4);
        } else {
            prepare.bindText(4, str4);
        }
        if (str5 == null) {
            prepare.bindNull(5);
        } else {
            prepare.bindText(5, str5);
        }
        if (str6 == null) {
            prepare.bindNull(6);
        } else {
            prepare.bindText(6, str6);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateWifiFirmware(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda66(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWifiFirmware$25(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wifiFirmware = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateMcuFirmware(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda21(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateMcuFirmware$26(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET mcuFirmware = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateHardware(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda88(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHardware$27(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET hardware = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateStandByMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda53(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateStandByMode$28(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isStandByOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateEcoMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda47(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateEcoMode$29(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isEcoModeOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHinsMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda62(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHinsMode$30(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isHinsModeOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHinsNightMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda85(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHinsNightMode$31(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isHinsNightModeOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateG4NightMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda41(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateG4NightMode$32(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isG4NightModeOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateGermShieldMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda57(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateGermShieldMode$33(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isGermShieldOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateGermShieldNightMode(String str, Boolean bool, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda91(bool, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateGermShieldNightMode$34(Boolean bool, String str, SQLiteConnection sQLiteConnection) {
        Integer num;
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isGermShieldNightModeOn = ? WHERE uid = ?");
        if (bool == null) {
            num = null;
        } else {
            try {
                num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        }
        if (num == null) {
            prepare.bindNull(1);
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateSerialNumber(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda12(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateSerialNumber$35(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET serial = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateFilterTrigger(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda97(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateFilterTrigger$36(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET filterTrigger = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateG4NightModeFilterTrigger(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda31(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateG4NightModeFilterTrigger$37(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET g4NightModefilterTrigger = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateSafetySwitch(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda51(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateSafetySwitch$38(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET isSafetySwitchOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateMacAddress(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda3(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateMacAddress$39(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET mac = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateModelName(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda32(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateModelName$40(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET modelName = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateFilterType(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda15(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateFilterType$41(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET filterType = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateDeviceType(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda104(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateDeviceType$42(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET typeIndex = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWelcomeHome(String str, Double d, Double d2, Integer num, String str2, Boolean bool, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda30(d, d2, num, str2, bool, str), continuation);
    }

    static /* synthetic */ Unit lambda$updateWelcomeHome$43(Double d, Double d2, Integer num, String str, Boolean bool, String str2, SQLiteConnection sQLiteConnection) {
        Integer num2;
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET lat = ?, lng = ?, radius = ?, textValue = ?, isEnabled = ? WHERE uid = ?");
        if (d == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindDouble(1, d.doubleValue());
        }
        if (d2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindDouble(2, d2.doubleValue());
        }
        if (num == null) {
            prepare.bindNull(3);
        } else {
            prepare.bindLong(3, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(4);
        } else {
            prepare.bindText(4, str);
        }
        if (bool == null) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
        if (num2 == null) {
            prepare.bindNull(5);
        } else {
            prepare.bindLong(5, (long) num2.intValue());
        }
        if (str2 == null) {
            prepare.bindNull(6);
        } else {
            prepare.bindText(6, str2);
        }
        prepare.step();
        Unit unit = Unit.INSTANCE;
        prepare.close();
        return unit;
    }

    public Object updateDisinfection(String str, Boolean bool, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda45(bool, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateDisinfection$44(Boolean bool, String str, SQLiteConnection sQLiteConnection) {
        Integer num;
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET disinfection = ? WHERE uid = ?");
        if (bool == null) {
            num = null;
        } else {
            try {
                num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        }
        if (num == null) {
            prepare.bindNull(1);
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateDisinfectLeftTime(String str, Integer num, Long l, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda68(num, l, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateDisinfectLeftTime$45(Integer num, Long l, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET disinfectLeftTime = ?, disinfectLeftTimeUpdateTime = ? WHERE uid = ?");
        if (num == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (l == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindLong(2, l.longValue());
        }
        if (str == null) {
            prepare.bindNull(3);
        } else {
            prepare.bindText(3, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateWickdryEnabled(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda33(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWickdryEnabled$46(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wickdryEnabled = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWickdryOn(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda43(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWickdryOn$47(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wickdryOn = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWickdryLeftTime(String str, int i, long j, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda94(i, j, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWickdryLeftTime$48(int i, long j, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wickdryLeftTime = ?, wickdryLeftTimeUpdateTime = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            prepare.bindLong(2, j);
            if (str == null) {
                prepare.bindNull(3);
            } else {
                prepare.bindText(3, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWickUsage(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda44(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWickUsage$49(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wickUsage = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWaterShortage(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda76(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWaterShortage$50(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET waterShortage = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAutoRh(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda14(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAutoRh$51(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET autoRh = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateTimerStatus(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda54(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateTimerStatus$52(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET timerStatus = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateTimerDuration(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda79(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateTimerDuration$53(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET timerDuration = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateTimerLeftTime(String str, int i, long j, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda28(i, j, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateTimerLeftTime$54(int i, long j, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET timerLeftTime = ?, timerLeftTimeUpdateTime = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            prepare.bindLong(2, j);
            if (str == null) {
                prepare.bindNull(3);
            } else {
                prepare.bindText(3, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateTemperatureUnit(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda4(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateTemperatureUnit$55(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET temperatureUnit = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateOscillationState(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda26(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateOscillationState$56(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET oscillationState = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateOscillationAngle(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda77(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateOscillationAngle$57(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET oscillationAngle = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateOscillationDirection(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda2(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateOscillationDirection$58(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET oscillationDirection = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateOscillationFanSpeed(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda34(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateOscillationFanSpeed$59(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET oscillationFanSpeed = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateMainMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda65(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateMainMode$60(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET mainMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateApSubMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda87(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateApSubMode$61(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET apSubMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateApFanSpeed(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda50(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateApFanSpeed$62(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET apFanSpeed = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHeatSubMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda20(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHeatSubMode$63(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET heatSubMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHeatFanSpeed(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda95(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHeatFanSpeed$64(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET heatFanSpeed = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHeatAutoTmp(String str, double d, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda48(d, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHeatAutoTmp$65(double d, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET heatAutoTmp = ? WHERE uid = ?");
        try {
            prepare.bindDouble(1, d);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHeatEcoTmp(String str, double d, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda70(d, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHeatEcoTmp$66(double d, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET heatEcoTmp = ? WHERE uid = ?");
        try {
            prepare.bindDouble(1, d);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateCoolSubMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda8(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCoolSubMode$67(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET coolSubMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateCoolFanSpeed(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda49(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCoolFanSpeed$68(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET coolFanSpeed = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateCoolAutoTag(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda81(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCoolAutoTag$69(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET coolAutoTag = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateCoolAutoPresets(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda74(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCoolAutoPresets$70(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET coolAutoPresets = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateCoolEcoTag(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda75(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCoolEcoTag$71(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET coolEcoTag = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateCoolEcoPresets(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda72(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCoolEcoPresets$72(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET coolEcoPresets = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateLocationId(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda25(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateLocationId$73(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET locationId = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object deleteLocationId(String str, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda7(str), continuation);
    }

    static /* synthetic */ Integer lambda$deleteLocationId$74(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET locationId = '' WHERE locationId = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda35(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateMode$75(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET mode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHumMode(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda40(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHumMode$76(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET humMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWaterLevel(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda101(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWaterLevel$77(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET waterLevel = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateDehSubMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda93(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateDehSubMode$78(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET dehSubMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWaterTankFailure(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda64(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWaterTankFailure$79(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET waterTankFailure = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateSmartSubMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda27(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateSmartSubMode$80(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET smartSubMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateDetectCat(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda102(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateDetectCat$81(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET detectCat = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateBodyMounted(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda17(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateBodyMounted$82(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET bodyMounted = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateCleanAirEta(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda84(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateCleanAirEta$83(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET cleanAirEta = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updatePanelDisplayMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda82(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updatePanelDisplayMode$84(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET panelDisplayMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateHoverEnabled(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda19(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHoverEnabled$85(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET hoverEnabled = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAirRefreshEnabled(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda11(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAirRefreshEnabled$86(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET airRefreshEnabled = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAirRefreshStatus(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda23(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAirRefreshStatus$87(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET airRefreshStatus = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAirRefreshDuration(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda29(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAirRefreshDuration$88(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET airRefreshDuration = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAirRefreshTimeStamp(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda63(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAirRefreshTimeStamp$89(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET airRefreshTimeStamp = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAirRefreshStartTimeStamp(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda89(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAirRefreshStartTimeStamp$90(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET airRefreshStartTimeStamp = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAirRefreshEndTimeStamp(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda24(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAirRefreshEndTimeStamp$91(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET airRefreshEndTimeStamp = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateRoomType(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda100(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateRoomType$92(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET roomType = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateNightLampBrightness(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda83(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateNightLampBrightness$93(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET nightLampBrightness = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWickdryDuration(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda98(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWickdryDuration$94(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wickdryDuration = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateWickdryDone(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda86(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateWickdryDone$95(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET wickdryDone = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateYwrmEnabled(String str, Boolean bool, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda36(bool, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateYwrmEnabled$96(Boolean bool, String str, SQLiteConnection sQLiteConnection) {
        Integer num;
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET ywrmEnabled = ? WHERE uid = ?");
        if (bool == null) {
            num = null;
        } else {
            try {
                num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        }
        if (num == null) {
            prepare.bindNull(1);
        } else {
            prepare.bindLong(1, (long) num.intValue());
        }
        if (str == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateYwrmUsage(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda105(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateYwrmUsage$97(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET ywrmUsage = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateNightLampSteplessBrightness(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda99(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateNightLampSteplessBrightness$98(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET nightLampSteplessBrightness = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateAlarms(String str, String str2, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda80(str2, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateAlarms$99(String str, String str2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET alarms = ? WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        if (str2 == null) {
            prepare.bindNull(2);
        } else {
            prepare.bindText(2, str2);
        }
        prepare.step();
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object updateHumSubMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda16(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateHumSubMode$100(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET humSubMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateUse24Hour(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda78(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateUse24Hour$101(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET use24Hour = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updatWaterInfill(String str, boolean z, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda39(z, str), continuation);
    }

    static /* synthetic */ Integer lambda$updatWaterInfill$102(boolean z, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET waterInfill = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public Object updateSensorMode(String str, int i, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda1(i, str), continuation);
    }

    static /* synthetic */ Integer lambda$updateSensorMode$103(int i, String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE device_table SET sensorMode = ? WHERE uid = ?");
        try {
            prepare.bindLong(1, (long) i);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public void delete(String str) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda52(str));
    }

    static /* synthetic */ Object lambda$delete$104(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_table WHERE uid = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        prepare.step();
        prepare.close();
        return null;
    }

    public void deleteAll(boolean z) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda6(z));
    }

    /* JADX INFO: finally extract failed */
    static /* synthetic */ Object lambda$deleteAll$105(boolean z, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_table WHERE isAblDevice = ?");
        try {
            prepare.bindLong(1, z ? 1 : 0);
            prepare.step();
            prepare.close();
            return null;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    public void deleteAll() {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda22());
    }

    /* JADX INFO: finally extract failed */
    static /* synthetic */ Object lambda$deleteAll$106(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_table");
        try {
            prepare.step();
            prepare.close();
            return null;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }
}
