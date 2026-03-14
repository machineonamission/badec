package com.blueair.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import com.blueair.android.databinding.ActivityWelcomeBinding;
import com.blueair.auth.AuthService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/android/activity/WelcomeActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityWelcomeBinding;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "loginLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "versionClickCount", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setWelcomeSpan", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeActivity extends BaseActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(WelcomeActivity.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)))};
   public static final int $stable = 8;
   private final Lazy authService$delegate;
   private ActivityWelcomeBinding binding;
   private ActivityResultLauncher loginLauncher;
   private final String screenName = "welcome";
   private int versionClickCount;

   // $FF: synthetic method
   public static void $r8$lambda$2thlp7Kf7jVbSzixuQSgNcKP_Jg(WelcomeActivity var0, ActivityResult var1) {
      onCreate$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$QYGAx93bEINsFCm1Wjo8NnsLixs(WelcomeActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Yc5no5bGFuL0lLmX_zgdU27sq2w(WelcomeActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ukLCWEVbQSG9Lzk37ipExw9W418(WelcomeActivity var0, View var1) {
      onCreate$lambda$3(var0, var1);
   }

   public WelcomeActivity() {
      DIAware var2 = this;
      JVMTypeToken var1 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var1, AuthService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private static final void onCreate$lambda$0(WelcomeActivity var0, ActivityResult var1) {
      if (var1.getResultCode() == -1) {
         var0.finish();
      }

   }

   private static final void onCreate$lambda$1(WelcomeActivity var0, View var1) {
      ActivityResultLauncher var2 = var0.loginLauncher;
      ActivityResultLauncher var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("loginLauncher");
         var3 = null;
      }

      var3.launch(Actions.openLoginIntent$default(Actions.INSTANCE, (Context)var0, (String)null, 2, (Object)null));
   }

   private static final void onCreate$lambda$2(WelcomeActivity var0, View var1) {
      ActivityResultLauncher var2 = var0.loginLauncher;
      ActivityResultLauncher var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("loginLauncher");
         var3 = null;
      }

      var3.launch(Actions.INSTANCE.openLoginIntent((Context)var0, "action_register"));
   }

   private static final void onCreate$lambda$3(WelcomeActivity var0, View var1) {
      int var2 = var0.versionClickCount + 1;
      var0.versionClickCount = var2;
      if (var2 >= 7) {
         var0.versionClickCount = 0;
         var0.startActivity(new Intent((Context)var0, DevSettingsActivity.class));
      }

   }

   private final void setWelcomeSpan() {
      ActivityWelcomeBinding var4 = this.binding;
      Object var3 = null;
      ActivityWelcomeBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      CharSequence var5 = var2.txtWelcomeMsg.getText();
      Intrinsics.checkNotNull(var5);
      if (var5.length() > 0) {
         SpannableString var6 = new SpannableString(var5);
         CharSequence var8 = (CharSequence)var6;
         int var1 = StringsKt.indexOf$default(var8, "\n", 0, false, 6, (Object)null);
         if (var1 > 0) {
            var6.setSpan(new ForegroundColorSpan(-1), 0, var1, 33);
            ActivityWelcomeBinding var7 = this.binding;
            if (var7 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var7 = (ActivityWelcomeBinding)var3;
            }

            var7.txtWelcomeMsg.setText(var8);
         }
      }

   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityWelcomeBinding var3 = ActivityWelcomeBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      Object var2 = null;
      ActivityWelcomeBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      this.setContentView((View)var4.getRoot());
      this.immersiveStatusBar(true);
      this.setWelcomeSpan();
      ActivityResultLauncher var5 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new WelcomeActivity$$ExternalSyntheticLambda0(this));
      Intrinsics.checkNotNullExpressionValue(var5, "registerForActivityResult(...)");
      this.loginLauncher = var5;
      var3 = this.binding;
      ActivityWelcomeBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnLogin.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda1(this));
      var3 = this.binding;
      var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      var6.btnRegister.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda2(this));
      var3 = this.binding;
      var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      TextView var14 = var6.tvVersion;
      StringBuilder var9 = new StringBuilder();
      var9.append(this.getString(R.string.menu_app_version));
      var9.append(" 4.5.2 (2366)");
      var14.setText((CharSequence)var9.toString());
      ActivityWelcomeBinding var10 = this.binding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = (ActivityWelcomeBinding)var2;
      }

      var10.tvVersion.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda3(this));
      if ((Boolean)this.getAuthService().isUserLoggedIn().getValue()) {
         this.startActivity(Actions.INSTANCE.openHomeIntent((Context)this));
         this.finish();
      }

   }
}
