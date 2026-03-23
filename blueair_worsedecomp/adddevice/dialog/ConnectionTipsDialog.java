package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.DialogConnectionTipsBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/blueair/adddevice/dialog/ConnectionTipsDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionTipsDialog.kt */
public final class ConnectionTipsDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/adddevice/dialog/ConnectionTipsDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/dialog/ConnectionTipsDialog;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ConnectionTipsDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectionTipsDialog newInstance() {
            return new ConnectionTipsDialog();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        DialogConnectionTipsBinding inflate = DialogConnectionTipsBinding.inflate(getLayoutInflater(), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.confirmButton.setOnClickListener(new ConnectionTipsDialog$$ExternalSyntheticLambda0(this));
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(inflate.getRoot());
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.rounded_rectangle_white));
        }
        return dialog;
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(ConnectionTipsDialog connectionTipsDialog, View view) {
        connectionTipsDialog.dismiss();
    }
}
