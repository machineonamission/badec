package com.blueair.devicedetails.dialog;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/blueair/devicedetails/dialog/DeviceSetTimezoneDialogFragment$onCreateView$2$6$1$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSetTimezoneDialogFragment.kt */
public final class DeviceSetTimezoneDialogFragment$onCreateView$2$6$1$1 extends LinearSmoothScroller {
    DeviceSetTimezoneDialogFragment$onCreateView$2$6$1$1(Context context) {
        super(context);
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
    }
}
