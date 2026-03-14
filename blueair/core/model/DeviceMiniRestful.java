package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000eBß\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0010\u0012\b\b\u0002\u0010!\u001a\u00020\u0010\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u0012\b\b\u0002\u0010#\u001a\u00020\u0010\u0012\b\b\u0002\u0010$\u001a\u00020\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\u0010\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\b\b\u0002\u0010'\u001a\u00020\u0010\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\b\b\u0002\u0010)\u001a\u00020\u0010\u0012\b\b\u0002\u0010*\u001a\u00020\u0010\u0012\b\b\u0002\u0010+\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u001b\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u0012\b\b\u0002\u0010.\u001a\u00020\u0013\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u00100\u001a\u00020\u0013\u0012\b\b\u0002\u00101\u001a\u00020\u0013\u0012\b\b\u0002\u00102\u001a\u00020\u0013\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504\u0012\b\b\u0002\u00106\u001a\u00020\u001b¢\u0006\u0004\b7\u00108J\u0006\u0010`\u001a\u00020\u001bJ\t\u0010a\u001a\u00020\u0010HÆ\u0003J\t\u0010b\u001a\u00020\u0010HÆ\u0003J\t\u0010c\u001a\u00020\u0013HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010?J\t\u0010e\u001a\u00020\u0013HÆ\u0003J\t\u0010f\u001a\u00020\u0010HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010i\u001a\u00020\u001bHÆ\u0003J\t\u0010j\u001a\u00020\u001bHÆ\u0003J\t\u0010k\u001a\u00020\u0013HÆ\u0003J\t\u0010l\u001a\u00020\u001fHÆ\u0003J\t\u0010m\u001a\u00020\u0010HÆ\u0003J\t\u0010n\u001a\u00020\u0010HÆ\u0003J\t\u0010o\u001a\u00020\u0010HÆ\u0003J\t\u0010p\u001a\u00020\u0010HÆ\u0003J\t\u0010q\u001a\u00020\u0010HÆ\u0003J\t\u0010r\u001a\u00020\u0010HÆ\u0003J\t\u0010s\u001a\u00020\u0010HÆ\u0003J\t\u0010t\u001a\u00020\u0010HÆ\u0003J\t\u0010u\u001a\u00020\u0010HÆ\u0003J\t\u0010v\u001a\u00020\u0010HÆ\u0003J\t\u0010w\u001a\u00020\u0010HÆ\u0003J\t\u0010x\u001a\u00020\u0013HÆ\u0003J\t\u0010y\u001a\u00020\u001bHÆ\u0003J\t\u0010z\u001a\u00020\u0010HÆ\u0003J\t\u0010{\u001a\u00020\u0013HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010}\u001a\u00020\u0013HÆ\u0003J\t\u0010~\u001a\u00020\u0013HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0013HÆ\u0003J\u0012\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u001bHÆ\u0003Jê\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00102\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00102\b\b\u0002\u0010%\u001a\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u00102\b\b\u0002\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00132\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u00020\u00132\b\b\u0002\u00102\u001a\u00020\u00132\u0010\b\u0002\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u000105042\b\b\u0002\u00106\u001a\u00020\u001bHÆ\u0001¢\u0006\u0003\u0010\u0083\u0001J\u0007\u0010\u0084\u0001\u001a\u00020\u0013J\u0016\u0010\u0085\u0001\u001a\u00020\u001b2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0013HÖ\u0001J\n\u0010\u0089\u0001\u001a\u00020\u0010HÖ\u0001J\u001b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0013R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0014\u0010\u0011\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0014\u0010\u0015\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0014\u0010\u0016\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010:R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010:R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010\u001a\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0014\u0010\u001c\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010GR\u0014\u0010\u001d\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010=R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010 \u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010:R\u0014\u0010!\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010:R\u0014\u0010\"\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010:R\u0014\u0010#\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010:R\u0014\u0010$\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010:R\u0014\u0010%\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010:R\u0014\u0010&\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010:R\u0014\u0010'\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010:R\u0014\u0010(\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010:R\u0014\u0010)\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010:R\u0014\u0010*\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010:R\u0014\u0010+\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010=R\u0014\u0010,\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010GR\u0014\u0010-\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010:R\u0014\u0010.\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010=R\u0016\u0010/\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010:R\u0014\u00100\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010=R\u0014\u00101\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010=R\u0014\u00102\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010=R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010504X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0014\u00106\u001a\u00020\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010G¨\u0006\u008f\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceMiniRestful;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasMainMode;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/HasNightLamp;", "Lcom/blueair/core/model/HasHourFormat;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "updateProgress", "isStandByOn", "modelName", "typeIndex", "sku", "mainMode", "apSubMode", "nightLampSteplessBrightness", "alarms", "", "Lcom/blueair/core/model/DeviceAlarm;", "use24Hour", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ILjava/lang/String;IIILjava/util/List;Z)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getUpdateProgress", "getModelName", "getTypeIndex", "getSku", "getMainMode", "getApSubMode", "getNightLampSteplessBrightness", "getAlarms", "()Ljava/util/List;", "getUse24Hour", "hasNightMode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ILjava/lang/String;IIILjava/util/List;Z)Lcom/blueair/core/model/DeviceMiniRestful;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceMiniRestful implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasScheduling, HasSKU, HasMainMode, HasAlarm, HasNightLamp, HasHourFormat {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final List alarms;
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

   public DeviceMiniRestful(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, boolean var26, String var27, int var28, String var29, int var30, int var31, int var32, List var33, boolean var34) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var14, "mac");
      Intrinsics.checkNotNullParameter(var15, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var16, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var17, "hardware");
      Intrinsics.checkNotNullParameter(var18, "timeZone");
      Intrinsics.checkNotNullParameter(var19, "serial");
      Intrinsics.checkNotNullParameter(var20, "purchaseDate");
      Intrinsics.checkNotNullParameter(var21, "dealerName");
      Intrinsics.checkNotNullParameter(var22, "dealerCountry");
      Intrinsics.checkNotNullParameter(var23, "filterType");
      Intrinsics.checkNotNullParameter(var24, "filterTrigger");
      Intrinsics.checkNotNullParameter(var27, "modelName");
      Intrinsics.checkNotNullParameter(var33, "alarms");
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
      this.isChildLockOn = var10;
      this.connectivityStatusIndex = var11;
      this.lastConnectivityInMillis = var12;
      this.mac = var14;
      this.mcuFirmware = var15;
      this.wifiFirmware = var16;
      this.hardware = var17;
      this.timeZone = var18;
      this.serial = var19;
      this.purchaseDate = var20;
      this.dealerName = var21;
      this.dealerCountry = var22;
      this.filterType = var23;
      this.filterTrigger = var24;
      this.updateProgress = var25;
      this.isStandByOn = var26;
      this.modelName = var27;
      this.typeIndex = var28;
      this.sku = var29;
      this.mainMode = var30;
      this.apSubMode = var31;
      this.nightLampSteplessBrightness = var32;
      this.alarms = var33;
      this.use24Hour = var34;
   }

   // $FF: synthetic method
   public DeviceMiniRestful(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, boolean var26, String var27, int var28, String var29, int var30, int var31, int var32, List var33, boolean var34, int var35, int var36, DefaultConstructorMarker var37) {
      if ((var35 & 2) != 0) {
         var2 = "Pairing…";
      }

      if ((var35 & 4) != 0) {
         var3 = 0;
      }

      if ((var35 & 8) != 0) {
         var4 = null;
      }

      if ((var35 & 16) != 0) {
         var5 = 0;
      }

      String var40 = "";
      if ((var35 & 32) != 0) {
         var6 = "";
      }

      if ((var35 & 64) != 0) {
         var7 = null;
      }

      if ((var35 & 128) != 0) {
         var8 = null;
      }

      if ((var35 & 256) != 0) {
         var9 = false;
      }

      if ((var35 & 512) != 0) {
         var10 = false;
      }

      if ((var35 & 1024) != 0) {
         var11 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var35 & 2048) != 0) {
         var12 = 0L;
      }

      if ((var35 & 4096) != 0) {
         var14 = "";
      }

      if ((var35 & 8192) != 0) {
         var15 = "";
      }

      if ((var35 & 16384) != 0) {
         var16 = "";
      }

      if ((var35 & '耀') != 0) {
         var17 = "";
      }

      if ((var35 & 65536) != 0) {
         var18 = "";
      }

      if ((var35 & 131072) != 0) {
         var19 = "";
      }

      if ((var35 & 262144) != 0) {
         var20 = "";
      }

      if ((var35 & 524288) != 0) {
         var21 = "";
      }

      if ((var35 & 1048576) != 0) {
         var22 = "";
      }

      if ((var35 & 2097152) != 0) {
         var23 = "";
      }

      if ((var35 & 4194304) != 0) {
         var24 = "";
      }

      if ((var35 & 8388608) != 0) {
         var25 = 0;
      }

      if ((var35 & 16777216) != 0) {
         var26 = false;
      }

      if ((var35 & 33554432) != 0) {
         var27 = var40;
      }

      if ((var35 & 67108864) != 0) {
         var28 = DeviceType.MiniRestful.INSTANCE.getIndex();
      }

      if ((var35 & 134217728) != 0) {
         var29 = null;
      }

      if ((var35 & 268435456) != 0) {
         var30 = 0;
      }

      if ((var35 & 536870912) != 0) {
         var31 = 2;
      }

      if ((var35 & 1073741824) != 0) {
         var32 = 1;
      }

      if ((var35 & Integer.MIN_VALUE) != 0) {
         ArrayList var38 = new ArrayList(6);

         for(int var39 = 0; var39 < 6; ++var39) {
            var38.add((Object)null);
         }

         var33 = (List)var38;
      }

      if ((var36 & 1) != 0) {
         var34 = true;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34);
   }

   // $FF: synthetic method
   public static DeviceMiniRestful copy$default(DeviceMiniRestful var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, boolean var26, String var27, int var28, String var29, int var30, int var31, int var32, List var33, boolean var34, int var35, int var36, Object var37) {
      if ((var35 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var35 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var35 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var35 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var35 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var35 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var35 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var35 & 128) != 0) {
         var8 = var0.deviceUuid;
      }

      if ((var35 & 256) != 0) {
         var9 = var0.hasFinishedOnboarding;
      }

      if ((var35 & 512) != 0) {
         var10 = var0.isChildLockOn;
      }

      if ((var35 & 1024) != 0) {
         var11 = var0.connectivityStatusIndex;
      }

      if ((var35 & 2048) != 0) {
         var12 = var0.lastConnectivityInMillis;
      }

      if ((var35 & 4096) != 0) {
         var14 = var0.mac;
      }

      if ((var35 & 8192) != 0) {
         var15 = var0.mcuFirmware;
      }

      if ((var35 & 16384) != 0) {
         var16 = var0.wifiFirmware;
      }

      if ((var35 & '耀') != 0) {
         var17 = var0.hardware;
      }

      if ((var35 & 65536) != 0) {
         var18 = var0.timeZone;
      }

      if ((var35 & 131072) != 0) {
         var19 = var0.serial;
      }

      if ((var35 & 262144) != 0) {
         var20 = var0.purchaseDate;
      }

      if ((var35 & 524288) != 0) {
         var21 = var0.dealerName;
      }

      if ((var35 & 1048576) != 0) {
         var22 = var0.dealerCountry;
      }

      if ((var35 & 2097152) != 0) {
         var23 = var0.filterType;
      }

      if ((var35 & 4194304) != 0) {
         var24 = var0.filterTrigger;
      }

      if ((var35 & 8388608) != 0) {
         var25 = var0.updateProgress;
      }

      if ((var35 & 16777216) != 0) {
         var26 = var0.isStandByOn;
      }

      if ((var35 & 33554432) != 0) {
         var27 = var0.modelName;
      }

      if ((var35 & 67108864) != 0) {
         var28 = var0.typeIndex;
      }

      if ((var35 & 134217728) != 0) {
         var29 = var0.sku;
      }

      if ((var35 & 268435456) != 0) {
         var30 = var0.mainMode;
      }

      if ((var35 & 536870912) != 0) {
         var31 = var0.apSubMode;
      }

      if ((var35 & 1073741824) != 0) {
         var32 = var0.nightLampSteplessBrightness;
      }

      if ((var35 & Integer.MIN_VALUE) != 0) {
         var33 = var0.alarms;
      }

      if ((var36 & 1) != 0) {
         var34 = var0.use24Hour;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34);
   }

   public ApSubMode apSubMode() {
      return HasMainMode$_CC.$default$apSubMode(this);
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

   public final List component32() {
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

   public final DeviceMiniRestful copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, boolean var10, int var11, long var12, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, int var25, boolean var26, String var27, int var28, String var29, int var30, int var31, int var32, List var33, boolean var34) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var14, "mac");
      Intrinsics.checkNotNullParameter(var15, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var16, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var17, "hardware");
      Intrinsics.checkNotNullParameter(var18, "timeZone");
      Intrinsics.checkNotNullParameter(var19, "serial");
      Intrinsics.checkNotNullParameter(var20, "purchaseDate");
      Intrinsics.checkNotNullParameter(var21, "dealerName");
      Intrinsics.checkNotNullParameter(var22, "dealerCountry");
      Intrinsics.checkNotNullParameter(var23, "filterType");
      Intrinsics.checkNotNullParameter(var24, "filterTrigger");
      Intrinsics.checkNotNullParameter(var27, "modelName");
      Intrinsics.checkNotNullParameter(var33, "alarms");
      return new DeviceMiniRestful(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceMiniRestful)) {
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
         } else if (this.updateProgress != var1.updateProgress) {
            return false;
         } else if (this.isStandByOn != var1.isStandByOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else if (this.mainMode != var1.mainMode) {
            return false;
         } else if (this.apSubMode != var1.apSubMode) {
            return false;
         } else if (this.nightLampSteplessBrightness != var1.nightLampSteplessBrightness) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarms, var1.alarms)) {
            return false;
         } else {
            return this.use24Hour == var1.use24Hour;
         }
      }
   }

   public List getAlarms() {
      return this.alarms;
   }

   public int getApSubMode() {
      return this.apSubMode;
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

   public String getInfo() {
      return this.info;
   }

   public long getLastConnectivityInMillis() {
      return this.lastConnectivityInMillis;
   }

   public String getMac() {
      return this.mac;
   }

   public int getMainMode() {
      return this.mainMode;
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

   public int getNightLampSteplessBrightness() {
      return this.nightLampSteplessBrightness;
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

   public String getUid() {
      return this.uid;
   }

   public int getUpdateProgress() {
      return this.updateProgress;
   }

   public boolean getUse24Hour() {
      return this.use24Hour;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public final boolean hasNightMode() {
      return McuFirmwareVersions.Companion.compare(this.getMcuFirmware(), SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestNightModeV2()) >= 0;
   }

   public int hashCode() {
      int var7 = this.uid.hashCode();
      int var5 = this.name.hashCode();
      int var6 = this.fanSpeed;
      Integer var29 = this.filterLife;
      int var4 = 0;
      int var1;
      if (var29 == null) {
         var1 = 0;
      } else {
         var1 = var29.hashCode();
      }

      int var9 = this.brightness;
      int var8 = this.autoModeText.hashCode();
      String var30 = this.info;
      int var2;
      if (var30 == null) {
         var2 = 0;
      } else {
         var2 = var30.hashCode();
      }

      DeviceUuid var31 = this.deviceUuid;
      int var3;
      if (var31 == null) {
         var3 = 0;
      } else {
         var3 = var31.hashCode();
      }

      int var24 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      int var21 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var13 = this.connectivityStatusIndex;
      int var25 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var10 = this.mac.hashCode();
      int var14 = this.mcuFirmware.hashCode();
      int var15 = this.wifiFirmware.hashCode();
      int var26 = this.hardware.hashCode();
      int var19 = this.timeZone.hashCode();
      int var18 = this.serial.hashCode();
      int var23 = this.purchaseDate.hashCode();
      int var27 = this.dealerName.hashCode();
      int var28 = this.dealerCountry.hashCode();
      int var12 = this.filterType.hashCode();
      int var22 = this.filterTrigger.hashCode();
      int var20 = this.updateProgress;
      int var11 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var16 = this.modelName.hashCode();
      int var17 = this.typeIndex;
      String var32 = this.sku;
      if (var32 != null) {
         var4 = var32.hashCode();
      }

      return (((((((((((((((((((((((((((((((var7 * 31 + var5) * 31 + var6) * 31 + var1) * 31 + var9) * 31 + var8) * 31 + var2) * 31 + var3) * 31 + var24) * 31 + var21) * 31 + var13) * 31 + var25) * 31 + var10) * 31 + var14) * 31 + var15) * 31 + var26) * 31 + var19) * 31 + var18) * 31 + var23) * 31 + var27) * 31 + var28) * 31 + var12) * 31 + var22) * 31 + var20) * 31 + var11) * 31 + var16) * 31 + var17) * 31 + var4) * 31 + this.mainMode) * 31 + this.apSubMode) * 31 + this.nightLampSteplessBrightness) * 31 + this.alarms.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.use24Hour);
   }

   public boolean isChildLockOn() {
      return this.isChildLockOn;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isInApSubMode(ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(this, var1);
   }

   public boolean isInMainMode(MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(this, var1);
   }

   public boolean isOnline() {
      return Device$_CC.$default$isOnline(this);
   }

   public boolean isStandByOn() {
      return this.isStandByOn;
   }

   public boolean isUsDevice() {
      return Device$_CC.$default$isUsDevice(this);
   }

   public MainMode mainMode() {
      return HasMainMode$_CC.$default$mainMode(this);
   }

   public boolean supportResetFilterOnline() {
      return Device$_CC.$default$supportResetFilterOnline(this);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceMiniRestful(uid=");
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
      var1.append(", updateProgress=");
      var1.append(this.updateProgress);
      var1.append(", isStandByOn=");
      var1.append(this.isStandByOn);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", sku=");
      var1.append(this.sku);
      var1.append(", mainMode=");
      var1.append(this.mainMode);
      var1.append(", apSubMode=");
      var1.append(this.apSubMode);
      var1.append(", nightLampSteplessBrightness=");
      var1.append(this.nightLampSteplessBrightness);
      var1.append(", alarms=");
      var1.append(this.alarms);
      var1.append(", use24Hour=");
      var1.append(this.use24Hour);
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
      DeviceUuid var5 = this.deviceUuid;
      if (var5 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var5.writeToParcel(var1, var2);
      }

      var1.writeInt(this.hasFinishedOnboarding);
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
      var1.writeInt(this.updateProgress);
      var1.writeInt(this.isStandByOn);
      var1.writeString(this.modelName);
      var1.writeInt(this.typeIndex);
      var1.writeString(this.sku);
      var1.writeInt(this.mainMode);
      var1.writeInt(this.apSubMode);
      var1.writeInt(this.nightLampSteplessBrightness);
      List var6 = this.alarms;
      var1.writeInt(var6.size());

      for(DeviceAlarm var7 : var6) {
         if (var7 == null) {
            var1.writeInt(0);
         } else {
            var1.writeInt(1);
            var7.writeToParcel(var1, var2);
         }
      }

      var1.writeInt(this.use24Hour);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceMiniRestful createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var21 = var1.readString();
         String var20 = var1.readString();
         int var4 = var1.readInt();
         Integer var18;
         if (var1.readInt() == 0) {
            var18 = null;
         } else {
            var18 = var1.readInt();
         }

         int var5 = var1.readInt();
         String var22 = var1.readString();
         String var23 = var1.readString();
         Object var19;
         if (var1.readInt() == 0) {
            var19 = null;
         } else {
            var19 = DeviceUuid.CREATOR.createFromParcel(var1);
         }

         DeviceUuid var33 = (DeviceUuid)var19;
         int var2 = var1.readInt();
         boolean var12 = true;
         boolean var13 = false;
         if (var2 == 0) {
            var12 = false;
         }

         if (var1.readInt() != 0) {
            var13 = true;
         }

         int var10 = var1.readInt();
         long var16 = var1.readLong();
         String var25 = var1.readString();
         String var26 = var1.readString();
         String var34 = var1.readString();
         String var31 = var1.readString();
         String var24 = var1.readString();
         String var28 = var1.readString();
         String var27 = var1.readString();
         String var32 = var1.readString();
         String var35 = var1.readString();
         String var30 = var1.readString();
         String var29 = var1.readString();
         boolean var14 = false;
         int var8 = var1.readInt();
         if (var1.readInt() != 0) {
            var14 = true;
         }

         String var37 = var1.readString();
         int var9 = var1.readInt();
         String var36 = var1.readString();
         int var7 = var1.readInt();
         int var6 = var1.readInt();
         int var11 = var1.readInt();
         var2 = var1.readInt();
         ArrayList var38 = new ArrayList(var2);

         for(int var3 = 0; var3 != var2; ++var3) {
            if (var1.readInt() == 0) {
               var19 = null;
            } else {
               var19 = DeviceAlarm.CREATOR.createFromParcel(var1);
            }

            var38.add(var19);
         }

         List var41 = (List)var38;
         boolean var15;
         if (var1.readInt() != 0) {
            var15 = true;
         } else {
            var15 = false;
         }

         return new DeviceMiniRestful(var21, var20, var4, var18, var5, var22, var23, var33, var12, var13, var10, var16, var25, var26, var34, var31, var24, var28, var27, var32, var35, var30, var29, var8, var14, var37, var9, var36, var7, var6, var11, var41, var15);
      }

      public final DeviceMiniRestful[] newArray(int var1) {
         return new DeviceMiniRestful[var1];
      }
   }
}
