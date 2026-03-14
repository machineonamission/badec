package com.blueair.adddevice.viewmodel;

import android.app.Application;
import android.content.Context;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.HasSKU;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.DelayKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"},
   d2 = {"Lcom/blueair/adddevice/viewmodel/FinalizeViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "startTimestamp", "", "hasAnalyticsed", "", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "value", "Lcom/blueair/core/model/HasSKU;", "device", "getDevice", "()Lcom/blueair/core/model/HasSKU;", "setPushToken", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitDeviceName", "deviceUuid", "", "deviceName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitDeviceTimezone", "timezone", "Ljava/util/TimeZone;", "(Ljava/lang/String;Ljava/util/TimeZone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInitialOnline", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resubscribeMqttRt5s", "notifyAnalytics", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FinalizeViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(FinalizeViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)))};
   private final Lazy authService$delegate;
   private HasSKU device;
   private boolean hasAnalyticsed;
   private long startTimestamp;

   public FinalizeViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.startTimestamp = System.currentTimeMillis();
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.authService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AuthService.class)), (Object)null).provideDelegate(this, $$delegatedProperties[0]);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   public final Object commitDeviceName(String var1, String var2, Continuation var3) {
      Object var6;
      label1719: {
         if (var3 instanceof <undefinedtype>) {
            var6 = (<undefinedtype>)var3;
            if ((((<undefinedtype>)var6).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var6).label += Integer.MIN_VALUE;
               break label1719;
            }
         }

         var6 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final FinalizeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.commitDeviceName((String)null, (String)null, (Continuation)this);
            }
         };
      }

      label1713: {
         DeviceManager var8 = (DeviceManager)((<undefinedtype>)var6).result;
         Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var4 = ((<undefinedtype>)var6).label;
         String var5;
         String var194;
         Throwable var10000;
         if (var4 != 0) {
            if (var4 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2 = (String)((<undefinedtype>)var6).L$1;
            var1 = (String)((<undefinedtype>)var6).L$0;
            var194 = var1;
            var5 = var2;

            label1662:
            try {
               ResultKt.throwOnFailure(var8);
               break label1713;
            } catch (Throwable var179) {
               var10000 = var179;
               boolean var10001 = false;
               break label1662;
            }
         } else {
            label1723: {
               ResultKt.throwOnFailure(var8);
               var194 = var1;
               var5 = var2;

               try {
                  var199 = Timber.Forest;
               } catch (Throwable var191) {
                  var10000 = var191;
                  boolean var201 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               StringBuilder var9;
               try {
                  var9 = new StringBuilder;
               } catch (Throwable var190) {
                  var10000 = var190;
                  boolean var202 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var9.<init>("commitDeviceName: deviceUuid = ");
               } catch (Throwable var189) {
                  var10000 = var189;
                  boolean var203 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var9.append(var1);
               } catch (Throwable var188) {
                  var10000 = var188;
                  boolean var204 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var9.append(", deviceName = ");
               } catch (Throwable var187) {
                  var10000 = var187;
                  boolean var205 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var9.append(var2);
               } catch (Throwable var186) {
                  var10000 = var186;
                  boolean var206 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var199.d(var9.toString(), new Object[0]);
               } catch (Throwable var185) {
                  var10000 = var185;
                  boolean var207 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var8 = this.getDeviceManager();
               } catch (Throwable var184) {
                  var10000 = var184;
                  boolean var208 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  ((<undefinedtype>)var6).L$0 = var1;
               } catch (Throwable var183) {
                  var10000 = var183;
                  boolean var209 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  ((<undefinedtype>)var6).L$1 = var2;
               } catch (Throwable var182) {
                  var10000 = var182;
                  boolean var210 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  ((<undefinedtype>)var6).label = 1;
               } catch (Throwable var181) {
                  var10000 = var181;
                  boolean var211 = false;
                  break label1723;
               }

               var194 = var1;
               var5 = var2;

               try {
                  var6 = var8.setDeviceName((String)var1, var2, (Continuation)var6);
               } catch (Throwable var180) {
                  var10000 = var180;
                  boolean var212 = false;
                  break label1723;
               }

               if (var6 == var7) {
                  return var7;
               }
               break label1713;
            }
         }

         Throwable var192 = var10000;
         Timber.Forest var197 = Timber.Forest;
         StringBuilder var193 = new StringBuilder("commitDeviceName(");
         var193.append(var194);
         var193.append(", ");
         var193.append(var5);
         var193.append(") done");
         var197.d(var193.toString(), new Object[0]);
         throw var192;
      }

      Timber.Forest var196 = Timber.Forest;
      StringBuilder var195 = new StringBuilder("commitDeviceName(");
      var195.append(var1);
      var195.append(", ");
      var195.append(var2);
      var195.append(") done");
      var196.d(var195.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   public final Object commitDeviceTimezone(String var1, TimeZone var2, Continuation var3) {
      Object var6;
      label2011: {
         if (var3 instanceof <undefinedtype>) {
            var6 = (<undefinedtype>)var3;
            if ((((<undefinedtype>)var6).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var6).label += Integer.MIN_VALUE;
               break label2011;
            }
         }

         var6 = new ContinuationImpl(this, var3) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final FinalizeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.commitDeviceTimezone((String)null, (TimeZone)null, (Continuation)this);
            }
         };
      }

      String var5;
      Throwable var10000;
      label2014: {
         DeviceManager var7 = (DeviceManager)((<undefinedtype>)var6).result;
         Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var4 = ((<undefinedtype>)var6).label;
         if (var4 != 0) {
            if (var4 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var2 = (TimeZone)((<undefinedtype>)var6).L$1;
            var1 = (String)((<undefinedtype>)var6).L$0;
            var5 = var1;
            var252 = var2;

            try {
               ResultKt.throwOnFailure(var7);
            } catch (Throwable var249) {
               var10000 = var249;
               boolean var10001 = false;
               break label2014;
            }

            var6 = var7;
         } else {
            ResultKt.throwOnFailure(var7);
            var5 = var1;
            var252 = var2;

            Timber.Forest var9;
            try {
               var9 = Timber.Forest;
            } catch (Throwable var248) {
               var10000 = var248;
               boolean var262 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var258 = new StringBuilder;
            } catch (Throwable var247) {
               var10000 = var247;
               boolean var263 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var258.<init>("commitDeviceTimezone: deviceUuid = ");
            } catch (Throwable var246) {
               var10000 = var246;
               boolean var264 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var258.append(var1);
            } catch (Throwable var245) {
               var10000 = var245;
               boolean var265 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var258.append(", timezone = ");
            } catch (Throwable var244) {
               var10000 = var244;
               boolean var266 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var258.append(var2);
            } catch (Throwable var243) {
               var10000 = var243;
               boolean var267 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var9.d(var258.toString(), new Object[0]);
            } catch (Throwable var242) {
               var10000 = var242;
               boolean var268 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var7 = this.getDeviceManager();
            } catch (Throwable var241) {
               var10000 = var241;
               boolean var269 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var261 = (Context)this.getApplication();
            } catch (Throwable var240) {
               var10000 = var240;
               boolean var270 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               ((<undefinedtype>)var6).L$0 = var1;
            } catch (Throwable var239) {
               var10000 = var239;
               boolean var271 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               ((<undefinedtype>)var6).L$1 = var2;
            } catch (Throwable var238) {
               var10000 = var238;
               boolean var272 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               ((<undefinedtype>)var6).label = 1;
            } catch (Throwable var237) {
               var10000 = var237;
               boolean var273 = false;
               break label2014;
            }

            var5 = var1;
            var252 = var2;

            try {
               var7 = (DeviceManager)var7.setDeviceTimezone((String)var1, var2, var261, (Continuation)var6);
            } catch (Throwable var236) {
               var10000 = var236;
               boolean var274 = false;
               break label2014;
            }

            var6 = var7;
            if (var7 == var8) {
               return var8;
            }
         }

         var5 = var1;
         var252 = var2;

         try {
            ApiResult var257 = (ApiResult)var6;
         } catch (Throwable var235) {
            var10000 = var235;
            boolean var275 = false;
            break label2014;
         }

         Timber.Forest var254 = Timber.Forest;
         StringBuilder var253 = new StringBuilder("commitDeviceTimezone(");
         var253.append(var1);
         var253.append(", ");
         var253.append(var2);
         var253.append(") done");
         var254.d(var253.toString(), new Object[0]);
         return Unit.INSTANCE;
      }

      Throwable var250 = var10000;
      Timber.Forest var251 = Timber.Forest;
      StringBuilder var256 = new StringBuilder("commitDeviceTimezone(");
      var256.append(var5);
      var256.append(", ");
      var256.append(var252);
      var256.append(") done");
      var251.d(var256.toString(), new Object[0]);
      throw var250;
   }

   public final Object ensureInitialOnline(String var1, Continuation var2) {
      Object var6;
      label43977: {
         if (var2 instanceof <undefinedtype>) {
            var6 = (<undefinedtype>)var2;
            if ((((<undefinedtype>)var6).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var6).label += Integer.MIN_VALUE;
               break label43977;
            }
         }

         var6 = new ContinuationImpl(this, (Continuation)var2) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final FinalizeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.ensureInitialOnline((String)null, (Continuation)this);
            }
         };
      }

      label43970: {
         Throwable var10000;
         label43980: {
            Object var8;
            label43968: {
               label43967: {
                  label43996: {
                     label43997: {
                        Object var9;
                        int var5182;
                        int var5189;
                        label43985: {
                           Object var5207;
                           label43960: {
                              var8 = ((<undefinedtype>)var6).result;
                              var9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              switch (((<undefinedtype>)var6).label) {
                                 case 0:
                                    ResultKt.throwOnFailure(var8);
                                    var5178 = var1;

                                    try {
                                       ((<undefinedtype>)var6).L$0 = var1;
                                    } catch (Throwable var5141) {
                                       var10000 = var5141;
                                       boolean var5253 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       ((<undefinedtype>)var6).label = 1;
                                    } catch (Throwable var5140) {
                                       var10000 = var5140;
                                       boolean var5254 = false;
                                       break label43997;
                                    }

                                    String var5209 = var1;
                                    var5178 = var1;

                                    try {
                                       if (DelayKt.delay(10000L, (Continuation)var6) == var9) {
                                          return var9;
                                       }
                                    } catch (Throwable var5139) {
                                       var10000 = var5139;
                                       boolean var5255 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       var5174 = Timber.Forest;
                                    } catch (Throwable var5149) {
                                       var10000 = var5149;
                                       boolean var5256 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       var5216 = new StringBuilder;
                                    } catch (Throwable var5150) {
                                       var10000 = var5150;
                                       boolean var5257 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       var5216.<init>("ensureInitialOnline(");
                                    } catch (Throwable var5151) {
                                       var10000 = var5151;
                                       boolean var5258 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       var5216.append(var5209);
                                    } catch (Throwable var5152) {
                                       var10000 = var5152;
                                       boolean var5259 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       var5216.append(") started");
                                    } catch (Throwable var5153) {
                                       var10000 = var5153;
                                       boolean var5260 = false;
                                       break label43997;
                                    }

                                    var5178 = var1;

                                    try {
                                       var5174.d(var5216.toString(), new Object[0]);
                                    } catch (Throwable var5154) {
                                       var10000 = var5154;
                                       boolean var5261 = false;
                                       break label43997;
                                    }

                                    var5182 = 0;
                                    var5189 = 0;
                                    var1 = var1;
                                    break;
                                 case 1:
                                    String var5208 = (String)((<undefinedtype>)var6).L$0;
                                    var5178 = var5208;

                                    try {
                                       ResultKt.throwOnFailure(var8);
                                    } catch (Throwable var5142) {
                                       var10000 = var5142;
                                       boolean var5246 = false;
                                       break label43997;
                                    }

                                    var5178 = var5208;

                                    try {
                                       var5173 = Timber.Forest;
                                    } catch (Throwable var5138) {
                                       var10000 = var5138;
                                       boolean var5247 = false;
                                       break label43997;
                                    }

                                    var5178 = var5208;

                                    try {
                                       var5215 = new StringBuilder;
                                    } catch (Throwable var5137) {
                                       var10000 = var5137;
                                       boolean var5248 = false;
                                       break label43997;
                                    }

                                    var5178 = var5208;

                                    try {
                                       var5215.<init>("ensureInitialOnline(");
                                    } catch (Throwable var5136) {
                                       var10000 = var5136;
                                       boolean var5249 = false;
                                       break label43997;
                                    }

                                    var5178 = var5208;

                                    try {
                                       var5215.append(var5208);
                                    } catch (Throwable var5135) {
                                       var10000 = var5135;
                                       boolean var5250 = false;
                                       break label43997;
                                    }

                                    var5178 = var5208;

                                    try {
                                       var5215.append(") started");
                                    } catch (Throwable var5134) {
                                       var10000 = var5134;
                                       boolean var5251 = false;
                                       break label43997;
                                    }

                                    var5178 = var5208;

                                    try {
                                       var5173.d(var5215.toString(), new Object[0]);
                                    } catch (Throwable var5133) {
                                       var10000 = var5133;
                                       boolean var5252 = false;
                                       break label43997;
                                    }

                                    var5182 = 0;
                                    var5189 = 0;
                                    var1 = var5208;
                                    break;
                                 case 2:
                                    var5182 = ((<undefinedtype>)var6).I$1;
                                    var5189 = ((<undefinedtype>)var6).I$0;
                                    var1 = (String)((<undefinedtype>)var6).L$0;
                                    var5179 = var1;

                                    try {
                                       ResultKt.throwOnFailure(var8);
                                    } catch (Throwable var5120) {
                                       var10000 = var5120;
                                       boolean var5230 = false;
                                       break label43996;
                                    }

                                    var5207 = var6;
                                    var5179 = var1;

                                    try {
                                       var5193 = (Boolean)((ApiResult)var8).getOrNull();
                                    } catch (Throwable var5155) {
                                       var10000 = var5155;
                                       boolean var5231 = false;
                                       break label43996;
                                    }

                                    if (var5193 != null) {
                                       var5179 = var1;

                                       try {
                                          var5182 = var5193;
                                       } catch (Throwable var5156) {
                                          var10000 = var5156;
                                          boolean var5232 = false;
                                          break label43996;
                                       }
                                    } else {
                                       var5182 = 0;
                                    }

                                    ++var5189;
                                    var5179 = var1;

                                    try {
                                       var5194 = Timber.Forest;
                                    } catch (Throwable var5157) {
                                       var10000 = var5157;
                                       boolean var5233 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5214 = new StringBuilder;
                                    } catch (Throwable var5158) {
                                       var10000 = var5158;
                                       boolean var5234 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5214.<init>();
                                    } catch (Throwable var5159) {
                                       var10000 = var5159;
                                       boolean var5235 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5214.append("ensureInitialOnline: checkCount=");
                                    } catch (Throwable var5160) {
                                       var10000 = var5160;
                                       boolean var5236 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5214.append(var5189);
                                    } catch (Throwable var5161) {
                                       var10000 = var5161;
                                       boolean var5237 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5214.append(", result=");
                                    } catch (Throwable var5162) {
                                       var10000 = var5162;
                                       boolean var5238 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5214.append((boolean)var5182);
                                    } catch (Throwable var5163) {
                                       var10000 = var5163;
                                       boolean var5239 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       var5194.d(var5214.toString(), new Object[0]);
                                    } catch (Throwable var5164) {
                                       var10000 = var5164;
                                       boolean var5240 = false;
                                       break label43996;
                                    }

                                    if (var5182 != 0 || var5189 >= 6) {
                                       break label43960;
                                    }

                                    var5179 = var1;

                                    try {
                                       ((<undefinedtype>)var5207).L$0 = var1;
                                    } catch (Throwable var5165) {
                                       var10000 = var5165;
                                       boolean var5241 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       ((<undefinedtype>)var5207).I$0 = var5189;
                                    } catch (Throwable var5166) {
                                       var10000 = var5166;
                                       boolean var5242 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       ((<undefinedtype>)var5207).I$1 = var5182;
                                    } catch (Throwable var5167) {
                                       var10000 = var5167;
                                       boolean var5243 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       ((<undefinedtype>)var5207).label = 3;
                                    } catch (Throwable var5168) {
                                       var10000 = var5168;
                                       boolean var5244 = false;
                                       break label43996;
                                    }

                                    var5179 = var1;

                                    try {
                                       if (DelayKt.delay(5000L, (Continuation)var5207) == var9) {
                                          return var9;
                                       }
                                    } catch (Throwable var5169) {
                                       var10000 = var5169;
                                       boolean var5245 = false;
                                       break label43996;
                                    }

                                    var6 = var6;
                                    var5189 = var5182;
                                    var5182 = var5189;
                                    break;
                                 case 3:
                                    var5189 = ((<undefinedtype>)var6).I$1;
                                    var5182 = ((<undefinedtype>)var6).I$0;
                                    var1 = (String)((<undefinedtype>)var6).L$0;

                                    try {
                                       ResultKt.throwOnFailure(var8);
                                       break;
                                    } finally {
                                       break label43970;
                                    }
                                 case 4:
                                    var5182 = ((<undefinedtype>)var6).I$1;
                                    var5189 = ((<undefinedtype>)var6).I$0;
                                    String var5177 = (String)((<undefinedtype>)var6).L$0;
                                    var1 = var5177;

                                    try {
                                       ResultKt.throwOnFailure(var8);
                                    } catch (Throwable var5097) {
                                       var10000 = var5097;
                                       boolean var5223 = false;
                                       break label43967;
                                    }

                                    var5207 = var6;
                                    String var5192 = var5177;
                                    var5178 = var5177;

                                    try {
                                       Timber.Forest.d("ensureInitialOnline: call initial done", new Object[0]);
                                    } catch (Throwable var5143) {
                                       var10000 = var5143;
                                       boolean var5224 = false;
                                       break label43997;
                                    }

                                    var5178 = var5177;

                                    try {
                                       ((<undefinedtype>)var5207).L$0 = var5192;
                                    } catch (Throwable var5144) {
                                       var10000 = var5144;
                                       boolean var5225 = false;
                                       break label43997;
                                    }

                                    var5178 = var5177;

                                    try {
                                       ((<undefinedtype>)var5207).I$0 = var5189;
                                    } catch (Throwable var5145) {
                                       var10000 = var5145;
                                       boolean var5226 = false;
                                       break label43997;
                                    }

                                    var5178 = var5177;

                                    try {
                                       ((<undefinedtype>)var5207).I$1 = var5182;
                                    } catch (Throwable var5146) {
                                       var10000 = var5146;
                                       boolean var5227 = false;
                                       break label43997;
                                    }

                                    var5178 = var5177;

                                    try {
                                       ((<undefinedtype>)var5207).label = 5;
                                    } catch (Throwable var5147) {
                                       var10000 = var5147;
                                       boolean var5228 = false;
                                       break label43997;
                                    }

                                    var8 = var6;
                                    var1 = var5177;
                                    var5178 = var5177;

                                    try {
                                       if (DelayKt.delay(100L, (Continuation)var5207) == var9) {
                                          return var9;
                                       }
                                       break label43985;
                                    } catch (Throwable var5148) {
                                       var10000 = var5148;
                                       boolean var5229 = false;
                                       break label43997;
                                    }
                                 case 5:
                                    var5182 = ((<undefinedtype>)var6).I$1;
                                    var5189 = ((<undefinedtype>)var6).I$0;
                                    String var5176 = (String)((<undefinedtype>)var6).L$0;
                                    var1 = var5176;

                                    try {
                                       ResultKt.throwOnFailure(var8);
                                    } catch (Throwable var5096) {
                                       var10000 = var5096;
                                       boolean var5222 = false;
                                       break label43967;
                                    }

                                    var1 = var5176;
                                    var8 = var6;
                                    break label43985;
                                 case 6:
                                    var5182 = ((<undefinedtype>)var6).I$1;
                                    var5182 = ((<undefinedtype>)var6).I$0;
                                    FinalizeViewModel var7 = (FinalizeViewModel)((<undefinedtype>)var6).L$1;
                                    var1 = (String)((<undefinedtype>)var6).L$0;
                                    var5175 = var1;

                                    try {
                                       ResultKt.throwOnFailure(var8);
                                    } catch (Throwable var5087) {
                                       var10000 = var5087;
                                       boolean var10001 = false;
                                       break label43980;
                                    }

                                    var5191 = var7;
                                    break label43968;
                                 default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              while(true) {
                                 var5178 = var1;

                                 try {
                                    var5210 = this.getDeviceManager();
                                 } catch (Throwable var5132) {
                                    var10000 = var5132;
                                    boolean var5262 = false;
                                    break label43997;
                                 }

                                 var5178 = var1;

                                 try {
                                    ((<undefinedtype>)var6).L$0 = var1;
                                 } catch (Throwable var5131) {
                                    var10000 = var5131;
                                    boolean var5263 = false;
                                    break label43997;
                                 }

                                 var5178 = var1;

                                 try {
                                    ((<undefinedtype>)var6).I$0 = var5182;
                                 } catch (Throwable var5130) {
                                    var10000 = var5130;
                                    boolean var5264 = false;
                                    break label43997;
                                 }

                                 var5178 = var1;

                                 try {
                                    ((<undefinedtype>)var6).I$1 = var5189;
                                 } catch (Throwable var5129) {
                                    var10000 = var5129;
                                    boolean var5265 = false;
                                    break label43997;
                                 }

                                 var5178 = var1;

                                 try {
                                    ((<undefinedtype>)var6).label = 2;
                                 } catch (Throwable var5128) {
                                    var10000 = var5128;
                                    boolean var5266 = false;
                                    break label43997;
                                 }

                                 var5178 = var1;

                                 try {
                                    var8 = var5210.getBlueDeviceStatus(var1, (Continuation)var6);
                                 } catch (Throwable var5127) {
                                    var10000 = var5127;
                                    boolean var5267 = false;
                                    break label43997;
                                 }

                                 if (var8 == var9) {
                                    return var9;
                                 }

                                 var5189 = var5182;
                                 var5207 = var6;
                                 var5179 = var1;

                                 try {
                                    var5195 = (Boolean)((ApiResult)var8).getOrNull();
                                 } catch (Throwable var5114) {
                                    var10000 = var5114;
                                    boolean var5268 = false;
                                    break label43996;
                                 }

                                 if (var5195 != null) {
                                    var5179 = var1;

                                    try {
                                       var5182 = var5195;
                                    } catch (Throwable var5113) {
                                       var10000 = var5113;
                                       boolean var5269 = false;
                                       break label43996;
                                    }
                                 } else {
                                    var5182 = 0;
                                 }

                                 ++var5189;
                                 var5179 = var1;

                                 try {
                                    var5196 = Timber.Forest;
                                 } catch (Throwable var5112) {
                                    var10000 = var5112;
                                    boolean var5270 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5218 = new StringBuilder;
                                 } catch (Throwable var5111) {
                                    var10000 = var5111;
                                    boolean var5271 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5218.<init>();
                                 } catch (Throwable var5110) {
                                    var10000 = var5110;
                                    boolean var5272 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5218.append("ensureInitialOnline: checkCount=");
                                 } catch (Throwable var5109) {
                                    var10000 = var5109;
                                    boolean var5273 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5218.append(var5189);
                                 } catch (Throwable var5108) {
                                    var10000 = var5108;
                                    boolean var5274 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5218.append(", result=");
                                 } catch (Throwable var5107) {
                                    var10000 = var5107;
                                    boolean var5275 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5218.append((boolean)var5182);
                                 } catch (Throwable var5106) {
                                    var10000 = var5106;
                                    boolean var5276 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    var5196.d(var5218.toString(), new Object[0]);
                                 } catch (Throwable var5105) {
                                    var10000 = var5105;
                                    boolean var5277 = false;
                                    break label43996;
                                 }

                                 if (var5182 != 0 || var5189 >= 6) {
                                    break;
                                 }

                                 var5179 = var1;

                                 try {
                                    ((<undefinedtype>)var5207).L$0 = var1;
                                 } catch (Throwable var5119) {
                                    var10000 = var5119;
                                    boolean var5278 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    ((<undefinedtype>)var5207).I$0 = var5189;
                                 } catch (Throwable var5118) {
                                    var10000 = var5118;
                                    boolean var5279 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    ((<undefinedtype>)var5207).I$1 = var5182;
                                 } catch (Throwable var5117) {
                                    var10000 = var5117;
                                    boolean var5280 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    ((<undefinedtype>)var5207).label = 3;
                                 } catch (Throwable var5116) {
                                    var10000 = var5116;
                                    boolean var5281 = false;
                                    break label43996;
                                 }

                                 var5179 = var1;

                                 try {
                                    if (DelayKt.delay(5000L, (Continuation)var5207) == var9) {
                                       return var9;
                                    }
                                 } catch (Throwable var5115) {
                                    var10000 = var5115;
                                    boolean var5282 = false;
                                    break label43996;
                                 }

                                 var6 = var6;
                                 var5189 = var5182;
                                 var5182 = var5189;
                              }
                           }

                           var5179 = var1;

                           try {
                              Timber.Forest.d("ensureInitialOnline: call initial", new Object[0]);
                           } catch (Throwable var5104) {
                              var10000 = var5104;
                              boolean var5283 = false;
                              break label43996;
                           }

                           var5179 = var1;

                           try {
                              var5197 = this.getDeviceManager();
                           } catch (Throwable var5103) {
                              var10000 = var5103;
                              boolean var5284 = false;
                              break label43996;
                           }

                           var5179 = var1;

                           try {
                              ((<undefinedtype>)var5207).L$0 = var1;
                           } catch (Throwable var5102) {
                              var10000 = var5102;
                              boolean var5285 = false;
                              break label43996;
                           }

                           var5179 = var1;

                           try {
                              ((<undefinedtype>)var5207).I$0 = var5189;
                           } catch (Throwable var5101) {
                              var10000 = var5101;
                              boolean var5286 = false;
                              break label43996;
                           }

                           var5179 = var1;

                           try {
                              ((<undefinedtype>)var5207).I$1 = var5182;
                           } catch (Throwable var5100) {
                              var10000 = var5100;
                              boolean var5287 = false;
                              break label43996;
                           }

                           var5179 = var1;

                           try {
                              ((<undefinedtype>)var5207).label = 4;
                           } catch (Throwable var5099) {
                              var10000 = var5099;
                              boolean var5288 = false;
                              break label43996;
                           }

                           var5179 = var1;

                           try {
                              var6 = var5197.checkInitialOnline(var1, (Continuation)var5207);
                           } catch (Throwable var5098) {
                              var10000 = var5098;
                              boolean var5289 = false;
                              break label43996;
                           }

                           if (var6 == var9) {
                              return var9;
                           }

                           String var5200 = var1;
                           var5178 = var1;

                           try {
                              Timber.Forest.d("ensureInitialOnline: call initial done", new Object[0]);
                           } catch (Throwable var5126) {
                              var10000 = var5126;
                              boolean var5290 = false;
                              break label43997;
                           }

                           var5178 = var1;

                           try {
                              ((<undefinedtype>)var5207).L$0 = var5200;
                           } catch (Throwable var5125) {
                              var10000 = var5125;
                              boolean var5291 = false;
                              break label43997;
                           }

                           var5178 = var1;

                           try {
                              ((<undefinedtype>)var5207).I$0 = var5189;
                           } catch (Throwable var5124) {
                              var10000 = var5124;
                              boolean var5292 = false;
                              break label43997;
                           }

                           var5178 = var1;

                           try {
                              ((<undefinedtype>)var5207).I$1 = var5182;
                           } catch (Throwable var5123) {
                              var10000 = var5123;
                              boolean var5293 = false;
                              break label43997;
                           }

                           var5178 = var1;

                           try {
                              ((<undefinedtype>)var5207).label = 5;
                           } catch (Throwable var5122) {
                              var10000 = var5122;
                              boolean var5294 = false;
                              break label43997;
                           }

                           var8 = var5207;
                           var1 = var1;
                           var5178 = var1;

                           try {
                              if (DelayKt.delay(100L, (Continuation)var5207) == var9) {
                                 return var9;
                              }
                           } catch (Throwable var5121) {
                              var10000 = var5121;
                              boolean var5295 = false;
                              break label43997;
                           }
                        }

                        var5178 = var1;

                        try {
                           var5201 = this.getDeviceManager();
                        } catch (Throwable var5095) {
                           var10000 = var5095;
                           boolean var5296 = false;
                           break label43997;
                        }

                        var5178 = var1;

                        try {
                           ((<undefinedtype>)var8).L$0 = var1;
                        } catch (Throwable var5094) {
                           var10000 = var5094;
                           boolean var5297 = false;
                           break label43997;
                        }

                        var5178 = var1;

                        try {
                           ((<undefinedtype>)var8).L$1 = this;
                        } catch (Throwable var5093) {
                           var10000 = var5093;
                           boolean var5298 = false;
                           break label43997;
                        }

                        var5178 = var1;

                        try {
                           ((<undefinedtype>)var8).I$0 = var5189;
                        } catch (Throwable var5092) {
                           var10000 = var5092;
                           boolean var5299 = false;
                           break label43997;
                        }

                        var5178 = var1;

                        try {
                           ((<undefinedtype>)var8).I$1 = var5182;
                        } catch (Throwable var5091) {
                           var10000 = var5091;
                           boolean var5300 = false;
                           break label43997;
                        }

                        var5178 = var1;

                        try {
                           ((<undefinedtype>)var8).label = 6;
                        } catch (Throwable var5090) {
                           var10000 = var5090;
                           boolean var5301 = false;
                           break label43997;
                        }

                        var5178 = var1;

                        try {
                           var8 = var5201.getDatabaseDevice(var1, (Continuation)var8);
                        } catch (Throwable var5089) {
                           var10000 = var5089;
                           boolean var5302 = false;
                           break label43997;
                        }

                        if (var8 == var9) {
                           return var9;
                        }

                        var5191 = this;
                        break label43968;
                     }

                     Throwable var5202 = var10000;
                     var1 = var5178;
                     var2 = var5202;
                     break label43970;
                  }

                  Throwable var5198 = var10000;
                  var1 = var5179;
                  var2 = var5198;
                  break label43970;
               }

               var2 = var10000;
               break label43970;
            }

            var5175 = var1;

            HasSKU var5211;
            label43500: {
               label43990: {
                  try {
                     if (!(var8 instanceof HasSKU)) {
                        break label43990;
                     }
                  } catch (Throwable var5088) {
                     var10000 = var5088;
                     boolean var5303 = false;
                     break label43980;
                  }

                  var5175 = var1;

                  try {
                     var5211 = (HasSKU)var8;
                     break label43500;
                  } catch (Throwable var5086) {
                     var10000 = var5086;
                     boolean var5304 = false;
                     break label43980;
                  }
               }

               var5211 = null;
            }

            var5175 = var1;

            try {
               var5191.device = var5211;
            } catch (Throwable var5084) {
               var10000 = var5084;
               boolean var5305 = false;
               break label43980;
            }

            Timber.Forest var5180 = Timber.Forest;
            StringBuilder var5205 = new StringBuilder("ensureInitialOnline(");
            var5205.append(var1);
            var5205.append(") done");
            var5180.d(var5205.toString(), new Object[0]);
            return Unit.INSTANCE;
         }

         Throwable var5203 = var10000;
         var1 = var5175;
         var2 = var5203;
      }

      Timber.Forest var5204 = Timber.Forest;
      StringBuilder var5212 = new StringBuilder("ensureInitialOnline(");
      var5212.append(var1);
      var5212.append(") done");
      var5204.d(var5212.toString(), new Object[0]);
      throw var2;
   }

   public final HasSKU getDevice() {
      return this.device;
   }

   public final void notifyAnalytics() {
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("notifyAnalytics: hasAnalyticsed = ");
      var5.append(this.hasAnalyticsed);
      var6.d(var5.toString(), new Object[0]);
      if (!this.hasAnalyticsed) {
         this.hasAnalyticsed = true;
         long var3 = System.currentTimeMillis();
         long var1 = (var3 - this.startTimestamp) / (long)1000;
         var6 = Timber.Forest;
         var5 = new StringBuilder("notifyAnalytics: durationInSeconds = ");
         var5.append(var1);
         var5.append(", finalizedTimeStamp = ");
         var5.append(var3);
         var5.append(", startTimestamp = ");
         var5.append(this.startTimestamp);
         var6.d(var5.toString(), new Object[0]);
         this.getAnalyticsService().event(new AnalyticEvent.BT_FINALIZE((int)var1));
      }

   }

   public final void resubscribeMqttRt5s(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceUuid");
      this.getDeviceManager().resubscribeMqttRt5s(var1);
   }

   public final Object setPushToken(Continuation var1) {
      label196: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var17 = var3;
               break label196;
            }
         }

         var17 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final FinalizeViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setPushToken((Continuation)this);
            }
         };
      }

      Throwable var10000;
      label199: {
         Object var21 = ((<undefinedtype>)var17).result;
         Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
         int var2 = ((<undefinedtype>)var17).label;
         Object var18;
         if (var2 != 0) {
            if (var2 != 1) {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            try {
               ResultKt.throwOnFailure(var21);
            } catch (Throwable var16) {
               var10000 = var16;
               boolean var10001 = false;
               break label199;
            }

            var18 = var21;
         } else {
            ResultKt.throwOnFailure(var21);

            try {
               Timber.Forest.d("setPushToken()", new Object[0]);
               AuthService var22 = this.getAuthService();
               ((<undefinedtype>)var17).label = 1;
               var21 = AuthService.setPushToken$default(var22, (String)null, (Continuation)var17, 1, (Object)null);
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var24 = false;
               break label199;
            }

            var18 = var21;
            if (var21 == var4) {
               return var4;
            }
         }

         try {
            ApiResult var20 = (ApiResult)var18;
         } catch (Throwable var14) {
            var10000 = var14;
            boolean var25 = false;
            break label199;
         }

         Timber.Forest.d("setPushToken() done", new Object[0]);
         return Unit.INSTANCE;
      }

      Throwable var19 = var10000;
      Timber.Forest.d("setPushToken() done", new Object[0]);
      throw var19;
   }
}
