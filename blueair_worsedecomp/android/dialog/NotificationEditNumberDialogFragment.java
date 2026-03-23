package com.blueair.android.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.blueair.android.databinding.DialogfragmentNotificationEditNumberBinding;
import com.blueair.viewcore.R;
import com.shawnlin.numberpicker.NumberPicker;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/blueair/android/dialog/NotificationEditNumberDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "viewDataBinding", "Lcom/blueair/android/databinding/DialogfragmentNotificationEditNumberBinding;", "onPickResult", "Lkotlin/Function2;", "", "", "getOnPickResult", "()Lkotlin/jvm/functions/Function2;", "setOnPickResult", "(Lkotlin/jvm/functions/Function2;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationEditNumberDialogFragment.kt */
public final class NotificationEditNumberDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private static final String ARGUMENT_INITIAL_VALUE = "TRIGGER";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Function2<? super NotificationEditNumberDialogFragment, ? super Integer, Unit> onPickResult;
    private DialogfragmentNotificationEditNumberBinding viewDataBinding;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/android/dialog/NotificationEditNumberDialogFragment$Companion;", "", "<init>", "()V", "ARGUMENT_INITIAL_VALUE", "", "newInstance", "Lcom/blueair/android/dialog/NotificationEditNumberDialogFragment;", "initialValue", "", "onPickResult", "Lkotlin/Function2;", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationEditNumberDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationEditNumberDialogFragment newInstance(int i, Function2<? super NotificationEditNumberDialogFragment, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "onPickResult");
            NotificationEditNumberDialogFragment notificationEditNumberDialogFragment = new NotificationEditNumberDialogFragment();
            notificationEditNumberDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(NotificationEditNumberDialogFragment.ARGUMENT_INITIAL_VALUE, Integer.valueOf(i))));
            notificationEditNumberDialogFragment.setOnPickResult(function2);
            return notificationEditNumberDialogFragment;
        }
    }

    public final Function2<NotificationEditNumberDialogFragment, Integer, Unit> getOnPickResult() {
        return this.onPickResult;
    }

    public final void setOnPickResult(Function2<? super NotificationEditNumberDialogFragment, ? super Integer, Unit> function2) {
        this.onPickResult = function2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setWindowAnimations(R.style.dialog_animation);
            }
        }
        DialogfragmentNotificationEditNumberBinding inflate = DialogfragmentNotificationEditNumberBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        DialogfragmentNotificationEditNumberBinding dialogfragmentNotificationEditNumberBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        inflate.btnCancel.setOnClickListener(new NotificationEditNumberDialogFragment$$ExternalSyntheticLambda0(this));
        inflate.btnSave.setOnClickListener(new NotificationEditNumberDialogFragment$$ExternalSyntheticLambda1(this, inflate));
        NumberPicker numberPicker = inflate.numberPicker;
        Bundle arguments = getArguments();
        numberPicker.setValue(arguments != null ? arguments.getInt(ARGUMENT_INITIAL_VALUE) : 10);
        DialogfragmentNotificationEditNumberBinding dialogfragmentNotificationEditNumberBinding2 = this.viewDataBinding;
        if (dialogfragmentNotificationEditNumberBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentNotificationEditNumberBinding = dialogfragmentNotificationEditNumberBinding2;
        }
        View root = dialogfragmentNotificationEditNumberBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4$lambda$2(NotificationEditNumberDialogFragment notificationEditNumberDialogFragment, View view) {
        notificationEditNumberDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4$lambda$3(NotificationEditNumberDialogFragment notificationEditNumberDialogFragment, DialogfragmentNotificationEditNumberBinding dialogfragmentNotificationEditNumberBinding, View view) {
        Function2<? super NotificationEditNumberDialogFragment, ? super Integer, Unit> function2 = notificationEditNumberDialogFragment.onPickResult;
        if (function2 != null) {
            function2.invoke(notificationEditNumberDialogFragment, Integer.valueOf(dialogfragmentNotificationEditNumberBinding.numberPicker.getValue()));
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
    }
}
