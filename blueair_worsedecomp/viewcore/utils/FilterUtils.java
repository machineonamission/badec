package com.blueair.viewcore.utils;

import android.content.Context;
import com.blueair.core.R;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceB4;
import com.blueair.core.model.DeviceB4sp;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceSense;
import com.blueair.core.model.Filter;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.push.NotificationService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0016H\u0002¨\u0006\u001a"}, d2 = {"Lcom/blueair/viewcore/utils/FilterUtils;", "", "<init>", "()V", "filterName", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "isDualProtectionRegion", "", "filterImageRes", "", "legacyFilterImageRes", "filter", "Lcom/blueair/core/model/Filter;", "legacyFilterName", "deviceClassicSmokeStopFilterImageRes", "deviceClassicParticleFilterImageRes", "isDualProtection", "g4FilterImageRes", "Lcom/blueair/core/model/DeviceG4;", "g4FilterName", "g4plusFilterImageRes", "g4plusFilterName", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterUtils.kt */
public final class FilterUtils {
    public static final FilterUtils INSTANCE = new FilterUtils();

    private FilterUtils() {
    }

    public final String filterName(Context context, Device device, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof DeviceG4) {
            return g4FilterName(context, (DeviceG4) device);
        }
        if ((device instanceof DeviceB4) || (device instanceof DeviceB4sp)) {
            return "ComboFilter";
        }
        if (device instanceof HasFanSpeed) {
            return legacyFilterName(context, device, ((HasFanSpeed) device).getFilter(), z);
        }
        return "Unknown Filter";
    }

    public final int filterImageRes(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof DeviceG4) {
            return g4FilterImageRes((DeviceG4) device);
        }
        if ((device instanceof DeviceB4) || (device instanceof DeviceB4sp)) {
            return R.drawable.filter_b4;
        }
        if (device instanceof HasFanSpeed) {
            return legacyFilterImageRes(device, ((HasFanSpeed) device).getFilter(), z);
        }
        return 0;
    }

    public final int legacyFilterImageRes(Device device, Filter filter, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(filter, NotificationService.ACTION_TYPE_FILTER);
        if (Intrinsics.areEqual((Object) filter, (Object) Filter.SmokeStopFilter.INSTANCE)) {
            if (isDualProtection(device, z)) {
                return com.blueair.viewcore.R.drawable.dual_protection_filter;
            }
            return deviceClassicSmokeStopFilterImageRes(device);
        } else if (!Intrinsics.areEqual((Object) filter, (Object) Filter.ParticleFilter.INSTANCE) && !Intrinsics.areEqual((Object) filter, (Object) Filter.UnknownFilter.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else if (device instanceof DeviceSense) {
            return com.blueair.viewcore.R.drawable.particle_filter;
        } else {
            return deviceClassicParticleFilterImageRes(device);
        }
    }

    public final String legacyFilterName(Context context, Device device, Filter filter, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(filter, NotificationService.ACTION_TYPE_FILTER);
        if (Intrinsics.areEqual((Object) filter, (Object) Filter.SmokeStopFilter.INSTANCE)) {
            if (isDualProtection(device, z)) {
                String string = context.getString(com.blueair.viewcore.R.string.filter_dual_protection);
                Intrinsics.checkNotNull(string);
                return string;
            }
            String string2 = context.getString(com.blueair.viewcore.R.string.filter_smokestop);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (Intrinsics.areEqual((Object) filter, (Object) Filter.ParticleFilter.INSTANCE)) {
            String string3 = context.getString(com.blueair.viewcore.R.string.filter_particle);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (Intrinsics.areEqual((Object) filter, (Object) Filter.UnknownFilter.INSTANCE)) {
            String string4 = context.getString(com.blueair.viewcore.R.string.filter_unknown);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final int deviceClassicSmokeStopFilterImageRes(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Timber.Forest forest = Timber.Forest;
        forest.d("device classic modelName: " + device.getModelName(), new Object[0]);
        CharSequence modelName = device.getModelName();
        if (StringsKt.contains$default(modelName, (CharSequence) "20", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "290", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "280", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "260", false, 2, (Object) null)) {
            return com.blueair.viewcore.R.drawable.smokestop_200;
        }
        if (StringsKt.contains$default(modelName, (CharSequence) "405", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "460", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "480", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "490", false, 2, (Object) null)) {
            return com.blueair.viewcore.R.drawable.smokestop_400;
        }
        return com.blueair.viewcore.R.drawable.smokestop_500_600;
    }

    public final int deviceClassicParticleFilterImageRes(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Timber.Forest forest = Timber.Forest;
        forest.d("device classic modelName: " + device.getModelName(), new Object[0]);
        CharSequence modelName = device.getModelName();
        if (StringsKt.contains$default(modelName, (CharSequence) "20", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "290", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "280", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "260", false, 2, (Object) null)) {
            return com.blueair.viewcore.R.drawable.particle_500_600;
        }
        if (StringsKt.contains$default(modelName, (CharSequence) "405", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "460", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "480", false, 2, (Object) null) || StringsKt.contains$default(modelName, (CharSequence) "490", false, 2, (Object) null)) {
            return com.blueair.viewcore.R.drawable.particle_400;
        }
        return com.blueair.viewcore.R.drawable.particle_500_600;
    }

    private final boolean isDualProtection(Device device, boolean z) {
        return z && (device instanceof DeviceClassic ? ((DeviceClassic) device).getHasNewSensors() : false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r2.equals("106956") != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r2.equals("106861") == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r2.equals("106860") == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        return com.blueair.viewcore.R.drawable.smart_filter_ultra_f_plus;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r2.equals("107389") == false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g4FilterImageRes(com.blueair.core.model.DeviceG4 r2) {
        /*
            r1 = this;
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r2.isPlus()
            if (r0 == 0) goto L_0x0010
            int r2 = r1.g4plusFilterImageRes(r2)
            return r2
        L_0x0010:
            java.lang.String r2 = r2.getSku()
            if (r2 == 0) goto L_0x0045
            int r0 = r2.hashCode()
            switch(r0) {
                case 1448821659: goto L_0x0039;
                case 1448821660: goto L_0x0030;
                case 1448822595: goto L_0x0027;
                case 1448846716: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0045
        L_0x001e:
            java.lang.String r0 = "107389"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0042
            goto L_0x0045
        L_0x0027:
            java.lang.String r0 = "106956"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0045
            goto L_0x0042
        L_0x0030:
            java.lang.String r0 = "106861"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0042
            goto L_0x0045
        L_0x0039:
            java.lang.String r0 = "106860"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            int r2 = com.blueair.viewcore.R.drawable.smart_filter_ultra_f_plus
            return r2
        L_0x0045:
            int r2 = com.blueair.core.R.drawable.filter_g4_smart
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.utils.FilterUtils.g4FilterImageRes(com.blueair.core.model.DeviceG4):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r3.equals("106956") != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r3.equals("106861") == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r3.equals("106860") == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        r3 = com.blueair.viewcore.R.string.g4_smart_filter_ultra_f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.equals("107389") == false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String g4FilterName(android.content.Context r2, com.blueair.core.model.DeviceG4 r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "device"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3.isPlus()
            if (r0 == 0) goto L_0x0015
            java.lang.String r2 = r1.g4plusFilterName(r2, r3)
            return r2
        L_0x0015:
            java.lang.String r3 = r3.getSku()
            if (r3 == 0) goto L_0x004a
            int r0 = r3.hashCode()
            switch(r0) {
                case 1448821659: goto L_0x003e;
                case 1448821660: goto L_0x0035;
                case 1448822595: goto L_0x002c;
                case 1448846716: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x004a
        L_0x0023:
            java.lang.String r0 = "107389"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0047
            goto L_0x004a
        L_0x002c:
            java.lang.String r0 = "106956"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004a
            goto L_0x0047
        L_0x0035:
            java.lang.String r0 = "106861"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0047
            goto L_0x004a
        L_0x003e:
            java.lang.String r0 = "106860"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0047
            goto L_0x004a
        L_0x0047:
            int r3 = com.blueair.viewcore.R.string.g4_smart_filter_ultra_f
            goto L_0x004c
        L_0x004a:
            int r3 = com.blueair.viewcore.R.string.g4_smart_filter
        L_0x004c:
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.utils.FilterUtils.g4FilterName(android.content.Context, com.blueair.core.model.DeviceG4):java.lang.String");
    }

    private final int g4plusFilterImageRes(DeviceG4 deviceG4) {
        String modelSeries = deviceG4.getModelSeries();
        int hashCode = modelSeries.hashCode();
        if (hashCode != 1788) {
            if (hashCode != 1790) {
                if (hashCode == 1792 && modelSeries.equals("88")) {
                    return com.blueair.viewcore.R.drawable.smart_filter_ultra_8800;
                }
            } else if (modelSeries.equals("86")) {
                return com.blueair.viewcore.R.drawable.smart_filter_8600;
            }
        } else if (modelSeries.equals("84")) {
            return com.blueair.viewcore.R.drawable.smart_filter_8400;
        }
        return R.drawable.filter_g4_smart;
    }

    private final String g4plusFilterName(Context context, DeviceG4 deviceG4) {
        int i;
        String modelSeries = deviceG4.getModelSeries();
        int hashCode = modelSeries.hashCode();
        if (hashCode != 1788) {
            if (hashCode != 1790) {
                if (hashCode == 1792 && modelSeries.equals("88")) {
                    i = com.blueair.viewcore.R.string.g4plus_8800_series_filter;
                    String string = context.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            } else if (modelSeries.equals("86")) {
                i = com.blueair.viewcore.R.string.g4plus_8600_series_filter;
                String string2 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
        } else if (modelSeries.equals("84")) {
            i = com.blueair.viewcore.R.string.g4plus_8400_series_filter;
            String string22 = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
            return string22;
        }
        i = com.blueair.viewcore.R.string.g4plus_unknown_series_filter;
        String string222 = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string222, "getString(...)");
        return string222;
    }
}
