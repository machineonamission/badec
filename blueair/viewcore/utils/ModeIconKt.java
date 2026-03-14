package com.blueair.viewcore.utils;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceBlue;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.MainMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(
   d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"},
   d2 = {"getSupportedModes", "", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lcom/blueair/core/model/Device;", "exceptStandBy", "", "isMainMode", "mainMode", "Lcom/blueair/core/model/MainMode;", "viewcore_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class ModeIconKt {
   public static final List getSupportedModes(Device var0, boolean var1, boolean var2, MainMode var3) {
      if (var0 == null) {
         return CollectionsKt.emptyList();
      } else if (var2) {
         return var0 instanceof DeviceCombo3in1 ? CollectionsKt.listOf(new ModeIcon[]{ModeIcon.AIR_PURIFY, ModeIcon.COOL, ModeIcon.HEAT}) : CollectionsKt.emptyList();
      } else if (var0 instanceof DeviceDehumidifier) {
         MainMode var4 = var3;
         if (var3 == null) {
            var4 = ((DeviceDehumidifier)var0).mainMode();
         }

         return var4 == MainMode.Dehumidification ? CollectionsKt.listOf(new ModeIcon[]{ModeIcon.DRYING.proofread(var0), ModeIcon.AUTO, ModeIcon.CONTINUOUS}) : CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.NIGHT});
      } else if (var0 instanceof DeviceMiniRestful) {
         return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.NIGHT});
      } else if (var0 instanceof DeviceBlue40) {
         return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.ECO});
      } else if (var0 instanceof DevicePet20) {
         return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.SMART, ModeIcon.NIGHT});
      } else if (!(var0 instanceof DeviceHumidifier) && !(var0 instanceof DeviceHumidifier20)) {
         if (var0 instanceof DeviceCombo3in1) {
            return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.ECO});
         } else if (var0 instanceof DeviceCombo2in120) {
            return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.SKIN});
         } else if (var0 instanceof DeviceCombo2in1) {
            return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT});
         } else if (var0 instanceof DeviceNewClassic) {
            return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.ECO});
         } else if (!(var0 instanceof DeviceBlue) && !(var0 instanceof DeviceB4) && !(var0 instanceof DeviceB4sp)) {
            if (var0 instanceof DeviceG4) {
               return ((DeviceG4)var0).isPlus() && DeviceKt.supportDisinfection(var0) ? CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.DISINFECTION}) : CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT});
            } else {
               return var0 instanceof DeviceFanTable ? CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT}) : CollectionsKt.emptyList();
            }
         } else {
            return CollectionsKt.listOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT});
         }
      } else {
         List var6 = CollectionsKt.listOf(new ModeIcon[]{ModeIcon.STANDBY, ModeIcon.FAN_SPEED, ModeIcon.AUTO.proofread(var0), ModeIcon.NIGHT});
         List var5 = var6;
         if (var1) {
            var5 = CollectionsKt.drop((Iterable)var6, 1);
         }

         return var5;
      }
   }

   // $FF: synthetic method
   public static List getSupportedModes$default(Device var0, boolean var1, boolean var2, MainMode var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = false;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      return getSupportedModes(var0, var1, var2, var3);
   }
}
