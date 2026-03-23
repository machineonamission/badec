package com.blueair.database.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.NotificationRepository", f = "NotificationRepository.kt", i = {0, 0}, l = {80}, m = "revokeDismission", n = {"type", "$i$a$-runCatching-NotificationRepository$revokeDismission$2"}, s = {"L$0", "I$0"})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$revokeDismission$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$revokeDismission$1(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$revokeDismission$1> continuation) {
        super(continuation);
        this.this$0 = notificationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.revokeDismission((String) null, this);
    }
}
