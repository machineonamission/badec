package com.blueair.viewcore;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ViewUtils$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ViewUtils$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ViewUtils.showConfirmation$lambda$2(this.f$0, dialogInterface, i);
    }
}
