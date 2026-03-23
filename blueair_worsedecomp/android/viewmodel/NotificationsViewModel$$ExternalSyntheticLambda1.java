package com.blueair.android.viewmodel;

import android.view.View;
import com.blueair.core.model.Device;
import com.blueair.core.model.FilterInfo;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationsViewModel$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ NotificationsViewModel f$0;
    public final /* synthetic */ Device f$1;
    public final /* synthetic */ FilterInfo f$2;
    public final /* synthetic */ BottomSheetDialog f$3;

    public /* synthetic */ NotificationsViewModel$$ExternalSyntheticLambda1(NotificationsViewModel notificationsViewModel, Device device, FilterInfo filterInfo, BottomSheetDialog bottomSheetDialog) {
        this.f$0 = notificationsViewModel;
        this.f$1 = device;
        this.f$2 = filterInfo;
        this.f$3 = bottomSheetDialog;
    }

    public final void onClick(View view) {
        NotificationsViewModel.showFilterPurchaseOptionDialog$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
