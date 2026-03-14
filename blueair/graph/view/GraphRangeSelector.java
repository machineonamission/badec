package com.blueair.graph.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.SimpleDatapoint;
import com.blueair.graph.databinding.RangeSelectBinding;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.GraphUtils;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eJ\u0010\u0010/\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0006\u00100\u001a\u00020)J\u000e\u00101\u001a\u00020)2\u0006\u0010.\u001a\u00020\u000eR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b%\u0010'¨\u00062"},
   d2 = {"Lcom/blueair/graph/view/GraphRangeSelector;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_liveScale", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blueair/graph/utils/ChartTimeScale;", "liveScale", "Landroidx/lifecycle/LiveData;", "getLiveScale", "()Landroidx/lifecycle/LiveData;", "binding", "Lcom/blueair/graph/databinding/RangeSelectBinding;", "timeButton", "Lcom/google/android/material/button/MaterialButton;", "getTimeButton", "()Lcom/google/android/material/button/MaterialButton;", "rangeDay", "getRangeDay", "rangeWeek", "getRangeWeek", "rangeMonth", "getRangeMonth", "rangeClose", "getRangeClose", "rangeSelectLayout", "Landroid/view/View;", "getRangeSelectLayout", "()Landroid/view/View;", "isExpanded", "", "()Z", "reset", "", "updateTime", "point", "Lcom/blueair/core/model/SimpleDatapoint;", "updateTimeScale", "timeScale", "updateScale", "hideRangeSelector", "showRangeSelector", "graph_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GraphRangeSelector extends FrameLayout {
   private final MutableLiveData _liveScale;
   private final RangeSelectBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$4TZXCRA0KZowNt4dZaqIYTcg9yk(GraphRangeSelector var0, View var1) {
      _init_$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$79kOM99mFcB_TP2dtXObNDhSNCg(GraphRangeSelector var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$PcMBVpVaLTrWOmyNgXoKGrFlNag(GraphRangeSelector var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$WcQQAQpszYP0JCjYEJXUmWj99B4(GraphRangeSelector var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$wxcaF0s9jkX_RDgUuFyBQatbiLY/* $FF was: $r8$lambda$wxcaF0s9jkX-RDgUuFyBQatbiLY*/(GraphRangeSelector var0, ChartTimeScale var1, View var2) {
      updateTimeScale$lambda$4(var0, var1, var2);
   }

   public GraphRangeSelector(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      this._liveScale = new MutableLiveData();
      RangeSelectBinding var2 = RangeSelectBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      this.binding = var2;
      this.reset();
      this.getRangeMonth().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda0(this));
      this.getRangeWeek().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda1(this));
      this.getRangeDay().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda2(this));
      this.getRangeClose().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda3(this));
      this.getTimeButton().setAccessibilityDelegate(new View.AccessibilityDelegate() {
         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            CharSequence var3 = var1.getResources().getText(R.string.show_range_selector_action_description);
            Intrinsics.checkNotNullExpressionValue(var3, "getText(...)");
            var2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, var3));
         }
      });
   }

   public GraphRangeSelector(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      this._liveScale = new MutableLiveData();
      RangeSelectBinding var3 = RangeSelectBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      this.reset();
      this.getRangeMonth().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda0(this));
      this.getRangeWeek().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda1(this));
      this.getRangeDay().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda2(this));
      this.getRangeClose().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda3(this));
      this.getTimeButton().setAccessibilityDelegate(new View.AccessibilityDelegate() {
         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            CharSequence var3 = var1.getResources().getText(R.string.show_range_selector_action_description);
            Intrinsics.checkNotNullExpressionValue(var3, "getText(...)");
            var2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, var3));
         }
      });
   }

   public GraphRangeSelector(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this._liveScale = new MutableLiveData();
      RangeSelectBinding var4 = RangeSelectBinding.inflate(LayoutInflater.from(this.getContext()), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      this.reset();
      this.getRangeMonth().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda0(this));
      this.getRangeWeek().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda1(this));
      this.getRangeDay().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda2(this));
      this.getRangeClose().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda3(this));
      this.getTimeButton().setAccessibilityDelegate(new View.AccessibilityDelegate() {
         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            CharSequence var3 = var1.getResources().getText(R.string.show_range_selector_action_description);
            Intrinsics.checkNotNullExpressionValue(var3, "getText(...)");
            var2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, var3));
         }
      });
   }

   private static final void _init_$lambda$0(GraphRangeSelector var0, View var1) {
      var0.updateScale(ChartTimeScale.MONTH);
      var0.hideRangeSelector();
   }

   private static final void _init_$lambda$1(GraphRangeSelector var0, View var1) {
      var0.updateScale(ChartTimeScale.WEEK);
      var0.hideRangeSelector();
   }

   private static final void _init_$lambda$2(GraphRangeSelector var0, View var1) {
      var0.updateScale(ChartTimeScale.DAY);
      var0.hideRangeSelector();
   }

   private static final void _init_$lambda$3(GraphRangeSelector var0, View var1) {
      var0.hideRangeSelector();
   }

   private final void updateScale(ChartTimeScale var1) {
      this._liveScale.postValue(var1);
   }

   private static final void updateTimeScale$lambda$4(GraphRangeSelector var0, ChartTimeScale var1, View var2) {
      var0.showRangeSelector(var1);
   }

   public final LiveData getLiveScale() {
      return (LiveData)this._liveScale;
   }

   public final MaterialButton getRangeClose() {
      MaterialButton var1 = this.binding.rangeClose;
      Intrinsics.checkNotNullExpressionValue(var1, "rangeClose");
      return var1;
   }

   public final MaterialButton getRangeDay() {
      MaterialButton var1 = this.binding.rangeDay;
      Intrinsics.checkNotNullExpressionValue(var1, "rangeDay");
      return var1;
   }

   public final MaterialButton getRangeMonth() {
      MaterialButton var1 = this.binding.rangeMonth;
      Intrinsics.checkNotNullExpressionValue(var1, "rangeMonth");
      return var1;
   }

   public final View getRangeSelectLayout() {
      ConstraintLayout var1 = this.binding.rangeSelectLayout;
      Intrinsics.checkNotNullExpressionValue(var1, "rangeSelectLayout");
      return (View)var1;
   }

   public final MaterialButton getRangeWeek() {
      MaterialButton var1 = this.binding.rangeWeek;
      Intrinsics.checkNotNullExpressionValue(var1, "rangeWeek");
      return var1;
   }

   public final MaterialButton getTimeButton() {
      MaterialButton var1 = this.binding.timeButton;
      Intrinsics.checkNotNullExpressionValue(var1, "timeButton");
      return var1;
   }

   public final void hideRangeSelector() {
      this.getRangeSelectLayout().setVisibility(4);
      this.getTimeButton().setVisibility(0);
   }

   public final boolean isExpanded() {
      return this.getRangeSelectLayout().getVisibility() == 0;
   }

   public final void reset() {
      MaterialButton var4 = this.getTimeButton();
      GraphUtils var3 = GraphUtils.INSTANCE;
      long var1 = System.currentTimeMillis();
      Context var5 = this.getContext();
      Intrinsics.checkNotNullExpressionValue(var5, "getContext(...)");
      var4.setText((CharSequence)GraphUtils.getStringDate$default(var3, var1, var5, false, 4, (Object)null));
      if (this.isExpanded()) {
         this.hideRangeSelector();
      }

   }

   public final void showRangeSelector(ChartTimeScale var1) {
      Intrinsics.checkNotNullParameter(var1, "timeScale");
      this.getTimeButton().setVisibility(4);
      byte var4;
      if (GraphRangeSelector.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 1) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      byte var3;
      if (GraphRangeSelector.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 2) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      byte var2;
      if (GraphRangeSelector.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()] == 3) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.getRangeMonth().setTypeface((Typeface)null, var4);
      MaterialButton var6 = this.getRangeMonth();
      Resources var5 = this.getRangeMonth().getResources();
      if (var4 == 1) {
         var4 = R.dimen.text_small;
      } else {
         var4 = R.dimen.text_xsmall;
      }

      var6.setTextSize(0, var5.getDimension(var4));
      this.getRangeWeek().setTypeface((Typeface)null, var3);
      var6 = this.getRangeWeek();
      var5 = this.getRangeWeek().getResources();
      if (var3 == 1) {
         var3 = R.dimen.text_small;
      } else {
         var3 = R.dimen.text_xsmall;
      }

      var6.setTextSize(0, var5.getDimension(var3));
      this.getRangeDay().setTypeface((Typeface)null, var2);
      MaterialButton var13 = this.getRangeDay();
      Resources var8 = this.getRangeDay().getResources();
      if (var2 == 1) {
         var2 = R.dimen.text_small;
      } else {
         var2 = R.dimen.text_xsmall;
      }

      var13.setTextSize(0, var8.getDimension(var2));
      this.getRangeSelectLayout().setVisibility(0);
   }

   public final void updateTime(SimpleDatapoint var1) {
      Intrinsics.checkNotNullParameter(var1, "point");
      MaterialButton var5 = this.getTimeButton();
      GraphUtils var4 = GraphUtils.INSTANCE;
      long var2 = var1.getTimeInMillis();
      Context var6 = this.getContext();
      Intrinsics.checkNotNullExpressionValue(var6, "getContext(...)");
      var5.setText((CharSequence)GraphUtils.getStringDate$default(var4, var2, var6, false, 4, (Object)null));
      if (this.isExpanded()) {
         this.hideRangeSelector();
      }

   }

   public final void updateTimeScale(ChartTimeScale var1) {
      Intrinsics.checkNotNullParameter(var1, "timeScale");
      this.getTimeButton().setOnClickListener(new GraphRangeSelector$$ExternalSyntheticLambda4(this, var1));
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
         int[] var0 = new int[ChartTimeScale.values().length];

         try {
            var0[ChartTimeScale.MONTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ChartTimeScale.WEEK.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ChartTimeScale.DAY.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
