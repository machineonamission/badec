package com.blueair.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationManagerCompat;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicemanager.DeviceManager;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import kotlin.Lazy;
import kotlin.Metadata;
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
import kotlinx.coroutines.Dispatchers;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u001b\u001a\u00020\u001cX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"},
   d2 = {"Lcom/blueair/push/DeviceActionService;", "Landroid/app/Service;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "onDestroy", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "push_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceActionService extends Service implements DIAware, CoroutineScope {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceActionService.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceActionService.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)))};
   private final DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
   private final Lazy deviceManager$delegate;
   private final Lazy di$delegate;

   public DeviceActionService() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI();
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var4 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceManager$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, DeviceManager.class)), (Object)null).provideDelegate(this, var1[1]);
   }

   private final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
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

   public IBinder onBind(Intent var1) {
      Intrinsics.checkNotNullParameter(var1, "intent");
      return null;
   }

   public void onDestroy() {
      super.onDestroy();
      Timber.Forest.d("onDestroy", new Object[0]);
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "intent");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("onStartCommand: ");
      var5.append(var1.getAction());
      var4.d(var5.toString(), new Object[0]);
      String var8 = var1.getStringExtra("device_id");
      if (var8 != null) {
         String var7 = var1.getAction();
         if (var7 != null && var7.hashCode() == 246957887 && var7.equals("blueair.action.devicestopalarm")) {
            var2 = var1.getIntExtra("notification_id", 0);
            BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var8, var2, (Continuation)null) {
               final String $deviceId;
               final int $notificationId;
               Object L$0;
               int label;
               final DeviceActionService this$0;

               {
                  this.this$0 = var1;
                  this.$deviceId = var2;
                  this.$notificationId = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$deviceId, this.$notificationId, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Device var3;
                  Object var5;
                  label39: {
                     var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              if (var2 != 3) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              var3 = (Device)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           }

                           var3 = (Device)this.L$0;
                           ResultKt.throwOnFailure(var1);
                           break label39;
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        var1 = this.this$0.getDeviceManager();
                        String var4 = this.$deviceId;
                        Continuation var11 = (Continuation)this;
                        this.label = 1;
                        Object var12 = var1.getDatabaseDevice(var4, var11);
                        var1 = (DeviceManager)var12;
                        if (var12 == var5) {
                           return var5;
                        }
                     }

                     var3 = (Device)var1;
                     if (!(var3 instanceof HasAlarm)) {
                        return Unit.INSTANCE;
                     }

                     DeviceManager var13 = this.this$0.getDeviceManager();
                     HasAlarm var6 = (HasAlarm)var3;
                     Continuation var8 = (Continuation)this;
                     this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                     this.label = 2;
                     Object var14 = var13.stopAlarm(var6, var8);
                     var1 = (DeviceManager)var14;
                     if (var14 == var5) {
                        return var5;
                     }
                  }

                  ApiResult var9 = (ApiResult)var1;
                  Function2 var15 = new Function2(this.this$0, this.$notificationId, (Continuation)null) {
                     final int $notificationId;
                     int label;
                     final DeviceActionService this$0;

                     {
                        this.this$0 = var1;
                        this.$notificationId = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, this.$notificationId, var2));
                     }

                     public final Object invoke(SimpleResponse var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           NotificationManagerCompat.from((Context)this.this$0).cancel(this.$notificationId);
                           this.this$0.stopSelf();
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var16 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var3);
                  this.label = 3;
                  if (ApiResultKt.onSuccess(var9, var15, var16) == var5) {
                     return var5;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, 2, (Object)null);
         } else {
            this.stopSelf();
         }
      }

      return 2;
   }
}
