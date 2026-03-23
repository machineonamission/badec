package com.blueair.android.util;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/blueair/android/util/SimpleScrollingPagerIndicator;", "Lru/tinkoff/scrollingpagerindicator/ScrollingPagerIndicator;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentPostion", "getCurrentPostion", "()I", "setCurrentPostion", "(I)V", "setCurrentPosition", "", "position", "onPageScrolled", "page", "offset", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleScrollingPagerIndicator.kt */
public final class SimpleScrollingPagerIndicator extends ScrollingPagerIndicator {
    public static final int $stable = 8;
    private int currentPostion;

    public final int getCurrentPostion() {
        return this.currentPostion;
    }

    public final void setCurrentPostion(int i) {
        this.currentPostion = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleScrollingPagerIndicator(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleScrollingPagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleScrollingPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public void setCurrentPosition(int i) {
        super.setCurrentPosition(i);
        this.currentPostion = i;
    }

    public void onPageScrolled(int i, float f) {
        super.onPageScrolled(i, f);
        if (((double) f) <= 0.5d || i >= getVisibleDotCount() - 1) {
            this.currentPostion = i;
        } else {
            this.currentPostion = i + 1;
        }
    }
}
