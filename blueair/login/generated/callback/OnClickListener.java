package com.blueair.login.generated.callback;

import android.view.View;

public final class OnClickListener implements View.OnClickListener {
   final Listener mListener;
   final int mSourceId;

   public OnClickListener(Listener var1, int var2) {
      this.mListener = var1;
      this.mSourceId = var2;
   }

   public void onClick(View var1) {
      this.mListener._internalCallbackOnClick(this.mSourceId, var1);
   }

   public interface Listener {
      void _internalCallbackOnClick(int var1, View var2);
   }
}
