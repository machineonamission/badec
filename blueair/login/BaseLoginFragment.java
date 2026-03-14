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
import com.blueair.core.util.LinkUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.LoginPendingAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\f\u0010\u001d\u001a\u00020\u0019*\u00020\u0001H\u0004J\b\u0010\u001e\u001a\u00020\u0019H\u0004J\b\u0010\u001f\u001a\u00020\u0019H\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "},
   d2 = {"Lcom/blueair/login/BaseLoginFragment;", "Landroidx/fragment/app/Fragment;", "layoutId", "", "<init>", "(I)V", "viewModel", "Lcom/blueair/login/BaseLoginViewModel;", "getViewModel", "()Lcom/blueair/login/BaseLoginViewModel;", "binding", "Landroidx/databinding/ViewDataBinding;", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "", "context", "Landroid/content/Context;", "onDestroy", "show", "openPolicies", "openTerms", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseLoginFragment extends Fragment {
   protected ViewDataBinding binding;
   private final int layoutId;
   private final BaseLoginViewModel viewModel;

   // $FF: synthetic method
   public static Unit $r8$lambda$Re7yB7he01krVM1w1cfQA13iZ0U(BaseLoginViewModel var0, BaseLoginFragment var1, LoginActivity var2, Unit var3) {
      return onAttach$lambda$5$lambda$4$lambda$2(var0, var1, var2, var3);
   }

   public BaseLoginFragment(int var1) {
      this.layoutId = var1;
   }

   private static final Unit onAttach$lambda$5$lambda$4$lambda$2(BaseLoginViewModel var0, BaseLoginFragment var1, LoginActivity var2, Unit var3) {
      LoginPendingAction var8 = var0.getLoginPendingAction();
      Context var4 = var1.requireContext();
      Intrinsics.checkNotNullExpressionValue(var4, "requireContext(...)");
      Intent var5 = var8.toIntent(var4);
      if (var5 == null) {
         Actions var9 = Actions.INSTANCE;
         Context var6 = var1.requireContext();
         Intrinsics.checkNotNullExpressionValue(var6, "requireContext(...)");
         Intent var7 = var9.openHomeIntent(var6);
         if (var1 instanceof RegisterFragment) {
            var7.putExtra("action_register", true);
         }

         var2.startActivity(var7);
      } else {
         var2.startActivity(var5);
      }

      var2.setResult(-1);
      var2.finish();
      return Unit.INSTANCE;
   }

   protected final ViewDataBinding getBinding() {
      ViewDataBinding var1 = this.binding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         return null;
      }
   }

   protected BaseLoginViewModel getViewModel() {
      return this.viewModel;
   }

   public void onAttach(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super.onAttach(var1);
      LoginActivity var4;
      if (var1 instanceof LoginActivity) {
         var4 = (LoginActivity)var1;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         BaseLoginViewModel var3 = this.getViewModel();
         Intrinsics.checkNotNull(var3);
         LifecycleOwner var2 = (LifecycleOwner)var4;
         BaseLoginViewModelKt.observe(var2, var3.getLoginFinished(), new BaseLoginFragment$$ExternalSyntheticLambda0(var3, this, var4));
         BaseLoginViewModelKt.observe(var2, var3.getLoading(), new Function1(var4) {
            public final void invoke(Boolean var1) {
               ((LoginActivity)this.receiver).renderLoading(var1);
            }
         });
         BaseLoginViewModelKt.observe(var2, var3.getFailure(), new Function1(var4) {
            public final void invoke(LoginFailure var1) {
               ((LoginActivity)this.receiver).renderFailure(var1);
            }
         });
         if (var3.isUserLoggedIn()) {
            Actions var7 = Actions.INSTANCE;
            Context var5 = this.requireContext();
            Intrinsics.checkNotNullExpressionValue(var5, "requireContext(...)");
            Intent var6 = var7.openHomeIntent(var5);
            if (this instanceof RegisterFragment) {
               var6.putExtra("action_register", true);
            }

            var4.startActivity(var6);
            var4.setResult(-1);
            var4.finish();
         }
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      ViewDataBinding var4 = DataBindingUtil.inflate(var1, this.layoutId, var2, false);
      var4.setLifecycleOwner((LifecycleOwner)this);
      var4.setVariable(BR.viewModel, this.getViewModel());
      Intrinsics.checkNotNull(var4);
      this.setBinding(var4);
      View var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
   }

   public void onDestroy() {
      super.onDestroy();
      BaseLoginViewModel var1 = this.getViewModel();
      if (var1 != null) {
         var1.setLoginPendingAction(LoginPendingAction.Companion.getEMPTY());
      }

   }

   protected final void openPolicies() {
      Intent var3 = (new Intent("blueair.action.info")).putExtra("display_key", 2).putExtra("toolbar_key", this.getString(com.blueair.viewcore.R.string.action_policies));
      LinkUtils var2 = LinkUtils.INSTANCE;
      BaseLoginViewModel var1 = this.getViewModel();
      Intrinsics.checkNotNull(var1);
      Intent var4 = var3.putExtra("url_key", var2.getPrivacyLinkFromCountryCode(var1.getCountry()));
      Intrinsics.checkNotNullExpressionValue(var4, "putExtra(...)");
      this.startActivity(var4);
   }

   protected final void openTerms() {
      Intent var2 = (new Intent("blueair.action.info")).putExtra("display_key", 2).putExtra("toolbar_key", this.getString(com.blueair.viewcore.R.string.terms_of_service));
      LinkUtils var1 = LinkUtils.INSTANCE;
      BaseLoginViewModel var3 = this.getViewModel();
      Intrinsics.checkNotNull(var3);
      Intent var4 = var2.putExtra("url_key", var1.getTermsLink(var3.getCountry()));
      Intrinsics.checkNotNullExpressionValue(var4, "putExtra(...)");
      this.startActivity(var4);
   }

   protected final void setBinding(ViewDataBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.binding = var1;
   }

   protected final void show(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "<this>");
      FragmentActivity var2 = this.requireActivity();
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      ActionBar var3 = ((AppCompatActivity)var2).getSupportActionBar();
      if (var3 != null) {
         var3.setHomeAsUpIndicator(com.blueair.viewcore.R.drawable.ic_arrow_back_white);
      }

      FragmentManager var4 = this.requireActivity().getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
      FragmentTransaction var5 = var4.beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var5, "beginTransaction()");
      var5.setCustomAnimations(17432578, 17432579, 17432578, 17432579);
      var5.replace(R.id.fragmentContainer, var1);
      var5.addToBackStack((String)null);
      var5.commit();
   }
}
