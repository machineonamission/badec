package com.blueair.devicedetails.dialog;

import android.graphics.Outline;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment$onViewCreated$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceNCreateEditScheduleDialogFragment.kt */
public final class DeviceNCreateEditScheduleDialogFragment$onViewCreated$1 extends ViewOutlineProvider {
    final /* synthetic */ DeviceNCreateEditScheduleDialogFragment this$0;

    DeviceNCreateEditScheduleDialogFragment$onViewCreated$1(DeviceNCreateEditScheduleDialogFragment deviceNCreateEditScheduleDialogFragment) {
        this.this$0 = deviceNCreateEditScheduleDialogFragment;
    }

    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(outline, "outline");
        int applyDimension = (int) TypedValue.applyDimension(1, 25.0f, this.this$0.getResources().getDisplayMetrics());
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + applyDimension, (float) applyDimension);
    }
}
