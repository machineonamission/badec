package com.blueair.push;

import android.content.Context;
import android.net.Uri;
import cn.jpush.android.service.PluginFCMMessagingService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.sdk.KlaviyoSdk;
import com.google.firebase.messaging.RemoteMessage;
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
import org.json.JSONObject;
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
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\"\u001a\u00020#X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"},
   d2 = {"Lcom/blueair/push/FirebasePushNotificationService;", "Lcn/jpush/android/service/PluginFCMMessagingService;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "onNewToken", "", "token", "", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "push_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FirebasePushNotificationService extends PluginFCMMessagingService implements DIAware, CoroutineScope {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(FirebasePushNotificationService.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(FirebasePushNotificationService.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(FirebasePushNotificationService.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(FirebasePushNotificationService.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)))};
   private final DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
   private final Lazy analyticsService$delegate;
   private final Lazy deviceManager$delegate;
   private final Lazy di$delegate;
   private final Lazy notificationService$delegate;

   public FirebasePushNotificationService() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI();
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var4 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.notificationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, NotificationService.class)), (Object)null).provideDelegate(this, var1[1]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analyticsService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AnalyticsService.class)), (Object)null).provideDelegate(this, var1[2]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceManager$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, DeviceManager.class)), (Object)null).provideDelegate(this, var1[3]);
   }

   private final AnalyticsService getAnalyticsService() {
      return (AnalyticsService)this.analyticsService$delegate.getValue();
   }

   private final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
   }

   private final NotificationService getNotificationService() {
      return (NotificationService)this.notificationService$delegate.getValue();
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

   public void onMessageReceived(RemoteMessage var1) {
      Intrinsics.checkNotNullParameter(var1, "message");
      super.onMessageReceived(var1);
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("onMessageReceived: ");
      var3.append(var1.getData());
      var2.d(var3.toString(), new Object[0]);
      if (KlaviyoSdk.INSTANCE.isKlaviyoMessage(var1)) {
         Uri var6 = KlaviyoSdk.INSTANCE.getDeeplink(var1);
         if (var6 != null) {
            String var4 = var6.getHost();
            if (var4 != null) {
               String var9 = var6.getQueryParameter("type");
               if (var9 != null) {
                  String var5 = var6.getQueryParameter("action");
                  if (var5 != null) {
                     String var11 = var6.getQueryParameter("did");
                     if (Intrinsics.areEqual(var5, "stop_alarm")) {
                        if (var11 != null) {
                           this.getNotificationService().showStopAlarmNotification(var11, (String)var1.getData().get("title"), (String)var1.getData().get("body"));
                        }
                     } else {
                        KlaviyoSdk.INSTANCE.displayNotification(var1, (Context)this);
                     }

                     BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var11, this, var6, var4, var9, var5, (Continuation)null) {
                        final String $action;
                        final Uri $deeplink;
                        final String $did;
                        final String $path;
                        final String $type;
                        int I$0;
                        Object L$0;
                        int label;
                        final FirebasePushNotificationService this$0;

                        {
                           this.$did = var1;
                           this.this$0 = var2;
                           this.$deeplink = var3;
                           this.$path = var4;
                           this.$type = var5;
                           this.$action = var6;
                        }

                        public final Continuation create(Object var1, Continuation var2) {
                           return (Continuation)(new <anonymous constructor>(this.$did, this.this$0, this.$deeplink, this.$path, this.$type, this.$action, var2));
                        }

                        public final Object invoke(CoroutineScope var1, Continuation var2) {
                           return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           label21: {
                              Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              int var2 = this.label;
                              if (var2 != 0) {
                                 if (var2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 String var3 = (String)this.L$0;
                                 ResultKt.throwOnFailure(var1);
                              } else {
                                 ResultKt.throwOnFailure(var1);
                                 String var7 = this.$did;
                                 if (var7 == null) {
                                    var1 = null;
                                    break label21;
                                 }

                                 var1 = this.this$0.getDeviceManager();
                                 this.L$0 = SpillingKt.nullOutSpilledVariable(var7);
                                 this.I$0 = 0;
                                 this.label = 1;
                                 Object var8 = var1.getDatabaseDevice(var7, this);
                                 var1 = (DeviceManager)var8;
                                 if (var8 == var4) {
                                    return var4;
                                 }
                              }

                              var1 = (Device)var1;
                           }

                           AnalyticsService var10 = this.this$0.getAnalyticsService();
                           String var9 = this.$deeplink.toString();
                           Intrinsics.checkNotNullExpressionValue(var9, "toString(...)");
                           var10.event(new AnalyticEvent.KlaviyoEvent.Receive(var9, this.$path, this.$type, this.$action, var1));
                           return Unit.INSTANCE;
                        }
                     }, 2, (Object)null);
                     return;
                  }
               }
            }
         }
      } else if (!this.getNotificationService().getUseJPush()) {
         String var13 = (String)var1.getData().get("user_id");
         if (var13 != null) {
            String var14 = (String)var1.getData().get("device_id");
            if (var14 != null) {
               String var12 = (String)var1.getData().get("template_id");
               if (var12 != null) {
                  String var10 = (String)var1.getData().get("params");
                  String var7 = var10;
                  if (var10 == null) {
                     var7 = "{}";
                  }

                  JSONObject var8 = new JSONObject(var7);
                  this.getNotificationService().showNotification$push_otherRelease(var13, var14, var12, var8);
               }
            }
         }
      }

   }

   public void onNewToken(String var1) {
      Intrinsics.checkNotNullParameter(var1, "token");
      super.onNewToken(var1);
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Firebase new token = ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      this.getNotificationService().setNotificationToken$push_otherRelease(var1);
   }
}
