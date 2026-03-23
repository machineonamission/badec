package com.blueair.devicedetails.activity;

import android.view.View;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.devicedetails.R;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/activity/ScheduleListActivity$showMenuDialog$1", "Lcom/kongzue/dialogx/interfaces/OnBindView;", "Lcom/kongzue/dialogx/dialogs/CustomDialog;", "onBind", "", "dialog", "v", "Landroid/view/View;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScheduleListActivity.kt */
public final class ScheduleListActivity$showMenuDialog$1 extends OnBindView<CustomDialog> {
    final /* synthetic */ ScheduleListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScheduleListActivity$showMenuDialog$1(ScheduleListActivity scheduleListActivity, int i) {
        super(i);
        this.this$0 = scheduleListActivity;
    }

    public void onBind(CustomDialog customDialog, View view) {
        Intrinsics.checkNotNullParameter(customDialog, "dialog");
        Intrinsics.checkNotNullParameter(view, "v");
        View findViewById = view.findViewById(R.id.tv_addSchedule);
        View findViewById2 = view.findViewById(R.id.tv_deleteSchedule);
        findViewById.setOnClickListener(new ScheduleListActivity$showMenuDialog$1$$ExternalSyntheticLambda0(customDialog, this.this$0));
        findViewById2.setOnClickListener(new ScheduleListActivity$showMenuDialog$1$$ExternalSyntheticLambda1(customDialog, this.this$0));
    }

    /* access modifiers changed from: private */
    public static final void onBind$lambda$0(CustomDialog customDialog, ScheduleListActivity scheduleListActivity, View view) {
        customDialog.dismiss();
        ScheduleListActivity.gotoScheduleOverview$default(scheduleListActivity, (DeviceScheduleMerged) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onBind$lambda$1(CustomDialog customDialog, ScheduleListActivity scheduleListActivity, View view) {
        customDialog.dismiss();
        scheduleListActivity.showDeleteDialog();
    }
}
