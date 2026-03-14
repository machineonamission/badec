package com.blueair.viewcore.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.TypedValueCompat;
import com.blueair.core.model.OscillationDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018H\u0002J\u0016\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u0015H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006-"},
   d2 = {"Lcom/blueair/viewcore/view/FanView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaint", "Landroid/graphics/Paint;", "normalColorArray", "", "disableColorArray", "bgColorArray", "ringPaint", "mAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "mCurrentStartAngle", "", "mCurrentSweepAngle", "_isInAttribute", "", "value", "isInAttribute", "()Z", "setInAttribute", "(Z)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawRing", "backgroundMode", "animateFanAngles", "sweepAngle", "direction", "Lcom/blueair/core/model/OscillationDirection;", "newStartAngle", "newSweepAngle", "normalizeAngle", "angle", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FanView extends View {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private boolean _isInAttribute;
   private final int[] bgColorArray;
   private final int[] disableColorArray;
   private final ValueAnimator mAnimator;
   private float mCurrentStartAngle;
   private float mCurrentSweepAngle;
   private final Paint mPaint;
   private final int[] normalColorArray;
   private final Paint ringPaint;

   // $FF: synthetic method
   public static void $r8$lambda$De0SB5WBBdIiKeeT3ZRgFzFTIjE(FanView var0, float var1, float var2, ValueAnimator var3) {
      animateFanAngles$lambda$2(var0, var1, var2, var3);
   }

   public FanView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public FanView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public FanView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      Paint var8 = new Paint();
      this.mPaint = var8;
      Paint var5 = new Paint(1);
      var5.setColor(-16776961);
      var5.setStyle(Style.STROKE);
      this.ringPaint = var5;
      ValueAnimator var6 = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
      var6.setDuration(1000L);
      var6.setInterpolator((TimeInterpolator)(new AccelerateDecelerateInterpolator()));
      this.mAnimator = var6;
      this.mCurrentStartAngle = 275.0F;
      var8.setStyle(Style.FILL);
      var5.setStrokeWidth(TypedValueCompat.dpToPx(24.0F, this.getResources().getDisplayMetrics()));
      int var4 = Color.parseColor("#002855");
      var3 = Color.parseColor("#000720");
      Companion var7 = Companion;
      this.bgColorArray = new int[]{var7.withAlpha(var4, 0.06F), var7.withAlpha(var4, 0.04F), var7.withAlpha(var4, 0.02F)};
      this.normalColorArray = new int[]{var7.withAlpha(var4, 0.4F), var7.withAlpha(var4, 0.3F), var7.withAlpha(var4, 0.2F)};
      this.disableColorArray = new int[]{var7.withAlpha(var3, 0.06F), var7.withAlpha(var4, 0.03F), var7.withAlpha(var4, 0.01F)};
   }

   // $FF: synthetic method
   public FanView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   private final void animateFanAngles(float var1, float var2) {
      if (this.normalizeAngle(var1) != this.normalizeAngle(this.mCurrentStartAngle) || var2 != this.mCurrentSweepAngle) {
         if (this._isInAttribute) {
            this.mCurrentStartAngle = var1;
            this.mCurrentSweepAngle = var2;
            this.invalidate();
         } else {
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.addUpdateListener(new FanView$$ExternalSyntheticLambda0(this, var1, var2));
            this.mAnimator.start();
         }
      }
   }

   private static final void animateFanAngles$lambda$2(FanView var0, float var1, float var2, ValueAnimator var3) {
      Intrinsics.checkNotNullParameter(var3, "animation");
      Companion var5 = (Companion)var3.getAnimatedValue();
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type kotlin.Float");
      float var4 = (Float)var5;
      var5 = Companion;
      var0.mCurrentStartAngle = var5.lerp(var0.mCurrentStartAngle, var1, var4);
      var0.mCurrentSweepAngle = var5.lerp(var0.mCurrentSweepAngle, var2, var4);
      var0.invalidate();
   }

   private final void drawRing(Canvas var1, boolean var2) {
      int var13 = this.getWidth() / 2;
      int var12 = this.getHeight() / 2;
      float var8 = this.ringPaint.getStrokeWidth();
      float var7 = (float)Math.min(var13, var12);
      float var6 = (float)3;
      float var5 = var8 / (float)2;
      float var3 = this.mCurrentStartAngle;
      float var4 = this.mCurrentSweepAngle;
      int[] var14;
      if (this.isEnabled()) {
         var14 = this.normalColorArray;
      } else {
         var14 = this.disableColorArray;
      }

      if (var2) {
         var14 = this.bgColorArray;
         var3 = 275.0F;
         var4 = 350.0F;
      }

      for(IndexedValue var15 : ArraysKt.withIndex(var14)) {
         this.ringPaint.setColor(((Number)var15.getValue()).intValue());
         float var11 = (float)var15.getIndex() * var8 + var7 - var6 * var8 + var5;
         float var9 = (float)var13;
         float var10 = (float)var12;
         var1.drawArc(var9 - var11, var10 - var11, var9 + var11, var10 + var11, var3, var4, false, this.ringPaint);
      }

   }

   private final float normalizeAngle(float var1) {
      float var2 = (float)360;
      return (var1 + var2) % var2;
   }

   public final void animateFanAngles(int var1, OscillationDirection var2) {
      Intrinsics.checkNotNullParameter(var2, "direction");
      int var3 = FanView.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            if (var1 > 90) {
               var3 = 265 - var1;
            } else {
               var3 = 180 - var1 / 2;
            }
         } else if (var1 > 90) {
            var3 = -85;
         } else {
            var3 = 0 - var1 / 2;
         }
      } else {
         var3 = 90 - var1 / 2;
      }

      this.animateFanAngles((float)var3, (float)var1);
   }

   public final boolean isInAttribute() {
      return this._isInAttribute;
   }

   protected void onDraw(Canvas var1) {
      Intrinsics.checkNotNullParameter(var1, "canvas");
      super.onDraw(var1);
      this.drawRing(var1, true);
      this.drawRing(var1, false);
   }

   public final void setInAttribute(boolean var1) {
      this._isInAttribute = var1;
      if (var1) {
         this.ringPaint.setStrokeWidth(TypedValueCompat.dpToPx(20.0F, this.getResources().getDisplayMetrics()));
      } else {
         this.ringPaint.setStrokeWidth(TypedValueCompat.dpToPx(24.0F, this.getResources().getDisplayMetrics()));
      }

      this.invalidate();
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u0012\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005¨\u0006\f"},
      d2 = {"Lcom/blueair/viewcore/view/FanView$Companion;", "", "<init>", "()V", "lerp", "", "start", "end", "fraction", "withAlpha", "", "alphaPercent", "viewcore_otherRelease"},
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

      public final float lerp(float var1, float var2, float var3) {
         return var1 + var3 * (var2 - var1);
      }

      public final int withAlpha(int var1, float var2) {
         return ColorUtils.setAlphaComponent(var1, (int)((float)255 * var2));
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
         int[] var0 = new int[OscillationDirection.values().length];

         try {
            var0[OscillationDirection.STRAIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[OscillationDirection.RIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[OscillationDirection.LEFT.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
