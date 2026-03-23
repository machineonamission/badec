package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/blueair/viewcore/view/QualityStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qualityTitle", "Landroid/widget/TextView;", "qualityValue", "qualityImage", "Landroid/widget/ImageView;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: QualityStatusView.kt */
public final class QualityStatusView extends ConstraintLayout {
    private final ImageView qualityImage;
    private final TextView qualityTitle;
    private final TextView qualityValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QualityStatusView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = ConstraintLayout.inflate(getContext(), R.layout.quality_status_view, this);
        View findViewById = inflate.findViewById(R.id.quality_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.qualityTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.quality_value);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.qualityValue = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.quality_status_image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.qualityImage = (ImageView) findViewById3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QualityStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        View inflate = ConstraintLayout.inflate(getContext(), R.layout.quality_status_view, this);
        View findViewById = inflate.findViewById(R.id.quality_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.qualityTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.quality_value);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.qualityValue = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.quality_status_image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.qualityImage = (ImageView) findViewById3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QualityStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        View inflate = ConstraintLayout.inflate(getContext(), R.layout.quality_status_view, this);
        View findViewById = inflate.findViewById(R.id.quality_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.qualityTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.quality_value);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.qualityValue = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.quality_status_image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.qualityImage = (ImageView) findViewById3;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QualityStatusView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        View inflate = ConstraintLayout.inflate(getContext(), R.layout.quality_status_view, this);
        View findViewById = inflate.findViewById(R.id.quality_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.qualityTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.quality_value);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.qualityValue = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.quality_status_image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.qualityImage = (ImageView) findViewById3;
    }
}
