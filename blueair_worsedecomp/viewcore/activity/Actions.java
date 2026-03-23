package com.blueair.viewcore.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.android.activity.InfoActivity;
import com.blueair.auth.LocationService;
import com.blueair.core.model.ChinaPrivacy;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.I18nConfig;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.viewcore.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010&\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005J\u0018\u0010'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u0005J\u0016\u0010+\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-J&\u0010.\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u000102J>\u00103\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020)2\b\b\u0002\u0010 \u001a\u00020\u0005J\u000e\u00109\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ)\u0010:\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/blueair/viewcore/activity/Actions;", "", "<init>", "()V", "EXTRA_DEVICE_ID", "", "EXTRA_DEVICE_SKU", "EXTRA_DEVICE", "SEARCH_MODE", "LOCATION_ID", "CURRENT_LOCATION", "EXTRA_SCHEDULE_MERGED", "EXTRA_ACTION_TYPE", "EXTRA_FILTER_TYPE", "EXTRA_NOTIFICATION_ID", "EXTRA_SCREEN_NAME", "EXTRA_VERSION", "EXTRA_TEXT", "EXTRA_LINK", "ACTION_DEVICE_STOP_ALARM", "MAP_IGNORE_LOCATION_ID", "ACTION_REGISTER", "openDialerIntent", "Landroid/content/Intent;", "tel", "openBrowserIntent", "url", "openJdMallIntent", "openHomeIntent", "context", "Landroid/content/Context;", "openNotificationIntent", "deviceId", "actionType", "stopAlarmIntent", "notificationId", "", "openAddDeviceIntent", "openDeviceDetailsIntent", "openWelcomeIntent", "clearTask", "", "openLoginIntent", "openChinaPrivacyPolicyIntent", "privacy", "Lcom/blueair/core/model/ChinaPrivacy;", "openAntiFakeScanIntent", "device", "Lcom/blueair/core/model/HasSKU;", "targetType", "Lcom/blueair/core/model/DeviceFilterType;", "openMapIntent", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "navigateToLocationId", "searchMode", "isCurrentLocation", "openTroubleShootIntent", "internalIntent", "action", "flags", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/Intent;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Actions.kt */
public final class Actions {
    public static final String ACTION_DEVICE_STOP_ALARM = "blueair.action.devicestopalarm";
    public static final String ACTION_REGISTER = "action_register";
    public static final String CURRENT_LOCATION = "current_location";
    public static final String EXTRA_ACTION_TYPE = "action_type";
    public static final String EXTRA_DEVICE = "device";
    public static final String EXTRA_DEVICE_ID = "device_id";
    public static final String EXTRA_DEVICE_SKU = "device_sku";
    public static final String EXTRA_FILTER_TYPE = "filter_type";
    public static final String EXTRA_LINK = "extra_link";
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";
    public static final String EXTRA_SCHEDULE_MERGED = "schedule_merged";
    public static final String EXTRA_SCREEN_NAME = "screen_name";
    public static final String EXTRA_TEXT = "extra_text";
    public static final String EXTRA_VERSION = "extra_version";
    public static final Actions INSTANCE = new Actions();
    public static final String LOCATION_ID = "location_id";
    public static final String MAP_IGNORE_LOCATION_ID = "";
    public static final String SEARCH_MODE = "search_mode";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Actions.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.auth.LocationService$MapType[] r0 = com.blueair.auth.LocationService.MapType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.auth.LocationService$MapType r1 = com.blueair.auth.LocationService.MapType.AMAP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.auth.LocationService$MapType r1 = com.blueair.auth.LocationService.MapType.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.auth.LocationService$MapType r1 = com.blueair.auth.LocationService.MapType.MAPBOX     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.activity.Actions.WhenMappings.<clinit>():void");
        }
    }

    private Actions() {
    }

    public final Intent openDialerIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "tel");
        return new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
    }

    public final Intent openBrowserIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    public final Intent openJdMallIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str)).setPackage("com.jingdong.app.mall");
        Intrinsics.checkNotNullExpressionValue(intent, "setPackage(...)");
        return intent;
    }

    public final Intent openHomeIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return internalIntent(context, "blueair.action.home", 603979776);
    }

    public final Intent openNotificationIntent(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        Intent internalIntent = internalIntent(context, "blueair.action.home", Integer.valueOf(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        internalIntent.putExtra("device_id", str);
        internalIntent.putExtra("action_type", str2);
        return internalIntent;
    }

    public final Intent stopAlarmIntent(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intent internalIntent$default = internalIntent$default(this, context, ACTION_DEVICE_STOP_ALARM, (Integer) null, 4, (Object) null);
        internalIntent$default.putExtra("device_id", str);
        internalIntent$default.putExtra(EXTRA_NOTIFICATION_ID, i);
        return internalIntent$default;
    }

    public final Intent openAddDeviceIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return internalIntent$default(this, context, "blueair.action.adddevice", (Integer) null, 4, (Object) null);
    }

    public final Intent openDeviceDetailsIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intent putExtra = internalIntent$default(this, context, "blueair.action.devicedetails", (Integer) null, 4, (Object) null).putExtra("device_id", str);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
        return putExtra;
    }

    public static /* synthetic */ Intent openWelcomeIntent$default(Actions actions, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return actions.openWelcomeIntent(context, z);
    }

    public final Intent openWelcomeIntent(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        return internalIntent(context, "blueair.action.welcome", z ? 268468224 : null);
    }

    public static /* synthetic */ Intent openLoginIntent$default(Actions actions, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return actions.openLoginIntent(context, str);
    }

    public final Intent openLoginIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        Intent internalIntent$default = internalIntent$default(this, context, "blueair.action.login", (Integer) null, 4, (Object) null);
        internalIntent$default.putExtra("action_type", str);
        return internalIntent$default;
    }

    public final Intent openChinaPrivacyPolicyIntent(Context context, ChinaPrivacy chinaPrivacy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chinaPrivacy, ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
        Intent internalIntent$default = internalIntent$default(this, context, "blueair.action.chinaprivacypolicy", (Integer) null, 4, (Object) null);
        internalIntent$default.putExtra(EXTRA_VERSION, chinaPrivacy.getVersion());
        internalIntent$default.putExtra(EXTRA_TEXT, I18nConfig.getValue$default(chinaPrivacy.getText(), (Locale) null, 1, (Object) null));
        internalIntent$default.putExtra("extra_link_terms", I18nConfig.getValue$default(chinaPrivacy.getLinkTerms(), (Locale) null, 1, (Object) null));
        internalIntent$default.putExtra("extra_link_privacy", I18nConfig.getValue$default(chinaPrivacy.getLinkPrivacy(), (Locale) null, 1, (Object) null));
        return internalIntent$default;
    }

    public static /* synthetic */ Intent openAntiFakeScanIntent$default(Actions actions, Context context, HasSKU hasSKU, DeviceFilterType deviceFilterType, int i, Object obj) {
        if ((i & 2) != 0) {
            hasSKU = null;
        }
        if ((i & 4) != 0) {
            deviceFilterType = null;
        }
        return actions.openAntiFakeScanIntent(context, hasSKU, deviceFilterType);
    }

    public final Intent openAntiFakeScanIntent(Context context, HasSKU hasSKU, DeviceFilterType deviceFilterType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent internalIntent$default = internalIntent$default(this, context, "blueair.action.antifakescan", (Integer) null, 4, (Object) null);
        if (hasSKU != null) {
            internalIntent$default.putExtra("device", hasSKU);
        }
        if (deviceFilterType != null) {
            internalIntent$default.putExtra(EXTRA_FILTER_TYPE, deviceFilterType.name());
        }
        return internalIntent$default;
    }

    public static /* synthetic */ Intent openMapIntent$default(Actions actions, Context context, LocationService.MapType mapType, String str, boolean z, boolean z2, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        if ((i & 32) != 0) {
            str2 = "";
        }
        return actions.openMapIntent(context, mapType, str, z, z2, str2);
    }

    public final Intent openMapIntent(Context context, LocationService.MapType mapType, String str, boolean z, boolean z2, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mapType, "mapType");
        Intrinsics.checkNotNullParameter(str, "navigateToLocationId");
        Intrinsics.checkNotNullParameter(str2, DeviceDataEntity.DEVICE_ID);
        int i = WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()];
        if (i == 1) {
            str3 = "blueair.action.amap";
        } else if (i == 2) {
            str3 = "blueair.action.googlemaps";
        } else if (i == 3) {
            str3 = "blueair.action.mapbox";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intent putExtra = internalIntent$default(this, context, str3, (Integer) null, 4, (Object) null).putExtra(SEARCH_MODE, z).putExtra("location_id", str).putExtra(CURRENT_LOCATION, z2).putExtra("device_id", str2);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
        return putExtra;
    }

    public final Intent openTroubleShootIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = context;
        Intent putExtra = internalIntent$default(this, context2, "blueair.action.info", (Integer) null, 4, (Object) null).putExtra(InfoActivity.DISPLAY_KEY, 7).putExtra(InfoActivity.TOOLBAR_TITLE_KEY, context2.getString(R.string.customer_support));
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
        return putExtra;
    }

    static /* synthetic */ Intent internalIntent$default(Actions actions, Context context, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return actions.internalIntent(context, str, num);
    }

    private final Intent internalIntent(Context context, String str, Integer num) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        Intrinsics.checkNotNullExpressionValue(intent, "setPackage(...)");
        if (num != null) {
            intent.setFlags(num.intValue());
        }
        return intent;
    }
}
