package com.blueair.viewcore.extensions;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.blueair.viewcore.utils.SnapOnScrollListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"attachSnapHelperWithListener", "", "Landroidx/recyclerview/widget/RecyclerView;", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "behavior", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "onSnapPositionChangeListener", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: RecyclerExtensions.kt */
public final class RecyclerExtensionsKt {
    public static /* synthetic */ void attachSnapHelperWithListener$default(RecyclerView recyclerView, SnapHelper snapHelper, SnapOnScrollListener.Behavior behavior, SnapOnScrollListener.OnSnapPositionChangeListener onSnapPositionChangeListener, int i, Object obj) {
        if ((i & 2) != 0) {
            behavior = SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL;
        }
        attachSnapHelperWithListener(recyclerView, snapHelper, behavior, onSnapPositionChangeListener);
    }

    public static final void attachSnapHelperWithListener(RecyclerView recyclerView, SnapHelper snapHelper, SnapOnScrollListener.Behavior behavior, SnapOnScrollListener.OnSnapPositionChangeListener onSnapPositionChangeListener) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(snapHelper, "snapHelper");
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Intrinsics.checkNotNullParameter(onSnapPositionChangeListener, "onSnapPositionChangeListener");
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new SnapOnScrollListener(snapHelper, behavior, onSnapPositionChangeListener));
    }
}
