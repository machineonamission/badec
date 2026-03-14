package com.blueair.login;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0017J\u0015\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001c"},
   d2 = {"Lcom/blueair/login/LoginActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "loading", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "kotlin.jvm.PlatformType", "getLoading", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "loading$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "renderLoading", "show", "", "(Ljava/lang/Boolean;)V", "renderFailure", "failure", "Lcom/blueair/login/LoginFailure;", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LoginActivity extends BaseActivity {
   private String _screenName;
   private final Lazy loading$delegate = LazyKt.lazy(new LoginActivity$$ExternalSyntheticLambda0(this));

   // $FF: synthetic method
   public static ProgressBlockerView $r8$lambda$6607yi5ACpuPP5Ql1eat8grlXu8(LoginActivity var0) {
      return loading_delegate$lambda$0(var0);
   }

   private final ProgressBlockerView getLoading() {
      return (ProgressBlockerView)this.loading$delegate.getValue();
   }

   private static final ProgressBlockerView loading_delegate$lambda$0(LoginActivity var0) {
      return (ProgressBlockerView)var0.findViewById(R.id.loading);
   }

   protected String getScreenName() {
      return this._screenName;
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onBackPressed() {
      if (this.getSupportFragmentManager().getBackStackEntryCount() > 0) {
         this.getSupportFragmentManager().popBackStack();
      } else {
         super.onBackPressed();
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(R.layout.activity_login);
      BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object)null);
      String var3 = this.getIntent().getStringExtra("action_type");
      FragmentManager var2 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      FragmentTransaction var4 = var2.beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var4, "beginTransaction()");
      if (Intrinsics.areEqual(var3, "action_register")) {
         this._screenName = "register";
         var4.replace(R.id.fragmentContainer, new RegisterFragment());
      } else {
         this._screenName = "login";
         var4.replace(R.id.fragmentContainer, new SignInFragment());
      }

      var4.commit();
   }

   public final void renderFailure(LoginFailure var1) {
      Integer var2;
      if (var1 != null) {
         var2 = var1.getTextResId();
      } else {
         var2 = null;
      }

      if (var2 != null) {
         FragmentManager var4 = this.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var4.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var4.isStateSaved()) {
            label34: {
               var2 = var1.getTitleResId();
               if (var2 != null) {
                  String var3 = this.getString(((Number)var2).intValue());
                  var7 = var3;
                  if (var3 != null) {
                     break label34;
                  }
               }

               StringBuilder var5 = new StringBuilder();
               var5.append(this.getString(com.blueair.viewcore.R.string.error));
               var5.append(' ');
               String var9 = var1.getCode();
               String var8 = var9;
               if (var9 == null) {
                  var8 = "";
               }

               var5.append(var8);
               var7 = var5.toString();
            }

            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, 0, (Integer)null, var1.getTextResId(), com.blueair.viewcore.R.string.snackbar_ok, (Integer)null, false, false, false, false, (String[])null, var7, (Integer)null, (Function1)null, 7136, (Object)null)).show(var4, "ConfirmationDialogLeftAligned");
         }
      }

   }

   public final void renderLoading(Boolean var1) {
      ProgressBlockerView var3 = this.getLoading();
      Intrinsics.checkNotNullExpressionValue(var3, "<get-loading>(...)");
      View var4 = (View)var3;
      boolean var2;
      if (var1 != null) {
         var2 = var1;
      } else {
         var2 = false;
      }

      ViewExtensionsKt.show(var4, var2);
   }
}
