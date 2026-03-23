package com.blueair.viewcore.dialog;

import android.content.Intent;
import android.view.View;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\r\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"com/blueair/viewcore/dialog/TroubleshootingDialog$Companion$buildLegacyClickableSpan$1", "Lcom/blueair/viewcore/utils/NoUnderlineClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "providerLinkColor", "", "()Ljava/lang/Integer;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TroubleshootingDialog.kt */
public final class TroubleshootingDialog$Companion$buildLegacyClickableSpan$1 extends NoUnderlineClickableSpan {
    final /* synthetic */ int $linkColor;

    TroubleshootingDialog$Companion$buildLegacyClickableSpan$1(int i) {
        this.$linkColor = i;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        view.getContext().startActivity(new Intent("blueair.action.adddevicelegacy"));
    }

    public Integer providerLinkColor() {
        return Integer.valueOf(this.$linkColor);
    }
}
