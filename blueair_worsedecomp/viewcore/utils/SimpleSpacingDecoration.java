package com.blueair.viewcore.utils;

import android.graphics.Rect;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001'B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003J(\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J(\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0002J0\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/blueair/viewcore/utils/SimpleSpacingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "horizontalSpacing", "", "verticalSpacing", "includeEdge", "", "<init>", "(IIZ)V", "excludeCallback", "Lcom/blueair/viewcore/utils/SimpleSpacingDecoration$ExcludeCallback;", "topEdgeSpacing", "bottomEdgeSpacing", "edgeHorizontalSpacing", "setEdgeSpacing", "", "hSpacing", "vSpacing", "topSpacing", "bottomSpacing", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getLinearItemOffset", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "itemPosition", "contentPos", "getGridItemOffsets", "column", "spanCount", "itemCountWithoutHeader", "setExcludeCallback", "ExcludeCallback", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleSpacingDecoration.kt */
public final class SimpleSpacingDecoration extends RecyclerView.ItemDecoration {
    private int bottomEdgeSpacing;
    private int edgeHorizontalSpacing;
    private ExcludeCallback excludeCallback;
    private final int horizontalSpacing;
    private boolean includeEdge;
    private int topEdgeSpacing;
    private final int verticalSpacing;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/blueair/viewcore/utils/SimpleSpacingDecoration$ExcludeCallback;", "", "headerCount", "", "getHeaderCount", "()I", "shouldExclude", "", "position", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SimpleSpacingDecoration.kt */
    public interface ExcludeCallback {
        int getHeaderCount();

        boolean shouldExclude(int i);
    }

    public SimpleSpacingDecoration(int i, int i2) {
        this(i, i2, false, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleSpacingDecoration(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? false : z);
    }

    public SimpleSpacingDecoration(int i, int i2, boolean z) {
        this.horizontalSpacing = i;
        this.verticalSpacing = i2;
        this.includeEdge = z;
        if (z) {
            setEdgeSpacing(i, i2);
        }
    }

    public final void setEdgeSpacing(int i, int i2) {
        setEdgeSpacing(i, i2, i2);
    }

    public final void setEdgeSpacing(int i, int i2, int i3) {
        if (i != 0 || i2 != 0 || i3 != 0) {
            this.includeEdge = true;
            this.edgeHorizontalSpacing = i;
            this.topEdgeSpacing = i2;
            this.bottomEdgeSpacing = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0026, code lost:
        if (r0.shouldExclude(r11) != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getItemOffsets(android.graphics.Rect r8, android.view.View r9, androidx.recyclerview.widget.RecyclerView r10, androidx.recyclerview.widget.RecyclerView.State r11) {
        /*
            r7 = this;
            java.lang.String r0 = "outRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            super.getItemOffsets(r8, r9, r10, r11)
            int r11 = r10.getChildAdapterPosition(r9)
            com.blueair.viewcore.utils.SimpleSpacingDecoration$ExcludeCallback r0 = r7.excludeCallback
            if (r0 == 0) goto L_0x002a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.shouldExclude(r11)
            if (r0 == 0) goto L_0x002a
        L_0x0028:
            r1 = r7
            goto L_0x008a
        L_0x002a:
            com.blueair.viewcore.utils.SimpleSpacingDecoration$ExcludeCallback r0 = r7.excludeCallback
            if (r0 == 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.getHeaderCount()
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            int r3 = r11 - r0
            if (r3 >= 0) goto L_0x003c
            goto L_0x0028
        L_0x003c:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r10 = r10.getLayoutManager()
            if (r10 != 0) goto L_0x0043
            goto L_0x0028
        L_0x0043:
            boolean r1 = r10 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r1 == 0) goto L_0x005b
            androidx.recyclerview.widget.GridLayoutManager r10 = (androidx.recyclerview.widget.GridLayoutManager) r10
            int r5 = r10.getSpanCount()
            int r4 = r3 % r5
            int r9 = r10.getItemCount()
            int r6 = r9 - r0
            r1 = r7
            r2 = r8
            r1.getGridItemOffsets(r2, r3, r4, r5, r6)
            return
        L_0x005b:
            r2 = r8
            boolean r8 = r10 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r8 == 0) goto L_0x0080
            android.view.ViewGroup$LayoutParams r8 = r9.getLayoutParams()
            java.lang.String r9 = "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager r10 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r10
            int r5 = r10.getSpanCount()
            int r4 = r8.getSpanIndex()
            int r8 = r10.getItemCount()
            int r6 = r8 - r0
            r1 = r7
            r1.getGridItemOffsets(r2, r3, r4, r5, r6)
            return
        L_0x0080:
            r1 = r7
            boolean r8 = r10 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r8 == 0) goto L_0x008a
            androidx.recyclerview.widget.LinearLayoutManager r10 = (androidx.recyclerview.widget.LinearLayoutManager) r10
            r7.getLinearItemOffset(r2, r10, r11, r3)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.utils.SimpleSpacingDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private final void getLinearItemOffset(Rect rect, LinearLayoutManager linearLayoutManager, int i, int i2) {
        boolean z = false;
        boolean z2 = linearLayoutManager.getOrientation() == 1;
        if (this.includeEdge) {
            if (i2 == 0) {
                if (z2) {
                    rect.top = this.topEdgeSpacing;
                } else {
                    rect.left = this.edgeHorizontalSpacing;
                }
            }
            if (i == linearLayoutManager.getItemCount() - 1) {
                z = true;
            }
            if (z2) {
                rect.bottom = z ? this.bottomEdgeSpacing : this.verticalSpacing;
            } else {
                rect.right = z ? this.edgeHorizontalSpacing : this.horizontalSpacing;
            }
        } else if (i2 <= 0) {
        } else {
            if (z2) {
                rect.top = this.verticalSpacing;
            } else {
                rect.left = this.horizontalSpacing;
            }
        }
    }

    private final void getGridItemOffsets(Rect rect, int i, int i2, int i3, int i4) {
        if (this.includeEdge) {
            rect.left = (this.horizontalSpacing * (i3 - i2)) / i3;
            rect.right = (this.horizontalSpacing * (i2 + 1)) / i3;
            if (i2 == 0) {
                rect.left = this.edgeHorizontalSpacing;
            }
            if (i2 == i3 - 1) {
                rect.right = this.edgeHorizontalSpacing;
            }
            if (i < i3) {
                rect.top = this.topEdgeSpacing;
            }
            int i5 = (i4 / i3) * i3;
            if (i4 % i3 == 0) {
                i5 -= i3;
            }
            rect.bottom = i >= i5 ? this.bottomEdgeSpacing : this.verticalSpacing;
            return;
        }
        rect.left = (this.horizontalSpacing * i2) / i3;
        rect.right = (this.horizontalSpacing * ((i3 - 1) - i2)) / i3;
        if (i >= i3) {
            rect.top = this.verticalSpacing;
        }
    }

    public final void setExcludeCallback(ExcludeCallback excludeCallback2) {
        this.excludeCallback = excludeCallback2;
    }
}
