package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.databinding.HolderDeviceScheduleBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceScheduleBinding;", "formatter12", "Ljava/text/SimpleDateFormat;", "formatter24", "bind", "", "hasCustomName", "", "is24Format", "item", "Lcom/blueair/core/model/DeviceScheduleMerged;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceScheduleBinding binding;
   private final SimpleDateFormat formatter12;
   private final SimpleDateFormat formatter24;

   // $FF: synthetic method
   public static CharSequence $r8$lambda$1WIztM9ylR252yEtmehgT7UIYls(DeviceScheduleViewHolder var0, DayOfWeek var1) {
      return bind$lambda$0(var0, var1);
   }

   public DeviceScheduleViewHolder(HolderDeviceScheduleBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      this.formatter12 = new SimpleDateFormat("hh:mm a");
      this.formatter24 = new SimpleDateFormat("HH:mm");
   }

   private static final CharSequence bind$lambda$0(DeviceScheduleViewHolder var0, DayOfWeek var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Context var2 = var0.itemView.getContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getContext(...)");
      return (CharSequence)DayOfWeekExtensionKt.displayValueShort(var1, var2);
   }

   public final void bind(boolean var1, boolean var2, DeviceScheduleMerged var3, Device var4) {
      Intrinsics.checkNotNullParameter(var3, "item");
      Intrinsics.checkNotNullParameter(var4, "device");
      String var6;
      if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, var3.getDaysOfWeek())) {
         var6 = this.itemView.getContext().getString(R.string.weekdays);
      } else if (DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, var3.getDaysOfWeek())) {
         var6 = this.itemView.getContext().getString(R.string.weekend);
      } else if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, var3.getDaysOfWeek())) {
         var6 = this.itemView.getContext().getString(R.string.everyday);
      } else {
         var6 = CollectionsKt.joinToString$default((Iterable)var3.getDaysOfWeek(), (CharSequence)", ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new DeviceScheduleViewHolder$$ExternalSyntheticLambda0(this), 30, (Object)null);
      }

      Intrinsics.checkNotNull(var6);
      Pair var7;
      if (!var2) {
         var7 = TuplesKt.to(this.formatter12.format(this.formatter24.parse(var3.getStartTime())), this.formatter12.format(this.formatter24.parse(var3.getEndTime())));
      } else {
         var7 = TuplesKt.to(var3.getStartTime(), var3.getEndTime());
      }

      String var8 = (String)var7.component1();
      String var9 = (String)var7.component2();
      TextView var17 = this.binding.timeRange;
      StringBuilder var10 = new StringBuilder();
      var10.append(var8);
      var10.append(" - ");
      var10.append(var9);
      var17.setText((CharSequence)var10.toString());
      String var18;
      if (var1 && !StringsKt.isBlank((CharSequence)var3.getName())) {
         var18 = var3.getName();
      } else {
         var18 = this.itemView.getContext().getString(R.string.schedule_default_name);
         Intrinsics.checkNotNullExpressionValue(var18, "getString(...)");
      }

      StringBuilder var20 = new StringBuilder();
      var20.append(var18);
      var20.append(" <b>");
      var20.append(var6);
      var20.append("</b>");
      Spanned var14 = HtmlCompat.fromHtml(var20.toString(), 0);
      Intrinsics.checkNotNullExpressionValue(var14, "fromHtml(...)");
      this.binding.nameAndRepeat.setText((CharSequence)var14);
      TextView var15 = this.binding.mode;
      Context var19 = this.itemView.getContext();
      int var5;
      if (var3.isNightMode()) {
         var5 = R.string.night;
      } else if (var3.isAutoMode()) {
         var5 = R.string.auto;
      } else if (var3.isStandbyMode()) {
         var5 = R.string.stand_by;
      } else if (var3.isDisinfectionMode()) {
         var5 = R.string.disinfection;
      } else {
         var5 = R.string.fan_speed;
      }

      var15.setText((CharSequence)var19.getString(var5));
      Context var16 = this.itemView.getContext();
      if (var3.isNightMode()) {
         var5 = ModeIcon.NIGHT.getOnIcon();
      } else if (var3.isAutoMode()) {
         var5 = ModeIcon.AUTO.proofread(var4).getOnIcon();
      } else if (var3.isStandbyMode()) {
         var5 = ModeIcon.STANDBY.getOffIcon();
      } else if (var3.isDisinfectionMode()) {
         var5 = ModeIcon.DISINFECTION.getOnIcon();
      } else {
         var5 = ModeIcon.FAN_SPEED.getOnIcon();
      }

      Drawable var11 = ContextCompat.getDrawable(var16, var5);
      var5 = this.itemView.getResources().getDimensionPixelSize(R.dimen.schedule_mode_icon_size);
      if (var11 != null) {
         var11.setBounds(0, 0, var5, var5);
      }

      this.binding.mode.setCompoundDrawablesRelative((Drawable)null, (Drawable)null, var11, (Drawable)null);
   }

   public final HolderDeviceScheduleBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleViewHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceScheduleViewHolder instance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         HolderDeviceScheduleBinding var2 = HolderDeviceScheduleBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceScheduleViewHolder(var2);
      }
   }
}
