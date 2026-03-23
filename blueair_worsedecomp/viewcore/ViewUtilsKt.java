package com.blueair.viewcore;

import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.databinding.BindingAdapter;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0002\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"setOnClickListener", "", "Landroid/view/View;", "debounceInterval", "", "listenerBlock", "Lkotlin/Function1;", "setClipToBackground", "bindSelected", "inputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "value", "", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt {
    public static final void setOnClickListener(View view, long j, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "listenerBlock");
        view.setOnClickListener(new DebounceOnClickListener(j, function1));
    }

    public static final void setClipToBackground(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        view.setClipToOutline(true);
    }

    @BindingAdapter({"customSelected"})
    public static final void bindSelected(TextInputLayout textInputLayout, boolean z) {
        Intrinsics.checkNotNullParameter(textInputLayout, "inputLayout");
        textInputLayout.setSelected(z);
        textInputLayout.refreshEndIconDrawableState();
    }
}
