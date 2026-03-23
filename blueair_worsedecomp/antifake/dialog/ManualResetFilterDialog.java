package com.blueair.antifake.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.antifake.adapter.ManualResetAdapter;
import com.blueair.antifake.databinding.DialogfragmentManualResetFilterBinding;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/blueair/antifake/dialog/ManualResetFilterDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ManualResetFilterDialog.kt */
public final class ManualResetFilterDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/antifake/dialog/ManualResetFilterDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/dialog/ManualResetFilterDialog;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ManualResetFilterDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ManualResetFilterDialog newInstance(DeviceFilterType deviceFilterType) {
            Intrinsics.checkNotNullParameter(deviceFilterType, "filterType");
            ManualResetFilterDialog manualResetFilterDialog = new ManualResetFilterDialog();
            manualResetFilterDialog.setArguments(BundleKt.bundleOf(TuplesKt.to(Actions.EXTRA_FILTER_TYPE, deviceFilterType.name())));
            return manualResetFilterDialog;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            Dialog dialog2 = getDialog();
            if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
                window.setWindowAnimations(R.style.dialog_animation_right);
            }
        }
        DialogfragmentManualResetFilterBinding inflate = DialogfragmentManualResetFilterBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.pager.setAdapter(new ManualResetAdapter());
        inflate.pageDots.attachToPager(inflate.pager);
        inflate.btnBack.setOnClickListener(new ManualResetFilterDialog$$ExternalSyntheticLambda0(this));
        inflate.btnConfirm.setOnClickListener(new ManualResetFilterDialog$$ExternalSyntheticLambda1(this));
        TextView textView = inflate.customerSupportText;
        String string = getString(R.string.customer_support);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Pattern compile = Pattern.compile(string, 0);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Linkify.addLinks(textView, compile, "tel:400-006-9693");
        inflate.customerSupportText.setMovementMethod(LinkMovementMethod.getInstance());
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$1(ManualResetFilterDialog manualResetFilterDialog, View view) {
        manualResetFilterDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2(ManualResetFilterDialog manualResetFilterDialog, View view) {
        manualResetFilterDialog.dismiss();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }
}
