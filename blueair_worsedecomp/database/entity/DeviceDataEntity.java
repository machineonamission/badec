package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.DataTrend;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.IndoorDatapoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u00109\u001a\u00020\u0012HÆ\u0003J¢\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020*2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0012HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006A"}, d2 = {"Lcom/blueair/database/entity/DeviceDataEntity;", "", "id", "", "deviceId", "time", "", "pm1", "", "pm10", "pm25", "voc", "hcho", "tmp", "hum", "fan", "weight", "trend", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;I)V", "getId", "()Ljava/lang/String;", "getDeviceId", "getTime", "()J", "getPm1", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPm10", "getPm25", "getVoc", "getHcho", "getTmp", "getHum", "getFan", "getWeight", "getTrend", "()I", "toDeviceData", "Lcom/blueair/core/model/DeviceData;", "isCelsius", "", "toIndoorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;I)Lcom/blueair/database/entity/DeviceDataEntity;", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDataEntity.kt */
public final class DeviceDataEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEVICE_DATA_TABLE = "device_data";
    public static final String DEVICE_ID = "deviceId";
    private final String deviceId;
    private final Float fan;
    private final Float hcho;
    private final Float hum;
    private final String id;
    private final Float pm1;
    private final Float pm10;
    private final Float pm25;
    private final long time;
    private final Float tmp;
    private final int trend;
    private final Float voc;
    private final Float weight;

    public DeviceDataEntity() {
        this((String) null, (String) null, 0, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, (Float) null, 0, 8191, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceDataEntity copy$default(DeviceDataEntity deviceDataEntity, String str, String str2, long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, int i, int i2, Object obj) {
        int i3 = i2;
        return deviceDataEntity.copy((i3 & 1) != 0 ? deviceDataEntity.id : str, (i3 & 2) != 0 ? deviceDataEntity.deviceId : str2, (i3 & 4) != 0 ? deviceDataEntity.time : j, (i3 & 8) != 0 ? deviceDataEntity.pm1 : f, (i3 & 16) != 0 ? deviceDataEntity.pm10 : f2, (i3 & 32) != 0 ? deviceDataEntity.pm25 : f3, (i3 & 64) != 0 ? deviceDataEntity.voc : f4, (i3 & 128) != 0 ? deviceDataEntity.hcho : f5, (i3 & 256) != 0 ? deviceDataEntity.tmp : f6, (i3 & 512) != 0 ? deviceDataEntity.hum : f7, (i3 & 1024) != 0 ? deviceDataEntity.fan : f8, (i3 & 2048) != 0 ? deviceDataEntity.weight : f9, (i3 & 4096) != 0 ? deviceDataEntity.trend : i);
    }

    public final String component1() {
        return this.id;
    }

    public final Float component10() {
        return this.hum;
    }

    public final Float component11() {
        return this.fan;
    }

    public final Float component12() {
        return this.weight;
    }

    public final int component13() {
        return this.trend;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final long component3() {
        return this.time;
    }

    public final Float component4() {
        return this.pm1;
    }

    public final Float component5() {
        return this.pm10;
    }

    public final Float component6() {
        return this.pm25;
    }

    public final Float component7() {
        return this.voc;
    }

    public final Float component8() {
        return this.hcho;
    }

    public final Float component9() {
        return this.tmp;
    }

    public final DeviceDataEntity copy(String str, String str2, long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, int i) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "id");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, DEVICE_ID);
        return new DeviceDataEntity(str3, str4, j, f, f2, f3, f4, f5, f6, f7, f8, f9, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceDataEntity)) {
            return false;
        }
        DeviceDataEntity deviceDataEntity = (DeviceDataEntity) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) deviceDataEntity.id) && Intrinsics.areEqual((Object) this.deviceId, (Object) deviceDataEntity.deviceId) && this.time == deviceDataEntity.time && Intrinsics.areEqual((Object) this.pm1, (Object) deviceDataEntity.pm1) && Intrinsics.areEqual((Object) this.pm10, (Object) deviceDataEntity.pm10) && Intrinsics.areEqual((Object) this.pm25, (Object) deviceDataEntity.pm25) && Intrinsics.areEqual((Object) this.voc, (Object) deviceDataEntity.voc) && Intrinsics.areEqual((Object) this.hcho, (Object) deviceDataEntity.hcho) && Intrinsics.areEqual((Object) this.tmp, (Object) deviceDataEntity.tmp) && Intrinsics.areEqual((Object) this.hum, (Object) deviceDataEntity.hum) && Intrinsics.areEqual((Object) this.fan, (Object) deviceDataEntity.fan) && Intrinsics.areEqual((Object) this.weight, (Object) deviceDataEntity.weight) && this.trend == deviceDataEntity.trend;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.deviceId.hashCode()) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.time)) * 31;
        Float f = this.pm1;
        int i = 0;
        int hashCode2 = (hashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.pm10;
        int hashCode3 = (hashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.pm25;
        int hashCode4 = (hashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.voc;
        int hashCode5 = (hashCode4 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.hcho;
        int hashCode6 = (hashCode5 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.tmp;
        int hashCode7 = (hashCode6 + (f6 == null ? 0 : f6.hashCode())) * 31;
        Float f7 = this.hum;
        int hashCode8 = (hashCode7 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Float f8 = this.fan;
        int hashCode9 = (hashCode8 + (f8 == null ? 0 : f8.hashCode())) * 31;
        Float f9 = this.weight;
        if (f9 != null) {
            i = f9.hashCode();
        }
        return ((hashCode9 + i) * 31) + this.trend;
    }

    public String toString() {
        return "DeviceDataEntity(id=" + this.id + ", deviceId=" + this.deviceId + ", time=" + this.time + ", pm1=" + this.pm1 + ", pm10=" + this.pm10 + ", pm25=" + this.pm25 + ", voc=" + this.voc + ", hcho=" + this.hcho + ", tmp=" + this.tmp + ", hum=" + this.hum + ", fan=" + this.fan + ", weight=" + this.weight + ", trend=" + this.trend + ')';
    }

    public DeviceDataEntity(String str, String str2, long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Float f9, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, DEVICE_ID);
        this.id = str;
        this.deviceId = str2;
        this.time = j;
        this.pm1 = f;
        this.pm10 = f2;
        this.pm25 = f3;
        this.voc = f4;
        this.hcho = f5;
        this.tmp = f6;
        this.hum = f7;
        this.fan = f8;
        this.weight = f9;
        this.trend = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceDataEntity(java.lang.String r16, java.lang.String r17, long r18, java.lang.Float r20, java.lang.Float r21, java.lang.Float r22, java.lang.Float r23, java.lang.Float r24, java.lang.Float r25, java.lang.Float r26, java.lang.Float r27, java.lang.Float r28, int r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r16
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = r17
        L_0x0013:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001a
            r3 = 0
            goto L_0x001c
        L_0x001a:
            r3 = r18
        L_0x001c:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0023
            r5 = r6
            goto L_0x0025
        L_0x0023:
            r5 = r20
        L_0x0025:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002b
            r7 = r6
            goto L_0x002d
        L_0x002b:
            r7 = r21
        L_0x002d:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            r8 = r6
            goto L_0x0035
        L_0x0033:
            r8 = r22
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            r9 = r6
            goto L_0x003d
        L_0x003b:
            r9 = r23
        L_0x003d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0043
            r10 = r6
            goto L_0x0045
        L_0x0043:
            r10 = r24
        L_0x0045:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004b
            r11 = r6
            goto L_0x004d
        L_0x004b:
            r11 = r25
        L_0x004d:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0053
            r12 = r6
            goto L_0x0055
        L_0x0053:
            r12 = r26
        L_0x0055:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005b
            r13 = r6
            goto L_0x005d
        L_0x005b:
            r13 = r27
        L_0x005d:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r6 = r28
        L_0x0064:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0071
            com.blueair.core.model.DataTrend$HistoricalTrend r0 = com.blueair.core.model.DataTrend.HistoricalTrend.INSTANCE
            int r0 = r0.getCode()
            r30 = r0
            goto L_0x0073
        L_0x0071:
            r30 = r29
        L_0x0073:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r21 = r5
            r29 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.entity.DeviceDataEntity.<init>(java.lang.String, java.lang.String, long, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getTime() {
        return this.time;
    }

    public final Float getPm1() {
        return this.pm1;
    }

    public final Float getPm10() {
        return this.pm10;
    }

    public final Float getPm25() {
        return this.pm25;
    }

    public final Float getVoc() {
        return this.voc;
    }

    public final Float getHcho() {
        return this.hcho;
    }

    public final Float getTmp() {
        return this.tmp;
    }

    public final Float getHum() {
        return this.hum;
    }

    public final Float getFan() {
        return this.fan;
    }

    public final Float getWeight() {
        return this.weight;
    }

    public final int getTrend() {
        return this.trend;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/database/entity/DeviceDataEntity$Companion;", "", "<init>", "()V", "DEVICE_DATA_TABLE", "", "DEVICE_ID", "fromDeviceData", "", "Lcom/blueair/database/entity/DeviceDataEntity;", "input", "Lcom/blueair/core/model/DeviceData;", "dataTrend", "Lcom/blueair/core/model/DataTrend;", "toDeviceData", "isCelsius", "", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDataEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceDataEntity> fromDeviceData(DeviceData deviceData, DataTrend dataTrend) {
            DeviceDataEntity deviceDataEntity;
            DeviceData deviceData2 = deviceData;
            Intrinsics.checkNotNullParameter(deviceData2, "input");
            DataTrend dataTrend2 = dataTrend;
            Intrinsics.checkNotNullParameter(dataTrend2, "dataTrend");
            Collection arrayList = new ArrayList();
            for (IndoorDatapoint indoorDatapoint : deviceData2.getRawDataPoints()) {
                if (indoorDatapoint.getTimeInSeconds() < 946656000) {
                    deviceDataEntity = null;
                } else {
                    deviceDataEntity = new DeviceDataEntity(deviceData2.getDeviceId() + indoorDatapoint.getTimeInSeconds(), deviceData2.getDeviceId(), indoorDatapoint.getTimeInSeconds(), indoorDatapoint.getPm1(), indoorDatapoint.getPm10(), indoorDatapoint.getPm25(), indoorDatapoint.getVoc(), indoorDatapoint.getHcho(), indoorDatapoint.getTmp(), indoorDatapoint.getHum(), indoorDatapoint.getFan(), indoorDatapoint.getWeight(), dataTrend2.getCode());
                }
                if (deviceDataEntity != null) {
                    arrayList.add(deviceDataEntity);
                }
            }
            return (List) arrayList;
        }

        public final DeviceData toDeviceData(List<DeviceDataEntity> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "input");
            if (CollectionsKt.firstOrNull(list) == null) {
                return new DeviceData("", CollectionsKt.emptyList(), z);
            }
            String deviceId = ((DeviceDataEntity) CollectionsKt.first(list)).getDeviceId();
            Iterable<DeviceDataEntity> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (DeviceDataEntity indoorDatapoint : iterable) {
                arrayList.add(indoorDatapoint.toIndoorDatapoint());
            }
            return new DeviceData(deviceId, (List) arrayList, z);
        }
    }

    public final DeviceData toDeviceData(boolean z) {
        return new DeviceData(this.deviceId, CollectionsKt.listOf(toIndoorDatapoint()), z);
    }

    public final IndoorDatapoint toIndoorDatapoint() {
        return new IndoorDatapoint(this.time, this.pm1, this.pm10, this.pm25, this.voc, this.hcho, this.tmp, this.hum, this.fan, this.weight);
    }
}
