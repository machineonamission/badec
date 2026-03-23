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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b]\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000fB«\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u0014\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\u0011\u0012\b\b\u0002\u0010&\u001a\u00020\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0011\u0012\b\b\u0002\u0010(\u001a\u00020\u0011\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\b\b\u0002\u0010*\u001a\u00020\u0011\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u0012\b\b\u0002\u0010,\u001a\u00020\u0011\u0012\b\b\u0002\u0010-\u001a\u00020\u0011\u0012\b\b\u0002\u0010.\u001a\u00020\u0011\u0012\b\b\u0002\u0010/\u001a\u000200\u0012\b\b\u0002\u00101\u001a\u000200\u0012\b\b\u0002\u00102\u001a\u000200\u0012\b\b\u0002\u00103\u001a\u000200\u0012\b\b\u0002\u00104\u001a\u000200\u0012\b\b\u0002\u00105\u001a\u00020\u0014\u0012\b\b\u0002\u00106\u001a\u00020\u001c\u0012\b\b\u0002\u00107\u001a\u00020\u001c\u0012\b\b\u0002\u00108\u001a\u00020\u001c\u0012\b\b\u0002\u00109\u001a\u00020\u001c\u0012\b\b\u0002\u0010:\u001a\u00020\u001c\u0012\b\b\u0002\u0010;\u001a\u00020\u0011\u0012\b\b\u0002\u0010<\u001a\u00020\u0011\u0012\b\b\u0002\u0010=\u001a\u00020\u0014\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@¢\u0006\u0004\bA\u0010BJ\t\u0010p\u001a\u00020\u0011HÆ\u0003J\t\u0010q\u001a\u00020\u0011HÆ\u0003J\t\u0010r\u001a\u00020\u0014HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010IJ\t\u0010t\u001a\u00020\u0014HÆ\u0003J\t\u0010u\u001a\u00020\u0011HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010x\u001a\u00020\u001cHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\t\u0010z\u001a\u00020\u0014HÆ\u0003J\t\u0010{\u001a\u00020\u001cHÆ\u0003J\t\u0010|\u001a\u00020\u0014HÆ\u0003J\t\u0010}\u001a\u00020#HÆ\u0003J\t\u0010~\u001a\u00020\u0011HÆ\u0003J\t\u0010\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u000200HÆ\u0003J\n\u0010\u0001\u001a\u000200HÆ\u0003J\n\u0010\u0001\u001a\u000200HÆ\u0003J\n\u0010\u0001\u001a\u000200HÆ\u0003J\n\u0010\u0001\u001a\u000200HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u001cHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0014HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010@HÆ\u0003J¶\u0003\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020\u00112\b\b\u0002\u0010'\u001a\u00020\u00112\b\b\u0002\u0010(\u001a\u00020\u00112\b\b\u0002\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00103\u001a\u0002002\b\b\u0002\u00104\u001a\u0002002\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020\u001c2\b\b\u0002\u0010:\u001a\u00020\u001c2\b\b\u0002\u0010;\u001a\u00020\u00112\b\b\u0002\u0010<\u001a\u00020\u00112\b\b\u0002\u0010=\u001a\u00020\u00142\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\u0014J\u0016\u0010\u0001\u001a\u00020\u001c2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0014HÖ\u0001J\n\u0010 \u0001\u001a\u00020\u0011HÖ\u0001J\u001b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030¤\u00012\u0007\u0010¥\u0001\u001a\u00020\u0014R\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010DR\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0014\u0010\u0016\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010GR\u0014\u0010\u0017\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010DR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010DR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0014\u0010\u001f\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010GR\u0014\u0010 \u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010QR\u0014\u0010!\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010GR\u0014\u0010\"\u001a\u00020#X\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0014\u0010$\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010DR\u0014\u0010%\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010DR\u0014\u0010&\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010DR\u0014\u0010'\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010DR\u0014\u0010(\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010DR\u0014\u0010)\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010DR\u0014\u0010*\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010DR\u0014\u0010+\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010DR\u0014\u0010,\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010DR\u0014\u0010-\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010DR\u0014\u0010.\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010DR\u0014\u0010/\u001a\u000200X\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0014\u00101\u001a\u000200X\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010dR\u0014\u00102\u001a\u000200X\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010dR\u0014\u00103\u001a\u000200X\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010dR\u0014\u00104\u001a\u000200X\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010dR\u0014\u00105\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010GR\u0014\u00106\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010QR\u0014\u00107\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010QR\u0014\u00108\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010QR\u0014\u00109\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010QR\u0014\u0010:\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010QR\u0014\u0010;\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010DR\u0014\u0010<\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010DR\u0014\u0010=\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010GR\u0016\u0010>\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010DR\u0016\u0010?\u001a\u0004\u0018\u00010@X\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006¦\u0001"}, d2 = {"Lcom/blueair/core/model/DeviceNewClassic;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasEcoMode;", "Lcom/blueair/core/model/HasHinsMode;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isEcoModeOn", "isHinsModeOn", "isHinsNightModeOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZZZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;)Lcom/blueair/core/model/DeviceNewClassic;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Device.kt */
public final class DeviceNewClassic implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasWelcomeHome, HasEcoMode, HasHinsMode {
    public static final Parcelable.Creator<DeviceNewClassic> CREATOR = new Creator();
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
    private final boolean isEcoModeOn;
    private final boolean isG4NightModeOn;
    private final boolean isHinsModeOn;
    private final boolean isHinsNightModeOn;
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
    public static final class Creator implements Parcelable.Creator<DeviceNewClassic> {
        public final DeviceNewClassic createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            IndoorDatapoint indoorDatapoint;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
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
            boolean z8 = parcel2.readInt() != 0;
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
            boolean z9 = z2;
            long readLong = parcel2.readLong();
            boolean z10 = z9;
            String readString5 = parcel2.readString();
            String readString6 = parcel2.readString();
            boolean z11 = z10;
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            boolean z12 = z11;
            String readString9 = parcel2.readString();
            String readString10 = parcel2.readString();
            boolean z13 = z12;
            String readString11 = parcel2.readString();
            String readString12 = parcel2.readString();
            boolean z14 = z13;
            String readString13 = parcel2.readString();
            String readString14 = parcel2.readString();
            boolean z15 = z14;
            String readString15 = parcel2.readString();
            double[] createDoubleArray = parcel2.createDoubleArray();
            boolean z16 = z15;
            double[] createDoubleArray2 = parcel2.createDoubleArray();
            boolean z17 = z;
            double[] createDoubleArray3 = parcel2.createDoubleArray();
            boolean z18 = z16;
            double[] createDoubleArray4 = parcel2.createDoubleArray();
            boolean z19 = z17;
            double[] createDoubleArray5 = parcel2.createDoubleArray();
            boolean z20 = z18;
            int readInt5 = parcel2.readInt();
            if (parcel2.readInt() != 0) {
                z4 = z19;
                z19 = z20;
            } else {
                z4 = z19;
            }
            if (parcel2.readInt() != 0) {
                z5 = z20;
            } else {
                z5 = z20;
                z20 = z4;
            }
            if (parcel2.readInt() != 0) {
                z6 = z4;
                z4 = z5;
            } else {
                z6 = z4;
            }
            if (parcel2.readInt() != 0) {
                z7 = z5;
            } else {
                z7 = z5;
                z5 = z6;
            }
            if (parcel2.readInt() != 0) {
                z6 = z7;
            }
            String readString16 = parcel2.readString();
            String readString17 = parcel2.readString();
            int readInt6 = parcel2.readInt();
            String readString18 = parcel2.readString();
            if (parcel2.readInt() != 0) {
                welcomeHomeLocation = WelcomeHomeLocation.CREATOR.createFromParcel(parcel2);
            }
            return new DeviceNewClassic(readString, readString2, readInt, valueOf, readInt2, readString3, readString4, createFromParcel, z8, indoorDatapoint, readInt3, z3, readInt4, readLong, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, createDoubleArray, createDoubleArray2, createDoubleArray3, createDoubleArray4, createDoubleArray5, readInt5, z19, z20, z4, z5, z6, readString16, readString17, readInt6, readString18, welcomeHomeLocation);
        }

        public final DeviceNewClassic[] newArray(int i) {
            return new DeviceNewClassic[i];
        }
    }

    public static /* synthetic */ DeviceNewClassic copy$default(DeviceNewClassic deviceNewClassic, String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation, int i7, int i8, Object obj) {
        DeviceNewClassic deviceNewClassic2 = deviceNewClassic;
        int i9 = i7;
        int i10 = i8;
        return deviceNewClassic2.copy((i9 & 1) != 0 ? deviceNewClassic2.uid : str, (i9 & 2) != 0 ? deviceNewClassic2.name : str2, (i9 & 4) != 0 ? deviceNewClassic2.fanSpeed : i, (i9 & 8) != 0 ? deviceNewClassic2.filterLife : num, (i9 & 16) != 0 ? deviceNewClassic2.brightness : i2, (i9 & 32) != 0 ? deviceNewClassic2.autoModeText : str3, (i9 & 64) != 0 ? deviceNewClassic2.info : str4, (i9 & 128) != 0 ? deviceNewClassic2.deviceUuid : deviceUuid2, (i9 & 256) != 0 ? deviceNewClassic2.hasFinishedOnboarding : z, (i9 & 512) != 0 ? deviceNewClassic2.latestSensorDatapoint : indoorDatapoint, (i9 & 1024) != 0 ? deviceNewClassic2.lastSelectedSensorTypeIndex : i3, (i9 & 2048) != 0 ? deviceNewClassic2.isChildLockOn : z2, (i9 & 4096) != 0 ? deviceNewClassic2.connectivityStatusIndex : i4, (i9 & 8192) != 0 ? deviceNewClassic2.lastConnectivityInMillis : j, (i9 & 16384) != 0 ? deviceNewClassic2.mac : str5, (32768 & i9) != 0 ? deviceNewClassic2.mcuFirmware : str6, (i9 & 65536) != 0 ? deviceNewClassic2.wifiFirmware : str7, (i7 & 131072) != 0 ? deviceNewClassic2.hardware : str8, (i7 & 262144) != 0 ? deviceNewClassic2.timeZone : str9, (i7 & 524288) != 0 ? deviceNewClassic2.serial : str10, (i7 & 1048576) != 0 ? deviceNewClassic2.purchaseDate : str11, (i7 & 2097152) != 0 ? deviceNewClassic2.dealerName : str12, (i7 & 4194304) != 0 ? deviceNewClassic2.dealerCountry : str13, (i7 & 8388608) != 0 ? deviceNewClassic2.filterType : str14, (i7 & 16777216) != 0 ? deviceNewClassic2.filterTrigger : str15, (i7 & 33554432) != 0 ? deviceNewClassic2.pm1Ranges : dArr, (i7 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceNewClassic2.pm10Ranges : dArr2, (i7 & 134217728) != 0 ? deviceNewClassic2.pm25Ranges : dArr3, (i7 & 268435456) != 0 ? deviceNewClassic2.vocRanges : dArr4, (i7 & 536870912) != 0 ? deviceNewClassic2.hchoRanges : dArr5, (i7 & 1073741824) != 0 ? deviceNewClassic2.updateProgress : i5, (i7 & Integer.MIN_VALUE) != 0 ? deviceNewClassic2.isStandByOn : z3, (i10 & 1) != 0 ? deviceNewClassic2.isEcoModeOn : z4, (i10 & 2) != 0 ? deviceNewClassic2.isHinsModeOn : z5, (i10 & 4) != 0 ? deviceNewClassic2.isHinsNightModeOn : z6, (i10 & 8) != 0 ? deviceNewClassic2.isG4NightModeOn : z7, (i10 & 16) != 0 ? deviceNewClassic2.g4NightModeFilterTrigger : str16, (i10 & 32) != 0 ? deviceNewClassic2.modelName : str17, (i10 & 64) != 0 ? deviceNewClassic2.typeIndex : i6, (i10 & 128) != 0 ? deviceNewClassic2.sku : str18, (i10 & 256) != 0 ? deviceNewClassic2.welcomeHome : welcomeHomeLocation);
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
        return this.isEcoModeOn;
    }

    public final boolean component34() {
        return this.isHinsModeOn;
    }

    public final boolean component35() {
        return this.isHinsNightModeOn;
    }

    public final boolean component36() {
        return this.isG4NightModeOn;
    }

    public final String component37() {
        return this.g4NightModeFilterTrigger;
    }

    public final String component38() {
        return this.modelName;
    }

    public final int component39() {
        return this.typeIndex;
    }

    public final Integer component4() {
        return this.filterLife;
    }

    public final String component40() {
        return this.sku;
    }

    public final WelcomeHomeLocation component41() {
        return this.welcomeHome;
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

    public final DeviceNewClassic copy(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation) {
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
        return new DeviceNewClassic(str19, str20, i, num, i2, str21, str4, deviceUuid2, z, indoorDatapoint, i3, z2, i4, j, str5, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, dArr7, dArr2, dArr3, dArr4, dArr5, i5, z3, z4, z5, z6, z7, str16, str17, i6, str18, welcomeHomeLocation);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceNewClassic)) {
            return false;
        }
        DeviceNewClassic deviceNewClassic = (DeviceNewClassic) obj;
        return Intrinsics.areEqual((Object) this.uid, (Object) deviceNewClassic.uid) && Intrinsics.areEqual((Object) this.name, (Object) deviceNewClassic.name) && this.fanSpeed == deviceNewClassic.fanSpeed && Intrinsics.areEqual((Object) this.filterLife, (Object) deviceNewClassic.filterLife) && this.brightness == deviceNewClassic.brightness && Intrinsics.areEqual((Object) this.autoModeText, (Object) deviceNewClassic.autoModeText) && Intrinsics.areEqual((Object) this.info, (Object) deviceNewClassic.info) && Intrinsics.areEqual((Object) this.deviceUuid, (Object) deviceNewClassic.deviceUuid) && this.hasFinishedOnboarding == deviceNewClassic.hasFinishedOnboarding && Intrinsics.areEqual((Object) this.latestSensorDatapoint, (Object) deviceNewClassic.latestSensorDatapoint) && this.lastSelectedSensorTypeIndex == deviceNewClassic.lastSelectedSensorTypeIndex && this.isChildLockOn == deviceNewClassic.isChildLockOn && this.connectivityStatusIndex == deviceNewClassic.connectivityStatusIndex && this.lastConnectivityInMillis == deviceNewClassic.lastConnectivityInMillis && Intrinsics.areEqual((Object) this.mac, (Object) deviceNewClassic.mac) && Intrinsics.areEqual((Object) this.mcuFirmware, (Object) deviceNewClassic.mcuFirmware) && Intrinsics.areEqual((Object) this.wifiFirmware, (Object) deviceNewClassic.wifiFirmware) && Intrinsics.areEqual((Object) this.hardware, (Object) deviceNewClassic.hardware) && Intrinsics.areEqual((Object) this.timeZone, (Object) deviceNewClassic.timeZone) && Intrinsics.areEqual((Object) this.serial, (Object) deviceNewClassic.serial) && Intrinsics.areEqual((Object) this.purchaseDate, (Object) deviceNewClassic.purchaseDate) && Intrinsics.areEqual((Object) this.dealerName, (Object) deviceNewClassic.dealerName) && Intrinsics.areEqual((Object) this.dealerCountry, (Object) deviceNewClassic.dealerCountry) && Intrinsics.areEqual((Object) this.filterType, (Object) deviceNewClassic.filterType) && Intrinsics.areEqual((Object) this.filterTrigger, (Object) deviceNewClassic.filterTrigger) && Intrinsics.areEqual((Object) this.pm1Ranges, (Object) deviceNewClassic.pm1Ranges) && Intrinsics.areEqual((Object) this.pm10Ranges, (Object) deviceNewClassic.pm10Ranges) && Intrinsics.areEqual((Object) this.pm25Ranges, (Object) deviceNewClassic.pm25Ranges) && Intrinsics.areEqual((Object) this.vocRanges, (Object) deviceNewClassic.vocRanges) && Intrinsics.areEqual((Object) this.hchoRanges, (Object) deviceNewClassic.hchoRanges) && this.updateProgress == deviceNewClassic.updateProgress && this.isStandByOn == deviceNewClassic.isStandByOn && this.isEcoModeOn == deviceNewClassic.isEcoModeOn && this.isHinsModeOn == deviceNewClassic.isHinsModeOn && this.isHinsNightModeOn == deviceNewClassic.isHinsNightModeOn && this.isG4NightModeOn == deviceNewClassic.isG4NightModeOn && Intrinsics.areEqual((Object) this.g4NightModeFilterTrigger, (Object) deviceNewClassic.g4NightModeFilterTrigger) && Intrinsics.areEqual((Object) this.modelName, (Object) deviceNewClassic.modelName) && this.typeIndex == deviceNewClassic.typeIndex && Intrinsics.areEqual((Object) this.sku, (Object) deviceNewClassic.sku) && Intrinsics.areEqual((Object) this.welcomeHome, (Object) deviceNewClassic.welcomeHome);
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
        int hashCode5 = (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode4 + (indoorDatapoint == null ? 0 : indoorDatapoint.hashCode())) * 31) + this.lastSelectedSensorTypeIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn)) * 31) + this.connectivityStatusIndex) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis)) * 31) + this.mac.hashCode()) * 31) + this.mcuFirmware.hashCode()) * 31) + this.wifiFirmware.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.timeZone.hashCode()) * 31) + this.serial.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.dealerName.hashCode()) * 31) + this.dealerCountry.hashCode()) * 31) + this.filterType.hashCode()) * 31) + this.filterTrigger.hashCode()) * 31) + Arrays.hashCode(this.pm1Ranges)) * 31) + Arrays.hashCode(this.pm10Ranges)) * 31) + Arrays.hashCode(this.pm25Ranges)) * 31) + Arrays.hashCode(this.vocRanges)) * 31) + Arrays.hashCode(this.hchoRanges)) * 31) + this.updateProgress) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isEcoModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isHinsModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isHinsNightModeOn)) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn)) * 31) + this.g4NightModeFilterTrigger.hashCode()) * 31) + this.modelName.hashCode()) * 31) + this.typeIndex) * 31;
        String str2 = this.sku;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        WelcomeHomeLocation welcomeHomeLocation = this.welcomeHome;
        if (welcomeHomeLocation != null) {
            i = welcomeHomeLocation.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "DeviceNewClassic(uid=" + this.uid + ", name=" + this.name + ", fanSpeed=" + this.fanSpeed + ", filterLife=" + this.filterLife + ", brightness=" + this.brightness + ", autoModeText=" + this.autoModeText + ", info=" + this.info + ", deviceUuid=" + this.deviceUuid + ", hasFinishedOnboarding=" + this.hasFinishedOnboarding + ", latestSensorDatapoint=" + this.latestSensorDatapoint + ", lastSelectedSensorTypeIndex=" + this.lastSelectedSensorTypeIndex + ", isChildLockOn=" + this.isChildLockOn + ", connectivityStatusIndex=" + this.connectivityStatusIndex + ", lastConnectivityInMillis=" + this.lastConnectivityInMillis + ", mac=" + this.mac + ", mcuFirmware=" + this.mcuFirmware + ", wifiFirmware=" + this.wifiFirmware + ", hardware=" + this.hardware + ", timeZone=" + this.timeZone + ", serial=" + this.serial + ", purchaseDate=" + this.purchaseDate + ", dealerName=" + this.dealerName + ", dealerCountry=" + this.dealerCountry + ", filterType=" + this.filterType + ", filterTrigger=" + this.filterTrigger + ", pm1Ranges=" + Arrays.toString(this.pm1Ranges) + ", pm10Ranges=" + Arrays.toString(this.pm10Ranges) + ", pm25Ranges=" + Arrays.toString(this.pm25Ranges) + ", vocRanges=" + Arrays.toString(this.vocRanges) + ", hchoRanges=" + Arrays.toString(this.hchoRanges) + ", updateProgress=" + this.updateProgress + ", isStandByOn=" + this.isStandByOn + ", isEcoModeOn=" + this.isEcoModeOn + ", isHinsModeOn=" + this.isHinsModeOn + ", isHinsNightModeOn=" + this.isHinsNightModeOn + ", isG4NightModeOn=" + this.isG4NightModeOn + ", g4NightModeFilterTrigger=" + this.g4NightModeFilterTrigger + ", modelName=" + this.modelName + ", typeIndex=" + this.typeIndex + ", sku=" + this.sku + ", welcomeHome=" + this.welcomeHome + ')';
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
        parcel.writeInt(this.isEcoModeOn ? 1 : 0);
        parcel.writeInt(this.isHinsModeOn ? 1 : 0);
        parcel.writeInt(this.isHinsNightModeOn ? 1 : 0);
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

    public DeviceNewClassic(String str, String str2, int i, Integer num, int i2, String str3, String str4, DeviceUuid deviceUuid2, boolean z, IndoorDatapoint indoorDatapoint, int i3, boolean z2, int i4, long j, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5, int i5, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str16, String str17, int i6, String str18, WelcomeHomeLocation welcomeHomeLocation) {
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
        this.isEcoModeOn = z4;
        this.isHinsModeOn = z5;
        this.isHinsNightModeOn = z6;
        this.isG4NightModeOn = z7;
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
    public /* synthetic */ DeviceNewClassic(java.lang.String r36, java.lang.String r37, int r38, java.lang.Integer r39, int r40, java.lang.String r41, java.lang.String r42, com.blueair.core.model.DeviceUuid r43, boolean r44, com.blueair.core.model.IndoorDatapoint r45, int r46, boolean r47, int r48, long r49, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, double[] r62, double[] r63, double[] r64, double[] r65, double[] r66, int r67, boolean r68, boolean r69, boolean r70, boolean r71, boolean r72, java.lang.String r73, java.lang.String r74, int r75, java.lang.String r76, com.blueair.core.model.WelcomeHomeLocation r77, int r78, int r79, kotlin.jvm.internal.DefaultConstructorMarker r80) {
        /*
            r35 = this;
            r0 = r78
            r1 = r79
            r2 = r0 & 2
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = "Pairing…"
            goto L_0x000d
        L_0x000b:
            r2 = r37
        L_0x000d:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0015
        L_0x0013:
            r3 = r38
        L_0x0015:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001b
            r5 = 0
            goto L_0x001d
        L_0x001b:
            r5 = r39
        L_0x001d:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0023
            r7 = 0
            goto L_0x0025
        L_0x0023:
            r7 = r40
        L_0x0025:
            r8 = r0 & 32
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002d
            r8 = r9
            goto L_0x002f
        L_0x002d:
            r8 = r41
        L_0x002f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0035
            r10 = 0
            goto L_0x0037
        L_0x0035:
            r10 = r42
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r11 = 0
            goto L_0x003f
        L_0x003d:
            r11 = r43
        L_0x003f:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0045
            r12 = 0
            goto L_0x0047
        L_0x0045:
            r12 = r44
        L_0x0047:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x004d
            r13 = 0
            goto L_0x004f
        L_0x004d:
            r13 = r45
        L_0x004f:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0055
            r14 = 0
            goto L_0x0057
        L_0x0055:
            r14 = r46
        L_0x0057:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x005d
            r15 = 0
            goto L_0x005f
        L_0x005d:
            r15 = r47
        L_0x005f:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006a
            com.blueair.core.model.ConnectivityStatus r6 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r6 = r6.ordinal()
            goto L_0x006c
        L_0x006a:
            r6 = r48
        L_0x006c:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x0073
            r16 = 0
            goto L_0x0075
        L_0x0073:
            r16 = r49
        L_0x0075:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x007b
            r4 = r9
            goto L_0x007d
        L_0x007b:
            r4 = r51
        L_0x007d:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x0087
            r18 = r9
            goto L_0x0089
        L_0x0087:
            r18 = r52
        L_0x0089:
            r19 = 65536(0x10000, float:9.18355E-41)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x0092
            r19 = r9
            goto L_0x0094
        L_0x0092:
            r19 = r53
        L_0x0094:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009d
            r20 = r9
            goto L_0x009f
        L_0x009d:
            r20 = r54
        L_0x009f:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00a8
            r21 = r9
            goto L_0x00aa
        L_0x00a8:
            r21 = r55
        L_0x00aa:
            r22 = 524288(0x80000, float:7.34684E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00b3
            r22 = r9
            goto L_0x00b5
        L_0x00b3:
            r22 = r56
        L_0x00b5:
            r23 = 1048576(0x100000, float:1.469368E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00be
            r23 = r9
            goto L_0x00c0
        L_0x00be:
            r23 = r57
        L_0x00c0:
            r24 = 2097152(0x200000, float:2.938736E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c9
            r24 = r9
            goto L_0x00cb
        L_0x00c9:
            r24 = r58
        L_0x00cb:
            r25 = 4194304(0x400000, float:5.877472E-39)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00d4
            r25 = r9
            goto L_0x00d6
        L_0x00d4:
            r25 = r59
        L_0x00d6:
            r26 = 8388608(0x800000, float:1.17549435E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00df
            r26 = r9
            goto L_0x00e1
        L_0x00df:
            r26 = r60
        L_0x00e1:
            r27 = 16777216(0x1000000, float:2.3509887E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00ea
            r27 = r9
            goto L_0x00ec
        L_0x00ea:
            r27 = r61
        L_0x00ec:
            r28 = 33554432(0x2000000, float:9.403955E-38)
            r28 = r0 & r28
            r80 = r2
            r0 = 0
            if (r28 == 0) goto L_0x00f8
            double[] r2 = new double[r0]
            goto L_0x00fa
        L_0x00f8:
            r2 = r62
        L_0x00fa:
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            r28 = r78 & r28
            r38 = r2
            if (r28 == 0) goto L_0x0105
            double[] r2 = new double[r0]
            goto L_0x0107
        L_0x0105:
            r2 = r63
        L_0x0107:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r78 & r28
            r39 = r2
            if (r28 == 0) goto L_0x0112
            double[] r2 = new double[r0]
            goto L_0x0114
        L_0x0112:
            r2 = r64
        L_0x0114:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
            r28 = r78 & r28
            r40 = r2
            if (r28 == 0) goto L_0x011f
            double[] r2 = new double[r0]
            goto L_0x0121
        L_0x011f:
            r2 = r65
        L_0x0121:
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            r28 = r78 & r28
            r41 = r2
            if (r28 == 0) goto L_0x012c
            double[] r2 = new double[r0]
            goto L_0x012e
        L_0x012c:
            r2 = r66
        L_0x012e:
            r28 = 1073741824(0x40000000, float:2.0)
            r28 = r78 & r28
            if (r28 == 0) goto L_0x0137
            r28 = r0
            goto L_0x0139
        L_0x0137:
            r28 = r67
        L_0x0139:
            r29 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = r78 & r29
            if (r29 == 0) goto L_0x0142
            r29 = r0
            goto L_0x0144
        L_0x0142:
            r29 = r68
        L_0x0144:
            r30 = r1 & 1
            if (r30 == 0) goto L_0x014b
            r30 = r0
            goto L_0x014d
        L_0x014b:
            r30 = r69
        L_0x014d:
            r31 = r1 & 2
            if (r31 == 0) goto L_0x0154
            r31 = r0
            goto L_0x0156
        L_0x0154:
            r31 = r70
        L_0x0156:
            r32 = r1 & 4
            if (r32 == 0) goto L_0x015d
            r32 = r0
            goto L_0x015f
        L_0x015d:
            r32 = r71
        L_0x015f:
            r33 = r1 & 8
            if (r33 == 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r0 = r72
        L_0x0166:
            r33 = r1 & 16
            if (r33 == 0) goto L_0x016d
            r33 = r9
            goto L_0x016f
        L_0x016d:
            r33 = r73
        L_0x016f:
            r34 = r1 & 32
            if (r34 == 0) goto L_0x0174
            goto L_0x0176
        L_0x0174:
            r9 = r74
        L_0x0176:
            r34 = r1 & 64
            if (r34 == 0) goto L_0x0181
            com.blueair.core.model.DeviceType$NewClassic r34 = com.blueair.core.model.DeviceType.NewClassic.INSTANCE
            int r34 = r34.getIndex()
            goto L_0x0183
        L_0x0181:
            r34 = r75
        L_0x0183:
            r42 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018b
            r0 = 0
            goto L_0x018d
        L_0x018b:
            r0 = r76
        L_0x018d:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0194
            r79 = 0
            goto L_0x0196
        L_0x0194:
            r79 = r77
        L_0x0196:
            r37 = r35
            r64 = r38
            r65 = r39
            r66 = r40
            r67 = r41
            r74 = r42
            r39 = r80
            r78 = r0
            r68 = r2
            r40 = r3
            r53 = r4
            r41 = r5
            r50 = r6
            r42 = r7
            r43 = r8
            r76 = r9
            r44 = r10
            r45 = r11
            r46 = r12
            r47 = r13
            r48 = r14
            r49 = r15
            r51 = r16
            r54 = r18
            r55 = r19
            r56 = r20
            r57 = r21
            r58 = r22
            r59 = r23
            r60 = r24
            r61 = r25
            r62 = r26
            r63 = r27
            r69 = r28
            r70 = r29
            r71 = r30
            r72 = r31
            r73 = r32
            r75 = r33
            r77 = r34
            r38 = r36
            r37.<init>(r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.DeviceNewClassic.<init>(java.lang.String, java.lang.String, int, java.lang.Integer, int, java.lang.String, java.lang.String, com.blueair.core.model.DeviceUuid, boolean, com.blueair.core.model.IndoorDatapoint, int, boolean, int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double[], double[], double[], double[], double[], int, boolean, boolean, boolean, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String, com.blueair.core.model.WelcomeHomeLocation, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public boolean isEcoModeOn() {
        return this.isEcoModeOn;
    }

    public boolean isHinsModeOn() {
        return this.isHinsModeOn;
    }

    public boolean isHinsNightModeOn() {
        return this.isHinsNightModeOn;
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
