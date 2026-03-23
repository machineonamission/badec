package com.blueair.viewcore.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/blueair/viewcore/utils/ToastUtils;", "", "<init>", "()V", "showCenterToast", "", "context", "Landroid/content/Context;", "text", "", "duration", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ToastUtils.kt */
public final class ToastUtils {
    public static final ToastUtils INSTANCE = new ToastUtils();

    private ToastUtils() {
    }

    public static /* synthetic */ void showCenterToast$default(ToastUtils toastUtils, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        toastUtils.showCenterToast(context, i, i2);
    }

    public final void showCenterToast(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.default_toast, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(i);
        Toast toast = new Toast(context);
        toast.setView(textView);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i2);
        toast.show();
    }
}
