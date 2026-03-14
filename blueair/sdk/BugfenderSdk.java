package com.blueair.sdk;

import android.app.Application;
import android.content.Context;
import com.bugfender.sdk.Bugfender;
import com.bugfender.sdk.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J8\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f¨\u0006\u0014"},
   d2 = {"Lcom/blueair/sdk/BugfenderSdk;", "", "<init>", "()V", "init", "", "application", "Landroid/app/Application;", "log", "lineNumber", "", "methodName", "", "fileName", "priority", "tag", "message", "setDeviceString", "key", "value", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BugfenderSdk {
   public static final BugfenderSdk INSTANCE = new BugfenderSdk();

   private BugfenderSdk() {
   }

   public final void init(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      Bugfender.init((Context)var1, "ws5C2NZjocSqhaKJSq1vbXJ8CAlJzUi4", true);
      Bugfender.enableCrashReporting();
   }

   public final void log(int var1, String var2, String var3, int var4, String var5, String var6) {
      Intrinsics.checkNotNullParameter(var2, "methodName");
      Intrinsics.checkNotNullParameter(var3, "fileName");
      Intrinsics.checkNotNullParameter(var6, "message");
      LogLevel var7;
      if (var4 != 2) {
         if (var4 != 3) {
            if (var4 != 4) {
               if (var4 != 6) {
                  if (var4 != 7) {
                     var7 = LogLevel.Warning;
                  } else {
                     var7 = LogLevel.Fatal;
                  }
               } else {
                  var7 = LogLevel.Error;
               }
            } else {
               var7 = LogLevel.Info;
            }
         } else {
            var7 = LogLevel.Debug;
         }
      } else {
         var7 = LogLevel.Trace;
      }

      Bugfender.log(var1, var2, var3, var7, var5, var6);
   }

   public final void setDeviceString(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "key");
      Bugfender.setDeviceString(var1, var2);
   }
}
