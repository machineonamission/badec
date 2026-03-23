package com.blueair.database.repository;

import com.blueair.core.model.NotificationMessage;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.entity.NotificationEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0019\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u001fJ\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/blueair/database/repository/NotificationRepository;", "", "blueairDb", "Lcom/blueair/database/BlueairDatabase;", "deviceRepository", "Lcom/blueair/database/repository/DeviceRepository;", "<init>", "(Lcom/blueair/database/BlueairDatabase;Lcom/blueair/database/repository/DeviceRepository;)V", "flowNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/blueair/core/model/NotificationMessage;", "getFlowNotifications", "()Lkotlinx/coroutines/flow/Flow;", "flowNotifications$delegate", "Lkotlin/Lazy;", "getNotification", "Lcom/blueair/database/entity/NotificationEntity;", "deviceId", "", "type", "subType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "", "dismissAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "deleteNotification", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entity", "(Lcom/blueair/database/entity/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotification", "insertNotification", "revokeDismission", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationRepository.kt */
public final class NotificationRepository {
    private final BlueairDatabase blueairDb;
    /* access modifiers changed from: private */
    public final DeviceRepository deviceRepository;
    private final Lazy flowNotifications$delegate = LazyKt.lazy(new NotificationRepository$$ExternalSyntheticLambda0(this));

    public NotificationRepository(BlueairDatabase blueairDatabase, DeviceRepository deviceRepository2) {
        Intrinsics.checkNotNullParameter(blueairDatabase, "blueairDb");
        Intrinsics.checkNotNullParameter(deviceRepository2, "deviceRepository");
        this.blueairDb = blueairDatabase;
        this.deviceRepository = deviceRepository2;
    }

    public final Flow<List<NotificationMessage>> getFlowNotifications() {
        return (Flow) this.flowNotifications$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Flow flowNotifications_delegate$lambda$2(NotificationRepository notificationRepository) {
        return new NotificationRepository$flowNotifications_delegate$lambda$2$$inlined$map$1(notificationRepository.blueairDb.notificationDao().getFlowNotifications(), notificationRepository);
    }

    public final Object getNotification(String str, String str2, String str3, Continuation<? super NotificationEntity> continuation) {
        return this.blueairDb.notificationDao().getNotification(str, str2, str3, continuation);
    }

    public final Object dismiss(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object dismiss = this.blueairDb.notificationDao().dismiss(str, str2, str3, System.currentTimeMillis(), continuation);
        return dismiss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dismiss : Unit.INSTANCE;
    }

    public final Object dismissAll(Continuation<? super Unit> continuation) {
        Object dismissAll = this.blueairDb.notificationDao().dismissAll(System.currentTimeMillis(), continuation);
        return dismissAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dismissAll : Unit.INSTANCE;
    }

    public final Object deleteAll(Continuation<? super Unit> continuation) {
        Object deleteAll = this.blueairDb.notificationDao().deleteAll(continuation);
        return deleteAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? deleteAll : Unit.INSTANCE;
    }

    public final Object deleteNotification(String str, Continuation<? super Unit> continuation) {
        Object delete = this.blueairDb.notificationDao().delete(str, continuation);
        return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
    }

    public final Object deleteNotification(NotificationEntity notificationEntity, Continuation<? super Unit> continuation) {
        Object delete = this.blueairDb.notificationDao().delete(notificationEntity, continuation);
        return delete == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delete : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateNotification(com.blueair.database.entity.NotificationEntity r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.NotificationRepository$updateNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.NotificationRepository$updateNotification$1 r0 = (com.blueair.database.repository.NotificationRepository$updateNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.NotificationRepository$updateNotification$1 r0 = new com.blueair.database.repository.NotificationRepository$updateNotification$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$0
            com.blueair.database.entity.NotificationEntity r5 = (com.blueair.database.entity.NotificationEntity) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x005b }
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            com.blueair.database.BlueairDatabase r6 = r4.blueairDb     // Catch:{ all -> 0x005b }
            com.blueair.database.dao.NotificationDao r6 = r6.notificationDao()     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ all -> 0x005b }
            r0.L$0 = r2     // Catch:{ all -> 0x005b }
            r2 = 0
            r0.I$0 = r2     // Catch:{ all -> 0x005b }
            r0.label = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r5 = r6.update(r5, r0)     // Catch:{ all -> 0x005b }
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            kotlin.Result.m9366constructorimpl(r5)     // Catch:{ all -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            kotlin.Result.m9366constructorimpl(r5)
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.NotificationRepository.updateNotification(com.blueair.database.entity.NotificationEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object insertNotification(com.blueair.database.entity.NotificationEntity r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.NotificationRepository$insertNotification$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.NotificationRepository$insertNotification$1 r0 = (com.blueair.database.repository.NotificationRepository$insertNotification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.NotificationRepository$insertNotification$1 r0 = new com.blueair.database.repository.NotificationRepository$insertNotification$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$0
            com.blueair.database.entity.NotificationEntity r5 = (com.blueair.database.entity.NotificationEntity) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x005b }
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            com.blueair.database.BlueairDatabase r6 = r4.blueairDb     // Catch:{ all -> 0x005b }
            com.blueair.database.dao.NotificationDao r6 = r6.notificationDao()     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ all -> 0x005b }
            r0.L$0 = r2     // Catch:{ all -> 0x005b }
            r2 = 0
            r0.I$0 = r2     // Catch:{ all -> 0x005b }
            r0.label = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r5 = r6.insert(r5, r0)     // Catch:{ all -> 0x005b }
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            kotlin.Result.m9366constructorimpl(r5)     // Catch:{ all -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            kotlin.Result.m9366constructorimpl(r5)
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.NotificationRepository.insertNotification(com.blueair.database.entity.NotificationEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object revokeDismission(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.blueair.database.repository.NotificationRepository$revokeDismission$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.database.repository.NotificationRepository$revokeDismission$1 r0 = (com.blueair.database.repository.NotificationRepository$revokeDismission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.database.repository.NotificationRepository$revokeDismission$1 r0 = new com.blueair.database.repository.NotificationRepository$revokeDismission$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x005b }
            goto L_0x0055
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            com.blueair.database.BlueairDatabase r6 = r4.blueairDb     // Catch:{ all -> 0x005b }
            com.blueair.database.dao.NotificationDao r6 = r6.notificationDao()     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch:{ all -> 0x005b }
            r0.L$0 = r2     // Catch:{ all -> 0x005b }
            r2 = 0
            r0.I$0 = r2     // Catch:{ all -> 0x005b }
            r0.label = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r5 = r6.revokeDismission(r5, r0)     // Catch:{ all -> 0x005b }
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            kotlin.Result.m9366constructorimpl(r5)     // Catch:{ all -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            kotlin.Result.m9366constructorimpl(r5)
        L_0x0065:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.repository.NotificationRepository.revokeDismission(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
