package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¨\u0006\u000f"},
   d2 = {"Lcom/blueair/viewcore/view/SimpleStatusBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "statusBarHeight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleStatusBar extends View {
   public SimpleStatusBar(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public SimpleStatusBar(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public SimpleStatusBar(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
   }

   // $FF: synthetic method
   public SimpleStatusBar(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   private final int statusBarHeight() {
      int var1 = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
      return var1 > 0 ? this.getResources().getDimensionPixelSize(var1) : (int)TypedValue.applyDimension(1, 40.0F, this.getResources().getDisplayMetrics());
   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(MeasureSpec.getSize(var1), this.statusBarHeight());
   }
}
