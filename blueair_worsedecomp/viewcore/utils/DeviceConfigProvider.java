package com.blueair.viewcore.utils;

import android.content.Context;
import com.blueair.auth.LocationService;
import com.blueair.core.R;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceConfig;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasCompatibility;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.blueair.core.model.UserManual;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.WebViewActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\nJ\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\u001e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u0017\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0013\u001a\u00020\nJ\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010\u0013\u001a\u00020\nJ\u0012\u0010/\u001a\u0004\u0018\u00010\n2\b\u0010-\u001a\u0004\u0018\u000100J\u0012\u00101\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u000103R \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058\u0006@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u00064"}, d2 = {"Lcom/blueair/viewcore/utils/DeviceConfigProvider;", "", "<init>", "()V", "value", "Lcom/blueair/auth/LocationService;", "locationService", "getLocationService", "()Lcom/blueair/auth/LocationService;", "ip", "", "getIp", "()Ljava/lang/String;", "init", "", "getDeviceConfig", "Lcom/blueair/core/model/DeviceConfig;", "device", "Lcom/blueair/core/model/Device;", "sku", "getDeviceImage", "Lcom/blueair/core/model/DeviceImage;", "Lcom/blueair/core/model/BluetoothDevice;", "getFilterConfig", "Lcom/blueair/core/model/FilterConfig;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "hasBuyFilterLink", "", "filterConfig", "openFilterUrl", "context", "Landroid/content/Context;", "url", "title", "getFilterLifeLeftPercentage", "", "(Lcom/blueair/core/model/Device;)Ljava/lang/Integer;", "getFilterStatusColor", "filterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "getWickStatusColor", "wickLifeLeft", "getUserManual", "Lcom/blueair/core/model/UserManual;", "config", "getRefresherManual", "getIpConfigValue", "Lcom/blueair/core/model/IpConfig;", "getAwsLinkValue", "link", "Lcom/blueair/core/model/AwsLinkConfig;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceConfigProvider.kt */
public final class DeviceConfigProvider {
    public static final DeviceConfigProvider INSTANCE = new DeviceConfigProvider();
    private static LocationService locationService;

    private DeviceConfigProvider() {
    }

