package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasAutoRh;
import com.blueair.devicedetails.databinding.HolderDeviceHAutorhBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R,\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHAuthRhHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceHAutorhBinding;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onHumidityTargetSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "autoRh", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHAutorhBinding;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceHAutorhBinding;", "()Z", "getOnOpenInfoListener", "()Lkotlin/jvm/functions/Function0;", "getOnHumidityTargetSetListener", "()Lkotlin/jvm/functions/Function1;", "update", "device", "Lcom/blueair/core/model/Device;", "autorh", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHAuthRhHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceHAutorhBinding binding;
   private final boolean isInSchedule;
   private final Function1 onHumidityTargetSetListener;
   private final Function0 onOpenInfoListener;

   // $FF: synthetic method
   public static void $r8$lambda$q7geLE0ySBSogZXKMGzigBbQNm8(DeviceHAuthRhHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceHAuthRhHolder(HolderDeviceHAutorhBinding var1, boolean var2, Function0 var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var4, "onHumidityTargetSetListener");
      FrameLayout var5 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      super((View)var5);
      this.binding = var1;
      this.isInSchedule = var2;
      this.onOpenInfoListener = var3;
      this.onHumidityTargetSetListener = var4;
      if (var2) {
         var1.title.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      } else {
         var1.title.setOnClickListener(new DeviceHAuthRhHolder$$ExternalSyntheticLambda0(this));
      }

      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceHAuthRhHolder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            TextView var4 = this.this$0.getBinding().progressText;
            StringBuilder var5 = new StringBuilder();
            var5.append(var2);
            var5.append('%');
            var4.setText((CharSequence)var5.toString());
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.getOnHumidityTargetSetListener().invoke(var1.getProgress());
         }
      });
   }

   private static final void _init_$lambda$0(DeviceHAuthRhHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   public final HolderDeviceHAutorhBinding getBinding() {
      return this.binding;
   }

   public final Function1 getOnHumidityTargetSetListener() {
      return this.onHumidityTargetSetListener;
   }

   public final Function0 getOnOpenInfoListener() {
      return this.onOpenInfoListener;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void update(int var1) {
      var1 = RangesKt.coerceIn(var1, 30, 80);
      this.binding.seekbar.setProgress(var1);
      TextView var3 = this.binding.progressText;
      StringBuilder var2 = new StringBuilder();
      var2.append(var1);
      var2.append('%');
      var3.setText((CharSequence)var2.toString());
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasAutoRh) {
         this.update(RangesKt.coerceIn(((HasAutoRh)var1).getAutoRh(), 30, 80));
      }

   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHAuthRhHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHAuthRhHolder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onOpenInfoListener", "Lkotlin/Function0;", "", "onHumidityTargetSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "autoRh", "devicedetails_otherRelease"},
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

      public final DeviceHAuthRhHolder newInstance(ViewGroup var1, boolean var2, Function0 var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var4, "onHumidityTargetSetListener");
         HolderDeviceHAutorhBinding var5 = HolderDeviceHAutorhBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         if (var2) {
            var5.contentContainer.setBackground(AppCompatResources.getDrawable(var1.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
         }

         Intrinsics.checkNotNullExpressionValue(var5, "apply(...)");
         return new DeviceHAuthRhHolder(var5, var2, var3, var4);
      }
   }
}
