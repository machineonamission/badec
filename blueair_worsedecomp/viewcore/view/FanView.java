package com.blueair.viewcore.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.blueair.core.model.OscillationDirection;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0014J\u0018\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0002J\u0016\u0010*\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.J\u0016\u0010*\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/blueair/viewcore/view/FanView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaint", "Landroid/graphics/Paint;", "mRect", "Landroid/graphics/RectF;", "mAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "mCurrentStartAngle", "", "mCurrentSweepAngle", "startColor", "endColor", "mGradientColors", "", "mGradient", "Landroid/graphics/RadialGradient;", "_isInAttribute", "", "value", "isInAttribute", "()Z", "setInAttribute", "(Z)V", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "animateFanAngles", "newStartAngle", "newSweepAngle", "direction", "Lcom/blueair/core/model/OscillationDirection;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FanView.kt */
public final class FanView extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean _isInAttribute;
    private final int endColor;
    private final ValueAnimator mAnimator;
    private float mCurrentStartAngle;
    private float mCurrentSweepAngle;
    private RadialGradient mGradient;
    private int[] mGradientColors;
    private final Paint mPaint;
    private final RectF mRect;
    private int startColor;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FanView.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.OscillationDirection[] r0 = com.blueair.core.model.OscillationDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.STRAIGHT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.OscillationDirection r1 = com.blueair.core.model.OscillationDirection.LEFT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.view.FanView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FanView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FanView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mRect = new RectF();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnimator = ofFloat;
        this.mCurrentSweepAngle = 360.0f;
        this.startColor = -1;
        this.endColor = -1;
        paint.setStyle(Paint.Style.FILL);
    }

    public final boolean isInAttribute() {
        return this._isInAttribute;
    }

    public final void setInAttribute(boolean z) {
        int i;
        this._isInAttribute = z;
        if (z) {
            i = -1;
        } else {
            i = getContext().getColor(R.color.blue_green);
        }
        this.startColor = i;
        int blendARGB = ColorUtils.blendARGB(i, this.endColor, 0.25f);
        int blendARGB2 = ColorUtils.blendARGB(this.startColor, this.endColor, 0.5f);
        int blendARGB3 = ColorUtils.blendARGB(this.startColor, this.endColor, 0.75f);
        int i2 = this.endColor;
        this.mGradientColors = new int[]{blendARGB, blendARGB2, blendARGB3, i2, i2};
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = ((float) i) / 2.0f;
        float f2 = ((float) i2) / 2.0f;
        float min = Math.min(f, f2);
        int[] iArr = this.mGradientColors;
        if (iArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGradientColors");
            iArr = null;
        }
        RadialGradient radialGradient = new RadialGradient(f, f2, min, iArr, (float[]) null, Shader.TileMode.CLAMP);
        this.mGradient = radialGradient;
        this.mPaint.setShader(radialGradient);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        canvas.drawArc(this.mRect, this.mCurrentStartAngle, this.mCurrentSweepAngle, true, this.mPaint);
    }

    private final void animateFanAngles(float f, float f2) {
        this.mAnimator.removeAllUpdateListeners();
        this.mAnimator.addUpdateListener(new FanView$$ExternalSyntheticLambda0(this, f, f2));
        this.mAnimator.start();
    }

    /* access modifiers changed from: private */
    public static final void animateFanAngles$lambda$1(FanView fanView, float f, float f2, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Companion companion = Companion;
        fanView.mCurrentStartAngle = companion.lerp(fanView.mCurrentStartAngle, f, floatValue);
        fanView.mCurrentSweepAngle = companion.lerp(fanView.mCurrentSweepAngle, f2, floatValue);
        fanView.invalidate();
    }

    public final void animateFanAngles(int i, OscillationDirection oscillationDirection) {
        Intrinsics.checkNotNullParameter(oscillationDirection, "direction");
        animateFanAngles((float) i, oscillationDirection);
    }

    public final void animateFanAngles(float f, OscillationDirection oscillationDirection) {
        float f2;
        float f3;
        float f4;
        Intrinsics.checkNotNullParameter(oscillationDirection, "direction");
        int i = WhenMappings.$EnumSwitchMapping$0[oscillationDirection.ordinal()];
        if (i == 1) {
            f3 = f / ((float) 2);
            f4 = (float) 90;
        } else if (i == 2) {
            f3 = Math.max(f / ((float) 2), f - ((float) 90));
            f4 = (float) (f > 90.0f ? 5 : 0);
        } else if (i == 3) {
            f2 = Math.min((f / ((float) 2)) + ((float) 180), 265.0f);
            animateFanAngles(f2, ((float) 360) - f);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        f2 = f3 + f4;
        animateFanAngles(f2, ((float) 360) - f);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/blueair/viewcore/view/FanView$Companion;", "", "<init>", "()V", "lerp", "", "start", "end", "fraction", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FanView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float lerp(float f, float f2, float f3) {
            return f + (f3 * (f2 - f));
        }

        private Companion() {
        }
    }
}
