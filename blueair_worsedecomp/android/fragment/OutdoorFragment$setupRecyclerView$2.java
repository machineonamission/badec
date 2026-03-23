package com.blueair.android.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.FragmentOutdoorBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"com/blueair/android/fragment/OutdoorFragment$setupRecyclerView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "cacheFirstCompletelyVisiblePos", "", "getCacheFirstCompletelyVisiblePos", "()I", "setCacheFirstCompletelyVisiblePos", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorFragment.kt */
public final class OutdoorFragment$setupRecyclerView$2 extends RecyclerView.OnScrollListener {
    private int cacheFirstCompletelyVisiblePos;
    final /* synthetic */ OutdoorFragment this$0;

    OutdoorFragment$setupRecyclerView$2(OutdoorFragment outdoorFragment) {
        this.this$0 = outdoorFragment;
    }

    public final int getCacheFirstCompletelyVisiblePos() {
        return this.cacheFirstCompletelyVisiblePos;
    }

    public final void setCacheFirstCompletelyVisiblePos(int i) {
        this.cacheFirstCompletelyVisiblePos = i;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            FragmentOutdoorBinding fragmentOutdoorBinding = null;
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                OutdoorFragment outdoorFragment = this.this$0;
                int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                if (findFirstCompletelyVisibleItemPosition != this.cacheFirstCompletelyVisiblePos && findFirstCompletelyVisibleItemPosition == 0) {
                    OutdoorFragment.handleCurLocation$default(outdoorFragment, false, 1, (Object) null);
                }
                this.cacheFirstCompletelyVisiblePos = findFirstCompletelyVisibleItemPosition;
                int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (findLastCompletelyVisibleItemPosition == linearLayoutManager.getItemCount() - 1) {
                    FragmentOutdoorBinding access$getViewDataBinding$p = outdoorFragment.viewDataBinding;
                    if (access$getViewDataBinding$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                    } else {
                        fragmentOutdoorBinding = access$getViewDataBinding$p;
                    }
                    fragmentOutdoorBinding.pageDots.setCurrentPosition(findLastCompletelyVisibleItemPosition);
                }
            }
        }
    }
}
