package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\bT\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB©\u0002\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010\u001e\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\b\b\u0002\u0010\"\u001a\u00020\n\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010'\u001a\u00020%\u0012\b\b\u0002\u0010(\u001a\u00020%\u0012\b\b\u0002\u0010)\u001a\u00020%\u0012\b\b\u0002\u0010*\u001a\u00020\r\u0012\b\u0010+\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b,\u0010-J\t\u0010X\u001a\u00020\nHÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\rHÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\t\u0010\\\u001a\u00020\nHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010_\u001a\u00020\rHÆ\u0003J\t\u0010`\u001a\u00020\u0015HÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\t\u0010b\u001a\u00020\u0018HÆ\u0003J\t\u0010c\u001a\u00020\nHÆ\u0003J\t\u0010d\u001a\u00020\nHÆ\u0003J\t\u0010e\u001a\u00020\nHÆ\u0003J\t\u0010f\u001a\u00020\nHÆ\u0003J\t\u0010g\u001a\u00020\nHÆ\u0003J\t\u0010h\u001a\u00020\nHÆ\u0003J\t\u0010i\u001a\u00020\nHÆ\u0003J\t\u0010j\u001a\u00020\nHÆ\u0003J\t\u0010k\u001a\u00020\nHÆ\u0003J\t\u0010l\u001a\u00020\nHÆ\u0003J\t\u0010m\u001a\u00020\nHÆ\u0003J\t\u0010n\u001a\u00020%HÆ\u0003J\t\u0010o\u001a\u00020%HÆ\u0003J\t\u0010p\u001a\u00020%HÆ\u0003J\t\u0010q\u001a\u00020%HÆ\u0003J\t\u0010r\u001a\u00020%HÆ\u0003J\t\u0010s\u001a\u00020\rHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\nHÆ\u0003J¸\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020%2\b\b\u0002\u0010*\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010vJ\u0006\u0010w\u001a\u00020\rJ\u0013\u0010x\u001a\u00020\u00152\b\u0010y\u001a\u0004\u0018\u00010zHÖ\u0003J\t\u0010{\u001a\u00020\rHÖ\u0001J\t\u0010|\u001a\u00020\nHÖ\u0001J\u0018\u0010}\u001a\u00020~2\u0007\u0010\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\rR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0014\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010;R\u0014\u0010\u0016\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010\u0019\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u0014\u0010\u001a\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0014\u0010\u001b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0014\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/R\u0014\u0010\u001d\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0014\u0010\u001e\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010/R\u0014\u0010\u001f\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010/R\u0014\u0010 \u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010/R\u0014\u0010!\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010/R\u0014\u0010\"\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010/R\u0014\u0010#\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010/R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0014\u0010&\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010KR\u0014\u0010'\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010KR\u0014\u0010(\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010KR\u0014\u0010)\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u0014\u0010*\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0016\u0010+\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010/R\u0014\u0010R\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010/R\u0014\u0010T\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u00102R\u0014\u0010V\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010;¨\u0006\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceIcp;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasAblCloudFunctions;", "Lcom/blueair/core/model/HasBleFunctions;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasCompatibility;", "uid", "", "name", "fanSpeed", "", "filterLife", "autoModeText", "info", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "compatibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAutoModeText", "getInfo", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getCompatibility", "modelName", "getModelName", "typeIndex", "getTypeIndex", "hasAtLeastMinimumFirmwareVersion", "getHasAtLeastMinimumFirmwareVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DILjava/lang/String;)Lcom/blueair/core/model/DeviceIcp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceIcp implements Device, HasFanSpeed, HasInfo, HasAblCloudFunctions, HasBleFunctions, HasSensorData, HasChildLock, HasCompatibility {
    public static final Parcelable.Creator<DeviceIcp> CREATOR = new Creator();
    private final String autoModeText;
    private final String compatibility;
    private final int connectivityStatusIndex;
    private final String dealerCountry;
    private final String dealerName;
    private final int fanSpeed;
    private final Integer filterLife;
    private final String filterTrigger;
    private final String filterType;
    private final String hardware;
    private final double[] hchoRanges;
    private final String info;
    private final boolean isChildLockOn;
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
    public static final class Creator implements Parcelable.Creator<DeviceIcp> {
        public final DeviceIcp createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            IndoorDatapoint indoorDatapoint = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                indoorDatapoint = IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            }
            return new DeviceIcp(readString, readString2, readInt, valueOf, readString3, readString4, indoorDatapoint, parcel2.readInt(), parcel2.readInt() != 0, parcel2.readInt(), parcel2.readLong(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.createDoubleArray(), parcel2.readInt(), parcel2.readString());
        }

        public final DeviceIcp[] newArray(int i) {
            return new DeviceIcp[i];
        }
    }

    public static /* synthetic */ DeviceIcp copy$default(DeviceIcp deviceIcp, String str, String str2, int i, Integer num, String str3, String str4, IndoorDatapoint indoorDatapoint, int i2, boolean z, int i3, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i4, String str16, int i5, Object obj) {
        String str17;
        int i6;
        DeviceIcp deviceIcp2 = deviceIcp;
        int i7 = i5;
        String str18 = (i7 & 1) != 0 ? deviceIcp2.uid : str;
        String str19 = (i7 & 2) != 0 ? deviceIcp2.name : str2;
        int i8 = (i7 & 4) != 0 ? deviceIcp2.fanSpeed : i;
        Integer num2 = (i7 & 8) != 0 ? deviceIcp2.filterLife : num;
        String str20 = (i7 & 16) != 0 ? deviceIcp2.autoModeText : str3;
        String str21 = (i7 & 32) != 0 ? deviceIcp2.info : str4;
        IndoorDatapoint indoorDatapoint2 = (i7 & 64) != 0 ? deviceIcp2.latestSensorDatapoint : indoorDatapoint;
        int i9 = (i7 & 128) != 0 ? deviceIcp2.lastSelectedSensorTypeIndex : i2;
        boolean z2 = (i7 & 256) != 0 ? deviceIcp2.isChildLockOn : z;
        int i10 = (i7 & 512) != 0 ? deviceIcp2.connectivityStatusIndex : i3;
        long j2 = (i7 & 1024) != 0 ? deviceIcp2.lastConnectivityInMillis : j;
        String str22 = (i7 & 2048) != 0 ? deviceIcp2.mac : str5;
        String str23 = (i7 & 4096) != 0 ? deviceIcp2.mcuFirmware : str6;
        String str24 = str18;
        String str25 = (i7 & 8192) != 0 ? deviceIcp2.wifiFirmware : str7;
        String str26 = (i7 & 16384) != 0 ? deviceIcp2.hardware : str8;
        String str27 = (i7 & 32768) != 0 ? deviceIcp2.timeZone : str9;
        String str28 = (i5 & 65536) != 0 ? deviceIcp2.serial : str10;
        String str29 = (i5 & 131072) != 0 ? deviceIcp2.purchaseDate : str11;
        String str30 = (i5 & 262144) != 0 ? deviceIcp2.dealerName : str12;
        String str31 = (i5 & 524288) != 0 ? deviceIcp2.dealerCountry : str13;
        String str32 = (i5 & 1048576) != 0 ? deviceIcp2.filterType : str14;
        String str33 = (i5 & 2097152) != 0 ? deviceIcp2.filterTrigger : str15;
        double[] dArr6 = (i5 & 4194304) != 0 ? deviceIcp2.pm1Ranges : dArr;
        double[] dArr7 = (i5 & 8388608) != 0 ? deviceIcp2.pm10Ranges : dArr2;
        double[] dArr8 = (i5 & 16777216) != 0 ? deviceIcp2.pm25Ranges : dArr3;
        double[] dArr9 = (i5 & 33554432) != 0 ? deviceIcp2.vocRanges : dArr4;
        double[] dArr10 = (i5 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceIcp2.hchoRanges : dArr5;
        int i11 = (i5 & 134217728) != 0 ? deviceIcp2.updateProgress : i4;
        if ((i5 & 268435456) != 0) {
            i6 = i11;
            str17 = deviceIcp2.compatibility;
        } else {
            str17 = str16;
            i6 = i11;
        }
        return deviceIcp2.copy(str24, str19, i8, num2, str20, str21, indoorDatapoint2, i9, z2, i10, j2, str22, str23, str25, str26, str27, str28, str29, str30, str31, str32, str33, dArr6, dArr7, dArr8, dArr9, dArr10, i6, str17);
    }

    public final String component1() {
        return this.uid;
    }

    public final int component10() {
        return this.connectivityStatusIndex;
    }

    public final long component11() {
        return this.lastConnectivityInMillis;
    }

    public final String component12() {
        return this.mac;
    }

    public final String component13() {
        return this.mcuFirmware;
    }

    public final String component14() {
        return this.wifiFirmware;
    }

    public final String component15() {
        return this.hardware;
    }

    public final String component16() {
        return this.timeZone;
    }

    public final String component17() {
        return this.serial;
    }

    public final String component18() {
        return this.purchaseDate;
    }

    public final String component19() {
        return this.dealerName;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.dealerCountry;
    }

    public final String component21() {
        return this.filterType;
    }

    public final String component22() {
        return this.filterTrigger;
    }

    public final double[] component23() {
        return this.pm1Ranges;
    }

    public final double[] component24() {
        return this.pm10Ranges;
    }

    public final double[] component25() {
        return this.pm25Ranges;
    }

    public final double[] component26() {
        return this.vocRanges;
    }

    public final double[] component27() {
        return this.hchoRanges;
    }

    public final int component28() {
        return this.updateProgress;
    }

    public final String component29() {
        return this.compatibility;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final String component5() {
        return this.autoModeText;
    }

    public final String component6() {
        return this.info;
    }

    public final IndoorDatapoint component7() {
        return this.latestSensorDatapoint;
    }

    public final int component8() {
        return this.lastSelectedSensorTypeIndex;
    }

    public final boolean component9() {
        return this.isChildLockOn;
    }

    public final DeviceIcp copy(String str, String str2, int i, Integer num, String str3, String str4, IndoorDatapoint indoorDatapoint, int i2, boolean z, int i3, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i4, String str16) {
        String str17 = str;
        Intrinsics.checkNotNullParameter(str17, "uid");
        String str18 = str2;
        Intrinsics.checkNotNullParameter(str18, "name");
        String str19 = str3;
        Intrinsics.checkNotNullParameter(str19, "autoModeText");
        String str20 = str5;
        Intrinsics.checkNotNullParameter(str20, AnalyticEvent.KEY_MAC);
        String str21 = str6;
        Intrinsics.checkNotNullParameter(str21, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str7, "wifiFirmware");
        String str22 = str8;
        Intrinsics.checkNotNullParameter(str22, "hardware");
        String str23 = str9;
        Intrinsics.checkNotNullParameter(str23, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str24 = str10;
        Intrinsics.checkNotNullParameter(str24, "serial");
        String str25 = str11;
        Intrinsics.checkNotNullParameter(str25, "purchaseDate");
        String str26 = str12;
        Intrinsics.checkNotNullParameter(str26, "dealerName");
        String str27 = str13;
        Intrinsics.checkNotNullParameter(str27, "dealerCountry");
        String str28 = str14;
        Intrinsics.checkNotNullParameter(str28, "filterType");
        String str29 = str15;
        Intrinsics.checkNotNullParameter(str29, "filterTrigger");
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        String str30 = str22;
        String str31 = str23;
        String str32 = str24;
        String str33 = str25;
        String str34 = str26;
        String str35 = str27;
        String str36 = str28;
        String str37 = str29;
        return new DeviceIcp(str17, str18, i, num, str19, str4, indoorDatapoint, i2, z, i3, j, str20, str21, str7, str30, str31, str32, str33, str34, str35, str36, str37, dArr6, dArr2, dArr3, dArr4, dArr5, i4, str16);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceIcp)) {
            return false;
        }
        DeviceIcp deviceIcp = (DeviceIcp) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceIcp.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceIcp.name) && this.fanSpeed == deviceIcp.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceIcp.filterLife) && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceIcp.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceIcp.info) && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceIcp.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceIcp.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceIcp.isChildLockOn && this.connectivityStatusIndex == deviceIcp.connectivityStatusIndex && this.lastConnectivityInMillis == deviceIcp.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceIcp.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceIcp.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceIcp.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceIcp.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceIcp.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceIcp.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceIcp.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceIcp.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceIcp.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceIcp.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceIcp.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceIcp.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceIcp.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceIcp.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceIcp.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceIcp.hchoRanges) && this.updateProgress == deviceIcp.updateProgress && Intrinsics.areEqual((Object) this.compatibility, (Object) deviceIcp.compatibility);
    }

    public boolean getHasAtLeastMinimumFirmwareVersion() {
        return true;
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode4 = (((((((((((((((((((((((((((((((((((((((((((hashCode3 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31;
        String str2 = this.compatibility;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "DeviceIcp(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", compatibility=" + this.compatibility + ')';
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

    public DeviceIcp(String str, String str2, int i, Integer num, String str3, String str4, IndoorDatapoint indoorDatapoint, int i2, boolean z, int i3, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i4, String str16) {
        String str17 = str;
        String str18 = str2;
        String str19 = str3;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        String str30 = str15;
        Intrinsics.checkNotNullParameter(str17, "uid");
        Intrinsics.checkNotNullParameter(str18, "name");
        Intrinsics.checkNotNullParameter(str19, "autoModeText");
        Intrinsics.checkNotNullParameter(str20, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str21, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str22, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str23, "hardware");
        Intrinsics.checkNotNullParameter(str24, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str25, "serial");
        Intrinsics.checkNotNullParameter(str26, "purchaseDate");
        Intrinsics.checkNotNullParameter(str27, "dealerName");
        Intrinsics.checkNotNullParameter(str28, "dealerCountry");
        Intrinsics.checkNotNullParameter(str29, "filterType");
        Intrinsics.checkNotNullParameter(str30, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        double[] dArr6 = dArr5;
        Intrinsics.checkNotNullParameter(dArr6, "hchoRanges");
        this.uid = str17;
        this.name = str18;
        this.fanSpeed = i;
        this.filterLife = num;
        this.autoModeText = str19;
        this.info = str4;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i2;
        this.isChildLockOn = z;
        this.connectivityStatusIndex = i3;
        this.lastConnectivityInMillis = j;
        this.mac = str20;
        this.mcuFirmware = str21;
        this.wifiFirmware = str22;
        this.hardware = str23;
        this.timeZone = str24;
        this.serial = str25;
        this.purchaseDate = str26;
        this.dealerName = str27;
        this.dealerCountry = str28;
        this.filterType = str29;
        this.filterTrigger = str30;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr6;
        this.updateProgress = i4;
        this.compatibility = str16;
        this.modelName = DeviceType.Icp.INSTANCE.getName();
        this.typeIndex = DeviceType.Icp.INSTANCE.getIndex();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceIcp(java.lang.String r35, java.lang.String r36, int r37, java.lang.Integer r38, java.lang.String r39, java.lang.String r40, com.blueair.core.model.IndoorDatapoint r41, int r42, boolean r43, int r44, long r45, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, double[] r58, double[] r59, double[] r60, double[] r61, double[] r62, int r63, java.lang.String r64, int r65, kotlin.jvm.internal.DefaultConstructorMarker r66) {
        /*
            r34 = this;
            r0 = r65
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r37
        L_0x000b:
            r1 = r0 & 8
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r7 = r3
            goto L_0x0014
        L_0x0012:
            r7 = r38
        L_0x0014:
            r1 = r0 & 16
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x001c
            r8 = r4
            goto L_0x001e
        L_0x001c:
            r8 = r39
        L_0x001e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0024
            r10 = r3
            goto L_0x0026
        L_0x0024:
            r10 = r41
        L_0x0026:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002c
            r11 = r2
            goto L_0x002e
        L_0x002c:
            r11 = r42
        L_0x002e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0034
            r12 = r2
            goto L_0x0036
        L_0x0034:
            r12 = r43
        L_0x0036:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0042
            com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r1 = r1.ordinal()
            r13 = r1
            goto L_0x0044
        L_0x0042:
            r13 = r44
        L_0x0044:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004b
            r14 = 0
            goto L_0x004d
        L_0x004b:
            r14 = r45
        L_0x004d:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0054
            r16 = r4
            goto L_0x0056
        L_0x0054:
            r16 = r47
        L_0x0056:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x005d
            r17 = r4
            goto L_0x005f
        L_0x005d:
            r17 = r48
        L_0x005f:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0066
            r18 = r4
            goto L_0x0068
        L_0x0066:
            r18 = r49
        L_0x0068:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x006f
            r19 = r4
            goto L_0x0071
        L_0x006f:
            r19 = r50
        L_0x0071:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x007a
            r20 = r4
            goto L_0x007c
        L_0x007a:
            r20 = r51
        L_0x007c:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0084
            r21 = r4
            goto L_0x0086
        L_0x0084:
            r21 = r52
        L_0x0086:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x008e
            r22 = r4
            goto L_0x0090
        L_0x008e:
            r22 = r53
        L_0x0090:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0098
            r23 = r4
            goto L_0x009a
        L_0x0098:
            r23 = r54
        L_0x009a:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a2
            r24 = r4
            goto L_0x00a4
        L_0x00a2:
            r24 = r55
        L_0x00a4:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ac
            r25 = r4
            goto L_0x00ae
        L_0x00ac:
            r25 = r56
        L_0x00ae:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b6
            r26 = r4
            goto L_0x00b8
        L_0x00b6:
            r26 = r57
        L_0x00b8:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c2
            double[] r1 = new double[r2]
            r27 = r1
            goto L_0x00c4
        L_0x00c2:
            r27 = r58
        L_0x00c4:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ce
            double[] r1 = new double[r2]
            r28 = r1
            goto L_0x00d0
        L_0x00ce:
            r28 = r59
        L_0x00d0:
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00da
            double[] r1 = new double[r2]
            r29 = r1
            goto L_0x00dc
        L_0x00da:
            r29 = r60
        L_0x00dc:
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00e6
            double[] r1 = new double[r2]
            r30 = r1
            goto L_0x00e8
        L_0x00e6:
            r30 = r61
        L_0x00e8:
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00f2
            double[] r1 = new double[r2]
            r31 = r1
            goto L_0x00f4
        L_0x00f2:
            r31 = r62
        L_0x00f4:
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00fc
            r32 = r2
            goto L_0x00fe
        L_0x00fc:
            r32 = r63
        L_0x00fe:
            r3 = r34
            r4 = r35
            r5 = r36
            r9 = r40
            r33 = r64
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceIcp.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, java.lang.String, java.lang.String, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getUid() {
        return this.uid;
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

    public String getCompatibility() {
        return this.compatibility;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getTypeIndex() {
        return this.typeIndex;
    }
}
