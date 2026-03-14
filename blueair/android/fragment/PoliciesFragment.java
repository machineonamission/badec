package com.blueair.android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
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

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"},
   d2 = {"Lcom/blueair/android/fragment/PoliciesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/HomeViewModel;", "<init>", "()V", "viewDataBinding", "Lcom/blueair/android/databinding/FragmentPoliciesBinding;", "getViewDataBinding", "()Lcom/blueair/android/databinding/FragmentPoliciesBinding;", "setViewDataBinding", "(Lcom/blueair/android/databinding/FragmentPoliciesBinding;)V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/HomeViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showProgress", "", "shouldShowProgress", "", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PoliciesFragment extends BaseFragment {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public FragmentPoliciesBinding viewDataBinding;
   public HomeViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$3lQV3HHZR__Ednsea8OcPSdx__w/* $FF was: $r8$lambda$3lQV3HHZR--Ednsea8OcPSdx--w*/(PoliciesFragment var0, View var1) {
      onCreateView$lambda$1(var0, var1);
   }

   private static final void onCreateView$lambda$1(PoliciesFragment var0, View var1) {
      InfoActivity.Companion var5 = InfoActivity.Companion;
      FragmentActivity var2 = var0.requireActivity();
      Intrinsics.checkNotNullExpressionValue(var2, "requireActivity(...)");
      Activity var4 = (Activity)var2;
      String var6 = LinkUtils.INSTANCE.getPrivacyLinkFromCountryCode(var0.getViewModel().getCountry());
      String var3 = var0.getString(R.string.privacy_and_terms);
      Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
      var0.startActivity(var5.gotoWebView(var4, var6, var3));
   }

   public final FragmentPoliciesBinding getViewDataBinding() {
      FragmentPoliciesBinding var1 = this.viewDataBinding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         return null;
      }
   }

   public HomeViewModel getViewModel() {
      HomeViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentPoliciesBinding var7 = FragmentPoliciesBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
      FragmentActivity var4 = ((BaseFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
      this.setViewModel((HomeViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var4)).get(HomeViewModel.class)));
      var7.setLifecycleOwner((LifecycleOwner)this.requireActivity());
      this.setViewDataBinding(var7);
      this.getViewDataBinding().privacyPolicyClickview.setOnClickListener(new PoliciesFragment$$ExternalSyntheticLambda0(this));
      this.getViewDataBinding().icpNo.setMovementMethod(LinkMovementMethod.getInstance());
      TextView var5 = this.getViewDataBinding().icpNo;
      Intrinsics.checkNotNullExpressionValue(var5, "icpNo");
      ViewExtensionsKt.show((View)var5, this.getViewModel().shouldShowIcpNo());
      View var6 = this.getViewDataBinding().getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return var6;
   }

   public final void setViewDataBinding(FragmentPoliciesBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewDataBinding = var1;
   }

   public void setViewModel(HomeViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/android/fragment/PoliciesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/fragment/PoliciesFragment;", "app_otherRelease"},
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

      public final PoliciesFragment newInstance() {
         return new PoliciesFragment();
      }
   }
}
