package com.blueair.viewcore.fragment;

import android.webkit.WebView;
import androidx.activity.OnBackPressedCallback;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WebViewFragment$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ WebView f$0;
    public final /* synthetic */ WebViewFragment f$1;

    public /* synthetic */ WebViewFragment$$ExternalSyntheticLambda2(WebView webView, WebViewFragment webViewFragment) {
        this.f$0 = webView;
        this.f$1 = webViewFragment;
    }

    public final Object invoke(Object obj) {
        return WebViewFragment.configureWebView$lambda$3(this.f$0, this.f$1, (OnBackPressedCallback) obj);
    }
}
