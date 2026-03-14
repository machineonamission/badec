package com.blueair.viewcore.viewmodel;

import android.app.Application;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.devicemanager.DeviceManager;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/WebViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "handleUrl", "", "url", "", "onResult", "Lkotlin/Function1;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WebViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(WebViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(WebViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)))};
   private final Lazy authService$delegate;
   private final Lazy locationService$delegate;

   public WebViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.authService$delegate = var3.provideDelegate(this, var5[0]);
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null).provideDelegate(this, var5[1]);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   public final void handleUrl(String var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "url");
      Intrinsics.checkNotNullParameter(var2, "onResult");
      if (this.getLocationService().isMultiPassLink(var1)) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, this, var2, (Continuation)null) {
            final Function1 $onResult;
            final String $url;
            Object L$0;
            int label;
            final WebViewModel this$0;

            {
               this.$url = var1;
               this.this$0 = var2;
               this.$onResult = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.$url, this.this$0, this.$onResult, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Ref.ObjectRef var3;
               Object var4;
               label32: {
                  var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           var3 = (Ref.ObjectRef)this.L$0;
                           ResultKt.throwOnFailure(var1);
                           return Unit.INSTANCE;
                        }

                        var3 = (Ref.ObjectRef)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        break label32;
                     }

                     var3 = (Ref.ObjectRef)this.L$0;
                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     var3 = new Ref.ObjectRef();
                     var3.element = this.$url;
                     DeviceManager var6 = this.this$0.getDeviceManager();
                     String var7 = this.this$0.getAuthService().getUsername();
                     String var5 = this.$url;
                     Continuation var8 = (Continuation)this;
                     this.L$0 = var3;
                     this.label = 1;
                     var1 = var6.shopifyMultiPassLink(var7, var5, var8);
                     if (var1 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var14 = (ApiResult)var1;
                  Function2 var9 = new Function2(var3, (Continuation)null) {
                     final Ref.ObjectRef $link;
                     Object L$0;
                     int label;

                     {
                        this.$link = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(this.$link, var2);
                        var3.L$0 = var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(String var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        String var2 = (String)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           this.$link.element = var2;
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var12 = (Continuation)this;
                  this.L$0 = var3;
                  this.label = 2;
                  if (ApiResultKt.onSuccess(var14, var9, var12) == var4) {
                     return var4;
                  }
               }

               CoroutineContext var15 = (CoroutineContext)Dispatchers.getMain();
               Function2 var10 = new Function2(this.$onResult, var3, (Continuation)null) {
                  final Ref.ObjectRef $link;
                  final Function1 $onResult;
                  int label;

                  {
                     this.$onResult = var1;
                     this.$link = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$onResult, this.$link, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.$onResult.invoke(this.$link.element);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var13 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.label = 3;
               if (BuildersKt.withContext(var15, var10, var13) == var4) {
                  return var4;
               } else {
                  return Unit.INSTANCE;
               }
            }
         }, 2, (Object)null);
      } else {
         var2.invoke(var1);
      }
   }
}
