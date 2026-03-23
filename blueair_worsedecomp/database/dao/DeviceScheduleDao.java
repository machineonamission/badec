package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.DeviceScheduleEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u0018H'R \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/blueair/database/dao/DeviceScheduleDao;", "", "liveSchedules", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/database/entity/DeviceScheduleEntity;", "getLiveSchedules", "()Landroidx/lifecycle/LiveData;", "getByScheduleId", "scheduleId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByDeviceId", "deviceId", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "deviceScheduleEntities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "schedule", "(Lcom/blueair/database/entity/DeviceScheduleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "", "deleteAllForDevice", "deleteAll", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleDao.kt */
public interface DeviceScheduleDao {
    Object delete(String str, Continuation<? super Integer> continuation);

    int deleteAll();

    Object deleteAllForDevice(String str, Continuation<? super Integer> continuation);

    Object getAll(Continuation<? super List<DeviceScheduleEntity>> continuation);

    Object getByDeviceId(String str, Continuation<? super List<DeviceScheduleEntity>> continuation);

    Object getByScheduleId(String str, Continuation<? super DeviceScheduleEntity> continuation);

    LiveData<List<DeviceScheduleEntity>> getLiveSchedules();

    Object insert(List<DeviceScheduleEntity> list, Continuation<? super Unit> continuation);

    Object update(DeviceScheduleEntity deviceScheduleEntity, Continuation<? super Unit> continuation);
}