    public final LocationService getLocationService() {
        LocationService locationService2 = locationService;
        if (locationService2 != null) {
            return locationService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationService");
        return null;
    }

    public final String getIp() {
        return getLocationService().getCountry();
    }

    public final void init(LocationService locationService2) {
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        locationService = locationService2;
    }

    public final DeviceConfig getDeviceConfig(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return getDeviceConfig(DeviceKt.getSkuCompat(device));
    }

    public final DeviceConfig getDeviceConfig(String str) {
        return SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(str);
    }

    public final DeviceImage getDeviceImage(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        return getDeviceImage(bluetoothDevice.getSku());
    }

    public final DeviceImage getDeviceImage(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        String skuCompat = DeviceKt.getSkuCompat(device);
        if (skuCompat == null) {
            return null;
        }
        return getDeviceImage(skuCompat);
    }

    public final DeviceImage getDeviceImage(String str) {
        DeviceImage image;
        Intrinsics.checkNotNullParameter(str, "sku");
        DeviceConfig deviceConfig = getDeviceConfig(str);
        if (deviceConfig != null && (image = deviceConfig.getImage()) != null) {
            return image;
        }
        DeviceType fromSkuCompat = DeviceType.Companion.fromSkuCompat(str);
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Aware.INSTANCE)) {
            return DeviceImage.AWARE;
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Classic.INSTANCE) || Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.ClassicWithoutSensor.INSTANCE)) {
            return DeviceImage.CLASSIC;
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Sense.INSTANCE)) {
            return DeviceImage.SENSE;
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.Icp.INSTANCE)) {
            return DeviceImage.ICP;
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.B4.INSTANCE) || Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.B4sp.INSTANCE)) {
            return DeviceImage.B4;
        }
        if (Intrinsics.areEqual((Object) fromSkuCompat, (Object) DeviceType.G4.INSTANCE)) {
            return DeviceType.Companion.getG4Plus_SKU().contains(str) ? DeviceImage.G4_PLUS : DeviceImage.G4;
        }
        return null;
    }

    public static /* synthetic */ FilterConfig getFilterConfig$default(DeviceConfigProvider deviceConfigProvider, Device device, DeviceFilterType deviceFilterType, int i, Object obj) {
        if ((i & 2) != 0) {
            deviceFilterType = null;
        }
        return deviceConfigProvider.getFilterConfig(device, deviceFilterType);
    }

    public final FilterConfig getFilterConfig(Device device, DeviceFilterType deviceFilterType) {
        Intrinsics.checkNotNullParameter(device, "device");
        String skuCompat = DeviceKt.getSkuCompat(device);
        if (skuCompat == null) {
            return null;
        }
        return getFilterConfig(skuCompat, deviceFilterType, device);
    }

    public static /* synthetic */ FilterConfig getFilterConfig$default(DeviceConfigProvider deviceConfigProvider, String str, DeviceFilterType deviceFilterType, int i, Object obj) {
        if ((i & 2) != 0) {
            deviceFilterType = null;
        }
        return deviceConfigProvider.getFilterConfig(str, deviceFilterType);
    }

    public final FilterConfig getFilterConfig(String str, DeviceFilterType deviceFilterType) {
        Intrinsics.checkNotNullParameter(str, "sku");
        return getFilterConfig(str, deviceFilterType, (Device) null);
    }

    private final FilterConfig getFilterConfig(String str, DeviceFilterType deviceFilterType, Device device) {
        int i;
        List<FilterInfo> filters;
        FilterInfo filterInfo;
        List<FilterInfo> filters2;
        FilterInfo filterInfo2;
        DeviceFilterType deviceFilterType2 = deviceFilterType;
        Device device2 = device;
        DeviceConfig deviceConfig = getDeviceConfig(str);
        AwsLinkConfig awsLinkConfig = null;
        FilterConfig filter = deviceConfig != null ? deviceConfig.getFilter() : null;
        if (filter == null || (device2 instanceof HasCompatibility)) {
            if (deviceFilterType2 != DeviceFilterType.FILTER || device2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FilterInfo(DeviceFilterType.FILTER, new I18nConfig(FilterUtils.INSTANCE.filterName(getLocationService().getContext(), device2, getLocationService().isInDualProtectionRegion()), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null), FilterUtils.INSTANCE.filterImageRes(device2, getLocationService().isInDualProtectionRegion()), 0, (I18nConfig) null, (filter == null || (filters2 = filter.getFilters()) == null || (filterInfo2 = (FilterInfo) CollectionsKt.firstOrNull(filters2)) == null) ? null : filterInfo2.getLinkSubscribe(), (filter == null || (filters = filter.getFilters()) == null || (filterInfo = (FilterInfo) CollectionsKt.firstOrNull(filters)) == null) ? null : filterInfo.getLinkPurchase()));
            if (Intrinsics.areEqual((!(device2 instanceof DeviceG4) || ((DeviceG4) device2).isPlus()) ? null : "v_g4", (Object) "v_g4")) {
                AwsLinkConfig awsLinkConfig2 = new AwsLinkConfig(new I18nConfig("http://appres.blueair.cn/filter_video/g4_filter_en.mp4", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null), new I18nConfig("http://prod.blueair-static-resources.s3-website.eu-central-1.amazonaws.com/filter_video/g4_filter_en.mp4", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null), (I18nConfig) null);
                i = R.drawable.vt_g4;
                awsLinkConfig = awsLinkConfig2;
            } else {
                i = 0;
            }
            return new FilterConfig(awsLinkConfig, i, arrayList);
        } else if (deviceFilterType2 == null) {
            return filter;
        } else {
            Collection arrayList2 = new ArrayList();
            for (Object next : filter.getFilters()) {
                if (((FilterInfo) next).getType() == deviceFilterType2) {
                    arrayList2.add(next);
                }
            }
            return FilterConfig.copy$default(filter, (AwsLinkConfig) null, 0, (List) arrayList2, 3, (Object) null);
        }
    }

    public final boolean hasBuyFilterLink(FilterConfig filterConfig) {
        List<FilterInfo> filters;
        if (!(filterConfig == null || (filters = filterConfig.getFilters()) == null)) {
            Iterable<FilterInfo> iterable = filters;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                for (FilterInfo filterInfo : iterable) {
                    DeviceConfigProvider deviceConfigProvider = INSTANCE;
                    CharSequence ipConfigValue = deviceConfigProvider.getIpConfigValue(filterInfo.getLinkPurchase());
                    if (ipConfigValue != null && ipConfigValue.length() != 0) {
                        return true;
                    }
                    CharSequence ipConfigValue2 = deviceConfigProvider.getIpConfigValue(filterInfo.getLinkSubscribe());
                    if (ipConfigValue2 != null && ipConfigValue2.length() != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void openFilterUrl(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        if (StringsKt.startsWith$default(str, "https://item.jd.com", false, 2, (Object) null)) {
            try {
                context.startActivity(Actions.INSTANCE.openJdMallIntent(str));
            } catch (Throwable unused) {
                context.startActivity(Actions.INSTANCE.openBrowserIntent(str));
            }
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "youzan.com", false, 2, (Object) null)) {
            context.startActivity(Actions.INSTANCE.openBrowserIntent(str));
        } else {
            WebViewActivity.Companion.launch(context, AnalyticEvent.ScreenViewEvent.DEVICE_FILTER_BUY_WEB, str2, str);
        }
    }

    public final Integer getFilterLifeLeftPercentage(Device device) {
        FilterLifeTime filterLifeTime = device != null ? DeviceKt.getFilterLifeTime(device) : null;
        if (filterLifeTime instanceof FilterLifeTime.FilterPercentageLeft) {
            return Integer.valueOf(((FilterLifeTime.FilterPercentageLeft) filterLifeTime).getFilterLife());
        }
        if (filterLifeTime instanceof FilterLifeTime.FilterDaysLeft) {
            return ((FilterLifeTime.FilterDaysLeft) filterLifeTime).getFilterLifePercentage();
        }
        return null;
    }

    public final int getFilterStatusColor(FilterLifeTime filterLifeTime) {
        int i;
        Intrinsics.checkNotNullParameter(filterLifeTime, "filterLifeTime");
        if (filterLifeTime instanceof FilterLifeTime.FilterPercentageLeft) {
            int filterLife = ((FilterLifeTime.FilterPercentageLeft) filterLifeTime).getFilterLife();
            if (11 <= filterLife && filterLife <= Integer.MAX_VALUE) {
                i = com.blueair.viewcore.R.color.aquamarine;
            } else if (1 > filterLife || filterLife >= 11) {
                i = com.blueair.viewcore.R.color.warmpink;
            } else {
                i = com.blueair.viewcore.R.color.mustard_yellow;
            }
        } else if (filterLifeTime instanceof FilterLifeTime.FilterDaysLeft) {
            Integer filterLifePercentage = ((FilterLifeTime.FilterDaysLeft) filterLifeTime).getFilterLifePercentage();
            IntRange intRange = new IntRange(11, Integer.MAX_VALUE);
            if (filterLifePercentage == null || !intRange.contains(filterLifePercentage.intValue())) {
                IntRange intRange2 = new IntRange(1, 10);
                if (filterLifePercentage == null || !intRange2.contains(filterLifePercentage.intValue())) {
                    i = com.blueair.viewcore.R.color.warmpink;
                } else {
                    i = com.blueair.viewcore.R.color.mustard_yellow;
                }
            } else {
                i = com.blueair.viewcore.R.color.aquamarine;
            }
        } else if (filterLifeTime instanceof FilterLifeTime.NoFilterInfo) {
            i = com.blueair.viewcore.R.color.aquamarine;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return getLocationService().getContext().getColor(i);
    }

    public final int getWickStatusColor(int i) {
        int i2;
        if (i <= 0) {
            i2 = com.blueair.viewcore.R.color.warmpink;
        } else if (i < 11) {
            i2 = com.blueair.viewcore.R.color.mustard_yellow;
        } else {
            i2 = com.blueair.viewcore.R.color.aquamarine;
        }
        return getLocationService().getContext().getColor(i2);
    }

    public final UserManual getUserManual(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return getUserManual(getDeviceConfig(device));
    }

    public final UserManual getUserManual(String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        return getUserManual(getDeviceConfig(str));
    }

    private final UserManual getUserManual(DeviceConfig deviceConfig) {
        I18nConfig manual;
        String value$default;
        if (deviceConfig == null || (manual = deviceConfig.getManual()) == null || (value$default = I18nConfig.getValue$default(manual, (Locale) null, 1, (Object) null)) == null) {
            return null;
        }
        return new UserManual(value$default);
    }

    public final UserManual getRefresherManual(String str) {
        FilterConfig filter;
        List<FilterInfo> filters;
        Object obj;
        I18nConfig manual;
        String value$default;
        Intrinsics.checkNotNullParameter(str, "sku");
        DeviceConfig deviceConfig = getDeviceConfig(str);
        if (deviceConfig == null || (filter = deviceConfig.getFilter()) == null || (filters = filter.getFilters()) == null) {
            return null;
        }
        Iterator it = filters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            FilterInfo filterInfo = (FilterInfo) obj;
            if (filterInfo.getType() == DeviceFilterType.REFRESHER && filterInfo.getManual() != null) {
                break;
            }
        }
        FilterInfo filterInfo2 = (FilterInfo) obj;
        if (filterInfo2 == null || (manual = filterInfo2.getManual()) == null || (value$default = I18nConfig.getValue$default(manual, (Locale) null, 1, (Object) null)) == null) {
            return null;
        }
        return new UserManual(value$default);
    }

    public final String getIpConfigValue(IpConfig ipConfig) {
        if (ipConfig != null) {
            return ipConfig.getValue(getIp());
        }
        return null;
    }

    public final String getAwsLinkValue(AwsLinkConfig awsLinkConfig) {
        if (awsLinkConfig != null) {
            return AwsLinkConfig.getValue$default(awsLinkConfig, getLocationService().getCloudRegion(), (Locale) null, 2, (Object) null);
        }
        return null;
    }
}
