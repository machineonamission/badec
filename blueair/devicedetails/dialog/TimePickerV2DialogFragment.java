package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import com.blueair.devicedetails.databinding.DialogfragmentTimePickerV2Binding;
import com.blueair.devicedetails.view.CustomWheelView;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/dialog/TimePickerV2DialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentTimePickerV2Binding;", "getBinding", "()Lcom/blueair/devicedetails/databinding/DialogfragmentTimePickerV2Binding;", "setBinding", "(Lcom/blueair/devicedetails/databinding/DialogfragmentTimePickerV2Binding;)V", "is24HourFormat", "", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "adjustWheelTextSize", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TimePickerV2DialogFragment extends DialogFragment {
   private static final String ARG_CYCLIC_ENABLED = "ARG_CYCLIC_ENABLED";
   public static final String ARG_HOUR_OF_DAY = "ARG_HOUR_OF_DAY";
   public static final String ARG_MINUTE = "ARG_MINUTE";
   public static final String ARG_TIME_SECONDS = "ARG_TIME_SECONDS";
   private static final String ARG_TITLE = "ARG_TITLE";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String REQUEST_KEY = "TimePickerV2DialogFragment";
   public DialogfragmentTimePickerV2Binding binding;
   private Calendar calendar = Calendar.getInstance();
   private boolean is24HourFormat;

   // $FF: synthetic method
   public static void $r8$lambda$GQHAApZdpglqV7Td3Gx8wSaCK3E(TimePickerV2DialogFragment var0, DialogfragmentTimePickerV2Binding var1, View var2) {
      onViewCreated$lambda$8$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Q90IN_BSBtvdRFkxblyR75IhlY8/* $FF was: $r8$lambda$Q90IN-BSBtvdRFkxblyR75IhlY8*/(TimePickerV2DialogFragment var0) {
      onViewCreated$lambda$8$lambda$6(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$RZ2lTajIXuCYhGx0c1tTylwMdIA(TimePickerV2DialogFragment var0, View var1) {
      onViewCreated$lambda$8$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$lXbI1JSRS_JbqUBxG6Kxj_gwTms(Object var0) {
      return onViewCreated$lambda$8$lambda$2(var0);
   }

   private final void adjustWheelTextSize() {
      Paint var5 = new Paint(69);
      int var3 = this.getResources().getDisplayMetrics().widthPixels;
      if (this.is24HourFormat) {
         var3 /= 2;
      } else {
         var3 /= 3;
      }

      float var1 = TypedValueCompat.spToPx(64.0F, this.getResources().getDisplayMetrics());
      float var2 = TypedValueCompat.spToPx(2.0F, this.getResources().getDisplayMetrics());
      var5.setTextSize(var1);

      boolean var4;
      for(var4 = false; RangesKt.coerceAtLeast(var5.measureText("00..."), var5.measureText("88...")) > (float)var3; var4 = true) {
         var1 -= var2;
         var5.setTextSize(var1);
      }

      if (var4) {
         DialogfragmentTimePickerV2Binding var7 = this.getBinding();
         var7.wheelMinute.setTextSize(var1);
         var7.wheelHour.setTextSize(var1);
         var7.wheelAmPm.setTextSize(var1);
         var7.wheelMinute.setSelectedTextSize(var1);
         var7.wheelHour.setSelectedTextSize(var1);
         var7.wheelAmPm.setSelectedTextSize(var1);
         var7.tvColon.setTextSize(0, var1);
      }

   }

   private static final void onViewCreated$lambda$8$lambda$1(TimePickerV2DialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final String onViewCreated$lambda$8$lambda$2(Object var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      if (var0 instanceof Integer) {
         String var1 = String.format("%02d", Arrays.copyOf(new Object[]{var0}, 1));
         Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
         return var1;
      } else {
         return String.valueOf(var0);
      }
   }

   private static final void onViewCreated$lambda$8$lambda$6(TimePickerV2DialogFragment var0) {
      var0.adjustWheelTextSize();
   }

   private static final void onViewCreated$lambda$8$lambda$7(TimePickerV2DialogFragment var0, DialogfragmentTimePickerV2Binding var1, View var2) {
      var0.dismissAllowingStateLoss();
      Integer var6 = (Integer)var1.wheelHour.getCurrentItem();
      int var3;
      if (var6 != null) {
         var3 = var6;
      } else {
         var3 = 0;
      }

      var6 = (Integer)var1.wheelMinute.getCurrentItem();
      int var4;
      if (var6 != null) {
         var4 = var6;
      } else {
         var4 = 0;
      }

      var0.calendar.set(12, var4);
      if (var0.is24HourFormat) {
         var0.calendar.set(11, var3);
      } else {
         Calendar var8 = var0.calendar;
         int var5 = var3;
         if (var3 == 12) {
            var5 = 0;
         }

         var8.set(10, var5);
         var8 = var0.calendar;
         if (var1.wheelAmPm.getCurrentPosition() == 0) {
            var3 = 0;
         } else {
            var3 = 1;
         }

         var8.set(9, var3);
         var3 = var0.calendar.get(11);
      }

      FragmentKt.setFragmentResult((Fragment)var0, "TimePickerV2DialogFragment", BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_HOUR_OF_DAY", var3), TuplesKt.to("ARG_MINUTE", var4), TuplesKt.to("ARG_TIME_SECONDS", var3 * 3600 + var4 * 60)}));
   }

   public final DialogfragmentTimePickerV2Binding getBinding() {
      DialogfragmentTimePickerV2Binding var1 = this.binding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var6 = this.getDialog();
      if (var6 != null) {
         Window var7 = var6.getWindow();
         if (var7 != null) {
            var7.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var7.setWindowAnimations(R.style.dialog_animation);
            var7.setGravity(80);
         }
      }

      DialogfragmentTimePickerV2Binding var4 = DialogfragmentTimePickerV2Binding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.setBinding(var4);
      View var5 = this.getBinding().getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
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

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Context var6 = var1.getContext();
      this.is24HourFormat = DateFormat.is24HourFormat(var6);
      DialogfragmentTimePickerV2Binding var9 = this.getBinding();
      var9.btnClose.setOnClickListener(new TimePickerV2DialogFragment$$ExternalSyntheticLambda0(this));
      TimePickerV2DialogFragment$$ExternalSyntheticLambda1 var10 = new TimePickerV2DialogFragment$$ExternalSyntheticLambda1();
      var9.wheelHour.setFormatter(var10);
      var9.wheelMinute.setFormatter(var10);
      Bundle var11 = this.getArguments();
      if (var11 != null) {
         int var3 = var11.getInt("ARG_TIME_SECONDS");
         int var4 = var3 / 3600;
         int var5 = var3 / 60 - var4 * 60;
         this.calendar.set(11, var4);
         Calendar var7 = this.calendar;
         var3 = 12;
         var7.set(12, var5);
         if (this.is24HourFormat) {
            var9.wheelHour.setNewData(CollectionsKt.toList((Iterable)(new IntRange(0, 23))));
            var9.wheelHour.setDefaultValueReal(var4);
            CustomWheelView var16 = var9.wheelAmPm;
            Intrinsics.checkNotNullExpressionValue(var16, "wheelAmPm");
            ViewExtensionsKt.hide(var16);
         } else {
            var9.wheelHour.setNewData(CollectionsKt.toList((Iterable)(new IntRange(1, 12))));
            var4 = this.calendar.get(10);
            CustomWheelView var17 = var9.wheelHour;
            if (var4 != 0) {
               var3 = var4;
            }

            var17.setDefaultValueReal(var3);
            AppCompatTextView var18 = var9.tvHours;
            Intrinsics.checkNotNullExpressionValue(var18, "tvHours");
            ViewExtensionsKt.hide((View)var18);
            var18 = var9.tvMins;
            Intrinsics.checkNotNullExpressionValue(var18, "tvMins");
            ViewExtensionsKt.hide((View)var18);
            java.text.DateFormat var20 = java.text.DateFormat.getTimeInstance(3);
            Intrinsics.checkNotNull(var20, "null cannot be cast to non-null type java.text.SimpleDateFormat");
            DateFormatSymbols var8 = ((SimpleDateFormat)var20).getDateFormatSymbols();
            CustomWheelView var21 = var9.wheelAmPm;
            String[] var24 = var8.getAmPmStrings();
            Intrinsics.checkNotNullExpressionValue(var24, "getAmPmStrings(...)");
            var21.setNewData(ArraysKt.toList((Object[])var24));
            var9.wheelAmPm.setDefaultPositionReal(this.calendar.get(9));
            var3 = (int)TypedValueCompat.dpToPx(28.0F, var6.getResources().getDisplayMetrics());
            var9.ivScaleMaskLeft.setPadding(0, var3, 0, 0);
            var9.ivScaleMaskRight.setPadding(0, var3, 0, 0);
         }

         var9.wheelMinute.setNewData(CollectionsKt.toList((Iterable)(new IntRange(0, 59))));
         var9.wheelMinute.setDefaultValueReal(var5);
         Typeface var15 = TypefaceCompat.create(var6, ResourcesCompat.getFont(var6, R.font.gilroy), 500, false);
         Intrinsics.checkNotNullExpressionValue(var15, "create(...)");
         CustomWheelView var22 = var9.wheelHour;
         var22.setTypeface(var15);
         var22.setCyclicEnabled(var11.getBoolean("ARG_CYCLIC_ENABLED"));
         var22 = var9.wheelMinute;
         var22.setTypeface(var15);
         var22.setCyclicEnabled(var11.getBoolean("ARG_CYCLIC_ENABLED"));
         var9.wheelAmPm.setTypeface(var15);
         var9.title.setText((CharSequence)var11.getString("ARG_TITLE"));
      }

      var9.wheelMinute.post(new TimePickerV2DialogFragment$$ExternalSyntheticLambda2(this));
      var9.btnDone.setOnClickListener(new TimePickerV2DialogFragment$$ExternalSyntheticLambda3(this, var9));
   }

   public final void setBinding(DialogfragmentTimePickerV2Binding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.binding = var1;
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"},
      d2 = {"Lcom/blueair/devicedetails/dialog/TimePickerV2DialogFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ARG_HOUR_OF_DAY", "ARG_MINUTE", "ARG_TITLE", "ARG_TIME_SECONDS", "ARG_CYCLIC_ENABLED", "newInstance", "Lcom/blueair/devicedetails/dialog/TimePickerV2DialogFragment;", "title", "calendarTime", "Ljava/util/Calendar;", "cyclicEnabled", "", "secondsInDay", "", "devicedetails_otherRelease"},
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
      public static TimePickerV2DialogFragment newInstance$default(Companion var0, String var1, int var2, boolean var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = true;
         }

         return var0.newInstance(var1, var2, var3);
      }

      // $FF: synthetic method
      public static TimePickerV2DialogFragment newInstance$default(Companion var0, String var1, Calendar var2, boolean var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = true;
         }

         return var0.newInstance(var1, var2, var3);
      }

      public final TimePickerV2DialogFragment newInstance(String var1, int var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "title");
         TimePickerV2DialogFragment var4 = new TimePickerV2DialogFragment();
         var4.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("ARG_TITLE", var1), TuplesKt.to("ARG_TIME_SECONDS", var2), TuplesKt.to("ARG_CYCLIC_ENABLED", var3)}));
         return var4;
      }

      public final TimePickerV2DialogFragment newInstance(String var1, Calendar var2, boolean var3) {
         Intrinsics.checkNotNullParameter(var1, "title");
         Intrinsics.checkNotNullParameter(var2, "calendarTime");
         return this.newInstance(var1, var2.get(11) * 3600 + var2.get(12) * 60, var3);
      }
   }
}
