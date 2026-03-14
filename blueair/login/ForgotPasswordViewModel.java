package com.blueair.login;

import android.app.Application;
import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.GigyaService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006$"},
   d2 = {"Lcom/blueair/login/ForgotPasswordViewModel;", "Lcom/blueair/login/BaseLoginViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "Lkotlin/Lazy;", "email", "Landroidx/lifecycle/MutableLiveData;", "", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "emailValid", "Landroidx/lifecycle/LiveData;", "", "getEmailValid", "()Landroidx/lifecycle/LiveData;", "_emailValid", "forgotFinished", "", "getForgotFinished", "_forgotFinished", "_forgotPasswordFailure", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/blueair/login/LoginFailure;", "forgotPasswordFailure", "Lkotlinx/coroutines/flow/StateFlow;", "getForgotPasswordFailure", "()Lkotlinx/coroutines/flow/StateFlow;", "checkEmailInput", "forgotPassword", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ForgotPasswordViewModel extends BaseLoginViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(ForgotPasswordViewModel.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0)))};
   private final MutableLiveData _emailValid;
   private final MutableLiveData _forgotFinished;
   private final MutableStateFlow _forgotPasswordFailure;
   private final Lazy analyticsService$delegate;
   private final MutableLiveData email;
   private final StateFlow forgotPasswordFailure;

   public ForgotPasswordViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analyticsService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AnalyticsService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
      this.email = new MutableLiveData();
      this._emailValid = new MutableLiveData(false);
      this._forgotFinished = new MutableLiveData();
      MutableStateFlow var4 = StateFlowKt.MutableStateFlow((Object)null);
      this._forgotPasswordFailure = var4;
      this.forgotPasswordFailure = FlowKt.asStateFlow(var4);
   }

   public final void checkEmailInput() {
      this._emailValid.setValue(Patterns.EMAIL_ADDRESS.matcher((CharSequence)String.valueOf(this.email.getValue())).matches());
   }

   public final void forgotPassword() {
      Object var1 = this.getEmailValid().getValue();
      Intrinsics.checkNotNull(var1);
      if ((Boolean)var1) {
         this.loadingLaunch(new Function1(this, (Continuation)null) {
            int I$0;
            Object L$0;
            int label;
            final ForgotPasswordViewModel this$0;

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
               Object var6;
               label280: {
                  Throwable var10000;
                  label279: {
                     label287: {
                        var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              if (var2 != 2) {
                                 if (var2 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 ResultKt.throwOnFailure(var1);
                                 return Unit.INSTANCE;
                              }

                              ForgotPasswordViewModel var4 = (ForgotPasswordViewModel)this.L$0;

                              try {
                                 ResultKt.throwOnFailure(var1);
                                 break label287;
                              } catch (Throwable var19) {
                                 var10000 = var19;
                                 boolean var10001 = false;
                                 break label279;
                              }
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           MutableStateFlow var20 = this.this$0._forgotPasswordFailure;
                           Continuation var24 = (Continuation)this;
                           this.label = 1;
                           if (var20.emit((Object)null, var24) == var6) {
                              return var6;
                           }
                        }

                        ForgotPasswordViewModel var21 = this.this$0;

                        try {
                           Result.Companion var25 = Result.Companion;
                           GigyaService var26 = var21.getGigyaService();
                           Object var5 = var21.getEmail().getValue();
                           Intrinsics.checkNotNull(var5);
                           String var31 = (String)var5;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var21);
                           this.I$0 = 0;
                           this.label = 2;
                           if (var26.forgotPassword(var31, this) == var6) {
                              return var6;
                           }
                        } catch (Throwable var18) {
                           var10000 = var18;
                           boolean var35 = false;
                           break label279;
                        }
                     }

                     label267:
                     try {
                        var1 = Result.constructor-impl(Unit.INSTANCE);
                        break label280;
                     } catch (Throwable var17) {
                        var10000 = var17;
                        boolean var36 = false;
                        break label267;
                     }
                  }

                  Throwable var27 = var10000;
                  Result.Companion var22 = Result.Companion;
                  var1 = Result.constructor-impl(ResultKt.createFailure(var27));
               }

               boolean var3;
               AnalyticsService var7;
               String var29;
               label260: {
                  var7 = this.this$0.getAnalyticsService();
                  var3 = Result.isSuccess-impl(var1);
                  Throwable var28 = Result.exceptionOrNull-impl(var1);
                  if (var28 != null) {
                     String var32 = var28.getMessage();
                     var29 = var32;
                     if (var32 != null) {
                        break label260;
                     }
                  }

                  var29 = "";
               }

               var7.event(new AnalyticEvent.ForgotPasswordEvent(var3, var29));
               if (Result.isSuccess-impl(var1)) {
                  this.this$0._forgotFinished.setValue(Unit.INSTANCE);
               } else {
                  MutableStateFlow var30 = this.this$0._forgotPasswordFailure;
                  LoginFailure var33 = LoginFailure.Companion.fromCode(Result.exceptionOrNull-impl(var1), true);
                  Continuation var34 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var1);
                  this.label = 3;
                  if (var30.emit(var33, var34) == var6) {
                     return var6;
                  }
               }

               return Unit.INSTANCE;
            }
         });
      }
   }

   public final AnalyticsService getAnalyticsService() {
      return (AnalyticsService)this.analyticsService$delegate.getValue();
   }

   public final MutableLiveData getEmail() {
      return this.email;
   }

   public final LiveData getEmailValid() {
      return (LiveData)this._emailValid;
   }

   public final LiveData getForgotFinished() {
      return (LiveData)this._forgotFinished;
   }

   public final StateFlow getForgotPasswordFailure() {
      return this.forgotPasswordFailure;
   }
}
