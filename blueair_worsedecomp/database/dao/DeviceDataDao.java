package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.DeviceDataEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH'J,\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH'J,\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH'J$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00112\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\bH'J\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0004H'J\u0016\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u001e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0017J\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0017J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0006H'J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H'J\b\u0010!\u001a\u00020\u001aH'J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u000bH'J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000bH'J \u0010%\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH'J\u0017\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010)¨\u0006*À\u0006\u0003"}, d2 = {"Lcom/blueair/database/dao/DeviceDataDao;", "", "deviceData", "", "Lcom/blueair/database/entity/DeviceDataEntity;", "deviceId", "", "flowDeviceData", "Lkotlinx/coroutines/flow/Flow;", "getFlowDeviceDataSince", "timeStamp", "", "getFlowDeviceDataBetween", "timeStampStartInclusive", "timeStampEndInclusive", "getFlowDeviceNonRealTimeDataBetween", "getLiveDeviceDataSince", "Landroidx/lifecycle/LiveData;", "getFlowRealTimeDeviceData", "latestDeviceData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "latestLiveDeviceData", "latestFlowDeviceData", "latestFlowDeviceDataForAllDevices", "latestFlowNonRealTimeDeviceData", "insert", "", "insertAll", "insertAllAndDeletePrevious", "insertAllAndReplace", "delete", "id", "deleteAllForDevice", "deleteAll", "deleteAllOldDeviceData", "monthAgoSeconds", "deleteOldDeviceData", "deleteDeviceDataInInclusiveRange", "startSeconds", "endSeconds", "getLatestHistoricalDataTime", "(Ljava/lang/String;)Ljava/lang/Long;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDataDao.kt */
public interface DeviceDataDao {
    void delete(String str);

    void deleteAll();

    void deleteAllForDevice(String str);

    void deleteAllOldDeviceData(long j);

    void deleteDeviceDataInInclusiveRange(String str, long j, long j2);

    void deleteOldDeviceData(String str, long j);

    List<DeviceDataEntity> deviceData(String str);

    Flow<List<DeviceDataEntity>> flowDeviceData(String str);

    Flow<List<DeviceDataEntity>> getFlowDeviceDataBetween(String str, long j, long j2);

    Flow<List<DeviceDataEntity>> getFlowDeviceDataSince(String str, long j);

    Flow<List<DeviceDataEntity>> getFlowDeviceNonRealTimeDataBetween(String str, long j, long j2);

    Flow<List<DeviceDataEntity>> getFlowRealTimeDeviceData(String str);

    Long getLatestHistoricalDataTime(String str);

    LiveData<List<DeviceDataEntity>> getLiveDeviceDataSince(String str, long j);

    void insert(DeviceDataEntity deviceDataEntity);

    void insertAll(List<DeviceDataEntity> list);

    void insertAllAndDeletePrevious(String str, List<DeviceDataEntity> list);

    void insertAllAndReplace(String str, List<DeviceDataEntity> list);

    Object latestDeviceData(String str, Continuation<? super DeviceDataEntity> continuation);

    Flow<DeviceDataEntity> latestFlowDeviceData(String str);

    Flow<List<DeviceDataEntity>> latestFlowDeviceDataForAllDevices();

    Flow<DeviceDataEntity> latestFlowNonRealTimeDeviceData(String str);

    LiveData<DeviceDataEntity> latestLiveDeviceData(String str);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDataDao.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void insertAllAndDeletePrevious(DeviceDataDao deviceDataDao, String str, List<DeviceDataEntity> list) {
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(list, "deviceData");
            CC.$default$insertAllAndDeletePrevious(deviceDataDao, str, list);
        }

