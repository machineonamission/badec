package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/blueair/viewcore/view/SimpleIconTextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "setIcon", "", "drawable", "Landroid/graphics/drawable/Drawable;", "setIconResource", "resId", "setIconSize", "width", "height", "setText", "text", "", "hideText", "setTextSize", "size", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleIconTextView.kt */
public final class SimpleIconTextView extends LinearLayout {
    private final ImageView imageView;
    private final TextView textView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleIconTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleIconTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleIconTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleIconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(16);
        ImageView imageView2 = new ImageView(context);
        this.imageView = imageView2;
        View inflate = LayoutInflater.from(context).inflate(R.layout.simple_text_with_family_weight500, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) inflate;
        this.textView = textView2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleIconTextView, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.SimpleIconTextView_iconDrawable);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleIconTextView_iconSize, -1);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleIconTextView_iconWidth, -2);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleIconTextView_iconHeight, -2);
        String string = obtainStyledAttributes.getString(R.styleable.SimpleIconTextView_android_text);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SimpleIconTextView_android_textSize, 0.0f);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SimpleIconTextView_android_textColor);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SimpleIconTextView_spacing, 0);
        obtainStyledAttributes.recycle();
        imageView2.setImageDrawable(drawable);
        if (dimensionPixelSize != -1) {
            setIconSize(dimensionPixelSize, dimensionPixelSize);
        } else {
            setIconSize(dimensionPixelSize2, dimensionPixelSize3);
        }
        if (dimensionPixelSize4 != 0) {
            if (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            marginLayoutParams.setMarginStart(dimensionPixelSize4);
            textView2.setLayoutParams(marginLayoutParams);
        }
        setText(string);
        if (dimension != 0.0f) {
            textView2.setTextSize(0, dimension);
        }
        if (colorStateList != null) {
            textView2.setTextColor(colorStateList);
        }
        addView(imageView2);
        addView(textView2);
    }

    public final void setIcon(Drawable drawable) {
        this.imageView.setImageDrawable(drawable);
    }

    public final void setIconResource(int i) {
        this.imageView.setImageResource(i);
    }

    public final void setIconSize(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(i, i2);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        this.imageView.setLayoutParams(layoutParams);
    }

    public final void setText(String str) {
        CharSequence charSequence = str;
        this.textView.setText(charSequence);
        View view = this.textView;
        int i = 0;
        if (charSequence == null || charSequence.length() == 0) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public final void hideText() {
        this.textView.setVisibility(8);
    }

    public final void setTextSize(float f) {
        this.textView.setTextSize(f);
    }
}
