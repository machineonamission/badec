package com.blueair.viewcore.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.core.os.BundleKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.FragmentWebviewBinding;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.WebViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/blueair/viewcore/fragment/WebViewFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/viewcore/viewmodel/WebViewModel;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/FragmentWebviewBinding;", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/WebViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/WebViewModel;)V", "url", "", "getUrl", "()Ljava/lang/String;", "url$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configureWebView", "Landroid/webkit/WebView;", "webView", "progressBar", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "showProgress", "", "shouldShowProgress", "", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WebViewFragment.kt */
public final class WebViewFragment extends BaseFragment<WebViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_URL = "EXTRA_URL";
    private FragmentWebviewBinding binding;
    private final Lazy url$delegate = LazyKt.lazy(new WebViewFragment$$ExternalSyntheticLambda0(this));
    public WebViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/viewcore/fragment/WebViewFragment$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "newInstance", "Lcom/blueair/viewcore/fragment/WebViewFragment;", "url", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WebViewFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebViewFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            WebViewFragment webViewFragment = new WebViewFragment();
            webViewFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(WebViewFragment.EXTRA_URL, str)));
            return webViewFragment;
        }
    }

    public WebViewModel getViewModel() {
        WebViewModel webViewModel = this.viewModel;
        if (webViewModel != null) {
            return webViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(WebViewModel webViewModel) {
        Intrinsics.checkNotNullParameter(webViewModel, "<set-?>");
        this.viewModel = webViewModel;
    }

    private final String getUrl() {
        Object value = this.url$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    /* access modifiers changed from: private */
    public static final String url_delegate$lambda$0(WebViewFragment webViewFragment) {
        return webViewFragment.requireArguments().getString(EXTRA_URL, (String) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((WebViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(WebViewModel.class)));
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_webview, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = (FragmentWebviewBinding) inflate;
        setHasOptionsMenu(true);
        FragmentWebviewBinding fragmentWebviewBinding = this.binding;
        FragmentWebviewBinding fragmentWebviewBinding2 = null;
        if (fragmentWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWebviewBinding = null;
        }
        ProgressBlockerView progressBlockerView = fragmentWebviewBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
        FragmentWebviewBinding fragmentWebviewBinding3 = this.binding;
        if (fragmentWebviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWebviewBinding3 = null;
        }
        WebView webView = fragmentWebviewBinding3.webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        FragmentWebviewBinding fragmentWebviewBinding4 = this.binding;
        if (fragmentWebviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWebviewBinding4 = null;
        }
        configureWebView(webView, fragmentWebviewBinding4.progressView);
        if (getUrl().length() > 0) {
            getViewModel().handleUrl(getUrl(), new WebViewFragment$$ExternalSyntheticLambda1(this));
        }
        FragmentWebviewBinding fragmentWebviewBinding5 = this.binding;
        if (fragmentWebviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWebviewBinding2 = fragmentWebviewBinding5;
        }
        View root = fragmentWebviewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1(WebViewFragment webViewFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        Timber.Forest forest = Timber.Forest;
        forest.d("open url: " + webViewFragment.getUrl() + " | " + str, new Object[0]);
        FragmentWebviewBinding fragmentWebviewBinding = webViewFragment.binding;
        if (fragmentWebviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWebviewBinding = null;
        }
        fragmentWebviewBinding.webView.loadUrl(str);
        return Unit.INSTANCE;
    }

    static /* synthetic */ WebView configureWebView$default(WebViewFragment webViewFragment, WebView webView, ProgressBlockerView progressBlockerView, int i, Object obj) {
        if ((i & 2) != 0) {
            progressBlockerView = null;
        }
        return webViewFragment.configureWebView(webView, progressBlockerView);
    }

    private final WebView configureWebView(WebView webView, ProgressBlockerView progressBlockerView) {
        webView.setBackgroundColor(0);
        webView.setWebViewClient(new WebViewFragment$configureWebView$1(this, progressBlockerView));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(2);
        webView.clearCache(true);
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, (LifecycleOwner) null, false, new WebViewFragment$$ExternalSyntheticLambda2(webView, this), 3, (Object) null);
        return webView;
    }

    /* access modifiers changed from: private */
    public static final Unit configureWebView$lambda$3(WebView webView, WebViewFragment webViewFragment, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            webViewFragment.requireActivity().finish();
        }
        return Unit.INSTANCE;
    }
}
