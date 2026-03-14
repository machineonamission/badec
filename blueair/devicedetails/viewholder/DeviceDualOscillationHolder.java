package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.DualOscillationConfig;
import com.blueair.core.model.HasDualOscillation;
import com.blueair.core.model.OscillationMode;
import com.blueair.core.model.OscillationState;
import com.blueair.devicedetails.databinding.HolderDeviceDualOscillationBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bBY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDualOscillationHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceDualOscillationBinding;", "binding", "onCardClickListener", "Lkotlin/Function1;", "", "", "onSwingSwitchClickListener", "onLoopClickListener", "onLoopSwitchClickListener", "Lkotlin/Function0;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceDualOscillationBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "loopHintClosedBefore", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "closedBefore", "getAngleTextColor", "", "swing", "loop", "setOscillationEffect", "imageView", "Landroid/widget/ImageView;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceDualOscillationHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private boolean loopHintClosedBefore;
   private final Function1 onCardClickListener;
   private final Function1 onLoopClickListener;
   private final Function0 onLoopSwitchClickListener;
   private final Function1 onSwingSwitchClickListener;

   // $FF: synthetic method
   public static void $r8$lambda$_CKaQK3FwOWdob5F9VLCUeKKN9E/* $FF was: $r8$lambda$-CKaQK3FwOWdob5F9VLCUeKKN9E*/(HolderDeviceDualOscillationBinding var0, CompoundButton var1, boolean var2) {
      _init_$lambda$8(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$__E6xKvfstd7OJOXhN3zpPRg4Jg/* $FF was: $r8$lambda$-_E6xKvfstd7OJOXhN3zpPRg4Jg*/(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$41feyaaYRWuJWWMksdh2Sm_iY4U/* $FF was: $r8$lambda$41feyaaYRWuJWWMksdh2Sm-iY4U*/(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$7mZiOk_XMndzkQGLXqJi_KLAvk0/* $FF was: $r8$lambda$7mZiOk-XMndzkQGLXqJi-KLAvk0*/(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$CDyQN5wsftQ9MxbDceE1w6zUiJM(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$R4u5g3IEkgQ1nHhHdCBickLUb_0/* $FF was: $r8$lambda$R4u5g3IEkgQ1nHhHdCBickLUb-0*/(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$WJ3U_XgLYgrsuMlJi8nns2JUq6c(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$lcuL3I3sKvNlnR4V54BBnzg4f0k(DeviceDualOscillationHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$p3jHS_qRVY9DrlRC5QnpuH69VjA(HolderDeviceDualOscillationBinding var0, View var1) {
      _init_$lambda$7(var0, var1);
   }

   public DeviceDualOscillationHolder(HolderDeviceDualOscillationBinding var1, Function1 var2, Function1 var3, Function1 var4, Function0 var5) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onCardClickListener");
      Intrinsics.checkNotNullParameter(var3, "onSwingSwitchClickListener");
      Intrinsics.checkNotNullParameter(var4, "onLoopClickListener");
      Intrinsics.checkNotNullParameter(var5, "onLoopSwitchClickListener");
      super(var1);
      this.onCardClickListener = var2;
      this.onSwingSwitchClickListener = var3;
      this.onLoopClickListener = var4;
      this.onLoopSwitchClickListener = var5;
      var1.clHorizontal.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda0(this));
      var1.clVertical.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda1(this));
      var1.ivHorizontal.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda2(this));
      var1.ivVertical.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda3(this));
      var1.ivInfo.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda4(this));
      var1.hintLoop.btnCloseHint.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda5(this));
      var1.switchLoop.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda6(this));
      var1.clickView.setOnClickListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda7(var1));
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceDualOscillationHolder$$ExternalSyntheticLambda8(var1));
   }

   private static final void _init_$lambda$0(DeviceDualOscillationHolder var0, View var1) {
      var0.onCardClickListener.invoke(true);
   }

   private static final void _init_$lambda$1(DeviceDualOscillationHolder var0, View var1) {
      var0.onCardClickListener.invoke(false);
   }

   private static final void _init_$lambda$2(DeviceDualOscillationHolder var0, View var1) {
      var0.onSwingSwitchClickListener.invoke(true);
   }

   private static final void _init_$lambda$3(DeviceDualOscillationHolder var0, View var1) {
      var0.onSwingSwitchClickListener.invoke(false);
   }

   private static final void _init_$lambda$4(DeviceDualOscillationHolder var0, View var1) {
      var0.onLoopClickListener.invoke(false);
   }

   private static final void _init_$lambda$5(DeviceDualOscillationHolder var0, View var1) {
      var0.onLoopClickListener.invoke(true);
   }

   private static final void _init_$lambda$6(DeviceDualOscillationHolder var0, View var1) {
      var0.onLoopSwitchClickListener.invoke();
   }

   private static final void _init_$lambda$7(HolderDeviceDualOscillationBinding var0, View var1) {
      var0.expendSwitch.toggle();
   }

   private static final void _init_$lambda$8(HolderDeviceDualOscillationBinding var0, CompoundButton var1, boolean var2) {
      Group var3 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var3, "expendedContent");
      ViewExtensionsKt.show((View)var3, var2 ^ true);
   }

   private final int getAngleTextColor(boolean var1, boolean var2) {
      int var3;
      if (var2) {
         var3 = R.color.surface_dark_15;
      } else if (var1) {
         var3 = R.color.colorPrimaryText;
      } else {
         var3 = R.color.fill_grey;
      }

      return this.getColor(var3);
   }

   private final void setOscillationEffect(ImageView var1, boolean var2, boolean var3) {
      if (var2 && !var3) {
         var1.setBackgroundResource(R.drawable.bg_circle_primary);
         var1.setImageTintList(ColorStateList.valueOf(-1));
      } else {
         var1.setBackgroundResource(R.drawable.bg_circle_white_dart10_stroke1);
         ColorStateList var4;
         if (var3) {
            var4 = ColorStateList.valueOf(this.getColor(R.color.grey_200));
         } else {
            var4 = null;
         }

         var1.setImageTintList(var4);
      }

      var1.setEnabled(var3 ^ true);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasDualOscillation) {
         var1 = var1;
      } else {
         var1 = null;
      }

      if (var1 != null) {
         HolderDeviceDualOscillationBinding var5 = (HolderDeviceDualOscillationBinding)this.getBinding();
         DualOscillationConfig var6 = var1.getDualOscillationConfig();
         if (var6.getMode() == OscillationMode.LOOP) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var4;
         if (var6.getState(true) == OscillationState.SWING) {
            var4 = true;
         } else {
            var4 = false;
         }

         TextView var7 = var5.tvHorizontalAngle;
         String var9;
         if (var4 && !var2) {
            var9 = String.valueOf(var6.getCurAngle(true));
         } else {
            var9 = this.getString(R.string.off);
         }

         var7.setText((CharSequence)var9);
         var5.tvHorizontalAngle.setTextColor(this.getAngleTextColor(var4, var2));
         ImageView var10 = var5.ivHorizontal;
         Intrinsics.checkNotNullExpressionValue(var10, "ivHorizontal");
         this.setOscillationEffect(var10, var4, var2);
         if (var6.getState(false) == OscillationState.SWING) {
            var4 = true;
         } else {
            var4 = false;
         }

         var7 = var5.tvVerticalAngle;
         String var11;
         if (var4 && !var2) {
            var11 = String.valueOf(var6.getCurAngle(false));
         } else {
            var11 = this.getString(R.string.off);
         }

         var7.setText((CharSequence)var11);
         var5.tvVerticalAngle.setTextColor(this.getAngleTextColor(var4, var2));
         ImageView var12 = var5.ivVertical;
         Intrinsics.checkNotNullExpressionValue(var12, "ivVertical");
         this.setOscillationEffect(var12, var4, var2);
         var5.hintLoop.hintText.setText(R.string.oscillation_loop_hint);
         ConstraintLayout var13 = var5.hintLoop.getRoot();
         Intrinsics.checkNotNullExpressionValue(var13, "getRoot(...)");
         ViewExtensionsKt.show((View)var13, this.loopHintClosedBefore ^ true);
         var5.switchLoop.setCheckedSilence(var2);
         ((HolderDeviceDualOscillationBinding)this.getBinding()).clHorizontal.setEnabled(var2 ^ true);
         ((HolderDeviceDualOscillationBinding)this.getBinding()).clVertical.setEnabled(var2 ^ true);
         int var3;
         if (var2) {
            var3 = R.color.surface_dark_55;
         } else {
            var3 = R.color.colorPrimaryText;
         }

         var3 = this.getColor(var3);
         var5.tvHorizontal.setTextColor(var3);
         var5.tvVertical.setTextColor(var3);
      }

   }

   public final void update(Device var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.loopHintClosedBefore = var3;
      this.update(var1, var2);
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¨\u0006\u0010"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceDualOscillationHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceDualOscillationHolder;", "parentView", "Landroid/view/ViewGroup;", "onCardClickListener", "Lkotlin/Function1;", "", "", "onSwingSwitchClickListener", "onLoopInfoClickListener", "onLoopSwitchClickListener", "Lkotlin/Function0;", "devicedetails_otherRelease"},
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

      public final DeviceDualOscillationHolder newInstance(ViewGroup var1, Function1 var2, Function1 var3, Function1 var4, Function0 var5) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onCardClickListener");
         Intrinsics.checkNotNullParameter(var3, "onSwingSwitchClickListener");
         Intrinsics.checkNotNullParameter(var4, "onLoopInfoClickListener");
         Intrinsics.checkNotNullParameter(var5, "onLoopSwitchClickListener");
         HolderDeviceDualOscillationBinding var6 = HolderDeviceDualOscillationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
         return new DeviceDualOscillationHolder(var6, var2, var3, var4, var5);
      }
   }
}
