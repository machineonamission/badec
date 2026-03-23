package com.blueair.viewcore;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"unbold", "", "Landroid/widget/TextView;", "bold", "italicize", "boldItalicize", "showOrHide", "Landroid/view/View;", "visible", "", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static final void unbold(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTypeface((Typeface) null, 0);
    }

    public static final void bold(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTypeface(textView.getTypeface(), 1);
    }

    public static final void italicize(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTypeface(textView.getTypeface(), 2);
    }

    public static final void boldItalicize(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTypeface(textView.getTypeface(), 3);
    }

    public static final void showOrHide(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 4);
    }
}
