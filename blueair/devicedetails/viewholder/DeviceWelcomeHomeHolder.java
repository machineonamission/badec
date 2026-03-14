package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderWelcomeHomeModeBinding;
import com.blueair.devicedetails.util.DeviceWelcomeHomeProvider;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWelcomeHomeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderWelcomeHomeModeBinding;", "welcomeHomeProvider", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderWelcomeHomeModeBinding;Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderWelcomeHomeModeBinding;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "settingTitle", "Landroid/widget/TextView;", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "update", "", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceWelcomeHomeHolder extends DeviceSettingHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderWelcomeHomeModeBinding binding;
   private final ConstraintLayout clickView;
   private final TextView settingSummary;
   private final SwitchCompat settingSwitch;
   private final TextView settingTitle;
   private final DeviceWelcomeHomeProvider welcomeHomeProvider;

   public DeviceWelcomeHomeHolder(HolderWelcomeHomeModeBinding var1, DeviceWelcomeHomeProvider var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.welcomeHomeProvider = var2;
      ConstraintLayout var4 = var1.clLocation;
      Intrinsics.checkNotNullExpressionValue(var4, "clLocation");
      this.clickView = var4;
      AppCompatTextView var5 = var1.settingTitle;
      Intrinsics.checkNotNullExpressionValue(var5, "settingTitle");
      this.settingTitle = (TextView)var5;
      TextView var6 = var1.settingSummary;
      Intrinsics.checkNotNullExpressionValue(var6, "settingSummary");
      this.settingSummary = var6;
      SwitchCompat var7 = var1.settingSwitch;
      Intrinsics.checkNotNullExpressionValue(var7, "settingSwitch");
      this.settingSwitch = var7;
      ViewUtils var8 = ViewUtils.INSTANCE;
      var3 = var1.clLocation;
      Intrinsics.checkNotNullExpressionValue(var3, "clLocation");
      ViewUtils.setAccessibilityDelegate$default(var8, (View)var3, (KClass)null, var1.getRoot().getContext().getString(R.string.button_role), (Function2)null, 10, (Object)null);
   }

   public final HolderWelcomeHomeModeBinding getBinding() {
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
      DeviceWelcomeHomeProvider var7 = this.welcomeHomeProvider;
      if (var7 != null) {
         Context var5 = this.binding.getRoot().getContext();
         int var3 = ContextCompat.getColor(var5, R.color.colorPrimary);
         int var2 = ContextCompat.getColor(var5, R.color.surface_dark_65);
         if (var7.isHomeLocationExist()) {
            this.binding.tvLocation.setText((CharSequence)var7.getHomeAddress());
            this.binding.tvLocation.setTextColor(var3);
            AppCompatTextView var4 = this.binding.tvRadius;
            StringBuilder var6 = new StringBuilder();
            var6.append(ContextCompat.getString(var5, R.string.welcome_home_radius));
            var6.append(' ');
            var6.append(var7.fetchRadius());
            var4.setText((CharSequence)var6.toString());
            this.binding.ivEdit.setImageResource(R.drawable.ic_edit_flat);
            this.binding.tvRadius.setTextColor(var2);
            this.binding.tvRadius.setTextSize(12.0F);
         } else {
            this.binding.tvLocation.setText(R.string.no_location_assigned_value);
            this.binding.tvRadius.setText(R.string.add);
            this.binding.ivEdit.setImageResource(R.drawable.ic_add_flat);
            this.binding.tvLocation.setTextColor(var2);
            this.binding.tvRadius.setTextColor(var3);
            this.binding.tvRadius.setTextSize(14.0F);
         }

         this.binding.settingSwitch.setChecked(var7.isEnabled());
      }

   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceWelcomeHomeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceWelcomeHomeHolder;", "parentView", "Landroid/view/ViewGroup;", "welcomeHomeProvider", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "devicedetails_otherRelease"},
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

      public final DeviceWelcomeHomeHolder newInstance(ViewGroup var1, DeviceWelcomeHomeProvider var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderWelcomeHomeModeBinding var3 = HolderWelcomeHomeModeBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceWelcomeHomeHolder(var3, var2);
      }
   }
}
