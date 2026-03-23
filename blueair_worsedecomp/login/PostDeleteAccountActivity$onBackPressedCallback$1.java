package com.blueair.login;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/blueair/login/PostDeleteAccountActivity$onBackPressedCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PostDeleteAccountActivity.kt */
public final class PostDeleteAccountActivity$onBackPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ PostDeleteAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostDeleteAccountActivity$onBackPressedCallback$1(PostDeleteAccountActivity postDeleteAccountActivity) {
        super(true);
        this.this$0 = postDeleteAccountActivity;
    }

    public void handleOnBackPressed() {
        this.this$0.onClose();
    }
}
