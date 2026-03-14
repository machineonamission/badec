package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.DeviceDataEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH'J,\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH'J,\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH'J$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00112\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\bH'J\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0004H'J\u0016\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u001e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0017J\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0017J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0006H'J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H'J\b\u0010!\u001a\u00020\u001aH'J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u000bH'J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000bH'J \u0010%\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH'J\u0017\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010)¨\u0006*À\u0006\u0003"},
   d2 = {"Lcom/blueair/database/dao/DeviceDataDao;", "", "deviceData", "", "Lcom/blueair/database/entity/DeviceDataEntity;", "deviceId", "", "flowDeviceData", "Lkotlinx/coroutines/flow/Flow;", "getFlowDeviceDataSince", "timeStamp", "", "getFlowDeviceDataBetween", "timeStampStartInclusive", "timeStampEndInclusive", "getFlowDeviceNonRealTimeDataBetween", "getLiveDeviceDataSince", "Landroidx/lifecycle/LiveData;", "getFlowRealTimeDeviceData", "latestDeviceData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "latestLiveDeviceData", "latestFlowDeviceData", "latestFlowDeviceDataForAllDevices", "latestFlowNonRealTimeDeviceData", "insert", "", "insertAll", "insertAllAndDeletePrevious", "insertAllAndReplace", "delete", "id", "deleteAllForDevice", "deleteAll", "deleteAllOldDeviceData", "monthAgoSeconds", "deleteOldDeviceData", "deleteDeviceDataInInclusiveRange", "startSeconds", "endSeconds", "getLatestHistoricalDataTime", "(Ljava/lang/String;)Ljava/lang/Long;", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface DeviceDataDao {
   void delete(String var1);

   void deleteAll();

   void deleteAllForDevice(String var1);

   void deleteAllOldDeviceData(long var1);

   void deleteDeviceDataInInclusiveRange(String var1, long var2, long var4);

   void deleteOldDeviceData(String var1, long var2);

   List deviceData(String var1);

   Flow flowDeviceData(String var1);

   Flow getFlowDeviceDataBetween(String var1, long var2, long var4);

   Flow getFlowDeviceDataSince(String var1, long var2);

   Flow getFlowDeviceNonRealTimeDataBetween(String var1, long var2, long var4);

   Flow getFlowRealTimeDeviceData(String var1);

   Long getLatestHistoricalDataTime(String var1);

   LiveData getLiveDeviceDataSince(String var1, long var2);

   void insert(DeviceDataEntity var1);

   void insertAll(List var1);

   void insertAllAndDeletePrevious(String var1, List var2);

   void insertAllAndReplace(String var1, List var2);

   Object latestDeviceData(String var1, Continuation var2);

   Flow latestFlowDeviceData(String var1);

   Flow latestFlowDeviceDataForAllDevices();

   Flow latestFlowNonRealTimeDeviceData(String var1);

   LiveData latestLiveDeviceData(String var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static void insertAllAndDeletePrevious(DeviceDataDao var0, String var1, List var2) {
         Intrinsics.checkNotNullParameter(var1, "deviceId");
         Intrinsics.checkNotNullParameter(var2, "deviceData");
         DeviceDataDao$_CC.access$insertAllAndDeletePrevious$jd(var0, var1, var2);
      }

      @Deprecated
      public static void insertAllAndReplace(DeviceDataDao var0, String var1, List var2) {
         Intrinsics.checkNotNullParameter(var1, "deviceId");
         Intrinsics.checkNotNullParameter(var2, "deviceData");
         DeviceDataDao$_CC.access$insertAllAndReplace$jd(var0, var1, var2);
      }
   }
}
