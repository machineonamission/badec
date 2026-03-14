package com.blueair.login;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.auth.LogoutReason;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\u001eR\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"},
   d2 = {"Lcom/blueair/login/DeleteAccountConfirmViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "logoutService", "Lcom/blueair/auth/LogOutService;", "getLogoutService", "()Lcom/blueair/auth/LogOutService;", "logoutService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/blueair/login/DeleteAccountState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteAccount", "", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeleteAccountConfirmViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeleteAccountConfirmViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeleteAccountConfirmViewModel.class, "logoutService", "getLogoutService()Lcom/blueair/auth/LogOutService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeleteAccountConfirmViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   private final MutableStateFlow _state;
   private final Lazy authService$delegate;
   private final Lazy locationService$delegate;
   private final Lazy logoutService$delegate;
   private final StateFlow state;

   public DeleteAccountConfirmViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null);
      KProperty[] var6 = $$delegatedProperties;
      this.authService$delegate = var3.provideDelegate(this, var6[0]);
      JVMTypeToken var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.logoutService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, LogOutService.class)), (Object)null).provideDelegate(this, var6[1]);
      var7 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var7, LocationService.class)), (Object)null).provideDelegate(this, var6[2]);
      MutableStateFlow var5 = StateFlowKt.MutableStateFlow(new DeleteAccountState.Idle(this.getLocationService().getCountry()));
      this._state = var5;
      this.state = FlowKt.asStateFlow(var5);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final LogOutService getLogoutService() {
      return (LogOutService)this.logoutService$delegate.getValue();
   }

   public final void deleteAccount() {
      this.getLocationService().getCountry();
      BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int I$0;
         private Object L$0;
         Object L$1;
         Object L$2;
         int label;
         final DeleteAccountConfirmViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            label185: {
               Throwable var10000;
               label184: {
                  CoroutineScope var3 = (CoroutineScope)this.L$0;
                  Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  DeleteAccountConfirmViewModel var18;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     var3 = (CoroutineScope)this.L$2;
                     DeleteAccountConfirmViewModel var23 = (DeleteAccountConfirmViewModel)this.L$1;

                     try {
                        ResultKt.throwOnFailure(var1);
                     } catch (Throwable var17) {
                        var10000 = var17;
                        boolean var10001 = false;
                        break label184;
                     }

                     var18 = var23;
                  } else {
                     ResultKt.throwOnFailure(var1);
                     Timber.Forest.d("Deleting account", new Object[0]);
                     this.this$0._state.setValue(DeleteAccountState.Deleting.INSTANCE);
                     var18 = this.this$0;

                     try {
                        Result.Companion var5 = Result.Companion;
                        AuthService var28 = var18.getAuthService();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                        this.L$1 = var18;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(var3);
                        this.I$0 = 0;
                        this.label = 1;
                        if (var28.deleteAccount(this) == var4) {
                           return var4;
                        }
                     } catch (Throwable var16) {
                        var10000 = var16;
                        boolean var29 = false;
                        break label184;
                     }
                  }

                  label176:
                  try {
                     var18.getLogoutService().logOutRegistered(LogoutReason.ACCOUNT_DELETED);
                     var1 = Result.constructor-impl(Unit.INSTANCE);
                     break label185;
                  } catch (Throwable var15) {
                     var10000 = var15;
                     boolean var30 = false;
                     break label176;
                  }
               }

               Throwable var24 = var10000;
               Result.Companion var19 = Result.Companion;
               var1 = Result.constructor-impl(ResultKt.createFailure(var24));
            }

            DeleteAccountConfirmViewModel var25 = this.this$0;
            if (Result.isSuccess-impl(var1)) {
               Unit var27 = (Unit)var1;
               Timber.Forest.d("Account deleted", new Object[0]);
               var25._state.setValue(DeleteAccountState.Deleted.INSTANCE);
            }

            var25 = this.this$0;
            Throwable var21 = Result.exceptionOrNull-impl(var1);
            if (var21 != null) {
               Timber.Forest.w(var21, "Delete account failed", new Object[0]);
               var25._state.setValue(DeleteAccountState.Failed.INSTANCE);
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final StateFlow getState() {
      return this.state;
   }
}
