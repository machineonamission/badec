package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceHScheduleCustomTypeBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNScheduleCustomTypeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleCustomTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "onTypeSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getOnTypeSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTypeSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "radioGroupCustomScheduleSettings", "Landroid/widget/RadioGroup;", "textviewCustomScheduleDescription", "Landroid/widget/TextView;", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNScheduleCustomTypeHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewBinding binding;
   private final Device device;
   private Function1 onTypeSelectedListener;
   private final RadioGroup radioGroupCustomScheduleSettings;
   private final TextView textviewCustomScheduleDescription;

   // $FF: synthetic method
   public static void $r8$lambda$GISM7gxyO4M8nv4NHUCAV9FeQ8U(DeviceNScheduleCustomTypeHolder var0, RadioGroup var1, int var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   public DeviceNScheduleCustomTypeHolder(ViewBinding var1, Device var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
      this.device = var2;
      if (var1 instanceof HolderDeviceHScheduleCustomTypeBinding) {
         RadioGroup var5 = ((HolderDeviceHScheduleCustomTypeBinding)var1).radioGroupCustomScheduleSettings;
         Intrinsics.checkNotNullExpressionValue(var5, "radioGroupCustomScheduleSettings");
         this.radioGroupCustomScheduleSettings = var5;
         TextView var3 = ((HolderDeviceHScheduleCustomTypeBinding)var1).textviewCustomScheduleDescription;
         Intrinsics.checkNotNullExpressionValue(var3, "textviewCustomScheduleDescription");
         this.textviewCustomScheduleDescription = var3;
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNScheduleCustomTypeBinding");
         HolderDeviceNScheduleCustomTypeBinding var6 = (HolderDeviceNScheduleCustomTypeBinding)var1;
         RadioGroup var7 = ((HolderDeviceNScheduleCustomTypeBinding)var1).radioGroupCustomScheduleSettings;
         Intrinsics.checkNotNullExpressionValue(var7, "radioGroupCustomScheduleSettings");
         this.radioGroupCustomScheduleSettings = var7;
         TextView var4 = ((HolderDeviceNScheduleCustomTypeBinding)var1).textviewCustomScheduleDescription;
         Intrinsics.checkNotNullExpressionValue(var4, "textviewCustomScheduleDescription");
         this.textviewCustomScheduleDescription = var4;
      }

      this.radioGroupCustomScheduleSettings.setOnCheckedChangeListener(new DeviceNScheduleCustomTypeHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceNScheduleCustomTypeHolder var0, RadioGroup var1, int var2) {
      int var3 = R.id.radio_button_previous;
      String var5 = "previous";
      if (var2 != var3 && var2 == R.id.radio_button_custom) {
         var5 = "custom";
      }

      Function1 var4 = var0.onTypeSelectedListener;
      if (var4 != null) {
         var4.invoke(var5);
      }

   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final Function1 getOnTypeSelectedListener() {
      return this.onTypeSelectedListener;
   }

   public final void setOnTypeSelectedListener(Function1 var1) {
      this.onTypeSelectedListener = var1;
   }

   public final void update(String var1) {
      Intrinsics.checkNotNullParameter(var1, "type");
      int var2;
      if (Intrinsics.areEqual(var1, "custom")) {
         var2 = R.id.radio_button_custom;
      } else {
         var2 = R.id.radio_button_previous;
      }

      int var3;
      if (Intrinsics.areEqual(var1, "previous")) {
         var3 = com.blueair.viewcore.R.string.schedule_previous_description;
      } else {
         var3 = com.blueair.viewcore.R.string.schedule_custom_description;
      }

      this.radioGroupCustomScheduleSettings.check(var2);
      this.textviewCustomScheduleDescription.setText(var3);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleCustomTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNScheduleCustomTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceNScheduleCustomTypeHolder newInstance(ViewGroup var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         ViewBinding var4;
         if (var2 != null && DeviceKt.isAfterG4(var2) && !(var2 instanceof DeviceNewClassic)) {
            HolderDeviceHScheduleCustomTypeBinding var5 = HolderDeviceHScheduleCustomTypeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
            var4 = var5;
         } else {
            HolderDeviceNScheduleCustomTypeBinding var3 = HolderDeviceNScheduleCustomTypeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
            var4 = var3;
         }

         return new DeviceNScheduleCustomTypeHolder(var4, var2);
      }
   }
}
