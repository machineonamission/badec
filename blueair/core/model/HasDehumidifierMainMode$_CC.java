package com.blueair.core.model;

import android.content.Context;
import java.util.Iterator;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class HasDehumidifierMainMode$_CC {
   public static DehSubMode $default$dehSubMode(HasDehumidifierMainMode var0) {
      Iterator var2 = ((Iterable)DehSubMode.getEntries()).iterator();

      while(true) {
         if (var2.hasNext()) {
            Object var1 = var2.next();
            if (((DehSubMode)var1).getValue() != var0.getDehSubMode()) {
               continue;
            }

            var3 = var1;
            break;
         }

         var3 = null;
         break;
      }

      DehSubMode var4 = (DehSubMode)var3;
      return var4 == null ? DehSubMode.AUTO : var4;
   }

   public static boolean $default$isInDehSubMode(HasDehumidifierMainMode var0, DehSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "subMode");
      return var0.getDehSubMode() == var1.getValue();
   }

   // $FF: synthetic method
   public static ApSubMode access$apSubMode$jd(HasDehumidifierMainMode var0) {
      return HasMainMode$_CC.$default$apSubMode(var0);
   }

   // $FF: synthetic method
   public static DehSubMode access$dehSubMode$jd(HasDehumidifierMainMode var0) {
      return $default$dehSubMode(var0);
   }

   // $FF: synthetic method
   public static ConnectivityStatus access$getConnectivityStatus$jd(HasDehumidifierMainMode var0) {
      return Device$_CC.$default$getConnectivityStatus(var0);
   }

   // $FF: synthetic method
   public static TimeZone access$getTimezone$jd(HasDehumidifierMainMode var0, Context var1) {
      return Device$_CC.$default$getTimezone(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceType access$getType$jd(HasDehumidifierMainMode var0) {
      return Device$_CC.$default$getType(var0);
   }

   // $FF: synthetic method
   public static boolean access$isCnDevice$jd(HasDehumidifierMainMode var0) {
      return Device$_CC.$default$isCnDevice(var0);
   }

   // $FF: synthetic method
   public static boolean access$isInApSubMode$jd(HasDehumidifierMainMode var0, ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInDehSubMode$jd(HasDehumidifierMainMode var0, DehSubMode var1) {
      return $default$isInDehSubMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isInMainMode$jd(HasDehumidifierMainMode var0, MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(var0, var1);
   }

   // $FF: synthetic method
   public static boolean access$isOnline$jd(HasDehumidifierMainMode var0) {
      return Device$_CC.$default$isOnline(var0);
   }

   // $FF: synthetic method
   public static boolean access$isUsDevice$jd(HasDehumidifierMainMode var0) {
      return Device$_CC.$default$isUsDevice(var0);
   }

   // $FF: synthetic method
   public static MainMode access$mainMode$jd(HasDehumidifierMainMode var0) {
      return HasMainMode$_CC.$default$mainMode(var0);
   }

   // $FF: synthetic method
   public static boolean access$supportResetFilterOnline$jd(HasDehumidifierMainMode var0) {
      return Device$_CC.$default$supportResetFilterOnline(var0);
   }
}
