package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.devicedetails.databinding.HolderDeviceSettingModeBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTVOCSettingHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceSettingModeBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSettingModeBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceSettingModeBinding;", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "update", "", "device", "Lcom/blueair/core/model/Device;", "deviceOffline", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTVOCSettingHolder extends DeviceSettingHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceSettingModeBinding binding;
   private final TextView settingSummary;
   private final SwitchCompat settingSwitch;
   private final TextView settingTitle;

   public DeviceTVOCSettingHolder(HolderDeviceSettingModeBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      ConstraintLayout var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super((View)var2);
      this.binding = var1;
      TextView var4 = var1.settingTitle;
      Intrinsics.checkNotNullExpressionValue(var4, "settingTitle");
      this.settingTitle = var4;
      var4 = var1.settingSummary;
      Intrinsics.checkNotNullExpressionValue(var4, "settingSummary");
      this.settingSummary = var4;
      SwitchCompat var3 = var1.settingSwitch;
      Intrinsics.checkNotNullExpressionValue(var3, "settingSwitch");
      this.settingSwitch = var3;
   }

   public final HolderDeviceSettingModeBinding getBinding() {
      return this.binding;
   }

   public TextView getSettingSummary() {
      return this.settingSummary;
   }

   public SwitchCompat getSettingSwitch() {
      return this.settingSwitch;
   }

   public TextView getSettingTitle() {
      return this.settingTitle;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      super.update(var1);
      int var3 = R.string.tvoc_monitoring;
      int var2 = R.string.setting_tvoc_desc;
      TextView var7 = this.getSettingTitle();
      int var4 = R.drawable.ic_tvoc;
      boolean var6 = false;
      var7.setCompoundDrawablesRelativeWithIntrinsicBounds(var4, 0, 0, 0);
      TextViewCompat.setCompoundDrawableTintList(this.getSettingTitle(), ColorStateList.valueOf(this.itemView.getContext().getColor(R.color.colorPrimary)));
      this.getSettingTitle().setText(this.itemView.getContext().getText(var3));
      this.getSettingSwitch().setContentDescription(this.itemView.getContext().getText(var3));
      SwitchCompat var9 = this.getSettingSwitch();
      if (var1 instanceof DeviceBlue40) {
         var1 = var1;
      } else {
         var1 = null;
      }

      boolean var5 = var6;
      if (var1 != null) {
         var5 = var6;
         if (var1.useTVOCForAqi()) {
            var5 = true;
         }
      }

      var9.setCheckedSilence(var5);
      this.getSettingSummary().setText(this.itemView.getContext().getText(var2));
   }

   public final void update(boolean var1) {
      this.getSettingSwitch().setEnabled(var1 ^ true);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTVOCSettingHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTVOCSettingHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceTVOCSettingHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceSettingModeBinding var2 = HolderDeviceSettingModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceTVOCSettingHolder(var2);
      }
   }
}
