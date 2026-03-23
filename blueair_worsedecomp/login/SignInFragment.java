package com.blueair.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.core.BuildEnvironment;
import com.blueair.login.databinding.FragmentSignInBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078TX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/blueair/login/SignInFragment;", "Lcom/blueair/login/BaseLoginFragment;", "<init>", "()V", "keyboardSub", "Lio/reactivex/disposables/Disposable;", "viewModel", "Lcom/blueair/login/SignInViewModel;", "getViewModel", "()Lcom/blueair/login/SignInViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "hoverEnterDelayed", "editText", "Landroid/widget/EditText;", "setTermsAndPrivacySpan", "cbPrivacy", "Landroid/widget/TextView;", "setRequiredBold", "spannableString", "Landroid/text/SpannableString;", "onPause", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SignInFragment.kt */
public final class SignInFragment extends BaseLoginFragment {
    private Disposable keyboardSub;
    private final Lazy viewModel$delegate;

    public SignInFragment() {
        super(R.layout.fragment_sign_in);
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SignInFragment$special$$inlined$viewModels$default$2(new SignInFragment$special$$inlined$viewModels$default$1(fragment)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SignInViewModel.class), new SignInFragment$special$$inlined$viewModels$default$3(lazy), new SignInFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new SignInFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: protected */
    public SignInViewModel getViewModel() {
        return (SignInViewModel) this.viewModel$delegate.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentSignInBinding");
        FragmentSignInBinding fragmentSignInBinding = (FragmentSignInBinding) binding;
        fragmentSignInBinding.btnForgotPassword.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda4(this));
        fragmentSignInBinding.ivClose.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda5(this));
        fragmentSignInBinding.ivBack.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda6(this));
        fragmentSignInBinding.btnRegister.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda7(this));
        fragmentSignInBinding.btnLogin.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda8(view, this));
        FragmentActivity activity = getActivity();
        LoginActivity loginActivity = activity instanceof LoginActivity ? (LoginActivity) activity : null;
        if (loginActivity != null) {
            loginActivity.setStatusMode(false);
            ViewGroup.LayoutParams layoutParams = fragmentSignInBinding.toolbar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = loginActivity.getStatusBarHeight();
                fragmentSignInBinding.toolbar.setLayoutParams(layoutParams);
            }
        }
        if (BuildEnvironment.INSTANCE.isChina()) {
            TextView textView = fragmentSignInBinding.privacyText;
            Intrinsics.checkNotNullExpressionValue(textView, "privacyText");
            setTermsAndPrivacySpan(textView);
            Group group = fragmentSignInBinding.groupPrivacy;
            Intrinsics.checkNotNullExpressionValue(group, "groupPrivacy");
            ViewExtensionsKt.show$default(group, false, 1, (Object) null);
        } else {
            Group group2 = fragmentSignInBinding.groupPrivacy;
            Intrinsics.checkNotNullExpressionValue(group2, "groupPrivacy");
            ViewExtensionsKt.hide(group2);
            getViewModel().setPrivacyConfirmed();
        }
        SignInViewModel viewModel = getViewModel();
        LifecycleOwner lifecycleOwner = this;
        BaseLoginViewModelKt.observe(lifecycleOwner, viewModel.getPasswordGetter(), new SignInFragment$$ExternalSyntheticLambda9(this));
        BaseLoginViewModelKt.observe(lifecycleOwner, viewModel.getEmailValid(), new SignInFragment$$ExternalSyntheticLambda10(this));
        BaseLoginViewModelKt.observe(lifecycleOwner, viewModel.getPasswordValid(), new SignInFragment$$ExternalSyntheticLambda11(this, viewModel));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$0(SignInFragment signInFragment, View view) {
        signInFragment.show(new ForgotPasswordFragment());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$1(SignInFragment signInFragment, View view) {
        FragmentActivity activity = signInFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$2(SignInFragment signInFragment, View view) {
        FragmentActivity activity = signInFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$3(SignInFragment signInFragment, View view) {
        signInFragment.show(new RegisterFragment());
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$4(View view, SignInFragment signInFragment, View view2) {
        ViewHelperUtil.INSTANCE.hideSoftKeyboard(view);
        signInFragment.getViewModel().emailLogin();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$16$lambda$9(SignInFragment signInFragment, Function1 function1) {
        View inflate = signInFragment.requireActivity().getLayoutInflater().inflate(R.layout.dialog_enter_password, (ViewGroup) null);
        AlertDialog show = new AlertDialog.Builder(signInFragment.requireContext()).setView(inflate).show();
        ((MaterialButton) inflate.findViewById(R.id.ok_view)).setOnClickListener(new SignInFragment$$ExternalSyntheticLambda0(function1, (TextInputLayout) inflate.findViewById(R.id.editTextLayout), show));
        ((MaterialButton) inflate.findViewById(R.id.cancel_view)).setOnClickListener(new SignInFragment$$ExternalSyntheticLambda3(signInFragment, function1, show));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$16$lambda$9$lambda$7(Function1 function1, TextInputLayout textInputLayout, AlertDialog alertDialog, View view) {
        String str;
        Editable text;
        if (function1 != null) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            function1.invoke(str);
        }
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$16$lambda$9$lambda$8(SignInFragment signInFragment, Function1 function1, AlertDialog alertDialog, View view) {
        signInFragment.getViewModel().facebookLogout();
        if (function1 != null) {
            function1.invoke(null);
        }
        alertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$16$lambda$12(SignInFragment signInFragment, Boolean bool) {
        if (bool == null) {
            return Unit.INSTANCE;
        }
        bool.booleanValue();
        ViewDataBinding binding = signInFragment.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentSignInBinding");
        FragmentSignInBinding fragmentSignInBinding = (FragmentSignInBinding) binding;
        fragmentSignInBinding.txtEmail.setSelected(!bool.booleanValue());
        fragmentSignInBinding.txtEmail.setEndIconVisible(!bool.booleanValue());
        if (!bool.booleanValue()) {
            SimpleTextInputLayout simpleTextInputLayout = fragmentSignInBinding.txtEmail;
            CharSequence text = fragmentSignInBinding.txtEmailError.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            simpleTextInputLayout.setErrorText(text);
            fragmentSignInBinding.txtEmail.requestFocus();
            EditText editText = fragmentSignInBinding.txtEmail.getEditText();
            if (editText != null) {
                signInFragment.hoverEnterDelayed(editText);
            }
        } else {
            fragmentSignInBinding.txtEmail.setErrorText("");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$16$lambda$15(SignInFragment signInFragment, SignInViewModel signInViewModel, Boolean bool) {
        if (bool == null) {
            return Unit.INSTANCE;
        }
        bool.booleanValue();
        ViewDataBinding binding = signInFragment.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentSignInBinding");
        FragmentSignInBinding fragmentSignInBinding = (FragmentSignInBinding) binding;
        fragmentSignInBinding.txtPassword.setSelected(!bool.booleanValue());
        if (bool.booleanValue() || !Intrinsics.areEqual((Object) signInViewModel.getEmailValid().getValue(), (Object) true)) {
            fragmentSignInBinding.txtPassword.setErrorText("");
        } else {
            SimpleTextInputLayout simpleTextInputLayout = fragmentSignInBinding.txtPassword;
            CharSequence text = fragmentSignInBinding.txtPasswordError.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            simpleTextInputLayout.setErrorText(text);
            fragmentSignInBinding.txtPassword.requestFocus();
            EditText editText = fragmentSignInBinding.txtPassword.getEditText();
            if (editText != null) {
                signInFragment.hoverEnterDelayed(editText);
            }
        }
        return Unit.INSTANCE;
    }

    private final void hoverEnterDelayed(EditText editText) {
        editText.postDelayed(new SignInFragment$$ExternalSyntheticLambda2(editText), 10);
    }

    /* access modifiers changed from: private */
    public static final void hoverEnterDelayed$lambda$17(EditText editText) {
        editText.sendAccessibilityEvent(128);
    }

    private final void setTermsAndPrivacySpan(TextView textView) {
        CharSequence text = textView.getText();
        Intrinsics.checkNotNull(text);
        if (text.length() != 0) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            SpannableString spannableString = new SpannableString(text);
            String string = getString(R.string.terms_of_service);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(R.string.privacy_policy);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int indexOf$default = StringsKt.indexOf$default(text, string, 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                int length = string.length() + indexOf$default;
                spannableString.setSpan(new SignInFragment$setTermsAndPrivacySpan$1(this), indexOf$default, length, 33);
                spannableString.setSpan(new StyleSpan(1), indexOf$default, length, 33);
                spannableString.setSpan(new ForegroundColorSpan(-1), indexOf$default, length, 33);
            }
            String str = string2;
            int indexOf$default2 = StringsKt.indexOf$default(text, str, 0, false, 6, (Object) null);
            if (indexOf$default2 != -1) {
                int length2 = str.length() + indexOf$default2;
                spannableString.setSpan(new SignInFragment$setTermsAndPrivacySpan$2(this), indexOf$default2, length2, 33);
                spannableString.setSpan(new StyleSpan(1), indexOf$default2, length2, 33);
                spannableString.setSpan(new ForegroundColorSpan(-1), indexOf$default2, length2, 33);
            }
            setRequiredBold(spannableString);
            textView.setText(spannableString);
            textView.setOnTouchListener(new SignInFragment$$ExternalSyntheticLambda1());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (android.widget.TextView) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean setTermsAndPrivacySpan$lambda$18(android.view.View r3, android.view.MotionEvent r4) {
        /*
            boolean r0 = r3 instanceof android.widget.TextView
            if (r0 == 0) goto L_0x0030
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.text.method.MovementMethod r0 = r3.getMovementMethod()
            if (r0 == 0) goto L_0x0030
            java.lang.CharSequence r1 = r3.getText()
            boolean r1 = r1 instanceof android.text.Spannable
            if (r1 == 0) goto L_0x0030
            int r1 = r4.getAction()
            r2 = 1
            if (r1 != r2) goto L_0x0030
            java.lang.CharSequence r1 = r3.getText()
            java.lang.String r2 = "null cannot be cast to non-null type android.text.Spannable"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.text.Spannable r1 = (android.text.Spannable) r1
            boolean r3 = r0.onTouchEvent(r3, r1, r4)
            if (r3 == 0) goto L_0x0030
            r3 = 3
            r4.setAction(r3)
        L_0x0030:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.SignInFragment.setTermsAndPrivacySpan$lambda$18(android.view.View, android.view.MotionEvent):boolean");
    }

    private final void setRequiredBold(SpannableString spannableString) {
        String string = getString(R.string.bracketed_required);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, string, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            spannableString.setSpan(new StyleSpan(1), indexOf$default, string.length() + indexOf$default, 33);
        }
    }

    public void onPause() {
        super.onPause();
        Disposable disposable = this.keyboardSub;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
