package com.blueair.viewcore.extensions;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"dismissKeyboard", "", "Landroid/app/Activity;", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: ActivityExtensions.kt */
public final class ActivityExtensionsKt {
    public static final void dismissKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager.isAcceptingText()) {
            View currentFocus = activity.getCurrentFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
        }
    }
}
