package com.blueair.devicedetails.fragment;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/fragment/DeviceHSensorsFragment$setupGraphTabs$1$2", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "v", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHSensorsFragment.kt */
public final class DeviceHSensorsFragment$setupGraphTabs$1$2 extends AccessibilityDelegateCompat {
    final /* synthetic */ int $index;
    final /* synthetic */ DeviceHSensorsFragment this$0;

    DeviceHSensorsFragment$setupGraphTabs$1$2(DeviceHSensorsFragment deviceHSensorsFragment, int i) {
        this.this$0 = deviceHSensorsFragment;
        this.$index = i;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setStateDescription(this.this$0.getString(R.string.device_details_sensor_type_state_description, Integer.valueOf(this.$index + 1), Integer.valueOf(this.this$0.getViewModel().getSupportedSensors().size())));
    }
}
