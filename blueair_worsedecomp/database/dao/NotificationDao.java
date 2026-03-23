package com.blueair.database.dao;

import com.blueair.database.entity.NotificationEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010R \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/blueair/database/dao/NotificationDao;", "", "flowNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/blueair/database/entity/NotificationEntity;", "getFlowNotifications", "()Lkotlinx/coroutines/flow/Flow;", "insert", "", "entity", "(Lcom/blueair/database/entity/NotificationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "delete", "deviceId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "type", "subType", "time", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissAll", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeDismission", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationDao.kt */
public interface NotificationDao {
    Object delete(NotificationEntity notificationEntity, Continuation<? super Unit> continuation);

    Object delete(String str, Continuation<? super Unit> continuation);

    Object deleteAll(Continuation<? super Unit> continuation);

    Object dismiss(String str, String str2, String str3, long j, Continuation<? super Unit> continuation);

    Object dismissAll(long j, Continuation<? super Unit> continuation);

    Flow<List<NotificationEntity>> getFlowNotifications();

    Object getNotification(String str, String str2, String str3, Continuation<? super NotificationEntity> continuation);

    Object insert(NotificationEntity notificationEntity, Continuation<? super Unit> continuation);

    Object revokeDismission(String str, Continuation<? super Unit> continuation);

    Object update(NotificationEntity notificationEntity, Continuation<? super Unit> continuation);
}
