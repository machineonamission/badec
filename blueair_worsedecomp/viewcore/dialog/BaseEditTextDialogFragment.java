package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewHelperUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020'H\u0014J\b\u0010-\u001a\u00020.H$J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020.H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078DX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108DX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158DX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158DX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001a\u0010\u0017¨\u00061"}, d2 = {"Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "<init>", "()V", "dialogTitle", "Landroid/widget/TextView;", "getDialogTitle", "()Landroid/widget/TextView;", "dialogTitle$delegate", "Lkotlin/Lazy;", "dialogMsg", "getDialogMsg", "dialogMsg$delegate", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "editText$delegate", "saveBtn", "Landroid/widget/Button;", "getSaveBtn", "()Landroid/widget/Button;", "saveBtn$delegate", "cancelBtn", "getCancelBtn", "cancelBtn$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "onSaveBtnClicked", "text", "", "onCancelBtnClicked", "validateText", "", "showProgress", "shouldShowProgress", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseEditTextDialogFragment.kt */
public abstract class BaseEditTextDialogFragment<VM extends BaseViewModel> extends BaseDialogFragment<VM> {
    private final Lazy cancelBtn$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda4(this));
    private final Lazy dialogMsg$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda1(this));
    private final Lazy dialogTitle$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda0(this));
    private final Lazy editText$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda2(this));
    private final Lazy saveBtn$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda3(this));

    public void showProgress(boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract boolean validateText();

    /* access modifiers changed from: private */
    public static final TextView dialogTitle_delegate$lambda$0(BaseEditTextDialogFragment baseEditTextDialogFragment) {
        View view = baseEditTextDialogFragment.getView();
        if (view != null) {
            return (TextView) view.findViewById(R.id.dialog_title);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final TextView getDialogTitle() {
        return (TextView) this.dialogTitle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextView dialogMsg_delegate$lambda$1(BaseEditTextDialogFragment baseEditTextDialogFragment) {
        View view = baseEditTextDialogFragment.getView();
        if (view != null) {
            return (TextView) view.findViewById(R.id.dialog_msg);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final TextView getDialogMsg() {
        return (TextView) this.dialogMsg$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final EditText editText_delegate$lambda$2(BaseEditTextDialogFragment baseEditTextDialogFragment) {
        View view = baseEditTextDialogFragment.getView();
        if (view != null) {
            return (EditText) view.findViewById(R.id.editText);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final EditText getEditText() {
        return (EditText) this.editText$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Button saveBtn_delegate$lambda$3(BaseEditTextDialogFragment baseEditTextDialogFragment) {
        View view = baseEditTextDialogFragment.getView();
        if (view != null) {
            return (Button) view.findViewById(R.id.ok_view);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final Button getSaveBtn() {
        return (Button) this.saveBtn$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Button cancelBtn_delegate$lambda$4(BaseEditTextDialogFragment baseEditTextDialogFragment) {
        View view = baseEditTextDialogFragment.getView();
        if (view != null) {
            return (Button) view.findViewById(R.id.cancel_view);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final Button getCancelBtn() {
        return (Button) this.cancelBtn$delegate.getValue();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog dialog = new Dialog(requireContext());
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.rounded_rectangle_white));
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.dialog_enter_device_name, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Button saveBtn = getSaveBtn();
        if (saveBtn != null) {
            saveBtn.setOnClickListener(new BaseEditTextDialogFragment$$ExternalSyntheticLambda5(this));
        }
        Button cancelBtn = getCancelBtn();
        if (cancelBtn != null) {
            cancelBtn.setOnClickListener(new BaseEditTextDialogFragment$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(BaseEditTextDialogFragment baseEditTextDialogFragment, View view) {
        String str;
        Editable text;
        if (baseEditTextDialogFragment.validateText()) {
            EditText editText = baseEditTextDialogFragment.getEditText();
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            baseEditTextDialogFragment.onSaveBtnClicked(str);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(BaseEditTextDialogFragment baseEditTextDialogFragment, View view) {
        baseEditTextDialogFragment.onCancelBtnClicked();
    }

    /* access modifiers changed from: protected */
    public void onSaveBtnClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        ViewHelperUtil.INSTANCE.hideSoftKeyboard(getView());
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCancelBtnClicked() {
        dismiss();
    }
}
