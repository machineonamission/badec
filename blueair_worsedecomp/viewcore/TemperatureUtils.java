package com.blueair.viewcore;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/viewcore/TemperatureUtils;", "", "<init>", "()V", "CELSIUS", "", "FAHRENHEIT", "getTemperature", "", "temperature", "getTempUnit", "context", "Landroid/content/Context;", "isCelsius", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TemperatureUtils.kt */
public final class TemperatureUtils {
    public static final String CELSIUS = "Celsius";
    public static final String FAHRENHEIT = "Fahrenheit";
    public static final TemperatureUtils INSTANCE = new TemperatureUtils();

    public final float getTemperature(float f) {
        return f;
    }

    private TemperatureUtils() {
    }

    public final String getTempUnit(Context context, boolean z) {
        Resources resources;
        Resources resources2;
        if (z) {
            if (context == null || (resources2 = context.getResources()) == null) {
                return null;
            }
            return resources2.getString(R.string.temperature_unit_c);
        } else if (context == null || (resources = context.getResources()) == null) {
            return null;
        } else {
            return resources.getString(R.string.temperature_unit_f);
        }
    }
}
