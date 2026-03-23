package com.blueair.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.android.activity.InfoActivity;
import com.blueair.core.util.LinkUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.LoginPendingAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\f\u0010\u001d\u001a\u00020\u0019*\u00020\u0001H\u0004J\b\u0010\u001e\u001a\u00020\u0019H\u0004J\b\u0010\u001f\u001a\u00020\u0019H\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/blueair/login/BaseLoginFragment;", "Landroidx/fragment/app/Fragment;", "layoutId", "", "<init>", "(I)V", "viewModel", "Lcom/blueair/login/BaseLoginViewModel;", "getViewModel", "()Lcom/blueair/login/BaseLoginViewModel;", "binding", "Landroidx/databinding/ViewDataBinding;", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "", "context", "Landroid/content/Context;", "onDestroy", "show", "openPolicies", "openTerms", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLoginFragment.kt */
public abstract class BaseLoginFragment extends Fragment {
    protected ViewDataBinding binding;
    private final int layoutId;
    private final BaseLoginViewModel viewModel;

    public BaseLoginFragment(int i) {
        this.layoutId = i;
    }

    /* access modifiers changed from: protected */
    public BaseLoginViewModel getViewModel() {
        return this.viewModel;
    }

    /* access modifiers changed from: protected */
    public final ViewDataBinding getBinding() {
        ViewDataBinding viewDataBinding = this.binding;
        if (viewDataBinding != null) {
            return viewDataBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setBinding(ViewDataBinding viewDataBinding) {
        Intrinsics.checkNotNullParameter(viewDataBinding, "<set-?>");
        this.binding = viewDataBinding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, this.layoutId, viewGroup, false);
        inflate.setLifecycleOwner(this);
        inflate.setVariable(BR.viewModel, getViewModel());
        Intrinsics.checkNotNull(inflate);
        setBinding(inflate);
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        LoginActivity loginActivity = context instanceof LoginActivity ? (LoginActivity) context : null;
        if (loginActivity != null) {
            BaseLoginViewModel viewModel2 = getViewModel();
            Intrinsics.checkNotNull(viewModel2);
            LifecycleOwner lifecycleOwner = loginActivity;
            BaseLoginViewModelKt.observe(lifecycleOwner, viewModel2.getLoginFinished(), new BaseLoginFragment$$ExternalSyntheticLambda0(viewModel2, this, loginActivity));
            BaseLoginViewModelKt.observe(lifecycleOwner, viewModel2.getLoading(), new BaseLoginFragment$onAttach$1$1$2(loginActivity));
            BaseLoginViewModelKt.observe(lifecycleOwner, viewModel2.getFailure(), new BaseLoginFragment$onAttach$1$1$3(loginActivity));
            if (viewModel2.isUserLoggedIn()) {
                Actions actions = Actions.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                Intent openHomeIntent = actions.openHomeIntent(requireContext);
                if (this instanceof RegisterFragment) {
                    openHomeIntent.putExtra(Actions.ACTION_REGISTER, true);
                }
                loginActivity.startActivity(openHomeIntent);
                loginActivity.setResult(-1);
                loginActivity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onAttach$lambda$5$lambda$4$lambda$2(BaseLoginViewModel baseLoginViewModel, BaseLoginFragment baseLoginFragment, LoginActivity loginActivity, Unit unit) {
        LoginPendingAction loginPendingAction = baseLoginViewModel.getLoginPendingAction();
        Context requireContext = baseLoginFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        Intent intent = loginPendingAction.toIntent(requireContext);
        if (intent == null) {
            Actions actions = Actions.INSTANCE;
            Context requireContext2 = baseLoginFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Intent openHomeIntent = actions.openHomeIntent(requireContext2);
            if (baseLoginFragment instanceof RegisterFragment) {
                openHomeIntent.putExtra(Actions.ACTION_REGISTER, true);
            }
            loginActivity.startActivity(openHomeIntent);
        } else {
            loginActivity.startActivity(intent);
        }
        loginActivity.setResult(-1);
        loginActivity.finish();
        return Unit.INSTANCE;
    }

    public void onDestroy() {
        super.onDestroy();
        BaseLoginViewModel viewModel2 = getViewModel();
        if (viewModel2 != null) {
            viewModel2.setLoginPendingAction(LoginPendingAction.Companion.getEMPTY());
        }
    }

    /* access modifiers changed from: protected */
    public final void show(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.setCustomAnimations(17432578, 17432579, 17432578, 17432579);
        beginTransaction.replace(R.id.fragmentContainer, fragment);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    public final void openPolicies() {
        Intent putExtra = new Intent("blueair.action.info").putExtra(InfoActivity.DISPLAY_KEY, 2).putExtra(InfoActivity.TOOLBAR_TITLE_KEY, getString(R.string.action_policies));
        LinkUtils linkUtils = LinkUtils.INSTANCE;
        BaseLoginViewModel viewModel2 = getViewModel();
        Intrinsics.checkNotNull(viewModel2);
        Intent putExtra2 = putExtra.putExtra(InfoActivity.URL_KEY, linkUtils.getPrivacyLinkFromCountryCode(viewModel2.getCountry()));
        Intrinsics.checkNotNullExpressionValue(putExtra2, "putExtra(...)");
        startActivity(putExtra2);
    }

    /* access modifiers changed from: protected */
    public final void openTerms() {
        Intent putExtra = new Intent("blueair.action.info").putExtra(InfoActivity.DISPLAY_KEY, 2).putExtra(InfoActivity.TOOLBAR_TITLE_KEY, getString(R.string.terms_of_service));
        LinkUtils linkUtils = LinkUtils.INSTANCE;
        BaseLoginViewModel viewModel2 = getViewModel();
        Intrinsics.checkNotNull(viewModel2);
        Intent putExtra2 = putExtra.putExtra(InfoActivity.URL_KEY, linkUtils.getTermsLink(viewModel2.getCountry()));
        Intrinsics.checkNotNullExpressionValue(putExtra2, "putExtra(...)");
        startActivity(putExtra2);
    }
}
