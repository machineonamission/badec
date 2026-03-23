package com.blueair.viewcore.dialog;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/viewcore/dialog/ConnectionLostDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "dismissListener", "Lkotlin/Function0;", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionLostDialogFragment.kt */
public final class ConnectionLostDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public Function0<Unit> dismissListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/viewcore/dialog/ConnectionLostDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/dialog/ConnectionLostDialogFragment;", "dismissListener", "Lkotlin/Function0;", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ConnectionLostDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectionLostDialogFragment newInstance(Function0<Unit> function0) {
            ConnectionLostDialogFragment connectionLostDialogFragment = new ConnectionLostDialogFragment();
            connectionLostDialogFragment.dismissListener = function0;
            return connectionLostDialogFragment;
        }
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Dialog onCreateDialog(android.os.Bundle r6) {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            r0 = 0
            if (r6 == 0) goto L_0x000c
            android.view.LayoutInflater r6 = r6.getLayoutInflater()
            goto L_0x000d
        L_0x000c:
            r6 = r0
        L_0x000d:
            if (r6 == 0) goto L_0x0016
            int r1 = com.blueair.viewcore.R.layout.dialog_connection_lost
            android.view.View r6 = r6.inflate(r1, r0)
            goto L_0x0017
        L_0x0016:
            r6 = r0
        L_0x0017:
            android.app.Dialog r1 = new android.app.Dialog
            android.content.Context r2 = r5.requireContext()
            r1.<init>(r2)
            if (r6 == 0) goto L_0x0025
            r1.setContentView(r6)
        L_0x0025:
            androidx.fragment.app.FragmentActivity r2 = r5.getActivity()
            if (r2 == 0) goto L_0x003c
            android.view.Window r3 = r1.getWindow()
            if (r3 == 0) goto L_0x003c
            android.content.Context r2 = (android.content.Context) r2
            int r4 = com.blueair.viewcore.R.drawable.rounded_rectangle_white
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r4)
            r3.setBackgroundDrawable(r2)
        L_0x003c:
            if (r6 == 0) goto L_0x0047
            int r0 = com.blueair.viewcore.R.id.buttonTryAgainLater
            android.view.View r6 = r6.findViewById(r0)
            r0 = r6
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
        L_0x0047:
            if (r0 == 0) goto L_0x0051
            com.blueair.viewcore.dialog.ConnectionLostDialogFragment$$ExternalSyntheticLambda0 r6 = new com.blueair.viewcore.dialog.ConnectionLostDialogFragment$$ExternalSyntheticLambda0
            r6.<init>(r5)
            r0.setOnClickListener(r6)
        L_0x0051:
            r1.show()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.dialog.ConnectionLostDialogFragment.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(ConnectionLostDialogFragment connectionLostDialogFragment, View view) {
        connectionLostDialogFragment.dismiss();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Function0<Unit> function0 = this.dismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
