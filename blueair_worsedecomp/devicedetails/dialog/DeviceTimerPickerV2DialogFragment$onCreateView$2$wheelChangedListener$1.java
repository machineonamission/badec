package com.blueair.devicedetails.dialog;

import com.blueair.devicedetails.databinding.DialogfragmentDeviceTimerPickerV2Binding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/blueair/devicedetails/dialog/DeviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1", "Lcom/github/gzuliyujiang/wheelview/contract/OnWheelChangedListener;", "onWheelScrolled", "", "view", "Lcom/github/gzuliyujiang/wheelview/widget/WheelView;", "offset", "", "onWheelSelected", "position", "onWheelScrollStateChanged", "state", "onWheelLoopFinished", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceTimerPickerV2DialogFragment.kt */
public final class DeviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1 implements OnWheelChangedListener {
    final /* synthetic */ DialogfragmentDeviceTimerPickerV2Binding $this_run;

    public void onWheelLoopFinished(WheelView wheelView) {
    }

    public void onWheelScrollStateChanged(WheelView wheelView, int i) {
    }

    public void onWheelScrolled(WheelView wheelView, int i) {
    }

    DeviceTimerPickerV2DialogFragment$onCreateView$2$wheelChangedListener$1(DialogfragmentDeviceTimerPickerV2Binding dialogfragmentDeviceTimerPickerV2Binding) {
        this.$this_run = dialogfragmentDeviceTimerPickerV2Binding;
    }

    public void onWheelSelected(WheelView wheelView, int i) {
        Intrinsics.checkNotNullParameter(wheelView, ViewHierarchyConstants.VIEW_KEY);
        Integer num = (Integer) this.$this_run.wheelMinute.getCurrentItem();
        Integer num2 = (Integer) this.$this_run.wheelHour.getCurrentItem();
        this.$this_run.btnDone.setEnabled(num == null || num.intValue() != 0 || num2 == null || num2.intValue() != 0);
    }
}
