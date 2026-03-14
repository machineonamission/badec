package com.blueair.adddevice;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JW\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u00061"},
   d2 = {"Lcom/blueair/adddevice/DeviceInformationLegacy;", "Landroid/os/Parcelable;", "ipAddress", "", "macAddress", "id", "name", "model", "compatibility", "timeZone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIpAddress", "()Ljava/lang/String;", "setIpAddress", "(Ljava/lang/String;)V", "getMacAddress", "setMacAddress", "getId", "setId", "getName", "setName", "getModel", "setModel", "getCompatibility", "setCompatibility", "getTimeZone", "setTimeZone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceInformationLegacy implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private String compatibility;
   private String id;
   private String ipAddress;
   private String macAddress;
   private String model;
   private String name;
   private String timeZone;

   public DeviceInformationLegacy(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      Intrinsics.checkNotNullParameter(var3, "id");
      Intrinsics.checkNotNullParameter(var6, "compatibility");
      Intrinsics.checkNotNullParameter(var7, "timeZone");
      super();
      this.ipAddress = var1;
      this.macAddress = var2;
      this.id = var3;
      this.name = var4;
      this.model = var5;
      this.compatibility = var6;
      this.timeZone = var7;
   }

   // $FF: synthetic method
   public static DeviceInformationLegacy copy$default(DeviceInformationLegacy var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.ipAddress;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.macAddress;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.id;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.name;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.model;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.compatibility;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.timeZone;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final String component1() {
      return this.ipAddress;
   }

   public final String component2() {
      return this.macAddress;
   }

   public final String component3() {
      return this.id;
   }

   public final String component4() {
      return this.name;
   }

   public final String component5() {
      return this.model;
   }

   public final String component6() {
      return this.compatibility;
   }

   public final String component7() {
      return this.timeZone;
   }

   public final DeviceInformationLegacy copy(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      Intrinsics.checkNotNullParameter(var3, "id");
      Intrinsics.checkNotNullParameter(var6, "compatibility");
      Intrinsics.checkNotNullParameter(var7, "timeZone");
      return new DeviceInformationLegacy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceInformationLegacy)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.ipAddress, var1.ipAddress)) {
            return false;
         } else if (!Intrinsics.areEqual(this.macAddress, var1.macAddress)) {
            return false;
         } else if (!Intrinsics.areEqual(this.id, var1.id)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.model, var1.model)) {
            return false;
         } else if (!Intrinsics.areEqual(this.compatibility, var1.compatibility)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.timeZone, var1.timeZone);
         }
      }
   }

   public final String getCompatibility() {
      return this.compatibility;
   }

   public final String getId() {
      return this.id;
   }

   public final String getIpAddress() {
      return this.ipAddress;
   }

   public final String getMacAddress() {
      return this.macAddress;
   }

   public final String getModel() {
      return this.model;
   }

   public final String getName() {
      return this.name;
   }

   public final String getTimeZone() {
      return this.timeZone;
   }

   public int hashCode() {
      String var6 = this.ipAddress;
      int var4 = 0;
      int var1;
      if (var6 == null) {
         var1 = 0;
      } else {
         var1 = var6.hashCode();
      }

      var6 = this.macAddress;
      int var2;
      if (var6 == null) {
         var2 = 0;
      } else {
         var2 = var6.hashCode();
      }

      int var5 = this.id.hashCode();
      var6 = this.name;
      int var3;
      if (var6 == null) {
         var3 = 0;
      } else {
         var3 = var6.hashCode();
      }

      var6 = this.model;
      if (var6 != null) {
         var4 = var6.hashCode();
      }

      return (((((var1 * 31 + var2) * 31 + var5) * 31 + var3) * 31 + var4) * 31 + this.compatibility.hashCode()) * 31 + this.timeZone.hashCode();
   }

   public final void setCompatibility(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.compatibility = var1;
   }

   public final void setId(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.id = var1;
   }

   public final void setIpAddress(String var1) {
      this.ipAddress = var1;
   }

   public final void setMacAddress(String var1) {
      this.macAddress = var1;
   }

   public final void setModel(String var1) {
      this.model = var1;
   }

   public final void setName(String var1) {
      this.name = var1;
   }

   public final void setTimeZone(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.timeZone = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceInformationLegacy(ipAddress=");
      var1.append(this.ipAddress);
      var1.append(", macAddress=");
      var1.append(this.macAddress);
      var1.append(", id=");
      var1.append(this.id);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", model=");
      var1.append(this.model);
      var1.append(", compatibility=");
      var1.append(this.compatibility);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.ipAddress);
      var1.writeString(this.macAddress);
      var1.writeString(this.id);
      var1.writeString(this.name);
      var1.writeString(this.model);
      var1.writeString(this.compatibility);
      var1.writeString(this.timeZone);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceInformationLegacy createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new DeviceInformationLegacy(var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString(), var1.readString());
      }

      public final DeviceInformationLegacy[] newArray(int var1) {
         return new DeviceInformationLegacy[var1];
      }
   }
}
