package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.AqiDataEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u000b\u001a\u00020\fH'J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u001c\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H§@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0017\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/blueair/database/dao/AqiDataDao;", "", "aqiData", "", "Lcom/blueair/database/entity/AqiDataEntity;", "getAqiData", "()Ljava/util/List;", "liveAqiData", "Landroidx/lifecycle/LiveData;", "getLiveAqiData", "()Landroidx/lifecycle/LiveData;", "trackedLocationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "deviceData", "(Lcom/blueair/database/entity/AqiDataEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "trackedLocationData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "trackedLocationIdList", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiDataDao.kt */
public interface AqiDataDao {
    Object delete(String str, Continuation<? super Unit> continuation);

    Object delete(List<String> list, Continuation<? super Unit> continuation);

    Object deleteAll(Continuation<? super Unit> continuation);

    Object getAqiData(String str, Continuation<? super AqiDataEntity> continuation);

    List<AqiDataEntity> getAqiData();

    LiveData<List<AqiDataEntity>> getLiveAqiData();

    LiveData<AqiDataEntity> getLiveAqiData(String str);

    Object insert(AqiDataEntity aqiDataEntity, Continuation<? super Unit> continuation);

    Object insertAll(List<AqiDataEntity> list, Continuation<? super Unit> continuation);
}
