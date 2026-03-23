package com.blueair.viewcore.dialog;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/blueair/viewcore/dialog/SelectDeviceFilterDialogFragment$onViewCreated$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SelectDeviceFilterDialogFragment.kt */
public final class SelectDeviceFilterDialogFragment$onViewCreated$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ SelectDeviceFilterDialogFragment this$0;

    SelectDeviceFilterDialogFragment$onViewCreated$2(SelectDeviceFilterDialogFragment selectDeviceFilterDialogFragment) {
        this.this$0 = selectDeviceFilterDialogFragment;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.this$0.refreshFilterScrollIndicators();
    }
}
