package com.blueair.devicedetails.activity;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/activity/AlarmListActivity$showMenuDialog$1", "Lcom/kongzue/dialogx/interfaces/OnBindView;", "Lcom/kongzue/dialogx/dialogs/CustomDialog;", "onBind", "", "dialog", "v", "Landroid/view/View;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AlarmListActivity.kt */
public final class AlarmListActivity$showMenuDialog$1 extends OnBindView<CustomDialog> {
    final /* synthetic */ AlarmListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlarmListActivity$showMenuDialog$1(AlarmListActivity alarmListActivity, int i) {
        super(i);
        this.this$0 = alarmListActivity;
    }

    public void onBind(CustomDialog customDialog, View view) {
        Intrinsics.checkNotNullParameter(customDialog, "dialog");
        Intrinsics.checkNotNullParameter(view, "v");
        View findViewById = view.findViewById(R.id.tv_add);
        View findViewById2 = view.findViewById(R.id.tv_delete);
        findViewById.setOnClickListener(new AlarmListActivity$showMenuDialog$1$$ExternalSyntheticLambda0(customDialog, this.this$0));
        findViewById2.setOnClickListener(new AlarmListActivity$showMenuDialog$1$$ExternalSyntheticLambda1(customDialog, this.this$0));
    }

    /* access modifiers changed from: private */
    public static final void onBind$lambda$0(CustomDialog customDialog, AlarmListActivity alarmListActivity, View view) {
        customDialog.dismiss();
        alarmListActivity.createNewAlarm();
    }

    /* access modifiers changed from: private */
    public static final void onBind$lambda$2(CustomDialog customDialog, AlarmListActivity alarmListActivity, View view) {
        customDialog.dismiss();
        FragmentManager supportFragmentManager = alarmListActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<DeleteAlarmDialogFragment> cls = DeleteAlarmDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeleteAlarmDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("DeleteAlarmDialogFragment") instanceof DeleteAlarmDialogFragment) && !supportFragmentManager.isStateSaved()) {
            DeleteAlarmDialogFragment.Companion.newInstance$default(DeleteAlarmDialogFragment.Companion, alarmListActivity.getDevice(), true, (View) null, 4, (Object) null).show(supportFragmentManager, "DeleteAlarmDialogFragment");
        }
    }
}
