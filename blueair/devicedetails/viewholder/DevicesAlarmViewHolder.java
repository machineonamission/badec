package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.adapter.AlarmCardAdapter;
import com.blueair.devicedetails.databinding.HolderDevicesAlarmBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDevicesAlarmBinding;", "onAlarmChecked", "Lkotlin/Function3;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDevicesAlarmBinding;Lkotlin/jvm/functions/Function3;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDevicesAlarmBinding;", "alarmDevice", "adapter", "Lcom/blueair/devicedetails/adapter/AlarmCardAdapter;", "troubleshootingBtn", "Landroid/widget/Button;", "getTroubleshootingBtn", "()Landroid/widget/Button;", "closeBtn", "getCloseBtn", "iconMore", "Landroid/view/View;", "getIconMore", "()Landroid/view/View;", "bind", "hasAlarm", "forceOffline", "hideOfflineTip", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DevicesAlarmViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final AlarmCardAdapter adapter;
   private HasAlarm alarmDevice;
   private final HolderDevicesAlarmBinding binding;
   private final Function3 onAlarmChecked;

   // $FF: synthetic method
   public static Unit $r8$lambda$naRxaHXZl1RWsYSbmO84lmEhTHw(DevicesAlarmViewHolder var0, DeviceAlarm var1, boolean var2) {
      return adapter$lambda$1(var0, var1, var2);
   }

   public DevicesAlarmViewHolder(HolderDevicesAlarmBinding var1, Function3 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onAlarmChecked");
      super((View)var1.getRoot());
      this.binding = var1;
      this.onAlarmChecked = var2;
      AlarmCardAdapter var4 = new AlarmCardAdapter(this.itemView.getContext().getColor(R.color.surface_dark_65), new DevicesAlarmViewHolder$$ExternalSyntheticLambda0(this), (Function1)null, 4, (DefaultConstructorMarker)null);
      this.adapter = var4;
      RecyclerView var3 = var1.rvAlarms;
      var3.setAdapter(var4);
      var3.addItemDecoration(new SimpleSpacingDecoration(0, (int)TypedValueCompat.dpToPx(8.0F, var3.getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker)null));
   }

   private static final Unit adapter$lambda$1(DevicesAlarmViewHolder var0, DeviceAlarm var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceAlarm");
      HasAlarm var3 = var0.alarmDevice;
      if (var3 != null) {
         var0.onAlarmChecked.invoke(var3, var1, var2);
      }

      return Unit.INSTANCE;
   }

   public final void bind(HasAlarm var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "hasAlarm");
      this.alarmDevice = var1;
      boolean var5 = true;
      int var4 = 0;
      if (!var2 && var1.isOnline()) {
         var2 = false;
      } else {
         var2 = true;
      }

      this.adapter.setData(CollectionsKt.filterNotNull((Iterable)var1.getAlarms()), var2);
      HolderDevicesAlarmBinding var7 = this.binding;
      ImageView var8 = var7.ivMore;
      ColorStateList var6;
      if (var2) {
         var6 = ColorStateList.valueOf(this.itemView.getContext().getColor(R.color.surface_dark_45));
      } else {
         var6 = null;
      }

      var8.setImageTintList(var6);
      ConstraintLayout var12 = var7.layoutOffline.getRoot();
      Intrinsics.checkNotNullExpressionValue(var12, "getRoot(...)");
      View var13 = (View)var12;
      if (var2 && !var3) {
         var2 = true;
      } else {
         var2 = false;
      }

      ViewExtensionsKt.show(var13, var2);
      RecyclerView var14 = var7.rvAlarms;
      Intrinsics.checkNotNullExpressionValue(var14, "rvAlarms");
      View var15 = (View)var14;
      if (this.adapter.getItemCount() > 0) {
         var2 = var5;
      } else {
         var2 = false;
      }

      ViewExtensionsKt.show(var15, var2);
      var8 = var7.ivDevice;
      DeviceImage var16 = DeviceConfigProvider.INSTANCE.getDeviceImage(var1);
      if (var16 != null) {
         var4 = var16.getDevice();
      }

      var8.setImageResource(var4);
      var7.tvDeviceName.setText((CharSequence)var1.getName());
   }

   public final HolderDevicesAlarmBinding getBinding() {
      return this.binding;
   }

   public final Button getCloseBtn() {
      Button var1 = this.binding.layoutOffline.closeBtn;
      Intrinsics.checkNotNullExpressionValue(var1, "closeBtn");
      return var1;
   }

   public final View getIconMore() {
      ImageView var1 = this.binding.ivMore;
      Intrinsics.checkNotNullExpressionValue(var1, "ivMore");
      return (View)var1;
   }

   public final Button getTroubleshootingBtn() {
      Button var1 = this.binding.layoutOffline.troubleshootBtn;
      Intrinsics.checkNotNullExpressionValue(var1, "troubleshootBtn");
      return var1;
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\t¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/DevicesAlarmViewHolder;", "parent", "Landroid/view/ViewGroup;", "onAlarmChecked", "Lkotlin/Function3;", "Lcom/blueair/core/model/HasAlarm;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "devicedetails_otherRelease"},
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

      public final DevicesAlarmViewHolder instance(ViewGroup var1, Function3 var2) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         Intrinsics.checkNotNullParameter(var2, "onAlarmChecked");
         HolderDevicesAlarmBinding var3 = HolderDevicesAlarmBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DevicesAlarmViewHolder(var3, var2);
      }
   }
}
