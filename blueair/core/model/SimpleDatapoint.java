package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00038F¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\t¨\u0006!"},
   d2 = {"Lcom/blueair/core/model/SimpleDatapoint;", "Landroid/os/Parcelable;", "timeInSeconds", "", "value", "", "<init>", "(JF)V", "getTimeInSeconds", "()J", "getValue", "()F", "timeInMillis", "getTimeInMillis$annotations", "()V", "getTimeInMillis", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleDatapoint implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final long timeInSeconds;
   private final float value;

   public SimpleDatapoint(long var1, float var3) {
      this.timeInSeconds = var1;
      this.value = var3;
   }

   // $FF: synthetic method
   public static SimpleDatapoint copy$default(SimpleDatapoint var0, long var1, float var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.timeInSeconds;
      }

      if ((var4 & 2) != 0) {
         var3 = var0.value;
      }

      return var0.copy(var1, var3);
   }

   // $FF: synthetic method
   public static void getTimeInMillis$annotations() {
   }

   public final long component1() {
      return this.timeInSeconds;
   }

   public final float component2() {
      return this.value;
   }

   public final SimpleDatapoint copy(long var1, float var3) {
      return new SimpleDatapoint(var1, var3);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof SimpleDatapoint)) {
         return false;
      } else {
         var1 = var1;
         if (this.timeInSeconds != var1.timeInSeconds) {
            return false;
         } else {
            return Float.compare(this.value, var1.value) == 0;
         }
      }
   }

   public final long getTimeInMillis() {
      return this.timeInSeconds * (long)1000;
   }

   public final long getTimeInSeconds() {
      return this.timeInSeconds;
   }

   public final float getValue() {
      return this.value;
   }

   public int hashCode() {
      return AddDeviceState$$ExternalSyntheticBackport0.m(this.timeInSeconds) * 31 + Float.floatToIntBits(this.value);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("SimpleDatapoint(timeInSeconds=");
      var1.append(this.timeInSeconds);
      var1.append(", value=");
      var1.append(this.value);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeLong(this.timeInSeconds);
      var1.writeFloat(this.value);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final SimpleDatapoint createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new SimpleDatapoint(var1.readLong(), var1.readFloat());
      }

      public final SimpleDatapoint[] newArray(int var1) {
         return new SimpleDatapoint[var1];
      }
   }
}
