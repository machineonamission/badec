package com.blueair.core.util;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lcom/blueair/core/util/LocaleUtils;", "", "<init>", "()V", "getLocale", "Ljava/util/Locale;", "context", "Landroid/content/Context;", "isUsLocale", "", "getCountryLocale", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocaleUtils.kt */
public final class LocaleUtils {
    public static final LocaleUtils INSTANCE = new LocaleUtils();

    private LocaleUtils() {
    }

    public final Locale getLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Locale locale = context.getResources().getConfiguration().locale;
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList m = context.getResources().getConfiguration().getLocales();
            Intrinsics.checkNotNullExpressionValue(m, "getLocales(...)");
            if (m.size() > 0) {
                locale = m.get(0);
            }
            Intrinsics.checkNotNull(locale);
            return locale;
        }
        Intrinsics.checkNotNull(locale);
        return locale;
    }

    public final boolean isUsLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual((Object) getLocale(context), (Object) Locale.US);
    }

    public final String getCountryLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return StringUtils.INSTANCE.nullSafeToLowerCase(getLocale(context).getCountry());
    }
}
