package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceBrightnessV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B:\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0017J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessV2Binding;", "binding", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceBrightnessV2Binding;ZLkotlin/jvm/functions/Function1;)V", "()Z", "minBrightness", "inTouch", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "calcProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBrightnessV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private boolean inTouch;
   private final boolean isInSchedule;
   private int minBrightness;
   private final Function1 onBrightnessSetListener;

   public DeviceBrightnessV2Holder(HolderDeviceBrightnessV2Binding var1, boolean var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onBrightnessSetListener");
      super(var1);
      this.isInSchedule = var2;
      this.onBrightnessSetListener = var3;
      ViewUtils var5 = ViewUtils.INSTANCE;
      View var4 = var1.clickView;
      Intrinsics.checkNotNullExpressionValue(var4, "clickView");
      ViewUtils.setAccessibilityDelegate$default(var5, var4, (KClass)null, this.getString(R.string.button_role), (Function2)null, 10, (Object)null);
      var1.clickView.setOnClickListener(new DeviceBrightnessV2Holder$$ExternalSyntheticLambda1(var1));
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceBrightnessV2Holder$$ExternalSyntheticLambda2(var1));
      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var1, this) {
         final HolderDeviceBrightnessV2Binding $this_apply;
         final DeviceBrightnessV2Holder this$0;

         {
            this.$this_apply = var1;
            this.this$0 = var2;
         }

         public final int correctProgress(int var1) {
            return VERSION.SDK_INT >= 26 ? var1 : var1 * (100 - this.this$0.minBrightness) / 100 + this.this$0.minBrightness;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            TextView var5 = this.$this_apply.progressText;
            StringBuilder var4 = new StringBuilder();
            var4.append(this.correctProgress(var1.getProgress()));
            var4.append('%');
            var5.setText((CharSequence)var4.toString());
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = true;
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = false;
            int var2 = this.correctProgress(var1.getProgress());
            this.this$0.onBrightnessSetListener.invoke(var2);
         }
      });
      if (var2) {
         var1.expendSwitch.setChecked(false);
      }

   }

   static final void lambda$2$lambda$0(HolderDeviceBrightnessV2Binding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   static final void lambda$2$lambda$1(HolderDeviceBrightnessV2Binding var0, CompoundButton var1, boolean var2) {
      Group var3 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var3, "expendedContent");
      ViewExtensionsKt.show((View)var3, var2 ^ true);
   }

   public final int calcProgress(int var1) {
      if (VERSION.SDK_INT >= 26) {
         return var1;
      } else {
         int var2 = this.minBrightness;
         return MathKt.roundToInt((float)(var1 - var2) * 100.0F / (float)(100 - var2) + 0.5F);
      }
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void update(Device var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (DeviceKt.useNewBrightnessRange(var1) || var1 instanceof DeviceFanTable) {
         byte var3;
         if (var1 instanceof DeviceFanTable) {
            var3 = 2;
         } else {
            var3 = 10;
         }

         this.minBrightness = var3;
         if (VERSION.SDK_INT >= 26) {
            BlueairApp$$ExternalSyntheticApiModelOutline0.m(((HolderDeviceBrightnessV2Binding)this.getBinding()).seekbar, this.minBrightness);
         }

         TextView var5 = ((HolderDeviceBrightnessV2Binding)this.getBinding()).tvProgress0;
         StringBuilder var4 = new StringBuilder();
         var4.append(this.minBrightness);
         var4.append('%');
         var5.setText((CharSequence)var4.toString());
      }

      var2 = RangesKt.coerceIn(var2, this.minBrightness, 100);
      ((HolderDeviceBrightnessV2Binding)this.getBinding()).seekbar.setProgress(this.calcProgress(var2));
      TextView var9 = ((HolderDeviceBrightnessV2Binding)this.getBinding()).progressText;
      StringBuilder var6 = new StringBuilder();
      var6.append(var2);
      var6.append('%');
      var9.setText((CharSequence)var6.toString());
      View var7 = ((HolderDeviceBrightnessV2Binding)this.getBinding()).clickView;
      StringBuilder var10 = new StringBuilder();
      var10.append(((HolderDeviceBrightnessV2Binding)this.getBinding()).title.getText());
      var10.append(", ");
      var10.append(((HolderDeviceBrightnessV2Binding)this.getBinding()).progressText.getText());
      var7.setContentDescription((CharSequence)var10.toString());
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (!this.inTouch) {
         if (var1 instanceof HasBrightness) {
            this.update(var1, ((HasBrightness)var1).getBrightness());
         }

         if (!var2 && var1.isOnline() && !DeviceKt.isStandByOn(var1)) {
            HolderDeviceBrightnessV2Binding var12 = (HolderDeviceBrightnessV2Binding)this.getBinding();
            var12.clickView.setEnabled(true);
            var12.expendSwitch.setEnabled(true);
            var12.getRoot().setBackgroundTintList((ColorStateList)null);
            var12.leadingIcon.setImageResource(R.drawable.ic_brightness);
            var12.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            if (var1 instanceof HasMainMode) {
               var1 = var1;
               if (var1.isInMainMode(MainMode.AirPurify)) {
                  ApSubMode var7 = var1.apSubMode();
                  int var3 = DeviceBrightnessV2Holder.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
                  if (var3 != 1) {
                     if (var3 != 2) {
                        SwitchCompat var8 = var12.expendSwitch;
                        Intrinsics.checkNotNullExpressionValue(var8, "expendSwitch");
                        ViewExtensionsKt.show((View)var8, true);
                     } else {
                        var12.clickView.setEnabled(false);
                        SwitchCompat var9 = var12.expendSwitch;
                        Intrinsics.checkNotNullExpressionValue(var9, "expendSwitch");
                        ViewExtensionsKt.show((View)var9, false);
                        var12.expendSwitch.setChecked(true);
                        var12.progressText.setText(R.string.night);
                     }
                  } else {
                     var12.clickView.setEnabled(false);
                     SwitchCompat var10 = var12.expendSwitch;
                     Intrinsics.checkNotNullExpressionValue(var10, "expendSwitch");
                     ViewExtensionsKt.show((View)var10, false);
                     var12.expendSwitch.setChecked(true);
                     var12.progressText.setText(R.string.eco);
                  }
               }
            }
         } else {
            HolderDeviceBrightnessV2Binding var5 = (HolderDeviceBrightnessV2Binding)this.getBinding();
            var5.clickView.setEnabled(false);
            var5.expendSwitch.setEnabled(false);
            var5.expendSwitch.setChecked(true);
            SwitchCompat var4 = var5.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var4, "expendSwitch");
            ViewExtensionsKt.show((View)var4, true);
            var5.getRoot().setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_5)));
            var5.leadingIcon.setImageResource(R.drawable.ic_brightness_disabled);
            var5.title.setTextColor(this.getColor(R.color.surface_dark_55));
            var5.progressText.setText((CharSequence)"");
         }

         View var11 = ((HolderDeviceBrightnessV2Binding)this.getBinding()).clickView;
         StringBuilder var13 = new StringBuilder();
         var13.append(((HolderDeviceBrightnessV2Binding)this.getBinding()).title.getText());
         var13.append(", ");
         var13.append(((HolderDeviceBrightnessV2Binding)this.getBinding()).progressText.getText());
         var11.setContentDescription((CharSequence)var13.toString());
      }
   }

   @Metadata(
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceBrightnessV2Holder;", "parentView", "Landroid/view/ViewGroup;", "isInSchedule", "", "onBrightnessSetListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "brightness", "", "devicedetails_otherRelease"},
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

      public final DeviceBrightnessV2Holder newInstance(ViewGroup var1, boolean var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onBrightnessSetListener");
         HolderDeviceBrightnessV2Binding var4 = HolderDeviceBrightnessV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceBrightnessV2Holder(var4, var2, var3);
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.ECO.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ApSubMode.NIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
