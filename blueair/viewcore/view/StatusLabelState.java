package com.blueair.viewcore.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0006J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006%"},
   d2 = {"Lcom/blueair/viewcore/view/StatusLabelState;", "Landroid/os/Parcelable;", "shouldShowStatusLabel", "", "shouldSubstituteValueIntoText", "textResId", "", "valueForText", "backgroundResId", "<init>", "(ZZIII)V", "getShouldShowStatusLabel", "()Z", "getShouldSubstituteValueIntoText", "getTextResId", "()I", "getValueForText", "getBackgroundResId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StatusLabelState implements Parcelable {
   public static final Parcelable.Creator CREATOR = new Creator();
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final int backgroundResId;
   private final boolean shouldShowStatusLabel;
   private final boolean shouldSubstituteValueIntoText;
   private final int textResId;
   private final int valueForText;

   public StatusLabelState(boolean var1, boolean var2, int var3, int var4, int var5) {
      this.shouldShowStatusLabel = var1;
      this.shouldSubstituteValueIntoText = var2;
      this.textResId = var3;
      this.valueForText = var4;
      this.backgroundResId = var5;
   }

   // $FF: synthetic method
   public static StatusLabelState copy$default(StatusLabelState var0, boolean var1, boolean var2, int var3, int var4, int var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.shouldShowStatusLabel;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.shouldSubstituteValueIntoText;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.textResId;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.valueForText;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.backgroundResId;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final boolean component1() {
      return this.shouldShowStatusLabel;
   }

   public final boolean component2() {
      return this.shouldSubstituteValueIntoText;
   }

   public final int component3() {
      return this.textResId;
   }

   public final int component4() {
      return this.valueForText;
   }

   public final int component5() {
      return this.backgroundResId;
   }

   public final StatusLabelState copy(boolean var1, boolean var2, int var3, int var4, int var5) {
      return new StatusLabelState(var1, var2, var3, var4, var5);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof StatusLabelState)) {
         return false;
      } else {
         var1 = var1;
         if (this.shouldShowStatusLabel != var1.shouldShowStatusLabel) {
            return false;
         } else if (this.shouldSubstituteValueIntoText != var1.shouldSubstituteValueIntoText) {
            return false;
         } else if (this.textResId != var1.textResId) {
            return false;
         } else if (this.valueForText != var1.valueForText) {
            return false;
         } else {
            return this.backgroundResId == var1.backgroundResId;
         }
      }
   }

   public final int getBackgroundResId() {
      return this.backgroundResId;
   }

   public final boolean getShouldShowStatusLabel() {
      return this.shouldShowStatusLabel;
   }

   public final boolean getShouldSubstituteValueIntoText() {
      return this.shouldSubstituteValueIntoText;
   }

   public final int getTextResId() {
      return this.textResId;
   }

   public final int getValueForText() {
      return this.valueForText;
   }

   public int hashCode() {
      return (((AddDeviceState$$ExternalSyntheticBackport0.m(this.shouldShowStatusLabel) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.shouldSubstituteValueIntoText)) * 31 + this.textResId) * 31 + this.valueForText) * 31 + this.backgroundResId;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("StatusLabelState(shouldShowStatusLabel=");
      var1.append(this.shouldShowStatusLabel);
      var1.append(", shouldSubstituteValueIntoText=");
      var1.append(this.shouldSubstituteValueIntoText);
      var1.append(", textResId=");
      var1.append(this.textResId);
      var1.append(", valueForText=");
      var1.append(this.valueForText);
      var1.append(", backgroundResId=");
      var1.append(this.backgroundResId);
      var1.append(')');
      return var1.toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeInt(this.shouldShowStatusLabel);
      var1.writeInt(this.shouldSubstituteValueIntoText);
      var1.writeInt(this.textResId);
      var1.writeInt(this.valueForText);
      var1.writeInt(this.backgroundResId);
   }

   @Metadata(
      d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000bJ \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"},
      d2 = {"Lcom/blueair/viewcore/view/StatusLabelState$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/viewcore/view/StatusLabelState;", "device", "Lcom/blueair/core/model/HasSensorData;", "realValue", "", "sensorType", "Lcom/blueair/core/model/SensorType;", "Lcom/blueair/core/model/Device;", "forcedSensorType", "fromSensors", "fromDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "indoorAirStatusLabel", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "filterLifetime", "Lcom/blueair/core/model/FilterLifeTime;", "viewcore_otherRelease"},
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

      private final StatusLabelState from(IndoorAirStatusLabel var1, FilterLifeTime var2) {
         int var5 = R.drawable.status_label_dark_blue;
         boolean var7;
         if (var1 != null) {
            var7 = true;
         } else {
            var7 = false;
         }

         int var4;
         label54: {
            int var3;
            if (Intrinsics.areEqual(var1, IndoorAirStatusLabel.ReplaceFilter.INSTANCE)) {
               var3 = var1.getTextResId();
            } else {
               if (var1 == null) {
                  var4 = 0;
                  break label54;
               }

               var3 = var1.getTextResId();
            }

            var4 = var3;
         }

         boolean var8;
         if (!Intrinsics.areEqual(var1, IndoorAirStatusLabel.ReplaceFilter.INSTANCE) && !Intrinsics.areEqual(var1, IndoorAirStatusLabel.ReplaceFilterPercentage.INSTANCE)) {
            var8 = false;
         } else {
            var8 = true;
         }

         int var9;
         if (var1 instanceof IndoorAirStatusLabel.ReplaceFilterPercentage) {
            int var6 = var2.getFilterLife();
            if (Integer.MIN_VALUE <= var6 && var6 < 11) {
               var9 = R.drawable.status_label_red;
            } else if (11 <= var6 && var6 < 91) {
               var9 = R.drawable.status_label_orange;
            } else {
               var9 = var5;
               if (90 <= var6) {
                  var9 = var5;
                  if (var6 <= Integer.MAX_VALUE) {
                     var9 = R.drawable.status_label_blue;
                  }
               }
            }
         } else {
            var9 = var5;
            if (var1 != null) {
               var9 = var1.getBackgroundResId();
            }
         }

         return new StatusLabelState(var7, var8, var4, var2.getFilterLife(), var9);
      }

      // $FF: synthetic method
      public static StatusLabelState from$default(Companion var0, Device var1, SensorType var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         return var0.from(var1, var2);
      }

      // $FF: synthetic method
      static StatusLabelState from$default(Companion var0, IndoorAirStatusLabel var1, FilterLifeTime var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = new FilterLifeTime.FilterDaysLeft(100, (Integer)null, 2, (DefaultConstructorMarker)null);
         }

         return var0.from(var1, var2);
      }

      // $FF: synthetic method
      public static StatusLabelState fromDatapoint$default(Companion var0, IndoorDatapoint var1, HasSensorData var2, SensorType var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = SensorType.PM25;
         }

         return var0.fromDatapoint(var1, var2, var3);
      }

      // $FF: synthetic method
      public static StatusLabelState fromSensors$default(Companion var0, HasSensorData var1, SensorType var2, int var3, Object var4) {
         if ((var3 & 2) != 0) {
            var2 = SensorType.PM25;
         }

         return var0.fromSensors(var1, var2);
      }

      public final StatusLabelState from(Device var1, SensorType var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         int var4 = R.drawable.status_label_dark_blue;
         ConnectivityStatus var6 = var1.getConnectivityStatus();
         int var3 = StatusLabelState.Companion.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
         if (var3 == 1) {
            return this.from(IndoorAirStatusLabel.Offline.INSTANCE, DeviceKt.getFilterLifeTime(var1));
         } else if (var3 != 2) {
            if (var3 == 3) {
               return this.from(IndoorAirStatusLabel.Updating.INSTANCE, DeviceKt.getFilterLifeTime(var1));
            } else if (var3 == 4) {
               FilterLifeTime var7 = DeviceKt.getFilterLifeTime(var1);
               if (var1 instanceof HasSensorData) {
                  SensorType var10 = var2;
                  if (var2 == null) {
                     var10 = ((HasSensorData)var1).getLastSelectedSensorType();
                  }

                  return this.from(IndoorAirStatusLabel.Companion.fromDeviceAndSensor$default(IndoorAirStatusLabel.Companion, (HasSensorData)var1, var10, false, 4, (Object)null), var7);
               } else if (var7 instanceof FilterLifeTime.FilterDaysLeft) {
                  var3 = ((FilterLifeTime.FilterDaysLeft)var7).getFilterLife();
                  if (var3 <= 7) {
                     var4 = R.drawable.status_label_orange;
                  }

                  return new StatusLabelState(true, true, R.string.filter_usage, var3, var4);
               } else if (!(var7 instanceof FilterLifeTime.FilterPercentageLeft)) {
                  if (var7 instanceof FilterLifeTime.NoFilterInfo) {
                     return new StatusLabelState(false, false, R.string.filter_na, 100, R.drawable.status_label_grey);
                  } else {
                     throw new NoWhenBranchMatchedException();
                  }
               } else {
                  int var5 = ((FilterLifeTime.FilterPercentageLeft)var7).getFilterLife();
                  if (Integer.MIN_VALUE <= var5 && var5 < 11) {
                     var3 = R.drawable.status_label_red;
                  } else if (11 <= var5 && var5 < 91) {
                     var3 = R.drawable.status_label_orange;
                  } else {
                     var3 = var4;
                     if (90 <= var5) {
                        var3 = var4;
                        if (var5 <= Integer.MAX_VALUE) {
                           var3 = R.drawable.status_label_blue;
                        }
                     }
                  }

                  return new StatusLabelState(true, true, R.string.filter_usage_percentage, var5, var3);
               }
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            return this.from(IndoorAirStatusLabel.Connecting.INSTANCE, DeviceKt.getFilterLifeTime(var1));
         }
      }

      public final StatusLabelState from(HasSensorData var1, double var2, SensorType var4) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var4, "sensorType");
         return from$default(this, (IndoorAirStatusLabel)IndoorAirStatusLabel.Companion.fromValueAndSensor(var1, var2, var4), (FilterLifeTime)null, 2, (Object)null);
      }

      public final StatusLabelState fromDatapoint(IndoorDatapoint var1, HasSensorData var2, SensorType var3) {
         Intrinsics.checkNotNullParameter(var1, "dataPoint");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intrinsics.checkNotNullParameter(var3, "forcedSensorType");
         return from$default(this, (IndoorAirStatusLabel)IndoorAirStatusLabel.Companion.fromDeviceAndSensorAndDatapoint(var1, var2, var3, true), (FilterLifeTime)null, 2, (Object)null);
      }

      public final StatusLabelState fromSensors(HasSensorData var1, SensorType var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var2, "forcedSensorType");
         return from$default(this, (IndoorAirStatusLabel)IndoorAirStatusLabel.Companion.fromDeviceAndSensor(var1, var2, true), (FilterLifeTime)null, 2, (Object)null);
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
            int[] var0 = new int[ConnectivityStatus.values().length];

            try {
               var0[ConnectivityStatus.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[ConnectivityStatus.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError var4) {
            }

            try {
               var0[ConnectivityStatus.UPDATING.ordinal()] = 3;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[ConnectivityStatus.ONLINE.ordinal()] = 4;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final StatusLabelState createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         int var2 = var1.readInt();
         boolean var3 = true;
         boolean var4 = false;
         if (var2 == 0) {
            var3 = false;
         }

         if (var1.readInt() != 0) {
            var4 = true;
         }

         return new StatusLabelState(var3, var4, var1.readInt(), var1.readInt(), var1.readInt());
      }

      public final StatusLabelState[] newArray(int var1) {
         return new StatusLabelState[var1];
      }
   }
}
