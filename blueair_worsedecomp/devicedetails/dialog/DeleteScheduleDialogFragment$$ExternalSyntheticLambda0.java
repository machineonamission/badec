package com.blueair.devicedetails.dialog;

import android.view.View;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.mikepenz.fastadapter.IAdapter;
import kotlin.jvm.functions.Function4;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeleteScheduleDialogFragment$$ExternalSyntheticLambda0 implements Function4 {
    public final /* synthetic */ DeleteScheduleDialogFragment f$0;

    public /* synthetic */ DeleteScheduleDialogFragment$$ExternalSyntheticLambda0(DeleteScheduleDialogFragment deleteScheduleDialogFragment) {
        this.f$0 = deleteScheduleDialogFragment;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return Boolean.valueOf(DeleteScheduleDialogFragment.onViewCreated$lambda$8$lambda$7(this.f$0, (View) obj, (IAdapter) obj2, (DeletableItem) obj3, ((Integer) obj4).intValue()));
    }
}
