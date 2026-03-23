package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.util.AblWifFirmwareUtils;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b[\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nBÓ\u0002\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\f\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\b\b\u0002\u0010%\u001a\u00020\f\u0012\b\b\u0002\u0010&\u001a\u00020\f\u0012\b\b\u0002\u0010'\u001a\u00020\f\u0012\b\b\u0002\u0010(\u001a\u00020)\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010+\u001a\u00020)\u0012\b\b\u0002\u0010,\u001a\u00020)\u0012\b\b\u0002\u0010-\u001a\u00020)\u0012\b\b\u0002\u0010.\u001a\u00020\u000f\u0012\u0006\u0010/\u001a\u00020\f\u0012\b\b\u0002\u00100\u001a\u00020\u0018\u0012\b\u00101\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b2\u00103J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003J\t\u0010a\u001a\u00020\u000fHÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010:J\t\u0010c\u001a\u00020\u000fHÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010g\u001a\u00020\u000fHÆ\u0003J\t\u0010h\u001a\u00020\u0018HÆ\u0003J\t\u0010i\u001a\u00020\u0018HÆ\u0003J\t\u0010j\u001a\u00020\u000fHÆ\u0003J\t\u0010k\u001a\u00020\u001cHÆ\u0003J\t\u0010l\u001a\u00020\fHÆ\u0003J\t\u0010m\u001a\u00020\fHÆ\u0003J\t\u0010n\u001a\u00020\fHÆ\u0003J\t\u0010o\u001a\u00020\fHÆ\u0003J\t\u0010p\u001a\u00020\fHÆ\u0003J\t\u0010q\u001a\u00020\fHÆ\u0003J\t\u0010r\u001a\u00020\fHÆ\u0003J\t\u0010s\u001a\u00020\fHÆ\u0003J\t\u0010t\u001a\u00020\fHÆ\u0003J\t\u0010u\u001a\u00020\fHÆ\u0003J\t\u0010v\u001a\u00020\fHÆ\u0003J\t\u0010w\u001a\u00020)HÆ\u0003J\t\u0010x\u001a\u00020)HÆ\u0003J\t\u0010y\u001a\u00020)HÆ\u0003J\t\u0010z\u001a\u00020)HÆ\u0003J\t\u0010{\u001a\u00020)HÆ\u0003J\t\u0010|\u001a\u00020\u000fHÆ\u0003J\t\u0010}\u001a\u00020\fHÆ\u0003J\t\u0010~\u001a\u00020\u0018HÆ\u0003J\u000b\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003Jâ\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\f2\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)2\b\b\u0002\u0010,\u001a\u00020)2\b\b\u0002\u0010-\u001a\u00020)2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\u00182\n\b\u0002\u00101\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u000fJ\u0016\u0010\u0001\u001a\u00020\u00182\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÖ\u0001J\n\u0010\u0001\u001a\u00020\fHÖ\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u000fR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u0010\r\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0014\u0010\u0011\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u0014\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010\u0016\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00108R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010BR\u0014\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010BR\u0014\u0010\u001a\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00108R\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010\u001d\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00105R\u0014\u0010\u001e\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00105R\u0014\u0010\u001f\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00105R\u0014\u0010 \u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00105R\u0014\u0010!\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00105R\u0014\u0010\"\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0014\u0010#\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00105R\u0014\u0010$\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00105R\u0014\u0010%\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00105R\u0014\u0010&\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00105R\u0014\u0010'\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00105R\u0014\u0010(\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010*\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010RR\u0014\u0010+\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010RR\u0014\u0010,\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010RR\u0014\u0010-\u001a\u00020)X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010RR\u0014\u0010.\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u00108R\u0014\u0010/\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u00105R\u0011\u00100\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bY\u0010BR\u0016\u00101\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u00105R\u0014\u0010[\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u00108R\u0014\u0010]\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010B¨\u0006\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceClassic;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasNightMode;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isNightmodeOn", "", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "modelName", "hasNewSensors", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;ZLjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getModelName", "getHasNewSensors", "getCompatibility", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;ZLjava/lang/String;)Lcom/blueair/core/model/DeviceClassic;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceClassic implements Device, HasFanSpeed, HasBrightness, HasInfo, HasAblCloudFunctions, HasSensorData, HasNightMode, HasChildLock, HasScheduling, HasCompatibility {
    public static final Parcelable.Creator<DeviceClassic> CREATOR = new Creator();
    private final String autoModeText;
    private final int brightness;
    private final String compatibility;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String hardware;
    private final boolean hasNewSensors;
    private final double[] hchoRanges;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isNightmodeOn;
    private final long lastConnectivityInMillis;
    private final int lastSelectedSensorTypeIndex;
    private final IndoorDatapoint latestSensorDatapoint;
    private final String mac;
    private final String mcuFirmware;
    private final String modelName;
    private final String name;
    private final double[] pm10Ranges;
    private final double[] pm1Ranges;
    private final double[] pm25Ranges;
    private final String purchaseDate;
    private final String serial;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceClassic> {
        public final DeviceClassic createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            IndoorDatapoint indoorDatapoint = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                indoorDatapoint = IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            }
            IndoorDatapoint indoorDatapoint2 = indoorDatapoint;
            int readInt3 = parcel2.readInt();
            boolean z3 = true;
            boolean z4 = false;
            if (parcel2.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (parcel2.readInt() != 0) {
                z2 = false;
                z4 = z;
            } else {
                z2 = false;
            }
            boolean z5 = z2;
            int readInt4 = parcel2.readInt();
            long readLong = parcel2.readLong();
            boolean z6 = z5;
            String readString5 = parcel2.readString();
            boolean z7 = z6;
            String readString6 = parcel2.readString();
            boolean z8 = z7;
            String readString7 = parcel2.readString();
            boolean z9 = z8;
            String readString8 = parcel2.readString();
            boolean z10 = z9;
            String readString9 = parcel2.readString();
            boolean z11 = z10;
            String readString10 = parcel2.readString();
            boolean z12 = z11;
            String readString11 = parcel2.readString();
            boolean z13 = z12;
            String readString12 = parcel2.readString();
            boolean z14 = z13;
            String readString13 = parcel2.readString();
            boolean z15 = z14;
            String readString14 = parcel2.readString();
            boolean z16 = z15;
            String readString15 = parcel2.readString();
            boolean z17 = z16;
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z18 = z17;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z19 = z18;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z20 = z19;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z21 = z20;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z22 = z21;
            int readInt5 = parcel2.readInt();
            boolean z23 = z22;
            String readString16 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                z23 = z;
            }
            return new DeviceClassic(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, indoorDatapoint2, readInt3, z3, z4, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, readString16, z23, parcel2.readString());
        }

        public final DeviceClassic[] newArray(int i) {
            return new DeviceClassic[i];
        }
    }

    public static /* synthetic */ DeviceClassic copy$default(DeviceClassic deviceClassic, String str, String str2, int i, Integer num, int i2, String str3, String str4, IndoorDatapoint indoorDatapoint, int i3, boolean z, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, String str16, boolean z3, String str17, int i6, int i7, Object obj) {
        String str18;
        boolean z4;
        String str19;
        int i8;
        double[] dArr6;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
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
        int i9;
        boolean z5;
        boolean z6;
        int i10;
        IndoorDatapoint indoorDatapoint2;
        String str31;
        String str32;
        int i11;
        Integer num2;
        int i12;
        String str33;
        DeviceClassic deviceClassic2 = deviceClassic;
        int i13 = i6;
        String str34 = (i13 & 1) != 0 ? deviceClassic2.uid : str;
        String str35 = (i13 & 2) != 0 ? deviceClassic2.name : str2;
        int i14 = (i13 & 4) != 0 ? deviceClassic2.fanSpeed : i;
        Integer num3 = (i13 & 8) != 0 ? deviceClassic2.filterLife : num;
        int i15 = (i13 & 16) != 0 ? deviceClassic2.brightness : i2;
        String str36 = (i13 & 32) != 0 ? deviceClassic2.autoModeText : str3;
        String str37 = (i13 & 64) != 0 ? deviceClassic2.info : str4;
        IndoorDatapoint indoorDatapoint3 = (i13 & 128) != 0 ? deviceClassic2.latestSensorDatapoint : indoorDatapoint;
        int i16 = (i13 & 256) != 0 ? deviceClassic2.lastSelectedSensorTypeIndex : i3;
        boolean z7 = (i13 & 512) != 0 ? deviceClassic2.isNightmodeOn : z;
        boolean z8 = (i13 & 1024) != 0 ? deviceClassic2.isChildLockOn : z2;
        int i17 = (i13 & 2048) != 0 ? deviceClassic2.connectivityStatusIndex : i4;
        long j3 = (i13 & 4096) != 0 ? deviceClassic2.lastConnectivityInMillis : j;
        String str38 = str34;
        String str39 = (i13 & 8192) != 0 ? deviceClassic2.mac : str5;
        String str40 = (i13 & 16384) != 0 ? deviceClassic2.mcuFirmware : str6;
        String str41 = (i13 & 32768) != 0 ? deviceClassic2.wifiFirmware : str7;
        String str42 = (i6 & 65536) != 0 ? deviceClassic2.hardware : str8;
        String str43 = (i6 & 131072) != 0 ? deviceClassic2.timeZone : str9;
        String str44 = (i6 & 262144) != 0 ? deviceClassic2.serial : str10;
        String str45 = (i6 & 524288) != 0 ? deviceClassic2.purchaseDate : str11;
        String str46 = (i6 & 1048576) != 0 ? deviceClassic2.dealerName : str12;
        String str47 = (i6 & 2097152) != 0 ? deviceClassic2.dealerCountry : str13;
        String str48 = (i6 & 4194304) != 0 ? deviceClassic2.filterType : str14;
        String str49 = (i6 & 8388608) != 0 ? deviceClassic2.filterTrigger : str15;
        double[] dArr11 = (i6 & 16777216) != 0 ? deviceClassic2.pm1Ranges : dArr;
        double[] dArr12 = (i6 & 33554432) != 0 ? deviceClassic2.pm10Ranges : dArr2;
        double[] dArr13 = (i6 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceClassic2.pm25Ranges : dArr3;
        double[] dArr14 = (i6 & 134217728) != 0 ? deviceClassic2.vocRanges : dArr4;
        double[] dArr15 = (i6 & 268435456) != 0 ? deviceClassic2.hchoRanges : dArr5;
        int i18 = (i6 & 536870912) != 0 ? deviceClassic2.updateProgress : i5;
        String str50 = (i6 & 1073741824) != 0 ? deviceClassic2.modelName : str16;
        boolean z9 = (i6 & Integer.MIN_VALUE) != 0 ? deviceClassic2.hasNewSensors : z3;
        if ((i7 & 1) != 0) {
            z4 = z9;
            str18 = deviceClassic2.compatibility;
            str26 = str43;
            str25 = str44;
            str24 = str45;
            str23 = str46;
            str22 = str47;
            str21 = str48;
            str20 = str49;
            dArr10 = dArr11;
            dArr9 = dArr12;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            i8 = i18;
            str19 = str50;
            str29 = str40;
            num2 = num3;
            i11 = i15;
            str32 = str36;
            str31 = str37;
            indoorDatapoint2 = indoorDatapoint3;
            i10 = i16;
            z6 = z7;
            z5 = z8;
            i9 = i17;
            j2 = j3;
            str30 = str39;
            str28 = str41;
            str27 = str42;
            str33 = str35;
            i12 = i14;
        } else {
            str18 = str17;
            z4 = z9;
            str27 = str42;
            str26 = str43;
            str25 = str44;
            str24 = str45;
            str23 = str46;
            str22 = str47;
            str21 = str48;
            str20 = str49;
            dArr10 = dArr11;
            dArr9 = dArr12;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            i8 = i18;
            str19 = str50;
            str29 = str40;
            i12 = i14;
            num2 = num3;
            i11 = i15;
            str32 = str36;
            str31 = str37;
            indoorDatapoint2 = indoorDatapoint3;
            i10 = i16;
            z6 = z7;
            z5 = z8;
            i9 = i17;
            j2 = j3;
            str30 = str39;
            str28 = str41;
            str33 = str35;
        }
        return deviceClassic2.copy(str38, str33, i12, num2, i11, str32, str31, indoorDatapoint2, i10, z6, z5, i9, j2, str30, str29, str28, str27, str26, str25, str24, str23, str22, str21, str20, dArr10, dArr9, dArr8, dArr7, dArr6, i8, str19, z4, str18);
    }

    public final String component1() {
        return this.uid;
    }

    public final boolean component10() {
        return this.isNightmodeOn;
    }

    public final boolean component11() {
        return this.isChildLockOn;
    }

    public final int component12() {
        return this.connectivityStatusIndex;
    }

    public final long component13() {
        return this.lastConnectivityInMillis;
    }

    public final String component14() {
        return this.mac;
    }

    public final String component15() {
        return this.mcuFirmware;
    }

    public final String component16() {
        return this.wifiFirmware;
    }

    public final String component17() {
        return this.hardware;
    }

    public final String component18() {
        return this.timeZone;
    }

    public final String component19() {
        return this.serial;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.purchaseDate;
    }

    public final String component21() {
        return this.dealerName;
    }

    public final String component22() {
        return this.dealerCountry;
    }

    public final String component23() {
        return this.filterType;
    }

    public final String component24() {
        return this.filterTrigger;
    }

    public final double[] component25() {
        return this.pm1Ranges;
    }

    public final double[] component26() {
        return this.pm10Ranges;
    }

    public final double[] component27() {
        return this.pm25Ranges;
    }

    public final double[] component28() {
        return this.vocRanges;
    }

    public final double[] component29() {
        return this.hchoRanges;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final int component30() {
        return this.updateProgress;
    }

    public final String component31() {
        return this.modelName;
    }

    public final boolean component32() {
        return this.hasNewSensors;
    }

    public final String component33() {
        return this.compatibility;
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

    public final IndoorDatapoint component8() {
        return this.latestSensorDatapoint;
    }

    public final int component9() {
        return this.lastSelectedSensorTypeIndex;
    }

    public final DeviceClassic copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, IndoorDatapoint indoorDatapoint, int i3, boolean z, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, String str16, boolean z3, String str17) {
        String str18 = str;
        Intrinsics.checkNotNullParameter(str18, "uid");
        String str19 = str2;
        Intrinsics.checkNotNullParameter(str19, "name");
        String str20 = str3;
        Intrinsics.checkNotNullParameter(str20, "autoModeText");
        Intrinsics.checkNotNullParameter(str5, AnalyticEvent.KEY_MAC);
        String str21 = str6;
        Intrinsics.checkNotNullParameter(str21, "mcuFirmware");
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
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "modelName");
        String str31 = str21;
        String str32 = str22;
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        return new DeviceClassic(str18, str19, i, num, i2, str20, str4, indoorDatapoint, i3, z, z2, i4, j, str5, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, dArr6, dArr2, dArr3, dArr4, dArr5, i5, str16, z3, str17);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceClassic)) {
            return false;
        }
        DeviceClassic deviceClassic = (DeviceClassic) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceClassic.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceClassic.name) && this.fanSpeed == deviceClassic.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceClassic.filterLife) && this.brightness == deviceClassic.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceClassic.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceClassic.info) && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceClassic.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceClassic.lastSelectedSensorTypeIndex && this.isNightmodeOn == deviceClassic.isNightmodeOn && this.isChildLockOn == deviceClassic.isChildLockOn && this.connectivityStatusIndex == deviceClassic.connectivityStatusIndex && this.lastConnectivityInMillis == deviceClassic.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceClassic.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceClassic.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceClassic.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceClassic.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceClassic.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceClassic.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceClassic.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceClassic.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceClassic.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceClassic.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceClassic.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceClassic.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceClassic.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceClassic.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceClassic.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceClassic.hchoRanges) && this.updateProgress == deviceClassic.updateProgress && Intrinsics.areEqual((Object) this.modelName, (Object) deviceClassic.modelName) && this.hasNewSensors == deviceClassic.hasNewSensors && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceClassic.compatibility);
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode4 = (((((((((((((((((((((((((((((((((((((((((((((((((hashCode3 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isNightmodeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + this.modelName.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasNewSensors)) * 31;
        String str2 = this.compatibility;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceClassic(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isNightmodeOn=" + this.isNightmodeOn + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", modelName=" + this.modelName + ", hasNewSensors=" + this.hasNewSensors + ", compatibility=" + this.compatibility + ')';
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
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        if (indoorDatapoint == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            indoorDatapoint.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.lastSelectedSensorTypeIndex);
        parcel.writeInt(this.isNightmodeOn ? 1 : 0);
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
        parcel.writeDoubleArray(this.pm1Ranges);
        parcel.writeDoubleArray(this.pm10Ranges);
        parcel.writeDoubleArray(this.pm25Ranges);
        parcel.writeDoubleArray(this.vocRanges);
        parcel.writeDoubleArray(this.hchoRanges);
        parcel.writeInt(this.updateProgress);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.hasNewSensors ? 1 : 0);
        parcel.writeString(this.compatibility);
    }

    public double[] airRatingsFor(SensorType sensorType) {
        return HasSensorData.CC.$default$airRatingsFor(this, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(double d, SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, d, sensorType);
    }

    public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType sensorType) {
        return HasSensorData.CC.$default$aqiFor(this, sensorType);
    }

    public IndoorAirRatingRanges getAirRatingRanges() {
        return HasSensorData.CC.$default$getAirRatingRanges(this);
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

    public SensorType getLastSelectedSensorType() {
        return HasSensorData.CC.$default$getLastSelectedSensorType(this);
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

    public boolean isOnline() {
        return Device.CC.$default$isOnline(this);
    }

    public boolean isUsDevice() {
        return Device.CC.$default$isUsDevice(this);
    }

    public boolean supports(SensorType sensorType) {
        return HasSensorData.CC.$default$supports(this, sensorType);
    }

    public DeviceClassic(String str, String str2, int i, Integer num, int i2, String str3, String str4, IndoorDatapoint indoorDatapoint, int i3, boolean z, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, String str16, boolean z3, String str17) {
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
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        String str32 = str16;
        Intrinsics.checkNotNullParameter(str32, "modelName");
        this.uid = str18;
        this.name = str19;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str20;
        this.info = str4;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i3;
        this.isNightmodeOn = z;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i4;
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
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i5;
        this.modelName = str32;
        this.hasNewSensors = z3;
        this.compatibility = str17;
        this.typeIndex = DeviceType.Classic.INSTANCE.getIndex();
    }

    public String getUid() {
        return this.uid;
    }

    public /* synthetic */ DeviceClassic(String str, String str2, int i, Integer num, int i2, String str3, String str4, IndoorDatapoint indoorDatapoint, int i3, boolean z, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, String str16, boolean z3, String str17, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        String str18;
        String str19;
        boolean z4;
        String str20;
        String str21;
        String str22;
        DeviceClassic deviceClassic;
        int i8 = i6;
        String str23 = (i8 & 2) != 0 ? "todo" : str2;
        int i9 = (i8 & 4) != 0 ? 0 : i;
        Integer num2 = (i8 & 8) != 0 ? null : num;
        int i10 = (i8 & 16) != 0 ? 0 : i2;
        if ((i8 & 32) != 0) {
            str18 = "";
        } else {
            str18 = str3;
        }
        String str24 = (i8 & 64) != 0 ? null : str4;
        IndoorDatapoint indoorDatapoint2 = (i8 & 128) != 0 ? null : indoorDatapoint;
        int i11 = (i8 & 256) != 0 ? 0 : i3;
        boolean z5 = (i8 & 512) != 0 ? false : z;
        boolean z6 = (i8 & 1024) != 0 ? false : z2;
        int ordinal = (i8 & 2048) != 0 ? ConnectivityStatus.ONLINE.ordinal() : i4;
        long j2 = (i8 & 4096) != 0 ? 0 : j;
        String str25 = (i8 & 8192) != 0 ? "" : str5;
        String str26 = (i8 & 16384) != 0 ? "" : str6;
        String str27 = (32768 & i8) != 0 ? "" : str7;
        String str28 = (65536 & i8) != 0 ? "" : str8;
        String str29 = (131072 & i8) != 0 ? "" : str9;
        String str30 = (262144 & i8) != 0 ? "" : str10;
        String str31 = (524288 & i8) != 0 ? "" : str11;
        String str32 = (1048576 & i8) != 0 ? "" : str12;
        String str33 = (2097152 & i8) != 0 ? "" : str13;
        String str34 = (4194304 & i8) != 0 ? "" : str14;
        String str35 = (8388608 & i8) != 0 ? "" : str15;
        double[] dArr6 = (16777216 & i8) != 0 ? new double[0] : dArr;
        double[] dArr7 = (33554432 & i8) != 0 ? new double[0] : dArr2;
        double[] dArr8 = (67108864 & i8) != 0 ? new double[0] : dArr3;
        double[] dArr9 = (134217728 & i8) != 0 ? new double[0] : dArr4;
        double[] dArr10 = (268435456 & i8) != 0 ? new double[0] : dArr5;
        int i12 = (536870912 & i8) != 0 ? 0 : i5;
        if ((i8 & Integer.MIN_VALUE) != 0) {
            z4 = false;
            str22 = str;
            str20 = str16;
            str19 = str17;
            str21 = str18;
            deviceClassic = this;
        } else {
            z4 = z3;
            deviceClassic = this;
            str22 = str;
            str20 = str16;
            str19 = str17;
            str21 = str18;
        }
        new DeviceClassic(str22, str23, i9, num2, i10, str21, str24, indoorDatapoint2, i11, z5, z6, ordinal, j2, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, dArr6, dArr7, dArr8, dArr9, dArr10, i12, str20, z4, str19);
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

    public IndoorDatapoint getLatestSensorDatapoint() {
        return this.latestSensorDatapoint;
    }

    public int getLastSelectedSensorTypeIndex() {
        return this.lastSelectedSensorTypeIndex;
    }

    public boolean isNightmodeOn() {
        return this.isNightmodeOn;
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

    public double[] getPm1Ranges() {
        return this.pm1Ranges;
    }

    public double[] getPm10Ranges() {
        return this.pm10Ranges;
    }

    public double[] getPm25Ranges() {
        return this.pm25Ranges;
    }

    public double[] getVocRanges() {
        return this.vocRanges;
    }

    public double[] getHchoRanges() {
        return this.hchoRanges;
    }

    public int getUpdateProgress() {
        return this.updateProgress;
    }

    public String getModelName() {
        return this.modelName;
    }

    public final boolean getHasNewSensors() {
        return this.hasNewSensors;
    }

    public String getCompatibility() {
        return this.compatibility;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }

    public boolean getHasAtLeastMinimumFirmwareVersion() {
        return AblWifFirmwareUtils.INSTANCE.hasAtLeastMinimumWifiFirmwareVersion(this, AblWifFirmwareUtils.DEVICE_CLASSIC_MINIMUM_FIRMWARE_VERSION);
    }
}
