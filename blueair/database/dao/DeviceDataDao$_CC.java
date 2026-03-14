package com.blueair.database.dao;

import com.blueair.database.entity.DeviceDataEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

// $FF: synthetic class
public final class DeviceDataDao$_CC {
   public static void $default$insertAllAndDeletePrevious(DeviceDataDao var0, String var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "deviceData");
      Iterator var12 = ((Iterable)var2).iterator();
      Object var9;
      if (!var12.hasNext()) {
         var9 = null;
      } else {
         var9 = var12.next();
         if (var12.hasNext()) {
            long var5 = ((DeviceDataEntity)var9).getTime();
            Object var10 = var9;

            do {
               Object var11 = var12.next();
               long var7 = ((DeviceDataEntity)var11).getTime();
               var9 = var10;
               long var3 = var5;
               if (var5 < var7) {
                  var9 = var11;
                  var3 = var7;
               }

               var10 = var9;
               var5 = var3;
            } while(var12.hasNext());
         }
      }

      DeviceDataEntity var13 = (DeviceDataEntity)var9;
      if (var13 != null) {
         var0.deleteOldDeviceData(var1, var13.getTime());
      }

      var0.insertAll(var2);
   }

   public static void $default$insertAllAndReplace(DeviceDataDao var0, String var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "deviceData");
      Iterable var13 = (Iterable)var2;
      Iterator var14 = var13.iterator();
      boolean var9 = var14.hasNext();
      Object var12 = null;
      Object var10;
      if (!var9) {
         var10 = null;
      } else {
         var10 = var14.next();
         if (var14.hasNext()) {
            long var5 = ((DeviceDataEntity)var10).getTime();

            while(true) {
               Object var11 = var14.next();
               long var7 = ((DeviceDataEntity)var11).getTime();
               long var3 = var5;
               if (var5 < var7) {
                  var10 = var11;
                  var3 = var7;
               }

               if (!var14.hasNext()) {
                  break;
               }

               var5 = var3;
            }
         }
      }

      DeviceDataEntity var18 = (DeviceDataEntity)var10;
      Long var21;
      if (var18 != null) {
         var21 = var18.getTime();
      } else {
         var21 = null;
      }

      var14 = var13.iterator();
      if (!var14.hasNext()) {
         var18 = null;
      } else {
         var18 = (DeviceDataEntity)var14.next();
         if (var14.hasNext()) {
            long var16 = ((DeviceDataEntity)var18).getTime();

            while(true) {
               Object var22 = var14.next();
               long var17 = ((DeviceDataEntity)var22).getTime();
               long var15 = var16;
               if (var16 > var17) {
                  var18 = (DeviceDataEntity)var22;
                  var15 = var17;
               }

               if (!var14.hasNext()) {
                  break;
               }

               var16 = var15;
            }
         }
      }

      DeviceDataEntity var23 = var18;
      Long var20 = (Long)var12;
      if (var23 != null) {
         var20 = var23.getTime();
      }

      if (var21 != null && var20 != null) {
         var0.deleteDeviceDataInInclusiveRange(var1, var20, var21);
      }

      var0.insertAll(var2);
   }

   // $FF: synthetic method
   public static void access$insertAllAndDeletePrevious$jd(DeviceDataDao var0, String var1, List var2) {
      $default$insertAllAndDeletePrevious(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void access$insertAllAndReplace$jd(DeviceDataDao var0, String var1, List var2) {
      $default$insertAllAndReplace(var0, var1, var2);
   }
}
