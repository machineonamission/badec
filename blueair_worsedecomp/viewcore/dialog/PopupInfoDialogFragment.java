package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.DialogfragmentPopupInfoBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/DialogfragmentPopupInfoBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PopupInfoDialogFragment.kt */
public final class PopupInfoDialogFragment extends DialogFragment {
    private static final String ARG_CONTENT_MESSAGE = "ARG_CONTENT_MESSAGE";
    private static final String ARG_CONTENT_TITLE = "ARG_CONTENT_TITLE";
    private static final String ARG_TITLE = "ARG_TITLE";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DialogfragmentPopupInfoBinding binding;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment$Companion;", "", "<init>", "()V", "ARG_TITLE", "", "ARG_CONTENT_TITLE", "ARG_CONTENT_MESSAGE", "newInstance", "Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment;", "title", "", "contentTitle", "message", "(ILjava/lang/Integer;I)Lcom/blueair/viewcore/dialog/PopupInfoDialogFragment;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PopupInfoDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PopupInfoDialogFragment newInstance(int i, Integer num, int i2) {
            PopupInfoDialogFragment popupInfoDialogFragment = new PopupInfoDialogFragment();
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to(PopupInfoDialogFragment.ARG_TITLE, Integer.valueOf(i));
            pairArr[1] = TuplesKt.to(PopupInfoDialogFragment.ARG_CONTENT_TITLE, Integer.valueOf(num != null ? num.intValue() : -1));
            pairArr[2] = TuplesKt.to(PopupInfoDialogFragment.ARG_CONTENT_MESSAGE, Integer.valueOf(i2));
            popupInfoDialogFragment.setArguments(BundleKt.bundleOf(pairArr));
            return popupInfoDialogFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        DialogfragmentPopupInfoBinding inflate = DialogfragmentPopupInfoBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Bundle requireArguments = requireArguments();
        inflate.title.setText(requireArguments.getInt(ARG_TITLE));
        int i = requireArguments.getInt(ARG_CONTENT_TITLE);
        if (i > 0) {
            inflate.contentTitle.setText(i);
        } else {
            TextView textView = inflate.contentTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "contentTitle");
            ViewExtensionsKt.hide(textView);
        }
        inflate.contentMessage.setText(requireArguments.getInt(ARG_CONTENT_MESSAGE));
        inflate.doneBtn.setOnClickListener(new PopupInfoDialogFragment$$ExternalSyntheticLambda0(this));
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4$lambda$3(PopupInfoDialogFragment popupInfoDialogFragment, View view) {
        popupInfoDialogFragment.dismiss();
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
