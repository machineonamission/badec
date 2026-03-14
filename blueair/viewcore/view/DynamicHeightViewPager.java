package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\r"},
   d2 = {"Lcom/blueair/viewcore/view/DynamicHeightViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DynamicHeightViewPager extends ViewPager {
   public DynamicHeightViewPager(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 2, (DefaultConstructorMarker)null);
   }

   public DynamicHeightViewPager(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2);
   }

   // $FF: synthetic method
   public DynamicHeightViewPager(Context var1, AttributeSet var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   protected void onMeasure(int var1, int var2) {
      int var7 = this.getChildCount();
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var5 < var7; var3 = var4) {
         View var8 = this.getChildAt(var5);
         var8.measure(var1, MeasureSpec.makeMeasureSpec(0, 0));
         int var6 = var8.getMeasuredHeight();
         var4 = var3;
         if (var6 > var3) {
            var4 = var6;
         }

         ++var5;
      }

      if (var3 != 0) {
         var2 = MeasureSpec.makeMeasureSpec(var3, 1073741824);
      }

      super.onMeasure(var1, var2);
   }
}
