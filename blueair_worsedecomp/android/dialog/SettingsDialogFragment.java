package com.blueair.android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.databinding.DialogfragmentSettingsBinding;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.push.NotificationService;
import com.blueair.sdk.GoogleOssSdk;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020.H\u0016J\b\u00102\u001a\u00020.H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/blueair/android/dialog/SettingsDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "Lkotlin/Lazy;", "viewDataBinding", "Lcom/blueair/android/databinding/DialogfragmentSettingsBinding;", "getViewDataBinding", "()Lcom/blueair/android/databinding/DialogfragmentSettingsBinding;", "setViewDataBinding", "(Lcom/blueair/android/databinding/DialogfragmentSettingsBinding;)V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "firstResume", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupAccessibility", "", "showProgress", "shouldShowProgress", "onStart", "onPause", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SettingsDialogFragment.kt */
public final class SettingsDialogFragment extends BaseDialogFragment<HomeViewModel> implements ProgressFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SettingsDialogFragment.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0))};
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean firstResume;
    private final Lazy notificationService$delegate;
    private ProgressBlockerView progressBlockerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_SETTINGS;
    public DialogfragmentSettingsBinding viewDataBinding;
    public HomeViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/android/dialog/SettingsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/dialog/SettingsDialogFragment;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SettingsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsDialogFragment newInstance() {
            return new SettingsDialogFragment();
        }
    }

    public SettingsDialogFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new SettingsDialogFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.notificationService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, NotificationService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        this.firstResume = true;
    }

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final NotificationService getNotificationService() {
        return (NotificationService) this.notificationService$delegate.getValue();
    }

    public final DialogfragmentSettingsBinding getViewDataBinding() {
        DialogfragmentSettingsBinding dialogfragmentSettingsBinding = this.viewDataBinding;
        if (dialogfragmentSettingsBinding != null) {
            return dialogfragmentSettingsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        return null;
    }

    public final void setViewDataBinding(DialogfragmentSettingsBinding dialogfragmentSettingsBinding) {
        Intrinsics.checkNotNullParameter(dialogfragmentSettingsBinding, "<set-?>");
        this.viewDataBinding = dialogfragmentSettingsBinding;
    }

    public HomeViewModel getViewModel() {
        HomeViewModel homeViewModel = this.viewModel;
        if (homeViewModel != null) {
            return homeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(HomeViewModel homeViewModel) {
        Intrinsics.checkNotNullParameter(homeViewModel, "<set-?>");
        this.viewModel = homeViewModel;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public ConstraintLayout getRootView() {
        ConstraintLayout constraintLayout = getViewDataBinding().rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        HomeViewModel homeViewModel = (HomeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(HomeViewModel.class));
        setViewModel(homeViewModel);
        DialogfragmentSettingsBinding inflate = DialogfragmentSettingsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setHomeViewModel(homeViewModel);
        inflate.setLifecycleOwner(requireActivity());
        setViewDataBinding(inflate);
        getViewModel().getTemperatureSettings();
        if (getNotificationService().getEnabled()) {
            LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new SettingsDialogFragment$onCreateView$3(this, (Continuation<? super SettingsDialogFragment$onCreateView$3>) null));
            getViewDataBinding().itemNotification.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda0(this));
        } else {
            onCreateView$setNotificationCenterVisibility(this, false);
        }
        getViewDataBinding().closeBtn.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda1(this));
        getViewDataBinding().itemTempSetting.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda2(this));
        LinearLayout linearLayout = getViewDataBinding().itemLicense;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "itemLicense");
        ViewExtensionsKt.hide(linearLayout);
        getViewDataBinding().itemLicense.setOnClickListener(new SettingsDialogFragment$$ExternalSyntheticLambda3(this));
        setupAccessibility();
        View root = getViewDataBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$setNotificationCenterVisibility(SettingsDialogFragment settingsDialogFragment, boolean z) {
        LinearLayout linearLayout = settingsDialogFragment.getViewDataBinding().itemNotification;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "itemNotification");
        int i = 0;
        linearLayout.setVisibility(z ? 0 : 8);
        View view = settingsDialogFragment.getViewDataBinding().notificationSeparator;
        Intrinsics.checkNotNullExpressionValue(view, "notificationSeparator");
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3(SettingsDialogFragment settingsDialogFragment, View view) {
        FragmentManager childFragmentManager = settingsDialogFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<NotificationCenterDialogFragment> cls = NotificationCenterDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("NotificationCenterDialogFragment", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("NotificationCenterDialogFragment") instanceof NotificationCenterDialogFragment) && !childFragmentManager.isStateSaved()) {
            NotificationCenterDialogFragment.Companion.newInstance().show(childFragmentManager, "NotificationCenterDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4(SettingsDialogFragment settingsDialogFragment, View view) {
        settingsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5(SettingsDialogFragment settingsDialogFragment, View view) {
        settingsDialogFragment.getViewModel().toggleIsTempCelsius();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6(SettingsDialogFragment settingsDialogFragment, View view) {
        GoogleOssSdk googleOssSdk = GoogleOssSdk.INSTANCE;
        Context requireContext = settingsDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        googleOssSdk.startOssLicensesMenuActivity(requireContext);
    }

    private final void setupAccessibility() {
        getViewDataBinding().itemTempSetting.setAccessibilityDelegate(new SettingsDialogFragment$setupAccessibility$1());
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onPause() {
        super.onPause();
        this.firstResume = false;
        hideProgress(getContext());
    }
}
