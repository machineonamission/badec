package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.devicedetails.databinding.HolderScheduleCardBinding;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/ScheduleCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderScheduleCardBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderScheduleCardBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderScheduleCardBinding;", "formatter12", "Ljava/text/SimpleDateFormat;", "formatter24", "bind", "", "hasCustomName", "", "is24Format", "item", "Lcom/blueair/core/model/DeviceScheduleMerged;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScheduleCardViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderScheduleCardBinding binding;
   private final SimpleDateFormat formatter12;
   private final SimpleDateFormat formatter24;

   public ScheduleCardViewHolder(HolderScheduleCardBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      this.formatter12 = new SimpleDateFormat("hh:mm a");
      this.formatter24 = new SimpleDateFormat("HH:mm");
   }

   public final void bind(boolean var1, boolean var2, DeviceScheduleMerged var3, Device var4) {
      Intrinsics.checkNotNullParameter(var3, "item");
      Intrinsics.checkNotNullParameter(var4, "device");
      Set var7 = CollectionsKt.toSet((Iterable)CollectionsKt.sortedWith((Iterable)var3.getDaysOfWeek(), new Comparator() {
         public final int compare(Object var1, Object var2) {
            return ComparisonsKt.compareValues((Comparable)((DayOfWeek)var1).getWeekDayCompareValue(), (Comparable)((DayOfWeek)var2).getWeekDayCompareValue());
         }
      }));
      Context var6 = this.itemView.getContext();
      Intrinsics.checkNotNullExpressionValue(var6, "getContext(...)");
      String var25 = DayOfWeekExtensionKt.toString(var7, var6);
      Pair var18;
      if (!var2) {
         var18 = TuplesKt.to(this.formatter12.format(this.formatter24.parse(var3.getStartTime())), this.formatter12.format(this.formatter24.parse(var3.getEndTime())));
      } else {
         var18 = TuplesKt.to(var3.getStartTime(), var3.getEndTime());
      }

      String var8 = (String)var18.component1();
      String var9 = (String)var18.component2();
      TextView var19 = this.binding.timeRange;
      StringBuilder var10 = new StringBuilder();
      var10.append(var8);
      var10.append(" - ");
      var10.append(var9);
      var19.setText((CharSequence)var10.toString());
      String var20;
      if (var1 && !StringsKt.isBlank((CharSequence)var3.getName())) {
         var20 = var3.getName();
      } else {
         var20 = this.itemView.getContext().getString(R.string.schedule_default_name);
         Intrinsics.checkNotNullExpressionValue(var20, "getString(...)");
      }

      this.binding.tvName.setText((CharSequence)var20);
      this.binding.tvRepeat.setText((CharSequence)var25);
      if (!var3.isStandbyMode() && (var4 instanceof HasCombo3in1MainMode || var4 instanceof DeviceDehumidifier || var4 instanceof HasHumMainMode || var4 instanceof HasHumMode)) {
         ImageView var26 = this.binding.ivMainMode;
         Context var22 = this.itemView.getContext();
         int var5;
         if (var3.isCoolMainMode()) {
            var5 = ModeIcon.COOL.getFlatIcon();
         } else if (var3.isHeatMainMode()) {
            var5 = ModeIcon.HEAT.getFlatIcon();
         } else if (var3.isDehMainMode()) {
            var5 = R.drawable.mode_icon_dehum_flat;
         } else if (!var3.isHumMainMode() && !var3.isHumMode()) {
            var5 = ModeIcon.AIR_PURIFY.getFlatIcon();
         } else {
            var5 = ModeIcon.HUM.getFlatIcon();
         }

         var26.setImageDrawable(ContextCompat.getDrawable(var22, var5));
         ImageView var23 = this.binding.ivMainMode;
         Intrinsics.checkNotNullExpressionValue(var23, "ivMainMode");
         ViewExtensionsKt.show$default((View)var23, false, 1, (Object)null);
      } else {
         ImageView var21 = this.binding.ivMainMode;
         Intrinsics.checkNotNullExpressionValue(var21, "ivMainMode");
         ViewExtensionsKt.hide((View)var21);
      }

      var1 = var3.isNightMode();
      var20 = "";
      String var12;
      int var17;
      if (var1) {
         var17 = ModeIcon.NIGHT.getFlatIcon();
         var12 = var20;
      } else if (var3.isAutoMode()) {
         var17 = ModeIcon.AUTO.proofread(var4).getFlatIcon();
         var12 = var20;
      } else if (var3.isStandbyMode()) {
         var17 = ModeIcon.STANDBY.getFlatIcon();
         var12 = var20;
      } else if (var3.isDisinfectionMode()) {
         var17 = ModeIcon.DISINFECTION.getFlatIcon();
         var12 = var20;
      } else if (var3.isEcoMode()) {
         var17 = ModeIcon.ECO.getFlatIcon();
         var12 = var20;
      } else if (var3.isSmartMainMode()) {
         var17 = ModeIcon.SMART.getFlatIcon();
         var12 = var20;
      } else if (var3.isDryingMode()) {
         var17 = ModeIcon.DRYING.proofread(var4).getFlatIcon();
         var12 = var20;
      } else if (var3.isContinuousMode()) {
         var17 = ModeIcon.CONTINUOUS.getFlatIcon();
         var12 = var20;
      } else if (var3.isSkinMode()) {
         var17 = ModeIcon.SKIN.getFlatIcon();
         var12 = var20;
      } else {
         var12 = String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(var4, var3.fetchFanSpeed(var4)));
         var17 = ModeIcon.FAN_SPEED.getFlatIcon();
      }

      CharSequence var13 = (CharSequence)var12;
      if (var13.length() == 0) {
         AppCompatTextView var14 = this.binding.tvMode;
         Intrinsics.checkNotNullExpressionValue(var14, "tvMode");
         ViewExtensionsKt.hide((View)var14);
      } else {
         this.binding.tvMode.setText(var13);
         AppCompatTextView var15 = this.binding.tvMode;
         Intrinsics.checkNotNullExpressionValue(var15, "tvMode");
         ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
      }

      this.binding.ivMode.setImageResource(var17);
      LinearLayout var16 = this.binding.llMode;
      Intrinsics.checkNotNullExpressionValue(var16, "llMode");
      ViewExtensionsKt.show$default((View)var16, false, 1, (Object)null);
      this.binding.switchSchedule.setCheckedSilence(var3.getPaused() ^ true);
   }

   public final HolderScheduleCardBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/ScheduleCardViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/ScheduleCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final ScheduleCardViewHolder instance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         HolderScheduleCardBinding var2 = HolderScheduleCardBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new ScheduleCardViewHolder(var2);
      }
   }
}
