package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001f\u001a\u00020\u0006J\t\u0010 \u001a\u00020\bHÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006("},
   d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation;", "Landroid/os/Parcelable;", "lat", "", "lng", "radius", "", "textValue", "", "isEnabled", "", "<init>", "(DDILjava/lang/String;Z)V", "getLat", "()D", "getLng", "getRadius", "()I", "getTextValue", "()Ljava/lang/String;", "()Z", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "WelcomeHomeRadius", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomeLocation implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final boolean isEnabled;
   private final double lat;
   private final double lng;
   private final int radius;
   private final String textValue;

   public WelcomeHomeLocation(double var1, double var3, int var5, String var6, boolean var7) {
      Intrinsics.checkNotNullParameter(var6, "textValue");
      super();
      this.lat = var1;
      this.lng = var3;
      this.radius = var5;
      this.textValue = var6;
      this.isEnabled = var7;
   }

   // $FF: synthetic method
   public static WelcomeHomeLocation copy$default(WelcomeHomeLocation var0, double var1, double var3, int var5, String var6, boolean var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.lat;
      }

      if ((var8 & 2) != 0) {
         var3 = var0.lng;
      }

      if ((var8 & 4) != 0) {
         var5 = var0.radius;
      }

      if ((var8 & 8) != 0) {
         var6 = var0.textValue;
      }

      if ((var8 & 16) != 0) {
         var7 = var0.isEnabled;
      }

      return var0.copy(var1, var3, var5, var6, var7);
   }

   public final double component1() {
      return this.lat;
   }

   public final double component2() {
      return this.lng;
   }

   public final int component3() {
      return this.radius;
   }

   public final String component4() {
      return this.textValue;
   }

   public final boolean component5() {
      return this.isEnabled;
   }

   public final WelcomeHomeLocation copy(double var1, double var3, int var5, String var6, boolean var7) {
      Intrinsics.checkNotNullParameter(var6, "textValue");
      return new WelcomeHomeLocation(var1, var3, var5, var6, var7);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (var1 instanceof WelcomeHomeLocation) {
         double var2 = this.lat;
         var1 = var1;
         if (var2 == var1.lat && this.lng == var1.lng && this.radius == var1.radius) {
            return true;
         }
      }

      return false;
   }

   public final double getLat() {
      return this.lat;
   }

   public final double getLng() {
      return this.lng;
   }

   public final int getRadius() {
      return this.radius;
   }

   public final String getTextValue() {
      return this.textValue;
   }

   public int hashCode() {
      return (AddDeviceState$$ExternalSyntheticBackport0.m(this.lat) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.lng)) * 31 + this.radius;
   }

   public final boolean isEnabled() {
      return this.isEnabled;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("WelcomeHomeLocation(lat=");
      var1.append(this.lat);
      var1.append(", lng=");
      var1.append(this.lng);
      var1.append(", radius=");
      var1.append(this.radius);
      var1.append(", textValue=");
      var1.append(this.textValue);
      var1.append(", isEnabled=");
      var1.append(this.isEnabled);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeDouble(this.lat);
      var1.writeDouble(this.lng);
      var1.writeInt(this.radius);
      var1.writeString(this.textValue);
      var1.writeInt(this.isEnabled);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation$Companion;", "", "<init>", "()V", "toBlueWelcomeHomeLocation", "Lcom/blueair/core/model/BlueWelcomeHomeLocation;", "Lcom/blueair/core/model/WelcomeHomeLocation;", "fromBlueWelcomeHomeLocation", "location", "Lcom/blueair/core/model/BlueCloudHomeLocationReceive;", "core_otherRelease"},
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

      public final WelcomeHomeLocation fromBlueWelcomeHomeLocation(BlueCloudHomeLocationReceive var1) {
         return var1 != null ? new WelcomeHomeLocation(var1.getSetting().getLat(), var1.getSetting().getLng(), var1.getSetting().getRadius(), var1.getSetting().getTextValue(), false) : null;
      }

      public final BlueWelcomeHomeLocation toBlueWelcomeHomeLocation(WelcomeHomeLocation var1) {
         Intrinsics.checkNotNullParameter(var1, "<this>");
         return new BlueWelcomeHomeLocation(var1.getLat(), var1.getLng(), var1.getRadius(), var1.getTextValue());
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final WelcomeHomeLocation createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         double var2 = var1.readDouble();
         double var4 = var1.readDouble();
         int var6 = var1.readInt();
         String var8 = var1.readString();
         boolean var7;
         if (var1.readInt() != 0) {
            var7 = true;
         } else {
            var7 = false;
         }

         return new WelcomeHomeLocation(var2, var4, var6, var8, var7);
      }

      public final WelcomeHomeLocation[] newArray(int var1) {
         return new WelcomeHomeLocation[var1];
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"},
      d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "", "textValue", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;F)V", "getTextValue", "()Ljava/lang/String;", "getValue", "()F", "CAR", "BICYCLE", "WALK", "COMMUTE", "Companion", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum WelcomeHomeRadius {
      private static final EnumEntries $ENTRIES;
      private static final WelcomeHomeRadius[] $VALUES;
      BICYCLE("2 km", 2000.0F),
      CAR("3 km", 3000.0F),
      COMMUTE("2.5 km", 2500.0F);

      public static final Companion Companion;
      WALK("1 km", 1000.0F);

      private final String textValue;
      private final float value;

      // $FF: synthetic method
      private static final WelcomeHomeRadius[] $values() {
         return new WelcomeHomeRadius[]{CAR, BICYCLE, WALK, COMMUTE};
      }

      static {
         WelcomeHomeRadius[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
         Companion = new Companion((DefaultConstructorMarker)null);
      }

      private WelcomeHomeRadius(String var3, float var4) {
         this.textValue = var3;
         this.value = var4;
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }

      public final String getTextValue() {
         return this.textValue;
      }

      public final float getValue() {
         return this.value;
      }

      @Metadata(
         d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"},
         d2 = {"Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "value", "", "(Ljava/lang/Float;)Lcom/blueair/core/model/WelcomeHomeLocation$WelcomeHomeRadius;", "core_otherRelease"},
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

         public final WelcomeHomeRadius fromValue(Float var1) {
            for(WelcomeHomeRadius var4 : WelcomeHomeLocation.WelcomeHomeRadius.values()) {
               if (Intrinsics.areEqual(var4.getValue(), var1)) {
                  return var4;
               }
            }

            return null;
         }
      }
   }
}
