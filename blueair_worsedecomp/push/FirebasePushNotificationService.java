package com.blueair.push;

import android.content.Context;
import android.net.Uri;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.sdk.KlaviyoSdk;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\"\u001a\u00020#X\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/blueair/push/FirebasePushNotificationService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "onNewToken", "", "token", "", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "push_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FirebasePushNotificationService.kt */
public final class FirebasePushNotificationService extends FirebaseMessagingService implements DIAware, CoroutineScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final Lazy analyticsService$delegate;
    private final Lazy deviceManager$delegate;
    private final Lazy di$delegate;
    private final Lazy notificationService$delegate;

    static {
        Class<FirebasePushNotificationService> cls = FirebasePushNotificationService.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))};
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public FirebasePushNotificationService() {
        DIPropertyDelegateProvider<Context> closestDI = ClosestKt.closestDI();
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new FirebasePushNotificationService$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.notificationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, NotificationService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new FirebasePushNotificationService$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analyticsService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AnalyticsService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new FirebasePushNotificationService$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceManager$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, DeviceManager.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    private final NotificationService getNotificationService() {
        return (NotificationService) this.notificationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AnalyticsService getAnalyticsService() {
        return (AnalyticsService) this.analyticsService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        super.onNewToken(str);
        Timber.Forest forest = Timber.Forest;
        forest.d("Firebase new token = " + str, new Object[0]);
        getNotificationService().setNotificationToken$push_otherRelease(str);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        String str2;
        String host;
        String queryParameter;
        String queryParameter2;
        Intrinsics.checkNotNullParameter(remoteMessage, "message");
        super.onMessageReceived(remoteMessage);
        Timber.Forest forest = Timber.Forest;
        forest.d("onMessageReceived: " + remoteMessage.getData(), new Object[0]);
        if (KlaviyoSdk.INSTANCE.isKlaviyoMessage(remoteMessage)) {
            Uri deeplink = KlaviyoSdk.INSTANCE.getDeeplink(remoteMessage);
            if (deeplink != null && (host = deeplink.getHost()) != null && (queryParameter = deeplink.getQueryParameter("type")) != null && (queryParameter2 = deeplink.getQueryParameter("action")) != null) {
                String queryParameter3 = deeplink.getQueryParameter("did");
                if (!Intrinsics.areEqual((Object) queryParameter2, (Object) NotificationService.ACTION_TYPE_STOP_ALARM)) {
                    KlaviyoSdk.INSTANCE.displayNotification(remoteMessage, this);
                } else if (queryParameter3 != null) {
                    getNotificationService().showStopAlarmNotification(queryParameter3, remoteMessage.getData().get("title"), remoteMessage.getData().get("body"));
                }
                Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new FirebasePushNotificationService$onMessageReceived$1$2(queryParameter3, this, deeplink, host, queryParameter, queryParameter2, (Continuation<? super FirebasePushNotificationService$onMessageReceived$1$2>) null), 2, (Object) null);
                return;
            }
            return;
        }
        String str3 = remoteMessage.getData().get("user_id");
        if (str3 != null && (str = remoteMessage.getData().get("device_id")) != null && (str2 = remoteMessage.getData().get("template_id")) != null) {
            String str4 = remoteMessage.getData().get(NativeProtocol.WEB_DIALOG_PARAMS);
            if (str4 == null) {
                str4 = "{}";
            }
            getNotificationService().showNotification$push_otherRelease(str3, str, str2, new JSONObject(str4));
        }
    }
}
