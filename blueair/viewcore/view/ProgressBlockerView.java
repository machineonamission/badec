package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.ProgressBlockerBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u0018H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/blueair/viewcore/view/ProgressBlockerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "shouldBlock", "getShouldBlock", "()Z", "setShouldBlock", "(Z)V", "progressView", "Lcom/airbnb/lottie/LottieAnimationView;", "progressContainer", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setAnimationRawRes", "", "rawRes", "drawBlocking", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProgressBlockerView extends FrameLayout {
   private final FrameLayout progressContainer;
   private final LottieAnimationView progressView;
   private boolean shouldBlock;

   public ProgressBlockerView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public ProgressBlockerView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public ProgressBlockerView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.shouldBlock = true;
      ProgressBlockerBinding var6 = ProgressBlockerBinding.inflate(LayoutInflater.from(var1), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      LottieAnimationView var5 = var6.progressBar;
      Intrinsics.checkNotNullExpressionValue(var5, "progressBar");
      this.progressView = var5;
      FrameLayout var10 = var6.progressContainer;
      Intrinsics.checkNotNullExpressionValue(var10, "progressContainer");
      this.progressContainer = var10;
      if (var2 != null) {
         TypedArray var7 = var1.obtainStyledAttributes(var2, R.styleable.ProgressBlockerView, 0, 0);
         Intrinsics.checkNotNullExpressionValue(var7, "obtainStyledAttributes(...)");
         this.setShouldBlock(var7.getBoolean(R.styleable.ProgressBlockerView_blocking, true));
         var3 = var7.getDimensionPixelSize(R.styleable.ProgressBlockerView_progress_height, this.getResources().getDimensionPixelOffset(R.dimen.progress_width));
         int var4 = var7.getDimensionPixelSize(R.styleable.ProgressBlockerView_progress_width, this.getResources().getDimensionPixelOffset(R.dimen.progress_width));
         if (var4 > 0 && var3 > 0) {
            var5.getLayoutParams().width = var4;
            var5.getLayoutParams().height = var3;
         }

         ViewGroup.LayoutParams var8 = var5.getLayoutParams();
         var8.width = var4;
         var8.height = var3;
         var5.setLayoutParams(var8);
         var10.setBackgroundColor(var7.getColor(R.styleable.ProgressBlockerView_progress_backgroundColor, ResourcesCompat.getColor(this.getResources(), R.color.white_transparent, var1.getTheme())));
         var5.setAnimation(var7.getResourceId(R.styleable.ProgressBlockerView_progress_anim, R.raw.loading_animation_blue));
         var7.recycle();
      }

   }

   // $FF: synthetic method
   public ProgressBlockerView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   private final void drawBlocking() {
      FrameLayout var2 = this.progressContainer;
      int var1;
      if (this.shouldBlock) {
         var1 = R.color.white_transparent;
      } else {
         var1 = R.color.transparent;
      }

      var2.setBackgroundResource(var1);
   }

   public final boolean getShouldBlock() {
      return this.shouldBlock;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.shouldBlock || super.onTouchEvent(var1);
   }

   public final void setAnimationRawRes(int var1) {
      this.progressView.setAnimation(var1);
   }

   public final void setShouldBlock(boolean var1) {
      this.shouldBlock = var1;
      this.drawBlocking();
   }
}
