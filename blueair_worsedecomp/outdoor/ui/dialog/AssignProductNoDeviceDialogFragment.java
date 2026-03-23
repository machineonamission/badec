package com.blueair.outdoor.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.outdoor.R;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductNoDeviceDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AssignProductNoDeviceDialogFragment.kt */
public final class AssignProductNoDeviceDialogFragment extends DialogFragment {
    private static final String ARG_LOCATION_NAME = "ARG_LOCATION_NAME";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/outdoor/ui/dialog/AssignProductNoDeviceDialogFragment$Companion;", "", "<init>", "()V", "ARG_LOCATION_NAME", "", "newInstance", "Lcom/blueair/outdoor/ui/dialog/AssignProductNoDeviceDialogFragment;", "locationName", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AssignProductNoDeviceDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssignProductNoDeviceDialogFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "locationName");
            AssignProductNoDeviceDialogFragment assignProductNoDeviceDialogFragment = new AssignProductNoDeviceDialogFragment();
            assignProductNoDeviceDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(AssignProductNoDeviceDialogFragment.ARG_LOCATION_NAME, str)));
            return assignProductNoDeviceDialogFragment;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView;
        View inflate = requireActivity().getLayoutInflater().inflate(R.layout.dialog_assign_product_no_device, (ViewGroup) null);
        String string = requireArguments().getString(ARG_LOCATION_NAME);
        if (!(string == null || (textView = (TextView) inflate.findViewById(R.id.dialog_sub_title)) == null)) {
            textView.setText(string);
        }
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), com.blueair.viewcore.R.drawable.rounded_rectangle_white));
        }
        View findViewById = inflate.findViewById(R.id.btn_primary);
        if (findViewById != null) {
            findViewById.setOnClickListener(new AssignProductNoDeviceDialogFragment$$ExternalSyntheticLambda0(this));
        }
        dialog.show();
        return dialog;
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(AssignProductNoDeviceDialogFragment assignProductNoDeviceDialogFragment, View view) {
        assignProductNoDeviceDialogFragment.dismiss();
    }
}
