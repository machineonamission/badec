package com.blueair.database.entity;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.DataTrend;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.IndoorDatapoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CB§\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010;\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010<\u001a\u00020\u0013HÆ\u0003J®\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020,2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0013HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006D"},
   d2 = {"Lcom/blueair/database/entity/DeviceDataEntity;", "", "id", "", "deviceId", "time", "", "pm1", "", "pm10", "pm25", "voc", "hcho", "tmp", "hum", "fan", "weight", "rpm", "trend", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;I)V", "getId", "()Ljava/lang/String;", "getDeviceId", "getTime", "()J", "getPm1", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPm10", "getPm25", "getVoc", "getHcho", "getTmp", "getHum", "getFan", "getWeight", "getRpm", "getTrend", "()I", "toDeviceData", "Lcom/blueair/core/model/DeviceData;", "isCelsius", "", "toIndoorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;I)Lcom/blueair/database/entity/DeviceDataEntity;", "equals", "other", "hashCode", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDataEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
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
   private final Float rpm;
   private final long time;
   private final Float tmp;
   private final int trend;
   private final Float voc;
   private final Float weight;

   public DeviceDataEntity() {
      this((String)null, (String)null, 0L, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, (Float)null, 0, 16383, (DefaultConstructorMarker)null);
   }

   public DeviceDataEntity(String var1, String var2, long var3, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12, Float var13, Float var14, int var15) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      super();
      this.id = var1;
      this.deviceId = var2;
      this.time = var3;
      this.pm1 = var5;
      this.pm10 = var6;
      this.pm25 = var7;
      this.voc = var8;
      this.hcho = var9;
      this.tmp = var10;
      this.hum = var11;
      this.fan = var12;
      this.weight = var13;
      this.rpm = var14;
      this.trend = var15;
   }

   // $FF: synthetic method
   public DeviceDataEntity(String var1, String var2, long var3, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12, Float var13, Float var14, int var15, int var16, DefaultConstructorMarker var17) {
      String var18 = "";
      if ((var16 & 1) != 0) {
         var1 = "";
      }

      if ((var16 & 2) != 0) {
         var2 = var18;
      }

      if ((var16 & 4) != 0) {
         var3 = 0L;
      }

      Object var19 = null;
      if ((var16 & 8) != 0) {
         var5 = null;
      }

      if ((var16 & 16) != 0) {
         var6 = null;
      }

      if ((var16 & 32) != 0) {
         var7 = null;
      }

      if ((var16 & 64) != 0) {
         var8 = null;
      }

      if ((var16 & 128) != 0) {
         var9 = null;
      }

      if ((var16 & 256) != 0) {
         var10 = null;
      }

      if ((var16 & 512) != 0) {
         var11 = null;
      }

      if ((var16 & 1024) != 0) {
         var12 = null;
      }

      if ((var16 & 2048) != 0) {
         var13 = null;
      }

      if ((var16 & 4096) != 0) {
         var14 = (Float)var19;
      }

      if ((var16 & 8192) != 0) {
         var15 = DataTrend.HistoricalTrend.INSTANCE.getCode();
      }

      this(var1, var2, var3, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   // $FF: synthetic method
   public static DeviceDataEntity copy$default(DeviceDataEntity var0, String var1, String var2, long var3, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12, Float var13, Float var14, int var15, int var16, Object var17) {
      if ((var16 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var16 & 2) != 0) {
         var2 = var0.deviceId;
      }

      if ((var16 & 4) != 0) {
         var3 = var0.time;
      }

      if ((var16 & 8) != 0) {
         var5 = var0.pm1;
      }

      if ((var16 & 16) != 0) {
         var6 = var0.pm10;
      }

      if ((var16 & 32) != 0) {
         var7 = var0.pm25;
      }

      if ((var16 & 64) != 0) {
         var8 = var0.voc;
      }

      if ((var16 & 128) != 0) {
         var9 = var0.hcho;
      }

      if ((var16 & 256) != 0) {
         var10 = var0.tmp;
      }

      if ((var16 & 512) != 0) {
         var11 = var0.hum;
      }

      if ((var16 & 1024) != 0) {
         var12 = var0.fan;
      }

      if ((var16 & 2048) != 0) {
         var13 = var0.weight;
      }

      if ((var16 & 4096) != 0) {
         var14 = var0.rpm;
      }

      if ((var16 & 8192) != 0) {
         var15 = var0.trend;
      }

      return var0.copy(var1, var2, var3, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
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

   public final Float component13() {
      return this.rpm;
   }

   public final int component14() {
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

   public final DeviceDataEntity copy(String var1, String var2, long var3, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12, Float var13, Float var14, int var15) {
      Intrinsics.checkNotNullParameter(var1, "id");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      return new DeviceDataEntity(var1, var2, var3, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceDataEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceId, var1.deviceId)) {
            return false;
         } else if (this.time != var1.time) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm1, var1.pm1)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm10, var1.pm10)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm25, var1.pm25)) {
            return false;
         } else if (!Intrinsics.areEqual(this.voc, var1.voc)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hcho, var1.hcho)) {
            return false;
         } else if (!Intrinsics.areEqual(this.tmp, var1.tmp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hum, var1.hum)) {
            return false;
         } else if (!Intrinsics.areEqual(this.fan, var1.fan)) {
            return false;
         } else if (!Intrinsics.areEqual(this.weight, var1.weight)) {
            return false;
         } else if (!Intrinsics.areEqual(this.rpm, var1.rpm)) {
            return false;
         } else {
            return this.trend == var1.trend;
         }
      }
   }

   public final String getDeviceId() {
      return this.deviceId;
   }

   public final Float getFan() {
      return this.fan;
   }

   public final Float getHcho() {
      return this.hcho;
   }

   public final Float getHum() {
      return this.hum;
   }

   public final String getId() {
      return this.id;
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

   public final Float getRpm() {
      return this.rpm;
   }

   public final long getTime() {
      return this.time;
   }

   public final Float getTmp() {
      return this.tmp;
   }

   public final int getTrend() {
      return this.trend;
   }

   public final Float getVoc() {
      return this.voc;
   }

   public final Float getWeight() {
      return this.weight;
   }

   public int hashCode() {
      int var12 = this.id.hashCode();
      int var13 = this.deviceId.hashCode();
      int var11 = AddDeviceState$$ExternalSyntheticBackport0.m(this.time);
      Float var14 = this.pm1;
      int var10 = 0;
      int var1;
      if (var14 == null) {
         var1 = 0;
      } else {
         var1 = var14.hashCode();
      }

      var14 = this.pm10;
      int var2;
      if (var14 == null) {
         var2 = 0;
      } else {
         var2 = var14.hashCode();
      }

      var14 = this.pm25;
      int var3;
      if (var14 == null) {
         var3 = 0;
      } else {
         var3 = var14.hashCode();
      }

      var14 = this.voc;
      int var4;
      if (var14 == null) {
         var4 = 0;
      } else {
         var4 = var14.hashCode();
      }

      var14 = this.hcho;
      int var5;
      if (var14 == null) {
         var5 = 0;
      } else {
         var5 = var14.hashCode();
      }

      var14 = this.tmp;
      int var6;
      if (var14 == null) {
         var6 = 0;
      } else {
         var6 = var14.hashCode();
      }

      var14 = this.hum;
      int var7;
      if (var14 == null) {
         var7 = 0;
      } else {
         var7 = var14.hashCode();
      }

      var14 = this.fan;
      int var8;
      if (var14 == null) {
         var8 = 0;
      } else {
         var8 = var14.hashCode();
      }

      var14 = this.weight;
      int var9;
      if (var14 == null) {
         var9 = 0;
      } else {
         var9 = var14.hashCode();
      }

      var14 = this.rpm;
      if (var14 != null) {
         var10 = var14.hashCode();
      }

      return ((((((((((((var12 * 31 + var13) * 31 + var11) * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + this.trend;
   }

   public final DeviceData toDeviceData(boolean var1) {
      return new DeviceData(this.deviceId, CollectionsKt.listOf(this.toIndoorDatapoint()), var1);
   }

   public final IndoorDatapoint toIndoorDatapoint() {
      return new IndoorDatapoint(this.time, this.pm1, this.pm10, this.pm25, this.voc, this.hcho, this.tmp, this.hum, this.fan, this.weight, this.rpm);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceDataEntity(id=");
      var1.append(this.id);
      var1.append(", deviceId=");
      var1.append(this.deviceId);
      var1.append(", time=");
      var1.append(this.time);
      var1.append(", pm1=");
      var1.append(this.pm1);
      var1.append(", pm10=");
      var1.append(this.pm10);
      var1.append(", pm25=");
      var1.append(this.pm25);
      var1.append(", voc=");
      var1.append(this.voc);
      var1.append(", hcho=");
      var1.append(this.hcho);
      var1.append(", tmp=");
      var1.append(this.tmp);
      var1.append(", hum=");
      var1.append(this.hum);
      var1.append(", fan=");
      var1.append(this.fan);
      var1.append(", weight=");
      var1.append(this.weight);
      var1.append(", rpm=");
      var1.append(this.rpm);
      var1.append(", trend=");
      var1.append(this.trend);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lcom/blueair/database/entity/DeviceDataEntity$Companion;", "", "<init>", "()V", "DEVICE_DATA_TABLE", "", "DEVICE_ID", "fromDeviceData", "", "Lcom/blueair/database/entity/DeviceDataEntity;", "input", "Lcom/blueair/core/model/DeviceData;", "dataTrend", "Lcom/blueair/core/model/DataTrend;", "toDeviceData", "isCelsius", "", "database_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final List fromDeviceData(DeviceData var1, DataTrend var2) {
         Intrinsics.checkNotNullParameter(var1, "input");
         Intrinsics.checkNotNullParameter(var2, "dataTrend");
         Iterable var3 = (Iterable)var1.getRawDataPoints();
         Collection var4 = (Collection)(new ArrayList());

         for(IndoorDatapoint var6 : var3) {
            DeviceDataEntity var7;
            if (var6.getTimeInSeconds() < 946656000L) {
               var7 = null;
            } else {
               StringBuilder var8 = new StringBuilder();
               var8.append(var1.getDeviceId());
               var8.append(var6.getTimeInSeconds());
               var7 = new DeviceDataEntity(var8.toString(), var1.getDeviceId(), var6.getTimeInSeconds(), var6.getPm1(), var6.getPm10(), var6.getPm25(), var6.getVoc(), var6.getHcho(), var6.getTmp(), var6.getHum(), var6.getFan(), var6.getWeight(), var6.getRpm(), var2.getCode());
            }

            if (var7 != null) {
               var4.add(var7);
            }
         }

         return (List)var4;
      }

      public final DeviceData toDeviceData(List var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "input");
         if (CollectionsKt.firstOrNull(var1) == null) {
            return new DeviceData("", CollectionsKt.emptyList(), var2);
         } else {
            String var3 = ((DeviceDataEntity)CollectionsKt.first(var1)).getDeviceId();
            Iterable var4 = (Iterable)var1;
            Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var4, 10)));
            Iterator var6 = var4.iterator();

            while(var6.hasNext()) {
               var5.add(((DeviceDataEntity)var6.next()).toIndoorDatapoint());
            }

            return new DeviceData(var3, (List)var5, var2);
         }
      }
   }
}
