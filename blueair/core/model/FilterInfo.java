package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010\"\u001a\u00020\u0007J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006/"},
   d2 = {"Lcom/blueair/core/model/FilterInfo;", "Landroid/os/Parcelable;", "type", "Lcom/blueair/core/model/DeviceFilterType;", "name", "Lcom/blueair/core/model/I18nConfig;", "image", "", "summary", "manual", "linkSubscribe", "Lcom/blueair/core/model/IpConfig;", "linkPurchase", "<init>", "(Lcom/blueair/core/model/DeviceFilterType;Lcom/blueair/core/model/I18nConfig;IILcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/IpConfig;Lcom/blueair/core/model/IpConfig;)V", "getType", "()Lcom/blueair/core/model/DeviceFilterType;", "getName", "()Lcom/blueair/core/model/I18nConfig;", "getImage", "()I", "getSummary", "getManual", "getLinkSubscribe", "()Lcom/blueair/core/model/IpConfig;", "getLinkPurchase", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterInfo implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int image;
   private final IpConfig linkPurchase;
   private final IpConfig linkSubscribe;
   private final I18nConfig manual;
   private final I18nConfig name;
   private final int summary;
   private final DeviceFilterType type;

   public FilterInfo(DeviceFilterType var1, I18nConfig var2, int var3, int var4, I18nConfig var5, IpConfig var6, IpConfig var7) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "name");
      super();
      this.type = var1;
      this.name = var2;
      this.image = var3;
      this.summary = var4;
      this.manual = var5;
      this.linkSubscribe = var6;
      this.linkPurchase = var7;
   }

   // $FF: synthetic method
   public static FilterInfo copy$default(FilterInfo var0, DeviceFilterType var1, I18nConfig var2, int var3, int var4, I18nConfig var5, IpConfig var6, IpConfig var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.image;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.summary;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.manual;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.linkSubscribe;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.linkPurchase;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final DeviceFilterType component1() {
      return this.type;
   }

   public final I18nConfig component2() {
      return this.name;
   }

   public final int component3() {
      return this.image;
   }

   public final int component4() {
      return this.summary;
   }

   public final I18nConfig component5() {
      return this.manual;
   }

   public final IpConfig component6() {
      return this.linkSubscribe;
   }

   public final IpConfig component7() {
      return this.linkPurchase;
   }

   public final FilterInfo copy(DeviceFilterType var1, I18nConfig var2, int var3, int var4, I18nConfig var5, IpConfig var6, IpConfig var7) {
      Intrinsics.checkNotNullParameter(var1, "type");
      Intrinsics.checkNotNullParameter(var2, "name");
      return new FilterInfo(var1, var2, var3, var4, var5, var6, var7);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof FilterInfo)) {
         return false;
      } else {
         var1 = var1;
         if (this.type != var1.type) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.image != var1.image) {
            return false;
         } else if (this.summary != var1.summary) {
            return false;
         } else if (!Intrinsics.areEqual(this.manual, var1.manual)) {
            return false;
         } else if (!Intrinsics.areEqual(this.linkSubscribe, var1.linkSubscribe)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.linkPurchase, var1.linkPurchase);
         }
      }
   }

   public final int getImage() {
      return this.image;
   }

   public final IpConfig getLinkPurchase() {
      return this.linkPurchase;
   }

   public final IpConfig getLinkSubscribe() {
      return this.linkSubscribe;
   }

   public final I18nConfig getManual() {
      return this.manual;
   }

   public final I18nConfig getName() {
      return this.name;
   }

   public final int getSummary() {
      return this.summary;
   }

   public final DeviceFilterType getType() {
      return this.type;
   }

   public int hashCode() {
      int var4 = this.type.hashCode();
      int var7 = this.name.hashCode();
      int var6 = this.image;
      int var5 = this.summary;
      I18nConfig var8 = this.manual;
      int var3 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      IpConfig var9 = this.linkSubscribe;
      int var2;
      if (var9 == null) {
         var2 = 0;
      } else {
         var2 = var9.hashCode();
      }

      var9 = this.linkPurchase;
      if (var9 != null) {
         var3 = var9.hashCode();
      }

      return (((((var4 * 31 + var7) * 31 + var6) * 31 + var5) * 31 + var1) * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("FilterInfo(type=");
      var1.append(this.type);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", image=");
      var1.append(this.image);
      var1.append(", summary=");
      var1.append(this.summary);
      var1.append(", manual=");
      var1.append(this.manual);
      var1.append(", linkSubscribe=");
      var1.append(this.linkSubscribe);
      var1.append(", linkPurchase=");
      var1.append(this.linkPurchase);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.type.name());
      this.name.writeToParcel(var1, var2);
      var1.writeInt(this.image);
      var1.writeInt(this.summary);
      I18nConfig var3 = this.manual;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var3.writeToParcel(var1, var2);
      }

      IpConfig var4 = this.linkSubscribe;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
      }

      var4 = this.linkPurchase;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final FilterInfo createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         DeviceFilterType var8 = DeviceFilterType.valueOf(var1.readString());
         I18nConfig var7 = (I18nConfig)I18nConfig.CREATOR.createFromParcel(var1);
         int var3 = var1.readInt();
         int var4 = var1.readInt();
         int var2 = var1.readInt();
         Object var6 = null;
         Object var5;
         if (var2 == 0) {
            var5 = null;
         } else {
            var5 = I18nConfig.CREATOR.createFromParcel(var1);
         }

         I18nConfig var9 = (I18nConfig)var5;
         if (var1.readInt() == 0) {
            var5 = null;
         } else {
            var5 = IpConfig.CREATOR.createFromParcel(var1);
         }

         IpConfig var12 = (IpConfig)var5;
         Object var10;
         if (var1.readInt() == 0) {
            var10 = var6;
         } else {
            var10 = IpConfig.CREATOR.createFromParcel(var1);
         }

         return new FilterInfo(var8, var7, var3, var4, var9, var12, (IpConfig)var10);
      }

      public final FilterInfo[] newArray(int var1) {
         return new FilterInfo[var1];
      }
   }
}
