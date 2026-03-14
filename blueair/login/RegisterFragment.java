package com.blueair.login;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import com.blueair.login.databinding.FragmentRegisterBinding;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import com.blueair.viewcore.view.SimpleTextInputLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"},
   d2 = {"Lcom/blueair/login/RegisterFragment;", "Lcom/blueair/login/BaseLoginFragment;", "<init>", "()V", "viewModel", "Lcom/blueair/login/RegisterViewModel;", "getViewModel", "()Lcom/blueair/login/RegisterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "firstNameView", "Landroid/view/View;", "lastNameView", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "setTermsAndPrivacySpan", "cbPrivacy", "Landroid/widget/TextView;", "setRequiredBold", "spannableString", "Landroid/text/SpannableString;", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RegisterFragment extends BaseLoginFragment {
   private View firstNameView;
   private View lastNameView;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$M61fAKiwwi_ZIYg9xyCNpE3Gku0/* $FF was: $r8$lambda$M61fAKiwwi-ZIYg9xyCNpE3Gku0*/(EditText var0) {
      onViewCreated$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$OccGoQZCTGc6hy0LOeLLW2l1tGY(FragmentRegisterBinding var0, RegisterFragment var1, String var2) {
      return onViewCreated$lambda$6$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$hiNdaU8Fdt_0GNWkfBKQ56KdDYY/* $FF was: $r8$lambda$hiNdaU8Fdt-0GNWkfBKQ56KdDYY*/(RegisterFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$j7ee7FY_8B4cUZKxcEJw6jQ5LR4(RegisterFragment var0, RegisterViewModel var1, boolean var2) {
      return onViewCreated$lambda$11(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$oROZL5NEVAZMLM0HRkuCFyT_TVE/* $FF was: $r8$lambda$oROZL5NEVAZMLM0HRkuCFyT-TVE*/(RegisterFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$pYxL_uDUE_bRyN2HGeZ9BAIhAIk(View var0, MotionEvent var1) {
      return setTermsAndPrivacySpan$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qkuP8oAGJ6GJthXknmapYQZJMmw(RegisterFragment var0, View var1) {
      onViewCreated$lambda$6$lambda$1(var0, var1);
   }

   public RegisterFragment() {
      super(R.layout.fragment_register);
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
      this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(var1, Reflection.getOrCreateKotlinClass(RegisterViewModel.class), new Function0(var3) {
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

   private static final Unit onViewCreated$lambda$11(RegisterFragment var0, RegisterViewModel var1, boolean var2) {
      if (var2) {
         ViewDataBinding var3 = var0.getBinding();
         Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentRegisterBinding");
         FragmentRegisterBinding var4 = (FragmentRegisterBinding)var3;
         var2 = Intrinsics.areEqual(var1.getFirstNameValid().getValue(), true);
         SimpleTextInputLayout var10 = null;
         View var5;
         Object var8;
         if (!var2 && var0.firstNameView != null) {
            var8 = var0.getString(com.blueair.viewcore.R.string.enter_first_name);
            var5 = var0.firstNameView;
         } else if (!Intrinsics.areEqual(var1.getLastNameValid().getValue(), true) && var0.lastNameView != null) {
            var8 = var0.getString(com.blueair.viewcore.R.string.enter_last_name);
            var5 = var0.lastNameView;
         } else if (var1.getEmailError().getValue() != null) {
            var8 = var1.getEmailError().getValue();
            var5 = (View)var4.txtEmail;
         } else if (var1.getPasswordError().getValue() != null) {
            var8 = var1.getPasswordError().getValue();
            var5 = (View)var4.txtPassword;
         } else if (Intrinsics.areEqual(var1.getConfirmPasswordValid().getValue(), false)) {
            var8 = var4.txtConfirmPasswordError.getText();
            var5 = (View)var4.txtConfirmPassword;
         } else {
            var5 = null;
            var8 = null;
         }

         if (var5 instanceof SimpleTextInputLayout) {
            var10 = (SimpleTextInputLayout)var5;
         }

         if (var10 != null) {
            CharSequence var6 = (CharSequence)var8;
            if (var6 != null && var6.length() != 0) {
               var10.setErrorText(var6);
            }

            var10.requestFocus();
            EditText var7 = var10.getEditText();
            if (var7 != null) {
               var7.postDelayed(new RegisterFragment$$ExternalSyntheticLambda6(var7), 10L);
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7(EditText var0) {
      var0.sendAccessibilityEvent(128);
   }

   private static final void onViewCreated$lambda$6$lambda$0(RegisterFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var2.onBackPressed();
      }

   }

   private static final void onViewCreated$lambda$6$lambda$1(RegisterFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var2.finish();
      }

   }

   private static final Unit onViewCreated$lambda$6$lambda$2(FragmentRegisterBinding var0, RegisterFragment var1, String var2) {
      int var3;
      if (!Intrinsics.areEqual(var2, "eu") && !Intrinsics.areEqual(var2, "cn")) {
         var3 = com.blueair.viewcore.R.string.password_requirement_4_group;
      } else {
         var3 = com.blueair.viewcore.R.string.password_requirement_3_group;
      }

      var0.txtPasswordRequirement.setText(var3);
      TextInputEditText var5 = var0.password;
      StringBuilder var4 = new StringBuilder();
      var4.append(var1.getString(com.blueair.viewcore.R.string.create_password_required));
      var4.append(' ');
      var4.append(var1.getString(var3));
      var5.setContentDescription((CharSequence)var4.toString());
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$6$lambda$4(RegisterFragment var0, View var1) {
      var0.show(new SignInFragment());
   }

   private final void setRequiredBold(SpannableString var1) {
      String var4 = this.getString(com.blueair.viewcore.R.string.bracketed_required);
      Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
      int var2 = StringsKt.indexOf$default((CharSequence)var1, var4, 0, false, 6, (Object)null);
      if (var2 != -1) {
         int var3 = var4.length();
         var1.setSpan(new StyleSpan(1), var2, var3 + var2, 33);
      }

   }

   private final void setTermsAndPrivacySpan(TextView var1) {
      CharSequence var4 = var1.getText();
      Intrinsics.checkNotNull(var4);
      if (var4.length() != 0) {
         var1.setMovementMethod(LinkMovementMethod.getInstance());
         SpannableString var5 = new SpannableString(var4);
         String var7 = this.getString(com.blueair.viewcore.R.string.terms_of_service);
         Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
         String var6 = this.getString(com.blueair.viewcore.R.string.privacy_policy);
         Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
         int var3 = StringsKt.indexOf$default(var4, var7, 0, false, 6, (Object)null);
         if (var3 != -1) {
            int var2 = var7.length() + var3;
            var5.setSpan(new NoUnderlineClickableSpan(this) {
               final RegisterFragment this$0;

               {
                  this.this$0 = var1;
               }

               public void onClick(View var1) {
                  Intrinsics.checkNotNullParameter(var1, "widget");
                  this.this$0.openTerms();
               }
            }, var3, var2, 33);
            var5.setSpan(new StyleSpan(1), var3, var2, 33);
         }

         int var8 = StringsKt.indexOf$default(var4, var6, 0, false, 6, (Object)null);
         if (var8 != -1) {
            var3 = var6.length() + var8;
            var5.setSpan(new NoUnderlineClickableSpan(this) {
               final RegisterFragment this$0;

               {
                  this.this$0 = var1;
               }

               public void onClick(View var1) {
                  Intrinsics.checkNotNullParameter(var1, "widget");
                  this.this$0.openPolicies();
               }
            }, var8, var3, 33);
            var5.setSpan(new StyleSpan(1), var8, var3, 33);
         }

         this.setRequiredBold(var5);
         var1.setText((CharSequence)var5);
         var1.setOnTouchListener(new RegisterFragment$$ExternalSyntheticLambda5());
      }
   }

   private static final boolean setTermsAndPrivacySpan$lambda$12(View var0, MotionEvent var1) {
      if (var0 instanceof TextView) {
         TextView var3 = (TextView)var0;
         MovementMethod var2 = var3.getMovementMethod();
         if (var2 != null && var3.getText() instanceof Spannable && var1.getAction() == 1) {
            CharSequence var4 = var3.getText();
            Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type android.text.Spannable");
            if (var2.onTouchEvent(var3, (Spannable)var4, var1)) {
               var1.setAction(3);
            }
         }
      }

      return false;
   }

   protected RegisterViewModel getViewModel() {
      return (RegisterViewModel)this.viewModel$delegate.getValue();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      this.getViewModel().loadDataCenter();
      RegisterViewModel var10 = this.getViewModel();
      ViewDataBinding var5 = this.getBinding();
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentRegisterBinding");
      FragmentRegisterBinding var3 = (FragmentRegisterBinding)var5;
      var3.btnBack.setOnClickListener(new RegisterFragment$$ExternalSyntheticLambda0(this));
      var3.btnClose.setOnClickListener(new RegisterFragment$$ExternalSyntheticLambda1(this));
      var10.getDataCenter().observe(this.getViewLifecycleOwner(), new Observer(new RegisterFragment$$ExternalSyntheticLambda2(var3, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      FragmentActivity var6 = this.getActivity();
      LoginActivity var7;
      if (var6 instanceof LoginActivity) {
         var7 = (LoginActivity)var6;
      } else {
         var7 = null;
      }

      if (var7 != null) {
         var7.setStatusMode(true);
         ViewGroup.LayoutParams var4 = var3.toolbar.getLayoutParams();
         if (var4 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)var4).topMargin = var7.getStatusBarHeight();
            var3.toolbar.setLayoutParams(var4);
         }
      }

      var3.btnLogin.setOnClickListener(new RegisterFragment$$ExternalSyntheticLambda3(this));
      TextView var8 = var3.privacyText;
      Intrinsics.checkNotNullExpressionValue(var8, "privacyText");
      this.setTermsAndPrivacySpan(var8);
      this.firstNameView = this.getBinding().getRoot().findViewWithTag("FirstName");
      this.lastNameView = this.getBinding().getRoot().findViewWithTag("LastName");
      MaterialCheckBox var9 = var3.cbYears;
      SpannableString var11 = new SpannableString(var9.getText());
      this.setRequiredBold(var11);
      var9.setText((CharSequence)var11);
      LiveDataExtensionsKt.observeNonNull(var10.getFormError(), (LifecycleOwner)this, new RegisterFragment$$ExternalSyntheticLambda4(this, var10));
   }
}
