package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceHSettingsDeleteBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsDeleteBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingDeleteHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "deleteButton", "Landroid/widget/Button;", "getDeleteButton", "()Landroid/widget/Button;", "deleteButton$delegate", "Lkotlin/Lazy;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSettingDeleteHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewBinding binding;
   private final Lazy deleteButton$delegate;

   // $FF: synthetic method
   public static Button $r8$lambda$3RcPzvPA0RIp2Lm0wlcisp3ClbE(DeviceNSettingDeleteHolder var0) {
      return deleteButton_delegate$lambda$0(var0);
   }

   public DeviceNSettingDeleteHolder(ViewBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
      this.deleteButton$delegate = LazyKt.lazy(new DeviceNSettingDeleteHolder$$ExternalSyntheticLambda0(this));
   }

   private static final Button deleteButton_delegate$lambda$0(DeviceNSettingDeleteHolder var0) {
      return (Button)var0.binding.getRoot().findViewById(R.id.delete_btn);
   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public final Button getDeleteButton() {
      Object var1 = this.deleteButton$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Button)var1;
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingDeleteHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingDeleteHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceNSettingDeleteHolder newInstance(ViewGroup var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         ViewDataBinding var4;
         if (var2 != null && DeviceKt.isAfterG4(var2) && !(var2 instanceof DeviceNewClassic)) {
            HolderDeviceHSettingsDeleteBinding var5 = HolderDeviceHSettingsDeleteBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
            var4 = var5;
         } else {
            HolderDeviceNSettingsDeleteBinding var3 = HolderDeviceNSettingsDeleteBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
            var4 = var3;
         }

         return new DeviceNSettingDeleteHolder((ViewBinding)var4);
      }
   }
}
