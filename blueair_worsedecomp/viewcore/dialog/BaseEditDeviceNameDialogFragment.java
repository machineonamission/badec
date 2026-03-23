package com.blueair.viewcore.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/blueair/viewcore/dialog/BaseEditDeviceNameDialogFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "validateText", "", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseEditDeviceNameDialogFragment.kt */
public abstract class BaseEditDeviceNameDialogFragment<VM extends BaseViewModel> extends BaseEditTextDialogFragment<VM> {
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        EditText editText = getEditText();
        if (editText != null) {
            editText.setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(25)});
            editText.post(new BaseEditDeviceNameDialogFragment$$ExternalSyntheticLambda0(editText));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1$lambda$0(EditText editText) {
        editText.requestFocus();
        Object systemService = editText.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    /* access modifiers changed from: protected */
    public boolean validateText() {
        EditText editText = getEditText();
        if (String.valueOf(editText != null ? editText.getText() : null).length() != 0) {
            return true;
        }
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        viewUtils.showSnackbar((Activity) requireActivity, R.string.device_name_invalid_name, (ViewUtils.MessageType) ViewUtils.MessageType.WARNING.INSTANCE);
        return false;
    }
}
