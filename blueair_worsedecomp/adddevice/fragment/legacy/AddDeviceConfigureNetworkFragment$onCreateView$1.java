package com.blueair.adddevice.fragment.legacy;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/blueair/adddevice/fragment/legacy/AddDeviceConfigureNetworkFragment$onCreateView$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceConfigureNetworkFragment.kt */
public final class AddDeviceConfigureNetworkFragment$onCreateView$1 implements TextWatcher {
    final /* synthetic */ TextInputLayout $passwordViewContainer;
    final /* synthetic */ AddDeviceConfigureNetworkFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    AddDeviceConfigureNetworkFragment$onCreateView$1(AddDeviceConfigureNetworkFragment addDeviceConfigureNetworkFragment, TextInputLayout textInputLayout) {
        this.this$0 = addDeviceConfigureNetworkFragment;
        this.$passwordViewContainer = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        if (editable.length() > 0) {
            this.this$0.hasEnteredText = true;
        }
        this.this$0.getAddService().setWifiPassword(editable.toString());
        if (this.$passwordViewContainer.getEndIconMode() != 1 && this.this$0.getDeviceModelType() == 3) {
            this.$passwordViewContainer.setEndIconMode(1);
        }
        this.this$0.updateNextButtonState();
    }
}
