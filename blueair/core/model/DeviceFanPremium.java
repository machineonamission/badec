package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\bf\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u0010BÃ\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0015\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0012\u0012\b\b\u0002\u0010#\u001a\u00020\u0012\u0012\b\b\u0002\u0010$\u001a\u00020\u0012\u0012\b\b\u0002\u0010%\u001a\u00020\u0012\u0012\b\b\u0002\u0010&\u001a\u00020\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0012\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012\b\b\u0002\u0010)\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\b\b\u0002\u0010+\u001a\u00020,\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010.\u001a\u00020,\u0012\b\b\u0002\u0010/\u001a\u00020,\u0012\b\b\u0002\u00100\u001a\u00020,\u0012\b\b\u0002\u00101\u001a\u00020\u0015\u0012\b\b\u0002\u00102\u001a\u00020\u001a\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u00104\u001a\u00020\u0015\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u00106\u001a\u00020\u0015\u0012\b\b\u0002\u00107\u001a\u00020\u0015\u0012\b\b\u0002\u00108\u001a\u00020\u0015\u0012\b\b\u0002\u00109\u001a\u00020!\u0012\b\b\u0002\u0010:\u001a\u00020\u0015\u0012\b\b\u0002\u0010;\u001a\u00020\u0015\u0012\b\b\u0002\u0010<\u001a\u00020\u0015\u0012\b\b\u0002\u0010=\u001a\u00020\u0015\u0012\b\b\u0002\u0010>\u001a\u00020\u0015\u0012\b\b\u0002\u0010?\u001a\u00020\u0015\u0012\b\b\u0002\u0010@\u001a\u00020!\u0012\u0006\u0010A\u001a\u00020B\u0012\b\b\u0002\u0010C\u001a\u00020\u0015\u0012\b\b\u0002\u0010D\u001a\u00020,¢\u0006\u0004\bE\u0010FJ\t\u0010y\u001a\u00020\u0012HÆ\u0003J\t\u0010z\u001a\u00020\u0012HÆ\u0003J\t\u0010{\u001a\u00020\u0015HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010~\u001a\u00020\u001aHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020!HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020,HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020,HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020,HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020,HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020,HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020!HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¡\u0001\u001a\u00020!HÆ\u0003J\n\u0010¢\u0001\u001a\u00020BHÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¤\u0001\u001a\u00020,HÆ\u0003JÊ\u0003\u0010¥\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020,2\b\b\u0002\u00101\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u001a2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00152\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u00106\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\u00152\b\b\u0002\u00108\u001a\u00020\u00152\b\b\u0002\u00109\u001a\u00020!2\b\b\u0002\u0010:\u001a\u00020\u00152\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010=\u001a\u00020\u00152\b\b\u0002\u0010>\u001a\u00020\u00152\b\b\u0002\u0010?\u001a\u00020\u00152\b\b\u0002\u0010@\u001a\u00020!2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u00152\b\b\u0002\u0010D\u001a\u00020,HÆ\u0001J\u0007\u0010¦\u0001\u001a\u00020\u0015J\u0016\u0010§\u0001\u001a\u00020\u001a2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001HÖ\u0003J\n\u0010ª\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010«\u0001\u001a\u00020\u0012HÖ\u0001J\u001b\u0010¬\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020\u0015R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010\u0013\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010HR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010HR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010\u001d\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010KR\u0014\u0010\u001e\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010PR\u0014\u0010\u001f\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010KR\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0014\u0010\"\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010HR\u0014\u0010#\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010HR\u0014\u0010$\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010HR\u0014\u0010%\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010HR\u0014\u0010&\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010HR\u0014\u0010'\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010HR\u0014\u0010(\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010HR\u0014\u0010)\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010HR\u0014\u0010*\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010HR\u0014\u0010+\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0014\u0010-\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010aR\u0014\u0010.\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010aR\u0014\u0010/\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010aR\u0014\u00100\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010aR\u0014\u00101\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010KR\u0014\u00102\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010PR\u0014\u00103\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010HR\u0014\u00104\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010KR\u0016\u00105\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010HR\u0014\u00106\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010KR\u0014\u00107\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010KR\u0014\u00108\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010KR\u0014\u00109\u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010VR\u0014\u0010:\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010KR\u0014\u0010;\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010KR\u0014\u0010<\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010KR\u0014\u0010=\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010KR\u0014\u0010>\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010KR\u0014\u0010?\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010KR\u0014\u0010@\u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010VR\u0014\u0010A\u001a\u00020BX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0014\u0010C\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010KR\u0014\u0010D\u001a\u00020,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010a¨\u0006±\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceFanPremium;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasCoolMainMode;", "Lcom/blueair/core/model/HasTemperatureUnit;", "Lcom/blueair/core/model/HasNightModeTiming;", "Lcom/blueair/core/model/HasDualOscillation;", "Lcom/blueair/core/model/HasRpm;", "uid", "", "name", "brightness", "", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "modelName", "typeIndex", "sku", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "mainMode", "apSubMode", "coolSubMode", "coolFanSpeedLevel", "coolAutoLevel", "nightModeStartTime", "dualOscillationConfig", "Lcom/blueair/core/model/DualOscillationConfig;", "rpm", "nightPeriods", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;IIIJIIIIIIJLcom/blueair/core/model/DualOscillationConfig;I[D)V", "getUid", "()Ljava/lang/String;", "getName", "getBrightness", "()I", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getModelName", "getTypeIndex", "getSku", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getMainMode", "getApSubMode", "getCoolSubMode", "getCoolFanSpeedLevel", "getCoolAutoLevel", "getNightModeStartTime", "getDualOscillationConfig", "()Lcom/blueair/core/model/DualOscillationConfig;", "getRpm", "getNightPeriods", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFanPremium implements Device, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasScheduling, HasSKU, HasTimer, HasCoolMainMode, HasTemperatureUnit, HasNightModeTiming, HasDualOscillation, HasRpm {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int apSubMode;
   private final int brightness;
   private final int connectivityStatusIndex;
   private final int coolAutoLevel;
   private final int coolFanSpeedLevel;
   private final int coolSubMode;
   private final String dealerCountry;
   private final String dealerName;
   private final DeviceUuid deviceUuid;
   private final DualOscillationConfig dualOscillationConfig;
   private final String hardware;
   private final boolean hasFinishedOnboarding;
   private final double[] hchoRanges;
   private final String info;
   private final boolean isChildLockOn;
   private final boolean isStandByOn;
   private final long lastConnectivityInMillis;
   private final int lastSelectedSensorTypeIndex;
   private final IndoorDatapoint latestSensorDatapoint;
   private final String mac;
   private final int mainMode;
   private final String mcuFirmware;
   private final String modelName;
   private final String name;
   private final long nightModeStartTime;
   private final double[] nightPeriods;
   private final double[] pm10Ranges;
   private final double[] pm1Ranges;
   private final double[] pm25Ranges;
   private final String purchaseDate;
   private final int rpm;
   private final String serial;
   private final String sku;
   private final int temperatureUnit;
   private final String timeZone;
   private final int timerDuration;
   private final int timerLeftTime;
   private final long timerLeftTimeUpdateTime;
   private final int timerStatus;
   private final int typeIndex;
   private final String uid;
   private final int updateProgress;
   private final double[] vocRanges;
   private final String wifiFirmware;

   public DeviceFanPremium(String var1, String var2, int var3, String var4, DeviceUuid var5, boolean var6, IndoorDatapoint var7, int var8, boolean var9, int var10, long var11, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, double[] var22, double[] var23, double[] var24, double[] var25, double[] var26, int var27, boolean var28, String var29, int var30, String var31, int var32, int var33, int var34, long var35, int var37, int var38, int var39, int var40, int var41, int var42, long var43, DualOscillationConfig var45, int var46, double[] var47) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var13, "mac");
      Intrinsics.checkNotNullParameter(var14, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var15, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var16, "hardware");
      Intrinsics.checkNotNullParameter(var17, "timeZone");
      Intrinsics.checkNotNullParameter(var18, "serial");
      Intrinsics.checkNotNullParameter(var19, "purchaseDate");
      Intrinsics.checkNotNullParameter(var20, "dealerName");
      Intrinsics.checkNotNullParameter(var21, "dealerCountry");
      Intrinsics.checkNotNullParameter(var22, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var23, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var24, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var25, "vocRanges");
      Intrinsics.checkNotNullParameter(var26, "hchoRanges");
      Intrinsics.checkNotNullParameter(var29, "modelName");
      Intrinsics.checkNotNullParameter(var45, "dualOscillationConfig");
      Intrinsics.checkNotNullParameter(var47, "nightPeriods");
      super();
      this.uid = var1;
      this.name = var2;
      this.brightness = var3;
      this.info = var4;
      this.deviceUuid = var5;
      this.hasFinishedOnboarding = var6;
      this.latestSensorDatapoint = var7;
      this.lastSelectedSensorTypeIndex = var8;
      this.isChildLockOn = var9;
      this.connectivityStatusIndex = var10;
      this.lastConnectivityInMillis = var11;
      this.mac = var13;
      this.mcuFirmware = var14;
      this.wifiFirmware = var15;
      this.hardware = var16;
      this.timeZone = var17;
      this.serial = var18;
      this.purchaseDate = var19;
      this.dealerName = var20;
      this.dealerCountry = var21;
      this.pm1Ranges = var22;
      this.pm10Ranges = var23;
      this.pm25Ranges = var24;
      this.vocRanges = var25;
      this.hchoRanges = var26;
      this.updateProgress = var27;
      this.isStandByOn = var28;
      this.modelName = var29;
      this.typeIndex = var30;
      this.sku = var31;
      this.timerStatus = var32;
      this.timerDuration = var33;
      this.timerLeftTime = var34;
      this.timerLeftTimeUpdateTime = var35;
      this.temperatureUnit = var37;
      this.mainMode = var38;
      this.apSubMode = var39;
      this.coolSubMode = var40;
      this.coolFanSpeedLevel = var41;
      this.coolAutoLevel = var42;
      this.nightModeStartTime = var43;
      this.dualOscillationConfig = var45;
      this.rpm = var46;
      this.nightPeriods = var47;
   }

   // $FF: synthetic method
   public DeviceFanPremium(String var1, String var2, int var3, String var4, DeviceUuid var5, boolean var6, IndoorDatapoint var7, int var8, boolean var9, int var10, long var11, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, double[] var22, double[] var23, double[] var24, double[] var25, double[] var26, int var27, boolean var28, String var29, int var30, String var31, int var32, int var33, int var34, long var35, int var37, int var38, int var39, int var40, int var41, int var42, long var43, DualOscillationConfig var45, int var46, double[] var47, int var48, int var49, DefaultConstructorMarker var50) {
      if ((var48 & 2) != 0) {
         var2 = "Pairing…";
      }

      if ((var48 & 4) != 0) {
         var3 = 0;
      }

      if ((var48 & 8) != 0) {
         var4 = null;
      }

      if ((var48 & 16) != 0) {
         var5 = null;
      }

      if ((var48 & 32) != 0) {
         var6 = false;
      }

      if ((var48 & 64) != 0) {
         var7 = null;
      }

      if ((var48 & 128) != 0) {
         var8 = 0;
      }

      if ((var48 & 256) != 0) {
         var9 = false;
      }

      if ((var48 & 512) != 0) {
         var10 = ConnectivityStatus.ONLINE.ordinal();
      }

      if ((var48 & 1024) != 0) {
         var11 = 0L;
      }

      if ((var48 & 2048) != 0) {
         var13 = "";
      }

      if ((var48 & 4096) != 0) {
         var14 = "";
      }

      if ((var48 & 8192) != 0) {
         var15 = "";
      }

      if ((var48 & 16384) != 0) {
         var16 = "";
      }

      if (('耀' & var48) != 0) {
         var17 = "";
      }

      if ((65536 & var48) != 0) {
         var18 = "";
      }

      if ((131072 & var48) != 0) {
         var19 = "";
      }

      if ((262144 & var48) != 0) {
         var20 = "";
      }

      if ((524288 & var48) != 0) {
         var21 = "";
      }

      if ((1048576 & var48) != 0) {
         var22 = new double[0];
      }

      if ((2097152 & var48) != 0) {
         var23 = new double[0];
      }

      if ((4194304 & var48) != 0) {
         var24 = new double[0];
      }

      if ((8388608 & var48) != 0) {
         var25 = new double[0];
      }

      if ((16777216 & var48) != 0) {
         var26 = new double[0];
      }

      if ((33554432 & var48) != 0) {
         var27 = 0;
      }

      if ((67108864 & var48) != 0) {
         var28 = false;
      }

      if ((134217728 & var48) != 0) {
         var29 = "";
      }

      if ((268435456 & var48) != 0) {
         var30 = DeviceType.FanPremium.INSTANCE.getIndex();
      }

      if ((536870912 & var48) != 0) {
         var31 = null;
      }

      if ((1073741824 & var48) != 0) {
         var32 = 0;
      }

      if ((var48 & Integer.MIN_VALUE) != 0) {
         var33 = 0;
      }

      if ((var49 & 1) != 0) {
         var34 = 0;
      }

      if ((var49 & 2) != 0) {
         var35 = 0L;
      }

      if ((var49 & 4) != 0) {
         var37 = 0;
      }

      if ((var49 & 8) != 0) {
         var38 = 2;
      }

      if ((var49 & 16) != 0) {
         var39 = 2;
      }

      if ((var49 & 32) != 0) {
         var40 = 2;
      }

      if ((var49 & 64) != 0) {
         var41 = 1;
      }

      if ((var49 & 128) != 0) {
         var42 = 0;
      }

      if ((var49 & 256) != 0) {
         var43 = 0L;
      }

      if ((var49 & 1024) != 0) {
         var46 = 0;
      }

      if ((var49 & 2048) != 0) {
         var47 = new double[]{(double)8.0F, (double)7.0F, (double)4.0F, (double)0.0F};
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47);
   }

   // $FF: synthetic method
   public static DeviceFanPremium copy$default(DeviceFanPremium var0, String var1, String var2, int var3, String var4, DeviceUuid var5, boolean var6, IndoorDatapoint var7, int var8, boolean var9, int var10, long var11, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, double[] var22, double[] var23, double[] var24, double[] var25, double[] var26, int var27, boolean var28, String var29, int var30, String var31, int var32, int var33, int var34, long var35, int var37, int var38, int var39, int var40, int var41, int var42, long var43, DualOscillationConfig var45, int var46, double[] var47, int var48, int var49, Object var50) {
      if ((var48 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var48 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var48 & 4) != 0) {
         var3 = var0.brightness;
      }

      if ((var48 & 8) != 0) {
         var4 = var0.info;
      }

      if ((var48 & 16) != 0) {
         var5 = var0.deviceUuid;
      }

      if ((var48 & 32) != 0) {
         var6 = var0.hasFinishedOnboarding;
      }

      if ((var48 & 64) != 0) {
         var7 = var0.latestSensorDatapoint;
      }

      if ((var48 & 128) != 0) {
         var8 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var48 & 256) != 0) {
         var9 = var0.isChildLockOn;
      }

      if ((var48 & 512) != 0) {
         var10 = var0.connectivityStatusIndex;
      }

      if ((var48 & 1024) != 0) {
         var11 = var0.lastConnectivityInMillis;
      }

      if ((var48 & 2048) != 0) {
         var13 = var0.mac;
      }

      if ((var48 & 4096) != 0) {
         var14 = var0.mcuFirmware;
      }

      if ((var48 & 8192) != 0) {
         var15 = var0.wifiFirmware;
      }

      if ((var48 & 16384) != 0) {
         var16 = var0.hardware;
      }

      if ((var48 & '耀') != 0) {
         var17 = var0.timeZone;
      }

      if ((var48 & 65536) != 0) {
         var18 = var0.serial;
      }

      if ((var48 & 131072) != 0) {
         var19 = var0.purchaseDate;
      }

      if ((var48 & 262144) != 0) {
         var20 = var0.dealerName;
      }

      if ((var48 & 524288) != 0) {
         var21 = var0.dealerCountry;
      }

      if ((var48 & 1048576) != 0) {
         var22 = var0.pm1Ranges;
      }

      if ((var48 & 2097152) != 0) {
         var23 = var0.pm10Ranges;
      }

      if ((var48 & 4194304) != 0) {
         var24 = var0.pm25Ranges;
      }

      if ((var48 & 8388608) != 0) {
         var25 = var0.vocRanges;
      }

      if ((var48 & 16777216) != 0) {
         var26 = var0.hchoRanges;
      }

      if ((var48 & 33554432) != 0) {
         var27 = var0.updateProgress;
      }

      if ((var48 & 67108864) != 0) {
         var28 = var0.isStandByOn;
      }

      if ((var48 & 134217728) != 0) {
         var29 = var0.modelName;
      }

      if ((var48 & 268435456) != 0) {
         var30 = var0.typeIndex;
      }

      if ((var48 & 536870912) != 0) {
         var31 = var0.sku;
      }

      if ((var48 & 1073741824) != 0) {
         var32 = var0.timerStatus;
      }

      if ((var48 & Integer.MIN_VALUE) != 0) {
         var33 = var0.timerDuration;
      }

      if ((var49 & 1) != 0) {
         var34 = var0.timerLeftTime;
      }

      if ((var49 & 2) != 0) {
         var35 = var0.timerLeftTimeUpdateTime;
      }

      if ((var49 & 4) != 0) {
         var37 = var0.temperatureUnit;
      }

      if ((var49 & 8) != 0) {
         var38 = var0.mainMode;
      }

      if ((var49 & 16) != 0) {
         var39 = var0.apSubMode;
      }

      if ((var49 & 32) != 0) {
         var40 = var0.coolSubMode;
      }

      if ((var49 & 64) != 0) {
         var41 = var0.coolFanSpeedLevel;
      }

      if ((var49 & 128) != 0) {
         var42 = var0.coolAutoLevel;
      }

      if ((var49 & 256) != 0) {
         var43 = var0.nightModeStartTime;
      }

      if ((var49 & 512) != 0) {
         var45 = var0.dualOscillationConfig;
      }

      if ((var49 & 1024) != 0) {
         var46 = var0.rpm;
      }

      if ((var49 & 2048) != 0) {
         var47 = var0.nightPeriods;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47);
   }

   public double[] airRatingsFor(SensorType var1) {
      return HasSensorData$_CC.$default$airRatingsFor(this, var1);
   }

   public ApSubMode apSubMode() {
      return HasMainMode$_CC.$default$apSubMode(this);
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

   public final double[] component21() {
      return this.pm1Ranges;
   }

   public final double[] component22() {
      return this.pm10Ranges;
   }

   public final double[] component23() {
      return this.pm25Ranges;
   }

   public final double[] component24() {
      return this.vocRanges;
   }

   public final double[] component25() {
      return this.hchoRanges;
   }

   public final int component26() {
      return this.updateProgress;
   }

   public final boolean component27() {
      return this.isStandByOn;
   }

   public final String component28() {
      return this.modelName;
   }

   public final int component29() {
      return this.typeIndex;
   }

   public final int component3() {
      return this.brightness;
   }

   public final String component30() {
      return this.sku;
   }

   public final int component31() {
      return this.timerStatus;
   }

   public final int component32() {
      return this.timerDuration;
   }

   public final int component33() {
      return this.timerLeftTime;
   }

   public final long component34() {
      return this.timerLeftTimeUpdateTime;
   }

   public final int component35() {
      return this.temperatureUnit;
   }

   public final int component36() {
      return this.mainMode;
   }

   public final int component37() {
      return this.apSubMode;
   }

   public final int component38() {
      return this.coolSubMode;
   }

   public final int component39() {
      return this.coolFanSpeedLevel;
   }

   public final String component4() {
      return this.info;
   }

   public final int component40() {
      return this.coolAutoLevel;
   }

   public final long component41() {
      return this.nightModeStartTime;
   }

   public final DualOscillationConfig component42() {
      return this.dualOscillationConfig;
   }

   public final int component43() {
      return this.rpm;
   }

   public final double[] component44() {
      return this.nightPeriods;
   }

   public final DeviceUuid component5() {
      return this.deviceUuid;
   }

   public final boolean component6() {
      return this.hasFinishedOnboarding;
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

   public FanSpeedEnum coolFanSpeedEnum() {
      return HasCoolMainMode$_CC.$default$coolFanSpeedEnum(this);
   }

   public CoolSubMode coolSubMode() {
      return HasCoolMainMode$_CC.$default$coolSubMode(this);
   }

   public final DeviceFanPremium copy(String var1, String var2, int var3, String var4, DeviceUuid var5, boolean var6, IndoorDatapoint var7, int var8, boolean var9, int var10, long var11, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, double[] var22, double[] var23, double[] var24, double[] var25, double[] var26, int var27, boolean var28, String var29, int var30, String var31, int var32, int var33, int var34, long var35, int var37, int var38, int var39, int var40, int var41, int var42, long var43, DualOscillationConfig var45, int var46, double[] var47) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var13, "mac");
      Intrinsics.checkNotNullParameter(var14, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var15, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var16, "hardware");
      Intrinsics.checkNotNullParameter(var17, "timeZone");
      Intrinsics.checkNotNullParameter(var18, "serial");
      Intrinsics.checkNotNullParameter(var19, "purchaseDate");
      Intrinsics.checkNotNullParameter(var20, "dealerName");
      Intrinsics.checkNotNullParameter(var21, "dealerCountry");
      Intrinsics.checkNotNullParameter(var22, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var23, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var24, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var25, "vocRanges");
      Intrinsics.checkNotNullParameter(var26, "hchoRanges");
      Intrinsics.checkNotNullParameter(var29, "modelName");
      Intrinsics.checkNotNullParameter(var45, "dualOscillationConfig");
      Intrinsics.checkNotNullParameter(var47, "nightPeriods");
      return new DeviceFanPremium(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceFanPremium)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.brightness != var1.brightness) {
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
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else if (this.timerStatus != var1.timerStatus) {
            return false;
         } else if (this.timerDuration != var1.timerDuration) {
            return false;
         } else if (this.timerLeftTime != var1.timerLeftTime) {
            return false;
         } else if (this.timerLeftTimeUpdateTime != var1.timerLeftTimeUpdateTime) {
            return false;
         } else if (this.temperatureUnit != var1.temperatureUnit) {
            return false;
         } else if (this.mainMode != var1.mainMode) {
            return false;
         } else if (this.apSubMode != var1.apSubMode) {
            return false;
         } else if (this.coolSubMode != var1.coolSubMode) {
            return false;
         } else if (this.coolFanSpeedLevel != var1.coolFanSpeedLevel) {
            return false;
         } else if (this.coolAutoLevel != var1.coolAutoLevel) {
            return false;
         } else if (this.nightModeStartTime != var1.nightModeStartTime) {
            return false;
         } else if (!Intrinsics.areEqual(this.dualOscillationConfig, var1.dualOscillationConfig)) {
            return false;
         } else if (this.rpm != var1.rpm) {
            return false;
         } else {
            return Intrinsics.areEqual(this.nightPeriods, var1.nightPeriods);
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
   }

   public int getApSubMode() {
      return this.apSubMode;
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

   public int getCoolAutoLevel() {
      return this.coolAutoLevel;
   }

   public int getCoolFanSpeedLevel() {
      return this.coolFanSpeedLevel;
   }

   public int getCoolSubMode() {
      return this.coolSubMode;
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

   public DualOscillationConfig getDualOscillationConfig() {
      return this.dualOscillationConfig;
   }

   public String getHardware() {
      return this.hardware;
   }

   public boolean getHasFinishedOnboarding() {
      return this.hasFinishedOnboarding;
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

   public int getLeftSeconds() {
      return HasTimer$_CC.$default$getLeftSeconds(this);
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

   public long getNightModeStartTime() {
      return this.nightModeStartTime;
   }

   public double[] getNightPeriods() {
      return this.nightPeriods;
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

   public int getRealTimerLeftTime(long var1) {
      return HasTimer$_CC.$default$getRealTimerLeftTime(this, var1);
   }

   public int getRpm() {
      return this.rpm;
   }

   public String getSerial() {
      return this.serial;
   }

   public String getSku() {
      return this.sku;
   }

   public int getTemperatureUnit() {
      return this.temperatureUnit;
   }

   public String getTimeZone() {
      return this.timeZone;
   }

   public int getTimerDuration() {
      return this.timerDuration;
   }

   public int getTimerLeftTime() {
      return this.timerLeftTime;
   }

   public long getTimerLeftTimeUpdateTime() {
      return this.timerLeftTimeUpdateTime;
   }

   public int getTimerStatus() {
      return this.timerStatus;
   }

   public TimeZone getTimezone(Context var1) {
      return Device$_CC.$default$getTimezone(this, var1);
   }

   public DeviceType getType() {
      return Device$_CC.$default$getType(this);
   }

   public int getTypeIndex() {
      return this.typeIndex;
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

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var6 = this.uid.hashCode();
      int var7 = this.name.hashCode();
      int var5 = this.brightness;
      String var31 = this.info;
      int var4 = 0;
      int var1;
      if (var31 == null) {
         var1 = 0;
      } else {
         var1 = var31.hashCode();
      }

      DeviceUuid var32 = this.deviceUuid;
      int var2;
      if (var32 == null) {
         var2 = 0;
      } else {
         var2 = var32.hashCode();
      }

      int var8 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      IndoorDatapoint var33 = this.latestSensorDatapoint;
      int var3;
      if (var33 == null) {
         var3 = 0;
      } else {
         var3 = var33.hashCode();
      }

      int var21 = this.lastSelectedSensorTypeIndex;
      int var24 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var19 = this.connectivityStatusIndex;
      int var12 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var18 = this.mac.hashCode();
      int var14 = this.mcuFirmware.hashCode();
      int var20 = this.wifiFirmware.hashCode();
      int var10 = this.hardware.hashCode();
      int var26 = this.timeZone.hashCode();
      int var11 = this.serial.hashCode();
      int var16 = this.purchaseDate.hashCode();
      int var13 = this.dealerName.hashCode();
      int var22 = this.dealerCountry.hashCode();
      int var9 = Arrays.hashCode(this.pm1Ranges);
      int var23 = Arrays.hashCode(this.pm10Ranges);
      int var30 = Arrays.hashCode(this.pm25Ranges);
      int var28 = Arrays.hashCode(this.vocRanges);
      int var15 = Arrays.hashCode(this.hchoRanges);
      int var29 = this.updateProgress;
      int var27 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var17 = this.modelName.hashCode();
      int var25 = this.typeIndex;
      String var34 = this.sku;
      if (var34 != null) {
         var4 = var34.hashCode();
      }

      return ((((((((((((((((((((((((((((((((((((((((((var6 * 31 + var7) * 31 + var5) * 31 + var1) * 31 + var2) * 31 + var8) * 31 + var3) * 31 + var21) * 31 + var24) * 31 + var19) * 31 + var12) * 31 + var18) * 31 + var14) * 31 + var20) * 31 + var10) * 31 + var26) * 31 + var11) * 31 + var16) * 31 + var13) * 31 + var22) * 31 + var9) * 31 + var23) * 31 + var30) * 31 + var28) * 31 + var15) * 31 + var29) * 31 + var27) * 31 + var17) * 31 + var25) * 31 + var4) * 31 + this.timerStatus) * 31 + this.timerDuration) * 31 + this.timerLeftTime) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31 + this.temperatureUnit) * 31 + this.mainMode) * 31 + this.apSubMode) * 31 + this.coolSubMode) * 31 + this.coolFanSpeedLevel) * 31 + this.coolAutoLevel) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.nightModeStartTime)) * 31 + this.dualOscillationConfig.hashCode()) * 31 + this.rpm) * 31 + Arrays.hashCode(this.nightPeriods);
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

   public boolean isInSubMode(CoolSubMode var1) {
      return HasCoolMainMode$_CC.$default$isInSubMode(this, var1);
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

   public boolean supports(SensorType var1) {
      return HasSensorData$_CC.$default$supports(this, var1);
   }

   public TimerState timerStatus() {
      return HasTimer$_CC.$default$timerStatus(this);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceFanPremium(uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", brightness=");
      var1.append(this.brightness);
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
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", sku=");
      var1.append(this.sku);
      var1.append(", timerStatus=");
      var1.append(this.timerStatus);
      var1.append(", timerDuration=");
      var1.append(this.timerDuration);
      var1.append(", timerLeftTime=");
      var1.append(this.timerLeftTime);
      var1.append(", timerLeftTimeUpdateTime=");
      var1.append(this.timerLeftTimeUpdateTime);
      var1.append(", temperatureUnit=");
      var1.append(this.temperatureUnit);
      var1.append(", mainMode=");
      var1.append(this.mainMode);
      var1.append(", apSubMode=");
      var1.append(this.apSubMode);
      var1.append(", coolSubMode=");
      var1.append(this.coolSubMode);
      var1.append(", coolFanSpeedLevel=");
      var1.append(this.coolFanSpeedLevel);
      var1.append(", coolAutoLevel=");
      var1.append(this.coolAutoLevel);
      var1.append(", nightModeStartTime=");
      var1.append(this.nightModeStartTime);
      var1.append(", dualOscillationConfig=");
      var1.append(this.dualOscillationConfig);
      var1.append(", rpm=");
      var1.append(this.rpm);
      var1.append(", nightPeriods=");
      var1.append(Arrays.toString(this.nightPeriods));
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.uid);
      var1.writeString(this.name);
      var1.writeInt(this.brightness);
      var1.writeString(this.info);
      DeviceUuid var3 = this.deviceUuid;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var3.writeToParcel(var1, var2);
      }

      var1.writeInt(this.hasFinishedOnboarding);
      IndoorDatapoint var4 = this.latestSensorDatapoint;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
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
      var1.writeDoubleArray(this.pm1Ranges);
      var1.writeDoubleArray(this.pm10Ranges);
      var1.writeDoubleArray(this.pm25Ranges);
      var1.writeDoubleArray(this.vocRanges);
      var1.writeDoubleArray(this.hchoRanges);
      var1.writeInt(this.updateProgress);
      var1.writeInt(this.isStandByOn);
      var1.writeString(this.modelName);
      var1.writeInt(this.typeIndex);
      var1.writeString(this.sku);
      var1.writeInt(this.timerStatus);
      var1.writeInt(this.timerDuration);
      var1.writeInt(this.timerLeftTime);
      var1.writeLong(this.timerLeftTimeUpdateTime);
      var1.writeInt(this.temperatureUnit);
      var1.writeInt(this.mainMode);
      var1.writeInt(this.apSubMode);
      var1.writeInt(this.coolSubMode);
      var1.writeInt(this.coolFanSpeedLevel);
      var1.writeInt(this.coolAutoLevel);
      var1.writeLong(this.nightModeStartTime);
      this.dualOscillationConfig.writeToParcel(var1, var2);
      var1.writeInt(this.rpm);
      var1.writeDoubleArray(this.nightPeriods);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceFanPremium createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var15 = var1.readString();
         String var14 = var1.readString();
         int var2 = var1.readInt();
         String var13 = var1.readString();
         int var3 = var1.readInt();
         Object var12 = null;
         Object var11;
         if (var3 == 0) {
            var11 = null;
         } else {
            var11 = DeviceUuid.CREATOR.createFromParcel(var1);
         }

         DeviceUuid var16 = (DeviceUuid)var11;
         boolean var6;
         if (var1.readInt() != 0) {
            var6 = true;
         } else {
            var6 = false;
         }

         if (var1.readInt() == 0) {
            var11 = var12;
         } else {
            var11 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var24 = (IndoorDatapoint)var11;
         boolean var7 = false;
         int var5 = var1.readInt();
         if (var1.readInt() != 0) {
            var7 = true;
         }

         int var4 = var1.readInt();
         long var9 = var1.readLong();
         String var27 = var1.readString();
         String var29 = var1.readString();
         String var21 = var1.readString();
         String var33 = var1.readString();
         String var17 = var1.readString();
         String var18 = var1.readString();
         String var19 = var1.readString();
         String var23 = var1.readString();
         String var32 = var1.readString();
         double[] var25 = var1.createDoubleArray();
         double[] var22 = var1.createDoubleArray();
         double[] var28 = var1.createDoubleArray();
         double[] var20 = var1.createDoubleArray();
         double[] var26 = var1.createDoubleArray();
         boolean var8 = false;
         var3 = var1.readInt();
         if (var1.readInt() != 0) {
            var8 = true;
         }

         return new DeviceFanPremium(var15, var14, var2, var13, var16, var6, var24, var5, var7, var4, var9, var27, var29, var21, var33, var17, var18, var19, var23, var32, var25, var22, var28, var20, var26, var3, var8, var1.readString(), var1.readInt(), var1.readString(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readLong(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readLong(), (DualOscillationConfig)DualOscillationConfig.CREATOR.createFromParcel(var1), var1.readInt(), var1.createDoubleArray());
      }

      public final DeviceFanPremium[] newArray(int var1) {
         return new DeviceFanPremium[var1];
      }
   }
}
