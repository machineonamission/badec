package com.blueair.android.generated.callback;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public final class OnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
   final Listener mListener;
   final int mSourceId;

   public OnRefreshListener(Listener var1, int var2) {
      this.mListener = var1;
      this.mSourceId = var2;
   }

   public void onRefresh() {
      this.mListener._internalCallbackOnRefresh(this.mSourceId);
   }

   public interface Listener {
      void _internalCallbackOnRefresh(int var1);
   }
}
