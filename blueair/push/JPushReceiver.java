package com.blueair.push;

import android.content.Context;
import android.net.Uri;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020 H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006!"},
   d2 = {"Lcom/blueair/push/JPushReceiver;", "Lcn/jpush/android/service/JPushMessageReceiver;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "onRegister", "", "context", "Landroid/content/Context;", "registrationId", "", "onConnected", "connected", "", "onAliasOperatorResult", "message", "Lcn/jpush/android/api/JPushMessage;", "onTagOperatorResult", "onNotifyMessageArrived", "Lcn/jpush/android/api/NotificationMessage;", "onMessage", "Lcn/jpush/android/api/CustomMessage;", "push_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class JPushReceiver extends JPushMessageReceiver implements DIAware {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(JPushReceiver.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(JPushReceiver.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0)))};
   private final Lazy di$delegate;
   private final Lazy notificationService$delegate;

   public JPushReceiver() {
      LazyContextDIPropertyDelegateProvider var2 = ClosestKt.closestDI((Context)CustomViewModelStoreOwner.Companion.getApplication());
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var3 = this;
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.notificationService$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var4, NotificationService.class)), (Object)null).provideDelegate(this, var1[1]);
   }

   private final NotificationService getNotificationService() {
      return (NotificationService)this.notificationService$delegate.getValue();
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

   public void onAliasOperatorResult(Context var1, JPushMessage var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "message");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("onAliasOperatorResult: ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
   }

   public void onConnected(Context var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("onConnected: ");
      var4.append(var2);
      var3.d(var4.toString(), new Object[0]);
   }

   public void onMessage(Context var1, CustomMessage var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "message");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("onMessage: ");
      var4.append(var2);
      var3.d(var4.toString(), new Object[0]);
      String var5 = var2.message;
      Intrinsics.checkNotNullExpressionValue(var5, "message");
      Uri var7 = Uri.parse(var5);
      var5 = var7.getQueryParameter("action");
      if (var5 != null) {
         String var8 = var7.getQueryParameter("did");
         if (Intrinsics.areEqual(var5, "stop_alarm") && var8 != null) {
            this.getNotificationService().showStopAlarmNotification(var8, (String)null, (String)null);
         }
      }

   }

   public void onNotifyMessageArrived(Context var1, NotificationMessage var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "message");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("onNotifyMessageArrived: ");
      var3.append(var2.deeplink);
      var3.append(" | ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
   }

   public void onRegister(Context var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "registrationId");
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("onRegister: ");
      var3.append(var2);
      var4.d(var3.toString(), new Object[0]);
   }

   public void onTagOperatorResult(Context var1, JPushMessage var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "message");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("onTagOperatorResult: ");
      var4.append(var2);
      var3.d(var4.toString(), new Object[0]);
   }
}
