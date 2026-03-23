package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.util.SkuConfigurationManager;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000eBß\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u0012\b\b\u0002\u0010!\u001a\u00020\u0010\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u0012\b\b\u0002\u0010#\u001a\u00020\u0010\u0012\b\b\u0002\u0010$\u001a\u00020\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\u0010\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\u0010\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\b\b\u0002\u0010)\u001a\u00020\u0010\u0012\b\b\u0002\u0010*\u001a\u00020\u0010\u0012\b\b\u0002\u0010+\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u001b\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u0012\b\b\u0002\u0010.\u001a\u00020\u0013\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u00100\u001a\u00020\u0013\u0012\b\b\u0002\u00101\u001a\u00020\u0013\u0012\b\b\u0002\u00102\u001a\u00020\u0013\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504\u0012\b\b\u0002\u00106\u001a\u00020\u001b¢\u0006\u0004\b7\u00108J\u0006\u0010`\u001a\u00020\u001bJ\t\u0010a\u001a\u00020\u0010HÆ\u0003J\t\u0010b\u001a\u00020\u0010HÆ\u0003J\t\u0010c\u001a\u00020\u0013HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010?J\t\u0010e\u001a\u00020\u0013HÆ\u0003J\t\u0010f\u001a\u00020\u0010HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010i\u001a\u00020\u001bHÆ\u0003J\t\u0010j\u001a\u00020\u001bHÆ\u0003J\t\u0010k\u001a\u00020\u0013HÆ\u0003J\t\u0010l\u001a\u00020\u001fHÆ\u0003J\t\u0010m\u001a\u00020\u0010HÆ\u0003J\t\u0010n\u001a\u00020\u0010HÆ\u0003J\t\u0010o\u001a\u00020\u0010HÆ\u0003J\t\u0010p\u001a\u00020\u0010HÆ\u0003J\t\u0010q\u001a\u00020\u0010HÆ\u0003J\t\u0010r\u001a\u00020\u0010HÆ\u0003J\t\u0010s\u001a\u00020\u0010HÆ\u0003J\t\u0010t\u001a\u00020\u0010HÆ\u0003J\t\u0010u\u001a\u00020\u0010HÆ\u0003J\t\u0010v\u001a\u00020\u0010HÆ\u0003J\t\u0010w\u001a\u00020\u0010HÆ\u0003J\t\u0010x\u001a\u00020\u0013HÆ\u0003J\t\u0010y\u001a\u00020\u001bHÆ\u0003J\t\u0010z\u001a\u00020\u0010HÆ\u0003J\t\u0010{\u001a\u00020\u0013HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010}\u001a\u00020\u0013HÆ\u0003J\t\u0010~\u001a\u00020\u0013HÆ\u0003J\t\u0010\u001a\u00020\u0013HÆ\u0003J\u0012\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001bHÆ\u0003Jê\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00102\b\b\u0002\u0010%\u001a\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u00102\b\b\u0002\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u00020\u00132\b\b\u0002\u00102\u001a\u00020\u00132\u0010\b\u0002\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000105042\b\b\u0002\u00106\u001a\u00020\u001bHÆ\u0001¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u0013J\u0016\u0010\u0001\u001a\u00020\u001b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0013HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0010HÖ\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0013R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0014\u0010\u0011\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0014\u0010\u0015\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0014\u0010\u0016\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010:R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010:R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010\u001c\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010GR\u0014\u0010\u001d\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010=R\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010 \u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010:R\u0014\u0010!\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010:R\u0014\u0010\"\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010:R\u0014\u0010#\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010:R\u0014\u0010$\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010:R\u0014\u0010%\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010:R\u0014\u0010&\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010:R\u0014\u0010'\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010:R\u0014\u0010(\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010:R\u0014\u0010)\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010:R\u0014\u0010*\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010:R\u0014\u0010+\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010=R\u0014\u0010,\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010GR\u0014\u0010-\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010:R\u0014\u0010.\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010=R\u0016\u0010/\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010:R\u0014\u00100\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010=R\u0014\u00101\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010=R\u0014\u00102\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010=R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0014\u00106\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010G¨\u0006\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceMiniRestful;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasMainMode;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/HasNightLamp;", "Lcom/blueair/core/model/HasHourFormat;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "updateProgress", "isStandByOn", "modelName", "typeIndex", "sku", "mainMode", "apSubMode", "nightLampSteplessBrightness", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "use24Hour", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ILjava/lang/String;IIILjava/util/List;Z)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getUpdateProgress", "getModelName", "getTypeIndex", "getSku", "getMainMode", "getApSubMode", "getNightLampSteplessBrightness", "getAlarms", "()Ljava/util/List;", "getUse24Hour", "hasNightMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ILjava/lang/String;IIILjava/util/List;Z)Lcom/blueair/core/model/DeviceMiniRestful;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceMiniRestful implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasScheduling, HasSKU, HasMainMode, HasAlarm, HasNightLamp, HasHourFormat {
    public static final Parcelable.Creator<DeviceMiniRestful> CREATOR = new Creator();
    private final List<DeviceAlarm> alarms;
    private final int apSubMode;
    private final String autoModeText;
    private final int brightness;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final DeviceUuid deviceUuid;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isStandByOn;
    private final long lastConnectivityInMillis;
    private final String mac;
    private final int mainMode;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final int nightLampSteplessBrightness;
    private final String purchaseDate;
    private final String serial;
    private final String sku;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final boolean use24Hour;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceMiniRestful> {
        public final DeviceMiniRestful createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            int i;
            DeviceAlarm deviceAlarm;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z4 = true;
            boolean z5 = false;
            if (parcel2.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z4 = false;
            }
            if (parcel2.readInt() != 0) {
                z2 = false;
                z5 = z;
            } else {
                z2 = false;
            }
            boolean z6 = z2;
            int readInt3 = parcel2.readInt();
            long readLong = parcel2.readLong();
            boolean z7 = z6;
            String readString5 = parcel2.readString();
            boolean z8 = z7;
            String readString6 = parcel2.readString();
            boolean z9 = z8;
            String readString7 = parcel2.readString();
            boolean z10 = z9;
            String readString8 = parcel2.readString();
            boolean z11 = z10;
            String readString9 = parcel2.readString();
            boolean z12 = z11;
            String readString10 = parcel2.readString();
            boolean z13 = z12;
            String readString11 = parcel2.readString();
            boolean z14 = z13;
            String readString12 = parcel2.readString();
            boolean z15 = z14;
            String readString13 = parcel2.readString();
            boolean z16 = z15;
            String readString14 = parcel2.readString();
            boolean z17 = z16;
            String readString15 = parcel2.readString();
            boolean z18 = z17;
            int readInt4 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z3 = z18;
                z18 = z;
            } else {
                z3 = z18;
            }
            boolean z19 = z3;
            String readString16 = parcel2.readString();
            int readInt5 = parcel2.readInt();
            boolean z20 = z19;
            String readString17 = parcel2.readString();
            boolean z21 = z20;
            int readInt6 = parcel2.readInt();
            boolean z22 = z21;
            int readInt7 = parcel2.readInt();
            boolean z23 = z22;
            int readInt8 = parcel2.readInt();
            int readInt9 = parcel2.readInt();
            ArrayList arrayList = new ArrayList(readInt9);
            String str = readString;
            int i2 = z23;
            while (i2 != readInt9) {
                if (parcel2.readInt() == 0) {
                    i = readInt9;
                    deviceAlarm = null;
                } else {
                    i = readInt9;
                    deviceAlarm = DeviceAlarm.CREATOR.createFromParcel(parcel2);
                }
                arrayList.add(deviceAlarm);
                i2++;
                readInt9 = i;
            }
            return new DeviceMiniRestful(str, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z4, z5, readInt3, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, readInt4, z18, readString16, readInt5, readString17, readInt6, readInt7, readInt8, arrayList, parcel2.readInt() != 0 ? true : z23);
        }

        public final DeviceMiniRestful[] newArray(int i) {
            return new DeviceMiniRestful[i];
        }
    }

    public static /* synthetic */ DeviceMiniRestful copy$default(DeviceMiniRestful deviceMiniRestful, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, boolean z2, int i3, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i4, boolean z3, String str16, int i5, String str17, int i6, int i7, int i8, List list, boolean z4, int i9, int i10, Object obj) {
        boolean z5;
        List list2;
        int i11;
        int i12;
        int i13;
        String str18;
        int i14;
        String str19;
        boolean z6;
        int i15;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        long j2;
        int i16;
        boolean z7;
        boolean z8;
        DeviceUuid deviceUuid3;
        String str31;
        String str32;
        int i17;
        Integer num2;
        int i18;
        String str33;
        DeviceMiniRestful deviceMiniRestful2 = deviceMiniRestful;
        int i19 = i9;
        String str34 = (i19 & 1) != 0 ? deviceMiniRestful2.uid : str;
        String str35 = (i19 & 2) != 0 ? deviceMiniRestful2.name : str2;
        int i20 = (i19 & 4) != 0 ? deviceMiniRestful2.fanSpeed : i;
        Integer num3 = (i19 & 8) != 0 ? deviceMiniRestful2.filterLife : num;
        int i21 = (i19 & 16) != 0 ? deviceMiniRestful2.brightness : i2;
        String str36 = (i19 & 32) != 0 ? deviceMiniRestful2.autoModeText : str3;
        String str37 = (i19 & 64) != 0 ? deviceMiniRestful2.info : str4;
        DeviceUuid deviceUuid4 = (i19 & 128) != 0 ? deviceMiniRestful2.deviceUuid : deviceUuid2;
        boolean z9 = (i19 & 256) != 0 ? deviceMiniRestful2.hasFinishedOnboarding : z;
        boolean z10 = (i19 & 512) != 0 ? deviceMiniRestful2.isChildLockOn : z2;
        int i22 = (i19 & 1024) != 0 ? deviceMiniRestful2.connectivityStatusIndex : i3;
        long j3 = (i19 & 2048) != 0 ? deviceMiniRestful2.lastConnectivityInMillis : j;
        String str38 = (i19 & 4096) != 0 ? deviceMiniRestful2.mac : str5;
        String str39 = str34;
        String str40 = (i19 & 8192) != 0 ? deviceMiniRestful2.mcuFirmware : str6;
        String str41 = (i19 & 16384) != 0 ? deviceMiniRestful2.wifiFirmware : str7;
        String str42 = (i19 & 32768) != 0 ? deviceMiniRestful2.hardware : str8;
        String str43 = (i9 & 65536) != 0 ? deviceMiniRestful2.timeZone : str9;
        String str44 = (i9 & 131072) != 0 ? deviceMiniRestful2.serial : str10;
        String str45 = (i9 & 262144) != 0 ? deviceMiniRestful2.purchaseDate : str11;
        String str46 = (i9 & 524288) != 0 ? deviceMiniRestful2.dealerName : str12;
        String str47 = (i9 & 1048576) != 0 ? deviceMiniRestful2.dealerCountry : str13;
        String str48 = (i9 & 2097152) != 0 ? deviceMiniRestful2.filterType : str14;
        String str49 = (i9 & 4194304) != 0 ? deviceMiniRestful2.filterTrigger : str15;
        int i23 = (i9 & 8388608) != 0 ? deviceMiniRestful2.updateProgress : i4;
        boolean z11 = (i9 & 16777216) != 0 ? deviceMiniRestful2.isStandByOn : z3;
        String str50 = (i9 & 33554432) != 0 ? deviceMiniRestful2.modelName : str16;
        int i24 = (i9 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceMiniRestful2.typeIndex : i5;
        String str51 = (i9 & 134217728) != 0 ? deviceMiniRestful2.sku : str17;
        int i25 = (i9 & 268435456) != 0 ? deviceMiniRestful2.mainMode : i6;
        int i26 = (i9 & 536870912) != 0 ? deviceMiniRestful2.apSubMode : i7;
        int i27 = (i9 & 1073741824) != 0 ? deviceMiniRestful2.nightLampSteplessBrightness : i8;
        List list3 = (i9 & Integer.MIN_VALUE) != 0 ? deviceMiniRestful2.alarms : list;
        if ((i10 & 1) != 0) {
            list2 = list3;
            z5 = deviceMiniRestful2.use24Hour;
            str25 = str44;
            str24 = str45;
            str23 = str46;
            str22 = str47;
            str21 = str48;
            str20 = str49;
            i15 = i23;
            z6 = z11;
            str19 = str50;
            i14 = i24;
            str18 = str51;
            i13 = i25;
            i12 = i26;
            i11 = i27;
            str28 = str41;
            num2 = num3;
            i17 = i21;
            str32 = str36;
            str31 = str37;
            deviceUuid3 = deviceUuid4;
            z8 = z9;
            z7 = z10;
            i16 = i22;
            j2 = j3;
            str30 = str38;
            str29 = str40;
            str27 = str42;
            str26 = str43;
            str33 = str35;
            i18 = i20;
        } else {
            z5 = z4;
            list2 = list3;
            str26 = str43;
            str25 = str44;
            str24 = str45;
            str23 = str46;
            str22 = str47;
            str21 = str48;
            str20 = str49;
            i15 = i23;
            z6 = z11;
            str19 = str50;
            i14 = i24;
            str18 = str51;
            i13 = i25;
            i12 = i26;
            i11 = i27;
            str28 = str41;
            i18 = i20;
            num2 = num3;
            i17 = i21;
            str32 = str36;
            str31 = str37;
            deviceUuid3 = deviceUuid4;
            z8 = z9;
            z7 = z10;
            i16 = i22;
            j2 = j3;
            str30 = str38;
            str29 = str40;
            str27 = str42;
            str33 = str35;
        }
        return deviceMiniRestful2.copy(str39, str33, i18, num2, i17, str32, str31, deviceUuid3, z8, z7, i16, j2, str30, str29, str28, str27, str26, str25, str24, str23, str22, str21, str20, i15, z6, str19, i14, str18, i13, i12, i11, list2, z5);
    }

    public final String component1() {
        return this.uid;
    }

    public final boolean component10() {
        return this.isChildLockOn;
    }

    public final int component11() {
        return this.connectivityStatusIndex;
    }

    public final long component12() {
        return this.lastConnectivityInMillis;
    }

    public final String component13() {
        return this.mac;
    }

    public final String component14() {
        return this.mcuFirmware;
    }

    public final String component15() {
        return this.wifiFirmware;
    }

    public final String component16() {
        return this.hardware;
    }

    public final String component17() {
        return this.timeZone;
    }

    public final String component18() {
        return this.serial;
    }

    public final String component19() {
        return this.purchaseDate;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.dealerName;
    }

    public final String component21() {
        return this.dealerCountry;
    }

    public final String component22() {
        return this.filterType;
    }

    public final String component23() {
        return this.filterTrigger;
    }

    public final int component24() {
        return this.updateProgress;
    }

    public final boolean component25() {
        return this.isStandByOn;
    }

    public final String component26() {
        return this.modelName;
    }

    public final int component27() {
        return this.typeIndex;
    }

    public final String component28() {
        return this.sku;
    }

    public final int component29() {
        return this.mainMode;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final int component30() {
        return this.apSubMode;
    }

    public final int component31() {
        return this.nightLampSteplessBrightness;
    }

    public final List<DeviceAlarm> component32() {
        return this.alarms;
    }

    public final boolean component33() {
        return this.use24Hour;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final int component5() {
        return this.brightness;
    }

    public final String component6() {
        return this.autoModeText;
    }

    public final String component7() {
        return this.info;
    }

    public final DeviceUuid component8() {
        return this.deviceUuid;
    }

    public final boolean component9() {
        return this.hasFinishedOnboarding;
    }

    public final DeviceMiniRestful copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, boolean z2, int i3, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i4, boolean z3, String str16, int i5, String str17, int i6, int i7, int i8, List<DeviceAlarm> list, boolean z4) {
        String str18 = str;
        Intrinsics.checkNotNullParameter(str18, "uid");
        String str19 = str2;
        Intrinsics.checkNotNullParameter(str19, "name");
        String str20 = str3;
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        String str21 = str5;
        Intrinsics.checkNotNullParameter(str21, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str6, "mcuFirmware");
        String str22 = str7;
        Intrinsics.checkNotNullParameter(str22, "wifiFirmware");
        String str23 = str8;
        Intrinsics.checkNotNullParameter(str23, "hardware");
        String str24 = str9;
        Intrinsics.checkNotNullParameter(str24, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str25 = str10;
        Intrinsics.checkNotNullParameter(str25, "serial");
        String str26 = str11;
        Intrinsics.checkNotNullParameter(str26, "purchaseDate");
        String str27 = str12;
        Intrinsics.checkNotNullParameter(str27, "dealerName");
        String str28 = str13;
        Intrinsics.checkNotNullParameter(str28, "dealerCountry");
        String str29 = str14;
        Intrinsics.checkNotNullParameter(str29, "filterType");
        String str30 = str15;
        Intrinsics.checkNotNullParameter(str30, "filterTrigger");
        String str31 = str16;
        Intrinsics.checkNotNullParameter(str31, "modelName");
        Intrinsics.checkNotNullParameter(list, "alarms");
        String str32 = str22;
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        return new DeviceMiniRestful(str18, str19, i, num, i2, str20, str4, deviceUuid2, z, z2, i3, j, str21, str6, str32, str33, str34, str35, str36, str37, str38, str39, str40, i4, z3, str31, i5, str17, i6, i7, i8, list, z4);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceMiniRestful)) {
            return false;
        }
        DeviceMiniRestful deviceMiniRestful = (DeviceMiniRestful) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceMiniRestful.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceMiniRestful.name) && this.fanSpeed == deviceMiniRestful.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceMiniRestful.filterLife) && this.brightness == deviceMiniRestful.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceMiniRestful.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceMiniRestful.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceMiniRestful.deviceUuid) && this.hasFinishedOnboarding == deviceMiniRestful.hasFinishedOnboarding && this.isChildLockOn == deviceMiniRestful.isChildLockOn && this.connectivityStatusIndex == deviceMiniRestful.connectivityStatusIndex && this.lastConnectivityInMillis == deviceMiniRestful.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceMiniRestful.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceMiniRestful.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceMiniRestful.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceMiniRestful.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceMiniRestful.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceMiniRestful.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceMiniRestful.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceMiniRestful.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceMiniRestful.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceMiniRestful.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceMiniRestful.filterTrigger) && this.updateProgress == deviceMiniRestful.updateProgress && this.isStandByOn == deviceMiniRestful.isStandByOn && Intrinsics.areEqual((Object) this.modelName, (Object) deviceMiniRestful.modelName) && this.typeIndex == deviceMiniRestful.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceMiniRestful.sku) && this.mainMode == deviceMiniRestful.mainMode && this.apSubMode == deviceMiniRestful.apSubMode && this.nightLampSteplessBrightness == deviceMiniRestful.nightLampSteplessBrightness && Intrinsics.areEqual((Object) this.alarms, (Object) deviceMiniRestful.alarms) && this.use24Hour == deviceMiniRestful.use24Hour;
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DeviceUuid deviceUuid2 = this.deviceUuid;
        int hashCode4 = (((((((((((((((((((((((((((((((((((((((hashCode3 + (deviceUuid2 == null ? 0 : deviceUuid2.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((((hashCode4 + i) * 31) + this.mainMode) * 31) + this.apSubMode) * 31) + this.nightLampSteplessBrightness) * 31) + this.alarms.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.use24Hour);
    }

    public String toString() {
        return "DeviceMiniRestful(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", mainMode=" + this.mainMode + ", apSubMode=" + this.apSubMode + ", nightLampSteplessBrightness=" + this.nightLampSteplessBrightness + ", alarms=" + this.alarms + ", use24Hour=" + this.use24Hour + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeInt(this.fanSpeed);
        Integer num = this.filterLife;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.brightness);
        parcel.writeString(this.autoModeText);
        parcel.writeString(this.info);
        DeviceUuid deviceUuid2 = this.deviceUuid;
        if (deviceUuid2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            deviceUuid2.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.hasFinishedOnboarding ? 1 : 0);
        parcel.writeInt(this.isChildLockOn ? 1 : 0);
        parcel.writeInt(this.connectivityStatusIndex);
        parcel.writeLong(this.lastConnectivityInMillis);
        parcel.writeString(this.mac);
        parcel.writeString(this.mcuFirmware);
        parcel.writeString(this.wifiFirmware);
        parcel.writeString(this.hardware);
        parcel.writeString(this.timeZone);
        parcel.writeString(this.serial);
        parcel.writeString(this.purchaseDate);
        parcel.writeString(this.dealerName);
        parcel.writeString(this.dealerCountry);
        parcel.writeString(this.filterType);
        parcel.writeString(this.filterTrigger);
        parcel.writeInt(this.updateProgress);
        parcel.writeInt(this.isStandByOn ? 1 : 0);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.typeIndex);
        parcel.writeString(this.sku);
        parcel.writeInt(this.mainMode);
        parcel.writeInt(this.apSubMode);
        parcel.writeInt(this.nightLampSteplessBrightness);
        List<DeviceAlarm> list = this.alarms;
        parcel.writeInt(list.size());
        for (DeviceAlarm next : list) {
            if (next == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                next.writeToParcel(parcel, i);
            }
        }
        parcel.writeInt(this.use24Hour ? 1 : 0);
    }

    public ApSubMode apSubMode() {
        return HasMainMode.CC.$default$apSubMode(this);
    }

    public AutoMode getAutoMode() {
        return HasFanSpeed.CC.$default$getAutoMode(this);
    }

    public Brightness getBrightnessEnum() {
        return HasBrightness.CC.$default$getBrightnessEnum(this);
    }

    public ConnectivityStatus getConnectivityStatus() {
        return Device.CC.$default$getConnectivityStatus(this);
    }

    public FanSpeedEnum getFanSpeedEnum() {
        return HasFanSpeed.CC.$default$getFanSpeedEnum(this);
    }

    public Filter getFilter() {
        return HasFanSpeed.CC.$default$getFilter(this);
    }

    public boolean getHasGear0() {
        return HasFanSpeed.CC.$default$getHasGear0(this);
    }

    public boolean getHasGear4() {
        return HasFanSpeed.CC.$default$getHasGear4(this);
    }

    public TimeZone getTimezone(Context context) {
        return Device.CC.$default$getTimezone(this, context);
    }

    public FilterTrigger getTrigger() {
        return HasFanSpeed.CC.$default$getTrigger(this);
    }

    public DeviceType getType() {
        return Device.CC.$default$getType(this);
    }

    public UiAutoMode getUiAutoMode() {
        return HasFanSpeed.CC.$default$getUiAutoMode(this);
    }

    public boolean isInApSubMode(ApSubMode apSubMode2) {
        return HasMainMode.CC.$default$isInApSubMode(this, apSubMode2);
    }

    public boolean isInMainMode(MainMode mainMode2) {
        return HasMainMode.CC.$default$isInMainMode(this, mainMode2);
    }

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public MainMode mainMode() {
        return HasMainMode.CC.$default$mainMode(this);
    }

    public DeviceMiniRestful(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, boolean z2, int i3, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i4, boolean z3, String str16, int i5, String str17, int i6, int i7, int i8, List<DeviceAlarm> list, boolean z4) {
        String str18 = str;
        String str19 = str2;
        String str20 = str3;
        String str21 = str5;
        String str22 = str6;
        String str23 = str7;
        String str24 = str8;
        String str25 = str9;
        String str26 = str10;
        String str27 = str11;
        String str28 = str12;
        String str29 = str13;
        String str30 = str14;
        String str31 = str15;
        Intrinsics.checkNotNullParameter(str18, "uid");
        Intrinsics.checkNotNullParameter(str19, "name");
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        Intrinsics.checkNotNullParameter(str21, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str22, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str24, "hardware");
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str26, "serial");
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        Intrinsics.checkNotNullParameter(str30, "filterType");
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        Intrinsics.checkNotNullParameter(str16, "modelName");
        List<DeviceAlarm> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "alarms");
        this.uid = str18;
        this.name = str19;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str20;
        this.info = str4;
        this.deviceUuid = deviceUuid2;
        this.hasFinishedOnboarding = z;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i3;
        this.lastConnectivityInMillis = j;
        this.mac = str21;
        this.mcuFirmware = str22;
        this.wifiFirmware = str23;
        this.hardware = str24;
        this.timeZone = str25;
        this.serial = str26;
        this.purchaseDate = str27;
        this.dealerName = str28;
        this.dealerCountry = str29;
        this.filterType = str30;
        this.filterTrigger = str31;
        this.updateProgress = i4;
        this.isStandByOn = z3;
        this.modelName = str16;
        this.typeIndex = i5;
        this.sku = str17;
        this.mainMode = i6;
        this.apSubMode = i7;
        this.nightLampSteplessBrightness = i8;
        this.alarms = list2;
        this.use24Hour = z4;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceMiniRestful(java.lang.String r34, java.lang.String r35, int r36, java.lang.Integer r37, int r38, java.lang.String r39, java.lang.String r40, com.blueair.core.model.DeviceUuid r41, boolean r42, boolean r43, int r44, long r45, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, int r58, boolean r59, java.lang.String r60, int r61, java.lang.String r62, int r63, int r64, int r65, java.util.List r66, boolean r67, int r68, int r69, kotlin.jvm.internal.DefaultConstructorMarker r70) {
        /*
            r33 = this;
            r0 = r68
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = "Pairing…"
            goto L_0x000b
        L_0x0009:
            r1 = r35
        L_0x000b:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0013
        L_0x0011:
            r2 = r36
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r37
        L_0x001b:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r38
        L_0x0023:
            r7 = r0 & 32
            java.lang.String r8 = ""
            if (r7 == 0) goto L_0x002b
            r7 = r8
            goto L_0x002d
        L_0x002b:
            r7 = r39
        L_0x002d:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0033
            r9 = 0
            goto L_0x0035
        L_0x0033:
            r9 = r40
        L_0x0035:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003b
            r10 = 0
            goto L_0x003d
        L_0x003b:
            r10 = r41
        L_0x003d:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0043
            r11 = 0
            goto L_0x0045
        L_0x0043:
            r11 = r42
        L_0x0045:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x004b
            r12 = 0
            goto L_0x004d
        L_0x004b:
            r12 = r43
        L_0x004d:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            com.blueair.core.model.ConnectivityStatus r13 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r13 = r13.ordinal()
            goto L_0x005a
        L_0x0058:
            r13 = r44
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            r14 = 0
            goto L_0x0063
        L_0x0061:
            r14 = r45
        L_0x0063:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0069
            r3 = r8
            goto L_0x006b
        L_0x0069:
            r3 = r47
        L_0x006b:
            r5 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x0071
            r5 = r8
            goto L_0x0073
        L_0x0071:
            r5 = r48
        L_0x0073:
            r70 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x007b
            r1 = r8
            goto L_0x007d
        L_0x007b:
            r1 = r49
        L_0x007d:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0087
            r16 = r8
            goto L_0x0089
        L_0x0087:
            r16 = r50
        L_0x0089:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0092
            r17 = r8
            goto L_0x0094
        L_0x0092:
            r17 = r51
        L_0x0094:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009d
            r18 = r8
            goto L_0x009f
        L_0x009d:
            r18 = r52
        L_0x009f:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a8
            r19 = r8
            goto L_0x00aa
        L_0x00a8:
            r19 = r53
        L_0x00aa:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b3
            r20 = r8
            goto L_0x00b5
        L_0x00b3:
            r20 = r54
        L_0x00b5:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00be
            r21 = r8
            goto L_0x00c0
        L_0x00be:
            r21 = r55
        L_0x00c0:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c9
            r22 = r8
            goto L_0x00cb
        L_0x00c9:
            r22 = r56
        L_0x00cb:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d4
            r23 = r8
            goto L_0x00d6
        L_0x00d4:
            r23 = r57
        L_0x00d6:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00df
            r24 = 0
            goto L_0x00e1
        L_0x00df:
            r24 = r58
        L_0x00e1:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00ea
            r25 = 0
            goto L_0x00ec
        L_0x00ea:
            r25 = r59
        L_0x00ec:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r8 = r60
        L_0x00f5:
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x0102
            com.blueair.core.model.DeviceType$MiniRestful r26 = com.blueair.core.model.DeviceType.MiniRestful.INSTANCE
            int r26 = r26.getIndex()
            goto L_0x0104
        L_0x0102:
            r26 = r61
        L_0x0104:
            r27 = 134217728(0x8000000, float:3.85186E-34)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x010d
            r27 = 0
            goto L_0x010f
        L_0x010d:
            r27 = r62
        L_0x010f:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0118
            r28 = 0
            goto L_0x011a
        L_0x0118:
            r28 = r63
        L_0x011a:
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0123
            r29 = 2
            goto L_0x0125
        L_0x0123:
            r29 = r64
        L_0x0125:
            r30 = 1073741824(0x40000000, float:2.0)
            r30 = r0 & r30
            r31 = 1
            if (r30 == 0) goto L_0x0130
            r30 = r31
            goto L_0x0132
        L_0x0130:
            r30 = r65
        L_0x0132:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x0150
            java.util.ArrayList r0 = new java.util.ArrayList
            r37 = r1
            r1 = 6
            r0.<init>(r1)
            r32 = r2
            r2 = 0
        L_0x0143:
            if (r2 >= r1) goto L_0x014d
            r1 = 0
            r0.add(r1)
            int r2 = r2 + 1
            r1 = 6
            goto L_0x0143
        L_0x014d:
            java.util.List r0 = (java.util.List) r0
            goto L_0x0156
        L_0x0150:
            r37 = r1
            r32 = r2
            r0 = r66
        L_0x0156:
            r1 = r69 & 1
            if (r1 == 0) goto L_0x015d
            r69 = r31
            goto L_0x015f
        L_0x015d:
            r69 = r67
        L_0x015f:
            r35 = r33
            r36 = r34
            r51 = r37
            r37 = r70
            r68 = r0
            r49 = r3
            r39 = r4
            r50 = r5
            r40 = r6
            r41 = r7
            r62 = r8
            r42 = r9
            r43 = r10
            r44 = r11
            r45 = r12
            r46 = r13
            r47 = r14
            r52 = r16
            r53 = r17
            r54 = r18
            r55 = r19
            r56 = r20
            r57 = r21
            r58 = r22
            r59 = r23
            r60 = r24
            r61 = r25
            r63 = r26
            r64 = r27
            r65 = r28
            r66 = r29
            r67 = r30
            r38 = r32
            r35.<init>(r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceMiniRestful.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, java.lang.String, int, java.lang.String, int, int, int, java.util.List, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getName() {
        return this.name;
    }

    public int getFanSpeed() {
        return this.fanSpeed;
    }

    public Integer getFilterLife() {
        return this.filterLife;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getAutoModeText() {
        return this.autoModeText;
    }

    public String getInfo() {
        return this.info;
    }

    public DeviceUuid getDeviceUuid() {
        return this.deviceUuid;
    }

    public boolean getHasFinishedOnboarding() {
        return this.hasFinishedOnboarding;
    }

    public boolean isChildLockOn() {
        return this.isChildLockOn;
    }

    public int getConnectivityStatusIndex() {
        return this.connectivityStatusIndex;
    }

    public long getLastConnectivityInMillis() {
        return this.lastConnectivityInMillis;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMcuFirmware() {
        return this.mcuFirmware;
    }

    public String getWifiFirmware() {
        return this.wifiFirmware;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getPurchaseDate() {
        return this.purchaseDate;
    }

    public String getDealerName() {
        return this.dealerName;
    }

    public String getDealerCountry() {
        return this.dealerCountry;
    }

    public String getFilterType() {
        return this.filterType;
    }

    public String getFilterTrigger() {
        return this.filterTrigger;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }

    public boolean isStandByOn() {
        return this.isStandByOn;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public String getSku() {
        return this.sku;
    }

    public int getMainMode() {
        return this.mainMode;
    }

    public int getApSubMode() {
        return this.apSubMode;
    }

    public int getNightLampSteplessBrightness() {
        return this.nightLampSteplessBrightness;
    }

    public List<DeviceAlarm> getAlarms() {
        return this.alarms;
    }

    public boolean getUse24Hour() {
        return this.use24Hour;
    }

    public final boolean hasNightMode() {
        return McuFirmwareVersions.Companion.compare(getMcuFirmware(), SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestNightModeV2()) >= 0;
    }
}
