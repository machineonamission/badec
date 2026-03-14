package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsHinsBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingHinsHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsHinsBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsHinsBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsHinsBinding;", "update", "", "device", "Lcom/blueair/core/model/DeviceNewClassic;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSettingHinsHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNSettingsHinsBinding binding;

   public DeviceNSettingHinsHolder(HolderDeviceNSettingsHinsBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
   }

   private static final void update$lambda$0$setSwitchStyle(DeviceNSettingHinsHolder var0, SwitchCompat var1, boolean var2) {
      Context var4 = var0.itemView.getContext();
      int var3;
      if (var2) {
         var3 = R.color.colorPrimaryText;
      } else {
         var3 = R.color.marineblue_20;
      }

      var1.setTextColor(ContextCompat.getColor(var4, var3));
      var1.setEnabled(var2);
   }

   public final HolderDeviceNSettingsHinsBinding getBinding() {
      return this.binding;
   }

   public final void update(DeviceNewClassic var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      HolderDeviceNSettingsHinsBinding var2 = this.binding;
      var2.daySwitchBtn.setCheckedSilence(var1.isHinsModeOn());
      var2.nightSwitchBtn.setCheckedSilence(var1.isHinsNightModeOn());
      if (var1.isStandByOn()) {
         SwitchCompat var4 = var2.daySwitchBtn;
         Intrinsics.checkNotNullExpressionValue(var4, "daySwitchBtn");
         update$lambda$0$setSwitchStyle(this, var4, false);
         var4 = var2.nightSwitchBtn;
         Intrinsics.checkNotNullExpressionValue(var4, "nightSwitchBtn");
         update$lambda$0$setSwitchStyle(this, var4, false);
      } else {
         SwitchCompat var3 = var2.daySwitchBtn;
         Intrinsics.checkNotNullExpressionValue(var3, "daySwitchBtn");
         update$lambda$0$setSwitchStyle(this, var3, var1.isG4NightModeOn() ^ true);
         SwitchCompat var6 = var2.nightSwitchBtn;
         Intrinsics.checkNotNullExpressionValue(var6, "nightSwitchBtn");
         update$lambda$0$setSwitchStyle(this, var6, var1.isG4NightModeOn());
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingHinsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingHinsHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceNSettingHinsHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceNSettingsHinsBinding var2 = HolderDeviceNSettingsHinsBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceNSettingHinsHolder(var2);
      }
   }
}
