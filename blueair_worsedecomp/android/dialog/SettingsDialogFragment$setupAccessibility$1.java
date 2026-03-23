package com.blueair.android.dialog;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.projectodd.stilts.stomp.protocol.StompFrame;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/android/dialog/SettingsDialogFragment$setupAccessibility$1", "Landroid/view/View$AccessibilityDelegate;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SettingsDialogFragment.kt */
public final class SettingsDialogFragment$setupAccessibility$1 extends View.AccessibilityDelegate {
    SettingsDialogFragment$setupAccessibility$1() {
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, view.getResources().getString(R.string.temperature_scale_click_description)));
    }
}