        @Deprecated
        public static void insertAllAndReplace(DeviceDataDao deviceDataDao, String str, List<DeviceDataEntity> list) {
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(list, "deviceData");
            CC.$default$insertAllAndReplace(deviceDataDao, str, list);
        }
    }

    /* renamed from: com.blueair.database.dao.DeviceDataDao$-CC  reason: invalid class name */
    /* compiled from: DeviceDataDao.kt */
    public final /* synthetic */ class CC {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.blueair.database.entity.DeviceDataEntity} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void $default$insertAllAndDeletePrevious(com.blueair.database.dao.DeviceDataDao r8, java.lang.String r9, java.util.List r10) {
            /*
                java.lang.String r0 = "deviceId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r0 = "deviceData"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                r0 = r10
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.Iterator r0 = r0.iterator()
                boolean r1 = r0.hasNext()
                if (r1 != 0) goto L_0x0019
                r0 = 0
                goto L_0x0044
            L_0x0019:
                java.lang.Object r1 = r0.next()
                boolean r2 = r0.hasNext()
                if (r2 != 0) goto L_0x0025
            L_0x0023:
                r0 = r1
                goto L_0x0044
            L_0x0025:
                r2 = r1
                com.blueair.database.entity.DeviceDataEntity r2 = (com.blueair.database.entity.DeviceDataEntity) r2
                long r2 = r2.getTime()
            L_0x002c:
                java.lang.Object r4 = r0.next()
                r5 = r4
                com.blueair.database.entity.DeviceDataEntity r5 = (com.blueair.database.entity.DeviceDataEntity) r5
                long r5 = r5.getTime()
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 >= 0) goto L_0x003d
                r1 = r4
                r2 = r5
            L_0x003d:
                boolean r4 = r0.hasNext()
                if (r4 != 0) goto L_0x002c
                goto L_0x0023
            L_0x0044:
                com.blueair.database.entity.DeviceDataEntity r0 = (com.blueair.database.entity.DeviceDataEntity) r0
                if (r0 == 0) goto L_0x004f
                long r0 = r0.getTime()
                r8.deleteOldDeviceData(r9, r0)
            L_0x004f:
                r8.insertAll(r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.dao.DeviceDataDao.CC.$default$insertAllAndDeletePrevious(com.blueair.database.dao.DeviceDataDao, java.lang.String, java.util.List):void");
        }

        public static void $default$insertAllAndReplace(DeviceDataDao _this, String str, List list) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
            Intrinsics.checkNotNullParameter(list, "deviceData");
            Iterable iterable = list;
            Iterator it = iterable.iterator();
            Long l = null;
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    long time = ((DeviceDataEntity) obj).getTime();
                    while (true) {
                        Object next = it.next();
                        long time2 = ((DeviceDataEntity) next).getTime();
                        if (time < time2) {
                            obj = next;
                            time = time2;
                        }
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = str;
                        DeviceDataDao deviceDataDao = _this;
                        str = str2;
                    }
                }
            }
            DeviceDataEntity deviceDataEntity = (DeviceDataEntity) obj;
            Long valueOf = deviceDataEntity != null ? Long.valueOf(deviceDataEntity.getTime()) : null;
            Iterator it2 = iterable.iterator();
            if (!it2.hasNext()) {
                obj2 = null;
            } else {
                obj2 = it2.next();
                if (it2.hasNext()) {
                    long time3 = ((DeviceDataEntity) obj2).getTime();
                    while (true) {
                        Object next2 = it2.next();
                        long time4 = ((DeviceDataEntity) next2).getTime();
                        if (time3 > time4) {
                            obj2 = next2;
                            time3 = time4;
                        }
                        if (!it2.hasNext()) {
                            break;
                        }
                        String str3 = str;
                        DeviceDataDao deviceDataDao2 = _this;
                        str = str3;
                    }
                }
            }
            DeviceDataEntity deviceDataEntity2 = (DeviceDataEntity) obj2;
            if (deviceDataEntity2 != null) {
                l = Long.valueOf(deviceDataEntity2.getTime());
            }
            if (valueOf == null || l == null) {
                DeviceDataDao deviceDataDao3 = _this;
            } else {
                DeviceDataDao deviceDataDao4 = _this;
                deviceDataDao4.deleteDeviceDataInInclusiveRange(str, l.longValue(), valueOf.longValue());
                DeviceDataDao deviceDataDao5 = deviceDataDao4;
            }
            _this.insertAll(list);
        }
    }
}
