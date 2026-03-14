package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.HolderDeviceAlarmsBinding;
import com.blueair.viewcore.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAlarmsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAlarmsBinding;", "binding", "onOpenAlarmsListener", "Lkotlin/Function0;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAlarmsBinding;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAlarmsHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Function0 onOpenAlarmsListener;

   // $FF: synthetic method
   public static void $r8$lambda$pKXnQSg5BKSatZYwOv5rGTCuOxE(DeviceAlarmsHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceAlarmsHolder(HolderDeviceAlarmsBinding var1, Function0 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onOpenAlarmsListener");
      super(var1);
      this.onOpenAlarmsListener = var2;
      var1.contentContainer.setOnClickListener(new DeviceAlarmsHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceAlarmsHolder var0, View var1) {
      var0.onOpenAlarmsListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      HolderDeviceAlarmsBinding var5 = (HolderDeviceAlarmsBinding)this.getBinding();
      if (var1 instanceof HasAlarm) {
         Iterable var6 = (Iterable)((HasAlarm)var1).getAlarms();
         int var4;
         if (var6 instanceof Collection && ((Collection)var6).isEmpty()) {
            var4 = 0;
         } else {
            Iterator var10 = var6.iterator();
            int var3 = 0;

            while(true) {
               var4 = var3;
               if (!var10.hasNext()) {
                  break;
               }

               DeviceAlarm var7 = (DeviceAlarm)var10.next();
               if (var7 != null && var7.getEnabled()) {
                  var4 = var3 + 1;
                  var3 = var4;
                  if (var4 < 0) {
                     CollectionsKt.throwCountOverflow();
                     var3 = var4;
                  }
               }
            }
         }

         TextView var11 = var5.tvAlarmValue;
         String var13 = String.format(this.getString(R.string.alarm_active), Arrays.copyOf(new Object[]{var4}, 1));
         Intrinsics.checkNotNullExpressionValue(var13, "format(...)");
         var11.setText((CharSequence)var13);
         ImageView var12 = var5.ivAlarm;
         int var8;
         if (var4 > 0) {
            var8 = R.drawable.ic_alarm_active;
         } else {
            var8 = R.drawable.ic_alarm_off;
         }

         var12.setImageResource(var8);
      }

      if (!var2 && var1.isOnline()) {
         var5.contentContainer.setEnabled(true);
         var5.contentContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r1000_black5_stroke1);
         var5.tvAlarmLabel.setTextColor(this.getColor(R.color.colorPrimaryText));
      } else {
         var5.contentContainer.setEnabled(false);
         var5.contentContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r1000_black5_stroke1_disabled_white_bg);
         var5.ivAlarm.setImageResource(R.drawable.ic_alarm_disabled);
         var5.tvAlarmLabel.setTextColor(this.getColor(R.color.surface_dark_55));
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAlarmsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAlarmsHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenAlarmsListener", "Lkotlin/Function0;", "", "devicedetails_otherRelease"},
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

      public final DeviceAlarmsHolder newInstance(ViewGroup var1, Function0 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onOpenAlarmsListener");
         HolderDeviceAlarmsBinding var3 = HolderDeviceAlarmsBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceAlarmsHolder(var3, var2);
      }
   }
}
