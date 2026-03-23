package com.blueair.viewcore;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ViewUtils$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ViewUtils$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ViewUtils.showConfirmation$lambda$0(this.f$0, dialogInterface, i);
    }
}
