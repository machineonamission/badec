package com.blueair.devicedetails.dialog;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceAlarmSoundPickerBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/dialog/DeviceAlarmSoundPickerDialogFragment$onCreateView$2$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarmSoundPickerDialogFragment.kt */
public final class DeviceAlarmSoundPickerDialogFragment$onCreateView$2$5 extends RecyclerView.OnScrollListener {
    final /* synthetic */ DialogfragmentDeviceAlarmSoundPickerBinding $this_run;

    DeviceAlarmSoundPickerDialogFragment$onCreateView$2$5(DialogfragmentDeviceAlarmSoundPickerBinding dialogfragmentDeviceAlarmSoundPickerBinding) {
        this.$this_run = dialogfragmentDeviceAlarmSoundPickerBinding;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i != 0) {
            this.$this_run.bottomBar.setBackgroundColor(-1);
            View view = this.$this_run.separator;
            Intrinsics.checkNotNullExpressionValue(view, "separator");
            ViewExtensionsKt.show$default(view, false, 1, (Object) null);
            return;
        }
        this.$this_run.bottomBar.setBackgroundColor(0);
        View view2 = this.$this_run.separator;
        Intrinsics.checkNotNullExpressionValue(view2, "separator");
        ViewExtensionsKt.hide(view2);
    }
}
