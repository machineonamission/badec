package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.DayOfWeekConverter;
import com.blueair.database.DeviceScheduleInstructionsConverter;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.database.entity.DeviceScheduleEntity;
import com.blueair.database.entity.DeviceScheduleInstructionEntity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class DeviceScheduleDao_Impl implements DeviceScheduleDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<DeviceScheduleEntity> __insertAdapterOfDeviceScheduleEntity = new EntityInsertAdapter<DeviceScheduleEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `device_schedule_table` (`deviceId`,`scheduleId`,`scheduleName`,`startTime`,`endTime`,`instructions`,`paused`,`daysOfWeek`,`timeZone`,`endInstructions`,`scheduleEndType`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, DeviceScheduleEntity deviceScheduleEntity) {
            if (deviceScheduleEntity.getDeviceId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, deviceScheduleEntity.getDeviceId());
            }
            if (deviceScheduleEntity.getScheduleId() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, deviceScheduleEntity.getScheduleId());
            }
            if (deviceScheduleEntity.getScheduleName() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindText(3, deviceScheduleEntity.getScheduleName());
            }
            if (deviceScheduleEntity.getStartTime() == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindText(4, deviceScheduleEntity.getStartTime());
            }
            if (deviceScheduleEntity.getEndTime() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindText(5, deviceScheduleEntity.getEndTime());
            }
            String listToJson = DeviceScheduleInstructionsConverter.listToJson(deviceScheduleEntity.getInstructions());
            if (listToJson == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindText(6, listToJson);
            }
            sQLiteStatement.bindLong(7, deviceScheduleEntity.getPaused() ? 1 : 0);
            String listToJson2 = DayOfWeekConverter.listToJson(deviceScheduleEntity.getDaysOfWeek());
            if (listToJson2 == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindText(8, listToJson2);
            }
            if (deviceScheduleEntity.getTimeZone() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindText(9, deviceScheduleEntity.getTimeZone());
            }
            String listToJson3 = DeviceScheduleInstructionsConverter.listToJson(deviceScheduleEntity.getEndInstructions());
            if (listToJson3 == null) {
                sQLiteStatement.bindNull(10);
            } else {
                sQLiteStatement.bindText(10, listToJson3);
            }
            if (deviceScheduleEntity.getScheduleEndType() == null) {
                sQLiteStatement.bindNull(11);
            } else {
                sQLiteStatement.bindText(11, deviceScheduleEntity.getScheduleEndType());
            }
        }
    };

    public DeviceScheduleDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public Object insert(List<DeviceScheduleEntity> list, Continuation<? super Unit> continuation) {
        list.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda5(this, list), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$0$com-blueair-database-dao-DeviceScheduleDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8297lambda$insert$0$comblueairdatabasedaoDeviceScheduleDao_Impl(List list, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDeviceScheduleEntity.insert(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    public Object update(DeviceScheduleEntity deviceScheduleEntity, Continuation<? super Unit> continuation) {
        deviceScheduleEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda3(this, deviceScheduleEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$update$1$com-blueair-database-dao-DeviceScheduleDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8298lambda$update$1$comblueairdatabasedaoDeviceScheduleDao_Impl(DeviceScheduleEntity deviceScheduleEntity, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDeviceScheduleEntity.insert(sQLiteConnection, deviceScheduleEntity);
        return Unit.INSTANCE;
    }

    public LiveData<List<DeviceScheduleEntity>> getLiveSchedules() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DeviceScheduleEntity.DEVICE_SCHEDULE_TABLE}, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda7());
    }

    static /* synthetic */ List lambda$getLiveSchedules$2(SQLiteConnection sQLiteConnection) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_schedule_table");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startTime");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, SDKConstants.PARAM_END_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "instructions");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "paused");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "daysOfWeek");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endInstructions");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleEndType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
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
                if (prepare.isNull(columnIndexOrThrow3)) {
                    str3 = null;
                } else {
                    str3 = prepare.getText(columnIndexOrThrow3);
                }
                if (prepare.isNull(columnIndexOrThrow4)) {
                    str4 = null;
                } else {
                    str4 = prepare.getText(columnIndexOrThrow4);
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    str5 = null;
                } else {
                    str5 = prepare.getText(columnIndexOrThrow5);
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    str6 = null;
                } else {
                    str6 = prepare.getText(columnIndexOrThrow6);
                }
                List<DeviceScheduleInstructionEntity> jsonToList = DeviceScheduleInstructionsConverter.jsonToList(str6);
                boolean z = ((int) prepare.getLong(columnIndexOrThrow7)) != 0;
                if (prepare.isNull(columnIndexOrThrow8)) {
                    str7 = null;
                } else {
                    str7 = prepare.getText(columnIndexOrThrow8);
                }
                Set<Integer> jsonToSet = DayOfWeekConverter.jsonToSet(str7);
                if (prepare.isNull(columnIndexOrThrow9)) {
                    str8 = null;
                } else {
                    str8 = prepare.getText(columnIndexOrThrow9);
                }
                if (prepare.isNull(columnIndexOrThrow10)) {
                    str9 = null;
                } else {
                    str9 = prepare.getText(columnIndexOrThrow10);
                }
                List<DeviceScheduleInstructionEntity> jsonToList2 = DeviceScheduleInstructionsConverter.jsonToList(str9);
                if (prepare.isNull(columnIndexOrThrow11)) {
                    str10 = null;
                } else {
                    str10 = prepare.getText(columnIndexOrThrow11);
                }
                arrayList.add(new DeviceScheduleEntity(str, str2, str3, str4, str5, jsonToList, z, jsonToSet, str8, jsonToList2, str10));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public Object getByScheduleId(String str, Continuation<? super DeviceScheduleEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda4(str), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: com.blueair.database.entity.DeviceScheduleEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: com.blueair.database.entity.DeviceScheduleEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: com.blueair.database.entity.DeviceScheduleEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: com.blueair.database.entity.DeviceScheduleEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: com.blueair.database.entity.DeviceScheduleEntity} */
    /* JADX WARNING: type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceScheduleEntity lambda$getByScheduleId$3(java.lang.String r27, androidx.sqlite.SQLiteConnection r28) {
        /*
            r0 = r27
            java.lang.String r1 = "SELECT * from device_schedule_table WHERE scheduleId = ?"
            r2 = r28
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x010a }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x010a }
        L_0x0014:
            java.lang.String r0 = "deviceId"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x010a }
            java.lang.String r3 = "scheduleId"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "scheduleName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x010a }
            java.lang.String r5 = "startTime"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x010a }
            java.lang.String r6 = "endTime"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = "instructions"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x010a }
            java.lang.String r8 = "paused"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x010a }
            java.lang.String r9 = "daysOfWeek"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x010a }
            java.lang.String r10 = "timeZone"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x010a }
            java.lang.String r11 = "endInstructions"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x010a }
            java.lang.String r12 = "scheduleEndType"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x010a }
            boolean r13 = r1.step()     // Catch:{ all -> 0x010a }
            r14 = 0
            if (r13 == 0) goto L_0x0106
            boolean r13 = r1.isNull(r0)     // Catch:{ all -> 0x010a }
            if (r13 == 0) goto L_0x0066
            r16 = r14
            goto L_0x006c
        L_0x0066:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x010a }
            r16 = r0
        L_0x006c:
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x0075
            r17 = r14
            goto L_0x007b
        L_0x0075:
            java.lang.String r0 = r1.getText(r3)     // Catch:{ all -> 0x010a }
            r17 = r0
        L_0x007b:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x0084
            r18 = r14
            goto L_0x008a
        L_0x0084:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x010a }
            r18 = r0
        L_0x008a:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x0093
            r19 = r14
            goto L_0x0099
        L_0x0093:
            java.lang.String r0 = r1.getText(r5)     // Catch:{ all -> 0x010a }
            r19 = r0
        L_0x0099:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00a2
            r20 = r14
            goto L_0x00a8
        L_0x00a2:
            java.lang.String r0 = r1.getText(r6)     // Catch:{ all -> 0x010a }
            r20 = r0
        L_0x00a8:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00b0
            r0 = r14
            goto L_0x00b4
        L_0x00b0:
            java.lang.String r0 = r1.getText(r7)     // Catch:{ all -> 0x010a }
        L_0x00b4:
            java.util.List r21 = com.blueair.database.DeviceScheduleInstructionsConverter.jsonToList(r0)     // Catch:{ all -> 0x010a }
            long r3 = r1.getLong(r8)     // Catch:{ all -> 0x010a }
            int r0 = (int) r3     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r2 = 0
        L_0x00c1:
            r22 = r2
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00cb
            r0 = r14
            goto L_0x00cf
        L_0x00cb:
            java.lang.String r0 = r1.getText(r9)     // Catch:{ all -> 0x010a }
        L_0x00cf:
            java.util.Set r23 = com.blueair.database.DayOfWeekConverter.jsonToSet(r0)     // Catch:{ all -> 0x010a }
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00dc
            r24 = r14
            goto L_0x00e2
        L_0x00dc:
            java.lang.String r0 = r1.getText(r10)     // Catch:{ all -> 0x010a }
            r24 = r0
        L_0x00e2:
            boolean r0 = r1.isNull(r11)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00ea
            r0 = r14
            goto L_0x00ee
        L_0x00ea:
            java.lang.String r0 = r1.getText(r11)     // Catch:{ all -> 0x010a }
        L_0x00ee:
            java.util.List r25 = com.blueair.database.DeviceScheduleInstructionsConverter.jsonToList(r0)     // Catch:{ all -> 0x010a }
            boolean r0 = r1.isNull(r12)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x00fb
        L_0x00f8:
            r26 = r14
            goto L_0x0100
        L_0x00fb:
            java.lang.String r14 = r1.getText(r12)     // Catch:{ all -> 0x010a }
            goto L_0x00f8
        L_0x0100:
            com.blueair.database.entity.DeviceScheduleEntity r15 = new com.blueair.database.entity.DeviceScheduleEntity     // Catch:{ all -> 0x010a }
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x010a }
            r14 = r15
        L_0x0106:
            r1.close()
            return r14
        L_0x010a:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceScheduleDao_Impl.lambda$getByScheduleId$3(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceScheduleEntity");
    }

    public Object getByDeviceId(String str, Continuation<? super List<DeviceScheduleEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda1(str), continuation);
    }

    static /* synthetic */ List lambda$getByDeviceId$4(String str, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * FROM device_schedule_table WHERE deviceId = ?");
        if (str11 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str11);
        }
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleId");
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleName");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startTime");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, SDKConstants.PARAM_END_TIME);
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "instructions");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "paused");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "daysOfWeek");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endInstructions");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleEndType");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            String str12 = null;
            if (prepare.isNull(columnIndexOrThrow)) {
                str2 = null;
            } else {
                str2 = prepare.getText(columnIndexOrThrow);
            }
            if (prepare.isNull(columnIndexOrThrow2)) {
                str3 = null;
            } else {
                str3 = prepare.getText(columnIndexOrThrow2);
            }
            if (prepare.isNull(columnIndexOrThrow3)) {
                str4 = null;
            } else {
                str4 = prepare.getText(columnIndexOrThrow3);
            }
            if (prepare.isNull(columnIndexOrThrow4)) {
                str5 = null;
            } else {
                str5 = prepare.getText(columnIndexOrThrow4);
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                str6 = null;
            } else {
                str6 = prepare.getText(columnIndexOrThrow5);
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                str7 = null;
            } else {
                str7 = prepare.getText(columnIndexOrThrow6);
            }
            List<DeviceScheduleInstructionEntity> jsonToList = DeviceScheduleInstructionsConverter.jsonToList(str7);
            int i = columnIndexOrThrow2;
            boolean z = ((int) prepare.getLong(columnIndexOrThrow7)) != 0;
            if (prepare.isNull(columnIndexOrThrow8)) {
                str8 = null;
            } else {
                str8 = prepare.getText(columnIndexOrThrow8);
            }
            Set<Integer> jsonToSet = DayOfWeekConverter.jsonToSet(str8);
            if (prepare.isNull(columnIndexOrThrow9)) {
                str9 = null;
            } else {
                str9 = prepare.getText(columnIndexOrThrow9);
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                str10 = null;
            } else {
                str10 = prepare.getText(columnIndexOrThrow10);
            }
            List<DeviceScheduleInstructionEntity> jsonToList2 = DeviceScheduleInstructionsConverter.jsonToList(str10);
            if (!prepare.isNull(columnIndexOrThrow11)) {
                str12 = prepare.getText(columnIndexOrThrow11);
            }
            arrayList.add(new DeviceScheduleEntity(str2, str3, str4, str5, str6, jsonToList, z, jsonToSet, str9, jsonToList2, str12));
            columnIndexOrThrow2 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Object getAll(Continuation<? super List<DeviceScheduleEntity>> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda2(), continuation);
    }

    static /* synthetic */ List lambda$getAll$5(SQLiteConnection sQLiteConnection) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_schedule_table");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleId");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleName");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "startTime");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, SDKConstants.PARAM_END_TIME);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "instructions");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "paused");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "daysOfWeek");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "endInstructions");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "scheduleEndType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
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
                if (prepare.isNull(columnIndexOrThrow3)) {
                    str3 = null;
                } else {
                    str3 = prepare.getText(columnIndexOrThrow3);
                }
                if (prepare.isNull(columnIndexOrThrow4)) {
                    str4 = null;
                } else {
                    str4 = prepare.getText(columnIndexOrThrow4);
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    str5 = null;
                } else {
                    str5 = prepare.getText(columnIndexOrThrow5);
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    str6 = null;
                } else {
                    str6 = prepare.getText(columnIndexOrThrow6);
                }
                List<DeviceScheduleInstructionEntity> jsonToList = DeviceScheduleInstructionsConverter.jsonToList(str6);
                boolean z = ((int) prepare.getLong(columnIndexOrThrow7)) != 0;
                if (prepare.isNull(columnIndexOrThrow8)) {
                    str7 = null;
                } else {
                    str7 = prepare.getText(columnIndexOrThrow8);
                }
                Set<Integer> jsonToSet = DayOfWeekConverter.jsonToSet(str7);
                if (prepare.isNull(columnIndexOrThrow9)) {
                    str8 = null;
                } else {
                    str8 = prepare.getText(columnIndexOrThrow9);
                }
                if (prepare.isNull(columnIndexOrThrow10)) {
                    str9 = null;
                } else {
                    str9 = prepare.getText(columnIndexOrThrow10);
                }
                List<DeviceScheduleInstructionEntity> jsonToList2 = DeviceScheduleInstructionsConverter.jsonToList(str9);
                if (prepare.isNull(columnIndexOrThrow11)) {
                    str10 = null;
                } else {
                    str10 = prepare.getText(columnIndexOrThrow11);
                }
                arrayList.add(new DeviceScheduleEntity(str, str2, str3, str4, str5, jsonToList, z, jsonToSet, str8, jsonToList2, str10));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public Object delete(String str, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda0(str), continuation);
    }

    static /* synthetic */ Integer lambda$delete$6(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_schedule_table WHERE scheduleId = ?");
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
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public Object deleteAllForDevice(String str, Continuation<? super Integer> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda6(str), continuation);
    }

    static /* synthetic */ Integer lambda$deleteAllForDevice$7(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_schedule_table WHERE deviceId = ?");
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
        Integer valueOf = Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        prepare.close();
        return valueOf;
    }

    public int deleteAll() {
        return ((Integer) DBUtil.performBlocking(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda8())).intValue();
    }

    static /* synthetic */ Integer lambda$deleteAll$8(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_schedule_table");
        try {
            prepare.step();
            return Integer.valueOf(SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection));
        } finally {
            prepare.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }
}
