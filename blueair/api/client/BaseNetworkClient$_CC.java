package com.blueair.api.client;

import com.blueair.api.utils.DefaultOnDataMismatchAdapter;
import com.blueair.api.utils.SkipBadElementsListAdapter;
import com.blueair.core.model.BlueCloudHomeLocationReceive;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import io.flatcircle.coroutinehelper.Success;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

// $FF: synthetic class
public final class BaseNetworkClient$_CC {
   public static Object $default$awaitAllCalls(BaseNetworkClient var0, List var1, Continuation var2) {
      return awaitAllCalls$suspendImpl(var0, var1, var2);
   }

   public static Object $default$awaitCall(BaseNetworkClient var0, Deferred var1, Continuation var2) {
      return awaitCall$suspendImpl(var0, var1, var2);
   }

   public static Object $default$doSuspendedApiCall(BaseNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
      return doSuspendedApiCall$suspendImpl(var0, var1, var2, var3);
   }

   public static Object $default$doSuspendedApiCall(BaseNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
      return doSuspendedApiCall$suspendImpl(var0, var1, var2, var3, var4);
   }

   public static Retrofit $default$retroFitFactory(BaseNetworkClient var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "baseUrl");
      Retrofit var2 = (new Retrofit.Builder()).baseUrl(var1).addConverterFactory((Converter.Factory)MoshiConverterFactory.create((new Moshi.Builder()).add(I18nConfig.Adapter.INSTANCE).add(IpConfig.Adapter.INSTANCE).add(DefaultOnDataMismatchAdapter.newFactory(BlueCloudHomeLocationReceive.class, (Object)null)).add(SkipBadElementsListAdapter.Factory.INSTANCE).add((JsonAdapter.Factory)(new KotlinJsonAdapterFactory())).build())).addCallAdapterFactory((CallAdapter.Factory)CoroutineCallAdapterFactory.Companion.create()).client(var0.getOkHttpClient()).build();
      Intrinsics.checkNotNullExpressionValue(var2, "build(...)");
      return var2;
   }

   static {
      BaseNetworkClient.Companion var0 = BaseNetworkClient.Companion;
   }

   // $FF: synthetic method
   public static Object access$awaitAllCalls$jd(BaseNetworkClient var0, List var1, Continuation var2) {
      return $default$awaitAllCalls(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Object access$awaitCall$jd(BaseNetworkClient var0, Deferred var1, Continuation var2) {
      return $default$awaitCall(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Object access$doSuspendedApiCall$jd(BaseNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
      return $default$doSuspendedApiCall(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Object access$doSuspendedApiCall$jd(BaseNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
      return $default$doSuspendedApiCall(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static Retrofit access$retroFitFactory$jd(BaseNetworkClient var0, String var1) {
      return $default$retroFitFactory(var0, var1);
   }

   // $FF: synthetic method
   public static Object awaitAllCalls$suspendImpl(BaseNetworkClient var0, List var1, Continuation var2) {
      return CoroutineScopeKt.coroutineScope(new Function2(var1, var0, (Continuation)null) {
         final List $calls;
         private Object L$0;
         Object L$1;
         int label;
         final BaseNetworkClient this$0;

         {
            this.$calls = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.$calls, this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            CoroutineScope var3 = (CoroutineScope)this.L$0;
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               List var12 = (List)this.L$1;
               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Iterable var6 = (Iterable)this.$calls;
               var1 = this.this$0;
               Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var6, 10)));
               Iterator var29 = var6.iterator();

               while(var29.hasNext()) {
                  var5.add(BuildersKt.async$default(var3, (CoroutineContext)null, (CoroutineStart)null, new Function2(var1, (BaseNetworkClient.CallWithInput)var29.next(), (Continuation)null) {
                     final BaseNetworkClient.CallWithInput $callWithInput;
                     int label;
                     final BaseNetworkClient this$0;

                     {
                        this.this$0 = var1;
                        this.$callWithInput = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, this.$callWithInput, var2));
                     }

                     public final Object invoke(CoroutineScope var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 == 1) {
                              ResultKt.throwOnFailure(var1);
                              return var1;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        } else {
                           ResultKt.throwOnFailure(var1);
                           var1 = this.this$0;
                           Function2 var6 = this.$callWithInput.getCall();
                           String var4 = this.$callWithInput.getInput();
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           var1 = var1.doSuspendedApiCall(var6, var4, var5);
                           return var1 == var3 ? var3 : var1;
                        }
                     }
                  }, 3, (Object)null));
               }

               List var25 = (List)var5;
               Collection var30 = (Collection)var25;
               Continuation var8 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var25);
               this.label = 1;
               Object var13 = AwaitKt.awaitAll(var30, var8);
               var1 = (BaseNetworkClient)var13;
               if (var13 == var4) {
                  return var4;
               }
            }

            Iterable var9 = (Iterable)((List)var1);
            Collection var14 = (Collection)(new ArrayList());

            for(Object var20 : var9) {
               if (((ApiResult)var20).isFailure()) {
                  var14.add(var20);
               }
            }

            for(ApiResult var21 : (Iterable)((List)var14)) {
               Timber.Forest.w(var21.exceptionOrNull());
            }

            var14 = (Collection)(new ArrayList());

            for(Object var22 : var9) {
               if (((ApiResult)var22).isSuccess()) {
                  var14.add(var22);
               }
            }

            Iterable var23 = (Iterable)((List)var14);
            var14 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var23, 10)));
            Iterator var24 = var23.iterator();

            while(var24.hasNext()) {
               Object var28 = ((ApiResult)var24.next()).getOrNull();
               Intrinsics.checkNotNull(var28);
               var14.add(var28);
            }

            List var18 = (List)var14;
            if (!((Collection)var18).isEmpty()) {
               return (ApiResult)(new Success(var18));
            } else {
               for(ApiResult var19 : var9) {
                  if (var19.isFailure()) {
                     Throwable var11 = var19.exceptionOrNull();
                     Intrinsics.checkNotNull(var11);
                     return (ApiResult)(new Failure(var11));
                  }
               }

               throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
         }
      }, var2);
   }

   // $FF: synthetic method
   public static Object awaitCall$suspendImpl(BaseNetworkClient var0, Deferred var1, Continuation var2) {
      label49: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var16 = var4;
               break label49;
            }
         }

         var16 = new ContinuationImpl(var0, var2) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final BaseNetworkClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return BaseNetworkClient$_CC.awaitCall$suspendImpl(this.this$0, (Deferred)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label43: {
         Object var17 = ((<undefinedtype>)var16).result;
         Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var16).label;
         Object var12;
         if (var3 != 0) {
            if (var3 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            Deferred var10 = (Deferred)((<undefinedtype>)var16).L$1;
            BaseNetworkClient var11 = (BaseNetworkClient)((<undefinedtype>)var16).L$0;

            try {
               ResultKt.throwOnFailure(var17);
            } catch (Exception var9) {
               var10000 = var9;
               boolean var10001 = false;
               break label43;
            }

            var12 = var17;
         } else {
            ResultKt.throwOnFailure(var17);

            try {
               CoroutineContext var18 = (CoroutineContext)Dispatchers.getIO();
               Function2 var6 = new Function2(var1, (Continuation)null) {
                  final Deferred $job;
                  int label;

                  {
                     this.$job = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$job, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 == 1) {
                           ResultKt.throwOnFailure(var1);
                           return var1;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        Deferred var5 = this.$job;
                        Continuation var4 = (Continuation)this;
                        this.label = 1;
                        Object var6 = var5.await(var4);
                        return var6 == var3 ? var3 : var6;
                     }
                  }
               };
               var6 = var6;
               ((<undefinedtype>)var16).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var16).L$1 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var16).label = 1;
               var15 = BuildersKt.withContext(var18, var6, (Continuation)var16);
            } catch (Exception var8) {
               var10000 = var8;
               boolean var20 = false;
               break label43;
            }

            var12 = var15;
            if (var15 == var5) {
               return var5;
            }
         }

         try {
            ApiResult var14 = ApiResult.Companion.success(var12);
            return var14;
         } catch (Exception var7) {
            var10000 = var7;
            boolean var21 = false;
         }
      }

      Exception var13 = var10000;
      return ApiResult.Companion.fail((Throwable)var13);
   }

   // $FF: synthetic method
   public static Object doSuspendedApiCall$suspendImpl(BaseNetworkClient var0, Function2 var1, Object var2, Continuation var3) {
      label61: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var22 = var5;
               break label61;
            }
         }

         var22 = new ContinuationImpl(var0, var3) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final BaseNetworkClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return BaseNetworkClient$_CC.doSuspendedApiCall$suspendImpl(this.this$0, (Function2)null, (Object)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label64: {
         Object var23 = ((<undefinedtype>)var22).result;
         Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var4 = ((<undefinedtype>)var22).label;
         Object var15;
         if (var4 != 0) {
            if (var4 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var15 = ((<undefinedtype>)var22).L$2;
            Function2 var13 = (Function2)((<undefinedtype>)var22).L$1;
            BaseNetworkClient var14 = (BaseNetworkClient)((<undefinedtype>)var22).L$0;

            try {
               ResultKt.throwOnFailure(var23);
            } catch (Exception var11) {
               var10000 = var11;
               boolean var10001 = false;
               break label64;
            }

            var15 = var23;
         } else {
            ResultKt.throwOnFailure(var23);

            try {
               CoroutineContext var24 = (CoroutineContext)Dispatchers.getIO();
               Function2 var7 = new Function2(var1, var2, (Continuation)null) {
                  final Function2 $apiCall;
                  final Object $input;
                  int label;

                  {
                     this.$apiCall = var1;
                     this.$input = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$apiCall, this.$input, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 == 1) {
                           ResultKt.throwOnFailure(var1);
                           return var1;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        Function2 var5 = this.$apiCall;
                        Object var4 = this.$input;
                        this.label = 1;
                        Object var6 = var5.invoke(var4, this);
                        return var6 == var3 ? var3 : var6;
                     }
                  }
               };
               var7 = var7;
               ((<undefinedtype>)var22).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var22).L$1 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var22).L$2 = SpillingKt.nullOutSpilledVariable(var2);
               ((<undefinedtype>)var22).label = 1;
               var20 = BuildersKt.withContext(var24, var7, (Continuation)var22);
            } catch (Exception var10) {
               var10000 = var10;
               boolean var26 = false;
               break label64;
            }

            var15 = var20;
            if (var20 == var6) {
               return var6;
            }
         }

         try {
            var21 = (Response)var15;
            if (var21.isSuccessful() && var21.body() != null) {
               var15 = var21.body();
               Intrinsics.checkNotNull(var15);
               return new Success(var15);
            }
         } catch (Exception var9) {
            var10000 = var9;
            boolean var27 = false;
            break label64;
         }

         try {
            Exception var17 = new Exception(String.valueOf(var21.errorBody()));
            Failure var18 = new Failure((Throwable)var17);
            return var18;
         } catch (Exception var8) {
            var10000 = var8;
            boolean var28 = false;
         }
      }

      Exception var16 = var10000;
      return new Failure((Throwable)var16);
   }

   // $FF: synthetic method
   public static Object doSuspendedApiCall$suspendImpl(BaseNetworkClient var0, Function3 var1, Object var2, Object var3, Continuation var4) {
      label61: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var4;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var26 = var6;
               break label61;
            }
         }

         var26 = new ContinuationImpl(var0, var4) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final BaseNetworkClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return BaseNetworkClient$_CC.doSuspendedApiCall$suspendImpl(this.this$0, (Function3)null, (Object)null, (Object)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label64: {
         Object var27 = ((<undefinedtype>)var26).result;
         Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var5 = ((<undefinedtype>)var26).label;
         Object var17;
         if (var5 != 0) {
            if (var5 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var17 = ((<undefinedtype>)var26).L$3;
            var17 = ((<undefinedtype>)var26).L$2;
            Function3 var15 = (Function3)((<undefinedtype>)var26).L$1;
            BaseNetworkClient var16 = (BaseNetworkClient)((<undefinedtype>)var26).L$0;

            try {
               ResultKt.throwOnFailure(var27);
            } catch (Exception var12) {
               var10000 = var12;
               boolean var10001 = false;
               break label64;
            }

            var17 = var27;
         } else {
            ResultKt.throwOnFailure(var27);

            try {
               CoroutineContext var28 = (CoroutineContext)Dispatchers.getIO();
               Function2 var8 = new Function2(var1, var2, var3, (Continuation)null) {
                  final Function3 $apiCall;
                  final Object $input1;
                  final Object $input2;
                  int label;

                  {
                     this.$apiCall = var1;
                     this.$input1 = var2;
                     this.$input2 = var3;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$apiCall, this.$input1, this.$input2, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 == 1) {
                           ResultKt.throwOnFailure(var1);
                           return var1;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     } else {
                        ResultKt.throwOnFailure(var1);
                        Function3 var5 = this.$apiCall;
                        var1 = this.$input1;
                        Object var4 = this.$input2;
                        this.label = 1;
                        var1 = var5.invoke(var1, var4, this);
                        return var1 == var3 ? var3 : var1;
                     }
                  }
               };
               var8 = var8;
               ((<undefinedtype>)var26).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var26).L$1 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var26).L$2 = SpillingKt.nullOutSpilledVariable(var2);
               ((<undefinedtype>)var26).L$3 = SpillingKt.nullOutSpilledVariable(var3);
               ((<undefinedtype>)var26).label = 1;
               var22 = BuildersKt.withContext(var28, var8, (Continuation)var26);
            } catch (Exception var11) {
               var10000 = var11;
               boolean var30 = false;
               break label64;
            }

            var17 = var22;
            if (var22 == var7) {
               return var7;
            }
         }

         try {
            var18 = (Response)var17;
            if (var18.isSuccessful() && var18.body() != null) {
               var17 = var18.body();
               Intrinsics.checkNotNull(var17);
               Success var24 = new Success(var17);
               return (ApiResult)var24;
            }
         } catch (Exception var10) {
            var10000 = var10;
            boolean var31 = false;
            break label64;
         }

         try {
            Exception var25 = new Exception(String.valueOf(var18.errorBody()));
            Failure var23 = new Failure((Throwable)var25);
            ApiResult var20 = (ApiResult)var23;
            return var20;
         } catch (Exception var9) {
            var10000 = var9;
            boolean var32 = false;
         }
      }

      Exception var19 = var10000;
      return (ApiResult)(new Failure((Throwable)var19));
   }
}
