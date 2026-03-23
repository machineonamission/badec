package com.blueair.viewcore.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J&\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"com/blueair/viewcore/fragment/WebViewFragment$configureWebView$1", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WebViewFragment.kt */
public final class WebViewFragment$configureWebView$1 extends WebViewClient {
    final /* synthetic */ ProgressBlockerView $progressBar;
    final /* synthetic */ WebViewFragment this$0;

    WebViewFragment$configureWebView$1(WebViewFragment webViewFragment, ProgressBlockerView progressBlockerView) {
        this.this$0 = webViewFragment;
        this.$progressBar = progressBlockerView;
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(str, "url");
        if (!StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
            Timber.Forest forest = Timber.Forest;
            forest.d("handle url as intent: " + str, new Object[0]);
            try {
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        ProgressBlockerView progressBlockerView = this.$progressBar;
        if (progressBlockerView != null) {
            ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        ProgressBlockerView progressBlockerView = this.$progressBar;
        if (progressBlockerView != null) {
            ViewExtensionsKt.hide(progressBlockerView);
        }
    }
}
