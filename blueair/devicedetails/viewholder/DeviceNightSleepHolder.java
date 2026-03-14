package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasNightModeTiming;
import com.blueair.devicedetails.databinding.HolderDeviceNightSleepBinding;
import com.blueair.viewcore.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNightSleepHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceNightSleepBinding;", "binding", "isInSchedule", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onHintCloseListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNightSleepBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "()Z", "nightSleepHintClosedBefore", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "hintClosedBefore", "getLeftHm", "", "leftSeconds", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNightSleepHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final boolean isInSchedule;
   private boolean nightSleepHintClosedBefore;
   private final Function0 onHintCloseListener;
   private final Function0 onInfoClickListener;

   // $FF: synthetic method
   public static void $r8$lambda$QjlkUMJpAypYA5lECi6iQoqWYS0(DeviceNightSleepHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$loZa3tT9w7SvRjom8LM_CnzK26k/* $FF was: $r8$lambda$loZa3tT9w7SvRjom8LM-CnzK26k*/(DeviceNightSleepHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   public DeviceNightSleepHolder(HolderDeviceNightSleepBinding var1, boolean var2, Function0 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
      Intrinsics.checkNotNullParameter(var4, "onHintCloseListener");
      super(var1);
      this.isInSchedule = var2;
      this.onInfoClickListener = var3;
      this.onHintCloseListener = var4;
      var1.ivInfo.setOnClickListener(new DeviceNightSleepHolder$$ExternalSyntheticLambda0(this));
      var1.hintSleep.btnCloseHint.setOnClickListener(new DeviceNightSleepHolder$$ExternalSyntheticLambda1(this));
   }

   private static final void _init_$lambda$0(DeviceNightSleepHolder var0, View var1) {
      var0.onInfoClickListener.invoke();
   }

   private static final void _init_$lambda$1(DeviceNightSleepHolder var0, View var1) {
      var0.onHintCloseListener.invoke();
   }

   private final String getLeftHm(long var1) {
      int var3 = (int)Math.ceil((double)var1 / (double)60.0F);
      String var4 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{var3 / 60, var3 % 60}, 2));
      Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
      return var4;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasNightModeTiming) {
         var2 = this.isInSchedule;
         long var5 = 28800L;
         long var9;
         int var15;
         long var16;
         if (!var2) {
            var16 = System.currentTimeMillis() / (long)1000;
            var1 = var1;
            var9 = RangesKt.coerceIn(var16 - var1.getNightModeStartTime(), 0L, 28800L);
            int var4 = var1.getNightPeriods().length;
            var15 = 0;

            while(true) {
               if (var15 >= var4) {
                  var15 = 0;
                  break;
               }

               if ((double)var9 >= var1.getNightPeriods()[var15] * (double)3600) {
                  --var15;
                  break;
               }

               ++var15;
            }

            var15 = RangesKt.coerceIn(var15, 0, 2);
            var16 = var5;
         } else {
            var16 = 28800L;
            var15 = 0;
            var9 = var5;
         }

         HolderDeviceNightSleepBinding var12 = (HolderDeviceNightSleepBinding)this.getBinding();
         if (var15 != 1) {
            if (var15 != 2) {
               var12.tvSleepLabel.setText(R.string.label_fall_asleep);
               var12.hintSleep.hintText.setText(R.string.night_fall_asleep_hint);
            } else {
               var12.tvSleepLabel.setText(R.string.label_stay_asleep);
               var12.hintSleep.hintText.setText(R.string.night_stay_asleep_hint);
            }
         } else {
            var12.tvSleepLabel.setText(R.string.label_deep_sleep);
            var12.hintSleep.hintText.setText(R.string.night_deep_sleep_hint);
         }

         var12.tvLeft.setText((CharSequence)var12.getRoot().getContext().getString(R.string.time_left, new Object[]{this.getLeftHm(var9)}));
         ((HolderDeviceNightSleepBinding)this.getBinding()).progressIndicator.setProgress((int)(var9 * (long)100 / var16));
      }
   }

   public final void update(Device var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.nightSleepHintClosedBefore = var3;
      this.update(var1, var2);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNightSleepHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNightSleepHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onHintCloseListener", "devicedetails_otherRelease"},
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

      public final DeviceNightSleepHolder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onInfoClickListener");
         Intrinsics.checkNotNullParameter(var4, "onHintCloseListener");
         HolderDeviceNightSleepBinding var5 = HolderDeviceNightSleepBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceNightSleepHolder(var5, var2, var3, var4);
      }
   }
}
