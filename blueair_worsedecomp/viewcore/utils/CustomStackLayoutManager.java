package com.blueair.viewcore.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J,\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/viewcore/utils/CustomStackLayoutManager;", "Lcom/yuyakaido/android/cardstackview/CardStackLayoutManager;", "cardStackView", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "stackListener", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "autoMeause", "", "<init>", "(Lcom/yuyakaido/android/cardstackview/CardStackView;Lcom/yuyakaido/android/cardstackview/CardStackListener;Z)V", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "isAutoMeasureEnabled", "onMeasure", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "", "heightSpec", "setSizeFromTopView", "setSizeFromChild", "topView", "Landroid/view/View;", "width", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CustomStackLayoutManager.kt */
public final class CustomStackLayoutManager extends CardStackLayoutManager {
    private final boolean autoMeause;
    private final CardStackView cardStackView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomStackLayoutManager(CardStackView cardStackView2, CardStackListener cardStackListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cardStackView2, cardStackListener, (i & 4) != 0 ? true : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomStackLayoutManager(CardStackView cardStackView2, CardStackListener cardStackListener, boolean z) {
        super(cardStackView2.getContext(), cardStackListener);
        Intrinsics.checkNotNullParameter(cardStackView2, "cardStackView");
        Intrinsics.checkNotNullParameter(cardStackListener, "stackListener");
        this.cardStackView = cardStackView2;
        this.autoMeause = z;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    public boolean isAutoMeasureEnabled() {
        return this.autoMeause;
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        View topView = getTopView();
        if (topView == null || this.autoMeause) {
            super.onMeasure(recycler, state, i, i2);
        } else {
            setSizeFromChild(topView, CardStackLayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this.cardStackView)));
        }
    }

    public final void setSizeFromTopView() {
        View topView = getTopView();
        if (topView != null) {
            setSizeFromChild(topView, getWidth());
        }
    }

    private final void setSizeFromChild(View view, int i) {
        View view2;
        if (this.autoMeause) {
            int i2 = 0;
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.cardStackView.findViewHolderForAdapterPosition(0);
            if (!(findViewHolderForAdapterPosition == null || (view2 = findViewHolderForAdapterPosition.itemView) == null)) {
                view = view2;
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            if (getItemCount() > 0) {
                view.measure(CardStackLayoutManager.getChildMeasureSpec(i, getWidthMode(), getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width, true), CardStackLayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), paddingTop, view.getLayoutParams().height, true));
                i2 = view.getMeasuredHeight() + paddingTop;
            }
            ViewGroup.LayoutParams layoutParams = this.cardStackView.getLayoutParams();
            layoutParams.height = i2;
            this.cardStackView.setLayoutParams(layoutParams);
        }
    }
}
