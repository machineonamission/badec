package com.blueair.core.util;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/core/util/PhoneUtil;", "", "<init>", "()V", "isGoogleServicesAvailable", "", "context", "Landroid/content/Context;", "isHuaweiServicesAvailable", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PhoneUtil.kt */
public final class PhoneUtil {
    public static final PhoneUtil INSTANCE = new PhoneUtil();

    public final boolean isHuaweiServicesAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }

    private PhoneUtil() {
    }

    public final boolean isGoogleServicesAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        return instance.isGooglePlayServicesAvailable(context) == 0;
    }
}
