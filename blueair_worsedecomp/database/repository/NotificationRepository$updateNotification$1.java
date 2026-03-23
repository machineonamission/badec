package com.blueair.database.repository;

import com.blueair.database.entity.NotificationEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.NotificationRepository", f = "NotificationRepository.kt", i = {0, 0}, l = {68}, m = "updateNotification", n = {"entity", "$i$a$-runCatching-NotificationRepository$updateNotification$2"}, s = {"L$0", "I$0"})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$updateNotification$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$updateNotification$1(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$updateNotification$1> continuation) {
        super(continuation);
        this.this$0 = notificationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateNotification((NotificationEntity) null, this);
    }
}
