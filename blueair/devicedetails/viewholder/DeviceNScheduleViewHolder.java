package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceNScheduleBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNScheduleBinding;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNScheduleBinding;Lcom/blueair/core/model/Device;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNScheduleBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "formatter12", "Ljava/text/SimpleDateFormat;", "formatter24", "bind", "", "hasCustomName", "", "is24Format", "item", "Lcom/blueair/core/model/DeviceScheduleMerged;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNScheduleViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNScheduleBinding binding;
   private final Device device;
   private final SimpleDateFormat formatter12;
   private final SimpleDateFormat formatter24;

   public DeviceNScheduleViewHolder(HolderDeviceNScheduleBinding var1, Device var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "device");
      super((View)var1.getRoot());
      this.binding = var1;
      this.device = var2;
      this.formatter12 = new SimpleDateFormat("hh:mm a");
      this.formatter24 = new SimpleDateFormat("HH:mm");
   }

   public final void bind(boolean var1, boolean var2, DeviceScheduleMerged var3) {
      Intrinsics.checkNotNullParameter(var3, "item");
      Set var8 = var3.getDaysOfWeek();
      Context var7 = this.itemView.getContext();
      Intrinsics.checkNotNullExpressionValue(var7, "getContext(...)");
      String var37 = DayOfWeekExtensionKt.toString(var8, var7);
      Pair var19;
      if (var2) {
         var19 = TuplesKt.to(var3.getStartTime(), var3.getEndTime());
      } else {
         var19 = TuplesKt.to(this.formatter12.format(this.formatter24.parse(var3.getStartTime())), this.formatter12.format(this.formatter24.parse(var3.getEndTime())));
      }

      String var9 = (String)var19.component1();
      String var11 = (String)var19.component2();
      TextView var20 = this.binding.timeRange;
      StringBuilder var10 = new StringBuilder();
      var10.append(var9);
      var10.append(" - ");
      var10.append(var11);
      var20.setText((CharSequence)var10.toString());
      String var21;
      if (var1 && !StringsKt.isBlank((CharSequence)var3.getName())) {
         var21 = var3.getName();
      } else {
         var21 = this.itemView.getContext().getString(R.string.schedule_default_name);
         Intrinsics.checkNotNullExpressionValue(var21, "getString(...)");
      }

      StringBuilder var40 = new StringBuilder();
      var40.append(var21);
      var40.append(" <b>");
      var40.append(var37);
      var40.append("</b>");
      var21 = var40.toString();
      byte var5 = 0;
      Spanned var23 = HtmlCompat.fromHtml(var21, 0);
      Intrinsics.checkNotNullExpressionValue(var23, "fromHtml(...)");
      this.binding.nameAndRepeat.setText((CharSequence)var23);
      var1 = this.device instanceof HasCombo3in1MainMode;
      boolean var6 = true;
      if (var1 && !var3.isStandbyMode()) {
         AppCompatImageView var38 = this.binding.iconMainMode;
         Context var26 = this.itemView.getContext();
         int var4;
         if (var3.isCoolMainMode()) {
            var4 = ModeIcon.COOL.getOnIcon();
         } else if (var3.isHeatMainMode()) {
            var4 = ModeIcon.HEAT.getOnIcon();
         } else {
            var4 = ModeIcon.AIR_PURIFY.getOnIcon();
         }

         var38.setImageDrawable(ContextCompat.getDrawable(var26, var4));
         TextView var27 = this.binding.mainMode;
         Intrinsics.checkNotNullExpressionValue(var27, "mainMode");
         ViewExtensionsKt.show$default((View)var27, false, 1, (Object)null);
         var27 = this.binding.mainMode;
         if (var3.isCoolMainMode()) {
            var4 = R.string.main_mode_cool_short;
         } else if (var3.isHeatMainMode()) {
            var4 = R.string.main_mode_heat_short;
         } else {
            var4 = R.string.main_mode_ap_short;
         }

         var27.setText(var4);
         AppCompatImageView var29 = this.binding.iconMainMode;
         Intrinsics.checkNotNullExpressionValue(var29, "iconMainMode");
         ViewExtensionsKt.show$default((View)var29, false, 1, (Object)null);
         TextView var30 = this.binding.mainMode;
         Intrinsics.checkNotNullExpressionValue(var30, "mainMode");
         ViewExtensionsKt.show$default((View)var30, false, 1, (Object)null);
      } else {
         AppCompatImageView var24 = this.binding.iconMainMode;
         Intrinsics.checkNotNullExpressionValue(var24, "iconMainMode");
         ViewExtensionsKt.hide((View)var24);
         TextView var25 = this.binding.mainMode;
         Intrinsics.checkNotNullExpressionValue(var25, "mainMode");
         ViewExtensionsKt.hide((View)var25);
      }

      Context var31 = this.itemView.getContext();
      int var14;
      if (var3.isNightMode()) {
         var14 = ModeIcon.NIGHT.getOnIcon();
      } else if (var3.isAutoMode()) {
         var14 = ModeIcon.AUTO.proofread(this.device).getOnIcon();
      } else if (var3.isStandbyMode()) {
         var14 = ModeIcon.STANDBY.getOffIcon();
      } else if (var3.isDisinfectionMode()) {
         var14 = ModeIcon.DISINFECTION.getOnIcon();
      } else if (var3.isEcoMode()) {
         var14 = ModeIcon.ECO.getOnIcon();
      } else if (var3.isSmartMainMode()) {
         var14 = ModeIcon.SMART.getOnIcon();
      } else {
         var14 = ModeIcon.FAN_SPEED.getOnIcon();
      }

      Drawable var32 = ContextCompat.getDrawable(var31, var14);
      this.binding.iconMode.setImageDrawable(var32);
      TextView var33 = this.binding.mode;
      if (var3.isNightMode()) {
         var14 = R.string.night;
      } else if (var3.isAutoMode()) {
         var14 = R.string.auto;
      } else if (var3.isStandbyMode()) {
         var14 = R.string.stand_by;
      } else if (var3.isDisinfectionMode()) {
         var14 = R.string.disinfection;
      } else if (var3.isEcoMode()) {
         var14 = R.string.eco;
      } else if (var3.isSmartMainMode()) {
         var14 = R.string.main_mode_smart;
      } else {
         var14 = R.string.fan_speed;
      }

      var33.setText(var14);
      var33 = this.binding.scheduleSwitch;
      Intrinsics.checkNotNullExpressionValue(var33, "scheduleSwitch");
      View var35 = (View)var33;
      if (DeviceKt.isAfterG4(this.device) && !(this.device instanceof DeviceNewClassic)) {
         var14 = var6;
      } else {
         var14 = 0;
      }

      if (var14) {
         var14 = var5;
      } else {
         var14 = 8;
      }

      var35.setVisibility(var14);
      TextView var36 = this.binding.scheduleSwitch;
      Context var39 = this.itemView.getContext();
      if (var3.getPaused()) {
         var14 = R.string.off_camel_case;
      } else {
         var14 = R.string.on_camel_case;
      }

      var36.setText((CharSequence)var39.getString(var14));
   }

   public final HolderDeviceNScheduleBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNScheduleViewHolder;", "parent", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceNScheduleViewHolder newInstance(ViewGroup var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         Intrinsics.checkNotNullParameter(var2, "device");
         HolderDeviceNScheduleBinding var3 = HolderDeviceNScheduleBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceNScheduleViewHolder(var3, var2);
      }
   }
}
