package com.blueair.devicedetails.activity;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"com/blueair/devicedetails/activity/DeviceSettingsActivity$onCreate$6", "Landroidx/core/widget/NestedScrollView$OnScrollChangeListener;", "lastScrollTime", "", "getLastScrollTime", "()J", "setLastScrollTime", "(J)V", "onScrollChange", "", "v", "Landroidx/core/widget/NestedScrollView;", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsActivity.kt */
public final class DeviceSettingsActivity$onCreate$6 implements NestedScrollView.OnScrollChangeListener {
    private long lastScrollTime;
    final /* synthetic */ DeviceSettingsActivity this$0;

    DeviceSettingsActivity$onCreate$6(DeviceSettingsActivity deviceSettingsActivity) {
        this.this$0 = deviceSettingsActivity;
    }

    public final long getLastScrollTime() {
        return this.lastScrollTime;
    }

    public final void setLastScrollTime(long j) {
        this.lastScrollTime = j;
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "v");
        this.lastScrollTime = System.currentTimeMillis();
        ActivityDeviceSettingsBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.bottomBar.setBackgroundColor(-1);
        ActivityDeviceSettingsBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        View view = access$getBinding$p2.separator;
        Intrinsics.checkNotNullExpressionValue(view, "separator");
        ViewExtensionsKt.show$default(view, false, 1, (Object) null);
        nestedScrollView.postDelayed(new DeviceSettingsActivity$onCreate$6$onScrollChange$$inlined$postDelayed$1(this, this.this$0), 300);
    }
}
