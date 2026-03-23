package com.blueair.login;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.viewhelper.ViewHelperUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058TX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/login/ForgotPasswordFragment;", "Lcom/blueair/login/BaseLoginFragment;", "<init>", "()V", "viewModel", "Lcom/blueair/login/ForgotPasswordViewModel;", "getViewModel", "()Lcom/blueair/login/ForgotPasswordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ForgotPasswordFragment.kt */
public final class ForgotPasswordFragment extends BaseLoginFragment {
    private final Lazy viewModel$delegate;

    public ForgotPasswordFragment() {
        super(R.layout.fragment_forgot_password);
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ForgotPasswordFragment$special$$inlined$viewModels$default$2(new ForgotPasswordFragment$special$$inlined$viewModels$default$1(fragment)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class), new ForgotPasswordFragment$special$$inlined$viewModels$default$3(lazy), new ForgotPasswordFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new ForgotPasswordFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: protected */
    public ForgotPasswordViewModel getViewModel() {
        return (ForgotPasswordViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            super.onViewCreated(r9, r10)
            androidx.databinding.ViewDataBinding r10 = r8.getBinding()
            java.lang.String r0 = "null cannot be cast to non-null type com.blueair.login.databinding.FragmentForgotPasswordBinding"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r0)
            com.blueair.login.databinding.FragmentForgotPasswordBinding r10 = (com.blueair.login.databinding.FragmentForgotPasswordBinding) r10
            androidx.appcompat.widget.AppCompatImageButton r0 = r10.btnBack
            com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda0 r1 = new com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda0
            r1.<init>(r8)
            r0.setOnClickListener(r1)
            androidx.appcompat.widget.AppCompatImageButton r0 = r10.btnClose
            com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda1 r1 = new com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda1
            r1.<init>(r8)
            r0.setOnClickListener(r1)
            androidx.lifecycle.LifecycleOwner r0 = r8.getViewLifecycleOwner()
            java.lang.String r1 = "getViewLifecycleOwner(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.blueair.login.ForgotPasswordFragment$onViewCreated$1$3 r0 = new com.blueair.login.ForgotPasswordFragment$onViewCreated$1$3
            r7 = 0
            r0.<init>(r8, r10, r7)
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            boolean r1 = r0 instanceof com.blueair.login.LoginActivity
            if (r1 == 0) goto L_0x0052
            r7 = r0
            com.blueair.login.LoginActivity r7 = (com.blueair.login.LoginActivity) r7
        L_0x0052:
            if (r7 == 0) goto L_0x0070
            r0 = 1
            r7.setStatusMode(r0)
            com.google.android.material.appbar.MaterialToolbar r0 = r10.toolbar
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r1 == 0) goto L_0x0070
            r1 = r0
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r2 = r7.getStatusBarHeight()
            r1.topMargin = r2
            com.google.android.material.appbar.MaterialToolbar r10 = r10.toolbar
            r10.setLayoutParams(r0)
        L_0x0070:
            com.blueair.login.ForgotPasswordViewModel r10 = r8.getViewModel()
            r0 = r8
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.LiveData r1 = r10.getForgotFinished()
            com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda2 r2 = new com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda2
            r2.<init>(r9, r8)
            com.blueair.login.BaseLoginViewModelKt.observe(r0, r1, r2)
            androidx.lifecycle.MutableLiveData r9 = r10.getEmail()
            androidx.lifecycle.LiveData r9 = (androidx.lifecycle.LiveData) r9
            com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda3 r1 = new com.blueair.login.ForgotPasswordFragment$$ExternalSyntheticLambda3
            r1.<init>(r10)
            com.blueair.login.BaseLoginViewModelKt.observe(r0, r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.ForgotPasswordFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$0(ForgotPasswordFragment forgotPasswordFragment, View view) {
        FragmentActivity activity = forgotPasswordFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$1(ForgotPasswordFragment forgotPasswordFragment, View view) {
        FragmentActivity activity = forgotPasswordFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6$lambda$4(View view, ForgotPasswordFragment forgotPasswordFragment, Unit unit) {
        ViewHelperUtil.INSTANCE.hideSoftKeyboard(view);
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        FragmentActivity requireActivity = forgotPasswordFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        viewUtils.showSnackbar((Activity) requireActivity, R.string.msg_reset_password_success, (ViewUtils.MessageType) ViewUtils.MessageType.SUCCESS.INSTANCE);
        forgotPasswordFragment.requireActivity().getSupportFragmentManager().popBackStack();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6$lambda$5(ForgotPasswordViewModel forgotPasswordViewModel, String str) {
        forgotPasswordViewModel.checkEmailInput();
        return Unit.INSTANCE;
    }
}
