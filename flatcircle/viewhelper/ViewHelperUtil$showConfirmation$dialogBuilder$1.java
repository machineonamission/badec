package io.flatcircle.viewhelper;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"io/flatcircle/viewhelper/ViewHelperUtil$showConfirmation$dialogBuilder$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "p0", "Landroid/content/DialogInterface;", "p1", "", "viewhelper_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: ViewHelperUtil.kt */
public final class ViewHelperUtil$showConfirmation$dialogBuilder$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ Function1 $result;

    ViewHelperUtil$showConfirmation$dialogBuilder$1(Function1 function1) {
        this.$result = function1;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.$result.invoke(true);
    }
}
