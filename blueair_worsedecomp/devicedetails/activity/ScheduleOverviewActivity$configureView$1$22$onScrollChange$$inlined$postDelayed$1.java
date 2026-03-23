package com.blueair.devicedetails.activity;

import android.view.View;
import com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$postDelayed$runnable$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: View.kt */
public final class ScheduleOverviewActivity$configureView$1$22$onScrollChange$$inlined$postDelayed$1 implements Runnable {
    final /* synthetic */ ActivityDeviceScheduleOverviewBinding $this_apply$inlined;
    final /* synthetic */ ScheduleOverviewActivity$configureView$1$22 this$0;

    public ScheduleOverviewActivity$configureView$1$22$onScrollChange$$inlined$postDelayed$1(ScheduleOverviewActivity$configureView$1$22 scheduleOverviewActivity$configureView$1$22, ActivityDeviceScheduleOverviewBinding activityDeviceScheduleOverviewBinding) {
        this.this$0 = scheduleOverviewActivity$configureView$1$22;
        this.$this_apply$inlined = activityDeviceScheduleOverviewBinding;
    }

    public final void run() {
        if (System.currentTimeMillis() - this.this$0.getLastScrollTime() > 250) {
            this.$this_apply$inlined.bottomBar.setBackgroundColor(0);
            View view = this.$this_apply$inlined.separator;
            Intrinsics.checkNotNullExpressionValue(view, "separator");
            ViewExtensionsKt.hide(view);
        }
    }
}
