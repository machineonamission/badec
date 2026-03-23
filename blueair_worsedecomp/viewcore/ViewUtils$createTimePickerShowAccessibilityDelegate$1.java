package com.blueair.viewcore;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.projectodd.stilts.stomp.protocol.StompFrame;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/viewcore/ViewUtils$createTimePickerShowAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils$createTimePickerShowAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ int $contentDescriptionPatternResourceId;

    ViewUtils$createTimePickerShowAccessibilityDelegate$1(int i) {
        this.$contentDescriptionPatternResourceId = i;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        Resources resources = view.getResources();
        String string = resources.getString(R.string.show_time_picker_action_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, string));
        accessibilityNodeInfoCompat.setRoleDescription(resources.getString(R.string.button_role));
        accessibilityNodeInfoCompat.setContentDescription(resources.getString(this.$contentDescriptionPatternResourceId, new Object[]{((TextView) view).getText()}));
    }
}
