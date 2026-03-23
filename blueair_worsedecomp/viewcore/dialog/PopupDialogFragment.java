package com.blueair.viewcore.dialog;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.viewcore.databinding.PopupDialogBinding;
import com.blueair.viewcore.viewmodel.PopupMessage;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/blueair/viewcore/dialog/PopupDialogFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "state", "Lcom/blueair/viewcore/viewmodel/PopupMessage;", "getState", "()Lcom/blueair/viewcore/viewmodel/PopupMessage;", "state$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroidx/appcompat/app/AppCompatDialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PopupDialogFragment.kt */
public final class PopupDialogFragment extends AppCompatDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_STATE = "state";
    /* access modifiers changed from: private */
    public static final String TAG = "popup_dialog";
    private final Lazy state$delegate = LazyKt.lazy(new PopupDialogFragment$$ExternalSyntheticLambda0(this));

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/viewcore/dialog/PopupDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "KEY_STATE", "newInstance", "Lcom/blueair/viewcore/dialog/PopupDialogFragment;", "message", "Lcom/blueair/viewcore/viewmodel/PopupMessage;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PopupDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return PopupDialogFragment.TAG;
        }

        public final PopupDialogFragment newInstance(PopupMessage popupMessage) {
            Intrinsics.checkNotNullParameter(popupMessage, "message");
            Bundle bundle = new Bundle();
            bundle.putParcelable("state", popupMessage);
            PopupDialogFragment popupDialogFragment = new PopupDialogFragment();
            popupDialogFragment.setArguments(bundle);
            return popupDialogFragment;
        }
    }

    private final PopupMessage getState() {
        return (PopupMessage) this.state$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final PopupMessage state_delegate$lambda$0(PopupDialogFragment popupDialogFragment) {
        Parcelable parcelable = popupDialogFragment.requireArguments().getParcelable("state");
        if (parcelable != null) {
            return (PopupMessage) parcelable;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public AppCompatDialog onCreateDialog(Bundle bundle) {
        PopupDialogBinding inflate = PopupDialogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        AlertDialog create = new AlertDialog.Builder(requireActivity()).setView((View) inflate.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        inflate.titleTextView.setText(getState().getTitleResId());
        Integer subtitleResId = getState().getSubtitleResId();
        if (subtitleResId == null) {
            AppCompatTextView appCompatTextView = inflate.subtitleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "subtitleTextView");
            ViewExtensionsKt.hide(appCompatTextView);
        } else {
            AppCompatTextView appCompatTextView2 = inflate.subtitleTextView;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "subtitleTextView");
            ViewExtensionsKt.show$default(appCompatTextView2, false, 1, (Object) null);
            inflate.subtitleTextView.setText(subtitleResId.intValue());
        }
        inflate.messageTextView.setText(getState().getMessageResId());
        return create;
    }
}
