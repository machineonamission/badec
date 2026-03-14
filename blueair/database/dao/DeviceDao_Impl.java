package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.database.DeviceAlarmListConverter;
import com.blueair.database.DeviceUuidEntity;
import com.blueair.database.DoubleArrayConverter;
import com.blueair.database.entity.DeviceEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

public final class DeviceDao_Impl implements DeviceDao {
   private final RoomDatabase __db;
   private final EntityInsertAdapter __insertAdapterOfDeviceEntity;
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfDeviceEntity;

   public DeviceDao_Impl(RoomDatabase var1) {
      this.__db = var1;
      this.__insertAdapterOfDeviceEntity = new EntityInsertAdapter(this) {
         final DeviceDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, DeviceEntity var2) {
            if (var2.getUid() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getUid());
            }

            if (var2.getName() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getName());
            }

            if (var2.getModelName() == null) {
               var1.bindNull(3);
            } else {
               var1.bindText(3, var2.getModelName());
            }

            var1.bindLong(4, (long)var2.getTypeIndex());
            if (var2.getFanSpeed() == null) {
               var1.bindNull(5);
            } else {
               var1.bindLong(5, (long)var2.getFanSpeed());
            }

            if (var2.getFilterLife() == null) {
               var1.bindNull(6);
            } else {
               var1.bindLong(6, (long)var2.getFilterLife());
            }

            if (var2.getAutoModeText() == null) {
               var1.bindNull(7);
            } else {
               var1.bindText(7, var2.getAutoModeText());
            }

            if (var2.getBrightness() == null) {
               var1.bindNull(8);
            } else {
               var1.bindLong(8, (long)var2.getBrightness());
            }

            if (var2.getInfo() == null) {
               var1.bindNull(9);
            } else {
               var1.bindText(9, var2.getInfo());
            }

            var1.bindLong(10, (long)var2.getHasFinishedOnboarding());
            if (var2.getLastSelectedSensorType() == null) {
               var1.bindNull(11);
            } else {
               var1.bindLong(11, (long)var2.getLastSelectedSensorType());
            }

            var1.bindLong(12, (long)var2.isAblDevice());
            var1.bindLong(13, (long)var2.isNightModeOn());
            var1.bindLong(14, (long)var2.isChildLockOn());
            if (var2.getLinkedDeviceUid() == null) {
               var1.bindNull(15);
            } else {
               var1.bindText(15, var2.getLinkedDeviceUid());
            }

            var1.bindLong(16, (long)var2.getConnectivityStatusIndex());
            var1.bindLong(17, var2.getLastConnectivityMillis());
            if (var2.getMac() == null) {
               var1.bindNull(18);
            } else {
               var1.bindText(18, var2.getMac());
            }

            if (var2.getMcuFirmware() == null) {
               var1.bindNull(19);
            } else {
               var1.bindText(19, var2.getMcuFirmware());
            }

            if (var2.getWifiFirmware() == null) {
               var1.bindNull(20);
            } else {
               var1.bindText(20, var2.getWifiFirmware());
            }

            if (var2.getHardware() == null) {
               var1.bindNull(21);
            } else {
               var1.bindText(21, var2.getHardware());
            }

            if (var2.getTimeZone() == null) {
               var1.bindNull(22);
            } else {
               var1.bindText(22, var2.getTimeZone());
            }

            if (var2.getSerial() == null) {
               var1.bindNull(23);
            } else {
               var1.bindText(23, var2.getSerial());
            }

            if (var2.getPurchaseDate() == null) {
               var1.bindNull(24);
            } else {
               var1.bindText(24, var2.getPurchaseDate());
            }

            if (var2.getDealerName() == null) {
               var1.bindNull(25);
            } else {
               var1.bindText(25, var2.getDealerName());
            }

            if (var2.getDealerCountry() == null) {
               var1.bindNull(26);
            } else {
               var1.bindText(26, var2.getDealerCountry());
            }

            if (var2.getFilterType() == null) {
               var1.bindNull(27);
            } else {
               var1.bindText(27, var2.getFilterType());
            }

            if (var2.getFilterTrigger() == null) {
               var1.bindNull(28);
            } else {
               var1.bindText(28, var2.getFilterTrigger());
            }

            String var3 = DoubleArrayConverter.fromDoubleArray(var2.getPm1Ranges());
            if (var3 == null) {
               var1.bindNull(29);
            } else {
               var1.bindText(29, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getPm10Ranges());
            if (var3 == null) {
               var1.bindNull(30);
            } else {
               var1.bindText(30, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getPm25Ranges());
            if (var3 == null) {
               var1.bindNull(31);
            } else {
               var1.bindText(31, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getVocRanges());
            if (var3 == null) {
               var1.bindNull(32);
            } else {
               var1.bindText(32, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getHchoRanges());
            if (var3 == null) {
               var1.bindNull(33);
            } else {
               var1.bindText(33, var3);
            }

            var1.bindLong(34, (long)var2.getUpdateProgress());
            var1.bindLong(35, (long)var2.isStandByOn());
            var1.bindLong(36, (long)var2.isEcoModeOn());
            var1.bindLong(37, (long)var2.isHinsModeOn());
            var1.bindLong(38, (long)var2.isHinsNightModeOn());
            var1.bindLong(39, (long)var2.isG4NightModeOn());
            var1.bindLong(40, (long)var2.isGermShieldOn());
            Boolean var10 = var2.isGermShieldNightModeOn();
            Object var4 = null;
            Integer var11;
            if (var10 == null) {
               var11 = null;
            } else {
               var11 = Integer.valueOf(var2.isGermShieldNightModeOn());
            }

            if (var11 == null) {
               var1.bindNull(41);
            } else {
               var1.bindLong(41, (long)var11);
            }

            var1.bindLong(42, (long)var2.isSafetySwitchOn());
            if (var2.getG4NightModefilterTrigger() == null) {
               var1.bindNull(43);
            } else {
               var1.bindText(43, var2.getG4NightModefilterTrigger());
            }

            var1.bindLong(44, (long)var2.getAimInstalled());
            if (var2.getSku() == null) {
               var1.bindNull(45);
            } else {
               var1.bindText(45, var2.getSku());
            }

            if (var2.getCompatibility() == null) {
               var1.bindNull(46);
            } else {
               var1.bindText(46, var2.getCompatibility());
            }

            if (var2.getLocationId() == null) {
               var1.bindNull(47);
            } else {
               var1.bindText(47, var2.getLocationId());
            }

            if (var2.getDisinfection() == null) {
               var11 = null;
            } else {
               var11 = Integer.valueOf(var2.getDisinfection());
            }

            if (var11 == null) {
               var1.bindNull(48);
            } else {
               var1.bindLong(48, (long)var11);
            }

            if (var2.getDisinfectLeftTime() == null) {
               var1.bindNull(49);
            } else {
               var1.bindLong(49, (long)var2.getDisinfectLeftTime());
            }

            if (var2.getDisinfectLeftTimeUpdateTime() == null) {
               var1.bindNull(50);
            } else {
               var1.bindLong(50, var2.getDisinfectLeftTimeUpdateTime());
            }

            var1.bindLong(51, (long)var2.getWickdryEnabled());
            var1.bindLong(52, (long)var2.getWickdryOn());
            var1.bindLong(53, (long)var2.getWickdryLeftTime());
            var1.bindLong(54, var2.getWickdryLeftTimeUpdateTime());
            var1.bindLong(55, (long)var2.getWickUsage());
            var1.bindLong(56, (long)var2.getWaterShortage());
            var1.bindLong(57, (long)var2.getAutoRh());
            var1.bindLong(58, (long)var2.getTimerStatus());
            var1.bindLong(59, (long)var2.getTimerDuration());
            var1.bindLong(60, (long)var2.getTimerLeftTime());
            var1.bindLong(61, var2.getTimerLeftTimeUpdateTime());
            var1.bindLong(62, (long)var2.getTemperatureUnit());
            var1.bindLong(63, (long)var2.getOscillationState());
            var1.bindLong(64, (long)var2.getOscillationAngle());
            var1.bindLong(65, (long)var2.getOscillationDirection());
            var1.bindLong(66, (long)var2.getOscillationFanSpeed());
            var1.bindLong(67, (long)var2.getMainMode());
            var1.bindLong(68, (long)var2.getApSubMode());
            var1.bindLong(69, (long)var2.getApFanSpeed());
            var1.bindLong(70, (long)var2.getHeatSubMode());
            var1.bindLong(71, (long)var2.getHeatFanSpeed());
            var1.bindDouble(72, var2.getHeatAutoTmp());
            var1.bindDouble(73, var2.getHeatEcoTmp());
            var1.bindLong(74, (long)var2.getCoolSubMode());
            var1.bindLong(75, (long)var2.getCoolFanSpeed());
            var1.bindLong(76, (long)var2.getCoolAutoTag());
            String var13 = DoubleArrayConverter.fromDoubleArray(var2.getCoolAutoPresets());
            if (var13 == null) {
               var1.bindNull(77);
            } else {
               var1.bindText(77, var13);
            }

            var1.bindLong(78, (long)var2.getCoolEcoTag());
            var13 = DoubleArrayConverter.fromDoubleArray(var2.getCoolEcoPresets());
            if (var13 == null) {
               var1.bindNull(79);
            } else {
               var1.bindText(79, var13);
            }

            var1.bindLong(80, (long)var2.getHumMode());
            var1.bindLong(81, (long)var2.getMode());
            var1.bindLong(82, (long)var2.getWaterLevel());
            var1.bindLong(83, (long)var2.getDehSubMode());
            var1.bindLong(84, (long)var2.getWaterTankFailure());
            var1.bindLong(85, (long)var2.getSmartSubMode());
            var1.bindLong(86, (long)var2.getDetectCat());
            var1.bindLong(87, (long)var2.getBodyMounted());
            var1.bindLong(88, (long)var2.getCleanAirEta());
            var1.bindLong(89, (long)var2.getPanelDisplayMode());
            var1.bindLong(90, (long)var2.getHoverEnabled());
            var1.bindLong(91, (long)var2.getAirRefreshEnabled());
            var1.bindLong(92, (long)var2.getAirRefreshStatus());
            var1.bindLong(93, (long)var2.getAirRefreshDuration());
            var1.bindLong(94, (long)var2.getAirRefreshTimeStamp());
            var1.bindLong(95, (long)var2.getAirRefreshStartTimeStamp());
            var1.bindLong(96, (long)var2.getAirRefreshEndTimeStamp());
            var1.bindLong(97, (long)var2.getRoomType());
            var1.bindLong(98, (long)var2.getNightLampBrightness());
            var1.bindLong(99, (long)var2.getWickdryDuration());
            var1.bindLong(100, (long)var2.getWickdryDone());
            Integer var15;
            if (var2.getYwrmEnabled() == null) {
               var15 = (Integer)var4;
            } else {
               var15 = Integer.valueOf(var2.getYwrmEnabled());
            }

            if (var15 == null) {
               var1.bindNull(101);
            } else {
               var1.bindLong(101, (long)var15);
            }

            var1.bindLong(102, (long)var2.getYwrmUsage());
            var1.bindLong(103, (long)var2.getNightLampSteplessBrightness());
            String var16 = DeviceAlarmListConverter.fromDeviceAlarmList(var2.getAlarms());
            if (var16 == null) {
               var1.bindNull(104);
            } else {
               var1.bindText(104, var16);
            }

            var1.bindLong(105, (long)var2.getHumSubMode());
            var1.bindLong(106, (long)var2.getUse24Hour());
            var1.bindLong(107, (long)var2.getWaterInfill());
            var1.bindLong(108, (long)var2.getSensorMode());
            var1.bindLong(109, (long)var2.getCoolFanSpeedLevel());
            var1.bindLong(110, (long)var2.getCoolAutoLevel());
            var1.bindLong(111, var2.getNightModeStartTime());
            var1.bindLong(112, (long)var2.getRpm1());
            var16 = DoubleArrayConverter.fromDoubleArray(var2.getNightPeriods());
            if (var16 == null) {
               var1.bindNull(113);
            } else {
               var1.bindText(113, var16);
            }

            DeviceUuidEntity var18 = var2.getDeviceUuid();
            if (var18 != null) {
               if (var18.getUuid() == null) {
                  var1.bindNull(114);
               } else {
                  var1.bindText(114, var18.getUuid());
               }

               if (var18.getSsid() == null) {
                  var1.bindNull(115);
               } else {
                  var1.bindText(115, var18.getSsid());
               }

               if (var18.getBssid() == null) {
                  var1.bindNull(116);
               } else {
                  var1.bindText(116, var18.getBssid());
               }

               if (var18.getIpv4() == null) {
                  var1.bindNull(117);
               } else {
                  var1.bindText(117, var18.getIpv4());
               }

               if (var18.getIpv6() == null) {
                  var1.bindNull(118);
               } else {
                  var1.bindText(118, var18.getIpv6());
               }
            } else {
               var1.bindNull(114);
               var1.bindNull(115);
               var1.bindNull(116);
               var1.bindNull(117);
               var1.bindNull(118);
            }

            IndoorDatapoint var19 = var2.getLatestSensorDatapoint();
            if (var19 != null) {
               var1.bindLong(119, var19.getTimeInSeconds());
               if (var19.getPm1() == null) {
                  var1.bindNull(120);
               } else {
                  var1.bindDouble(120, (double)var19.getPm1());
               }

               if (var19.getPm10() == null) {
                  var1.bindNull(121);
               } else {
                  var1.bindDouble(121, (double)var19.getPm10());
               }

               if (var19.getPm25() == null) {
                  var1.bindNull(122);
               } else {
                  var1.bindDouble(122, (double)var19.getPm25());
               }

               if (var19.getVoc() == null) {
                  var1.bindNull(123);
               } else {
                  var1.bindDouble(123, (double)var19.getVoc());
               }

               if (var19.getHcho() == null) {
                  var1.bindNull(124);
               } else {
                  var1.bindDouble(124, (double)var19.getHcho());
               }

               if (var19.getTmp() == null) {
                  var1.bindNull(125);
               } else {
                  var1.bindDouble(125, (double)var19.getTmp());
               }

               if (var19.getHum() == null) {
                  var1.bindNull(126);
               } else {
                  var1.bindDouble(126, (double)var19.getHum());
               }

               if (var19.getFan() == null) {
                  var1.bindNull(127);
               } else {
                  var1.bindDouble(127, (double)var19.getFan());
               }

               if (var19.getWeight() == null) {
                  var1.bindNull(128);
               } else {
                  var1.bindDouble(128, (double)var19.getWeight());
               }

               if (var19.getRpm() == null) {
                  var1.bindNull(129);
               } else {
                  var1.bindDouble(129, (double)var19.getRpm());
               }
            } else {
               var1.bindNull(119);
               var1.bindNull(120);
               var1.bindNull(121);
               var1.bindNull(122);
               var1.bindNull(123);
               var1.bindNull(124);
               var1.bindNull(125);
               var1.bindNull(126);
               var1.bindNull(127);
               var1.bindNull(128);
               var1.bindNull(129);
            }

            WelcomeHomeLocation var20 = var2.getWelcomeHome();
            if (var20 != null) {
               var1.bindDouble(130, var20.getLat());
               var1.bindDouble(131, var20.getLng());
               var1.bindLong(132, (long)var20.getRadius());
               if (var20.getTextValue() == null) {
                  var1.bindNull(133);
               } else {
                  var1.bindText(133, var20.getTextValue());
               }

               var1.bindLong(134, (long)var20.isEnabled());
            } else {
               var1.bindNull(130);
               var1.bindNull(131);
               var1.bindNull(132);
               var1.bindNull(133);
               var1.bindNull(134);
            }

            DualOscillationConfig var5 = var2.getDualOscillationConfig();
            var1.bindLong(135, (long)var5.getOscillationMode());
            var1.bindLong(136, (long)var5.getHorizontalOscillationState());
            var1.bindLong(137, (long)var5.getHorizontalOscillationFixAngle());
            var1.bindLong(138, (long)var5.getHorizontalOscillationMinAngle());
            var1.bindLong(139, (long)var5.getHorizontalOscillationMaxAngle());
            var1.bindLong(140, (long)var5.getVerticalOscillationState());
            var1.bindLong(141, (long)var5.getVerticalOscillationFixAngle());
            var1.bindLong(142, (long)var5.getVerticalOscillationMinAngle());
            var1.bindLong(143, (long)var5.getVerticalOscillationMaxAngle());
            var1.bindLong(144, (long)var5.getHorizontalCalibrationState());
            var1.bindLong(145, (long)var5.getVerticalCalibrationState());
         }

         protected String createQuery() {
            return "INSERT OR REPLACE INTO `device_table` (`uid`,`name`,`modelName`,`typeIndex`,`fanSpeed`,`filterLife`,`autoModeText`,`brightness`,`info`,`hasFinishedOnboarding`,`lastSelectedSensorType`,`isAblDevice`,`isNightModeOn`,`isChildLockOn`,`linkedDeviceUid`,`connectivityStatusIndex`,`lastConnectivityMillis`,`mac`,`mcuFirmware`,`wifiFirmware`,`hardware`,`timeZone`,`serial`,`purchaseDate`,`dealerName`,`dealerCountry`,`filterType`,`filterTrigger`,`pm1Ranges`,`pm10Ranges`,`pm25Ranges`,`vocRanges`,`hchoRanges`,`updateProgress`,`isStandByOn`,`isEcoModeOn`,`isHinsModeOn`,`isHinsNightModeOn`,`isG4NightModeOn`,`isGermShieldOn`,`isGermShieldNightModeOn`,`isSafetySwitchOn`,`g4NightModefilterTrigger`,`aimInstalled`,`sku`,`compatibility`,`locationId`,`disinfection`,`disinfectLeftTime`,`disinfectLeftTimeUpdateTime`,`wickdryEnabled`,`wickdryOn`,`wickdryLeftTime`,`wickdryLeftTimeUpdateTime`,`wickUsage`,`waterShortage`,`autoRh`,`timerStatus`,`timerDuration`,`timerLeftTime`,`timerLeftTimeUpdateTime`,`temperatureUnit`,`oscillationState`,`oscillationAngle`,`oscillationDirection`,`oscillationFanSpeed`,`mainMode`,`apSubMode`,`apFanSpeed`,`heatSubMode`,`heatFanSpeed`,`heatAutoTmp`,`heatEcoTmp`,`coolSubMode`,`coolFanSpeed`,`coolAutoTag`,`coolAutoPresets`,`coolEcoTag`,`coolEcoPresets`,`humMode`,`mode`,`waterLevel`,`dehSubMode`,`waterTankFailure`,`smartSubMode`,`detectCat`,`bodyMounted`,`cleanAirEta`,`panelDisplayMode`,`hoverEnabled`,`airRefreshEnabled`,`airRefreshStatus`,`airRefreshDuration`,`airRefreshTimeStamp`,`airRefreshStartTimeStamp`,`airRefreshEndTimeStamp`,`roomType`,`nightLampBrightness`,`wickdryDuration`,`wickdryDone`,`ywrmEnabled`,`ywrmUsage`,`nightLampSteplessBrightness`,`alarms`,`humSubMode`,`use24Hour`,`waterInfill`,`sensorMode`,`coolFanSpeedLevel`,`coolAutoLevel`,`nightModeStartTime`,`rpm1`,`nightPeriods`,`uuid`,`ssid`,`bssid`,`ipv4`,`ipv6`,`timeInSeconds`,`pm1`,`pm10`,`pm25`,`voc`,`hcho`,`tmp`,`hum`,`fan`,`weight`,`rpm`,`lat`,`lng`,`radius`,`textValue`,`isEnabled`,`oscillationMode`,`horizontalOscillationState`,`horizontalOscillationFixAngle`,`horizontalOscillationMinAngle`,`horizontalOscillationMaxAngle`,`verticalOscillationState`,`verticalOscillationFixAngle`,`verticalOscillationMinAngle`,`verticalOscillationMaxAngle`,`horizontalCalibrationState`,`verticalCalibrationState`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         }
      };
      this.__updateAdapterOfDeviceEntity = new EntityDeleteOrUpdateAdapter(this) {
         final DeviceDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, DeviceEntity var2) {
            if (var2.getUid() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getUid());
            }

            if (var2.getName() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getName());
            }

            if (var2.getModelName() == null) {
               var1.bindNull(3);
            } else {
               var1.bindText(3, var2.getModelName());
            }

            var1.bindLong(4, (long)var2.getTypeIndex());
            if (var2.getFanSpeed() == null) {
               var1.bindNull(5);
            } else {
               var1.bindLong(5, (long)var2.getFanSpeed());
            }

            if (var2.getFilterLife() == null) {
               var1.bindNull(6);
            } else {
               var1.bindLong(6, (long)var2.getFilterLife());
            }

            if (var2.getAutoModeText() == null) {
               var1.bindNull(7);
            } else {
               var1.bindText(7, var2.getAutoModeText());
            }

            if (var2.getBrightness() == null) {
               var1.bindNull(8);
            } else {
               var1.bindLong(8, (long)var2.getBrightness());
            }

            if (var2.getInfo() == null) {
               var1.bindNull(9);
            } else {
               var1.bindText(9, var2.getInfo());
            }

            var1.bindLong(10, (long)var2.getHasFinishedOnboarding());
            if (var2.getLastSelectedSensorType() == null) {
               var1.bindNull(11);
            } else {
               var1.bindLong(11, (long)var2.getLastSelectedSensorType());
            }

            var1.bindLong(12, (long)var2.isAblDevice());
            var1.bindLong(13, (long)var2.isNightModeOn());
            var1.bindLong(14, (long)var2.isChildLockOn());
            if (var2.getLinkedDeviceUid() == null) {
               var1.bindNull(15);
            } else {
               var1.bindText(15, var2.getLinkedDeviceUid());
            }

            var1.bindLong(16, (long)var2.getConnectivityStatusIndex());
            var1.bindLong(17, var2.getLastConnectivityMillis());
            if (var2.getMac() == null) {
               var1.bindNull(18);
            } else {
               var1.bindText(18, var2.getMac());
            }

            if (var2.getMcuFirmware() == null) {
               var1.bindNull(19);
            } else {
               var1.bindText(19, var2.getMcuFirmware());
            }

            if (var2.getWifiFirmware() == null) {
               var1.bindNull(20);
            } else {
               var1.bindText(20, var2.getWifiFirmware());
            }

            if (var2.getHardware() == null) {
               var1.bindNull(21);
            } else {
               var1.bindText(21, var2.getHardware());
            }

            if (var2.getTimeZone() == null) {
               var1.bindNull(22);
            } else {
               var1.bindText(22, var2.getTimeZone());
            }

            if (var2.getSerial() == null) {
               var1.bindNull(23);
            } else {
               var1.bindText(23, var2.getSerial());
            }

            if (var2.getPurchaseDate() == null) {
               var1.bindNull(24);
            } else {
               var1.bindText(24, var2.getPurchaseDate());
            }

            if (var2.getDealerName() == null) {
               var1.bindNull(25);
            } else {
               var1.bindText(25, var2.getDealerName());
            }

            if (var2.getDealerCountry() == null) {
               var1.bindNull(26);
            } else {
               var1.bindText(26, var2.getDealerCountry());
            }

            if (var2.getFilterType() == null) {
               var1.bindNull(27);
            } else {
               var1.bindText(27, var2.getFilterType());
            }

            if (var2.getFilterTrigger() == null) {
               var1.bindNull(28);
            } else {
               var1.bindText(28, var2.getFilterTrigger());
            }

            String var3 = DoubleArrayConverter.fromDoubleArray(var2.getPm1Ranges());
            if (var3 == null) {
               var1.bindNull(29);
            } else {
               var1.bindText(29, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getPm10Ranges());
            if (var3 == null) {
               var1.bindNull(30);
            } else {
               var1.bindText(30, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getPm25Ranges());
            if (var3 == null) {
               var1.bindNull(31);
            } else {
               var1.bindText(31, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getVocRanges());
            if (var3 == null) {
               var1.bindNull(32);
            } else {
               var1.bindText(32, var3);
            }

            var3 = DoubleArrayConverter.fromDoubleArray(var2.getHchoRanges());
            if (var3 == null) {
               var1.bindNull(33);
            } else {
               var1.bindText(33, var3);
            }

            var1.bindLong(34, (long)var2.getUpdateProgress());
            var1.bindLong(35, (long)var2.isStandByOn());
            var1.bindLong(36, (long)var2.isEcoModeOn());
            var1.bindLong(37, (long)var2.isHinsModeOn());
            var1.bindLong(38, (long)var2.isHinsNightModeOn());
            var1.bindLong(39, (long)var2.isG4NightModeOn());
            var1.bindLong(40, (long)var2.isGermShieldOn());
            Boolean var9 = var2.isGermShieldNightModeOn();
            Object var4 = null;
            Integer var10;
            if (var9 == null) {
               var10 = null;
            } else {
               var10 = Integer.valueOf(var2.isGermShieldNightModeOn());
            }

            if (var10 == null) {
               var1.bindNull(41);
            } else {
               var1.bindLong(41, (long)var10);
            }

            var1.bindLong(42, (long)var2.isSafetySwitchOn());
            if (var2.getG4NightModefilterTrigger() == null) {
               var1.bindNull(43);
            } else {
               var1.bindText(43, var2.getG4NightModefilterTrigger());
            }

            var1.bindLong(44, (long)var2.getAimInstalled());
            if (var2.getSku() == null) {
               var1.bindNull(45);
            } else {
               var1.bindText(45, var2.getSku());
            }

            if (var2.getCompatibility() == null) {
               var1.bindNull(46);
            } else {
               var1.bindText(46, var2.getCompatibility());
            }

            if (var2.getLocationId() == null) {
               var1.bindNull(47);
            } else {
               var1.bindText(47, var2.getLocationId());
            }

            if (var2.getDisinfection() == null) {
               var10 = null;
            } else {
               var10 = Integer.valueOf(var2.getDisinfection());
            }

            if (var10 == null) {
               var1.bindNull(48);
            } else {
               var1.bindLong(48, (long)var10);
            }

            if (var2.getDisinfectLeftTime() == null) {
               var1.bindNull(49);
            } else {
               var1.bindLong(49, (long)var2.getDisinfectLeftTime());
            }

            if (var2.getDisinfectLeftTimeUpdateTime() == null) {
               var1.bindNull(50);
            } else {
               var1.bindLong(50, var2.getDisinfectLeftTimeUpdateTime());
            }

            var1.bindLong(51, (long)var2.getWickdryEnabled());
            var1.bindLong(52, (long)var2.getWickdryOn());
            var1.bindLong(53, (long)var2.getWickdryLeftTime());
            var1.bindLong(54, var2.getWickdryLeftTimeUpdateTime());
            var1.bindLong(55, (long)var2.getWickUsage());
            var1.bindLong(56, (long)var2.getWaterShortage());
            var1.bindLong(57, (long)var2.getAutoRh());
            var1.bindLong(58, (long)var2.getTimerStatus());
            var1.bindLong(59, (long)var2.getTimerDuration());
            var1.bindLong(60, (long)var2.getTimerLeftTime());
            var1.bindLong(61, var2.getTimerLeftTimeUpdateTime());
            var1.bindLong(62, (long)var2.getTemperatureUnit());
            var1.bindLong(63, (long)var2.getOscillationState());
            var1.bindLong(64, (long)var2.getOscillationAngle());
            var1.bindLong(65, (long)var2.getOscillationDirection());
            var1.bindLong(66, (long)var2.getOscillationFanSpeed());
            var1.bindLong(67, (long)var2.getMainMode());
            var1.bindLong(68, (long)var2.getApSubMode());
            var1.bindLong(69, (long)var2.getApFanSpeed());
            var1.bindLong(70, (long)var2.getHeatSubMode());
            var1.bindLong(71, (long)var2.getHeatFanSpeed());
            var1.bindDouble(72, var2.getHeatAutoTmp());
            var1.bindDouble(73, var2.getHeatEcoTmp());
            var1.bindLong(74, (long)var2.getCoolSubMode());
            var1.bindLong(75, (long)var2.getCoolFanSpeed());
            var1.bindLong(76, (long)var2.getCoolAutoTag());
            String var12 = DoubleArrayConverter.fromDoubleArray(var2.getCoolAutoPresets());
            if (var12 == null) {
               var1.bindNull(77);
            } else {
               var1.bindText(77, var12);
            }

            var1.bindLong(78, (long)var2.getCoolEcoTag());
            var12 = DoubleArrayConverter.fromDoubleArray(var2.getCoolEcoPresets());
            if (var12 == null) {
               var1.bindNull(79);
            } else {
               var1.bindText(79, var12);
            }

            var1.bindLong(80, (long)var2.getHumMode());
            var1.bindLong(81, (long)var2.getMode());
            var1.bindLong(82, (long)var2.getWaterLevel());
            var1.bindLong(83, (long)var2.getDehSubMode());
            var1.bindLong(84, (long)var2.getWaterTankFailure());
            var1.bindLong(85, (long)var2.getSmartSubMode());
            var1.bindLong(86, (long)var2.getDetectCat());
            var1.bindLong(87, (long)var2.getBodyMounted());
            var1.bindLong(88, (long)var2.getCleanAirEta());
            var1.bindLong(89, (long)var2.getPanelDisplayMode());
            var1.bindLong(90, (long)var2.getHoverEnabled());
            var1.bindLong(91, (long)var2.getAirRefreshEnabled());
            var1.bindLong(92, (long)var2.getAirRefreshStatus());
            var1.bindLong(93, (long)var2.getAirRefreshDuration());
            var1.bindLong(94, (long)var2.getAirRefreshTimeStamp());
            var1.bindLong(95, (long)var2.getAirRefreshStartTimeStamp());
            var1.bindLong(96, (long)var2.getAirRefreshEndTimeStamp());
            var1.bindLong(97, (long)var2.getRoomType());
            var1.bindLong(98, (long)var2.getNightLampBrightness());
            var1.bindLong(99, (long)var2.getWickdryDuration());
            var1.bindLong(100, (long)var2.getWickdryDone());
            Integer var14;
            if (var2.getYwrmEnabled() == null) {
               var14 = (Integer)var4;
            } else {
               var14 = Integer.valueOf(var2.getYwrmEnabled());
            }

            if (var14 == null) {
               var1.bindNull(101);
            } else {
               var1.bindLong(101, (long)var14);
            }

            var1.bindLong(102, (long)var2.getYwrmUsage());
            var1.bindLong(103, (long)var2.getNightLampSteplessBrightness());
            String var15 = DeviceAlarmListConverter.fromDeviceAlarmList(var2.getAlarms());
            if (var15 == null) {
               var1.bindNull(104);
            } else {
               var1.bindText(104, var15);
            }

            var1.bindLong(105, (long)var2.getHumSubMode());
            var1.bindLong(106, (long)var2.getUse24Hour());
            var1.bindLong(107, (long)var2.getWaterInfill());
            var1.bindLong(108, (long)var2.getSensorMode());
            var1.bindLong(109, (long)var2.getCoolFanSpeedLevel());
            var1.bindLong(110, (long)var2.getCoolAutoLevel());
            var1.bindLong(111, var2.getNightModeStartTime());
            var1.bindLong(112, (long)var2.getRpm1());
            var15 = DoubleArrayConverter.fromDoubleArray(var2.getNightPeriods());
            if (var15 == null) {
               var1.bindNull(113);
            } else {
               var1.bindText(113, var15);
            }

            DeviceUuidEntity var17 = var2.getDeviceUuid();
            if (var17 != null) {
               if (var17.getUuid() == null) {
                  var1.bindNull(114);
               } else {
                  var1.bindText(114, var17.getUuid());
               }

               if (var17.getSsid() == null) {
                  var1.bindNull(115);
               } else {
                  var1.bindText(115, var17.getSsid());
               }

               if (var17.getBssid() == null) {
                  var1.bindNull(116);
               } else {
                  var1.bindText(116, var17.getBssid());
               }

               if (var17.getIpv4() == null) {
                  var1.bindNull(117);
               } else {
                  var1.bindText(117, var17.getIpv4());
               }

               if (var17.getIpv6() == null) {
                  var1.bindNull(118);
               } else {
                  var1.bindText(118, var17.getIpv6());
               }
            } else {
               var1.bindNull(114);
               var1.bindNull(115);
               var1.bindNull(116);
               var1.bindNull(117);
               var1.bindNull(118);
            }

            IndoorDatapoint var18 = var2.getLatestSensorDatapoint();
            if (var18 != null) {
               var1.bindLong(119, var18.getTimeInSeconds());
               if (var18.getPm1() == null) {
                  var1.bindNull(120);
               } else {
                  var1.bindDouble(120, (double)var18.getPm1());
               }

               if (var18.getPm10() == null) {
                  var1.bindNull(121);
               } else {
                  var1.bindDouble(121, (double)var18.getPm10());
               }

               if (var18.getPm25() == null) {
                  var1.bindNull(122);
               } else {
                  var1.bindDouble(122, (double)var18.getPm25());
               }

               if (var18.getVoc() == null) {
                  var1.bindNull(123);
               } else {
                  var1.bindDouble(123, (double)var18.getVoc());
               }

               if (var18.getHcho() == null) {
                  var1.bindNull(124);
               } else {
                  var1.bindDouble(124, (double)var18.getHcho());
               }

               if (var18.getTmp() == null) {
                  var1.bindNull(125);
               } else {
                  var1.bindDouble(125, (double)var18.getTmp());
               }

               if (var18.getHum() == null) {
                  var1.bindNull(126);
               } else {
                  var1.bindDouble(126, (double)var18.getHum());
               }

               if (var18.getFan() == null) {
                  var1.bindNull(127);
               } else {
                  var1.bindDouble(127, (double)var18.getFan());
               }

               if (var18.getWeight() == null) {
                  var1.bindNull(128);
               } else {
                  var1.bindDouble(128, (double)var18.getWeight());
               }

               if (var18.getRpm() == null) {
                  var1.bindNull(129);
               } else {
                  var1.bindDouble(129, (double)var18.getRpm());
               }
            } else {
               var1.bindNull(119);
               var1.bindNull(120);
               var1.bindNull(121);
               var1.bindNull(122);
               var1.bindNull(123);
               var1.bindNull(124);
               var1.bindNull(125);
               var1.bindNull(126);
               var1.bindNull(127);
               var1.bindNull(128);
               var1.bindNull(129);
            }

            WelcomeHomeLocation var19 = var2.getWelcomeHome();
            if (var19 != null) {
               var1.bindDouble(130, var19.getLat());
               var1.bindDouble(131, var19.getLng());
               var1.bindLong(132, (long)var19.getRadius());
               if (var19.getTextValue() == null) {
                  var1.bindNull(133);
               } else {
                  var1.bindText(133, var19.getTextValue());
               }

               var1.bindLong(134, (long)var19.isEnabled());
            } else {
               var1.bindNull(130);
               var1.bindNull(131);
               var1.bindNull(132);
               var1.bindNull(133);
               var1.bindNull(134);
            }

            DualOscillationConfig var20 = var2.getDualOscillationConfig();
            var1.bindLong(135, (long)var20.getOscillationMode());
            var1.bindLong(136, (long)var20.getHorizontalOscillationState());
            var1.bindLong(137, (long)var20.getHorizontalOscillationFixAngle());
            var1.bindLong(138, (long)var20.getHorizontalOscillationMinAngle());
            var1.bindLong(139, (long)var20.getHorizontalOscillationMaxAngle());
            var1.bindLong(140, (long)var20.getVerticalOscillationState());
            var1.bindLong(141, (long)var20.getVerticalOscillationFixAngle());
            var1.bindLong(142, (long)var20.getVerticalOscillationMinAngle());
            var1.bindLong(143, (long)var20.getVerticalOscillationMaxAngle());
            var1.bindLong(144, (long)var20.getHorizontalCalibrationState());
            var1.bindLong(145, (long)var20.getVerticalCalibrationState());
            if (var2.getUid() == null) {
               var1.bindNull(146);
            } else {
               var1.bindText(146, var2.getUid());
            }
         }

         protected String createQuery() {
            return "UPDATE OR REPLACE `device_table` SET `uid` = ?,`name` = ?,`modelName` = ?,`typeIndex` = ?,`fanSpeed` = ?,`filterLife` = ?,`autoModeText` = ?,`brightness` = ?,`info` = ?,`hasFinishedOnboarding` = ?,`lastSelectedSensorType` = ?,`isAblDevice` = ?,`isNightModeOn` = ?,`isChildLockOn` = ?,`linkedDeviceUid` = ?,`connectivityStatusIndex` = ?,`lastConnectivityMillis` = ?,`mac` = ?,`mcuFirmware` = ?,`wifiFirmware` = ?,`hardware` = ?,`timeZone` = ?,`serial` = ?,`purchaseDate` = ?,`dealerName` = ?,`dealerCountry` = ?,`filterType` = ?,`filterTrigger` = ?,`pm1Ranges` = ?,`pm10Ranges` = ?,`pm25Ranges` = ?,`vocRanges` = ?,`hchoRanges` = ?,`updateProgress` = ?,`isStandByOn` = ?,`isEcoModeOn` = ?,`isHinsModeOn` = ?,`isHinsNightModeOn` = ?,`isG4NightModeOn` = ?,`isGermShieldOn` = ?,`isGermShieldNightModeOn` = ?,`isSafetySwitchOn` = ?,`g4NightModefilterTrigger` = ?,`aimInstalled` = ?,`sku` = ?,`compatibility` = ?,`locationId` = ?,`disinfection` = ?,`disinfectLeftTime` = ?,`disinfectLeftTimeUpdateTime` = ?,`wickdryEnabled` = ?,`wickdryOn` = ?,`wickdryLeftTime` = ?,`wickdryLeftTimeUpdateTime` = ?,`wickUsage` = ?,`waterShortage` = ?,`autoRh` = ?,`timerStatus` = ?,`timerDuration` = ?,`timerLeftTime` = ?,`timerLeftTimeUpdateTime` = ?,`temperatureUnit` = ?,`oscillationState` = ?,`oscillationAngle` = ?,`oscillationDirection` = ?,`oscillationFanSpeed` = ?,`mainMode` = ?,`apSubMode` = ?,`apFanSpeed` = ?,`heatSubMode` = ?,`heatFanSpeed` = ?,`heatAutoTmp` = ?,`heatEcoTmp` = ?,`coolSubMode` = ?,`coolFanSpeed` = ?,`coolAutoTag` = ?,`coolAutoPresets` = ?,`coolEcoTag` = ?,`coolEcoPresets` = ?,`humMode` = ?,`mode` = ?,`waterLevel` = ?,`dehSubMode` = ?,`waterTankFailure` = ?,`smartSubMode` = ?,`detectCat` = ?,`bodyMounted` = ?,`cleanAirEta` = ?,`panelDisplayMode` = ?,`hoverEnabled` = ?,`airRefreshEnabled` = ?,`airRefreshStatus` = ?,`airRefreshDuration` = ?,`airRefreshTimeStamp` = ?,`airRefreshStartTimeStamp` = ?,`airRefreshEndTimeStamp` = ?,`roomType` = ?,`nightLampBrightness` = ?,`wickdryDuration` = ?,`wickdryDone` = ?,`ywrmEnabled` = ?,`ywrmUsage` = ?,`nightLampSteplessBrightness` = ?,`alarms` = ?,`humSubMode` = ?,`use24Hour` = ?,`waterInfill` = ?,`sensorMode` = ?,`coolFanSpeedLevel` = ?,`coolAutoLevel` = ?,`nightModeStartTime` = ?,`rpm1` = ?,`nightPeriods` = ?,`uuid` = ?,`ssid` = ?,`bssid` = ?,`ipv4` = ?,`ipv6` = ?,`timeInSeconds` = ?,`pm1` = ?,`pm10` = ?,`pm25` = ?,`voc` = ?,`hcho` = ?,`tmp` = ?,`hum` = ?,`fan` = ?,`weight` = ?,`rpm` = ?,`lat` = ?,`lng` = ?,`radius` = ?,`textValue` = ?,`isEnabled` = ?,`oscillationMode` = ?,`horizontalOscillationState` = ?,`horizontalOscillationFixAngle` = ?,`horizontalOscillationMinAngle` = ?,`horizontalOscillationMaxAngle` = ?,`verticalOscillationState` = ?,`verticalOscillationFixAngle` = ?,`verticalOscillationMinAngle` = ?,`verticalOscillationMaxAngle` = ?,`horizontalCalibrationState` = ?,`verticalCalibrationState` = ? WHERE `uid` = ?";
         }
      };
   }

   public static List getRequiredConverters() {
      return Collections.EMPTY_LIST;
   }

   // $FF: synthetic method
   static Object lambda$delete$110(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var15 = var1.prepare("DELETE FROM device_table WHERE uid = ?");
            if (var0 == null) {
               try {
                  var15.bindNull(1);
               } catch (Throwable var13) {
                  var10000 = var13;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var15.bindText(1, var0);
               } catch (Throwable var12) {
                  var10000 = var12;
                  boolean var16 = false;
                  break label98;
               }
            }

            label92:
            try {
               var15.step();
               break label99;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               break label92;
            }
         }

         Throwable var14 = var10000;
         var15.close();
         throw var14;
      }

      var15.close();
      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteAll$111(boolean var0, SQLiteConnection var1) {
      SQLiteStatement var7 = var1.prepare("DELETE FROM device_table WHERE isAblDevice = ?");
      long var2 = (long)var0;

      try {
         var7.bindLong(1, var2);
         var7.step();
      } finally {
         var7.close();
      }

      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteAll$112(SQLiteConnection var0) {
      SQLiteStatement var4 = var0.prepare("DELETE FROM device_table");

      try {
         var4.step();
      } finally {
         var4.close();
      }

      return null;
   }

   // $FF: synthetic method
   static Integer lambda$deleteLocationId$74(String var0, SQLiteConnection var1) {
      int var2;
      SQLiteStatement var3;
      label99: {
         Throwable var10000;
         label98: {
            var3 = var1.prepare("UPDATE device_table SET locationId = '' WHERE locationId = ?");
            if (var0 == null) {
               try {
                  var3.bindNull(1);
               } catch (Throwable var15) {
                  var10000 = var15;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var3.bindText(1, var0);
               } catch (Throwable var14) {
                  var10000 = var14;
                  boolean var17 = false;
                  break label98;
               }
            }

            label92:
            try {
               var3.step();
               var2 = SQLiteConnectionUtil.getTotalChangedRows(var1);
               break label99;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var18 = false;
               break label92;
            }
         }

         Throwable var16 = var10000;
         var3.close();
         throw var16;
      }

      var3.close();
      return var2;
   }

   // $FF: synthetic method
   static DeviceEntity lambda$device$7(String var0, SQLiteConnection var1) {
      SQLiteStatement var231;
      label197485: {
         Throwable var10000;
         label197487: {
            var231 = var1.prepare("SELECT * from device_table WHERE uid = ?");
            if (var0 == null) {
               try {
                  var231.bindNull(1);
               } catch (Throwable var23192) {
                  var10000 = var23192;
                  boolean var10001 = false;
                  break label197487;
               }
            } else {
               try {
                  var231.bindText(1, var0);
               } catch (Throwable var23191) {
                  var10000 = var23191;
                  boolean var23280 = false;
                  break label197487;
               }
            }

            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var152;
            int var153;
            int var154;
            boolean var155;
            try {
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "uid");
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "name");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "modelName");
               var152 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "typeIndex");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "fanSpeed");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterLife");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "autoModeText");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "brightness");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "info");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hasFinishedOnboarding");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lastSelectedSensorType");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isAblDevice");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isNightModeOn");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isChildLockOn");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "linkedDeviceUid");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "connectivityStatusIndex");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lastConnectivityMillis");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mac");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mcuFirmware");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wifiFirmware");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hardware");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timeZone");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "serial");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "purchaseDate");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dealerName");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dealerCountry");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterType");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterTrigger");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm1Ranges");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm10Ranges");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm25Ranges");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "vocRanges");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hchoRanges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "updateProgress");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isStandByOn");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isEcoModeOn");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isHinsModeOn");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isHinsNightModeOn");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isG4NightModeOn");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isGermShieldOn");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isGermShieldNightModeOn");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isSafetySwitchOn");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "g4NightModefilterTrigger");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "aimInstalled");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "sku");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "compatibility");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "locationId");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfection");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfectLeftTime");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfectLeftTimeUpdateTime");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryEnabled");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryOn");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryLeftTime");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryLeftTimeUpdateTime");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickUsage");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterShortage");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "autoRh");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerStatus");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerDuration");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerLeftTime");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerLeftTimeUpdateTime");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "temperatureUnit");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationState");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationAngle");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationDirection");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationFanSpeed");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mainMode");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "apSubMode");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "apFanSpeed");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatSubMode");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatFanSpeed");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatAutoTmp");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatEcoTmp");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolSubMode");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolFanSpeed");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoTag");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoPresets");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolEcoTag");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolEcoPresets");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "humMode");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mode");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterLevel");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dehSubMode");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterTankFailure");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "smartSubMode");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "detectCat");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "bodyMounted");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "cleanAirEta");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "panelDisplayMode");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hoverEnabled");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshEnabled");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshStatus");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshDuration");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshTimeStamp");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshStartTimeStamp");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshEndTimeStamp");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "roomType");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightLampBrightness");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryDuration");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryDone");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ywrmEnabled");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ywrmUsage");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightLampSteplessBrightness");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "alarms");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "humSubMode");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "use24Hour");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterInfill");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "sensorMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolFanSpeedLevel");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoLevel");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightModeStartTime");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "rpm1");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightPeriods");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "uuid");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ssid");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "bssid");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ipv4");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ipv6");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timeInSeconds");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm1");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm10");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm25");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "voc");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hcho");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "tmp");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hum");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "fan");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "weight");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "rpm");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lat");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lng");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "radius");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "textValue");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isEnabled");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationMode");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationState");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationFixAngle");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationMinAngle");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationMaxAngle");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationState");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationFixAngle");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationMinAngle");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationMaxAngle");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalCalibrationState");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalCalibrationState");
               var155 = var231.step();
            } catch (Throwable var23190) {
               var10000 = var23190;
               boolean var23281 = false;
               break label197487;
            }

            var23193 = null;
            Object var229 = null;
            if (!var155) {
               break label197485;
            }

            label197473: {
               label197472: {
                  try {
                     if (var231.isNull(var154)) {
                        break label197472;
                     }
                  } catch (Throwable var23189) {
                     var10000 = var23189;
                     boolean var23282 = false;
                     break label197487;
                  }

                  try {
                     var0 = var231.getText(var154);
                     break label197473;
                  } catch (Throwable var23188) {
                     var10000 = var23188;
                     boolean var23283 = false;
                     break label197487;
                  }
               }

               var0 = null;
            }

            label197464: {
               label197463: {
                  try {
                     if (var231.isNull(var153)) {
                        break label197463;
                     }
                  } catch (Throwable var23187) {
                     var10000 = var23187;
                     boolean var23284 = false;
                     break label197487;
                  }

                  try {
                     var23196 = var231.getText(var153);
                     break label197464;
                  } catch (Throwable var23186) {
                     var10000 = var23186;
                     boolean var23285 = false;
                     break label197487;
                  }
               }

               var23196 = null;
            }

            String var190;
            label197455: {
               label197454: {
                  try {
                     if (var231.isNull(var13)) {
                        break label197454;
                     }
                  } catch (Throwable var23185) {
                     var10000 = var23185;
                     boolean var23286 = false;
                     break label197487;
                  }

                  try {
                     var190 = var231.getText(var13);
                     break label197455;
                  } catch (Throwable var23184) {
                     var10000 = var23184;
                     boolean var23287 = false;
                     break label197487;
                  }
               }

               var190 = null;
            }

            Integer var191;
            label197446: {
               label197445: {
                  try {
                     var13 = (int)var231.getLong(var152);
                     if (var231.isNull(var141)) {
                        break label197445;
                     }
                  } catch (Throwable var23183) {
                     var10000 = var23183;
                     boolean var23288 = false;
                     break label197487;
                  }

                  try {
                     var191 = (int)var231.getLong(var141);
                     break label197446;
                  } catch (Throwable var23182) {
                     var10000 = var23182;
                     boolean var23289 = false;
                     break label197487;
                  }
               }

               var191 = null;
            }

            Integer var192;
            label197437: {
               label197436: {
                  try {
                     if (var231.isNull(var142)) {
                        break label197436;
                     }
                  } catch (Throwable var23181) {
                     var10000 = var23181;
                     boolean var23290 = false;
                     break label197487;
                  }

                  try {
                     var192 = (int)var231.getLong(var142);
                     break label197437;
                  } catch (Throwable var23180) {
                     var10000 = var23180;
                     boolean var23291 = false;
                     break label197487;
                  }
               }

               var192 = null;
            }

            String var193;
            label197428: {
               label197427: {
                  try {
                     if (var231.isNull(var145)) {
                        break label197427;
                     }
                  } catch (Throwable var23179) {
                     var10000 = var23179;
                     boolean var23292 = false;
                     break label197487;
                  }

                  try {
                     var193 = var231.getText(var145);
                     break label197428;
                  } catch (Throwable var23178) {
                     var10000 = var23178;
                     boolean var23293 = false;
                     break label197487;
                  }
               }

               var193 = null;
            }

            Integer var194;
            label197419: {
               label197418: {
                  try {
                     if (var231.isNull(var143)) {
                        break label197418;
                     }
                  } catch (Throwable var23177) {
                     var10000 = var23177;
                     boolean var23294 = false;
                     break label197487;
                  }

                  try {
                     var194 = (int)var231.getLong(var143);
                     break label197419;
                  } catch (Throwable var23176) {
                     var10000 = var23176;
                     boolean var23295 = false;
                     break label197487;
                  }
               }

               var194 = null;
            }

            String var195;
            label197410: {
               label197409: {
                  try {
                     if (var231.isNull(var48)) {
                        break label197409;
                     }
                  } catch (Throwable var23175) {
                     var10000 = var23175;
                     boolean var23296 = false;
                     break label197487;
                  }

                  try {
                     var195 = var231.getText(var48);
                     break label197410;
                  } catch (Throwable var23174) {
                     var10000 = var23174;
                     boolean var23297 = false;
                     break label197487;
                  }
               }

               var195 = null;
            }

            label197401: {
               label197400: {
                  try {
                     if ((int)var231.getLong(var150) != 0) {
                        break label197400;
                     }
                  } catch (Throwable var23173) {
                     var10000 = var23173;
                     boolean var23298 = false;
                     break label197487;
                  }

                  var155 = false;
                  break label197401;
               }

               var155 = true;
            }

            Integer var196;
            label197393: {
               label197392: {
                  try {
                     if (var231.isNull(var147)) {
                        break label197392;
                     }
                  } catch (Throwable var23172) {
                     var10000 = var23172;
                     boolean var23299 = false;
                     break label197487;
                  }

                  try {
                     var196 = (int)var231.getLong(var147);
                     break label197393;
                  } catch (Throwable var23171) {
                     var10000 = var23171;
                     boolean var23300 = false;
                     break label197487;
                  }
               }

               var196 = null;
            }

            boolean var156;
            label197384: {
               label197383: {
                  try {
                     if ((int)var231.getLong(var149) != 0) {
                        break label197383;
                     }
                  } catch (Throwable var23170) {
                     var10000 = var23170;
                     boolean var23301 = false;
                     break label197487;
                  }

                  var156 = false;
                  break label197384;
               }

               var156 = true;
            }

            boolean var157;
            label197376: {
               label197375: {
                  try {
                     if ((int)var231.getLong(var144) != 0) {
                        break label197375;
                     }
                  } catch (Throwable var23169) {
                     var10000 = var23169;
                     boolean var23302 = false;
                     break label197487;
                  }

                  var157 = false;
                  break label197376;
               }

               var157 = true;
            }

            boolean var158;
            label197368: {
               label197367: {
                  try {
                     if ((int)var231.getLong(var146) != 0) {
                        break label197367;
                     }
                  } catch (Throwable var23168) {
                     var10000 = var23168;
                     boolean var23303 = false;
                     break label197487;
                  }

                  var158 = false;
                  break label197368;
               }

               var158 = true;
            }

            String var197;
            label197360: {
               label197359: {
                  try {
                     if (var231.isNull(var151)) {
                        break label197359;
                     }
                  } catch (Throwable var23167) {
                     var10000 = var23167;
                     boolean var23304 = false;
                     break label197487;
                  }

                  try {
                     var197 = var231.getText(var151);
                     break label197360;
                  } catch (Throwable var23166) {
                     var10000 = var23166;
                     boolean var23305 = false;
                     break label197487;
                  }
               }

               var197 = null;
            }

            long var180;
            String var198;
            label197351: {
               label197350: {
                  try {
                     var48 = (int)var231.getLong(var148);
                     var180 = var231.getLong(var125);
                     if (var231.isNull(var79)) {
                        break label197350;
                     }
                  } catch (Throwable var23165) {
                     var10000 = var23165;
                     boolean var23306 = false;
                     break label197487;
                  }

                  try {
                     var198 = var231.getText(var79);
                     break label197351;
                  } catch (Throwable var23164) {
                     var10000 = var23164;
                     boolean var23307 = false;
                     break label197487;
                  }
               }

               var198 = null;
            }

            String var199;
            label197342: {
               label197341: {
                  try {
                     if (var231.isNull(var135)) {
                        break label197341;
                     }
                  } catch (Throwable var23163) {
                     var10000 = var23163;
                     boolean var23308 = false;
                     break label197487;
                  }

                  try {
                     var199 = var231.getText(var135);
                     break label197342;
                  } catch (Throwable var23162) {
                     var10000 = var23162;
                     boolean var23309 = false;
                     break label197487;
                  }
               }

               var199 = null;
            }

            String var200;
            label197333: {
               label197332: {
                  try {
                     if (var231.isNull(var134)) {
                        break label197332;
                     }
                  } catch (Throwable var23161) {
                     var10000 = var23161;
                     boolean var23310 = false;
                     break label197487;
                  }

                  try {
                     var200 = var231.getText(var134);
                     break label197333;
                  } catch (Throwable var23160) {
                     var10000 = var23160;
                     boolean var23311 = false;
                     break label197487;
                  }
               }

               var200 = null;
            }

            String var201;
            label197324: {
               label197323: {
                  try {
                     if (var231.isNull(var140)) {
                        break label197323;
                     }
                  } catch (Throwable var23159) {
                     var10000 = var23159;
                     boolean var23312 = false;
                     break label197487;
                  }

                  try {
                     var201 = var231.getText(var140);
                     break label197324;
                  } catch (Throwable var23158) {
                     var10000 = var23158;
                     boolean var23313 = false;
                     break label197487;
                  }
               }

               var201 = null;
            }

            String var202;
            label197315: {
               label197314: {
                  try {
                     if (var231.isNull(var132)) {
                        break label197314;
                     }
                  } catch (Throwable var23157) {
                     var10000 = var23157;
                     boolean var23314 = false;
                     break label197487;
                  }

                  try {
                     var202 = var231.getText(var132);
                     break label197315;
                  } catch (Throwable var23156) {
                     var10000 = var23156;
                     boolean var23315 = false;
                     break label197487;
                  }
               }

               var202 = null;
            }

            String var203;
            label197306: {
               label197305: {
                  try {
                     if (var231.isNull(var130)) {
                        break label197305;
                     }
                  } catch (Throwable var23155) {
                     var10000 = var23155;
                     boolean var23316 = false;
                     break label197487;
                  }

                  try {
                     var203 = var231.getText(var130);
                     break label197306;
                  } catch (Throwable var23154) {
                     var10000 = var23154;
                     boolean var23317 = false;
                     break label197487;
                  }
               }

               var203 = null;
            }

            String var204;
            label197297: {
               label197296: {
                  try {
                     if (var231.isNull(var137)) {
                        break label197296;
                     }
                  } catch (Throwable var23153) {
                     var10000 = var23153;
                     boolean var23318 = false;
                     break label197487;
                  }

                  try {
                     var204 = var231.getText(var137);
                     break label197297;
                  } catch (Throwable var23152) {
                     var10000 = var23152;
                     boolean var23319 = false;
                     break label197487;
                  }
               }

               var204 = null;
            }

            String var205;
            label197288: {
               label197287: {
                  try {
                     if (var231.isNull(var131)) {
                        break label197287;
                     }
                  } catch (Throwable var23151) {
                     var10000 = var23151;
                     boolean var23320 = false;
                     break label197487;
                  }

                  try {
                     var205 = var231.getText(var131);
                     break label197288;
                  } catch (Throwable var23150) {
                     var10000 = var23150;
                     boolean var23321 = false;
                     break label197487;
                  }
               }

               var205 = null;
            }

            String var206;
            label197279: {
               label197278: {
                  try {
                     if (var231.isNull(var126)) {
                        break label197278;
                     }
                  } catch (Throwable var23149) {
                     var10000 = var23149;
                     boolean var23322 = false;
                     break label197487;
                  }

                  try {
                     var206 = var231.getText(var126);
                     break label197279;
                  } catch (Throwable var23148) {
                     var10000 = var23148;
                     boolean var23323 = false;
                     break label197487;
                  }
               }

               var206 = null;
            }

            String var207;
            label197270: {
               label197269: {
                  try {
                     if (var231.isNull(var127)) {
                        break label197269;
                     }
                  } catch (Throwable var23147) {
                     var10000 = var23147;
                     boolean var23324 = false;
                     break label197487;
                  }

                  try {
                     var207 = var231.getText(var127);
                     break label197270;
                  } catch (Throwable var23146) {
                     var10000 = var23146;
                     boolean var23325 = false;
                     break label197487;
                  }
               }

               var207 = null;
            }

            String var208;
            label197261: {
               label197260: {
                  try {
                     if (var231.isNull(var124)) {
                        break label197260;
                     }
                  } catch (Throwable var23145) {
                     var10000 = var23145;
                     boolean var23326 = false;
                     break label197487;
                  }

                  try {
                     var208 = var231.getText(var124);
                     break label197261;
                  } catch (Throwable var23144) {
                     var10000 = var23144;
                     boolean var23327 = false;
                     break label197487;
                  }
               }

               var208 = null;
            }

            String var209;
            label197252: {
               label197251: {
                  try {
                     if (var231.isNull(var133)) {
                        break label197251;
                     }
                  } catch (Throwable var23143) {
                     var10000 = var23143;
                     boolean var23328 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var133);
                     break label197252;
                  } catch (Throwable var23142) {
                     var10000 = var23142;
                     boolean var23329 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var232;
            label197243: {
               label197242: {
                  try {
                     var232 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var139)) {
                        break label197242;
                     }
                  } catch (Throwable var23141) {
                     var10000 = var23141;
                     boolean var23330 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var139);
                     break label197243;
                  } catch (Throwable var23140) {
                     var10000 = var23140;
                     boolean var23331 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var233;
            label197234: {
               label197233: {
                  try {
                     var233 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var128)) {
                        break label197233;
                     }
                  } catch (Throwable var23139) {
                     var10000 = var23139;
                     boolean var23332 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var128);
                     break label197234;
                  } catch (Throwable var23138) {
                     var10000 = var23138;
                     boolean var23333 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var234;
            label197225: {
               label197224: {
                  try {
                     var234 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var136)) {
                        break label197224;
                     }
                  } catch (Throwable var23137) {
                     var10000 = var23137;
                     boolean var23334 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var136);
                     break label197225;
                  } catch (Throwable var23136) {
                     var10000 = var23136;
                     boolean var23335 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var235;
            label197216: {
               label197215: {
                  try {
                     var235 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var129)) {
                        break label197215;
                     }
                  } catch (Throwable var23135) {
                     var10000 = var23135;
                     boolean var23336 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var129);
                     break label197216;
                  } catch (Throwable var23134) {
                     var10000 = var23134;
                     boolean var23337 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            boolean var159;
            double[] var236;
            label197207: {
               label197206: {
                  try {
                     var236 = DoubleArrayConverter.fromString(var209);
                     var79 = (int)var231.getLong(var138);
                     if ((int)var231.getLong(var106) != 0) {
                        break label197206;
                     }
                  } catch (Throwable var23133) {
                     var10000 = var23133;
                     boolean var23338 = false;
                     break label197487;
                  }

                  var159 = false;
                  break label197207;
               }

               var159 = true;
            }

            boolean var160;
            label197199: {
               label197198: {
                  try {
                     if ((int)var231.getLong(var110) != 0) {
                        break label197198;
                     }
                  } catch (Throwable var23132) {
                     var10000 = var23132;
                     boolean var23339 = false;
                     break label197487;
                  }

                  var160 = false;
                  break label197199;
               }

               var160 = true;
            }

            boolean var161;
            label197191: {
               label197190: {
                  try {
                     if ((int)var231.getLong(var111) != 0) {
                        break label197190;
                     }
                  } catch (Throwable var23131) {
                     var10000 = var23131;
                     boolean var23340 = false;
                     break label197487;
                  }

                  var161 = false;
                  break label197191;
               }

               var161 = true;
            }

            boolean var162;
            label197183: {
               label197182: {
                  try {
                     if ((int)var231.getLong(var114) != 0) {
                        break label197182;
                     }
                  } catch (Throwable var23130) {
                     var10000 = var23130;
                     boolean var23341 = false;
                     break label197487;
                  }

                  var162 = false;
                  break label197183;
               }

               var162 = true;
            }

            boolean var163;
            label197175: {
               label197174: {
                  try {
                     if ((int)var231.getLong(var107) != 0) {
                        break label197174;
                     }
                  } catch (Throwable var23129) {
                     var10000 = var23129;
                     boolean var23342 = false;
                     break label197487;
                  }

                  var163 = false;
                  break label197175;
               }

               var163 = true;
            }

            boolean var164;
            label197167: {
               label197166: {
                  try {
                     if ((int)var231.getLong(var121) != 0) {
                        break label197166;
                     }
                  } catch (Throwable var23128) {
                     var10000 = var23128;
                     boolean var23343 = false;
                     break label197487;
                  }

                  var164 = false;
                  break label197167;
               }

               var164 = true;
            }

            label197159: {
               label197158: {
                  try {
                     if (var231.isNull(var120)) {
                        break label197158;
                     }
                  } catch (Throwable var23127) {
                     var10000 = var23127;
                     boolean var23344 = false;
                     break label197487;
                  }

                  try {
                     var23261 = (int)var231.getLong(var120);
                     break label197159;
                  } catch (Throwable var23126) {
                     var10000 = var23126;
                     boolean var23345 = false;
                     break label197487;
                  }
               }

               var23261 = null;
            }

            Boolean var23262;
            if (var23261 == null) {
               var23262 = null;
            } else {
               boolean var165;
               label197148: {
                  label197147: {
                     try {
                        if (var23261 != 0) {
                           break label197147;
                        }
                     } catch (Throwable var23125) {
                        var10000 = var23125;
                        boolean var23346 = false;
                        break label197487;
                     }

                     var165 = false;
                     break label197148;
                  }

                  var165 = true;
               }

               try {
                  var23262 = var165;
               } catch (Throwable var23124) {
                  var10000 = var23124;
                  boolean var23347 = false;
                  break label197487;
               }
            }

            boolean var23254;
            label197139: {
               label197138: {
                  try {
                     if ((int)var231.getLong(var108) != 0) {
                        break label197138;
                     }
                  } catch (Throwable var23123) {
                     var10000 = var23123;
                     boolean var23348 = false;
                     break label197487;
                  }

                  var23254 = false;
                  break label197139;
               }

               var23254 = true;
            }

            String var210;
            label197131: {
               label197130: {
                  try {
                     if (var231.isNull(var118)) {
                        break label197130;
                     }
                  } catch (Throwable var23122) {
                     var10000 = var23122;
                     boolean var23349 = false;
                     break label197487;
                  }

                  try {
                     var210 = var231.getText(var118);
                     break label197131;
                  } catch (Throwable var23121) {
                     var10000 = var23121;
                     boolean var23350 = false;
                     break label197487;
                  }
               }

               var210 = null;
            }

            boolean var166;
            label197122: {
               label197121: {
                  try {
                     if ((int)var231.getLong(var123) != 0) {
                        break label197121;
                     }
                  } catch (Throwable var23120) {
                     var10000 = var23120;
                     boolean var23351 = false;
                     break label197487;
                  }

                  var166 = false;
                  break label197122;
               }

               var166 = true;
            }

            String var211;
            label197114: {
               label197113: {
                  try {
                     if (var231.isNull(var116)) {
                        break label197113;
                     }
                  } catch (Throwable var23119) {
                     var10000 = var23119;
                     boolean var23352 = false;
                     break label197487;
                  }

                  try {
                     var211 = var231.getText(var116);
                     break label197114;
                  } catch (Throwable var23118) {
                     var10000 = var23118;
                     boolean var23353 = false;
                     break label197487;
                  }
               }

               var211 = null;
            }

            String var212;
            label197105: {
               label197104: {
                  try {
                     if (var231.isNull(var115)) {
                        break label197104;
                     }
                  } catch (Throwable var23117) {
                     var10000 = var23117;
                     boolean var23354 = false;
                     break label197487;
                  }

                  try {
                     var212 = var231.getText(var115);
                     break label197105;
                  } catch (Throwable var23116) {
                     var10000 = var23116;
                     boolean var23355 = false;
                     break label197487;
                  }
               }

               var212 = null;
            }

            String var213;
            label197096: {
               label197095: {
                  try {
                     if (var231.isNull(var117)) {
                        break label197095;
                     }
                  } catch (Throwable var23115) {
                     var10000 = var23115;
                     boolean var23356 = false;
                     break label197487;
                  }

                  try {
                     var213 = var231.getText(var117);
                     break label197096;
                  } catch (Throwable var23114) {
                     var10000 = var23114;
                     boolean var23357 = false;
                     break label197487;
                  }
               }

               var213 = null;
            }

            Integer var214;
            label197087: {
               label197086: {
                  try {
                     if (var231.isNull(var109)) {
                        break label197086;
                     }
                  } catch (Throwable var23113) {
                     var10000 = var23113;
                     boolean var23358 = false;
                     break label197487;
                  }

                  try {
                     var214 = (int)var231.getLong(var109);
                     break label197087;
                  } catch (Throwable var23112) {
                     var10000 = var23112;
                     boolean var23359 = false;
                     break label197487;
                  }
               }

               var214 = null;
            }

            Boolean var23263;
            if (var214 == null) {
               var23263 = null;
            } else {
               boolean var167;
               label197076: {
                  label197075: {
                     try {
                        if (var214 != 0) {
                           break label197075;
                        }
                     } catch (Throwable var23111) {
                        var10000 = var23111;
                        boolean var23360 = false;
                        break label197487;
                     }

                     var167 = false;
                     break label197076;
                  }

                  var167 = true;
               }

               try {
                  var23263 = var167;
               } catch (Throwable var23110) {
                  var10000 = var23110;
                  boolean var23361 = false;
                  break label197487;
               }
            }

            Integer var215;
            label197067: {
               label197066: {
                  try {
                     if (var231.isNull(var113)) {
                        break label197066;
                     }
                  } catch (Throwable var23109) {
                     var10000 = var23109;
                     boolean var23362 = false;
                     break label197487;
                  }

                  try {
                     var215 = (int)var231.getLong(var113);
                     break label197067;
                  } catch (Throwable var23108) {
                     var10000 = var23108;
                     boolean var23363 = false;
                     break label197487;
                  }
               }

               var215 = null;
            }

            Long var216;
            label197058: {
               label197057: {
                  try {
                     if (var231.isNull(var119)) {
                        break label197057;
                     }
                  } catch (Throwable var23107) {
                     var10000 = var23107;
                     boolean var23364 = false;
                     break label197487;
                  }

                  try {
                     var216 = var231.getLong(var119);
                     break label197058;
                  } catch (Throwable var23106) {
                     var10000 = var23106;
                     boolean var23365 = false;
                     break label197487;
                  }
               }

               var216 = null;
            }

            boolean var23255;
            label197049: {
               label197048: {
                  try {
                     if ((int)var231.getLong(var112) != 0) {
                        break label197048;
                     }
                  } catch (Throwable var23105) {
                     var10000 = var23105;
                     boolean var23366 = false;
                     break label197487;
                  }

                  var23255 = false;
                  break label197049;
               }

               var23255 = true;
            }

            boolean var168;
            label197041: {
               label197040: {
                  try {
                     if ((int)var231.getLong(var122) != 0) {
                        break label197040;
                     }
                  } catch (Throwable var23104) {
                     var10000 = var23104;
                     boolean var23367 = false;
                     break label197487;
                  }

                  var168 = false;
                  break label197041;
               }

               var168 = true;
            }

            boolean var169;
            long var182;
            label197033: {
               label197032: {
                  try {
                     var105 = (int)var231.getLong(var105);
                     var182 = var231.getLong(var103);
                     var103 = (int)var231.getLong(var104);
                     if ((int)var231.getLong(var102) != 0) {
                        break label197032;
                     }
                  } catch (Throwable var23103) {
                     var10000 = var23103;
                     boolean var23368 = false;
                     break label197487;
                  }

                  var169 = false;
                  break label197033;
               }

               var169 = true;
            }

            double var4;
            double var6;
            long var188;
            String var217;
            label197025: {
               label197024: {
                  try {
                     var101 = (int)var231.getLong(var101);
                     var100 = (int)var231.getLong(var100);
                     var99 = (int)var231.getLong(var99);
                     var98 = (int)var231.getLong(var98);
                     var188 = var231.getLong(var97);
                     var96 = (int)var231.getLong(var96);
                     var95 = (int)var231.getLong(var95);
                     var94 = (int)var231.getLong(var94);
                     var93 = (int)var231.getLong(var93);
                     var92 = (int)var231.getLong(var92);
                     var91 = (int)var231.getLong(var91);
                     var90 = (int)var231.getLong(var90);
                     var89 = (int)var231.getLong(var89);
                     var88 = (int)var231.getLong(var88);
                     var87 = (int)var231.getLong(var87);
                     var4 = var231.getDouble(var84);
                     var6 = var231.getDouble(var86);
                     var84 = (int)var231.getLong(var85);
                     var83 = (int)var231.getLong(var83);
                     var82 = (int)var231.getLong(var82);
                     if (var231.isNull(var80)) {
                        break label197024;
                     }
                  } catch (Throwable var23102) {
                     var10000 = var23102;
                     boolean var23369 = false;
                     break label197487;
                  }

                  try {
                     var217 = var231.getText(var80);
                     break label197025;
                  } catch (Throwable var23101) {
                     var10000 = var23101;
                     boolean var23370 = false;
                     break label197487;
                  }
               }

               var217 = null;
            }

            double[] var237;
            label197016: {
               label197015: {
                  try {
                     var237 = DoubleArrayConverter.fromString(var217);
                     var80 = (int)var231.getLong(var81);
                     if (var231.isNull(var78)) {
                        break label197015;
                     }
                  } catch (Throwable var23100) {
                     var10000 = var23100;
                     boolean var23371 = false;
                     break label197487;
                  }

                  try {
                     var217 = var231.getText(var78);
                     break label197016;
                  } catch (Throwable var23099) {
                     var10000 = var23099;
                     boolean var23372 = false;
                     break label197487;
                  }
               }

               var217 = null;
            }

            boolean var170;
            double[] var238;
            label197007: {
               label197006: {
                  try {
                     var238 = DoubleArrayConverter.fromString(var217);
                     if ((int)var231.getLong(var77) != 0) {
                        break label197006;
                     }
                  } catch (Throwable var23098) {
                     var10000 = var23098;
                     boolean var23373 = false;
                     break label197487;
                  }

                  var170 = false;
                  break label197007;
               }

               var170 = true;
            }

            boolean var171;
            label196999: {
               label196998: {
                  try {
                     var76 = (int)var231.getLong(var76);
                     var75 = (int)var231.getLong(var75);
                     var74 = (int)var231.getLong(var74);
                     if ((int)var231.getLong(var73) != 0) {
                        break label196998;
                     }
                  } catch (Throwable var23097) {
                     var10000 = var23097;
                     boolean var23374 = false;
                     break label197487;
                  }

                  var171 = false;
                  break label196999;
               }

               var171 = true;
            }

            boolean var172;
            label196991: {
               label196990: {
                  try {
                     var72 = (int)var231.getLong(var72);
                     if ((int)var231.getLong(var71) != 0) {
                        break label196990;
                     }
                  } catch (Throwable var23096) {
                     var10000 = var23096;
                     boolean var23375 = false;
                     break label197487;
                  }

                  var172 = false;
                  break label196991;
               }

               var172 = true;
            }

            boolean var173;
            label196983: {
               label196982: {
                  try {
                     if ((int)var231.getLong(var69) != 0) {
                        break label196982;
                     }
                  } catch (Throwable var23095) {
                     var10000 = var23095;
                     boolean var23376 = false;
                     break label197487;
                  }

                  var173 = false;
                  break label196983;
               }

               var173 = true;
            }

            boolean var174;
            label196975: {
               label196974: {
                  try {
                     var69 = (int)var231.getLong(var70);
                     var68 = (int)var231.getLong(var68);
                     if ((int)var231.getLong(var67) != 0) {
                        break label196974;
                     }
                  } catch (Throwable var23094) {
                     var10000 = var23094;
                     boolean var23377 = false;
                     break label197487;
                  }

                  var174 = false;
                  break label196975;
               }

               var174 = true;
            }

            boolean var175;
            label196967: {
               label196966: {
                  try {
                     if ((int)var231.getLong(var66) != 0) {
                        break label196966;
                     }
                  } catch (Throwable var23093) {
                     var10000 = var23093;
                     boolean var23378 = false;
                     break label197487;
                  }

                  var175 = false;
                  break label196967;
               }

               var175 = true;
            }

            boolean var176;
            label196959: {
               label196958: {
                  try {
                     var65 = (int)var231.getLong(var65);
                     var64 = (int)var231.getLong(var64);
                     var63 = (int)var231.getLong(var63);
                     var62 = (int)var231.getLong(var62);
                     var61 = (int)var231.getLong(var61);
                     var60 = (int)var231.getLong(var60);
                     var59 = (int)var231.getLong(var59);
                     var58 = (int)var231.getLong(var58);
                     if ((int)var231.getLong(var57) != 0) {
                        break label196958;
                     }
                  } catch (Throwable var23092) {
                     var10000 = var23092;
                     boolean var23379 = false;
                     break label197487;
                  }

                  var176 = false;
                  break label196959;
               }

               var176 = true;
            }

            label196951: {
               label196950: {
                  try {
                     if (var231.isNull(var56)) {
                        break label196950;
                     }
                  } catch (Throwable var23091) {
                     var10000 = var23091;
                     boolean var23380 = false;
                     break label197487;
                  }

                  try {
                     var23265 = (int)var231.getLong(var56);
                     break label196951;
                  } catch (Throwable var23090) {
                     var10000 = var23090;
                     boolean var23381 = false;
                     break label197487;
                  }
               }

               var23265 = null;
            }

            Boolean var23266;
            if (var23265 == null) {
               var23266 = null;
            } else {
               boolean var177;
               label196940: {
                  label196939: {
                     try {
                        if (var23265 != 0) {
                           break label196939;
                        }
                     } catch (Throwable var23089) {
                        var10000 = var23089;
                        boolean var23382 = false;
                        break label197487;
                     }

                     var177 = false;
                     break label196940;
                  }

                  var177 = true;
               }

               try {
                  var23266 = var177;
               } catch (Throwable var23088) {
                  var10000 = var23088;
                  boolean var23383 = false;
                  break label197487;
               }
            }

            String var218;
            label196931: {
               label196930: {
                  try {
                     var55 = (int)var231.getLong(var55);
                     var54 = (int)var231.getLong(var54);
                     if (var231.isNull(var52)) {
                        break label196930;
                     }
                  } catch (Throwable var23087) {
                     var10000 = var23087;
                     boolean var23384 = false;
                     break label197487;
                  }

                  try {
                     var218 = var231.getText(var52);
                     break label196931;
                  } catch (Throwable var23086) {
                     var10000 = var23086;
                     boolean var23385 = false;
                     break label197487;
                  }
               }

               var218 = null;
            }

            List var239;
            boolean var23256;
            label196922: {
               label196921: {
                  try {
                     var239 = DeviceAlarmListConverter.fromString(var218);
                     var52 = (int)var231.getLong(var53);
                     if ((int)var231.getLong(var50) != 0) {
                        break label196921;
                     }
                  } catch (Throwable var23085) {
                     var10000 = var23085;
                     boolean var23386 = false;
                     break label197487;
                  }

                  var23256 = false;
                  break label196922;
               }

               var23256 = true;
            }

            boolean var178;
            label196914: {
               label196913: {
                  try {
                     if ((int)var231.getLong(var51) != 0) {
                        break label196913;
                     }
                  } catch (Throwable var23084) {
                     var10000 = var23084;
                     boolean var23387 = false;
                     break label197487;
                  }

                  var178 = false;
                  break label196914;
               }

               var178 = true;
            }

            long var184;
            label196906: {
               label196905: {
                  try {
                     var49 = (int)var231.getLong(var49);
                     var47 = (int)var231.getLong(var47);
                     var46 = (int)var231.getLong(var46);
                     var184 = var231.getLong(var45);
                     var44 = (int)var231.getLong(var44);
                     if (var231.isNull(var39)) {
                        break label196905;
                     }
                  } catch (Throwable var23083) {
                     var10000 = var23083;
                     boolean var23388 = false;
                     break label197487;
                  }

                  try {
                     var218 = var231.getText(var39);
                     break label196906;
                  } catch (Throwable var23082) {
                     var10000 = var23082;
                     boolean var23389 = false;
                     break label197487;
                  }
               }

               var218 = null;
            }

            double[] var240;
            label196897: {
               label197494: {
                  try {
                     var240 = DoubleArrayConverter.fromString(var218);
                     if (var231.isNull(var37) && var231.isNull(var29) && var231.isNull(var26) && var231.isNull(var33) && var231.isNull(var38)) {
                        break label197494;
                     }
                  } catch (Throwable var23081) {
                     var10000 = var23081;
                     boolean var23390 = false;
                     break label197487;
                  }

                  label196873: {
                     label196872: {
                        try {
                           if (var231.isNull(var37)) {
                              break label196872;
                           }
                        } catch (Throwable var23080) {
                           var10000 = var23080;
                           boolean var23391 = false;
                           break label197487;
                        }

                        try {
                           var218 = var231.getText(var37);
                           break label196873;
                        } catch (Throwable var23075) {
                           var10000 = var23075;
                           boolean var23392 = false;
                           break label197487;
                        }
                     }

                     var218 = null;
                  }

                  String var219;
                  label196866: {
                     label196865: {
                        try {
                           if (var231.isNull(var29)) {
                              break label196865;
                           }
                        } catch (Throwable var23079) {
                           var10000 = var23079;
                           boolean var23393 = false;
                           break label197487;
                        }

                        try {
                           var219 = var231.getText(var29);
                           break label196866;
                        } catch (Throwable var23074) {
                           var10000 = var23074;
                           boolean var23394 = false;
                           break label197487;
                        }
                     }

                     var219 = null;
                  }

                  String var220;
                  label196859: {
                     label196858: {
                        try {
                           if (var231.isNull(var26)) {
                              break label196858;
                           }
                        } catch (Throwable var23078) {
                           var10000 = var23078;
                           boolean var23395 = false;
                           break label197487;
                        }

                        try {
                           var220 = var231.getText(var26);
                           break label196859;
                        } catch (Throwable var23073) {
                           var10000 = var23073;
                           boolean var23396 = false;
                           break label197487;
                        }
                     }

                     var220 = null;
                  }

                  String var221;
                  label196852: {
                     label196851: {
                        try {
                           if (var231.isNull(var33)) {
                              break label196851;
                           }
                        } catch (Throwable var23077) {
                           var10000 = var23077;
                           boolean var23397 = false;
                           break label197487;
                        }

                        try {
                           var221 = var231.getText(var33);
                           break label196852;
                        } catch (Throwable var23072) {
                           var10000 = var23072;
                           boolean var23398 = false;
                           break label197487;
                        }
                     }

                     var221 = null;
                  }

                  String var222;
                  label196845: {
                     label196844: {
                        try {
                           if (var231.isNull(var38)) {
                              break label196844;
                           }
                        } catch (Throwable var23076) {
                           var10000 = var23076;
                           boolean var23399 = false;
                           break label197487;
                        }

                        try {
                           var222 = var231.getText(var38);
                           break label196845;
                        } catch (Throwable var23071) {
                           var10000 = var23071;
                           boolean var23400 = false;
                           break label197487;
                        }
                     }

                     var222 = null;
                  }

                  DeviceUuidEntity var223;
                  try {
                     var223 = new DeviceUuidEntity(var218, var219, var220, var221, var222);
                  } catch (Throwable var23070) {
                     var10000 = var23070;
                     boolean var23401 = false;
                     break label197487;
                  }

                  var23269 = var223;
                  break label196897;
               }

               var23269 = null;
            }

            IndoorDatapoint var23271;
            label196830: {
               label197495: {
                  try {
                     if (var231.isNull(var40) && var231.isNull(var36) && var231.isNull(var25) && var231.isNull(var41) && var231.isNull(var30) && var231.isNull(var42) && var231.isNull(var27) && var231.isNull(var43) && var231.isNull(var28) && var231.isNull(var32) && var231.isNull(var24)) {
                        break label197495;
                     }
                  } catch (Throwable var23069) {
                     var10000 = var23069;
                     boolean var23402 = false;
                     break label197487;
                  }

                  long var186;
                  label196782: {
                     label196781: {
                        try {
                           var186 = var231.getLong(var40);
                           if (var231.isNull(var36)) {
                              break label196781;
                           }
                        } catch (Throwable var23068) {
                           var10000 = var23068;
                           boolean var23403 = false;
                           break label197487;
                        }

                        try {
                           var23270 = (float)var231.getDouble(var36);
                           break label196782;
                        } catch (Throwable var23058) {
                           var10000 = var23058;
                           boolean var23404 = false;
                           break label197487;
                        }
                     }

                     var23270 = null;
                  }

                  Float var23272;
                  label196775: {
                     label196774: {
                        try {
                           if (var231.isNull(var25)) {
                              break label196774;
                           }
                        } catch (Throwable var23067) {
                           var10000 = var23067;
                           boolean var23405 = false;
                           break label197487;
                        }

                        try {
                           var23272 = (float)var231.getDouble(var25);
                           break label196775;
                        } catch (Throwable var23057) {
                           var10000 = var23057;
                           boolean var23406 = false;
                           break label197487;
                        }
                     }

                     var23272 = null;
                  }

                  Float var23275;
                  label196768: {
                     label196767: {
                        try {
                           if (var231.isNull(var41)) {
                              break label196767;
                           }
                        } catch (Throwable var23066) {
                           var10000 = var23066;
                           boolean var23407 = false;
                           break label197487;
                        }

                        try {
                           var23275 = (float)var231.getDouble(var41);
                           break label196768;
                        } catch (Throwable var23056) {
                           var10000 = var23056;
                           boolean var23408 = false;
                           break label197487;
                        }
                     }

                     var23275 = null;
                  }

                  Float var23278;
                  label196761: {
                     label196760: {
                        try {
                           if (var231.isNull(var30)) {
                              break label196760;
                           }
                        } catch (Throwable var23065) {
                           var10000 = var23065;
                           boolean var23409 = false;
                           break label197487;
                        }

                        try {
                           var23278 = (float)var231.getDouble(var30);
                           break label196761;
                        } catch (Throwable var23055) {
                           var10000 = var23055;
                           boolean var23410 = false;
                           break label197487;
                        }
                     }

                     var23278 = null;
                  }

                  Float var23279;
                  label196754: {
                     label196753: {
                        try {
                           if (var231.isNull(var42)) {
                              break label196753;
                           }
                        } catch (Throwable var23064) {
                           var10000 = var23064;
                           boolean var23411 = false;
                           break label197487;
                        }

                        try {
                           var23279 = (float)var231.getDouble(var42);
                           break label196754;
                        } catch (Throwable var23054) {
                           var10000 = var23054;
                           boolean var23412 = false;
                           break label197487;
                        }
                     }

                     var23279 = null;
                  }

                  Float var224;
                  label196747: {
                     label196746: {
                        try {
                           if (var231.isNull(var27)) {
                              break label196746;
                           }
                        } catch (Throwable var23063) {
                           var10000 = var23063;
                           boolean var23413 = false;
                           break label197487;
                        }

                        try {
                           var224 = (float)var231.getDouble(var27);
                           break label196747;
                        } catch (Throwable var23053) {
                           var10000 = var23053;
                           boolean var23414 = false;
                           break label197487;
                        }
                     }

                     var224 = null;
                  }

                  Float var225;
                  label196740: {
                     label196739: {
                        try {
                           if (var231.isNull(var43)) {
                              break label196739;
                           }
                        } catch (Throwable var23062) {
                           var10000 = var23062;
                           boolean var23415 = false;
                           break label197487;
                        }

                        try {
                           var225 = (float)var231.getDouble(var43);
                           break label196740;
                        } catch (Throwable var23052) {
                           var10000 = var23052;
                           boolean var23416 = false;
                           break label197487;
                        }
                     }

                     var225 = null;
                  }

                  Float var226;
                  label196733: {
                     label196732: {
                        try {
                           if (var231.isNull(var28)) {
                              break label196732;
                           }
                        } catch (Throwable var23061) {
                           var10000 = var23061;
                           boolean var23417 = false;
                           break label197487;
                        }

                        try {
                           var226 = (float)var231.getDouble(var28);
                           break label196733;
                        } catch (Throwable var23051) {
                           var10000 = var23051;
                           boolean var23418 = false;
                           break label197487;
                        }
                     }

                     var226 = null;
                  }

                  Float var227;
                  label196726: {
                     label196725: {
                        try {
                           if (var231.isNull(var32)) {
                              break label196725;
                           }
                        } catch (Throwable var23060) {
                           var10000 = var23060;
                           boolean var23419 = false;
                           break label197487;
                        }

                        try {
                           var227 = (float)var231.getDouble(var32);
                           break label196726;
                        } catch (Throwable var23050) {
                           var10000 = var23050;
                           boolean var23420 = false;
                           break label197487;
                        }
                     }

                     var227 = null;
                  }

                  Float var228;
                  label196719: {
                     label196718: {
                        try {
                           if (var231.isNull(var24)) {
                              break label196718;
                           }
                        } catch (Throwable var23059) {
                           var10000 = var23059;
                           boolean var23421 = false;
                           break label197487;
                        }

                        try {
                           var228 = (float)var231.getDouble(var24);
                           break label196719;
                        } catch (Throwable var23049) {
                           var10000 = var23049;
                           boolean var23422 = false;
                           break label197487;
                        }
                     }

                     var228 = null;
                  }

                  IndoorDatapoint var230;
                  try {
                     var230 = new IndoorDatapoint(var186, var23270, var23272, var23275, var23278, var23279, var224, var225, var226, var227, var228);
                  } catch (Throwable var23048) {
                     var10000 = var23048;
                     boolean var23423 = false;
                     break label197487;
                  }

                  var23271 = var230;
                  break label196830;
               }

               var23271 = null;
            }

            WelcomeHomeLocation var23274;
            label196699: {
               label197496: {
                  try {
                     if (var231.isNull(var35) && var231.isNull(var34) && var231.isNull(var31) && var231.isNull(var21) && var231.isNull(var22)) {
                        break label197496;
                     }
                  } catch (Throwable var23047) {
                     var10000 = var23047;
                     boolean var23424 = false;
                     break label197487;
                  }

                  double var2;
                  double var8;
                  label196682: {
                     label196681: {
                        try {
                           var8 = var231.getDouble(var35);
                           var2 = var231.getDouble(var34);
                           var24 = (int)var231.getLong(var31);
                           if (var231.isNull(var21)) {
                              break label196681;
                           }
                        } catch (Throwable var23046) {
                           var10000 = var23046;
                           boolean var23425 = false;
                           break label197487;
                        }

                        try {
                           var23273 = var231.getText(var21);
                           break label196682;
                        } catch (Throwable var23044) {
                           var10000 = var23044;
                           boolean var23426 = false;
                           break label197487;
                        }
                     }

                     var23273 = (String)var229;
                  }

                  boolean var179;
                  label196675: {
                     label196674: {
                        try {
                           if ((int)var231.getLong(var22) != 0) {
                              break label196674;
                           }
                        } catch (Throwable var23045) {
                           var10000 = var23045;
                           boolean var23427 = false;
                           break label197487;
                        }

                        var179 = false;
                        break label196675;
                     }

                     var179 = true;
                  }

                  WelcomeHomeLocation var23276;
                  try {
                     var23276 = new WelcomeHomeLocation(var8, var2, var24, var23273, var179);
                  } catch (Throwable var23043) {
                     var10000 = var23043;
                     boolean var23428 = false;
                     break label197487;
                  }

                  var23274 = var23276;
                  break label196699;
               }

               var23274 = null;
            }

            label196665:
            try {
               var21 = (int)var231.getLong(var23);
               var20 = (int)var231.getLong(var20);
               var19 = (int)var231.getLong(var19);
               var18 = (int)var231.getLong(var18);
               var17 = (int)var231.getLong(var17);
               var16 = (int)var231.getLong(var16);
               var15 = (int)var231.getLong(var15);
               var14 = (int)var231.getLong(var14);
               var12 = (int)var231.getLong(var12);
               var11 = (int)var231.getLong(var11);
               var10 = (int)var231.getLong(var10);
               DualOscillationConfig var23277 = new DualOscillationConfig(var21, var20, var19, var18, var17, var16, var15, var14, var12, var11, var10);
               var23193 = new DeviceEntity(var0, var23196, var190, var13, var191, var192, var193, var194, var195, var23269, var155, var23271, var196, var156, var157, var158, var197, var48, var180, var198, var199, var200, var201, var202, var203, var204, var205, var206, var207, var208, var232, var233, var234, var235, var236, var79, var159, var160, var161, var162, var163, var164, var23262, var23254, var210, var166, var211, var212, var23274, var213, var23263, var215, var216, var23255, var168, var105, var182, var103, var169, var101, var100, var99, var98, var188, var96, var95, var94, var93, var92, var91, var90, var89, var88, var87, var4, var6, var84, var83, var82, var237, var80, var238, var170, var76, var75, var74, var171, var72, var172, var173, var69, var68, var174, var175, var65, var64, var63, var62, var61, var60, var59, var58, var176, var23266, var55, var54, var239, var52, var23256, var178, var49, var47, var46, var184, var23277, var44, var240);
               break label197485;
            } catch (Throwable var23042) {
               var10000 = var23042;
               boolean var23429 = false;
               break label196665;
            }
         }

         Throwable var23195 = var10000;
         var231.close();
         throw var23195;
      }

      var231.close();
      return var23193;
   }

   // $FF: synthetic method
   static List lambda$getDevices$2(SQLiteConnection var0) {
      SQLiteStatement var285 = var0.prepare("SELECT * from device_table ORDER BY modelName DESC");

      ArrayList var286;
      label223033: {
         Throwable var10000;
         label223032: {
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var153;
            int var154;
            try {
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uid");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "name");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "modelName");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "typeIndex");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fanSpeed");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterLife");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoModeText");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "brightness");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "info");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hasFinishedOnboarding");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastSelectedSensorType");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isAblDevice");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isNightModeOn");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isChildLockOn");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "linkedDeviceUid");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "connectivityStatusIndex");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastConnectivityMillis");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mac");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mcuFirmware");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wifiFirmware");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hardware");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeZone");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "serial");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "purchaseDate");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerName");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerCountry");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterType");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterTrigger");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1Ranges");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10Ranges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25Ranges");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "vocRanges");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hchoRanges");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "updateProgress");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isStandByOn");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEcoModeOn");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsModeOn");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsNightModeOn");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isG4NightModeOn");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldOn");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldNightModeOn");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isSafetySwitchOn");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "g4NightModefilterTrigger");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "aimInstalled");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sku");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "compatibility");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "locationId");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfection");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTime");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTimeUpdateTime");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryEnabled");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryOn");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTime");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTimeUpdateTime");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickUsage");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterShortage");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoRh");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerStatus");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerDuration");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTime");
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTimeUpdateTime");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "temperatureUnit");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationState");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationAngle");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationDirection");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationFanSpeed");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mainMode");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apSubMode");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apFanSpeed");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatSubMode");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatFanSpeed");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatAutoTmp");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatEcoTmp");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolSubMode");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeed");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoTag");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoPresets");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoTag");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoPresets");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humMode");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mode");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterLevel");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dehSubMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterTankFailure");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "smartSubMode");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "detectCat");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bodyMounted");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "cleanAirEta");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "panelDisplayMode");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hoverEnabled");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEnabled");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStatus");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshDuration");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshTimeStamp");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStartTimeStamp");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEndTimeStamp");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "roomType");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampBrightness");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDuration");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDone");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmEnabled");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmUsage");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampSteplessBrightness");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "alarms");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humSubMode");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "use24Hour");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterInfill");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sensorMode");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeedLevel");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoLevel");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightModeStartTime");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm1");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightPeriods");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uuid");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ssid");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bssid");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv4");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv6");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeInSeconds");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "voc");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hcho");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "tmp");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hum");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fan");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "weight");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lat");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lng");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "radius");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "textValue");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEnabled");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationMode");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationState");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationFixAngle");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMinAngle");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMaxAngle");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationState");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationFixAngle");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMinAngle");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMaxAngle");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalCalibrationState");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalCalibrationState");
               var286 = new ArrayList();
            } catch (Throwable var30051) {
               var10000 = var30051;
               boolean var10001 = false;
               break label223032;
            }

            while(true) {
               label223027: {
                  label223026: {
                     try {
                        if (!var285.step()) {
                           break label223033;
                        }

                        if (var285.isNull(var153)) {
                           break label223026;
                        }
                     } catch (Throwable var30050) {
                        var10000 = var30050;
                        boolean var30082 = false;
                        break;
                     }

                     try {
                        var30052 = var285.getText(var153);
                        break label223027;
                     } catch (Throwable var29964) {
                        var10000 = var29964;
                        boolean var30083 = false;
                        break;
                     }
                  }

                  var30052 = null;
               }

               String var244;
               label223019: {
                  label223018: {
                     try {
                        if (var285.isNull(var123)) {
                           break label223018;
                        }
                     } catch (Throwable var30049) {
                        var10000 = var30049;
                        boolean var30084 = false;
                        break;
                     }

                     try {
                        var244 = var285.getText(var123);
                        break label223019;
                     } catch (Throwable var29963) {
                        var10000 = var29963;
                        boolean var30085 = false;
                        break;
                     }
                  }

                  var244 = null;
               }

               String var245;
               label223012: {
                  label223011: {
                     try {
                        if (var285.isNull(var119)) {
                           break label223011;
                        }
                     } catch (Throwable var30048) {
                        var10000 = var30048;
                        boolean var30086 = false;
                        break;
                     }

                     try {
                        var245 = var285.getText(var119);
                        break label223012;
                     } catch (Throwable var29962) {
                        var10000 = var29962;
                        boolean var30087 = false;
                        break;
                     }
                  }

                  var245 = null;
               }

               int var155;
               Integer var246;
               label223005: {
                  label223004: {
                     try {
                        var155 = (int)var285.getLong(var121);
                        if (var285.isNull(var120)) {
                           break label223004;
                        }
                     } catch (Throwable var30047) {
                        var10000 = var30047;
                        boolean var30088 = false;
                        break;
                     }

                     try {
                        var246 = (int)var285.getLong(var120);
                        break label223005;
                     } catch (Throwable var29961) {
                        var10000 = var29961;
                        boolean var30089 = false;
                        break;
                     }
                  }

                  var246 = null;
               }

               Integer var247;
               label222998: {
                  label222997: {
                     try {
                        if (var285.isNull(var114)) {
                           break label222997;
                        }
                     } catch (Throwable var30046) {
                        var10000 = var30046;
                        boolean var30090 = false;
                        break;
                     }

                     try {
                        var247 = (int)var285.getLong(var114);
                        break label222998;
                     } catch (Throwable var29960) {
                        var10000 = var29960;
                        boolean var30091 = false;
                        break;
                     }
                  }

                  var247 = null;
               }

               String var248;
               label222991: {
                  label222990: {
                     try {
                        if (var285.isNull(var112)) {
                           break label222990;
                        }
                     } catch (Throwable var30045) {
                        var10000 = var30045;
                        boolean var30092 = false;
                        break;
                     }

                     try {
                        var248 = var285.getText(var112);
                        break label222991;
                     } catch (Throwable var29959) {
                        var10000 = var29959;
                        boolean var30093 = false;
                        break;
                     }
                  }

                  var248 = null;
               }

               Integer var249;
               label222984: {
                  label222983: {
                     try {
                        if (var285.isNull(var107)) {
                           break label222983;
                        }
                     } catch (Throwable var30044) {
                        var10000 = var30044;
                        boolean var30094 = false;
                        break;
                     }

                     try {
                        var249 = (int)var285.getLong(var107);
                        break label222984;
                     } catch (Throwable var29958) {
                        var10000 = var29958;
                        boolean var30095 = false;
                        break;
                     }
                  }

                  var249 = null;
               }

               String var250;
               label222977: {
                  label222976: {
                     try {
                        if (var285.isNull(var109)) {
                           break label222976;
                        }
                     } catch (Throwable var30043) {
                        var10000 = var30043;
                        boolean var30096 = false;
                        break;
                     }

                     try {
                        var250 = var285.getText(var109);
                        break label222977;
                     } catch (Throwable var29957) {
                        var10000 = var29957;
                        boolean var30097 = false;
                        break;
                     }
                  }

                  var250 = null;
               }

               boolean var209;
               label222970: {
                  label222969: {
                     try {
                        if ((int)var285.getLong(var110) != 0) {
                           break label222969;
                        }
                     } catch (Throwable var30042) {
                        var10000 = var30042;
                        boolean var30098 = false;
                        break;
                     }

                     var209 = false;
                     break label222970;
                  }

                  var209 = true;
               }

               Integer var251;
               label222963: {
                  label222962: {
                     try {
                        if (var285.isNull(var111)) {
                           break label222962;
                        }
                     } catch (Throwable var30041) {
                        var10000 = var30041;
                        boolean var30099 = false;
                        break;
                     }

                     try {
                        var251 = (int)var285.getLong(var111);
                        break label222963;
                     } catch (Throwable var29956) {
                        var10000 = var29956;
                        boolean var30100 = false;
                        break;
                     }
                  }

                  var251 = null;
               }

               boolean var210;
               label222956: {
                  label222955: {
                     try {
                        if ((int)var285.getLong(var115) != 0) {
                           break label222955;
                        }
                     } catch (Throwable var30040) {
                        var10000 = var30040;
                        boolean var30101 = false;
                        break;
                     }

                     var210 = false;
                     break label222956;
                  }

                  var210 = true;
               }

               boolean var211;
               label222949: {
                  label222948: {
                     try {
                        if ((int)var285.getLong(var113) != 0) {
                           break label222948;
                        }
                     } catch (Throwable var30039) {
                        var10000 = var30039;
                        boolean var30102 = false;
                        break;
                     }

                     var211 = false;
                     break label222949;
                  }

                  var211 = true;
               }

               boolean var212;
               label222942: {
                  label222941: {
                     try {
                        if ((int)var285.getLong(var108) != 0) {
                           break label222941;
                        }
                     } catch (Throwable var30038) {
                        var10000 = var30038;
                        boolean var30103 = false;
                        break;
                     }

                     var212 = false;
                     break label222942;
                  }

                  var212 = true;
               }

               String var252;
               label222935: {
                  label222934: {
                     try {
                        if (var285.isNull(var62)) {
                           break label222934;
                        }
                     } catch (Throwable var30037) {
                        var10000 = var30037;
                        boolean var30104 = false;
                        break;
                     }

                     try {
                        var252 = var285.getText(var62);
                        break label222935;
                     } catch (Throwable var29955) {
                        var10000 = var29955;
                        boolean var30105 = false;
                        break;
                     }
                  }

                  var252 = null;
               }

               int var156;
               long var240;
               String var253;
               label222928: {
                  label222927: {
                     try {
                        var156 = (int)var285.getLong(var118);
                        var240 = var285.getLong(var116);
                        if (var285.isNull(var151)) {
                           break label222927;
                        }
                     } catch (Throwable var30036) {
                        var10000 = var30036;
                        boolean var30106 = false;
                        break;
                     }

                     try {
                        var253 = var285.getText(var151);
                        break label222928;
                     } catch (Throwable var29954) {
                        var10000 = var29954;
                        boolean var30107 = false;
                        break;
                     }
                  }

                  var253 = null;
               }

               String var254;
               label222921: {
                  label222920: {
                     try {
                        if (var285.isNull(var150)) {
                           break label222920;
                        }
                     } catch (Throwable var30035) {
                        var10000 = var30035;
                        boolean var30108 = false;
                        break;
                     }

                     try {
                        var254 = var285.getText(var150);
                        break label222921;
                     } catch (Throwable var29953) {
                        var10000 = var29953;
                        boolean var30109 = false;
                        break;
                     }
                  }

                  var254 = null;
               }

               String var255;
               label222914: {
                  label222913: {
                     try {
                        if (var285.isNull(var149)) {
                           break label222913;
                        }
                     } catch (Throwable var30034) {
                        var10000 = var30034;
                        boolean var30110 = false;
                        break;
                     }

                     try {
                        var255 = var285.getText(var149);
                        break label222914;
                     } catch (Throwable var29952) {
                        var10000 = var29952;
                        boolean var30111 = false;
                        break;
                     }
                  }

                  var255 = null;
               }

               String var256;
               label222907: {
                  label222906: {
                     try {
                        if (var285.isNull(var148)) {
                           break label222906;
                        }
                     } catch (Throwable var30033) {
                        var10000 = var30033;
                        boolean var30112 = false;
                        break;
                     }

                     try {
                        var256 = var285.getText(var148);
                        break label222907;
                     } catch (Throwable var29951) {
                        var10000 = var29951;
                        boolean var30113 = false;
                        break;
                     }
                  }

                  var256 = null;
               }

               String var257;
               label222900: {
                  label222899: {
                     try {
                        if (var285.isNull(var147)) {
                           break label222899;
                        }
                     } catch (Throwable var30032) {
                        var10000 = var30032;
                        boolean var30114 = false;
                        break;
                     }

                     try {
                        var257 = var285.getText(var147);
                        break label222900;
                     } catch (Throwable var29950) {
                        var10000 = var29950;
                        boolean var30115 = false;
                        break;
                     }
                  }

                  var257 = null;
               }

               String var258;
               label222893: {
                  label222892: {
                     try {
                        if (var285.isNull(var146)) {
                           break label222892;
                        }
                     } catch (Throwable var30031) {
                        var10000 = var30031;
                        boolean var30116 = false;
                        break;
                     }

                     try {
                        var258 = var285.getText(var146);
                        break label222893;
                     } catch (Throwable var29949) {
                        var10000 = var29949;
                        boolean var30117 = false;
                        break;
                     }
                  }

                  var258 = null;
               }

               String var259;
               label222886: {
                  label222885: {
                     try {
                        if (var285.isNull(var145)) {
                           break label222885;
                        }
                     } catch (Throwable var30030) {
                        var10000 = var30030;
                        boolean var30118 = false;
                        break;
                     }

                     try {
                        var259 = var285.getText(var145);
                        break label222886;
                     } catch (Throwable var29948) {
                        var10000 = var29948;
                        boolean var30119 = false;
                        break;
                     }
                  }

                  var259 = null;
               }

               String var260;
               label222879: {
                  label222878: {
                     try {
                        if (var285.isNull(var144)) {
                           break label222878;
                        }
                     } catch (Throwable var30029) {
                        var10000 = var30029;
                        boolean var30120 = false;
                        break;
                     }

                     try {
                        var260 = var285.getText(var144);
                        break label222879;
                     } catch (Throwable var29947) {
                        var10000 = var29947;
                        boolean var30121 = false;
                        break;
                     }
                  }

                  var260 = null;
               }

               String var261;
               label222872: {
                  label222871: {
                     try {
                        if (var285.isNull(var143)) {
                           break label222871;
                        }
                     } catch (Throwable var30028) {
                        var10000 = var30028;
                        boolean var30122 = false;
                        break;
                     }

                     try {
                        var261 = var285.getText(var143);
                        break label222872;
                     } catch (Throwable var29946) {
                        var10000 = var29946;
                        boolean var30123 = false;
                        break;
                     }
                  }

                  var261 = null;
               }

               String var262;
               label222865: {
                  label222864: {
                     try {
                        if (var285.isNull(var142)) {
                           break label222864;
                        }
                     } catch (Throwable var30027) {
                        var10000 = var30027;
                        boolean var30124 = false;
                        break;
                     }

                     try {
                        var262 = var285.getText(var142);
                        break label222865;
                     } catch (Throwable var29945) {
                        var10000 = var29945;
                        boolean var30125 = false;
                        break;
                     }
                  }

                  var262 = null;
               }

               String var263;
               label222858: {
                  label222857: {
                     try {
                        if (var285.isNull(var141)) {
                           break label222857;
                        }
                     } catch (Throwable var30026) {
                        var10000 = var30026;
                        boolean var30126 = false;
                        break;
                     }

                     try {
                        var263 = var285.getText(var141);
                        break label222858;
                     } catch (Throwable var29944) {
                        var10000 = var29944;
                        boolean var30127 = false;
                        break;
                     }
                  }

                  var263 = null;
               }

               String var264;
               label222851: {
                  label222850: {
                     try {
                        if (var285.isNull(var140)) {
                           break label222850;
                        }
                     } catch (Throwable var30025) {
                        var10000 = var30025;
                        boolean var30128 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var140);
                        break label222851;
                     } catch (Throwable var29943) {
                        var10000 = var29943;
                        boolean var30129 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var287;
               try {
                  var287 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29942) {
                  var10000 = var29942;
                  boolean var30130 = false;
                  break;
               }

               label222843: {
                  label222842: {
                     try {
                        if (var285.isNull(var139)) {
                           break label222842;
                        }
                     } catch (Throwable var30024) {
                        var10000 = var30024;
                        boolean var30131 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var139);
                        break label222843;
                     } catch (Throwable var29941) {
                        var10000 = var29941;
                        boolean var30132 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var288;
               try {
                  var288 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29940) {
                  var10000 = var29940;
                  boolean var30133 = false;
                  break;
               }

               label222835: {
                  label222834: {
                     try {
                        if (var285.isNull(var138)) {
                           break label222834;
                        }
                     } catch (Throwable var30023) {
                        var10000 = var30023;
                        boolean var30134 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var138);
                        break label222835;
                     } catch (Throwable var29939) {
                        var10000 = var29939;
                        boolean var30135 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var289;
               try {
                  var289 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29938) {
                  var10000 = var29938;
                  boolean var30136 = false;
                  break;
               }

               label222827: {
                  label222826: {
                     try {
                        if (var285.isNull(var137)) {
                           break label222826;
                        }
                     } catch (Throwable var30022) {
                        var10000 = var30022;
                        boolean var30137 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var137);
                        break label222827;
                     } catch (Throwable var29937) {
                        var10000 = var29937;
                        boolean var30138 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var290;
               try {
                  var290 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29936) {
                  var10000 = var29936;
                  boolean var30139 = false;
                  break;
               }

               label222819: {
                  label222818: {
                     try {
                        if (var285.isNull(var136)) {
                           break label222818;
                        }
                     } catch (Throwable var30021) {
                        var10000 = var30021;
                        boolean var30140 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var136);
                        break label222819;
                     } catch (Throwable var29935) {
                        var10000 = var29935;
                        boolean var30141 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var291;
               try {
                  var291 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29934) {
                  var10000 = var29934;
                  boolean var30142 = false;
                  break;
               }

               int var157;
               boolean var213;
               label222811: {
                  label222810: {
                     try {
                        var157 = (int)var285.getLong(var105);
                        if ((int)var285.getLong(var104) != 0) {
                           break label222810;
                        }
                     } catch (Throwable var30020) {
                        var10000 = var30020;
                        boolean var30143 = false;
                        break;
                     }

                     var213 = false;
                     break label222811;
                  }

                  var213 = true;
               }

               boolean var214;
               label222804: {
                  label222803: {
                     try {
                        if ((int)var285.getLong(var101) != 0) {
                           break label222803;
                        }
                     } catch (Throwable var30019) {
                        var10000 = var30019;
                        boolean var30144 = false;
                        break;
                     }

                     var214 = false;
                     break label222804;
                  }

                  var214 = true;
               }

               boolean var215;
               label222797: {
                  label222796: {
                     try {
                        if ((int)var285.getLong(var102) != 0) {
                           break label222796;
                        }
                     } catch (Throwable var30018) {
                        var10000 = var30018;
                        boolean var30145 = false;
                        break;
                     }

                     var215 = false;
                     break label222797;
                  }

                  var215 = true;
               }

               boolean var216;
               label222790: {
                  label222789: {
                     try {
                        if ((int)var285.getLong(var99) != 0) {
                           break label222789;
                        }
                     } catch (Throwable var30017) {
                        var10000 = var30017;
                        boolean var30146 = false;
                        break;
                     }

                     var216 = false;
                     break label222790;
                  }

                  var216 = true;
               }

               boolean var217;
               label222783: {
                  label222782: {
                     try {
                        if ((int)var285.getLong(var98) != 0) {
                           break label222782;
                        }
                     } catch (Throwable var30016) {
                        var10000 = var30016;
                        boolean var30147 = false;
                        break;
                     }

                     var217 = false;
                     break label222783;
                  }

                  var217 = true;
               }

               boolean var218;
               label222776: {
                  label222775: {
                     try {
                        if ((int)var285.getLong(var97) != 0) {
                           break label222775;
                        }
                     } catch (Throwable var30015) {
                        var10000 = var30015;
                        boolean var30148 = false;
                        break;
                     }

                     var218 = false;
                     break label222776;
                  }

                  var218 = true;
               }

               label222769: {
                  label222768: {
                     try {
                        if (var285.isNull(var95)) {
                           break label222768;
                        }
                     } catch (Throwable var30014) {
                        var10000 = var30014;
                        boolean var30149 = false;
                        break;
                     }

                     try {
                        var30062 = (int)var285.getLong(var95);
                        break label222769;
                     } catch (Throwable var29933) {
                        var10000 = var29933;
                        boolean var30150 = false;
                        break;
                     }
                  }

                  var30062 = null;
               }

               Boolean var30063;
               if (var30062 == null) {
                  var30063 = null;
               } else {
                  boolean var219;
                  label222760: {
                     label222759: {
                        try {
                           if (var30062 != 0) {
                              break label222759;
                           }
                        } catch (Throwable var30013) {
                           var10000 = var30013;
                           boolean var30151 = false;
                           break;
                        }

                        var219 = false;
                        break label222760;
                     }

                     var219 = true;
                  }

                  try {
                     var30063 = var219;
                  } catch (Throwable var29932) {
                     var10000 = var29932;
                     boolean var30152 = false;
                     break;
                  }
               }

               boolean var30055;
               label222753: {
                  label222752: {
                     try {
                        if ((int)var285.getLong(var94) != 0) {
                           break label222752;
                        }
                     } catch (Throwable var30012) {
                        var10000 = var30012;
                        boolean var30153 = false;
                        break;
                     }

                     var30055 = false;
                     break label222753;
                  }

                  var30055 = true;
               }

               String var265;
               label222746: {
                  label222745: {
                     try {
                        if (var285.isNull(var92)) {
                           break label222745;
                        }
                     } catch (Throwable var30011) {
                        var10000 = var30011;
                        boolean var30154 = false;
                        break;
                     }

                     try {
                        var265 = var285.getText(var92);
                        break label222746;
                     } catch (Throwable var29931) {
                        var10000 = var29931;
                        boolean var30155 = false;
                        break;
                     }
                  }

                  var265 = null;
               }

               boolean var220;
               label222739: {
                  label222738: {
                     try {
                        if ((int)var285.getLong(var91) != 0) {
                           break label222738;
                        }
                     } catch (Throwable var30010) {
                        var10000 = var30010;
                        boolean var30156 = false;
                        break;
                     }

                     var220 = false;
                     break label222739;
                  }

                  var220 = true;
               }

               String var266;
               label222732: {
                  label222731: {
                     try {
                        if (var285.isNull(var135)) {
                           break label222731;
                        }
                     } catch (Throwable var30009) {
                        var10000 = var30009;
                        boolean var30157 = false;
                        break;
                     }

                     try {
                        var266 = var285.getText(var135);
                        break label222732;
                     } catch (Throwable var29930) {
                        var10000 = var29930;
                        boolean var30158 = false;
                        break;
                     }
                  }

                  var266 = null;
               }

               String var267;
               label222725: {
                  label222724: {
                     try {
                        if (var285.isNull(var86)) {
                           break label222724;
                        }
                     } catch (Throwable var30008) {
                        var10000 = var30008;
                        boolean var30159 = false;
                        break;
                     }

                     try {
                        var267 = var285.getText(var86);
                        break label222725;
                     } catch (Throwable var29929) {
                        var10000 = var29929;
                        boolean var30160 = false;
                        break;
                     }
                  }

                  var267 = null;
               }

               String var268;
               label222718: {
                  label222717: {
                     try {
                        if (var285.isNull(var134)) {
                           break label222717;
                        }
                     } catch (Throwable var30007) {
                        var10000 = var30007;
                        boolean var30161 = false;
                        break;
                     }

                     try {
                        var268 = var285.getText(var134);
                        break label222718;
                     } catch (Throwable var29928) {
                        var10000 = var29928;
                        boolean var30162 = false;
                        break;
                     }
                  }

                  var268 = null;
               }

               Integer var269;
               label222711: {
                  label222710: {
                     try {
                        if (var285.isNull(var83)) {
                           break label222710;
                        }
                     } catch (Throwable var30006) {
                        var10000 = var30006;
                        boolean var30163 = false;
                        break;
                     }

                     try {
                        var269 = (int)var285.getLong(var83);
                        break label222711;
                     } catch (Throwable var29927) {
                        var10000 = var29927;
                        boolean var30164 = false;
                        break;
                     }
                  }

                  var269 = null;
               }

               Boolean var30064;
               if (var269 == null) {
                  var30064 = null;
               } else {
                  boolean var221;
                  label222702: {
                     label222701: {
                        try {
                           if (var269 != 0) {
                              break label222701;
                           }
                        } catch (Throwable var30005) {
                           var10000 = var30005;
                           boolean var30165 = false;
                           break;
                        }

                        var221 = false;
                        break label222702;
                     }

                     var221 = true;
                  }

                  try {
                     var30064 = var221;
                  } catch (Throwable var29926) {
                     var10000 = var29926;
                     boolean var30166 = false;
                     break;
                  }
               }

               Integer var270;
               label222695: {
                  label222694: {
                     try {
                        if (var285.isNull(var80)) {
                           break label222694;
                        }
                     } catch (Throwable var30004) {
                        var10000 = var30004;
                        boolean var30167 = false;
                        break;
                     }

                     try {
                        var270 = (int)var285.getLong(var80);
                        break label222695;
                     } catch (Throwable var29925) {
                        var10000 = var29925;
                        boolean var30168 = false;
                        break;
                     }
                  }

                  var270 = null;
               }

               Long var271;
               label222688: {
                  label222687: {
                     try {
                        if (var285.isNull(var78)) {
                           break label222687;
                        }
                     } catch (Throwable var30003) {
                        var10000 = var30003;
                        boolean var30169 = false;
                        break;
                     }

                     try {
                        var271 = var285.getLong(var78);
                        break label222688;
                     } catch (Throwable var29924) {
                        var10000 = var29924;
                        boolean var30170 = false;
                        break;
                     }
                  }

                  var271 = null;
               }

               boolean var30056;
               label222681: {
                  label222680: {
                     try {
                        if ((int)var285.getLong(var77) != 0) {
                           break label222680;
                        }
                     } catch (Throwable var30002) {
                        var10000 = var30002;
                        boolean var30171 = false;
                        break;
                     }

                     var30056 = false;
                     break label222681;
                  }

                  var30056 = true;
               }

               boolean var222;
               label222674: {
                  label222673: {
                     try {
                        if ((int)var285.getLong(var75) != 0) {
                           break label222673;
                        }
                     } catch (Throwable var30001) {
                        var10000 = var30001;
                        boolean var30172 = false;
                        break;
                     }

                     var222 = false;
                     break label222674;
                  }

                  var222 = true;
               }

               int var159;
               int var162;
               boolean var223;
               long var238;
               label222667: {
                  label222666: {
                     try {
                        var162 = (int)var285.getLong(var74);
                        var238 = var285.getLong(var72);
                        var159 = (int)var285.getLong(var71);
                        if ((int)var285.getLong(var70) != 0) {
                           break label222666;
                        }
                     } catch (Throwable var30000) {
                        var10000 = var30000;
                        boolean var30173 = false;
                        break;
                     }

                     var223 = false;
                     break label222667;
                  }

                  var223 = true;
               }

               int var158;
               int var160;
               int var161;
               int var163;
               int var164;
               long var236;
               try {
                  var164 = (int)var285.getLong(var69);
                  var163 = (int)var285.getLong(var64);
                  var161 = (int)var285.getLong(var68);
                  var160 = (int)var285.getLong(var67);
                  var236 = var285.getLong(var154);
                  var158 = (int)var285.getLong(var133);
               } catch (Throwable var29923) {
                  var10000 = var29923;
                  boolean var30174 = false;
                  break;
               }

               double var1;
               double var5;
               int var165;
               int var166;
               int var167;
               int var168;
               int var169;
               int var170;
               int var171;
               int var172;
               int var173;
               try {
                  var166 = (int)var285.getLong(var65);
                  var170 = (int)var285.getLong(var63);
                  var169 = (int)var285.getLong(var61);
                  var167 = (int)var285.getLong(var60);
                  var171 = (int)var285.getLong(var59);
                  var165 = (int)var285.getLong(var58);
                  var168 = (int)var285.getLong(var57);
                  var172 = (int)var285.getLong(var56);
                  var173 = (int)var285.getLong(var55);
                  var5 = var285.getDouble(var131);
                  var1 = var285.getDouble(var132);
               } catch (Throwable var29922) {
                  var10000 = var29922;
                  boolean var30175 = false;
                  break;
               }

               int var174;
               try {
                  var174 = (int)var285.getLong(var130);
               } catch (Throwable var29921) {
                  var10000 = var29921;
                  boolean var30176 = false;
                  break;
               }

               int var176;
               int var177;
               String var272;
               label222659: {
                  label222658: {
                     try {
                        var177 = (int)var285.getLong(var54);
                        var176 = (int)var285.getLong(var53);
                        if (var285.isNull(var52)) {
                           break label222658;
                        }
                     } catch (Throwable var29999) {
                        var10000 = var29999;
                        boolean var30177 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var52);
                        break label222659;
                     } catch (Throwable var29920) {
                        var10000 = var29920;
                        boolean var30178 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               int var175;
               double[] var292;
               label222652: {
                  label222651: {
                     try {
                        var292 = DoubleArrayConverter.fromString(var272);
                        var175 = (int)var285.getLong(var129);
                        if (var285.isNull(var128)) {
                           break label222651;
                        }
                     } catch (Throwable var29998) {
                        var10000 = var29998;
                        boolean var30179 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var128);
                        break label222652;
                     } catch (Throwable var29919) {
                        var10000 = var29919;
                        boolean var30180 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               double[] var293;
               try {
                  var293 = DoubleArrayConverter.fromString(var272);
               } catch (Throwable var29918) {
                  var10000 = var29918;
                  boolean var30181 = false;
                  break;
               }

               boolean var224;
               label222644: {
                  label222643: {
                     try {
                        if ((int)var285.getLong(var51) != 0) {
                           break label222643;
                        }
                     } catch (Throwable var29997) {
                        var10000 = var29997;
                        boolean var30182 = false;
                        break;
                     }

                     var224 = false;
                     break label222644;
                  }

                  var224 = true;
               }

               int var178;
               int var179;
               int var180;
               boolean var225;
               label222637: {
                  label222636: {
                     try {
                        var180 = (int)var285.getLong(var50);
                        var178 = (int)var285.getLong(var49);
                        var179 = (int)var285.getLong(var48);
                        if ((int)var285.getLong(var47) != 0) {
                           break label222636;
                        }
                     } catch (Throwable var29996) {
                        var10000 = var29996;
                        boolean var30183 = false;
                        break;
                     }

                     var225 = false;
                     break label222637;
                  }

                  var225 = true;
               }

               int var181;
               try {
                  var181 = (int)var285.getLong(var127);
               } catch (Throwable var29917) {
                  var10000 = var29917;
                  boolean var30184 = false;
                  break;
               }

               boolean var226;
               label222629: {
                  label222628: {
                     try {
                        if ((int)var285.getLong(var126) != 0) {
                           break label222628;
                        }
                     } catch (Throwable var29995) {
                        var10000 = var29995;
                        boolean var30185 = false;
                        break;
                     }

                     var226 = false;
                     break label222629;
                  }

                  var226 = true;
               }

               boolean var227;
               label222622: {
                  label222621: {
                     try {
                        if ((int)var285.getLong(var46) != 0) {
                           break label222621;
                        }
                     } catch (Throwable var29994) {
                        var10000 = var29994;
                        boolean var30186 = false;
                        break;
                     }

                     var227 = false;
                     break label222622;
                  }

                  var227 = true;
               }

               int var182;
               int var183;
               boolean var228;
               label222615: {
                  label222614: {
                     try {
                        var183 = (int)var285.getLong(var45);
                        var182 = (int)var285.getLong(var44);
                        if ((int)var285.getLong(var43) != 0) {
                           break label222614;
                        }
                     } catch (Throwable var29993) {
                        var10000 = var29993;
                        boolean var30187 = false;
                        break;
                     }

                     var228 = false;
                     break label222615;
                  }

                  var228 = true;
               }

               boolean var229;
               label222608: {
                  label222607: {
                     try {
                        if ((int)var285.getLong(var125) != 0) {
                           break label222607;
                        }
                     } catch (Throwable var29992) {
                        var10000 = var29992;
                        boolean var30188 = false;
                        break;
                     }

                     var229 = false;
                     break label222608;
                  }

                  var229 = true;
               }

               int var184;
               try {
                  var184 = (int)var285.getLong(var124);
               } catch (Throwable var29916) {
                  var10000 = var29916;
                  boolean var30189 = false;
                  break;
               }

               int var185;
               int var186;
               int var187;
               int var188;
               int var189;
               int var190;
               int var191;
               boolean var230;
               label222600: {
                  label222599: {
                     try {
                        var190 = (int)var285.getLong(var42);
                        var188 = (int)var285.getLong(var41);
                        var191 = (int)var285.getLong(var40);
                        var189 = (int)var285.getLong(var39);
                        var185 = (int)var285.getLong(var38);
                        var187 = (int)var285.getLong(var37);
                        var186 = (int)var285.getLong(var36);
                        if ((int)var285.getLong(var35) != 0) {
                           break label222599;
                        }
                     } catch (Throwable var29991) {
                        var10000 = var29991;
                        boolean var30190 = false;
                        break;
                     }

                     var230 = false;
                     break label222600;
                  }

                  var230 = true;
               }

               label222593: {
                  label222592: {
                     try {
                        if (var285.isNull(var122)) {
                           break label222592;
                        }
                     } catch (Throwable var29990) {
                        var10000 = var29990;
                        boolean var30191 = false;
                        break;
                     }

                     try {
                        var30066 = (int)var285.getLong(var122);
                        break label222593;
                     } catch (Throwable var29915) {
                        var10000 = var29915;
                        boolean var30192 = false;
                        break;
                     }
                  }

                  var30066 = null;
               }

               Boolean var30067;
               if (var30066 == null) {
                  var30067 = null;
               } else {
                  boolean var231;
                  label222584: {
                     label222583: {
                        try {
                           if (var30066 != 0) {
                              break label222583;
                           }
                        } catch (Throwable var29989) {
                           var10000 = var29989;
                           boolean var30193 = false;
                           break;
                        }

                        var231 = false;
                        break label222584;
                     }

                     var231 = true;
                  }

                  try {
                     var30067 = var231;
                  } catch (Throwable var29914) {
                     var10000 = var29914;
                     boolean var30194 = false;
                     break;
                  }
               }

               int var192;
               try {
                  var192 = (int)var285.getLong(var117);
               } catch (Throwable var29913) {
                  var10000 = var29913;
                  boolean var30195 = false;
                  break;
               }

               int var198;
               String var273;
               label222576: {
                  label222575: {
                     try {
                        var198 = (int)var285.getLong(var34);
                        if (var285.isNull(var33)) {
                           break label222575;
                        }
                     } catch (Throwable var29988) {
                        var10000 = var29988;
                        boolean var30196 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var33);
                        break label222576;
                     } catch (Throwable var29912) {
                        var10000 = var29912;
                        boolean var30197 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               int var194;
               List var294;
               boolean var30057;
               label222569: {
                  label222568: {
                     try {
                        var294 = DeviceAlarmListConverter.fromString(var273);
                        var194 = (int)var285.getLong(var32);
                        if ((int)var285.getLong(var31) != 0) {
                           break label222568;
                        }
                     } catch (Throwable var29987) {
                        var10000 = var29987;
                        boolean var30198 = false;
                        break;
                     }

                     var30057 = false;
                     break label222569;
                  }

                  var30057 = true;
               }

               boolean var232;
               label222562: {
                  label222561: {
                     try {
                        if ((int)var285.getLong(var30) != 0) {
                           break label222561;
                        }
                     } catch (Throwable var29986) {
                        var10000 = var29986;
                        boolean var30199 = false;
                        break;
                     }

                     var232 = false;
                     break label222562;
                  }

                  var232 = true;
               }

               int var193;
               int var195;
               int var196;
               int var197;
               long var234;
               label222555: {
                  label222554: {
                     try {
                        var196 = (int)var285.getLong(var26);
                        var197 = (int)var285.getLong(var29);
                        var193 = (int)var285.getLong(var23);
                        var234 = var285.getLong(var88);
                        var195 = (int)var285.getLong(var20);
                        if (var285.isNull(var28)) {
                           break label222554;
                        }
                     } catch (Throwable var29985) {
                        var10000 = var29985;
                        boolean var30200 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var28);
                        break label222555;
                     } catch (Throwable var29911) {
                        var10000 = var29911;
                        boolean var30201 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               double[] var295;
               label222548: {
                  label223044: {
                     try {
                        var295 = DoubleArrayConverter.fromString(var273);
                        if (var285.isNull(var27) && var285.isNull(var85) && var285.isNull(var21) && var285.isNull(var25) && var285.isNull(var24)) {
                           break label223044;
                        }
                     } catch (Throwable var29984) {
                        var10000 = var29984;
                        boolean var30202 = false;
                        break;
                     }

                     label222529: {
                        label222528: {
                           try {
                              if (var285.isNull(var27)) {
                                 break label222528;
                              }
                           } catch (Throwable var29983) {
                              var10000 = var29983;
                              boolean var30203 = false;
                              break;
                           }

                           try {
                              var273 = var285.getText(var27);
                              break label222529;
                           } catch (Throwable var29910) {
                              var10000 = var29910;
                              boolean var30204 = false;
                              break;
                           }
                        }

                        var273 = null;
                     }

                     String var274;
                     label222522: {
                        label222521: {
                           try {
                              if (var285.isNull(var85)) {
                                 break label222521;
                              }
                           } catch (Throwable var29982) {
                              var10000 = var29982;
                              boolean var30205 = false;
                              break;
                           }

                           try {
                              var274 = var285.getText(var85);
                              break label222522;
                           } catch (Throwable var29909) {
                              var10000 = var29909;
                              boolean var30206 = false;
                              break;
                           }
                        }

                        var274 = null;
                     }

                     String var275;
                     label222515: {
                        label222514: {
                           try {
                              if (var285.isNull(var21)) {
                                 break label222514;
                              }
                           } catch (Throwable var29981) {
                              var10000 = var29981;
                              boolean var30207 = false;
                              break;
                           }

                           try {
                              var275 = var285.getText(var21);
                              break label222515;
                           } catch (Throwable var29908) {
                              var10000 = var29908;
                              boolean var30208 = false;
                              break;
                           }
                        }

                        var275 = null;
                     }

                     String var276;
                     label222508: {
                        label222507: {
                           try {
                              if (var285.isNull(var25)) {
                                 break label222507;
                              }
                           } catch (Throwable var29980) {
                              var10000 = var29980;
                              boolean var30209 = false;
                              break;
                           }

                           try {
                              var276 = var285.getText(var25);
                              break label222508;
                           } catch (Throwable var29907) {
                              var10000 = var29907;
                              boolean var30210 = false;
                              break;
                           }
                        }

                        var276 = null;
                     }

                     String var277;
                     label222501: {
                        label222500: {
                           try {
                              if (var285.isNull(var24)) {
                                 break label222500;
                              }
                           } catch (Throwable var29979) {
                              var10000 = var29979;
                              boolean var30211 = false;
                              break;
                           }

                           try {
                              var277 = var285.getText(var24);
                              break label222501;
                           } catch (Throwable var29906) {
                              var10000 = var29906;
                              boolean var30212 = false;
                              break;
                           }
                        }

                        var277 = null;
                     }

                     DeviceUuidEntity var278;
                     try {
                        var278 = new DeviceUuidEntity(var273, var274, var275, var276, var277);
                     } catch (Throwable var29905) {
                        var10000 = var29905;
                        boolean var30213 = false;
                        break;
                     }

                     var30070 = var278;
                     break label222548;
                  }

                  var30070 = null;
               }

               IndoorDatapoint var30072;
               label222494: {
                  label223045: {
                     try {
                        if (var285.isNull(var89) && var285.isNull(var18) && var285.isNull(var11) && var285.isNull(var22) && var285.isNull(var17) && var285.isNull(var12) && var285.isNull(var13) && var285.isNull(var14) && var285.isNull(var15) && var285.isNull(var19) && var285.isNull(var82)) {
                           break label223045;
                        }
                     } catch (Throwable var29978) {
                        var10000 = var29978;
                        boolean var30214 = false;
                        break;
                     }

                     long var242;
                     label222465: {
                        label222464: {
                           try {
                              var242 = var285.getLong(var89);
                              if (var285.isNull(var18)) {
                                 break label222464;
                              }
                           } catch (Throwable var29977) {
                              var10000 = var29977;
                              boolean var30215 = false;
                              break;
                           }

                           try {
                              var30071 = (float)var285.getDouble(var18);
                              break label222465;
                           } catch (Throwable var29904) {
                              var10000 = var29904;
                              boolean var30216 = false;
                              break;
                           }
                        }

                        var30071 = null;
                     }

                     Float var30073;
                     label222458: {
                        label222457: {
                           try {
                              if (var285.isNull(var11)) {
                                 break label222457;
                              }
                           } catch (Throwable var29976) {
                              var10000 = var29976;
                              boolean var30217 = false;
                              break;
                           }

                           try {
                              var30073 = (float)var285.getDouble(var11);
                              break label222458;
                           } catch (Throwable var29903) {
                              var10000 = var29903;
                              boolean var30218 = false;
                              break;
                           }
                        }

                        var30073 = null;
                     }

                     Float var30076;
                     label222451: {
                        label222450: {
                           try {
                              if (var285.isNull(var22)) {
                                 break label222450;
                              }
                           } catch (Throwable var29975) {
                              var10000 = var29975;
                              boolean var30219 = false;
                              break;
                           }

                           try {
                              var30076 = (float)var285.getDouble(var22);
                              break label222451;
                           } catch (Throwable var29902) {
                              var10000 = var29902;
                              boolean var30220 = false;
                              break;
                           }
                        }

                        var30076 = null;
                     }

                     Float var30079;
                     label222444: {
                        label222443: {
                           try {
                              if (var285.isNull(var17)) {
                                 break label222443;
                              }
                           } catch (Throwable var29974) {
                              var10000 = var29974;
                              boolean var30221 = false;
                              break;
                           }

                           try {
                              var30079 = (float)var285.getDouble(var17);
                              break label222444;
                           } catch (Throwable var29901) {
                              var10000 = var29901;
                              boolean var30222 = false;
                              break;
                           }
                        }

                        var30079 = null;
                     }

                     Float var30081;
                     label222437: {
                        label222436: {
                           try {
                              if (var285.isNull(var12)) {
                                 break label222436;
                              }
                           } catch (Throwable var29973) {
                              var10000 = var29973;
                              boolean var30223 = false;
                              break;
                           }

                           try {
                              var30081 = (float)var285.getDouble(var12);
                              break label222437;
                           } catch (Throwable var29900) {
                              var10000 = var29900;
                              boolean var30224 = false;
                              break;
                           }
                        }

                        var30081 = null;
                     }

                     Float var279;
                     label222430: {
                        label222429: {
                           try {
                              if (var285.isNull(var13)) {
                                 break label222429;
                              }
                           } catch (Throwable var29972) {
                              var10000 = var29972;
                              boolean var30225 = false;
                              break;
                           }

                           try {
                              var279 = (float)var285.getDouble(var13);
                              break label222430;
                           } catch (Throwable var29899) {
                              var10000 = var29899;
                              boolean var30226 = false;
                              break;
                           }
                        }

                        var279 = null;
                     }

                     Float var280;
                     label222423: {
                        label222422: {
                           try {
                              if (var285.isNull(var14)) {
                                 break label222422;
                              }
                           } catch (Throwable var29971) {
                              var10000 = var29971;
                              boolean var30227 = false;
                              break;
                           }

                           try {
                              var280 = (float)var285.getDouble(var14);
                              break label222423;
                           } catch (Throwable var29898) {
                              var10000 = var29898;
                              boolean var30228 = false;
                              break;
                           }
                        }

                        var280 = null;
                     }

                     Float var281;
                     label222416: {
                        label222415: {
                           try {
                              if (var285.isNull(var15)) {
                                 break label222415;
                              }
                           } catch (Throwable var29970) {
                              var10000 = var29970;
                              boolean var30229 = false;
                              break;
                           }

                           try {
                              var281 = (float)var285.getDouble(var15);
                              break label222416;
                           } catch (Throwable var29897) {
                              var10000 = var29897;
                              boolean var30230 = false;
                              break;
                           }
                        }

                        var281 = null;
                     }

                     Float var282;
                     label222409: {
                        label222408: {
                           try {
                              if (var285.isNull(var19)) {
                                 break label222408;
                              }
                           } catch (Throwable var29969) {
                              var10000 = var29969;
                              boolean var30231 = false;
                              break;
                           }

                           try {
                              var282 = (float)var285.getDouble(var19);
                              break label222409;
                           } catch (Throwable var29896) {
                              var10000 = var29896;
                              boolean var30232 = false;
                              break;
                           }
                        }

                        var282 = null;
                     }

                     Float var283;
                     label222402: {
                        label222401: {
                           try {
                              if (var285.isNull(var82)) {
                                 break label222401;
                              }
                           } catch (Throwable var29968) {
                              var10000 = var29968;
                              boolean var30233 = false;
                              break;
                           }

                           try {
                              var283 = (float)var285.getDouble(var82);
                              break label222402;
                           } catch (Throwable var29895) {
                              var10000 = var29895;
                              boolean var30234 = false;
                              break;
                           }
                        }

                        var283 = null;
                     }

                     IndoorDatapoint var284;
                     try {
                        var284 = new IndoorDatapoint(var242, var30071, var30073, var30076, var30079, var30081, var279, var280, var281, var282, var283);
                     } catch (Throwable var29894) {
                        var10000 = var29894;
                        boolean var30235 = false;
                        break;
                     }

                     var30072 = var284;
                     break label222494;
                  }

                  var30072 = null;
               }

               WelcomeHomeLocation var30075;
               label222395: {
                  label223046: {
                     try {
                        if (var285.isNull(var81) && var285.isNull(var9) && var285.isNull(var10) && var285.isNull(var106) && var285.isNull(var16)) {
                           break label223046;
                        }
                     } catch (Throwable var29967) {
                        var10000 = var29967;
                        boolean var30236 = false;
                        break;
                     }

                     double var3;
                     try {
                        var3 = var285.getDouble(var81);
                     } catch (Throwable var29893) {
                        var10000 = var29893;
                        boolean var30237 = false;
                        break;
                     }

                     double var7;
                     int var199;
                     label222374: {
                        label222373: {
                           try {
                              var7 = var285.getDouble(var9);
                              var199 = (int)var285.getLong(var10);
                              if (var285.isNull(var106)) {
                                 break label222373;
                              }
                           } catch (Throwable var29966) {
                              var10000 = var29966;
                              boolean var30238 = false;
                              break;
                           }

                           try {
                              var30074 = var285.getText(var106);
                              break label222374;
                           } catch (Throwable var29892) {
                              var10000 = var29892;
                              boolean var30239 = false;
                              break;
                           }
                        }

                        var30074 = null;
                     }

                     boolean var233;
                     label222366: {
                        label222365: {
                           try {
                              if ((int)var285.getLong(var16) != 0) {
                                 break label222365;
                              }
                           } catch (Throwable var29965) {
                              var10000 = var29965;
                              boolean var30240 = false;
                              break;
                           }

                           var233 = false;
                           break label222366;
                        }

                        var233 = true;
                     }

                     WelcomeHomeLocation var30077;
                     try {
                        var30077 = new WelcomeHomeLocation(var3, var7, var199, var30074, var233);
                     } catch (Throwable var29891) {
                        var10000 = var29891;
                        boolean var30241 = false;
                        break;
                     }

                     var30075 = var30077;
                     break label222395;
                  }

                  var30075 = null;
               }

               int var152;
               try {
                  var152 = (int)var285.getLong(var103);
               } catch (Throwable var29890) {
                  var10000 = var29890;
                  boolean var30242 = false;
                  break;
               }

               int var30054;
               try {
                  var30054 = (int)var285.getLong(var100);
               } catch (Throwable var29889) {
                  var10000 = var29889;
                  boolean var30243 = false;
                  break;
               }

               int var200;
               try {
                  var200 = (int)var285.getLong(var96);
               } catch (Throwable var29888) {
                  var10000 = var29888;
                  boolean var30244 = false;
                  break;
               }

               int var201;
               try {
                  var201 = (int)var285.getLong(var93);
               } catch (Throwable var29887) {
                  var10000 = var29887;
                  boolean var30245 = false;
                  break;
               }

               int var202;
               try {
                  var202 = (int)var285.getLong(var90);
               } catch (Throwable var29886) {
                  var10000 = var29886;
                  boolean var30246 = false;
                  break;
               }

               int var203;
               try {
                  var203 = (int)var285.getLong(var87);
               } catch (Throwable var29885) {
                  var10000 = var29885;
                  boolean var30247 = false;
                  break;
               }

               int var204;
               try {
                  var204 = (int)var285.getLong(var84);
               } catch (Throwable var29884) {
                  var10000 = var29884;
                  boolean var30248 = false;
                  break;
               }

               int var205;
               try {
                  var205 = (int)var285.getLong(var79);
               } catch (Throwable var29883) {
                  var10000 = var29883;
                  boolean var30249 = false;
                  break;
               }

               int var206;
               try {
                  var206 = (int)var285.getLong(var76);
               } catch (Throwable var29882) {
                  var10000 = var29882;
                  boolean var30250 = false;
                  break;
               }

               int var207;
               try {
                  var207 = (int)var285.getLong(var73);
               } catch (Throwable var29881) {
                  var10000 = var29881;
                  boolean var30251 = false;
                  break;
               }

               try {
                  int var208 = (int)var285.getLong(var66);
                  DualOscillationConfig var30078 = new DualOscillationConfig(var152, var30054, var200, var201, var202, var203, var204, var205, var206, var207, var208);
                  DeviceEntity var30080 = new DeviceEntity(var30052, var244, var245, var155, var246, var247, var248, var249, var250, var30070, var209, var30072, var251, var210, var211, var212, var252, var156, var240, var253, var254, var255, var256, var257, var258, var259, var260, var261, var262, var263, var287, var288, var289, var290, var291, var157, var213, var214, var215, var216, var217, var218, var30063, var30055, var265, var220, var266, var267, var30075, var268, var30064, var270, var271, var30056, var222, var162, var238, var159, var223, var164, var163, var161, var160, var236, var158, var166, var170, var169, var167, var171, var165, var168, var172, var173, var5, var1, var174, var177, var176, var292, var175, var293, var224, var180, var178, var179, var225, var181, var226, var227, var183, var182, var228, var229, var184, var190, var188, var191, var189, var185, var187, var186, var230, var30067, var192, var198, var294, var194, var30057, var232, var196, var197, var193, var234, var30078, var195, var295);
                  var286.add(var30080);
               } catch (Throwable var29880) {
                  var10000 = var29880;
                  boolean var30252 = false;
                  break;
               }
            }
         }

         Throwable var30053 = var10000;
         var285.close();
         throw var30053;
      }

      var285.close();
      return var286;
   }

   // $FF: synthetic method
   static List lambda$getDevices$3(SQLiteConnection var0) {
      SQLiteStatement var285 = var0.prepare("SELECT * from device_table ORDER BY modelName DESC");

      ArrayList var286;
      label223033: {
         Throwable var10000;
         label223032: {
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var153;
            int var154;
            try {
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uid");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "name");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "modelName");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "typeIndex");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fanSpeed");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterLife");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoModeText");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "brightness");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "info");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hasFinishedOnboarding");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastSelectedSensorType");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isAblDevice");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isNightModeOn");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isChildLockOn");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "linkedDeviceUid");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "connectivityStatusIndex");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastConnectivityMillis");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mac");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mcuFirmware");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wifiFirmware");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hardware");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeZone");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "serial");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "purchaseDate");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerName");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerCountry");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterType");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterTrigger");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1Ranges");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10Ranges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25Ranges");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "vocRanges");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hchoRanges");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "updateProgress");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isStandByOn");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEcoModeOn");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsModeOn");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsNightModeOn");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isG4NightModeOn");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldOn");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldNightModeOn");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isSafetySwitchOn");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "g4NightModefilterTrigger");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "aimInstalled");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sku");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "compatibility");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "locationId");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfection");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTime");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTimeUpdateTime");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryEnabled");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryOn");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTime");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTimeUpdateTime");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickUsage");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterShortage");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoRh");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerStatus");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerDuration");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTime");
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTimeUpdateTime");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "temperatureUnit");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationState");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationAngle");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationDirection");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationFanSpeed");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mainMode");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apSubMode");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apFanSpeed");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatSubMode");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatFanSpeed");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatAutoTmp");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatEcoTmp");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolSubMode");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeed");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoTag");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoPresets");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoTag");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoPresets");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humMode");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mode");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterLevel");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dehSubMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterTankFailure");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "smartSubMode");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "detectCat");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bodyMounted");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "cleanAirEta");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "panelDisplayMode");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hoverEnabled");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEnabled");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStatus");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshDuration");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshTimeStamp");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStartTimeStamp");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEndTimeStamp");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "roomType");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampBrightness");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDuration");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDone");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmEnabled");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmUsage");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampSteplessBrightness");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "alarms");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humSubMode");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "use24Hour");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterInfill");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sensorMode");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeedLevel");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoLevel");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightModeStartTime");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm1");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightPeriods");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uuid");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ssid");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bssid");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv4");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv6");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeInSeconds");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "voc");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hcho");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "tmp");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hum");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fan");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "weight");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lat");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lng");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "radius");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "textValue");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEnabled");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationMode");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationState");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationFixAngle");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMinAngle");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMaxAngle");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationState");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationFixAngle");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMinAngle");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMaxAngle");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalCalibrationState");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalCalibrationState");
               var286 = new ArrayList();
            } catch (Throwable var30051) {
               var10000 = var30051;
               boolean var10001 = false;
               break label223032;
            }

            while(true) {
               label223027: {
                  label223026: {
                     try {
                        if (!var285.step()) {
                           break label223033;
                        }

                        if (var285.isNull(var154)) {
                           break label223026;
                        }
                     } catch (Throwable var30050) {
                        var10000 = var30050;
                        boolean var30082 = false;
                        break;
                     }

                     try {
                        var30052 = var285.getText(var154);
                        break label223027;
                     } catch (Throwable var29964) {
                        var10000 = var29964;
                        boolean var30083 = false;
                        break;
                     }
                  }

                  var30052 = null;
               }

               String var244;
               label223019: {
                  label223018: {
                     try {
                        if (var285.isNull(var123)) {
                           break label223018;
                        }
                     } catch (Throwable var30049) {
                        var10000 = var30049;
                        boolean var30084 = false;
                        break;
                     }

                     try {
                        var244 = var285.getText(var123);
                        break label223019;
                     } catch (Throwable var29963) {
                        var10000 = var29963;
                        boolean var30085 = false;
                        break;
                     }
                  }

                  var244 = null;
               }

               String var245;
               label223012: {
                  label223011: {
                     try {
                        if (var285.isNull(var118)) {
                           break label223011;
                        }
                     } catch (Throwable var30048) {
                        var10000 = var30048;
                        boolean var30086 = false;
                        break;
                     }

                     try {
                        var245 = var285.getText(var118);
                        break label223012;
                     } catch (Throwable var29962) {
                        var10000 = var29962;
                        boolean var30087 = false;
                        break;
                     }
                  }

                  var245 = null;
               }

               int var155;
               Integer var246;
               label223005: {
                  label223004: {
                     try {
                        var155 = (int)var285.getLong(var121);
                        if (var285.isNull(var119)) {
                           break label223004;
                        }
                     } catch (Throwable var30047) {
                        var10000 = var30047;
                        boolean var30088 = false;
                        break;
                     }

                     try {
                        var246 = (int)var285.getLong(var119);
                        break label223005;
                     } catch (Throwable var29961) {
                        var10000 = var29961;
                        boolean var30089 = false;
                        break;
                     }
                  }

                  var246 = null;
               }

               Integer var247;
               label222998: {
                  label222997: {
                     try {
                        if (var285.isNull(var114)) {
                           break label222997;
                        }
                     } catch (Throwable var30046) {
                        var10000 = var30046;
                        boolean var30090 = false;
                        break;
                     }

                     try {
                        var247 = (int)var285.getLong(var114);
                        break label222998;
                     } catch (Throwable var29960) {
                        var10000 = var29960;
                        boolean var30091 = false;
                        break;
                     }
                  }

                  var247 = null;
               }

               String var248;
               label222991: {
                  label222990: {
                     try {
                        if (var285.isNull(var112)) {
                           break label222990;
                        }
                     } catch (Throwable var30045) {
                        var10000 = var30045;
                        boolean var30092 = false;
                        break;
                     }

                     try {
                        var248 = var285.getText(var112);
                        break label222991;
                     } catch (Throwable var29959) {
                        var10000 = var29959;
                        boolean var30093 = false;
                        break;
                     }
                  }

                  var248 = null;
               }

               Integer var249;
               label222984: {
                  label222983: {
                     try {
                        if (var285.isNull(var110)) {
                           break label222983;
                        }
                     } catch (Throwable var30044) {
                        var10000 = var30044;
                        boolean var30094 = false;
                        break;
                     }

                     try {
                        var249 = (int)var285.getLong(var110);
                        break label222984;
                     } catch (Throwable var29958) {
                        var10000 = var29958;
                        boolean var30095 = false;
                        break;
                     }
                  }

                  var249 = null;
               }

               String var250;
               label222977: {
                  label222976: {
                     try {
                        if (var285.isNull(var111)) {
                           break label222976;
                        }
                     } catch (Throwable var30043) {
                        var10000 = var30043;
                        boolean var30096 = false;
                        break;
                     }

                     try {
                        var250 = var285.getText(var111);
                        break label222977;
                     } catch (Throwable var29957) {
                        var10000 = var29957;
                        boolean var30097 = false;
                        break;
                     }
                  }

                  var250 = null;
               }

               boolean var209;
               label222970: {
                  label222969: {
                     try {
                        if ((int)var285.getLong(var107) != 0) {
                           break label222969;
                        }
                     } catch (Throwable var30042) {
                        var10000 = var30042;
                        boolean var30098 = false;
                        break;
                     }

                     var209 = false;
                     break label222970;
                  }

                  var209 = true;
               }

               Integer var251;
               label222963: {
                  label222962: {
                     try {
                        if (var285.isNull(var109)) {
                           break label222962;
                        }
                     } catch (Throwable var30041) {
                        var10000 = var30041;
                        boolean var30099 = false;
                        break;
                     }

                     try {
                        var251 = (int)var285.getLong(var109);
                        break label222963;
                     } catch (Throwable var29956) {
                        var10000 = var29956;
                        boolean var30100 = false;
                        break;
                     }
                  }

                  var251 = null;
               }

               boolean var210;
               label222956: {
                  label222955: {
                     try {
                        if ((int)var285.getLong(var115) != 0) {
                           break label222955;
                        }
                     } catch (Throwable var30040) {
                        var10000 = var30040;
                        boolean var30101 = false;
                        break;
                     }

                     var210 = false;
                     break label222956;
                  }

                  var210 = true;
               }

               boolean var211;
               label222949: {
                  label222948: {
                     try {
                        if ((int)var285.getLong(var113) != 0) {
                           break label222948;
                        }
                     } catch (Throwable var30039) {
                        var10000 = var30039;
                        boolean var30102 = false;
                        break;
                     }

                     var211 = false;
                     break label222949;
                  }

                  var211 = true;
               }

               boolean var212;
               label222942: {
                  label222941: {
                     try {
                        if ((int)var285.getLong(var108) != 0) {
                           break label222941;
                        }
                     } catch (Throwable var30038) {
                        var10000 = var30038;
                        boolean var30103 = false;
                        break;
                     }

                     var212 = false;
                     break label222942;
                  }

                  var212 = true;
               }

               String var252;
               label222935: {
                  label222934: {
                     try {
                        if (var285.isNull(var63)) {
                           break label222934;
                        }
                     } catch (Throwable var30037) {
                        var10000 = var30037;
                        boolean var30104 = false;
                        break;
                     }

                     try {
                        var252 = var285.getText(var63);
                        break label222935;
                     } catch (Throwable var29955) {
                        var10000 = var29955;
                        boolean var30105 = false;
                        break;
                     }
                  }

                  var252 = null;
               }

               int var156;
               long var242;
               String var253;
               label222928: {
                  label222927: {
                     try {
                        var156 = (int)var285.getLong(var120);
                        var242 = var285.getLong(var117);
                        if (var285.isNull(var151)) {
                           break label222927;
                        }
                     } catch (Throwable var30036) {
                        var10000 = var30036;
                        boolean var30106 = false;
                        break;
                     }

                     try {
                        var253 = var285.getText(var151);
                        break label222928;
                     } catch (Throwable var29954) {
                        var10000 = var29954;
                        boolean var30107 = false;
                        break;
                     }
                  }

                  var253 = null;
               }

               String var254;
               label222921: {
                  label222920: {
                     try {
                        if (var285.isNull(var150)) {
                           break label222920;
                        }
                     } catch (Throwable var30035) {
                        var10000 = var30035;
                        boolean var30108 = false;
                        break;
                     }

                     try {
                        var254 = var285.getText(var150);
                        break label222921;
                     } catch (Throwable var29953) {
                        var10000 = var29953;
                        boolean var30109 = false;
                        break;
                     }
                  }

                  var254 = null;
               }

               String var255;
               label222914: {
                  label222913: {
                     try {
                        if (var285.isNull(var149)) {
                           break label222913;
                        }
                     } catch (Throwable var30034) {
                        var10000 = var30034;
                        boolean var30110 = false;
                        break;
                     }

                     try {
                        var255 = var285.getText(var149);
                        break label222914;
                     } catch (Throwable var29952) {
                        var10000 = var29952;
                        boolean var30111 = false;
                        break;
                     }
                  }

                  var255 = null;
               }

               String var256;
               label222907: {
                  label222906: {
                     try {
                        if (var285.isNull(var148)) {
                           break label222906;
                        }
                     } catch (Throwable var30033) {
                        var10000 = var30033;
                        boolean var30112 = false;
                        break;
                     }

                     try {
                        var256 = var285.getText(var148);
                        break label222907;
                     } catch (Throwable var29951) {
                        var10000 = var29951;
                        boolean var30113 = false;
                        break;
                     }
                  }

                  var256 = null;
               }

               String var257;
               label222900: {
                  label222899: {
                     try {
                        if (var285.isNull(var147)) {
                           break label222899;
                        }
                     } catch (Throwable var30032) {
                        var10000 = var30032;
                        boolean var30114 = false;
                        break;
                     }

                     try {
                        var257 = var285.getText(var147);
                        break label222900;
                     } catch (Throwable var29950) {
                        var10000 = var29950;
                        boolean var30115 = false;
                        break;
                     }
                  }

                  var257 = null;
               }

               String var258;
               label222893: {
                  label222892: {
                     try {
                        if (var285.isNull(var146)) {
                           break label222892;
                        }
                     } catch (Throwable var30031) {
                        var10000 = var30031;
                        boolean var30116 = false;
                        break;
                     }

                     try {
                        var258 = var285.getText(var146);
                        break label222893;
                     } catch (Throwable var29949) {
                        var10000 = var29949;
                        boolean var30117 = false;
                        break;
                     }
                  }

                  var258 = null;
               }

               String var259;
               label222886: {
                  label222885: {
                     try {
                        if (var285.isNull(var145)) {
                           break label222885;
                        }
                     } catch (Throwable var30030) {
                        var10000 = var30030;
                        boolean var30118 = false;
                        break;
                     }

                     try {
                        var259 = var285.getText(var145);
                        break label222886;
                     } catch (Throwable var29948) {
                        var10000 = var29948;
                        boolean var30119 = false;
                        break;
                     }
                  }

                  var259 = null;
               }

               String var260;
               label222879: {
                  label222878: {
                     try {
                        if (var285.isNull(var144)) {
                           break label222878;
                        }
                     } catch (Throwable var30029) {
                        var10000 = var30029;
                        boolean var30120 = false;
                        break;
                     }

                     try {
                        var260 = var285.getText(var144);
                        break label222879;
                     } catch (Throwable var29947) {
                        var10000 = var29947;
                        boolean var30121 = false;
                        break;
                     }
                  }

                  var260 = null;
               }

               String var261;
               label222872: {
                  label222871: {
                     try {
                        if (var285.isNull(var143)) {
                           break label222871;
                        }
                     } catch (Throwable var30028) {
                        var10000 = var30028;
                        boolean var30122 = false;
                        break;
                     }

                     try {
                        var261 = var285.getText(var143);
                        break label222872;
                     } catch (Throwable var29946) {
                        var10000 = var29946;
                        boolean var30123 = false;
                        break;
                     }
                  }

                  var261 = null;
               }

               String var262;
               label222865: {
                  label222864: {
                     try {
                        if (var285.isNull(var142)) {
                           break label222864;
                        }
                     } catch (Throwable var30027) {
                        var10000 = var30027;
                        boolean var30124 = false;
                        break;
                     }

                     try {
                        var262 = var285.getText(var142);
                        break label222865;
                     } catch (Throwable var29945) {
                        var10000 = var29945;
                        boolean var30125 = false;
                        break;
                     }
                  }

                  var262 = null;
               }

               String var263;
               label222858: {
                  label222857: {
                     try {
                        if (var285.isNull(var141)) {
                           break label222857;
                        }
                     } catch (Throwable var30026) {
                        var10000 = var30026;
                        boolean var30126 = false;
                        break;
                     }

                     try {
                        var263 = var285.getText(var141);
                        break label222858;
                     } catch (Throwable var29944) {
                        var10000 = var29944;
                        boolean var30127 = false;
                        break;
                     }
                  }

                  var263 = null;
               }

               String var264;
               label222851: {
                  label222850: {
                     try {
                        if (var285.isNull(var140)) {
                           break label222850;
                        }
                     } catch (Throwable var30025) {
                        var10000 = var30025;
                        boolean var30128 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var140);
                        break label222851;
                     } catch (Throwable var29943) {
                        var10000 = var29943;
                        boolean var30129 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var287;
               try {
                  var287 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29942) {
                  var10000 = var29942;
                  boolean var30130 = false;
                  break;
               }

               label222843: {
                  label222842: {
                     try {
                        if (var285.isNull(var139)) {
                           break label222842;
                        }
                     } catch (Throwable var30024) {
                        var10000 = var30024;
                        boolean var30131 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var139);
                        break label222843;
                     } catch (Throwable var29941) {
                        var10000 = var29941;
                        boolean var30132 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var288;
               try {
                  var288 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29940) {
                  var10000 = var29940;
                  boolean var30133 = false;
                  break;
               }

               label222835: {
                  label222834: {
                     try {
                        if (var285.isNull(var138)) {
                           break label222834;
                        }
                     } catch (Throwable var30023) {
                        var10000 = var30023;
                        boolean var30134 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var138);
                        break label222835;
                     } catch (Throwable var29939) {
                        var10000 = var29939;
                        boolean var30135 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var289;
               try {
                  var289 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29938) {
                  var10000 = var29938;
                  boolean var30136 = false;
                  break;
               }

               label222827: {
                  label222826: {
                     try {
                        if (var285.isNull(var137)) {
                           break label222826;
                        }
                     } catch (Throwable var30022) {
                        var10000 = var30022;
                        boolean var30137 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var137);
                        break label222827;
                     } catch (Throwable var29937) {
                        var10000 = var29937;
                        boolean var30138 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var290;
               try {
                  var290 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29936) {
                  var10000 = var29936;
                  boolean var30139 = false;
                  break;
               }

               label222819: {
                  label222818: {
                     try {
                        if (var285.isNull(var136)) {
                           break label222818;
                        }
                     } catch (Throwable var30021) {
                        var10000 = var30021;
                        boolean var30140 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var136);
                        break label222819;
                     } catch (Throwable var29935) {
                        var10000 = var29935;
                        boolean var30141 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var291;
               try {
                  var291 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29934) {
                  var10000 = var29934;
                  boolean var30142 = false;
                  break;
               }

               int var157;
               boolean var213;
               label222811: {
                  label222810: {
                     try {
                        var157 = (int)var285.getLong(var106);
                        if ((int)var285.getLong(var104) != 0) {
                           break label222810;
                        }
                     } catch (Throwable var30020) {
                        var10000 = var30020;
                        boolean var30143 = false;
                        break;
                     }

                     var213 = false;
                     break label222811;
                  }

                  var213 = true;
               }

               boolean var214;
               label222804: {
                  label222803: {
                     try {
                        if ((int)var285.getLong(var102) != 0) {
                           break label222803;
                        }
                     } catch (Throwable var30019) {
                        var10000 = var30019;
                        boolean var30144 = false;
                        break;
                     }

                     var214 = false;
                     break label222804;
                  }

                  var214 = true;
               }

               boolean var215;
               label222797: {
                  label222796: {
                     try {
                        if ((int)var285.getLong(var101) != 0) {
                           break label222796;
                        }
                     } catch (Throwable var30018) {
                        var10000 = var30018;
                        boolean var30145 = false;
                        break;
                     }

                     var215 = false;
                     break label222797;
                  }

                  var215 = true;
               }

               boolean var216;
               label222790: {
                  label222789: {
                     try {
                        if ((int)var285.getLong(var100) != 0) {
                           break label222789;
                        }
                     } catch (Throwable var30017) {
                        var10000 = var30017;
                        boolean var30146 = false;
                        break;
                     }

                     var216 = false;
                     break label222790;
                  }

                  var216 = true;
               }

               boolean var217;
               label222783: {
                  label222782: {
                     try {
                        if ((int)var285.getLong(var96) != 0) {
                           break label222782;
                        }
                     } catch (Throwable var30016) {
                        var10000 = var30016;
                        boolean var30147 = false;
                        break;
                     }

                     var217 = false;
                     break label222783;
                  }

                  var217 = true;
               }

               boolean var218;
               label222776: {
                  label222775: {
                     try {
                        if ((int)var285.getLong(var97) != 0) {
                           break label222775;
                        }
                     } catch (Throwable var30015) {
                        var10000 = var30015;
                        boolean var30148 = false;
                        break;
                     }

                     var218 = false;
                     break label222776;
                  }

                  var218 = true;
               }

               label222769: {
                  label222768: {
                     try {
                        if (var285.isNull(var95)) {
                           break label222768;
                        }
                     } catch (Throwable var30014) {
                        var10000 = var30014;
                        boolean var30149 = false;
                        break;
                     }

                     try {
                        var30062 = (int)var285.getLong(var95);
                        break label222769;
                     } catch (Throwable var29933) {
                        var10000 = var29933;
                        boolean var30150 = false;
                        break;
                     }
                  }

                  var30062 = null;
               }

               Boolean var30063;
               if (var30062 == null) {
                  var30063 = null;
               } else {
                  boolean var219;
                  label222760: {
                     label222759: {
                        try {
                           if (var30062 != 0) {
                              break label222759;
                           }
                        } catch (Throwable var30013) {
                           var10000 = var30013;
                           boolean var30151 = false;
                           break;
                        }

                        var219 = false;
                        break label222760;
                     }

                     var219 = true;
                  }

                  try {
                     var30063 = var219;
                  } catch (Throwable var29932) {
                     var10000 = var29932;
                     boolean var30152 = false;
                     break;
                  }
               }

               boolean var30055;
               label222753: {
                  label222752: {
                     try {
                        if ((int)var285.getLong(var93) != 0) {
                           break label222752;
                        }
                     } catch (Throwable var30012) {
                        var10000 = var30012;
                        boolean var30153 = false;
                        break;
                     }

                     var30055 = false;
                     break label222753;
                  }

                  var30055 = true;
               }

               String var265;
               label222746: {
                  label222745: {
                     try {
                        if (var285.isNull(var92)) {
                           break label222745;
                        }
                     } catch (Throwable var30011) {
                        var10000 = var30011;
                        boolean var30154 = false;
                        break;
                     }

                     try {
                        var265 = var285.getText(var92);
                        break label222746;
                     } catch (Throwable var29931) {
                        var10000 = var29931;
                        boolean var30155 = false;
                        break;
                     }
                  }

                  var265 = null;
               }

               boolean var220;
               label222739: {
                  label222738: {
                     try {
                        if ((int)var285.getLong(var90) != 0) {
                           break label222738;
                        }
                     } catch (Throwable var30010) {
                        var10000 = var30010;
                        boolean var30156 = false;
                        break;
                     }

                     var220 = false;
                     break label222739;
                  }

                  var220 = true;
               }

               String var266;
               label222732: {
                  label222731: {
                     try {
                        if (var285.isNull(var135)) {
                           break label222731;
                        }
                     } catch (Throwable var30009) {
                        var10000 = var30009;
                        boolean var30157 = false;
                        break;
                     }

                     try {
                        var266 = var285.getText(var135);
                        break label222732;
                     } catch (Throwable var29930) {
                        var10000 = var29930;
                        boolean var30158 = false;
                        break;
                     }
                  }

                  var266 = null;
               }

               String var267;
               label222725: {
                  label222724: {
                     try {
                        if (var285.isNull(var87)) {
                           break label222724;
                        }
                     } catch (Throwable var30008) {
                        var10000 = var30008;
                        boolean var30159 = false;
                        break;
                     }

                     try {
                        var267 = var285.getText(var87);
                        break label222725;
                     } catch (Throwable var29929) {
                        var10000 = var29929;
                        boolean var30160 = false;
                        break;
                     }
                  }

                  var267 = null;
               }

               String var268;
               label222718: {
                  label222717: {
                     try {
                        if (var285.isNull(var134)) {
                           break label222717;
                        }
                     } catch (Throwable var30007) {
                        var10000 = var30007;
                        boolean var30161 = false;
                        break;
                     }

                     try {
                        var268 = var285.getText(var134);
                        break label222718;
                     } catch (Throwable var29928) {
                        var10000 = var29928;
                        boolean var30162 = false;
                        break;
                     }
                  }

                  var268 = null;
               }

               Integer var269;
               label222711: {
                  label222710: {
                     try {
                        if (var285.isNull(var82)) {
                           break label222710;
                        }
                     } catch (Throwable var30006) {
                        var10000 = var30006;
                        boolean var30163 = false;
                        break;
                     }

                     try {
                        var269 = (int)var285.getLong(var82);
                        break label222711;
                     } catch (Throwable var29927) {
                        var10000 = var29927;
                        boolean var30164 = false;
                        break;
                     }
                  }

                  var269 = null;
               }

               Boolean var30064;
               if (var269 == null) {
                  var30064 = null;
               } else {
                  boolean var221;
                  label222702: {
                     label222701: {
                        try {
                           if (var269 != 0) {
                              break label222701;
                           }
                        } catch (Throwable var30005) {
                           var10000 = var30005;
                           boolean var30165 = false;
                           break;
                        }

                        var221 = false;
                        break label222702;
                     }

                     var221 = true;
                  }

                  try {
                     var30064 = var221;
                  } catch (Throwable var29926) {
                     var10000 = var29926;
                     boolean var30166 = false;
                     break;
                  }
               }

               Integer var270;
               label222695: {
                  label222694: {
                     try {
                        if (var285.isNull(var80)) {
                           break label222694;
                        }
                     } catch (Throwable var30004) {
                        var10000 = var30004;
                        boolean var30167 = false;
                        break;
                     }

                     try {
                        var270 = (int)var285.getLong(var80);
                        break label222695;
                     } catch (Throwable var29925) {
                        var10000 = var29925;
                        boolean var30168 = false;
                        break;
                     }
                  }

                  var270 = null;
               }

               Long var271;
               label222688: {
                  label222687: {
                     try {
                        if (var285.isNull(var78)) {
                           break label222687;
                        }
                     } catch (Throwable var30003) {
                        var10000 = var30003;
                        boolean var30169 = false;
                        break;
                     }

                     try {
                        var271 = var285.getLong(var78);
                        break label222688;
                     } catch (Throwable var29924) {
                        var10000 = var29924;
                        boolean var30170 = false;
                        break;
                     }
                  }

                  var271 = null;
               }

               boolean var30056;
               label222681: {
                  label222680: {
                     try {
                        if ((int)var285.getLong(var77) != 0) {
                           break label222680;
                        }
                     } catch (Throwable var30002) {
                        var10000 = var30002;
                        boolean var30171 = false;
                        break;
                     }

                     var30056 = false;
                     break label222681;
                  }

                  var30056 = true;
               }

               boolean var222;
               label222674: {
                  label222673: {
                     try {
                        if ((int)var285.getLong(var75) != 0) {
                           break label222673;
                        }
                     } catch (Throwable var30001) {
                        var10000 = var30001;
                        boolean var30172 = false;
                        break;
                     }

                     var222 = false;
                     break label222674;
                  }

                  var222 = true;
               }

               int var159;
               int var164;
               boolean var223;
               long var238;
               label222667: {
                  label222666: {
                     try {
                        var159 = (int)var285.getLong(var74);
                        var238 = var285.getLong(var72);
                        var164 = (int)var285.getLong(var71);
                        if ((int)var285.getLong(var70) != 0) {
                           break label222666;
                        }
                     } catch (Throwable var30000) {
                        var10000 = var30000;
                        boolean var30173 = false;
                        break;
                     }

                     var223 = false;
                     break label222667;
                  }

                  var223 = true;
               }

               int var158;
               int var160;
               int var161;
               int var162;
               int var163;
               long var240;
               try {
                  var161 = (int)var285.getLong(var69);
                  var162 = (int)var285.getLong(var65);
                  var163 = (int)var285.getLong(var68);
                  var158 = (int)var285.getLong(var66);
                  var240 = var285.getLong(var153);
                  var160 = (int)var285.getLong(var133);
               } catch (Throwable var29923) {
                  var10000 = var29923;
                  boolean var30174 = false;
                  break;
               }

               double var3;
               double var7;
               int var165;
               int var166;
               int var167;
               int var168;
               int var169;
               int var170;
               int var171;
               int var172;
               int var173;
               try {
                  var166 = (int)var285.getLong(var64);
                  var170 = (int)var285.getLong(var62);
                  var171 = (int)var285.getLong(var61);
                  var167 = (int)var285.getLong(var60);
                  var173 = (int)var285.getLong(var59);
                  var165 = (int)var285.getLong(var58);
                  var169 = (int)var285.getLong(var57);
                  var168 = (int)var285.getLong(var56);
                  var172 = (int)var285.getLong(var55);
                  var3 = var285.getDouble(var131);
                  var7 = var285.getDouble(var132);
               } catch (Throwable var29922) {
                  var10000 = var29922;
                  boolean var30175 = false;
                  break;
               }

               int var174;
               try {
                  var174 = (int)var285.getLong(var130);
               } catch (Throwable var29921) {
                  var10000 = var29921;
                  boolean var30176 = false;
                  break;
               }

               int var175;
               int var176;
               String var272;
               label222659: {
                  label222658: {
                     try {
                        var175 = (int)var285.getLong(var54);
                        var176 = (int)var285.getLong(var53);
                        if (var285.isNull(var52)) {
                           break label222658;
                        }
                     } catch (Throwable var29999) {
                        var10000 = var29999;
                        boolean var30177 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var52);
                        break label222659;
                     } catch (Throwable var29920) {
                        var10000 = var29920;
                        boolean var30178 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               int var177;
               double[] var292;
               label222652: {
                  label222651: {
                     try {
                        var292 = DoubleArrayConverter.fromString(var272);
                        var177 = (int)var285.getLong(var129);
                        if (var285.isNull(var128)) {
                           break label222651;
                        }
                     } catch (Throwable var29998) {
                        var10000 = var29998;
                        boolean var30179 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var128);
                        break label222652;
                     } catch (Throwable var29919) {
                        var10000 = var29919;
                        boolean var30180 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               double[] var293;
               try {
                  var293 = DoubleArrayConverter.fromString(var272);
               } catch (Throwable var29918) {
                  var10000 = var29918;
                  boolean var30181 = false;
                  break;
               }

               boolean var224;
               label222644: {
                  label222643: {
                     try {
                        if ((int)var285.getLong(var51) != 0) {
                           break label222643;
                        }
                     } catch (Throwable var29997) {
                        var10000 = var29997;
                        boolean var30182 = false;
                        break;
                     }

                     var224 = false;
                     break label222644;
                  }

                  var224 = true;
               }

               int var178;
               int var179;
               int var180;
               boolean var225;
               label222637: {
                  label222636: {
                     try {
                        var179 = (int)var285.getLong(var50);
                        var178 = (int)var285.getLong(var49);
                        var180 = (int)var285.getLong(var48);
                        if ((int)var285.getLong(var47) != 0) {
                           break label222636;
                        }
                     } catch (Throwable var29996) {
                        var10000 = var29996;
                        boolean var30183 = false;
                        break;
                     }

                     var225 = false;
                     break label222637;
                  }

                  var225 = true;
               }

               int var181;
               try {
                  var181 = (int)var285.getLong(var127);
               } catch (Throwable var29917) {
                  var10000 = var29917;
                  boolean var30184 = false;
                  break;
               }

               boolean var226;
               label222629: {
                  label222628: {
                     try {
                        if ((int)var285.getLong(var126) != 0) {
                           break label222628;
                        }
                     } catch (Throwable var29995) {
                        var10000 = var29995;
                        boolean var30185 = false;
                        break;
                     }

                     var226 = false;
                     break label222629;
                  }

                  var226 = true;
               }

               boolean var227;
               label222622: {
                  label222621: {
                     try {
                        if ((int)var285.getLong(var46) != 0) {
                           break label222621;
                        }
                     } catch (Throwable var29994) {
                        var10000 = var29994;
                        boolean var30186 = false;
                        break;
                     }

                     var227 = false;
                     break label222622;
                  }

                  var227 = true;
               }

               int var182;
               int var183;
               boolean var228;
               label222615: {
                  label222614: {
                     try {
                        var182 = (int)var285.getLong(var45);
                        var183 = (int)var285.getLong(var44);
                        if ((int)var285.getLong(var43) != 0) {
                           break label222614;
                        }
                     } catch (Throwable var29993) {
                        var10000 = var29993;
                        boolean var30187 = false;
                        break;
                     }

                     var228 = false;
                     break label222615;
                  }

                  var228 = true;
               }

               boolean var229;
               label222608: {
                  label222607: {
                     try {
                        if ((int)var285.getLong(var125) != 0) {
                           break label222607;
                        }
                     } catch (Throwable var29992) {
                        var10000 = var29992;
                        boolean var30188 = false;
                        break;
                     }

                     var229 = false;
                     break label222608;
                  }

                  var229 = true;
               }

               int var184;
               try {
                  var184 = (int)var285.getLong(var124);
               } catch (Throwable var29916) {
                  var10000 = var29916;
                  boolean var30189 = false;
                  break;
               }

               int var185;
               int var186;
               int var187;
               int var188;
               int var189;
               int var190;
               int var191;
               boolean var230;
               label222600: {
                  label222599: {
                     try {
                        var191 = (int)var285.getLong(var42);
                        var189 = (int)var285.getLong(var41);
                        var186 = (int)var285.getLong(var40);
                        var188 = (int)var285.getLong(var39);
                        var190 = (int)var285.getLong(var38);
                        var187 = (int)var285.getLong(var37);
                        var185 = (int)var285.getLong(var36);
                        if ((int)var285.getLong(var35) != 0) {
                           break label222599;
                        }
                     } catch (Throwable var29991) {
                        var10000 = var29991;
                        boolean var30190 = false;
                        break;
                     }

                     var230 = false;
                     break label222600;
                  }

                  var230 = true;
               }

               label222593: {
                  label222592: {
                     try {
                        if (var285.isNull(var122)) {
                           break label222592;
                        }
                     } catch (Throwable var29990) {
                        var10000 = var29990;
                        boolean var30191 = false;
                        break;
                     }

                     try {
                        var30066 = (int)var285.getLong(var122);
                        break label222593;
                     } catch (Throwable var29915) {
                        var10000 = var29915;
                        boolean var30192 = false;
                        break;
                     }
                  }

                  var30066 = null;
               }

               Boolean var30067;
               if (var30066 == null) {
                  var30067 = null;
               } else {
                  boolean var231;
                  label222584: {
                     label222583: {
                        try {
                           if (var30066 != 0) {
                              break label222583;
                           }
                        } catch (Throwable var29989) {
                           var10000 = var29989;
                           boolean var30193 = false;
                           break;
                        }

                        var231 = false;
                        break label222584;
                     }

                     var231 = true;
                  }

                  try {
                     var30067 = var231;
                  } catch (Throwable var29914) {
                     var10000 = var29914;
                     boolean var30194 = false;
                     break;
                  }
               }

               int var192;
               try {
                  var192 = (int)var285.getLong(var116);
               } catch (Throwable var29913) {
                  var10000 = var29913;
                  boolean var30195 = false;
                  break;
               }

               int var196;
               String var273;
               label222576: {
                  label222575: {
                     try {
                        var196 = (int)var285.getLong(var34);
                        if (var285.isNull(var33)) {
                           break label222575;
                        }
                     } catch (Throwable var29988) {
                        var10000 = var29988;
                        boolean var30196 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var33);
                        break label222576;
                     } catch (Throwable var29912) {
                        var10000 = var29912;
                        boolean var30197 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               int var197;
               List var294;
               boolean var30057;
               label222569: {
                  label222568: {
                     try {
                        var294 = DeviceAlarmListConverter.fromString(var273);
                        var197 = (int)var285.getLong(var32);
                        if ((int)var285.getLong(var31) != 0) {
                           break label222568;
                        }
                     } catch (Throwable var29987) {
                        var10000 = var29987;
                        boolean var30198 = false;
                        break;
                     }

                     var30057 = false;
                     break label222569;
                  }

                  var30057 = true;
               }

               boolean var232;
               label222562: {
                  label222561: {
                     try {
                        if ((int)var285.getLong(var30) != 0) {
                           break label222561;
                        }
                     } catch (Throwable var29986) {
                        var10000 = var29986;
                        boolean var30199 = false;
                        break;
                     }

                     var232 = false;
                     break label222562;
                  }

                  var232 = true;
               }

               int var193;
               int var194;
               int var195;
               int var198;
               long var236;
               label222555: {
                  label222554: {
                     try {
                        var195 = (int)var285.getLong(var26);
                        var198 = (int)var285.getLong(var29);
                        var193 = (int)var285.getLong(var23);
                        var236 = var285.getLong(var88);
                        var194 = (int)var285.getLong(var21);
                        if (var285.isNull(var28)) {
                           break label222554;
                        }
                     } catch (Throwable var29985) {
                        var10000 = var29985;
                        boolean var30200 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var28);
                        break label222555;
                     } catch (Throwable var29911) {
                        var10000 = var29911;
                        boolean var30201 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               double[] var295;
               label222548: {
                  label223044: {
                     try {
                        var295 = DoubleArrayConverter.fromString(var273);
                        if (var285.isNull(var27) && var285.isNull(var85) && var285.isNull(var20) && var285.isNull(var25) && var285.isNull(var24)) {
                           break label223044;
                        }
                     } catch (Throwable var29984) {
                        var10000 = var29984;
                        boolean var30202 = false;
                        break;
                     }

                     label222529: {
                        label222528: {
                           try {
                              if (var285.isNull(var27)) {
                                 break label222528;
                              }
                           } catch (Throwable var29983) {
                              var10000 = var29983;
                              boolean var30203 = false;
                              break;
                           }

                           try {
                              var273 = var285.getText(var27);
                              break label222529;
                           } catch (Throwable var29910) {
                              var10000 = var29910;
                              boolean var30204 = false;
                              break;
                           }
                        }

                        var273 = null;
                     }

                     String var274;
                     label222522: {
                        label222521: {
                           try {
                              if (var285.isNull(var85)) {
                                 break label222521;
                              }
                           } catch (Throwable var29982) {
                              var10000 = var29982;
                              boolean var30205 = false;
                              break;
                           }

                           try {
                              var274 = var285.getText(var85);
                              break label222522;
                           } catch (Throwable var29909) {
                              var10000 = var29909;
                              boolean var30206 = false;
                              break;
                           }
                        }

                        var274 = null;
                     }

                     String var275;
                     label222515: {
                        label222514: {
                           try {
                              if (var285.isNull(var20)) {
                                 break label222514;
                              }
                           } catch (Throwable var29981) {
                              var10000 = var29981;
                              boolean var30207 = false;
                              break;
                           }

                           try {
                              var275 = var285.getText(var20);
                              break label222515;
                           } catch (Throwable var29908) {
                              var10000 = var29908;
                              boolean var30208 = false;
                              break;
                           }
                        }

                        var275 = null;
                     }

                     String var276;
                     label222508: {
                        label222507: {
                           try {
                              if (var285.isNull(var25)) {
                                 break label222507;
                              }
                           } catch (Throwable var29980) {
                              var10000 = var29980;
                              boolean var30209 = false;
                              break;
                           }

                           try {
                              var276 = var285.getText(var25);
                              break label222508;
                           } catch (Throwable var29907) {
                              var10000 = var29907;
                              boolean var30210 = false;
                              break;
                           }
                        }

                        var276 = null;
                     }

                     String var277;
                     label222501: {
                        label222500: {
                           try {
                              if (var285.isNull(var24)) {
                                 break label222500;
                              }
                           } catch (Throwable var29979) {
                              var10000 = var29979;
                              boolean var30211 = false;
                              break;
                           }

                           try {
                              var277 = var285.getText(var24);
                              break label222501;
                           } catch (Throwable var29906) {
                              var10000 = var29906;
                              boolean var30212 = false;
                              break;
                           }
                        }

                        var277 = null;
                     }

                     DeviceUuidEntity var278;
                     try {
                        var278 = new DeviceUuidEntity(var273, var274, var275, var276, var277);
                     } catch (Throwable var29905) {
                        var10000 = var29905;
                        boolean var30213 = false;
                        break;
                     }

                     var30070 = var278;
                     break label222548;
                  }

                  var30070 = null;
               }

               IndoorDatapoint var30072;
               label222494: {
                  label223045: {
                     try {
                        if (var285.isNull(var89) && var285.isNull(var18) && var285.isNull(var11) && var285.isNull(var22) && var285.isNull(var17) && var285.isNull(var12) && var285.isNull(var13) && var285.isNull(var14) && var285.isNull(var15) && var285.isNull(var19) && var285.isNull(var83)) {
                           break label223045;
                        }
                     } catch (Throwable var29978) {
                        var10000 = var29978;
                        boolean var30214 = false;
                        break;
                     }

                     long var234;
                     label222465: {
                        label222464: {
                           try {
                              var234 = var285.getLong(var89);
                              if (var285.isNull(var18)) {
                                 break label222464;
                              }
                           } catch (Throwable var29977) {
                              var10000 = var29977;
                              boolean var30215 = false;
                              break;
                           }

                           try {
                              var30071 = (float)var285.getDouble(var18);
                              break label222465;
                           } catch (Throwable var29904) {
                              var10000 = var29904;
                              boolean var30216 = false;
                              break;
                           }
                        }

                        var30071 = null;
                     }

                     Float var30073;
                     label222458: {
                        label222457: {
                           try {
                              if (var285.isNull(var11)) {
                                 break label222457;
                              }
                           } catch (Throwable var29976) {
                              var10000 = var29976;
                              boolean var30217 = false;
                              break;
                           }

                           try {
                              var30073 = (float)var285.getDouble(var11);
                              break label222458;
                           } catch (Throwable var29903) {
                              var10000 = var29903;
                              boolean var30218 = false;
                              break;
                           }
                        }

                        var30073 = null;
                     }

                     Float var30076;
                     label222451: {
                        label222450: {
                           try {
                              if (var285.isNull(var22)) {
                                 break label222450;
                              }
                           } catch (Throwable var29975) {
                              var10000 = var29975;
                              boolean var30219 = false;
                              break;
                           }

                           try {
                              var30076 = (float)var285.getDouble(var22);
                              break label222451;
                           } catch (Throwable var29902) {
                              var10000 = var29902;
                              boolean var30220 = false;
                              break;
                           }
                        }

                        var30076 = null;
                     }

                     Float var30079;
                     label222444: {
                        label222443: {
                           try {
                              if (var285.isNull(var17)) {
                                 break label222443;
                              }
                           } catch (Throwable var29974) {
                              var10000 = var29974;
                              boolean var30221 = false;
                              break;
                           }

                           try {
                              var30079 = (float)var285.getDouble(var17);
                              break label222444;
                           } catch (Throwable var29901) {
                              var10000 = var29901;
                              boolean var30222 = false;
                              break;
                           }
                        }

                        var30079 = null;
                     }

                     Float var30081;
                     label222437: {
                        label222436: {
                           try {
                              if (var285.isNull(var12)) {
                                 break label222436;
                              }
                           } catch (Throwable var29973) {
                              var10000 = var29973;
                              boolean var30223 = false;
                              break;
                           }

                           try {
                              var30081 = (float)var285.getDouble(var12);
                              break label222437;
                           } catch (Throwable var29900) {
                              var10000 = var29900;
                              boolean var30224 = false;
                              break;
                           }
                        }

                        var30081 = null;
                     }

                     Float var279;
                     label222430: {
                        label222429: {
                           try {
                              if (var285.isNull(var13)) {
                                 break label222429;
                              }
                           } catch (Throwable var29972) {
                              var10000 = var29972;
                              boolean var30225 = false;
                              break;
                           }

                           try {
                              var279 = (float)var285.getDouble(var13);
                              break label222430;
                           } catch (Throwable var29899) {
                              var10000 = var29899;
                              boolean var30226 = false;
                              break;
                           }
                        }

                        var279 = null;
                     }

                     Float var280;
                     label222423: {
                        label222422: {
                           try {
                              if (var285.isNull(var14)) {
                                 break label222422;
                              }
                           } catch (Throwable var29971) {
                              var10000 = var29971;
                              boolean var30227 = false;
                              break;
                           }

                           try {
                              var280 = (float)var285.getDouble(var14);
                              break label222423;
                           } catch (Throwable var29898) {
                              var10000 = var29898;
                              boolean var30228 = false;
                              break;
                           }
                        }

                        var280 = null;
                     }

                     Float var281;
                     label222416: {
                        label222415: {
                           try {
                              if (var285.isNull(var15)) {
                                 break label222415;
                              }
                           } catch (Throwable var29970) {
                              var10000 = var29970;
                              boolean var30229 = false;
                              break;
                           }

                           try {
                              var281 = (float)var285.getDouble(var15);
                              break label222416;
                           } catch (Throwable var29897) {
                              var10000 = var29897;
                              boolean var30230 = false;
                              break;
                           }
                        }

                        var281 = null;
                     }

                     Float var282;
                     label222409: {
                        label222408: {
                           try {
                              if (var285.isNull(var19)) {
                                 break label222408;
                              }
                           } catch (Throwable var29969) {
                              var10000 = var29969;
                              boolean var30231 = false;
                              break;
                           }

                           try {
                              var282 = (float)var285.getDouble(var19);
                              break label222409;
                           } catch (Throwable var29896) {
                              var10000 = var29896;
                              boolean var30232 = false;
                              break;
                           }
                        }

                        var282 = null;
                     }

                     Float var283;
                     label222402: {
                        label222401: {
                           try {
                              if (var285.isNull(var83)) {
                                 break label222401;
                              }
                           } catch (Throwable var29968) {
                              var10000 = var29968;
                              boolean var30233 = false;
                              break;
                           }

                           try {
                              var283 = (float)var285.getDouble(var83);
                              break label222402;
                           } catch (Throwable var29895) {
                              var10000 = var29895;
                              boolean var30234 = false;
                              break;
                           }
                        }

                        var283 = null;
                     }

                     IndoorDatapoint var284;
                     try {
                        var284 = new IndoorDatapoint(var234, var30071, var30073, var30076, var30079, var30081, var279, var280, var281, var282, var283);
                     } catch (Throwable var29894) {
                        var10000 = var29894;
                        boolean var30235 = false;
                        break;
                     }

                     var30072 = var284;
                     break label222494;
                  }

                  var30072 = null;
               }

               WelcomeHomeLocation var30075;
               label222395: {
                  label223046: {
                     try {
                        if (var285.isNull(var81) && var285.isNull(var9) && var285.isNull(var10) && var285.isNull(var105) && var285.isNull(var16)) {
                           break label223046;
                        }
                     } catch (Throwable var29967) {
                        var10000 = var29967;
                        boolean var30236 = false;
                        break;
                     }

                     double var5;
                     try {
                        var5 = var285.getDouble(var81);
                     } catch (Throwable var29893) {
                        var10000 = var29893;
                        boolean var30237 = false;
                        break;
                     }

                     double var1;
                     int var199;
                     label222374: {
                        label222373: {
                           try {
                              var1 = var285.getDouble(var9);
                              var199 = (int)var285.getLong(var10);
                              if (var285.isNull(var105)) {
                                 break label222373;
                              }
                           } catch (Throwable var29966) {
                              var10000 = var29966;
                              boolean var30238 = false;
                              break;
                           }

                           try {
                              var30074 = var285.getText(var105);
                              break label222374;
                           } catch (Throwable var29892) {
                              var10000 = var29892;
                              boolean var30239 = false;
                              break;
                           }
                        }

                        var30074 = null;
                     }

                     boolean var233;
                     label222366: {
                        label222365: {
                           try {
                              if ((int)var285.getLong(var16) != 0) {
                                 break label222365;
                              }
                           } catch (Throwable var29965) {
                              var10000 = var29965;
                              boolean var30240 = false;
                              break;
                           }

                           var233 = false;
                           break label222366;
                        }

                        var233 = true;
                     }

                     WelcomeHomeLocation var30077;
                     try {
                        var30077 = new WelcomeHomeLocation(var5, var1, var199, var30074, var233);
                     } catch (Throwable var29891) {
                        var10000 = var29891;
                        boolean var30241 = false;
                        break;
                     }

                     var30075 = var30077;
                     break label222395;
                  }

                  var30075 = null;
               }

               int var152;
               try {
                  var152 = (int)var285.getLong(var103);
               } catch (Throwable var29890) {
                  var10000 = var29890;
                  boolean var30242 = false;
                  break;
               }

               int var30054;
               try {
                  var30054 = (int)var285.getLong(var99);
               } catch (Throwable var29889) {
                  var10000 = var29889;
                  boolean var30243 = false;
                  break;
               }

               int var200;
               try {
                  var200 = (int)var285.getLong(var98);
               } catch (Throwable var29888) {
                  var10000 = var29888;
                  boolean var30244 = false;
                  break;
               }

               int var201;
               try {
                  var201 = (int)var285.getLong(var94);
               } catch (Throwable var29887) {
                  var10000 = var29887;
                  boolean var30245 = false;
                  break;
               }

               int var202;
               try {
                  var202 = (int)var285.getLong(var91);
               } catch (Throwable var29886) {
                  var10000 = var29886;
                  boolean var30246 = false;
                  break;
               }

               int var203;
               try {
                  var203 = (int)var285.getLong(var86);
               } catch (Throwable var29885) {
                  var10000 = var29885;
                  boolean var30247 = false;
                  break;
               }

               int var204;
               try {
                  var204 = (int)var285.getLong(var84);
               } catch (Throwable var29884) {
                  var10000 = var29884;
                  boolean var30248 = false;
                  break;
               }

               int var205;
               try {
                  var205 = (int)var285.getLong(var79);
               } catch (Throwable var29883) {
                  var10000 = var29883;
                  boolean var30249 = false;
                  break;
               }

               int var206;
               try {
                  var206 = (int)var285.getLong(var76);
               } catch (Throwable var29882) {
                  var10000 = var29882;
                  boolean var30250 = false;
                  break;
               }

               int var207;
               try {
                  var207 = (int)var285.getLong(var73);
               } catch (Throwable var29881) {
                  var10000 = var29881;
                  boolean var30251 = false;
                  break;
               }

               try {
                  int var208 = (int)var285.getLong(var67);
                  DualOscillationConfig var30078 = new DualOscillationConfig(var152, var30054, var200, var201, var202, var203, var204, var205, var206, var207, var208);
                  DeviceEntity var30080 = new DeviceEntity(var30052, var244, var245, var155, var246, var247, var248, var249, var250, var30070, var209, var30072, var251, var210, var211, var212, var252, var156, var242, var253, var254, var255, var256, var257, var258, var259, var260, var261, var262, var263, var287, var288, var289, var290, var291, var157, var213, var214, var215, var216, var217, var218, var30063, var30055, var265, var220, var266, var267, var30075, var268, var30064, var270, var271, var30056, var222, var159, var238, var164, var223, var161, var162, var163, var158, var240, var160, var166, var170, var171, var167, var173, var165, var169, var168, var172, var3, var7, var174, var175, var176, var292, var177, var293, var224, var179, var178, var180, var225, var181, var226, var227, var182, var183, var228, var229, var184, var191, var189, var186, var188, var190, var187, var185, var230, var30067, var192, var196, var294, var197, var30057, var232, var195, var198, var193, var236, var30078, var194, var295);
                  var286.add(var30080);
               } catch (Throwable var29880) {
                  var10000 = var29880;
                  boolean var30252 = false;
                  break;
               }
            }
         }

         Throwable var30053 = var10000;
         var285.close();
         throw var30053;
      }

      var285.close();
      return var286;
   }

   // $FF: synthetic method
   static DeviceEntity lambda$getFlowDevice$8(String var0, SQLiteConnection var1) {
      SQLiteStatement var231;
      label197485: {
         Throwable var10000;
         label197487: {
            var231 = var1.prepare("SELECT * from device_table WHERE uid = ?");
            if (var0 == null) {
               try {
                  var231.bindNull(1);
               } catch (Throwable var23192) {
                  var10000 = var23192;
                  boolean var10001 = false;
                  break label197487;
               }
            } else {
               try {
                  var231.bindText(1, var0);
               } catch (Throwable var23191) {
                  var10000 = var23191;
                  boolean var23280 = false;
                  break label197487;
               }
            }

            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var152;
            int var153;
            int var154;
            boolean var155;
            try {
               var152 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "uid");
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "name");
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "modelName");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "typeIndex");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "fanSpeed");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterLife");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "autoModeText");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "brightness");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "info");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hasFinishedOnboarding");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lastSelectedSensorType");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isAblDevice");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isNightModeOn");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isChildLockOn");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "linkedDeviceUid");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "connectivityStatusIndex");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lastConnectivityMillis");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mac");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mcuFirmware");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wifiFirmware");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hardware");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timeZone");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "serial");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "purchaseDate");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dealerName");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dealerCountry");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterType");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterTrigger");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm1Ranges");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm10Ranges");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm25Ranges");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "vocRanges");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hchoRanges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "updateProgress");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isStandByOn");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isEcoModeOn");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isHinsModeOn");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isHinsNightModeOn");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isG4NightModeOn");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isGermShieldOn");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isGermShieldNightModeOn");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isSafetySwitchOn");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "g4NightModefilterTrigger");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "aimInstalled");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "sku");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "compatibility");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "locationId");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfection");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfectLeftTime");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfectLeftTimeUpdateTime");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryEnabled");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryOn");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryLeftTime");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryLeftTimeUpdateTime");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickUsage");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterShortage");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "autoRh");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerStatus");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerDuration");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerLeftTime");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerLeftTimeUpdateTime");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "temperatureUnit");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationState");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationAngle");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationDirection");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationFanSpeed");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mainMode");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "apSubMode");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "apFanSpeed");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatSubMode");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatFanSpeed");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatAutoTmp");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatEcoTmp");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolSubMode");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolFanSpeed");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoTag");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoPresets");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolEcoTag");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolEcoPresets");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "humMode");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mode");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterLevel");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dehSubMode");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterTankFailure");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "smartSubMode");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "detectCat");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "bodyMounted");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "cleanAirEta");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "panelDisplayMode");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hoverEnabled");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshEnabled");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshStatus");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshDuration");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshTimeStamp");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshStartTimeStamp");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshEndTimeStamp");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "roomType");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightLampBrightness");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryDuration");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryDone");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ywrmEnabled");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ywrmUsage");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightLampSteplessBrightness");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "alarms");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "humSubMode");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "use24Hour");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterInfill");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "sensorMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolFanSpeedLevel");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoLevel");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightModeStartTime");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "rpm1");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightPeriods");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "uuid");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ssid");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "bssid");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ipv4");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ipv6");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timeInSeconds");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm1");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm10");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm25");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "voc");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hcho");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "tmp");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hum");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "fan");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "weight");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "rpm");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lat");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lng");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "radius");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "textValue");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isEnabled");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationMode");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationState");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationFixAngle");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationMinAngle");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationMaxAngle");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationState");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationFixAngle");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationMinAngle");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationMaxAngle");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalCalibrationState");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalCalibrationState");
               var155 = var231.step();
            } catch (Throwable var23190) {
               var10000 = var23190;
               boolean var23281 = false;
               break label197487;
            }

            var23193 = null;
            Object var229 = null;
            if (!var155) {
               break label197485;
            }

            label197473: {
               label197472: {
                  try {
                     if (var231.isNull(var152)) {
                        break label197472;
                     }
                  } catch (Throwable var23189) {
                     var10000 = var23189;
                     boolean var23282 = false;
                     break label197487;
                  }

                  try {
                     var0 = var231.getText(var152);
                     break label197473;
                  } catch (Throwable var23188) {
                     var10000 = var23188;
                     boolean var23283 = false;
                     break label197487;
                  }
               }

               var0 = null;
            }

            label197464: {
               label197463: {
                  try {
                     if (var231.isNull(var154)) {
                        break label197463;
                     }
                  } catch (Throwable var23187) {
                     var10000 = var23187;
                     boolean var23284 = false;
                     break label197487;
                  }

                  try {
                     var23196 = var231.getText(var154);
                     break label197464;
                  } catch (Throwable var23186) {
                     var10000 = var23186;
                     boolean var23285 = false;
                     break label197487;
                  }
               }

               var23196 = null;
            }

            String var190;
            label197455: {
               label197454: {
                  try {
                     if (var231.isNull(var153)) {
                        break label197454;
                     }
                  } catch (Throwable var23185) {
                     var10000 = var23185;
                     boolean var23286 = false;
                     break label197487;
                  }

                  try {
                     var190 = var231.getText(var153);
                     break label197455;
                  } catch (Throwable var23184) {
                     var10000 = var23184;
                     boolean var23287 = false;
                     break label197487;
                  }
               }

               var190 = null;
            }

            Integer var191;
            label197446: {
               label197445: {
                  try {
                     var13 = (int)var231.getLong(var13);
                     if (var231.isNull(var147)) {
                        break label197445;
                     }
                  } catch (Throwable var23183) {
                     var10000 = var23183;
                     boolean var23288 = false;
                     break label197487;
                  }

                  try {
                     var191 = (int)var231.getLong(var147);
                     break label197446;
                  } catch (Throwable var23182) {
                     var10000 = var23182;
                     boolean var23289 = false;
                     break label197487;
                  }
               }

               var191 = null;
            }

            Integer var192;
            label197437: {
               label197436: {
                  try {
                     if (var231.isNull(var144)) {
                        break label197436;
                     }
                  } catch (Throwable var23181) {
                     var10000 = var23181;
                     boolean var23290 = false;
                     break label197487;
                  }

                  try {
                     var192 = (int)var231.getLong(var144);
                     break label197437;
                  } catch (Throwable var23180) {
                     var10000 = var23180;
                     boolean var23291 = false;
                     break label197487;
                  }
               }

               var192 = null;
            }

            String var193;
            label197428: {
               label197427: {
                  try {
                     if (var231.isNull(var142)) {
                        break label197427;
                     }
                  } catch (Throwable var23179) {
                     var10000 = var23179;
                     boolean var23292 = false;
                     break label197487;
                  }

                  try {
                     var193 = var231.getText(var142);
                     break label197428;
                  } catch (Throwable var23178) {
                     var10000 = var23178;
                     boolean var23293 = false;
                     break label197487;
                  }
               }

               var193 = null;
            }

            Integer var194;
            label197419: {
               label197418: {
                  try {
                     if (var231.isNull(var148)) {
                        break label197418;
                     }
                  } catch (Throwable var23177) {
                     var10000 = var23177;
                     boolean var23294 = false;
                     break label197487;
                  }

                  try {
                     var194 = (int)var231.getLong(var148);
                     break label197419;
                  } catch (Throwable var23176) {
                     var10000 = var23176;
                     boolean var23295 = false;
                     break label197487;
                  }
               }

               var194 = null;
            }

            String var195;
            label197410: {
               label197409: {
                  try {
                     if (var231.isNull(var149)) {
                        break label197409;
                     }
                  } catch (Throwable var23175) {
                     var10000 = var23175;
                     boolean var23296 = false;
                     break label197487;
                  }

                  try {
                     var195 = var231.getText(var149);
                     break label197410;
                  } catch (Throwable var23174) {
                     var10000 = var23174;
                     boolean var23297 = false;
                     break label197487;
                  }
               }

               var195 = null;
            }

            label197401: {
               label197400: {
                  try {
                     if ((int)var231.getLong(var143) != 0) {
                        break label197400;
                     }
                  } catch (Throwable var23173) {
                     var10000 = var23173;
                     boolean var23298 = false;
                     break label197487;
                  }

                  var155 = false;
                  break label197401;
               }

               var155 = true;
            }

            Integer var196;
            label197393: {
               label197392: {
                  try {
                     if (var231.isNull(var141)) {
                        break label197392;
                     }
                  } catch (Throwable var23172) {
                     var10000 = var23172;
                     boolean var23299 = false;
                     break label197487;
                  }

                  try {
                     var196 = (int)var231.getLong(var141);
                     break label197393;
                  } catch (Throwable var23171) {
                     var10000 = var23171;
                     boolean var23300 = false;
                     break label197487;
                  }
               }

               var196 = null;
            }

            boolean var156;
            label197384: {
               label197383: {
                  try {
                     if ((int)var231.getLong(var150) != 0) {
                        break label197383;
                     }
                  } catch (Throwable var23170) {
                     var10000 = var23170;
                     boolean var23301 = false;
                     break label197487;
                  }

                  var156 = false;
                  break label197384;
               }

               var156 = true;
            }

            boolean var157;
            label197376: {
               label197375: {
                  try {
                     if ((int)var231.getLong(var151) != 0) {
                        break label197375;
                     }
                  } catch (Throwable var23169) {
                     var10000 = var23169;
                     boolean var23302 = false;
                     break label197487;
                  }

                  var157 = false;
                  break label197376;
               }

               var157 = true;
            }

            boolean var158;
            label197368: {
               label197367: {
                  try {
                     if ((int)var231.getLong(var145) != 0) {
                        break label197367;
                     }
                  } catch (Throwable var23168) {
                     var10000 = var23168;
                     boolean var23303 = false;
                     break label197487;
                  }

                  var158 = false;
                  break label197368;
               }

               var158 = true;
            }

            String var197;
            label197360: {
               label197359: {
                  try {
                     if (var231.isNull(var146)) {
                        break label197359;
                     }
                  } catch (Throwable var23167) {
                     var10000 = var23167;
                     boolean var23304 = false;
                     break label197487;
                  }

                  try {
                     var197 = var231.getText(var146);
                     break label197360;
                  } catch (Throwable var23166) {
                     var10000 = var23166;
                     boolean var23305 = false;
                     break label197487;
                  }
               }

               var197 = null;
            }

            long var182;
            String var198;
            label197351: {
               label197350: {
                  try {
                     var51 = (int)var231.getLong(var51);
                     var182 = var231.getLong(var80);
                     if (var231.isNull(var126)) {
                        break label197350;
                     }
                  } catch (Throwable var23165) {
                     var10000 = var23165;
                     boolean var23306 = false;
                     break label197487;
                  }

                  try {
                     var198 = var231.getText(var126);
                     break label197351;
                  } catch (Throwable var23164) {
                     var10000 = var23164;
                     boolean var23307 = false;
                     break label197487;
                  }
               }

               var198 = null;
            }

            String var199;
            label197342: {
               label197341: {
                  try {
                     if (var231.isNull(var125)) {
                        break label197341;
                     }
                  } catch (Throwable var23163) {
                     var10000 = var23163;
                     boolean var23308 = false;
                     break label197487;
                  }

                  try {
                     var199 = var231.getText(var125);
                     break label197342;
                  } catch (Throwable var23162) {
                     var10000 = var23162;
                     boolean var23309 = false;
                     break label197487;
                  }
               }

               var199 = null;
            }

            String var200;
            label197333: {
               label197332: {
                  try {
                     if (var231.isNull(var134)) {
                        break label197332;
                     }
                  } catch (Throwable var23161) {
                     var10000 = var23161;
                     boolean var23310 = false;
                     break label197487;
                  }

                  try {
                     var200 = var231.getText(var134);
                     break label197333;
                  } catch (Throwable var23160) {
                     var10000 = var23160;
                     boolean var23311 = false;
                     break label197487;
                  }
               }

               var200 = null;
            }

            String var201;
            label197324: {
               label197323: {
                  try {
                     if (var231.isNull(var135)) {
                        break label197323;
                     }
                  } catch (Throwable var23159) {
                     var10000 = var23159;
                     boolean var23312 = false;
                     break label197487;
                  }

                  try {
                     var201 = var231.getText(var135);
                     break label197324;
                  } catch (Throwable var23158) {
                     var10000 = var23158;
                     boolean var23313 = false;
                     break label197487;
                  }
               }

               var201 = null;
            }

            String var202;
            label197315: {
               label197314: {
                  try {
                     if (var231.isNull(var133)) {
                        break label197314;
                     }
                  } catch (Throwable var23157) {
                     var10000 = var23157;
                     boolean var23314 = false;
                     break label197487;
                  }

                  try {
                     var202 = var231.getText(var133);
                     break label197315;
                  } catch (Throwable var23156) {
                     var10000 = var23156;
                     boolean var23315 = false;
                     break label197487;
                  }
               }

               var202 = null;
            }

            String var203;
            label197306: {
               label197305: {
                  try {
                     if (var231.isNull(var139)) {
                        break label197305;
                     }
                  } catch (Throwable var23155) {
                     var10000 = var23155;
                     boolean var23316 = false;
                     break label197487;
                  }

                  try {
                     var203 = var231.getText(var139);
                     break label197306;
                  } catch (Throwable var23154) {
                     var10000 = var23154;
                     boolean var23317 = false;
                     break label197487;
                  }
               }

               var203 = null;
            }

            String var204;
            label197297: {
               label197296: {
                  try {
                     if (var231.isNull(var132)) {
                        break label197296;
                     }
                  } catch (Throwable var23153) {
                     var10000 = var23153;
                     boolean var23318 = false;
                     break label197487;
                  }

                  try {
                     var204 = var231.getText(var132);
                     break label197297;
                  } catch (Throwable var23152) {
                     var10000 = var23152;
                     boolean var23319 = false;
                     break label197487;
                  }
               }

               var204 = null;
            }

            String var205;
            label197288: {
               label197287: {
                  try {
                     if (var231.isNull(var140)) {
                        break label197287;
                     }
                  } catch (Throwable var23151) {
                     var10000 = var23151;
                     boolean var23320 = false;
                     break label197487;
                  }

                  try {
                     var205 = var231.getText(var140);
                     break label197288;
                  } catch (Throwable var23150) {
                     var10000 = var23150;
                     boolean var23321 = false;
                     break label197487;
                  }
               }

               var205 = null;
            }

            String var206;
            label197279: {
               label197278: {
                  try {
                     if (var231.isNull(var130)) {
                        break label197278;
                     }
                  } catch (Throwable var23149) {
                     var10000 = var23149;
                     boolean var23322 = false;
                     break label197487;
                  }

                  try {
                     var206 = var231.getText(var130);
                     break label197279;
                  } catch (Throwable var23148) {
                     var10000 = var23148;
                     boolean var23323 = false;
                     break label197487;
                  }
               }

               var206 = null;
            }

            String var207;
            label197270: {
               label197269: {
                  try {
                     if (var231.isNull(var128)) {
                        break label197269;
                     }
                  } catch (Throwable var23147) {
                     var10000 = var23147;
                     boolean var23324 = false;
                     break label197487;
                  }

                  try {
                     var207 = var231.getText(var128);
                     break label197270;
                  } catch (Throwable var23146) {
                     var10000 = var23146;
                     boolean var23325 = false;
                     break label197487;
                  }
               }

               var207 = null;
            }

            String var208;
            label197261: {
               label197260: {
                  try {
                     if (var231.isNull(var124)) {
                        break label197260;
                     }
                  } catch (Throwable var23145) {
                     var10000 = var23145;
                     boolean var23326 = false;
                     break label197487;
                  }

                  try {
                     var208 = var231.getText(var124);
                     break label197261;
                  } catch (Throwable var23144) {
                     var10000 = var23144;
                     boolean var23327 = false;
                     break label197487;
                  }
               }

               var208 = null;
            }

            String var209;
            label197252: {
               label197251: {
                  try {
                     if (var231.isNull(var127)) {
                        break label197251;
                     }
                  } catch (Throwable var23143) {
                     var10000 = var23143;
                     boolean var23328 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var127);
                     break label197252;
                  } catch (Throwable var23142) {
                     var10000 = var23142;
                     boolean var23329 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var232;
            label197243: {
               label197242: {
                  try {
                     var232 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var129)) {
                        break label197242;
                     }
                  } catch (Throwable var23141) {
                     var10000 = var23141;
                     boolean var23330 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var129);
                     break label197243;
                  } catch (Throwable var23140) {
                     var10000 = var23140;
                     boolean var23331 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var233;
            label197234: {
               label197233: {
                  try {
                     var233 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var137)) {
                        break label197233;
                     }
                  } catch (Throwable var23139) {
                     var10000 = var23139;
                     boolean var23332 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var137);
                     break label197234;
                  } catch (Throwable var23138) {
                     var10000 = var23138;
                     boolean var23333 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var234;
            label197225: {
               label197224: {
                  try {
                     var234 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var131)) {
                        break label197224;
                     }
                  } catch (Throwable var23137) {
                     var10000 = var23137;
                     boolean var23334 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var131);
                     break label197225;
                  } catch (Throwable var23136) {
                     var10000 = var23136;
                     boolean var23335 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var235;
            label197216: {
               label197215: {
                  try {
                     var235 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var136)) {
                        break label197215;
                     }
                  } catch (Throwable var23135) {
                     var10000 = var23135;
                     boolean var23336 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var136);
                     break label197216;
                  } catch (Throwable var23134) {
                     var10000 = var23134;
                     boolean var23337 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            boolean var159;
            double[] var236;
            label197207: {
               label197206: {
                  try {
                     var236 = DoubleArrayConverter.fromString(var209);
                     var80 = (int)var231.getLong(var138);
                     if ((int)var231.getLong(var123) != 0) {
                        break label197206;
                     }
                  } catch (Throwable var23133) {
                     var10000 = var23133;
                     boolean var23338 = false;
                     break label197487;
                  }

                  var159 = false;
                  break label197207;
               }

               var159 = true;
            }

            boolean var160;
            label197199: {
               label197198: {
                  try {
                     if ((int)var231.getLong(var110) != 0) {
                        break label197198;
                     }
                  } catch (Throwable var23132) {
                     var10000 = var23132;
                     boolean var23339 = false;
                     break label197487;
                  }

                  var160 = false;
                  break label197199;
               }

               var160 = true;
            }

            boolean var161;
            label197191: {
               label197190: {
                  try {
                     if ((int)var231.getLong(var105) != 0) {
                        break label197190;
                     }
                  } catch (Throwable var23131) {
                     var10000 = var23131;
                     boolean var23340 = false;
                     break label197487;
                  }

                  var161 = false;
                  break label197191;
               }

               var161 = true;
            }

            boolean var162;
            label197183: {
               label197182: {
                  try {
                     if ((int)var231.getLong(var117) != 0) {
                        break label197182;
                     }
                  } catch (Throwable var23130) {
                     var10000 = var23130;
                     boolean var23341 = false;
                     break label197487;
                  }

                  var162 = false;
                  break label197183;
               }

               var162 = true;
            }

            boolean var163;
            label197175: {
               label197174: {
                  try {
                     if ((int)var231.getLong(var107) != 0) {
                        break label197174;
                     }
                  } catch (Throwable var23129) {
                     var10000 = var23129;
                     boolean var23342 = false;
                     break label197487;
                  }

                  var163 = false;
                  break label197175;
               }

               var163 = true;
            }

            boolean var164;
            label197167: {
               label197166: {
                  try {
                     if ((int)var231.getLong(var114) != 0) {
                        break label197166;
                     }
                  } catch (Throwable var23128) {
                     var10000 = var23128;
                     boolean var23343 = false;
                     break label197487;
                  }

                  var164 = false;
                  break label197167;
               }

               var164 = true;
            }

            label197159: {
               label197158: {
                  try {
                     if (var231.isNull(var120)) {
                        break label197158;
                     }
                  } catch (Throwable var23127) {
                     var10000 = var23127;
                     boolean var23344 = false;
                     break label197487;
                  }

                  try {
                     var23261 = (int)var231.getLong(var120);
                     break label197159;
                  } catch (Throwable var23126) {
                     var10000 = var23126;
                     boolean var23345 = false;
                     break label197487;
                  }
               }

               var23261 = null;
            }

            Boolean var23262;
            if (var23261 == null) {
               var23262 = null;
            } else {
               boolean var165;
               label197148: {
                  label197147: {
                     try {
                        if (var23261 != 0) {
                           break label197147;
                        }
                     } catch (Throwable var23125) {
                        var10000 = var23125;
                        boolean var23346 = false;
                        break label197487;
                     }

                     var165 = false;
                     break label197148;
                  }

                  var165 = true;
               }

               try {
                  var23262 = var165;
               } catch (Throwable var23124) {
                  var10000 = var23124;
                  boolean var23347 = false;
                  break label197487;
               }
            }

            boolean var23254;
            label197139: {
               label197138: {
                  try {
                     if ((int)var231.getLong(var109) != 0) {
                        break label197138;
                     }
                  } catch (Throwable var23123) {
                     var10000 = var23123;
                     boolean var23348 = false;
                     break label197487;
                  }

                  var23254 = false;
                  break label197139;
               }

               var23254 = true;
            }

            String var210;
            label197131: {
               label197130: {
                  try {
                     if (var231.isNull(var108)) {
                        break label197130;
                     }
                  } catch (Throwable var23122) {
                     var10000 = var23122;
                     boolean var23349 = false;
                     break label197487;
                  }

                  try {
                     var210 = var231.getText(var108);
                     break label197131;
                  } catch (Throwable var23121) {
                     var10000 = var23121;
                     boolean var23350 = false;
                     break label197487;
                  }
               }

               var210 = null;
            }

            boolean var166;
            label197122: {
               label197121: {
                  try {
                     if ((int)var231.getLong(var122) != 0) {
                        break label197121;
                     }
                  } catch (Throwable var23120) {
                     var10000 = var23120;
                     boolean var23351 = false;
                     break label197487;
                  }

                  var166 = false;
                  break label197122;
               }

               var166 = true;
            }

            String var211;
            label197114: {
               label197113: {
                  try {
                     if (var231.isNull(var106)) {
                        break label197113;
                     }
                  } catch (Throwable var23119) {
                     var10000 = var23119;
                     boolean var23352 = false;
                     break label197487;
                  }

                  try {
                     var211 = var231.getText(var106);
                     break label197114;
                  } catch (Throwable var23118) {
                     var10000 = var23118;
                     boolean var23353 = false;
                     break label197487;
                  }
               }

               var211 = null;
            }

            String var212;
            label197105: {
               label197104: {
                  try {
                     if (var231.isNull(var115)) {
                        break label197104;
                     }
                  } catch (Throwable var23117) {
                     var10000 = var23117;
                     boolean var23354 = false;
                     break label197487;
                  }

                  try {
                     var212 = var231.getText(var115);
                     break label197105;
                  } catch (Throwable var23116) {
                     var10000 = var23116;
                     boolean var23355 = false;
                     break label197487;
                  }
               }

               var212 = null;
            }

            String var213;
            label197096: {
               label197095: {
                  try {
                     if (var231.isNull(var116)) {
                        break label197095;
                     }
                  } catch (Throwable var23115) {
                     var10000 = var23115;
                     boolean var23356 = false;
                     break label197487;
                  }

                  try {
                     var213 = var231.getText(var116);
                     break label197096;
                  } catch (Throwable var23114) {
                     var10000 = var23114;
                     boolean var23357 = false;
                     break label197487;
                  }
               }

               var213 = null;
            }

            Integer var214;
            label197087: {
               label197086: {
                  try {
                     if (var231.isNull(var111)) {
                        break label197086;
                     }
                  } catch (Throwable var23113) {
                     var10000 = var23113;
                     boolean var23358 = false;
                     break label197487;
                  }

                  try {
                     var214 = (int)var231.getLong(var111);
                     break label197087;
                  } catch (Throwable var23112) {
                     var10000 = var23112;
                     boolean var23359 = false;
                     break label197487;
                  }
               }

               var214 = null;
            }

            Boolean var23263;
            if (var214 == null) {
               var23263 = null;
            } else {
               boolean var167;
               label197076: {
                  label197075: {
                     try {
                        if (var214 != 0) {
                           break label197075;
                        }
                     } catch (Throwable var23111) {
                        var10000 = var23111;
                        boolean var23360 = false;
                        break label197487;
                     }

                     var167 = false;
                     break label197076;
                  }

                  var167 = true;
               }

               try {
                  var23263 = var167;
               } catch (Throwable var23110) {
                  var10000 = var23110;
                  boolean var23361 = false;
                  break label197487;
               }
            }

            Integer var215;
            label197067: {
               label197066: {
                  try {
                     if (var231.isNull(var113)) {
                        break label197066;
                     }
                  } catch (Throwable var23109) {
                     var10000 = var23109;
                     boolean var23362 = false;
                     break label197487;
                  }

                  try {
                     var215 = (int)var231.getLong(var113);
                     break label197067;
                  } catch (Throwable var23108) {
                     var10000 = var23108;
                     boolean var23363 = false;
                     break label197487;
                  }
               }

               var215 = null;
            }

            Long var216;
            label197058: {
               label197057: {
                  try {
                     if (var231.isNull(var119)) {
                        break label197057;
                     }
                  } catch (Throwable var23107) {
                     var10000 = var23107;
                     boolean var23364 = false;
                     break label197487;
                  }

                  try {
                     var216 = var231.getLong(var119);
                     break label197058;
                  } catch (Throwable var23106) {
                     var10000 = var23106;
                     boolean var23365 = false;
                     break label197487;
                  }
               }

               var216 = null;
            }

            boolean var23255;
            label197049: {
               label197048: {
                  try {
                     if ((int)var231.getLong(var118) != 0) {
                        break label197048;
                     }
                  } catch (Throwable var23105) {
                     var10000 = var23105;
                     boolean var23366 = false;
                     break label197487;
                  }

                  var23255 = false;
                  break label197049;
               }

               var23255 = true;
            }

            boolean var168;
            label197041: {
               label197040: {
                  try {
                     if ((int)var231.getLong(var121) != 0) {
                        break label197040;
                     }
                  } catch (Throwable var23104) {
                     var10000 = var23104;
                     boolean var23367 = false;
                     break label197487;
                  }

                  var168 = false;
                  break label197041;
               }

               var168 = true;
            }

            boolean var169;
            long var180;
            label197033: {
               label197032: {
                  try {
                     var105 = (int)var231.getLong(var112);
                     var180 = var231.getLong(var103);
                     var103 = (int)var231.getLong(var104);
                     if ((int)var231.getLong(var101) != 0) {
                        break label197032;
                     }
                  } catch (Throwable var23103) {
                     var10000 = var23103;
                     boolean var23368 = false;
                     break label197487;
                  }

                  var169 = false;
                  break label197033;
               }

               var169 = true;
            }

            double var2;
            double var8;
            long var186;
            String var217;
            label197025: {
               label197024: {
                  try {
                     var101 = (int)var231.getLong(var102);
                     var100 = (int)var231.getLong(var100);
                     var99 = (int)var231.getLong(var99);
                     var98 = (int)var231.getLong(var98);
                     var186 = var231.getLong(var96);
                     var96 = (int)var231.getLong(var97);
                     var95 = (int)var231.getLong(var95);
                     var94 = (int)var231.getLong(var94);
                     var93 = (int)var231.getLong(var93);
                     var92 = (int)var231.getLong(var92);
                     var91 = (int)var231.getLong(var91);
                     var90 = (int)var231.getLong(var90);
                     var89 = (int)var231.getLong(var89);
                     var88 = (int)var231.getLong(var88);
                     var87 = (int)var231.getLong(var87);
                     var8 = var231.getDouble(var86);
                     var2 = var231.getDouble(var85);
                     var84 = (int)var231.getLong(var84);
                     var83 = (int)var231.getLong(var83);
                     var82 = (int)var231.getLong(var82);
                     if (var231.isNull(var79)) {
                        break label197024;
                     }
                  } catch (Throwable var23102) {
                     var10000 = var23102;
                     boolean var23369 = false;
                     break label197487;
                  }

                  try {
                     var217 = var231.getText(var79);
                     break label197025;
                  } catch (Throwable var23101) {
                     var10000 = var23101;
                     boolean var23370 = false;
                     break label197487;
                  }
               }

               var217 = null;
            }

            double[] var237;
            label197016: {
               label197015: {
                  try {
                     var237 = DoubleArrayConverter.fromString(var217);
                     var79 = (int)var231.getLong(var81);
                     if (var231.isNull(var78)) {
                        break label197015;
                     }
                  } catch (Throwable var23100) {
                     var10000 = var23100;
                     boolean var23371 = false;
                     break label197487;
                  }

                  try {
                     var217 = var231.getText(var78);
                     break label197016;
                  } catch (Throwable var23099) {
                     var10000 = var23099;
                     boolean var23372 = false;
                     break label197487;
                  }
               }

               var217 = null;
            }

            boolean var170;
            double[] var238;
            label197007: {
               label197006: {
                  try {
                     var238 = DoubleArrayConverter.fromString(var217);
                     if ((int)var231.getLong(var76) != 0) {
                        break label197006;
                     }
                  } catch (Throwable var23098) {
                     var10000 = var23098;
                     boolean var23373 = false;
                     break label197487;
                  }

                  var170 = false;
                  break label197007;
               }

               var170 = true;
            }

            boolean var171;
            label196999: {
               label196998: {
                  try {
                     var76 = (int)var231.getLong(var77);
                     var75 = (int)var231.getLong(var75);
                     var74 = (int)var231.getLong(var74);
                     if ((int)var231.getLong(var73) != 0) {
                        break label196998;
                     }
                  } catch (Throwable var23097) {
                     var10000 = var23097;
                     boolean var23374 = false;
                     break label197487;
                  }

                  var171 = false;
                  break label196999;
               }

               var171 = true;
            }

            boolean var172;
            label196991: {
               label196990: {
                  try {
                     var72 = (int)var231.getLong(var72);
                     if ((int)var231.getLong(var69) != 0) {
                        break label196990;
                     }
                  } catch (Throwable var23096) {
                     var10000 = var23096;
                     boolean var23375 = false;
                     break label197487;
                  }

                  var172 = false;
                  break label196991;
               }

               var172 = true;
            }

            boolean var173;
            label196983: {
               label196982: {
                  try {
                     if ((int)var231.getLong(var70) != 0) {
                        break label196982;
                     }
                  } catch (Throwable var23095) {
                     var10000 = var23095;
                     boolean var23376 = false;
                     break label197487;
                  }

                  var173 = false;
                  break label196983;
               }

               var173 = true;
            }

            boolean var174;
            label196975: {
               label196974: {
                  try {
                     var69 = (int)var231.getLong(var71);
                     var68 = (int)var231.getLong(var68);
                     if ((int)var231.getLong(var65) != 0) {
                        break label196974;
                     }
                  } catch (Throwable var23094) {
                     var10000 = var23094;
                     boolean var23377 = false;
                     break label197487;
                  }

                  var174 = false;
                  break label196975;
               }

               var174 = true;
            }

            boolean var175;
            label196967: {
               label196966: {
                  try {
                     if ((int)var231.getLong(var67) != 0) {
                        break label196966;
                     }
                  } catch (Throwable var23093) {
                     var10000 = var23093;
                     boolean var23378 = false;
                     break label197487;
                  }

                  var175 = false;
                  break label196967;
               }

               var175 = true;
            }

            boolean var176;
            label196959: {
               label196958: {
                  try {
                     var65 = (int)var231.getLong(var66);
                     var64 = (int)var231.getLong(var64);
                     var63 = (int)var231.getLong(var63);
                     var62 = (int)var231.getLong(var62);
                     var61 = (int)var231.getLong(var61);
                     var60 = (int)var231.getLong(var60);
                     var59 = (int)var231.getLong(var59);
                     var58 = (int)var231.getLong(var58);
                     if ((int)var231.getLong(var55) != 0) {
                        break label196958;
                     }
                  } catch (Throwable var23092) {
                     var10000 = var23092;
                     boolean var23379 = false;
                     break label197487;
                  }

                  var176 = false;
                  break label196959;
               }

               var176 = true;
            }

            label196951: {
               label196950: {
                  try {
                     if (var231.isNull(var57)) {
                        break label196950;
                     }
                  } catch (Throwable var23091) {
                     var10000 = var23091;
                     boolean var23380 = false;
                     break label197487;
                  }

                  try {
                     var23265 = (int)var231.getLong(var57);
                     break label196951;
                  } catch (Throwable var23090) {
                     var10000 = var23090;
                     boolean var23381 = false;
                     break label197487;
                  }
               }

               var23265 = null;
            }

            Boolean var23266;
            if (var23265 == null) {
               var23266 = null;
            } else {
               boolean var177;
               label196940: {
                  label196939: {
                     try {
                        if (var23265 != 0) {
                           break label196939;
                        }
                     } catch (Throwable var23089) {
                        var10000 = var23089;
                        boolean var23382 = false;
                        break label197487;
                     }

                     var177 = false;
                     break label196940;
                  }

                  var177 = true;
               }

               try {
                  var23266 = var177;
               } catch (Throwable var23088) {
                  var10000 = var23088;
                  boolean var23383 = false;
                  break label197487;
               }
            }

            String var218;
            label196931: {
               label196930: {
                  try {
                     var55 = (int)var231.getLong(var56);
                     var54 = (int)var231.getLong(var54);
                     if (var231.isNull(var52)) {
                        break label196930;
                     }
                  } catch (Throwable var23087) {
                     var10000 = var23087;
                     boolean var23384 = false;
                     break label197487;
                  }

                  try {
                     var218 = var231.getText(var52);
                     break label196931;
                  } catch (Throwable var23086) {
                     var10000 = var23086;
                     boolean var23385 = false;
                     break label197487;
                  }
               }

               var218 = null;
            }

            List var239;
            boolean var23256;
            label196922: {
               label196921: {
                  try {
                     var239 = DeviceAlarmListConverter.fromString(var218);
                     var52 = (int)var231.getLong(var53);
                     if ((int)var231.getLong(var48) != 0) {
                        break label196921;
                     }
                  } catch (Throwable var23085) {
                     var10000 = var23085;
                     boolean var23386 = false;
                     break label197487;
                  }

                  var23256 = false;
                  break label196922;
               }

               var23256 = true;
            }

            boolean var178;
            label196914: {
               label196913: {
                  try {
                     if ((int)var231.getLong(var49) != 0) {
                        break label196913;
                     }
                  } catch (Throwable var23084) {
                     var10000 = var23084;
                     boolean var23387 = false;
                     break label197487;
                  }

                  var178 = false;
                  break label196914;
               }

               var178 = true;
            }

            long var184;
            label196906: {
               label196905: {
                  try {
                     var48 = (int)var231.getLong(var50);
                     var47 = (int)var231.getLong(var47);
                     var46 = (int)var231.getLong(var46);
                     var184 = var231.getLong(var45);
                     var44 = (int)var231.getLong(var44);
                     if (var231.isNull(var30)) {
                        break label196905;
                     }
                  } catch (Throwable var23083) {
                     var10000 = var23083;
                     boolean var23388 = false;
                     break label197487;
                  }

                  try {
                     var218 = var231.getText(var30);
                     break label196906;
                  } catch (Throwable var23082) {
                     var10000 = var23082;
                     boolean var23389 = false;
                     break label197487;
                  }
               }

               var218 = null;
            }

            double[] var240;
            label196897: {
               label197494: {
                  try {
                     var240 = DoubleArrayConverter.fromString(var218);
                     if (var231.isNull(var29) && var231.isNull(var28) && var231.isNull(var34) && var231.isNull(var38) && var231.isNull(var25)) {
                        break label197494;
                     }
                  } catch (Throwable var23081) {
                     var10000 = var23081;
                     boolean var23390 = false;
                     break label197487;
                  }

                  label196873: {
                     label196872: {
                        try {
                           if (var231.isNull(var29)) {
                              break label196872;
                           }
                        } catch (Throwable var23080) {
                           var10000 = var23080;
                           boolean var23391 = false;
                           break label197487;
                        }

                        try {
                           var218 = var231.getText(var29);
                           break label196873;
                        } catch (Throwable var23075) {
                           var10000 = var23075;
                           boolean var23392 = false;
                           break label197487;
                        }
                     }

                     var218 = null;
                  }

                  String var219;
                  label196866: {
                     label196865: {
                        try {
                           if (var231.isNull(var28)) {
                              break label196865;
                           }
                        } catch (Throwable var23079) {
                           var10000 = var23079;
                           boolean var23393 = false;
                           break label197487;
                        }

                        try {
                           var219 = var231.getText(var28);
                           break label196866;
                        } catch (Throwable var23074) {
                           var10000 = var23074;
                           boolean var23394 = false;
                           break label197487;
                        }
                     }

                     var219 = null;
                  }

                  String var220;
                  label196859: {
                     label196858: {
                        try {
                           if (var231.isNull(var34)) {
                              break label196858;
                           }
                        } catch (Throwable var23078) {
                           var10000 = var23078;
                           boolean var23395 = false;
                           break label197487;
                        }

                        try {
                           var220 = var231.getText(var34);
                           break label196859;
                        } catch (Throwable var23073) {
                           var10000 = var23073;
                           boolean var23396 = false;
                           break label197487;
                        }
                     }

                     var220 = null;
                  }

                  String var221;
                  label196852: {
                     label196851: {
                        try {
                           if (var231.isNull(var38)) {
                              break label196851;
                           }
                        } catch (Throwable var23077) {
                           var10000 = var23077;
                           boolean var23397 = false;
                           break label197487;
                        }

                        try {
                           var221 = var231.getText(var38);
                           break label196852;
                        } catch (Throwable var23072) {
                           var10000 = var23072;
                           boolean var23398 = false;
                           break label197487;
                        }
                     }

                     var221 = null;
                  }

                  String var222;
                  label196845: {
                     label196844: {
                        try {
                           if (var231.isNull(var25)) {
                              break label196844;
                           }
                        } catch (Throwable var23076) {
                           var10000 = var23076;
                           boolean var23399 = false;
                           break label197487;
                        }

                        try {
                           var222 = var231.getText(var25);
                           break label196845;
                        } catch (Throwable var23071) {
                           var10000 = var23071;
                           boolean var23400 = false;
                           break label197487;
                        }
                     }

                     var222 = null;
                  }

                  DeviceUuidEntity var223;
                  try {
                     var223 = new DeviceUuidEntity(var218, var219, var220, var221, var222);
                  } catch (Throwable var23070) {
                     var10000 = var23070;
                     boolean var23401 = false;
                     break label197487;
                  }

                  var23269 = var223;
                  break label196897;
               }

               var23269 = null;
            }

            IndoorDatapoint var23271;
            label196830: {
               label197495: {
                  try {
                     if (var231.isNull(var42) && var231.isNull(var27) && var231.isNull(var40) && var231.isNull(var26) && var231.isNull(var41) && var231.isNull(var37) && var231.isNull(var36) && var231.isNull(var31) && var231.isNull(var32) && var231.isNull(var39) && var231.isNull(var35)) {
                        break label197495;
                     }
                  } catch (Throwable var23069) {
                     var10000 = var23069;
                     boolean var23402 = false;
                     break label197487;
                  }

                  long var188;
                  label196782: {
                     label196781: {
                        try {
                           var188 = var231.getLong(var42);
                           if (var231.isNull(var27)) {
                              break label196781;
                           }
                        } catch (Throwable var23068) {
                           var10000 = var23068;
                           boolean var23403 = false;
                           break label197487;
                        }

                        try {
                           var23270 = (float)var231.getDouble(var27);
                           break label196782;
                        } catch (Throwable var23058) {
                           var10000 = var23058;
                           boolean var23404 = false;
                           break label197487;
                        }
                     }

                     var23270 = null;
                  }

                  Float var23272;
                  label196775: {
                     label196774: {
                        try {
                           if (var231.isNull(var40)) {
                              break label196774;
                           }
                        } catch (Throwable var23067) {
                           var10000 = var23067;
                           boolean var23405 = false;
                           break label197487;
                        }

                        try {
                           var23272 = (float)var231.getDouble(var40);
                           break label196775;
                        } catch (Throwable var23057) {
                           var10000 = var23057;
                           boolean var23406 = false;
                           break label197487;
                        }
                     }

                     var23272 = null;
                  }

                  Float var23275;
                  label196768: {
                     label196767: {
                        try {
                           if (var231.isNull(var26)) {
                              break label196767;
                           }
                        } catch (Throwable var23066) {
                           var10000 = var23066;
                           boolean var23407 = false;
                           break label197487;
                        }

                        try {
                           var23275 = (float)var231.getDouble(var26);
                           break label196768;
                        } catch (Throwable var23056) {
                           var10000 = var23056;
                           boolean var23408 = false;
                           break label197487;
                        }
                     }

                     var23275 = null;
                  }

                  Float var23278;
                  label196761: {
                     label196760: {
                        try {
                           if (var231.isNull(var41)) {
                              break label196760;
                           }
                        } catch (Throwable var23065) {
                           var10000 = var23065;
                           boolean var23409 = false;
                           break label197487;
                        }

                        try {
                           var23278 = (float)var231.getDouble(var41);
                           break label196761;
                        } catch (Throwable var23055) {
                           var10000 = var23055;
                           boolean var23410 = false;
                           break label197487;
                        }
                     }

                     var23278 = null;
                  }

                  Float var23279;
                  label196754: {
                     label196753: {
                        try {
                           if (var231.isNull(var37)) {
                              break label196753;
                           }
                        } catch (Throwable var23064) {
                           var10000 = var23064;
                           boolean var23411 = false;
                           break label197487;
                        }

                        try {
                           var23279 = (float)var231.getDouble(var37);
                           break label196754;
                        } catch (Throwable var23054) {
                           var10000 = var23054;
                           boolean var23412 = false;
                           break label197487;
                        }
                     }

                     var23279 = null;
                  }

                  Float var224;
                  label196747: {
                     label196746: {
                        try {
                           if (var231.isNull(var36)) {
                              break label196746;
                           }
                        } catch (Throwable var23063) {
                           var10000 = var23063;
                           boolean var23413 = false;
                           break label197487;
                        }

                        try {
                           var224 = (float)var231.getDouble(var36);
                           break label196747;
                        } catch (Throwable var23053) {
                           var10000 = var23053;
                           boolean var23414 = false;
                           break label197487;
                        }
                     }

                     var224 = null;
                  }

                  Float var225;
                  label196740: {
                     label196739: {
                        try {
                           if (var231.isNull(var31)) {
                              break label196739;
                           }
                        } catch (Throwable var23062) {
                           var10000 = var23062;
                           boolean var23415 = false;
                           break label197487;
                        }

                        try {
                           var225 = (float)var231.getDouble(var31);
                           break label196740;
                        } catch (Throwable var23052) {
                           var10000 = var23052;
                           boolean var23416 = false;
                           break label197487;
                        }
                     }

                     var225 = null;
                  }

                  Float var226;
                  label196733: {
                     label196732: {
                        try {
                           if (var231.isNull(var32)) {
                              break label196732;
                           }
                        } catch (Throwable var23061) {
                           var10000 = var23061;
                           boolean var23417 = false;
                           break label197487;
                        }

                        try {
                           var226 = (float)var231.getDouble(var32);
                           break label196733;
                        } catch (Throwable var23051) {
                           var10000 = var23051;
                           boolean var23418 = false;
                           break label197487;
                        }
                     }

                     var226 = null;
                  }

                  Float var227;
                  label196726: {
                     label196725: {
                        try {
                           if (var231.isNull(var39)) {
                              break label196725;
                           }
                        } catch (Throwable var23060) {
                           var10000 = var23060;
                           boolean var23419 = false;
                           break label197487;
                        }

                        try {
                           var227 = (float)var231.getDouble(var39);
                           break label196726;
                        } catch (Throwable var23050) {
                           var10000 = var23050;
                           boolean var23420 = false;
                           break label197487;
                        }
                     }

                     var227 = null;
                  }

                  Float var228;
                  label196719: {
                     label196718: {
                        try {
                           if (var231.isNull(var35)) {
                              break label196718;
                           }
                        } catch (Throwable var23059) {
                           var10000 = var23059;
                           boolean var23421 = false;
                           break label197487;
                        }

                        try {
                           var228 = (float)var231.getDouble(var35);
                           break label196719;
                        } catch (Throwable var23049) {
                           var10000 = var23049;
                           boolean var23422 = false;
                           break label197487;
                        }
                     }

                     var228 = null;
                  }

                  IndoorDatapoint var230;
                  try {
                     var230 = new IndoorDatapoint(var188, var23270, var23272, var23275, var23278, var23279, var224, var225, var226, var227, var228);
                  } catch (Throwable var23048) {
                     var10000 = var23048;
                     boolean var23423 = false;
                     break label197487;
                  }

                  var23271 = var230;
                  break label196830;
               }

               var23271 = null;
            }

            WelcomeHomeLocation var23274;
            label196699: {
               label197496: {
                  try {
                     if (var231.isNull(var43) && var231.isNull(var24) && var231.isNull(var33) && var231.isNull(var21) && var231.isNull(var23)) {
                        break label197496;
                     }
                  } catch (Throwable var23047) {
                     var10000 = var23047;
                     boolean var23424 = false;
                     break label197487;
                  }

                  double var4;
                  double var6;
                  label196682: {
                     label196681: {
                        try {
                           var4 = var231.getDouble(var43);
                           var6 = var231.getDouble(var24);
                           var24 = (int)var231.getLong(var33);
                           if (var231.isNull(var21)) {
                              break label196681;
                           }
                        } catch (Throwable var23046) {
                           var10000 = var23046;
                           boolean var23425 = false;
                           break label197487;
                        }

                        try {
                           var23273 = var231.getText(var21);
                           break label196682;
                        } catch (Throwable var23044) {
                           var10000 = var23044;
                           boolean var23426 = false;
                           break label197487;
                        }
                     }

                     var23273 = (String)var229;
                  }

                  boolean var179;
                  label196675: {
                     label196674: {
                        try {
                           if ((int)var231.getLong(var23) != 0) {
                              break label196674;
                           }
                        } catch (Throwable var23045) {
                           var10000 = var23045;
                           boolean var23427 = false;
                           break label197487;
                        }

                        var179 = false;
                        break label196675;
                     }

                     var179 = true;
                  }

                  WelcomeHomeLocation var23276;
                  try {
                     var23276 = new WelcomeHomeLocation(var4, var6, var24, var23273, var179);
                  } catch (Throwable var23043) {
                     var10000 = var23043;
                     boolean var23428 = false;
                     break label197487;
                  }

                  var23274 = var23276;
                  break label196699;
               }

               var23274 = null;
            }

            label196665:
            try {
               var21 = (int)var231.getLong(var22);
               var20 = (int)var231.getLong(var20);
               var19 = (int)var231.getLong(var19);
               var18 = (int)var231.getLong(var18);
               var17 = (int)var231.getLong(var17);
               var16 = (int)var231.getLong(var16);
               var15 = (int)var231.getLong(var15);
               var14 = (int)var231.getLong(var14);
               var12 = (int)var231.getLong(var12);
               var11 = (int)var231.getLong(var11);
               var10 = (int)var231.getLong(var10);
               DualOscillationConfig var23277 = new DualOscillationConfig(var21, var20, var19, var18, var17, var16, var15, var14, var12, var11, var10);
               var23193 = new DeviceEntity(var0, var23196, var190, var13, var191, var192, var193, var194, var195, var23269, var155, var23271, var196, var156, var157, var158, var197, var51, var182, var198, var199, var200, var201, var202, var203, var204, var205, var206, var207, var208, var232, var233, var234, var235, var236, var80, var159, var160, var161, var162, var163, var164, var23262, var23254, var210, var166, var211, var212, var23274, var213, var23263, var215, var216, var23255, var168, var105, var180, var103, var169, var101, var100, var99, var98, var186, var96, var95, var94, var93, var92, var91, var90, var89, var88, var87, var8, var2, var84, var83, var82, var237, var79, var238, var170, var76, var75, var74, var171, var72, var172, var173, var69, var68, var174, var175, var65, var64, var63, var62, var61, var60, var59, var58, var176, var23266, var55, var54, var239, var52, var23256, var178, var48, var47, var46, var184, var23277, var44, var240);
               break label197485;
            } catch (Throwable var23042) {
               var10000 = var23042;
               boolean var23429 = false;
               break label196665;
            }
         }

         Throwable var23195 = var10000;
         var231.close();
         throw var23195;
      }

      var231.close();
      return var23193;
   }

   // $FF: synthetic method
   static List lambda$getFlowDevices$5(SQLiteConnection var0) {
      SQLiteStatement var285 = var0.prepare("SELECT * from device_table ORDER BY modelName DESC");

      ArrayList var286;
      label223033: {
         Throwable var10000;
         label223032: {
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var153;
            int var154;
            try {
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uid");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "name");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "modelName");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "typeIndex");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fanSpeed");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterLife");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoModeText");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "brightness");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "info");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hasFinishedOnboarding");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastSelectedSensorType");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isAblDevice");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isNightModeOn");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isChildLockOn");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "linkedDeviceUid");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "connectivityStatusIndex");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastConnectivityMillis");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mac");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mcuFirmware");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wifiFirmware");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hardware");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeZone");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "serial");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "purchaseDate");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerName");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerCountry");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterType");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterTrigger");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1Ranges");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10Ranges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25Ranges");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "vocRanges");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hchoRanges");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "updateProgress");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isStandByOn");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEcoModeOn");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsModeOn");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsNightModeOn");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isG4NightModeOn");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldOn");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldNightModeOn");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isSafetySwitchOn");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "g4NightModefilterTrigger");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "aimInstalled");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sku");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "compatibility");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "locationId");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfection");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTime");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTimeUpdateTime");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryEnabled");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryOn");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTime");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTimeUpdateTime");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickUsage");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterShortage");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoRh");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerStatus");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerDuration");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTime");
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTimeUpdateTime");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "temperatureUnit");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationState");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationAngle");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationDirection");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationFanSpeed");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mainMode");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apSubMode");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apFanSpeed");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatSubMode");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatFanSpeed");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatAutoTmp");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatEcoTmp");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolSubMode");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeed");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoTag");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoPresets");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoTag");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoPresets");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humMode");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mode");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterLevel");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dehSubMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterTankFailure");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "smartSubMode");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "detectCat");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bodyMounted");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "cleanAirEta");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "panelDisplayMode");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hoverEnabled");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEnabled");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStatus");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshDuration");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshTimeStamp");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStartTimeStamp");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEndTimeStamp");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "roomType");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampBrightness");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDuration");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDone");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmEnabled");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmUsage");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampSteplessBrightness");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "alarms");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humSubMode");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "use24Hour");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterInfill");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sensorMode");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeedLevel");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoLevel");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightModeStartTime");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm1");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightPeriods");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uuid");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ssid");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bssid");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv4");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv6");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeInSeconds");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "voc");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hcho");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "tmp");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hum");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fan");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "weight");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lat");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lng");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "radius");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "textValue");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEnabled");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationMode");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationState");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationFixAngle");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMinAngle");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMaxAngle");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationState");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationFixAngle");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMinAngle");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMaxAngle");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalCalibrationState");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalCalibrationState");
               var286 = new ArrayList();
            } catch (Throwable var30051) {
               var10000 = var30051;
               boolean var10001 = false;
               break label223032;
            }

            while(true) {
               label223027: {
                  label223026: {
                     try {
                        if (!var285.step()) {
                           break label223033;
                        }

                        if (var285.isNull(var153)) {
                           break label223026;
                        }
                     } catch (Throwable var30050) {
                        var10000 = var30050;
                        boolean var30082 = false;
                        break;
                     }

                     try {
                        var30052 = var285.getText(var153);
                        break label223027;
                     } catch (Throwable var29964) {
                        var10000 = var29964;
                        boolean var30083 = false;
                        break;
                     }
                  }

                  var30052 = null;
               }

               String var244;
               label223019: {
                  label223018: {
                     try {
                        if (var285.isNull(var122)) {
                           break label223018;
                        }
                     } catch (Throwable var30049) {
                        var10000 = var30049;
                        boolean var30084 = false;
                        break;
                     }

                     try {
                        var244 = var285.getText(var122);
                        break label223019;
                     } catch (Throwable var29963) {
                        var10000 = var29963;
                        boolean var30085 = false;
                        break;
                     }
                  }

                  var244 = null;
               }

               String var245;
               label223012: {
                  label223011: {
                     try {
                        if (var285.isNull(var118)) {
                           break label223011;
                        }
                     } catch (Throwable var30048) {
                        var10000 = var30048;
                        boolean var30086 = false;
                        break;
                     }

                     try {
                        var245 = var285.getText(var118);
                        break label223012;
                     } catch (Throwable var29962) {
                        var10000 = var29962;
                        boolean var30087 = false;
                        break;
                     }
                  }

                  var245 = null;
               }

               int var156;
               Integer var246;
               label223005: {
                  label223004: {
                     try {
                        var156 = (int)var285.getLong(var121);
                        if (var285.isNull(var119)) {
                           break label223004;
                        }
                     } catch (Throwable var30047) {
                        var10000 = var30047;
                        boolean var30088 = false;
                        break;
                     }

                     try {
                        var246 = (int)var285.getLong(var119);
                        break label223005;
                     } catch (Throwable var29961) {
                        var10000 = var29961;
                        boolean var30089 = false;
                        break;
                     }
                  }

                  var246 = null;
               }

               Integer var247;
               label222998: {
                  label222997: {
                     try {
                        if (var285.isNull(var114)) {
                           break label222997;
                        }
                     } catch (Throwable var30046) {
                        var10000 = var30046;
                        boolean var30090 = false;
                        break;
                     }

                     try {
                        var247 = (int)var285.getLong(var114);
                        break label222998;
                     } catch (Throwable var29960) {
                        var10000 = var29960;
                        boolean var30091 = false;
                        break;
                     }
                  }

                  var247 = null;
               }

               String var248;
               label222991: {
                  label222990: {
                     try {
                        if (var285.isNull(var112)) {
                           break label222990;
                        }
                     } catch (Throwable var30045) {
                        var10000 = var30045;
                        boolean var30092 = false;
                        break;
                     }

                     try {
                        var248 = var285.getText(var112);
                        break label222991;
                     } catch (Throwable var29959) {
                        var10000 = var29959;
                        boolean var30093 = false;
                        break;
                     }
                  }

                  var248 = null;
               }

               Integer var249;
               label222984: {
                  label222983: {
                     try {
                        if (var285.isNull(var111)) {
                           break label222983;
                        }
                     } catch (Throwable var30044) {
                        var10000 = var30044;
                        boolean var30094 = false;
                        break;
                     }

                     try {
                        var249 = (int)var285.getLong(var111);
                        break label222984;
                     } catch (Throwable var29958) {
                        var10000 = var29958;
                        boolean var30095 = false;
                        break;
                     }
                  }

                  var249 = null;
               }

               String var250;
               label222977: {
                  label222976: {
                     try {
                        if (var285.isNull(var108)) {
                           break label222976;
                        }
                     } catch (Throwable var30043) {
                        var10000 = var30043;
                        boolean var30096 = false;
                        break;
                     }

                     try {
                        var250 = var285.getText(var108);
                        break label222977;
                     } catch (Throwable var29957) {
                        var10000 = var29957;
                        boolean var30097 = false;
                        break;
                     }
                  }

                  var250 = null;
               }

               boolean var209;
               label222970: {
                  label222969: {
                     try {
                        if ((int)var285.getLong(var107) != 0) {
                           break label222969;
                        }
                     } catch (Throwable var30042) {
                        var10000 = var30042;
                        boolean var30098 = false;
                        break;
                     }

                     var209 = false;
                     break label222970;
                  }

                  var209 = true;
               }

               Integer var251;
               label222963: {
                  label222962: {
                     try {
                        if (var285.isNull(var110)) {
                           break label222962;
                        }
                     } catch (Throwable var30041) {
                        var10000 = var30041;
                        boolean var30099 = false;
                        break;
                     }

                     try {
                        var251 = (int)var285.getLong(var110);
                        break label222963;
                     } catch (Throwable var29956) {
                        var10000 = var29956;
                        boolean var30100 = false;
                        break;
                     }
                  }

                  var251 = null;
               }

               boolean var210;
               label222956: {
                  label222955: {
                     try {
                        if ((int)var285.getLong(var117) != 0) {
                           break label222955;
                        }
                     } catch (Throwable var30040) {
                        var10000 = var30040;
                        boolean var30101 = false;
                        break;
                     }

                     var210 = false;
                     break label222956;
                  }

                  var210 = true;
               }

               boolean var211;
               label222949: {
                  label222948: {
                     try {
                        if ((int)var285.getLong(var113) != 0) {
                           break label222948;
                        }
                     } catch (Throwable var30039) {
                        var10000 = var30039;
                        boolean var30102 = false;
                        break;
                     }

                     var211 = false;
                     break label222949;
                  }

                  var211 = true;
               }

               boolean var212;
               label222942: {
                  label222941: {
                     try {
                        if ((int)var285.getLong(var109) != 0) {
                           break label222941;
                        }
                     } catch (Throwable var30038) {
                        var10000 = var30038;
                        boolean var30103 = false;
                        break;
                     }

                     var212 = false;
                     break label222942;
                  }

                  var212 = true;
               }

               String var252;
               label222935: {
                  label222934: {
                     try {
                        if (var285.isNull(var62)) {
                           break label222934;
                        }
                     } catch (Throwable var30037) {
                        var10000 = var30037;
                        boolean var30104 = false;
                        break;
                     }

                     try {
                        var252 = var285.getText(var62);
                        break label222935;
                     } catch (Throwable var29955) {
                        var10000 = var29955;
                        boolean var30105 = false;
                        break;
                     }
                  }

                  var252 = null;
               }

               int var155;
               long var238;
               String var253;
               label222928: {
                  label222927: {
                     try {
                        var155 = (int)var285.getLong(var120);
                        var238 = var285.getLong(var115);
                        if (var285.isNull(var151)) {
                           break label222927;
                        }
                     } catch (Throwable var30036) {
                        var10000 = var30036;
                        boolean var30106 = false;
                        break;
                     }

                     try {
                        var253 = var285.getText(var151);
                        break label222928;
                     } catch (Throwable var29954) {
                        var10000 = var29954;
                        boolean var30107 = false;
                        break;
                     }
                  }

                  var253 = null;
               }

               String var254;
               label222921: {
                  label222920: {
                     try {
                        if (var285.isNull(var150)) {
                           break label222920;
                        }
                     } catch (Throwable var30035) {
                        var10000 = var30035;
                        boolean var30108 = false;
                        break;
                     }

                     try {
                        var254 = var285.getText(var150);
                        break label222921;
                     } catch (Throwable var29953) {
                        var10000 = var29953;
                        boolean var30109 = false;
                        break;
                     }
                  }

                  var254 = null;
               }

               String var255;
               label222914: {
                  label222913: {
                     try {
                        if (var285.isNull(var149)) {
                           break label222913;
                        }
                     } catch (Throwable var30034) {
                        var10000 = var30034;
                        boolean var30110 = false;
                        break;
                     }

                     try {
                        var255 = var285.getText(var149);
                        break label222914;
                     } catch (Throwable var29952) {
                        var10000 = var29952;
                        boolean var30111 = false;
                        break;
                     }
                  }

                  var255 = null;
               }

               String var256;
               label222907: {
                  label222906: {
                     try {
                        if (var285.isNull(var148)) {
                           break label222906;
                        }
                     } catch (Throwable var30033) {
                        var10000 = var30033;
                        boolean var30112 = false;
                        break;
                     }

                     try {
                        var256 = var285.getText(var148);
                        break label222907;
                     } catch (Throwable var29951) {
                        var10000 = var29951;
                        boolean var30113 = false;
                        break;
                     }
                  }

                  var256 = null;
               }

               String var257;
               label222900: {
                  label222899: {
                     try {
                        if (var285.isNull(var147)) {
                           break label222899;
                        }
                     } catch (Throwable var30032) {
                        var10000 = var30032;
                        boolean var30114 = false;
                        break;
                     }

                     try {
                        var257 = var285.getText(var147);
                        break label222900;
                     } catch (Throwable var29950) {
                        var10000 = var29950;
                        boolean var30115 = false;
                        break;
                     }
                  }

                  var257 = null;
               }

               String var258;
               label222893: {
                  label222892: {
                     try {
                        if (var285.isNull(var146)) {
                           break label222892;
                        }
                     } catch (Throwable var30031) {
                        var10000 = var30031;
                        boolean var30116 = false;
                        break;
                     }

                     try {
                        var258 = var285.getText(var146);
                        break label222893;
                     } catch (Throwable var29949) {
                        var10000 = var29949;
                        boolean var30117 = false;
                        break;
                     }
                  }

                  var258 = null;
               }

               String var259;
               label222886: {
                  label222885: {
                     try {
                        if (var285.isNull(var145)) {
                           break label222885;
                        }
                     } catch (Throwable var30030) {
                        var10000 = var30030;
                        boolean var30118 = false;
                        break;
                     }

                     try {
                        var259 = var285.getText(var145);
                        break label222886;
                     } catch (Throwable var29948) {
                        var10000 = var29948;
                        boolean var30119 = false;
                        break;
                     }
                  }

                  var259 = null;
               }

               String var260;
               label222879: {
                  label222878: {
                     try {
                        if (var285.isNull(var144)) {
                           break label222878;
                        }
                     } catch (Throwable var30029) {
                        var10000 = var30029;
                        boolean var30120 = false;
                        break;
                     }

                     try {
                        var260 = var285.getText(var144);
                        break label222879;
                     } catch (Throwable var29947) {
                        var10000 = var29947;
                        boolean var30121 = false;
                        break;
                     }
                  }

                  var260 = null;
               }

               String var261;
               label222872: {
                  label222871: {
                     try {
                        if (var285.isNull(var143)) {
                           break label222871;
                        }
                     } catch (Throwable var30028) {
                        var10000 = var30028;
                        boolean var30122 = false;
                        break;
                     }

                     try {
                        var261 = var285.getText(var143);
                        break label222872;
                     } catch (Throwable var29946) {
                        var10000 = var29946;
                        boolean var30123 = false;
                        break;
                     }
                  }

                  var261 = null;
               }

               String var262;
               label222865: {
                  label222864: {
                     try {
                        if (var285.isNull(var142)) {
                           break label222864;
                        }
                     } catch (Throwable var30027) {
                        var10000 = var30027;
                        boolean var30124 = false;
                        break;
                     }

                     try {
                        var262 = var285.getText(var142);
                        break label222865;
                     } catch (Throwable var29945) {
                        var10000 = var29945;
                        boolean var30125 = false;
                        break;
                     }
                  }

                  var262 = null;
               }

               String var263;
               label222858: {
                  label222857: {
                     try {
                        if (var285.isNull(var141)) {
                           break label222857;
                        }
                     } catch (Throwable var30026) {
                        var10000 = var30026;
                        boolean var30126 = false;
                        break;
                     }

                     try {
                        var263 = var285.getText(var141);
                        break label222858;
                     } catch (Throwable var29944) {
                        var10000 = var29944;
                        boolean var30127 = false;
                        break;
                     }
                  }

                  var263 = null;
               }

               String var264;
               label222851: {
                  label222850: {
                     try {
                        if (var285.isNull(var140)) {
                           break label222850;
                        }
                     } catch (Throwable var30025) {
                        var10000 = var30025;
                        boolean var30128 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var140);
                        break label222851;
                     } catch (Throwable var29943) {
                        var10000 = var29943;
                        boolean var30129 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var287;
               try {
                  var287 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29942) {
                  var10000 = var29942;
                  boolean var30130 = false;
                  break;
               }

               label222843: {
                  label222842: {
                     try {
                        if (var285.isNull(var139)) {
                           break label222842;
                        }
                     } catch (Throwable var30024) {
                        var10000 = var30024;
                        boolean var30131 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var139);
                        break label222843;
                     } catch (Throwable var29941) {
                        var10000 = var29941;
                        boolean var30132 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var288;
               try {
                  var288 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29940) {
                  var10000 = var29940;
                  boolean var30133 = false;
                  break;
               }

               label222835: {
                  label222834: {
                     try {
                        if (var285.isNull(var138)) {
                           break label222834;
                        }
                     } catch (Throwable var30023) {
                        var10000 = var30023;
                        boolean var30134 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var138);
                        break label222835;
                     } catch (Throwable var29939) {
                        var10000 = var29939;
                        boolean var30135 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var289;
               try {
                  var289 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29938) {
                  var10000 = var29938;
                  boolean var30136 = false;
                  break;
               }

               label222827: {
                  label222826: {
                     try {
                        if (var285.isNull(var137)) {
                           break label222826;
                        }
                     } catch (Throwable var30022) {
                        var10000 = var30022;
                        boolean var30137 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var137);
                        break label222827;
                     } catch (Throwable var29937) {
                        var10000 = var29937;
                        boolean var30138 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var290;
               try {
                  var290 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29936) {
                  var10000 = var29936;
                  boolean var30139 = false;
                  break;
               }

               label222819: {
                  label222818: {
                     try {
                        if (var285.isNull(var136)) {
                           break label222818;
                        }
                     } catch (Throwable var30021) {
                        var10000 = var30021;
                        boolean var30140 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var136);
                        break label222819;
                     } catch (Throwable var29935) {
                        var10000 = var29935;
                        boolean var30141 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var291;
               try {
                  var291 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29934) {
                  var10000 = var29934;
                  boolean var30142 = false;
                  break;
               }

               int var157;
               boolean var213;
               label222811: {
                  label222810: {
                     try {
                        var157 = (int)var285.getLong(var105);
                        if ((int)var285.getLong(var104) != 0) {
                           break label222810;
                        }
                     } catch (Throwable var30020) {
                        var10000 = var30020;
                        boolean var30143 = false;
                        break;
                     }

                     var213 = false;
                     break label222811;
                  }

                  var213 = true;
               }

               boolean var214;
               label222804: {
                  label222803: {
                     try {
                        if ((int)var285.getLong(var102) != 0) {
                           break label222803;
                        }
                     } catch (Throwable var30019) {
                        var10000 = var30019;
                        boolean var30144 = false;
                        break;
                     }

                     var214 = false;
                     break label222804;
                  }

                  var214 = true;
               }

               boolean var215;
               label222797: {
                  label222796: {
                     try {
                        if ((int)var285.getLong(var101) != 0) {
                           break label222796;
                        }
                     } catch (Throwable var30018) {
                        var10000 = var30018;
                        boolean var30145 = false;
                        break;
                     }

                     var215 = false;
                     break label222797;
                  }

                  var215 = true;
               }

               boolean var216;
               label222790: {
                  label222789: {
                     try {
                        if ((int)var285.getLong(var99) != 0) {
                           break label222789;
                        }
                     } catch (Throwable var30017) {
                        var10000 = var30017;
                        boolean var30146 = false;
                        break;
                     }

                     var216 = false;
                     break label222790;
                  }

                  var216 = true;
               }

               boolean var217;
               label222783: {
                  label222782: {
                     try {
                        if ((int)var285.getLong(var98) != 0) {
                           break label222782;
                        }
                     } catch (Throwable var30016) {
                        var10000 = var30016;
                        boolean var30147 = false;
                        break;
                     }

                     var217 = false;
                     break label222783;
                  }

                  var217 = true;
               }

               boolean var218;
               label222776: {
                  label222775: {
                     try {
                        if ((int)var285.getLong(var96) != 0) {
                           break label222775;
                        }
                     } catch (Throwable var30015) {
                        var10000 = var30015;
                        boolean var30148 = false;
                        break;
                     }

                     var218 = false;
                     break label222776;
                  }

                  var218 = true;
               }

               label222769: {
                  label222768: {
                     try {
                        if (var285.isNull(var95)) {
                           break label222768;
                        }
                     } catch (Throwable var30014) {
                        var10000 = var30014;
                        boolean var30149 = false;
                        break;
                     }

                     try {
                        var30062 = (int)var285.getLong(var95);
                        break label222769;
                     } catch (Throwable var29933) {
                        var10000 = var29933;
                        boolean var30150 = false;
                        break;
                     }
                  }

                  var30062 = null;
               }

               Boolean var30063;
               if (var30062 == null) {
                  var30063 = null;
               } else {
                  boolean var219;
                  label222760: {
                     label222759: {
                        try {
                           if (var30062 != 0) {
                              break label222759;
                           }
                        } catch (Throwable var30013) {
                           var10000 = var30013;
                           boolean var30151 = false;
                           break;
                        }

                        var219 = false;
                        break label222760;
                     }

                     var219 = true;
                  }

                  try {
                     var30063 = var219;
                  } catch (Throwable var29932) {
                     var10000 = var29932;
                     boolean var30152 = false;
                     break;
                  }
               }

               boolean var30055;
               label222753: {
                  label222752: {
                     try {
                        if ((int)var285.getLong(var94) != 0) {
                           break label222752;
                        }
                     } catch (Throwable var30012) {
                        var10000 = var30012;
                        boolean var30153 = false;
                        break;
                     }

                     var30055 = false;
                     break label222753;
                  }

                  var30055 = true;
               }

               String var265;
               label222746: {
                  label222745: {
                     try {
                        if (var285.isNull(var92)) {
                           break label222745;
                        }
                     } catch (Throwable var30011) {
                        var10000 = var30011;
                        boolean var30154 = false;
                        break;
                     }

                     try {
                        var265 = var285.getText(var92);
                        break label222746;
                     } catch (Throwable var29931) {
                        var10000 = var29931;
                        boolean var30155 = false;
                        break;
                     }
                  }

                  var265 = null;
               }

               boolean var220;
               label222739: {
                  label222738: {
                     try {
                        if ((int)var285.getLong(var90) != 0) {
                           break label222738;
                        }
                     } catch (Throwable var30010) {
                        var10000 = var30010;
                        boolean var30156 = false;
                        break;
                     }

                     var220 = false;
                     break label222739;
                  }

                  var220 = true;
               }

               String var266;
               label222732: {
                  label222731: {
                     try {
                        if (var285.isNull(var135)) {
                           break label222731;
                        }
                     } catch (Throwable var30009) {
                        var10000 = var30009;
                        boolean var30157 = false;
                        break;
                     }

                     try {
                        var266 = var285.getText(var135);
                        break label222732;
                     } catch (Throwable var29930) {
                        var10000 = var29930;
                        boolean var30158 = false;
                        break;
                     }
                  }

                  var266 = null;
               }

               String var267;
               label222725: {
                  label222724: {
                     try {
                        if (var285.isNull(var85)) {
                           break label222724;
                        }
                     } catch (Throwable var30008) {
                        var10000 = var30008;
                        boolean var30159 = false;
                        break;
                     }

                     try {
                        var267 = var285.getText(var85);
                        break label222725;
                     } catch (Throwable var29929) {
                        var10000 = var29929;
                        boolean var30160 = false;
                        break;
                     }
                  }

                  var267 = null;
               }

               String var268;
               label222718: {
                  label222717: {
                     try {
                        if (var285.isNull(var134)) {
                           break label222717;
                        }
                     } catch (Throwable var30007) {
                        var10000 = var30007;
                        boolean var30161 = false;
                        break;
                     }

                     try {
                        var268 = var285.getText(var134);
                        break label222718;
                     } catch (Throwable var29928) {
                        var10000 = var29928;
                        boolean var30162 = false;
                        break;
                     }
                  }

                  var268 = null;
               }

               Integer var269;
               label222711: {
                  label222710: {
                     try {
                        if (var285.isNull(var82)) {
                           break label222710;
                        }
                     } catch (Throwable var30006) {
                        var10000 = var30006;
                        boolean var30163 = false;
                        break;
                     }

                     try {
                        var269 = (int)var285.getLong(var82);
                        break label222711;
                     } catch (Throwable var29927) {
                        var10000 = var29927;
                        boolean var30164 = false;
                        break;
                     }
                  }

                  var269 = null;
               }

               Boolean var30064;
               if (var269 == null) {
                  var30064 = null;
               } else {
                  boolean var221;
                  label222702: {
                     label222701: {
                        try {
                           if (var269 != 0) {
                              break label222701;
                           }
                        } catch (Throwable var30005) {
                           var10000 = var30005;
                           boolean var30165 = false;
                           break;
                        }

                        var221 = false;
                        break label222702;
                     }

                     var221 = true;
                  }

                  try {
                     var30064 = var221;
                  } catch (Throwable var29926) {
                     var10000 = var29926;
                     boolean var30166 = false;
                     break;
                  }
               }

               Integer var270;
               label222695: {
                  label222694: {
                     try {
                        if (var285.isNull(var81)) {
                           break label222694;
                        }
                     } catch (Throwable var30004) {
                        var10000 = var30004;
                        boolean var30167 = false;
                        break;
                     }

                     try {
                        var270 = (int)var285.getLong(var81);
                        break label222695;
                     } catch (Throwable var29925) {
                        var10000 = var29925;
                        boolean var30168 = false;
                        break;
                     }
                  }

                  var270 = null;
               }

               Long var271;
               label222688: {
                  label222687: {
                     try {
                        if (var285.isNull(var78)) {
                           break label222687;
                        }
                     } catch (Throwable var30003) {
                        var10000 = var30003;
                        boolean var30169 = false;
                        break;
                     }

                     try {
                        var271 = var285.getLong(var78);
                        break label222688;
                     } catch (Throwable var29924) {
                        var10000 = var29924;
                        boolean var30170 = false;
                        break;
                     }
                  }

                  var271 = null;
               }

               boolean var30056;
               label222681: {
                  label222680: {
                     try {
                        if ((int)var285.getLong(var76) != 0) {
                           break label222680;
                        }
                     } catch (Throwable var30002) {
                        var10000 = var30002;
                        boolean var30171 = false;
                        break;
                     }

                     var30056 = false;
                     break label222681;
                  }

                  var30056 = true;
               }

               boolean var222;
               label222674: {
                  label222673: {
                     try {
                        if ((int)var285.getLong(var75) != 0) {
                           break label222673;
                        }
                     } catch (Throwable var30001) {
                        var10000 = var30001;
                        boolean var30172 = false;
                        break;
                     }

                     var222 = false;
                     break label222674;
                  }

                  var222 = true;
               }

               int var159;
               int var161;
               boolean var223;
               long var234;
               label222667: {
                  label222666: {
                     try {
                        var159 = (int)var285.getLong(var74);
                        var234 = var285.getLong(var72);
                        var161 = (int)var285.getLong(var71);
                        if ((int)var285.getLong(var70) != 0) {
                           break label222666;
                        }
                     } catch (Throwable var30000) {
                        var10000 = var30000;
                        boolean var30173 = false;
                        break;
                     }

                     var223 = false;
                     break label222667;
                  }

                  var223 = true;
               }

               int var158;
               int var160;
               int var162;
               int var163;
               int var164;
               long var240;
               try {
                  var158 = (int)var285.getLong(var69);
                  var163 = (int)var285.getLong(var65);
                  var160 = (int)var285.getLong(var68);
                  var162 = (int)var285.getLong(var66);
                  var240 = var285.getLong(var154);
                  var164 = (int)var285.getLong(var133);
               } catch (Throwable var29923) {
                  var10000 = var29923;
                  boolean var30174 = false;
                  break;
               }

               double var3;
               double var7;
               int var165;
               int var166;
               int var167;
               int var168;
               int var169;
               int var170;
               int var171;
               int var172;
               int var173;
               try {
                  var166 = (int)var285.getLong(var64);
                  var170 = (int)var285.getLong(var63);
                  var168 = (int)var285.getLong(var61);
                  var173 = (int)var285.getLong(var60);
                  var167 = (int)var285.getLong(var59);
                  var171 = (int)var285.getLong(var58);
                  var172 = (int)var285.getLong(var57);
                  var165 = (int)var285.getLong(var56);
                  var169 = (int)var285.getLong(var55);
                  var3 = var285.getDouble(var131);
                  var7 = var285.getDouble(var132);
               } catch (Throwable var29922) {
                  var10000 = var29922;
                  boolean var30175 = false;
                  break;
               }

               int var174;
               try {
                  var174 = (int)var285.getLong(var130);
               } catch (Throwable var29921) {
                  var10000 = var29921;
                  boolean var30176 = false;
                  break;
               }

               int var175;
               int var177;
               String var272;
               label222659: {
                  label222658: {
                     try {
                        var175 = (int)var285.getLong(var54);
                        var177 = (int)var285.getLong(var53);
                        if (var285.isNull(var52)) {
                           break label222658;
                        }
                     } catch (Throwable var29999) {
                        var10000 = var29999;
                        boolean var30177 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var52);
                        break label222659;
                     } catch (Throwable var29920) {
                        var10000 = var29920;
                        boolean var30178 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               int var176;
               double[] var292;
               label222652: {
                  label222651: {
                     try {
                        var292 = DoubleArrayConverter.fromString(var272);
                        var176 = (int)var285.getLong(var129);
                        if (var285.isNull(var128)) {
                           break label222651;
                        }
                     } catch (Throwable var29998) {
                        var10000 = var29998;
                        boolean var30179 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var128);
                        break label222652;
                     } catch (Throwable var29919) {
                        var10000 = var29919;
                        boolean var30180 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               double[] var293;
               try {
                  var293 = DoubleArrayConverter.fromString(var272);
               } catch (Throwable var29918) {
                  var10000 = var29918;
                  boolean var30181 = false;
                  break;
               }

               boolean var224;
               label222644: {
                  label222643: {
                     try {
                        if ((int)var285.getLong(var51) != 0) {
                           break label222643;
                        }
                     } catch (Throwable var29997) {
                        var10000 = var29997;
                        boolean var30182 = false;
                        break;
                     }

                     var224 = false;
                     break label222644;
                  }

                  var224 = true;
               }

               int var178;
               int var180;
               int var181;
               boolean var225;
               label222637: {
                  label222636: {
                     try {
                        var181 = (int)var285.getLong(var50);
                        var178 = (int)var285.getLong(var49);
                        var180 = (int)var285.getLong(var48);
                        if ((int)var285.getLong(var47) != 0) {
                           break label222636;
                        }
                     } catch (Throwable var29996) {
                        var10000 = var29996;
                        boolean var30183 = false;
                        break;
                     }

                     var225 = false;
                     break label222637;
                  }

                  var225 = true;
               }

               int var179;
               try {
                  var179 = (int)var285.getLong(var127);
               } catch (Throwable var29917) {
                  var10000 = var29917;
                  boolean var30184 = false;
                  break;
               }

               boolean var226;
               label222629: {
                  label222628: {
                     try {
                        if ((int)var285.getLong(var126) != 0) {
                           break label222628;
                        }
                     } catch (Throwable var29995) {
                        var10000 = var29995;
                        boolean var30185 = false;
                        break;
                     }

                     var226 = false;
                     break label222629;
                  }

                  var226 = true;
               }

               boolean var227;
               label222622: {
                  label222621: {
                     try {
                        if ((int)var285.getLong(var46) != 0) {
                           break label222621;
                        }
                     } catch (Throwable var29994) {
                        var10000 = var29994;
                        boolean var30186 = false;
                        break;
                     }

                     var227 = false;
                     break label222622;
                  }

                  var227 = true;
               }

               int var182;
               int var183;
               boolean var228;
               label222615: {
                  label222614: {
                     try {
                        var183 = (int)var285.getLong(var45);
                        var182 = (int)var285.getLong(var44);
                        if ((int)var285.getLong(var43) != 0) {
                           break label222614;
                        }
                     } catch (Throwable var29993) {
                        var10000 = var29993;
                        boolean var30187 = false;
                        break;
                     }

                     var228 = false;
                     break label222615;
                  }

                  var228 = true;
               }

               boolean var229;
               label222608: {
                  label222607: {
                     try {
                        if ((int)var285.getLong(var125) != 0) {
                           break label222607;
                        }
                     } catch (Throwable var29992) {
                        var10000 = var29992;
                        boolean var30188 = false;
                        break;
                     }

                     var229 = false;
                     break label222608;
                  }

                  var229 = true;
               }

               int var184;
               try {
                  var184 = (int)var285.getLong(var124);
               } catch (Throwable var29916) {
                  var10000 = var29916;
                  boolean var30189 = false;
                  break;
               }

               int var185;
               int var186;
               int var187;
               int var188;
               int var189;
               int var190;
               int var191;
               boolean var230;
               label222600: {
                  label222599: {
                     try {
                        var186 = (int)var285.getLong(var42);
                        var185 = (int)var285.getLong(var41);
                        var189 = (int)var285.getLong(var40);
                        var188 = (int)var285.getLong(var39);
                        var191 = (int)var285.getLong(var38);
                        var187 = (int)var285.getLong(var37);
                        var190 = (int)var285.getLong(var36);
                        if ((int)var285.getLong(var35) != 0) {
                           break label222599;
                        }
                     } catch (Throwable var29991) {
                        var10000 = var29991;
                        boolean var30190 = false;
                        break;
                     }

                     var230 = false;
                     break label222600;
                  }

                  var230 = true;
               }

               label222593: {
                  label222592: {
                     try {
                        if (var285.isNull(var123)) {
                           break label222592;
                        }
                     } catch (Throwable var29990) {
                        var10000 = var29990;
                        boolean var30191 = false;
                        break;
                     }

                     try {
                        var30066 = (int)var285.getLong(var123);
                        break label222593;
                     } catch (Throwable var29915) {
                        var10000 = var29915;
                        boolean var30192 = false;
                        break;
                     }
                  }

                  var30066 = null;
               }

               Boolean var30067;
               if (var30066 == null) {
                  var30067 = null;
               } else {
                  boolean var231;
                  label222584: {
                     label222583: {
                        try {
                           if (var30066 != 0) {
                              break label222583;
                           }
                        } catch (Throwable var29989) {
                           var10000 = var29989;
                           boolean var30193 = false;
                           break;
                        }

                        var231 = false;
                        break label222584;
                     }

                     var231 = true;
                  }

                  try {
                     var30067 = var231;
                  } catch (Throwable var29914) {
                     var10000 = var29914;
                     boolean var30194 = false;
                     break;
                  }
               }

               int var192;
               try {
                  var192 = (int)var285.getLong(var116);
               } catch (Throwable var29913) {
                  var10000 = var29913;
                  boolean var30195 = false;
                  break;
               }

               int var195;
               String var273;
               label222576: {
                  label222575: {
                     try {
                        var195 = (int)var285.getLong(var34);
                        if (var285.isNull(var33)) {
                           break label222575;
                        }
                     } catch (Throwable var29988) {
                        var10000 = var29988;
                        boolean var30196 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var33);
                        break label222576;
                     } catch (Throwable var29912) {
                        var10000 = var29912;
                        boolean var30197 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               int var193;
               List var294;
               boolean var30057;
               label222569: {
                  label222568: {
                     try {
                        var294 = DeviceAlarmListConverter.fromString(var273);
                        var193 = (int)var285.getLong(var32);
                        if ((int)var285.getLong(var31) != 0) {
                           break label222568;
                        }
                     } catch (Throwable var29987) {
                        var10000 = var29987;
                        boolean var30198 = false;
                        break;
                     }

                     var30057 = false;
                     break label222569;
                  }

                  var30057 = true;
               }

               boolean var232;
               label222562: {
                  label222561: {
                     try {
                        if ((int)var285.getLong(var30) != 0) {
                           break label222561;
                        }
                     } catch (Throwable var29986) {
                        var10000 = var29986;
                        boolean var30199 = false;
                        break;
                     }

                     var232 = false;
                     break label222562;
                  }

                  var232 = true;
               }

               int var194;
               int var196;
               int var197;
               int var198;
               long var236;
               label222555: {
                  label222554: {
                     try {
                        var196 = (int)var285.getLong(var26);
                        var197 = (int)var285.getLong(var29);
                        var198 = (int)var285.getLong(var24);
                        var236 = var285.getLong(var88);
                        var194 = (int)var285.getLong(var21);
                        if (var285.isNull(var28)) {
                           break label222554;
                        }
                     } catch (Throwable var29985) {
                        var10000 = var29985;
                        boolean var30200 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var28);
                        break label222555;
                     } catch (Throwable var29911) {
                        var10000 = var29911;
                        boolean var30201 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               double[] var295;
               label222548: {
                  label223044: {
                     try {
                        var295 = DoubleArrayConverter.fromString(var273);
                        if (var285.isNull(var27) && var285.isNull(var87) && var285.isNull(var20) && var285.isNull(var25) && var285.isNull(var23)) {
                           break label223044;
                        }
                     } catch (Throwable var29984) {
                        var10000 = var29984;
                        boolean var30202 = false;
                        break;
                     }

                     label222529: {
                        label222528: {
                           try {
                              if (var285.isNull(var27)) {
                                 break label222528;
                              }
                           } catch (Throwable var29983) {
                              var10000 = var29983;
                              boolean var30203 = false;
                              break;
                           }

                           try {
                              var273 = var285.getText(var27);
                              break label222529;
                           } catch (Throwable var29910) {
                              var10000 = var29910;
                              boolean var30204 = false;
                              break;
                           }
                        }

                        var273 = null;
                     }

                     String var274;
                     label222522: {
                        label222521: {
                           try {
                              if (var285.isNull(var87)) {
                                 break label222521;
                              }
                           } catch (Throwable var29982) {
                              var10000 = var29982;
                              boolean var30205 = false;
                              break;
                           }

                           try {
                              var274 = var285.getText(var87);
                              break label222522;
                           } catch (Throwable var29909) {
                              var10000 = var29909;
                              boolean var30206 = false;
                              break;
                           }
                        }

                        var274 = null;
                     }

                     String var275;
                     label222515: {
                        label222514: {
                           try {
                              if (var285.isNull(var20)) {
                                 break label222514;
                              }
                           } catch (Throwable var29981) {
                              var10000 = var29981;
                              boolean var30207 = false;
                              break;
                           }

                           try {
                              var275 = var285.getText(var20);
                              break label222515;
                           } catch (Throwable var29908) {
                              var10000 = var29908;
                              boolean var30208 = false;
                              break;
                           }
                        }

                        var275 = null;
                     }

                     String var276;
                     label222508: {
                        label222507: {
                           try {
                              if (var285.isNull(var25)) {
                                 break label222507;
                              }
                           } catch (Throwable var29980) {
                              var10000 = var29980;
                              boolean var30209 = false;
                              break;
                           }

                           try {
                              var276 = var285.getText(var25);
                              break label222508;
                           } catch (Throwable var29907) {
                              var10000 = var29907;
                              boolean var30210 = false;
                              break;
                           }
                        }

                        var276 = null;
                     }

                     String var277;
                     label222501: {
                        label222500: {
                           try {
                              if (var285.isNull(var23)) {
                                 break label222500;
                              }
                           } catch (Throwable var29979) {
                              var10000 = var29979;
                              boolean var30211 = false;
                              break;
                           }

                           try {
                              var277 = var285.getText(var23);
                              break label222501;
                           } catch (Throwable var29906) {
                              var10000 = var29906;
                              boolean var30212 = false;
                              break;
                           }
                        }

                        var277 = null;
                     }

                     DeviceUuidEntity var278;
                     try {
                        var278 = new DeviceUuidEntity(var273, var274, var275, var276, var277);
                     } catch (Throwable var29905) {
                        var10000 = var29905;
                        boolean var30213 = false;
                        break;
                     }

                     var30070 = var278;
                     break label222548;
                  }

                  var30070 = null;
               }

               IndoorDatapoint var30072;
               label222494: {
                  label223045: {
                     try {
                        if (var285.isNull(var89) && var285.isNull(var18) && var285.isNull(var11) && var285.isNull(var22) && var285.isNull(var16) && var285.isNull(var12) && var285.isNull(var13) && var285.isNull(var14) && var285.isNull(var15) && var285.isNull(var19) && var285.isNull(var83)) {
                           break label223045;
                        }
                     } catch (Throwable var29978) {
                        var10000 = var29978;
                        boolean var30214 = false;
                        break;
                     }

                     long var242;
                     label222465: {
                        label222464: {
                           try {
                              var242 = var285.getLong(var89);
                              if (var285.isNull(var18)) {
                                 break label222464;
                              }
                           } catch (Throwable var29977) {
                              var10000 = var29977;
                              boolean var30215 = false;
                              break;
                           }

                           try {
                              var30071 = (float)var285.getDouble(var18);
                              break label222465;
                           } catch (Throwable var29904) {
                              var10000 = var29904;
                              boolean var30216 = false;
                              break;
                           }
                        }

                        var30071 = null;
                     }

                     Float var30073;
                     label222458: {
                        label222457: {
                           try {
                              if (var285.isNull(var11)) {
                                 break label222457;
                              }
                           } catch (Throwable var29976) {
                              var10000 = var29976;
                              boolean var30217 = false;
                              break;
                           }

                           try {
                              var30073 = (float)var285.getDouble(var11);
                              break label222458;
                           } catch (Throwable var29903) {
                              var10000 = var29903;
                              boolean var30218 = false;
                              break;
                           }
                        }

                        var30073 = null;
                     }

                     Float var30076;
                     label222451: {
                        label222450: {
                           try {
                              if (var285.isNull(var22)) {
                                 break label222450;
                              }
                           } catch (Throwable var29975) {
                              var10000 = var29975;
                              boolean var30219 = false;
                              break;
                           }

                           try {
                              var30076 = (float)var285.getDouble(var22);
                              break label222451;
                           } catch (Throwable var29902) {
                              var10000 = var29902;
                              boolean var30220 = false;
                              break;
                           }
                        }

                        var30076 = null;
                     }

                     Float var30079;
                     label222444: {
                        label222443: {
                           try {
                              if (var285.isNull(var16)) {
                                 break label222443;
                              }
                           } catch (Throwable var29974) {
                              var10000 = var29974;
                              boolean var30221 = false;
                              break;
                           }

                           try {
                              var30079 = (float)var285.getDouble(var16);
                              break label222444;
                           } catch (Throwable var29901) {
                              var10000 = var29901;
                              boolean var30222 = false;
                              break;
                           }
                        }

                        var30079 = null;
                     }

                     Float var30081;
                     label222437: {
                        label222436: {
                           try {
                              if (var285.isNull(var12)) {
                                 break label222436;
                              }
                           } catch (Throwable var29973) {
                              var10000 = var29973;
                              boolean var30223 = false;
                              break;
                           }

                           try {
                              var30081 = (float)var285.getDouble(var12);
                              break label222437;
                           } catch (Throwable var29900) {
                              var10000 = var29900;
                              boolean var30224 = false;
                              break;
                           }
                        }

                        var30081 = null;
                     }

                     Float var279;
                     label222430: {
                        label222429: {
                           try {
                              if (var285.isNull(var13)) {
                                 break label222429;
                              }
                           } catch (Throwable var29972) {
                              var10000 = var29972;
                              boolean var30225 = false;
                              break;
                           }

                           try {
                              var279 = (float)var285.getDouble(var13);
                              break label222430;
                           } catch (Throwable var29899) {
                              var10000 = var29899;
                              boolean var30226 = false;
                              break;
                           }
                        }

                        var279 = null;
                     }

                     Float var280;
                     label222423: {
                        label222422: {
                           try {
                              if (var285.isNull(var14)) {
                                 break label222422;
                              }
                           } catch (Throwable var29971) {
                              var10000 = var29971;
                              boolean var30227 = false;
                              break;
                           }

                           try {
                              var280 = (float)var285.getDouble(var14);
                              break label222423;
                           } catch (Throwable var29898) {
                              var10000 = var29898;
                              boolean var30228 = false;
                              break;
                           }
                        }

                        var280 = null;
                     }

                     Float var281;
                     label222416: {
                        label222415: {
                           try {
                              if (var285.isNull(var15)) {
                                 break label222415;
                              }
                           } catch (Throwable var29970) {
                              var10000 = var29970;
                              boolean var30229 = false;
                              break;
                           }

                           try {
                              var281 = (float)var285.getDouble(var15);
                              break label222416;
                           } catch (Throwable var29897) {
                              var10000 = var29897;
                              boolean var30230 = false;
                              break;
                           }
                        }

                        var281 = null;
                     }

                     Float var282;
                     label222409: {
                        label222408: {
                           try {
                              if (var285.isNull(var19)) {
                                 break label222408;
                              }
                           } catch (Throwable var29969) {
                              var10000 = var29969;
                              boolean var30231 = false;
                              break;
                           }

                           try {
                              var282 = (float)var285.getDouble(var19);
                              break label222409;
                           } catch (Throwable var29896) {
                              var10000 = var29896;
                              boolean var30232 = false;
                              break;
                           }
                        }

                        var282 = null;
                     }

                     Float var283;
                     label222402: {
                        label222401: {
                           try {
                              if (var285.isNull(var83)) {
                                 break label222401;
                              }
                           } catch (Throwable var29968) {
                              var10000 = var29968;
                              boolean var30233 = false;
                              break;
                           }

                           try {
                              var283 = (float)var285.getDouble(var83);
                              break label222402;
                           } catch (Throwable var29895) {
                              var10000 = var29895;
                              boolean var30234 = false;
                              break;
                           }
                        }

                        var283 = null;
                     }

                     IndoorDatapoint var284;
                     try {
                        var284 = new IndoorDatapoint(var242, var30071, var30073, var30076, var30079, var30081, var279, var280, var281, var282, var283);
                     } catch (Throwable var29894) {
                        var10000 = var29894;
                        boolean var30235 = false;
                        break;
                     }

                     var30072 = var284;
                     break label222494;
                  }

                  var30072 = null;
               }

               WelcomeHomeLocation var30075;
               label222395: {
                  label223046: {
                     try {
                        if (var285.isNull(var80) && var285.isNull(var9) && var285.isNull(var10) && var285.isNull(var106) && var285.isNull(var17)) {
                           break label223046;
                        }
                     } catch (Throwable var29967) {
                        var10000 = var29967;
                        boolean var30236 = false;
                        break;
                     }

                     double var5;
                     try {
                        var5 = var285.getDouble(var80);
                     } catch (Throwable var29893) {
                        var10000 = var29893;
                        boolean var30237 = false;
                        break;
                     }

                     double var1;
                     int var199;
                     label222374: {
                        label222373: {
                           try {
                              var1 = var285.getDouble(var9);
                              var199 = (int)var285.getLong(var10);
                              if (var285.isNull(var106)) {
                                 break label222373;
                              }
                           } catch (Throwable var29966) {
                              var10000 = var29966;
                              boolean var30238 = false;
                              break;
                           }

                           try {
                              var30074 = var285.getText(var106);
                              break label222374;
                           } catch (Throwable var29892) {
                              var10000 = var29892;
                              boolean var30239 = false;
                              break;
                           }
                        }

                        var30074 = null;
                     }

                     boolean var233;
                     label222366: {
                        label222365: {
                           try {
                              if ((int)var285.getLong(var17) != 0) {
                                 break label222365;
                              }
                           } catch (Throwable var29965) {
                              var10000 = var29965;
                              boolean var30240 = false;
                              break;
                           }

                           var233 = false;
                           break label222366;
                        }

                        var233 = true;
                     }

                     WelcomeHomeLocation var30077;
                     try {
                        var30077 = new WelcomeHomeLocation(var5, var1, var199, var30074, var233);
                     } catch (Throwable var29891) {
                        var10000 = var29891;
                        boolean var30241 = false;
                        break;
                     }

                     var30075 = var30077;
                     break label222395;
                  }

                  var30075 = null;
               }

               int var152;
               try {
                  var152 = (int)var285.getLong(var103);
               } catch (Throwable var29890) {
                  var10000 = var29890;
                  boolean var30242 = false;
                  break;
               }

               int var30054;
               try {
                  var30054 = (int)var285.getLong(var100);
               } catch (Throwable var29889) {
                  var10000 = var29889;
                  boolean var30243 = false;
                  break;
               }

               int var200;
               try {
                  var200 = (int)var285.getLong(var97);
               } catch (Throwable var29888) {
                  var10000 = var29888;
                  boolean var30244 = false;
                  break;
               }

               int var201;
               try {
                  var201 = (int)var285.getLong(var93);
               } catch (Throwable var29887) {
                  var10000 = var29887;
                  boolean var30245 = false;
                  break;
               }

               int var202;
               try {
                  var202 = (int)var285.getLong(var91);
               } catch (Throwable var29886) {
                  var10000 = var29886;
                  boolean var30246 = false;
                  break;
               }

               int var203;
               try {
                  var203 = (int)var285.getLong(var86);
               } catch (Throwable var29885) {
                  var10000 = var29885;
                  boolean var30247 = false;
                  break;
               }

               int var204;
               try {
                  var204 = (int)var285.getLong(var84);
               } catch (Throwable var29884) {
                  var10000 = var29884;
                  boolean var30248 = false;
                  break;
               }

               int var205;
               try {
                  var205 = (int)var285.getLong(var79);
               } catch (Throwable var29883) {
                  var10000 = var29883;
                  boolean var30249 = false;
                  break;
               }

               int var206;
               try {
                  var206 = (int)var285.getLong(var77);
               } catch (Throwable var29882) {
                  var10000 = var29882;
                  boolean var30250 = false;
                  break;
               }

               int var207;
               try {
                  var207 = (int)var285.getLong(var73);
               } catch (Throwable var29881) {
                  var10000 = var29881;
                  boolean var30251 = false;
                  break;
               }

               try {
                  int var208 = (int)var285.getLong(var67);
                  DualOscillationConfig var30078 = new DualOscillationConfig(var152, var30054, var200, var201, var202, var203, var204, var205, var206, var207, var208);
                  DeviceEntity var30080 = new DeviceEntity(var30052, var244, var245, var156, var246, var247, var248, var249, var250, var30070, var209, var30072, var251, var210, var211, var212, var252, var155, var238, var253, var254, var255, var256, var257, var258, var259, var260, var261, var262, var263, var287, var288, var289, var290, var291, var157, var213, var214, var215, var216, var217, var218, var30063, var30055, var265, var220, var266, var267, var30075, var268, var30064, var270, var271, var30056, var222, var159, var234, var161, var223, var158, var163, var160, var162, var240, var164, var166, var170, var168, var173, var167, var171, var172, var165, var169, var3, var7, var174, var175, var177, var292, var176, var293, var224, var181, var178, var180, var225, var179, var226, var227, var183, var182, var228, var229, var184, var186, var185, var189, var188, var191, var187, var190, var230, var30067, var192, var195, var294, var193, var30057, var232, var196, var197, var198, var236, var30078, var194, var295);
                  var286.add(var30080);
               } catch (Throwable var29880) {
                  var10000 = var29880;
                  boolean var30252 = false;
                  break;
               }
            }
         }

         Throwable var30053 = var10000;
         var285.close();
         throw var30053;
      }

      var285.close();
      return var286;
   }

   // $FF: synthetic method
   static List lambda$getLiveDevices$4(SQLiteConnection var0) {
      SQLiteStatement var285 = var0.prepare("SELECT * from device_table ORDER BY modelName DESC");

      ArrayList var286;
      label223033: {
         Throwable var10000;
         label223032: {
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var153;
            int var154;
            try {
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uid");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "name");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "modelName");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "typeIndex");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fanSpeed");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterLife");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoModeText");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "brightness");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "info");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hasFinishedOnboarding");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastSelectedSensorType");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isAblDevice");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isNightModeOn");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isChildLockOn");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "linkedDeviceUid");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "connectivityStatusIndex");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lastConnectivityMillis");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mac");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mcuFirmware");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wifiFirmware");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hardware");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeZone");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "serial");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "purchaseDate");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerName");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dealerCountry");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterType");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "filterTrigger");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1Ranges");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10Ranges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25Ranges");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "vocRanges");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hchoRanges");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "updateProgress");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isStandByOn");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEcoModeOn");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsModeOn");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isHinsNightModeOn");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isG4NightModeOn");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldOn");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isGermShieldNightModeOn");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isSafetySwitchOn");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "g4NightModefilterTrigger");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "aimInstalled");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sku");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "compatibility");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "locationId");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfection");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTime");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "disinfectLeftTimeUpdateTime");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryEnabled");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryOn");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTime");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryLeftTimeUpdateTime");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickUsage");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterShortage");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "autoRh");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerStatus");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerDuration");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTime");
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timerLeftTimeUpdateTime");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "temperatureUnit");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationState");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationAngle");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationDirection");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationFanSpeed");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mainMode");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apSubMode");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "apFanSpeed");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatSubMode");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatFanSpeed");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatAutoTmp");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "heatEcoTmp");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolSubMode");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeed");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoTag");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoPresets");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoTag");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolEcoPresets");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humMode");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "mode");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterLevel");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "dehSubMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterTankFailure");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "smartSubMode");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "detectCat");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bodyMounted");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "cleanAirEta");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "panelDisplayMode");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hoverEnabled");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEnabled");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStatus");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshDuration");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshTimeStamp");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshStartTimeStamp");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "airRefreshEndTimeStamp");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "roomType");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampBrightness");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDuration");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "wickdryDone");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmEnabled");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ywrmUsage");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightLampSteplessBrightness");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "alarms");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "humSubMode");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "use24Hour");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "waterInfill");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "sensorMode");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolFanSpeedLevel");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "coolAutoLevel");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightModeStartTime");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm1");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "nightPeriods");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "uuid");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ssid");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "bssid");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv4");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "ipv6");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "timeInSeconds");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm1");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm10");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "pm25");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "voc");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hcho");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "tmp");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "hum");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "fan");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "weight");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "rpm");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lat");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "lng");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "radius");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "textValue");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "isEnabled");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "oscillationMode");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationState");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationFixAngle");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMinAngle");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalOscillationMaxAngle");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationState");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationFixAngle");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMinAngle");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalOscillationMaxAngle");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "horizontalCalibrationState");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var285, "verticalCalibrationState");
               var286 = new ArrayList();
            } catch (Throwable var30051) {
               var10000 = var30051;
               boolean var10001 = false;
               break label223032;
            }

            while(true) {
               label223027: {
                  label223026: {
                     try {
                        if (!var285.step()) {
                           break label223033;
                        }

                        if (var285.isNull(var154)) {
                           break label223026;
                        }
                     } catch (Throwable var30050) {
                        var10000 = var30050;
                        boolean var30082 = false;
                        break;
                     }

                     try {
                        var30052 = var285.getText(var154);
                        break label223027;
                     } catch (Throwable var29964) {
                        var10000 = var29964;
                        boolean var30083 = false;
                        break;
                     }
                  }

                  var30052 = null;
               }

               String var244;
               label223019: {
                  label223018: {
                     try {
                        if (var285.isNull(var121)) {
                           break label223018;
                        }
                     } catch (Throwable var30049) {
                        var10000 = var30049;
                        boolean var30084 = false;
                        break;
                     }

                     try {
                        var244 = var285.getText(var121);
                        break label223019;
                     } catch (Throwable var29963) {
                        var10000 = var29963;
                        boolean var30085 = false;
                        break;
                     }
                  }

                  var244 = null;
               }

               String var245;
               label223012: {
                  label223011: {
                     try {
                        if (var285.isNull(var119)) {
                           break label223011;
                        }
                     } catch (Throwable var30048) {
                        var10000 = var30048;
                        boolean var30086 = false;
                        break;
                     }

                     try {
                        var245 = var285.getText(var119);
                        break label223012;
                     } catch (Throwable var29962) {
                        var10000 = var29962;
                        boolean var30087 = false;
                        break;
                     }
                  }

                  var245 = null;
               }

               int var156;
               Integer var246;
               label223005: {
                  label223004: {
                     try {
                        var156 = (int)var285.getLong(var122);
                        if (var285.isNull(var118)) {
                           break label223004;
                        }
                     } catch (Throwable var30047) {
                        var10000 = var30047;
                        boolean var30088 = false;
                        break;
                     }

                     try {
                        var246 = (int)var285.getLong(var118);
                        break label223005;
                     } catch (Throwable var29961) {
                        var10000 = var29961;
                        boolean var30089 = false;
                        break;
                     }
                  }

                  var246 = null;
               }

               Integer var247;
               label222998: {
                  label222997: {
                     try {
                        if (var285.isNull(var114)) {
                           break label222997;
                        }
                     } catch (Throwable var30046) {
                        var10000 = var30046;
                        boolean var30090 = false;
                        break;
                     }

                     try {
                        var247 = (int)var285.getLong(var114);
                        break label222998;
                     } catch (Throwable var29960) {
                        var10000 = var29960;
                        boolean var30091 = false;
                        break;
                     }
                  }

                  var247 = null;
               }

               String var248;
               label222991: {
                  label222990: {
                     try {
                        if (var285.isNull(var113)) {
                           break label222990;
                        }
                     } catch (Throwable var30045) {
                        var10000 = var30045;
                        boolean var30092 = false;
                        break;
                     }

                     try {
                        var248 = var285.getText(var113);
                        break label222991;
                     } catch (Throwable var29959) {
                        var10000 = var29959;
                        boolean var30093 = false;
                        break;
                     }
                  }

                  var248 = null;
               }

               Integer var249;
               label222984: {
                  label222983: {
                     try {
                        if (var285.isNull(var109)) {
                           break label222983;
                        }
                     } catch (Throwable var30044) {
                        var10000 = var30044;
                        boolean var30094 = false;
                        break;
                     }

                     try {
                        var249 = (int)var285.getLong(var109);
                        break label222984;
                     } catch (Throwable var29958) {
                        var10000 = var29958;
                        boolean var30095 = false;
                        break;
                     }
                  }

                  var249 = null;
               }

               String var250;
               label222977: {
                  label222976: {
                     try {
                        if (var285.isNull(var110)) {
                           break label222976;
                        }
                     } catch (Throwable var30043) {
                        var10000 = var30043;
                        boolean var30096 = false;
                        break;
                     }

                     try {
                        var250 = var285.getText(var110);
                        break label222977;
                     } catch (Throwable var29957) {
                        var10000 = var29957;
                        boolean var30097 = false;
                        break;
                     }
                  }

                  var250 = null;
               }

               boolean var209;
               label222970: {
                  label222969: {
                     try {
                        if ((int)var285.getLong(var108) != 0) {
                           break label222969;
                        }
                     } catch (Throwable var30042) {
                        var10000 = var30042;
                        boolean var30098 = false;
                        break;
                     }

                     var209 = false;
                     break label222970;
                  }

                  var209 = true;
               }

               Integer var251;
               label222963: {
                  label222962: {
                     try {
                        if (var285.isNull(var107)) {
                           break label222962;
                        }
                     } catch (Throwable var30041) {
                        var10000 = var30041;
                        boolean var30099 = false;
                        break;
                     }

                     try {
                        var251 = (int)var285.getLong(var107);
                        break label222963;
                     } catch (Throwable var29956) {
                        var10000 = var29956;
                        boolean var30100 = false;
                        break;
                     }
                  }

                  var251 = null;
               }

               boolean var210;
               label222956: {
                  label222955: {
                     try {
                        if ((int)var285.getLong(var115) != 0) {
                           break label222955;
                        }
                     } catch (Throwable var30040) {
                        var10000 = var30040;
                        boolean var30101 = false;
                        break;
                     }

                     var210 = false;
                     break label222956;
                  }

                  var210 = true;
               }

               boolean var211;
               label222949: {
                  label222948: {
                     try {
                        if ((int)var285.getLong(var112) != 0) {
                           break label222948;
                        }
                     } catch (Throwable var30039) {
                        var10000 = var30039;
                        boolean var30102 = false;
                        break;
                     }

                     var211 = false;
                     break label222949;
                  }

                  var211 = true;
               }

               boolean var212;
               label222942: {
                  label222941: {
                     try {
                        if ((int)var285.getLong(var111) != 0) {
                           break label222941;
                        }
                     } catch (Throwable var30038) {
                        var10000 = var30038;
                        boolean var30103 = false;
                        break;
                     }

                     var212 = false;
                     break label222942;
                  }

                  var212 = true;
               }

               String var252;
               label222935: {
                  label222934: {
                     try {
                        if (var285.isNull(var62)) {
                           break label222934;
                        }
                     } catch (Throwable var30037) {
                        var10000 = var30037;
                        boolean var30104 = false;
                        break;
                     }

                     try {
                        var252 = var285.getText(var62);
                        break label222935;
                     } catch (Throwable var29955) {
                        var10000 = var29955;
                        boolean var30105 = false;
                        break;
                     }
                  }

                  var252 = null;
               }

               int var155;
               long var234;
               String var253;
               label222928: {
                  label222927: {
                     try {
                        var155 = (int)var285.getLong(var120);
                        var234 = var285.getLong(var116);
                        if (var285.isNull(var151)) {
                           break label222927;
                        }
                     } catch (Throwable var30036) {
                        var10000 = var30036;
                        boolean var30106 = false;
                        break;
                     }

                     try {
                        var253 = var285.getText(var151);
                        break label222928;
                     } catch (Throwable var29954) {
                        var10000 = var29954;
                        boolean var30107 = false;
                        break;
                     }
                  }

                  var253 = null;
               }

               String var254;
               label222921: {
                  label222920: {
                     try {
                        if (var285.isNull(var150)) {
                           break label222920;
                        }
                     } catch (Throwable var30035) {
                        var10000 = var30035;
                        boolean var30108 = false;
                        break;
                     }

                     try {
                        var254 = var285.getText(var150);
                        break label222921;
                     } catch (Throwable var29953) {
                        var10000 = var29953;
                        boolean var30109 = false;
                        break;
                     }
                  }

                  var254 = null;
               }

               String var255;
               label222914: {
                  label222913: {
                     try {
                        if (var285.isNull(var149)) {
                           break label222913;
                        }
                     } catch (Throwable var30034) {
                        var10000 = var30034;
                        boolean var30110 = false;
                        break;
                     }

                     try {
                        var255 = var285.getText(var149);
                        break label222914;
                     } catch (Throwable var29952) {
                        var10000 = var29952;
                        boolean var30111 = false;
                        break;
                     }
                  }

                  var255 = null;
               }

               String var256;
               label222907: {
                  label222906: {
                     try {
                        if (var285.isNull(var148)) {
                           break label222906;
                        }
                     } catch (Throwable var30033) {
                        var10000 = var30033;
                        boolean var30112 = false;
                        break;
                     }

                     try {
                        var256 = var285.getText(var148);
                        break label222907;
                     } catch (Throwable var29951) {
                        var10000 = var29951;
                        boolean var30113 = false;
                        break;
                     }
                  }

                  var256 = null;
               }

               String var257;
               label222900: {
                  label222899: {
                     try {
                        if (var285.isNull(var147)) {
                           break label222899;
                        }
                     } catch (Throwable var30032) {
                        var10000 = var30032;
                        boolean var30114 = false;
                        break;
                     }

                     try {
                        var257 = var285.getText(var147);
                        break label222900;
                     } catch (Throwable var29950) {
                        var10000 = var29950;
                        boolean var30115 = false;
                        break;
                     }
                  }

                  var257 = null;
               }

               String var258;
               label222893: {
                  label222892: {
                     try {
                        if (var285.isNull(var146)) {
                           break label222892;
                        }
                     } catch (Throwable var30031) {
                        var10000 = var30031;
                        boolean var30116 = false;
                        break;
                     }

                     try {
                        var258 = var285.getText(var146);
                        break label222893;
                     } catch (Throwable var29949) {
                        var10000 = var29949;
                        boolean var30117 = false;
                        break;
                     }
                  }

                  var258 = null;
               }

               String var259;
               label222886: {
                  label222885: {
                     try {
                        if (var285.isNull(var145)) {
                           break label222885;
                        }
                     } catch (Throwable var30030) {
                        var10000 = var30030;
                        boolean var30118 = false;
                        break;
                     }

                     try {
                        var259 = var285.getText(var145);
                        break label222886;
                     } catch (Throwable var29948) {
                        var10000 = var29948;
                        boolean var30119 = false;
                        break;
                     }
                  }

                  var259 = null;
               }

               String var260;
               label222879: {
                  label222878: {
                     try {
                        if (var285.isNull(var144)) {
                           break label222878;
                        }
                     } catch (Throwable var30029) {
                        var10000 = var30029;
                        boolean var30120 = false;
                        break;
                     }

                     try {
                        var260 = var285.getText(var144);
                        break label222879;
                     } catch (Throwable var29947) {
                        var10000 = var29947;
                        boolean var30121 = false;
                        break;
                     }
                  }

                  var260 = null;
               }

               String var261;
               label222872: {
                  label222871: {
                     try {
                        if (var285.isNull(var143)) {
                           break label222871;
                        }
                     } catch (Throwable var30028) {
                        var10000 = var30028;
                        boolean var30122 = false;
                        break;
                     }

                     try {
                        var261 = var285.getText(var143);
                        break label222872;
                     } catch (Throwable var29946) {
                        var10000 = var29946;
                        boolean var30123 = false;
                        break;
                     }
                  }

                  var261 = null;
               }

               String var262;
               label222865: {
                  label222864: {
                     try {
                        if (var285.isNull(var142)) {
                           break label222864;
                        }
                     } catch (Throwable var30027) {
                        var10000 = var30027;
                        boolean var30124 = false;
                        break;
                     }

                     try {
                        var262 = var285.getText(var142);
                        break label222865;
                     } catch (Throwable var29945) {
                        var10000 = var29945;
                        boolean var30125 = false;
                        break;
                     }
                  }

                  var262 = null;
               }

               String var263;
               label222858: {
                  label222857: {
                     try {
                        if (var285.isNull(var141)) {
                           break label222857;
                        }
                     } catch (Throwable var30026) {
                        var10000 = var30026;
                        boolean var30126 = false;
                        break;
                     }

                     try {
                        var263 = var285.getText(var141);
                        break label222858;
                     } catch (Throwable var29944) {
                        var10000 = var29944;
                        boolean var30127 = false;
                        break;
                     }
                  }

                  var263 = null;
               }

               String var264;
               label222851: {
                  label222850: {
                     try {
                        if (var285.isNull(var140)) {
                           break label222850;
                        }
                     } catch (Throwable var30025) {
                        var10000 = var30025;
                        boolean var30128 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var140);
                        break label222851;
                     } catch (Throwable var29943) {
                        var10000 = var29943;
                        boolean var30129 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var287;
               try {
                  var287 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29942) {
                  var10000 = var29942;
                  boolean var30130 = false;
                  break;
               }

               label222843: {
                  label222842: {
                     try {
                        if (var285.isNull(var139)) {
                           break label222842;
                        }
                     } catch (Throwable var30024) {
                        var10000 = var30024;
                        boolean var30131 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var139);
                        break label222843;
                     } catch (Throwable var29941) {
                        var10000 = var29941;
                        boolean var30132 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var288;
               try {
                  var288 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29940) {
                  var10000 = var29940;
                  boolean var30133 = false;
                  break;
               }

               label222835: {
                  label222834: {
                     try {
                        if (var285.isNull(var138)) {
                           break label222834;
                        }
                     } catch (Throwable var30023) {
                        var10000 = var30023;
                        boolean var30134 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var138);
                        break label222835;
                     } catch (Throwable var29939) {
                        var10000 = var29939;
                        boolean var30135 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var289;
               try {
                  var289 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29938) {
                  var10000 = var29938;
                  boolean var30136 = false;
                  break;
               }

               label222827: {
                  label222826: {
                     try {
                        if (var285.isNull(var137)) {
                           break label222826;
                        }
                     } catch (Throwable var30022) {
                        var10000 = var30022;
                        boolean var30137 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var137);
                        break label222827;
                     } catch (Throwable var29937) {
                        var10000 = var29937;
                        boolean var30138 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var290;
               try {
                  var290 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29936) {
                  var10000 = var29936;
                  boolean var30139 = false;
                  break;
               }

               label222819: {
                  label222818: {
                     try {
                        if (var285.isNull(var136)) {
                           break label222818;
                        }
                     } catch (Throwable var30021) {
                        var10000 = var30021;
                        boolean var30140 = false;
                        break;
                     }

                     try {
                        var264 = var285.getText(var136);
                        break label222819;
                     } catch (Throwable var29935) {
                        var10000 = var29935;
                        boolean var30141 = false;
                        break;
                     }
                  }

                  var264 = null;
               }

               double[] var291;
               try {
                  var291 = DoubleArrayConverter.fromString(var264);
               } catch (Throwable var29934) {
                  var10000 = var29934;
                  boolean var30142 = false;
                  break;
               }

               int var157;
               boolean var213;
               label222811: {
                  label222810: {
                     try {
                        var157 = (int)var285.getLong(var105);
                        if ((int)var285.getLong(var104) != 0) {
                           break label222810;
                        }
                     } catch (Throwable var30020) {
                        var10000 = var30020;
                        boolean var30143 = false;
                        break;
                     }

                     var213 = false;
                     break label222811;
                  }

                  var213 = true;
               }

               boolean var214;
               label222804: {
                  label222803: {
                     try {
                        if ((int)var285.getLong(var102) != 0) {
                           break label222803;
                        }
                     } catch (Throwable var30019) {
                        var10000 = var30019;
                        boolean var30144 = false;
                        break;
                     }

                     var214 = false;
                     break label222804;
                  }

                  var214 = true;
               }

               boolean var215;
               label222797: {
                  label222796: {
                     try {
                        if ((int)var285.getLong(var101) != 0) {
                           break label222796;
                        }
                     } catch (Throwable var30018) {
                        var10000 = var30018;
                        boolean var30145 = false;
                        break;
                     }

                     var215 = false;
                     break label222797;
                  }

                  var215 = true;
               }

               boolean var216;
               label222790: {
                  label222789: {
                     try {
                        if ((int)var285.getLong(var100) != 0) {
                           break label222789;
                        }
                     } catch (Throwable var30017) {
                        var10000 = var30017;
                        boolean var30146 = false;
                        break;
                     }

                     var216 = false;
                     break label222790;
                  }

                  var216 = true;
               }

               boolean var217;
               label222783: {
                  label222782: {
                     try {
                        if ((int)var285.getLong(var98) != 0) {
                           break label222782;
                        }
                     } catch (Throwable var30016) {
                        var10000 = var30016;
                        boolean var30147 = false;
                        break;
                     }

                     var217 = false;
                     break label222783;
                  }

                  var217 = true;
               }

               boolean var218;
               label222776: {
                  label222775: {
                     try {
                        if ((int)var285.getLong(var96) != 0) {
                           break label222775;
                        }
                     } catch (Throwable var30015) {
                        var10000 = var30015;
                        boolean var30148 = false;
                        break;
                     }

                     var218 = false;
                     break label222776;
                  }

                  var218 = true;
               }

               label222769: {
                  label222768: {
                     try {
                        if (var285.isNull(var95)) {
                           break label222768;
                        }
                     } catch (Throwable var30014) {
                        var10000 = var30014;
                        boolean var30149 = false;
                        break;
                     }

                     try {
                        var30062 = (int)var285.getLong(var95);
                        break label222769;
                     } catch (Throwable var29933) {
                        var10000 = var29933;
                        boolean var30150 = false;
                        break;
                     }
                  }

                  var30062 = null;
               }

               Boolean var30063;
               if (var30062 == null) {
                  var30063 = null;
               } else {
                  boolean var219;
                  label222760: {
                     label222759: {
                        try {
                           if (var30062 != 0) {
                              break label222759;
                           }
                        } catch (Throwable var30013) {
                           var10000 = var30013;
                           boolean var30151 = false;
                           break;
                        }

                        var219 = false;
                        break label222760;
                     }

                     var219 = true;
                  }

                  try {
                     var30063 = var219;
                  } catch (Throwable var29932) {
                     var10000 = var29932;
                     boolean var30152 = false;
                     break;
                  }
               }

               boolean var30055;
               label222753: {
                  label222752: {
                     try {
                        if ((int)var285.getLong(var94) != 0) {
                           break label222752;
                        }
                     } catch (Throwable var30012) {
                        var10000 = var30012;
                        boolean var30153 = false;
                        break;
                     }

                     var30055 = false;
                     break label222753;
                  }

                  var30055 = true;
               }

               String var265;
               label222746: {
                  label222745: {
                     try {
                        if (var285.isNull(var92)) {
                           break label222745;
                        }
                     } catch (Throwable var30011) {
                        var10000 = var30011;
                        boolean var30154 = false;
                        break;
                     }

                     try {
                        var265 = var285.getText(var92);
                        break label222746;
                     } catch (Throwable var29931) {
                        var10000 = var29931;
                        boolean var30155 = false;
                        break;
                     }
                  }

                  var265 = null;
               }

               boolean var220;
               label222739: {
                  label222738: {
                     try {
                        if ((int)var285.getLong(var91) != 0) {
                           break label222738;
                        }
                     } catch (Throwable var30010) {
                        var10000 = var30010;
                        boolean var30156 = false;
                        break;
                     }

                     var220 = false;
                     break label222739;
                  }

                  var220 = true;
               }

               String var266;
               label222732: {
                  label222731: {
                     try {
                        if (var285.isNull(var135)) {
                           break label222731;
                        }
                     } catch (Throwable var30009) {
                        var10000 = var30009;
                        boolean var30157 = false;
                        break;
                     }

                     try {
                        var266 = var285.getText(var135);
                        break label222732;
                     } catch (Throwable var29930) {
                        var10000 = var29930;
                        boolean var30158 = false;
                        break;
                     }
                  }

                  var266 = null;
               }

               String var267;
               label222725: {
                  label222724: {
                     try {
                        if (var285.isNull(var86)) {
                           break label222724;
                        }
                     } catch (Throwable var30008) {
                        var10000 = var30008;
                        boolean var30159 = false;
                        break;
                     }

                     try {
                        var267 = var285.getText(var86);
                        break label222725;
                     } catch (Throwable var29929) {
                        var10000 = var29929;
                        boolean var30160 = false;
                        break;
                     }
                  }

                  var267 = null;
               }

               String var268;
               label222718: {
                  label222717: {
                     try {
                        if (var285.isNull(var134)) {
                           break label222717;
                        }
                     } catch (Throwable var30007) {
                        var10000 = var30007;
                        boolean var30161 = false;
                        break;
                     }

                     try {
                        var268 = var285.getText(var134);
                        break label222718;
                     } catch (Throwable var29928) {
                        var10000 = var29928;
                        boolean var30162 = false;
                        break;
                     }
                  }

                  var268 = null;
               }

               Integer var269;
               label222711: {
                  label222710: {
                     try {
                        if (var285.isNull(var82)) {
                           break label222710;
                        }
                     } catch (Throwable var30006) {
                        var10000 = var30006;
                        boolean var30163 = false;
                        break;
                     }

                     try {
                        var269 = (int)var285.getLong(var82);
                        break label222711;
                     } catch (Throwable var29927) {
                        var10000 = var29927;
                        boolean var30164 = false;
                        break;
                     }
                  }

                  var269 = null;
               }

               Boolean var30064;
               if (var269 == null) {
                  var30064 = null;
               } else {
                  boolean var221;
                  label222702: {
                     label222701: {
                        try {
                           if (var269 != 0) {
                              break label222701;
                           }
                        } catch (Throwable var30005) {
                           var10000 = var30005;
                           boolean var30165 = false;
                           break;
                        }

                        var221 = false;
                        break label222702;
                     }

                     var221 = true;
                  }

                  try {
                     var30064 = var221;
                  } catch (Throwable var29926) {
                     var10000 = var29926;
                     boolean var30166 = false;
                     break;
                  }
               }

               Integer var270;
               label222695: {
                  label222694: {
                     try {
                        if (var285.isNull(var79)) {
                           break label222694;
                        }
                     } catch (Throwable var30004) {
                        var10000 = var30004;
                        boolean var30167 = false;
                        break;
                     }

                     try {
                        var270 = (int)var285.getLong(var79);
                        break label222695;
                     } catch (Throwable var29925) {
                        var10000 = var29925;
                        boolean var30168 = false;
                        break;
                     }
                  }

                  var270 = null;
               }

               Long var271;
               label222688: {
                  label222687: {
                     try {
                        if (var285.isNull(var78)) {
                           break label222687;
                        }
                     } catch (Throwable var30003) {
                        var10000 = var30003;
                        boolean var30169 = false;
                        break;
                     }

                     try {
                        var271 = var285.getLong(var78);
                        break label222688;
                     } catch (Throwable var29924) {
                        var10000 = var29924;
                        boolean var30170 = false;
                        break;
                     }
                  }

                  var271 = null;
               }

               boolean var30056;
               label222681: {
                  label222680: {
                     try {
                        if ((int)var285.getLong(var76) != 0) {
                           break label222680;
                        }
                     } catch (Throwable var30002) {
                        var10000 = var30002;
                        boolean var30171 = false;
                        break;
                     }

                     var30056 = false;
                     break label222681;
                  }

                  var30056 = true;
               }

               boolean var222;
               label222674: {
                  label222673: {
                     try {
                        if ((int)var285.getLong(var75) != 0) {
                           break label222673;
                        }
                     } catch (Throwable var30001) {
                        var10000 = var30001;
                        boolean var30172 = false;
                        break;
                     }

                     var222 = false;
                     break label222674;
                  }

                  var222 = true;
               }

               int var163;
               int var164;
               boolean var223;
               long var236;
               label222667: {
                  label222666: {
                     try {
                        var164 = (int)var285.getLong(var73);
                        var236 = var285.getLong(var71);
                        var163 = (int)var285.getLong(var72);
                        if ((int)var285.getLong(var70) != 0) {
                           break label222666;
                        }
                     } catch (Throwable var30000) {
                        var10000 = var30000;
                        boolean var30173 = false;
                        break;
                     }

                     var223 = false;
                     break label222667;
                  }

                  var223 = true;
               }

               int var158;
               int var159;
               int var160;
               int var161;
               int var162;
               long var240;
               try {
                  var160 = (int)var285.getLong(var69);
                  var159 = (int)var285.getLong(var65);
                  var162 = (int)var285.getLong(var68);
                  var158 = (int)var285.getLong(var66);
                  var240 = var285.getLong(var153);
                  var161 = (int)var285.getLong(var133);
               } catch (Throwable var29923) {
                  var10000 = var29923;
                  boolean var30174 = false;
                  break;
               }

               double var5;
               double var7;
               int var165;
               int var166;
               int var167;
               int var168;
               int var169;
               int var170;
               int var171;
               int var172;
               int var173;
               try {
                  var167 = (int)var285.getLong(var64);
                  var171 = (int)var285.getLong(var63);
                  var166 = (int)var285.getLong(var61);
                  var168 = (int)var285.getLong(var60);
                  var173 = (int)var285.getLong(var59);
                  var170 = (int)var285.getLong(var58);
                  var165 = (int)var285.getLong(var57);
                  var169 = (int)var285.getLong(var56);
                  var172 = (int)var285.getLong(var55);
                  var7 = var285.getDouble(var131);
                  var5 = var285.getDouble(var132);
               } catch (Throwable var29922) {
                  var10000 = var29922;
                  boolean var30175 = false;
                  break;
               }

               int var174;
               try {
                  var174 = (int)var285.getLong(var130);
               } catch (Throwable var29921) {
                  var10000 = var29921;
                  boolean var30176 = false;
                  break;
               }

               int var175;
               int var176;
               String var272;
               label222659: {
                  label222658: {
                     try {
                        var176 = (int)var285.getLong(var54);
                        var175 = (int)var285.getLong(var53);
                        if (var285.isNull(var52)) {
                           break label222658;
                        }
                     } catch (Throwable var29999) {
                        var10000 = var29999;
                        boolean var30177 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var52);
                        break label222659;
                     } catch (Throwable var29920) {
                        var10000 = var29920;
                        boolean var30178 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               int var177;
               double[] var292;
               label222652: {
                  label222651: {
                     try {
                        var292 = DoubleArrayConverter.fromString(var272);
                        var177 = (int)var285.getLong(var129);
                        if (var285.isNull(var128)) {
                           break label222651;
                        }
                     } catch (Throwable var29998) {
                        var10000 = var29998;
                        boolean var30179 = false;
                        break;
                     }

                     try {
                        var272 = var285.getText(var128);
                        break label222652;
                     } catch (Throwable var29919) {
                        var10000 = var29919;
                        boolean var30180 = false;
                        break;
                     }
                  }

                  var272 = null;
               }

               double[] var293;
               try {
                  var293 = DoubleArrayConverter.fromString(var272);
               } catch (Throwable var29918) {
                  var10000 = var29918;
                  boolean var30181 = false;
                  break;
               }

               boolean var224;
               label222644: {
                  label222643: {
                     try {
                        if ((int)var285.getLong(var51) != 0) {
                           break label222643;
                        }
                     } catch (Throwable var29997) {
                        var10000 = var29997;
                        boolean var30182 = false;
                        break;
                     }

                     var224 = false;
                     break label222644;
                  }

                  var224 = true;
               }

               int var178;
               int var179;
               int var180;
               boolean var225;
               label222637: {
                  label222636: {
                     try {
                        var178 = (int)var285.getLong(var50);
                        var179 = (int)var285.getLong(var49);
                        var180 = (int)var285.getLong(var48);
                        if ((int)var285.getLong(var47) != 0) {
                           break label222636;
                        }
                     } catch (Throwable var29996) {
                        var10000 = var29996;
                        boolean var30183 = false;
                        break;
                     }

                     var225 = false;
                     break label222637;
                  }

                  var225 = true;
               }

               int var181;
               try {
                  var181 = (int)var285.getLong(var127);
               } catch (Throwable var29917) {
                  var10000 = var29917;
                  boolean var30184 = false;
                  break;
               }

               boolean var226;
               label222629: {
                  label222628: {
                     try {
                        if ((int)var285.getLong(var126) != 0) {
                           break label222628;
                        }
                     } catch (Throwable var29995) {
                        var10000 = var29995;
                        boolean var30185 = false;
                        break;
                     }

                     var226 = false;
                     break label222629;
                  }

                  var226 = true;
               }

               boolean var227;
               label222622: {
                  label222621: {
                     try {
                        if ((int)var285.getLong(var46) != 0) {
                           break label222621;
                        }
                     } catch (Throwable var29994) {
                        var10000 = var29994;
                        boolean var30186 = false;
                        break;
                     }

                     var227 = false;
                     break label222622;
                  }

                  var227 = true;
               }

               int var182;
               int var183;
               boolean var228;
               label222615: {
                  label222614: {
                     try {
                        var182 = (int)var285.getLong(var45);
                        var183 = (int)var285.getLong(var44);
                        if ((int)var285.getLong(var43) != 0) {
                           break label222614;
                        }
                     } catch (Throwable var29993) {
                        var10000 = var29993;
                        boolean var30187 = false;
                        break;
                     }

                     var228 = false;
                     break label222615;
                  }

                  var228 = true;
               }

               boolean var229;
               label222608: {
                  label222607: {
                     try {
                        if ((int)var285.getLong(var125) != 0) {
                           break label222607;
                        }
                     } catch (Throwable var29992) {
                        var10000 = var29992;
                        boolean var30188 = false;
                        break;
                     }

                     var229 = false;
                     break label222608;
                  }

                  var229 = true;
               }

               int var184;
               try {
                  var184 = (int)var285.getLong(var124);
               } catch (Throwable var29916) {
                  var10000 = var29916;
                  boolean var30189 = false;
                  break;
               }

               int var185;
               int var186;
               int var187;
               int var188;
               int var189;
               int var190;
               int var191;
               boolean var230;
               label222600: {
                  label222599: {
                     try {
                        var186 = (int)var285.getLong(var42);
                        var189 = (int)var285.getLong(var41);
                        var185 = (int)var285.getLong(var40);
                        var188 = (int)var285.getLong(var39);
                        var191 = (int)var285.getLong(var38);
                        var190 = (int)var285.getLong(var37);
                        var187 = (int)var285.getLong(var36);
                        if ((int)var285.getLong(var35) != 0) {
                           break label222599;
                        }
                     } catch (Throwable var29991) {
                        var10000 = var29991;
                        boolean var30190 = false;
                        break;
                     }

                     var230 = false;
                     break label222600;
                  }

                  var230 = true;
               }

               label222593: {
                  label222592: {
                     try {
                        if (var285.isNull(var123)) {
                           break label222592;
                        }
                     } catch (Throwable var29990) {
                        var10000 = var29990;
                        boolean var30191 = false;
                        break;
                     }

                     try {
                        var30066 = (int)var285.getLong(var123);
                        break label222593;
                     } catch (Throwable var29915) {
                        var10000 = var29915;
                        boolean var30192 = false;
                        break;
                     }
                  }

                  var30066 = null;
               }

               Boolean var30067;
               if (var30066 == null) {
                  var30067 = null;
               } else {
                  boolean var231;
                  label222584: {
                     label222583: {
                        try {
                           if (var30066 != 0) {
                              break label222583;
                           }
                        } catch (Throwable var29989) {
                           var10000 = var29989;
                           boolean var30193 = false;
                           break;
                        }

                        var231 = false;
                        break label222584;
                     }

                     var231 = true;
                  }

                  try {
                     var30067 = var231;
                  } catch (Throwable var29914) {
                     var10000 = var29914;
                     boolean var30194 = false;
                     break;
                  }
               }

               int var192;
               try {
                  var192 = (int)var285.getLong(var117);
               } catch (Throwable var29913) {
                  var10000 = var29913;
                  boolean var30195 = false;
                  break;
               }

               int var194;
               String var273;
               label222576: {
                  label222575: {
                     try {
                        var194 = (int)var285.getLong(var34);
                        if (var285.isNull(var33)) {
                           break label222575;
                        }
                     } catch (Throwable var29988) {
                        var10000 = var29988;
                        boolean var30196 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var33);
                        break label222576;
                     } catch (Throwable var29912) {
                        var10000 = var29912;
                        boolean var30197 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               int var193;
               List var294;
               boolean var30057;
               label222569: {
                  label222568: {
                     try {
                        var294 = DeviceAlarmListConverter.fromString(var273);
                        var193 = (int)var285.getLong(var32);
                        if ((int)var285.getLong(var31) != 0) {
                           break label222568;
                        }
                     } catch (Throwable var29987) {
                        var10000 = var29987;
                        boolean var30198 = false;
                        break;
                     }

                     var30057 = false;
                     break label222569;
                  }

                  var30057 = true;
               }

               boolean var232;
               label222562: {
                  label222561: {
                     try {
                        if ((int)var285.getLong(var30) != 0) {
                           break label222561;
                        }
                     } catch (Throwable var29986) {
                        var10000 = var29986;
                        boolean var30199 = false;
                        break;
                     }

                     var232 = false;
                     break label222562;
                  }

                  var232 = true;
               }

               int var195;
               int var196;
               int var197;
               int var198;
               long var238;
               label222555: {
                  label222554: {
                     try {
                        var198 = (int)var285.getLong(var26);
                        var195 = (int)var285.getLong(var29);
                        var196 = (int)var285.getLong(var24);
                        var238 = var285.getLong(var88);
                        var197 = (int)var285.getLong(var20);
                        if (var285.isNull(var28)) {
                           break label222554;
                        }
                     } catch (Throwable var29985) {
                        var10000 = var29985;
                        boolean var30200 = false;
                        break;
                     }

                     try {
                        var273 = var285.getText(var28);
                        break label222555;
                     } catch (Throwable var29911) {
                        var10000 = var29911;
                        boolean var30201 = false;
                        break;
                     }
                  }

                  var273 = null;
               }

               double[] var295;
               label222548: {
                  label223044: {
                     try {
                        var295 = DoubleArrayConverter.fromString(var273);
                        if (var285.isNull(var27) && var285.isNull(var87) && var285.isNull(var21) && var285.isNull(var25) && var285.isNull(var23)) {
                           break label223044;
                        }
                     } catch (Throwable var29984) {
                        var10000 = var29984;
                        boolean var30202 = false;
                        break;
                     }

                     label222529: {
                        label222528: {
                           try {
                              if (var285.isNull(var27)) {
                                 break label222528;
                              }
                           } catch (Throwable var29983) {
                              var10000 = var29983;
                              boolean var30203 = false;
                              break;
                           }

                           try {
                              var273 = var285.getText(var27);
                              break label222529;
                           } catch (Throwable var29910) {
                              var10000 = var29910;
                              boolean var30204 = false;
                              break;
                           }
                        }

                        var273 = null;
                     }

                     String var274;
                     label222522: {
                        label222521: {
                           try {
                              if (var285.isNull(var87)) {
                                 break label222521;
                              }
                           } catch (Throwable var29982) {
                              var10000 = var29982;
                              boolean var30205 = false;
                              break;
                           }

                           try {
                              var274 = var285.getText(var87);
                              break label222522;
                           } catch (Throwable var29909) {
                              var10000 = var29909;
                              boolean var30206 = false;
                              break;
                           }
                        }

                        var274 = null;
                     }

                     String var275;
                     label222515: {
                        label222514: {
                           try {
                              if (var285.isNull(var21)) {
                                 break label222514;
                              }
                           } catch (Throwable var29981) {
                              var10000 = var29981;
                              boolean var30207 = false;
                              break;
                           }

                           try {
                              var275 = var285.getText(var21);
                              break label222515;
                           } catch (Throwable var29908) {
                              var10000 = var29908;
                              boolean var30208 = false;
                              break;
                           }
                        }

                        var275 = null;
                     }

                     String var276;
                     label222508: {
                        label222507: {
                           try {
                              if (var285.isNull(var25)) {
                                 break label222507;
                              }
                           } catch (Throwable var29980) {
                              var10000 = var29980;
                              boolean var30209 = false;
                              break;
                           }

                           try {
                              var276 = var285.getText(var25);
                              break label222508;
                           } catch (Throwable var29907) {
                              var10000 = var29907;
                              boolean var30210 = false;
                              break;
                           }
                        }

                        var276 = null;
                     }

                     String var277;
                     label222501: {
                        label222500: {
                           try {
                              if (var285.isNull(var23)) {
                                 break label222500;
                              }
                           } catch (Throwable var29979) {
                              var10000 = var29979;
                              boolean var30211 = false;
                              break;
                           }

                           try {
                              var277 = var285.getText(var23);
                              break label222501;
                           } catch (Throwable var29906) {
                              var10000 = var29906;
                              boolean var30212 = false;
                              break;
                           }
                        }

                        var277 = null;
                     }

                     DeviceUuidEntity var278;
                     try {
                        var278 = new DeviceUuidEntity(var273, var274, var275, var276, var277);
                     } catch (Throwable var29905) {
                        var10000 = var29905;
                        boolean var30213 = false;
                        break;
                     }

                     var30070 = var278;
                     break label222548;
                  }

                  var30070 = null;
               }

               IndoorDatapoint var30072;
               label222494: {
                  label223045: {
                     try {
                        if (var285.isNull(var89) && var285.isNull(var18) && var285.isNull(var11) && var285.isNull(var22) && var285.isNull(var17) && var285.isNull(var12) && var285.isNull(var13) && var285.isNull(var14) && var285.isNull(var15) && var285.isNull(var19) && var285.isNull(var83)) {
                           break label223045;
                        }
                     } catch (Throwable var29978) {
                        var10000 = var29978;
                        boolean var30214 = false;
                        break;
                     }

                     long var242;
                     label222465: {
                        label222464: {
                           try {
                              var242 = var285.getLong(var89);
                              if (var285.isNull(var18)) {
                                 break label222464;
                              }
                           } catch (Throwable var29977) {
                              var10000 = var29977;
                              boolean var30215 = false;
                              break;
                           }

                           try {
                              var30071 = (float)var285.getDouble(var18);
                              break label222465;
                           } catch (Throwable var29904) {
                              var10000 = var29904;
                              boolean var30216 = false;
                              break;
                           }
                        }

                        var30071 = null;
                     }

                     Float var30073;
                     label222458: {
                        label222457: {
                           try {
                              if (var285.isNull(var11)) {
                                 break label222457;
                              }
                           } catch (Throwable var29976) {
                              var10000 = var29976;
                              boolean var30217 = false;
                              break;
                           }

                           try {
                              var30073 = (float)var285.getDouble(var11);
                              break label222458;
                           } catch (Throwable var29903) {
                              var10000 = var29903;
                              boolean var30218 = false;
                              break;
                           }
                        }

                        var30073 = null;
                     }

                     Float var30076;
                     label222451: {
                        label222450: {
                           try {
                              if (var285.isNull(var22)) {
                                 break label222450;
                              }
                           } catch (Throwable var29975) {
                              var10000 = var29975;
                              boolean var30219 = false;
                              break;
                           }

                           try {
                              var30076 = (float)var285.getDouble(var22);
                              break label222451;
                           } catch (Throwable var29902) {
                              var10000 = var29902;
                              boolean var30220 = false;
                              break;
                           }
                        }

                        var30076 = null;
                     }

                     Float var30079;
                     label222444: {
                        label222443: {
                           try {
                              if (var285.isNull(var17)) {
                                 break label222443;
                              }
                           } catch (Throwable var29974) {
                              var10000 = var29974;
                              boolean var30221 = false;
                              break;
                           }

                           try {
                              var30079 = (float)var285.getDouble(var17);
                              break label222444;
                           } catch (Throwable var29901) {
                              var10000 = var29901;
                              boolean var30222 = false;
                              break;
                           }
                        }

                        var30079 = null;
                     }

                     Float var30081;
                     label222437: {
                        label222436: {
                           try {
                              if (var285.isNull(var12)) {
                                 break label222436;
                              }
                           } catch (Throwable var29973) {
                              var10000 = var29973;
                              boolean var30223 = false;
                              break;
                           }

                           try {
                              var30081 = (float)var285.getDouble(var12);
                              break label222437;
                           } catch (Throwable var29900) {
                              var10000 = var29900;
                              boolean var30224 = false;
                              break;
                           }
                        }

                        var30081 = null;
                     }

                     Float var279;
                     label222430: {
                        label222429: {
                           try {
                              if (var285.isNull(var13)) {
                                 break label222429;
                              }
                           } catch (Throwable var29972) {
                              var10000 = var29972;
                              boolean var30225 = false;
                              break;
                           }

                           try {
                              var279 = (float)var285.getDouble(var13);
                              break label222430;
                           } catch (Throwable var29899) {
                              var10000 = var29899;
                              boolean var30226 = false;
                              break;
                           }
                        }

                        var279 = null;
                     }

                     Float var280;
                     label222423: {
                        label222422: {
                           try {
                              if (var285.isNull(var14)) {
                                 break label222422;
                              }
                           } catch (Throwable var29971) {
                              var10000 = var29971;
                              boolean var30227 = false;
                              break;
                           }

                           try {
                              var280 = (float)var285.getDouble(var14);
                              break label222423;
                           } catch (Throwable var29898) {
                              var10000 = var29898;
                              boolean var30228 = false;
                              break;
                           }
                        }

                        var280 = null;
                     }

                     Float var281;
                     label222416: {
                        label222415: {
                           try {
                              if (var285.isNull(var15)) {
                                 break label222415;
                              }
                           } catch (Throwable var29970) {
                              var10000 = var29970;
                              boolean var30229 = false;
                              break;
                           }

                           try {
                              var281 = (float)var285.getDouble(var15);
                              break label222416;
                           } catch (Throwable var29897) {
                              var10000 = var29897;
                              boolean var30230 = false;
                              break;
                           }
                        }

                        var281 = null;
                     }

                     Float var282;
                     label222409: {
                        label222408: {
                           try {
                              if (var285.isNull(var19)) {
                                 break label222408;
                              }
                           } catch (Throwable var29969) {
                              var10000 = var29969;
                              boolean var30231 = false;
                              break;
                           }

                           try {
                              var282 = (float)var285.getDouble(var19);
                              break label222409;
                           } catch (Throwable var29896) {
                              var10000 = var29896;
                              boolean var30232 = false;
                              break;
                           }
                        }

                        var282 = null;
                     }

                     Float var283;
                     label222402: {
                        label222401: {
                           try {
                              if (var285.isNull(var83)) {
                                 break label222401;
                              }
                           } catch (Throwable var29968) {
                              var10000 = var29968;
                              boolean var30233 = false;
                              break;
                           }

                           try {
                              var283 = (float)var285.getDouble(var83);
                              break label222402;
                           } catch (Throwable var29895) {
                              var10000 = var29895;
                              boolean var30234 = false;
                              break;
                           }
                        }

                        var283 = null;
                     }

                     IndoorDatapoint var284;
                     try {
                        var284 = new IndoorDatapoint(var242, var30071, var30073, var30076, var30079, var30081, var279, var280, var281, var282, var283);
                     } catch (Throwable var29894) {
                        var10000 = var29894;
                        boolean var30235 = false;
                        break;
                     }

                     var30072 = var284;
                     break label222494;
                  }

                  var30072 = null;
               }

               WelcomeHomeLocation var30075;
               label222395: {
                  label223046: {
                     try {
                        if (var285.isNull(var81) && var285.isNull(var9) && var285.isNull(var10) && var285.isNull(var106) && var285.isNull(var16)) {
                           break label223046;
                        }
                     } catch (Throwable var29967) {
                        var10000 = var29967;
                        boolean var30236 = false;
                        break;
                     }

                     double var1;
                     try {
                        var1 = var285.getDouble(var81);
                     } catch (Throwable var29893) {
                        var10000 = var29893;
                        boolean var30237 = false;
                        break;
                     }

                     double var3;
                     int var199;
                     label222374: {
                        label222373: {
                           try {
                              var3 = var285.getDouble(var9);
                              var199 = (int)var285.getLong(var10);
                              if (var285.isNull(var106)) {
                                 break label222373;
                              }
                           } catch (Throwable var29966) {
                              var10000 = var29966;
                              boolean var30238 = false;
                              break;
                           }

                           try {
                              var30074 = var285.getText(var106);
                              break label222374;
                           } catch (Throwable var29892) {
                              var10000 = var29892;
                              boolean var30239 = false;
                              break;
                           }
                        }

                        var30074 = null;
                     }

                     boolean var233;
                     label222366: {
                        label222365: {
                           try {
                              if ((int)var285.getLong(var16) != 0) {
                                 break label222365;
                              }
                           } catch (Throwable var29965) {
                              var10000 = var29965;
                              boolean var30240 = false;
                              break;
                           }

                           var233 = false;
                           break label222366;
                        }

                        var233 = true;
                     }

                     WelcomeHomeLocation var30077;
                     try {
                        var30077 = new WelcomeHomeLocation(var1, var3, var199, var30074, var233);
                     } catch (Throwable var29891) {
                        var10000 = var29891;
                        boolean var30241 = false;
                        break;
                     }

                     var30075 = var30077;
                     break label222395;
                  }

                  var30075 = null;
               }

               int var152;
               try {
                  var152 = (int)var285.getLong(var103);
               } catch (Throwable var29890) {
                  var10000 = var29890;
                  boolean var30242 = false;
                  break;
               }

               int var30054;
               try {
                  var30054 = (int)var285.getLong(var99);
               } catch (Throwable var29889) {
                  var10000 = var29889;
                  boolean var30243 = false;
                  break;
               }

               int var200;
               try {
                  var200 = (int)var285.getLong(var97);
               } catch (Throwable var29888) {
                  var10000 = var29888;
                  boolean var30244 = false;
                  break;
               }

               int var201;
               try {
                  var201 = (int)var285.getLong(var93);
               } catch (Throwable var29887) {
                  var10000 = var29887;
                  boolean var30245 = false;
                  break;
               }

               int var202;
               try {
                  var202 = (int)var285.getLong(var90);
               } catch (Throwable var29886) {
                  var10000 = var29886;
                  boolean var30246 = false;
                  break;
               }

               int var203;
               try {
                  var203 = (int)var285.getLong(var85);
               } catch (Throwable var29885) {
                  var10000 = var29885;
                  boolean var30247 = false;
                  break;
               }

               int var204;
               try {
                  var204 = (int)var285.getLong(var84);
               } catch (Throwable var29884) {
                  var10000 = var29884;
                  boolean var30248 = false;
                  break;
               }

               int var205;
               try {
                  var205 = (int)var285.getLong(var80);
               } catch (Throwable var29883) {
                  var10000 = var29883;
                  boolean var30249 = false;
                  break;
               }

               int var206;
               try {
                  var206 = (int)var285.getLong(var77);
               } catch (Throwable var29882) {
                  var10000 = var29882;
                  boolean var30250 = false;
                  break;
               }

               int var207;
               try {
                  var207 = (int)var285.getLong(var74);
               } catch (Throwable var29881) {
                  var10000 = var29881;
                  boolean var30251 = false;
                  break;
               }

               try {
                  int var208 = (int)var285.getLong(var67);
                  DualOscillationConfig var30080 = new DualOscillationConfig(var152, var30054, var200, var201, var202, var203, var204, var205, var206, var207, var208);
                  DeviceEntity var30078 = new DeviceEntity(var30052, var244, var245, var156, var246, var247, var248, var249, var250, var30070, var209, var30072, var251, var210, var211, var212, var252, var155, var234, var253, var254, var255, var256, var257, var258, var259, var260, var261, var262, var263, var287, var288, var289, var290, var291, var157, var213, var214, var215, var216, var217, var218, var30063, var30055, var265, var220, var266, var267, var30075, var268, var30064, var270, var271, var30056, var222, var164, var236, var163, var223, var160, var159, var162, var158, var240, var161, var167, var171, var166, var168, var173, var170, var165, var169, var172, var7, var5, var174, var176, var175, var292, var177, var293, var224, var178, var179, var180, var225, var181, var226, var227, var182, var183, var228, var229, var184, var186, var189, var185, var188, var191, var190, var187, var230, var30067, var192, var194, var294, var193, var30057, var232, var198, var195, var196, var238, var30080, var197, var295);
                  var286.add(var30078);
               } catch (Throwable var29880) {
                  var10000 = var29880;
                  boolean var30252 = false;
                  break;
               }
            }
         }

         Throwable var30053 = var10000;
         var285.close();
         throw var30053;
      }

      var285.close();
      return var286;
   }

   // $FF: synthetic method
   static DeviceEntity lambda$liveDevice$6(String var0, SQLiteConnection var1) {
      SQLiteStatement var231;
      label197485: {
         Throwable var10000;
         label197487: {
            var231 = var1.prepare("SELECT * from device_table WHERE uid = ?");
            if (var0 == null) {
               try {
                  var231.bindNull(1);
               } catch (Throwable var23192) {
                  var10000 = var23192;
                  boolean var10001 = false;
                  break label197487;
               }
            } else {
               try {
                  var231.bindText(1, var0);
               } catch (Throwable var23191) {
                  var10000 = var23191;
                  boolean var23280 = false;
                  break label197487;
               }
            }

            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            int var21;
            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var30;
            int var31;
            int var32;
            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            int var38;
            int var39;
            int var40;
            int var41;
            int var42;
            int var43;
            int var44;
            int var45;
            int var46;
            int var47;
            int var48;
            int var49;
            int var50;
            int var51;
            int var52;
            int var53;
            int var54;
            int var55;
            int var56;
            int var57;
            int var58;
            int var59;
            int var60;
            int var61;
            int var62;
            int var63;
            int var64;
            int var65;
            int var66;
            int var67;
            int var68;
            int var69;
            int var70;
            int var71;
            int var72;
            int var73;
            int var74;
            int var75;
            int var76;
            int var77;
            int var78;
            int var79;
            int var80;
            int var81;
            int var82;
            int var83;
            int var84;
            int var85;
            int var86;
            int var87;
            int var88;
            int var89;
            int var90;
            int var91;
            int var92;
            int var93;
            int var94;
            int var95;
            int var96;
            int var97;
            int var98;
            int var99;
            int var100;
            int var101;
            int var102;
            int var103;
            int var104;
            int var105;
            int var106;
            int var107;
            int var108;
            int var109;
            int var110;
            int var111;
            int var112;
            int var113;
            int var114;
            int var115;
            int var116;
            int var117;
            int var118;
            int var119;
            int var120;
            int var121;
            int var122;
            int var123;
            int var124;
            int var125;
            int var126;
            int var127;
            int var128;
            int var129;
            int var130;
            int var131;
            int var132;
            int var133;
            int var134;
            int var135;
            int var136;
            int var137;
            int var138;
            int var139;
            int var140;
            int var141;
            int var142;
            int var143;
            int var144;
            int var145;
            int var146;
            int var147;
            int var148;
            int var149;
            int var150;
            int var151;
            int var152;
            int var153;
            int var154;
            boolean var155;
            try {
               var152 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "uid");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "name");
               var153 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "modelName");
               var154 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "typeIndex");
               var150 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "fanSpeed");
               var142 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterLife");
               var51 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "autoModeText");
               var148 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "brightness");
               var149 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "info");
               var141 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hasFinishedOnboarding");
               var145 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lastSelectedSensorType");
               var146 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isAblDevice");
               var143 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isNightModeOn");
               var151 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isChildLockOn");
               var144 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "linkedDeviceUid");
               var147 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "connectivityStatusIndex");
               var130 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lastConnectivityMillis");
               var135 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mac");
               var132 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mcuFirmware");
               var127 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wifiFirmware");
               var133 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hardware");
               var131 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timeZone");
               var140 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "serial");
               var136 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "purchaseDate");
               var81 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dealerName");
               var124 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dealerCountry");
               var134 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterType");
               var126 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "filterTrigger");
               var139 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm1Ranges");
               var137 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm10Ranges");
               var125 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm25Ranges");
               var129 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "vocRanges");
               var128 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hchoRanges");
               var138 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "updateProgress");
               var114 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isStandByOn");
               var111 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isEcoModeOn");
               var112 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isHinsModeOn");
               var117 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isHinsNightModeOn");
               var123 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isG4NightModeOn");
               var119 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isGermShieldOn");
               var105 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isGermShieldNightModeOn");
               var115 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isSafetySwitchOn");
               var121 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "g4NightModefilterTrigger");
               var118 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "aimInstalled");
               var122 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "sku");
               var120 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "compatibility");
               var116 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "locationId");
               var113 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfection");
               var110 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfectLeftTime");
               var107 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "disinfectLeftTimeUpdateTime");
               var106 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryEnabled");
               var108 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryOn");
               var109 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryLeftTime");
               var103 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryLeftTimeUpdateTime");
               var104 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickUsage");
               var102 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterShortage");
               var101 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "autoRh");
               var100 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerStatus");
               var99 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerDuration");
               var98 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerLeftTime");
               var97 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timerLeftTimeUpdateTime");
               var96 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "temperatureUnit");
               var95 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationState");
               var94 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationAngle");
               var93 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationDirection");
               var92 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationFanSpeed");
               var91 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mainMode");
               var90 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "apSubMode");
               var89 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "apFanSpeed");
               var88 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatSubMode");
               var87 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatFanSpeed");
               var86 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatAutoTmp");
               var84 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "heatEcoTmp");
               var85 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolSubMode");
               var83 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolFanSpeed");
               var82 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoTag");
               var80 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoPresets");
               var79 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolEcoTag");
               var78 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolEcoPresets");
               var77 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "humMode");
               var76 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "mode");
               var75 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterLevel");
               var74 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "dehSubMode");
               var72 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterTankFailure");
               var73 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "smartSubMode");
               var71 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "detectCat");
               var70 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "bodyMounted");
               var69 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "cleanAirEta");
               var68 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "panelDisplayMode");
               var67 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hoverEnabled");
               var65 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshEnabled");
               var66 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshStatus");
               var64 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshDuration");
               var63 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshTimeStamp");
               var62 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshStartTimeStamp");
               var61 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "airRefreshEndTimeStamp");
               var60 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "roomType");
               var59 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightLampBrightness");
               var58 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryDuration");
               var57 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "wickdryDone");
               var55 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ywrmEnabled");
               var56 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ywrmUsage");
               var54 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightLampSteplessBrightness");
               var52 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "alarms");
               var53 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "humSubMode");
               var49 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "use24Hour");
               var50 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "waterInfill");
               var48 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "sensorMode");
               var47 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolFanSpeedLevel");
               var46 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "coolAutoLevel");
               var45 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightModeStartTime");
               var44 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "rpm1");
               var35 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "nightPeriods");
               var42 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "uuid");
               var33 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ssid");
               var26 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "bssid");
               var28 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ipv4");
               var41 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "ipv6");
               var25 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "timeInSeconds");
               var31 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm1");
               var36 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm10");
               var32 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "pm25");
               var27 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "voc");
               var34 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hcho");
               var29 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "tmp");
               var24 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "hum");
               var39 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "fan");
               var38 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "weight");
               var37 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "rpm");
               var40 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lat");
               var43 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "lng");
               var30 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "radius");
               var21 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "textValue");
               var23 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "isEnabled");
               var22 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "oscillationMode");
               var20 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationState");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationFixAngle");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationMinAngle");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalOscillationMaxAngle");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationState");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationFixAngle");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationMinAngle");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalOscillationMaxAngle");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "horizontalCalibrationState");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var231, "verticalCalibrationState");
               var155 = var231.step();
            } catch (Throwable var23190) {
               var10000 = var23190;
               boolean var23281 = false;
               break label197487;
            }

            var23193 = null;
            Object var229 = null;
            if (!var155) {
               break label197485;
            }

            label197473: {
               label197472: {
                  try {
                     if (var231.isNull(var152)) {
                        break label197472;
                     }
                  } catch (Throwable var23189) {
                     var10000 = var23189;
                     boolean var23282 = false;
                     break label197487;
                  }

                  try {
                     var0 = var231.getText(var152);
                     break label197473;
                  } catch (Throwable var23188) {
                     var10000 = var23188;
                     boolean var23283 = false;
                     break label197487;
                  }
               }

               var0 = null;
            }

            label197464: {
               label197463: {
                  try {
                     if (var231.isNull(var14)) {
                        break label197463;
                     }
                  } catch (Throwable var23187) {
                     var10000 = var23187;
                     boolean var23284 = false;
                     break label197487;
                  }

                  try {
                     var23196 = var231.getText(var14);
                     break label197464;
                  } catch (Throwable var23186) {
                     var10000 = var23186;
                     boolean var23285 = false;
                     break label197487;
                  }
               }

               var23196 = null;
            }

            String var190;
            label197455: {
               label197454: {
                  try {
                     if (var231.isNull(var153)) {
                        break label197454;
                     }
                  } catch (Throwable var23185) {
                     var10000 = var23185;
                     boolean var23286 = false;
                     break label197487;
                  }

                  try {
                     var190 = var231.getText(var153);
                     break label197455;
                  } catch (Throwable var23184) {
                     var10000 = var23184;
                     boolean var23287 = false;
                     break label197487;
                  }
               }

               var190 = null;
            }

            Integer var191;
            label197446: {
               label197445: {
                  try {
                     var14 = (int)var231.getLong(var154);
                     if (var231.isNull(var150)) {
                        break label197445;
                     }
                  } catch (Throwable var23183) {
                     var10000 = var23183;
                     boolean var23288 = false;
                     break label197487;
                  }

                  try {
                     var191 = (int)var231.getLong(var150);
                     break label197446;
                  } catch (Throwable var23182) {
                     var10000 = var23182;
                     boolean var23289 = false;
                     break label197487;
                  }
               }

               var191 = null;
            }

            Integer var192;
            label197437: {
               label197436: {
                  try {
                     if (var231.isNull(var142)) {
                        break label197436;
                     }
                  } catch (Throwable var23181) {
                     var10000 = var23181;
                     boolean var23290 = false;
                     break label197487;
                  }

                  try {
                     var192 = (int)var231.getLong(var142);
                     break label197437;
                  } catch (Throwable var23180) {
                     var10000 = var23180;
                     boolean var23291 = false;
                     break label197487;
                  }
               }

               var192 = null;
            }

            String var193;
            label197428: {
               label197427: {
                  try {
                     if (var231.isNull(var51)) {
                        break label197427;
                     }
                  } catch (Throwable var23179) {
                     var10000 = var23179;
                     boolean var23292 = false;
                     break label197487;
                  }

                  try {
                     var193 = var231.getText(var51);
                     break label197428;
                  } catch (Throwable var23178) {
                     var10000 = var23178;
                     boolean var23293 = false;
                     break label197487;
                  }
               }

               var193 = null;
            }

            Integer var194;
            label197419: {
               label197418: {
                  try {
                     if (var231.isNull(var148)) {
                        break label197418;
                     }
                  } catch (Throwable var23177) {
                     var10000 = var23177;
                     boolean var23294 = false;
                     break label197487;
                  }

                  try {
                     var194 = (int)var231.getLong(var148);
                     break label197419;
                  } catch (Throwable var23176) {
                     var10000 = var23176;
                     boolean var23295 = false;
                     break label197487;
                  }
               }

               var194 = null;
            }

            String var195;
            label197410: {
               label197409: {
                  try {
                     if (var231.isNull(var149)) {
                        break label197409;
                     }
                  } catch (Throwable var23175) {
                     var10000 = var23175;
                     boolean var23296 = false;
                     break label197487;
                  }

                  try {
                     var195 = var231.getText(var149);
                     break label197410;
                  } catch (Throwable var23174) {
                     var10000 = var23174;
                     boolean var23297 = false;
                     break label197487;
                  }
               }

               var195 = null;
            }

            label197401: {
               label197400: {
                  try {
                     if ((int)var231.getLong(var141) != 0) {
                        break label197400;
                     }
                  } catch (Throwable var23173) {
                     var10000 = var23173;
                     boolean var23298 = false;
                     break label197487;
                  }

                  var155 = false;
                  break label197401;
               }

               var155 = true;
            }

            Integer var196;
            label197393: {
               label197392: {
                  try {
                     if (var231.isNull(var145)) {
                        break label197392;
                     }
                  } catch (Throwable var23172) {
                     var10000 = var23172;
                     boolean var23299 = false;
                     break label197487;
                  }

                  try {
                     var196 = (int)var231.getLong(var145);
                     break label197393;
                  } catch (Throwable var23171) {
                     var10000 = var23171;
                     boolean var23300 = false;
                     break label197487;
                  }
               }

               var196 = null;
            }

            boolean var156;
            label197384: {
               label197383: {
                  try {
                     if ((int)var231.getLong(var146) != 0) {
                        break label197383;
                     }
                  } catch (Throwable var23170) {
                     var10000 = var23170;
                     boolean var23301 = false;
                     break label197487;
                  }

                  var156 = false;
                  break label197384;
               }

               var156 = true;
            }

            boolean var157;
            label197376: {
               label197375: {
                  try {
                     if ((int)var231.getLong(var143) != 0) {
                        break label197375;
                     }
                  } catch (Throwable var23169) {
                     var10000 = var23169;
                     boolean var23302 = false;
                     break label197487;
                  }

                  var157 = false;
                  break label197376;
               }

               var157 = true;
            }

            boolean var158;
            label197368: {
               label197367: {
                  try {
                     if ((int)var231.getLong(var151) != 0) {
                        break label197367;
                     }
                  } catch (Throwable var23168) {
                     var10000 = var23168;
                     boolean var23303 = false;
                     break label197487;
                  }

                  var158 = false;
                  break label197368;
               }

               var158 = true;
            }

            String var197;
            label197360: {
               label197359: {
                  try {
                     if (var231.isNull(var144)) {
                        break label197359;
                     }
                  } catch (Throwable var23167) {
                     var10000 = var23167;
                     boolean var23304 = false;
                     break label197487;
                  }

                  try {
                     var197 = var231.getText(var144);
                     break label197360;
                  } catch (Throwable var23166) {
                     var10000 = var23166;
                     boolean var23305 = false;
                     break label197487;
                  }
               }

               var197 = null;
            }

            long var182;
            String var198;
            label197351: {
               label197350: {
                  try {
                     var51 = (int)var231.getLong(var147);
                     var182 = var231.getLong(var130);
                     if (var231.isNull(var135)) {
                        break label197350;
                     }
                  } catch (Throwable var23165) {
                     var10000 = var23165;
                     boolean var23306 = false;
                     break label197487;
                  }

                  try {
                     var198 = var231.getText(var135);
                     break label197351;
                  } catch (Throwable var23164) {
                     var10000 = var23164;
                     boolean var23307 = false;
                     break label197487;
                  }
               }

               var198 = null;
            }

            String var199;
            label197342: {
               label197341: {
                  try {
                     if (var231.isNull(var132)) {
                        break label197341;
                     }
                  } catch (Throwable var23163) {
                     var10000 = var23163;
                     boolean var23308 = false;
                     break label197487;
                  }

                  try {
                     var199 = var231.getText(var132);
                     break label197342;
                  } catch (Throwable var23162) {
                     var10000 = var23162;
                     boolean var23309 = false;
                     break label197487;
                  }
               }

               var199 = null;
            }

            String var200;
            label197333: {
               label197332: {
                  try {
                     if (var231.isNull(var127)) {
                        break label197332;
                     }
                  } catch (Throwable var23161) {
                     var10000 = var23161;
                     boolean var23310 = false;
                     break label197487;
                  }

                  try {
                     var200 = var231.getText(var127);
                     break label197333;
                  } catch (Throwable var23160) {
                     var10000 = var23160;
                     boolean var23311 = false;
                     break label197487;
                  }
               }

               var200 = null;
            }

            String var201;
            label197324: {
               label197323: {
                  try {
                     if (var231.isNull(var133)) {
                        break label197323;
                     }
                  } catch (Throwable var23159) {
                     var10000 = var23159;
                     boolean var23312 = false;
                     break label197487;
                  }

                  try {
                     var201 = var231.getText(var133);
                     break label197324;
                  } catch (Throwable var23158) {
                     var10000 = var23158;
                     boolean var23313 = false;
                     break label197487;
                  }
               }

               var201 = null;
            }

            String var202;
            label197315: {
               label197314: {
                  try {
                     if (var231.isNull(var131)) {
                        break label197314;
                     }
                  } catch (Throwable var23157) {
                     var10000 = var23157;
                     boolean var23314 = false;
                     break label197487;
                  }

                  try {
                     var202 = var231.getText(var131);
                     break label197315;
                  } catch (Throwable var23156) {
                     var10000 = var23156;
                     boolean var23315 = false;
                     break label197487;
                  }
               }

               var202 = null;
            }

            String var203;
            label197306: {
               label197305: {
                  try {
                     if (var231.isNull(var140)) {
                        break label197305;
                     }
                  } catch (Throwable var23155) {
                     var10000 = var23155;
                     boolean var23316 = false;
                     break label197487;
                  }

                  try {
                     var203 = var231.getText(var140);
                     break label197306;
                  } catch (Throwable var23154) {
                     var10000 = var23154;
                     boolean var23317 = false;
                     break label197487;
                  }
               }

               var203 = null;
            }

            String var204;
            label197297: {
               label197296: {
                  try {
                     if (var231.isNull(var136)) {
                        break label197296;
                     }
                  } catch (Throwable var23153) {
                     var10000 = var23153;
                     boolean var23318 = false;
                     break label197487;
                  }

                  try {
                     var204 = var231.getText(var136);
                     break label197297;
                  } catch (Throwable var23152) {
                     var10000 = var23152;
                     boolean var23319 = false;
                     break label197487;
                  }
               }

               var204 = null;
            }

            String var205;
            label197288: {
               label197287: {
                  try {
                     if (var231.isNull(var81)) {
                        break label197287;
                     }
                  } catch (Throwable var23151) {
                     var10000 = var23151;
                     boolean var23320 = false;
                     break label197487;
                  }

                  try {
                     var205 = var231.getText(var81);
                     break label197288;
                  } catch (Throwable var23150) {
                     var10000 = var23150;
                     boolean var23321 = false;
                     break label197487;
                  }
               }

               var205 = null;
            }

            String var206;
            label197279: {
               label197278: {
                  try {
                     if (var231.isNull(var124)) {
                        break label197278;
                     }
                  } catch (Throwable var23149) {
                     var10000 = var23149;
                     boolean var23322 = false;
                     break label197487;
                  }

                  try {
                     var206 = var231.getText(var124);
                     break label197279;
                  } catch (Throwable var23148) {
                     var10000 = var23148;
                     boolean var23323 = false;
                     break label197487;
                  }
               }

               var206 = null;
            }

            String var207;
            label197270: {
               label197269: {
                  try {
                     if (var231.isNull(var134)) {
                        break label197269;
                     }
                  } catch (Throwable var23147) {
                     var10000 = var23147;
                     boolean var23324 = false;
                     break label197487;
                  }

                  try {
                     var207 = var231.getText(var134);
                     break label197270;
                  } catch (Throwable var23146) {
                     var10000 = var23146;
                     boolean var23325 = false;
                     break label197487;
                  }
               }

               var207 = null;
            }

            String var208;
            label197261: {
               label197260: {
                  try {
                     if (var231.isNull(var126)) {
                        break label197260;
                     }
                  } catch (Throwable var23145) {
                     var10000 = var23145;
                     boolean var23326 = false;
                     break label197487;
                  }

                  try {
                     var208 = var231.getText(var126);
                     break label197261;
                  } catch (Throwable var23144) {
                     var10000 = var23144;
                     boolean var23327 = false;
                     break label197487;
                  }
               }

               var208 = null;
            }

            String var209;
            label197252: {
               label197251: {
                  try {
                     if (var231.isNull(var139)) {
                        break label197251;
                     }
                  } catch (Throwable var23143) {
                     var10000 = var23143;
                     boolean var23328 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var139);
                     break label197252;
                  } catch (Throwable var23142) {
                     var10000 = var23142;
                     boolean var23329 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var232;
            label197243: {
               label197242: {
                  try {
                     var232 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var137)) {
                        break label197242;
                     }
                  } catch (Throwable var23141) {
                     var10000 = var23141;
                     boolean var23330 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var137);
                     break label197243;
                  } catch (Throwable var23140) {
                     var10000 = var23140;
                     boolean var23331 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var233;
            label197234: {
               label197233: {
                  try {
                     var233 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var125)) {
                        break label197233;
                     }
                  } catch (Throwable var23139) {
                     var10000 = var23139;
                     boolean var23332 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var125);
                     break label197234;
                  } catch (Throwable var23138) {
                     var10000 = var23138;
                     boolean var23333 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var234;
            label197225: {
               label197224: {
                  try {
                     var234 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var129)) {
                        break label197224;
                     }
                  } catch (Throwable var23137) {
                     var10000 = var23137;
                     boolean var23334 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var129);
                     break label197225;
                  } catch (Throwable var23136) {
                     var10000 = var23136;
                     boolean var23335 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            double[] var235;
            label197216: {
               label197215: {
                  try {
                     var235 = DoubleArrayConverter.fromString(var209);
                     if (var231.isNull(var128)) {
                        break label197215;
                     }
                  } catch (Throwable var23135) {
                     var10000 = var23135;
                     boolean var23336 = false;
                     break label197487;
                  }

                  try {
                     var209 = var231.getText(var128);
                     break label197216;
                  } catch (Throwable var23134) {
                     var10000 = var23134;
                     boolean var23337 = false;
                     break label197487;
                  }
               }

               var209 = null;
            }

            boolean var159;
            double[] var236;
            label197207: {
               label197206: {
                  try {
                     var236 = DoubleArrayConverter.fromString(var209);
                     var81 = (int)var231.getLong(var138);
                     if ((int)var231.getLong(var114) != 0) {
                        break label197206;
                     }
                  } catch (Throwable var23133) {
                     var10000 = var23133;
                     boolean var23338 = false;
                     break label197487;
                  }

                  var159 = false;
                  break label197207;
               }

               var159 = true;
            }

            boolean var160;
            label197199: {
               label197198: {
                  try {
                     if ((int)var231.getLong(var111) != 0) {
                        break label197198;
                     }
                  } catch (Throwable var23132) {
                     var10000 = var23132;
                     boolean var23339 = false;
                     break label197487;
                  }

                  var160 = false;
                  break label197199;
               }

               var160 = true;
            }

            boolean var161;
            label197191: {
               label197190: {
                  try {
                     if ((int)var231.getLong(var112) != 0) {
                        break label197190;
                     }
                  } catch (Throwable var23131) {
                     var10000 = var23131;
                     boolean var23340 = false;
                     break label197487;
                  }

                  var161 = false;
                  break label197191;
               }

               var161 = true;
            }

            boolean var162;
            label197183: {
               label197182: {
                  try {
                     if ((int)var231.getLong(var117) != 0) {
                        break label197182;
                     }
                  } catch (Throwable var23130) {
                     var10000 = var23130;
                     boolean var23341 = false;
                     break label197487;
                  }

                  var162 = false;
                  break label197183;
               }

               var162 = true;
            }

            boolean var163;
            label197175: {
               label197174: {
                  try {
                     if ((int)var231.getLong(var123) != 0) {
                        break label197174;
                     }
                  } catch (Throwable var23129) {
                     var10000 = var23129;
                     boolean var23342 = false;
                     break label197487;
                  }

                  var163 = false;
                  break label197175;
               }

               var163 = true;
            }

            boolean var164;
            label197167: {
               label197166: {
                  try {
                     if ((int)var231.getLong(var119) != 0) {
                        break label197166;
                     }
                  } catch (Throwable var23128) {
                     var10000 = var23128;
                     boolean var23343 = false;
                     break label197487;
                  }

                  var164 = false;
                  break label197167;
               }

               var164 = true;
            }

            label197159: {
               label197158: {
                  try {
                     if (var231.isNull(var105)) {
                        break label197158;
                     }
                  } catch (Throwable var23127) {
                     var10000 = var23127;
                     boolean var23344 = false;
                     break label197487;
                  }

                  try {
                     var23261 = (int)var231.getLong(var105);
                     break label197159;
                  } catch (Throwable var23126) {
                     var10000 = var23126;
                     boolean var23345 = false;
                     break label197487;
                  }
               }

               var23261 = null;
            }

            Boolean var23262;
            if (var23261 == null) {
               var23262 = null;
            } else {
               boolean var165;
               label197148: {
                  label197147: {
                     try {
                        if (var23261 != 0) {
                           break label197147;
                        }
                     } catch (Throwable var23125) {
                        var10000 = var23125;
                        boolean var23346 = false;
                        break label197487;
                     }

                     var165 = false;
                     break label197148;
                  }

                  var165 = true;
               }

               try {
                  var23262 = var165;
               } catch (Throwable var23124) {
                  var10000 = var23124;
                  boolean var23347 = false;
                  break label197487;
               }
            }

            boolean var23254;
            label197139: {
               label197138: {
                  try {
                     if ((int)var231.getLong(var115) != 0) {
                        break label197138;
                     }
                  } catch (Throwable var23123) {
                     var10000 = var23123;
                     boolean var23348 = false;
                     break label197487;
                  }

                  var23254 = false;
                  break label197139;
               }

               var23254 = true;
            }

            String var210;
            label197131: {
               label197130: {
                  try {
                     if (var231.isNull(var121)) {
                        break label197130;
                     }
                  } catch (Throwable var23122) {
                     var10000 = var23122;
                     boolean var23349 = false;
                     break label197487;
                  }

                  try {
                     var210 = var231.getText(var121);
                     break label197131;
                  } catch (Throwable var23121) {
                     var10000 = var23121;
                     boolean var23350 = false;
                     break label197487;
                  }
               }

               var210 = null;
            }

            boolean var166;
            label197122: {
               label197121: {
                  try {
                     if ((int)var231.getLong(var118) != 0) {
                        break label197121;
                     }
                  } catch (Throwable var23120) {
                     var10000 = var23120;
                     boolean var23351 = false;
                     break label197487;
                  }

                  var166 = false;
                  break label197122;
               }

               var166 = true;
            }

            String var211;
            label197114: {
               label197113: {
                  try {
                     if (var231.isNull(var122)) {
                        break label197113;
                     }
                  } catch (Throwable var23119) {
                     var10000 = var23119;
                     boolean var23352 = false;
                     break label197487;
                  }

                  try {
                     var211 = var231.getText(var122);
                     break label197114;
                  } catch (Throwable var23118) {
                     var10000 = var23118;
                     boolean var23353 = false;
                     break label197487;
                  }
               }

               var211 = null;
            }

            String var212;
            label197105: {
               label197104: {
                  try {
                     if (var231.isNull(var120)) {
                        break label197104;
                     }
                  } catch (Throwable var23117) {
                     var10000 = var23117;
                     boolean var23354 = false;
                     break label197487;
                  }

                  try {
                     var212 = var231.getText(var120);
                     break label197105;
                  } catch (Throwable var23116) {
                     var10000 = var23116;
                     boolean var23355 = false;
                     break label197487;
                  }
               }

               var212 = null;
            }

            String var213;
            label197096: {
               label197095: {
                  try {
                     if (var231.isNull(var116)) {
                        break label197095;
                     }
                  } catch (Throwable var23115) {
                     var10000 = var23115;
                     boolean var23356 = false;
                     break label197487;
                  }

                  try {
                     var213 = var231.getText(var116);
                     break label197096;
                  } catch (Throwable var23114) {
                     var10000 = var23114;
                     boolean var23357 = false;
                     break label197487;
                  }
               }

               var213 = null;
            }

            Integer var214;
            label197087: {
               label197086: {
                  try {
                     if (var231.isNull(var113)) {
                        break label197086;
                     }
                  } catch (Throwable var23113) {
                     var10000 = var23113;
                     boolean var23358 = false;
                     break label197487;
                  }

                  try {
                     var214 = (int)var231.getLong(var113);
                     break label197087;
                  } catch (Throwable var23112) {
                     var10000 = var23112;
                     boolean var23359 = false;
                     break label197487;
                  }
               }

               var214 = null;
            }

            Boolean var23263;
            if (var214 == null) {
               var23263 = null;
            } else {
               boolean var167;
               label197076: {
                  label197075: {
                     try {
                        if (var214 != 0) {
                           break label197075;
                        }
                     } catch (Throwable var23111) {
                        var10000 = var23111;
                        boolean var23360 = false;
                        break label197487;
                     }

                     var167 = false;
                     break label197076;
                  }

                  var167 = true;
               }

               try {
                  var23263 = var167;
               } catch (Throwable var23110) {
                  var10000 = var23110;
                  boolean var23361 = false;
                  break label197487;
               }
            }

            Integer var215;
            label197067: {
               label197066: {
                  try {
                     if (var231.isNull(var110)) {
                        break label197066;
                     }
                  } catch (Throwable var23109) {
                     var10000 = var23109;
                     boolean var23362 = false;
                     break label197487;
                  }

                  try {
                     var215 = (int)var231.getLong(var110);
                     break label197067;
                  } catch (Throwable var23108) {
                     var10000 = var23108;
                     boolean var23363 = false;
                     break label197487;
                  }
               }

               var215 = null;
            }

            Long var216;
            label197058: {
               label197057: {
                  try {
                     if (var231.isNull(var107)) {
                        break label197057;
                     }
                  } catch (Throwable var23107) {
                     var10000 = var23107;
                     boolean var23364 = false;
                     break label197487;
                  }

                  try {
                     var216 = var231.getLong(var107);
                     break label197058;
                  } catch (Throwable var23106) {
                     var10000 = var23106;
                     boolean var23365 = false;
                     break label197487;
                  }
               }

               var216 = null;
            }

            boolean var23255;
            label197049: {
               label197048: {
                  try {
                     if ((int)var231.getLong(var106) != 0) {
                        break label197048;
                     }
                  } catch (Throwable var23105) {
                     var10000 = var23105;
                     boolean var23366 = false;
                     break label197487;
                  }

                  var23255 = false;
                  break label197049;
               }

               var23255 = true;
            }

            boolean var168;
            label197041: {
               label197040: {
                  try {
                     if ((int)var231.getLong(var108) != 0) {
                        break label197040;
                     }
                  } catch (Throwable var23104) {
                     var10000 = var23104;
                     boolean var23367 = false;
                     break label197487;
                  }

                  var168 = false;
                  break label197041;
               }

               var168 = true;
            }

            boolean var169;
            long var188;
            label197033: {
               label197032: {
                  try {
                     var105 = (int)var231.getLong(var109);
                     var188 = var231.getLong(var103);
                     var103 = (int)var231.getLong(var104);
                     if ((int)var231.getLong(var102) != 0) {
                        break label197032;
                     }
                  } catch (Throwable var23103) {
                     var10000 = var23103;
                     boolean var23368 = false;
                     break label197487;
                  }

                  var169 = false;
                  break label197033;
               }

               var169 = true;
            }

            double var2;
            double var4;
            long var180;
            String var217;
            label197025: {
               label197024: {
                  try {
                     var101 = (int)var231.getLong(var101);
                     var100 = (int)var231.getLong(var100);
                     var99 = (int)var231.getLong(var99);
                     var98 = (int)var231.getLong(var98);
                     var180 = var231.getLong(var97);
                     var96 = (int)var231.getLong(var96);
                     var95 = (int)var231.getLong(var95);
                     var94 = (int)var231.getLong(var94);
                     var93 = (int)var231.getLong(var93);
                     var92 = (int)var231.getLong(var92);
                     var91 = (int)var231.getLong(var91);
                     var90 = (int)var231.getLong(var90);
                     var89 = (int)var231.getLong(var89);
                     var88 = (int)var231.getLong(var88);
                     var87 = (int)var231.getLong(var87);
                     var4 = var231.getDouble(var86);
                     var2 = var231.getDouble(var84);
                     var84 = (int)var231.getLong(var85);
                     var83 = (int)var231.getLong(var83);
                     var82 = (int)var231.getLong(var82);
                     if (var231.isNull(var80)) {
                        break label197024;
                     }
                  } catch (Throwable var23102) {
                     var10000 = var23102;
                     boolean var23369 = false;
                     break label197487;
                  }

                  try {
                     var217 = var231.getText(var80);
                     break label197025;
                  } catch (Throwable var23101) {
                     var10000 = var23101;
                     boolean var23370 = false;
                     break label197487;
                  }
               }

               var217 = null;
            }

            double[] var237;
            label197016: {
               label197015: {
                  try {
                     var237 = DoubleArrayConverter.fromString(var217);
                     var79 = (int)var231.getLong(var79);
                     if (var231.isNull(var78)) {
                        break label197015;
                     }
                  } catch (Throwable var23100) {
                     var10000 = var23100;
                     boolean var23371 = false;
                     break label197487;
                  }

                  try {
                     var217 = var231.getText(var78);
                     break label197016;
                  } catch (Throwable var23099) {
                     var10000 = var23099;
                     boolean var23372 = false;
                     break label197487;
                  }
               }

               var217 = null;
            }

            boolean var170;
            double[] var238;
            label197007: {
               label197006: {
                  try {
                     var238 = DoubleArrayConverter.fromString(var217);
                     if ((int)var231.getLong(var77) != 0) {
                        break label197006;
                     }
                  } catch (Throwable var23098) {
                     var10000 = var23098;
                     boolean var23373 = false;
                     break label197487;
                  }

                  var170 = false;
                  break label197007;
               }

               var170 = true;
            }

            boolean var171;
            label196999: {
               label196998: {
                  try {
                     var76 = (int)var231.getLong(var76);
                     var75 = (int)var231.getLong(var75);
                     var74 = (int)var231.getLong(var74);
                     if ((int)var231.getLong(var72) != 0) {
                        break label196998;
                     }
                  } catch (Throwable var23097) {
                     var10000 = var23097;
                     boolean var23374 = false;
                     break label197487;
                  }

                  var171 = false;
                  break label196999;
               }

               var171 = true;
            }

            boolean var172;
            label196991: {
               label196990: {
                  try {
                     var72 = (int)var231.getLong(var73);
                     if ((int)var231.getLong(var71) != 0) {
                        break label196990;
                     }
                  } catch (Throwable var23096) {
                     var10000 = var23096;
                     boolean var23375 = false;
                     break label197487;
                  }

                  var172 = false;
                  break label196991;
               }

               var172 = true;
            }

            boolean var173;
            label196983: {
               label196982: {
                  try {
                     if ((int)var231.getLong(var70) != 0) {
                        break label196982;
                     }
                  } catch (Throwable var23095) {
                     var10000 = var23095;
                     boolean var23376 = false;
                     break label197487;
                  }

                  var173 = false;
                  break label196983;
               }

               var173 = true;
            }

            boolean var174;
            label196975: {
               label196974: {
                  try {
                     var69 = (int)var231.getLong(var69);
                     var68 = (int)var231.getLong(var68);
                     if ((int)var231.getLong(var67) != 0) {
                        break label196974;
                     }
                  } catch (Throwable var23094) {
                     var10000 = var23094;
                     boolean var23377 = false;
                     break label197487;
                  }

                  var174 = false;
                  break label196975;
               }

               var174 = true;
            }

            boolean var175;
            label196967: {
               label196966: {
                  try {
                     if ((int)var231.getLong(var65) != 0) {
                        break label196966;
                     }
                  } catch (Throwable var23093) {
                     var10000 = var23093;
                     boolean var23378 = false;
                     break label197487;
                  }

                  var175 = false;
                  break label196967;
               }

               var175 = true;
            }

            boolean var176;
            label196959: {
               label196958: {
                  try {
                     var65 = (int)var231.getLong(var66);
                     var64 = (int)var231.getLong(var64);
                     var63 = (int)var231.getLong(var63);
                     var62 = (int)var231.getLong(var62);
                     var61 = (int)var231.getLong(var61);
                     var60 = (int)var231.getLong(var60);
                     var59 = (int)var231.getLong(var59);
                     var58 = (int)var231.getLong(var58);
                     if ((int)var231.getLong(var57) != 0) {
                        break label196958;
                     }
                  } catch (Throwable var23092) {
                     var10000 = var23092;
                     boolean var23379 = false;
                     break label197487;
                  }

                  var176 = false;
                  break label196959;
               }

               var176 = true;
            }

            label196951: {
               label196950: {
                  try {
                     if (var231.isNull(var55)) {
                        break label196950;
                     }
                  } catch (Throwable var23091) {
                     var10000 = var23091;
                     boolean var23380 = false;
                     break label197487;
                  }

                  try {
                     var23265 = (int)var231.getLong(var55);
                     break label196951;
                  } catch (Throwable var23090) {
                     var10000 = var23090;
                     boolean var23381 = false;
                     break label197487;
                  }
               }

               var23265 = null;
            }

            Boolean var23266;
            if (var23265 == null) {
               var23266 = null;
            } else {
               boolean var177;
               label196940: {
                  label196939: {
                     try {
                        if (var23265 != 0) {
                           break label196939;
                        }
                     } catch (Throwable var23089) {
                        var10000 = var23089;
                        boolean var23382 = false;
                        break label197487;
                     }

                     var177 = false;
                     break label196940;
                  }

                  var177 = true;
               }

               try {
                  var23266 = var177;
               } catch (Throwable var23088) {
                  var10000 = var23088;
                  boolean var23383 = false;
                  break label197487;
               }
            }

            String var218;
            label196931: {
               label196930: {
                  try {
                     var55 = (int)var231.getLong(var56);
                     var54 = (int)var231.getLong(var54);
                     if (var231.isNull(var52)) {
                        break label196930;
                     }
                  } catch (Throwable var23087) {
                     var10000 = var23087;
                     boolean var23384 = false;
                     break label197487;
                  }

                  try {
                     var218 = var231.getText(var52);
                     break label196931;
                  } catch (Throwable var23086) {
                     var10000 = var23086;
                     boolean var23385 = false;
                     break label197487;
                  }
               }

               var218 = null;
            }

            List var239;
            boolean var23256;
            label196922: {
               label196921: {
                  try {
                     var239 = DeviceAlarmListConverter.fromString(var218);
                     var52 = (int)var231.getLong(var53);
                     if ((int)var231.getLong(var49) != 0) {
                        break label196921;
                     }
                  } catch (Throwable var23085) {
                     var10000 = var23085;
                     boolean var23386 = false;
                     break label197487;
                  }

                  var23256 = false;
                  break label196922;
               }

               var23256 = true;
            }

            boolean var178;
            label196914: {
               label196913: {
                  try {
                     if ((int)var231.getLong(var50) != 0) {
                        break label196913;
                     }
                  } catch (Throwable var23084) {
                     var10000 = var23084;
                     boolean var23387 = false;
                     break label197487;
                  }

                  var178 = false;
                  break label196914;
               }

               var178 = true;
            }

            long var186;
            label196906: {
               label196905: {
                  try {
                     var48 = (int)var231.getLong(var48);
                     var47 = (int)var231.getLong(var47);
                     var46 = (int)var231.getLong(var46);
                     var186 = var231.getLong(var45);
                     var44 = (int)var231.getLong(var44);
                     if (var231.isNull(var35)) {
                        break label196905;
                     }
                  } catch (Throwable var23083) {
                     var10000 = var23083;
                     boolean var23388 = false;
                     break label197487;
                  }

                  try {
                     var218 = var231.getText(var35);
                     break label196906;
                  } catch (Throwable var23082) {
                     var10000 = var23082;
                     boolean var23389 = false;
                     break label197487;
                  }
               }

               var218 = null;
            }

            double[] var240;
            label196897: {
               label197494: {
                  try {
                     var240 = DoubleArrayConverter.fromString(var218);
                     if (var231.isNull(var42) && var231.isNull(var33) && var231.isNull(var26) && var231.isNull(var28) && var231.isNull(var41)) {
                        break label197494;
                     }
                  } catch (Throwable var23081) {
                     var10000 = var23081;
                     boolean var23390 = false;
                     break label197487;
                  }

                  label196873: {
                     label196872: {
                        try {
                           if (var231.isNull(var42)) {
                              break label196872;
                           }
                        } catch (Throwable var23080) {
                           var10000 = var23080;
                           boolean var23391 = false;
                           break label197487;
                        }

                        try {
                           var218 = var231.getText(var42);
                           break label196873;
                        } catch (Throwable var23075) {
                           var10000 = var23075;
                           boolean var23392 = false;
                           break label197487;
                        }
                     }

                     var218 = null;
                  }

                  String var219;
                  label196866: {
                     label196865: {
                        try {
                           if (var231.isNull(var33)) {
                              break label196865;
                           }
                        } catch (Throwable var23079) {
                           var10000 = var23079;
                           boolean var23393 = false;
                           break label197487;
                        }

                        try {
                           var219 = var231.getText(var33);
                           break label196866;
                        } catch (Throwable var23074) {
                           var10000 = var23074;
                           boolean var23394 = false;
                           break label197487;
                        }
                     }

                     var219 = null;
                  }

                  String var220;
                  label196859: {
                     label196858: {
                        try {
                           if (var231.isNull(var26)) {
                              break label196858;
                           }
                        } catch (Throwable var23078) {
                           var10000 = var23078;
                           boolean var23395 = false;
                           break label197487;
                        }

                        try {
                           var220 = var231.getText(var26);
                           break label196859;
                        } catch (Throwable var23073) {
                           var10000 = var23073;
                           boolean var23396 = false;
                           break label197487;
                        }
                     }

                     var220 = null;
                  }

                  String var221;
                  label196852: {
                     label196851: {
                        try {
                           if (var231.isNull(var28)) {
                              break label196851;
                           }
                        } catch (Throwable var23077) {
                           var10000 = var23077;
                           boolean var23397 = false;
                           break label197487;
                        }

                        try {
                           var221 = var231.getText(var28);
                           break label196852;
                        } catch (Throwable var23072) {
                           var10000 = var23072;
                           boolean var23398 = false;
                           break label197487;
                        }
                     }

                     var221 = null;
                  }

                  String var222;
                  label196845: {
                     label196844: {
                        try {
                           if (var231.isNull(var41)) {
                              break label196844;
                           }
                        } catch (Throwable var23076) {
                           var10000 = var23076;
                           boolean var23399 = false;
                           break label197487;
                        }

                        try {
                           var222 = var231.getText(var41);
                           break label196845;
                        } catch (Throwable var23071) {
                           var10000 = var23071;
                           boolean var23400 = false;
                           break label197487;
                        }
                     }

                     var222 = null;
                  }

                  DeviceUuidEntity var223;
                  try {
                     var223 = new DeviceUuidEntity(var218, var219, var220, var221, var222);
                  } catch (Throwable var23070) {
                     var10000 = var23070;
                     boolean var23401 = false;
                     break label197487;
                  }

                  var23269 = var223;
                  break label196897;
               }

               var23269 = null;
            }

            IndoorDatapoint var23271;
            label196830: {
               label197495: {
                  try {
                     if (var231.isNull(var25) && var231.isNull(var31) && var231.isNull(var36) && var231.isNull(var32) && var231.isNull(var27) && var231.isNull(var34) && var231.isNull(var29) && var231.isNull(var24) && var231.isNull(var39) && var231.isNull(var38) && var231.isNull(var37)) {
                        break label197495;
                     }
                  } catch (Throwable var23069) {
                     var10000 = var23069;
                     boolean var23402 = false;
                     break label197487;
                  }

                  long var184;
                  label196782: {
                     label196781: {
                        try {
                           var184 = var231.getLong(var25);
                           if (var231.isNull(var31)) {
                              break label196781;
                           }
                        } catch (Throwable var23068) {
                           var10000 = var23068;
                           boolean var23403 = false;
                           break label197487;
                        }

                        try {
                           var23270 = (float)var231.getDouble(var31);
                           break label196782;
                        } catch (Throwable var23058) {
                           var10000 = var23058;
                           boolean var23404 = false;
                           break label197487;
                        }
                     }

                     var23270 = null;
                  }

                  Float var23272;
                  label196775: {
                     label196774: {
                        try {
                           if (var231.isNull(var36)) {
                              break label196774;
                           }
                        } catch (Throwable var23067) {
                           var10000 = var23067;
                           boolean var23405 = false;
                           break label197487;
                        }

                        try {
                           var23272 = (float)var231.getDouble(var36);
                           break label196775;
                        } catch (Throwable var23057) {
                           var10000 = var23057;
                           boolean var23406 = false;
                           break label197487;
                        }
                     }

                     var23272 = null;
                  }

                  Float var23275;
                  label196768: {
                     label196767: {
                        try {
                           if (var231.isNull(var32)) {
                              break label196767;
                           }
                        } catch (Throwable var23066) {
                           var10000 = var23066;
                           boolean var23407 = false;
                           break label197487;
                        }

                        try {
                           var23275 = (float)var231.getDouble(var32);
                           break label196768;
                        } catch (Throwable var23056) {
                           var10000 = var23056;
                           boolean var23408 = false;
                           break label197487;
                        }
                     }

                     var23275 = null;
                  }

                  Float var23278;
                  label196761: {
                     label196760: {
                        try {
                           if (var231.isNull(var27)) {
                              break label196760;
                           }
                        } catch (Throwable var23065) {
                           var10000 = var23065;
                           boolean var23409 = false;
                           break label197487;
                        }

                        try {
                           var23278 = (float)var231.getDouble(var27);
                           break label196761;
                        } catch (Throwable var23055) {
                           var10000 = var23055;
                           boolean var23410 = false;
                           break label197487;
                        }
                     }

                     var23278 = null;
                  }

                  Float var23279;
                  label196754: {
                     label196753: {
                        try {
                           if (var231.isNull(var34)) {
                              break label196753;
                           }
                        } catch (Throwable var23064) {
                           var10000 = var23064;
                           boolean var23411 = false;
                           break label197487;
                        }

                        try {
                           var23279 = (float)var231.getDouble(var34);
                           break label196754;
                        } catch (Throwable var23054) {
                           var10000 = var23054;
                           boolean var23412 = false;
                           break label197487;
                        }
                     }

                     var23279 = null;
                  }

                  Float var224;
                  label196747: {
                     label196746: {
                        try {
                           if (var231.isNull(var29)) {
                              break label196746;
                           }
                        } catch (Throwable var23063) {
                           var10000 = var23063;
                           boolean var23413 = false;
                           break label197487;
                        }

                        try {
                           var224 = (float)var231.getDouble(var29);
                           break label196747;
                        } catch (Throwable var23053) {
                           var10000 = var23053;
                           boolean var23414 = false;
                           break label197487;
                        }
                     }

                     var224 = null;
                  }

                  Float var225;
                  label196740: {
                     label196739: {
                        try {
                           if (var231.isNull(var24)) {
                              break label196739;
                           }
                        } catch (Throwable var23062) {
                           var10000 = var23062;
                           boolean var23415 = false;
                           break label197487;
                        }

                        try {
                           var225 = (float)var231.getDouble(var24);
                           break label196740;
                        } catch (Throwable var23052) {
                           var10000 = var23052;
                           boolean var23416 = false;
                           break label197487;
                        }
                     }

                     var225 = null;
                  }

                  Float var226;
                  label196733: {
                     label196732: {
                        try {
                           if (var231.isNull(var39)) {
                              break label196732;
                           }
                        } catch (Throwable var23061) {
                           var10000 = var23061;
                           boolean var23417 = false;
                           break label197487;
                        }

                        try {
                           var226 = (float)var231.getDouble(var39);
                           break label196733;
                        } catch (Throwable var23051) {
                           var10000 = var23051;
                           boolean var23418 = false;
                           break label197487;
                        }
                     }

                     var226 = null;
                  }

                  Float var227;
                  label196726: {
                     label196725: {
                        try {
                           if (var231.isNull(var38)) {
                              break label196725;
                           }
                        } catch (Throwable var23060) {
                           var10000 = var23060;
                           boolean var23419 = false;
                           break label197487;
                        }

                        try {
                           var227 = (float)var231.getDouble(var38);
                           break label196726;
                        } catch (Throwable var23050) {
                           var10000 = var23050;
                           boolean var23420 = false;
                           break label197487;
                        }
                     }

                     var227 = null;
                  }

                  Float var228;
                  label196719: {
                     label196718: {
                        try {
                           if (var231.isNull(var37)) {
                              break label196718;
                           }
                        } catch (Throwable var23059) {
                           var10000 = var23059;
                           boolean var23421 = false;
                           break label197487;
                        }

                        try {
                           var228 = (float)var231.getDouble(var37);
                           break label196719;
                        } catch (Throwable var23049) {
                           var10000 = var23049;
                           boolean var23422 = false;
                           break label197487;
                        }
                     }

                     var228 = null;
                  }

                  IndoorDatapoint var230;
                  try {
                     var230 = new IndoorDatapoint(var184, var23270, var23272, var23275, var23278, var23279, var224, var225, var226, var227, var228);
                  } catch (Throwable var23048) {
                     var10000 = var23048;
                     boolean var23423 = false;
                     break label197487;
                  }

                  var23271 = var230;
                  break label196830;
               }

               var23271 = null;
            }

            WelcomeHomeLocation var23274;
            label196699: {
               label197496: {
                  try {
                     if (var231.isNull(var40) && var231.isNull(var43) && var231.isNull(var30) && var231.isNull(var21) && var231.isNull(var23)) {
                        break label197496;
                     }
                  } catch (Throwable var23047) {
                     var10000 = var23047;
                     boolean var23424 = false;
                     break label197487;
                  }

                  double var6;
                  double var8;
                  label196682: {
                     label196681: {
                        try {
                           var6 = var231.getDouble(var40);
                           var8 = var231.getDouble(var43);
                           var24 = (int)var231.getLong(var30);
                           if (var231.isNull(var21)) {
                              break label196681;
                           }
                        } catch (Throwable var23046) {
                           var10000 = var23046;
                           boolean var23425 = false;
                           break label197487;
                        }

                        try {
                           var23273 = var231.getText(var21);
                           break label196682;
                        } catch (Throwable var23044) {
                           var10000 = var23044;
                           boolean var23426 = false;
                           break label197487;
                        }
                     }

                     var23273 = (String)var229;
                  }

                  boolean var179;
                  label196675: {
                     label196674: {
                        try {
                           if ((int)var231.getLong(var23) != 0) {
                              break label196674;
                           }
                        } catch (Throwable var23045) {
                           var10000 = var23045;
                           boolean var23427 = false;
                           break label197487;
                        }

                        var179 = false;
                        break label196675;
                     }

                     var179 = true;
                  }

                  WelcomeHomeLocation var23276;
                  try {
                     var23276 = new WelcomeHomeLocation(var6, var8, var24, var23273, var179);
                  } catch (Throwable var23043) {
                     var10000 = var23043;
                     boolean var23428 = false;
                     break label197487;
                  }

                  var23274 = var23276;
                  break label196699;
               }

               var23274 = null;
            }

            label196665:
            try {
               var21 = (int)var231.getLong(var22);
               var20 = (int)var231.getLong(var20);
               var19 = (int)var231.getLong(var19);
               var18 = (int)var231.getLong(var18);
               var17 = (int)var231.getLong(var17);
               var16 = (int)var231.getLong(var16);
               var15 = (int)var231.getLong(var15);
               var13 = (int)var231.getLong(var13);
               var12 = (int)var231.getLong(var12);
               var11 = (int)var231.getLong(var11);
               var10 = (int)var231.getLong(var10);
               DualOscillationConfig var23277 = new DualOscillationConfig(var21, var20, var19, var18, var17, var16, var15, var13, var12, var11, var10);
               var23193 = new DeviceEntity(var0, var23196, var190, var14, var191, var192, var193, var194, var195, var23269, var155, var23271, var196, var156, var157, var158, var197, var51, var182, var198, var199, var200, var201, var202, var203, var204, var205, var206, var207, var208, var232, var233, var234, var235, var236, var81, var159, var160, var161, var162, var163, var164, var23262, var23254, var210, var166, var211, var212, var23274, var213, var23263, var215, var216, var23255, var168, var105, var188, var103, var169, var101, var100, var99, var98, var180, var96, var95, var94, var93, var92, var91, var90, var89, var88, var87, var4, var2, var84, var83, var82, var237, var79, var238, var170, var76, var75, var74, var171, var72, var172, var173, var69, var68, var174, var175, var65, var64, var63, var62, var61, var60, var59, var58, var176, var23266, var55, var54, var239, var52, var23256, var178, var48, var47, var46, var186, var23277, var44, var240);
               break label197485;
            } catch (Throwable var23042) {
               var10000 = var23042;
               boolean var23429 = false;
               break label196665;
            }
         }

         Throwable var23195 = var10000;
         var231.close();
         throw var23195;
      }

      var231.close();
      return var23193;
   }

   // $FF: synthetic method
   static Integer lambda$updatWaterInfill$102(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET waterInfill = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAirRefreshDuration$88(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET airRefreshDuration = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAirRefreshEnabled$86(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET airRefreshEnabled = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAirRefreshEndTimeStamp$91(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET airRefreshEndTimeStamp = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAirRefreshStartTimeStamp$90(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET airRefreshStartTimeStamp = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAirRefreshStatus$87(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET airRefreshStatus = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAirRefreshTimeStamp$89(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET airRefreshTimeStamp = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAlarms$99(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET alarms = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateApFanSpeed$62(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET apFanSpeed = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateApSubMode$61(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET apSubMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateAutoMode$15(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET autoModeText = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateAutoRh$51(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET autoRh = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateBodyMounted$82(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET bodyMounted = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateBrightness$16(Integer var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET brightness = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateChildLock$17(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isChildLockOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCleanAirEta$83(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET cleanAirEta = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCompatibility$23(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET compatibility = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateConnectivityStatus$19(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET connectivityStatusIndex = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolAutoLevel$104(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET coolAutoLevel = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolAutoPresets$70(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET coolAutoPresets = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolAutoTag$69(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET coolAutoTag = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolEcoPresets$72(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET coolEcoPresets = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolEcoTag$71(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET coolEcoTag = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolFanSpeed$68(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET coolFanSpeed = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolFanSpeedLevel$105(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET coolFanSpeedLevel = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateCoolSubMode$67(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET coolSubMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateDehSubMode$78(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET dehSubMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateDetectCat$81(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET detectCat = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateDeviceType$42(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET typeIndex = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateDisinfectLeftTime$45(Integer var0, Long var1, String var2, SQLiteConnection var3) {
      int var4;
      SQLiteStatement var5;
      label368: {
         Throwable var10000;
         label370: {
            var5 = var3.prepare("UPDATE device_table SET disinfectLeftTime = ?, disinfectLeftTimeUpdateTime = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var5.bindNull(1);
               } catch (Throwable var61) {
                  var10000 = var61;
                  boolean var10001 = false;
                  break label370;
               }
            } else {
               try {
                  var5.bindLong(1, (long)var0);
               } catch (Throwable var60) {
                  var10000 = var60;
                  boolean var63 = false;
                  break label370;
               }
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var59) {
                  var10000 = var59;
                  boolean var64 = false;
                  break label370;
               }
            } else {
               try {
                  var5.bindLong(2, var1);
               } catch (Throwable var58) {
                  var10000 = var58;
                  boolean var65 = false;
                  break label370;
               }
            }

            if (var2 == null) {
               try {
                  var5.bindNull(3);
               } catch (Throwable var57) {
                  var10000 = var57;
                  boolean var66 = false;
                  break label370;
               }
            } else {
               try {
                  var5.bindText(3, var2);
               } catch (Throwable var56) {
                  var10000 = var56;
                  boolean var67 = false;
                  break label370;
               }
            }

            label351:
            try {
               var5.step();
               var4 = SQLiteConnectionUtil.getTotalChangedRows(var3);
               break label368;
            } catch (Throwable var55) {
               var10000 = var55;
               boolean var68 = false;
               break label351;
            }
         }

         Throwable var62 = var10000;
         var5.close();
         throw var62;
      }

      var5.close();
      return var4;
   }

   // $FF: synthetic method
   static Integer lambda$updateDisinfection$44(Boolean var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label307: {
         Throwable var10000;
         label309: {
            var4 = var2.prepare("UPDATE device_table SET disinfection = ? WHERE uid = ?");
            Integer var47;
            if (var0 == null) {
               var47 = null;
            } else {
               try {
                  var47 = Integer.valueOf(var0);
               } catch (Throwable var46) {
                  var10000 = var46;
                  boolean var10001 = false;
                  break label309;
               }
            }

            if (var47 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var45) {
                  var10000 = var45;
                  boolean var49 = false;
                  break label309;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var47);
               } catch (Throwable var44) {
                  var10000 = var44;
                  boolean var50 = false;
                  break label309;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var43) {
                  var10000 = var43;
                  boolean var51 = false;
                  break label309;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var42) {
                  var10000 = var42;
                  boolean var52 = false;
                  break label309;
               }
            }

            label291:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label307;
            } catch (Throwable var41) {
               var10000 = var41;
               boolean var53 = false;
               break label291;
            }
         }

         Throwable var48 = var10000;
         var4.close();
         throw var48;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateDualOscillationConfig$109(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, String var11, SQLiteConnection var12) {
      SQLiteStatement var15 = var12.prepare("UPDATE device_table SET oscillationMode = ?, horizontalOscillationState = ?, horizontalOscillationFixAngle = ?, horizontalOscillationMinAngle = ?, horizontalOscillationMaxAngle = ?, verticalOscillationState = ?, verticalOscillationFixAngle = ?, verticalOscillationMinAngle = ?, verticalOscillationMaxAngle = ?, horizontalCalibrationState = ?, verticalCalibrationState = ? WHERE uid = ?");
      long var13 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var15.bindLong(1, var13);
               var15.bindLong(2, (long)var1);
               var15.bindLong(3, (long)var2);
               var15.bindLong(4, (long)var3);
               var15.bindLong(5, (long)var4);
               var15.bindLong(6, (long)var5);
               var15.bindLong(7, (long)var6);
               var15.bindLong(8, (long)var7);
               var15.bindLong(9, (long)var8);
               var15.bindLong(10, (long)var9);
               var15.bindLong(11, (long)var10);
            } catch (Throwable var35) {
               var10000 = var35;
               boolean var10001 = false;
               break label170;
            }

            if (var11 == null) {
               try {
                  var15.bindNull(12);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var38 = false;
                  break label170;
               }
            } else {
               try {
                  var15.bindText(12, var11);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var39 = false;
                  break label170;
               }
            }

            label156:
            try {
               var15.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var12);
               break label166;
            } catch (Throwable var32) {
               var10000 = var32;
               boolean var40 = false;
               break label156;
            }
         }

         Throwable var37 = var10000;
         var15.close();
         throw var37;
      }

      var15.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateEcoMode$29(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isEcoModeOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateFanSpeed$13(Integer var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET fanSpeed = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateFanSpeedAndAutoMode$14(Integer var0, String var1, String var2, SQLiteConnection var3) {
      int var4;
      SQLiteStatement var5;
      label368: {
         Throwable var10000;
         label370: {
            var5 = var3.prepare("UPDATE device_table SET fanSpeed = ?, autoModeText = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var5.bindNull(1);
               } catch (Throwable var61) {
                  var10000 = var61;
                  boolean var10001 = false;
                  break label370;
               }
            } else {
               try {
                  var5.bindLong(1, (long)var0);
               } catch (Throwable var60) {
                  var10000 = var60;
                  boolean var63 = false;
                  break label370;
               }
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var59) {
                  var10000 = var59;
                  boolean var64 = false;
                  break label370;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var58) {
                  var10000 = var58;
                  boolean var65 = false;
                  break label370;
               }
            }

            if (var2 == null) {
               try {
                  var5.bindNull(3);
               } catch (Throwable var57) {
                  var10000 = var57;
                  boolean var66 = false;
                  break label370;
               }
            } else {
               try {
                  var5.bindText(3, var2);
               } catch (Throwable var56) {
                  var10000 = var56;
                  boolean var67 = false;
                  break label370;
               }
            }

            label351:
            try {
               var5.step();
               var4 = SQLiteConnectionUtil.getTotalChangedRows(var3);
               break label368;
            } catch (Throwable var55) {
               var10000 = var55;
               boolean var68 = false;
               break label351;
            }
         }

         Throwable var62 = var10000;
         var5.close();
         throw var62;
      }

      var5.close();
      return var4;
   }

   // $FF: synthetic method
   static Integer lambda$updateFilterLife$21(Integer var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET filterLife = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateFilterTrigger$36(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET filterTrigger = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateFilterType$41(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET filterType = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateG4NightMode$32(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isG4NightModeOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateG4NightModeFilterTrigger$37(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET g4NightModefilterTrigger = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateGermShieldMode$33(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isGermShieldOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateGermShieldNightMode$34(Boolean var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label307: {
         Throwable var10000;
         label309: {
            var4 = var2.prepare("UPDATE device_table SET isGermShieldNightModeOn = ? WHERE uid = ?");
            Integer var47;
            if (var0 == null) {
               var47 = null;
            } else {
               try {
                  var47 = Integer.valueOf(var0);
               } catch (Throwable var46) {
                  var10000 = var46;
                  boolean var10001 = false;
                  break label309;
               }
            }

            if (var47 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var45) {
                  var10000 = var45;
                  boolean var49 = false;
                  break label309;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var47);
               } catch (Throwable var44) {
                  var10000 = var44;
                  boolean var50 = false;
                  break label309;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var43) {
                  var10000 = var43;
                  boolean var51 = false;
                  break label309;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var42) {
                  var10000 = var42;
                  boolean var52 = false;
                  break label309;
               }
            }

            label291:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label307;
            } catch (Throwable var41) {
               var10000 = var41;
               boolean var53 = false;
               break label291;
            }
         }

         Throwable var48 = var10000;
         var4.close();
         throw var48;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateHardware$27(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET hardware = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateHeatAutoTmp$65(double var0, String var2, SQLiteConnection var3) {
      SQLiteStatement var5 = var3.prepare("UPDATE device_table SET heatAutoTmp = ? WHERE uid = ?");

      int var4;
      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindDouble(1, var0);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var2 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var27 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var2);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var28 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var4 = SQLiteConnectionUtil.getTotalChangedRows(var3);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var29 = false;
               break label156;
            }
         }

         Throwable var26 = var10000;
         var5.close();
         throw var26;
      }

      var5.close();
      return var4;
   }

   // $FF: synthetic method
   static Integer lambda$updateHeatEcoTmp$66(double var0, String var2, SQLiteConnection var3) {
      SQLiteStatement var5 = var3.prepare("UPDATE device_table SET heatEcoTmp = ? WHERE uid = ?");

      int var4;
      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindDouble(1, var0);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var2 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var27 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var2);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var28 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var4 = SQLiteConnectionUtil.getTotalChangedRows(var3);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var29 = false;
               break label156;
            }
         }

         Throwable var26 = var10000;
         var5.close();
         throw var26;
      }

      var5.close();
      return var4;
   }

   // $FF: synthetic method
   static Integer lambda$updateHeatFanSpeed$64(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET heatFanSpeed = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateHeatSubMode$63(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET heatSubMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateHinsMode$30(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isHinsModeOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateHinsNightMode$31(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isHinsNightModeOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateHoverEnabled$85(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET hoverEnabled = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateHumMode$76(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET humMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateHumSubMode$100(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET humSubMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateLastSelectedSensorType$12(Integer var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET lastSelectedSensorType = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateLatestSensorDataPoint$11(long var0, Float var2, Float var3, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, String var10, SQLiteConnection var11) {
      SQLiteStatement var13 = var11.prepare("UPDATE device_table SET timeInSeconds = ?, pm1 = ?, pm10 = ?, pm25 = ?, voc = ?, hcho = ?, tmp = ?, hum = ?, fan = ? WHERE uid = ?");

      int var12;
      label2398: {
         Throwable var10000;
         label2402: {
            try {
               var13.bindLong(1, var0);
            } catch (Throwable var433) {
               var10000 = var433;
               boolean var10001 = false;
               break label2402;
            }

            if (var2 == null) {
               try {
                  var13.bindNull(2);
               } catch (Throwable var432) {
                  var10000 = var432;
                  boolean var435 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(2, (double)var2);
               } catch (Throwable var431) {
                  var10000 = var431;
                  boolean var436 = false;
                  break label2402;
               }
            }

            if (var3 == null) {
               try {
                  var13.bindNull(3);
               } catch (Throwable var430) {
                  var10000 = var430;
                  boolean var437 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(3, (double)var3);
               } catch (Throwable var429) {
                  var10000 = var429;
                  boolean var438 = false;
                  break label2402;
               }
            }

            if (var4 == null) {
               try {
                  var13.bindNull(4);
               } catch (Throwable var428) {
                  var10000 = var428;
                  boolean var439 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(4, (double)var4);
               } catch (Throwable var427) {
                  var10000 = var427;
                  boolean var440 = false;
                  break label2402;
               }
            }

            if (var5 == null) {
               try {
                  var13.bindNull(5);
               } catch (Throwable var426) {
                  var10000 = var426;
                  boolean var441 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(5, (double)var5);
               } catch (Throwable var425) {
                  var10000 = var425;
                  boolean var442 = false;
                  break label2402;
               }
            }

            if (var6 == null) {
               try {
                  var13.bindNull(6);
               } catch (Throwable var424) {
                  var10000 = var424;
                  boolean var443 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(6, (double)var6);
               } catch (Throwable var423) {
                  var10000 = var423;
                  boolean var444 = false;
                  break label2402;
               }
            }

            if (var7 == null) {
               try {
                  var13.bindNull(7);
               } catch (Throwable var422) {
                  var10000 = var422;
                  boolean var445 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(7, (double)var7);
               } catch (Throwable var421) {
                  var10000 = var421;
                  boolean var446 = false;
                  break label2402;
               }
            }

            if (var8 == null) {
               try {
                  var13.bindNull(8);
               } catch (Throwable var420) {
                  var10000 = var420;
                  boolean var447 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(8, (double)var8);
               } catch (Throwable var419) {
                  var10000 = var419;
                  boolean var448 = false;
                  break label2402;
               }
            }

            if (var9 == null) {
               try {
                  var13.bindNull(9);
               } catch (Throwable var418) {
                  var10000 = var418;
                  boolean var449 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindDouble(9, (double)var9);
               } catch (Throwable var417) {
                  var10000 = var417;
                  boolean var450 = false;
                  break label2402;
               }
            }

            if (var10 == null) {
               try {
                  var13.bindNull(10);
               } catch (Throwable var416) {
                  var10000 = var416;
                  boolean var451 = false;
                  break label2402;
               }
            } else {
               try {
                  var13.bindText(10, var10);
               } catch (Throwable var415) {
                  var10000 = var415;
                  boolean var452 = false;
                  break label2402;
               }
            }

            label2348:
            try {
               var13.step();
               var12 = SQLiteConnectionUtil.getTotalChangedRows(var11);
               break label2398;
            } catch (Throwable var414) {
               var10000 = var414;
               boolean var453 = false;
               break label2348;
            }
         }

         Throwable var434 = var10000;
         var13.close();
         throw var434;
      }

      var13.close();
      return var12;
   }

   // $FF: synthetic method
   static Integer lambda$updateLinkedDeviceUid$18(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET linkedDeviceUid = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateLocationId$73(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET locationId = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateMacAddress$39(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET mac = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateMainMode$60(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET mainMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateMcuFirmware$26(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET mcuFirmware = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateMode$75(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET mode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateModelName$40(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET modelName = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateName$9(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET name = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateNightLampBrightness$93(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET nightLampBrightness = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateNightLampSteplessBrightness$98(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET nightLampSteplessBrightness = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateNightModeStartTime$106(long var0, String var2, SQLiteConnection var3) {
      SQLiteStatement var5 = var3.prepare("UPDATE device_table SET nightModeStartTime = ? WHERE uid = ?");

      int var4;
      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var0);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var2 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var27 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var2);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var28 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var4 = SQLiteConnectionUtil.getTotalChangedRows(var3);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var29 = false;
               break label156;
            }
         }

         Throwable var26 = var10000;
         var5.close();
         throw var26;
      }

      var5.close();
      return var4;
   }

   // $FF: synthetic method
   static Integer lambda$updateNightPeriods$107(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET nightPeriods = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateOscillationAngle$57(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET oscillationAngle = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateOscillationDirection$58(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET oscillationDirection = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateOscillationFanSpeed$59(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET oscillationFanSpeed = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateOscillationState$56(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET oscillationState = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updatePanelDisplayMode$84(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET panelDisplayMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateProgress$20(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET updateProgress = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateRoomType$92(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET roomType = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateRpm$108(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET rpm1 = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateSafetySwitch$38(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isSafetySwitchOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateSensorMode$103(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET sensorMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateSensorRange$24(String var0, String var1, String var2, String var3, String var4, String var5, SQLiteConnection var6) {
      int var7;
      SQLiteStatement var8;
      label1067: {
         Throwable var10000;
         label1069: {
            var8 = var6.prepare("UPDATE device_table SET pm1Ranges = ?, pm10Ranges = ?, pm25Ranges = ?, vocRanges = ?, hchoRanges = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var8.bindNull(1);
               } catch (Throwable var190) {
                  var10000 = var190;
                  boolean var10001 = false;
                  break label1069;
               }
            } else {
               try {
                  var8.bindText(1, var0);
               } catch (Throwable var189) {
                  var10000 = var189;
                  boolean var192 = false;
                  break label1069;
               }
            }

            if (var1 == null) {
               try {
                  var8.bindNull(2);
               } catch (Throwable var188) {
                  var10000 = var188;
                  boolean var193 = false;
                  break label1069;
               }
            } else {
               try {
                  var8.bindText(2, var1);
               } catch (Throwable var187) {
                  var10000 = var187;
                  boolean var194 = false;
                  break label1069;
               }
            }

            if (var2 == null) {
               try {
                  var8.bindNull(3);
               } catch (Throwable var186) {
                  var10000 = var186;
                  boolean var195 = false;
                  break label1069;
               }
            } else {
               try {
                  var8.bindText(3, var2);
               } catch (Throwable var185) {
                  var10000 = var185;
                  boolean var196 = false;
                  break label1069;
               }
            }

            if (var3 == null) {
               try {
                  var8.bindNull(4);
               } catch (Throwable var184) {
                  var10000 = var184;
                  boolean var197 = false;
                  break label1069;
               }
            } else {
               try {
                  var8.bindText(4, var3);
               } catch (Throwable var183) {
                  var10000 = var183;
                  boolean var198 = false;
                  break label1069;
               }
            }

            if (var4 == null) {
               try {
                  var8.bindNull(5);
               } catch (Throwable var182) {
                  var10000 = var182;
                  boolean var199 = false;
                  break label1069;
               }
            } else {
               try {
                  var8.bindText(5, var4);
               } catch (Throwable var181) {
                  var10000 = var181;
                  boolean var200 = false;
                  break label1069;
               }
            }

            if (var5 == null) {
               try {
                  var8.bindNull(6);
               } catch (Throwable var180) {
                  var10000 = var180;
                  boolean var201 = false;
                  break label1069;
               }
            } else {
               try {
                  var8.bindText(6, var5);
               } catch (Throwable var179) {
                  var10000 = var179;
                  boolean var202 = false;
                  break label1069;
               }
            }

            label1035:
            try {
               var8.step();
               var7 = SQLiteConnectionUtil.getTotalChangedRows(var6);
               break label1067;
            } catch (Throwable var178) {
               var10000 = var178;
               boolean var203 = false;
               break label1035;
            }
         }

         Throwable var191 = var10000;
         var8.close();
         throw var191;
      }

      var8.close();
      return var7;
   }

   // $FF: synthetic method
   static Integer lambda$updateSerialNumber$35(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET serial = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateSku$22(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET sku = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateSmartSubMode$80(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET smartSubMode = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateStandByMode$28(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET isStandByOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateTemperatureUnit$55(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET temperatureUnit = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateTimerDuration$53(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET timerDuration = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateTimerLeftTime$54(int var0, long var1, String var3, SQLiteConnection var4) {
      SQLiteStatement var7 = var4.prepare("UPDATE device_table SET timerLeftTime = ?, timerLeftTimeUpdateTime = ? WHERE uid = ?");
      long var5 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var7.bindLong(1, var5);
               var7.bindLong(2, var1);
            } catch (Throwable var27) {
               var10000 = var27;
               boolean var10001 = false;
               break label170;
            }

            if (var3 == null) {
               try {
                  var7.bindNull(3);
               } catch (Throwable var26) {
                  var10000 = var26;
                  boolean var30 = false;
                  break label170;
               }
            } else {
               try {
                  var7.bindText(3, var3);
               } catch (Throwable var25) {
                  var10000 = var25;
                  boolean var31 = false;
                  break label170;
               }
            }

            label156:
            try {
               var7.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var4);
               break label166;
            } catch (Throwable var24) {
               var10000 = var24;
               boolean var32 = false;
               break label156;
            }
         }

         Throwable var29 = var10000;
         var7.close();
         throw var29;
      }

      var7.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateTimerStatus$52(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET timerStatus = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateTimezone$10(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET timeZone = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateUse24Hour$101(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET use24Hour = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWaterLevel$77(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET waterLevel = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWaterShortage$50(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET waterShortage = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWaterTankFailure$79(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET waterTankFailure = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Unit lambda$updateWelcomeHome$43(Double var0, Double var1, Integer var2, String var3, Boolean var4, String var5, SQLiteConnection var6) {
      label1263: {
         Throwable var10000;
         label1265: {
            var220 = var6.prepare("UPDATE device_table SET lat = ?, lng = ?, radius = ?, textValue = ?, isEnabled = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var220.bindNull(1);
               } catch (Throwable var216) {
                  var10000 = var216;
                  boolean var10001 = false;
                  break label1265;
               }
            } else {
               try {
                  var220.bindDouble(1, var0);
               } catch (Throwable var215) {
                  var10000 = var215;
                  boolean var221 = false;
                  break label1265;
               }
            }

            if (var1 == null) {
               try {
                  var220.bindNull(2);
               } catch (Throwable var214) {
                  var10000 = var214;
                  boolean var222 = false;
                  break label1265;
               }
            } else {
               try {
                  var220.bindDouble(2, var1);
               } catch (Throwable var213) {
                  var10000 = var213;
                  boolean var223 = false;
                  break label1265;
               }
            }

            if (var2 == null) {
               try {
                  var220.bindNull(3);
               } catch (Throwable var212) {
                  var10000 = var212;
                  boolean var224 = false;
                  break label1265;
               }
            } else {
               try {
                  var220.bindLong(3, (long)var2);
               } catch (Throwable var211) {
                  var10000 = var211;
                  boolean var225 = false;
                  break label1265;
               }
            }

            if (var3 == null) {
               try {
                  var220.bindNull(4);
               } catch (Throwable var210) {
                  var10000 = var210;
                  boolean var226 = false;
                  break label1265;
               }
            } else {
               try {
                  var220.bindText(4, var3);
               } catch (Throwable var209) {
                  var10000 = var209;
                  boolean var227 = false;
                  break label1265;
               }
            }

            Integer var217;
            if (var4 == null) {
               var217 = null;
            } else {
               try {
                  var217 = Integer.valueOf(var4);
               } catch (Throwable var208) {
                  var10000 = var208;
                  boolean var228 = false;
                  break label1265;
               }
            }

            if (var217 == null) {
               try {
                  var220.bindNull(5);
               } catch (Throwable var207) {
                  var10000 = var207;
                  boolean var229 = false;
                  break label1265;
               }
            } else {
               try {
                  var220.bindLong(5, (long)var217);
               } catch (Throwable var206) {
                  var10000 = var206;
                  boolean var230 = false;
                  break label1265;
               }
            }

            if (var5 == null) {
               try {
                  var220.bindNull(6);
               } catch (Throwable var205) {
                  var10000 = var205;
                  boolean var231 = false;
                  break label1265;
               }
            } else {
               try {
                  var220.bindText(6, var5);
               } catch (Throwable var204) {
                  var10000 = var204;
                  boolean var232 = false;
                  break label1265;
               }
            }

            label1227:
            try {
               var220.step();
               var219 = Unit.INSTANCE;
               break label1263;
            } catch (Throwable var203) {
               var10000 = var203;
               boolean var233 = false;
               break label1227;
            }
         }

         Throwable var218 = var10000;
         var220.close();
         throw var218;
      }

      var220.close();
      return var219;
   }

   // $FF: synthetic method
   static Integer lambda$updateWickUsage$49(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET wickUsage = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWickdryDone$95(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET wickdryDone = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWickdryDuration$94(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET wickdryDuration = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWickdryEnabled$46(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET wickdryEnabled = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWickdryLeftTime$48(int var0, long var1, String var3, SQLiteConnection var4) {
      SQLiteStatement var7 = var4.prepare("UPDATE device_table SET wickdryLeftTime = ?, wickdryLeftTimeUpdateTime = ? WHERE uid = ?");
      long var5 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var7.bindLong(1, var5);
               var7.bindLong(2, var1);
            } catch (Throwable var27) {
               var10000 = var27;
               boolean var10001 = false;
               break label170;
            }

            if (var3 == null) {
               try {
                  var7.bindNull(3);
               } catch (Throwable var26) {
                  var10000 = var26;
                  boolean var30 = false;
                  break label170;
               }
            } else {
               try {
                  var7.bindText(3, var3);
               } catch (Throwable var25) {
                  var10000 = var25;
                  boolean var31 = false;
                  break label170;
               }
            }

            label156:
            try {
               var7.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var4);
               break label166;
            } catch (Throwable var24) {
               var10000 = var24;
               boolean var32 = false;
               break label156;
            }
         }

         Throwable var29 = var10000;
         var7.close();
         throw var29;
      }

      var7.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWickdryOn$47(boolean var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET wickdryOn = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   // $FF: synthetic method
   static Integer lambda$updateWifiFirmware$25(String var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label215: {
         Throwable var10000;
         label217: {
            var4 = var2.prepare("UPDATE device_table SET wifiFirmware = ? WHERE uid = ?");
            if (var0 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var34) {
                  var10000 = var34;
                  boolean var10001 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(1, var0);
               } catch (Throwable var33) {
                  var10000 = var33;
                  boolean var36 = false;
                  break label217;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var37 = false;
                  break label217;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label217;
               }
            }

            label203:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label215;
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var39 = false;
               break label203;
            }
         }

         Throwable var35 = var10000;
         var4.close();
         throw var35;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateYwrmEnabled$96(Boolean var0, String var1, SQLiteConnection var2) {
      int var3;
      SQLiteStatement var4;
      label307: {
         Throwable var10000;
         label309: {
            var4 = var2.prepare("UPDATE device_table SET ywrmEnabled = ? WHERE uid = ?");
            Integer var47;
            if (var0 == null) {
               var47 = null;
            } else {
               try {
                  var47 = Integer.valueOf(var0);
               } catch (Throwable var46) {
                  var10000 = var46;
                  boolean var10001 = false;
                  break label309;
               }
            }

            if (var47 == null) {
               try {
                  var4.bindNull(1);
               } catch (Throwable var45) {
                  var10000 = var45;
                  boolean var49 = false;
                  break label309;
               }
            } else {
               try {
                  var4.bindLong(1, (long)var47);
               } catch (Throwable var44) {
                  var10000 = var44;
                  boolean var50 = false;
                  break label309;
               }
            }

            if (var1 == null) {
               try {
                  var4.bindNull(2);
               } catch (Throwable var43) {
                  var10000 = var43;
                  boolean var51 = false;
                  break label309;
               }
            } else {
               try {
                  var4.bindText(2, var1);
               } catch (Throwable var42) {
                  var10000 = var42;
                  boolean var52 = false;
                  break label309;
               }
            }

            label291:
            try {
               var4.step();
               var3 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label307;
            } catch (Throwable var41) {
               var10000 = var41;
               boolean var53 = false;
               break label291;
            }
         }

         Throwable var48 = var10000;
         var4.close();
         throw var48;
      }

      var4.close();
      return var3;
   }

   // $FF: synthetic method
   static Integer lambda$updateYwrmUsage$97(int var0, String var1, SQLiteConnection var2) {
      SQLiteStatement var5 = var2.prepare("UPDATE device_table SET ywrmUsage = ? WHERE uid = ?");
      long var3 = (long)var0;

      label166: {
         Throwable var10000;
         label170: {
            try {
               var5.bindLong(1, var3);
            } catch (Throwable var25) {
               var10000 = var25;
               boolean var10001 = false;
               break label170;
            }

            if (var1 == null) {
               try {
                  var5.bindNull(2);
               } catch (Throwable var24) {
                  var10000 = var24;
                  boolean var28 = false;
                  break label170;
               }
            } else {
               try {
                  var5.bindText(2, var1);
               } catch (Throwable var23) {
                  var10000 = var23;
                  boolean var29 = false;
                  break label170;
               }
            }

            label156:
            try {
               var5.step();
               var0 = SQLiteConnectionUtil.getTotalChangedRows(var2);
               break label166;
            } catch (Throwable var22) {
               var10000 = var22;
               boolean var30 = false;
               break label156;
            }
         }

         Throwable var27 = var10000;
         var5.close();
         throw var27;
      }

      var5.close();
      return var0;
   }

   public void delete(String var1) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda61(var1));
   }

   public void deleteAll() {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda30());
   }

   public void deleteAll(boolean var1) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda13(var1));
   }

   public Object deleteLocationId(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda14(var1), var2);
   }

   public DeviceEntity device(String var1) {
      return (DeviceEntity)DBUtil.performBlocking(this.__db, true, false, new DeviceDao_Impl$$ExternalSyntheticLambda48(var1));
   }

   public Object getDevices(Continuation var1) {
      return DBUtil.performSuspending(this.__db, true, false, new DeviceDao_Impl$$ExternalSyntheticLambda12(), var1);
   }

   public List getDevices() {
      return (List)DBUtil.performBlocking(this.__db, true, false, new DeviceDao_Impl$$ExternalSyntheticLambda105());
   }

   public Flow getFlowDevice(String var1) {
      RoomDatabase var2 = this.__db;
      DeviceDao_Impl$$ExternalSyntheticLambda51 var3 = new DeviceDao_Impl$$ExternalSyntheticLambda51(var1);
      return FlowUtil.createFlow(var2, false, new String[]{"device_table"}, var3);
   }

   public Flow getFlowDevices() {
      RoomDatabase var1 = this.__db;
      DeviceDao_Impl$$ExternalSyntheticLambda70 var2 = new DeviceDao_Impl$$ExternalSyntheticLambda70();
      return FlowUtil.createFlow(var1, false, new String[]{"device_table"}, var2);
   }

   public LiveData getLiveDevices() {
      InvalidationTracker var1 = this.__db.getInvalidationTracker();
      DeviceDao_Impl$$ExternalSyntheticLambda55 var2 = new DeviceDao_Impl$$ExternalSyntheticLambda55();
      return var1.createLiveData(new String[]{"device_table"}, false, var2);
   }

   public void insert(DeviceEntity var1) {
      var1.getClass();
      DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda65(this, var1));
   }

   // $FF: synthetic method
   Object lambda$insert$0$com_blueair_database_dao_DeviceDao_Impl/* $FF was: lambda$insert$0$com-blueair-database-dao-DeviceDao_Impl*/(DeviceEntity var1, SQLiteConnection var2) {
      this.__insertAdapterOfDeviceEntity.insert(var2, var1);
      return null;
   }

   // $FF: synthetic method
   Integer lambda$update$1$com_blueair_database_dao_DeviceDao_Impl/* $FF was: lambda$update$1$com-blueair-database-dao-DeviceDao_Impl*/(DeviceEntity var1, SQLiteConnection var2) {
      return this.__updateAdapterOfDeviceEntity.handle(var2, var1);
   }

   public LiveData liveDevice(String var1) {
      InvalidationTracker var2 = this.__db.getInvalidationTracker();
      DeviceDao_Impl$$ExternalSyntheticLambda90 var3 = new DeviceDao_Impl$$ExternalSyntheticLambda90(var1);
      return var2.createLiveData(new String[]{"device_table"}, false, var3);
   }

   public Object updatWaterInfill(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda49(var2, var1), var3);
   }

   public int update(DeviceEntity var1) {
      var1.getClass();
      return (Integer)DBUtil.performBlocking(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda108(this, var1));
   }

   public Object updateAirRefreshDuration(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda35(var2, var1), var3);
   }

   public Object updateAirRefreshEnabled(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda19(var2, var1), var3);
   }

   public Object updateAirRefreshEndTimeStamp(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda32(var2, var1), var3);
   }

   public Object updateAirRefreshStartTimeStamp(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda102(var2, var1), var3);
   }

   public Object updateAirRefreshStatus(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda31(var2, var1), var3);
   }

   public Object updateAirRefreshTimeStamp(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda73(var2, var1), var3);
   }

   public Object updateAlarms(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda93(var2, var1), var3);
   }

   public Object updateApFanSpeed(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda60(var2, var1), var3);
   }

   public Object updateApSubMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda99(var2, var1), var3);
   }

   public Object updateAutoMode(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda0(var2, var1), var3);
   }

   public Object updateAutoRh(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda22(var2, var1), var3);
   }

   public Object updateBodyMounted(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda26(var2, var1), var3);
   }

   public Object updateBrightness(String var1, Integer var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda4(var2, var1), var3);
   }

   public Object updateChildLock(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda77(var2, var1), var3);
   }

   public Object updateCleanAirEta(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda101(var2, var1), var3);
   }

   public Object updateCompatibility(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda11(var2, var1), var3);
   }

   public Object updateConnectivityStatus(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda18(var2, var1), var3);
   }

   public Object updateCoolAutoLevel(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda44(var2, var1), var3);
   }

   public Object updateCoolAutoPresets(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda85(var2, var1), var3);
   }

   public Object updateCoolAutoTag(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda94(var2, var1), var3);
   }

   public Object updateCoolEcoPresets(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda84(var2, var1), var3);
   }

   public Object updateCoolEcoTag(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda86(var2, var1), var3);
   }

   public Object updateCoolFanSpeed(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda59(var2, var1), var3);
   }

   public Object updateCoolFanSpeedLevel(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda17(var2, var1), var3);
   }

   public Object updateCoolSubMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda15(var2, var1), var3);
   }

   public Object updateDehSubMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda106(var2, var1), var3);
   }

   public Object updateDetectCat(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda3(var2, var1), var3);
   }

   public Object updateDeviceType(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda5(var2, var1), var3);
   }

   public Object updateDisinfectLeftTime(String var1, Integer var2, Long var3, Continuation var4) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda78(var2, var3, var1), var4);
   }

   public Object updateDisinfection(String var1, Boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda54(var2, var1), var3);
   }

   public Object updateDualOscillationConfig(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, Continuation var13) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda79(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var1), var13);
   }

   public Object updateEcoMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda56(var2, var1), var3);
   }

   public Object updateFanSpeed(String var1, Integer var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda72(var2, var1), var3);
   }

   public Object updateFanSpeedAndAutoMode(String var1, Integer var2, String var3, Continuation var4) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda83(var2, var3, var1), var4);
   }

   public Object updateFilterLife(String var1, Integer var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda71(var2, var1), var3);
   }

   public Object updateFilterTrigger(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda109(var2, var1), var3);
   }

   public Object updateFilterType(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda23(var2, var1), var3);
   }

   public Object updateG4NightMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda50(var2, var1), var3);
   }

   public Object updateG4NightModeFilterTrigger(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda39(var2, var1), var3);
   }

   public Object updateGermShieldMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda67(var2, var1), var3);
   }

   public Object updateGermShieldNightMode(String var1, Boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda104(var2, var1), var3);
   }

   public Object updateHardware(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda100(var2, var1), var3);
   }

   public Object updateHeatAutoTmp(String var1, double var2, Continuation var4) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda58(var2, var1), var4);
   }

   public Object updateHeatEcoTmp(String var1, double var2, Continuation var4) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda82(var2, var1), var4);
   }

   public Object updateHeatFanSpeed(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda112(var2, var1), var3);
   }

   public Object updateHeatSubMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda28(var2, var1), var3);
   }

   public Object updateHinsMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda68(var2, var1), var3);
   }

   public Object updateHinsNightMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda97(var2, var1), var3);
   }

   public Object updateHoverEnabled(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda27(var2, var1), var3);
   }

   public Object updateHumMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda46(var2, var1), var3);
   }

   public Object updateHumSubMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda25(var2, var1), var3);
   }

   public Object updateLastSelectedSensorType(String var1, Integer var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda47(var2, var1), var3);
   }

   public Object updateLatestSensorDataPoint(String var1, long var2, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Continuation var12) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda81(var2, var4, var5, var6, var7, var8, var9, var10, var11, var1), var12);
   }

   public Object updateLinkedDeviceUid(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda69(var2, var1), var3);
   }

   public Object updateLocationId(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda33(var2, var1), var3);
   }

   public Object updateMacAddress(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda9(var2, var1), var3);
   }

   public Object updateMainMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda75(var2, var1), var3);
   }

   public Object updateMcuFirmware(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda29(var2, var1), var3);
   }

   public Object updateMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda43(var2, var1), var3);
   }

   public Object updateModelName(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda40(var2, var1), var3);
   }

   public Object updateName(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda103(var2, var1), var3);
   }

   public Object updateNightLampBrightness(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda96(var2, var1), var3);
   }

   public Object updateNightLampSteplessBrightness(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda111(var2, var1), var3);
   }

   public Object updateNightModeStartTime(String var1, long var2, Continuation var4) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda89(var2, var1), var4);
   }

   public Object updateNightPeriods(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda62(var2, var1), var3);
   }

   public Object updateOscillationAngle(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda88(var2, var1), var3);
   }

   public Object updateOscillationDirection(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda8(var2, var1), var3);
   }

   public Object updateOscillationFanSpeed(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda42(var2, var1), var3);
   }

   public Object updateOscillationState(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda34(var2, var1), var3);
   }

   public Object updatePanelDisplayMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda95(var2, var1), var3);
   }

   public Object updateProgress(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda66(var2, var1), var3);
   }

   public Object updateRoomType(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda1(var2, var1), var3);
   }

   public Object updateRpm(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda80(var2, var1), var3);
   }

   public Object updateSafetySwitch(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda57(var2, var1), var3);
   }

   public Object updateSensorMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda7(var2, var1), var3);
   }

   public Object updateSensorRange(String var1, String var2, String var3, String var4, String var5, String var6, Continuation var7) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda24(var2, var3, var4, var5, var6, var1), var7);
   }

   public Object updateSerialNumber(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda20(var2, var1), var3);
   }

   public Object updateSku(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda16(var2, var1), var3);
   }

   public Object updateSmartSubMode(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda36(var2, var1), var3);
   }

   public Object updateStandByMode(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda63(var2, var1), var3);
   }

   public Object updateTemperatureUnit(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda10(var2, var1), var3);
   }

   public Object updateTimerDuration(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda92(var2, var1), var3);
   }

   public Object updateTimerLeftTime(String var1, int var2, long var3, Continuation var5) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda37(var2, var3, var1), var5);
   }

   public Object updateTimerStatus(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda64(var2, var1), var3);
   }

   public Object updateTimezone(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda21(var2, var1), var3);
   }

   public Object updateUse24Hour(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda91(var2, var1), var3);
   }

   public Object updateWaterLevel(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda2(var2, var1), var3);
   }

   public Object updateWaterShortage(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda87(var2, var1), var3);
   }

   public Object updateWaterTankFailure(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda74(var2, var1), var3);
   }

   public Object updateWelcomeHome(String var1, Double var2, Double var3, Integer var4, String var5, Boolean var6, Continuation var7) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda38(var2, var3, var4, var5, var6, var1), var7);
   }

   public Object updateWickUsage(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda53(var2, var1), var3);
   }

   public Object updateWickdryDone(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda98(var2, var1), var3);
   }

   public Object updateWickdryDuration(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda110(var2, var1), var3);
   }

   public Object updateWickdryEnabled(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda41(var2, var1), var3);
   }

   public Object updateWickdryLeftTime(String var1, int var2, long var3, Continuation var5) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda107(var2, var3, var1), var5);
   }

   public Object updateWickdryOn(String var1, boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda52(var2, var1), var3);
   }

   public Object updateWifiFirmware(String var1, String var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda76(var2, var1), var3);
   }

   public Object updateYwrmEnabled(String var1, Boolean var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda45(var2, var1), var3);
   }

   public Object updateYwrmUsage(String var1, int var2, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceDao_Impl$$ExternalSyntheticLambda6(var2, var1), var3);
   }
}
