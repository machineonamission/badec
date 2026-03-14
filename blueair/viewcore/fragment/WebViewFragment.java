package com.blueair.viewcore.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.core.os.BundleKt;
import androidx.databinding.DataBindingUtil;
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
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"},
   d2 = {"Lcom/blueair/viewcore/fragment/WebViewFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/viewcore/viewmodel/WebViewModel;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/FragmentWebviewBinding;", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/WebViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/WebViewModel;)V", "url", "", "getUrl", "()Ljava/lang/String;", "url$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configureWebView", "Landroid/webkit/WebView;", "webView", "progressBar", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "showProgress", "", "shouldShowProgress", "", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WebViewFragment extends BaseFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_URL = "EXTRA_URL";
   private FragmentWebviewBinding binding;
   private final Lazy url$delegate = LazyKt.lazy(new WebViewFragment$$ExternalSyntheticLambda0(this));
   public WebViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$AotPJskNRwX_GdnE7d1B__yBOTs/* $FF was: $r8$lambda$AotPJskNRwX_GdnE7d1B--yBOTs*/(WebView var0, WebViewFragment var1, OnBackPressedCallback var2) {
      return configureWebView$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GpWXMtts8VC7KBFqlsTbtkz9ThQ(WebViewFragment var0, String var1) {
      return onCreateView$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$Z4_tAHlcnawWGZSopGnsag9Wwk8(WebViewFragment var0) {
      return url_delegate$lambda$0(var0);
   }

   private final WebView configureWebView(WebView var1, ProgressBlockerView var2) {
      var1.setBackgroundColor(0);
      var1.setWebViewClient(new WebViewClient(this, var2) {
         final ProgressBlockerView $progressBar;
         final WebViewFragment this$0;

         {
            this.this$0 = var1;
            this.$progressBar = var2;
         }

         public void onPageFinished(WebView var1, String var2) {
            super.onPageFinished(var1, var2);
            ProgressBlockerView var3 = this.$progressBar;
            if (var3 != null) {
               ViewExtensionsKt.hide((View)var3);
            }

         }

         public void onPageStarted(WebView var1, String var2, Bitmap var3) {
            super.onPageStarted(var1, var2, var3);
            ProgressBlockerView var4 = this.$progressBar;
            if (var4 != null) {
               ViewExtensionsKt.show$default((View)var4, false, 1, (Object)null);
            }

         }

         @Deprecated(
            message = "Deprecated in Java"
         )
         public boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            Intrinsics.checkNotNullParameter(var1, "view");
            Intrinsics.checkNotNullParameter(var2, "url");
            if (!StringsKt.startsWith$default(var2, "http", false, 2, (Object)null)) {
               Timber.Forest var3 = Timber.Forest;
               StringBuilder var6 = new StringBuilder("handle url as intent: ");
               var6.append(var2);
               var3.d(var6.toString(), new Object[0]);

               try {
                  Intent var7 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                  this.this$0.startActivity(var7);
                  return true;
               } catch (Throwable var5) {
                  var5.printStackTrace();
                  return false;
               }
            } else {
               return false;
            }
         }
      });
      WebSettings var3 = var1.getSettings();
      var3.setJavaScriptEnabled(true);
      var3.setDomStorageEnabled(true);
      var3.setLoadsImagesAutomatically(true);
      var3.setUseWideViewPort(true);
      var3.setCacheMode(2);
      var1.clearCache(true);
      OnBackPressedDispatcher var4 = this.requireActivity().getOnBackPressedDispatcher();
      Intrinsics.checkNotNullExpressionValue(var4, "<get-onBackPressedDispatcher>(...)");
      OnBackPressedDispatcherKt.addCallback$default(var4, (LifecycleOwner)null, false, new WebViewFragment$$ExternalSyntheticLambda2(var1, this), 3, (Object)null);
      return var1;
   }

   // $FF: synthetic method
   static WebView configureWebView$default(WebViewFragment var0, WebView var1, ProgressBlockerView var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return var0.configureWebView(var1, var2);
   }

   private static final Unit configureWebView$lambda$3(WebView var0, WebViewFragment var1, OnBackPressedCallback var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$addCallback");
      if (var0.canGoBack()) {
         var0.goBack();
      } else {
         var1.requireActivity().finish();
      }

      return Unit.INSTANCE;
   }

   private final String getUrl() {
      Object var1 = this.url$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (String)var1;
   }

   private static final Unit onCreateView$lambda$1(WebViewFragment var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "result");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("open url: ");
      var3.append(var0.getUrl());
      var3.append(" | ");
      var3.append(var1);
      var2.d(var3.toString(), new Object[0]);
      FragmentWebviewBinding var5 = var0.binding;
      FragmentWebviewBinding var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.webView.loadUrl(var1);
      return Unit.INSTANCE;
   }

   private static final String url_delegate$lambda$0(WebViewFragment var0) {
      return var0.requireArguments().getString("EXTRA_URL", (String)null);
   }

   public WebViewModel getViewModel() {
      WebViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentActivity var13 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var13, "requireActivity(...)");
      this.setViewModel((WebViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var13)).get(WebViewModel.class)));
      FragmentWebviewBinding var5 = DataBindingUtil.inflate(var1, R.layout.fragment_webview, var2, false);
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      this.binding = var5;
      this.setHasOptionsMenu(true);
      FragmentWebviewBinding var14 = this.binding;
      Object var12 = null;
      var5 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      ProgressBlockerView var7 = var5.progressView;
      Intrinsics.checkNotNullExpressionValue(var7, "progressView");
      ViewExtensionsKt.show$default((View)var7, false, 1, (Object)null);
      var14 = this.binding;
      FragmentWebviewBinding var8 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      WebView var4 = var8.webView;
      Intrinsics.checkNotNullExpressionValue(var4, "webView");
      var14 = this.binding;
      var8 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      this.configureWebView(var4, var8.progressView);
      if (((CharSequence)this.getUrl()).length() > 0) {
         this.getViewModel().handleUrl(this.getUrl(), new WebViewFragment$$ExternalSyntheticLambda1(this));
      }

      var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (FragmentWebviewBinding)var12;
      }

      View var11 = var8.getRoot();
      Intrinsics.checkNotNullExpressionValue(var11, "getRoot(...)");
      return var11;
   }

   public void setViewModel(WebViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/viewcore/fragment/WebViewFragment$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "newInstance", "Lcom/blueair/viewcore/fragment/WebViewFragment;", "url", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final WebViewFragment newInstance(String var1) {
         Intrinsics.checkNotNullParameter(var1, "url");
         WebViewFragment var2 = new WebViewFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("EXTRA_URL", var1)}));
         return var2;
      }
   }
}
