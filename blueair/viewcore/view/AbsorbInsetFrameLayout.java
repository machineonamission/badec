package com.blueair.viewcore.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0015J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000fH\u0016¨\u0006\u0010"},
   d2 = {"Lcom/blueair/viewcore/view/AbsorbInsetFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fitSystemWindows", "", "insets", "Landroid/graphics/Rect;", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AbsorbInsetFrameLayout extends FrameLayout {
   public AbsorbInsetFrameLayout(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public AbsorbInsetFrameLayout(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public AbsorbInsetFrameLayout(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
   }

   // $FF: synthetic method
   public AbsorbInsetFrameLayout(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   protected boolean fitSystemWindows(Rect var1) {
      Intrinsics.checkNotNullParameter(var1, "insets");
      var1.left = 0;
      var1.top = 0;
      var1.right = 0;
      return super.fitSystemWindows(var1);
   }

   public WindowInsets onApplyWindowInsets(WindowInsets var1) {
      Intrinsics.checkNotNullParameter(var1, "insets");
      var1 = super.onApplyWindowInsets(var1.replaceSystemWindowInsets(0, 0, 0, var1.getSystemWindowInsetBottom()));
      Intrinsics.checkNotNullExpressionValue(var1, "onApplyWindowInsets(...)");
      return var1;
   }
}
