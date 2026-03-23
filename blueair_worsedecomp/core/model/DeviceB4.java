package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\rB\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u000f\u0012\b\b\u0002\u0010#\u001a\u00020\u000f\u0012\b\b\u0002\u0010$\u001a\u00020\u000f\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\b\b\u0002\u0010(\u001a\u00020\u000f\u0012\b\b\u0002\u0010)\u001a\u00020\u000f\u0012\b\b\u0002\u0010*\u001a\u00020\u000f\u0012\b\b\u0002\u0010+\u001a\u00020\u000f\u0012\b\b\u0002\u0010,\u001a\u00020\u000f\u0012\b\b\u0002\u0010-\u001a\u00020.\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u00100\u001a\u00020.\u0012\b\b\u0002\u00101\u001a\u00020.\u0012\b\b\u0002\u00102\u001a\u00020.\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u00104\u001a\u00020\u001a\u0012\b\b\u0002\u00105\u001a\u00020\u001a\u0012\b\b\u0002\u00106\u001a\u00020\u000f\u0012\b\b\u0002\u00107\u001a\u00020\u000f\u0012\b\b\u0002\u00108\u001a\u00020\u0012\u0012\b\u00109\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\t\u0010k\u001a\u00020\u000fHÆ\u0003J\t\u0010l\u001a\u00020\u000fHÆ\u0003J\t\u0010m\u001a\u00020\u0012HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010DJ\t\u0010o\u001a\u00020\u0012HÆ\u0003J\t\u0010p\u001a\u00020\u000fHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010s\u001a\u00020\u001aHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010u\u001a\u00020\u0012HÆ\u0003J\t\u0010v\u001a\u00020\u001aHÆ\u0003J\t\u0010w\u001a\u00020\u0012HÆ\u0003J\t\u0010x\u001a\u00020!HÆ\u0003J\t\u0010y\u001a\u00020\u000fHÆ\u0003J\t\u0010z\u001a\u00020\u000fHÆ\u0003J\t\u0010{\u001a\u00020\u000fHÆ\u0003J\t\u0010|\u001a\u00020\u000fHÆ\u0003J\t\u0010}\u001a\u00020\u000fHÆ\u0003J\t\u0010~\u001a\u00020\u000fHÆ\u0003J\t\u0010\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0003\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\u000f2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\b\b\u0002\u00101\u001a\u00020.2\b\b\u0002\u00102\u001a\u00020.2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u001a2\b\b\u0002\u00105\u001a\u00020\u001a2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u00122\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u0012J\u0016\u0010\u0001\u001a\u00020\u001a2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0012HÖ\u0001J\n\u0010\u0001\u001a\u00020\u000fHÖ\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0012R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010?R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010DR\u0014\u0010\u0014\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010BR\u0014\u0010\u0015\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010?R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010?R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010\u001d\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010BR\u0014\u0010\u001e\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010LR\u0014\u0010\u001f\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010BR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010\"\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010?R\u0014\u0010#\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010?R\u0014\u0010$\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010?R\u0014\u0010%\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010?R\u0014\u0010&\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010?R\u0014\u0010'\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010?R\u0014\u0010(\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010?R\u0014\u0010)\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010?R\u0014\u0010*\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010?R\u0014\u0010+\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010?R\u0014\u0010,\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010?R\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0014\u0010/\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010_R\u0014\u00100\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010_R\u0014\u00101\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010_R\u0014\u00102\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010_R\u0014\u00103\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010BR\u0014\u00104\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010LR\u0014\u00105\u001a\u00020\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010LR\u0014\u00106\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010?R\u0014\u00107\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010?R\u0014\u00108\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010BR\u0016\u00109\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010?R\u0016\u0010:\u001a\u0004\u0018\u00010;X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010j¨\u0006\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceB4;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;)Lcom/blueair/core/model/DeviceB4;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceB4 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasWelcomeHome {
    public static final Parcelable.Creator<DeviceB4> CREATOR = new Creator();
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
    private final String g4NightModeFilterTrigger;
    private final String hardware;
    private final boolean hasFinishedOnboarding;
    private final double[] hchoRanges;
    private final String info;
    private final boolean isChildLockOn;
    private final boolean isG4NightModeOn;
    private final boolean isStandByOn;
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
    private final String sku;
    private final String timeZone;
    private final int typeIndex;
    private final String uid;
    private final int updateProgress;
    private final double[] vocRanges;
    private final WelcomeHomeLocation welcomeHome;
    private final String wifiFirmware;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: Device.kt */
    public static final class Creator implements Parcelable.Creator<DeviceB4> {
        public final DeviceB4 createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            int readInt = parcel2.readInt();
            WelcomeHomeLocation welcomeHomeLocation = null;
            Integer valueOf = parcel2.readInt() == 0 ? null : Integer.valueOf(parcel2.readInt());
            int readInt2 = parcel2.readInt();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            DeviceUuid createFromParcel = parcel2.readInt() == 0 ? null : DeviceUuid.CREATOR.createFromParcel(parcel2);
            boolean z5 = parcel2.readInt() != 0;
            IndoorDatapoint createFromParcel2 = parcel2.readInt() == 0 ? null : IndoorDatapoint.CREATOR.createFromParcel(parcel2);
            int readInt3 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z2 = true;
                z = false;
                indoorDatapoint = createFromParcel2;
                z3 = true;
            } else {
                z2 = true;
                indoorDatapoint = createFromParcel2;
                z3 = false;
                z = false;
            }
            int readInt4 = parcel2.readInt();
            boolean z6 = z2;
            long readLong = parcel2.readLong();
            boolean z7 = z6;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z8 = z7;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z9 = z8;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z10 = z9;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z11 = z10;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z12 = z11;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z13 = z12;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z14 = z;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z15 = z13;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z16 = z14;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z17 = z15;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z16;
                z16 = z17;
            } else {
                z4 = z16;
            }
            if (parcel2.readInt() == 0) {
                z17 = z4;
            }
            String readString16 = parcel2.readString();
            String readString17 = parcel2.readString();
            int readInt6 = parcel2.readInt();
            String readString18 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                welcomeHomeLocation = WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            }
            return new DeviceB4(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z5, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z16, z17, readString16, readString17, readInt6, readString18, welcomeHomeLocation);
        }

        public final DeviceB4[] newArray(int i) {
            return new DeviceB4[i];
        }
    }

    public static /* synthetic */ DeviceB4 copy$default(DeviceB4 deviceB4, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, Object obj) {
        WelcomeHomeLocation welcomeHomeLocation2;
        String str19;
        int i9;
        String str20;
        String str21;
        boolean z5;
        boolean z6;
        int i10;
        double[] dArr6;
        double[] dArr7;
        double[] dArr8;
        double[] dArr9;
        double[] dArr10;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        long j2;
        int i11;
        boolean z7;
        int i12;
        IndoorDatapoint indoorDatapoint2;
        boolean z8;
        DeviceUuid deviceUuid3;
        String str33;
        String str34;
        int i13;
        Integer num2;
        int i14;
        DeviceB4 deviceB42 = deviceB4;
        int i15 = i7;
        String str35 = (i15 & 1) != 0 ? deviceB42.uid : str;
        String str36 = (i15 & 2) != 0 ? deviceB42.name : str2;
        int i16 = (i15 & 4) != 0 ? deviceB42.fanSpeed : i;
        Integer num3 = (i15 & 8) != 0 ? deviceB42.filterLife : num;
        int i17 = (i15 & 16) != 0 ? deviceB42.brightness : i2;
        String str37 = (i15 & 32) != 0 ? deviceB42.autoModeText : str3;
        String str38 = (i15 & 64) != 0 ? deviceB42.info : str4;
        DeviceUuid deviceUuid4 = (i15 & 128) != 0 ? deviceB42.deviceUuid : deviceUuid2;
        boolean z9 = (i15 & 256) != 0 ? deviceB42.hasFinishedOnboarding : z;
        IndoorDatapoint indoorDatapoint3 = (i15 & 512) != 0 ? deviceB42.latestSensorDatapoint : indoorDatapoint;
        int i18 = (i15 & 1024) != 0 ? deviceB42.lastSelectedSensorTypeIndex : i3;
        boolean z10 = (i15 & 2048) != 0 ? deviceB42.isChildLockOn : z2;
        int i19 = (i15 & 4096) != 0 ? deviceB42.connectivityStatusIndex : i4;
        String str39 = str35;
        String str40 = str36;
        long j3 = (i15 & 8192) != 0 ? deviceB42.lastConnectivityInMillis : j;
        String str41 = (i15 & 16384) != 0 ? deviceB42.mac : str5;
        String str42 = (i15 & 32768) != 0 ? deviceB42.mcuFirmware : str6;
        String str43 = (i7 & 65536) != 0 ? deviceB42.wifiFirmware : str7;
        String str44 = (i7 & 131072) != 0 ? deviceB42.hardware : str8;
        String str45 = (i7 & 262144) != 0 ? deviceB42.timeZone : str9;
        String str46 = (i7 & 524288) != 0 ? deviceB42.serial : str10;
        String str47 = (i7 & 1048576) != 0 ? deviceB42.purchaseDate : str11;
        String str48 = (i7 & 2097152) != 0 ? deviceB42.dealerName : str12;
        String str49 = (i7 & 4194304) != 0 ? deviceB42.dealerCountry : str13;
        String str50 = (i7 & 8388608) != 0 ? deviceB42.filterType : str14;
        String str51 = (i7 & 16777216) != 0 ? deviceB42.filterTrigger : str15;
        double[] dArr11 = (i7 & 33554432) != 0 ? deviceB42.pm1Ranges : dArr;
        double[] dArr12 = (i7 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceB42.pm10Ranges : dArr2;
        double[] dArr13 = (i7 & 134217728) != 0 ? deviceB42.pm25Ranges : dArr3;
        double[] dArr14 = (i7 & 268435456) != 0 ? deviceB42.vocRanges : dArr4;
        double[] dArr15 = (i7 & 536870912) != 0 ? deviceB42.hchoRanges : dArr5;
        int i20 = (i7 & 1073741824) != 0 ? deviceB42.updateProgress : i5;
        boolean z11 = (i7 & Integer.MIN_VALUE) != 0 ? deviceB42.isStandByOn : z3;
        boolean z12 = (i8 & 1) != 0 ? deviceB42.isG4NightModeOn : z4;
        String str52 = (i8 & 2) != 0 ? deviceB42.g4NightModeFilterTrigger : str16;
        String str53 = (i8 & 4) != 0 ? deviceB42.modelName : str17;
        int i21 = (i8 & 8) != 0 ? deviceB42.typeIndex : i6;
        String str54 = (i8 & 16) != 0 ? deviceB42.sku : str18;
        if ((i8 & 32) != 0) {
            str19 = str54;
            welcomeHomeLocation2 = deviceB42.welcomeHome;
            str24 = str49;
            str23 = str50;
            str22 = str51;
            dArr10 = dArr11;
            dArr9 = dArr12;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            i10 = i20;
            z6 = z11;
            z5 = z12;
            str21 = str52;
            str20 = str53;
            i9 = i21;
            j2 = j3;
            z8 = z9;
            indoorDatapoint2 = indoorDatapoint3;
            i12 = i18;
            z7 = z10;
            i11 = i19;
            str32 = str41;
            str31 = str42;
            str30 = str43;
            str29 = str44;
            str28 = str45;
            str27 = str46;
            str26 = str47;
            str25 = str48;
            i14 = i16;
            num2 = num3;
            i13 = i17;
            str34 = str37;
            str33 = str38;
            deviceUuid3 = deviceUuid4;
        } else {
            welcomeHomeLocation2 = welcomeHomeLocation;
            str19 = str54;
            str25 = str48;
            str24 = str49;
            str23 = str50;
            str22 = str51;
            dArr10 = dArr11;
            dArr9 = dArr12;
            dArr8 = dArr13;
            dArr7 = dArr14;
            dArr6 = dArr15;
            i10 = i20;
            z6 = z11;
            z5 = z12;
            str21 = str52;
            str20 = str53;
            i9 = i21;
            j2 = j3;
            deviceUuid3 = deviceUuid4;
            z8 = z9;
            indoorDatapoint2 = indoorDatapoint3;
            i12 = i18;
            z7 = z10;
            i11 = i19;
            str32 = str41;
            str31 = str42;
            str30 = str43;
            str29 = str44;
            str28 = str45;
            str27 = str46;
            str26 = str47;
            i14 = i16;
            num2 = num3;
            i13 = i17;
            str34 = str37;
            str33 = str38;
        }
        return deviceB42.copy(str39, str40, i14, num2, i13, str34, str33, deviceUuid3, z8, indoorDatapoint2, i12, z7, i11, j2, str32, str31, str30, str29, str28, str27, str26, str25, str24, str23, str22, dArr10, dArr9, dArr8, dArr7, dArr6, i10, z6, z5, str21, str20, i9, str19, welcomeHomeLocation2);
    }

    public final String component1() {
        return this.uid;
    }

    public final IndoorDatapoint component10() {
        return this.latestSensorDatapoint;
    }

    public final int component11() {
        return this.lastSelectedSensorTypeIndex;
    }

    public final boolean component12() {
        return this.isChildLockOn;
    }

    public final int component13() {
        return this.connectivityStatusIndex;
    }

    public final long component14() {
        return this.lastConnectivityInMillis;
    }

    public final String component15() {
        return this.mac;
    }

    public final String component16() {
        return this.mcuFirmware;
    }

    public final String component17() {
        return this.wifiFirmware;
    }

    public final String component18() {
        return this.hardware;
    }

    public final String component19() {
        return this.timeZone;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.serial;
    }

    public final String component21() {
        return this.purchaseDate;
    }

    public final String component22() {
        return this.dealerName;
    }

    public final String component23() {
        return this.dealerCountry;
    }

    public final String component24() {
        return this.filterType;
    }

    public final String component25() {
        return this.filterTrigger;
    }

    public final double[] component26() {
        return this.pm1Ranges;
    }

    public final double[] component27() {
        return this.pm10Ranges;
    }

    public final double[] component28() {
        return this.pm25Ranges;
    }

    public final double[] component29() {
        return this.vocRanges;
    }

    public final int component3() {
        return this.fanSpeed;
    }

    public final double[] component30() {
        return this.hchoRanges;
    }

    public final int component31() {
        return this.updateProgress;
    }

    public final boolean component32() {
        return this.isStandByOn;
    }

    public final boolean component33() {
        return this.isG4NightModeOn;
    }

    public final String component34() {
        return this.g4NightModeFilterTrigger;
    }

    public final String component35() {
        return this.modelName;
    }

    public final int component36() {
        return this.typeIndex;
    }

    public final String component37() {
        return this.sku;
    }

    public final WelcomeHomeLocation component38() {
        return this.welcomeHome;
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

    public final DeviceB4 copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation) {
        String str19 = str;
        Intrinsics.checkNotNullParameter(str19, "uid");
        String str20 = str2;
        Intrinsics.checkNotNullParameter(str20, "name");
        String str21 = str3;
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str5, AnalyticEvent.KEY_MAC);
        String str22 = str6;
        Intrinsics.checkNotNullParameter(str22, "mcuFirmware");
        String str23 = str7;
        Intrinsics.checkNotNullParameter(str23, "wifiFirmware");
        String str24 = str8;
        Intrinsics.checkNotNullParameter(str24, "hardware");
        String str25 = str9;
        Intrinsics.checkNotNullParameter(str25, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        String str26 = str10;
        Intrinsics.checkNotNullParameter(str26, "serial");
        String str27 = str11;
        Intrinsics.checkNotNullParameter(str27, "purchaseDate");
        String str28 = str12;
        Intrinsics.checkNotNullParameter(str28, "dealerName");
        String str29 = str13;
        Intrinsics.checkNotNullParameter(str29, "dealerCountry");
        String str30 = str14;
        Intrinsics.checkNotNullParameter(str30, "filterType");
        String str31 = str15;
        Intrinsics.checkNotNullParameter(str31, "filterTrigger");
        double[] dArr6 = dArr;
        Intrinsics.checkNotNullParameter(dArr6, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        Intrinsics.checkNotNullParameter(str17, "modelName");
        String str32 = str22;
        String str33 = str23;
        String str34 = str24;
        String str35 = str25;
        String str36 = str26;
        String str37 = str27;
        String str38 = str28;
        String str39 = str29;
        String str40 = str30;
        String str41 = str31;
        double[] dArr7 = dArr6;
        return new DeviceB4(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, str16, str17, i6, str18, welcomeHomeLocation);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceB4)) {
            return false;
        }
        DeviceB4 deviceB4 = (DeviceB4) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceB4.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceB4.name) && this.fanSpeed == deviceB4.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceB4.filterLife) && this.brightness == deviceB4.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceB4.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceB4.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceB4.deviceUuid) && this.hasFinishedOnboarding == deviceB4.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceB4.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceB4.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceB4.isChildLockOn && this.connectivityStatusIndex == deviceB4.connectivityStatusIndex && this.lastConnectivityInMillis == deviceB4.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceB4.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceB4.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceB4.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceB4.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceB4.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceB4.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceB4.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceB4.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceB4.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceB4.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceB4.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceB4.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceB4.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceB4.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceB4.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceB4.hchoRanges) && this.updateProgress == deviceB4.updateProgress && this.isStandByOn == deviceB4.isStandByOn && this.isG4NightModeOn == deviceB4.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceB4.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceB4.modelName) && this.typeIndex == deviceB4.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceB4.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceB4.welcomeHome);
    }

    public int hashCode() {
        int hashCode = ((((this.uid.hashCode() * 31) + this.name.hashCode()) * 31) + this.fanSpeed) * 31;
        Integer num = this.filterLife;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.brightness) * 31) + this.autoModeText.hashCode()) * 31;
        String str = this.info;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DeviceUuid deviceUuid2 = this.deviceUuid;
        int hashCode4 = (((hashCode3 + (deviceUuid2 == null ? 0 : deviceUuid2.hashCode())) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding)) * 31;
        IndoorDatapoint indoorDatapoint = this.latestSensorDatapoint;
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn)) * 31) + this.g4NightModeFilterTrigger.hashCode()) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation != null) {
            i = welcomeHomeLocation.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "DeviceB4(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ')';
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
        parcel.writeInt(this.isStandByOn ? 1 : 0);
        parcel.writeInt(this.isG4NightModeOn ? 1 : 0);
        parcel.writeString(this.g4NightModeFilterTrigger);
        parcel.writeString(this.modelName);
        parcel.writeInt(this.typeIndex);
        parcel.writeString(this.sku);
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        welcomeHomeLocation.writeToParcel(parcel, i);
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

    public FilterTrigger getG4NightModeTrigger() {
        return HasG4NightMode.CC.$default$getG4NightModeTrigger(this);
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

    public UiG4NightMode getUiG4NightMode() {
        return HasG4NightMode.CC.$default$getUiG4NightMode(this);
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

    public DeviceB4(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation) {
        String str19 = str;
        String str20 = str2;
        String str21 = str3;
        String str22 = str5;
        String str23 = str6;
        String str24 = str7;
        String str25 = str8;
        String str26 = str9;
        String str27 = str10;
        String str28 = str11;
        String str29 = str12;
        String str30 = str13;
        String str31 = str14;
        String str32 = str15;
        Intrinsics.checkNotNullParameter(str19, "uid");
        Intrinsics.checkNotNullParameter(str20, "name");
        Intrinsics.checkNotNullParameter(str21, "autoModeText");
        Intrinsics.checkNotNullParameter(str22, AnalyticEvent.KEY_MAC);
        Intrinsics.checkNotNullParameter(str23, "mcuFirmware");
        Intrinsics.checkNotNullParameter(str24, "wifiFirmware");
        Intrinsics.checkNotNullParameter(str25, "hardware");
        Intrinsics.checkNotNullParameter(str26, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        Intrinsics.checkNotNullParameter(str27, "serial");
        Intrinsics.checkNotNullParameter(str28, "purchaseDate");
        Intrinsics.checkNotNullParameter(str29, "dealerName");
        Intrinsics.checkNotNullParameter(str30, "dealerCountry");
        Intrinsics.checkNotNullParameter(str31, "filterType");
        Intrinsics.checkNotNullParameter(str32, "filterTrigger");
        Intrinsics.checkNotNullParameter(dArr, "pm1Ranges");
        Intrinsics.checkNotNullParameter(dArr2, "pm10Ranges");
        Intrinsics.checkNotNullParameter(dArr3, "pm25Ranges");
        Intrinsics.checkNotNullParameter(dArr4, "vocRanges");
        Intrinsics.checkNotNullParameter(dArr5, "hchoRanges");
        Intrinsics.checkNotNullParameter(str16, "g4NightModeFilterTrigger");
        String str33 = str17;
        Intrinsics.checkNotNullParameter(str33, "modelName");
        this.uid = str19;
        this.name = str20;
        this.fanSpeed = i;
        this.filterLife = num;
        this.brightness = i2;
        this.autoModeText = str21;
        this.info = str4;
        this.deviceUuid = deviceUuid2;
        this.hasFinishedOnboarding = z;
        this.latestSensorDatapoint = indoorDatapoint;
        this.lastSelectedSensorTypeIndex = i3;
        this.isChildLockOn = z2;
        this.connectivityStatusIndex = i4;
        this.lastConnectivityInMillis = j;
        this.mac = str22;
        this.mcuFirmware = str23;
        this.wifiFirmware = str24;
        this.hardware = str25;
        this.timeZone = str26;
        this.serial = str27;
        this.purchaseDate = str28;
        this.dealerName = str29;
        this.dealerCountry = str30;
        this.filterType = str31;
        this.filterTrigger = str32;
        this.pm1Ranges = dArr;
        this.pm10Ranges = dArr2;
        this.pm25Ranges = dArr3;
        this.vocRanges = dArr4;
        this.hchoRanges = dArr5;
        this.updateProgress = i5;
        this.isStandByOn = z3;
        this.isG4NightModeOn = z4;
        this.g4NightModeFilterTrigger = str16;
        this.modelName = str33;
        this.typeIndex = i6;
        this.sku = str18;
        this.welcomeHome = welcomeHomeLocation;
    }

    public String getUid() {
        return this.uid;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceB4(java.lang.String r43, java.lang.String r44, int r45, java.lang.Integer r46, int r47, java.lang.String r48, java.lang.String r49, com.blueair.core.model.DeviceUuid r50, boolean r51, com.blueair.core.model.IndoorDatapoint r52, int r53, boolean r54, int r55, long r56, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.lang.String r63, java.lang.String r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, double[] r69, double[] r70, double[] r71, double[] r72, double[] r73, int r74, boolean r75, boolean r76, java.lang.String r77, java.lang.String r78, int r79, java.lang.String r80, com.blueair.core.model.WelcomeHomeLocation r81, int r82, int r83, kotlin.jvm.internal.DefaultConstructorMarker r84) {
        /*
            r42 = this;
            r0 = r82
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "Pairing…"
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r44
        L_0x000c:
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r5 = r2
            goto L_0x0015
        L_0x0013:
            r5 = r45
        L_0x0015:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001b
            r6 = 0
            goto L_0x001d
        L_0x001b:
            r6 = r46
        L_0x001d:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0023
            r7 = r2
            goto L_0x0025
        L_0x0023:
            r7 = r47
        L_0x0025:
            r1 = r0 & 32
            java.lang.String r8 = ""
            if (r1 == 0) goto L_0x002d
            r1 = r8
            goto L_0x002f
        L_0x002d:
            r1 = r48
        L_0x002f:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0035
            r9 = 0
            goto L_0x0037
        L_0x0035:
            r9 = r49
        L_0x0037:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003d
            r10 = 0
            goto L_0x003f
        L_0x003d:
            r10 = r50
        L_0x003f:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0045
            r11 = r2
            goto L_0x0047
        L_0x0045:
            r11 = r51
        L_0x0047:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x004d
            r12 = 0
            goto L_0x004f
        L_0x004d:
            r12 = r52
        L_0x004f:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0055
            r13 = r2
            goto L_0x0057
        L_0x0055:
            r13 = r53
        L_0x0057:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x005d
            r14 = r2
            goto L_0x005f
        L_0x005d:
            r14 = r54
        L_0x005f:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r15 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r15 = r15.ordinal()
            goto L_0x006c
        L_0x006a:
            r15 = r55
        L_0x006c:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0073
            r16 = 0
            goto L_0x0075
        L_0x0073:
            r16 = r56
        L_0x0075:
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x007c
            r18 = r8
            goto L_0x007e
        L_0x007c:
            r18 = r58
        L_0x007e:
            r3 = 32768(0x8000, float:4.5918E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0087
            r19 = r8
            goto L_0x0089
        L_0x0087:
            r19 = r59
        L_0x0089:
            r3 = 65536(0x10000, float:9.18355E-41)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0091
            r20 = r8
            goto L_0x0093
        L_0x0091:
            r20 = r60
        L_0x0093:
            r3 = 131072(0x20000, float:1.83671E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x009b
            r21 = r8
            goto L_0x009d
        L_0x009b:
            r21 = r61
        L_0x009d:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00a5
            r22 = r8
            goto L_0x00a7
        L_0x00a5:
            r22 = r62
        L_0x00a7:
            r3 = 524288(0x80000, float:7.34684E-40)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00af
            r23 = r8
            goto L_0x00b1
        L_0x00af:
            r23 = r63
        L_0x00b1:
            r3 = 1048576(0x100000, float:1.469368E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00b9
            r24 = r8
            goto L_0x00bb
        L_0x00b9:
            r24 = r64
        L_0x00bb:
            r3 = 2097152(0x200000, float:2.938736E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00c3
            r25 = r8
            goto L_0x00c5
        L_0x00c3:
            r25 = r65
        L_0x00c5:
            r3 = 4194304(0x400000, float:5.877472E-39)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00cd
            r26 = r8
            goto L_0x00cf
        L_0x00cd:
            r26 = r66
        L_0x00cf:
            r3 = 8388608(0x800000, float:1.17549435E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00d7
            r27 = r8
            goto L_0x00d9
        L_0x00d7:
            r27 = r67
        L_0x00d9:
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00e1
            r28 = r8
            goto L_0x00e3
        L_0x00e1:
            r28 = r68
        L_0x00e3:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00ed
            double[] r3 = new double[r2]
            r29 = r3
            goto L_0x00ef
        L_0x00ed:
            r29 = r69
        L_0x00ef:
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x00f9
            double[] r3 = new double[r2]
            r30 = r3
            goto L_0x00fb
        L_0x00f9:
            r30 = r70
        L_0x00fb:
            r3 = 134217728(0x8000000, float:3.85186E-34)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0105
            double[] r3 = new double[r2]
            r31 = r3
            goto L_0x0107
        L_0x0105:
            r31 = r71
        L_0x0107:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0111
            double[] r3 = new double[r2]
            r32 = r3
            goto L_0x0113
        L_0x0111:
            r32 = r72
        L_0x0113:
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x011d
            double[] r3 = new double[r2]
            r33 = r3
            goto L_0x011f
        L_0x011d:
            r33 = r73
        L_0x011f:
            r3 = 1073741824(0x40000000, float:2.0)
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0127
            r34 = r2
            goto L_0x0129
        L_0x0127:
            r34 = r74
        L_0x0129:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r3
            if (r0 == 0) goto L_0x0131
            r35 = r2
            goto L_0x0133
        L_0x0131:
            r35 = r75
        L_0x0133:
            r0 = r83 & 1
            if (r0 == 0) goto L_0x013a
            r36 = r2
            goto L_0x013c
        L_0x013a:
            r36 = r76
        L_0x013c:
            r0 = r83 & 2
            if (r0 == 0) goto L_0x0143
            r37 = r8
            goto L_0x0145
        L_0x0143:
            r37 = r77
        L_0x0145:
            r0 = r83 & 4
            if (r0 == 0) goto L_0x014c
            r38 = r8
            goto L_0x014e
        L_0x014c:
            r38 = r78
        L_0x014e:
            r0 = r83 & 8
            if (r0 == 0) goto L_0x015b
            com.blueair.core.model.DeviceType$B4 r0 = com.blueair.core.model.DeviceType.B4.INSTANCE
            int r0 = r0.getIndex()
            r39 = r0
            goto L_0x015d
        L_0x015b:
            r39 = r79
        L_0x015d:
            r0 = r83 & 32
            if (r0 == 0) goto L_0x0164
            r41 = 0
            goto L_0x0166
        L_0x0164:
            r41 = r81
        L_0x0166:
            r2 = r42
            r3 = r43
            r40 = r80
            r8 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceB4.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public boolean isStandByOn() {
        return this.isStandByOn;
    }

    public boolean isG4NightModeOn() {
        return this.isG4NightModeOn;
    }

    public String getG4NightModeFilterTrigger() {
        return this.g4NightModeFilterTrigger;
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

    public WelcomeHomeLocation getWelcomeHome() {
        return this.welcomeHome;
    }
}
