package com.blueair.login;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SignInFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ TextInputLayout f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ SignInFragment$$ExternalSyntheticLambda0(Function1 function1, TextInputLayout textInputLayout, AlertDialog alertDialog) {
        this.f$0 = function1;
        this.f$1 = textInputLayout;
        this.f$2 = alertDialog;
    }

    public final void onClick(View view) {
        SignInFragment.onViewCreated$lambda$16$lambda$9$lambda$7(this.f$0, this.f$1, this.f$2, view);
    }
}
