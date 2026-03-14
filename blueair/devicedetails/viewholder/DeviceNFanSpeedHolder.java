package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.databinding.ViewDataBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding;
import com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBinding;
import com.blueair.devicedetails.util.EtaUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFanSpeedHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "<init>", "(Landroidx/databinding/ViewDataBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "speed0", "Landroid/widget/RadioButton;", "speed4", "radioGroup", "Landroid/widget/RadioGroup;", "cleanAirEta", "Landroid/widget/TextView;", "setHolderEnabled", "enabled", "update", "speedEnum", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNFanSpeedHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewDataBinding binding;
   private final TextView cleanAirEta;
   private final Device device;
   private final boolean isInSchedule;
   private final Function1 onFanSpeedSelectedListener;
   private final RadioGroup radioGroup;
   private final RadioButton speed0;
   private final RadioButton speed4;

   public DeviceNFanSpeedHolder(ViewDataBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onFanSpeedSelectedListener");
      View var5 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      super(var5);
      this.binding = var1;
      this.device = var2;
      this.isInSchedule = var3;
      this.onFanSpeedSelectedListener = var4;
      var3 = var1 instanceof HolderDeviceHFanSpeedBinding;
      Object var12 = null;
      if (var3) {
         RadioButton var13 = ((HolderDeviceHFanSpeedBinding)var1).speed0;
         Intrinsics.checkNotNullExpressionValue(var13, "speed0");
         this.speed0 = var13;
         var13 = ((HolderDeviceHFanSpeedBinding)var1).speed4;
         Intrinsics.checkNotNullExpressionValue(var13, "speed4");
         this.speed4 = var13;
         RadioGroup var6 = ((HolderDeviceHFanSpeedBinding)var1).radioGroup;
         Intrinsics.checkNotNullExpressionValue(var6, "radioGroup");
         this.radioGroup = var6;
         this.cleanAirEta = null;
      } else if (var1 instanceof HolderDeviceNFanSpeedBinding) {
         RadioButton var15 = ((HolderDeviceNFanSpeedBinding)var1).speed0;
         Intrinsics.checkNotNullExpressionValue(var15, "speed0");
         this.speed0 = var15;
         var15 = ((HolderDeviceNFanSpeedBinding)var1).speed4;
         Intrinsics.checkNotNullExpressionValue(var15, "speed4");
         this.speed4 = var15;
         RadioGroup var7 = ((HolderDeviceNFanSpeedBinding)var1).radioGroup;
         Intrinsics.checkNotNullExpressionValue(var7, "radioGroup");
         this.radioGroup = var7;
         this.cleanAirEta = null;
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBinding");
         HolderDeviceHAttributeFanSpeedBinding var17 = (HolderDeviceHAttributeFanSpeedBinding)var1;
         RadioButton var18 = ((HolderDeviceHAttributeFanSpeedBinding)var1).speed0;
         Intrinsics.checkNotNullExpressionValue(var18, "speed0");
         this.speed0 = var18;
         var18 = ((HolderDeviceHAttributeFanSpeedBinding)var1).speed4;
         Intrinsics.checkNotNullExpressionValue(var18, "speed4");
         this.speed4 = var18;
         RadioGroup var20 = ((HolderDeviceHAttributeFanSpeedBinding)var1).radioGroup;
         Intrinsics.checkNotNullExpressionValue(var20, "radioGroup");
         this.radioGroup = var20;
         this.cleanAirEta = ((HolderDeviceHAttributeFanSpeedBinding)var1).cleanAirEta;
      }

      HasFanSpeed var8 = (HasFanSpeed)var12;
      if (var2 instanceof HasFanSpeed) {
         var8 = (HasFanSpeed)var2;
      }

      if (var8 == null || !var8.getHasGear4()) {
         ViewExtensionsKt.hide((View)this.speed4);
      }

      if (var2 instanceof DevicePet20) {
         ViewExtensionsKt.hide((View)this.speed0);
      }

      for(View var9 : ViewGroupKt.getChildren((ViewGroup)this.radioGroup)) {
         var9.setOnClickListener(new DeviceNFanSpeedHolder$$ExternalSyntheticLambda0(var9, this));
      }

   }

   static final void lambda$1$lambda$0(View var0, DeviceNFanSpeedHolder var1, View var2) {
      int var4 = var0.getId();
      int var5 = R.id.speed_0;
      byte var3 = 0;
      if (var4 != var5) {
         if (var4 == R.id.speed_1) {
            var3 = 1;
         } else if (var4 == R.id.speed_2) {
            var3 = 2;
         } else if (var4 == R.id.speed_3) {
            var3 = 3;
         } else if (var4 == R.id.speed_4) {
            var3 = 4;
         }
      }

      var1.onFanSpeedSelectedListener.invoke(FanSpeedEnum.Companion.fromStep(var3, var1.device));
   }

   private final void setHolderEnabled(boolean var1) {
      Iterator var2 = ViewGroupKt.getChildren((ViewGroup)this.radioGroup).iterator();

      while(var2.hasNext()) {
         ((View)var2.next()).setEnabled(var1);
      }

   }

   public final ViewDataBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasFanSpeed) {
         boolean var2 = var1 instanceof HasCombo3in1MainMode;
         FanSpeedEnum var4;
         if (var2) {
            var4 = ((HasCombo3in1MainMode)var1).currentFanSpeedEnum();
         } else {
            var4 = ((HasFanSpeed)var1).getFanSpeedEnum();
         }

         this.update(var4);
         if (var1 instanceof HasBody) {
            this.setHolderEnabled(((HasBody)var1).getBodyMounted());
            return;
         }

         boolean var3 = true;
         if (var2) {
            var2 = var3;
            if (((HasMainMode)var1).isInMainMode(MainMode.HEAT)) {
               if (!var1.isUsDevice()) {
                  var2 = var3;
               } else {
                  var2 = false;
               }
            }

            this.setHolderEnabled(var2);
            return;
         }

         if (var1 instanceof DeviceHumidifier) {
            var1 = var1;
            if (Intrinsics.areEqual(var1.getHardware(), "hum_n")) {
               this.setHolderEnabled(var1.getWaterShortage() ^ true);
            }
         }
      }

   }

   public final void update(Device var1, IndoorDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasFanSpeed) {
         Object var5 = null;
         IndoorDatapoint var10;
         if (var2 == null) {
            HasSensorData var4;
            if (var1 instanceof HasSensorData) {
               var4 = (HasSensorData)var1;
            } else {
               var4 = null;
            }

            if (var4 != null) {
               var10 = var4.getLatestSensorDatapoint();
            } else {
               var10 = null;
            }
         } else {
            var10 = var2;
         }

         Float var11;
         if (var10 != null) {
            var11 = var10.getPm25();
         } else {
            var11 = null;
         }

         if (var11 != null && !this.isInSchedule && (!(var1 instanceof HasWick) || !((HasWick)var1).getWickdryOn())) {
            TextView var12 = this.cleanAirEta;
            if (var12 != null) {
               ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
            }

            TextView var7 = this.cleanAirEta;
            if (var7 != null) {
               EtaUtils var6 = EtaUtils.INSTANCE;
               Context var13 = this.itemView.getContext();
               Intrinsics.checkNotNullExpressionValue(var13, "getContext(...)");
               int var3 = DeviceKt.fanSpeedValue(var1);
               Float var9 = (Float)var5;
               if (var2 != null) {
                  var9 = var2.getPm25();
               }

               var7.setText(var6.etaString(var13, var3, var9));
               return;
            }
         } else {
            TextView var8 = this.cleanAirEta;
            if (var8 != null) {
               ViewExtensionsKt.hide((View)var8);
            }
         }
      }

   }

   public final void update(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "speedEnum");
      int var2 = var1.toStep(this.device);
      if (var2 != 0) {
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  var2 = R.id.speed_4;
               } else {
                  var2 = R.id.speed_3;
               }
            } else {
               var2 = R.id.speed_2;
            }
         } else {
            var2 = R.id.speed_1;
         }
      } else {
         var2 = R.id.speed_0;
      }

      this.radioGroup.check(var2);
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFanSpeedHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNFanSpeedHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "devicedetails_otherRelease"},
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

      public final DeviceNFanSpeedHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onFanSpeedSelectedListener");
         ViewDataBinding var6;
         if (var3) {
            if (var2 instanceof DeviceNewClassic) {
               HolderDeviceNFanSpeedBinding var5 = HolderDeviceNFanSpeedBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
               Intrinsics.checkNotNull(var5);
               var6 = var5;
            } else {
               HolderDeviceHFanSpeedBinding var7 = HolderDeviceHFanSpeedBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
               Intrinsics.checkNotNull(var7);
               var6 = var7;
            }
         } else {
            HolderDeviceHAttributeFanSpeedBinding var8 = HolderDeviceHAttributeFanSpeedBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNull(var8);
            var6 = var8;
         }

         return new DeviceNFanSpeedHolder(var6, var2, var3, var4);
      }
   }
}
