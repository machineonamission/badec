package com.blueair.login;

import android.view.View;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/login/SignInFragment$setTermsAndPrivacySpan$1", "Lcom/blueair/viewcore/utils/NoUnderlineClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SignInFragment.kt */
public final class SignInFragment$setTermsAndPrivacySpan$1 extends NoUnderlineClickableSpan {
    final /* synthetic */ SignInFragment this$0;

    SignInFragment$setTermsAndPrivacySpan$1(SignInFragment signInFragment) {
        this.this$0 = signInFragment;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        this.this$0.openTerms();
    }
}
