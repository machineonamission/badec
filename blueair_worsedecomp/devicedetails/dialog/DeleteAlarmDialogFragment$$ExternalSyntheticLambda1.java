package com.blueair.devicedetails.dialog;

import android.view.View;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.mikepenz.fastadapter.IAdapter;
import kotlin.jvm.functions.Function4;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeleteAlarmDialogFragment$$ExternalSyntheticLambda1 implements Function4 {
    public final /* synthetic */ DeleteAlarmDialogFragment f$0;

    public /* synthetic */ DeleteAlarmDialogFragment$$ExternalSyntheticLambda1(DeleteAlarmDialogFragment deleteAlarmDialogFragment) {
        this.f$0 = deleteAlarmDialogFragment;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(DeleteAlarmDialogFragment.onViewCreated$lambda$9$lambda$8(this.f$0, (View) obj, (IAdapter) obj2, (DeletableItem) obj3, ((Integer) obj4).intValue()));
    }
}
