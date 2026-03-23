package com.blueair.viewcore.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/viewcore/utils/ActivityUtils;", "", "<init>", "()V", "isActivityInStack", "", "context", "Landroid/content/Context;", "activity", "Ljava/lang/Class;", "Landroid/app/Activity;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ActivityUtils.kt */
public final class ActivityUtils {
    public static final ActivityUtils INSTANCE = new ActivityUtils();

    private ActivityUtils() {
    }

    public final boolean isActivityInStack(Context context, Class<? extends Activity> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "activity");
        ComponentName resolveActivity = new Intent(context, cls).resolveActivity(context.getPackageManager());
        if (resolveActivity == null) {
            return false;
        }
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(10);
        Intrinsics.checkNotNull(runningTasks);
        Iterable<ActivityManager.RunningTaskInfo> iterable = runningTasks;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (ActivityManager.RunningTaskInfo m : iterable) {
            if (Intrinsics.areEqual((Object) m.baseActivity, (Object) resolveActivity)) {
                return true;
            }
        }
        return false;
    }
}
