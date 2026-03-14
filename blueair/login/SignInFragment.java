package com.blueair.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import com.blueair.core.BuildEnvironment;
import com.blueair.login.databinding.FragmentSignInBinding;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001c"},
   d2 = {"Lcom/blueair/login/SignInFragment;", "Lcom/blueair/login/BaseLoginFragment;", "<init>", "()V", "keyboardSub", "Lio/reactivex/disposables/Disposable;", "viewModel", "Lcom/blueair/login/SignInViewModel;", "getViewModel", "()Lcom/blueair/login/SignInViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "hoverEnterDelayed", "editText", "Landroid/widget/EditText;", "setTermsAndPrivacySpan", "cbPrivacy", "Landroid/widget/TextView;", "setRequiredBold", "spannableString", "Landroid/text/SpannableString;", "onPause", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SignInFragment extends BaseLoginFragment {
   private Disposable keyboardSub;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$4IqXP82tQmAMqd0ayqIm4p3e2PM(EditText var0) {
      hoverEnterDelayed$lambda$17(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$7DMOfUszMHr3iDMC_4a8cs7cV_E/* $FF was: $r8$lambda$7DMOfUszMHr3iDMC_4a8cs7cV-E*/(SignInFragment var0, Function1 var1, AlertDialog var2, View var3) {
      onViewCreated$lambda$16$lambda$9$lambda$8(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$7qgpD4PYfz_nPeqo5PNNC3xPjpw(View var0, SignInFragment var1, View var2) {
      onViewCreated$lambda$6$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$A3sbh44DgqY4PJhCy9ek7Mx8xHk(Function1 var0, TextInputLayout var1, AlertDialog var2, View var3) {
      onViewCreated$lambda$16$lambda$9$lambda$7(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$CPyeoYrOzWUtdnOGTo0jMkvsA5E(SignInFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GSB9xwMSuXyRChzXREayazEGKzQ(SignInFragment var0, Function1 var1) {
      return onViewCreated$lambda$16$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$Jtez_d6exJMQKjtXVIDdfJnBKNU(View var0, MotionEvent var1) {
      return setTermsAndPrivacySpan$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SZrbJmMAICvNLWH3te4E6oidWPI(SignInFragment var0, Boolean var1) {
      return onViewCreated$lambda$16$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Ub0u1bS1A3iQi8yJJDyb0TlIpYY(SignInFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$aee5QYvjD8BJQsVjrNy_KuBjIY0(SignInFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$i__B9IspKbgeRoA14Fhzuq8ZyAI/* $FF was: $r8$lambda$i--B9IspKbgeRoA14Fhzuq8ZyAI*/(SignInFragment var0, SignInViewModel var1, Boolean var2) {
      return onViewCreated$lambda$16$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$i3EmPMZIoklcKKXbOXojs9LSFbY(SignInFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$3(var0, var1);
   }

   public SignInFragment() {
      super(R.layout.fragment_sign_in);
      Fragment var1 = this;
      Function0 var2 = new Function0(var1) {
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final Fragment invoke() {
            return this.$this_viewModels;
         }
      };
      Lazy var3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0(var2) {
         final Function0 $ownerProducer;

         public {
            this.$ownerProducer = var1;
         }

         public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner)this.$ownerProducer.invoke();
         }
      });
      this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(var1, Reflection.getOrCreateKotlinClass(SignInViewModel.class), new Function0(var3) {
         final Lazy $owner$delegate;

         public {
            this.$owner$delegate = var1;
         }

         public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate).getViewModelStore();
         }
      }, new Function0((Function0)null, var3) {
         final Function0 $extrasProducer;
         final Lazy $owner$delegate;

         public {
            this.$extrasProducer = var1;
            this.$owner$delegate = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            ViewModelStoreOwner var3 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var4;
            if (var3 instanceof HasDefaultViewModelProviderFactory) {
               var4 = (HasDefaultViewModelProviderFactory)var3;
            } else {
               var4 = null;
            }

            return var4 != null ? var4.getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         }
      }, new Function0(var1, var3) {
         final Lazy $owner$delegate;
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
            this.$owner$delegate = var2;
         }

         public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner var1 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var2;
            if (var1 instanceof HasDefaultViewModelProviderFactory) {
               var2 = (HasDefaultViewModelProviderFactory)var1;
            } else {
               var2 = null;
            }

            if (var2 != null) {
               ViewModelProvider.Factory var3 = var2.getDefaultViewModelProviderFactory();
               if (var3 != null) {
                  return var3;
               }
            }

            ViewModelProvider.Factory var4 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(var4, "defaultViewModelProviderFactory");
            return var4;
         }
      });
   }

   private final void hoverEnterDelayed(EditText var1) {
      var1.postDelayed(new SignInFragment$$ExternalSyntheticLambda2(var1), 10L);
   }

   private static final void hoverEnterDelayed$lambda$17(EditText var0) {
      var0.sendAccessibilityEvent(128);
   }

   private static final Unit onViewCreated$lambda$16$lambda$12(SignInFragment var0, Boolean var1) {
      if (var1 != null) {
         var1;
         FragmentSignInBinding var2 = var0.getBinding();
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentSignInBinding");
         var2 = var2;
         var2.txtEmail.setSelected(var1 ^ true);
         var2.txtEmail.setEndIconVisible(var1 ^ true);
         if (!var1) {
            SimpleTextInputLayout var3 = var2.txtEmail;
            CharSequence var4 = var2.txtEmailError.getText();
            Intrinsics.checkNotNullExpressionValue(var4, "getText(...)");
            var3.setErrorText(var4);
            var2.txtEmail.requestFocus();
            EditText var5 = var2.txtEmail.getEditText();
            if (var5 != null) {
               var0.hoverEnterDelayed(var5);
            }
         } else {
            var2.txtEmail.setErrorText((CharSequence)"");
         }

         return Unit.INSTANCE;
      } else {
         return Unit.INSTANCE;
      }
   }

   private static final Unit onViewCreated$lambda$16$lambda$15(SignInFragment var0, SignInViewModel var1, Boolean var2) {
      if (var2 == null) {
         return Unit.INSTANCE;
      } else {
         var2;
         FragmentSignInBinding var3 = var0.getBinding();
         Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentSignInBinding");
         var3 = var3;
         var3.txtPassword.setSelected(var2 ^ true);
         if (!var2 && Intrinsics.areEqual(var1.getEmailValid().getValue(), true)) {
            SimpleTextInputLayout var4 = var3.txtPassword;
            CharSequence var6 = var3.txtPasswordError.getText();
            Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
            var4.setErrorText(var6);
            var3.txtPassword.requestFocus();
            EditText var5 = var3.txtPassword.getEditText();
            if (var5 != null) {
               var0.hoverEnterDelayed(var5);
            }
         } else {
            var3.txtPassword.setErrorText((CharSequence)"");
         }

         return Unit.INSTANCE;
      }
   }

   private static final Unit onViewCreated$lambda$16$lambda$9(SignInFragment var0, Function1 var1) {
      View var5 = var0.requireActivity().getLayoutInflater().inflate(R.layout.dialog_enter_password, (ViewGroup)null);
      TextInputLayout var2 = (TextInputLayout)var5.findViewById(R.id.editTextLayout);
      MaterialButton var4 = (MaterialButton)var5.findViewById(R.id.ok_view);
      MaterialButton var3 = (MaterialButton)var5.findViewById(R.id.cancel_view);
      AlertDialog var6 = (new AlertDialog.Builder(var0.requireContext())).setView(var5).show();
      var4.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda0(var1, var2, var6));
      var3.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda3(var0, var1, var6));
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$16$lambda$9$lambda$7(Function1 var0, TextInputLayout var1, AlertDialog var2, View var3) {
      if (var0 != null) {
         label15: {
            EditText var4 = var1.getEditText();
            if (var4 != null) {
               Editable var5 = var4.getText();
               if (var5 != null) {
                  String var7 = var5.toString();
                  var6 = var7;
                  if (var7 != null) {
                     break label15;
                  }
               }
            }

            var6 = "";
         }

         var0.invoke(var6);
      }

      var2.dismiss();
   }

   private static final void onViewCreated$lambda$16$lambda$9$lambda$8(SignInFragment var0, Function1 var1, AlertDialog var2, View var3) {
      var0.getViewModel().facebookLogout();
      if (var1 != null) {
         var1.invoke((Object)null);
      }

      var2.dismiss();
   }

   private static final void onViewCreated$lambda$6$lambda$0(SignInFragment var0, View var1) {
      var0.show(new ForgotPasswordFragment());
   }

   private static final void onViewCreated$lambda$6$lambda$1(SignInFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var2.finish();
      }

   }

   private static final void onViewCreated$lambda$6$lambda$2(SignInFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var2.onBackPressed();
      }

   }

   private static final void onViewCreated$lambda$6$lambda$3(SignInFragment var0, View var1) {
      var0.show(new RegisterFragment());
   }

   private static final void onViewCreated$lambda$6$lambda$4(View var0, SignInFragment var1, View var2) {
      ViewHelperUtil.INSTANCE.hideSoftKeyboard(var0);
      var1.getViewModel().emailLogin();
   }

   private final void setRequiredBold(SpannableString var1) {
      String var4 = this.getString(com.blueair.viewcore.R.string.bracketed_required);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      int var3 = StringsKt.indexOf$default((CharSequence)var1, var4, 0, false, 6, (Object)null);
      if (var3 != -1) {
         int var2 = var4.length();
         var1.setSpan(new StyleSpan(1), var3, var2 + var3, 33);
      }

   }

   private final void setTermsAndPrivacySpan(TextView var1) {
      CharSequence var6 = var1.getText();
      Intrinsics.checkNotNull(var6);
      if (var6.length() != 0) {
         var1.setMovementMethod(LinkMovementMethod.getInstance());
         SpannableString var4 = new SpannableString(var6);
         String var7 = this.getString(com.blueair.viewcore.R.string.terms_of_service);
         Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
         String var5 = this.getString(com.blueair.viewcore.R.string.privacy_policy);
         Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
         int var2 = StringsKt.indexOf$default(var6, var7, 0, false, 6, (Object)null);
         if (var2 != -1) {
            int var3 = var7.length() + var2;
            var4.setSpan(new NoUnderlineClickableSpan(this) {
               final SignInFragment this$0;

               {
                  this.this$0 = var1;
               }

               public void onClick(View var1) {
                  Intrinsics.checkNotNullParameter(var1, "widget");
                  this.this$0.openTerms();
               }
            }, var2, var3, 33);
            var4.setSpan(new StyleSpan(1), var2, var3, 33);
            var4.setSpan(new ForegroundColorSpan(-1), var2, var3, 33);
         }

         int var9 = StringsKt.indexOf$default(var6, var5, 0, false, 6, (Object)null);
         if (var9 != -1) {
            var2 = var5.length() + var9;
            var4.setSpan(new NoUnderlineClickableSpan(this) {
               final SignInFragment this$0;

               {
                  this.this$0 = var1;
               }

               public void onClick(View var1) {
                  Intrinsics.checkNotNullParameter(var1, "widget");
                  this.this$0.openPolicies();
               }
            }, var9, var2, 33);
            var4.setSpan(new StyleSpan(1), var9, var2, 33);
            var4.setSpan(new ForegroundColorSpan(-1), var9, var2, 33);
         }

         this.setRequiredBold(var4);
         var1.setText((CharSequence)var4);
         var1.setOnTouchListener(new SignInFragment$$ExternalSyntheticLambda1());
      }
   }

   private static final boolean setTermsAndPrivacySpan$lambda$18(View var0, MotionEvent var1) {
      if (var0 instanceof TextView) {
         TextView var4 = (TextView)var0;
         MovementMethod var2 = var4.getMovementMethod();
         if (var2 != null && var4.getText() instanceof Spannable && var1.getAction() == 1) {
            CharSequence var3 = var4.getText();
            Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type android.text.Spannable");
            if (var2.onTouchEvent(var4, (Spannable)var3, var1)) {
               var1.setAction(3);
            }
         }
      }

      return false;
   }

   protected SignInViewModel getViewModel() {
      return (SignInViewModel)this.viewModel$delegate.getValue();
   }

   public void onPause() {
      super.onPause();
      Disposable var1 = this.keyboardSub;
      if (var1 != null) {
         var1.dispose();
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentSignInBinding var10 = this.getBinding();
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentSignInBinding");
      var10 = var10;
      var10.btnForgotPassword.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda4(this));
      var10.ivClose.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda5(this));
      var10.ivBack.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda6(this));
      var10.btnRegister.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda7(this));
      var10.btnLogin.setOnClickListener(new SignInFragment$$ExternalSyntheticLambda8(var1, this));
      FragmentActivity var4 = this.getActivity();
      LoginActivity var5;
      if (var4 instanceof LoginActivity) {
         var5 = (LoginActivity)var4;
      } else {
         var5 = null;
      }

      if (var5 != null) {
         var5.setStatusMode(false);
         ViewGroup.LayoutParams var3 = var10.toolbar.getLayoutParams();
         if (var3 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)var3).topMargin = var5.getStatusBarHeight();
            var10.toolbar.setLayoutParams(var3);
         }
      }

      if (BuildEnvironment.INSTANCE.isChina()) {
         TextView var6 = var10.privacyText;
         Intrinsics.checkNotNullExpressionValue(var6, "privacyText");
         this.setTermsAndPrivacySpan(var6);
         Group var7 = var10.groupPrivacy;
         Intrinsics.checkNotNullExpressionValue(var7, "groupPrivacy");
         ViewExtensionsKt.show$default((View)var7, false, 1, (Object)null);
      } else {
         Group var8 = var10.groupPrivacy;
         Intrinsics.checkNotNullExpressionValue(var8, "groupPrivacy");
         ViewExtensionsKt.hide((View)var8);
         this.getViewModel().setPrivacyConfirmed();
      }

      SignInViewModel var9 = this.getViewModel();
      LifecycleOwner var12 = (LifecycleOwner)this;
      BaseLoginViewModelKt.observe(var12, (LiveData)var9.getPasswordGetter(), new SignInFragment$$ExternalSyntheticLambda9(this));
      BaseLoginViewModelKt.observe(var12, var9.getEmailValid(), new SignInFragment$$ExternalSyntheticLambda10(this));
      BaseLoginViewModelKt.observe(var12, var9.getPasswordValid(), new SignInFragment$$ExternalSyntheticLambda11(this, var9));
   }
}
