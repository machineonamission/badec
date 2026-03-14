package com.blueair.core.model;

import android.content.Context;
import java.util.TimeZone;

// $FF: synthetic class
public final class HasLinkingCapability$_CC {
   public static boolean $default$isLinked(HasLinkingCapability var0) {
      String var1 = var0.getLinkedToUid();
      return var1 != null && ((CharSequence)var1).length() > 0;
   }

   // $FF: synthetic method
   public static AutoMode access$getAutoMode$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getAutoMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasLinkingCapability var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static FanSpeedEnum access$getFanSpeedEnum$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getFanSpeedEnum(var0);
   }

   // $FF: synthetic method
   public static Filter access$getFilter$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getFilter(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGear0$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getHasGear0(var0);
   }

   // $FF: synthetic method
   public static boolean access$getHasGear4$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getHasGear4(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasLinkingCapability var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static FilterTrigger access$getTrigger$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getTrigger(var0);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasLinkingCapability var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static UiAutoMode access$getUiAutoMode$jd(HasLinkingCapability var0) {
      return HasFanSpeed$_CC.$default$getUiAutoMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasLinkingCapability var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isLinked$jd(HasLinkingCapability var0) {
      return $default$isLinked(var0);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasLinkingCapability var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasLinkingCapability var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasLinkingCapability var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
