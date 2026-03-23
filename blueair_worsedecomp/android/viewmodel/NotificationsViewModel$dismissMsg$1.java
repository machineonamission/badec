package com.blueair.android.viewmodel;

import com.blueair.android.adapter.NotificationItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.NotificationsViewModel$dismissMsg$1", f = "NotificationsViewModel.kt", i = {}, l = {293, 295}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationsViewModel.kt */
final class NotificationsViewModel$dismissMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotificationItem $item;
    final /* synthetic */ boolean $withDelay;
    int label;
    final /* synthetic */ NotificationsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationsViewModel$dismissMsg$1(boolean z, NotificationsViewModel notificationsViewModel, NotificationItem notificationItem, Continuation<? super NotificationsViewModel$dismissMsg$1> continuation) {
        super(2, continuation);
        this.$withDelay = z;
        this.this$0 = notificationsViewModel;
        this.$item = notificationItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationsViewModel$dismissMsg$1(this.$withDelay, this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NotificationsViewModel$dismissMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (kotlinx.coroutines.DelayKt.delay(300, r5) == r0) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r5.this$0.getDeviceManager().dismissNotificationMsg(r5.$item.getMessage(), r5) == r0) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0033
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.$withDelay
            if (r6 == 0) goto L_0x0033
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r3
            r3 = 300(0x12c, double:1.48E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L_0x0033
            goto L_0x004a
        L_0x0033:
            com.blueair.android.viewmodel.NotificationsViewModel r6 = r5.this$0
            com.blueair.devicemanager.DeviceManager r6 = r6.getDeviceManager()
            com.blueair.android.adapter.NotificationItem r1 = r5.$item
            com.blueair.core.model.NotificationMessage r1 = r1.getMessage()
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r6 = r6.dismissNotificationMsg(r1, r3)
            if (r6 != r0) goto L_0x004b
        L_0x004a:
            return r0
        L_0x004b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.NotificationsViewModel$dismissMsg$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
