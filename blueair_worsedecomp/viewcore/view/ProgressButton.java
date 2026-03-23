package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.res.ResourcesCompat;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.ProgressButtonBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/viewcore/view/ProgressButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoLoad", "", "getAutoLoad", "()Z", "setAutoLoad", "(Z)V", "currentlyLoading", "getCurrentlyLoading", "progressBar", "Landroid/widget/ProgressBar;", "imageView", "Landroid/widget/ImageView;", "performClick", "hideProgress", "", "showProgress", "shouldShowProgress", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProgressButton.kt */
public final class ProgressButton extends FrameLayout {
    private boolean autoLoad;
    private final ImageView imageView;
    private final ProgressBar progressBar;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.autoLoad = true;
        ProgressButtonBinding inflate = ProgressButtonBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ProgressBar progressBar2 = inflate.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar");
        this.progressBar = progressBar2;
        ImageView imageView2 = inflate.image;
        Intrinsics.checkNotNullExpressionValue(imageView2, "image");
        this.imageView = imageView2;
        if (attributeSet == null) {
            setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.btn_next_background, (Resources.Theme) null));
            imageView2.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.btn_next_foreground, (Resources.Theme) null));
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressButton, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.autoLoad = obtainStyledAttributes.getBoolean(R.styleable.ProgressButton_auto_progress, true);
        setBackground(ResourcesCompat.getDrawable(context.getResources(), obtainStyledAttributes.getResourceId(R.styleable.ProgressButton_button_background, R.drawable.btn_next_background), (Resources.Theme) null));
        imageView2.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), obtainStyledAttributes.getResourceId(R.styleable.ProgressButton_button_foreground, R.drawable.btn_next_foreground), (Resources.Theme) null));
        obtainStyledAttributes.recycle();
    }

    public final boolean getAutoLoad() {
        return this.autoLoad;
    }

    public final void setAutoLoad(boolean z) {
        this.autoLoad = z;
    }

    public final boolean getCurrentlyLoading() {
        return this.progressBar.getVisibility() == 0;
    }

    public boolean performClick() {
        if (getCurrentlyLoading()) {
            return false;
        }
        if (this.autoLoad) {
            showProgress$default(this, false, 1, (Object) null);
        }
        return super.performClick();
    }

    public final void hideProgress() {
        showProgress(false);
    }

    public static /* synthetic */ void showProgress$default(ProgressButton progressButton, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        progressButton.showProgress(z);
    }

    public final void showProgress(boolean z) {
        ViewExtensionsKt.show(this.imageView, !z);
        ViewExtensionsKt.show(this.progressBar, z);
    }
}
