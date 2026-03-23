package com.blueair.android.viewmodel;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationsViewModel$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ BottomSheetDialog f$0;

    public /* synthetic */ NotificationsViewModel$$ExternalSyntheticLambda2(BottomSheetDialog bottomSheetDialog) {
        this.f$0 = bottomSheetDialog;
    }

    public final void onClick(View view) {
        NotificationsViewModel.showFilterPurchaseOptionDialog$lambda$4(this.f$0, view);
    }
}
