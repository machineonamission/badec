package com.blueair.devicedetails.util;

import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/util/DeviceScheduleUtils;", "", "<init>", "()V", "testOverlapOfSchedules", "", "startTime", "Ljava/util/Calendar;", "endTime", "repeat", "", "Lcom/blueair/core/model/DayOfWeek;", "state", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "editingSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "allSchedules", "", "convertCalendarTimeToMinutes", "", "time", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleUtils {
   public static final DeviceScheduleUtils INSTANCE = new DeviceScheduleUtils();

   private DeviceScheduleUtils() {
   }

   // $FF: synthetic method
   public static boolean testOverlapOfSchedules$default(DeviceScheduleUtils var0, Calendar var1, Calendar var2, Set var3, DeviceCreateEditScheduleViewModel.State var4, DeviceScheduleMerged var5, List var6, int var7, Object var8) {
      if ((var7 & 16) != 0) {
         var5 = null;
      }

      return var0.testOverlapOfSchedules(var1, var2, var3, var4, var5, var6);
   }

   public final int convertCalendarTimeToMinutes(Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "time");
      return var1.get(11) * 60 + var1.get(12);
   }

   public final boolean testOverlapOfSchedules(Calendar var1, Calendar var2, Set var3, DeviceCreateEditScheduleViewModel.State var4, DeviceScheduleMerged var5, List var6) {
      Intrinsics.checkNotNullParameter(var1, "startTime");
      Intrinsics.checkNotNullParameter(var2, "endTime");
      Intrinsics.checkNotNullParameter(var3, "repeat");
      Intrinsics.checkNotNullParameter(var4, "state");
      Intrinsics.checkNotNullParameter(var6, "allSchedules");

      for(DayOfWeek var17 : (Iterable)var3) {
         int var7 = var17.getCompareValue();
         int var8 = 1440;
         int var10 = var7 * 1440;
         int var9 = 11;
         var7 = var1.get(11) * 60 + var1.get(12);
         int var12 = var2.get(11) * 60 + var2.get(12);
         int var11 = var7 + var10;
         if (var12 < var7) {
            var7 = 1440;
         } else {
            var7 = 0;
         }

         var12 = var10 + var12 + var7;
         Iterator var14 = var6.iterator();
         var7 = var9;

         while(var14.hasNext()) {
            DeviceScheduleMerged var18 = (DeviceScheduleMerged)var14.next();
            if (var4 != DeviceCreateEditScheduleViewModel.State.MODIFY || var5 == null || !var18.isSameMergedSchedules(var5)) {
               Calendar var20 = var18.timeToCalendar(var18.getStartTime());
               Calendar var16 = var18.timeToCalendar(var18.getEndTime());
               var9 = (short)var8;
               var10 = var7;
               if (var20 != null) {
                  var9 = (short)var8;
                  var10 = var7;
                  if (var16 != null) {
                     Iterator var19 = var18.getDaysOfWeek().iterator();

                     while(true) {
                        var9 = (short)var8;
                        var10 = var7;
                        if (!var19.hasNext()) {
                           break;
                        }

                        DayOfWeek var36 = (DayOfWeek)var19.next();
                        var9 = var36.getCompareValue() * var8;
                        int var13 = var20.get(var7) * 60 + var20.get(12);
                        var10 = var16.get(var7) * 60 + var16.get(12);
                        var8 = var13 + var9;
                        if (var10 < var13) {
                           var7 = 1440;
                        } else {
                           var7 = 0;
                        }

                        var7 = var10 + var9 + var7;
                        if (var11 <= var7 && var7 <= var12 || var11 <= var8 && var8 <= var12 || var8 <= var12 && var12 <= var7 || var8 <= var11 && var11 <= var7) {
                           return true;
                        }

                        if (var17 == DayOfWeek.SAT && var36 == DayOfWeek.SUN) {
                           var9 = var8 + 10080;
                           var10 = var7 + 10080;
                           if (var11 <= var10 && var10 <= var12 || var11 <= var9 && var9 <= var12 || var9 <= var12 && var12 <= var10 || var9 <= var11 && var11 <= var10) {
                              return true;
                           }
                        }

                        if (var17 == DayOfWeek.SUN && var36 == DayOfWeek.SAT) {
                           var10 = var11 + 10080;
                           var9 = var12 + 10080;
                           if (var10 <= var7 && var7 <= var9 || var10 <= var8 && var8 <= var9 || var8 <= var9 && var9 <= var7 || var8 <= var10 && var10 <= var7) {
                              return true;
                           }
                        }

                        var8 = 1440;
                        var7 = 11;
                     }
                  }
               }

               var8 = var9;
               var7 = var10;
            }
         }
      }

      return false;
   }
}
