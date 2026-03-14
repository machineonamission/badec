package com.blueair.push;

import android.content.Context;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.ups.JPushUPSManager;
import cn.jpush.android.ups.TokenResult;
import com.blueair.auth.AuthService;
import com.blueair.auth.LogOutable;
import com.blueair.auth.RegionUtils;
import com.blueair.core.BuildEnvironment;
import com.blueair.devicemanager.DeviceManager;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u001c\u001a\u00020\u001dX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 ²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002"},
   d2 = {"Lcom/blueair/push/JPushSdkService;", "Lcom/blueair/auth/LogOutable;", "Lkotlinx/coroutines/CoroutineScope;", "Lorg/kodein/di/DIAware;", "context", "Landroid/content/Context;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "<init>", "(Landroid/content/Context;Lcom/blueair/devicemanager/DeviceManager;)V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "value", "", "enabled", "getEnabled", "()Z", "register", "", "unRegister", "setBadgeNumber", "number", "", "logOut", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "push_otherRelease", "authService", "Lcom/blueair/auth/AuthService;"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class JPushSdkService implements LogOutable, CoroutineScope, DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(JPushSdkService.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property0((PropertyReference0)(new PropertyReference0Impl(JPushSdkService.class, "authService", "<v#0>", 0)))};
   private final DefaultCoroutineScope $$delegate_0;
   private final Context context;
   private final DeviceManager deviceManager;
   private final Lazy di$delegate;
   private boolean enabled;

   // $FF: synthetic method
   public static void $r8$lambda$4p1da1mNyDjEvqvmi1DLEazRfDU(JPushSdkService var0, TokenResult var1) {
      register$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$gvMB16bV0ZJHO8h_F5voXobSMdQ/* $FF was: $r8$lambda$gvMB16bV0ZJHO8h-F5voXobSMdQ*/(TokenResult var0) {
      unRegister$lambda$2(var0);
   }

   public JPushSdkService(Context var1, DeviceManager var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "deviceManager");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.context = var1;
      this.deviceManager = var2;
      this.di$delegate = ClosestKt.closestDI(var1).provideDelegate(this, $$delegatedProperties[0]);
      this.enabled = true;
   }

   private static final void register$lambda$0(JPushSdkService var0, TokenResult var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("JPush register result: ");
      var3.append(var1.getReturnCode());
      var3.append(" | ");
      var3.append(var1.getActionType());
      var3.append(" | ");
      var3.append(var1.getToken());
      var2.d(var3.toString(), new Object[0]);
      BuildersKt.launch$default(var0, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, (Continuation)null) {
         final TokenResult $result;
         int label;
         final JPushSdkService this$0;

         {
            this.this$0 = var1;
            this.$result = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$result, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var5 = this.this$0.deviceManager;
               String var6 = this.$result.getToken();
               Intrinsics.checkNotNullExpressionValue(var6, "getToken(...)");
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.linkJPush(var6, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   private static final AuthService unRegister$lambda$1(Lazy var0) {
      return (AuthService)var0.getValue();
   }

   private static final void unRegister$lambda$2(TokenResult var0) {
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("JPush unregister result: ");
      var2.append(var0.getReturnCode());
      var2.append(" | ");
      var2.append(var0.getActionType());
      var2.append(" | ");
      var2.append(var0.getToken());
      var1.d(var2.toString(), new Object[0]);
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   public final boolean getEnabled() {
      return this.enabled;
   }

   public void logOut() {
      if (this.enabled) {
         this.unRegister();
      }
   }

   public final void register(boolean var1) {
      this.enabled = var1;
      if (var1) {
         String var4 = RegionUtils.INSTANCE.getResourceConfigCountryOrFallback(this.context);
         Timber.Forest var2 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("register jpush: countryCode=");
         var3.append(var4);
         var2.d(var3.toString(), new Object[0]);
         JPushInterface.setDebugMode(BuildEnvironment.INSTANCE.isRelease() ^ true);
         JPushConstants.init(this.context);
         JCoreInterface.setCountryCode(this.context, var4);
         String var5 = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getString("JPUSH_APPKEY");
         JPushUPSManager.registerToken(this.context, var5, (String)null, (String)null, new JPushSdkService$$ExternalSyntheticLambda0(this));
      }
   }

   public final void setBadgeNumber(int var1) {
      if (this.enabled) {
         JPushInterface.setBadgeNumber(this.context, var1);
      }
   }

   public final void unRegister() {
      if (this.enabled) {
         String var1 = JPushInterface.getRegistrationID(this.context);
         DIAware var2 = this;
         JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
         }).getSuperType());
         Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
         String var4 = unRegister$lambda$1(DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AuthService.class)), (Object)null).provideDelegate((Object)null, $$delegatedProperties[1])).getBearerToken();
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var4, var1, (Continuation)null) {
            final String $bearerToken;
            final String $jgid;
            int label;
            final JPushSdkService this$0;

            {
               this.this$0 = var1;
               this.$bearerToken = var2;
               this.$jgid = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$bearerToken, this.$jgid, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  var1 = this.this$0.deviceManager;
                  String var4 = this.$bearerToken;
                  String var6 = this.$jgid;
                  Intrinsics.checkNotNull(var6);
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (var1.unlinkJPush(var4, var6, var5) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
         JPushUPSManager.unRegisterToken(this.context, new JPushSdkService$$ExternalSyntheticLambda1());
      }
   }
}
