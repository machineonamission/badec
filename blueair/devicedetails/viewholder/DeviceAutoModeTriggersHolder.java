package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderSettingAutoModeTriggersBinding;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoModeTriggersHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderSettingAutoModeTriggersBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderSettingAutoModeTriggersBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderSettingAutoModeTriggersBinding;", "nightTitleView", "Landroid/widget/TextView;", "nightGroup", "Landroid/widget/RadioGroup;", "getNightGroup", "()Landroid/widget/RadioGroup;", "autoGroup", "getAutoGroup", "settingTitle", "getSettingTitle", "()Landroid/widget/TextView;", "settingSummary", "getSettingSummary", "settingSwitch", "Lcom/blueair/viewcore/view/SwitchCompat;", "getSettingSwitch", "()Lcom/blueair/viewcore/view/SwitchCompat;", "update", "", "device", "Lcom/blueair/core/model/Device;", "overrideAutoModeTrigger", "Lcom/blueair/core/model/FilterTrigger;", "overrideNighModeTrigger", "setOnline", "setOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAutoModeTriggersHolder extends DeviceSettingHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final RadioGroup autoGroup;
   private final HolderSettingAutoModeTriggersBinding binding;
   private final RadioGroup nightGroup;
   private final TextView nightTitleView;
   private final TextView settingSummary;
   private final SwitchCompat settingSwitch;
   private final TextView settingTitle;

   public DeviceAutoModeTriggersHolder(HolderSettingAutoModeTriggersBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      ConstraintLayout var2 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var2, "getRoot(...)");
      super((View)var2);
      this.binding = var1;
      TextView var4 = var1.nightTitle;
      Intrinsics.checkNotNullExpressionValue(var4, "nightTitle");
      this.nightTitleView = var4;
      RadioGroup var5 = var1.buttonGroupNightMode;
      Intrinsics.checkNotNullExpressionValue(var5, "buttonGroupNightMode");
      this.nightGroup = var5;
      var5 = var1.buttonGroupAutoMode;
      Intrinsics.checkNotNullExpressionValue(var5, "buttonGroupAutoMode");
      this.autoGroup = var5;
      TextView var7 = var1.settingTitle;
      Intrinsics.checkNotNullExpressionValue(var7, "settingTitle");
      this.settingTitle = var7;
      TextView var3 = var1.settingSummary;
      Intrinsics.checkNotNullExpressionValue(var3, "settingSummary");
      this.settingSummary = var3;
   }

   public final RadioGroup getAutoGroup() {
      return this.autoGroup;
   }

   public final HolderSettingAutoModeTriggersBinding getBinding() {
      return this.binding;
   }

   public final RadioGroup getNightGroup() {
      return this.nightGroup;
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

   public void setOffline(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      super.setOffline(var1);
      this.nightGroup.setActivated(true);
      Iterator var2 = ViewGroupKt.getChildren((ViewGroup)this.nightGroup).iterator();

      while(var2.hasNext()) {
         ((View)var2.next()).setEnabled(false);
      }

      this.autoGroup.setActivated(true);
      var2 = ViewGroupKt.getChildren((ViewGroup)this.autoGroup).iterator();

      while(var2.hasNext()) {
         ((View)var2.next()).setEnabled(false);
      }

   }

   public void setOnline(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      super.setOnline(var1);
      this.nightGroup.setActivated(false);
      Iterator var2 = ViewGroupKt.getChildren((ViewGroup)this.nightGroup).iterator();

      while(var2.hasNext()) {
         ((View)var2.next()).setEnabled(true);
      }

      this.autoGroup.setActivated(false);
      var2 = ViewGroupKt.getChildren((ViewGroup)this.autoGroup).iterator();

      while(var2.hasNext()) {
         ((View)var2.next()).setEnabled(true);
      }

   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   public final void update(Device var1, FilterTrigger var2, FilterTrigger var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      super.update(var1);
      if (var1 instanceof HasStandBy && ((HasStandBy)var1).isStandByOn()) {
         this.setOffline(var1);
      }

      if (var1 instanceof HasFanSpeed) {
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("update : filter type = ");
         HasFanSpeed var5 = (HasFanSpeed)var1;
         var6.append(var5.getFilter().getName());
         var6.append(" & trigger = ");
         FilterTrigger var4;
         if (var2 == null) {
            var4 = var5.getTrigger();
         } else {
            var4 = var2;
         }

         var6.append(var4);
         var7.d(var6.toString(), new Object[0]);
         var4 = var2;
         if (var2 == null) {
            var4 = var5.getTrigger();
         }

         if (Intrinsics.areEqual(var4, FilterTrigger.Particles.INSTANCE)) {
            this.autoGroup.check(R.id.auto_mode_pm_button);
         } else if (Intrinsics.areEqual(var4, FilterTrigger.ParticlesAndGases.INSTANCE)) {
            this.autoGroup.check(R.id.auto_mode_pm_tvoc_button);
         } else {
            this.autoGroup.clearCheck();
         }

         if (var1 instanceof HasG4NightMode) {
            Timber.Forest var11 = Timber.Forest;
            StringBuilder var12 = new StringBuilder("update : g4 night mode trigger = ");
            if (var3 == null) {
               var2 = ((HasG4NightMode)var1).getG4NightModeTrigger();
            } else {
               var2 = var3;
            }

            var12.append(var2);
            var11.d(var12.toString(), new Object[0]);
            var2 = var3;
            if (var3 == null) {
               var2 = ((HasG4NightMode)var1).getG4NightModeTrigger();
            }

            if (Intrinsics.areEqual(var2, FilterTrigger.Particles.INSTANCE)) {
               this.nightGroup.check(R.id.night_mode_pm_button);
            } else if (Intrinsics.areEqual(var2, FilterTrigger.ParticlesAndGases.INSTANCE)) {
               this.nightGroup.check(R.id.night_mode_pm_tvoc_button);
            } else {
               this.nightGroup.clearCheck();
            }
         }
      }

      ViewExtensionsKt.show((View)this.nightTitleView, DeviceKt.isG4orB4orNB(var1));
      ViewExtensionsKt.show((View)this.nightGroup, DeviceKt.isG4orB4orNB(var1));
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\t*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoModeTriggersHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoModeTriggersHolder;", "parentView", "Landroid/view/ViewGroup;", "setModeButtonContentDescription", "", "Landroid/widget/RadioButton;", "modeTextResId", "", "triggerTextResId", "devicedetails_otherRelease"},
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

      private final void setModeButtonContentDescription(RadioButton var1, int var2, int var3) {
         var1.setContentDescription((CharSequence)var1.getResources().getString(com.blueair.viewcore.R.string.mode_button_content_description_pattern, new Object[]{var1.getResources().getString(var2), var1.getResources().getString(var3)}));
      }

      public final DeviceAutoModeTriggersHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderSettingAutoModeTriggersBinding var4 = HolderSettingAutoModeTriggersBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Companion var2 = DeviceAutoModeTriggersHolder.Companion;
         RadioButton var3 = var4.autoModePmButton;
         Intrinsics.checkNotNullExpressionValue(var3, "autoModePmButton");
         var2.setModeButtonContentDescription(var3, com.blueair.viewcore.R.string.auto_mode, com.blueair.viewcore.R.string.pm_button_text);
         var2 = DeviceAutoModeTriggersHolder.Companion;
         var3 = var4.autoModePmTvocButton;
         Intrinsics.checkNotNullExpressionValue(var3, "autoModePmTvocButton");
         var2.setModeButtonContentDescription(var3, com.blueair.viewcore.R.string.auto_mode, com.blueair.viewcore.R.string.pm_tvoc_button_text);
         var2 = DeviceAutoModeTriggersHolder.Companion;
         var3 = var4.nightModePmButton;
         Intrinsics.checkNotNullExpressionValue(var3, "nightModePmButton");
         var2.setModeButtonContentDescription(var3, com.blueair.viewcore.R.string.night, com.blueair.viewcore.R.string.pm_button_text);
         var2 = DeviceAutoModeTriggersHolder.Companion;
         var3 = var4.nightModePmTvocButton;
         Intrinsics.checkNotNullExpressionValue(var3, "nightModePmTvocButton");
         var2.setModeButtonContentDescription(var3, com.blueair.viewcore.R.string.night, com.blueair.viewcore.R.string.pm_tvoc_button_text);
         Intrinsics.checkNotNullExpressionValue(var4, "apply(...)");
         return new DeviceAutoModeTriggersHolder(var4);
      }
   }
}
