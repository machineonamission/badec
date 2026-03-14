package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b[\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\rB\u008b\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u000f\u0012\b\b\u0002\u0010#\u001a\u00020\u000f\u0012\b\b\u0002\u0010$\u001a\u00020\u000f\u0012\b\b\u0002\u0010%\u001a\u00020\u000f\u0012\b\b\u0002\u0010&\u001a\u00020\u000f\u0012\b\b\u0002\u0010'\u001a\u00020\u000f\u0012\b\b\u0002\u0010(\u001a\u00020\u000f\u0012\b\b\u0002\u0010)\u001a\u00020\u000f\u0012\b\b\u0002\u0010*\u001a\u00020\u000f\u0012\b\b\u0002\u0010+\u001a\u00020\u000f\u0012\b\b\u0002\u0010,\u001a\u00020\u000f\u0012\b\b\u0002\u0010-\u001a\u00020.\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u00100\u001a\u00020.\u0012\b\b\u0002\u00101\u001a\u00020.\u0012\b\b\u0002\u00102\u001a\u00020.\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u00104\u001a\u00020\u001a\u0012\b\b\u0002\u00105\u001a\u00020\u001a\u0012\b\b\u0002\u00106\u001a\u00020\u000f\u0012\b\b\u0002\u00107\u001a\u00020\u000f\u0012\b\b\u0002\u00108\u001a\u00020\u0012\u0012\b\u00109\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;¢\u0006\u0004\b<\u0010=J\t\u0010l\u001a\u00020\u000fHÆ\u0003J\t\u0010m\u001a\u00020\u000fHÆ\u0003J\t\u0010n\u001a\u00020\u0012HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010DJ\t\u0010p\u001a\u00020\u0012HÆ\u0003J\t\u0010q\u001a\u00020\u000fHÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010t\u001a\u00020\u001aHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010v\u001a\u00020\u0012HÆ\u0003J\t\u0010w\u001a\u00020\u001aHÆ\u0003J\t\u0010x\u001a\u00020\u0012HÆ\u0003J\t\u0010y\u001a\u00020!HÆ\u0003J\t\u0010z\u001a\u00020\u000fHÆ\u0003J\t\u0010{\u001a\u00020\u000fHÆ\u0003J\t\u0010|\u001a\u00020\u000fHÆ\u0003J\t\u0010}\u001a\u00020\u000fHÆ\u0003J\t\u0010~\u001a\u00020\u000fHÆ\u0003J\t\u0010\u007f\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020.HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0098\u0003\u0010\u0092\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\u000f2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\b\b\u0002\u00101\u001a\u00020.2\b\b\u0002\u00102\u001a\u00020.2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u001a2\b\b\u0002\u00105\u001a\u00020\u001a2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u00122\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;HÆ\u0001¢\u0006\u0003\u0010\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u00020\u0012J\u0016\u0010\u0095\u0001\u001a\u00020\u001a2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001HÖ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0012HÖ\u0001J\n\u0010\u0099\u0001\u001a\u00020\u000fHÖ\u0001J\u001b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u0012R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010\u0010\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010?R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010DR\u0014\u0010\u0014\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010BR\u0014\u0010\u0015\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010?R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010?R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010\u001d\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010BR\u0014\u0010\u001e\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010LR\u0014\u0010\u001f\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010BR\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010\"\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010?R\u0014\u0010#\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010?R\u0014\u0010$\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010?R\u0014\u0010%\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010?R\u0014\u0010&\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010?R\u0014\u0010'\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010?R\u0014\u0010(\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010?R\u0014\u0010)\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010?R\u0014\u0010*\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010?R\u0014\u0010+\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010?R\u0014\u0010,\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010?R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0014\u0010/\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010_R\u0014\u00100\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010_R\u0014\u00101\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010_R\u0014\u00102\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010_R\u0014\u00103\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010BR\u0014\u00104\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010LR\u0014\u00105\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010LR\u0014\u00106\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010?R\u0014\u00107\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010?R\u0014\u00108\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010BR\u0016\u00109\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010?R\u0016\u0010:\u001a\u0004\u0018\u00010;X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0011\u0010k\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bk\u0010L¨\u0006\u009f\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceBlue;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "isPremium", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;)Lcom/blueair/core/model/DeviceBlue;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBlue implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasWelcomeHome {
   public static final Parcelable.Creator CREATOR = new Creator();
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

   public DeviceBlue(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var16, "mac");
      Intrinsics.checkNotNullParameter(var17, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var18, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var19, "hardware");
      Intrinsics.checkNotNullParameter(var20, "timeZone");
      Intrinsics.checkNotNullParameter(var21, "serial");
      Intrinsics.checkNotNullParameter(var22, "purchaseDate");
      Intrinsics.checkNotNullParameter(var23, "dealerName");
      Intrinsics.checkNotNullParameter(var24, "dealerCountry");
      Intrinsics.checkNotNullParameter(var25, "filterType");
      Intrinsics.checkNotNullParameter(var26, "filterTrigger");
      Intrinsics.checkNotNullParameter(var27, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var28, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var29, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var30, "vocRanges");
      Intrinsics.checkNotNullParameter(var31, "hchoRanges");
      Intrinsics.checkNotNullParameter(var35, "g4NightModeFilterTrigger");
      Intrinsics.checkNotNullParameter(var36, "modelName");
      super();
      this.uid = var1;
      this.name = var2;
      this.fanSpeed = var3;
      this.filterLife = var4;
      this.brightness = var5;
      this.autoModeText = var6;
      this.info = var7;
      this.deviceUuid = var8;
      this.hasFinishedOnboarding = var9;
      this.latestSensorDatapoint = var10;
      this.lastSelectedSensorTypeIndex = var11;
      this.isChildLockOn = var12;
      this.connectivityStatusIndex = var13;
      this.lastConnectivityInMillis = var14;
      this.mac = var16;
      this.mcuFirmware = var17;
      this.wifiFirmware = var18;
      this.hardware = var19;
      this.timeZone = var20;
      this.serial = var21;
      this.purchaseDate = var22;
      this.dealerName = var23;
      this.dealerCountry = var24;
      this.filterType = var25;
      this.filterTrigger = var26;
      this.pm1Ranges = var27;
      this.pm10Ranges = var28;
      this.pm25Ranges = var29;
      this.vocRanges = var30;
      this.hchoRanges = var31;
      this.updateProgress = var32;
      this.isStandByOn = var33;
      this.isG4NightModeOn = var34;
      this.g4NightModeFilterTrigger = var35;
      this.modelName = var36;
      this.typeIndex = var37;
      this.sku = var38;
      this.welcomeHome = var39;
   }

   // $FF: synthetic method
   public DeviceBlue(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, DefaultConstructorMarker var42) {
      if ((var40 & 2) != 0) {
         var2 = "Pairing…";
      }

      if ((var40 & 4) != 0) {
         var3 = 0;
      }

      if ((var40 & 8) != 0) {
         var4 = null;
      }

      if ((var40 & 16) != 0) {
         var5 = 0;
      }

      if ((var40 & 32) != 0) {
         var6 = "";
      }

      if ((var40 & 64) != 0) {
         var7 = null;
      }

      if ((var40 & 128) != 0) {
         var8 = null;
      }

      if ((var40 & 256) != 0) {
         var9 = false;
      }

      if ((var40 & 512) != 0) {
         var10 = null;
      }

      if ((var40 & 1024) != 0) {
         var11 = 0;
      }

      if ((var40 & 2048) != 0) {
         var12 = false;
      }

      if ((var40 & 4096) != 0) {
         var13 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var40 & 8192) != 0) {
         var14 = 0L;
      }

      if ((var40 & 16384) != 0) {
         var16 = "";
      }

      if (('耀' & var40) != 0) {
         var17 = "";
      }

      if ((65536 & var40) != 0) {
         var18 = "";
      }

      if ((131072 & var40) != 0) {
         var19 = "";
      }

      if ((262144 & var40) != 0) {
         var20 = "";
      }

      if ((524288 & var40) != 0) {
         var21 = "";
      }

      if ((1048576 & var40) != 0) {
         var22 = "";
      }

      if ((2097152 & var40) != 0) {
         var23 = "";
      }

      if ((4194304 & var40) != 0) {
         var24 = "";
      }

      if ((8388608 & var40) != 0) {
         var25 = "";
      }

      if ((16777216 & var40) != 0) {
         var26 = "";
      }

      if ((33554432 & var40) != 0) {
         var27 = new double[0];
      }

      if ((67108864 & var40) != 0) {
         var28 = new double[0];
      }

      if ((134217728 & var40) != 0) {
         var29 = new double[0];
      }

      if ((268435456 & var40) != 0) {
         var30 = new double[0];
      }

      if ((536870912 & var40) != 0) {
         var31 = new double[0];
      }

      if ((1073741824 & var40) != 0) {
         var32 = 0;
      }

      if ((var40 & Integer.MIN_VALUE) != 0) {
         var33 = false;
      }

      if ((var41 & 1) != 0) {
         var34 = false;
      }

      if ((var41 & 2) != 0) {
         var35 = "";
      }

      if ((var41 & 4) != 0) {
         var36 = "";
      }

      if ((var41 & 8) != 0) {
         var37 = DeviceType.Blue.INSTANCE.getIndex();
      }

      if ((var41 & 32) != 0) {
         var39 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39);
   }

   // $FF: synthetic method
   public static DeviceBlue copy$default(DeviceBlue var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, Object var42) {
      if ((var40 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var40 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var40 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var40 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var40 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var40 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var40 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var40 & 128) != 0) {
         var8 = var0.deviceUuid;
      }

      if ((var40 & 256) != 0) {
         var9 = var0.hasFinishedOnboarding;
      }

      if ((var40 & 512) != 0) {
         var10 = var0.latestSensorDatapoint;
      }

      if ((var40 & 1024) != 0) {
         var11 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var40 & 2048) != 0) {
         var12 = var0.isChildLockOn;
      }

      if ((var40 & 4096) != 0) {
         var13 = var0.connectivityStatusIndex;
      }

      if ((var40 & 8192) != 0) {
         var14 = var0.lastConnectivityInMillis;
      }

      if ((var40 & 16384) != 0) {
         var16 = var0.mac;
      }

      if ((var40 & '耀') != 0) {
         var17 = var0.mcuFirmware;
      }

      if ((var40 & 65536) != 0) {
         var18 = var0.wifiFirmware;
      }

      if ((var40 & 131072) != 0) {
         var19 = var0.hardware;
      }

      if ((var40 & 262144) != 0) {
         var20 = var0.timeZone;
      }

      if ((var40 & 524288) != 0) {
         var21 = var0.serial;
      }

      if ((var40 & 1048576) != 0) {
         var22 = var0.purchaseDate;
      }

      if ((var40 & 2097152) != 0) {
         var23 = var0.dealerName;
      }

      if ((var40 & 4194304) != 0) {
         var24 = var0.dealerCountry;
      }

      if ((var40 & 8388608) != 0) {
         var25 = var0.filterType;
      }

      if ((var40 & 16777216) != 0) {
         var26 = var0.filterTrigger;
      }

      if ((var40 & 33554432) != 0) {
         var27 = var0.pm1Ranges;
      }

      if ((var40 & 67108864) != 0) {
         var28 = var0.pm10Ranges;
      }

      if ((var40 & 134217728) != 0) {
         var29 = var0.pm25Ranges;
      }

      if ((var40 & 268435456) != 0) {
         var30 = var0.vocRanges;
      }

      if ((var40 & 536870912) != 0) {
         var31 = var0.hchoRanges;
      }

      if ((var40 & 1073741824) != 0) {
         var32 = var0.updateProgress;
      }

      if ((var40 & Integer.MIN_VALUE) != 0) {
         var33 = var0.isStandByOn;
      }

      if ((var41 & 1) != 0) {
         var34 = var0.isG4NightModeOn;
      }

      if ((var41 & 2) != 0) {
         var35 = var0.g4NightModeFilterTrigger;
      }

      if ((var41 & 4) != 0) {
         var36 = var0.modelName;
      }

      if ((var41 & 8) != 0) {
         var37 = var0.typeIndex;
      }

      if ((var41 & 16) != 0) {
         var38 = var0.sku;
      }

      if ((var41 & 32) != 0) {
         var39 = var0.welcomeHome;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39);
   }

   public double[] airRatingsFor(SensorType var1) {
      return HasSensorData$_CC.$default$airRatingsFor(this, var1);
   }

   public IndoorAirRatingRanges.IndoorAirRating aqiFor(double var1, SensorType var3) {
      return HasSensorData$_CC.$default$aqiFor(this, var1, var3);
   }

   public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType var1) {
      return HasSensorData$_CC.$default$aqiFor(this, var1);
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

   public final DeviceBlue copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var16, "mac");
      Intrinsics.checkNotNullParameter(var17, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var18, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var19, "hardware");
      Intrinsics.checkNotNullParameter(var20, "timeZone");
      Intrinsics.checkNotNullParameter(var21, "serial");
      Intrinsics.checkNotNullParameter(var22, "purchaseDate");
      Intrinsics.checkNotNullParameter(var23, "dealerName");
      Intrinsics.checkNotNullParameter(var24, "dealerCountry");
      Intrinsics.checkNotNullParameter(var25, "filterType");
      Intrinsics.checkNotNullParameter(var26, "filterTrigger");
      Intrinsics.checkNotNullParameter(var27, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var28, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var29, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var30, "vocRanges");
      Intrinsics.checkNotNullParameter(var31, "hchoRanges");
      Intrinsics.checkNotNullParameter(var35, "g4NightModeFilterTrigger");
      Intrinsics.checkNotNullParameter(var36, "modelName");
      return new DeviceBlue(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceBlue)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.fanSpeed != var1.fanSpeed) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterLife, var1.filterLife)) {
            return false;
         } else if (this.brightness != var1.brightness) {
            return false;
         } else if (!Intrinsics.areEqual(this.autoModeText, var1.autoModeText)) {
            return false;
         } else if (!Intrinsics.areEqual(this.info, var1.info)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceUuid, var1.deviceUuid)) {
            return false;
         } else if (this.hasFinishedOnboarding != var1.hasFinishedOnboarding) {
            return false;
         } else if (!Intrinsics.areEqual(this.latestSensorDatapoint, var1.latestSensorDatapoint)) {
            return false;
         } else if (this.lastSelectedSensorTypeIndex != var1.lastSelectedSensorTypeIndex) {
            return false;
         } else if (this.isChildLockOn != var1.isChildLockOn) {
            return false;
         } else if (this.connectivityStatusIndex != var1.connectivityStatusIndex) {
            return false;
         } else if (this.lastConnectivityInMillis != var1.lastConnectivityInMillis) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wifiFirmware, var1.wifiFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hardware, var1.hardware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeZone, var1.timeZone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.serial, var1.serial)) {
            return false;
         } else if (!Intrinsics.areEqual(this.purchaseDate, var1.purchaseDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerName, var1.dealerName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerCountry, var1.dealerCountry)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterType, var1.filterType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterTrigger, var1.filterTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm1Ranges, var1.pm1Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm10Ranges, var1.pm10Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm25Ranges, var1.pm25Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.vocRanges, var1.vocRanges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hchoRanges, var1.hchoRanges)) {
            return false;
         } else if (this.updateProgress != var1.updateProgress) {
            return false;
         } else if (this.isStandByOn != var1.isStandByOn) {
            return false;
         } else if (this.isG4NightModeOn != var1.isG4NightModeOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.g4NightModeFilterTrigger, var1.g4NightModeFilterTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.welcomeHome, var1.welcomeHome);
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
   }

   public AutoMode getAutoMode() {
      return HasFanSpeed$_CC.$default$getAutoMode(this);
   }

   public String getAutoModeText() {
      return this.autoModeText;
   }

   public int getBrightness() {
      return this.brightness;
   }

   public Brightness getBrightnessEnum() {
      return HasBrightness$_CC.$default$getBrightnessEnum(this);
   }

   public ConnectivityStatus getConnectivityStatus() {
      return Device$_CC.$default$getConnectivityStatus(this);
   }

   public int getConnectivityStatusIndex() {
      return this.connectivityStatusIndex;
   }

   public String getDealerCountry() {
      return this.dealerCountry;
   }

   public String getDealerName() {
      return this.dealerName;
   }

   public DeviceUuid getDeviceUuid() {
      return this.deviceUuid;
   }

   public int getFanSpeed() {
      return this.fanSpeed;
   }

   public FanSpeedEnum getFanSpeedEnum() {
      return HasFanSpeed$_CC.$default$getFanSpeedEnum(this);
   }

   public Filter getFilter() {
      return HasFanSpeed$_CC.$default$getFilter(this);
   }

   public Integer getFilterLife() {
      return this.filterLife;
   }

   public String getFilterTrigger() {
      return this.filterTrigger;
   }

   public String getFilterType() {
      return this.filterType;
   }

   public String getG4NightModeFilterTrigger() {
      return this.g4NightModeFilterTrigger;
   }

   public FilterTrigger getG4NightModeTrigger() {
      return HasG4NightMode$_CC.$default$getG4NightModeTrigger(this);
   }

   public String getHardware() {
      return this.hardware;
   }

   public boolean getHasFinishedOnboarding() {
      return this.hasFinishedOnboarding;
   }

   public boolean getHasGear0() {
      return HasFanSpeed$_CC.$default$getHasGear0(this);
   }

   public boolean getHasGear4() {
      return HasFanSpeed$_CC.$default$getHasGear4(this);
   }

   public double[] getHchoRanges() {
      return this.hchoRanges;
   }

   public String getInfo() {
      return this.info;
   }

   public long getLastConnectivityInMillis() {
      return this.lastConnectivityInMillis;
   }

   public SensorType getLastSelectedSensorType() {
      return HasSensorData$_CC.$default$getLastSelectedSensorType(this);
   }

   public int getLastSelectedSensorTypeIndex() {
      return this.lastSelectedSensorTypeIndex;
   }

   public IndoorDatapoint getLatestSensorDatapoint() {
      return this.latestSensorDatapoint;
   }

   public String getMac() {
      return this.mac;
   }

   public String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public String getModelName() {
      return this.modelName;
   }

   public String getName() {
      return this.name;
   }

   public double[] getPm10Ranges() {
      return this.pm10Ranges;
   }

   public double[] getPm1Ranges() {
      return this.pm1Ranges;
   }

   public double[] getPm25Ranges() {
      return this.pm25Ranges;
   }

   public String getPurchaseDate() {
      return this.purchaseDate;
   }

   public String getSerial() {
      return this.serial;
   }

   public String getSku() {
      return this.sku;
   }

   public String getTimeZone() {
      return this.timeZone;
   }

   public TimeZone getTimezone(Context var1) {
      return Device$_CC.$default$getTimezone(this, var1);
   }

   public FilterTrigger getTrigger() {
      return HasFanSpeed$_CC.$default$getTrigger(this);
   }

   public DeviceType getType() {
      return Device$_CC.$default$getType(this);
   }

   public int getTypeIndex() {
      return this.typeIndex;
   }

   public UiAutoMode getUiAutoMode() {
      return HasFanSpeed$_CC.$default$getUiAutoMode(this);
   }

   public UiG4NightMode getUiG4NightMode() {
      return HasG4NightMode$_CC.$default$getUiG4NightMode(this);
   }

   public String getUid() {
      return this.uid;
   }

   public int getUpdateProgress() {
      return this.updateProgress;
   }

   public double[] getVocRanges() {
      return this.vocRanges;
   }

   public WelcomeHomeLocation getWelcomeHome() {
      return this.welcomeHome;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var8 = this.uid.hashCode();
      int var7 = this.name.hashCode();
      int var9 = this.fanSpeed;
      Integer var39 = this.filterLife;
      int var6 = 0;
      int var1;
      if (var39 == null) {
         var1 = 0;
      } else {
         var1 = var39.hashCode();
      }

      int var11 = this.brightness;
      int var10 = this.autoModeText.hashCode();
      String var40 = this.info;
      int var2;
      if (var40 == null) {
         var2 = 0;
      } else {
         var2 = var40.hashCode();
      }

      DeviceUuid var41 = this.deviceUuid;
      int var3;
      if (var41 == null) {
         var3 = 0;
      } else {
         var3 = var41.hashCode();
      }

      int var12 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      IndoorDatapoint var42 = this.latestSensorDatapoint;
      int var4;
      if (var42 == null) {
         var4 = 0;
      } else {
         var4 = var42.hashCode();
      }

      int var19 = this.lastSelectedSensorTypeIndex;
      int var23 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var38 = this.connectivityStatusIndex;
      int var26 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var16 = this.mac.hashCode();
      int var33 = this.mcuFirmware.hashCode();
      int var25 = this.wifiFirmware.hashCode();
      int var18 = this.hardware.hashCode();
      int var31 = this.timeZone.hashCode();
      int var36 = this.serial.hashCode();
      int var15 = this.purchaseDate.hashCode();
      int var35 = this.dealerName.hashCode();
      int var21 = this.dealerCountry.hashCode();
      int var27 = this.filterType.hashCode();
      int var34 = this.filterTrigger.hashCode();
      int var30 = Arrays.hashCode(this.pm1Ranges);
      int var29 = Arrays.hashCode(this.pm10Ranges);
      int var20 = Arrays.hashCode(this.pm25Ranges);
      int var17 = Arrays.hashCode(this.vocRanges);
      int var24 = Arrays.hashCode(this.hchoRanges);
      int var13 = this.updateProgress;
      int var22 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var37 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn);
      int var14 = this.g4NightModeFilterTrigger.hashCode();
      int var28 = this.modelName.hashCode();
      int var32 = this.typeIndex;
      String var43 = this.sku;
      int var5;
      if (var43 == null) {
         var5 = 0;
      } else {
         var5 = var43.hashCode();
      }

      WelcomeHomeLocation var44 = this.welcomeHome;
      if (var44 != null) {
         var6 = var44.hashCode();
      }

      return ((((((((((((((((((((((((((((((((((((var8 * 31 + var7) * 31 + var9) * 31 + var1) * 31 + var11) * 31 + var10) * 31 + var2) * 31 + var3) * 31 + var12) * 31 + var4) * 31 + var19) * 31 + var23) * 31 + var38) * 31 + var26) * 31 + var16) * 31 + var33) * 31 + var25) * 31 + var18) * 31 + var31) * 31 + var36) * 31 + var15) * 31 + var35) * 31 + var21) * 31 + var27) * 31 + var34) * 31 + var30) * 31 + var29) * 31 + var20) * 31 + var17) * 31 + var24) * 31 + var13) * 31 + var22) * 31 + var37) * 31 + var14) * 31 + var28) * 31 + var32) * 31 + var5) * 31 + var6;
   }

   public boolean isChildLockOn() {
      return this.isChildLockOn;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isG4NightModeOn() {
      return this.isG4NightModeOn;
   }

   public boolean isOnline() {
      return Device$_CC.$default$isOnline(this);
   }

   public final boolean isPremium() {
      return SkuConfigurationManager.INSTANCE.getConfig().skuIsBluePremium(this.getSku());
   }

   public boolean isStandByOn() {
      return this.isStandByOn;
   }

   public boolean isUsDevice() {
      return Device$_CC.$default$isUsDevice(this);
   }

   public boolean supportResetFilterOnline() {
      return Device$_CC.$default$supportResetFilterOnline(this);
   }

   public boolean supports(SensorType var1) {
      return HasSensorData$_CC.$default$supports(this, var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceBlue(uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", fanSpeed=");
      var1.append(this.fanSpeed);
      var1.append(", filterLife=");
      var1.append(this.filterLife);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(", autoModeText=");
      var1.append(this.autoModeText);
      var1.append(", info=");
      var1.append(this.info);
      var1.append(", deviceUuid=");
      var1.append(this.deviceUuid);
      var1.append(", hasFinishedOnboarding=");
      var1.append(this.hasFinishedOnboarding);
      var1.append(", latestSensorDatapoint=");
      var1.append(this.latestSensorDatapoint);
      var1.append(", lastSelectedSensorTypeIndex=");
      var1.append(this.lastSelectedSensorTypeIndex);
      var1.append(", isChildLockOn=");
      var1.append(this.isChildLockOn);
      var1.append(", connectivityStatusIndex=");
      var1.append(this.connectivityStatusIndex);
      var1.append(", lastConnectivityInMillis=");
      var1.append(this.lastConnectivityInMillis);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", wifiFirmware=");
      var1.append(this.wifiFirmware);
      var1.append(", hardware=");
      var1.append(this.hardware);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(", serial=");
      var1.append(this.serial);
      var1.append(", purchaseDate=");
      var1.append(this.purchaseDate);
      var1.append(", dealerName=");
      var1.append(this.dealerName);
      var1.append(", dealerCountry=");
      var1.append(this.dealerCountry);
      var1.append(", filterType=");
      var1.append(this.filterType);
      var1.append(", filterTrigger=");
      var1.append(this.filterTrigger);
      var1.append(", pm1Ranges=");
      var1.append(Arrays.toString(this.pm1Ranges));
      var1.append(", pm10Ranges=");
      var1.append(Arrays.toString(this.pm10Ranges));
      var1.append(", pm25Ranges=");
      var1.append(Arrays.toString(this.pm25Ranges));
      var1.append(", vocRanges=");
      var1.append(Arrays.toString(this.vocRanges));
      var1.append(", hchoRanges=");
      var1.append(Arrays.toString(this.hchoRanges));
      var1.append(", updateProgress=");
      var1.append(this.updateProgress);
      var1.append(", isStandByOn=");
      var1.append(this.isStandByOn);
      var1.append(", isG4NightModeOn=");
      var1.append(this.isG4NightModeOn);
      var1.append(", g4NightModeFilterTrigger=");
      var1.append(this.g4NightModeFilterTrigger);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", sku=");
      var1.append(this.sku);
      var1.append(", welcomeHome=");
      var1.append(this.welcomeHome);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.uid);
      var1.writeString(this.name);
      var1.writeInt(this.fanSpeed);
      Integer var3 = this.filterLife;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3);
      }

      var1.writeInt(this.brightness);
      var1.writeString(this.autoModeText);
      var1.writeString(this.info);
      DeviceUuid var4 = this.deviceUuid;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
      }

      var1.writeInt(this.hasFinishedOnboarding);
      IndoorDatapoint var5 = this.latestSensorDatapoint;
      if (var5 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var5.writeToParcel(var1, var2);
      }

      var1.writeInt(this.lastSelectedSensorTypeIndex);
      var1.writeInt(this.isChildLockOn);
      var1.writeInt(this.connectivityStatusIndex);
      var1.writeLong(this.lastConnectivityInMillis);
      var1.writeString(this.mac);
      var1.writeString(this.mcuFirmware);
      var1.writeString(this.wifiFirmware);
      var1.writeString(this.hardware);
      var1.writeString(this.timeZone);
      var1.writeString(this.serial);
      var1.writeString(this.purchaseDate);
      var1.writeString(this.dealerName);
      var1.writeString(this.dealerCountry);
      var1.writeString(this.filterType);
      var1.writeString(this.filterTrigger);
      var1.writeDoubleArray(this.pm1Ranges);
      var1.writeDoubleArray(this.pm10Ranges);
      var1.writeDoubleArray(this.pm25Ranges);
      var1.writeDoubleArray(this.vocRanges);
      var1.writeDoubleArray(this.hchoRanges);
      var1.writeInt(this.updateProgress);
      var1.writeInt(this.isStandByOn);
      var1.writeInt(this.isG4NightModeOn);
      var1.writeString(this.g4NightModeFilterTrigger);
      var1.writeString(this.modelName);
      var1.writeInt(this.typeIndex);
      var1.writeString(this.sku);
      WelcomeHomeLocation var6 = this.welcomeHome;
      if (var6 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var6.writeToParcel(var1, var2);
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceBlue createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var18 = var1.readString();
         String var17 = var1.readString();
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         Object var16 = null;
         Integer var14;
         if (var3 == 0) {
            var14 = null;
         } else {
            var14 = var1.readInt();
         }

         int var4 = var1.readInt();
         String var20 = var1.readString();
         String var19 = var1.readString();
         Object var15;
         if (var1.readInt() == 0) {
            var15 = null;
         } else {
            var15 = DeviceUuid.CREATOR.createFromParcel(var1);
         }

         DeviceUuid var21 = (DeviceUuid)var15;
         boolean var8;
         if (var1.readInt() != 0) {
            var8 = true;
         } else {
            var8 = false;
         }

         if (var1.readInt() == 0) {
            var15 = null;
         } else {
            var15 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var22 = (IndoorDatapoint)var15;
         var3 = var1.readInt();
         boolean var9;
         if (var1.readInt() != 0) {
            var9 = true;
         } else {
            var9 = false;
         }

         int var5 = var1.readInt();
         long var12 = var1.readLong();
         String var36 = var1.readString();
         String var26 = var1.readString();
         String var34 = var1.readString();
         String var24 = var1.readString();
         String var31 = var1.readString();
         String var37 = var1.readString();
         String var35 = var1.readString();
         String var32 = var1.readString();
         String var39 = var1.readString();
         String var40 = var1.readString();
         String var38 = var1.readString();
         double[] var44 = var1.createDoubleArray();
         double[] var28 = var1.createDoubleArray();
         double[] var23 = var1.createDoubleArray();
         double[] var27 = var1.createDoubleArray();
         boolean var10 = false;
         double[] var29 = var1.createDoubleArray();
         boolean var11 = true;
         int var6 = var1.readInt();
         if (var1.readInt() != 0) {
            var10 = true;
         }

         if (var1.readInt() == 0) {
            var11 = false;
         }

         String var25 = var1.readString();
         String var30 = var1.readString();
         int var7 = var1.readInt();
         String var33 = var1.readString();
         Object var41;
         if (var1.readInt() == 0) {
            var41 = var16;
         } else {
            var41 = WelcomeHomeLocation.CREATOR.createFromParcel(var1);
         }

         return new DeviceBlue(var18, var17, var2, var14, var4, var20, var19, var21, var8, var22, var3, var9, var5, var12, var36, var26, var34, var24, var31, var37, var35, var32, var39, var40, var38, var44, var28, var23, var27, var29, var6, var10, var11, var25, var30, var7, var33, (WelcomeHomeLocation)var41);
      }

      public final DeviceBlue[] newArray(int var1) {
         return new DeviceBlue[var1];
      }
   }
}
