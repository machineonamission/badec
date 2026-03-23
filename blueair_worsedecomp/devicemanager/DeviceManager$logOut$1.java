package com.blueair.devicemanager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$logOut$1", f = "DeviceManager.kt", i = {}, l = {558}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$logOut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$logOut$1(DeviceManager deviceManager, Continuation<? super DeviceManager$logOut$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$logOut$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$logOut$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a2, code lost:
        timber.log.Timber.Forest.e(r6, "logOut: background thread logOut failed", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0010 }
            goto L_0x003e
        L_0x0010:
            r6 = move-exception
            goto L_0x00a2
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r6)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = "logOut: background thread started"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0010 }
            r6.v(r1, r4)     // Catch:{ all -> 0x0010 }
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0     // Catch:{ all -> 0x0010 }
            r6.clearDb()     // Catch:{ all -> 0x0010 }
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0     // Catch:{ all -> 0x0010 }
            com.blueair.livestream.StreamService r6 = r6.streamService     // Catch:{ all -> 0x0010 }
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ all -> 0x0010 }
            r5.label = r3     // Catch:{ all -> 0x0010 }
            java.lang.Object r6 = r6.clear(r1)     // Catch:{ all -> 0x0010 }
            if (r6 != r0) goto L_0x003e
            return r0
        L_0x003e:
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0     // Catch:{ all -> 0x0010 }
            java.lang.Object r6 = r6.connectionLock     // Catch:{ all -> 0x0010 }
            com.blueair.devicemanager.DeviceManager r0 = r5.this$0     // Catch:{ all -> 0x0010 }
            monitor-enter(r6)     // Catch:{ all -> 0x0010 }
            java.util.List r1 = r0.connections     // Catch:{ all -> 0x009f }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x009f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x009f }
        L_0x0051:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0061
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x009f }
            com.blueair.api.ConnectionManager r4 = (com.blueair.api.ConnectionManager) r4     // Catch:{ all -> 0x009f }
            r4.clear()     // Catch:{ all -> 0x009f }
            goto L_0x0051
        L_0x0061:
            java.util.List r0 = r0.connections     // Catch:{ all -> 0x009f }
            r0.clear()     // Catch:{ all -> 0x009f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009f }
            monitor-exit(r6)     // Catch:{ all -> 0x0010 }
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0     // Catch:{ all -> 0x0010 }
            java.util.Map r6 = r6.ablDevicesMockedOtaProgressJobs     // Catch:{ all -> 0x0010 }
            java.util.Collection r6 = r6.values()     // Catch:{ all -> 0x0010 }
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch:{ all -> 0x0010 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0010 }
        L_0x007b:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x008c
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x0010 }
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0     // Catch:{ all -> 0x0010 }
            r1 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r1, (int) r3, (java.lang.Object) r1)     // Catch:{ all -> 0x0010 }
            goto L_0x007b
        L_0x008c:
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0     // Catch:{ all -> 0x0010 }
            java.util.Map r6 = r6.ablDevicesMockedOtaProgressJobs     // Catch:{ all -> 0x0010 }
            r6.clear()     // Catch:{ all -> 0x0010 }
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = "logOut: background thread completed"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0010 }
            r6.v(r0, r1)     // Catch:{ all -> 0x0010 }
            goto L_0x00ab
        L_0x009f:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0010 }
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x00a2:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.String r1 = "logOut: background thread logOut failed"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.e(r6, r1, r2)
        L_0x00ab:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceManager$logOut$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
