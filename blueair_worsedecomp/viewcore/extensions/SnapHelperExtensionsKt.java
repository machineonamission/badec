package com.blueair.viewcore.extensions;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getSnapPosition", "", "Landroidx/recyclerview/widget/SnapHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: SnapHelperExtensions.kt */
public final class SnapHelperExtensionsKt {
    public static final int getSnapPosition(SnapHelper snapHelper, RecyclerView recyclerView) {
        View findSnapView;
        Intrinsics.checkNotNullParameter(snapHelper, "<this>");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null || (findSnapView = snapHelper.findSnapView(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.getPosition(findSnapView);
    }
}
