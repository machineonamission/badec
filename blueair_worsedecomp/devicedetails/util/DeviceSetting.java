package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.gigya.android.sdk.GigyaDefinitions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001b2\u00020\u0001:\u0014\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0013\u001c\u001d\u001e\u001f !\"#$%&'()*+,-.¨\u0006/"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "CUSTOM_NAME", "LINKED_DEVICE", "TIMEZONE", "GERM_SHIELD_MODE", "AUTO_MODE_TRIGGERS", "STANDBY_MODE", "CHILD_LOCK_MODE", "PRODUCT_INFO", "ERROR_REPORT", "DISPLAY_MODE", "TVOC", "AUTO_REFRESH", "WELCOME_HOME", "TEMPERATURE", "DRY_MODE", "USER_MANUAL", "WATER_REFRESHER", "WICK_DRY", "HOUR_FORMAT", "Companion", "Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_MODE_TRIGGERS;", "Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_REFRESH;", "Lcom/blueair/devicedetails/util/DeviceSetting$CHILD_LOCK_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$CUSTOM_NAME;", "Lcom/blueair/devicedetails/util/DeviceSetting$DISPLAY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$DRY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$ERROR_REPORT;", "Lcom/blueair/devicedetails/util/DeviceSetting$GERM_SHIELD_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$HOUR_FORMAT;", "Lcom/blueair/devicedetails/util/DeviceSetting$LINKED_DEVICE;", "Lcom/blueair/devicedetails/util/DeviceSetting$PRODUCT_INFO;", "Lcom/blueair/devicedetails/util/DeviceSetting$STANDBY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting$TEMPERATURE;", "Lcom/blueair/devicedetails/util/DeviceSetting$TIMEZONE;", "Lcom/blueair/devicedetails/util/DeviceSetting$TVOC;", "Lcom/blueair/devicedetails/util/DeviceSetting$USER_MANUAL;", "Lcom/blueair/devicedetails/util/DeviceSetting$WATER_REFRESHER;", "Lcom/blueair/devicedetails/util/DeviceSetting$WELCOME_HOME;", "Lcom/blueair/devicedetails/util/DeviceSetting$WICK_DRY;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSetting.kt */
public abstract class DeviceSetting {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<List<DeviceSetting>> SETTINGS$delegate = LazyKt.lazy(new DeviceSetting$$ExternalSyntheticLambda0());
    /* access modifiers changed from: private */
    public static final Lazy<Map<DeviceSetting, Integer>> settingsToViewType$delegate = LazyKt.lazy(new DeviceSetting$$ExternalSyntheticLambda1());
    private final String name;

