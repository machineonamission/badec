package io.flatcircle.viewhelper;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"hide", "", "Landroid/view/View;", "show", "shouldShow", "", "viewhelper_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static final void hide(View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        show(view, false);
    }

    public static /* synthetic */ void show$default(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        show(view, z);
    }

    public static final void show(View view, boolean z) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        view.setVisibility(z ? 0 : 8);
    }
}
