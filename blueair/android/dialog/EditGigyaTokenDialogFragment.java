package com.blueair.android.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.BaseEditTextDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0006H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\b¨\u0006\u001e"},
   d2 = {"Lcom/blueair/android/dialog/EditGigyaTokenDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/DevSettingsViewModel;)V", "gigyaToken", "getGigyaToken", "gigyaToken$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onSaveBtnClicked", "text", "validateText", "", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class EditGigyaTokenDialogFragment extends BaseEditTextDialogFragment {
   public static final int $stable = 8;
   private static final String ARG_GIGYA_TOKEN = "gigya_token";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy gigyaToken$delegate = LazyKt.lazy(new EditGigyaTokenDialogFragment$$ExternalSyntheticLambda0(this));
   private final String screenName;
   public DevSettingsViewModel viewModel;

   // $FF: synthetic method
   public static String $r8$lambda$saVD_HyZvM7pGzSLNS_HONU12RA/* $FF was: $r8$lambda$saVD-HyZvM7pGzSLNS-HONU12RA*/(EditGigyaTokenDialogFragment var0) {
      return gigyaToken_delegate$lambda$0(var0);
   }

   private final String getGigyaToken() {
      return (String)this.gigyaToken$delegate.getValue();
   }

   private static final String gigyaToken_delegate$lambda$0(EditGigyaTokenDialogFragment var0) {
      Bundle var1 = var0.getArguments();
      if (var1 != null) {
         String var2 = var1.getString("gigya_token");
         if (var2 != null) {
            return var2;
         }
      }

      return "";
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DevSettingsViewModel getViewModel() {
      DevSettingsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      FragmentActivity var2 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var2, "requireActivity(...)");
      this.setViewModel((DevSettingsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var2)).get(DevSettingsViewModel.class)));
   }

   protected void onSaveBtnClicked(String var1) {
      Intrinsics.checkNotNullParameter(var1, "text");
      this.getViewModel().setGigyaJwt(var1);
      super.onSaveBtnClicked(var1);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      TextView var3 = this.getDialogTitle();
      if (var3 != null) {
         var3.setText((CharSequence)"Set gigya token");
      }

      var3 = this.getDialogMsg();
      if (var3 != null) {
         var3.setText((CharSequence)"This will change logged in user.\nFormat:\nusername:gigyaToken\n\"username:\" is optional");
      }

      var3 = this.getDialogMsg();
      if (var3 != null) {
         var3.setGravity(3);
      }

      EditText var6 = this.getEditText();
      if (var6 != null) {
         var6.setText((CharSequence)this.getGigyaToken());
      }

   }

   public void setViewModel(DevSettingsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   protected boolean validateText() {
      return true;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/android/dialog/EditGigyaTokenDialogFragment$Companion;", "", "<init>", "()V", "ARG_GIGYA_TOKEN", "", "newInstance", "Lcom/blueair/android/dialog/EditGigyaTokenDialogFragment;", "gigyaToken", "app_otherRelease"},
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

      public final EditGigyaTokenDialogFragment newInstance(String var1) {
         Intrinsics.checkNotNullParameter(var1, "gigyaToken");
         EditGigyaTokenDialogFragment var2 = new EditGigyaTokenDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("gigya_token", var1)}));
         return var2;
      }
   }
}
