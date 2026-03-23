package com.blueair.api.restapi;

import com.amplitude.api.Constants;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.activity.Actions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 :2\u00020\u0001:\u0001:By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006;"}, d2 = {"Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent;", "", "event_name", "", "click_time", "", "device_model", "device_uuid", "device_sku", "device_mcu_firmware", "device_timezone", "device_filter_type", "device_filter_left_life", "", "filter_name", "user_id", "user_region", "phone_os", "phone_device", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEvent_name", "()Ljava/lang/String;", "getClick_time", "()J", "getDevice_model", "getDevice_uuid", "getDevice_sku", "getDevice_mcu_firmware", "getDevice_timezone", "getDevice_filter_type", "getDevice_filter_left_life", "()I", "getFilter_name", "getUser_id", "getUser_region", "getPhone_os", "getPhone_device", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class AnalyticsFilterCLickEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final long click_time;
    private final int device_filter_left_life;
    private final String device_filter_type;
    private final String device_mcu_firmware;
    private final String device_model;
    private final String device_sku;
    private final String device_timezone;
    private final String device_uuid;
    private final String event_name;
    private final String filter_name;
    private final String phone_device;
    private final String phone_os;
    private final String user_id;
    private final String user_region;

    public static /* synthetic */ AnalyticsFilterCLickEvent copy$default(AnalyticsFilterCLickEvent analyticsFilterCLickEvent, String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, String str12, int i2, Object obj) {
        AnalyticsFilterCLickEvent analyticsFilterCLickEvent2 = analyticsFilterCLickEvent;
        int i3 = i2;
        return analyticsFilterCLickEvent2.copy((i3 & 1) != 0 ? analyticsFilterCLickEvent2.event_name : str, (i3 & 2) != 0 ? analyticsFilterCLickEvent2.click_time : j, (i3 & 4) != 0 ? analyticsFilterCLickEvent2.device_model : str2, (i3 & 8) != 0 ? analyticsFilterCLickEvent2.device_uuid : str3, (i3 & 16) != 0 ? analyticsFilterCLickEvent2.device_sku : str4, (i3 & 32) != 0 ? analyticsFilterCLickEvent2.device_mcu_firmware : str5, (i3 & 64) != 0 ? analyticsFilterCLickEvent2.device_timezone : str6, (i3 & 128) != 0 ? analyticsFilterCLickEvent2.device_filter_type : str7, (i3 & 256) != 0 ? analyticsFilterCLickEvent2.device_filter_left_life : i, (i3 & 512) != 0 ? analyticsFilterCLickEvent2.filter_name : str8, (i3 & 1024) != 0 ? analyticsFilterCLickEvent2.user_id : str9, (i3 & 2048) != 0 ? analyticsFilterCLickEvent2.user_region : str10, (i3 & 4096) != 0 ? analyticsFilterCLickEvent2.phone_os : str11, (i3 & 8192) != 0 ? analyticsFilterCLickEvent2.phone_device : str12);
    }

    public final String component1() {
        return this.event_name;
    }

    public final String component10() {
        return this.filter_name;
    }

    public final String component11() {
        return this.user_id;
    }

    public final String component12() {
        return this.user_region;
    }

    public final String component13() {
        return this.phone_os;
    }

    public final String component14() {
        return this.phone_device;
    }

    public final long component2() {
        return this.click_time;
    }

    public final String component3() {
        return this.device_model;
    }

    public final String component4() {
        return this.device_uuid;
    }

    public final String component5() {
        return this.device_sku;
    }

    public final String component6() {
        return this.device_mcu_firmware;
    }

    public final String component7() {
        return this.device_timezone;
    }

    public final String component8() {
        return this.device_filter_type;
    }

    public final int component9() {
        return this.device_filter_left_life;
    }

    public final AnalyticsFilterCLickEvent copy(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, String str12) {
        String str13 = str;
        Intrinsics.checkNotNullParameter(str13, AnalyticEvent.KEY_EVENT_NAME);
        String str14 = str2;
        Intrinsics.checkNotNullParameter(str14, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL);
        String str15 = str3;
        Intrinsics.checkNotNullParameter(str15, "device_uuid");
        String str16 = str4;
        Intrinsics.checkNotNullParameter(str16, Actions.EXTRA_DEVICE_SKU);
        String str17 = str5;
        Intrinsics.checkNotNullParameter(str17, "device_mcu_firmware");
        String str18 = str6;
        Intrinsics.checkNotNullParameter(str18, "device_timezone");
        String str19 = str7;
        Intrinsics.checkNotNullParameter(str19, "device_filter_type");
        String str20 = str9;
        Intrinsics.checkNotNullParameter(str20, "user_id");
        String str21 = str10;
        Intrinsics.checkNotNullParameter(str21, "user_region");
        String str22 = str11;
        Intrinsics.checkNotNullParameter(str22, "phone_os");
        Intrinsics.checkNotNullParameter(str12, "phone_device");
        return new AnalyticsFilterCLickEvent(str13, j, str14, str15, str16, str17, str18, str19, i, str8, str20, str21, str22, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticsFilterCLickEvent)) {
            return false;
        }
        AnalyticsFilterCLickEvent analyticsFilterCLickEvent = (AnalyticsFilterCLickEvent) obj;
        return Intrinsics.areEqual((Object) this.event_name, (Object) analyticsFilterCLickEvent.event_name) && this.click_time == analyticsFilterCLickEvent.click_time && Intrinsics.areEqual((Object) this.device_model, (Object) analyticsFilterCLickEvent.device_model) && Intrinsics.areEqual((Object) this.device_uuid, (Object) analyticsFilterCLickEvent.device_uuid) && Intrinsics.areEqual((Object) this.device_sku, (Object) analyticsFilterCLickEvent.device_sku) && Intrinsics.areEqual((Object) this.device_mcu_firmware, (Object) analyticsFilterCLickEvent.device_mcu_firmware) && Intrinsics.areEqual((Object) this.device_timezone, (Object) analyticsFilterCLickEvent.device_timezone) && Intrinsics.areEqual((Object) this.device_filter_type, (Object) analyticsFilterCLickEvent.device_filter_type) && this.device_filter_left_life == analyticsFilterCLickEvent.device_filter_left_life && Intrinsics.areEqual((Object) this.filter_name, (Object) analyticsFilterCLickEvent.filter_name) && Intrinsics.areEqual((Object) this.user_id, (Object) analyticsFilterCLickEvent.user_id) && Intrinsics.areEqual((Object) this.user_region, (Object) analyticsFilterCLickEvent.user_region) && Intrinsics.areEqual((Object) this.phone_os, (Object) analyticsFilterCLickEvent.phone_os) && Intrinsics.areEqual((Object) this.phone_device, (Object) analyticsFilterCLickEvent.phone_device);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.event_name.hashCode() * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.click_time)) * 31) + this.device_model.hashCode()) * 31) + this.device_uuid.hashCode()) * 31) + this.device_sku.hashCode()) * 31) + this.device_mcu_firmware.hashCode()) * 31) + this.device_timezone.hashCode()) * 31) + this.device_filter_type.hashCode()) * 31) + this.device_filter_left_life) * 31;
        String str = this.filter_name;
        return ((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.user_id.hashCode()) * 31) + this.user_region.hashCode()) * 31) + this.phone_os.hashCode()) * 31) + this.phone_device.hashCode();
    }

    public String toString() {
        return "AnalyticsFilterCLickEvent(event_name=" + this.event_name + ", click_time=" + this.click_time + ", device_model=" + this.device_model + ", device_uuid=" + this.device_uuid + ", device_sku=" + this.device_sku + ", device_mcu_firmware=" + this.device_mcu_firmware + ", device_timezone=" + this.device_timezone + ", device_filter_type=" + this.device_filter_type + ", device_filter_left_life=" + this.device_filter_left_life + ", filter_name=" + this.filter_name + ", user_id=" + this.user_id + ", user_region=" + this.user_region + ", phone_os=" + this.phone_os + ", phone_device=" + this.phone_device + ')';
    }

    public AnalyticsFilterCLickEvent(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, String str11, String str12) {
        String str13 = str3;
        String str14 = str4;
        String str15 = str5;
        String str16 = str6;
        String str17 = str7;
        String str18 = str9;
        String str19 = str10;
        String str20 = str11;
        String str21 = str12;
        Intrinsics.checkNotNullParameter(str, AnalyticEvent.KEY_EVENT_NAME);
        Intrinsics.checkNotNullParameter(str2, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL);
        Intrinsics.checkNotNullParameter(str13, "device_uuid");
        Intrinsics.checkNotNullParameter(str14, Actions.EXTRA_DEVICE_SKU);
        Intrinsics.checkNotNullParameter(str15, "device_mcu_firmware");
        Intrinsics.checkNotNullParameter(str16, "device_timezone");
        Intrinsics.checkNotNullParameter(str17, "device_filter_type");
        Intrinsics.checkNotNullParameter(str18, "user_id");
        Intrinsics.checkNotNullParameter(str19, "user_region");
        Intrinsics.checkNotNullParameter(str20, "phone_os");
        Intrinsics.checkNotNullParameter(str21, "phone_device");
        this.event_name = str;
        this.click_time = j;
        this.device_model = str2;
        this.device_uuid = str13;
        this.device_sku = str14;
        this.device_mcu_firmware = str15;
        this.device_timezone = str16;
        this.device_filter_type = str17;
        this.device_filter_left_life = i;
        this.filter_name = str8;
        this.user_id = str18;
        this.user_region = str19;
        this.phone_os = str20;
        this.phone_device = str21;
    }

    public final String getEvent_name() {
        return this.event_name;
    }

    public final long getClick_time() {
        return this.click_time;
    }

    public final String getDevice_model() {
        return this.device_model;
    }

    public final String getDevice_uuid() {
        return this.device_uuid;
    }

    public final String getDevice_sku() {
        return this.device_sku;
    }

    public final String getDevice_mcu_firmware() {
        return this.device_mcu_firmware;
    }

    public final String getDevice_timezone() {
        return this.device_timezone;
    }

    public final String getDevice_filter_type() {
        return this.device_filter_type;
    }

    public final int getDevice_filter_left_life() {
        return this.device_filter_left_life;
    }

    public final String getFilter_name() {
        return this.filter_name;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final String getUser_region() {
        return this.user_region;
    }

    public final String getPhone_os() {
        return this.phone_os;
    }

    public final String getPhone_device() {
        return this.phone_device;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent$Companion;", "", "<init>", "()V", "fromAnalyticEvent", "Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent;", "event", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserDevicesBlueRestApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private static final String fromAnalyticEvent$payloadStr(AnalyticEvent.FilterClickEvent filterClickEvent, String str) {
            Object obj = filterClickEvent.getPayload().get(str);
            String str2 = obj instanceof String ? (String) obj : null;
            return str2 == null ? "" : str2;
        }

        public final AnalyticsFilterCLickEvent fromAnalyticEvent(AnalyticEvent.FilterClickEvent filterClickEvent) {
            AnalyticEvent.FilterClickEvent filterClickEvent2 = filterClickEvent;
            Intrinsics.checkNotNullParameter(filterClickEvent2, "event");
            String eventName = filterClickEvent2.getEventName();
            Object obj = filterClickEvent2.getPayload().get("click_time");
            String str = null;
            Long l = obj instanceof Long ? (Long) obj : null;
            long longValue = l != null ? l.longValue() : System.currentTimeMillis();
            String fromAnalyticEvent$payloadStr = fromAnalyticEvent$payloadStr(filterClickEvent2, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL);
            String fromAnalyticEvent$payloadStr2 = fromAnalyticEvent$payloadStr(filterClickEvent2, "device_uuid");
            String fromAnalyticEvent$payloadStr3 = fromAnalyticEvent$payloadStr(filterClickEvent2, Actions.EXTRA_DEVICE_SKU);
            String fromAnalyticEvent$payloadStr4 = fromAnalyticEvent$payloadStr(filterClickEvent2, "device_mcu_firmware");
            String fromAnalyticEvent$payloadStr5 = fromAnalyticEvent$payloadStr(filterClickEvent2, "device_timezone");
            String fromAnalyticEvent$payloadStr6 = fromAnalyticEvent$payloadStr(filterClickEvent2, "device_filter_type");
            Object obj2 = filterClickEvent2.getPayload().get("device_filter_left_life");
            Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
            int intValue = num != null ? num.intValue() : 0;
            CharSequence fromAnalyticEvent$payloadStr7 = fromAnalyticEvent$payloadStr(filterClickEvent2, "filter_name");
            if (fromAnalyticEvent$payloadStr7.length() != 0) {
                str = fromAnalyticEvent$payloadStr7;
            }
            return new AnalyticsFilterCLickEvent(eventName, longValue, fromAnalyticEvent$payloadStr, fromAnalyticEvent$payloadStr2, fromAnalyticEvent$payloadStr3, fromAnalyticEvent$payloadStr4, fromAnalyticEvent$payloadStr5, fromAnalyticEvent$payloadStr6, intValue, str, fromAnalyticEvent$payloadStr(filterClickEvent2, "user_id"), fromAnalyticEvent$payloadStr(filterClickEvent2, "user_region"), fromAnalyticEvent$payloadStr(filterClickEvent2, "phone_os"), fromAnalyticEvent$payloadStr(filterClickEvent2, "phone_device"));
        }
    }
}
