package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;
import com.dd.ShadowLayout;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/blueair/viewcore/view/ShadowedRecyclerViewLayout;", "Lcom/dd/ShadowLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "backgroundLayout", "Landroid/widget/FrameLayout;", "getBackgroundLayout", "()Landroid/widget/FrameLayout;", "initViews", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ShadowedRecyclerViewLayout.kt */
public final class ShadowedRecyclerViewLayout extends ShadowLayout {
    private final FrameLayout backgroundLayout;
    private final RecyclerView recyclerView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowedRecyclerViewLayout(Context context) {
        this(context, (AttributeSet) null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShadowedRecyclerViewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowedRecyclerViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.recyclerView = new RecyclerView(getContext());
        this.backgroundLayout = new FrameLayout(getContext());
        initViews(context, attributeSet);
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final FrameLayout getBackgroundLayout() {
        return this.backgroundLayout;
    }

    private final void initViews(Context context, AttributeSet attributeSet) {
        RecyclerView recyclerView2 = this.recyclerView;
        recyclerView2.setItemAnimator((RecyclerView.ItemAnimator) null);
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setOverScrollMode(2);
        recyclerView2.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        recyclerView2.setClipToOutline(true);
        MaterialDividerItemDecoration materialDividerItemDecoration = new MaterialDividerItemDecoration(context, 1);
        materialDividerItemDecoration.setDividerColorResource(context, R.color.surface_dark_10);
        materialDividerItemDecoration.setLastItemDecorated(false);
        recyclerView2.addItemDecoration(materialDividerItemDecoration);
        if (attributeSet != null) {
            int[] iArr = R.styleable.ShadowedRecyclerViewLayout;
            Intrinsics.checkNotNullExpressionValue(iArr, "ShadowedRecyclerViewLayout");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ShadowedRecyclerViewLayout_srvl_background, R.drawable.rounded_rectangle_white_r16_black5_stroke1);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShadowedRecyclerViewLayout_srvl_background_padding, MathKt.roundToInt(TypedValueCompat.dpToPx(1.0f, obtainStyledAttributes.getResources().getDisplayMetrics())));
            this.backgroundLayout.setBackgroundResource(resourceId);
            this.backgroundLayout.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            this.recyclerView.setBackgroundResource(resourceId);
            this.recyclerView.setBackgroundTintList(ColorStateList.valueOf(0));
            obtainStyledAttributes.recycle();
        }
        this.backgroundLayout.addView(this.recyclerView, new FrameLayout.LayoutParams(-1, -2));
        addView(this.backgroundLayout, new FrameLayout.LayoutParams(-1, -2));
    }
}
