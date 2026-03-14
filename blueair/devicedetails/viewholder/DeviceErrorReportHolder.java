package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceRegularSettingBinding;
import com.blueair.devicedetails.view.ButtonTileConstraintLayout;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceErrorReportHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceRegularSettingBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceRegularSettingBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceRegularSettingBinding;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "settingValue", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceErrorReportHolder extends DeviceSettingHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceRegularSettingBinding binding;
   private final ConstraintLayout clickView;
   private final TextView settingSummary;
   private final SwitchCompat settingSwitch;
   private final TextView settingTitle;
   private final TextView settingValue;

   public DeviceErrorReportHolder(HolderDeviceRegularSettingBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      ButtonTileConstraintLayout var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super((View)var2);
      this.binding = var1;
      var2 = var1.regularSettingLayout;
      Intrinsics.checkNotNullExpressionValue(var2, "regularSettingLayout");
      this.clickView = var2;
      TextView var5 = var1.settingTitle;
      Intrinsics.checkNotNullExpressionValue(var5, "settingTitle");
      this.settingTitle = var5;
      TextView var3 = var1.settingValue;
      Intrinsics.checkNotNullExpressionValue(var3, "settingValue");
      this.settingValue = var3;
   }

   public final HolderDeviceRegularSettingBinding getBinding() {
      return this.binding;
   }

   public final ConstraintLayout getClickView() {
      return this.clickView;
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
      this.getSettingTitle().setText(this.itemView.getContext().getText(R.string.error_report));
      ViewExtensionsKt.show((View)this.settingValue, false);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceErrorReportHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceErrorReportHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceErrorReportHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceRegularSettingBinding var2 = HolderDeviceRegularSettingBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceErrorReportHolder(var2);
      }
   }
}
