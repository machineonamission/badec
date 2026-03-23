package com.blueair.android.fragment;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.activity.InfoActivity;
import com.blueair.android.databinding.FragmentPoliciesBinding;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.core.util.LinkUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/blueair/android/fragment/PoliciesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "<init>", "()V", "viewDataBinding", "Lcom/blueair/android/databinding/FragmentPoliciesBinding;", "getViewDataBinding", "()Lcom/blueair/android/databinding/FragmentPoliciesBinding;", "setViewDataBinding", "(Lcom/blueair/android/databinding/FragmentPoliciesBinding;)V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showProgress", "", "shouldShowProgress", "", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PoliciesFragment.kt */
public final class PoliciesFragment extends BaseFragment<HomeViewModel> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public FragmentPoliciesBinding viewDataBinding;
    public HomeViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/android/fragment/PoliciesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/fragment/PoliciesFragment;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: PoliciesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PoliciesFragment newInstance() {
            return new PoliciesFragment();
        }
    }

    public final FragmentPoliciesBinding getViewDataBinding() {
        FragmentPoliciesBinding fragmentPoliciesBinding = this.viewDataBinding;
        if (fragmentPoliciesBinding != null) {
            return fragmentPoliciesBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        return null;
    }

    public final void setViewDataBinding(FragmentPoliciesBinding fragmentPoliciesBinding) {
        Intrinsics.checkNotNullParameter(fragmentPoliciesBinding, "<set-?>");
        this.viewDataBinding = fragmentPoliciesBinding;
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentPoliciesBinding inflate = FragmentPoliciesBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((HomeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(HomeViewModel.class)));
        inflate.setLifecycleOwner(requireActivity());
        setViewDataBinding(inflate);
        getViewDataBinding().privacyPolicyClickview.setOnClickListener(new PoliciesFragment$$ExternalSyntheticLambda0(this));
        getViewDataBinding().icpNo.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView = getViewDataBinding().icpNo;
        Intrinsics.checkNotNullExpressionValue(textView, "icpNo");
        ViewExtensionsKt.show(textView, getViewModel().shouldShowIcpNo());
        View root = getViewDataBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$1(PoliciesFragment policiesFragment, View view) {
        InfoActivity.Companion companion = InfoActivity.Companion;
        FragmentActivity requireActivity = policiesFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        String privacyLinkFromCountryCode = LinkUtils.INSTANCE.getPrivacyLinkFromCountryCode(policiesFragment.getViewModel().getCountry());
        String string = policiesFragment.getString(R.string.privacy_and_terms);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        policiesFragment.startActivity(companion.gotoWebView(requireActivity, privacyLinkFromCountryCode, string));
    }
}
