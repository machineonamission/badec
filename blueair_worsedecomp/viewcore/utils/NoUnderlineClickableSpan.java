package com.blueair.viewcore.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/viewcore/utils/NoUnderlineClickableSpan;", "Landroid/text/style/ClickableSpan;", "<init>", "()V", "providerLinkColor", "", "()Ljava/lang/Integer;", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NoUnderlineClickableSpan.kt */
public abstract class NoUnderlineClickableSpan extends ClickableSpan {
    public Integer providerLinkColor() {
        return null;
    }

    public final void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        Integer providerLinkColor = providerLinkColor();
        if (providerLinkColor != null) {
            textPaint.setColor(providerLinkColor.intValue());
        }
        textPaint.setUnderlineText(false);
    }
}
