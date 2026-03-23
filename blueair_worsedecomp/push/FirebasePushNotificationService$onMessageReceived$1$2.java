package com.blueair.push;

import android.net.Uri;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicemanager.DeviceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.push.FirebasePushNotificationService$onMessageReceived$1$2", f = "FirebasePushNotificationService.kt", i = {0, 0}, l = {53}, m = "invokeSuspend", n = {"it", "$i$a$-let-FirebasePushNotificationService$onMessageReceived$1$2$device$1"}, s = {"L$0", "I$0"})
/* compiled from: FirebasePushNotificationService.kt */
final class FirebasePushNotificationService$onMessageReceived$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $action;
    final /* synthetic */ Uri $deeplink;
    final /* synthetic */ String $did;
    final /* synthetic */ String $path;
    final /* synthetic */ String $type;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ FirebasePushNotificationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirebasePushNotificationService$onMessageReceived$1$2(String str, FirebasePushNotificationService firebasePushNotificationService, Uri uri, String str2, String str3, String str4, Continuation<? super FirebasePushNotificationService$onMessageReceived$1$2> continuation) {
        super(2, continuation);
        this.$did = str;
        this.this$0 = firebasePushNotificationService;
        this.$deeplink = uri;
        this.$path = str2;
        this.$type = str3;
        this.$action = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FirebasePushNotificationService$onMessageReceived$1$2(this.$did, this.this$0, this.$deeplink, this.$path, this.$type, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FirebasePushNotificationService$onMessageReceived$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Device device;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$did;
            if (str != null) {
                DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.I$0 = 0;
                this.label = 1;
                obj = access$getDeviceManager.getDatabaseDevice(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                device = null;
                Device device2 = device;
                AnalyticsService access$getAnalyticsService = this.this$0.getAnalyticsService();
                String uri = this.$deeplink.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                access$getAnalyticsService.event(new AnalyticEvent.KlaviyoEvent.Receive(uri, this.$path, this.$type, this.$action, device2));
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            String str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        device = (Device) obj;
        Device device22 = device;
        AnalyticsService access$getAnalyticsService2 = this.this$0.getAnalyticsService();
        String uri2 = this.$deeplink.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        access$getAnalyticsService2.event(new AnalyticEvent.KlaviyoEvent.Receive(uri2, this.$path, this.$type, this.$action, device22));
        return Unit.INSTANCE;
    }
}
