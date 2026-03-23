package com.blueair.viewcore.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.blueair.viewcore.extensions.SnapHelperExtensionsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/blueair/viewcore/utils/SnapOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "snapHelper", "Landroidx/recyclerview/widget/SnapHelper;", "behavior", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "onSnapPositionChangeListener", "Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "<init>", "(Landroidx/recyclerview/widget/SnapHelper;Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;)V", "getBehavior", "()Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "setBehavior", "(Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;)V", "getOnSnapPositionChangeListener", "()Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "setOnSnapPositionChangeListener", "(Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;)V", "snapPosition", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "onScrollStateChanged", "newState", "maybeNotifySnapPositionChange", "OnSnapPositionChangeListener", "Behavior", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SnapOnScrollListener.kt */
public final class SnapOnScrollListener extends RecyclerView.OnScrollListener {
    private Behavior behavior;
    private OnSnapPositionChangeListener onSnapPositionChangeListener;
    private final SnapHelper snapHelper;
    private int snapPosition;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/blueair/viewcore/utils/SnapOnScrollListener$OnSnapPositionChangeListener;", "", "onSnapPositionChange", "", "position", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SnapOnScrollListener.kt */
    public interface OnSnapPositionChangeListener {
        void onSnapPositionChange(int i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnapOnScrollListener(SnapHelper snapHelper2, Behavior behavior2, OnSnapPositionChangeListener onSnapPositionChangeListener2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapHelper2, (i & 2) != 0 ? Behavior.NOTIFY_ON_SCROLL : behavior2, (i & 4) != 0 ? null : onSnapPositionChangeListener2);
    }

    public final Behavior getBehavior() {
        return this.behavior;
    }

    public final void setBehavior(Behavior behavior2) {
        Intrinsics.checkNotNullParameter(behavior2, "<set-?>");
        this.behavior = behavior2;
    }

    public final OnSnapPositionChangeListener getOnSnapPositionChangeListener() {
        return this.onSnapPositionChangeListener;
    }

    public final void setOnSnapPositionChangeListener(OnSnapPositionChangeListener onSnapPositionChangeListener2) {
        this.onSnapPositionChangeListener = onSnapPositionChangeListener2;
    }

    public SnapOnScrollListener(SnapHelper snapHelper2, Behavior behavior2, OnSnapPositionChangeListener onSnapPositionChangeListener2) {
        Intrinsics.checkNotNullParameter(snapHelper2, "snapHelper");
        Intrinsics.checkNotNullParameter(behavior2, "behavior");
        this.snapHelper = snapHelper2;
        this.behavior = behavior2;
        this.onSnapPositionChangeListener = onSnapPositionChangeListener2;
        this.snapPosition = -1;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/viewcore/utils/SnapOnScrollListener$Behavior;", "", "<init>", "(Ljava/lang/String;I)V", "NOTIFY_ON_SCROLL", "NOTIFY_ON_SCROLL_STATE_IDLE", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SnapOnScrollListener.kt */
    public enum Behavior {
        NOTIFY_ON_SCROLL,
        NOTIFY_ON_SCROLL_STATE_IDLE;

        public static EnumEntries<Behavior> getEntries() {
            return $ENTRIES;
        }

        static {
            Behavior[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.behavior == Behavior.NOTIFY_ON_SCROLL) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.behavior == Behavior.NOTIFY_ON_SCROLL_STATE_IDLE && i == 0) {
            maybeNotifySnapPositionChange(recyclerView);
        }
    }

    private final void maybeNotifySnapPositionChange(RecyclerView recyclerView) {
        int snapPosition2 = SnapHelperExtensionsKt.getSnapPosition(this.snapHelper, recyclerView);
        if (this.snapPosition != snapPosition2) {
            OnSnapPositionChangeListener onSnapPositionChangeListener2 = this.onSnapPositionChangeListener;
            if (onSnapPositionChangeListener2 != null) {
                onSnapPositionChangeListener2.onSnapPositionChange(snapPosition2);
            }
            this.snapPosition = snapPosition2;
        }
    }
}
