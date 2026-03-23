package com.blueair.database.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.database.entity.NotificationEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

public final class NotificationDao_Impl implements NotificationDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<NotificationEntity> __deleteAdapterOfNotificationEntity = new EntityDeleteOrUpdateAdapter<NotificationEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "DELETE FROM `notification_table` WHERE `deviceId` = ? AND `type` = ? AND `subType` = ?";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, NotificationEntity notificationEntity) {
            if (notificationEntity.getDeviceId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, notificationEntity.getDeviceId());
            }
            if (notificationEntity.getType() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, notificationEntity.getType());
            }
            if (notificationEntity.getSubType() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, notificationEntity.getSubType());
            }
        }
    };
    private final EntityInsertAdapter<NotificationEntity> __insertAdapterOfNotificationEntity = new EntityInsertAdapter<NotificationEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `notification_table` (`deviceId`,`type`,`subType`,`subLevel`,`dismissed`,`dismissTime`,`datetime`) VALUES (?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, NotificationEntity notificationEntity) {
            if (notificationEntity.getDeviceId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, notificationEntity.getDeviceId());
            }
            if (notificationEntity.getType() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, notificationEntity.getType());
            }
            if (notificationEntity.getSubType() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, notificationEntity.getSubType());
            }
            sQLiteStatement.bindLong(4, (long) notificationEntity.getSubLevel());
            sQLiteStatement.bindLong(5, notificationEntity.getDismissed() ? 1 : 0);
            sQLiteStatement.bindLong(6, notificationEntity.getDismissTime());
            sQLiteStatement.bindLong(7, notificationEntity.getDatetime());
        }
    };
    private final EntityDeleteOrUpdateAdapter<NotificationEntity> __updateAdapterOfNotificationEntity = new EntityDeleteOrUpdateAdapter<NotificationEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "UPDATE OR ABORT `notification_table` SET `deviceId` = ?,`type` = ?,`subType` = ?,`subLevel` = ?,`dismissed` = ?,`dismissTime` = ?,`datetime` = ? WHERE `deviceId` = ? AND `type` = ? AND `subType` = ?";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, NotificationEntity notificationEntity) {
            if (notificationEntity.getDeviceId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, notificationEntity.getDeviceId());
            }
            if (notificationEntity.getType() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, notificationEntity.getType());
            }
            if (notificationEntity.getSubType() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, notificationEntity.getSubType());
            }
            sQLiteStatement.bindLong(4, (long) notificationEntity.getSubLevel());
            sQLiteStatement.bindLong(5, notificationEntity.getDismissed() ? 1 : 0);
            sQLiteStatement.bindLong(6, notificationEntity.getDismissTime());
            sQLiteStatement.bindLong(7, notificationEntity.getDatetime());
            if (notificationEntity.getDeviceId() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindText(8, notificationEntity.getDeviceId());
            }
            if (notificationEntity.getType() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindText(9, notificationEntity.getType());
            }
            if (notificationEntity.getSubType() == null) {
                sQLiteStatement.bindNull(10);
            } else {
                sQLiteStatement.bindText(10, notificationEntity.getSubType());
            }
        }
    };

    public NotificationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public Object insert(NotificationEntity notificationEntity, Continuation<? super Unit> continuation) {
        notificationEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda5(this, notificationEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$0$com-blueair-database-dao-NotificationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8300lambda$insert$0$comblueairdatabasedaoNotificationDao_Impl(NotificationEntity notificationEntity, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfNotificationEntity.insert(sQLiteConnection, notificationEntity);
        return Unit.INSTANCE;
    }

    public Object delete(NotificationEntity notificationEntity, Continuation<? super Unit> continuation) {
        notificationEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda8(this, notificationEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$delete$1$com-blueair-database-dao-NotificationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8299lambda$delete$1$comblueairdatabasedaoNotificationDao_Impl(NotificationEntity notificationEntity, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfNotificationEntity.handle(sQLiteConnection, notificationEntity);
        return Unit.INSTANCE;
    }

    public Object update(NotificationEntity notificationEntity, Continuation<? super Unit> continuation) {
        notificationEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda3(this, notificationEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$update$2$com-blueair-database-dao-NotificationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8301lambda$update$2$comblueairdatabasedaoNotificationDao_Impl(NotificationEntity notificationEntity, SQLiteConnection sQLiteConnection) {
        this.__updateAdapterOfNotificationEntity.handle(sQLiteConnection, notificationEntity);
        return Unit.INSTANCE;
    }

    public Flow<List<NotificationEntity>> getFlowNotifications() {
        return FlowUtil.createFlow(this.__db, false, new String[]{NotificationEntity.NOTIFICATION_TABLE}, new NotificationDao_Impl$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ List lambda$getFlowNotifications$3(SQLiteConnection sQLiteConnection) {
        String str;
        String str2;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from notification_table where dismissed = 0 ORDER BY CASE WHEN type = 'FILTER_LIFE' AND subLevel = 0 THEN 0 WHEN type = 'AQI' THEN 1 ELSE 2 END ASC, datetime DESC");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "type");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "subType");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "subLevel");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "dismissed");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "dismissTime");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "datetime");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String str3 = null;
                if (prepare.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = prepare.getText(columnIndexOrThrow);
                }
                if (prepare.isNull(columnIndexOrThrow2)) {
                    str2 = null;
                } else {
                    str2 = prepare.getText(columnIndexOrThrow2);
                }
                if (!prepare.isNull(columnIndexOrThrow3)) {
                    str3 = prepare.getText(columnIndexOrThrow3);
                }
                arrayList.add(new NotificationEntity(str, str2, str3, (int) prepare.getLong(columnIndexOrThrow4), ((int) prepare.getLong(columnIndexOrThrow5)) != 0, prepare.getLong(columnIndexOrThrow6), prepare.getLong(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public Object getNotification(String str, String str2, String str3, Continuation<? super NotificationEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new NotificationDao_Impl$$ExternalSyntheticLambda1(str, str2, str3), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: com.blueair.database.entity.NotificationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: com.blueair.database.entity.NotificationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: com.blueair.database.entity.NotificationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: com.blueair.database.entity.NotificationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: com.blueair.database.entity.NotificationEntity} */
    /* JADX WARNING: type inference failed for: r10v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.NotificationEntity lambda$getNotification$4(java.lang.String r21, java.lang.String r22, java.lang.String r23, androidx.sqlite.SQLiteConnection r24) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.String r3 = "SELECT * from notification_table WHERE deviceId = ? and type = ? and subType = ?"
            r4 = r24
            androidx.sqlite.SQLiteStatement r3 = r4.prepare(r3)
            r4 = 1
            if (r0 != 0) goto L_0x0015
            r3.bindNull(r4)     // Catch:{ all -> 0x00a6 }
            goto L_0x0018
        L_0x0015:
            r3.bindText(r4, r0)     // Catch:{ all -> 0x00a6 }
        L_0x0018:
            r0 = 2
            if (r1 != 0) goto L_0x001f
            r3.bindNull(r0)     // Catch:{ all -> 0x00a6 }
            goto L_0x0022
        L_0x001f:
            r3.bindText(r0, r1)     // Catch:{ all -> 0x00a6 }
        L_0x0022:
            r0 = 3
            if (r2 != 0) goto L_0x0029
            r3.bindNull(r0)     // Catch:{ all -> 0x00a6 }
            goto L_0x002c
        L_0x0029:
            r3.bindText(r0, r2)     // Catch:{ all -> 0x00a6 }
        L_0x002c:
            java.lang.String r0 = "deviceId"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = "type"
            int r1 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r1)     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "subType"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r2)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = "subLevel"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = "dismissed"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r6)     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = "dismissTime"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r7)     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "datetime"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r3, r8)     // Catch:{ all -> 0x00a6 }
            boolean r9 = r3.step()     // Catch:{ all -> 0x00a6 }
            r10 = 0
            if (r9 == 0) goto L_0x00a2
            boolean r9 = r3.isNull(r0)     // Catch:{ all -> 0x00a6 }
            if (r9 == 0) goto L_0x0065
            r12 = r10
            goto L_0x006a
        L_0x0065:
            java.lang.String r0 = r3.getText(r0)     // Catch:{ all -> 0x00a6 }
            r12 = r0
        L_0x006a:
            boolean r0 = r3.isNull(r1)     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0072
            r13 = r10
            goto L_0x0077
        L_0x0072:
            java.lang.String r0 = r3.getText(r1)     // Catch:{ all -> 0x00a6 }
            r13 = r0
        L_0x0077:
            boolean r0 = r3.isNull(r2)     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x007f
        L_0x007d:
            r14 = r10
            goto L_0x0084
        L_0x007f:
            java.lang.String r10 = r3.getText(r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x007d
        L_0x0084:
            long r0 = r3.getLong(r5)     // Catch:{ all -> 0x00a6 }
            int r15 = (int) r0     // Catch:{ all -> 0x00a6 }
            long r0 = r3.getLong(r6)     // Catch:{ all -> 0x00a6 }
            int r0 = (int) r0     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r4 = 0
        L_0x0092:
            r16 = r4
            long r17 = r3.getLong(r7)     // Catch:{ all -> 0x00a6 }
            long r19 = r3.getLong(r8)     // Catch:{ all -> 0x00a6 }
            com.blueair.database.entity.NotificationEntity r11 = new com.blueair.database.entity.NotificationEntity     // Catch:{ all -> 0x00a6 }
            r11.<init>(r12, r13, r14, r15, r16, r17, r19)     // Catch:{ all -> 0x00a6 }
            r10 = r11
        L_0x00a2:
            r3.close()
            return r10
        L_0x00a6:
            r0 = move-exception
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.NotificationDao_Impl.lambda$getNotification$4(java.lang.String, java.lang.String, java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.NotificationEntity");
    }

    public Object delete(String str, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda7(str), continuation);
    }

    static /* synthetic */ Unit lambda$delete$5(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM notification_table WHERE deviceId = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        prepare.step();
        Unit unit = Unit.INSTANCE;
        prepare.close();
        return unit;
    }

    public Object deleteAll(Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda0(), continuation);
    }

    static /* synthetic */ Unit lambda$deleteAll$6(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM notification_table");
        try {
            prepare.step();
            return Unit.INSTANCE;
        } finally {
            prepare.close();
        }
    }

    public Object dismiss(String str, String str2, String str3, long j, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda6(j, str, str2, str3), continuation);
    }

    static /* synthetic */ Unit lambda$dismiss$7(long j, String str, String str2, String str3, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE notification_table SET dismissed = 1, dismissTime = ? WHERE deviceId = ?  and type = ? and subType = ?");
        try {
            prepare.bindLong(1, j);
            if (str == null) {
                prepare.bindNull(2);
            } else {
                prepare.bindText(2, str);
            }
            if (str2 == null) {
                prepare.bindNull(3);
            } else {
                prepare.bindText(3, str2);
            }
            if (str3 == null) {
                prepare.bindNull(4);
            } else {
                prepare.bindText(4, str3);
            }
            prepare.step();
            return Unit.INSTANCE;
        } finally {
            prepare.close();
        }
    }

    public Object dismissAll(long j, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda9(j), continuation);
    }

    static /* synthetic */ Unit lambda$dismissAll$8(long j, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE notification_table SET dismissed = 1, dismissTime = ?");
        try {
            prepare.bindLong(1, j);
            prepare.step();
            return Unit.INSTANCE;
        } finally {
            prepare.close();
        }
    }

    public Object revokeDismission(String str, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda2(str), continuation);
    }

    static /* synthetic */ Unit lambda$revokeDismission$9(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("UPDATE notification_table SET dismissed = 0, dismissTime = 0 WHERE type = ?");
        if (str == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str);
        }
        prepare.step();
        Unit unit = Unit.INSTANCE;
        prepare.close();
        return unit;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }
}
