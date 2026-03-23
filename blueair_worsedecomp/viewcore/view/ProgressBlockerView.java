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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u0018H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/viewcore/view/ProgressBlockerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "shouldBlock", "getShouldBlock", "()Z", "setShouldBlock", "(Z)V", "progressView", "Lcom/airbnb/lottie/LottieAnimationView;", "progressContainer", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setAnimationRawRes", "", "rawRes", "drawBlocking", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProgressBlockerView.kt */
public final class ProgressBlockerView extends FrameLayout {
    private final FrameLayout progressContainer;
    private final LottieAnimationView progressView;
    private boolean shouldBlock;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProgressBlockerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProgressBlockerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressBlockerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressBlockerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shouldBlock = true;
        ProgressBlockerBinding inflate = ProgressBlockerBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        LottieAnimationView lottieAnimationView = inflate.progressBar;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "progressBar");
        this.progressView = lottieAnimationView;
        FrameLayout frameLayout = inflate.progressContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "progressContainer");
        this.progressContainer = frameLayout;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBlockerView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            setShouldBlock(obtainStyledAttributes.getBoolean(R.styleable.ProgressBlockerView_blocking, true));
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBlockerView_progress_height, getResources().getDimensionPixelOffset(R.dimen.progress_width));
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ProgressBlockerView_progress_width, getResources().getDimensionPixelOffset(R.dimen.progress_width));
            if (dimensionPixelSize2 > 0 && dimensionPixelSize > 0) {
                lottieAnimationView.getLayoutParams().width = dimensionPixelSize2;
                lottieAnimationView.getLayoutParams().height = dimensionPixelSize;
            }
            ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
            layoutParams.width = dimensionPixelSize2;
            layoutParams.height = dimensionPixelSize;
            lottieAnimationView.setLayoutParams(layoutParams);
            frameLayout.setBackgroundColor(obtainStyledAttributes.getColor(R.styleable.ProgressBlockerView_progress_backgroundColor, ResourcesCompat.getColor(getResources(), R.color.white_transparent, context.getTheme())));
            lottieAnimationView.setAnimation(obtainStyledAttributes.getResourceId(R.styleable.ProgressBlockerView_progress_anim, R.raw.loading_animation_blue));
            obtainStyledAttributes.recycle();
        }
    }

    public final boolean getShouldBlock() {
        return this.shouldBlock;
    }

    public final void setShouldBlock(boolean z) {
        this.shouldBlock = z;
        drawBlocking();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.shouldBlock || super.onTouchEvent(motionEvent);
    }

    public final void setAnimationRawRes(int i) {
        this.progressView.setAnimation(i);
    }

    private final void drawBlocking() {
        this.progressContainer.setBackgroundResource(this.shouldBlock ? R.color.white_transparent : R.color.transparent);
    }
}
