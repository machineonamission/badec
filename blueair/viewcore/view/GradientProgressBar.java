package com.blueair.viewcore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0014J\u001a\u0010$\u001a\u00020\u001c2\b\b\u0001\u0010%\u001a\u00020\u00072\b\b\u0001\u0010&\u001a\u00020\u0007R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"},
   d2 = {"Lcom/blueair/viewcore/view/GradientProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "max", "getMax", "()I", "setMax", "(I)V", "value", "progress", "getProgress", "setProgress", "startColor", "endColor", "trackColor", "paint", "Landroid/graphics/Paint;", "trackPaint", "rectF", "Landroid/graphics/RectF;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setGradientColors", "start", "end", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GradientProgressBar extends View {
   private int endColor;
   private int max;
   private final Paint paint;
   private int progress;
   private final RectF rectF;
   private int startColor;
   private int trackColor;
   private final Paint trackPaint;

   public GradientProgressBar(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public GradientProgressBar(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public GradientProgressBar(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.max = 100;
      this.startColor = Color.parseColor("#D7E5F4");
      this.endColor = Color.parseColor("#3B77BE");
      this.trackColor = Color.parseColor("#0D000720");
      this.paint = new Paint(1);
      Paint var4 = new Paint(1);
      var4.setColor(this.trackColor);
      var4.setStyle(Style.FILL);
      this.trackPaint = var4;
      this.rectF = new RectF();
   }

   // $FF: synthetic method
   public GradientProgressBar(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   public final int getMax() {
      return this.max;
   }

   public final int getProgress() {
      return this.progress;
   }

   protected void onDraw(Canvas var1) {
      Intrinsics.checkNotNullParameter(var1, "canvas");
      super.onDraw(var1);
      float var5 = (float)this.getWidth();
      float var4 = (float)this.getHeight();
      this.rectF.set(0.0F, 0.0F, var5, var4);
      float var2 = var4 / 2.0F;
      var1.drawRoundRect(this.rectF, var2, var2, this.trackPaint);
      float var3 = (float)this.getPaddingLeft();
      var2 = (float)this.getPaddingTop();
      float var6 = (float)this.getPaddingRight();
      var4 -= (float)this.getPaddingBottom();
      var6 = var5 - var6 - var3;
      var5 = var4 - var2;
      if (var6 > 0.0F && var5 > 0.0F) {
         var6 *= (float)this.progress / (float)this.max;
         if (var6 > 0.0F) {
            this.rectF.set(var3, var2, var6 + var3, var4);
            var2 = var5 / 2.0F;
            var1.drawRoundRect(this.rectF, var2, var2, this.paint);
         }
      }

   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      LinearGradient var5 = new LinearGradient((float)this.getPaddingLeft(), 0.0F, (float)var1 - (float)this.getPaddingRight(), 0.0F, this.startColor, this.endColor, TileMode.CLAMP);
      this.paint.setShader((Shader)var5);
   }

   public final void setGradientColors(int var1, int var2) {
      this.startColor = var1;
      this.endColor = var2;
      if (this.getWidth() > 0) {
         this.onSizeChanged(this.getWidth(), this.getHeight(), this.getWidth(), this.getHeight());
         this.invalidate();
      }

   }

   public final void setMax(int var1) {
      this.max = var1;
   }

   public final void setProgress(int var1) {
      if (this.progress != var1) {
         this.progress = RangesKt.coerceIn(var1, 0, this.max);
         this.invalidate();
      }

   }
}
