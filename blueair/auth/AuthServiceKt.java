package com.blueair.auth;

import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import io.flatcircle.coroutinehelper.Success;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Response;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001a>\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tH\u0086@¢\u0006\u0002\u0010\r\u001aa\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u000727\u0010\b\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\u0006\u0010\u0012\u001a\u0002H\u000eH\u0086@¢\u0006\u0002\u0010\u0013\u001a\u0084\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u00072L\u0010\b\u001aH\b\u0001\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00162\u0006\u0010\u0017\u001a\u0002H\u00142\u0006\u0010\u0018\u001a\u0002H\u0015H\u0086@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"},
   d2 = {"awaitCall", "Lio/flatcircle/coroutinehelper/ApiResult;", "T", "job", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSuspendedApiCall", "Output", "apiCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lretrofit2/Response;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "input", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Input1", "Input2", "Lkotlin/Function3;", "input1", "input2", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class AuthServiceKt {
   public static final Object awaitCall(Deferred var0, Continuation var1) {
      label49: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var13 = var3;
               break label49;
            }
         }

         var13 = new ContinuationImpl(var1) {
            Object L$0;
            int label;
            Object result;

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return AuthServiceKt.awaitCall((Deferred)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label43: {
         Object var15 = ((<undefinedtype>)var13).result;
         Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var2 = ((<undefinedtype>)var13).label;
         Object var10;
         if (var2 != 0) {
            if (var2 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            Deferred var9 = (Deferred)((<undefinedtype>)var13).L$0;

            try {
               ResultKt.throwOnFailure(var15);
            } catch (Exception var8) {
               var10000 = var8;
               boolean var10001 = false;
               break label43;
            }

            var10 = var15;
         } else {
            ResultKt.throwOnFailure(var15);

            try {
               CoroutineContext var16 = (CoroutineContext)Dispatchers.getIO();
               Function2 var5 = new Function2(var0, (Continuation)null) {
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
                        Deferred var4 = this.$job;
                        Continuation var5 = (Continuation)this;
                        this.label = 1;
                        Object var6 = var4.await(var5);
                        return var6 == var3 ? var3 : var6;
                     }
                  }
               };
               var5 = var5;
               ((<undefinedtype>)var13).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var13).label = 1;
               var14 = BuildersKt.withContext(var16, var5, (Continuation)var13);
            } catch (Exception var7) {
               var10000 = var7;
               boolean var18 = false;
               break label43;
            }

            var10 = var14;
            if (var14 == var4) {
               return var4;
            }
         }

         try {
            ApiResult var12 = ApiResult.Companion.success(var10);
            return var12;
         } catch (Exception var6) {
            var10000 = var6;
            boolean var19 = false;
         }
      }

      Exception var11 = var10000;
      return ApiResult.Companion.fail((Throwable)var11);
   }

   public static final Object doSuspendedApiCall(Function1 var0, Continuation var1) {
      label73: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var17 = var3;
               break label73;
            }
         }

         var17 = new ContinuationImpl(var1) {
            Object L$0;
            int label;
            Object result;

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return AuthServiceKt.doSuspendedApiCall((Function1)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label76: {
         Object var23 = ((<undefinedtype>)var17).result;
         Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var2 = ((<undefinedtype>)var17).label;
         Object var13;
         if (var2 != 0) {
            if (var2 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            Function1 var12 = (Function1)((<undefinedtype>)var17).L$0;

            try {
               ResultKt.throwOnFailure(var23);
            } catch (Exception var11) {
               var10000 = var11;
               boolean var10001 = false;
               break label76;
            }

            var13 = var23;
         } else {
            ResultKt.throwOnFailure(var23);

            try {
               CoroutineContext var24 = (CoroutineContext)Dispatchers.getIO();
               Function2 var5 = new Function2(var0, (Continuation)null) {
                  final Function1 $apiCall;
                  int label;

                  {
                     this.$apiCall = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$apiCall, var2));
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
                        Function1 var4 = this.$apiCall;
                        this.label = 1;
                        Object var5 = var4.invoke(this);
                        return var5 == var3 ? var3 : var5;
                     }
                  }
               };
               var5 = var5;
               ((<undefinedtype>)var17).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var17).label = 1;
               var18 = BuildersKt.withContext(var24, var5, (Continuation)var17);
            } catch (Exception var10) {
               var10000 = var10;
               boolean var27 = false;
               break label76;
            }

            var13 = var18;
            if (var18 == var4) {
               return var4;
            }
         }

         label54: {
            try {
               var14 = (Response)var13;
               Timber.Forest var19 = Timber.Forest;
               StringBuilder var25 = new StringBuilder("doSuspendedApiCall: response = ");
               var25.append(var14);
               var19.d(var25.toString(), new Object[0]);
               if (var14.isSuccessful()) {
                  var21 = var14.body();
                  break label54;
               }
            } catch (Exception var9) {
               var10000 = var9;
               boolean var28 = false;
               break label76;
            }

            try {
               Exception var20 = new Exception(String.valueOf(var14.errorBody()));
               Failure var15 = new Failure((Throwable)var20);
               return var15;
            } catch (Exception var8) {
               var10000 = var8;
               boolean var29 = false;
               break label76;
            }
         }

         if (var21 != null) {
            try {
               return new Success(var21);
            } catch (Exception var6) {
               var10000 = var6;
               boolean var30 = false;
            }
         } else {
            try {
               Exception var22 = new Exception(String.valueOf(var14.errorBody()));
               return new Failure((Throwable)var22);
            } catch (Exception var7) {
               var10000 = var7;
               boolean var31 = false;
            }
         }
      }

      Exception var16 = var10000;
      return new Failure((Throwable)var16);
   }

   public static final Object doSuspendedApiCall(Function2 var0, Object var1, Continuation var2) {
      label73: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var23 = var4;
               break label73;
            }
         }

         var23 = new ContinuationImpl(var2) {
            Object L$0;
            Object L$1;
            int label;
            Object result;

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return AuthServiceKt.doSuspendedApiCall((Function2)null, (Object)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label76: {
         Object var24 = ((<undefinedtype>)var23).result;
         Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var3 = ((<undefinedtype>)var23).label;
         Object var15;
         if (var3 != 0) {
            if (var3 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var15 = ((<undefinedtype>)var23).L$1;
            Function2 var14 = (Function2)((<undefinedtype>)var23).L$0;

            try {
               ResultKt.throwOnFailure(var24);
            } catch (Exception var12) {
               var10000 = var12;
               boolean var10001 = false;
               break label76;
            }

            var15 = var24;
         } else {
            ResultKt.throwOnFailure(var24);

            try {
               CoroutineContext var25 = (CoroutineContext)Dispatchers.getIO();
               Function2 var6 = new Function2(var0, var1, (Continuation)null) {
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
                        Function2 var4 = this.$apiCall;
                        var1 = this.$input;
                        this.label = 1;
                        var1 = var4.invoke(var1, this);
                        return var1 == var3 ? var3 : var1;
                     }
                  }
               };
               var6 = var6;
               ((<undefinedtype>)var23).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var23).L$1 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var23).label = 1;
               var1 = BuildersKt.withContext(var25, var6, (Continuation)var23);
            } catch (Exception var11) {
               var10000 = var11;
               boolean var27 = false;
               break label76;
            }

            var15 = var1;
            if (var1 == var5) {
               return var5;
            }
         }

         label54: {
            try {
               var16 = (Response)var15;
               if (var16.isSuccessful()) {
                  var1 = var16.body();
                  break label54;
               }
            } catch (Exception var10) {
               var10000 = var10;
               boolean var28 = false;
               break label76;
            }

            try {
               Exception var20 = new Exception(String.valueOf(var16.errorBody()));
               Failure var17 = new Failure((Throwable)var20);
               return var17;
            } catch (Exception var9) {
               var10000 = var9;
               boolean var29 = false;
               break label76;
            }
         }

         if (var1 != null) {
            try {
               return new Success(var1);
            } catch (Exception var7) {
               var10000 = var7;
               boolean var30 = false;
            }
         } else {
            try {
               Exception var22 = new Exception(String.valueOf(var16.errorBody()));
               return new Failure((Throwable)var22);
            } catch (Exception var8) {
               var10000 = var8;
               boolean var31 = false;
            }
         }
      }

      Exception var18 = var10000;
      return new Failure((Throwable)var18);
   }

   public static final Object doSuspendedApiCall(Function3 var0, Object var1, Object var2, Continuation var3) {
      label73: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var5 = (<undefinedtype>)var3;
            if ((var5.label & Integer.MIN_VALUE) != 0) {
               var5.label += Integer.MIN_VALUE;
               var27 = var5;
               break label73;
            }
         }

         var27 = new ContinuationImpl(var3) {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return AuthServiceKt.doSuspendedApiCall((Function3)null, (Object)null, (Object)null, (Continuation)this);
            }
         };
      }

      Exception var10000;
      label76: {
         Object var28 = ((<undefinedtype>)var27).result;
         Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var4 = ((<undefinedtype>)var27).label;
         Object var17;
         if (var4 != 0) {
            if (var4 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var17 = ((<undefinedtype>)var27).L$2;
            var17 = ((<undefinedtype>)var27).L$1;
            Function3 var16 = (Function3)((<undefinedtype>)var27).L$0;

            try {
               ResultKt.throwOnFailure(var28);
            } catch (Exception var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label76;
            }

            var17 = var28;
         } else {
            ResultKt.throwOnFailure(var28);

            try {
               CoroutineContext var29 = (CoroutineContext)Dispatchers.getIO();
               Function2 var7 = new Function2(var0, var1, var2, (Continuation)null) {
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
                        Function3 var4 = this.$apiCall;
                        var1 = this.$input1;
                        Object var5 = this.$input2;
                        this.label = 1;
                        var1 = var4.invoke(var1, var5, this);
                        return var1 == var3 ? var3 : var1;
                     }
                  }
               };
               var7 = var7;
               ((<undefinedtype>)var27).L$0 = SpillingKt.nullOutSpilledVariable(var0);
               ((<undefinedtype>)var27).L$1 = SpillingKt.nullOutSpilledVariable(var1);
               ((<undefinedtype>)var27).L$2 = SpillingKt.nullOutSpilledVariable(var2);
               ((<undefinedtype>)var27).label = 1;
               var1 = BuildersKt.withContext(var29, var7, (Continuation)var27);
            } catch (Exception var12) {
               var10000 = var12;
               boolean var31 = false;
               break label76;
            }

            var17 = var1;
            if (var1 == var6) {
               return var6;
            }
         }

         label54: {
            try {
               var18 = (Response)var17;
               if (var18.isSuccessful()) {
                  var1 = var18.body();
                  break label54;
               }
            } catch (Exception var11) {
               var10000 = var11;
               boolean var32 = false;
               break label76;
            }

            try {
               Exception var22 = new Exception(String.valueOf(var18.errorBody()));
               Failure var19 = new Failure((Throwable)var22);
               return var19;
            } catch (Exception var10) {
               var10000 = var10;
               boolean var33 = false;
               break label76;
            }
         }

         if (var1 != null) {
            try {
               return new Success(var1);
            } catch (Exception var8) {
               var10000 = var8;
               boolean var34 = false;
            }
         } else {
            try {
               Exception var25 = new Exception(String.valueOf(var18.errorBody()));
               return new Failure((Throwable)var25);
            } catch (Exception var9) {
               var10000 = var9;
               boolean var35 = false;
            }
         }
      }

      Exception var26 = var10000;
      Timber.Forest var24 = Timber.Forest;
      StringBuilder var20 = new StringBuilder("doSuspendedApiCall: exception = ");
      var20.append(var26);
      var24.d(var20.toString(), new Object[0]);
      return new Failure((Throwable)var26);
   }
}
