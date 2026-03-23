package com.blueair.viewcore;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.projectodd.stilts.stomp.protocol.StompFrame;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/viewcore/ViewUtils$setAccessibilityDelegate$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils$setAccessibilityDelegate$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ Function2<View, AccessibilityNodeInfoCompat, Unit> $initializer;
    final /* synthetic */ KClass<? extends View> $kClass;
    final /* synthetic */ String $tooltip;

    ViewUtils$setAccessibilityDelegate$1(KClass<? extends View> kClass, String str, Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> function2) {
        this.$kClass = kClass;
        this.$tooltip = str;
        this.$initializer = function2;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, StompFrame.Header.HOST);
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        KClass<? extends View> kClass = this.$kClass;
        if (kClass != null) {
            accessibilityNodeInfoCompat.setClassName(JvmClassMappingKt.getJavaClass(kClass).getName());
        }
        String str = this.$tooltip;
        if (str != null) {
            accessibilityNodeInfoCompat.setTooltipText(str);
        }
        Function2<View, AccessibilityNodeInfoCompat, Unit> function2 = this.$initializer;
        if (function2 != null) {
            function2.invoke(view, accessibilityNodeInfoCompat);
        }
    }
}
