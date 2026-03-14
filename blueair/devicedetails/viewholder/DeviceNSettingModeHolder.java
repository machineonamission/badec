package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsModeBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingModeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsModeBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsModeBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsModeBinding;", "update", "", "title", "", "value", "", "disabled", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSettingModeHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNSettingsModeBinding binding;

   public DeviceNSettingModeHolder(HolderDeviceNSettingsModeBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
   }

   public final HolderDeviceNSettingsModeBinding getBinding() {
      return this.binding;
   }

   public final void update(int var1, boolean var2, boolean var3) {
      this.binding.title.setText(var1);
      Context var5 = this.itemView.getContext();
      int var4;
      if (var3) {
         var4 = R.color.marineblue_20;
      } else {
         var4 = R.color.colorPrimaryText;
      }

      var4 = ContextCompat.getColor(var5, var4);
      this.binding.title.setTextColor(var4);
      this.binding.descText.setTextColor(var4);
      this.binding.switchBtn.setCheckedSilence(var2);
      this.binding.switchBtn.setEnabled(var3 ^ true);
      this.binding.switchBtn.setContentDescription((CharSequence)this.binding.getRoot().getContext().getString(var1));
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingModeHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceNSettingModeHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceNSettingsModeBinding var2 = HolderDeviceNSettingsModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceNSettingModeHolder(var2);
      }
   }
}