    public /* synthetic */ DeviceSetting(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$CUSTOM_NAME;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class CUSTOM_NAME extends DeviceSetting {
        public static final CUSTOM_NAME INSTANCE = new CUSTOM_NAME();

        private CUSTOM_NAME() {
            super("custom_name", (DefaultConstructorMarker) null);
        }
    }

    private DeviceSetting(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$LINKED_DEVICE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class LINKED_DEVICE extends DeviceSetting {
        public static final LINKED_DEVICE INSTANCE = new LINKED_DEVICE();

        private LINKED_DEVICE() {
            super("linked_device", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$TIMEZONE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class TIMEZONE extends DeviceSetting {
        public static final TIMEZONE INSTANCE = new TIMEZONE();

        private TIMEZONE() {
            super(GigyaDefinitions.AccountProfileExtraFields.TIMEZONE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$GERM_SHIELD_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class GERM_SHIELD_MODE extends DeviceSetting {
        public static final GERM_SHIELD_MODE INSTANCE = new GERM_SHIELD_MODE();

        private GERM_SHIELD_MODE() {
            super("germ_shield_mode", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_MODE_TRIGGERS;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class AUTO_MODE_TRIGGERS extends DeviceSetting {
        public static final AUTO_MODE_TRIGGERS INSTANCE = new AUTO_MODE_TRIGGERS();

        private AUTO_MODE_TRIGGERS() {
            super("auto_mode_triggers", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$STANDBY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class STANDBY_MODE extends DeviceSetting {
        public static final STANDBY_MODE INSTANCE = new STANDBY_MODE();

        private STANDBY_MODE() {
            super("standby_mode", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$CHILD_LOCK_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class CHILD_LOCK_MODE extends DeviceSetting {
        public static final CHILD_LOCK_MODE INSTANCE = new CHILD_LOCK_MODE();

        private CHILD_LOCK_MODE() {
            super("child_lock_mode", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$PRODUCT_INFO;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class PRODUCT_INFO extends DeviceSetting {
        public static final PRODUCT_INFO INSTANCE = new PRODUCT_INFO();

        private PRODUCT_INFO() {
            super("product_info", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$ERROR_REPORT;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class ERROR_REPORT extends DeviceSetting {
        public static final ERROR_REPORT INSTANCE = new ERROR_REPORT();

        private ERROR_REPORT() {
            super("error_report", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$DISPLAY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class DISPLAY_MODE extends DeviceSetting {
        public static final DISPLAY_MODE INSTANCE = new DISPLAY_MODE();

        private DISPLAY_MODE() {
            super("display_mode", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$TVOC;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class TVOC extends DeviceSetting {
        public static final TVOC INSTANCE = new TVOC();

        private TVOC() {
            super("tvoc", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$AUTO_REFRESH;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class AUTO_REFRESH extends DeviceSetting {
        public static final AUTO_REFRESH INSTANCE = new AUTO_REFRESH();

        private AUTO_REFRESH() {
            super("auto_refresh", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$WELCOME_HOME;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class WELCOME_HOME extends DeviceSetting {
        public static final WELCOME_HOME INSTANCE = new WELCOME_HOME();

        private WELCOME_HOME() {
            super("welcome_home", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$TEMPERATURE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class TEMPERATURE extends DeviceSetting {
        public static final TEMPERATURE INSTANCE = new TEMPERATURE();

        private TEMPERATURE() {
            super("temperature", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$DRY_MODE;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class DRY_MODE extends DeviceSetting {
        public static final DRY_MODE INSTANCE = new DRY_MODE();

        private DRY_MODE() {
            super("dry_mode", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$USER_MANUAL;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class USER_MANUAL extends DeviceSetting {
        public static final USER_MANUAL INSTANCE = new USER_MANUAL();

        private USER_MANUAL() {
            super("user_manual", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$WATER_REFRESHER;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class WATER_REFRESHER extends DeviceSetting {
        public static final WATER_REFRESHER INSTANCE = new WATER_REFRESHER();

        private WATER_REFRESHER() {
            super("water_refresher", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$WICK_DRY;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class WICK_DRY extends DeviceSetting {
        public static final WICK_DRY INSTANCE = new WICK_DRY();

        private WICK_DRY() {
            super("wick_dry", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$HOUR_FORMAT;", "Lcom/blueair/devicedetails/util/DeviceSetting;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class HOUR_FORMAT extends DeviceSetting {
        public static final HOUR_FORMAT INSTANCE = new HOUR_FORMAT();

        private HOUR_FORMAT() {
            super("hour_format", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceSetting$Companion;", "", "<init>", "()V", "SETTINGS", "", "Lcom/blueair/devicedetails/util/DeviceSetting;", "getSETTINGS", "()Ljava/util/List;", "SETTINGS$delegate", "Lkotlin/Lazy;", "settingsToViewType", "", "", "getSettingsToViewType", "()Ljava/util/Map;", "settingsToViewType$delegate", "getSupportedSettings", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSetting.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceSetting> getSETTINGS() {
            return (List) DeviceSetting.SETTINGS$delegate.getValue();
        }

        public final Map<DeviceSetting, Integer> getSettingsToViewType() {
            return (Map) DeviceSetting.settingsToViewType$delegate.getValue();
        }

        public final List<DeviceSetting> getSupportedSettings(Device device) {
            boolean z;
            Collection arrayList = new ArrayList();
            for (Object next : getSETTINGS()) {
                DeviceSetting deviceSetting = (DeviceSetting) next;
                if (device != null) {
                    z = DeviceSettingKt.supportSetting(device, deviceSetting);
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    /* access modifiers changed from: private */
    public static final List SETTINGS_delegate$lambda$0() {
        return CollectionsKt.listOf(CUSTOM_NAME.INSTANCE, LINKED_DEVICE.INSTANCE, HOUR_FORMAT.INSTANCE, TIMEZONE.INSTANCE, TEMPERATURE.INSTANCE, DRY_MODE.INSTANCE, GERM_SHIELD_MODE.INSTANCE, AUTO_MODE_TRIGGERS.INSTANCE, CHILD_LOCK_MODE.INSTANCE, DISPLAY_MODE.INSTANCE, TVOC.INSTANCE, AUTO_REFRESH.INSTANCE, WICK_DRY.INSTANCE, WATER_REFRESHER.INSTANCE, WELCOME_HOME.INSTANCE, USER_MANUAL.INSTANCE, PRODUCT_INFO.INSTANCE, ERROR_REPORT.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final Map settingsToViewType_delegate$lambda$2() {
        Iterable settings = Companion.getSETTINGS();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(settings, 10));
        int i = 0;
        for (Object next : settings) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to((DeviceSetting) next, Integer.valueOf(i)));
            i = i2;
        }
        return MapsKt.toMap((List) arrayList);
    }
}
