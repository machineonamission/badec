package com.blueair.login;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.blueair.auth.GigyaService;
import com.blueair.login.databinding.FragmentRegisterBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058TX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/blueair/login/RegisterFragment;", "Lcom/blueair/login/BaseLoginFragment;", "<init>", "()V", "viewModel", "Lcom/blueair/login/RegisterViewModel;", "getViewModel", "()Lcom/blueair/login/RegisterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "firstNameView", "Landroid/view/View;", "lastNameView", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "setTermsAndPrivacySpan", "cbPrivacy", "Landroid/widget/TextView;", "setRequiredBold", "spannableString", "Landroid/text/SpannableString;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RegisterFragment.kt */
public final class RegisterFragment extends BaseLoginFragment {
    private View firstNameView;
    private View lastNameView;
    private final Lazy viewModel$delegate;

    public RegisterFragment() {
        super(R.layout.fragment_register);
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new RegisterFragment$special$$inlined$viewModels$default$2(new RegisterFragment$special$$inlined$viewModels$default$1(fragment)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(RegisterViewModel.class), new RegisterFragment$special$$inlined$viewModels$default$3(lazy), new RegisterFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new RegisterFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: protected */
    public RegisterViewModel getViewModel() {
        return (RegisterViewModel) this.viewModel$delegate.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        getViewModel().loadDataCenter();
        RegisterViewModel viewModel = getViewModel();
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentRegisterBinding");
        FragmentRegisterBinding fragmentRegisterBinding = (FragmentRegisterBinding) binding;
        fragmentRegisterBinding.btnBack.setOnClickListener(new RegisterFragment$$ExternalSyntheticLambda0(this));
        fragmentRegisterBinding.btnClose.setOnClickListener(new RegisterFragment$$ExternalSyntheticLambda1(this));
        viewModel.getDataCenter().observe(getViewLifecycleOwner(), new RegisterFragment$sam$androidx_lifecycle_Observer$0(new RegisterFragment$$ExternalSyntheticLambda2(fragmentRegisterBinding, this)));
        FragmentActivity activity = getActivity();
        LoginActivity loginActivity = activity instanceof LoginActivity ? (LoginActivity) activity : null;
        if (loginActivity != null) {
            loginActivity.setStatusMode(true);
            ViewGroup.LayoutParams layoutParams = fragmentRegisterBinding.toolbar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = loginActivity.getStatusBarHeight();
                fragmentRegisterBinding.toolbar.setLayoutParams(layoutParams);
            }
        }
        fragmentRegisterBinding.btnLogin.setOnClickListener(new RegisterFragment$$ExternalSyntheticLambda3(this));
        TextView textView = fragmentRegisterBinding.privacyText;
        Intrinsics.checkNotNullExpressionValue(textView, "privacyText");
        setTermsAndPrivacySpan(textView);
        this.firstNameView = getBinding().getRoot().findViewWithTag("FirstName");
        this.lastNameView = getBinding().getRoot().findViewWithTag("LastName");
        MaterialCheckBox materialCheckBox = fragmentRegisterBinding.cbYears;
        SpannableString spannableString = new SpannableString(materialCheckBox.getText());
        setRequiredBold(spannableString);
        materialCheckBox.setText(spannableString);
        LiveDataExtensionsKt.observeNonNull(viewModel.getFormError(), this, new RegisterFragment$$ExternalSyntheticLambda4(this, viewModel));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$0(RegisterFragment registerFragment, View view) {
        FragmentActivity activity = registerFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$1(RegisterFragment registerFragment, View view) {
        FragmentActivity activity = registerFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6$lambda$2(FragmentRegisterBinding fragmentRegisterBinding, RegisterFragment registerFragment, String str) {
        int i;
        if (Intrinsics.areEqual((Object) str, (Object) GigyaService.EUROPE) || Intrinsics.areEqual((Object) str, (Object) "cn")) {
            i = R.string.password_requirement_3_group;
        } else {
            i = R.string.password_requirement_4_group;
        }
        fragmentRegisterBinding.txtPasswordRequirement.setText(i);
        TextInputEditText textInputEditText = fragmentRegisterBinding.password;
        textInputEditText.setContentDescription(registerFragment.getString(R.string.create_password_required) + TokenParser.SP + registerFragment.getString(i));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$4(RegisterFragment registerFragment, View view) {
        registerFragment.show(new SignInFragment());
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11(RegisterFragment registerFragment, RegisterViewModel registerViewModel, boolean z) {
        Object obj;
        KeyEvent.Callback callback;
        if (z) {
            ViewDataBinding binding = registerFragment.getBinding();
            Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentRegisterBinding");
            FragmentRegisterBinding fragmentRegisterBinding = (FragmentRegisterBinding) binding;
            SimpleTextInputLayout simpleTextInputLayout = null;
            if (!Intrinsics.areEqual((Object) registerViewModel.getFirstNameValid().getValue(), (Object) true) && registerFragment.firstNameView != null) {
                obj = registerFragment.getString(R.string.enter_first_name);
                callback = registerFragment.firstNameView;
            } else if (!Intrinsics.areEqual((Object) registerViewModel.getLastNameValid().getValue(), (Object) true) && registerFragment.lastNameView != null) {
                obj = registerFragment.getString(R.string.enter_last_name);
                callback = registerFragment.lastNameView;
            } else if (registerViewModel.getEmailError().getValue() != null) {
                obj = registerViewModel.getEmailError().getValue();
                callback = (View) fragmentRegisterBinding.txtEmail;
            } else if (registerViewModel.getPasswordError().getValue() != null) {
                obj = registerViewModel.getPasswordError().getValue();
                callback = (View) fragmentRegisterBinding.txtPassword;
            } else if (Intrinsics.areEqual((Object) registerViewModel.getConfirmPasswordValid().getValue(), (Object) false)) {
                obj = fragmentRegisterBinding.txtConfirmPasswordError.getText();
                callback = (View) fragmentRegisterBinding.txtConfirmPassword;
            } else {
                callback = null;
                obj = null;
            }
            if (callback instanceof SimpleTextInputLayout) {
                simpleTextInputLayout = (SimpleTextInputLayout) callback;
            }
            if (simpleTextInputLayout != null) {
                CharSequence charSequence = (CharSequence) obj;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    simpleTextInputLayout.setErrorText(charSequence);
                }
                simpleTextInputLayout.requestFocus();
                EditText editText = simpleTextInputLayout.getEditText();
                if (editText != null) {
                    editText.postDelayed(new RegisterFragment$$ExternalSyntheticLambda6(editText), 10);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(EditText editText) {
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
                spannableString.setSpan(new RegisterFragment$setTermsAndPrivacySpan$1(this), indexOf$default, length, 33);
                spannableString.setSpan(new StyleSpan(1), indexOf$default, length, 33);
            }
            String str = string2;
            int indexOf$default2 = StringsKt.indexOf$default(text, str, 0, false, 6, (Object) null);
            if (indexOf$default2 != -1) {
                int length2 = str.length() + indexOf$default2;
                spannableString.setSpan(new RegisterFragment$setTermsAndPrivacySpan$2(this), indexOf$default2, length2, 33);
                spannableString.setSpan(new StyleSpan(1), indexOf$default2, length2, 33);
            }
            setRequiredBold(spannableString);
            textView.setText(spannableString);
            textView.setOnTouchListener(new RegisterFragment$$ExternalSyntheticLambda5());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (android.widget.TextView) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean setTermsAndPrivacySpan$lambda$12(android.view.View r3, android.view.MotionEvent r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.RegisterFragment.setTermsAndPrivacySpan$lambda$12(android.view.View, android.view.MotionEvent):boolean");
    }

    private final void setRequiredBold(SpannableString spannableString) {
        String string = getString(R.string.bracketed_required);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, string, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            spannableString.setSpan(new StyleSpan(1), indexOf$default, string.length() + indexOf$default, 33);
        }
    }
}
