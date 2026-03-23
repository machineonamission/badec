package com.blueair.viewcore.view;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.projectodd.stilts.stomp.protocol.StompFrame;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/viewcore/view/ScrollingPageIndicatorAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "onGetCurrentItem", "Lkotlin/Function0;", "", "onGetItemCount", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScrollingPageIndicatorAccessibilityDelegate.kt */
public final class ScrollingPageIndicatorAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Function0<Integer> onGetCurrentItem;
    private final Function0<Integer> onGetItemCount;

    public ScrollingPageIndicatorAccessibilityDelegate(Function0<Integer> function0, Function0<Integer> function02) {
        Intrinsics.checkNotNullParameter(function0, "onGetCurrentItem");
        Intrinsics.checkNotNullParameter(function02, "onGetItemCount");
        this.onGetCurrentItem = function0;
        this.onGetItemCount = function02;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setRoleDescription(view.getResources().getString(R.string.page_indicator_role_description));
        accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R.string.page_indicator_content_description, new Object[]{this.onGetCurrentItem.invoke(), this.onGetItemCount.invoke()}));
    }
}
