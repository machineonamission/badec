package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AlarmSound;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.devicedetails.databinding.HolderAlarmCardBinding;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c¨\u0006%"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderAlarmCardBinding;", "onAlarmChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onAlarmTapped", "Lkotlin/Function1;", "nameColor", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderAlarmCardBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderAlarmCardBinding;", "Ljava/lang/Integer;", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getTimeFormatter", "()Ljava/text/SimpleDateFormat;", "timeFormatter$delegate", "Lkotlin/Lazy;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getCalendar", "()Ljava/util/Calendar;", "calendar$delegate", "bind", "item", "offline", "getDisplayTime", "", "secondsInDay", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AlarmCardViewHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderAlarmCardBinding binding;
   private final Lazy calendar$delegate;
   private final Integer nameColor;
   private final Function2 onAlarmChecked;
   private final Function1 onAlarmTapped;
   private final Lazy timeFormatter$delegate;

   // $FF: synthetic method
   public static SimpleDateFormat $r8$lambda$EDXoIkx63dYjcjqgf8FYLHaqFss(AlarmCardViewHolder var0) {
      return timeFormatter_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Oj4Yy2CldrYxjgmmEdDTpmMQieE(AlarmCardViewHolder var0, DeviceAlarm var1, CompoundButton var2, boolean var3) {
      bind$lambda$6$lambda$5(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$mvRFCUMoVKldWF1rtlx1sX9og8M(AlarmCardViewHolder var0, DeviceAlarm var1, View var2) {
      bind$lambda$6$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Calendar $r8$lambda$zs_7aCLpGRsgZOhyQ1ijQxs5JYo/* $FF was: $r8$lambda$zs-7aCLpGRsgZOhyQ1ijQxs5JYo*/() {
      return calendar_delegate$lambda$1();
   }

   public AlarmCardViewHolder(HolderAlarmCardBinding var1, Function2 var2, Function1 var3, Integer var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onAlarmChecked");
      super((View)var1.getRoot());
      this.binding = var1;
      this.onAlarmChecked = var2;
      this.onAlarmTapped = var3;
      this.nameColor = var4;
      this.timeFormatter$delegate = LazyKt.lazy(new AlarmCardViewHolder$$ExternalSyntheticLambda0(this));
      this.calendar$delegate = LazyKt.lazy(new AlarmCardViewHolder$$ExternalSyntheticLambda1());
      if (var4 != null) {
         int var5 = ((Number)var4).intValue();
         var1.tvName.setTextColor(var5);
      }

   }

   // $FF: synthetic method
   public AlarmCardViewHolder(HolderAlarmCardBinding var1, Function2 var2, Function1 var3, Integer var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 4) != 0) {
         var3 = null;
      }

      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private static final void bind$lambda$6$lambda$4(AlarmCardViewHolder var0, DeviceAlarm var1, View var2) {
      Function1 var3 = var0.onAlarmTapped;
      if (var3 != null) {
         var3.invoke(var1);
      }

   }

   private static final void bind$lambda$6$lambda$5(AlarmCardViewHolder var0, DeviceAlarm var1, CompoundButton var2, boolean var3) {
      var0.onAlarmChecked.invoke(var1, var3);
   }

   private static final Calendar calendar_delegate$lambda$1() {
      return Calendar.getInstance();
   }

   private final Calendar getCalendar() {
      return (Calendar)this.calendar$delegate.getValue();
   }

   private final String getDisplayTime(int var1) {
      int var2 = var1 / 3600;
      this.getCalendar().set(11, var2);
      this.getCalendar().set(12, (var1 - var2 * 3600) / 60);
      String var3 = this.getTimeFormatter().format(this.getCalendar().getTime());
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      return var3;
   }

   private final SimpleDateFormat getTimeFormatter() {
      return (SimpleDateFormat)this.timeFormatter$delegate.getValue();
   }

   private static final SimpleDateFormat timeFormatter_delegate$lambda$0(AlarmCardViewHolder var0) {
      String var1;
      if (DateFormat.is24HourFormat(var0.itemView.getContext())) {
         var1 = "HH:mm";
      } else {
         var1 = "hh:mm a";
      }

      return new SimpleDateFormat(var1);
   }

   public final void bind(DeviceAlarm var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "item");
      HolderAlarmCardBinding var4 = this.binding;
      var4.tvTime.setText((CharSequence)this.getDisplayTime(var1.getSecondsInDay()));
      var4.tvName.setText((CharSequence)var1.getName());
      SwitchCompat var5 = var4.switchAlarm;
      boolean var3 = true;
      var5.setEnabled(var2 ^ true);
      var4.switchAlarm.setCheckedSilence(var1.getEnabled());
      if (!((Collection)var1.getDaysOfWeek()).isEmpty()) {
         TextView var9 = var4.tvRepeat;
         Set var6 = CollectionsKt.toSet((Iterable)CollectionsKt.sortedWith((Iterable)var1.getDaysOfWeek(), new Comparator() {
            public final int compare(Object var1, Object var2) {
               return ComparisonsKt.compareValues((Comparable)((DayOfWeek)var1).getWeekDayCompareValue(), (Comparable)((DayOfWeek)var2).getWeekDayCompareValue());
            }
         }));
         Context var7 = var4.getRoot().getContext();
         Intrinsics.checkNotNullExpressionValue(var7, "getContext(...)");
         var9.setText((CharSequence)DayOfWeekExtensionKt.toString(var6, var7));
         var9 = var4.tvRepeat;
         Intrinsics.checkNotNullExpressionValue(var9, "tvRepeat");
         ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
      } else {
         TextView var11 = var4.tvRepeat;
         Intrinsics.checkNotNullExpressionValue(var11, "tvRepeat");
         ViewExtensionsKt.hide((View)var11);
      }

      ImageView var12 = var4.ivLight;
      Intrinsics.checkNotNullExpressionValue(var12, "ivLight");
      ViewExtensionsKt.show((View)var12, var1.getLightEnabled());
      var12 = var4.ivSound;
      Intrinsics.checkNotNullExpressionValue(var12, "ivSound");
      View var14 = (View)var12;
      if (var1.getSound() != AlarmSound.Mute.getValue()) {
         var2 = var3;
      } else {
         var2 = false;
      }

      ViewExtensionsKt.show(var14, var2);
      var4.getRoot().setOnClickListener(new AlarmCardViewHolder$$ExternalSyntheticLambda2(this, var1));
      var4.switchAlarm.setOnCheckedChangeListener(new AlarmCardViewHolder$$ExternalSyntheticLambda3(this, var1));
   }

   public final HolderAlarmCardBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011¨\u0006\u0012"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder$Companion;", "", "<init>", "()V", "instance", "Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "onAlarmChecked", "Lkotlin/Function2;", "Lcom/blueair/core/model/DeviceAlarm;", "", "", "onAlarmTapped", "Lkotlin/Function1;", "nameColor", "", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)Lcom/blueair/devicedetails/viewholder/AlarmCardViewHolder;", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static AlarmCardViewHolder instance$default(Companion var0, ViewGroup var1, Function2 var2, Function1 var3, Integer var4, int var5, Object var6) {
         if ((var5 & 4) != 0) {
            var3 = null;
         }

         if ((var5 & 8) != 0) {
            var4 = null;
         }

         return var0.instance(var1, var2, var3, var4);
      }

      public final AlarmCardViewHolder instance(ViewGroup var1, Function2 var2, Function1 var3, Integer var4) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         Intrinsics.checkNotNullParameter(var2, "onAlarmChecked");
         HolderAlarmCardBinding var5 = HolderAlarmCardBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new AlarmCardViewHolder(var5, var2, var3, var4);
      }
   }
}
