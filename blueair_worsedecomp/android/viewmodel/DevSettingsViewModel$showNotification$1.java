package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.DevSettingsViewModel$showNotification$1", f = "DevSettingsViewModel.kt", i = {}, l = {326, 328}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DevSettingsViewModel.kt */
final class DevSettingsViewModel$showNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DevSettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DevSettingsViewModel$showNotification$1(DevSettingsViewModel devSettingsViewModel, Continuation<? super DevSettingsViewModel$showNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = devSettingsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevSettingsViewModel$showNotification$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevSettingsViewModel$showNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (kotlinx.coroutines.DelayKt.delay(com.mapbox.maps.plugin.locationcomponent.LocationComponentConstants.MAX_ANIMATION_DURATION_MS, r5) == r0) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r5.L$0
            com.blueair.push.NotificationService r0 = (com.blueair.push.NotificationService) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x0016:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0033
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r3
            r3 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x0033
            goto L_0x004c
        L_0x0033:
            com.blueair.android.viewmodel.DevSettingsViewModel r6 = r5.this$0
            com.blueair.push.NotificationService r6 = r6.getNotificationService()
            com.blueair.android.viewmodel.DevSettingsViewModel r1 = r5.this$0
            com.blueair.devicemanager.DeviceManager r1 = r1.getDeviceManager()
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.L$0 = r6
            r5.label = r2
            java.lang.Object r1 = r1.getBlueDevices(r3)
            if (r1 != r0) goto L_0x004d
        L_0x004c:
            return r0
        L_0x004d:
            r0 = r6
            r6 = r1
        L_0x004f:
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r6)
            com.blueair.core.model.HasBlueCloudFunctions r6 = (com.blueair.core.model.HasBlueCloudFunctions) r6
            if (r6 == 0) goto L_0x005f
            java.lang.String r6 = r6.getUid()
            if (r6 != 0) goto L_0x0061
        L_0x005f:
            java.lang.String r6 = ""
        L_0x0061:
            java.lang.String r1 = "Click to open filter page"
            java.lang.String r2 = "filter"
            java.lang.String r3 = "Test Notification"
            r0.showNotification(r6, r3, r1, r2)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.DevSettingsViewModel$showNotification$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
