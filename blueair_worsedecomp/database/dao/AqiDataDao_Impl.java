package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.AqiDataEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class AqiDataDao_Impl implements AqiDataDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<AqiDataEntity> __insertAdapterOfAqiDataEntity = new EntityInsertAdapter<AqiDataEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `aqi_data_table` (`trackedLocationId`,`datetime`,`co`,`no2`,`o3`,`pm10`,`pm25`,`so2`,`aqi`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, AqiDataEntity aqiDataEntity) {
            if (aqiDataEntity.getTrackedLocationId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, aqiDataEntity.getTrackedLocationId());
            }
            sQLiteStatement.bindLong(2, aqiDataEntity.getDatetime());
            if (aqiDataEntity.getCo() == null) {
                sQLiteStatement.bindNull(3);
            } else {
                sQLiteStatement.bindDouble(3, aqiDataEntity.getCo().doubleValue());
            }
            if (aqiDataEntity.getNo2() == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindDouble(4, aqiDataEntity.getNo2().doubleValue());
            }
            if (aqiDataEntity.getO3() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindDouble(5, aqiDataEntity.getO3().doubleValue());
            }
            if (aqiDataEntity.getPm10() == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindDouble(6, aqiDataEntity.getPm10().doubleValue());
            }
            if (aqiDataEntity.getPm25() == null) {
                sQLiteStatement.bindNull(7);
            } else {
                sQLiteStatement.bindDouble(7, aqiDataEntity.getPm25().doubleValue());
            }
            if (aqiDataEntity.getSo2() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindDouble(8, aqiDataEntity.getSo2().doubleValue());
            }
            if (aqiDataEntity.getAqi() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindDouble(9, aqiDataEntity.getAqi().doubleValue());
            }
        }
    };

    public AqiDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public Object insert(AqiDataEntity aqiDataEntity, Continuation<? super Unit> continuation) {
        aqiDataEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda5(this, aqiDataEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$0$com-blueair-database-dao-AqiDataDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8289lambda$insert$0$comblueairdatabasedaoAqiDataDao_Impl(AqiDataEntity aqiDataEntity, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfAqiDataEntity.insert(sQLiteConnection, aqiDataEntity);
        return Unit.INSTANCE;
    }

    public Object insertAll(List<AqiDataEntity> list, Continuation<? super Unit> continuation) {
        list.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda2(this, list), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insertAll$1$com-blueair-database-dao-AqiDataDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8290lambda$insertAll$1$comblueairdatabasedaoAqiDataDao_Impl(List list, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfAqiDataEntity.insert(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    public List<AqiDataEntity> getAqiData() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new AqiDataDao_Impl$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ List lambda$getAqiData$2(SQLiteConnection sQLiteConnection) {
        String str;
        Double d;
        Double d2;
        Double d3;
        Double d4;
        Double d5;
        Double d6;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from aqi_data_table");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trackedLocationId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "datetime");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "co");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "no2");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "o3");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "so2");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "aqi");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                Double d7 = null;
                if (prepare.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = prepare.getText(columnIndexOrThrow);
                }
                long j = prepare.getLong(columnIndexOrThrow2);
                if (prepare.isNull(columnIndexOrThrow3)) {
                    d = null;
                } else {
                    d = Double.valueOf(prepare.getDouble(columnIndexOrThrow3));
                }
                if (prepare.isNull(columnIndexOrThrow4)) {
                    d2 = null;
                } else {
                    d2 = Double.valueOf(prepare.getDouble(columnIndexOrThrow4));
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    d3 = null;
                } else {
                    d3 = Double.valueOf(prepare.getDouble(columnIndexOrThrow5));
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    d4 = null;
                } else {
                    d4 = Double.valueOf(prepare.getDouble(columnIndexOrThrow6));
                }
                if (prepare.isNull(columnIndexOrThrow7)) {
                    d5 = null;
                } else {
                    d5 = Double.valueOf(prepare.getDouble(columnIndexOrThrow7));
                }
                if (prepare.isNull(columnIndexOrThrow8)) {
                    d6 = null;
                } else {
                    d6 = Double.valueOf(prepare.getDouble(columnIndexOrThrow8));
                }
                if (!prepare.isNull(columnIndexOrThrow9)) {
                    d7 = Double.valueOf(prepare.getDouble(columnIndexOrThrow9));
                }
                arrayList.add(new AqiDataEntity(str, j, d, d2, d3, d4, d5, d6, d7));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public Object getAqiData(String str, Continuation<? super AqiDataEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new AqiDataDao_Impl$$ExternalSyntheticLambda6(str), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.Double] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.AqiDataEntity lambda$getAqiData$3(java.lang.String r23, androidx.sqlite.SQLiteConnection r24) {
        /*
            r0 = r23
            java.lang.String r1 = "SELECT * from aqi_data_table WHERE trackedLocationId = ?"
            r2 = r24
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x00f0 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x00f0 }
        L_0x0014:
            java.lang.String r0 = "trackedLocationId"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x00f0 }
            java.lang.String r2 = "datetime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "co"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "no2"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x00f0 }
            java.lang.String r5 = "o3"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x00f0 }
            java.lang.String r6 = "pm10"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = "pm25"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r8 = "so2"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x00f0 }
            java.lang.String r9 = "aqi"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x00f0 }
            boolean r10 = r1.step()     // Catch:{ all -> 0x00f0 }
            r11 = 0
            if (r10 == 0) goto L_0x00ec
            boolean r10 = r1.isNull(r0)     // Catch:{ all -> 0x00f0 }
            if (r10 == 0) goto L_0x0059
            r13 = r11
            goto L_0x005e
        L_0x0059:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x00f0 }
            r13 = r0
        L_0x005e:
            long r14 = r1.getLong(r2)     // Catch:{ all -> 0x00f0 }
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x006b
            r16 = r11
            goto L_0x0075
        L_0x006b:
            double r2 = r1.getDouble(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r16 = r0
        L_0x0075:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x007e
            r17 = r11
            goto L_0x0088
        L_0x007e:
            double r2 = r1.getDouble(r4)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r17 = r0
        L_0x0088:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x0091
            r18 = r11
            goto L_0x009b
        L_0x0091:
            double r2 = r1.getDouble(r5)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r18 = r0
        L_0x009b:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00a4
            r19 = r11
            goto L_0x00ae
        L_0x00a4:
            double r2 = r1.getDouble(r6)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r19 = r0
        L_0x00ae:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00b7
            r20 = r11
            goto L_0x00c1
        L_0x00b7:
            double r2 = r1.getDouble(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r20 = r0
        L_0x00c1:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00ca
            r21 = r11
            goto L_0x00d4
        L_0x00ca:
            double r2 = r1.getDouble(r8)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r21 = r0
        L_0x00d4:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00dd
        L_0x00da:
            r22 = r11
            goto L_0x00e6
        L_0x00dd:
            double r2 = r1.getDouble(r9)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r11 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            goto L_0x00da
        L_0x00e6:
            com.blueair.database.entity.AqiDataEntity r12 = new com.blueair.database.entity.AqiDataEntity     // Catch:{ all -> 0x00f0 }
            r12.<init>(r13, r14, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x00f0 }
            r11 = r12
        L_0x00ec:
            r1.close()
            return r11
        L_0x00f0:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.AqiDataDao_Impl.lambda$getAqiData$3(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.AqiDataEntity");
    }

    public LiveData<List<AqiDataEntity>> getLiveAqiData() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{AqiDataEntity.AQI_DATA_TABLE}, false, new AqiDataDao_Impl$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ List lambda$getLiveAqiData$4(SQLiteConnection sQLiteConnection) {
        String str;
        Double d;
        Double d2;
        Double d3;
        Double d4;
        Double d5;
        Double d6;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from aqi_data_table");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trackedLocationId");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "datetime");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "co");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "no2");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "o3");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "so2");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "aqi");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                Double d7 = null;
                if (prepare.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = prepare.getText(columnIndexOrThrow);
                }
                long j = prepare.getLong(columnIndexOrThrow2);
                if (prepare.isNull(columnIndexOrThrow3)) {
                    d = null;
                } else {
                    d = Double.valueOf(prepare.getDouble(columnIndexOrThrow3));
                }
                if (prepare.isNull(columnIndexOrThrow4)) {
                    d2 = null;
                } else {
                    d2 = Double.valueOf(prepare.getDouble(columnIndexOrThrow4));
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    d3 = null;
                } else {
                    d3 = Double.valueOf(prepare.getDouble(columnIndexOrThrow5));
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    d4 = null;
                } else {
                    d4 = Double.valueOf(prepare.getDouble(columnIndexOrThrow6));
                }
                if (prepare.isNull(columnIndexOrThrow7)) {
                    d5 = null;
                } else {
                    d5 = Double.valueOf(prepare.getDouble(columnIndexOrThrow7));
                }
                if (prepare.isNull(columnIndexOrThrow8)) {
                    d6 = null;
                } else {
                    d6 = Double.valueOf(prepare.getDouble(columnIndexOrThrow8));
                }
                if (!prepare.isNull(columnIndexOrThrow9)) {
                    d7 = Double.valueOf(prepare.getDouble(columnIndexOrThrow9));
                }
                arrayList.add(new AqiDataEntity(str, j, d, d2, d3, d4, d5, d6, d7));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public LiveData<AqiDataEntity> getLiveAqiData(String str) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{AqiDataEntity.AQI_DATA_TABLE}, false, new AqiDataDao_Impl$$ExternalSyntheticLambda1(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.blueair.database.entity.AqiDataEntity} */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.Double] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.AqiDataEntity lambda$getLiveAqiData$5(java.lang.String r23, androidx.sqlite.SQLiteConnection r24) {
        /*
            r0 = r23
            java.lang.String r1 = "SELECT * from aqi_data_table WHERE trackedLocationId = ?"
            r2 = r24
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x00f0 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x00f0 }
        L_0x0014:
            java.lang.String r0 = "trackedLocationId"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x00f0 }
            java.lang.String r2 = "datetime"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x00f0 }
            java.lang.String r3 = "co"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x00f0 }
            java.lang.String r4 = "no2"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x00f0 }
            java.lang.String r5 = "o3"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x00f0 }
            java.lang.String r6 = "pm10"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x00f0 }
            java.lang.String r7 = "pm25"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x00f0 }
            java.lang.String r8 = "so2"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x00f0 }
            java.lang.String r9 = "aqi"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x00f0 }
            boolean r10 = r1.step()     // Catch:{ all -> 0x00f0 }
            r11 = 0
            if (r10 == 0) goto L_0x00ec
            boolean r10 = r1.isNull(r0)     // Catch:{ all -> 0x00f0 }
            if (r10 == 0) goto L_0x0059
            r13 = r11
            goto L_0x005e
        L_0x0059:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x00f0 }
            r13 = r0
        L_0x005e:
            long r14 = r1.getLong(r2)     // Catch:{ all -> 0x00f0 }
            boolean r0 = r1.isNull(r3)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x006b
            r16 = r11
            goto L_0x0075
        L_0x006b:
            double r2 = r1.getDouble(r3)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r16 = r0
        L_0x0075:
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x007e
            r17 = r11
            goto L_0x0088
        L_0x007e:
            double r2 = r1.getDouble(r4)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r17 = r0
        L_0x0088:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x0091
            r18 = r11
            goto L_0x009b
        L_0x0091:
            double r2 = r1.getDouble(r5)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r18 = r0
        L_0x009b:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00a4
            r19 = r11
            goto L_0x00ae
        L_0x00a4:
            double r2 = r1.getDouble(r6)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r19 = r0
        L_0x00ae:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00b7
            r20 = r11
            goto L_0x00c1
        L_0x00b7:
            double r2 = r1.getDouble(r7)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r20 = r0
        L_0x00c1:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00ca
            r21 = r11
            goto L_0x00d4
        L_0x00ca:
            double r2 = r1.getDouble(r8)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            r21 = r0
        L_0x00d4:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x00f0 }
            if (r0 == 0) goto L_0x00dd
        L_0x00da:
            r22 = r11
            goto L_0x00e6
        L_0x00dd:
            double r2 = r1.getDouble(r9)     // Catch:{ all -> 0x00f0 }
            java.lang.Double r11 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            goto L_0x00da
        L_0x00e6:
            com.blueair.database.entity.AqiDataEntity r12 = new com.blueair.database.entity.AqiDataEntity     // Catch:{ all -> 0x00f0 }
            r12.<init>(r13, r14, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x00f0 }
            r11 = r12
        L_0x00ec:
            r1.close()
            return r11
        L_0x00f0:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.AqiDataDao_Impl.lambda$getLiveAqiData$5(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.AqiDataEntity");
    }

    public Object delete(String str, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda0(str), continuation);
    }

    static /* synthetic */ Unit lambda$delete$6(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM aqi_data_table WHERE trackedLocationId = ?");
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

    public Object delete(List<String> list, Continuation<? super Unit> continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM aqi_data_table WHERE trackedLocationId in (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda8(sb.toString(), list), continuation);
    }

    static /* synthetic */ Unit lambda$delete$7(String str, List list, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            Iterator it = list.iterator();
            int i = 1;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 == null) {
                    prepare.bindNull(i);
                } else {
                    prepare.bindText(i, str2);
                }
                i++;
            }
            prepare.step();
            return Unit.INSTANCE;
        } finally {
            prepare.close();
        }
    }

    public Object deleteAll(Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda7(), continuation);
    }

    static /* synthetic */ Unit lambda$deleteAll$8(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM aqi_data_table");
        try {
            prepare.step();
            return Unit.INSTANCE;
        } finally {
            prepare.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }
}
