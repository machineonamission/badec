package com.blueair.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-J\u000e\u0010/\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-J\u000e\u00100\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-J\u000e\u00101\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-J\u000e\u00102\u001a\u0002032\u0006\u0010,\u001a\u00020-J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003Jw\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0006\u0010@\u001a\u00020\u0003J\u0013\u0010A\u001a\u00020-2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020FHÖ\u0001J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u0006L"},
   d2 = {"Lcom/blueair/core/model/DualOscillationConfig;", "Landroid/os/Parcelable;", "oscillationMode", "", "horizontalOscillationState", "horizontalOscillationFixAngle", "horizontalOscillationMinAngle", "horizontalOscillationMaxAngle", "verticalOscillationState", "verticalOscillationFixAngle", "verticalOscillationMinAngle", "verticalOscillationMaxAngle", "horizontalCalibrationState", "verticalCalibrationState", "<init>", "(IIIIIIIIIII)V", "getOscillationMode", "()I", "setOscillationMode", "(I)V", "getHorizontalOscillationState", "setHorizontalOscillationState", "getHorizontalOscillationFixAngle", "setHorizontalOscillationFixAngle", "getHorizontalOscillationMinAngle", "setHorizontalOscillationMinAngle", "getHorizontalOscillationMaxAngle", "setHorizontalOscillationMaxAngle", "getVerticalOscillationState", "setVerticalOscillationState", "getVerticalOscillationFixAngle", "setVerticalOscillationFixAngle", "getVerticalOscillationMinAngle", "setVerticalOscillationMinAngle", "getVerticalOscillationMaxAngle", "setVerticalOscillationMaxAngle", "getHorizontalCalibrationState", "setHorizontalCalibrationState", "getVerticalCalibrationState", "setVerticalCalibrationState", "getMode", "Lcom/blueair/core/model/OscillationMode;", "getState", "Lcom/blueair/core/model/OscillationState;", "horizontal", "", "getFixAngle", "getMinAngle", "getMaxAngle", "getCurAngle", "getCalibrationState", "Lcom/blueair/core/model/CalibrationState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DualOscillationConfig implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   private int horizontalCalibrationState;
   private int horizontalOscillationFixAngle;
   private int horizontalOscillationMaxAngle;
   private int horizontalOscillationMinAngle;
   private int horizontalOscillationState;
   private int oscillationMode;
   private int verticalCalibrationState;
   private int verticalOscillationFixAngle;
   private int verticalOscillationMaxAngle;
   private int verticalOscillationMinAngle;
   private int verticalOscillationState;

   public DualOscillationConfig() {
      this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, (DefaultConstructorMarker)null);
   }

   public DualOscillationConfig(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.oscillationMode = var1;
      this.horizontalOscillationState = var2;
      this.horizontalOscillationFixAngle = var3;
      this.horizontalOscillationMinAngle = var4;
      this.horizontalOscillationMaxAngle = var5;
      this.verticalOscillationState = var6;
      this.verticalOscillationFixAngle = var7;
      this.verticalOscillationMinAngle = var8;
      this.verticalOscillationMaxAngle = var9;
      this.horizontalCalibrationState = var10;
      this.verticalCalibrationState = var11;
   }

   // $FF: synthetic method
   public DualOscillationConfig(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, DefaultConstructorMarker var13) {
      if ((var12 & 1) != 0) {
         var1 = 0;
      }

      if ((var12 & 2) != 0) {
         var2 = 0;
      }

      if ((var12 & 4) != 0) {
         var3 = 0;
      }

      if ((var12 & 8) != 0) {
         var4 = 0;
      }

      if ((var12 & 16) != 0) {
         var5 = 0;
      }

      if ((var12 & 32) != 0) {
         var6 = 0;
      }

      if ((var12 & 64) != 0) {
         var7 = 0;
      }

      if ((var12 & 128) != 0) {
         var8 = 0;
      }

      if ((var12 & 256) != 0) {
         var9 = 0;
      }

      if ((var12 & 512) != 0) {
         var10 = 0;
      }

      if ((var12 & 1024) != 0) {
         var11 = 0;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   // $FF: synthetic method
   public static DualOscillationConfig copy$default(DualOscillationConfig var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, Object var13) {
      if ((var12 & 1) != 0) {
         var1 = var0.oscillationMode;
      }

      if ((var12 & 2) != 0) {
         var2 = var0.horizontalOscillationState;
      }

      if ((var12 & 4) != 0) {
         var3 = var0.horizontalOscillationFixAngle;
      }

      if ((var12 & 8) != 0) {
         var4 = var0.horizontalOscillationMinAngle;
      }

      if ((var12 & 16) != 0) {
         var5 = var0.horizontalOscillationMaxAngle;
      }

      if ((var12 & 32) != 0) {
         var6 = var0.verticalOscillationState;
      }

      if ((var12 & 64) != 0) {
         var7 = var0.verticalOscillationFixAngle;
      }

      if ((var12 & 128) != 0) {
         var8 = var0.verticalOscillationMinAngle;
      }

      if ((var12 & 256) != 0) {
         var9 = var0.verticalOscillationMaxAngle;
      }

      if ((var12 & 512) != 0) {
         var10 = var0.horizontalCalibrationState;
      }

      if ((var12 & 1024) != 0) {
         var11 = var0.verticalCalibrationState;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final int component1() {
      return this.oscillationMode;
   }

   public final int component10() {
      return this.horizontalCalibrationState;
   }

   public final int component11() {
      return this.verticalCalibrationState;
   }

   public final int component2() {
      return this.horizontalOscillationState;
   }

   public final int component3() {
      return this.horizontalOscillationFixAngle;
   }

   public final int component4() {
      return this.horizontalOscillationMinAngle;
   }

   public final int component5() {
      return this.horizontalOscillationMaxAngle;
   }

   public final int component6() {
      return this.verticalOscillationState;
   }

   public final int component7() {
      return this.verticalOscillationFixAngle;
   }

   public final int component8() {
      return this.verticalOscillationMinAngle;
   }

   public final int component9() {
      return this.verticalOscillationMaxAngle;
   }

   public final DualOscillationConfig copy(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      return new DualOscillationConfig(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DualOscillationConfig)) {
         return false;
      } else {
         var1 = var1;
         if (this.oscillationMode != var1.oscillationMode) {
            return false;
         } else if (this.horizontalOscillationState != var1.horizontalOscillationState) {
            return false;
         } else if (this.horizontalOscillationFixAngle != var1.horizontalOscillationFixAngle) {
            return false;
         } else if (this.horizontalOscillationMinAngle != var1.horizontalOscillationMinAngle) {
            return false;
         } else if (this.horizontalOscillationMaxAngle != var1.horizontalOscillationMaxAngle) {
            return false;
         } else if (this.verticalOscillationState != var1.verticalOscillationState) {
            return false;
         } else if (this.verticalOscillationFixAngle != var1.verticalOscillationFixAngle) {
            return false;
         } else if (this.verticalOscillationMinAngle != var1.verticalOscillationMinAngle) {
            return false;
         } else if (this.verticalOscillationMaxAngle != var1.verticalOscillationMaxAngle) {
            return false;
         } else if (this.horizontalCalibrationState != var1.horizontalCalibrationState) {
            return false;
         } else {
            return this.verticalCalibrationState == var1.verticalCalibrationState;
         }
      }
   }

   public final CalibrationState getCalibrationState(boolean var1) {
      CalibrationState.Companion var3 = CalibrationState.Companion;
      int var2;
      if (var1) {
         var2 = this.horizontalCalibrationState;
      } else {
         var2 = this.verticalCalibrationState;
      }

      return var3.fromValue(var2);
   }

   public final int getCurAngle(boolean var1) {
      OscillationState var3 = this.getState(var1);
      int var2 = DualOscillationConfig.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               return this.getFixAngle(var1);
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            return this.getMaxAngle(var1) - this.getMinAngle(var1);
         }
      } else {
         return 0;
      }
   }

   public final int getFixAngle(boolean var1) {
      return var1 ? this.horizontalOscillationFixAngle : this.verticalOscillationFixAngle;
   }

   public final int getHorizontalCalibrationState() {
      return this.horizontalCalibrationState;
   }

   public final int getHorizontalOscillationFixAngle() {
      return this.horizontalOscillationFixAngle;
   }

   public final int getHorizontalOscillationMaxAngle() {
      return this.horizontalOscillationMaxAngle;
   }

   public final int getHorizontalOscillationMinAngle() {
      return this.horizontalOscillationMinAngle;
   }

   public final int getHorizontalOscillationState() {
      return this.horizontalOscillationState;
   }

   public final int getMaxAngle(boolean var1) {
      return var1 ? this.horizontalOscillationMaxAngle : this.verticalOscillationMaxAngle;
   }

   public final int getMinAngle(boolean var1) {
      return var1 ? this.horizontalOscillationMinAngle : this.verticalOscillationMinAngle;
   }

   public final OscillationMode getMode() {
      return OscillationMode.Companion.fromValue(this.oscillationMode);
   }

   public final int getOscillationMode() {
      return this.oscillationMode;
   }

   public final OscillationState getState(boolean var1) {
      OscillationState.Companion var3 = OscillationState.Companion;
      int var2;
      if (var1) {
         var2 = this.horizontalOscillationState;
      } else {
         var2 = this.verticalOscillationState;
      }

      return var3.fromValue(var2);
   }

   public final int getVerticalCalibrationState() {
      return this.verticalCalibrationState;
   }

   public final int getVerticalOscillationFixAngle() {
      return this.verticalOscillationFixAngle;
   }

   public final int getVerticalOscillationMaxAngle() {
      return this.verticalOscillationMaxAngle;
   }

   public final int getVerticalOscillationMinAngle() {
      return this.verticalOscillationMinAngle;
   }

   public final int getVerticalOscillationState() {
      return this.verticalOscillationState;
   }

   public int hashCode() {
      return (((((((((this.oscillationMode * 31 + this.horizontalOscillationState) * 31 + this.horizontalOscillationFixAngle) * 31 + this.horizontalOscillationMinAngle) * 31 + this.horizontalOscillationMaxAngle) * 31 + this.verticalOscillationState) * 31 + this.verticalOscillationFixAngle) * 31 + this.verticalOscillationMinAngle) * 31 + this.verticalOscillationMaxAngle) * 31 + this.horizontalCalibrationState) * 31 + this.verticalCalibrationState;
   }

   public final void setHorizontalCalibrationState(int var1) {
      this.horizontalCalibrationState = var1;
   }

   public final void setHorizontalOscillationFixAngle(int var1) {
      this.horizontalOscillationFixAngle = var1;
   }

   public final void setHorizontalOscillationMaxAngle(int var1) {
      this.horizontalOscillationMaxAngle = var1;
   }

   public final void setHorizontalOscillationMinAngle(int var1) {
      this.horizontalOscillationMinAngle = var1;
   }

   public final void setHorizontalOscillationState(int var1) {
      this.horizontalOscillationState = var1;
   }

   public final void setOscillationMode(int var1) {
      this.oscillationMode = var1;
   }

   public final void setVerticalCalibrationState(int var1) {
      this.verticalCalibrationState = var1;
   }

   public final void setVerticalOscillationFixAngle(int var1) {
      this.verticalOscillationFixAngle = var1;
   }

   public final void setVerticalOscillationMaxAngle(int var1) {
      this.verticalOscillationMaxAngle = var1;
   }

   public final void setVerticalOscillationMinAngle(int var1) {
      this.verticalOscillationMinAngle = var1;
   }

   public final void setVerticalOscillationState(int var1) {
      this.verticalOscillationState = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DualOscillationConfig(oscillationMode=");
      var1.append(this.oscillationMode);
      var1.append(", horizontalOscillationState=");
      var1.append(this.horizontalOscillationState);
      var1.append(", horizontalOscillationFixAngle=");
      var1.append(this.horizontalOscillationFixAngle);
      var1.append(", horizontalOscillationMinAngle=");
      var1.append(this.horizontalOscillationMinAngle);
      var1.append(", horizontalOscillationMaxAngle=");
      var1.append(this.horizontalOscillationMaxAngle);
      var1.append(", verticalOscillationState=");
      var1.append(this.verticalOscillationState);
      var1.append(", verticalOscillationFixAngle=");
      var1.append(this.verticalOscillationFixAngle);
      var1.append(", verticalOscillationMinAngle=");
      var1.append(this.verticalOscillationMinAngle);
      var1.append(", verticalOscillationMaxAngle=");
      var1.append(this.verticalOscillationMaxAngle);
      var1.append(", horizontalCalibrationState=");
      var1.append(this.horizontalCalibrationState);
      var1.append(", verticalCalibrationState=");
      var1.append(this.verticalCalibrationState);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeInt(this.oscillationMode);
      var1.writeInt(this.horizontalOscillationState);
      var1.writeInt(this.horizontalOscillationFixAngle);
      var1.writeInt(this.horizontalOscillationMinAngle);
      var1.writeInt(this.horizontalOscillationMaxAngle);
      var1.writeInt(this.verticalOscillationState);
      var1.writeInt(this.verticalOscillationFixAngle);
      var1.writeInt(this.verticalOscillationMinAngle);
      var1.writeInt(this.verticalOscillationMaxAngle);
      var1.writeInt(this.horizontalCalibrationState);
      var1.writeInt(this.verticalCalibrationState);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DualOscillationConfig createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         return new DualOscillationConfig(var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt());
      }

      public final DualOscillationConfig[] newArray(int var1) {
         return new DualOscillationConfig[var1];
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
         int[] var0 = new int[OscillationState.values().length];

         try {
            var0[OscillationState.DISABLE.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[OscillationState.SWING.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[OscillationState.FIXED.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
