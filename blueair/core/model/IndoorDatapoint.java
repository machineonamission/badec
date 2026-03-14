package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020*¢\u0006\u0002\u0010+J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0090\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010=J\u0006\u0010>\u001a\u00020 J\u0013\u0010?\u001a\u00020-2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020 HÖ\u0001J\t\u0010C\u001a\u00020DHÖ\u0001J\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b,\u0010.¨\u0006J"},
   d2 = {"Lcom/blueair/core/model/IndoorDatapoint;", "Landroid/os/Parcelable;", "timeInSeconds", "", "pm1", "", "pm10", "pm25", "voc", "hcho", "tmp", "hum", "fan", "weight", "rpm", "<init>", "(JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getTimeInSeconds", "()J", "getPm1", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPm10", "getPm25", "getVoc", "getHcho", "getTmp", "getHum", "getFan", "getWeight", "getRpm", "disinftime", "", "getDisinftime", "()Ljava/lang/Integer;", "setDisinftime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "timeInMillis", "getTimeInMillis", "valueFor", "sensorType", "Lcom/blueair/core/model/SensorType;", "(Lcom/blueair/core/model/SensorType;)Ljava/lang/Float;", "isEmpty", "", "()Z", "isEmpty$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/blueair/core/model/IndoorDatapoint;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IndoorDatapoint implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private transient Integer disinftime;
   private final Float fan;
   private final Float hcho;
   private final Float hum;
   private final Lazy isEmpty$delegate;
   private final Float pm1;
   private final Float pm10;
   private final Float pm25;
   private final Float rpm;
   private final long timeInSeconds;
   private final Float tmp;
   private final Float voc;
   private final Float weight;

   // $FF: synthetic method
   public static boolean $r8$lambda$ScY8oeBtkWsuPd_feiSAd6acuwc/* $FF was: $r8$lambda$ScY8oeBtkWsuPd-feiSAd6acuwc*/(IndoorDatapoint var0) {
      return isEmpty_delegate$lambda$0(var0);
   }

   public IndoorDatapoint(long var1, Float var3, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12) {
      this.timeInSeconds = var1;
      this.pm1 = var3;
      this.pm10 = var4;
      this.pm25 = var5;
      this.voc = var6;
      this.hcho = var7;
      this.tmp = var8;
      this.hum = var9;
      this.fan = var10;
      this.weight = var11;
      this.rpm = var12;
      this.isEmpty$delegate = LazyKt.lazy(new IndoorDatapoint$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public static IndoorDatapoint copy$default(IndoorDatapoint var0, long var1, Float var3, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12, int var13, Object var14) {
      if ((var13 & 1) != 0) {
         var1 = var0.timeInSeconds;
      }

      if ((var13 & 2) != 0) {
         var3 = var0.pm1;
      }

      if ((var13 & 4) != 0) {
         var4 = var0.pm10;
      }

      if ((var13 & 8) != 0) {
         var5 = var0.pm25;
      }

      if ((var13 & 16) != 0) {
         var6 = var0.voc;
      }

      if ((var13 & 32) != 0) {
         var7 = var0.hcho;
      }

      if ((var13 & 64) != 0) {
         var8 = var0.tmp;
      }

      if ((var13 & 128) != 0) {
         var9 = var0.hum;
      }

      if ((var13 & 256) != 0) {
         var10 = var0.fan;
      }

      if ((var13 & 512) != 0) {
         var11 = var0.weight;
      }

      if ((var13 & 1024) != 0) {
         var12 = var0.rpm;
      }

      return var0.copy(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   private static final boolean isEmpty_delegate$lambda$0(IndoorDatapoint var0) {
      return var0.pm1 == null && var0.pm10 == null && var0.pm25 == null && var0.voc == null && var0.hcho == null && var0.tmp == null && var0.hum == null && var0.fan == null && var0.weight == null && var0.rpm == null && var0.disinftime == null;
   }

   public final long component1() {
      return this.timeInSeconds;
   }

   public final Float component10() {
      return this.weight;
   }

   public final Float component11() {
      return this.rpm;
   }

   public final Float component2() {
      return this.pm1;
   }

   public final Float component3() {
      return this.pm10;
   }

   public final Float component4() {
      return this.pm25;
   }

   public final Float component5() {
      return this.voc;
   }

   public final Float component6() {
      return this.hcho;
   }

   public final Float component7() {
      return this.tmp;
   }

   public final Float component8() {
      return this.hum;
   }

   public final Float component9() {
      return this.fan;
   }

   public final IndoorDatapoint copy(long var1, Float var3, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Float var12) {
      return new IndoorDatapoint(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof IndoorDatapoint)) {
         return false;
      } else {
         var1 = var1;
         if (this.timeInSeconds != var1.timeInSeconds) {
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
         } else {
            return Intrinsics.areEqual(this.rpm, var1.rpm);
         }
      }
   }

   public final Integer getDisinftime() {
      return this.disinftime;
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

   public final long getTimeInMillis() {
      return this.timeInSeconds * (long)1000;
   }

   public final long getTimeInSeconds() {
      return this.timeInSeconds;
   }

   public final Float getTmp() {
      return this.tmp;
   }

   public final Float getVoc() {
      return this.voc;
   }

   public final Float getWeight() {
      return this.weight;
   }

   public int hashCode() {
      int var11 = AddDeviceState$$ExternalSyntheticBackport0.m(this.timeInSeconds);
      Float var12 = this.pm1;
      int var10 = 0;
      int var1;
      if (var12 == null) {
         var1 = 0;
      } else {
         var1 = var12.hashCode();
      }

      var12 = this.pm10;
      int var2;
      if (var12 == null) {
         var2 = 0;
      } else {
         var2 = var12.hashCode();
      }

      var12 = this.pm25;
      int var3;
      if (var12 == null) {
         var3 = 0;
      } else {
         var3 = var12.hashCode();
      }

      var12 = this.voc;
      int var4;
      if (var12 == null) {
         var4 = 0;
      } else {
         var4 = var12.hashCode();
      }

      var12 = this.hcho;
      int var5;
      if (var12 == null) {
         var5 = 0;
      } else {
         var5 = var12.hashCode();
      }

      var12 = this.tmp;
      int var6;
      if (var12 == null) {
         var6 = 0;
      } else {
         var6 = var12.hashCode();
      }

      var12 = this.hum;
      int var7;
      if (var12 == null) {
         var7 = 0;
      } else {
         var7 = var12.hashCode();
      }

      var12 = this.fan;
      int var8;
      if (var12 == null) {
         var8 = 0;
      } else {
         var8 = var12.hashCode();
      }

      var12 = this.weight;
      int var9;
      if (var12 == null) {
         var9 = 0;
      } else {
         var9 = var12.hashCode();
      }

      var12 = this.rpm;
      if (var12 != null) {
         var10 = var12.hashCode();
      }

      return (((((((((var11 * 31 + var1) * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10;
   }

   public final boolean isEmpty() {
      return (Boolean)this.isEmpty$delegate.getValue();
   }

   public final void setDisinftime(Integer var1) {
      this.disinftime = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("IndoorDatapoint(timeInSeconds=");
      var1.append(this.timeInSeconds);
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
      var1.append(')');
      return var1.toString();
   }

   public final Float valueFor(SensorType var1) {
      Intrinsics.checkNotNullParameter(var1, "sensorType");
      switch (IndoorDatapoint.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
         case 1:
            return this.pm1;
         case 2:
            return this.pm10;
         case 3:
            return this.pm25;
         case 4:
            return this.voc;
         case 5:
            return this.hcho;
         case 6:
            return this.hum;
         case 7:
            return this.tmp;
         case 8:
            return this.fan;
         case 9:
            return this.weight;
         case 10:
            return this.rpm;
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeLong(this.timeInSeconds);
      Float var3 = this.pm1;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.pm10;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.pm25;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.voc;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.hcho;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.tmp;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.hum;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.fan;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.weight;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }

      var3 = this.rpm;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeFloat(var3);
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final IndoorDatapoint createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         long var3 = var1.readLong();
         int var2 = var1.readInt();
         Object var14 = null;
         Float var5;
         if (var2 == 0) {
            var5 = null;
         } else {
            var5 = var1.readFloat();
         }

         Float var6;
         if (var1.readInt() == 0) {
            var6 = null;
         } else {
            var6 = var1.readFloat();
         }

         Float var7;
         if (var1.readInt() == 0) {
            var7 = null;
         } else {
            var7 = var1.readFloat();
         }

         Float var8;
         if (var1.readInt() == 0) {
            var8 = null;
         } else {
            var8 = var1.readFloat();
         }

         Float var9;
         if (var1.readInt() == 0) {
            var9 = null;
         } else {
            var9 = var1.readFloat();
         }

         Float var10;
         if (var1.readInt() == 0) {
            var10 = null;
         } else {
            var10 = var1.readFloat();
         }

         Float var11;
         if (var1.readInt() == 0) {
            var11 = null;
         } else {
            var11 = var1.readFloat();
         }

         Float var12;
         if (var1.readInt() == 0) {
            var12 = null;
         } else {
            var12 = var1.readFloat();
         }

         Float var13;
         if (var1.readInt() == 0) {
            var13 = null;
         } else {
            var13 = var1.readFloat();
         }

         Float var15;
         if (var1.readInt() == 0) {
            var15 = (Float)var14;
         } else {
            var15 = var1.readFloat();
         }

         return new IndoorDatapoint(var3, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15);
      }

      public final IndoorDatapoint[] newArray(int var1) {
         return new IndoorDatapoint[var1];
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.PM1.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.FAN.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.WEIGHT.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.RPM.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
