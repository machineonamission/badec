package com.blueair.android.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.R;
import com.blueair.android.databinding.ActivityGoogleAppFlipBinding;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.viewmodel.AccountLinkingViewModel;
import com.blueair.android.viewmodel.LinkingState;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.view.ProgressBlockerView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J2\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0012H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"},
   d2 = {"Lcom/blueair/android/activity/GoogleAppFlipActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityGoogleAppFlipBinding;", "viewModel", "Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "verifyFingerprint", "", "expectedPackage", "expectedFingerprint", "algorithm", "setSuccessResult", "authCode", "setErrorResult", "resultCode", "", "errorType", "errorCode", "errorMsg", "jumpToFailurePage", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GoogleAppFlipActivity extends BaseActivity {
   public static final int $stable = 8;
   private ActivityGoogleAppFlipBinding binding;
   private final String screenName = "google_app_flip";
   private AccountLinkingViewModel viewModel;

   // $FF: synthetic method
   public static CharSequence $r8$lambda$FIMuY1rLo9Btwnwb5kZDTVYVyNo(byte var0) {
      return verifyFingerprint$lambda$4$lambda$3(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Je_ARXoABDW0ADzn5MwfnPb_VHs/* $FF was: $r8$lambda$Je-ARXoABDW0ADzn5MwfnPb_VHs*/(GoogleAppFlipActivity var0, View var1) {
      onCreate$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$hTpBAsZVrzeAPwsFzP5BdjEL7B0(GoogleAppFlipActivity var0, View var1) {
      onCreate$lambda$2$lambda$0(var0, var1);
   }

   private static final void onCreate$lambda$2$lambda$0(GoogleAppFlipActivity var0, View var1) {
      var0.setErrorResult(-2, 2, 14, "CANCELLED_BY_USER", false);
   }

   private static final void onCreate$lambda$2$lambda$1(GoogleAppFlipActivity var0, View var1) {
      AccountLinkingViewModel var3 = var0.viewModel;
      AccountLinkingViewModel var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var2 = null;
      }

      var2.finishGoogleLinking();
   }

   private final void setErrorResult(int var1, int var2, int var3, String var4, boolean var5) {
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("setErrorResult(");
      var6.append(var1);
      var6.append(", ");
      var6.append(var2);
      var6.append(", ");
      var6.append(var3);
      var6.append(", ");
      var6.append(var4);
      var6.append(')');
      var7.d(var6.toString(), new Object[0]);
      Intent var8 = new Intent();
      var8.putExtra("ERROR_TYPE", var2);
      var8.putExtra("ERROR_CODE", var3);
      var8.putExtra("ERROR_DESCRIPTION", var4);
      this.setResult(var1, var8);
      this.finish();
      if (var5) {
         this.startActivity((new Intent((Context)this, AccountLinkingActivity.class)).putExtra("EXTRA_NAME", "GoogleAssistant").putExtra("EXTRA_LINKED", false).putExtra("EXTRA_STATE", "FAILED"));
      }

   }

   // $FF: synthetic method
   static void setErrorResult$default(GoogleAppFlipActivity var0, int var1, int var2, int var3, String var4, boolean var5, int var6, Object var7) {
      if ((var6 & 16) != 0) {
         var5 = true;
      }

      var0.setErrorResult(var1, var2, var3, var4, var5);
   }

   private final void setSuccessResult(String var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("setSuccessResult(");
      var3.append(var1);
      var3.append(')');
      var2.d(var3.toString(), new Object[0]);
      Intent var5 = new Intent();
      var5.putExtra("AUTHORIZATION_CODE", var1);
      this.setResult(-1, var5);
      AccountLinkingViewModel var6 = this.viewModel;
      AccountLinkingViewModel var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var4 = null;
      }

      var4.setGoogleLinkRequested(true);
      this.finish();
   }

   private final boolean verifyFingerprint(String var1, String var2, String var3) {
      ComponentName var4 = this.getCallingActivity();
      if (var4 != null) {
         String var6 = var4.getPackageName();
         if (var6 != null) {
            Timber.Forest var16 = Timber.Forest;
            StringBuilder var5 = new StringBuilder("caller package: ");
            var5.append(var6);
            var16.d(var5.toString(), new Object[0]);
            if (Intrinsics.areEqual(var1, var6)) {
               label16: {
                  Signature var7 = this.getPackageManager().getPackageInfo(var6, 64).signatures;
                  if (var7 != null) {
                     var7 = ((Object[])var7)[0];
                     if (var7 != null) {
                        var9 = var7.toByteArray();
                        break label16;
                     }
                  }

                  var9 = null;
               }

               ByteArrayInputStream var10 = new ByteArrayInputStream(var9);
               Certificate var11 = CertificateFactory.getInstance("X509").generateCertificate((InputStream)var10);
               Intrinsics.checkNotNull(var11, "null cannot be cast to non-null type java.security.cert.X509Certificate");
               X509Certificate var12 = (X509Certificate)var11;
               byte[] var13 = MessageDigest.getInstance(var3).digest(var12.getEncoded());
               Intrinsics.checkNotNull(var13);
               String var14 = ArraysKt.joinToString$default(var13, (CharSequence)":", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new GoogleAppFlipActivity$$ExternalSyntheticLambda0(), 30, (Object)null);
               Timber.Forest var15 = Timber.Forest;
               StringBuilder var17 = new StringBuilder("caller fingerprint: ");
               var17.append(var14);
               var15.d(var17.toString(), new Object[0]);
               return Intrinsics.areEqual(var2, var14);
            }
         }
      }

      return false;
   }

   private static final CharSequence verifyFingerprint$lambda$4$lambda$3(byte var0) {
      String var1 = String.format("%02X", Arrays.copyOf(new Object[]{var0}, 1));
      Intrinsics.checkNotNullExpressionValue(var1, "format(...)");
      return (CharSequence)var1;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ViewDataBinding var6 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_google_app_flip);
      Intrinsics.checkNotNullExpressionValue(var6, "setContentView(...)");
      this.binding = (ActivityGoogleAppFlipBinding)var6;
      AccountLinkingViewModel var2 = (AccountLinkingViewModel)(new ViewModelProvider((ViewModelStoreOwner)this)).get(AccountLinkingViewModel.class);
      this.viewModel = var2;
      AccountLinkingViewModel var7 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var7 = null;
      }

      var7.setAccountType(Integration.GoogleAssistant);
      var2 = this.viewModel;
      var7 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var7 = null;
      }

      var7.setGoogleLinkRequested(false);
      Bundle var3 = this.getIntent().getExtras();
      Intrinsics.checkNotNull(var3);
      Timber.Forest var16 = Timber.Forest;
      StringBuilder var9 = new StringBuilder("onCreate: ");
      var9.append(this.getIntent());
      var9.append(", ");
      var9.append(var3.getString("CLIENT_ID"));
      var9.append(", ");
      var9.append(var3.getStringArrayList("SCOPE"));
      var9.append(", ");
      var9.append(var3.getString("REDIRECT_URI"));
      var16.d(var9.toString(), new Object[0]);
      String var26 = this.getIntent().getStringExtra("CLIENT_ID");
      AccountLinkingViewModel var17 = this.viewModel;
      AccountLinkingViewModel var10 = var17;
      if (var17 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var10 = null;
      }

      if (!Intrinsics.areEqual(var26, var10.getGoogleClientId())) {
         setErrorResult$default(this, -2, 2, 9, "INVALID_CLIENT", false, 16, (Object)null);
      } else if (!this.verifyFingerprint("com.google.android.googlequicksearchbox", "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83", "SHA-256") && !this.verifyFingerprint("com.google.android.apps.chromecast.app", "3D:7A:12:23:01:9A:A3:9D:9E:A0:E3:43:6A:B7:C0:89:6B:FB:4F:B6:79:F4:DE:5F:E7:C2:3F:32:6C:8F:99:4A", "SHA-256")) {
         setErrorResult$default(this, -2, 2, 8, "CLIENT_VERIFICATION_FAILED", false, 16, (Object)null);
      } else {
         ActivityGoogleAppFlipBinding var18 = this.binding;
         ActivityGoogleAppFlipBinding var11 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var11 = null;
         }

         TextView var4 = var11.signedInAs;
         String var5 = this.getString(com.blueair.viewcore.R.string.google_appflip_signed_in_as);
         Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
         AccountLinkingViewModel var27 = this.viewModel;
         AccountLinkingViewModel var19 = var27;
         if (var27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            var19 = null;
         }

         String var20 = String.format(var5, Arrays.copyOf(new Object[]{var19.getUsername()}, 1));
         Intrinsics.checkNotNullExpressionValue(var20, "format(...)");
         var4.setText((CharSequence)var20);
         String var29 = this.getString(com.blueair.viewcore.R.string.privacy_policy);
         Intrinsics.checkNotNullExpressionValue(var29, "getString(...)");
         String var28 = this.getString(com.blueair.viewcore.R.string.google_appflip_review_policy);
         Intrinsics.checkNotNullExpressionValue(var28, "getString(...)");
         StringBuilder var21 = new StringBuilder("<a href=\"https://policies.google.com/\">");
         var21.append(var29);
         var21.append("</a>");
         String var22 = String.format(var28, Arrays.copyOf(new Object[]{var21.toString()}, 1));
         Intrinsics.checkNotNullExpressionValue(var22, "format(...)");
         var11.reviewPolicy.setText((CharSequence)HtmlCompat.fromHtml(var22, 0));
         var11.reviewPolicy.setMovementMethod(LinkMovementMethod.getInstance());
         var11.btnCancel.setOnClickListener(new GoogleAppFlipActivity$$ExternalSyntheticLambda1(this));
         var11.btnAgree.setOnClickListener(new GoogleAppFlipActivity$$ExternalSyntheticLambda2(this));
         AccountLinkingViewModel var23 = this.viewModel;
         AccountLinkingViewModel var12 = var23;
         if (var23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            var12 = null;
         }

         FlowKt.launchIn(FlowKt.onEach((Flow)var12.getState(), new Function2(this, (Continuation)null) {
            Object L$0;
            int label;
            final GoogleAppFlipActivity this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               Function2 var3 = new <anonymous constructor>(this.this$0, var2);
               var3.L$0 = var1;
               return (Continuation)var3;
            }

            public final Object invoke(LinkingState var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               LinkingState var4 = (LinkingState)this.L$0;
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  ActivityGoogleAppFlipBinding var3 = this.this$0.binding;
                  ActivityGoogleAppFlipBinding var5 = var3;
                  if (var3 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("binding");
                     var5 = null;
                  }

                  ProgressBlockerView var6 = var5.loading;
                  Intrinsics.checkNotNullExpressionValue(var6, "loading");
                  View var7 = (View)var6;
                  byte var2;
                  if (Intrinsics.areEqual(var4, LinkingState.Loading.INSTANCE)) {
                     var2 = 0;
                  } else {
                     var2 = 8;
                  }

                  var7.setVisibility(var2);
                  if (var4 instanceof LinkingState.AuthCodeGot) {
                     LinkingState.AuthCodeGot var8 = (LinkingState.AuthCodeGot)var4;
                     if (StringsKt.isBlank((CharSequence)var8.getCode())) {
                        GoogleAppFlipActivity.setErrorResult$default(this.this$0, -2, 2, 16, "USER_AUTHENTICATION_FAILED", false, 16, (Object)null);
                     } else {
                        this.this$0.setSuccessResult(var8.getCode());
                     }
                  }

                  return Unit.INSTANCE;
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         }), (CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this));
         var23 = this.viewModel;
         var12 = var23;
         if (var23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            var12 = null;
         }

         if (!var12.isUserLoggedIn()) {
            var23 = this.viewModel;
            var12 = var23;
            if (var23 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("viewModel");
               var12 = null;
            }

            var12.setLoginPendingAction(LoginPendingAction.Companion.googleLinking());
            this.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, (Context)this, false, 2, (Object)null));
         }

      }
   }

   protected void onResume() {
      super.onResume();
      ActivityGoogleAppFlipBinding var3 = this.binding;
      Object var2 = null;
      ActivityGoogleAppFlipBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      TextView var7 = var1.signedInAs;
      String var4 = this.getString(com.blueair.viewcore.R.string.google_appflip_signed_in_as);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      AccountLinkingViewModel var5 = this.viewModel;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         var5 = (AccountLinkingViewModel)var2;
      }

      String var6 = String.format(var4, Arrays.copyOf(new Object[]{var5.getUsername()}, 1));
      Intrinsics.checkNotNullExpressionValue(var6, "format(...)");
      var7.setText((CharSequence)var6);
   }
}
