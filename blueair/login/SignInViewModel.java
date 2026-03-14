package com.blueair.login;

import android.app.Application;
import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.FacebookService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u00130\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u00130\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0015R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"},
   d2 = {"Lcom/blueair/login/SignInViewModel;", "Lcom/blueair/login/BaseLoginViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "facebookService", "Lcom/blueair/auth/FacebookService;", "getFacebookService", "()Lcom/blueair/auth/FacebookService;", "facebookService$delegate", "Lkotlin/Lazy;", "email", "Landroidx/lifecycle/MutableLiveData;", "", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "emailValid", "Landroidx/lifecycle/LiveData;", "", "getEmailValid", "()Landroidx/lifecycle/LiveData;", "_emailValid", "kotlin.jvm.PlatformType", "password", "getPassword", "passwordValid", "getPasswordValid", "_passwordValid", "confirmPrivacy", "getConfirmPrivacy", "privacyConfirmed", "getPrivacyConfirmed", "_privacyConfirmed", "emailLogin", "", "facebookLogout", "setPrivacyConfirmed", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SignInViewModel extends BaseLoginViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(SignInViewModel.class, "facebookService", "getFacebookService()Lcom/blueair/auth/FacebookService;", 0)))};
   private final MutableLiveData _emailValid;
   private final MutableLiveData _passwordValid;
   private final MutableLiveData _privacyConfirmed;
   private final MutableLiveData confirmPrivacy;
   private final MutableLiveData email;
   private final Lazy facebookService$delegate;
   private final MutableLiveData password;

   public SignInViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.facebookService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, FacebookService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.email = new MutableLiveData();
      Boolean var4 = true;
      this._emailValid = new MutableLiveData(var4);
      this.password = new MutableLiveData();
      this._passwordValid = new MutableLiveData(var4);
      this.confirmPrivacy = new MutableLiveData();
      this._privacyConfirmed = new MutableLiveData();
   }

   private final FacebookService getFacebookService() {
      return (FacebookService)this.facebookService$delegate.getValue();
   }

   public final void emailLogin() {
      this._emailValid.setValue(Patterns.EMAIL_ADDRESS.matcher((CharSequence)String.valueOf(this.email.getValue())).matches());
      MutableLiveData var2 = this._passwordValid;
      boolean var1;
      if (String.valueOf(this.password.getValue()).length() > 5) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.setValue(var1);
      Object var3 = this.getEmailValid().getValue();
      Intrinsics.checkNotNull(var3);
      if ((Boolean)var3) {
         var3 = this.getPasswordValid().getValue();
         Intrinsics.checkNotNull(var3);
         if ((Boolean)var3) {
            this.authenticateUser(new Function1(this, (Continuation)null) {
               int label;
               final SignInViewModel this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Continuation var1) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, var1));
               }

               public final Object invoke(Continuation var1) {
                  return ((<undefinedtype>)this.create(var1)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var4;
                  label35: {
                     var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              if (var2 == 3) {
                                 ResultKt.throwOnFailure(var1);
                                 return var1;
                              }

                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                           break label35;
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        var1 = this.this$0.getAuthService();
                        Continuation var3 = (Continuation)this;
                        this.label = 1;
                        if (var1.updateGigyaDataCenter(var3) == var4) {
                           return var4;
                        }
                     }

                     var1 = this.this$0.getAuthService();
                     Object var11 = this.this$0.getEmail().getValue();
                     Intrinsics.checkNotNull(var11);
                     String var12 = (String)var11;
                     Continuation var5 = (Continuation)this;
                     this.label = 2;
                     Object var13 = var1.doGigyaDataCentersHaveEmailAddress(var12, var5);
                     var1 = var13;
                     if (var13 == var4) {
                        return var4;
                     }
                  }

                  if (!(Boolean)var1) {
                     throw new Exception("403047");
                  } else {
                     var1 = this.this$0.getGigyaService();
                     Object var14 = this.this$0.getEmail().getValue();
                     Intrinsics.checkNotNull(var14);
                     String var15 = (String)var14;
                     Object var16 = this.this$0.getPassword().getValue();
                     Intrinsics.checkNotNull(var16);
                     String var17 = (String)var16;
                     Continuation var6 = (Continuation)this;
                     this.label = 3;
                     var1 = var1.emailLogin(var15, var17, var6);
                     if (var1 != var4) {
                        return var1;
                     } else {
                        return var4;
                     }
                  }
               }
            });
         }
      }

   }

   public final void facebookLogout() {
      this.getFacebookService().logOut();
   }

   public final MutableLiveData getConfirmPrivacy() {
      return this.confirmPrivacy;
   }

   public final MutableLiveData getEmail() {
      return this.email;
   }

   public final LiveData getEmailValid() {
      return (LiveData)this._emailValid;
   }

   public final MutableLiveData getPassword() {
      return this.password;
   }

   public final LiveData getPasswordValid() {
      return (LiveData)this._passwordValid;
   }

   public final LiveData getPrivacyConfirmed() {
      return (LiveData)this._privacyConfirmed;
   }

   public final void setPrivacyConfirmed() {
      this.confirmPrivacy.postValue(true);
   }
}
