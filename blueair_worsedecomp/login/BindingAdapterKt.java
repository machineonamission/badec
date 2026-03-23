package com.blueair.login;

import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.BindingAdapter;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\b0\u0005H\u0007\u001a\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"afterTextChange", "Landroid/text/TextWatcher;", "et", "Landroidx/appcompat/widget/AppCompatEditText;", "bloc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "errorText", "Lcom/google/android/material/textfield/TextInputLayout;", "text", "", "login_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: BindingAdapter.kt */
public final class BindingAdapterKt {
    @BindingAdapter({"afterTextChange"})
    public static final TextWatcher afterTextChange(AppCompatEditText appCompatEditText, Function1<? super AppCompatEditText, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "et");
        Intrinsics.checkNotNullParameter(function1, "bloc");
        TextWatcher bindingAdapterKt$afterTextChange$$inlined$doAfterTextChanged$1 = new BindingAdapterKt$afterTextChange$$inlined$doAfterTextChanged$1(function1, appCompatEditText);
        appCompatEditText.addTextChangedListener(bindingAdapterKt$afterTextChange$$inlined$doAfterTextChanged$1);
        return bindingAdapterKt$afterTextChange$$inlined$doAfterTextChanged$1;
    }

    @BindingAdapter({"errorText"})
    public static final void errorText(TextInputLayout textInputLayout, String str) {
        Intrinsics.checkNotNullParameter(textInputLayout, "et");
        textInputLayout.setError(str);
    }
}
