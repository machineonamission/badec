package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceTimerPickerV2Binding;
import com.blueair.viewcore.R;
import com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.google.android.material.button.MaterialButton;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onPickResult", "Lkotlin/Function1;", "", "", "getOnPickResult", "()Lkotlin/jvm/functions/Function1;", "setOnPickResult", "(Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceTimerPickerV2Binding;", "getBinding", "()Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceTimerPickerV2Binding;", "setBinding", "(Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceTimerPickerV2Binding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTimerPickerV2DialogFragment extends DialogFragment {
   private static final String ARG_CYCLIC_ENABLED = "ARG_CYCLIC_ENABLED";
   private static final String ARG_MAX_HOUR = "ARG_MAX_HOUR";
   private static final String ARG_TIMER_SECOND = "ARG_TIMER_SECOND";
   private static final String ARG_TITLE = "ARG_TITLE";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public DialogfragmentDeviceTimerPickerV2Binding binding;
   private Function1 onPickResult;

   // $FF: synthetic method
   public static void $r8$lambda$1oRxL2cSLy32sjVhLOh_JbLiLbY/* $FF was: $r8$lambda$1oRxL2cSLy32sjVhLOh-JbLiLbY*/(DialogfragmentDeviceTimerPickerV2Binding var0, DeviceTimerPickerV2DialogFragment var1, View var2) {
      onCreateView$lambda$7$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static String $r8$lambda$MjCXsTwM1QGCX_siz0DGAep6FkU/* $FF was: $r8$lambda$MjCXsTwM1QGCX-siz0DGAep6FkU*/(Object var0) {
      return onCreateView$lambda$7$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$my1iVtEchfpe3ZLvneIoqfG9V_o(DeviceTimerPickerV2DialogFragment var0, View var1) {
      onCreateView$lambda$7$lambda$1(var0, var1);
   }

   private static final void onCreateView$lambda$7$lambda$1(DeviceTimerPickerV2DialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final String onCreateView$lambda$7$lambda$2(Object var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      if (var0 instanceof Integer) {
         String var1 = String.format("%02d", Arrays.copyOf(new Object[]{var0}, 1));
         Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
         return var1;
      } else {
         return String.valueOf(var0);
      }
   }

   private static final void onCreateView$lambda$7$lambda$6(DialogfragmentDeviceTimerPickerV2Binding var0, DeviceTimerPickerV2DialogFragment var1, View var2) {
      Integer var5 = (Integer)var0.wheelHour.getCurrentItem();
      Integer var3 = (Integer)var0.wheelMinute.getCurrentItem();
      if (var5 == null || var5 != 0 || var3 == null || var3 != 0) {
         Function1 var4 = var1.onPickResult;
         if (var4 != null) {
            var4.invoke(var5 * 3600 + var3 * 60);
         }

         var1.dismiss();
      }
   }

   public final DialogfragmentDeviceTimerPickerV2Binding getBinding() {
      DialogfragmentDeviceTimerPickerV2Binding var1 = this.binding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         return null;
      }
   }

   public final Function1 getOnPickResult() {
      return this.onPickResult;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var13 = this.getDialog();
      if (var13 != null) {
         Window var14 = var13.getWindow();
         if (var14 != null) {
            var14.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var14.setWindowAnimations(R.style.dialog_animation);
            var14.setGravity(80);
         }
      }

      DialogfragmentDeviceTimerPickerV2Binding var7 = DialogfragmentDeviceTimerPickerV2Binding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
      this.setBinding(var7);
      var7 = this.getBinding();
      var7.btnClose.setOnClickListener(new DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda0(this));
      DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1 var10 = new DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda1();
      var7.wheelHour.setFormatter(var10);
      var7.wheelMinute.setFormatter(var10);
      OnWheelChangedListener var15 = new OnWheelChangedListener(var7) {
         final DialogfragmentDeviceTimerPickerV2Binding $this_run;

         {
            this.$this_run = var1;
         }

         public void onWheelLoopFinished(WheelView var1) {
         }

         public void onWheelScrollStateChanged(WheelView var1, int var2) {
         }

         public void onWheelScrolled(WheelView var1, int var2) {
         }

         public void onWheelSelected(WheelView var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "view");
            Integer var4 = (Integer)this.$this_run.wheelMinute.getCurrentItem();
            Integer var5 = (Integer)this.$this_run.wheelHour.getCurrentItem();
            MaterialButton var6 = this.$this_run.btnDone;
            boolean var3;
            if (var4 != null && var4 == 0 && var5 != null && var5 == 0) {
               var3 = false;
            } else {
               var3 = true;
            }

            var6.setEnabled(var3);
         }
      };
      WheelView var11 = var7.wheelMinute;
      var15 = var15;
      var11.setOnWheelChangedListener(var15);
      var7.wheelHour.setOnWheelChangedListener(var15);
      Bundle var12 = this.getArguments();
      if (var12 != null) {
         int var4 = RangesKt.coerceAtLeast(var12.getInt("ARG_MAX_HOUR") - 1, 0);
         int var6 = var12.getInt("ARG_TIMER_SECOND");
         int var5 = var6 / 3600;
         var6 /= 60;
         var7.wheelHour.setData(CollectionsKt.toMutableList((Iterable)(new IntRange(0, var4))));
         var7.wheelHour.setDefaultValue(var5);
         var7.wheelMinute.setData(CollectionsKt.toMutableList((Iterable)(new IntRange(0, 59))));
         var7.wheelMinute.setDefaultValue(var6 - var5 * 60);
         WheelView var17 = var7.wheelHour;
         var17.setTypeface(ResourcesCompat.getFont(this.requireContext(), R.font.gilroy_medium));
         var17.setCyclicEnabled(var12.getBoolean("ARG_CYCLIC_ENABLED"));
         var17 = var7.wheelMinute;
         var17.setTypeface(ResourcesCompat.getFont(this.requireContext(), R.font.gilroy_medium));
         var17.setCyclicEnabled(var12.getBoolean("ARG_CYCLIC_ENABLED"));
         var7.title.setText((CharSequence)var12.getString("ARG_TITLE"));
      }

      var7.btnDone.setOnClickListener(new DeviceTimerPickerV2DialogFragment$$ExternalSyntheticLambda2(var7, this));
      View var9 = this.getBinding().getRoot();
      Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
      return var9;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -2);
         }
      }

   }

   public final void setBinding(DialogfragmentDeviceTimerPickerV2Binding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.binding = var1;
   }

   public final void setOnPickResult(Function1 var1) {
      this.onPickResult = var1;
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment$Companion;", "", "<init>", "()V", "ARG_TITLE", "", "ARG_MAX_HOUR", "ARG_TIMER_SECOND", "ARG_CYCLIC_ENABLED", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment;", "title", "maxHour", "", "timeSeconds", "cyclicEnabled", "", "devicedetails_otherRelease"},
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
      public static DeviceTimerPickerV2DialogFragment newInstance$default(Companion var0, String var1, int var2, int var3, boolean var4, int var5, Object var6) {
         if ((var5 & 8) != 0) {
            var4 = true;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceTimerPickerV2DialogFragment newInstance(String var1, int var2, int var3, boolean var4) {
         Intrinsics.checkNotNullParameter(var1, "title");
         DeviceTimerPickerV2DialogFragment var5 = new DeviceTimerPickerV2DialogFragment();
         var5.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_TITLE", var1), TuplesKt.to("ARG_MAX_HOUR", var2), TuplesKt.to("ARG_TIMER_SECOND", var3), TuplesKt.to("ARG_CYCLIC_ENABLED", var4)}));
         return var5;
      }
   }
}
