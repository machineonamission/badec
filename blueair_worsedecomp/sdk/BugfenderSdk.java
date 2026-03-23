package com.blueair.sdk;

import android.app.Application;
import com.bugfender.sdk.Bugfender;
import com.bugfender.sdk.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J8\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f¨\u0006\u0014"}, d2 = {"Lcom/blueair/sdk/BugfenderSdk;", "", "<init>", "()V", "init", "", "application", "Landroid/app/Application;", "log", "lineNumber", "", "methodName", "", "fileName", "priority", "tag", "message", "setDeviceString", "key", "value", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BugfenderSdk.kt */
public final class BugfenderSdk {
    public static final BugfenderSdk INSTANCE = new BugfenderSdk();

    private BugfenderSdk() {
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Bugfender.init(application, "ws5C2NZjocSqhaKJSq1vbXJ8CAlJzUi4", true);
        Bugfender.enableCrashReporting();
    }

    public final void log(int i, String str, String str2, int i2, String str3, String str4) {
        LogLevel logLevel;
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(str2, "fileName");
        Intrinsics.checkNotNullParameter(str4, "message");
        if (i2 == 2) {
            logLevel = LogLevel.Trace;
        } else if (i2 == 3) {
            logLevel = LogLevel.Debug;
        } else if (i2 == 4) {
            logLevel = LogLevel.Info;
        } else if (i2 == 6) {
            logLevel = LogLevel.Error;
        } else if (i2 != 7) {
            logLevel = LogLevel.Warning;
        } else {
            logLevel = LogLevel.Fatal;
        }
        Bugfender.log(i, str, str2, logLevel, str3, str4);
    }

    public final void setDeviceString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Bugfender.setDeviceString(str, str2);
    }
}
