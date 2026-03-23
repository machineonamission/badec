package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.database.dao.DeviceDataDao;
import com.blueair.database.entity.DeviceDataEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

public final class DeviceDataDao_Impl implements DeviceDataDao {
    private final RoomDatabase __db;
    private final EntityInsertAdapter<DeviceDataEntity> __insertAdapterOfDeviceDataEntity = new EntityInsertAdapter<DeviceDataEntity>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `device_data` (`id`,`deviceId`,`time`,`pm1`,`pm10`,`pm25`,`voc`,`hcho`,`tmp`,`hum`,`fan`,`weight`,`trend`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, DeviceDataEntity deviceDataEntity) {
            if (deviceDataEntity.getId() == null) {
                sQLiteStatement.bindNull(1);
            } else {
                sQLiteStatement.bindText(1, deviceDataEntity.getId());
            }
            if (deviceDataEntity.getDeviceId() == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindText(2, deviceDataEntity.getDeviceId());
            }
            sQLiteStatement.bindLong(3, deviceDataEntity.getTime());
            if (deviceDataEntity.getPm1() == null) {
                sQLiteStatement.bindNull(4);
            } else {
                sQLiteStatement.bindDouble(4, (double) deviceDataEntity.getPm1().floatValue());
            }
            if (deviceDataEntity.getPm10() == null) {
                sQLiteStatement.bindNull(5);
            } else {
                sQLiteStatement.bindDouble(5, (double) deviceDataEntity.getPm10().floatValue());
            }
            if (deviceDataEntity.getPm25() == null) {
                sQLiteStatement.bindNull(6);
            } else {
                sQLiteStatement.bindDouble(6, (double) deviceDataEntity.getPm25().floatValue());
            }
            if (deviceDataEntity.getVoc() == null) {
                sQLiteStatement.bindNull(7);
            } else {
                sQLiteStatement.bindDouble(7, (double) deviceDataEntity.getVoc().floatValue());
            }
            if (deviceDataEntity.getHcho() == null) {
                sQLiteStatement.bindNull(8);
            } else {
                sQLiteStatement.bindDouble(8, (double) deviceDataEntity.getHcho().floatValue());
            }
            if (deviceDataEntity.getTmp() == null) {
                sQLiteStatement.bindNull(9);
            } else {
                sQLiteStatement.bindDouble(9, (double) deviceDataEntity.getTmp().floatValue());
            }
            if (deviceDataEntity.getHum() == null) {
                sQLiteStatement.bindNull(10);
            } else {
                sQLiteStatement.bindDouble(10, (double) deviceDataEntity.getHum().floatValue());
            }
            if (deviceDataEntity.getFan() == null) {
                sQLiteStatement.bindNull(11);
            } else {
                sQLiteStatement.bindDouble(11, (double) deviceDataEntity.getFan().floatValue());
            }
            if (deviceDataEntity.getWeight() == null) {
                sQLiteStatement.bindNull(12);
            } else {
                sQLiteStatement.bindDouble(12, (double) deviceDataEntity.getWeight().floatValue());
            }
            sQLiteStatement.bindLong(13, (long) deviceDataEntity.getTrend());
        }
    };

    public DeviceDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public void insert(DeviceDataEntity deviceDataEntity) {
        deviceDataEntity.getClass();
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda22(this, deviceDataEntity));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insert$0$com-blueair-database-dao-DeviceDataDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m8293lambda$insert$0$comblueairdatabasedaoDeviceDataDao_Impl(DeviceDataEntity deviceDataEntity, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDeviceDataEntity.insert(sQLiteConnection, deviceDataEntity);
        return null;
    }

    public void insertAll(List<DeviceDataEntity> list) {
        list.getClass();
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda16(this, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insertAll$1$com-blueair-database-dao-DeviceDataDao_Impl  reason: not valid java name */
    public /* synthetic */ Object m8294lambda$insertAll$1$comblueairdatabasedaoDeviceDataDao_Impl(List list, SQLiteConnection sQLiteConnection) {
        this.__insertAdapterOfDeviceDataEntity.insert(sQLiteConnection, list);
        return null;
    }

    public void insertAllAndDeletePrevious(String str, List<DeviceDataEntity> list) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda20(this, str, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insertAllAndDeletePrevious$2$com-blueair-database-dao-DeviceDataDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8295lambda$insertAllAndDeletePrevious$2$comblueairdatabasedaoDeviceDataDao_Impl(String str, List list, SQLiteConnection sQLiteConnection) {
        DeviceDataDao.CC.$default$insertAllAndDeletePrevious(this, str, list);
        return Unit.INSTANCE;
    }

    public void insertAllAndReplace(String str, List<DeviceDataEntity> list) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda18(this, str, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$insertAllAndReplace$3$com-blueair-database-dao-DeviceDataDao_Impl  reason: not valid java name */
    public /* synthetic */ Unit m8296lambda$insertAllAndReplace$3$comblueairdatabasedaoDeviceDataDao_Impl(String str, List list, SQLiteConnection sQLiteConnection) {
        DeviceDataDao.CC.$default$insertAllAndReplace(this, str, list);
        return Unit.INSTANCE;
    }

    public List<DeviceDataEntity> deviceData(String str) {
        return (List) DBUtil.performBlocking(this.__db, true, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda0(str));
    }

    static /* synthetic */ List lambda$deviceData$4(String str, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ?");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Flow<List<DeviceDataEntity>> flowDeviceData(String str) {
        return FlowUtil.createFlow(this.__db, true, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda3(str));
    }

    static /* synthetic */ List lambda$flowDeviceData$5(String str, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ?");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Flow<List<DeviceDataEntity>> getFlowDeviceDataSince(String str, long j) {
        return FlowUtil.createFlow(this.__db, true, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda12(str, j));
    }

    static /* synthetic */ List lambda$getFlowDeviceDataSince$6(String str, long j, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ? AND time >= ? ORDER BY time");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        prepare.bindLong(2, j);
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j2 = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j2, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Flow<List<DeviceDataEntity>> getFlowDeviceDataBetween(String str, long j, long j2) {
        return FlowUtil.createFlow(this.__db, true, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda9(str, j, j2));
    }

    static /* synthetic */ List lambda$getFlowDeviceDataBetween$7(String str, long j, long j2, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ? AND time >= ? AND time <= ? ORDER BY time");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        prepare.bindLong(2, j);
        prepare.bindLong(3, j2);
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j3 = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j3, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Flow<List<DeviceDataEntity>> getFlowDeviceNonRealTimeDataBetween(String str, long j, long j2) {
        return FlowUtil.createFlow(this.__db, true, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda8(str, j, j2));
    }

    static /* synthetic */ List lambda$getFlowDeviceNonRealTimeDataBetween$8(String str, long j, long j2, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ? AND trend != 2 AND time >= ? AND time <= ? ORDER BY time");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        prepare.bindLong(2, j);
        prepare.bindLong(3, j2);
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j3 = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j3, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public LiveData<List<DeviceDataEntity>> getLiveDeviceDataSince(String str, long j) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, false, new DeviceDataDao_Impl$$ExternalSyntheticLambda11(str, j));
    }

    static /* synthetic */ List lambda$getLiveDeviceDataSince$9(String str, long j, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ? AND time >= ? ORDER BY time");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        prepare.bindLong(2, j);
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j2 = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j2, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Flow<List<DeviceDataEntity>> getFlowRealTimeDeviceData(String str) {
        return FlowUtil.createFlow(this.__db, true, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda15(str));
    }

    static /* synthetic */ List lambda$getFlowRealTimeDeviceData$10(String str, SQLiteConnection sQLiteConnection) {
        String str2;
        String str3;
        int i;
        int i2;
        Float f;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        String str4 = str;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * from device_data WHERE deviceId = ? AND trend = 2 ORDER BY time");
        if (str4 == null) {
            try {
                prepare.bindNull(1);
            } catch (Throwable th) {
                prepare.close();
                throw th;
            }
        } else {
            prepare.bindText(1, str4);
        }
        int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
        int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
        int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
        int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
        int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
        int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
        int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
        int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
        int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
        int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
        int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
        int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
        int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
        ArrayList arrayList = new ArrayList();
        while (prepare.step()) {
            Float f9 = null;
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
            long j = prepare.getLong(columnIndexOrThrow3);
            if (prepare.isNull(columnIndexOrThrow4)) {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = null;
            } else {
                i2 = columnIndexOrThrow2;
                i = columnIndexOrThrow3;
                f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
            }
            if (prepare.isNull(columnIndexOrThrow5)) {
                f2 = null;
            } else {
                f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
            }
            if (prepare.isNull(columnIndexOrThrow6)) {
                f3 = null;
            } else {
                f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
            }
            if (prepare.isNull(columnIndexOrThrow7)) {
                f4 = null;
            } else {
                f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
            }
            if (prepare.isNull(columnIndexOrThrow8)) {
                f5 = null;
            } else {
                f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
            }
            if (prepare.isNull(columnIndexOrThrow9)) {
                f6 = null;
            } else {
                f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
            }
            if (prepare.isNull(columnIndexOrThrow10)) {
                f7 = null;
            } else {
                f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
            }
            if (prepare.isNull(columnIndexOrThrow11)) {
                f8 = null;
            } else {
                f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
            }
            if (!prepare.isNull(columnIndexOrThrow12)) {
                f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
            }
            arrayList.add(new DeviceDataEntity(str2, str3, j, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
            columnIndexOrThrow2 = i2;
            columnIndexOrThrow3 = i;
        }
        prepare.close();
        return arrayList;
    }

    public Object latestDeviceData(String str, Continuation<? super DeviceDataEntity> continuation) {
        return DBUtil.performSuspending(this.__db, true, false, new DeviceDataDao_Impl$$ExternalSyntheticLambda1(str), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX WARNING: type inference failed for: r15v2, types: [java.lang.Float] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceDataEntity lambda$latestDeviceData$11(java.lang.String r31, androidx.sqlite.SQLiteConnection r32) {
        /*
            r0 = r31
            java.lang.String r1 = "SELECT * from device_data WHERE deviceId = ? ORDER BY time DESC LIMIT 1"
            r2 = r32
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0150 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0150 }
        L_0x0014:
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0150 }
            java.lang.String r2 = "deviceId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = "time"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0150 }
            java.lang.String r4 = "pm1"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "pm10"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0150 }
            java.lang.String r6 = "pm25"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r7 = "voc"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "hcho"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0150 }
            java.lang.String r9 = "tmp"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0150 }
            java.lang.String r10 = "hum"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0150 }
            java.lang.String r11 = "fan"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0150 }
            java.lang.String r12 = "weight"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0150 }
            java.lang.String r13 = "trend"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0150 }
            boolean r14 = r1.step()     // Catch:{ all -> 0x0150 }
            r15 = 0
            if (r14 == 0) goto L_0x014c
            boolean r14 = r1.isNull(r0)     // Catch:{ all -> 0x0150 }
            if (r14 == 0) goto L_0x0072
            r17 = r15
            goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0150 }
            r17 = r0
        L_0x0078:
            boolean r0 = r1.isNull(r2)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0081
            r18 = r15
            goto L_0x0087
        L_0x0081:
            java.lang.String r0 = r1.getText(r2)     // Catch:{ all -> 0x0150 }
            r18 = r0
        L_0x0087:
            long r19 = r1.getLong(r3)     // Catch:{ all -> 0x0150 }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0094
            r21 = r15
            goto L_0x009f
        L_0x0094:
            double r2 = r1.getDouble(r4)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r21 = r0
        L_0x009f:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00a8
            r22 = r15
            goto L_0x00b3
        L_0x00a8:
            double r2 = r1.getDouble(r5)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r22 = r0
        L_0x00b3:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00bc
            r23 = r15
            goto L_0x00c7
        L_0x00bc:
            double r2 = r1.getDouble(r6)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r23 = r0
        L_0x00c7:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00d0
            r24 = r15
            goto L_0x00db
        L_0x00d0:
            double r2 = r1.getDouble(r7)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r24 = r0
        L_0x00db:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e4
            r25 = r15
            goto L_0x00ef
        L_0x00e4:
            double r2 = r1.getDouble(r8)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r25 = r0
        L_0x00ef:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00f8
            r26 = r15
            goto L_0x0103
        L_0x00f8:
            double r2 = r1.getDouble(r9)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r26 = r0
        L_0x0103:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x010c
            r27 = r15
            goto L_0x0117
        L_0x010c:
            double r2 = r1.getDouble(r10)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r27 = r0
        L_0x0117:
            boolean r0 = r1.isNull(r11)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0120
            r28 = r15
            goto L_0x012b
        L_0x0120:
            double r2 = r1.getDouble(r11)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r28 = r0
        L_0x012b:
            boolean r0 = r1.isNull(r12)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0134
        L_0x0131:
            r29 = r15
            goto L_0x013e
        L_0x0134:
            double r2 = r1.getDouble(r12)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r15 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            goto L_0x0131
        L_0x013e:
            long r2 = r1.getLong(r13)     // Catch:{ all -> 0x0150 }
            int r0 = (int) r2     // Catch:{ all -> 0x0150 }
            com.blueair.database.entity.DeviceDataEntity r16 = new com.blueair.database.entity.DeviceDataEntity     // Catch:{ all -> 0x0150 }
            r30 = r0
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x0150 }
            r15 = r16
        L_0x014c:
            r1.close()
            return r15
        L_0x0150:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDataDao_Impl.lambda$latestDeviceData$11(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceDataEntity");
    }

    public LiveData<DeviceDataEntity> latestLiveDeviceData(String str) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, false, new DeviceDataDao_Impl$$ExternalSyntheticLambda7(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX WARNING: type inference failed for: r15v2, types: [java.lang.Float] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceDataEntity lambda$latestLiveDeviceData$12(java.lang.String r31, androidx.sqlite.SQLiteConnection r32) {
        /*
            r0 = r31
            java.lang.String r1 = "SELECT * from device_data WHERE deviceId = ? ORDER BY time DESC LIMIT 1"
            r2 = r32
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0150 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0150 }
        L_0x0014:
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0150 }
            java.lang.String r2 = "deviceId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = "time"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0150 }
            java.lang.String r4 = "pm1"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "pm10"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0150 }
            java.lang.String r6 = "pm25"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r7 = "voc"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "hcho"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0150 }
            java.lang.String r9 = "tmp"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0150 }
            java.lang.String r10 = "hum"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0150 }
            java.lang.String r11 = "fan"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0150 }
            java.lang.String r12 = "weight"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0150 }
            java.lang.String r13 = "trend"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0150 }
            boolean r14 = r1.step()     // Catch:{ all -> 0x0150 }
            r15 = 0
            if (r14 == 0) goto L_0x014c
            boolean r14 = r1.isNull(r0)     // Catch:{ all -> 0x0150 }
            if (r14 == 0) goto L_0x0072
            r17 = r15
            goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0150 }
            r17 = r0
        L_0x0078:
            boolean r0 = r1.isNull(r2)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0081
            r18 = r15
            goto L_0x0087
        L_0x0081:
            java.lang.String r0 = r1.getText(r2)     // Catch:{ all -> 0x0150 }
            r18 = r0
        L_0x0087:
            long r19 = r1.getLong(r3)     // Catch:{ all -> 0x0150 }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0094
            r21 = r15
            goto L_0x009f
        L_0x0094:
            double r2 = r1.getDouble(r4)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r21 = r0
        L_0x009f:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00a8
            r22 = r15
            goto L_0x00b3
        L_0x00a8:
            double r2 = r1.getDouble(r5)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r22 = r0
        L_0x00b3:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00bc
            r23 = r15
            goto L_0x00c7
        L_0x00bc:
            double r2 = r1.getDouble(r6)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r23 = r0
        L_0x00c7:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00d0
            r24 = r15
            goto L_0x00db
        L_0x00d0:
            double r2 = r1.getDouble(r7)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r24 = r0
        L_0x00db:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e4
            r25 = r15
            goto L_0x00ef
        L_0x00e4:
            double r2 = r1.getDouble(r8)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r25 = r0
        L_0x00ef:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00f8
            r26 = r15
            goto L_0x0103
        L_0x00f8:
            double r2 = r1.getDouble(r9)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r26 = r0
        L_0x0103:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x010c
            r27 = r15
            goto L_0x0117
        L_0x010c:
            double r2 = r1.getDouble(r10)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r27 = r0
        L_0x0117:
            boolean r0 = r1.isNull(r11)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0120
            r28 = r15
            goto L_0x012b
        L_0x0120:
            double r2 = r1.getDouble(r11)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r28 = r0
        L_0x012b:
            boolean r0 = r1.isNull(r12)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0134
        L_0x0131:
            r29 = r15
            goto L_0x013e
        L_0x0134:
            double r2 = r1.getDouble(r12)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r15 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            goto L_0x0131
        L_0x013e:
            long r2 = r1.getLong(r13)     // Catch:{ all -> 0x0150 }
            int r0 = (int) r2     // Catch:{ all -> 0x0150 }
            com.blueair.database.entity.DeviceDataEntity r16 = new com.blueair.database.entity.DeviceDataEntity     // Catch:{ all -> 0x0150 }
            r30 = r0
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x0150 }
            r15 = r16
        L_0x014c:
            r1.close()
            return r15
        L_0x0150:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDataDao_Impl.lambda$latestLiveDeviceData$12(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceDataEntity");
    }

    public Flow<DeviceDataEntity> latestFlowDeviceData(String str) {
        return FlowUtil.createFlow(this.__db, false, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda21(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX WARNING: type inference failed for: r15v2, types: [java.lang.Float] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceDataEntity lambda$latestFlowDeviceData$13(java.lang.String r31, androidx.sqlite.SQLiteConnection r32) {
        /*
            r0 = r31
            java.lang.String r1 = "SELECT * from device_data WHERE deviceId = ? ORDER BY time DESC LIMIT 1"
            r2 = r32
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0150 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0150 }
        L_0x0014:
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0150 }
            java.lang.String r2 = "deviceId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = "time"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0150 }
            java.lang.String r4 = "pm1"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "pm10"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0150 }
            java.lang.String r6 = "pm25"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r7 = "voc"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "hcho"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0150 }
            java.lang.String r9 = "tmp"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0150 }
            java.lang.String r10 = "hum"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0150 }
            java.lang.String r11 = "fan"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0150 }
            java.lang.String r12 = "weight"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0150 }
            java.lang.String r13 = "trend"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0150 }
            boolean r14 = r1.step()     // Catch:{ all -> 0x0150 }
            r15 = 0
            if (r14 == 0) goto L_0x014c
            boolean r14 = r1.isNull(r0)     // Catch:{ all -> 0x0150 }
            if (r14 == 0) goto L_0x0072
            r17 = r15
            goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0150 }
            r17 = r0
        L_0x0078:
            boolean r0 = r1.isNull(r2)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0081
            r18 = r15
            goto L_0x0087
        L_0x0081:
            java.lang.String r0 = r1.getText(r2)     // Catch:{ all -> 0x0150 }
            r18 = r0
        L_0x0087:
            long r19 = r1.getLong(r3)     // Catch:{ all -> 0x0150 }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0094
            r21 = r15
            goto L_0x009f
        L_0x0094:
            double r2 = r1.getDouble(r4)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r21 = r0
        L_0x009f:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00a8
            r22 = r15
            goto L_0x00b3
        L_0x00a8:
            double r2 = r1.getDouble(r5)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r22 = r0
        L_0x00b3:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00bc
            r23 = r15
            goto L_0x00c7
        L_0x00bc:
            double r2 = r1.getDouble(r6)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r23 = r0
        L_0x00c7:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00d0
            r24 = r15
            goto L_0x00db
        L_0x00d0:
            double r2 = r1.getDouble(r7)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r24 = r0
        L_0x00db:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e4
            r25 = r15
            goto L_0x00ef
        L_0x00e4:
            double r2 = r1.getDouble(r8)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r25 = r0
        L_0x00ef:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00f8
            r26 = r15
            goto L_0x0103
        L_0x00f8:
            double r2 = r1.getDouble(r9)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r26 = r0
        L_0x0103:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x010c
            r27 = r15
            goto L_0x0117
        L_0x010c:
            double r2 = r1.getDouble(r10)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r27 = r0
        L_0x0117:
            boolean r0 = r1.isNull(r11)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0120
            r28 = r15
            goto L_0x012b
        L_0x0120:
            double r2 = r1.getDouble(r11)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r28 = r0
        L_0x012b:
            boolean r0 = r1.isNull(r12)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0134
        L_0x0131:
            r29 = r15
            goto L_0x013e
        L_0x0134:
            double r2 = r1.getDouble(r12)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r15 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            goto L_0x0131
        L_0x013e:
            long r2 = r1.getLong(r13)     // Catch:{ all -> 0x0150 }
            int r0 = (int) r2     // Catch:{ all -> 0x0150 }
            com.blueair.database.entity.DeviceDataEntity r16 = new com.blueair.database.entity.DeviceDataEntity     // Catch:{ all -> 0x0150 }
            r30 = r0
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x0150 }
            r15 = r16
        L_0x014c:
            r1.close()
            return r15
        L_0x0150:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDataDao_Impl.lambda$latestFlowDeviceData$13(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceDataEntity");
    }

    public Flow<List<DeviceDataEntity>> latestFlowDeviceDataForAllDevices() {
        return FlowUtil.createFlow(this.__db, false, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda13());
    }

    static /* synthetic */ List lambda$latestFlowDeviceDataForAllDevices$14(SQLiteConnection sQLiteConnection) {
        String str;
        String str2;
        int i;
        Float f;
        int i2;
        Float f2;
        Float f3;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        Float f8;
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT d.*, t.latest_time AS time FROM device_data d INNER JOIN (SELECT deviceId, MAX(time) AS latest_time FROM device_data GROUP BY deviceId) t ON d.deviceId = t.deviceId AND d.time = t.latest_time");
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, DeviceDataEntity.DEVICE_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "time");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm1");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm10");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "pm25");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "voc");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hcho");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "tmp");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "hum");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN);
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "weight");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(prepare, "trend");
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                Float f9 = null;
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
                long j = prepare.getLong(columnIndexOrThrow3);
                if (prepare.isNull(columnIndexOrThrow4)) {
                    i = columnIndexOrThrow2;
                    i2 = columnIndexOrThrow3;
                    f = null;
                } else {
                    i = columnIndexOrThrow2;
                    i2 = columnIndexOrThrow3;
                    f = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow4));
                }
                if (prepare.isNull(columnIndexOrThrow5)) {
                    f2 = null;
                } else {
                    f2 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow5));
                }
                if (prepare.isNull(columnIndexOrThrow6)) {
                    f3 = null;
                } else {
                    f3 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow6));
                }
                if (prepare.isNull(columnIndexOrThrow7)) {
                    f4 = null;
                } else {
                    f4 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow7));
                }
                if (prepare.isNull(columnIndexOrThrow8)) {
                    f5 = null;
                } else {
                    f5 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow8));
                }
                if (prepare.isNull(columnIndexOrThrow9)) {
                    f6 = null;
                } else {
                    f6 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow9));
                }
                if (prepare.isNull(columnIndexOrThrow10)) {
                    f7 = null;
                } else {
                    f7 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow10));
                }
                if (prepare.isNull(columnIndexOrThrow11)) {
                    f8 = null;
                } else {
                    f8 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow11));
                }
                if (!prepare.isNull(columnIndexOrThrow12)) {
                    f9 = Float.valueOf((float) prepare.getDouble(columnIndexOrThrow12));
                }
                arrayList.add(new DeviceDataEntity(str, str2, j, f, f2, f3, f4, f5, f6, f7, f8, f9, (int) prepare.getLong(columnIndexOrThrow13)));
                columnIndexOrThrow2 = i;
                columnIndexOrThrow3 = i2;
            }
            return arrayList;
        } finally {
            prepare.close();
        }
    }

    public Flow<DeviceDataEntity> latestFlowNonRealTimeDeviceData(String str) {
        return FlowUtil.createFlow(this.__db, false, new String[]{DeviceDataEntity.DEVICE_DATA_TABLE}, new DeviceDataDao_Impl$$ExternalSyntheticLambda14(str));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: com.blueair.database.entity.DeviceDataEntity} */
    /* JADX WARNING: type inference failed for: r15v2, types: [java.lang.Float] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.blueair.database.entity.DeviceDataEntity lambda$latestFlowNonRealTimeDeviceData$15(java.lang.String r31, androidx.sqlite.SQLiteConnection r32) {
        /*
            r0 = r31
            java.lang.String r1 = "SELECT * from device_data WHERE deviceId = ? AND trend != 2 ORDER BY time DESC LIMIT 1"
            r2 = r32
            androidx.sqlite.SQLiteStatement r1 = r2.prepare(r1)
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r1.bindNull(r2)     // Catch:{ all -> 0x0150 }
            goto L_0x0014
        L_0x0011:
            r1.bindText(r2, r0)     // Catch:{ all -> 0x0150 }
        L_0x0014:
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r0)     // Catch:{ all -> 0x0150 }
            java.lang.String r2 = "deviceId"
            int r2 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = "time"
            int r3 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r3)     // Catch:{ all -> 0x0150 }
            java.lang.String r4 = "pm1"
            int r4 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0150 }
            java.lang.String r5 = "pm10"
            int r5 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0150 }
            java.lang.String r6 = "pm25"
            int r6 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x0150 }
            java.lang.String r7 = "voc"
            int r7 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x0150 }
            java.lang.String r8 = "hcho"
            int r8 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r8)     // Catch:{ all -> 0x0150 }
            java.lang.String r9 = "tmp"
            int r9 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r9)     // Catch:{ all -> 0x0150 }
            java.lang.String r10 = "hum"
            int r10 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r10)     // Catch:{ all -> 0x0150 }
            java.lang.String r11 = "fan"
            int r11 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r11)     // Catch:{ all -> 0x0150 }
            java.lang.String r12 = "weight"
            int r12 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r12)     // Catch:{ all -> 0x0150 }
            java.lang.String r13 = "trend"
            int r13 = androidx.room.util.SQLiteStatementUtil.getColumnIndexOrThrow(r1, r13)     // Catch:{ all -> 0x0150 }
            boolean r14 = r1.step()     // Catch:{ all -> 0x0150 }
            r15 = 0
            if (r14 == 0) goto L_0x014c
            boolean r14 = r1.isNull(r0)     // Catch:{ all -> 0x0150 }
            if (r14 == 0) goto L_0x0072
            r17 = r15
            goto L_0x0078
        L_0x0072:
            java.lang.String r0 = r1.getText(r0)     // Catch:{ all -> 0x0150 }
            r17 = r0
        L_0x0078:
            boolean r0 = r1.isNull(r2)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0081
            r18 = r15
            goto L_0x0087
        L_0x0081:
            java.lang.String r0 = r1.getText(r2)     // Catch:{ all -> 0x0150 }
            r18 = r0
        L_0x0087:
            long r19 = r1.getLong(r3)     // Catch:{ all -> 0x0150 }
            boolean r0 = r1.isNull(r4)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0094
            r21 = r15
            goto L_0x009f
        L_0x0094:
            double r2 = r1.getDouble(r4)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r21 = r0
        L_0x009f:
            boolean r0 = r1.isNull(r5)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00a8
            r22 = r15
            goto L_0x00b3
        L_0x00a8:
            double r2 = r1.getDouble(r5)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r22 = r0
        L_0x00b3:
            boolean r0 = r1.isNull(r6)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00bc
            r23 = r15
            goto L_0x00c7
        L_0x00bc:
            double r2 = r1.getDouble(r6)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r23 = r0
        L_0x00c7:
            boolean r0 = r1.isNull(r7)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00d0
            r24 = r15
            goto L_0x00db
        L_0x00d0:
            double r2 = r1.getDouble(r7)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r24 = r0
        L_0x00db:
            boolean r0 = r1.isNull(r8)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00e4
            r25 = r15
            goto L_0x00ef
        L_0x00e4:
            double r2 = r1.getDouble(r8)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r25 = r0
        L_0x00ef:
            boolean r0 = r1.isNull(r9)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00f8
            r26 = r15
            goto L_0x0103
        L_0x00f8:
            double r2 = r1.getDouble(r9)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r26 = r0
        L_0x0103:
            boolean r0 = r1.isNull(r10)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x010c
            r27 = r15
            goto L_0x0117
        L_0x010c:
            double r2 = r1.getDouble(r10)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r27 = r0
        L_0x0117:
            boolean r0 = r1.isNull(r11)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0120
            r28 = r15
            goto L_0x012b
        L_0x0120:
            double r2 = r1.getDouble(r11)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            r28 = r0
        L_0x012b:
            boolean r0 = r1.isNull(r12)     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x0134
        L_0x0131:
            r29 = r15
            goto L_0x013e
        L_0x0134:
            double r2 = r1.getDouble(r12)     // Catch:{ all -> 0x0150 }
            float r0 = (float) r2     // Catch:{ all -> 0x0150 }
            java.lang.Float r15 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0150 }
            goto L_0x0131
        L_0x013e:
            long r2 = r1.getLong(r13)     // Catch:{ all -> 0x0150 }
            int r0 = (int) r2     // Catch:{ all -> 0x0150 }
            com.blueair.database.entity.DeviceDataEntity r16 = new com.blueair.database.entity.DeviceDataEntity     // Catch:{ all -> 0x0150 }
            r30 = r0
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x0150 }
            r15 = r16
        L_0x014c:
            r1.close()
            return r15
        L_0x0150:
            r0 = move-exception
            r1.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDataDao_Impl.lambda$latestFlowNonRealTimeDeviceData$15(java.lang.String, androidx.sqlite.SQLiteConnection):com.blueair.database.entity.DeviceDataEntity");
    }

    public Long getLatestHistoricalDataTime(String str) {
        return (Long) DBUtil.performBlocking(this.__db, true, false, new DeviceDataDao_Impl$$ExternalSyntheticLambda2(str));
    }

    static /* synthetic */ Long lambda$getLatestHistoricalDataTime$16(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT time from device_data where deviceId = ? AND trend = 0 ORDER BY time DESC LIMIT 1");
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
        Long l = null;
        if (prepare.step()) {
            if (!prepare.isNull(0)) {
                l = Long.valueOf(prepare.getLong(0));
            }
        }
        prepare.close();
        return l;
    }

    public void delete(String str) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda6(str));
    }

    static /* synthetic */ Object lambda$delete$17(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_data WHERE id = ?");
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
        prepare.close();
        return null;
    }

    public void deleteAllForDevice(String str) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda10(str));
    }

    static /* synthetic */ Object lambda$deleteAllForDevice$18(String str, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_data WHERE deviceId = ?");
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
        prepare.close();
        return null;
    }

    public void deleteAll() {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda4());
    }

    /* JADX INFO: finally extract failed */
    static /* synthetic */ Object lambda$deleteAll$19(SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_data");
        try {
            prepare.step();
            prepare.close();
            return null;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    public void deleteAllOldDeviceData(long j) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda19(j));
    }

    /* JADX INFO: finally extract failed */
    static /* synthetic */ Object lambda$deleteAllOldDeviceData$20(long j, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_data WHERE time<?");
        try {
            prepare.bindLong(1, j);
            prepare.step();
            prepare.close();
            return null;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    public void deleteOldDeviceData(String str, long j) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda17(str, j));
    }

    static /* synthetic */ Object lambda$deleteOldDeviceData$21(String str, long j, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_data WHERE deviceId = ? AND time<?");
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
        prepare.bindLong(2, j);
        prepare.step();
        prepare.close();
        return null;
    }

    public void deleteDeviceDataInInclusiveRange(String str, long j, long j2) {
        DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda5(str, j, j2));
    }

    static /* synthetic */ Object lambda$deleteDeviceDataInInclusiveRange$22(String str, long j, long j2, SQLiteConnection sQLiteConnection) {
        SQLiteStatement prepare = sQLiteConnection.prepare("DELETE FROM device_data WHERE deviceId = ? AND time >= ? AND time <= ?");
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
        prepare.bindLong(2, j);
        prepare.bindLong(3, j2);
        prepare.step();
        prepare.close();
        return null;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }
}
