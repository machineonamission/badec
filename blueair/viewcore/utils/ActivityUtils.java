package com.blueair.viewcore.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t¨\u0006\u000b"},
   d2 = {"Lcom/blueair/viewcore/utils/ActivityUtils;", "", "<init>", "()V", "isActivityInStack", "", "context", "Landroid/content/Context;", "activity", "Ljava/lang/Class;", "Landroid/app/Activity;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ActivityUtils {
   public static final ActivityUtils INSTANCE = new ActivityUtils();

   private ActivityUtils() {
   }

   public final boolean isActivityInStack(Context var1, Class var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "activity");
      ComponentName var8 = (new Intent(var1, var2)).resolveActivity(var1.getPackageManager());
      if (var8 == null) {
         return false;
      } else {
         Object var3 = var1.getSystemService("activity");
         ActivityManager var4;
         if (var3 instanceof ActivityManager) {
            var4 = (ActivityManager)var3;
         } else {
            var4 = null;
         }

         if (var4 == null) {
            return false;
         } else {
            List var5 = var4.getRunningTasks(10);
            Intrinsics.checkNotNull(var5);
            Iterable var6 = (Iterable)var5;
            if (var6 instanceof Collection && ((Collection)var6).isEmpty()) {
               return false;
            } else {
               Iterator var7 = var6.iterator();

               while(var7.hasNext()) {
                  if (Intrinsics.areEqual(BlueairApp$$ExternalSyntheticApiModelOutline0.m((ActivityManager.RunningTaskInfo)var7.next()), var8)) {
                     return true;
                  }
               }

               return false;
            }
         }
      }
   }
}
