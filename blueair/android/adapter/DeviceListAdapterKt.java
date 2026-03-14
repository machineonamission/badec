package com.blueair.android.adapter;

import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasSensorMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.WelcomeHomeLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¨\u0006\b"},
   d2 = {"doListsContainSameDevices", "", "nuList", "", "Lcom/blueair/core/model/Device;", "oldList", "hasDeviceChanged", "o", "app_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceListAdapterKt {
   // $FF: synthetic method
   public static final boolean access$doListsContainSameDevices(List var0, List var1) {
      return doListsContainSameDevices(var0, var1);
   }

   // $FF: synthetic method
   public static final boolean access$hasDeviceChanged(Device var0, List var1) {
      return hasDeviceChanged(var0, var1);
   }

   private static final boolean doListsContainSameDevices(List var0, List var1) {
      Iterable var2 = (Iterable)var0;
      Collection var3 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         var3.add(((Device)var6.next()).getUid());
      }

      Set var4 = CollectionsKt.toSet((Iterable)((List)var3));
      Iterable var7 = (Iterable)var1;
      Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
      Iterator var8 = var7.iterator();

      while(var8.hasNext()) {
         var5.add(((Device)var8.next()).getUid());
      }

      return Intrinsics.areEqual(var4, CollectionsKt.toSet((Iterable)((List)var5)));
   }

   private static final boolean hasDeviceChanged(Device var0, List var1) {
      Iterator var4 = ((Iterable)var1).iterator();

      Object var5;
      do {
         boolean var3 = var4.hasNext();
         var5 = null;
         if (!var3) {
            var9 = null;
            break;
         }

         var9 = var4.next();
      } while(!Intrinsics.areEqual(((Device)var9).getUid(), var0.getUid()));

      Device var6 = (Device)var9;
      if (var6 == null) {
         return true;
      } else if (!Intrinsics.areEqual(var0.getType(), var6.getType())) {
         return true;
      } else if (!Intrinsics.areEqual(var0.getName(), var6.getName())) {
         return true;
      } else if (var0.getConnectivityStatus() != var6.getConnectivityStatus()) {
         return true;
      } else {
         if (var0 instanceof HasFanSpeed && var6 instanceof HasFanSpeed) {
            HasFanSpeed var10 = (HasFanSpeed)var0;
            AutoMode var7 = var10.getAutoMode();
            HasFanSpeed var23 = (HasFanSpeed)var6;
            if (var7 != var23.getAutoMode() || var0 instanceof HasG4NightMode && var6 instanceof HasG4NightMode && ((HasG4NightMode)var0).isG4NightModeOn() != ((HasG4NightMode)var6).isG4NightModeOn() || DeviceKt.fanSpeedValue(var0) != DeviceKt.fanSpeedValue(var6) || !Intrinsics.areEqual(var10.getFilterLife(), var23.getFilterLife())) {
               return true;
            }
         }

         if (var0 instanceof HasWelcomeHome && var6 instanceof HasWelcomeHome) {
            WelcomeHomeLocation var11 = ((HasWelcomeHome)var0).getWelcomeHome();
            Boolean var12;
            if (var11 != null) {
               var12 = var11.isEnabled();
            } else {
               var12 = null;
            }

            WelcomeHomeLocation var24 = ((HasWelcomeHome)var6).getWelcomeHome();
            Boolean var25;
            if (var24 != null) {
               var25 = var24.isEnabled();
            } else {
               var25 = null;
            }

            if (!Intrinsics.areEqual(var12, var25)) {
               return true;
            }
         }

         if (var0 instanceof HasStandBy && var6 instanceof HasStandBy && ((HasStandBy)var0).isStandByOn() != ((HasStandBy)var6).isStandByOn()) {
            return true;
         } else if (var0 instanceof HasEcoMode && var6 instanceof HasEcoMode && ((HasEcoMode)var0).isEcoModeOn() != ((HasEcoMode)var6).isEcoModeOn()) {
            return true;
         } else if (var0 instanceof HasSafetySwitch && var6 instanceof HasSafetySwitch && ((HasSafetySwitch)var0).isSafetySwitchOn() != ((HasSafetySwitch)var6).isSafetySwitchOn()) {
            return true;
         } else if (var0 instanceof HasLinkingCapability && var6 instanceof HasLinkingCapability && ((HasLinkingCapability)var0).isLinked() != ((HasLinkingCapability)var6).isLinked()) {
            return true;
         } else if (var0 instanceof HasChildLock && var6 instanceof HasChildLock && ((HasChildLock)var0).isChildLockOn() != ((HasChildLock)var6).isChildLockOn()) {
            return true;
         } else if (var0.getUpdateProgress() != var6.getUpdateProgress()) {
            return true;
         } else {
            if (var0 instanceof HasDisinfection && var6 instanceof HasDisinfection) {
               HasDisinfection var13 = (HasDisinfection)var0;
               Boolean var31 = var13.getDisinfection();
               HasDisinfection var26 = (HasDisinfection)var6;
               if (!Intrinsics.areEqual(var31, var26.getDisinfection()) || !Intrinsics.areEqual(var13.getDisinfectLeftTime(), var26.getDisinfectLeftTime()) || !Intrinsics.areEqual(var13.getDisinfectLeftTimeUpdateTime(), var26.getDisinfectLeftTimeUpdateTime())) {
                  return true;
               }
            }

            if (var0 instanceof HasWick && var6 instanceof HasWick) {
               HasWick var27 = (HasWick)var0;
               boolean var22 = var27.getWickdryOn();
               HasWick var14 = (HasWick)var6;
               if (var22 != var14.getWickdryOn() || var27.getWickdryLeftTime() != var14.getWickdryLeftTime() || var27.getWickdryLeftTimeUpdateTime() != var14.getWickdryLeftTimeUpdateTime() || var27.getWaterShortage() != var14.getWaterShortage() || var27.getWickUsage() != var14.getWickUsage()) {
                  return true;
               }

               if (var0 instanceof HasSensorData && var6 instanceof HasSensorData) {
                  IndoorDatapoint var15 = ((HasSensorData)var0).getLatestSensorDatapoint();
                  Float var16;
                  if (var15 != null) {
                     var16 = var15.getHum();
                  } else {
                     var16 = null;
                  }

                  IndoorDatapoint var32 = ((HasSensorData)var6).getLatestSensorDatapoint();
                  Float var28 = (Float)var5;
                  if (var32 != null) {
                     var28 = var32.getHum();
                  }

                  if (!Intrinsics.areEqual(var16, var28)) {
                     return true;
                  }
               }
            }

            if (var0 instanceof HasMainMode && var6 instanceof HasMainMode) {
               HasCombo3in1MainMode var29 = var0;
               int var2 = var29.getMainMode();
               HasMainMode var17 = (HasMainMode)var6;
               if (var2 != var17.getMainMode() || var29.getApSubMode() != var17.getApSubMode()) {
                  return true;
               }

               if (var29 instanceof HasCombo3in1MainMode && var6 instanceof HasCombo3in1MainMode) {
                  var29 = (HasCombo3in1MainMode)var0;
                  var2 = var29.getApFanSpeed();
                  HasCombo3in1MainMode var18 = (HasCombo3in1MainMode)var6;
                  if (var2 != var18.getApFanSpeed() || var29.getHeatSubMode() != var18.getHeatSubMode() || var29.getHeatFanSpeed() != var18.getHeatFanSpeed() || var29.getCoolSubMode() != var18.getCoolSubMode() || var29.getCoolFanSpeed() != var18.getCoolFanSpeed()) {
                     return true;
                  }
               } else if (var29 instanceof HasDehumidifierMainMode && var6 instanceof HasDehumidifierMainMode) {
                  if (((HasDehumidifierMainMode)var0).getDehSubMode() != ((HasDehumidifierMainMode)var6).getDehSubMode()) {
                     return true;
                  }
               } else if (var29 instanceof HasPetMainMode && var6 instanceof HasPetMainMode && ((HasPetMainMode)var0).getSmartSubMode() != ((HasPetMainMode)var6).getSmartSubMode()) {
                  return true;
               }
            }

            if (DeviceKt.isCelsiusUnit(var0) != DeviceKt.isCelsiusUnit(var6)) {
               return true;
            } else if (var0 instanceof HasMode && var6 instanceof HasMode && ((HasMode)var0).getMode() != ((HasMode)var6).getMode()) {
               return true;
            } else if (var0 instanceof HasHumMode && var6 instanceof HasHumMode && ((HasHumMode)var0).getHumMode() != ((HasHumMode)var6).getHumMode()) {
               return true;
            } else if (var0 instanceof HasTimer && var6 instanceof HasTimer && ((HasTimer)var0).getLeftSeconds() != ((HasTimer)var6).getLeftSeconds()) {
               return true;
            } else if (var0 instanceof HasAlarm && var6 instanceof HasAlarm && !Intrinsics.areEqual(((HasAlarm)var0).getAlarms(), ((HasAlarm)var6).getAlarms())) {
               return true;
            } else if (var0 instanceof HasWaterLevel && var6 instanceof HasWaterLevel && ((HasWaterLevel)var0).getWaterLevel() != ((HasWaterLevel)var6).getWaterLevel()) {
               return true;
            } else if (var0 instanceof HasSensorMode && var6 instanceof HasSensorMode && ((HasSensorMode)var0).getSensorMode() != ((HasSensorMode)var6).getSensorMode()) {
               return true;
            } else {
               if (var0 instanceof HasCoolMainMode && var6 instanceof HasCoolMainMode) {
                  var0 = var0;
                  int var21 = var0.getCoolSubMode();
                  HasCoolMainMode var19 = (HasCoolMainMode)var6;
                  if (var21 != var19.getCoolSubMode() || var0.getCoolAutoLevel() != var19.getCoolAutoLevel() || var0.getCoolFanSpeedLevel() != var19.getCoolFanSpeedLevel()) {
                     return true;
                  }
               }

               return false;
            }
         }
      }
   }
}
