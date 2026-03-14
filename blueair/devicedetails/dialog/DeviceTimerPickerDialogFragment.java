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
import com.blueair.devicedetails.databinding.DialogfragmentDeviceHTimerPickerBinding;
import com.blueair.viewcore.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onPickResult", "Lkotlin/Function1;", "", "", "getOnPickResult", "()Lkotlin/jvm/functions/Function1;", "setOnPickResult", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTimerPickerDialogFragment extends DialogFragment {
   private static final String ARG_CURRENT_INDEX = "ARG_CURRENT_INDEX";
   private static final String ARG_CYCLIC_ENABLED = "ARG_CYCLIC_ENABLED";
   private static final String ARG_TITLE = "ARG_TITLE";
   private static final String ARG_VALUE_LIST = "ARG_VALUE_LIST";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Function1 onPickResult;

   // $FF: synthetic method
   public static void $r8$lambda$g6tV_6mFeCJyGtZNM17rc2jWvFo/* $FF was: $r8$lambda$g6tV-6mFeCJyGtZNM17rc2jWvFo*/(DeviceTimerPickerDialogFragment var0, DialogfragmentDeviceHTimerPickerBinding var1, View var2) {
      onCreateView$lambda$5$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qhrbWN4nnqu6_0umuBQe1KgMq9A(DeviceTimerPickerDialogFragment var0, View var1) {
      onCreateView$lambda$5$lambda$1(var0, var1);
   }

   private static final void onCreateView$lambda$5$lambda$1(DeviceTimerPickerDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onCreateView$lambda$5$lambda$2(DeviceTimerPickerDialogFragment var0, DialogfragmentDeviceHTimerPickerBinding var1, View var2) {
      Function1 var3 = var0.onPickResult;
      if (var3 != null) {
         var3.invoke(var1.timerPicker.getCurrentPosition());
      }

      var0.dismiss();
   }

   public final Function1 getOnPickResult() {
      return this.onPickResult;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var9 = this.getDialog();
      if (var9 != null) {
         Window var10 = var9.getWindow();
         if (var10 != null) {
            var10.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
         }
      }

      DialogfragmentDeviceHTimerPickerBinding var8 = DialogfragmentDeviceHTimerPickerBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var8, "inflate(...)");
      var8.timerPickerCancel.setOnClickListener(new DeviceTimerPickerDialogFragment$$ExternalSyntheticLambda0(this));
      var8.timerPickerDone.setOnClickListener(new DeviceTimerPickerDialogFragment$$ExternalSyntheticLambda1(this, var8));
      Bundle var6 = this.requireArguments();
      ArrayList var11 = var6.getStringArrayList("ARG_VALUE_LIST");
      if (var11 != null) {
         List var12 = (List)var11;
         int var4 = var6.getInt("ARG_CURRENT_INDEX", 0);
         WheelView var5 = var8.timerPicker;
         var5.setData(var12);
         var5.scrollTo(var4);
         var5.setTypeface(ResourcesCompat.getFont(this.requireContext(), R.font.gilroy));
         var5.setCyclicEnabled(var6.getBoolean("ARG_CYCLIC_ENABLED"));
         var8.title.setText((CharSequence)var6.getString("ARG_TITLE"));
      }

      View var7 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      return var7;
   }

   public final void setOnPickResult(Function1 var1) {
      this.onPickResult = var1;
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceTimerPickerDialogFragment$Companion;", "", "<init>", "()V", "ARG_VALUE_LIST", "", "ARG_CURRENT_INDEX", "ARG_CYCLIC_ENABLED", "ARG_TITLE", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceTimerPickerDialogFragment;", "title", "valueList", "", "currentIndex", "", "cyclicEnabled", "", "devicedetails_otherRelease"},
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
      public static DeviceTimerPickerDialogFragment newInstance$default(Companion var0, String var1, List var2, int var3, boolean var4, int var5, Object var6) {
         if ((var5 & 8) != 0) {
            var4 = true;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceTimerPickerDialogFragment newInstance(String var1, List var2, int var3, boolean var4) {
         Intrinsics.checkNotNullParameter(var1, "title");
         Intrinsics.checkNotNullParameter(var2, "valueList");
         DeviceTimerPickerDialogFragment var5 = new DeviceTimerPickerDialogFragment();
         var5.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_TITLE", var1), TuplesKt.to("ARG_VALUE_LIST", var2), TuplesKt.to("ARG_CURRENT_INDEX", var3), TuplesKt.to("ARG_CYCLIC_ENABLED", var4)}));
         return var5;
      }
   }
}
