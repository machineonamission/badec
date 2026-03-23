package com.blueair.android.generated.callback;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public final class OnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
    final Listener mListener;
    final int mSourceId;

    public interface Listener {
        void _internalCallbackOnRefresh(int i);
    }

    public OnRefreshListener(Listener listener, int i) {
        this.mListener = listener;
        this.mSourceId = i;
    }

    public void onRefresh() {
        this.mListener._internalCallbackOnRefresh(this.mSourceId);
    }
}
