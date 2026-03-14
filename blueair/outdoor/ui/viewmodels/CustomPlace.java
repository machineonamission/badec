package com.blueair.outdoor.ui.viewmodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0017HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006%"},
   d2 = {"Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "Landroid/os/Parcelable;", "lat", "", "lng", "address", "", "shortAddress", "<init>", "(DDLjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLat", "()D", "getLng", "getAddress", "()Ljava/lang/String;", "getShortAddress", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CustomPlace implements Parcelable {
   public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker)null);
   private final String address;
   private final double lat;
   private final double lng;
   private final String shortAddress;

   public CustomPlace(double var1, double var3, String var5, String var6) {
      this.lat = var1;
      this.lng = var3;
      this.address = var5;
      this.shortAddress = var6;
   }

   // $FF: synthetic method
   public CustomPlace(double var1, double var3, String var5, String var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 8) != 0) {
         var6 = var5;
      }

      this(var1, var3, var5, var6);
   }

   public CustomPlace(Parcel var1) {
      Intrinsics.checkNotNullParameter(var1, "parcel");
      this(var1.readDouble(), var1.readDouble(), var1.readString(), var1.readString());
   }

   // $FF: synthetic method
   public static CustomPlace copy$default(CustomPlace var0, double var1, double var3, String var5, String var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.lat;
      }

      if ((var7 & 2) != 0) {
         var3 = var0.lng;
      }

      if ((var7 & 4) != 0) {
         var5 = var0.address;
      }

      if ((var7 & 8) != 0) {
         var6 = var0.shortAddress;
      }

      return var0.copy(var1, var3, var5, var6);
   }

   public final double component1() {
      return this.lat;
   }

   public final double component2() {
      return this.lng;
   }

   public final String component3() {
      return this.address;
   }

   public final String component4() {
      return this.shortAddress;
   }

   public final CustomPlace copy(double var1, double var3, String var5, String var6) {
      return new CustomPlace(var1, var3, var5, var6);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof CustomPlace)) {
         return false;
      } else {
         var1 = var1;
         if (Double.compare(this.lat, var1.lat) != 0) {
            return false;
         } else if (Double.compare(this.lng, var1.lng) != 0) {
            return false;
         } else if (!Intrinsics.areEqual(this.address, var1.address)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.shortAddress, var1.shortAddress);
         }
      }
   }

   public final String getAddress() {
      return this.address;
   }

   public final double getLat() {
      return this.lat;
   }

   public final double getLng() {
      return this.lng;
   }

   public final String getShortAddress() {
      return this.shortAddress;
   }

   public int hashCode() {
      int var3 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lat);
      int var4 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lng);
      String var5 = this.address;
      int var2 = 0;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      var5 = this.shortAddress;
      if (var5 != null) {
         var2 = var5.hashCode();
      }

      return ((var3 * 31 + var4) * 31 + var1) * 31 + var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("CustomPlace(lat=");
      var1.append(this.lat);
      var1.append(", lng=");
      var1.append(this.lng);
      var1.append(", address=");
      var1.append(this.address);
      var1.append(", shortAddress=");
      var1.append(this.shortAddress);
      var1.append(')');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeDouble(this.lat);
      var1.writeDouble(this.lng);
      var1.writeString(this.address);
      var1.writeString(this.shortAddress);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"},
      d2 = {"Lcom/blueair/outdoor/ui/viewmodels/CustomPlace$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CREATOR implements Parcelable.Creator {
      private CREATOR() {
      }

      // $FF: synthetic method
      public CREATOR(DefaultConstructorMarker var1) {
         this();
      }

      public CustomPlace createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new CustomPlace(var1);
      }

      public CustomPlace[] newArray(int var1) {
         return new CustomPlace[var1];
      }
   }
}
