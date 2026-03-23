package com.blueair.android.fragment;

import android.widget.TextView;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.google.android.material.button.MaterialButton;
import java.util.TimeZone;
import kotlin.jvm.functions.Function5;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IndoorFragment$$ExternalSyntheticLambda4 implements Function5 {
    public final /* synthetic */ ConfirmationDialogLeftAligned f$0;
    public final /* synthetic */ TimeZone f$1;

    public /* synthetic */ IndoorFragment$$ExternalSyntheticLambda4(ConfirmationDialogLeftAligned confirmationDialogLeftAligned, TimeZone timeZone) {
        this.f$0 = confirmationDialogLeftAligned;
        this.f$1 = timeZone;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return IndoorFragment.showDstPrompt$lambda$28$lambda$27$lambda$26(this.f$0, this.f$1, (TextView) obj, (TextView) obj2, (TextView) obj3, (MaterialButton) obj4, (MaterialButton) obj5);
    }
}
