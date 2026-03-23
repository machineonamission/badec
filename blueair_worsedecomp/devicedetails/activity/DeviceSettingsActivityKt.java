package com.blueair.devicedetails.activity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"changeToolbarFont", "", "Landroidx/appcompat/widget/Toolbar;", "context", "Landroid/content/Context;", "fontRes", "", "devicedetails_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsActivity.kt */
public final class DeviceSettingsActivityKt {
    public static final void changeToolbarFont(Toolbar toolbar, Context context, int i) {
        Intrinsics.checkNotNullParameter(toolbar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int childCount = toolbar.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (Intrinsics.areEqual((Object) textView.getText(), (Object) toolbar.getTitle())) {
                    textView.setTypeface(ResourcesCompat.getFont(context, i));
                    return;
                }
            }
        }
    }
}
