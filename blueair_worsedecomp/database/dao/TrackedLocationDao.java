package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.TrackedLocationEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u001f\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H'J\u001c\u0010\u001f\u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\"\u001a\u00020\u001aH§@¢\u0006\u0002\u0010#R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/blueair/database/dao/TrackedLocationDao;", "", "trackedLocations", "", "Lcom/blueair/database/entity/TrackedLocationEntity;", "getTrackedLocations", "()Ljava/util/List;", "liveTrackedLocations", "Landroidx/lifecycle/LiveData;", "getLiveTrackedLocations", "()Landroidx/lifecycle/LiveData;", "currentLocation", "getCurrentLocation", "()Lcom/blueair/database/entity/TrackedLocationEntity;", "liveCurrentLocation", "getLiveCurrentLocation", "liveTrackedLocation", "id", "", "getTrackedLocation", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "", "trackedLocationEntity", "(Lcom/blueair/database/entity/TrackedLocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "trackedLocationEntities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackedLocation", "location", "deleteTrackedLocations", "ids", "locations", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TrackedLocationDao.kt */
public interface TrackedLocationDao {
    Object deleteAll(Continuation<? super Unit> continuation);

    Object deleteTrackedLocation(TrackedLocationEntity trackedLocationEntity, Continuation<? super Unit> continuation);

    Object deleteTrackedLocation(String str, Continuation<? super Unit> continuation);

    Object deleteTrackedLocations(List<TrackedLocationEntity> list, Continuation<? super Unit> continuation);

    void deleteTrackedLocations(List<String> list);

    TrackedLocationEntity getCurrentLocation();

    LiveData<TrackedLocationEntity> getLiveCurrentLocation();

    LiveData<List<TrackedLocationEntity>> getLiveTrackedLocations();

    Object getTrackedLocation(String str, Continuation<? super TrackedLocationEntity> continuation);

    List<TrackedLocationEntity> getTrackedLocations();

    Object insert(TrackedLocationEntity trackedLocationEntity, Continuation<? super Unit> continuation);

    Object insert(List<TrackedLocationEntity> list, Continuation<? super Unit> continuation);

    LiveData<TrackedLocationEntity> liveTrackedLocation(String str);

    Object update(TrackedLocationEntity trackedLocationEntity, Continuation<? super Integer> continuation);
}
