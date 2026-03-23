package com.blueair.devicedetails.dialog;

import android.widget.ImageButton;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterSelectionBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/devicedetails/dialog/FilterSelectionDialogFragment$onCreateView$3", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterSelectionDialogFragment.kt */
public final class FilterSelectionDialogFragment$onCreateView$3 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ FilterSelectionDialogFragment this$0;

    FilterSelectionDialogFragment$onCreateView$3(FilterSelectionDialogFragment filterSelectionDialogFragment) {
        this.this$0 = filterSelectionDialogFragment;
    }

    public void onPageSelected(int i) {
        DialogfragmentDeviceFilterSelectionBinding access$getViewDataBinding$p = this.this$0.viewDataBinding;
        DialogfragmentDeviceFilterSelectionBinding dialogfragmentDeviceFilterSelectionBinding = null;
        if (access$getViewDataBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            access$getViewDataBinding$p = null;
        }
        boolean z = false;
        access$getViewDataBinding$p.btnLeft.setEnabled(i != 0);
        DialogfragmentDeviceFilterSelectionBinding access$getViewDataBinding$p2 = this.this$0.viewDataBinding;
        if (access$getViewDataBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceFilterSelectionBinding = access$getViewDataBinding$p2;
        }
        ImageButton imageButton = dialogfragmentDeviceFilterSelectionBinding.btnRight;
        if (i != this.this$0.getPagerAdapter().getItemCount() - 1) {
            z = true;
        }
        imageButton.setEnabled(z);
    }
}
