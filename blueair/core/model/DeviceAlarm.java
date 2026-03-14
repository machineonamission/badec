package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003JY\u0010)\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\u00072\b\b\u0003\u0010\u000b\u001a\u00020\u00072\b\b\u0003\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0006\u0010*\u001a\u00020\u0007J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u00065"},
   d2 = {"Lcom/blueair/core/model/DeviceAlarm;", "Landroid/os/Parcelable;", "name", "", "enabled", "", "secondsInDay", "", "lightEnabled", "lightDuration", "sound", "volume", "repeats", "<init>", "(Ljava/lang/String;ZIZIIII)V", "getName", "()Ljava/lang/String;", "getEnabled", "()Z", "getSecondsInDay", "()I", "getLightEnabled", "getLightDuration", "getSound", "getVolume", "getRepeats", "daysOfWeek", "", "Lcom/blueair/core/model/DayOfWeek;", "getDaysOfWeek$annotations", "()V", "getDaysOfWeek", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAlarm implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final Set daysOfWeek;
   private final boolean enabled;
   private final int lightDuration;
   private final boolean lightEnabled;
   private final String name;
   private final int repeats;
   private final int secondsInDay;
   private final int sound;
   private final int volume;

   public DeviceAlarm(@Json(name = "n") String var1, @Json(name = "e") boolean var2, @Json(name = "t") int var3, @Json(name = "l") boolean var4, @Json(name = "ld") int var5, @Json(name = "s") int var6, @Json(name = "v") int var7, @Json(name = "r") int var8) {
      Intrinsics.checkNotNullParameter(var1, "name");
      super();
      this.name = var1;
      this.enabled = var2;
      this.secondsInDay = var3;
      this.lightEnabled = var4;
      this.lightDuration = var5;
      this.sound = var6;
      this.volume = var7;
      this.repeats = var8;
      HashSet var11 = new HashSet();
      BitSet var9 = BitSet.valueOf(new long[]{(long)var8});

      for(DayOfWeek var12 : (Iterable)CollectionsKt.sortedWith((Iterable)DayOfWeek.getEntries(), new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((DayOfWeek)var1).getMonFirstOrder(), (Comparable)((DayOfWeek)var2).getMonFirstOrder());
         }
      })) {
         if (var9.get(var12.getMonFirstOrder())) {
            var11.add(var12);
         }
      }

      this.daysOfWeek = (Set)var11;
   }

   // $FF: synthetic method
   public static DeviceAlarm copy$default(DeviceAlarm var0, String var1, boolean var2, int var3, boolean var4, int var5, int var6, int var7, int var8, int var9, Object var10) {
      if ((var9 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var9 & 2) != 0) {
         var2 = var0.enabled;
      }

      if ((var9 & 4) != 0) {
         var3 = var0.secondsInDay;
      }

      if ((var9 & 8) != 0) {
         var4 = var0.lightEnabled;
      }

      if ((var9 & 16) != 0) {
         var5 = var0.lightDuration;
      }

      if ((var9 & 32) != 0) {
         var6 = var0.sound;
      }

      if ((var9 & 64) != 0) {
         var7 = var0.volume;
      }

      if ((var9 & 128) != 0) {
         var8 = var0.repeats;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   // $FF: synthetic method
   public static void getDaysOfWeek$annotations() {
   }

   public final String component1() {
      return this.name;
   }

   public final boolean component2() {
      return this.enabled;
   }

   public final int component3() {
      return this.secondsInDay;
   }

   public final boolean component4() {
      return this.lightEnabled;
   }

   public final int component5() {
      return this.lightDuration;
   }

   public final int component6() {
      return this.sound;
   }

   public final int component7() {
      return this.volume;
   }

   public final int component8() {
      return this.repeats;
   }

   public final DeviceAlarm copy(@Json(name = "n") String var1, @Json(name = "e") boolean var2, @Json(name = "t") int var3, @Json(name = "l") boolean var4, @Json(name = "ld") int var5, @Json(name = "s") int var6, @Json(name = "v") int var7, @Json(name = "r") int var8) {
      Intrinsics.checkNotNullParameter(var1, "name");
      return new DeviceAlarm(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceAlarm)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.enabled != var1.enabled) {
            return false;
         } else if (this.secondsInDay != var1.secondsInDay) {
            return false;
         } else if (this.lightEnabled != var1.lightEnabled) {
            return false;
         } else if (this.lightDuration != var1.lightDuration) {
            return false;
         } else if (this.sound != var1.sound) {
            return false;
         } else if (this.volume != var1.volume) {
            return false;
         } else {
            return this.repeats == var1.repeats;
         }
      }
   }

   public final Set getDaysOfWeek() {
      return this.daysOfWeek;
   }

   public final boolean getEnabled() {
      return this.enabled;
   }

   public final int getLightDuration() {
      return this.lightDuration;
   }

   public final boolean getLightEnabled() {
      return this.lightEnabled;
   }

   public final String getName() {
      return this.name;
   }

   public final int getRepeats() {
      return this.repeats;
   }

   public final int getSecondsInDay() {
      return this.secondsInDay;
   }

   public final int getSound() {
      return this.sound;
   }

   public final int getVolume() {
      return this.volume;
   }

   public int hashCode() {
      return ((((((this.name.hashCode() * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.enabled)) * 31 + this.secondsInDay) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.lightEnabled)) * 31 + this.lightDuration) * 31 + this.sound) * 31 + this.volume) * 31 + this.repeats;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceAlarm(name=");
      var1.append(this.name);
      var1.append(", enabled=");
      var1.append(this.enabled);
      var1.append(", secondsInDay=");
      var1.append(this.secondsInDay);
      var1.append(", lightEnabled=");
      var1.append(this.lightEnabled);
      var1.append(", lightDuration=");
      var1.append(this.lightDuration);
      var1.append(", sound=");
      var1.append(this.sound);
      var1.append(", volume=");
      var1.append(this.volume);
      var1.append(", repeats=");
      var1.append(this.repeats);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.name);
      var1.writeInt(this.enabled);
      var1.writeInt(this.secondsInDay);
      var1.writeInt(this.lightEnabled);
      var1.writeInt(this.lightDuration);
      var1.writeInt(this.sound);
      var1.writeInt(this.volume);
      var1.writeInt(this.repeats);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceAlarm createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var5 = var1.readString();
         int var2 = var1.readInt();
         boolean var3 = true;
         if (var2 == 0) {
            var3 = false;
         }

         boolean var4 = false;
         var2 = var1.readInt();
         if (var1.readInt() != 0) {
            var4 = true;
         }

         return new DeviceAlarm(var5, var3, var2, var4, var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt());
      }

      public final DeviceAlarm[] newArray(int var1) {
         return new DeviceAlarm[var1];
      }
   }
}
