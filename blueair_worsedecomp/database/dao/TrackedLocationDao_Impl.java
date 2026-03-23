package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.TrackedLocationEntity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class TrackedLocationDao_Impl implements TrackedLocationDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<TrackedLocationEntity> __deleteAdapterOfTrackedLocationEntity = new EntityDeleteOrUpdateAdapter<TrackedLocationEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "DELETE FROM `tracked_location_table` WHERE `id` = ?";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, TrackedLocationEntity trackedLocationEntity) {
            if (trackedLocationEntity.getId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, trackedLocationEntity.getId());
            }
        }
    };
    private final EntityInsertAdapter<TrackedLocationEntity> __insertAdapterOfTrackedLocationEntity = new EntityInsertAdapter<TrackedLocationEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `tracked_location_table` (`id`,`latitude`,`longitude`,`locationName`,`cityName`,`stateName`,`countryName`,`countryCode`,`mapType`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, TrackedLocationEntity trackedLocationEntity) {
            if (trackedLocationEntity.getId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, trackedLocationEntity.getId());
            }
            sQLiteStatement.bindDouble(2, trackedLocationEntity.getLatitude());
            sQLiteStatement.bindDouble(3, trackedLocationEntity.getLongitude());
            if (trackedLocationEntity.getLocationName() == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindText(4, trackedLocationEntity.getLocationName());
            }
            if (trackedLocationEntity.getCityName() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindText(5, trackedLocationEntity.getCityName());
            }
            if (trackedLocationEntity.getStateName() == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindText(6, trackedLocationEntity.getStateName());
            }
            if (trackedLocationEntity.getCountryName() == null) {
                sQLiteStatement.bindNull(7);
            } else {
                sQLiteStatement.bindText(7, trackedLocationEntity.getCountryName());
            }
            if (trackedLocationEntity.getCountryCode() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindText(8, trackedLocationEntity.getCountryCode());
            }
            if (trackedLocationEntity.getMapType() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindText(9, trackedLocationEntity.getMapType());
            }
        }
    };
    private final EntityDeleteOrUpdateAdapter<TrackedLocationEntity> __updateAdapterOfTrackedLocationEntity = new EntityDeleteOrUpdateAdapter<TrackedLocationEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "UPDATE OR REPLACE `tracked_location_table` SET `id` = ?,`latitude` = ?,`longitude` = ?,`locationName` = ?,`cityName` = ?,`stateName` = ?,`countryName` = ?,`countryCode` = ?,`mapType` = ? WHERE `id` = ?";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, TrackedLocationEntity trackedLocationEntity) {
            if (trackedLocationEntity.getId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, trackedLocationEntity.getId());
            }
            sQLiteStatement.bindDouble(2, trackedLocationEntity.getLatitude());
            sQLiteStatement.bindDouble(3, trackedLocationEntity.getLongitude());
            if (trackedLocationEntity.getLocationName() == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindText(4, trackedLocationEntity.getLocationName());
            }
            if (trackedLocationEntity.getCityName() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindText(5, trackedLocationEntity.getCityName());
            }
            if (trackedLocationEntity.getStateName() == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindText(6, trackedLocationEntity.getStateName());
            }
            if (trackedLocationEntity.getCountryName() == null) {
                sQLiteStatement.bindNull(7);
            } else {
                sQLiteStatement.bindText(7, trackedLocationEntity.getCountryName());
            }
            if (trackedLocationEntity.getCountryCode() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindText(8, trackedLocationEntity.getCountryCode());
            }
            if (trackedLocationEntity.getMapType() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindText(9, trackedLocationEntity.getMapType());
            }
            if (trackedLocationEntity.getId() == null) {
                sQLiteStatement.bindNull(10);
            } else {
                sQLiteStatement.bindText(10, trackedLocationEntity.getId());
            }
        }
    };

    public TrackedLocationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public Object insert(TrackedLocationEntity trackedLocationEntity, Continuation<? super Unit> continuation) {
        trackedLocationEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda9(this, trackedLocationEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$0$com-blueair-database-dao-TrackedLocationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8304lambda$insert$0$comblueairdatabasedaoTrackedLocationDao_Impl(TrackedLocationEntity trackedLocationEntity, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfTrackedLocationEntity.insert(sQLiteConnection, trackedLocationEntity);
        return Unit.INSTANCE;
    }

    public Object insert(List<TrackedLocationEntity> list, Continuation<? super Unit> continuation) {
        list.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda10(this, list), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$1$com-blueair-database-dao-TrackedLocationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8305lambda$insert$1$comblueairdatabasedaoTrackedLocationDao_Impl(List list, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfTrackedLocationEntity.insert(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    public Object deleteTrackedLocation(TrackedLocationEntity trackedLocationEntity, Continuation<? super Unit> continuation) {
        trackedLocationEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda2(this, trackedLocationEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$deleteTrackedLocation$2$com-blueair-database-dao-TrackedLocationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8302lambda$deleteTrackedLocation$2$comblueairdatabasedaoTrackedLocationDao_Impl(TrackedLocationEntity trackedLocationEntity, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfTrackedLocationEntity.handle(sQLiteConnection, trackedLocationEntity);
        return Unit.INSTANCE;
    }

    public Object deleteTrackedLocations(List<TrackedLocationEntity> list, Continuation<? super Unit> continuation) {
        list.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda3(this, list), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$deleteTrackedLocations$3$com-blueair-database-dao-TrackedLocationDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8303lambda$deleteTrackedLocations$3$comblueairdatabasedaoTrackedLocationDao_Impl(List list, SQLiteConnection sQLiteConnection) {
        this.__deleteAdapterOfTrackedLocationEntity.handleMultiple(sQLiteConnection, list);
        return Unit.INSTANCE;
    }

    public Object update(TrackedLocationEntity trackedLocationEntity, Continuation<? super Integer> continuation) {
        trackedLocationEntity.getClass();
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda13(this, trackedLocationEntity), continuation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$update$4$com-blueair-database-dao-TrackedLocationDao_Impl  reason: not valid java name */
    public /* synthetic */ Integer m8306lambda$update$4$comblueairdatabasedaoTrackedLocationDao_Impl(TrackedLocationEntity trackedLocationEntity, SQLiteConnection sQLiteConnection) {
        return Integer.valueOf(this.__updateAdapterOfTrackedLocationEntity.handle(sQLiteConnection, trackedLocationEntity));
    }

    public List<TrackedLocationEntity> getTrackedLocations() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda12());
    }

    static /* synthetic */ List lambda$getTrackedLocations$5(SQLiteConnection sQLiteConnection) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from tracked_location_table");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latitude");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "longitude");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "locationName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "cityName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stateName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countryName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "mapType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String str7 = null;
                if (prepare.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = prepare.getText(columnIndexOrThrow);
                }
                double d = prepare.getDouble(columnIndexOrThrow2);
                double d2 = prepare.getDouble(columnIndexOrThrow3);
                if (prepare.isNull(columnIndexOrThrow4)) {
                    str2 = null;
                } else {
                    str2 = prepare.getText(columnIndexOrThrow4);
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = prepare.getText(columnIndexOrThrow5);
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = prepare.getText(columnIndexOrThrow6);
                }
                if (prepare.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = prepare.getText(columnIndexOrThrow7);
                }
                if (prepare.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = prepare.getText(columnIndexOrThrow8);
                }
                if (!prepare.isNull(columnIndexOrThrow9)) {
                    str7 = prepare.getText(columnIndexOrThrow9);
                }
                arrayList.add(new TrackedLocationEntity(str, d, d2, str2, str3, str4, str5, str6, str7));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public LiveData<List<TrackedLocationEntity>> getLiveTrackedLocations() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{TrackedLocationEntity.TRACKED_LOCATION_TABLE}, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda8());
    }

    static /* synthetic */ List lambda$getLiveTrackedLocations$6(SQLiteConnection sQLiteConnection) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from tracked_location_table");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "latitude");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "longitude");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "locationName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "cityName");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "stateName");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "countryName");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "mapType");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                String str7 = null;
                if (prepare.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = prepare.getText(columnIndexOrThrow);
                }
                double d = prepare.getDouble(columnIndexOrThrow2);
                double d2 = prepare.getDouble(columnIndexOrThrow3);
                if (prepare.isNull(columnIndexOrThrow4)) {
                    str2 = null;
                } else {
                    str2 = prepare.getText(columnIndexOrThrow4);
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = prepare.getText(columnIndexOrThrow5);
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = prepare.getText(columnIndexOrThrow6);
                }
                if (prepare.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = prepare.getText(columnIndexOrThrow7);
                }
                if (prepare.isNull(columnIndexOrThrow8)) {
                    str6 = null;
                } else {
                    str6 = prepare.getText(columnIndexOrThrow8);
                }
                if (!prepare.isNull(columnIndexOrThrow9)) {
                    str7 = prepare.getText(columnIndexOrThrow9);
                }
                arrayList.add(new TrackedLocationEntity(str, d, d2, str2, str3, str4, str5, str6, str7));
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public TrackedLocationEntity getCurrentLocation() {
        return (TrackedLocationEntity) DBUtil.performBlocking(this.__db, true, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda0());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.TrackedLocationEntity lambda$getCurrentLocation$7(androidx.sqlite.SQLiteConnection r24) {
        /*
            java.lang.String r0 = "SELECT * from tracked_location_table where id = 'current'"
            r1 = r24
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r0)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "latitude"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = "longitude"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "locationName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = "cityName"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = "stateName"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r7 = "countryName"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x00bd }
            java.lang.String r8 = "countryCode"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r9 = "mapType"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x00bd }
            boolean r10 = r1.step()     // Catch:{ all -> 0x00bd }
            r11 = 0
            if (r10 == 0) goto L_0x00b9
            boolean r10 = r1.isNull(r0)     // Catch:{ all -> 0x00bd }
            if (r10 == 0) goto L_0x004d
            r13 = r11
            goto L_0x0052
        L_0x004d:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x00bd }
            r13 = r0
        L_0x0052:
            double r14 = r1.getDouble(r2)     // Catch:{ all -> 0x00bd }
            double r16 = r1.getDouble(r3)     // Catch:{ all -> 0x00bd }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0063
            r18 = r11
            goto L_0x0069
        L_0x0063:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x00bd }
            r18 = r0
        L_0x0069:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0072
            r19 = r11
            goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r1.getText(r5)     // Catch:{ all -> 0x00bd }
            r19 = r0
        L_0x0078:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0081
            r20 = r11
            goto L_0x0087
        L_0x0081:
            java.lang.String r0 = r1.getText(r6)     // Catch:{ all -> 0x00bd }
            r20 = r0
        L_0x0087:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0090
            r21 = r11
            goto L_0x0096
        L_0x0090:
            java.lang.String r0 = r1.getText(r7)     // Catch:{ all -> 0x00bd }
            r21 = r0
        L_0x0096:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x009f
            r22 = r11
            goto L_0x00a5
        L_0x009f:
            java.lang.String r0 = r1.getText(r8)     // Catch:{ all -> 0x00bd }
            r22 = r0
        L_0x00a5:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x00ae
        L_0x00ab:
            r23 = r11
            goto L_0x00b3
        L_0x00ae:
            java.lang.String r11 = r1.getText(r9)     // Catch:{ all -> 0x00bd }
            goto L_0x00ab
        L_0x00b3:
            com.blueair.database.entity.TrackedLocationEntity r12 = new com.blueair.database.entity.TrackedLocationEntity     // Catch:{ all -> 0x00bd }
            r12.<init>(r13, r14, r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x00bd }
            r11 = r12
        L_0x00b9:
            r1.close()
            return r11
        L_0x00bd:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.TrackedLocationDao_Impl.lambda$getCurrentLocation$7(androidx.sqlite.SQLiteConnection):com.blueair.database.entity.TrackedLocationEntity");
    }

    public LiveData<TrackedLocationEntity> getLiveCurrentLocation() {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{TrackedLocationEntity.TRACKED_LOCATION_TABLE}, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda11());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.TrackedLocationEntity lambda$getLiveCurrentLocation$8(androidx.sqlite.SQLiteConnection r24) {
        /*
            java.lang.String r0 = "SELECT * from tracked_location_table where id = 'current'"
            r1 = r24
            androidx.sqlite.SQLiteStatement r1 = r1.prepare(r0)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "latitude"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = "longitude"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "locationName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x00bd }
            java.lang.String r5 = "cityName"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = "stateName"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r7 = "countryName"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x00bd }
            java.lang.String r8 = "countryCode"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r9 = "mapType"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x00bd }
            boolean r10 = r1.step()     // Catch:{ all -> 0x00bd }
            r11 = 0
            if (r10 == 0) goto L_0x00b9
            boolean r10 = r1.isNull(r0)     // Catch:{ all -> 0x00bd }
            if (r10 == 0) goto L_0x004d
            r13 = r11
            goto L_0x0052
        L_0x004d:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x00bd }
            r13 = r0
        L_0x0052:
            double r14 = r1.getDouble(r2)     // Catch:{ all -> 0x00bd }
            double r16 = r1.getDouble(r3)     // Catch:{ all -> 0x00bd }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0063
            r18 = r11
            goto L_0x0069
        L_0x0063:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x00bd }
            r18 = r0
        L_0x0069:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0072
            r19 = r11
            goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r1.getText(r5)     // Catch:{ all -> 0x00bd }
            r19 = r0
        L_0x0078:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0081
            r20 = r11
            goto L_0x0087
        L_0x0081:
            java.lang.String r0 = r1.getText(r6)     // Catch:{ all -> 0x00bd }
            r20 = r0
        L_0x0087:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0090
            r21 = r11
            goto L_0x0096
        L_0x0090:
            java.lang.String r0 = r1.getText(r7)     // Catch:{ all -> 0x00bd }
            r21 = r0
        L_0x0096:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x009f
            r22 = r11
            goto L_0x00a5
        L_0x009f:
            java.lang.String r0 = r1.getText(r8)     // Catch:{ all -> 0x00bd }
            r22 = r0
        L_0x00a5:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x00ae
        L_0x00ab:
            r23 = r11
            goto L_0x00b3
        L_0x00ae:
            java.lang.String r11 = r1.getText(r9)     // Catch:{ all -> 0x00bd }
            goto L_0x00ab
        L_0x00b3:
            com.blueair.database.entity.TrackedLocationEntity r12 = new com.blueair.database.entity.TrackedLocationEntity     // Catch:{ all -> 0x00bd }
            r12.<init>(r13, r14, r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x00bd }
            r11 = r12
        L_0x00b9:
            r1.close()
            return r11
        L_0x00bd:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.TrackedLocationDao_Impl.lambda$getLiveCurrentLocation$8(androidx.sqlite.SQLiteConnection):com.blueair.database.entity.TrackedLocationEntity");
    }

    public LiveData<TrackedLocationEntity> liveTrackedLocation(String str) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{TrackedLocationEntity.TRACKED_LOCATION_TABLE}, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda4(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.TrackedLocationEntity lambda$liveTrackedLocation$9(java.lang.String r24, androidx.sqlite.SQLiteConnection r25) {
        /*
            r0 = r24
            java.lang.String r1 = "SELECT * from tracked_location_table  WHERE id = ?"
            r2 = r25
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x00c9 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x00c9 }
        L_0x0014:
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = "latitude"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "longitude"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = "locationName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x00c9 }
            java.lang.String r5 = "cityName"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x00c9 }
            java.lang.String r6 = "stateName"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x00c9 }
            java.lang.String r7 = "countryName"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = "countryCode"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = "mapType"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x00c9 }
            boolean r10 = r1.step()     // Catch:{ all -> 0x00c9 }
            r11 = 0
            if (r10 == 0) goto L_0x00c5
            boolean r10 = r1.isNull(r0)     // Catch:{ all -> 0x00c9 }
            if (r10 == 0) goto L_0x0059
            r13 = r11
            goto L_0x005e
        L_0x0059:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x00c9 }
            r13 = r0
        L_0x005e:
            double r14 = r1.getDouble(r2)     // Catch:{ all -> 0x00c9 }
            double r16 = r1.getDouble(r3)     // Catch:{ all -> 0x00c9 }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x006f
            r18 = r11
            goto L_0x0075
        L_0x006f:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x00c9 }
            r18 = r0
        L_0x0075:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x007e
            r19 = r11
            goto L_0x0084
        L_0x007e:
            java.lang.String r0 = r1.getText(r5)     // Catch:{ all -> 0x00c9 }
            r19 = r0
        L_0x0084:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x008d
            r20 = r11
            goto L_0x0093
        L_0x008d:
            java.lang.String r0 = r1.getText(r6)     // Catch:{ all -> 0x00c9 }
            r20 = r0
        L_0x0093:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x009c
            r21 = r11
            goto L_0x00a2
        L_0x009c:
            java.lang.String r0 = r1.getText(r7)     // Catch:{ all -> 0x00c9 }
            r21 = r0
        L_0x00a2:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00ab
            r22 = r11
            goto L_0x00b1
        L_0x00ab:
            java.lang.String r0 = r1.getText(r8)     // Catch:{ all -> 0x00c9 }
            r22 = r0
        L_0x00b1:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00ba
        L_0x00b7:
            r23 = r11
            goto L_0x00bf
        L_0x00ba:
            java.lang.String r11 = r1.getText(r9)     // Catch:{ all -> 0x00c9 }
            goto L_0x00b7
        L_0x00bf:
            com.blueair.database.entity.TrackedLocationEntity r12 = new com.blueair.database.entity.TrackedLocationEntity     // Catch:{ all -> 0x00c9 }
            r12.<init>(r13, r14, r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x00c9 }
            r11 = r12
        L_0x00c5:
            r1.close()
            return r11
        L_0x00c9:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.TrackedLocationDao_Impl.lambda$liveTrackedLocation$9(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.TrackedLocationEntity");
    }

    public Object getTrackedLocation(String str, Continuation<? super TrackedLocationEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda6(str), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: com.blueair.database.entity.TrackedLocationEntity} */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.TrackedLocationEntity lambda$getTrackedLocation$10(java.lang.String r24, androidx.sqlite.SQLiteConnection r25) {
        /*
            r0 = r24
            java.lang.String r1 = "SELECT * from tracked_location_table  WHERE id = ?"
            r2 = r25
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x00c9 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x00c9 }
        L_0x0014:
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = "latitude"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "longitude"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = "locationName"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x00c9 }
            java.lang.String r5 = "cityName"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x00c9 }
            java.lang.String r6 = "stateName"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x00c9 }
            java.lang.String r7 = "countryName"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = "countryCode"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = "mapType"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x00c9 }
            boolean r10 = r1.step()     // Catch:{ all -> 0x00c9 }
            r11 = 0
            if (r10 == 0) goto L_0x00c5
            boolean r10 = r1.isNull(r0)     // Catch:{ all -> 0x00c9 }
            if (r10 == 0) goto L_0x0059
            r13 = r11
            goto L_0x005e
        L_0x0059:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x00c9 }
            r13 = r0
        L_0x005e:
            double r14 = r1.getDouble(r2)     // Catch:{ all -> 0x00c9 }
            double r16 = r1.getDouble(r3)     // Catch:{ all -> 0x00c9 }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x006f
            r18 = r11
            goto L_0x0075
        L_0x006f:
            java.lang.String r0 = r1.getText(r4)     // Catch:{ all -> 0x00c9 }
            r18 = r0
        L_0x0075:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x007e
            r19 = r11
            goto L_0x0084
        L_0x007e:
            java.lang.String r0 = r1.getText(r5)     // Catch:{ all -> 0x00c9 }
            r19 = r0
        L_0x0084:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x008d
            r20 = r11
            goto L_0x0093
        L_0x008d:
            java.lang.String r0 = r1.getText(r6)     // Catch:{ all -> 0x00c9 }
            r20 = r0
        L_0x0093:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x009c
            r21 = r11
            goto L_0x00a2
        L_0x009c:
            java.lang.String r0 = r1.getText(r7)     // Catch:{ all -> 0x00c9 }
            r21 = r0
        L_0x00a2:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00ab
            r22 = r11
            goto L_0x00b1
        L_0x00ab:
            java.lang.String r0 = r1.getText(r8)     // Catch:{ all -> 0x00c9 }
            r22 = r0
        L_0x00b1:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x00ba
        L_0x00b7:
            r23 = r11
            goto L_0x00bf
        L_0x00ba:
            java.lang.String r11 = r1.getText(r9)     // Catch:{ all -> 0x00c9 }
            goto L_0x00b7
        L_0x00bf:
            com.blueair.database.entity.TrackedLocationEntity r12 = new com.blueair.database.entity.TrackedLocationEntity     // Catch:{ all -> 0x00c9 }
            r12.<init>(r13, r14, r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x00c9 }
            r11 = r12
        L_0x00c5:
            r1.close()
            return r11
        L_0x00c9:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.TrackedLocationDao_Impl.lambda$getTrackedLocation$10(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.TrackedLocationEntity");
    }

    public Object deleteTrackedLocation(String str, Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda5(str), continuation);
    }

    static /* synthetic */ Unit lambda$deleteTrackedLocation$11(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM tracked_location_table WHERE id = ?");
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

    public void deleteTrackedLocations(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE FROM tracked_location_table where id in (");
        StringUtil.appendPlaceholders(sb, list.size());
        sb.append(")");
        DBUtil.performBlocking(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda1(sb.toString(), list));
    }

    /* JADX INFO: finally extract failed */
    static /* synthetic */ Object lambda$deleteTrackedLocations$12(String str, List list, SQLiteConnection sQLiteConnection) {
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
            prepare.close();
            return null;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    public Object deleteAll(Continuation<? super Unit> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda7(), continuation);
    }

    static /* synthetic */ Unit lambda$deleteAll$13(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM tracked_location_table");
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
