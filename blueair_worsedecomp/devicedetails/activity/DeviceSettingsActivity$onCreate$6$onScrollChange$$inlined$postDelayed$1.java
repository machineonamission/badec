package com.blueair.devicedetails.activity;

import android.view.View;
import com.blueair.devicedetails.databinding.ActivityDeviceSettingsBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$postDelayed$runnable$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: View.kt */
public final class DeviceSettingsActivity$onCreate$6$onScrollChange$$inlined$postDelayed$1 implements Runnable {
    final /* synthetic */ DeviceSettingsActivity$onCreate$6 this$0;
    final /* synthetic */ DeviceSettingsActivity this$1$inlined;

    public DeviceSettingsActivity$onCreate$6$onScrollChange$$inlined$postDelayed$1(DeviceSettingsActivity$onCreate$6 deviceSettingsActivity$onCreate$6, DeviceSettingsActivity deviceSettingsActivity) {
        this.this$0 = deviceSettingsActivity$onCreate$6;
        this.this$1$inlined = deviceSettingsActivity;
    }

    public final void run() {
        if (System.currentTimeMillis() - this.this$0.getLastScrollTime() > 250) {
            ActivityDeviceSettingsBinding access$getBinding$p = this.this$1$inlined.binding;
            ActivityDeviceSettingsBinding activityDeviceSettingsBinding = null;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            access$getBinding$p.bottomBar.setBackgroundColor(0);
            ActivityDeviceSettingsBinding access$getBinding$p2 = this.this$1$inlined.binding;
            if (access$getBinding$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceSettingsBinding = access$getBinding$p2;
            }
            View view = activityDeviceSettingsBinding.separator;
            Intrinsics.checkNotNullExpressionValue(view, "separator");
            ViewExtensionsKt.hide(view);
        }
    }
}
